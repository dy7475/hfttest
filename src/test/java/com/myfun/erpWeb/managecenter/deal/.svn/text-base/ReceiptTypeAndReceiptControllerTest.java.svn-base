package com.myfun.erpWeb.managecenter.deal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

public class ReceiptTypeAndReceiptControllerTest extends BaseTestController {
	
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	@Test
	public void submitFinancialReceiptTypeList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("receiptType", "支付宝");
		param.put("id", "");
		List<Map<String, Object>> listMap = new ArrayList<>();
		listMap.add(param);
		String str = JSON.toJSONString(listMap);
		BaseMapParam param1 = new BaseMapParam();
		param1.setString("receiptTypeJson", str);
		System.out.println(postNewErp(param1, "/managecenter/receipt/submitFinancialReceiptTypeList"));
	}
	
	@Test
	public void getFinancialReceiptTypeList() throws Exception {
		System.out.println(postNewErp(null, "/managecenter/receipt/getFinancialReceiptTypeList"));
	}
	@Test
	public void submitFinancialReceiptAccountList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("receiptAccount", "支付宝(15228861532)");
		param.put("id", "");
		List<Map<String, Object>> listMap = new ArrayList<>();
		listMap.add(param);
		String str = JSON.toJSONString(listMap);
		BaseMapParam param1 = new BaseMapParam();
		param1.setString("receiptAccountJson", str);
		System.out.println(postNewErp(param1, "/managecenter/receipt/submitFinancialReceiptAccountList"));
	}
	
	@Test
	public void getFinancialReceiptAccountList() throws Exception {
		System.out.println(postNewErp(null, "/managecenter/receipt/getFinancialReceiptAccountList"));
	}
	@Test
	public void deleteFinancialReceiptType() throws Exception {
		Map<String, Integer> param=new HashMap<>();
		param.put("id", 1);
		System.out.println(postNewErp(param, "/managecenter/receipt/deleteFinancialReceiptType"));
	}
	@Test
	public void deleteFinancialReceiptAccount() throws Exception {
		Map<String, Integer> param=new HashMap<>();
		param.put("id", 1);
		System.out.println(postNewErp(param, "/managecenter/receipt/deleteFinancialReceiptAccount"));
	}
}
