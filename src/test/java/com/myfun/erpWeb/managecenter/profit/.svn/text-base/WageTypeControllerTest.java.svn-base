package com.myfun.erpWeb.managecenter.profit;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.ErpFunRoleWageProfit;
import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcount;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelative;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WageTypeControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.20.139:8087/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/per.do", "673777", "18681660716");
		init("http://192.168.21.250:9001/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280751", "18500300001");
	}
	
	/**
	 * 查询工资方案列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void updateWagetypeUserRelative() throws Exception {
		SaveSalaryPlanRelativeUserParam param = new SaveSalaryPlanRelativeUserParam();
		param.setRoleId("PROPERTY_SERVER");
		param.setDeptId(12001);
		param.setBaseWage(3000);
		param.setTransferId(1);
		System.out.println(postNewErp(param, "/managecenter/profit/updateWagetypeUserRelative"));
	}
	
	/**
	 * 查询工资方案列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void insertOrUpdateRoleSalaryPlan() throws Exception {
		CreateOrUpdateUserSalaryPlanParam param = new CreateOrUpdateUserSalaryPlanParam();
		param.setDeptId(12001);
		param.setRoleId("PROPERTY_SERVER");
		param.setBaseWage("3000");
		param.setSalaryTypeId(1);
		System.out.println(postNewErp(param, "/managecenter/profit/insertOrUpdateRoleSalaryPlan"));
	}

	/**
	 * 查询工资方案列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void updateWageConfig() throws Exception {
		ErpFunWageConfigParam erpFunWageConfigParam = new ErpFunWageConfigParam();

		erpFunWageConfigParam.setExchangeAmount(new BigDecimal("50"));
		erpFunWageConfigParam.setShowType((byte) 1);
		erpFunWageConfigParam.setPerformanceCalculateType((byte) 2);
		erpFunWageConfigParam.setCustomerPubPri((byte) 2);
		erpFunWageConfigParam.setHouseAdd((byte) 1);
		erpFunWageConfigParam.setHouseBuildInfo((byte) 1);
		erpFunWageConfigParam.setHouseSoso((byte) 1);
		erpFunWageConfigParam.setHousePubPri((byte) 1);
		erpFunWageConfigParam.setHouseSharePri((byte) 1);
		erpFunWageConfigParam.setHouseToEffective((byte) 1);
		erpFunWageConfigParam.setCustomerAdd((byte) 1);
		erpFunWageConfigParam.setCustomerSharePri((byte) 1);
		erpFunWageConfigParam.setCustomerToEffective((byte) 1);
		erpFunWageConfigParam.setCustomerPubPriType((byte) 1);

		System.out.println(postNewErp(erpFunWageConfigParam, "/managecenter/profit/updateWageConfig"));
	}

	/**
	 * 查询工资方案列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getWageConfig() throws Exception {
		ErpFunWageConfigParam erpFunWageConfigParam = new ErpFunWageConfigParam();

		System.out.println(postNewErp(erpFunWageConfigParam, "/managecenter/profit/getWageConfig"));
	}

	/**
	 * 查询工资方案列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void updateRoleWageConfig() throws Exception {
		RoleWageConfigParam erpFunWageConfigParam = new RoleWageConfigParam();
		erpFunWageConfigParam.setId(null);
		erpFunWageConfigParam.setBaseWage(new BigDecimal("3000"));
		erpFunWageConfigParam.setErpFunRoleWageWorkcountList("[{\"amountLimit\":\"100\",\"checkBusiness\":\"1\",\"checkType\":\"1\",\"singleAmount\":\"10\",\"targetCount\":\"10\",\"workcountDicName\":\"房源新增\",\"workcountDicValue\":\"1\"}]");
//		"erpRoleWagetypeRelativeList":"[{\"countType\":\"0\",\"royaltyType\":\"1\"}
//		{\"amountLimit\":\"100\",\"checkBusiness\":\"1\",\"checkType\":\"1\",\"singleAmount\":\"10\",\"targetCount\":\"10\",\"workcountDicName\":\"房源新增\",\"workcountDicValue\":\"1\"}
		erpFunWageConfigParam.setRoleId("XIAO_ZHANG_GUI");
		erpFunWageConfigParam.setErpRoleWagetypeRelativeList("[{\"countType\":\"0\",\"royaltyType\":\"1\"}]");
		System.out.println(postNewErp(erpFunWageConfigParam, "/managecenter/profit/updateRoleWageConfig"));
	}

	/**
	 * 查询角色薪资方案
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getRoleWageConfig() throws Exception {
		RoleWageConfigParam erpFunWageConfigParam = new RoleWageConfigParam();
		erpFunWageConfigParam.setRoleId("45df78a607b14c0eb118d56202e68684");
		System.out.println(postNewErp(erpFunWageConfigParam, "/managecenter/profit/getRoleWageConfig"));
	}

	@Test
	public void getDealProfitDetailList() throws Exception {
		ErpFunProfitDetailParam param = new ErpFunProfitDetailParam();
		param.setDealId(6777);
		System.out.println(postNewErp(param, "/profit/getDealProfitDetailList"));
	}

	@Test
	public void getSalarySchemeListByUser() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("deptId",12001)		;
		param.put("userId",20289880)		;
		System.out.println(postNewErp(param, "managecenter/profit/getSalarySchemeListByUser"));
	}

	@Test
	public void getSalarySchemeListByType() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("managePlan",1);
		param.put("performanceType",3);
		System.out.println(postNewErp(param, "managecenter/profit/getSalarySchemeListByType"));
	}

	@Test
	public void getWageTypeDetail() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("wagetypeId",2225);
		System.out.println(postNewErp(param, "managecenter/profit/getWageTypeDetail"));
	}
}
