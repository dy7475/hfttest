package com.myfun.erpWeb.managecenter.profit;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.profit.param.FunWageListParam;
import com.myfun.erpWeb.managecenter.profit.param.WageLogListParam;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.ErpFunRoleWageProfit;
import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcount;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelative;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErpFunWageControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "670087", "17180493881");
//		init("http://192.168.200.175:9001/erpWeb/", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
		init("http://192.168.21.135:8087/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "673777", "18681660716");

	}
	
	@Test
	public void getFunWageList() throws Exception {
//		"date1": "2019-07",
//		"date2": "2019-07",
//		"deptId": "12001",
//		"pageOffset": "1",
//		"pageRows": "50",
//		"roleId": "",
//		"userId": ""
		FunWageListParam erpFunWageParam = new FunWageListParam();
		erpFunWageParam.setAssessmentMonth("2019-07,2019-07");
		erpFunWageParam.setDeptId(12001);
		erpFunWageParam.setDate1("2019-07");
		erpFunWageParam.setDate2("2019-07");
		erpFunWageParam.setRoleId("be0cf8b791c041f9af1296b56a566b6f");
		erpFunWageParam.setRoleLevelId("62,63,73,74,75");
		System.out.println(postNewErp(erpFunWageParam, "/funWage/getFunWageList"));
	}

	@Test
	public void getPersonFunProfitDetailList() throws Exception {
		ErpFunWageParam erpFunWageParam = new ErpFunWageParam();
		erpFunWageParam.setAssessmentMonth("2018-01");
		erpFunWageParam.setUserId(20322125);
		erpFunWageParam.setProfitType(3);
		System.out.println(postNewErp(erpFunWageParam, "/funWage/getPersonFunProfitDetailList"));
	}

	@Test
	public void auditFunWageDetail() throws Exception {
		AuditWageParam erpFunWageParam = new AuditWageParam();
		erpFunWageParam.setWageIds("1446487");
		System.out.println(postNewErp(erpFunWageParam, "funWage/auditFunWageDetail"));
	}
	@Test
	public void getFunWageDetail() throws Exception {
		ErpFunWageParam erpFunWageParam = new ErpFunWageParam();
		erpFunWageParam.setWageId(12672);
//		erpFunWageParam.setOtherWage(new BigDecimal("30.00"));
		System.out.println(postNewErp(erpFunWageParam, "/funWage/getFunWageDetail"));
	}
	@Test
	public void updateFunWageDetail() throws Exception {
		ErpFunWageParam erpFunWageParam = new ErpFunWageParam();
		erpFunWageParam.setWageId(12672);
		erpFunWageParam.setExplain("迟到1次，奖励30元");
		//erpFunWageParam.setDelWage(new BigDecimal("10.00"));
		erpFunWageParam.setOtherWage(new BigDecimal("30.00"));
		erpFunWageParam.setRealWage(new BigDecimal(999));
		System.out.println(postNewErp(erpFunWageParam, "/funWage/updateFunWageDetail"));
	}

	@Test
	public void getProfitList() throws Exception {
		ErpFunProfitDetailParam erpFunWageParam = new ErpFunProfitDetailParam();
//		erpFunWageParam.setDealId(6703);
		erpFunWageParam.setStartTime("2018-02");
		erpFunWageParam.setEndTime("2018-02");
		erpFunWageParam.setTimeType(1);
		erpFunWageParam.setDeptId(892130);
		System.out.println(postNewErp(erpFunWageParam, "/profit/getProfitList"));
	}

	@Test
	public void getProfitDetail() throws Exception {
		ErpFunProfitDetailParam erpFunWageParam = new ErpFunProfitDetailParam();
		erpFunWageParam.setDealId(6697);
//		erpFunWageParam.setPerformanceId((byte)2);
		System.out.println(postNewErp(erpFunWageParam, "/profit/getProfitDetail"));
	}

	@Test
	public void updateWorkCountTargetDetail() throws Exception {
		ErpFunWorkCountTargetParam erpFunWorkCountTargetParam = new ErpFunWorkCountTargetParam();
//		erpFunWorkCountTargetParam.setId(12);
		erpFunWorkCountTargetParam.setUserPosition("GENERAL_MANAGER");
		erpFunWorkCountTargetParam.setGjHouseCount(7);
		erpFunWorkCountTargetParam.setTargetType((byte)2);
		System.out.println(postNewErp(erpFunWorkCountTargetParam, "/profit/updateWorkCountTargetDetail"));
	}

	@Test
	public void getWorkCountTargetList() throws Exception {
		ErpFunWorkCountTargetParam erpFunWorkCountTargetParam = new ErpFunWorkCountTargetParam();
		erpFunWorkCountTargetParam.setUserId(20322125);
		erpFunWorkCountTargetParam.setTargetType((byte)2);
		System.out.println(postNewErp(erpFunWorkCountTargetParam, "/profit/getWorkCountTargetList"));
	}

	/**
	 * 获取工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	@Test
	public void getUserListByShenHe() throws Exception {
		ErpFunWageParam erpFunWageParam = new ErpFunWageParam();
		System.out.println(postNewErp(erpFunWageParam, "/funWage/getUserListByShenHe"));
	}

	/**
	 * 更新工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	@Test
	public void updateShenheUserFlag() throws Exception {
		/*
		{"CLIENTKEY":"228f76c57dfca9642fed6de93f699930","DEPT_ID":"12001","SOURCE_DEPT_ID":"12001","USERIDS":"2001,2008,2009,10095135,20059061,20059130,20289880,2003,10086823,10088653,10103518,20320815,","WAGE_FLAG":"1"}
		* */
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userids","2001,2008,2009,10095135,20059061,20059130,20289880,2003,10086823,10088653,10103518,20320815,");
		System.out.println(postNewErp(pMap, "/funWage/updateShenheUserFlag"));
	}


	/**
	 * 更新工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	@Test
	public void getWageLogList() throws Exception {
		WageLogListParam pMap = new WageLogListParam();
		pMap.setPageRows(200);
		pMap.setPageOffset(1);
		System.out.println(postNewErp(pMap, "/funWage/getWageLogList"));
	}
}
