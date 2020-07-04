package com.myfun.erpWeb.managecenter.buildData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.buildData.param.*;
import com.myfun.erpWeb.managecenter.buildData.vo.*;
import com.myfun.erpWeb.statisticalAnalysis.DataAnalysisController;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpFunBuildRuleParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpBuildAllotService;
import com.myfun.service.business.erpdb.ErpFunBuildRuleService;
import com.myfun.service.business.erpdb.ErpFunBuildrulequerylimitService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

@Api(tags = "楼盘资料模块")
@RestController
@RequestMapping("/manageCenter/buildData")
public class FunBuildDataController extends BaseController {
	@Autowired ErpFunBuildRuleService erpFunBuildRuleService;
	@Autowired ErpFunBuildRuleMapper erpFunBuildRuleMapper;
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunBuildTrackMapper erpFunBuildTrackMapper;
	@Autowired ErpFunBuildrulequerylimitMapper erpFunBuildrulequerylimitMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunSelfbuildMapper erpFunSelfBuildMapper;
	@Autowired ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired ErpFunRegMapper erpFunRegMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpFunBuildrulequerylimitService erpFunBuildrulequerylimitService;
	@Autowired ErpFunSectionMapper erpFunSectionMapper;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired ErpBuildAllotMapper erpBuildAllotMapper;
	@Autowired ErpBuildLogMapper erpBuildLogMapper;
	@Autowired ErpBuildAllotService erpBuildAllotService;
	@Autowired ErpFunOrganizationMapper erpFunOrganizationMapper;


	/**
	 * 全部删除楼盘资料
	 * @author xionggang
	 * @since 2017年8月13日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAllBuildData")
	public ResponseJson deleteAllBuildData(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		erpFunBuildRuleService.deleteAllBuildData(getOperator().getCityId(), param.getMap());
		return ErpResponseJson.ok();
	}
	
	/**
	 * 楼盘资料统计-语音日志列表
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "楼盘资料统计-语音日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", responseContainer ="List", response = BuildDataIpCallVo.class)
	})
	@PostMapping(value = "/getBuildDataIpCallList")
	@ResponseBody
	public ResponseJson getBuildDataIpCallList(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);
		
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<BuildDataIpCallVo> ipCallList = erpFunBuildTrackMapper.getBuildDataIpCallList(getOperator().getCityId(), param.getMap());
		PageInfo<BuildDataIpCallVo> pageInfo = new PageInfo<>(ipCallList);
		for (BuildDataIpCallVo adminIpCallLog : ipCallList) {
			adminIpCallLog.setCallRecordUrl(CommonUtil.getPhotoUrl(adminIpCallLog.getCallRecordUrl()));
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "楼盘资料统计")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", responseContainer ="List", response = HouseTrackListVo.class)
	})
	@PostMapping(value = "/getBuildDataTrackList")
	@ResponseBody
	public ResponseJson getBuildDataTrackList(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);
		
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<HouseTrackListVo> houseIdList = erpFunBuildTrackMapper.getHouseTrackList(cityId, param.getMap());
		PageInfo<HouseTrackListVo> pageInfo = new PageInfo<>(houseIdList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 楼盘资料-工作量统计-跟进数据量详情列表
	 *
	 * @author czq
	 * @since 2019年4月28日
	 */
	@ApiOperation(value = "楼盘资料-工作量统计-跟进数据量详情列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", responseContainer ="List", response = BuildDataTrackDataVo.class)
	})
	@PostMapping(value = "/getBuildDataTrackDataList")
	@ResponseBody
	public ResponseJson getBuildDataTrackDataList(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		Integer deptId = getOperator().getDeptId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);
		Byte auth = getBuildRulePermission();
		Integer createUserId = param.getInteger("userId");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<BuildDataTrackDataVo> vos = erpFunBuildTrackMapper.getBuildDataTrackData(cityId, auth, userId, deptId, param.getMap());

		List<Integer> buildRuleIds = vos.stream().map(BuildDataTrackDataVo::getBuildRuleId).collect(Collectors.toList());

        if (buildRuleIds.size() > 0) {
            List<BuildDataTrackDataVo> count = erpFunBuildTrackMapper.getBuildDataTrackDataCount(cityId, buildRuleIds, createUserId, startTime, endTime);

            for (BuildDataTrackDataVo buildDataTrackDataVo : vos) {
                Optional<BuildDataTrackDataVo> optional = count.stream().filter(it -> it.getBuildRuleId().equals(buildDataTrackDataVo.getBuildRuleId())).findFirst();

                if (optional.isPresent()) {
                    BuildDataTrackDataVo data = optional.get();
                    buildDataTrackDataVo.setTrackCount(data.getTrackCount());
                }
            }
        }

		PageInfo<BuildDataTrackDataVo> pageInfo = new PageInfo<>(vos);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 楼盘资料-工作量统计-拨打数据量详情列表
	 *
	 * @author czq
	 * @since 2019年4月28日
	 */
	@ApiOperation(value = "楼盘资料-工作量统计-拨打数据量详情列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", responseContainer ="List", response = IpCallDataVo.class)
	})
	@PostMapping(value = "/getIpCallDataList")
	@ResponseBody
	public ResponseJson getIpCallDataList(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);
		Integer callUserId = param.getInteger("userId");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<IpCallDataVo> ipCallList = erpFunBuildTrackMapper.getIpCallDataList(getOperator().getCityId(), param.getMap());

		List<Integer> targetIds = ipCallList.stream().map(IpCallDataVo::getBuildRuleId).collect(Collectors.toList());
		if (targetIds.size() > 0) {
            List<IpCallDataVo> count = erpFunBuildTrackMapper.getIpCallDataCount(cityId, targetIds, callUserId, startTime, endTime);

            for (IpCallDataVo ipCallDataVo : ipCallList) {
                Optional<IpCallDataVo> optional = count.stream().filter(it -> it.getBuildRuleId().equals(ipCallDataVo.getBuildRuleId())).findFirst();

                if (optional.isPresent()) {
                    IpCallDataVo data = optional.get();
                    ipCallDataVo.setIpCallCount(data.getIpCallCount());
                }
            }
        }

		PageInfo<IpCallDataVo> pageInfo = new PageInfo<>(ipCallList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 楼盘资料-工作量统计-转租转售详情
	 *
	 * @author czq
	 * @since 2019年4月28日
	 */
	@ApiOperation(value = "楼盘资料-工作量统计-转租转售详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", responseContainer = "List", response = BuildDataHouseDataVo.class)
	})
	@PostMapping(value = "/getBuildDataHouseListV2")
	@ResponseBody
	public ResponseJson getBuildDataHouseListV2(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<BuildDataHouseDataVo> houseList = erpFunBuildRuleMapper.getHouseIdListV2(cityId, param.getMap());
		PageInfo<BuildDataHouseDataVo> pageInfo = new PageInfo<>(houseList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBuildDataHouseList")
	public ResponseJson getBuildDataHouseList(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<Integer> houseIdList = erpFunBuildRuleMapper.getHouseIdList(cityId, param.getMap());
		PageInfo<Integer> pageInfo = new PageInfo<Integer>(houseIdList);
		// 依据ID查询房源列表
		param.setObject("caseIdList", houseIdList);
		List<Map<String, Object>> caseList = erpFunSaleMapper.getCaseList(cityId, param.getMap());
		ErpResponseJson responseJson = ErpResponseJson.ok(pageInfo);
		responseJson.setData(caseList);
		return responseJson;
	}
	
	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBuildDataStatistic")
	public ResponseJson getBuildDataStatistic(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		Integer deptId = getOperator().getDeptId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		Byte auth = getBuildRulePermission();
		DataAnalysisController.changeSerchRange(param);
		// 转租转售统计，跟进量和跟进次数统计
		List<Map<String, Object>> transTrackDataList = erpFunBuildTrackMapper.getTrackAndTransSaleLeaseData(cityId, auth,userId,deptId,param.getMap());
		// 拨打量和拨打次数统计
		List<Map<String, Object>> ipCallDataList = erpFunBuildTrackMapper.getIpCallBuildData(cityId,auth,userId,deptId,param.getMap());
		// 合并到一起
		if(ipCallDataList != null && !ipCallDataList.isEmpty()) {
			if(transTrackDataList == null || transTrackDataList.isEmpty()) {
				transTrackDataList = ipCallDataList;
			} else {
				Map<String, Map<String, Object>> ipCallMap = ipCallDataList.stream().collect(
						Collectors.toMap(map -> {
//							Integer areaStr = StringUtil.parseInteger(map.get("areaId"));
//							Integer regStr = StringUtil.parseInteger(map.get("regId"));
//							Integer deptStr = StringUtil.parseInteger(map.get("deptId"));
//							Integer grStr = StringUtil.parseInteger(map.get("grId"));
							Integer userStr = StringUtil.parseInteger(map.get("userId"));
//							return areaStr + "_" + regStr + "_" + deptStr + "_" + grStr + "_" + userStr;
							return userStr + "";
						} , val -> val));
				for (Map<String, Object> transTrackData : transTrackDataList) {
//					Integer areaStr = StringUtil.parseInteger(transTrackData.get("areaId"));
//					Integer regStr = StringUtil.parseInteger(transTrackData.get("regId"));
//					Integer deptStr = StringUtil.parseInteger(transTrackData.get("deptId"));
//					Integer grStr = StringUtil.parseInteger(transTrackData.get("grId"));
					Integer userStr = StringUtil.parseInteger(transTrackData.get("userId"));
//					String tempStr =  areaStr + "_" + regStr + "_" + deptStr + "_" + grStr + "_" + userStr;
					String tempStr = userStr + "";
					Map<String, Object> ipMapTemp = ipCallMap.get(tempStr);
					if(ipMapTemp != null) {
						transTrackData.put("ipBuildCount", ipMapTemp.get("ipBuildCount"));
						transTrackData.put("ipAllCount", ipMapTemp.get("ipAllCount"));
					}
				}
			}
		}
		return ErpResponseJson.ok(transTrackDataList);
	}
	
	/**
	 * 获取可查看的楼盘资料列表
	 * @author 张宏利
	 * @since 2018年4月8日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取可查看的楼盘资料列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunBuildrulequerylimit.class, message = "成功")
	})
	@PostMapping("/getUserViewBuilds")
	public ResponseJson getUserViewBuilds(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		List<ErpFunBuildrulequerylimit> limitList = erpFunBuildrulequerylimitMapper.getUserViewBuilds(operator.getCityId(), operator.getUserId());
		return ErpResponseJson.ok(limitList);
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/16
	 * @tag 楼盘资料-获取楼盘资料管理员
	 */
	@RequestMapping("/getMgrFloorDataManager")
	public ResponseJson getMgrFloorDataManager(@RequestBody BaseMapParam param) {
		String deptName = param.getString("deptName");
		Integer deptId = param.getInteger("deptId");
		if (getOperator().newOrganizationType()) {
			return this.getMgrFloorDataManagerNewOrg(param);
		}
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		List<ErpFunDepts> funDeptsList = new LinkedList<>();
		if (deptId != null) {
			ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
			funDeptsList.add(funDepts);
		} else {
			funDeptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.getBuildManagerUsersList(cityId, compId, deptId);
		List<Map<String, Object>> funDeptsMapList = MapUtil.listObjTolistMap(funDeptsList);
		List<Map<String, Object>> userListMapList = MapUtil.listObjTolistMap(userList);
		List<Map<String, Object>> retList = new ArrayList<>();
		for (Map<String, Object> funDepts : funDeptsMapList) {
			if (StringUtils.isBlank(deptName) || ((String) funDepts.get("deptCname")).contains(deptName)) {
				Map<String, Object> retMap = new HashMap<>();
				retMap.putAll(funDepts);
				for (Map<String, Object> funUsers : userListMapList) {
					Object deptDeptId = funDepts.get("deptId");
					Object userDeptId = funUsers.get("deptId");
					if (deptDeptId != null && deptDeptId.equals(userDeptId)) {
						retMap.putAll(funUsers);
						retMap.put("deptId", funDepts.get("deptId"));
						userList.remove(funUsers);
						break;
					}
				}
				retList.add(retMap);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(retList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 楼盘资料-获取楼盘资料管理员(新版组织机构)
	 * @param param
	 * @return
	 */
	private ResponseJson getMgrFloorDataManagerNewOrg(BaseMapParam param) {
		String organizationName = param.getString("organizationName");
		Integer organizationId = param.getInteger("organizationId");
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		List<ErpFunOrganization> orgList = new LinkedList<>();
		if (organizationId != null) {
			ErpFunOrganization erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
			orgList.add(erpFunOrganizations);
		} else {
			orgList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, null);
		}
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		ErpFunUsersExample.Criteria criteria = erpFunUsersExample.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (organizationId != null && organizationId != 0) {
			criteria.andTissueLineLike("%:" + organizationId + ":%");
		}
		erpFunUsersExample.setShardCityId(cityId);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		List<Map<String, Object>> funDeptsMapList = MapUtil.listObjTolistMap(orgList);
		List<Map<String, Object>> userListMapList = MapUtil.listObjTolistMap(userList);
		List<Map<String, Object>> retList = new ArrayList<>();
		for (Map<String, Object> organization : funDeptsMapList) {
			if (StringUtils.isBlank(organizationName) || ((String) organization.get("organizationName")).contains(organizationName)) {
				Map<String, Object> retMap = new HashMap<>();
				retMap.putAll(organization);
				for (Map<String, Object> funUsers : userListMapList) {
					Object orgId = organization.get("organizationId");
					Object userOrgId = funUsers.get("organizationId");
					if (orgId != null && orgId.equals(userOrgId)) {
						retMap.putAll(funUsers);
						retMap.put("organizationId", organization.get("organizationId"));
						userList.remove(funUsers);
						break;
					}
				}
				retList.add(retMap);
			}
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(retList);
		return ErpResponseJson.ok(pageInfo);
	}


	/**
	 * @tag 获取楼盘下拉列表
	 * @author 邓永洪
	 * @since 2018/6/4
	 */
	@ApiOperation(value = "获取楼盘下拉列表",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = 200 ,responseContainer = "List",response = ErpFunSelfbuildDto.class,message = "success"))
	@RequestMapping("/getMgrFloorList")
	public ResponseJson getMgrFloorList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Byte buildFlag = param.getByte("buildFlag");
		String buildNameOrCode = param.getString("buildName");
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm:ss.S");
		// 查询的条件模糊查询buildName和buildCode
		if (StringUtils.isNotBlank(buildNameOrCode)) {
			try {
				buildNameOrCode = URLDecoder.decode(buildNameOrCode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String orderBy = param.getString("orderBy");
		if (StringUtils.isBlank(orderBy)) {
			orderBy = "BUILD_ID";
		}
		if (buildFlag == null) { //非楼盘资料进来的
			//判断权限
			boolean haveAuth = getFunBuildRuleAuthority();
			String buildIds = null;
			if (!haveAuth) {
				List<ErpFunBuildrulequerylimit> buildList = erpFunBuildrulequerylimitMapper.getBuildByUserId(cityId, operator.getCompId(), operator.getUserId());
				if (CollectionUtils.isEmpty(buildList)) {
					return ErpResponseJson.ok(new ArrayList<>());
				}
				buildIds = buildList.stream().map(val -> String.valueOf(val.getBuildId())).collect(Collectors.joining(","));
			}
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunSelfbuildDto> funSelfbuildDtos = erpFunSelfBuildMapper.getFunSelfBuildList(cityId, operator.getCompId(), buildNameOrCode, orderBy, buildIds);
			if (funSelfbuildDtos == null || funSelfbuildDtos.isEmpty()) {
				return ErpResponseJson.ok();
			}
			List<Integer> keys = funSelfbuildDtos.stream().map(val -> val.getBuildId()).collect(Collectors.toList());
			ErpBuildingInfoExample buildingInfoExample = new ErpBuildingInfoExample();
			buildingInfoExample.setShardCityId(cityId);
			buildingInfoExample.createCriteria().andBuildIdIn(keys);
			List<ErpBuildingInfo> erpBuildingInfos = erpBuildingInfoMapper.selectByExample(buildingInfoExample);
			// 查询商圈
			List<Integer> sectionIds = null;
			List<ErpFunSection> sectionList = null;
			Map<Integer, ErpFunSection> tempMap = new HashMap<>();
			if (!erpBuildingInfos.isEmpty()) {
				sectionIds = erpBuildingInfos.stream().collect(Collectors.mapping(ErpBuildingInfo::getSectionId, Collectors.toList()));
			}
			if (null != sectionIds && !sectionIds.isEmpty()) {
				ErpFunSectionExample erpFunSectionExample = new ErpFunSectionExample();
				erpFunSectionExample.createCriteria().andSectionIdIn(sectionIds);
				erpFunSectionExample.setShardCityId(cityId);
				sectionList = erpFunSectionMapper.selectByExample(erpFunSectionExample);
			}
			//
			if (null != sectionList && !sectionList.isEmpty()) {
				tempMap = sectionList.stream().collect(Collectors.toMap(ErpFunSection::getSectionId, val -> val));
			}
			Map<Integer, ErpFunSection> sectionMap = tempMap;
			Map<Integer, ErpBuildingInfo> buildingInfoMap = erpBuildingInfos.stream().collect(Collectors.toMap(ErpBuildingInfo::getBuildId, val -> val));
			List<ErpFunReg> erpFunRegs = erpFunRegMapper.getRegListByCityId(cityId);
			Map<Integer, ErpFunReg> funRegMap = erpFunRegs.stream().collect(Collectors.toMap(ErpFunReg::getRegId, val -> val));
			funSelfbuildDtos.stream().forEach(erpFunSelfbuildDto -> {
				ErpBuildingInfo buildingInfo = buildingInfoMap.get(erpFunSelfbuildDto.getBuildId());
				if (null != buildingInfo) {
					erpFunSelfbuildDto.setSectionId(buildingInfo.getSectionId());
					erpFunSelfbuildDto.setBuildAddress(buildingInfo.getBuildAddr());
					ErpFunReg funReg = funRegMap.get(buildingInfo.getBuildRegion());
					if (null != funReg)
						erpFunSelfbuildDto.setRegName(funReg.getRegName());
					ErpFunSection erpFunSection = sectionMap.get(buildingInfo.getSectionId());
					if (null != erpFunSection) {
						erpFunSelfbuildDto.setSectionName(erpFunSection.getSectionName());
					}
				}
			});
			PageInfo pageInfo = new PageInfo(funSelfbuildDtos);
			return ErpResponseJson.ok(pageInfo);
		} else { //楼盘资料进来的
			Byte oper = getBuildRulePermission();
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunSelfbuildDto> funSelfbuildDtos = erpFunSelfBuildMapper.getFunBuildListByDiffrentOper(cityId,compId, getOperator().getUserId(),getOperator().getDeptId(),nowTime,oper,buildNameOrCode);

			if (funSelfbuildDtos == null || funSelfbuildDtos.isEmpty()) {
				return ErpResponseJson.ok();
			}
			List<Integer> keys = funSelfbuildDtos.stream().map(val -> val.getBuildId()).collect(Collectors.toList());
			ErpBuildingInfoExample buildingInfoExample = new ErpBuildingInfoExample();
			buildingInfoExample.setShardCityId(cityId);
			buildingInfoExample.createCriteria().andBuildIdIn(keys);
			List<ErpBuildingInfo> erpBuildingInfos = erpBuildingInfoMapper.selectByExample(buildingInfoExample);

			// 查询商圈，为楼盘定位
			List<Integer> sectionIds = null;
			List<ErpFunSection> sectionList = null;
			Map<Integer, ErpFunSection> tempMap = new HashMap<>();
			if (!erpBuildingInfos.isEmpty()) {
				sectionIds = erpBuildingInfos.stream().collect(Collectors.mapping(ErpBuildingInfo::getSectionId, Collectors.toList()));
			}
			if (null != sectionIds && !sectionIds.isEmpty()) {
				ErpFunSectionExample erpFunSectionExample = new ErpFunSectionExample();
				erpFunSectionExample.createCriteria().andSectionIdIn(sectionIds);
				erpFunSectionExample.setShardCityId(cityId);
				sectionList = erpFunSectionMapper.selectByExample(erpFunSectionExample);
			}

			if (null != sectionList && !sectionList.isEmpty()) {
				tempMap = sectionList.stream().collect(Collectors.toMap(ErpFunSection::getSectionId, val -> val));
			}
			//商圈 浣花小区/通惠门...
			Map<Integer, ErpFunSection> sectionMap = tempMap;
			Map<Integer, ErpBuildingInfo> buildingInfoMap = erpBuildingInfos.stream().collect(Collectors.toMap(ErpBuildingInfo::getBuildId, val -> val));
			//行政区域 武侯区/青羊区...
			List<ErpFunReg> erpFunRegs = erpFunRegMapper.getRegListByCityId(cityId);
			Map<Integer, ErpFunReg> funRegMap = erpFunRegs.stream().collect(Collectors.toMap(ErpFunReg::getRegId, val -> val));
			funSelfbuildDtos.stream().forEach(erpFunSelfbuildDto -> {
				ErpBuildingInfo buildingInfo = buildingInfoMap.get(erpFunSelfbuildDto.getBuildId());
				if (null != buildingInfo) {
					erpFunSelfbuildDto.setSectionId(buildingInfo.getSectionId());
					erpFunSelfbuildDto.setBuildAddress(buildingInfo.getBuildAddr());
					ErpFunReg funReg = funRegMap.get(buildingInfo.getBuildRegion());
					if (null != funReg)
						erpFunSelfbuildDto.setRegName(funReg.getRegName());
					ErpFunSection erpFunSection = sectionMap.get(buildingInfo.getSectionId());
					if (null != erpFunSection) {
						erpFunSelfbuildDto.setSectionName(erpFunSection.getSectionName());
					}
				}
			});
			PageInfo pageInfo = new PageInfo(funSelfbuildDtos);
			return ErpResponseJson.ok(pageInfo);
		}
	}

	/**
	 * @tag 获取房号资料列表
	 * @author 邓永洪
	 * @since 2018/5/4
	 */
	@ApiOperation(value = "获取房号资料列表",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = 200 ,responseContainer = "List",response = ErpFunBuildRuleDto.class, message = "success"))
	@RequestMapping("/getMgrFloorDataList")
	public ResponseJson getMgrFloorDataList(@RequestBody FloorDataParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer buildId = param.getBuildId();
		if (null == buildId) {return ErpResponseJson.ok(new ArrayList<>());}
		String roof = param.getRoof();
		String unit = param.getUnit();
		String num = param.getNum();
		String house = param.getHouse();
		String query = param.getQueryType();
		if (StringUtils.isBlank(query)) {
			query = "INIT";
		}
		String cellPhone = param.getCellPhone();
		Date now = new Date();
		param.setCompId(compId);
		param.setUserId(userId);
		param.setNowTime(now);
		List<ErpFunBuildrulequerylimit> funBuildrulequerylimitList = erpFunBuildrulequerylimitMapper.getBuildrulequerylimitList(cityId, param);
		FloorDataParam dataParam = new FloorDataParam();
		dataParam.setBuildId(buildId);
		dataParam.setCompId(compId);
		if (!"ALL".equals(roof)) {// 栋
			if (roof.matches("[A-Za-z0-9]+")) {
				dataParam.setRoof(roof);
			} else {
				dataParam.setRoofLike(roof);
			}
		}
		if (!"ALL".equals(unit)) {// 单元
			dataParam.setUnit(unit);
		}
		if (!"ALL".equals(num)) {// 楼
			dataParam.setNum(num);
		}
		if (!"ALL".equals(house)) {// 号
			dataParam.setHouse(house);
		}
		//判断权限
		boolean haveAuth = judgeFunDataLookPermission(buildId);
		//电话查询
		if (StringUtils.isNotBlank(cellPhone)) {
			cellPhone = EnCodeHelper.encode(cellPhone);
			dataParam.setCellPhone(cellPhone);
			if (!haveAuth) {
				query = "QUERY_SELF_BUILD";
			}
		}
		// 没有权限，而且是查询自己的
		if (!haveAuth) {
			if (funBuildrulequerylimitList.isEmpty()) {
				return ErpResponseJson.ok(new ArrayList<>());
			}
			List<Map<String, Object>> personalList = new ArrayList<>();
			for (ErpFunBuildrulequerylimit funBuildrulequerylimit : funBuildrulequerylimitList) {
				Map<String, Object> map = new HashMap<>();
				String regx = funBuildrulequerylimit.getRuleRegEx();
				String[] floorAdresses = regx.split("_");
				String roofs = floorAdresses[0];
				String units = floorAdresses[1];
				String nums = floorAdresses[2];
				if (!roofs.equals("[A-Za-z0-9]+?")) {
					map.put("roof", roofs);
				}
				if (!units.equals("[0-9]+?")) {
					map.put("unit", units);
				}
				if (!nums.equals("[0-9]+?")) {
					map.put("num", nums);
				}
				personalList.add(map);
			}
			dataParam.setPersonalList(personalList);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunBuildRuleDto> funBuildRuleDtos = erpFunBuildRuleMapper.getFunBuildRuleList(cityId, dataParam, !haveAuth);
		for (ErpFunBuildRuleDto funBuildRuleDto : funBuildRuleDtos) {
			funBuildRuleDto.setCanLook(1);
		}

		PageInfo<ErpFunBuildRuleDto> pageInfo = new PageInfo(funBuildRuleDtos);
		return ErpResponseJson.ok(pageInfo);
	}

    /**
     * @Title 判断楼盘资料房号信息查看权
     * @Author wc
     * @Date 2019/4/19
     **/
    private boolean judgeFunDataLookPermission(Integer buildId) {
        boolean flag = false;
        Integer userId = getOperator().getUserId();
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpFunUsers funUsers = erpFunUsersMapper.selectDataByUserId(cityId, compId, userId);
        if (funUsers != null && funUsers.getBuildRuleFlag() != null && funUsers.getBuildRuleFlag()) {
            flag = true;
        }else {
            ErpFunUsers generalManagerUser = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
            if (generalManagerUser.getUserId().equals(userId)) {
                flag = true;
            }else {
                ErpUserOpers opersManage = erpUserOpersMapper.selectPerPermissionByName(cityId,userId,"BUILD_INFO_MANAGE");
                if (null != opersManage){ //具有楼盘资料管理权的人 权限同总经理
                    flag = true;
                } else {
                    ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
                    allotExample.setShardCityId(cityId);
                    allotExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andIsDelEqualTo((byte)1);
                    List<ErpBuildAllot> erpBuildAllotList = erpBuildAllotMapper.selectByExample(allotExample);
                    Set<Integer> deptIds = erpBuildAllotList == null ? new HashSet<>() : erpBuildAllotList.stream().map(v -> v.getDeptId()).collect(Collectors.toSet());
                    if (deptIds.contains(getOperator().getDeptId())) {
                        ErpUserOpers opersDistr = erpUserOpersMapper.selectPerPermissionByName(cityId,userId,"BUILD_INFO_ALLOT");
                        if (null != opersDistr) {//具有楼盘资料分配权的人 （楼盘查看范围所选门店中的有分配权的人可以查看该楼盘的资料信息）
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

	/**
	 * @tag 判断是否有权限查看当前楼盘
	 * @author 邓永洪
	 * @since 2018/9/29
	 */
	private Integer judgeIsCanLook(ErpFunBuildRuleDto buildRuleDto, List<ErpFunBuildrulequerylimit> funBuildrulequerylimitList) {
		Integer canLook = 0;
		Integer buildId = buildRuleDto.getBuildId();
		for (ErpFunBuildrulequerylimit queryLimit : funBuildrulequerylimitList) {
			if (buildId.equals(queryLimit.getBuildId())) {
				String ruleRegEx = queryLimit.getRuleRegEx();
				if ("[A-Za-z0-9]+?_[0-9]+?_[0-9]+?_[0-9]+?".equals(ruleRegEx)) {
					canLook = 1;
					continue;
				} else {
					String[] floorAdresses = ruleRegEx.split("_");
					String roofs = floorAdresses[0];
					String units = floorAdresses[1];
					String nums = floorAdresses[2];
					if ((nums.equals("[0-9]+?") || buildRuleDto.getNum().equals(nums))
							&& (roofs.equals("[A-Za-z0-9]+?") || buildRuleDto.getRoof().equals(roofs))
							&& (units.equals("[0-9]+?") || buildRuleDto.getUnit().equals(units))) {
						canLook = 1;
						continue;
					}
				}
			}
		}
		return canLook;
	}

	/**
	 * @tag 楼盘使用记录列表
	 * @author 邓永洪
	 * @since 2018/7/10
	 */
	@ApiOperation("楼盘使用记录列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List",response = ErpFunBuildrulequerylimitDto.class, message = "success")
	})
	@PostMapping("/getMgrUserViewRight")
	public ResponseJson getMgrUserViewRight(@RequestBody MgrUserViewRightParam param) {
		Operator ope = getOperator();
		Integer cityId = ope.getCityId();
		Integer userId = ope.getUserId();
		Integer compId = ope.getCompId();
		Integer deptId = ope.getDeptId();
		Byte status = param.getStatus();

		param.setUserId(userId);
		param.setDeptId(deptId);

		List<ErpFunBuildrulequerylimitDto> dataDtoList = null;
		//楼盘下拉列表已做了权限的限制，只有没有选择楼盘时，才去作权限限制
		if (param.getBuildId() != null) {//此时不需要权限控制
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			dataDtoList = erpFunBuildrulequerylimitMapper.getBuildrulequerylimitDtoByNoOper(cityId,compId,param);
		}else{
			Byte oper = getBuildRulePermission();
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			dataDtoList = erpFunBuildrulequerylimitMapper.getBuildrulequerylimitDtoByDifferentOper(cityId,compId,oper,param);
		}

		if (CollectionUtils.isEmpty(dataDtoList)) {
			return ErpResponseJson.ok();
		}

		//补充其它字段
		Set<Integer> buildIds = new HashSet<>();
		dataDtoList.forEach(val -> {
			buildIds.add(val.getBuildId());
		});

		List<ErpFunSelfbuildDto> funSelfbuildDtos = erpFunSelfBuildMapper.getFunSelfBuildListByBuildIds(cityId,compId,buildIds);
		Map<Integer,ErpFunSelfbuildDto> funSelfbuildDtoMap = funSelfbuildDtos.stream().collect(Collectors.toMap(val -> val.getBuildId(),val ->val));

		dataDtoList.forEach(val -> {
			ErpFunSelfbuildDto funSelfbuildDto = funSelfbuildDtoMap.get(val.getBuildId());
			if (null != funSelfbuildDto) {
				val.setTotalRoom(funSelfbuildDto.getRooms());
				val.setChangeLease(funSelfbuildDto.getChangeRent());
				val.setChangeSale(funSelfbuildDto.getChangeSale());
			}
		});

		PageInfo<ErpFunBuildrulequerylimitDto>  pageInfo = new PageInfo<>(dataDtoList);
		ErpResponseJson json =  new ErpResponseJson();
		json.setData(dataDtoList);
		json.setPageNum(pageInfo.getPageNum());
		json.setPageSize(pageInfo.getPageSize());
		json.setTotal(pageInfo.getTotal());
		return json;
	}

	/**
	 * @tag 插入楼盘分配记录
	 * @author 邓永洪
	 * @since 2018/7/10
	 */
	@ApiOperation("插入楼盘分配记录")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "success")
	})
	@PostMapping("/setMgrUserViewRight")
	public ResponseJson setMgrUserViewRight(@RequestBody FunBuildDataParam param) throws Exception {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		String deptCName = operator.getDeptCName();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		String userIdStr = param.getUserId();
		if (StringUtils.isBlank(userIdStr)) {
			return ErpResponseJson.ok();
		}
		erpFunBuildrulequerylimitService.setMgrUserViewRight(cityId,compId,userId,userName,deptCName,param);
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 暂停\启用楼盘
	 * @author 邓永洪
	 * @since 2018/7/11
	 */
	@RequestMapping("/deleteViewBuildRule")
	@ApiOperation("暂停\\启用楼盘")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	public ResponseJson deleteViewBuildRule(@RequestBody DeleteViewBuildRuleParam param) {
		ErpFunBuildrulequerylimit limit = new ErpFunBuildrulequerylimit();
		limit.setStatus(param.getStatus());
		ErpFunBuildrulequerylimitExample example = new ErpFunBuildrulequerylimitExample();
		example.setShardCityId(getOperator().getCityId());
		example.createCriteria().andLimitIdEqualTo(param.getIds()).andCompIdEqualTo(getOperator().getCompId());
		erpFunBuildrulequerylimitMapper.updateByExampleSelective(limit,example);
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 楼盘资料-写跟进
	 * @author 邓永洪
	 * @since 2018/7/11
	 */
	@ApiOperation("楼盘资料-写跟进")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/writeTrack")
	public ResponseJson writeTrack(@RequestBody writeTrackParam param) {
		Operator operator = getOperator();
		ErpFunBuildTrack funBuildTrack = getParamObj(ErpFunBuildTrack.class);
		Integer ruleId = funBuildTrack.getBuildRuleId();
		if (ruleId == null) {
			throw new BusinessException("参数错误！");
		}
		String content = funBuildTrack.getTrackContent();
		if (content.length() > 1000) {
			throw new BusinessException("参数错误！");
		}
		funBuildTrack.setTrackTime(getTimeNow());
		funBuildTrack.setCompId(operator.getCompId());
		funBuildTrack.setCreateUid(operator.getUserId());
		funBuildTrack.setShardCityId(operator.getCityId());
		erpFunBuildTrackMapper.insertSelective(funBuildTrack);
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 楼盘资料-查看跟进
	 * @author 邓永洪
	 * @since 2018/7/11
	 */
	@ApiOperation("查看跟进")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunBuildTrackDto.class, message = "成功")
	})
	@PostMapping("/getFloorTrackList")
	@NotBlank("buildRuleId")
	public ResponseJson getFloorTrackList(@RequestBody FunBuildDataParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer buildRuleId = param.getBuildRuleId();
		Byte haveAuth = getBuildRulePermission();
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunBuildTrackDto> resList = erpFunBuildTrackMapper.getFloorTrackList(cityId, operator.getCompId(),haveAuth,buildRuleId,operator.getUserId());
		return ErpResponseJson.ok(resList);
	}

	/**
	 * @tag 获取单个楼盘详细信息
	 * @author 邓永洪
	 * @since 2018/7/11
	 */
	@RequestMapping("/getMgrSingleFloorData")
	public ResponseJson getMgrSingleFloorData(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();

		FloorDataParam floorDataParam = new FloorDataParam();
		floorDataParam.setCompId(compId);
		floorDataParam.setUserId(userId);
		floorDataParam.setNowTime(new Date());

		String userName = operator.getUserName();
		Integer entityId = param.getInteger("entityId");
		if (entityId == null) {
			return ErpResponseJson.ok();
		}
		Boolean isGener = isBuildMananager();

		ErpFunBuildRule buildRule = erpFunBuildRuleService.getMgrSingleFloorData(cityId, compId, userId, userName, isGener, entityId);

		Integer buildId = buildRule.getBuildId();
		if (buildId != null) {
			floorDataParam.setBuildId(buildId);
		}

		ErpFunUsers funUsers = erpFunUsersMapper.selectDataByUserId(cityId, compId, userId);
		if (funUsers != null && funUsers.getBuildRuleFlag() != null && funUsers.getBuildRuleFlag()) {
			// 楼盘资料管理员权限标记，0:无权限
			return ErpResponseJson.ok(buildRule);
		}

		ErpFunUsers generalManagerUser = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
		if (generalManagerUser.getUserId().equals(userId)) {
			return ErpResponseJson.ok(buildRule);
		}

		// 具有楼盘资料管理权的人 权限同总经理
		ErpUserOpers opersManage = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "BUILD_INFO_MANAGE");
		if (null != opersManage) {
			return ErpResponseJson.ok(buildRule);
		}

		// 登录人无楼盘资料管理权有楼盘分配权，展示所属门店的楼盘数据
		ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
		allotExample.setShardCityId(cityId);
		allotExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andIsDelEqualTo((byte) 1);
		List<ErpBuildAllot> erpBuildAllotList = erpBuildAllotMapper.selectByExample(allotExample);
		Set<Integer> deptIds = erpBuildAllotList == null ? new HashSet<>() : erpBuildAllotList.stream().map(ErpBuildAllot::getDeptId).collect(Collectors.toSet());
		if (deptIds.contains(getOperator().getDeptId())) {
			// 具有楼盘资料分配权的人 （楼盘查看范围所选门店中的有分配权的人可以查看该楼盘的资料信息）
			ErpUserOpers opersDistr = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "BUILD_INFO_ALLOT");
			if (null != opersDistr && funUsers != null) {
				return ErpResponseJson.ok(buildRule);
			}
		}

		// 没有楼盘资料管理权和楼盘分配权, 展示分配的给自己的在有效时限内的楼盘
		List<ErpFunBuildrulequerylimit> limits = erpFunBuildrulequerylimitMapper.getBuildrulequerylimitList(cityId, floorDataParam);
		if (!limits.isEmpty()) {
			return ErpResponseJson.ok(buildRule);
		}

		throw new BusinessException("没有权限查看楼盘资料或者已经超过有效查看时间！");
	}

	/**
	 *	楼盘资料-开启或关闭隐号拨打
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/16
	 */
	@ApiOperation("开启或关闭隐号拨打")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/openOrCloseImplicitCall")
	@NotBlank("openFlag")
	public ResponseJson openOrCloseImplicitCall(@RequestBody FunBuildDataParam param) {
		Integer closeOrOpen = param.getOpenFlag() ;// 0=关闭 1=开通
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		erpFunUsersService.updateUserStatus(cityId,compId,userId,closeOrOpen);
		return ErpResponseJson.ok();
	}

	/**
	 *	楼盘资料-设置楼盘资料管理员
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/18
	 */
	@ApiOperation("设置楼盘资料管理员")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/setMgrFloorDataManager")
	@NotBlank({"sysManager","deptId"})
	public ResponseJson setMgrFloorDataManager(@RequestBody FunBuildDataParam param) {
		String userIds = param.getSysManager();
		String deptIds = param.getDeptId();
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		if(StringUtil.isBlank(userIds)){
			throw new BusinessException("管理员不能为空！");
		}
		erpFunUsersService.updateFloorMgrManager(cityId,compId,userIds,deptIds);
		return ErpResponseJson.ok();
	}

	/**
	 * 更新单条楼盘详细信息数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/19
	 */
	@RequestMapping("/updateMgrSingleFloorData")
	public ResponseJson updateMgrSingleFloorData(@RequestBody ErpFunBuildRuleParam param) {
		GeneralParam generalParam=new GeneralParam(getOperator());
		erpFunBuildRuleService.insertOrUpdateBuildRule(generalParam,param);
		return ErpResponseJson.ok();
	}

	/**
	 * 批量更新更新详细信息数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	@RequestMapping("/updateMgrMultiFloorData")
	public ResponseJson updateMgrMultiFloorData(@RequestBody BaseMapParam param) {
		String entityIds = param.getString("entityId");
		entityIds = entityIds.replaceAll("hasHouse,|,hasHouse", "");
		if("".equals(entityIds) || !entityIds.matches("[0-9,]+")){
			throw new BusinessException("批量修改失败,请检查选择的数据是否符合批量修改标准!");
		}
		ErpFunBuildRule erpFunBuildRule=new ErpFunBuildRule();
		this.setFunBuildRuleParam(erpFunBuildRule,param);
		Byte saleStreet = param.getByte("houseStreet");
		erpFunBuildRule.setHouseStreet(saleStreet==null?5:saleStreet);
		String stprice =param.getString("saleTotalPrice");
		if(StringUtils.isBlank(stprice) || !stprice.matches("^\\d+?[\\d|\\.]*\\d*?$")){
			stprice = "0";
		}
		stprice = StringUtils.isBlank(stprice)?"0":NumberHelper.formatNumber(stprice,NumberHelper.NUMBER_IN);
		erpFunBuildRule.setSaleTotalPrice(new BigDecimal(stprice));
		//电话单独写加密地
		String phoneReq = param.getString("cellPhone");
		String shareCellPhone = param.getString("shareCellPhone");
		if (StringUtil.isNotBlank(phoneReq)) {
			erpFunBuildRule.setCellPhone(this.getEncryptPhone(phoneReq));
		}
		if (StringUtil.isNotBlank(shareCellPhone)){
			erpFunBuildRule.setShareCellPhone(this.getEncryptPhone(shareCellPhone));
		}
		String [] ids = entityIds.split(",");
		erpFunBuildRule.setShardCityId(getOperator().getCityId());

        erpFunBuildRuleService.updateFunBuildRule(ids,erpFunBuildRule,getOperator().getCityId(),getOperator().getCompId(),getOperator().getUserId(),getOperator().getUserName());
		return ErpResponseJson.ok();
	}

	/**
	 * 批量导入楼盘数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	@RequestMapping("/importBuildInfos")
	public ResponseJson importBuildInfos(@RequestBody BaseMapParam param)  {
		String buildListJson=param.getString("buildlistJson");
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		Integer deptId=getOperator().getDeptId();
		Operator operator = getOperator();
		String userName = operator.getUserName();
		String deptName = operator.getDeptName();
		if (operator.newOrganizationType()) {
			deptId = operator.getOrganizationId();
			deptName = operator.getOrganizationName();
		}

		List<Map<String,Integer>> importBuildRules = erpFunBuildRuleService.importBuildRules(buildListJson,cityId,compId,userName,deptName,deptId,operator.getUserId());
		return ErpResponseJson.ok(importBuildRules);
	}

	/**
	 * 楼盘资料-批量删除楼盘数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	@ApiOperation("批量删除楼盘数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,  message = "成功")
	})
	@PostMapping("/deleteMgrMultiFloorData")
	@NotBlank("ids")
	public ResponseJson deleteMgrMultiFloorData(@RequestBody FunBuildDataParam param) {
		String ids = param.getIds();
		if(StringUtil.isBlank(ids)){
			throw new BusinessException("请选择要删除的项！");
		}

		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();

		//验证非法途径的访问
		if(!ids.matches("[0-9,]+")){
			throw new BusinessException("批量删除失败,请检查选择的数据是否符合批量删除标准!");
		}

		Byte flag = getBuildRulePermission();
		if(flag == 3 || flag == 2){
			throw new BusinessException("您没有权限进行批量删除！");
		}
		String[] entityIds = ids.split(",");
		erpFunBuildRuleService.deleteBuildRuleBat(cityId,compId,entityIds);
		return ErpResponseJson.ok();
	}

	/**
	 * 批量添加楼盘数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/23
	 */
	@RequestMapping("/insertMgrMultiFloorData")
	public ResponseJson insertMgrMultiFloorData(@RequestBody BaseMapParam param) throws Exception{
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		Integer deptId=getOperator().getDeptId();
		String deptName = getOperator().getDeptName();
		String userName = getOperator().getUserName();
		Integer userId = getOperator().getUserId();
		erpFunBuildRuleService.insertFloorUnitMgr(cityId,deptId,compId,userId,deptName,userName,param);
		return ErpResponseJson.ok();
	}

	/**
	 * 获取楼盘资料列表
	 * @param
	 * @return
	 */
	@ApiOperation("获取楼盘资料列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,responseContainer ="List",response = ErpFunSelfbuildDto.class,message = "success")
	})
	@RequestMapping("/getBuildList")
	public ResponseJson getBuildList(@RequestBody BuildListParam param) {
		Operator ope = getOperator();
		Integer cityId = ope.getCityId();
		Integer compId = ope.getCompId();
		Integer deptId = ope.getDeptId();
		Integer buildId = param.getBuildId();
		String sectionIds = param.getSectionId();
		Integer regId = param.getRegId();

		Byte userFlag = getBuildRulePermission();
		if (3 == userFlag) { //普通用户无权限查看楼盘资料列表
			return ErpResponseJson.ok();
		}

		Set<Integer> sectionIdList = null;
		// 传递商圈ID或区域Id或二者都传时，先过滤一遍数据
		if (sectionIds != null || regId != null) {//得到到商圈id
            List<String> sectionIdListTem = null;
            if (sectionIds != null && sectionIds.contains(",")) {
                sectionIdListTem = Arrays.asList(sectionIds.split(","));
            } else if (sectionIds != null) {
                sectionIdListTem = new ArrayList<>();
                sectionIdListTem.add(sectionIds);
            }
			List<ErpFunSection> erpFunSectionList = erpFunSectionMapper.getListByRegIdOrSectionId(cityId,sectionIdListTem,regId);
			if (null !=	 erpFunSectionList){
				sectionIdList  = erpFunSectionList.stream().map(val -> val.getSectionId()).collect(Collectors.toSet());
			}
		}

		List<ErpFunSelfbuildDto> buildDtoList = null;
		if (null != buildId) {//此时不需要权限，直接查询
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			buildDtoList = erpFunSelfBuildMapper.getFunBuildList(cityId, compId,param,sectionIdList);
		} else {
			//此时需要判断权限
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			buildDtoList = erpFunSelfBuildMapper.getBuildListByDiffrentOper(cityId, compId,userFlag,param,deptId,sectionIdList);
		}

		if (CollectionUtils.isEmpty(buildDtoList)) {
			return ErpResponseJson.ok();
		}
		List<Integer> buildIdList = buildDtoList.stream().collect(Collectors.mapping(val -> val.getBuildId(), Collectors.toList()));
        List<Integer> maxBuildIdList = new ArrayList<>();
		//补充楼盘的最新1条的日志记录
		//得到最新一条楼盘日志的id集合
        if (CollectionUtils.isNotEmpty(buildIdList)) {
            List<ErpBuildLog> buildLogs = erpBuildLogMapper.getMaxIdList(cityId, compId, buildIdList);
            maxBuildIdList = buildLogs.stream().map(val -> val.getBuildId()).collect(Collectors.toList());
        }
		List<ErpBuildLog> erpBuildLogs = erpBuildLogMapper.getBuildLogListByBuildIds(cityId, compId, maxBuildIdList);
		Map<Integer, ErpBuildLog> erpBuildLogsMap = erpBuildLogs.stream().collect(Collectors.toMap(ErpBuildLog::getBuildId, val -> val));
		//补充楼盘使用门店
		ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
		allotExample.setShardCityId(cityId);
		allotExample.createCriteria().andCompIdEqualTo(compId).andBuildIdIn(buildIdList).andIsDelEqualTo((byte)1);
		List<ErpBuildAllot> erpBuildAllotList = erpBuildAllotMapper.selectByExample(allotExample);
		Map<Integer,List<ErpBuildAllot>>  mapAllot = erpBuildAllotList.stream().collect(Collectors.groupingBy(ErpBuildAllot::getBuildId));
		
		boolean isMeiLian = ope.isMeiLianApi();
		buildDtoList.forEach(val -> {
			if (null != erpBuildLogsMap && erpBuildLogsMap.size() > 0) {
				ErpBuildLog buildLog = erpBuildLogsMap.get(val.getBuildId());
				if (null != buildLog) {
					val.setRecentLog(buildLog.getTrackConten());
					val.setRecentTime(buildLog.getCreationTime());
				}
			}
			if (null != mapAllot && mapAllot.size() > 0){
				List<ErpBuildAllot> allots = mapAllot.get(val.getBuildId());
				if (CollectionUtils.isNotEmpty(allots)) {
					String  useDeptIds = allots.stream().filter(val1 -> val1.getDeptId() != null).
					map(val1 -> val1.getDeptId().toString()).collect(Collectors.joining(","));
					val.setUseDeptIds(useDeptIds);
				}
			}
			// story#11366 美联增加楼盘推广名
			if (isMeiLian && StringUtil.isNotEmpty(val.getBuildName()) && StringUtil.isNotEmpty(val.getPromotionName())) {
				val.setBuildName(val.getBuildName() + "（" + val.getPromotionName() + "）");
			}
		});

		PageInfo<ErpFunSelfbuildDto> pageInfo = new PageInfo<>(buildDtoList);
		ErpResponseJson json =  new ErpResponseJson();
		json.setData(buildDtoList);
		json.setPageNum(pageInfo.getPageNum());
		json.setPageSize(pageInfo.getPageSize());
		json.setTotal(pageInfo.getTotal());
		return json;
	}

	/**
	 * 暂停/启用分配楼盘
	 * @param
	 * @return
	 */
	@ApiOperation("暂停/启用分配楼盘")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class,message = "success")
	})
	@RequestMapping("/updateFunBuildlimitStatus")
	public ResponseJson getBuildList(@RequestBody updateFunBuildlimitStatus param) {
		ErpFunBuildrulequerylimit limit = new ErpFunBuildrulequerylimit();
		limit.setShardCityId(getOperator().getCityId());
		limit.setLimitId(param.getLimitId());
		limit.setCompId(getOperator().getCompId());
		limit.setStatus(param.getStatus());

		erpFunBuildrulequerylimitMapper.updateByPrimaryKey(limit);
		return ErpResponseJson.ok();
	}

    /**
     * 楼盘使用日志列表
     * @param
     * @return
     */
    @ApiOperation(value = "楼盘使用日志列表",httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS,response = BuildLogListVo.class, message = "success")
    })
    @RequestMapping("/getBuildLogList")
    public ResponseJson getBuildLogList(@RequestBody @Valid BuildLogListParam param){
    	if(StringUtil.isNotEmpty(param.getStartTime())){
    		param.setStartTime(param.getStartTime() + " 00:00:00");
		}
		if(StringUtil.isNotEmpty(param.getEndTime())){
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		BuildLogListVo vo = new BuildLogListVo();
		PageHelper.startPage(param.getPageOffset(),param.getPageRows(),true);
		List<ErpBuildLog> erpBuildLogs = erpBuildLogMapper.getBuildLogList(getOperator().getCityId(),getOperator().getCompId(),param);
		PageInfo<ErpBuildLog> pageInfo = new PageInfo<>(erpBuildLogs);

		vo.setBuildLogList(erpBuildLogs);
		vo.setPageOffset(pageInfo.getPageNum());
		vo.setPageRows(pageInfo.getPageSize());
		vo.setTotalcount(pageInfo.getTotal());
		return ErpResponseJson.ok(vo);
    }
	/**
	 * 查看范围-->楼盘分配门店保存
	 * @param
	 * @return
	 */
	@ApiOperation("查看范围-->楼盘分配门店保存")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class, message = "success")
	})
	@RequestMapping("/saveBuildDepts")
	public ResponseJson saveBuildDepts(@RequestBody @Valid saveBuildDeptsParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String deptName = operator.getDeptCName();
		String userName = operator.getUserName();
		boolean newOrg = operator.newOrganizationType();

		erpBuildAllotService.saveErpBuildAllot(cityId,compId,userName,userId,deptName,param, newOrg);
		return ErpResponseJson.ok();
	}
	/**
	 * 查看范围-->获取楼盘分配门店
	 * @param
	 * @return
	 */
	@ApiOperation("查看范围-->获取楼盘分配门店")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class, message = "success")
	})
	@RequestMapping("/getBuildDepts")
	public ResponseJson getBuildDepts(@RequestBody @Valid GetBuildDeptsParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
		allotExample.setShardCityId(cityId);
		allotExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte)1).andBuildIdEqualTo(param.getBuildId());
		List<ErpBuildAllot> allotList = erpBuildAllotMapper.selectByExample(allotExample);
		GetBuildDeptsVo vo =  new GetBuildDeptsVo();
		vo.setAllotList(allotList);

		return ErpResponseJson.ok(vo);
	}

	/**
	 * 参数设置
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	private void setFunBuildRuleParam(ErpFunBuildRule erpFunBuildRule, BaseMapParam param) {
		String saleLowestPrice=StringUtil.isNotBlank(param.getString("saleLowestPrice"))?param.getString("saleLowestPrice"):"0";
		String saleUnitPrice=StringUtil.isNotBlank(param.getString("saleUnitPrice"))?param.getString("saleUnitPrice"):"0";
		String leaseTotalPrice=StringUtil.isNotBlank(param.getString("leaseTotalPrice"))?param.getString("leaseTotalPrice"):"0";
		String houseArea=StringUtil.isNotBlank(param.getString("houseArea"))?param.getString("houseArea"):"0";

		Integer leaseLowestPrice=param.getInteger("leaseLowestPrice");
		erpFunBuildRule.setSaleLowestPrice(new BigDecimal(saleLowestPrice));
		erpFunBuildRule.setSaleUnitPrice(new BigDecimal(saleUnitPrice));
		erpFunBuildRule.setLeaseTotalPrice(new BigDecimal(leaseTotalPrice));
		erpFunBuildRule.setLeaseLowestPrice(leaseLowestPrice);

		erpFunBuildRule.setFloors(param.getString("floors"));
		erpFunBuildRule.setHouseArea(new BigDecimal(houseArea));
		erpFunBuildRule.setHouseDirect(param.getByte("houseDirect"));
		erpFunBuildRule.setHouseDoors(param.getByte("houseDoors"));
		erpFunBuildRule.setHouseFitment(param.getByte("houseFitment"));
		erpFunBuildRule.setHouseLadder(param.getByte("houseLadder"));
		erpFunBuildRule.setHouseRight(param.getByte("houseRight"));
		erpFunBuildRule.setHouseStituat(param.getString("houseStituat"));

		erpFunBuildRule.setIdCard(param.getString("idCard"));
		erpFunBuildRule.setLeaseAccount(param.getByte("leaseAccount"));
		erpFunBuildRule.setLeaseDeposit(param.getInteger("leaseDeposit"));
		erpFunBuildRule.setLeaseLimite(param.getByte("leaseLimite"));
		erpFunBuildRule.setLeasePriceUnit(param.getByte("leasePriceUnit"));
		erpFunBuildRule.setLeaveTime(param.getString("leaveTime"));
		erpFunBuildRule.setOwner(param.getString("owner"));
		erpFunBuildRule.setSaleAccount(param.getString("saleAccount"));
		erpFunBuildRule.setShareUser(param.getString("shareUser"));


	}


	/**
	 * 1.具有楼盘资料管理权的人，显示所有 BUILD_INFO_MANAGE
	 * 2.具有楼盘资料分配权的人，显示所属门店的使用的楼盘
	 * 3.被分配人，无查看权
	 * @return  1 显示所有  2显示所属门店使用的楼盘 3 无查看权
	 * @since 2018/5/4
	 */
	private Byte getBuildRulePermission() {
		Byte oper = 3; //默认为普通用户
		Boolean flag = false;
		Integer userId = getOperator().getUserId();
		ErpUserOpers opersManage = erpUserOpersMapper.selectPerPermissionByName(getOperator().getCityId(),getOperator().getUserId(),"BUILD_INFO_MANAGE");
		if (null != opersManage){ //具有楼盘资料管理权的人
			oper = 1;
		} else {
			ErpUserOpers opersDistr = erpUserOpersMapper.selectPerPermissionByName(getOperator().getCityId(),getOperator().getUserId(),"BUILD_INFO_ALLOT");
			if (null != opersDistr) {//具有楼盘资料分配权的人
				oper = 2;
			}
		}
		return oper;
	}
	
	/**
	 * 电话加密处理
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/25
	 */
	private String getEncryptPhone(String phoneReq) {
		String phone = "&&&";
		String[] phones = StringHelper.split(phoneReq, " ");
		for(int i=0; i<phones.length; i++){
			String[] phoneValues = StringHelper.split(phones[i], ":");
			phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
			phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
		}
		return phone;
	}
	
	/**
	 * 获取电话
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/25
	 */
	private String getPhone(String cellPhone) {
		String[] phones = StringHelper.split(cellPhone, "&&&");
		String phone = "";
		for (int j = 0; j < phones.length; j++) {
			String[] phoneValues = StringHelper.split(phones[j], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			phone += phoneValues[0] + ":" + phoneValues[1] + " ";
		}
		return phone;
	}

	/**
	 * @tag 判断是否有权限（管理员和总经理）
	 * @author 邓永洪
	 * @since 2018/5/4
	 */
	private boolean getFunBuildRuleAuthority() {
		boolean flag = false;
		Integer userId = getOperator().getUserId();
		ErpFunUsers funUsers = erpFunUsersMapper.selectDataByUserId(getOperator().getCityId(), getOperator().getCompId(), userId);
		if (funUsers != null && funUsers.getBuildRuleFlag() != null && funUsers.getBuildRuleFlag()) {
			flag = true;
		}
		if (!flag) {
			ErpFunUsers generalManagerUser = erpFunUsersService.getGeneralManagerByCompId(getOperator().getCityId(), getOperator().getCompId());
			//ErpFunUsers generalManagerUser = erpFunUsersMapper.getGeneralManagerByCompId(getOperator().getCityId(), getOperator().getCompId());
			if (generalManagerUser.getUserId().equals(userId)) {
				flag = true;
			}
		}
		return flag;
	}
	private boolean isBuildMananager() {
		Operator operator = getOperator();
		Integer userId = getOperator().getUserId();
		ErpFunUsers funUsers = erpFunUsersMapper.selectByUserId(operator.getCityId(), userId);
		boolean flag = funUsers.getBuildRuleFlag()!=null?funUsers.getBuildRuleFlag():false;
		if (operator.isGeneralManager() || flag) {
			return true;
		}
		return false;
	}

	/**
	 * 查看范围-->楼盘分配门店保存
	 * @param
	 * @return
	 */
	@ApiOperation("查看楼盘规则权限")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS,response = MgrUserViewBuildsVO.class, message = "success")})
	@RequestMapping("/getMgrUserViewBuilds")
	public ResponseJson getMgrUserViewBuilds(@RequestBody @Valid MgrUserViewBuildsParam param){
		Operator operator = getOperator();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String nowTime = getTimeNow();

		List<ErpFunBuildrulequerylimit> erpFunBuildrulequerylimits = erpFunBuildrulequerylimitMapper.getMgrUserViewBuilds(cityId, compId, userId, nowTime);
		return ErpResponseJson.ok(erpFunBuildrulequerylimits);
	}
}


