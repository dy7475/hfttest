package com.myfun.erpWeb.managecenter.profit;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;

public class SalaryAssessmentControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.42:8080/erpWeb", "http://192.168.0.42:80/hftWebService/web/api/authentication/per.do", "37", "13980047326");
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "670087", "17180493881");
	}
	
	/**
	 * 排名
	 * @throws Exception
	 */
	@Test
	public void getRankInformation() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("type", 2);
		param.put("archiveId", 508375);
		System.out.println(postNewErp(param,"managecenter/profit/getRankInformation"));
	}
	/**
	 *个人信息
	 * @throws Exception
	 */
	@Test
	public void getSalarySchemeByArchiveId() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"managecenter/profit/getSalarySchemeByArchiveId"));
	}
	/**
	 *薪资考核统计列表
	 * @throws Exception
	 */
	@Test
	public void getSalarySchemeList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("time", "2017-08-01 00:00:00");
		System.out.println(postNewErp(param,"managecenter/profit/getSalarySchemeList"));
	}
	
	@Test
	public void getPerformanceAssessmentCountDetail() throws Exception{
		ErpPerformanceAssessmentCountParam param = new ErpPerformanceAssessmentCountParam();
		param.setCountType(7);
		param.setCheckType(1);
		param.setUserId(20322125);
		param.setAssessmentMonth("2018-02");
		param.setCompId(46470);
		param.setDeptId(892130);
		param.setCityId(1);
		param.setCaseType(1);
		param.setRegId(45363);
		param.setGrId(252995);
		param.setAreaId(18396);

		param.setValidFlag(0);
		System.out.println(postNewErp(param,"/managecenter/profit/getPerformanceAssessmentCountDetail"));
	}

	// 统计条数
	@Test
	public void getAssessmentDetailCount() throws Exception{
		ErpPerformanceAssessmentCountParam param = new ErpPerformanceAssessmentCountParam();
		param.setCountType(7);
		param.setCheckType(1);
		param.setUserId(20322125);
		param.setAssessmentMonth("2018-02");
		param.setCompId(46470);
		param.setDeptId(892130);
		param.setCityId(1);
		param.setCaseType(1);
		param.setRegId(45363);
		param.setGrId(252995);
		param.setAreaId(18396);

		param.setValidFlag(0);
		System.out.println(postNewErp(param,"/managecenter/profit/getAssessmentDetailCount"));
	}

	@Test
	public void getAbnormalWorkAmount() throws Exception {
		ErpPerformanceAssessmentCountParam param = new ErpPerformanceAssessmentCountParam();
		param.setId(31330);
		param.setDetailIds("40,41");
		param.setCountType(7);
		param.setValidFlag(0);
		System.out.println(postNewErp(param,"/managecenter/profit/getAbnormalWorkAmount"));
	}
	
	@Test
	public void getProfitMessageFormList() throws Exception{
		ErpProfitMessageFormParam param = new ErpProfitMessageFormParam();
		param.setAssessmentMonth("2018-02");
		param.setUserId(20322125);
		param.setCheckType(2);
		param.setAreaId(18396);
		param.setRegId(45363);
		param.setDeptId(892130);
		param.setGrId(252995);

		System.out.println(postNewErp(param,"/managecenter/profit/getProfitMessageFormList"));
	}

	@Test
	public void getAbnormalProfitMessage() throws Exception{
		ErpProfitMessageFormParam param = new ErpProfitMessageFormParam();
		param.setIds("19,20,21");
		param.setUserId(20322125);
		param.setValidFlag(1);
		param.setAssessmentId(31330);
		System.out.println(postNewErp(param,"/managecenter/profit/getAbnormalProfitMessage"));
	}
}
