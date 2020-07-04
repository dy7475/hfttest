package com.myfun.erpWeb.managecenter.accounting;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.param.GetMgrUsrIsInAtParam;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAccountMapper;
import com.myfun.repository.erpdb.dao.ErpAccountTypeMapper;
import com.myfun.repository.erpdb.dto.ErpAccountTypeDto;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.param.AccountTypeParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.service.business.erpdb.ErpAccountService;
import com.myfun.service.business.erpdb.ErpAccountTypeService;

import com.myfun.utils.DateTimeHelper;
/**
 * 管理中心-账务管理
 * @author flj
 * @2017-01-23 下午5:02:17
 */
@RestController
@RequestMapping("/managerCenter/accounting")
public class AccountingController extends BaseController {
	@Autowired private ErpAccountService erpAccountService;
	@Autowired private ErpAccountTypeService erpAccountTypeService;
	@Autowired private ErpAccountMapper erpAccountMapper;
	@Autowired private ErpAccountTypeMapper erpAccountTypeMapper;
	
	/**
	* @Date:2017-01-23
	* @Athor:方李骥
	* @Title: getAccountList 
	* @Description: 获取账务列表
	* @param param
	* @return   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/getAccountList")
	@NotBlank({"atId"})
	public ResponseJson getAccountList(@Valid @RequestBody BaseMapParam param){
		param.setInteger("compId",getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("partnerId", getOperator().getPartnerId());
		param.setInteger("openPartner", getOperator().openPartner());
		List<ErpAccount> resList = erpAccountMapper.selectAccountList(getOperator().getCityId(),param.getMap());
		return ErpResponseJson.ok(resList);
	}
	
	/**
	 * @Date:2017-01-23
	 * @Athor:方李骥
	 * @Title: getAccountList 
	 * @Description: 获取账套列表
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@ApiOperation("获取账套列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/getAccountTypeList")
	public ResponseJson getAccountTypeList(@RequestBody BaseMapParam param){
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("partnerId", getOperator().getPartnerId());
		param.setInteger("openPartner", getOperator().openPartner());
		param.setInteger("newOrganization", getOperator().newOrganizationType() ? 1 : 0);// 无限组织时，参数增加organizationId
		
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		List<ErpAccountTypeDto> resList = erpAccountTypeMapper.getAccountTypeList(getOperator().getCityId(), param.getMap());
		return ErpResponseJson.ok(resList);
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: insertAccountType 
	 * @Description: 新增一条账务
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/insertAccount")
	public ResponseJson insertAccount(@Valid @RequestBody AccountParam param){
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		param.setCreatorUid(getOperator().getUserId());
		param.setPartnerId(getOperator().getPartnerId());// story#11306 加盟模式-加盟定制开启后默认可自行管理的模块
		param.setOpenPartner(getOperator().openPartner());
		erpAccountService.insertAccount(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: updateAccount
	 * @Description: 更新账务
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/updateAccount")
	public ResponseJson updateAccount(@Valid @RequestBody AccountParam param){
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		erpAccountService.updateAccount(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: deleteAccount 
	 * @Description: 删除一条账务
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/deleteAccount")
	@NotBlank({"actId"})
	public ResponseJson deleteAccount(@Valid @RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		Integer actId = param.getInteger("actId");
		erpAccountService.deleteAccount(cityId, actId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: getAccountInfo 
	 * @Description: 查询账务详情
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@NotBlank({"actId"})
	@RequestMapping("/getAccountInfo")
	public ResponseJson getAccountInfo(@Valid @RequestBody BaseMapParam param){
		Integer actId = param.getInteger("actId");
		ErpAccount erpAccount = erpAccountMapper.selectByActIdAndCompId(getOperator().getCityId(), getOperator().getCompId(), actId);
		return ErpResponseJson.ok(erpAccount);
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: reviewAccount 
	 * @Description: 复核一条记录，在复核该记录时将时间在本记录以前的所有记录复核
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/reviewAccount")
	@NotBlank({"actId"})
	public ResponseJson reviewAccount(@Valid @RequestBody BaseMapParam param){
		param.setInteger("cityId",getOperator().getCityId());
		param.setInteger("userId",getOperator().getUserId());
		erpAccountService.reviewAccount(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: insertAccountType 
	 * @Description: 新增一条账套
	 * @param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/insertAccountType")
	public ResponseJson insertAccountType(@Valid @RequestBody AccountTypeParam accountTypeParam){
		accountTypeParam.setShardCityId(getOperator().getCityId());
		accountTypeParam.setCompId(getOperator().getCompId());
		accountTypeParam.setCreationTime(new Date());
		accountTypeParam.setCreatorUid(getOperator().getUserId());
		accountTypeParam.setPartnerId(getOperator().getPartnerId());
		erpAccountTypeService.insertAccountType(accountTypeParam);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: updateAccountType 
	 * @Description: 更新账套
	 * @param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/updateAccountType")
	public ResponseJson updateAccountType(@Valid @RequestBody AccountTypeParam accountTypeParam){
		accountTypeParam.setShardCityId(getOperator().getCityId());
		erpAccountTypeService.updateAccountType(accountTypeParam);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2017-01-24
	 * @Athor:方李骥
	 * @Title: deleteAccountType 
	 * @Description: 删除一条账套
	 * @param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/deleteAccountType")
	@NotBlank({"atId"})
	public ResponseJson deleteAccountType(@Valid @RequestBody BaseMapParam accountTypeParam){
		accountTypeParam.setInteger("cityId",getOperator().getCityId());
		erpAccountTypeService.deleteAccountType(accountTypeParam);
		return ErpResponseJson.ok();
	}
	
	/**
	 *判断用户是否为审核员且又是记账员 
	 * @author 熊刚
	 * @since 2017年9月15日
	 * @param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("判断用户是否为审核员且又是记账员")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/getMgrUsrIsInAt")
	public ResponseJson getMgrUsrIsInAt(@Valid @RequestBody GetMgrUsrIsInAtParam param) {
		param.setUserId(getOperator().getUserId());
		param.setCompId(getOperator().getCompId());
		Map<String, Object> isInAtMap = erpAccountTypeMapper.getMgrUsrIsInAt(getOperator().getCityId(), param);
		return ErpResponseJson.ok(isInAtMap);
	}
	
	/**
	 *报表导出
	 * @author 熊刚
	 * @since 2017年9月15日
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMgrMyAtList")
	public ResponseJson getMgrMyAtList(@Valid @RequestBody AccountParam param) {
		String startTime = param.getCreationTime1();
		String endTime = param.getCreationTime2();
		if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			startTime = DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 00:00:00");
			endTime = DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 23:59:59");
		} else if (StringUtils.isNotBlank(startTime) && StringUtils.isBlank(endTime)) {
			startTime = DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 00:00:00");
			endTime = DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 23:59:59");
		} else if (StringUtils.isNotBlank(endTime) && StringUtils.isBlank(startTime)) {
			startTime = DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 00:00:00");
			endTime = DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 23:59:59");
		}
		param.setCreationTime1(startTime);
		param.setCreationTime2(endTime);
		List<ErpAccount> erpAccountList = erpAccountMapper.getAccountList(getOperator().getCityId(), param);
		return ErpResponseJson.ok(erpAccountList);
	}
}
