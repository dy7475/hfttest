package com.myfun.erpWeb.managecenter.buildRile;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class FunBuildRuleControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");

	}
	
	@Test
	public void getBuildRoofUnits() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", 2010090);
		System.out.println(postNewErp(pMap,"/managerCenter/buildRule/getBuildRoofUnits"));
	}
	@Test
	public void getRoofUnitNumList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", 2010090);
		System.out.println(postNewErp(pMap,"/managerCenter/buildRule/getRoofUnitNumList"));
	}

	@Test
	public void getRoadsMenu() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("roadsName", "北");
		System.out.println(postNewErp(pMap,"/house/getRoadsMenu"));
	}
}
