package com.myfun.erpWeb.businesstools.renovation;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.RenovationCustomerParam;

public class RenovationCustomerControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	/**
	 * 登记装修信息
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void addRenovationCustomer() throws Exception{
		RenovationCustomerParam param = new RenovationCustomerParam();
		param.setCustLevel((byte)1);
		param.setUserId(20319440);
		param.setCustVisit((byte)1);
		param.setCustStatus((byte)2);
		param.setBuildName("兰雪松专用楼盘");
		param.setHouseRoof("二");
		param.setHouseFloor("二");
		param.setHouseUnit("二");
		param.setHouseRoom((byte)2);
		param.setHouseHall((byte)2);
		param.setHouseWei((byte)2);
		param.setHouseUseage((byte)2);
		param.setHouseArea(new BigDecimal(130));
		param.setHouseInnerarea(new BigDecimal(120));
		param.setIntentPriceLow(new BigDecimal(60));
		param.setIntentPriceHigh(new BigDecimal(80));
		param.setLastTrackContent("兰雪松测试数据1");
		param.setLastTrackUid(20319440);
		System.out.println(postNewErp(param,"renovation/addRenovationCustomer"));
	}

	/**
	 * 查询装修列表信息
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void updateRenovationCustomer() throws Exception{
		RenovationCustomerParam param = new RenovationCustomerParam();
		param.setId(3);
		param.setCustLevel((byte)1);
		param.setUserId(20319440);
		param.setCustVisit((byte)1);
		param.setCustStatus((byte)2);
		param.setBuildName("兰雪松专用楼盘");
		param.setHouseRoof("二");
		param.setHouseFloor("二");
		param.setHouseUnit("二");
		param.setHouseRoom((byte)2);
		param.setHouseHall((byte)2);
		param.setHouseWei((byte)2);
		param.setHouseUseage((byte)2);
		param.setHouseArea(new BigDecimal(130));
		param.setHouseInnerarea(new BigDecimal(120));
		param.setIntentPriceLow(new BigDecimal(60));
		param.setIntentPriceHigh(new BigDecimal(80));
		param.setLastTrackContent("兰雪松测试数据1");
		param.setLastTrackUid(20319440);
		param.setLastTrackTime(new Date());
		System.out.println(postNewErp(param,"renovation/updateRenovationCustomer"));
	}
	
	/**
	 * 查询装修列表信息
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void getRenovationCustomerList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("houseUseage", 2);
		param.setInteger("custStatus", 2);
		param.setString("intentPricelow", "70");
		param.setString("intentPricehigh", "75");
		System.out.println(postNewErp(param,"renovation/getRenovationCustomerList"));
	}
	
	/**
	 * 查询装修单个详细信息
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void getRenovationCustomer() throws Exception{
		RenovationCustomerParam param = new RenovationCustomerParam();
		param.setId(3);
		System.out.println(postNewErp(param,"renovation/getRenovationCustomer"));
	}
}
