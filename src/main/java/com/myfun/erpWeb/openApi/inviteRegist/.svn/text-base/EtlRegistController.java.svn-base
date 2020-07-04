package com.myfun.erpWeb.openApi.inviteRegist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.managecenter.sysmanager.param.CreateUserParam;
import com.myfun.erpWeb.openApi.inviteRegist.param.AddCompInviteRegistEtlParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpAliyunPhoneService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rijindael.AESHelper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 邀请注册相关页面
 * @author 张宏利
 * @since 2017年5月9日
 */
@Controller
@RequestMapping(value = "/openApi/etlInviteRegist")
public class EtlRegistController extends BaseController{

	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunUsersInvitedMapper erpFunUsersInvitedMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpAliyunPhoneService erpAliyunPhoneService;
	@Autowired
	HttpRequestTask httpRequestTask;


	@ApiOperation("邀请注册接口")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,  message = "成功")
	})
	@ResponseBody
	@PostMapping("/addInviteUserInfo")
	public ResponseJson addInviteUserInfo(@RequestBody AddCompInviteRegistEtlParam param) throws Exception {
		Integer cityId = param.getCityId();
		String compNo = param.getCompNo();
		Integer compId = param.getCompId();

		// 验证安全，别公司在职人员不能邀请
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
		if (null != adminFunArchive && 2 != adminFunArchive.getUserEdition()) {
			throw new BusinessException("该电话已经注册门店版，请更换号码！");
		}
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		if(null != param.getCurrentPId()){
			if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getCurrentPId());
				if(null == erpFunUsers || null == erpFunUsers.getDeptId()){
					throw new BusinessException("团队管理人数据错误，请稍后重试或联系在线客服！");
				}
				if(!erpFunUsers.getDeptId().toString().equals(param.getDeptId().toString())){
					throw new BusinessException("所选组织与所选团队组织不一致！");
				}
			}
		}
		// 首先查询下待验证列表
		ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
		example.setShardCityId(cityId);
		example.createCriteria().andUserMobileEqualTo(param.getUserMobile()).andCompIdEqualTo(compId).andCompNoEqualTo(compNo).andCityIdEqualTo(cityId).andInviteStatusEqualTo((byte) 0);
		List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
		if (resList.size() > 0) {
			ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
			ErpFunUsersInvited updatePo = new ErpFunUsersInvited();
			updatePo.setShardCityId(cityId);
			updatePo.setId(erpFunUsersInvited.getId());
			updatePo.setUpdateTime(new Date());
			updatePo.setInviteStatus((byte) 2);
			erpFunUsersInvitedMapper.updateByPrimaryKeySelective(updatePo);
		}
		ErpFunUsersInvited erpFunUsersInvited = new ErpFunUsersInvited();
		//**********************组织架构改版********************************

//		if (operator.newOrganizationType()) {       //zt组织机构
//			param.setRangeIds(null);// 先置空 后面统一处理
//		}
//		if (param.getAreaId() == null  && !operator.newOrganizationType()) {
//			ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, param.getDeptId());
//			param.setAreaId(funDepts.getAreaId());
//		}
		//**********************组织架构改版********************************
		erpFunUsersInvited.setAreaId(param.getAreaId());
		erpFunUsersInvited.setRegId(param.getRegId());
		erpFunUsersInvited.setCityId(cityId);
		erpFunUsersInvited.setCompId(compId);
		erpFunUsersInvited.setCompNo(compNo);
		erpFunUsersInvited.setDeptId(param.getDeptId());
		erpFunUsersInvited.setGrId(param.getGrId());
		erpFunUsersInvited.setInviteStatus((byte) 0);
		erpFunUsersInvited.setRangeIds(param.getRangeIds());
		erpFunUsersInvited.setRangeType(param.getRangeType());
		erpFunUsersInvited.setServiceReg(param.getServiceReg());
		erpFunUsersInvited.setServiceZone(param.getServiceZone());
		erpFunUsersInvited.setUserMobile(param.getUserMobile());
		erpFunUsersInvited.setUserPosition(param.getUserPosition());
		erpFunUsersInvited.setUserSex(param.getUserSex());
		erpFunUsersInvited.setServiceZoneIds(param.getServiceZoneIds());
		erpFunUsersInvited.setShardCityId(cityId);
		erpFunUsersInvited.setCreateTime(new Date());
		erpFunUsersInvited.setUserName(param.getUserName());

		ErpFunUsers generalManagerByCompId = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);

		erpFunUsersInvited.setCreateUid(generalManagerByCompId.getUserId());
		erpFunUsersInvited.setRoleLevelId(param.getRoleLevelId());
		erpFunUsersInvited.setCurrentPId(param.getCurrentPId());
		//**********************组织架构改版********************************
		erpFunUsersInvited.setOrganizationId(param.getOrganizationId());
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, param.getOrganizationId());
		if (erpFunOrganization != null) {
			erpFunUsersInvited.setOrganizationPath(erpFunOrganization.getOrganizationPath());
		}
		//**********************组织架构改版********************************
		erpFunUsersInvitedMapper.insertSelective(erpFunUsersInvited);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}
}

