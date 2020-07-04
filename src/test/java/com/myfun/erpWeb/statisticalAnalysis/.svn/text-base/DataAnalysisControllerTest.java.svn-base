package com.myfun.erpWeb.statisticalAnalysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class DataAnalysisControllerTest extends BaseTestController {

	@Before
	public void init(){
//		init("http://192.168.0.42:8080/erpWeb", "http://192.168.0.42:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.0.249:8080/erpWeb", "http://192.168.0.249/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");	}

	
	
	/**
	 * 房客源新增分析
	 * @author 张宏利
	 * @since 2017年7月15日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustAddCountData() throws Exception{
		Arrays.asList("ROOM").forEach(queryDim -> {
		//房源	
		//Arrays.asList("REG", "ROOM", "USEAGE", "SOURCE", "USER", "SECTION","PRICE","AREA").forEach(queryDim -> {
		//客源
//		Arrays.asList("USER", "SECTION","PRICE","AREA").forEach(queryDim -> {
			try {
				Map<String, Object> param =new HashMap<>();
				param.put("startTime", "2017-01-01");
				param.put("endTime", "2017-07-13");
				param.put("serchRange", "COMP");//DEPT,GROUP,COMP
				param.put("serchRangeId", "12001");
				param.put("queryDim", queryDim);// REG ROOM USEAGE SOURCE USER SECTION PRICE AREA
				param.put("caseType", "101");//101=买卖业务;102=租赁业务
				//param.put("caseType", "102");
				param.put("dateCountType", "2");
				param.put("isChart", "1");// 是否是图表
				System.err.println(postNewErp(param, "/statisticalAnalysis/dataAnalysis/getHouseCustAddCountData"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * 房客源新增分析(报表)
	 * @author 臧铁
	 * @since 2017年7月26日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustAddCountDataForReport() throws Exception{
		Arrays.asList("AREA").forEach(queryDim -> {
			//房源	
			//Arrays.asList("REG", "ROOM", "USEAGE", "SOURCE", "USER", "SECTION","PRICE","AREA").forEach(queryDim -> {
			//客源
			//Arrays.asList("USER", "SECTION","PRICE","AREA").forEach(queryDim -> {
			try {
				Map<String, Object> param =new HashMap<>();
				param.put("startTime", "2017-07-01");
				param.put("endTime", "2017-07-13");
				param.put("serchRange", "COMP");//DEPT,GROUP,COMP
				param.put("serchRangeId", "12001");
				param.put("queryDim", queryDim);// REG ROOM USEAGE SOURCE USER SECTION PRICE AREA
				param.put("caseType", "101");//1=买卖业务;2=租赁业务
				//param.put("caseType", "2");
				param.put("dateCountType", "2");
				param.put("order", "2");
				System.err.println(postNewErp(param, "/statisticalAnalysis/dataAnalysis/getHouseCustAddCountDataForReport"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * 房客源存量分析--按各维度进行统计
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * queryDim		统计维度，STATUS=状态 PRICE=价格 AREA=面积 ROOM=户型 REG=行政区 SECTION=商圈  USEAGE=用途 BELONG=所属
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * regionId		行政区域ID，只能一个
	 * sectionId	商圈ID，只能一个
	 * caseType		数据类型：101=买卖，102=租赁
	 * isChart		是否是图表：1=是
	 * dimension	维度 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getStoreDataAnalysis() throws Exception{
		//{serchRangeId=12001, statusType=1, queryDim=BELONG, regionId=11, dimension=USER, serchRange=AREA, CLIENTKEY=fd0703497efa099ef30459f6ac8b1132, caseType=101}
		Arrays.asList("REG").forEach(dimension -> {
//		Arrays.asList("AREA","REG","DEPT","GROUP","USER").forEach(dimension -> {
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("serchRangeId", 12001);
			pMap.put("statusType", 1);
			pMap.put("queryDim", "BELONG");
			pMap.put("regionId", 11);
			pMap.put("dimension", "USER");
			pMap.put("userId", 2021);
			try {
				System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysis"));
			} catch (Exception e) {}
		});
	}
	
//	/**
//	 * 房客源存量分析--人均拥有量排名
//	 * @author 张宏利
//	 * @since 2017年7月28日
//	 * @param param
//	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
//	 * serchRangeId	搜索范围Id
//	 * statusType	数据类型：1=有效数据 2=全部数据
//	 * caseType		数据类型：101=买卖，102=租赁
//	 * dimension	维度 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
//	 * @return
//	 */
//	@Test
//	public void getHouseCustPerCapitaCount() throws Exception{
////		Arrays.asList("AREA","REG","DEPT","GROUP","USER").forEach(dimension -> {
//		Arrays.asList("DEPT").forEach(dimension -> {
//			Map<String, Object> pMap = new HashMap<>();
//			pMap.put("caseType", "101");
//			pMap.put("serchRange", "DEPT");
//			pMap.put("serchRangeId", "12001");
//			pMap.put("dimension", dimension);
//			try {
//				System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustPerCapitaCount"));
//			} catch (Exception e) {}
//		});
//	}
	
	/**
	 * 房客源存量分析--统计房客源存量
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getStoreDataCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("queryDim", "REG");
		pMap.put("serchRange", "DEPT");
		pMap.put("serchRangeId", "12001");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataCount"));
	}
	
	/**
	 * 房客源存量分析--房客源带看、房堪分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * regionId		行政区域ID，只能一个
	 * sectionId	商圈ID，只能一个
	 * @return
	 */
	@Test
	public void getStoreDataDaiKan() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "DEPT");
		pMap.put("serchRangeId", "12001");
		pMap.put("regionId", "40143");
		pMap.put("sectionId", "139");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataDaiKan"));
	}
	
	/**
	 * 房客源存量分析--按价格-面积、户型、行政区分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度， AREA=面积 ROOM=户型 REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@Test
	public void getStoreDataAnalysisByPrice() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("queryDim", "REG");
//		pMap.put("regionId", "40143");
//		pMap.put("sectionId", "139");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByPrice"));
	}
	
	/**
	 * 按面积对-价格 户型 行政区 的分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度， PRICE=价格 ROOM=户型 REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@Test
	public void getStoreDataAnalysisByArea() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("queryDim", "ROOM");
//		pMap.put("regionId", "40143");
//		pMap.put("sectionId", "139");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByArea"));
	}
	
	/**
	 * 房客源存量分析--按户型-房价、面积、行政区分析
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * queryDim		统计维度， PRICE=价格 AREA=面积  REG=行政区
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@Test
	public void getStoreDataAnalysisByRoom() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("queryDim", "PRICE");
//		pMap.put("regionId", "40143");
//		pMap.put("sectionId", "139");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByRoom"));
	}
	
	/**
	 * 房客源存量分析--按用途-住宅商铺写字供需对比
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * useage		1=住宅  2=商铺 3=写字
	 * @return
	 */
	@Test
	public void getStoreDataAnalysisByUseage() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("useage", "1");
		pMap.put("statusType", "1");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByUseage"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByUseage"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataAnalysisByUseage"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		Thread.currentThread().sleep(Integer.MAX_VALUE);
	}
	
	/**
	 * 房客源存量分析--房客源基本情况
	 * @author 臧铁
	 * @since 2017年7月28日
	 * @param param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * @return
	 */
	@Test
	public void getHouseCustBasicStatus() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustBasicStatus"));
	}
	
	/**
	 * 房客源存量分析--房客源存量排名
	 * @author 张宏利
	 * @since 2017-07-14
	 * @param
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * statusType	数据类型：1=有效数据 2=全部数据
	 * caseType		数据类型：101=买卖，102=租赁
	 * rankType		排名类型：1=员工排名，2=门店排名
	 * @return
	 */
	@Test
	public void getStoreDataRanking() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("rankType", "2");
		pMap.put("statusType", "1");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getStoreDataRanking"));
	}

	/**
	 * 房，客源流转统计表（图表）
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param param  caseType  房客源类型           countDate  统计时间            searchDimension  类型  NEW=当月  OLD=历史
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getHouseCustFlowAnalysisCountList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("startTime", "2017-01");
		pMap.put("endTime", "2017-07");
		pMap.put("searchDimension", "NEW");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustFlowAnalysisCountList"));
	}
	
	/**
	 * 房，客源流转统计表(报表)
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param param  caseType  房客源类型           countDate  统计时间            searchDimension  类型  NEW=当月  OLD=历史
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getHouseCustFlowAnalysisCountListForReport() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "102");
		pMap.put("startTime", "2017-01");
		pMap.put("endTime", "2017-07");
		pMap.put("searchDimension", "NEW");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustFlowAnalysisCountListForReport"));
	}
	
	/**
	 * 获取房源底部统计信息（暂时无用）
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @throws Exception
	 */
	@Test
	public void getHouseBottomInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "1");
		pMap.put("dataType", "STATUS");
		pMap.put("dimension", "COMP");
		pMap.put("serchRange", "DEPT");
		pMap.put("serchRangeId", "12001");
		pMap.put("showType", "CHART");
		pMap.put("status", "");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseBottomInfo"));
	}
	
	/**
	 * 数据分析首页-房客源数据
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustStatusData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "102");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustStatusData"));
	}
	
	/**
	 * 数据分析首页-楼盘供需量对比-热点楼盘客户、房源排名|热点商圈客户、房源排名
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @throws Exception
	 */
	@Test
	public void getBuildSupplyDemandComparison() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "102");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		pMap.put("statusType", "2");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getBuildSupplyDemandComparison"));
	}
	
	/**
	 * 数据分析首页-房价购买力分析
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @throws Exception
	 */
	@Test
	public void getHouseBuyingPowerData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "102");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseBuyingPowerData"));
	}
	
	/**
	 * 房客源新增分析-房客源新增总量 
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustAddTotalData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "101");
		pMap.put("startTime", "2016-08");
		pMap.put("endTime", "2017-02");
		pMap.put("serchRange", "DEPT");
		pMap.put("serchRangeId", "12001");
		pMap.put("dateCountType", "2");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustAddTotalData"));
	}
	
	/**
	 * 房客源新增分析-房客源新增量排名
	 * @author 臧铁
	 * @since 2017年7月25日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustAddRank() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseType", "102");
		pMap.put("order", "2");
		pMap.put("startTime", "2016-08-01");
		pMap.put("endTime", "2017-02-02");
		pMap.put("serchRange", "COMP");
		pMap.put("serchRangeId", "12001");
		System.out.println(postNewErp(pMap,"/statisticalAnalysis/dataAnalysis/getHouseCustAddRank"));
	}
}
