package com.myfun.erpWeb.statisticalAnalysis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class WorkCountControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.42:8080/erpWeb", "http://192.168.0.42:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		//init("http://192.168.5.174:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
		init("http://192.168.200.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 工作量统计
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @throws Exception
	 */
	@Test
	public void getWorkCountIpLogList() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("statisticType", "1");
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		param.put("caseType", "1");
		param.put("startTime", "2011-07-01");
		param.put("endTime", "2017-07-26");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountIpLogList"));
	}
	
	/**
	 * 工作量统计
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @throws Exception
	 */
	@Test
	public void getWorkCountCounts() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("statisticType", "1");
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2017-07-01");
		param.put("endTime", "2017-07-26");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountCounts"));
	}
	
	/**
	 * 工作量统计
	 * @author 何传强
	 * @since 2017年7月28日
	 * @throws Exception
	 */
	@Test
	public void getWorkCountStatistics() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dimension", "DEPT");//组织维度AREA,REG,DEPT,GROUP,USER
		param.put("serchRange", "COMP");
	//	param.put("serchRangeId", "12001");
	//	param.put("userId", "10089643");
	//	param.put("caseType", "102");//101,102,1,2,3,4
		param.put("order", "1");
		param.put("startTime", "2018-05-01");
		param.put("endTime", "2018-05-09");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountStatistics"));
	}

	/**
	 * 获取工作量排名
	 * dimension	组织维度,AREA,REG,DEPT,GROUP,USER
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * caseType		数据类型：1=买卖，2=租赁
	 * startTime	起始时间
	 * endTime		结束时间
	 * orderBy		排序，DESC=最多,ASC=最少
	 * @author 张宏利
	 * @since 2017年7月31日
	 * @param param
	 * @return
	 */
	@Test
	public void getWorkCountRanking() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dimension", "USER");//组织维度AREA,REG,DEPT,GROUP,USER
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		param.put("caseType", "2");//HOUSE,CUST,101,102
		param.put("startTime", "2017-07-01");
		param.put("endTime", "2017-07-26");
		param.put("orderBy", "DESC");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountRanking"));
	}
	
	/**
	 * 获取工作量详情列表
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param
	 * countName 工作量的名字（djCount..）
	 * serchRange 	查询范围
	 * dateRange 日期范围（年-月-日~年-月-日）
	 * serchRangeId 	查询范围ID
	 * caseType 信息类型（1、2、3、4）
	 * deptId 门店ID
	 * @throws Exception
	 */
	@Test
	public void getWorkCountDetailList() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("countName", "djCount");
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		param.put("caseType", "4");
		param.put("startTime", "2017-05-01");
		param.put("endTime", "2017-07-26");
		param.put("deptId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountDetailList"));
	}
	
	/**
	 * 获取工作量跟进日志
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param
	 * countName 工作量的名字（djCount..）
	 * serchRange 	查询范围
	 * dateRange 日期范围（年-月-日~年-月-日）
	 * serchRangeId 	查询范围ID
	 * caseType 信息类型（1、2、3、4）
	 * deptId 门店ID
	 * @throws Exception
	 */
	@Test
	public void getWorkCountTrackList() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("countName", "fkCount");//djCount
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		param.put("caseType", "1");
		param.put("startTime", "2017-05-01");
		param.put("endTime", "2017-07-26");
		param.put("deptId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getWorkCountTrackList"));
	}
	/**
	 * 获取工作量总量排名
	 * @author flj
	 * @since 2017年8月24日
	 * @param
	 * countName 工作量的名字（djCount..）
	 * serchRange 	查询范围
	 * dateRange 日期范围（年-月-日~年-月-日）
	 * serchRangeId 	查询范围ID
	 * caseType 信息类型（1、2、3、4）
	 * deptId 门店ID
	 * @throws Exception
	 */
	@Test
	public void getTotalWorkCountRanking() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("dimension", "USER");
		System.err.println(postNewErp(param, "/statisticalAnalysis/workCount/getTotalWorkCountRanking"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/11
	 * @tag 获取当年应收业绩排名
	 */
	@Test
	public void getThisYearProfitTrend() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange","COMP");
		param.put("dimension","DEPT");
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getThisYearProfitTrend"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/11
	 * @tag 获取最近半年业绩走势
	 */
	@Test
	public void getHalfProfitTrend() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getHalfProfitTrend"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/11
	 * @tag 获取门店/员工房客源新增排名和本门店/本人新增数量
	 */
	@Test
	public void getHouseCustRanking() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		param.put("dimension","DEPT");
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getHouseCustRanking"));
	}

	/**
	 * 有效房源统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	@Test
	public void getMyHouseStatisticsInfo() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getMyHouseStatisticsInfo"));
	}

	/**
	 * 获取业绩龙虎榜饼图数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	@Test
	public void getFunProfitCountChart() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		param.put("dateType","SIGN_DATE");
		param.put("dimension","DEPT");
		param.put("endTime","2018-05-30");
		param.put("pfActusl",1);
		param.put("showType","CHART");
		param.put("startTime","2018-05-01");
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getFunProfitCountChart"));
	}

	/**
	 * 获取业绩龙虎榜的成交价格分布
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	@Test
	public void getCompTransactionDistribution() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		param.put("dateType","SIGN_DATE");
		param.put("dimension","DEPT");
		param.put("endTime","2018-05-30");
		param.put("pfActusl",1);
		param.put("showType","CHART");
		param.put("startTime","2018-05-01");
		param.put("caseType",101);
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getCompTransactionDistribution"));
	}

	/**
	 *  获取业绩龙虎榜统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	@Test
	public void getProfitRankingStatistics() throws Exception {
		/*
{"CLIENTKEY":"21b77a1ef0e91c66aa197aebbf3f2473","DATE_TYPE":"SIGN_DATE","DIMENSION":"USER","END_TIME":"2018-06-21","PF_ACTUAL":"0","SERCH_RANGE":"AREA","SERCH_RANGE_ID":"12001","SHOW_TYPE":"HOME","START_TIME":"2018-06-01"}
{"CLIENTKEY":"21b77a1ef0e91c66aa197aebbf3f2473","DATE_TYPE":"SIGN_DATE","DIMENSION":"GROUP","END_TIME":"2018-06-21","PF_ACTUAL":"0","SERCH_RANGE":"AREA","SERCH_RANGE_ID":"12001","SHOW_TYPE":"HOME","START_TIME":"2018-06-01"}
{"CLIENTKEY":"21b77a1ef0e91c66aa197aebbf3f2473","DATE_TYPE":"SIGN_DATE","DIMENSION":"DEPT","END_TIME":"2018-06-21","PF_ACTUAL":"0","SERCH_RANGE":"AREA","SERCH_RANGE_ID":"12001","SHOW_TYPE":"HOME","START_TIME":"2018-06-01"}
{"CLIENTKEY":"21b77a1ef0e91c66aa197aebbf3f2473","DATE_TYPE":"SIGN_DATE","DIMENSION":"REG","END_TIME":"2018-06-21","PF_ACTUAL":"0","SERCH_RANGE":"AREA","SERCH_RANGE_ID":"12001","SHOW_TYPE":"HOME","START_TIME":"2018-06-01"}
{"CLIENTKEY":"21b77a1ef0e91c66aa197aebbf3f2473","DATE_TYPE":"SIGN_DATE","DIMENSION":"AREA","END_TIME":"2018-06-21","PF_ACTUAL":"0","SERCH_RANGE":"COMP","SHOW_TYPE":"HOME","START_TIME":"2018-06-01"}
* */
		Map<String, Object> param =new HashMap<>();
		//param.put("serchRangeId","12001");
		param.put("serchRange","COMP");
		param.put("dateType","SIGN_DATE");
		param.put("dimension","AREA");
		param.put("endTime","2018-06-21");
		param.put("pfActual",0);//
		param.put("showType","HOME");
		param.put("startTime","2018-06-01");
//		param.put("caseType",101);
//		param.put("dataType",1);
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getProfitRankingStatistics"));
	}

	/**
	 * 获取业绩分析
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/4
	 */
	@Test
	public void getProfitAnalyse() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange","COMP");
		param.put("dateType","SIGN_DATE");
		param.put("dataType",2);
		param.put("endTime","2018-06");
		param.put("pfActual",1);//
		param.put("startTime","2018-01");
		param.put("dateRange","MONTH");

		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getProfitAnalyse"));
	}

	/**
	 * 房源成交统计分析
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/5
	 */
	@Test
	public void getHouseInnerDealAnalysisCountList() throws Exception {
		/*
		{"CASE_TYPE":"101","CLIENTKEY":"7290e8818e3e383e5a440a5091eb6794","DATE_TYPE":"SIGN_DATE","END_TIME":"2018-06","SERCH_RANGE":"COMP","SERCH_RANGE_ID":"","START_TIME":"2018-01"}
		* */
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange","COMP");
		param.put("caseType",101);
		param.put("dateType","SIGN_DATE");
		param.put("endTime","2018-06");
		param.put("startTime","2018-01");
		param.put("serchRangeId","");

		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getHouseInnerDealAnalysisCountList"));
	}

	/**
	 * 最近一周工作情况
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/7
	 */
	@Test
	public void getUserMonthWorkCore() throws Exception {
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param, "/statisticalAnalysis/workCount/getUserMonthWorkCore"));
	}
}
