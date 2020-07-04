package com.myfun.erpWeb.soso.customer;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyDataParam;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyListParam;

/**
 * 搜搜客源控制器
 * @author 张宏利
 * @since 2016年8月30日
 */
public class SoSoCustomerControllerTest extends BaseTestController{
	
	@Before
	public void init() {
		init("http://192.168.0.193:8081/erpWeb", "http://192.168.0.193/hftWebService/web/api/authentication/per.do", "17", "17810000019");
	}
	
	/**
	 * 获取搜搜求购列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 * @throws Exception 
	 */
	@Test//@RequestMapping(value="/getSoSoBuyList")
	public void getSoSoBuyList() throws Exception{
		SoSoBuyListParam param = new SoSoBuyListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		param.setArea1("0");
		param.setArea2("160");
		param.setKeywords("1");
		param.setPrice1("0");
		param.setPrice2("550");
		param.setRegion("双流");
		param.setRoom1("0");
		param.setRoom2("5");
		param.setTime("4");
		param.setUseage("1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getSoSoBuyList"));
	}
	
	/**
	 * 解密电话
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//@RequestMapping(value="/getSOSOPhone")
	public void deductCost() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setString("caseId", "1010985788");
		param.setString("caseType", "1");
		param.setString("source", "1");
		param.setString("sosoType", "1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getSOSOPhone"));
	}

	/**
	 * 获取搜搜求购详情
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//@RequestMapping(value="/getVipBuyData")
	public void getVipBuyData() throws Exception{
		SoSoBuyDataParam param = new SoSoBuyDataParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getVipBuyData"));
	}
	
	/**
	 * 获取搜搜求购已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//@RequestMapping(value="/getVipBuyViewedList")
	public void getVipBuyViewedList() throws Exception{
		SoSoBuyListParam param = new SoSoBuyListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		param.setArea1("0");
		param.setArea2("160");
		param.setKeywords("1");
		param.setPrice1("0");
		param.setPrice2("550");
		param.setRegion("双流");
		param.setRoom1("0");
		param.setRoom2("5");
		param.setTime("4");
		param.setUseage("1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getVipBuyViewedList"));
	}
	
	/**
	 * 获取搜搜求购列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//@RequestMapping(value="/getSoSoRentList")
	public void getSoSoRentList() throws Exception{
		SoSoBuyListParam param = new SoSoBuyListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		param.setArea1("0");
		param.setArea2("160");
		param.setKeywords("1");
		param.setPrice1("0");
		param.setPrice2("550");
		param.setRegion("双流");
		param.setRoom1("0");
		param.setRoom2("5");
		param.setTime("4");
		param.setUseage("1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getSoSoRentList"));
	}
	
	/**
	 * 获取搜搜求租已查看列表
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	@Test//@RequestMapping(value="/getVipRentViewedList")
	public void getVipRentViewedList() throws Exception{
		SoSoBuyListParam param = new SoSoBuyListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		param.setArea1("0");
		param.setArea2("160");
		param.setKeywords("1");
		param.setPrice1("0");
		param.setPrice2("550");
		param.setRegion("双流");
		param.setRoom1("0");
		param.setRoom2("5");
		param.setTime("4");
		param.setUseage("1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/customer/getVipRentViewedList"));
	}
}
