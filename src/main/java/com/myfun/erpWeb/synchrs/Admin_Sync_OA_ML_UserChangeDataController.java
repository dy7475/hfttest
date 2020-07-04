package com.myfun.erpWeb.synchrs;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_UserChangeDataParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.synchrs.Admin_Sync_OA_ML_UserChangeData2Service;
import com.myfun.service.business.admindb.synchrs.enums.DeptAndEmpTransferConstants.EmpChangTypeEnum;
import com.myfun.service.business.erpdb.ErpUserOpersService;

import io.swagger.annotations.Api;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_UserChangeDataController 
* @Description:人员调迁信息控制器（同步HRS人员信息异动记录）
* @author tangliang1
* @date 2020年6月24日 下午3:00:27 
*
 */
@Api(tags = "人员调迁信息控制器", value = "人员调迁信息控制器")
@RestController
@RequestMapping(value = "/synchrs/userChange")
public class Admin_Sync_OA_ML_UserChangeDataController extends BaseController {

	/****** 查看人员变动记录权限key ******/
	private final String LIMIT_VIEW_EMP_CHANGE_KEY="VIEW_EMP_CHANGE";
	
	@Autowired
//	private Admin_Sync_OA_ML_UserChangeDataService userChangeDataService;
	private Admin_Sync_OA_ML_UserChangeData2Service userChangeDataService;
	
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	
	/**
	 * 
	* @Title: getCurrentUserTransferInfo 
	* @Description: 获取当前操作人的调迁信息
	* @author tangliang1
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws
	 */
	@PostMapping(value = "/getCurrentUserTransferInfo")
	public Object getUserTransferInfo(@RequestBody Admin_Sync_OA_ML_UserChangeDataParam userChangeDataParam) {
		
		// 设置查询权限
		if (!this.checkUserJurisdiction(LIMIT_VIEW_EMP_CHANGE_KEY)) {
			return ErpResponseJson.warn("您没有查看权限");
		}
		
		// 如果hftUserId 未传，则表示查询当前登录用户的职级信息
		Integer hftUserId=userChangeDataParam.getHftUserId();
		if (Objects.isNull(hftUserId)) {
			hftUserId=getOperator().getUserId();
		}
		
		DefaultResponseJson respJson=new DefaultResponseJson();
		respJson.setData(userChangeDataService.getUserTransferInfo(hftUserId));
		respJson.setErrCode(Const.ResponseCode.SUCCESS);
		respJson.setErrMsg("操作成功");
		return respJson;
	}

	/**
	 * 
	* @Title: getUserTransferList 
	* @Description: 获取用户调迁列表
	* @author tangliang1
	* @param @param userChangeDataParam
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws
	 */
	@PostMapping(value = "/getUserTransferList")
	public Object getUserTransferList(@RequestBody Admin_Sync_OA_ML_UserChangeDataParam userChangeDataParam) {
		
		// 设置查询权限
		if (!this.checkUserJurisdiction(LIMIT_VIEW_EMP_CHANGE_KEY)) {
//			return ErpResponseJson.warn("您没有查看权限");
		}
		return userChangeDataService.getUserTransferList(userChangeDataParam);
	}

	/**
	 * 
	* @Title: getTransferType 
	* @Description: 获取用户调迁类型列表
	* @author tangliang1
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws
	 */
	@PostMapping(value = "/getTransferType")
	public Object getTransferType() {
		
		DefaultResponseJson respJson=new DefaultResponseJson();
		respJson.setData(EmpChangTypeEnum.getValues());
		respJson.setErrCode(Const.ResponseCode.SUCCESS);
		respJson.setErrMsg("操作成功");
		return respJson;
	}
	
	/**
	 * 
	* @Title: checkUserJurisdiction 
	* @Description: 检查用户是否有查看权限
	* @author tangliang1
	* @param @param permissionName  指定的权限key
	* @return void    返回类型 
	* @throws
	 */
	Boolean checkUserJurisdiction(String permissionName) {
		Operator oper=super.getOperator();
		return  erpUserOpersService.judgePermission(oper.getCityId(), oper.getUserId(), permissionName);
	}
	
}
