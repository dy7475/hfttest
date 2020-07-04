package com.myfun.erpWeb.usercenter.payment.trueHouse;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;

public class TrueHouseControllerTest extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "8", "17800000009");
//		init("http://192.168.0.42:8080/erpWeb", "http://192.168.0.42:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		init("http://192.168.5.172:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 保证金退还页面查询可提现金额等
	 * @author 张宏利
	 * @since 2018年4月8日
	 * @throws Exception
	 */
	@Test
	public void getTrueAmountInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/payment/trueHouse/getTrueAmountInfo"));
	}
	
}
