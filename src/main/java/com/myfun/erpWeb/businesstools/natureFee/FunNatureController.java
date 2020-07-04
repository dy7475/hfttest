package com.myfun.erpWeb.businesstools.natureFee;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunNatureTempletMapper;
import com.myfun.repository.erpdb.param.ErpFunNatureTempletParam;
import com.myfun.repository.erpdb.po.ErpFunNatureTemplet;
import com.myfun.repository.erpdb.po.ErpFunNatureTempletExample;
import com.myfun.service.business.erpdb.ErpFunNatureTempletService;
import org.apache.commons.collections.ArrayStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * title ：税费模块
 * auhor：lcb
 * date  : 2017/11/4
 */
@RestController
@RequestMapping(value = "/businesstools/natureFeeModule", method=RequestMethod.POST)
public class FunNatureController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FunNatureController.class);

	@Autowired
	ErpFunNatureTempletMapper erpFunNatureTempletMapper;
	@Autowired
	ErpFunNatureTempletService erpFunNatureTempletService;

	/**
	 * title ：查询税费模板列表
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@RequestMapping("/getNatureTempletList")
	public ResponseJson getNatureTempletList(@Valid @RequestBody BaseMapParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunNatureTempletExample erpFunNatureTempletExample = new ErpFunNatureTempletExample();
		erpFunNatureTempletExample.setShardCityId(cityId);
		erpFunNatureTempletExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunNatureTemplet> resList = erpFunNatureTempletMapper.selectByExample(erpFunNatureTempletExample);
		return ErpResponseJson.ok(resList);
	}

	/**
	 * title ：查询税费模板列表
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@RequestMapping("/addOrEditNatureTemplet")
	public ResponseJson addOrEditNatureTemplet(@Valid @RequestBody ErpFunNatureTempletParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer deptId = operator.getDeptId();

		ErpFunNatureTemplet erpFunNatureTemplet = new ErpFunNatureTemplet();
		BeanUtils.copyProperties(param, erpFunNatureTemplet);
		Integer res = erpFunNatureTempletService.addOrEditNatureTemplet(cityId, compId, deptId, erpFunNatureTemplet);
		return ErpResponseJson.ok(res);
	}

	/**
	 * title ：查询税费模板列表
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@RequestMapping("/test")
	public ResponseJson test(@Valid @RequestBody ErpFunNatureTempletParam param) throws Exception{
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> p = new HashMap<>();
		p.put("name", "李成兵");
		List<Map<String, Object>> paramList2 = new ArrayList<>();
		Map<String, Object> p2 = new HashMap<>();
		p2.put("p1", "2222");
		p2.put("p2", "3333");
		paramList2.add(p2);
		p.put("extParam", paramList2);
		paramList.add(p);
		return ErpResponseJson.ok(paramList);
	}


}


