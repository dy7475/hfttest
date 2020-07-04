package com.myfun.erpWeb.managecenter.billManager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunBillCodeMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillCodelogMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunBillExample.Criteria;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.collection.parallel.ParIterableLike;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 管理中心-票据管理模块
 * @author lcb
 * @2017-12-08
 */
@RestController
@RequestMapping("/managerCenter/funBillModule")
public class FunBillCodeController extends BaseController {

	@Autowired
	private ErpFunBillMapper erpFunBillMapper;
	@Autowired
	private ErpFunBillCodeMapper erpFunBillCodeMapper;
	@Autowired
	private ErpFunBillCodeService erpFunBillCodeService;
	@Autowired
	private ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired
	private ErpProcessFinancMapper erpProcessFinancMapper;

	/**
	 * 查询票据号列表
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectFunBillCodeList")
	public ResponseJson selectFunBillCodeList(@Valid @RequestBody FunBillModuleParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
/*
		ErpFunBillCodeExample erpFunBillCodeExample = new ErpFunBillCodeExample();
		erpFunBillCodeExample.setShardCityId(operator.getCityId());
		ErpFunBillCodeExample.Criteria criteria = erpFunBillCodeExample.createCriteria();
		criteria.andCompIdEqualTo(operator.getCompId());

		if(null != param.getDeptId()) {
			criteria.andDeptIdEqualTo(param.getDeptId());
		}

		if(null != param.getUserId()) {
			criteria.andUserIdEqualTo(param.getUserId());
		}
		if(null != param.getStatus()) {
			criteria.andStatusEqualTo(param.getStatus());
		}
		if(null != param.getBillWay()) {
			criteria.andBillWayEqualTo(param.getBillWay());
		}
		if(null != param.getBillType()) {
			criteria.andBillTypeEqualTo(param.getBillType());
		}
*/

		if (StringUtils.isNotBlank(param.getStartTime()) && StringUtils.isNotBlank(param.getEndTime())) {
			Date queryStartTime = DateUtil.StringToDate(param.getStartTime() + " 00:00:00");
			Date queryEndTime = DateUtil.StringToDate(param.getEndTime() + " 23:59:59");
			//criteria.andCreateTimeBetween(queryStartTime, queryEndTime);
			param.setQueryStartTime(queryStartTime);
			param.setQueryEndTime(queryEndTime);
		}
		//erpFunBillCodeExample.setOrderByClause("CREATE_TIME ");
		if (null != param.getPageOffset() && null != param.getPageRows()) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		}
		//List<ErpFunBillCode> erpFunBillCodes = erpFunBillCodeMapper.selectByExample(erpFunBillCodeExample);
		param.setIsNewOrganization(getOperator().newOrganizationType());
		List<ErpFunBillCode> erpFunBillCodes = erpFunBillCodeMapper.getFunBillCodes(operator.getCityId(), param);
		return ErpResponseJson.ok(new PageInfo<>(erpFunBillCodes));
	}
    
	/**
	 * 使用规则
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBillCodeRule")
	public ResponseJson updateBillCodeRule(@Valid @RequestBody FunBillModuleParam param) {
		Operator operator = getOperator();
		Integer res = erpFunBillCodeService.updateBillCodeRule(operator.getCityId(), operator.getCompId(), param);
		return ErpResponseJson.ok(res);
	}

	/**
	 * 使用规则
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBillCode")
	public ResponseJson updateBillCodeStatus(@Valid @RequestBody FunBillModuleParam param) {
		Operator operator = getOperator();
		Integer res = erpFunBillCodeService.updateBillCode(operator.getCityId(), operator.getCompId(), param);
		return ErpResponseJson.ok(res);
	}

	/**
	 * 号段分配
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createBillCode")
	public ResponseJson createBillCode(@Valid @RequestBody FunBillModuleParam param) {
		Operator operator = getOperator();
		Integer res = erpFunBillCodeService.createBillCode(operator.getCityId(), operator.getCompId(), operator.getUserId(), operator.getUserName(), param);
		return ErpResponseJson.ok(res);
	}
	
	/**
	 * 号段分配
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getNotUseBillCodeNoList")
	public ResponseJson getNotUseBillCodeNoList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Byte billType = param.getByte("billType");
		Byte billWay = param.getByte("billWay");
		String billNo = param.getString("billNo");
		String dealId = param.getString("dealId");
//		dealId="52156";
		if (StringUtils.isNotBlank(billNo)) {
			billNo = billNo+"%";
		}
		List<ErpFunBillCodelog> codeLogList = erpFunBillCodelogMapper.getNotUseBillCodeNoList(cityId, compId, null, billType, billWay, billNo);
		if(!StringUtil.isEmpty(dealId)){// 合同可以重复使用票据号
			ErpProcessFinancExample examplef = new ErpProcessFinancExample();
			examplef.setShardCityId(cityId);
			examplef.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(Integer.valueOf(dealId)).andBillWayEqualTo(billWay);
			List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectByExample(examplef);
			List<String> logList= new ArrayList<>();
			for (ErpProcessFinanc erpProcessFinanc:erpProcessFinancs) {
				if(!logList.contains(erpProcessFinanc.getBillCodeNo())){
						logList.add(erpProcessFinanc.getBillCodeNo());
						ErpFunBillCodelog log = new ErpFunBillCodelog();
						log.setCodeNo(erpProcessFinanc.getBillCodeNo());
						log.setCodeId(erpProcessFinanc.getBillCodeId());
					   	codeLogList.add(log);
					}
			}
			List<ErpFunBillCodelog> collect = codeLogList.stream().distinct().sorted(Comparator.comparing(ErpFunBillCodelog::getCodeNo)).collect(Collectors.toList());
			if(collect.size()>10){
			   List<ErpFunBillCodelog> erpFunBillCodelogs = collect.subList(0, 10);
			   return ErpResponseJson.ok(erpFunBillCodelogs);
            }
		}
		return ErpResponseJson.ok(codeLogList);
	}


}
