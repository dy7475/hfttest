package com.myfun.erpWeb.managecenter.billManager;

import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceGroupParam;
import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.param.QueryPrintBuillInfoParam;
import com.myfun.repository.erpdb.po.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BillManagerControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}

	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void selectFunBillCodeList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/selectFunBillCodeList"));
	}

	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void updateBillCodeRule() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("earbestDealBillRepeat", "0");
		param.put("allowUseBillnoIsbyhand", "0");
		param.put("invalidBillnoCanUseAgain", "1");
		param.put("billPrintWay", "0");
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/updateBillCodeRule"));
	}

	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void updateBillCode() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("codeId", "5");
//		param.put("status", "1");
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/updateBillCode"));
	}

	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void createBillCode() throws Exception{
		FunBillModuleParam funBillModuleParam = new FunBillModuleParam();
		funBillModuleParam.setDeptId(12001);
		funBillModuleParam.setBillPrintWay("0");
		funBillModuleParam.setBillType((byte)1);
		funBillModuleParam.setCodePrefix("flj");
		funBillModuleParam.setCodeStart("1");
        funBillModuleParam.setCodeEnd("100");
        funBillModuleParam.setBillWay((byte)1);
		System.out.println(postNewErp(funBillModuleParam,"/managerCenter/funBillModule/createBillCode"));
	}
	/**
	 * @Title 票据打印
	 * @Author flj
	 * @Date 2017/11/22
	 **/
	@Test
	public void printBill() throws Exception{
		QueryPrintBuillInfoParam attendanceModuleParam = new QueryPrintBuillInfoParam();
		attendanceModuleParam.setBillCodeId(37);
		attendanceModuleParam.setBillNo("lcb002");
		attendanceModuleParam.setBillWay((byte)0);
		attendanceModuleParam.setEarBestMoneyIds("201");
		/*attendanceModuleParam.setFinancIds("9363");*/
	/*	attendanceModuleParam.setDealId(6493);*/
		attendanceModuleParam.setPrintType((byte)1);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/funBillModule/printBill"));
	}
	
	/**
	 * @Title 票据打印
	 * @Author flj
	 * @Date 2017/11/22
	 **/
	@Test
	public void getPrintContentInfo() throws Exception{
		QueryPrintBuillInfoParam attendanceModuleParam = new QueryPrintBuillInfoParam();
		attendanceModuleParam.setBillCodeId(37);
		attendanceModuleParam.setBillNo("lcb002");
		attendanceModuleParam.setBillWay((byte)0);
		/*attendanceModuleParam.setEarBestMoneyIds("201");*/
		attendanceModuleParam.setFinancIds("9363");
		attendanceModuleParam.setDealId(6493);
		attendanceModuleParam.setPrintType((byte)0);
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/funBillModule/getPrintContentInfo"));
	}
	
	/**
	 * @Title 票据打印
	 * @Author flj
	 * @Date 2017/11/22
	 **/
	@Test
	public void saveBillPhoto() throws Exception{
		QueryPrintBuillInfoParam attendanceModuleParam = new QueryPrintBuillInfoParam();
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/funBillModule/saveBillPhoto"));
	}
	
	/**
	 * @Title 票据打印
	 * @Author flj
	 * @Date 2017/11/22
	 **/
	@Test
	public void delBillPhoto() throws Exception{
		QueryPrintBuillInfoParam attendanceModuleParam = new QueryPrintBuillInfoParam();
		System.out.println(postNewErp(attendanceModuleParam,"/managerCenter/funBillModule/delBillPhoto"));
	}


}
