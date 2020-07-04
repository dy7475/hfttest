package com.myfun.erpWeb.openApi;

import com.myfun.erpWeb.common.param.DeleteSubOrganizationParam;
import com.myfun.erpWeb.managecenter.sysmanager.OrganizationController;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewDeptParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.param.ModifyOrganizationManagerParam;
import com.myfun.repository.erpdb.param.ModifyUsersMobileParam;
import com.myfun.repository.erpdb.param.ModifyUsersUserPositionParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.Assert;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 第三方公寓推送接口
 * 
 * @author jsg
 *
 */
@Controller
@RequestMapping(value = "/openApi/organizationMoudle/")
public class OrganizationApiController {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationApiController.class);

	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	ActiveMqPublisher activeMqPublisher;
	@Autowired
	OrganizationController organizationController;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpAuditRuntimeService erpAuditRuntimeService;

	/**
	 * @desc （新版组织机构）删除子部门
	 * @author lzg
	 * @since 2019年11月26日
	 */
	@ApiOperation(value = "（新版组织机构）删除子部门")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteSubOrganization")
	@NotBlank("organizationId")
	@ResponseBody
	public ErpResponseJson deleteSubOrganization(@RequestBody @Valid DeleteSubOrganizationParam param) {
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		Assert.isNullThrow(param.getCityId());
		Assert.isNullThrow(param.getCompId());
		Assert.isNullThrow(param.getUserId());
		erpFunOrganizationService.deleteOrgByOrganizationId(param);
		activeMqPublisher.sendMoveOrgMsg(param.getCityId(), param.getCompId(), param.getOrganizationId(), null);
		return ErpResponseJson.ok();
	}


	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统同步调店")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/moveUserToNewDept")
	@ResponseBody
	public ErpResponseJson moveUserToNewDept(@RequestBody @Valid MoveUserToNewDeptParam param) {
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		Assert.isNullThrow(param.getCityId());
		Assert.isNullThrow(param.getCompId());
		Assert.isNullThrow(param.getUserId());
		Assert.isNullThrow(param.getUserName());
		organizationController.moveUserToNewOrgCommon(param);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统同步调店")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteUser")
	@ResponseBody
	public ErpResponseJson deleteUser(@RequestBody @Valid DeleteUsersParam param) {
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		Assert.isNullThrow(param.getCityId(), "cityId 必传");
		Assert.isNullThrow(param.getCompId(), "公司ID 必传");
		Assert.isNullThrow(param.getUserId(), "被注销人 必传");
		Assert.isNullThrow(param.getSelfUserId(), "操作人 必传");
		organizationController.deleteUserCommon(param);
		return ErpResponseJson.ok();
	}


	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统修改经纪人手机号")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/modifyUserMobile")
	@ResponseBody
	public ErpResponseJson modifyUserMobile(@RequestBody @Valid ModifyUsersMobileParam param) {
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		Assert.isNullThrow(param.getCityId(), "cityId 必传");
		Assert.isNullThrow(param.getArchiveId(), "被注销人必传");
		Assert.isNullThrow(param.getUserMobile(), "新手机号必传");
		Assert.isNullThrow(param.getSelfUserId(), "操作人必传");
		erpFunUsersService.modifyUserUserMobile(param.getCityId(), param.getArchiveId(), param.getUserMobile(), param.getSelfUserId());
		return ErpResponseJson.ok();
	}

	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统修改经纪人手机号")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/modifyUserUserPosition")
	@ResponseBody
	public ErpResponseJson modifyUserUserPosition(@RequestBody @Valid ModifyUsersUserPositionParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer userId = param.getUserId();
		String roleId = param.getRoleId();
		Integer currentUserId = param.getSelfUserId();
		Integer roleLevelId = param.getRoleLevelId();

		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, currentUserId);
		String createUserName = erpFunUsers.getUserName();
		erpFunUsersService.updateUserRole(cityId, compId, userId, roleId, roleLevelId, currentUserId,null,
				createUserName);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统修改组织管理员")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/modifyOrganizationManager")
	@ResponseBody
	public ErpResponseJson modifyOrganizationManager(@RequestBody @Valid ModifyOrganizationManagerParam param) {
		Integer cityId = param.getCityId();
		Integer organizationId = param.getOrganizationId();
		String userIds = param.getUserIds();
		Integer compId = param.getCompId();

		erpFunOrganizationService.updateOrganizationManager(cityId, compId, organizationId, userIds);
		//主管变更之后,处理主管变更的逻辑 flj 2020-06-24
		erpAuditRuntimeService.createAuditUserForOrgManagerChange(cityId, compId, Integer.valueOf(userIds));
		return ErpResponseJson.ok();
	}
	/**
	 * @Title
	 * @Author lcb
	 * @Time 2020/2/21
	 *
	 * **/
	@ApiOperation(value = "美联人事系统修改组织管理员")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@GetMapping("/changeOrgManager")
	@ResponseBody
	public ErpResponseJson changeOrgManager(Integer cityId,Integer compId,Integer userId) {
		//主管变更之后,处理主管变更的逻辑 flj 2020-06-24
		erpAuditRuntimeService.createAuditUserForOrgManagerChange(cityId, compId, userId);
		return ErpResponseJson.ok();
	}
}





