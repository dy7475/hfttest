
package com.myfun.erpWeb.managecenter.billManager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpBillPrintTempletMapper;
import com.myfun.repository.erpdb.dto.ErpBillPrintTempletDto;
import com.myfun.repository.erpdb.param.BillPrintTempletParam;
import com.myfun.service.business.erpdb.ErpBillPrintTempletService;

@RestController
@RequestMapping("/managerCenter/funBillModule")
public class FunBillPrintController extends BaseController {
	
	@Autowired
	private ErpBillPrintTempletMapper erpBillPrintTempletMapper;
	@Autowired
	private ErpBillPrintTempletService erpBillPrintTempletService;
	
	/**
	 * 新增、修改票据套打模板
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年3月5日
	 */
	@RequestMapping("/createAndUpdateBillModel")
	public ResponseJson createBillModel(@RequestBody BillPrintTempletParam param){
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		param.setArchiveId(operator.getArchiveId());
		param.setShardCityId(operator.getCityId());
		param.setCreationTime(new Date());
		erpBillPrintTempletService.createAndUpdateBillModel(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询票据套打模板
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年3月5日
	 */
	@RequestMapping("/getBillModel")
	public ResponseJson getBillModel(@RequestBody BaseMapParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		List<ErpBillPrintTempletDto> billPrintList = erpBillPrintTempletMapper.getModelById(operator.getCityId(), compId);
		if(null == billPrintList || billPrintList.size() <= 0){
			return ErpResponseJson.ok();
		}
		ErpBillPrintTempletDto erpBillPrintTempletDto = billPrintList.get(0);
		erpBillPrintTempletDto.setOnlineUrl(CommonUtil.getPhotoUrl(erpBillPrintTempletDto.getBillAddr()));
		return ErpResponseJson.ok(erpBillPrintTempletDto);
	}
}
