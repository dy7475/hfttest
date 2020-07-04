package com.myfun.erpWeb.soso.house;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.service.business.searchdb.bean.param.SoSoConverDetectParam;
import com.myfun.service.business.searchdb.bean.param.SoSoConvertRegisterParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 张宏利
 * @since 2016-9-21
 */
public class SoSoHouseControllerTest extends BaseTestController{
	
	@Before
	public void init() throws Exception{
	//	init("http://192.168.0.249:8080/erpWeb", "http://192.168.0.249/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		init("http://192.168.5.175:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");

	}
	/**
	 * 设置搜搜查看记录的专属电话
	 * @author 张宏利
	 * "sosoId", "sosoType", "exclusiveMobile"
	 * @since 2017年7月19日
	 * @throws Exception
	 */
	@Test
	public void updateExclusiveMobile() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setString("sosoId", "1010860626");
		param.setString("sosoType", "0");
		param.setString("exclusiveMobile", "15646194562|16349542684");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/updateExclusiveMobile"));
	}
	
	/**
	 * 获取搜搜图片列表
	 * @author 张宏利
	 * @param CASE_ID 房源ID、CASE_TYPE 房源类型
	 * @since 2016年8月18日
	 * @return
	 * @throws Exception 
	 */
	@Test//(value="/getSOSOPhotoList")
	public void getSOSOPhotoList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setString("caseId", "12001");
		param.setString("caseType", "1");
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOPhotoList"));
	}
	
	/**
	 * 
	 * @author 张宏利
	 * @since 2016年8月29日
	 * @param param
	 * @return
	 */
	@Test//(value="/getSoSoSaleList")
	public void getSoSoSaleList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
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
		//param.setFilterFlag("1");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSoSoSaleList"));
	}
	
	/**
	 * 获取搜搜出租列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@Test//(value="/getSOSOLeaseList")
	public void getSOSOLeaseList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOLeaseList"));
	}
	
	/**
	 * 获取搜搜转铺列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@Test//(value="/getSOSOShopList")
	public void getSOSOShopList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		param.setRegion("郫县");
		param.setTime("4");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOShopList"));
	}
	
	/**
	 * 获取搜搜合租列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@Test//(value="/getSOSOHezuList")
	public void getSOSOHezuList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
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
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOHezuList"));
	}
	
	/**
	 * 获取搜搜出租详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOLeaseDataById")
	public void getSOSOLeaseDataById() throws Exception{
		SoSoSaleDataInfoParam param = new SoSoSaleDataInfoParam();
		param.setSosoId(1340080538);
		param.setTime("2016-09-29 01:11:37");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOLeaseDataById"));
	}
	
	/**
	 * 获取搜搜出售详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSaleInDataInfoById")
	public void getSaleInDataInfoById() throws Exception{
		SoSoSaleDataInfoParam param = new SoSoSaleDataInfoParam();
		param.setSosoId(1010922412);
		param.setTime("2016-09-10 17:58:20");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSaleInDataInfoById"));
	}
	
	/**
	 * 获取搜搜转铺详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getShopDataInfoById")
	public void getShopDataInfoById() throws Exception{
		SoSoSaleDataInfoParam param = new SoSoSaleDataInfoParam();
		param.setSosoId(1010962971);
		param.setTime("2016-09-09 11:00:10");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getShopDataInfoById"));
	}
	
	/**
	 * 获取搜搜合租详细信息
	 * @author 张宏利
	 * @since 2016年8月25日
	 * @param param
	 * @return
	 */
	@Test//(value="/getSOSOHezuSmpInfo")
	public void getSOSOHezuSmpInfo() throws Exception{
		SoSoSaleDataInfoParam param = new SoSoSaleDataInfoParam();
		param.setSosoId(1010922412);
		param.setTime("2016-09-08 22:34:13");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOHezuSmpInfo"));
	}
	
	/**
	 * 获取搜搜查看条数
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewCount")
	public void getSOSOViewCountController() throws Exception{
		BaseMapParam param = new BaseMapParam();
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOViewCount"));
	}
	
	/**
	 * 获取搜搜电话
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 * @throws Exception 
	 */
	@Test//(value="/getSOSOConvertDetectData")
	public void getSOSOConvertDetectData() throws Exception{
		SoSoConverDetectParam param = new SoSoConverDetectParam();
		param.setSosoId(1594870215);
		//param.setRepeatId(1011097397);
		param.setSosoType(0);
		param.setType("1");
		param.setInTime("2019-02-27 17:00:00");
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOConvertDetectData"));
	}
	
	/**
	 * 获取搜搜已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewedSaleList")
	public void getSOSOViewedSaleList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOViewedSaleList"));
	}
	
	/**
	 * 获取搜搜出租已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewedLeaseList")
	public void getSOSOViewedLeaseList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOViewedLeaseList"));
	}
	
	/**
	 * 获取搜搜转铺已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewedShopList")
	public void getSOSOViewedShopList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOViewedShopList"));
	}
	
	/**
	 * 获取搜搜合租已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewedHeZuList")
	public void getSOSOViewedHeZuList() throws Exception{
		SoSoSaleListParam param = new SoSoSaleListParam();
		param.setPageOffset(1);
		param.setPageRows(10);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSOSOViewedHeZuList"));
	}
	

	/**
	 * 获取搜搜出售重复房源列表
	 * @author 熊刚
	 * @since 2016年8月19日
	 * @return
	 */
	@Test//(value="/getSOSOViewedHeZuList")
	public void getSaleInRepeatById() throws Exception{
		SoSoSaleDataInfoParam param = new SoSoSaleDataInfoParam();
		param.setSosoId(1010922412);
		param.setTime("2016-09-09 11:00:10");
		param.setRepeatId(1);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getSaleInRepeatById"));
	}



	/**
	 * @tag 标记搜搜出售房源
	 * @author 邓永洪
	 * @since 2018/5/3
	 */
	@Test
	public void complaintSoSoSale() throws Exception {
		/*
		* {"CLIENTKEY":"22c601474634eb103dde575ffdb2725f","complaintType":"3","repeatId":"1545052755","sosoId":"1545052790","time":"2018-06-19 07:13:36"}
		* {"CLIENTKEY":"acc5aacab97be1f780496194e622860a","complaintType":"2","repeatId":"1551299142","sosoId":"1551299142","time":"2018-07-06 15:13:54"}
		* */
		Map<String,Object> param=new HashMap<>();
//		param.put("time","2018-06-19 07:13:36");
////		param.put("sosoId","1545052790");
////		param.put("complaintType","3");
////		param.put("repeatId",1545052755);
//		param.put("time","2018-06-19 07:13:36");
//		param.put("sosoId","1532520193");
//		param.put("complaintType","2");
//		param.put("repeatId",1532520193);

		System.out.println("返回值：\n"+postNewErp(param,"soso/house/complaintSoSoSale"));
	}
	
	@Test
	public void getConvertOrRegisterList() throws Exception {
		SoSoConvertRegisterParam param = new SoSoConvertRegisterParam();
		param.setSosoType(1);
		param.setPhone("18782448043");
//		param.setSosoId(1549725925);
		System.out.println("返回值：\n"+postNewErp(param,"soso/house/getConvertOrRegisterList"));
	}

	@Test
	public void getSelfManageRange() throws Exception {
		BaseMapParam param = new BaseMapParam();
		System.out.println("返回值：\n"+postNewErp(param,"/common/getSelfManageRange"));
	}
}


