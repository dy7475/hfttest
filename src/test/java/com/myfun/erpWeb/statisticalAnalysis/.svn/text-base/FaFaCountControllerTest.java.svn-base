package com.myfun.erpWeb.statisticalAnalysis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class FaFaCountControllerTest extends BaseTestController {
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");	}

	/**
	 * 点击量按时间分析
	 * @author 熊刚
	 * dateCountType	0=日统计 2=月统计
	 * serchRange		搜索范围，COMP,AREA,REG,DEPT,GR,USER
	 * serchRangeId		搜索范围的值
	 * saleLease		出租出售 1=出售 2 =出租
	 * startTime		开始时间
	 * endTime			结束时间
	 * showType			显示类型（没用-前端要求返回的信息）
	 * dateTime			按天传递给的时间
	 * sort				排序1.desc 2.ASC
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountByTime() throws Exception {
		Map<String, Object> param =new HashMap<>();
//		param.put("serchRange", "COMP");
//		param.put("serchRangeId", "12001");
		param.put("startTime", "2017-05-26");
		param.put("endTime", "2017-07-26");
		param.put("dateCountType", "2");
		param.put("saleLease", "1");
//		param.put("countType", "MONTH");
	//	param.put("dateTime", "2017-07-26");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByTime"));
	}
	
	/**
	 * 点击量按时间分析(报表)
	 * @author 熊刚
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountByTimeReport() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2017-07-26");
		param.put("endTime", "2017-09-13");
		param.put("dateCountType", "2");
		param.put("saleLease", "1");
		param.put("countType", "MONTH");
		param.put("dateTime", "2017-07-26");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByTimeReport"));
	}
	
	/**
	 * 点击量按组织机构分析
	 * @author 熊刚
	 * @since 2017年7月14日
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 *saleLease		出租出售 1=出售 2 =出租
	 *startTime			开始时间
	 *endTime		结束时间
	 *showType		显示类型（没用-前端要求返回的信息）
	 *sort		排序1.desc 2.ASC
	 *serchRangeId	搜索范围ID
	 *dimension			维度，COMP,AREA,REG,DEPT,GROUP,USER
	 * @throws Exception
	 */
	@Test
	public void getClickCountByOrg() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2000-05-12");
		param.put("endTime", "2017-08-13");
		param.put("saleLease", "1");
		param.put("dimension", "REG");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByOrg"));
	}
	
	/**
	 * 点击量按组织机构分析(报表)
	 * @author 熊刚
	 * serchRange		搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 *startTime		开始时间
	 *endTime			结束时间
	 *saleLease			出租出售 1=出售 2 =出租
	 *sort			排序1.desc2.asc
	 *serchRangeId	搜索范围id
	 *dimension		维度COMP,AREA,REG,DEPT,GROUP,USER
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountByOrgReport() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "AREA");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2000-05-12");
		param.put("endTime", "2017-08-13");
		param.put("saleLease", "1");
		param.put("dimension", "DEPT");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByOrgReport"));
	}
	/**
	 * 点击量按网站
	 * @author 熊刚
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountBySite() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2017-07-12");
		param.put("endTime", "2017-07-27");
		param.put("dateCountType", "0");
		param.put("saleLease", "1");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountBySite"));
	}
	/**
	 * 点击按房源网站
	 * @author 熊刚
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountByHouse() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2010-07-26");
		param.put("endTime", "2017-08-13");
		param.put("dateCountType", "0");
		//param.put("saleLease","1");
		param.put("dimension","HOUSE_FITMENT");
		param.put("showType","showType");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByHouse"));
	}
	
	/**
	 * 点击按房源网站报表
	 * @author 熊刚HOUSE_ROOM户型图 (默认) HOUSE_REG行政区HOUSE_FITMENT装修类型 HOUSE_TYPE类型
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getClickCountByHouseReport() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2010-07-26");
		param.put("endTime", "2017-07-27");
		param.put("dateCountType", "0");
		//param.put("saleLease","1");
		param.put("dimension","HOUSE_FITMENT");
		param.put("showType","showType");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickCountByHouseReport"));
	}
	
	/**
	 * 站点统计  报表/图表
	 * @author 何传强
	 * @since 2017年7月13日
	 * @throws Exception
	 */
	@Test
	public void getSiteTableOrChartCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("cityId", "1");
		param.put("countType", "USER");//USER,SITE
		param.put("saleLease", "0");
		param.put("showType", "CHART");
		param.put("serchRange", "USER");
		//param.put("userId", 20026576);
		param.put("serchRangeId", "20026576");
		param.put("startTime", "2017-07-01");
		param.put("endTime", "2017-07-25");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getSiteTableOrChartCount"));
	}
	/**
	 * 获取各站点房源发布量统计
	 * @author 何传强
	 * @since 2017年7月13日
	 * @throws Exception
	 */
	@Test
	public void getEachSiteHousePushCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("cityId", "1");
		param.put("areaId", "12001");
		param.put("countType", "USER");
		param.put("dimension", "1");//数据维度 1=出售,2=出租," "=全部
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("startTime", "2017-07-10");
		param.put("endTime", "2017-07-14");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getEachSiteHousePushCount"));
	}
	/**
	 * 异常分析  人员/站点-报表
	 * @author 何传强
	 * @since 2017年7月13日
	 * @throws Exception
	 */
	@Test
	public void getPushExpectionCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("compId", "12001");
		param.put("countType", "USER");
		param.put("startTime", "2017-06-01");
		param.put("endTime", "2017-07-26");
		param.put("sort", "DESC");
		//param.put("showType", "CHART");
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("userId", "20319578");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getPushExpectionCount"));
	}
	/**
	 * 异常次数异常类型统计
	 * @author 何传强 
	 * @since 2017年7月17日
	 * @throws Exception
	 */
	@Test
	public void getExpectionCountStatistic() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("compId", "12001");
		param.put("dimension", "REG");
		param.put("startTime", "2017-07-10");
		param.put("sendTime", "2017-07-14");
		param.put("sort", "DESC");
		param.put("showType", "CHART");
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getExpectionCountStatistic"));
	}
	/**
	 * 异常次数人员统计
	 * @author 何传强
	 * @since 2017年7月18日
	 * @throws Exception
	 */
	@Test
	public void getExpectionCountByUser() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("compId", "12001");
		param.put("dimension", "REG");
		param.put("startTime", "2017-07-10");
		param.put("sendTime", "2017-07-14");
		param.put("sort", "DESC");
		param.put("showType", "CHART");
		param.put("serchRange", "DEPT");
		param.put("serchRangeId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getExpectionCountByUser"));
	}
	/**
	 * 首页点击量排名统计
	 * @author 何传强
	 * @since 2017年7月13日
	 * @throws Exception
	 */
	@Test
	public void getClickedRankCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("compId", "12001");
		param.put("dimension", "USER");
		param.put("startTime", "2016-07-01");
		param.put("endTime", "2017-08-10");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getClickedRankCount"));
	}
	/**
	 * 综合统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getFafaComprehensiveStatistic() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dimension", "USER");//组织维度AREA,REG,DEPT,GR,USER
		param.put("showType", "TABLE");
		param.put("userId", 20026576);
//		param.put("serchRange", "TABLE");
//		param.put("serchRangeId", "20321077");
		param.put("compId", "12001");
		param.put("startTime", "2016-05-01");
		param.put("endTime", "2017-07-26");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getFafaComprehensiveStatistic"));
	}
	/**
	 * 房源发布总量和人员统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @throws Exception
	 */
	@Test
	public void getHousePushCountAndUsersCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("compId", "12001");
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/fafaCount/getHousePushCountAndUsersCount"));
	}
}
