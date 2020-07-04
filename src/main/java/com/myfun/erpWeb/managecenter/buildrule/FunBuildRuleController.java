package com.myfun.erpWeb.managecenter.buildrule;


import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.github.pagehelper.PageHelper;
import com.myfun.erpWeb.managecenter.param.GetRoofUnitNumListParam;
import com.myfun.erpWeb.managecenter.param.MeiLianParaParam;
import com.myfun.erpWeb.managecenter.param.ParaParam;
import com.myfun.erpWeb.managecenter.vo.BuildInfoVO;
import com.myfun.erpWeb.managecenter.vo.ErpFunBuildRuleVo;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpBuildingSetMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuildRuleMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationManagerMapper;
import com.myfun.repository.erpdb.po.ErpFunBuildRule;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.service.business.erpdb.ErpFunBuildRuleService;

/**
 * 楼盘规则控制器
 */
@Api(tags = "楼盘规则控制器模块")
@RequestMapping(value="/managerCenter/buildRule",method=RequestMethod.POST)
@RestController
public class FunBuildRuleController extends BaseController{
	@Autowired private ErpFunBuildRuleMapper erpFunBuildRuleMapper;
	@Autowired private ErpBuildingSetMapper erpBuildingSetMapper;
	@Autowired private ErpFunBuildRuleService erpFunBuildRuleService;
	@Autowired private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired private AdminFunCityMapper adminFunCityMapper;
	@Autowired private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired private ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;

	/**
	 * 获取楼盘的栋单元楼列表 
	 * @author 臧铁
	 * @param param  buildId 主键      floor 第几楼        unit 单元         roof 栋
	 * @since 2017年6月20日
	 * @return
	 */
	@ApiOperation("获取楼盘的栋单元楼列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunBuildRuleVo.class, message = "成功")
	})
	@RequestMapping("/getRoofUnitNumList")
	public  ResponseJson getRoofUnitNumList(@Valid @RequestBody GetRoofUnitNumListParam param) {
		param.setCompId(getOperator().getCompId());
		List<ErpFunBuildRule> list = erpFunBuildRuleMapper.getRoofUnitNumList(getOperator().getCityId(),param);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 获取对应的栋单元
	 * @author 熊刚
	 * @since 2017年9月27日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBuildRoofUnits")
	public  ResponseJson getBuildRoofUnits(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		List<ErpFunBuildRule> list = erpFunBuildRuleMapper.getBuildRoofUnits(getOperator().getCityId(),param.getMap());
		return ErpResponseJson.ok(list);
	}

	/**
	 * 获取楼盘规则信息
	 * 对应老版接口：getBuildingRuleList，方法：BuildModule.getBuildingRuleList()
	 * @author 张宏利
	 * @since 2018年7月12日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "获取楼盘信息")
	@ApiResponses(value = {@ApiResponse(code = 1, message = "list", response = BuildInfoVO.BuildInfoListVO.class)})
	@PostMapping("/getHouseFloorMenu")
	public ResponseJson getBuildingRule(@RequestBody ParaParam param) {
		String para = param.getPara();
		if (StringUtil.isBlank(para)) {
			BuildInfoVO.BuildInfoListVO buildInfoListVO = new BuildInfoVO.BuildInfoListVO();
			buildInfoListVO.setBuildInfoVOS(Collections.emptyList());
			return ErpResponseJson.ok(buildInfoListVO);
		}
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		AdminFunCity dataByCityId = adminFunCityMapper.getDataByCityId(cityId);

		PageHelper.startPage(1, 10, false);
		List<BuildInfoVO> buildingInfoDtos = erpBuildingInfoMapper.getbuildBySearchField(cityId, getOperator().getCompId(), para, param.getBuildId(), dataByCityId.getBuildingFlag());
		List<Integer> regIds = buildingInfoDtos.stream().map(BuildInfoVO::getBuildRegion).distinct().collect(Collectors.toList());
		List<Integer> sectionIds = buildingInfoDtos.stream().map(BuildInfoVO::getSectionId).distinct().collect(Collectors.toList());
		List<Integer> buildIds = buildingInfoDtos.stream().map(BuildInfoVO::getBuildId).distinct().collect(Collectors.toList());

		if (regIds.size() > 0) {
			List<BuildInfoVO> regNames = erpBuildingInfoMapper.getRegNameById(cityId, regIds);

			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO regName : regNames) {
					Integer buildRegion = buildingInfoDto.getBuildRegion();
					if (buildRegion != null && buildRegion.equals(regName.getRegId())) {
						buildingInfoDto.setRegName(regName.getRegName());
					}
				}
			}
		}

		if (sectionIds.size() > 0) {
			List<BuildInfoVO> sectionNames = erpBuildingInfoMapper.getSectionNameById(cityId, sectionIds);

			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO sectionName : sectionNames) {
					Integer sectionId = buildingInfoDto.getSectionId();
					if (sectionId != null && sectionId.equals(sectionName.getSectionId())) {
						buildingInfoDto.setSectionName(sectionName.getSectionName());
					}
				}
			}
		}

		if (buildIds.size() > 0) {
			List<BuildInfoVO> buildLocks = erpBuildingInfoMapper.getBuildLockById(cityId, compId, buildIds);
			boolean isMeiLian = getOperator().isMeiLianApi();
			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO buildLock : buildLocks) {
					Integer buildId = buildingInfoDto.getBuildId();
					if (buildId != null && buildId.equals(buildLock.getBuildId())) {
						buildingInfoDto.setBuildLock(buildLock.getBuildLock());
					}
				}
				
				// story#11366 美联增加楼盘推广名
				if (isMeiLian && StringUtil.isNotEmpty(buildingInfoDto.getPromotionName())) {
                    buildingInfoDto.setPromotionName(buildingInfoDto.getPromotionName());
				}
			}
		}

		BuildInfoVO.BuildInfoListVO buildInfoListVO = new BuildInfoVO.BuildInfoListVO();
		buildInfoListVO.setBuildInfoVOS(buildingInfoDtos);
		return ErpResponseJson.ok(buildInfoListVO);
	}

	
	@ApiOperation(value = "获取美联楼盘信息")
	@ApiResponses(value = {@ApiResponse(code = 1, message = "list", response = BuildInfoVO.BuildInfoListVO.class)})
	@PostMapping("/getMeiLianHouseFloorMenu")
	public ResponseJson getMeiLianHouseFloorMenu(@RequestBody MeiLianParaParam param) {
		String para = param.getPara();
		if (StringUtil.isBlank(para)) {
			BuildInfoVO.BuildInfoListVO buildInfoListVO = new BuildInfoVO.BuildInfoListVO();
			buildInfoListVO.setBuildInfoVOS(Collections.emptyList());
			return ErpResponseJson.ok(buildInfoListVO);
		}
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer orgId = param.getOrganizationId();
		Integer myOrgId = getOperator().getOrganizationId();
		String houseUseage = param.getHouseUseage();
		AdminFunCity dataByCityId = adminFunCityMapper.getDataByCityId(cityId);
		if ("1".equals(houseUseage)) {
			houseUseage = "1|";
		}
		String myOrgIds = myOrgId.toString();
		List<ErpFunOrganizationManager> organizationManagerList = erpFunOrganizationManagerMapper.getManagerListByUserId(cityId, getOperator().getCompId(), getOperator().getUserId());
		if (!organizationManagerList.isEmpty()) {
			for (ErpFunOrganizationManager erpFunOrganizationManager : organizationManagerList) {
				myOrgIds = myOrgIds + "," + erpFunOrganizationManager.getOrganizationId();
			}
		}
		PageHelper.startPage(1, 10, false);
		List<BuildInfoVO> buildingInfoDtos = erpBuildingInfoMapper.getMeiLianbuildBySearchField(cityId, getOperator().getCompId(), para, param.getBuildId(), dataByCityId.getBuildingFlag(),orgId,myOrgId,houseUseage,myOrgIds);
        //如果没有非商品房登记权，楼盘搜索结果不返回非商品房的楼盘
		//[2020-06-09] yz erp前端要求取消限制
//        if(getOperator().isMeiLianApi()){
//            ErpUserOpers nichware_house_create = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, getOperator().getUserId(), "NICHWARE_HOUSE_CREATE");
//            buildingInfoDtos = buildingInfoDtos.stream().filter(o->"9".equals(o.getMlPropertyType()) || nichware_house_create != null).collect(Collectors.toList());
//        }
		List<Integer> regIds = buildingInfoDtos.stream().map(BuildInfoVO::getBuildRegion).distinct().collect(Collectors.toList());
		List<Integer> sectionIds = buildingInfoDtos.stream().map(BuildInfoVO::getSectionId).distinct().collect(Collectors.toList());
		List<Integer> buildIds = buildingInfoDtos.stream().map(BuildInfoVO::getBuildId).distinct().collect(Collectors.toList());

		if (regIds.size() > 0) {
			List<BuildInfoVO> regNames = erpBuildingInfoMapper.getRegNameById(cityId, regIds);

			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO regName : regNames) {
					Integer buildRegion = buildingInfoDto.getBuildRegion();
					if (buildRegion != null && buildRegion.equals(regName.getRegId())) {
						buildingInfoDto.setRegName(regName.getRegName());
					}
				}
			}
		}

		if (sectionIds.size() > 0) {
			List<BuildInfoVO> sectionNames = erpBuildingInfoMapper.getSectionNameById(cityId, sectionIds);

			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO sectionName : sectionNames) {
					Integer sectionId = buildingInfoDto.getSectionId();
					if (sectionId != null && sectionId.equals(sectionName.getSectionId())) {
						buildingInfoDto.setSectionName(sectionName.getSectionName());
					}
				}
			}
		}

		if (buildIds.size() > 0) {
			List<BuildInfoVO> buildLocks = erpBuildingInfoMapper.getBuildLockById(cityId, 0, buildIds);
			for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
				for (BuildInfoVO buildLock : buildLocks) {
					Integer buildId = buildingInfoDto.getBuildId();
					if (buildId != null && buildId.equals(buildLock.getBuildId())) {
						buildingInfoDto.setBuildLock(buildLock.getBuildLock());
					}
				}
			}
		}

		BuildInfoVO.BuildInfoListVO buildInfoListVO = new BuildInfoVO.BuildInfoListVO();
		for (BuildInfoVO buildingInfoDto : buildingInfoDtos) {
			//暂时的方案，如果有多个产权类型，返回一个。
			//[2020-06-08] yz 前端多选，全部返回
//			String mlPropertyType = buildingInfoDto.getMlPropertyType();
//			if(StringUtils.isNotEmpty(mlPropertyType)){
//				String[] split = mlPropertyType.split("\\|");
//				buildingInfoDto.setMlPropertyType(split[0]);
//			}
		}
		buildInfoListVO.setBuildInfoVOS(buildingInfoDtos);
		return ErpResponseJson.ok(buildInfoListVO);
	}
	
}
