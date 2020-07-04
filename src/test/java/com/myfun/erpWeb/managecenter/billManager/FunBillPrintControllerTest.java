package com.myfun.erpWeb.managecenter.billManager;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.BillPrintTempletParam;

public class FunBillPrintControllerTest extends BaseTestController {
	
	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 新增票据套打
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年3月5日
	 */
	@Test
	public void createBillModel() throws Exception{
		BillPrintTempletParam param = new BillPrintTempletParam();
		param.setBillInformation("测试账号，测试信息");
		param.setBillAddr("www.baidu.com");
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/createBillModel"));
	}

	/**
	 * 修改票据套打
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年3月5日
	 */
	@Test
	public void createAndUpdateBillModel() throws Exception{
		BillPrintTempletParam param = new BillPrintTempletParam();
		param.setBillInformation("修改测试账号，测试信息");
		param.setBillAddr("www.baidu.com/afafasfafaf");
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/createAndUpdateBillModel"));
	}
	
	/**
	 * 查询票据套打
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年3月5日
	 */
	@Test
	public void getBillModel() throws Exception{
		BaseMapParam param = new BaseMapParam();
		System.out.println(postNewErp(param,"/managerCenter/funBillModule/getBillModel"));
	}
}
