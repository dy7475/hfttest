package com.myfun.erpWeb.build.api;

import com.myfun.erpWeb.build.param.*;
import com.myfun.erpWeb.build.vo.PermissionTrackListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.build.vo.BuildPermissionListVO;
import com.myfun.erpWeb.build.vo.ReceiverListVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "盘源权限控制器", value = "盘源权限控制器")
@RequestMapping(value = "/buildPermission")
public interface BuildPermissionApi {

	@ApiOperation(value = "按楼盘查询列表")
	@ApiImplicitParam(dataTypeClass = BuildPermissionListParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = BuildPermissionListVO.class) })
	@PostMapping("/getBuildPermissionList")
	ResponseJson getBuildPermissionList(@RequestBody BuildPermissionListParam param) throws Exception;
	
	@ApiOperation(value = "按组织查询列表")
	@ApiImplicitParam(dataTypeClass = OrganizePermissionListParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = BuildPermissionListVO.class) })
	@PostMapping("/getOrganizePermissionList")
	ResponseJson getOrganizePermissionList(@RequestBody OrganizePermissionListParam param) throws Exception;
	
	@ApiOperation(value = "授权")
	@ApiImplicitParam(dataTypeClass = CreatePermissionParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/createPermission")
	ResponseJson createPermission(@RequestBody CreatePermissionParam param) throws Exception;
	
	@ApiOperation(value = "修改授权")
	@ApiImplicitParam(dataTypeClass = UpdatePermissionParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/updatePermission")
	ResponseJson updatePermission(@RequestBody UpdatePermissionParam param) throws Exception;
	
	@ApiOperation(value = "删除授权")
	@ApiImplicitParam(dataTypeClass = DeletePermissionParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/deletePermission")
	ResponseJson deletePermission(@RequestBody DeletePermissionParam param) throws Exception;
	
	@ApiOperation(value = "登记房源时查询接盘人列表")
	@ApiImplicitParam(dataTypeClass = ReceiverListParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ReceiverListVO.class) })
	@PostMapping("/getReceiverList")
	ResponseJson getReceiverList(@RequestBody ReceiverListParam param) throws Exception;
	
	@ApiOperation(value = "复制授权")
	@ApiImplicitParam(dataTypeClass = CopyPermissionParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/copyPermission")
	ResponseJson copyPermission(@RequestBody CopyPermissionParam param) throws Exception;

	@ApiOperation(value = "系统监控：盘源权限列表")
	@ApiImplicitParam(dataTypeClass = CopyPermissionParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = PermissionTrackListVO.class) })
	@PostMapping("/permissionTrackList")
	ResponseJson permissionTrackList(@RequestBody PermissionTrackListParam param) throws Exception;
	
}
