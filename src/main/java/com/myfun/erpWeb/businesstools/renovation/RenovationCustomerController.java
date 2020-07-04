package com.myfun.erpWeb.businesstools.renovation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerMapper;
import com.myfun.repository.erpdb.param.RenovationCustomerParam;
import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.service.business.erpdb.ErpRenovationCustomerService;
import com.myfun.utils.StringUtil;

@RestController
@RequestMapping("/renovation")
public class RenovationCustomerController extends BaseController{
	
	@Autowired
	private ErpRenovationCustomerMapper erpRenovationCustomerMapper;
	@Autowired
	private ErpRenovationCustomerService erpRenovationCustomerService;
	
	/**
	 * 登记装修信息
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年2月26日
	 */
	@RequestMapping("/addRenovationCustomer")
	public ResponseJson addRenovationCustomer(@RequestBody RenovationCustomerParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		param.setCompId(operator.getCompId());
		param.setArchiveId(operator.getArchiveId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setGrId(operator.getGrId());
		param.setDeptId(operator.getDeptId());
		param.setShardCityId(operator.getCityId());
		param.setUserName(operator.getUserName());
		erpRenovationCustomerService.addRenovationCustomer(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 修改装修信息
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年2月26日
	 */
	@RequestMapping("/updateRenovationCustomer")
	public ResponseJson updateRenovationCustomer(@RequestBody RenovationCustomerParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		param.setCompId(operator.getCompId());
		param.setArchiveId(operator.getArchiveId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setGrId(operator.getGrId());
		param.setDeptId(operator.getDeptId());
		param.setShardCityId(operator.getCityId());
		param.setUserName(operator.getUserName());
		erpRenovationCustomerService.updateRenovationCustomer(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询装修列表信息
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年2月26日
	 */
	@RequestMapping("/getRenovationCustomerList")
	public ResponseJson getRenovationCustomerList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer userId = param.getInteger("userId");
		String likeStr = param.getString("likeStr");//模糊查询客户姓名、电话、编号
		if(StringUtil.isNotBlank(likeStr)){
			likeStr ="%" + likeStr + "%";
		}
		Integer houseUseage = StringUtil.parseInteger(param.getInteger("houseUseage"), null);//用途
		BigDecimal intentPricelow = StringUtil.isNotBlank(param.getString("intentPricelow"))?StringUtil.parseBigDecimal(param.getString("intentPricelow")):null;//最低价
		BigDecimal intentPricehigh = StringUtil.isNotBlank(param.getString("intentPricehigh"))?StringUtil.parseBigDecimal(param.getString("intentPricehigh")):null;//最高价
		if(null != intentPricelow){
			intentPricelow = intentPricelow.multiply(new BigDecimal(10000));
		}
		if(null != intentPricehigh){
			intentPricehigh = intentPricehigh.multiply(new BigDecimal(10000));
		}
		Integer custStatus = StringUtil.parseInteger(param.getInteger("custStatus"), null);//客户状态，0=有效 1=无效 2=暂缓 3=已装修
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpRenovationCustomer> resultList = erpRenovationCustomerMapper.getRenovationList(operator.getCityId(), operator.getCompId(), userId, houseUseage, intentPricelow, intentPricehigh, custStatus, likeStr, param.getMap());
		PageInfo<ErpRenovationCustomer> pageInfo = new PageInfo<ErpRenovationCustomer>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 查询装修单个详细信息
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年2月26日
	 */
	@RequestMapping("/getRenovationCustomer")
	public ResponseJson getRenovationCustomer(@RequestBody RenovationCustomerParam param) {
		Operator operator = getOperator();
		param.setShardCityId(operator.getCityId());
		ErpRenovationCustomer erpRenovationCustomer = erpRenovationCustomerMapper.selectByPrimaryKey(param);
		return ErpResponseJson.ok(erpRenovationCustomer);
	}
	
}


