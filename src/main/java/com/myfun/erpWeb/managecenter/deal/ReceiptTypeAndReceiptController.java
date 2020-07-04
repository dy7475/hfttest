package com.myfun.erpWeb.managecenter.deal;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.deal.param.ReceiptAccountListParam;
import com.myfun.erpWeb.managecenter.deal.param.ReceiptListParam;
import com.myfun.erpWeb.managecenter.deal.vo.ErpFunReceiptAccountListVO;
import com.myfun.erpWeb.managecenter.deal.vo.ReceiptListVO;
import com.myfun.erpWeb.managecenter.sysmanager.param.IdParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunReceiptAccountMapper;
import com.myfun.repository.erpdb.dao.ErpFunReceiptTypeMapper;
import com.myfun.repository.erpdb.po.ErpFunReceiptAccount;
import com.myfun.repository.erpdb.po.ErpFunReceiptType;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunReceiptAccountService;
import com.myfun.service.business.erpdb.ErpFunReceiptTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/managecenter/receipt")
public class ReceiptTypeAndReceiptController extends BaseController {

	@Autowired
	private ErpFunReceiptAccountMapper erpFunReceiptAccountMapper;
	@Autowired
	private ErpFunReceiptTypeMapper erpFunReceiptTypeMapper;
	@Autowired
	private ErpFunReceiptTypeService erpFunReceiptTypeService;
	@Autowired
	private ErpFunReceiptAccountService erpFunReceiptAccountService;
	
	/**
	 * 查询收款方式列表
	 *@author 朱科
	 *@param 
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@ApiOperation("查询收款方式列表")
	@RequestMapping("/getFinancialReceiptTypeList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpFunReceiptType.class, message = "成功")
	})
	@ResponseBody
	public ErpResponseJson getFinancialReceiptTypeList() {
		List<ErpFunReceiptType> receiptTypeList = getErpFunReceiptTypes();
		return ErpResponseJson.ok(receiptTypeList);
	}

	/**
	 * App查询收款方式列表
	 *@author 朱科
	 *@param
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@ApiOperation("APP查询收款方式列表")
	@RequestMapping("/getAppFinancialReceiptTypeList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ReceiptListVO.class, message = "成功")
	})
	@ResponseBody
	public ErpResponseJson getAppFinancialReceiptTypeList() {
		List<ErpFunReceiptType> receiptTypeList = getErpFunReceiptTypes();
		ReceiptListVO vo = new ReceiptListVO();
		vo.setReceiptTypes(receiptTypeList);
		return ErpResponseJson.ok(vo);
	}


	private List<ErpFunReceiptType> getErpFunReceiptTypes() {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		return erpFunReceiptTypeMapper.getListByCompId(cityId, compId);
	}

	/**
	 * 保存收款方式
	 *@author 朱科
	 *@param 
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@RequestMapping("/submitFinancialReceiptTypeList")
	public ErpResponseJson submitFinancialReceiptTypeList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String paramJson = param.getString("receiptTypeJson");
		List<ErpFunReceiptType> paramList = JSON.parseArray(paramJson, ErpFunReceiptType.class);
		erpFunReceiptTypeService.updateReceiptTypeList(cityId, compId, paramList);
		return ErpResponseJson.ok();
	}

	/**
	 * 保存收款方式
	 *@author 朱科
	 *@param
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@RequestMapping("/appSubmitFinancialReceiptTypeList")
	public ErpResponseJson appSubmitFinancialReceiptTypeList(@Valid @RequestBody ReceiptListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<ErpFunReceiptType> paramList = param.getReceiptTypeList();
		erpFunReceiptTypeService.updateReceiptTypeList(cityId, compId, paramList);
		return ErpResponseJson.ok();
	}

	/**
	 * 删除收款方式
	 *@author 朱科
	 *@param 
	 *@return ErpResponseJson
	 *@since 2018年2月5日
	 */
	@RequestMapping("/deleteFinancialReceiptType")
	public ErpResponseJson deleteFinancialReceiptType(@Valid @RequestBody IdParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer id = param.getId();
		erpFunReceiptTypeMapper.updateTypeById(cityId, compId, id);
		return ErpResponseJson.ok();
	}
	/**
	 * 查询收款账号列表
	 *@author 朱科
	 *@param 
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@ApiOperation("查询收款账号列表")
	@RequestMapping("/getFinancialReceiptAccountList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpFunReceiptAccount.class, message = "成功")
	})
	@ResponseBody
	public ErpResponseJson getFinancialReceiptAccountList(){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<ErpFunReceiptAccount> receiptAccountList = erpFunReceiptAccountMapper.getListByCompId(cityId, compId);
		return ErpResponseJson.ok(receiptAccountList);
	}

	/**
	 * 查询收款账号列表
	 *@author 朱科
	 *@param
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@ApiOperation("App查询收款账号列表")
	@RequestMapping("/getAppFinancialReceiptAccountList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunReceiptAccountListVO.class, message = "成功")
	})
	@ResponseBody
	public ErpResponseJson getAppFinancialReceiptAccountList(){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<ErpFunReceiptAccount> receiptAccountList = erpFunReceiptAccountMapper.getListByCompId(cityId, compId);
		ErpFunReceiptAccountListVO vo = new ErpFunReceiptAccountListVO();
		vo.setReceiptAccountList(receiptAccountList);
		return ErpResponseJson.ok(vo);
	}


	/**
	 * 保存收款账号
	 *@author 朱科
	 *@param 
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@RequestMapping("/submitFinancialReceiptAccountList")
	public ErpResponseJson submitFinancialReceiptAccountList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String paramJson = param.getString("receiptAccountJson");
		List<ErpFunReceiptAccount> paramList = JSON.parseArray(paramJson, ErpFunReceiptAccount.class);
		erpFunReceiptAccountService.updateReceiptAccountList(cityId, compId, paramList);
		return ErpResponseJson.ok();
	}


	/**
	 * App保存收款账号
	 *@author 朱科
	 *@param
	 *@return ErpResponseJson
	 *@since 2018年1月31日
	 */
	@RequestMapping("/submitAppFinancialReceiptAccountList")
	public ErpResponseJson submitAppFinancialReceiptAccountList(@Valid @RequestBody ReceiptAccountListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<ErpFunReceiptAccount> paramList = param.getReceiptAccountList();
		erpFunReceiptAccountService.updateReceiptAccountList(cityId, compId, paramList);
		return ErpResponseJson.ok();
	}

	@RequestMapping("/deleteFinancialReceiptAccount")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response =ErpResponseJson.class, message = "成功")
	})
	public ErpResponseJson deleteFinancialReceiptAccount(@Valid @RequestBody IdParam idParam){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer id = idParam.getId();
		erpFunReceiptAccountMapper.updateAccountById(cityId, compId, id);
		return ErpResponseJson.ok();
	}
}
