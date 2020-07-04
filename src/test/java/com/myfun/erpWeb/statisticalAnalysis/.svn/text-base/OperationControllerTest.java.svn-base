package com.myfun.erpWeb.statisticalAnalysis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

import io.swagger.annotations.ApiModelProperty;

public class OperationControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.183:8001/erpWeb", "http://192.168.0.42:80/hftWebService/web/api/authentication/per.do", "37", "13980047326");
		//init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
//		init("http://192.168.0.249:8080/erpWeb", "http://192.168.0.249:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		init("http://192.168.200.101:8068/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/per.do", "673777", "18681660716");
	}
	/**
	 * 公司运营基本情况对比统计
	 * @author 熊刚
	 * serchRange 搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 *serchRangeId	搜索id
	 *caseType	数据类型：1=买卖业务（默认），2=租赁业务
	 *dimension 纬度 AREA 大区 REG 片区 DEPT 门店 GROUP 分组 USER 员工
	 *startTime	开始时间
	 *endTime		结束时间
	 *dateType	0=日统计 1= 周统计 2=月统计
	 * @since 2017年7月28日
	 * @throws Exception
	 */
	@Test
	public void getOperationsAndProfitCountOffReport() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("serchRange", "USER");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("userId", "10086823");
		paramMap.put("caseType", "102");
		paramMap.put("startTime", "2017-01-01");
		paramMap.put("endTime", "2018-12-12");
		paramMap.put("dimension", "GROUP");
		paramMap.put("dateType", "1");
		System.out.println(postNewErp(paramMap,"statistic/getOperationsAndProfitCountOffReport"));
	}
	/**
	 * 公司运营基本情况对比统计
	 * @author 熊刚
	 * @since 2017年7月28日
	 * @throws Exception
	 */
	@Test
	public void getBasicDetails() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-12");
		paramMap.put("endTime", "2017-07-12");
		paramMap.put("serchRange", "USER");
		paramMap.put("serchRangeId", "20319389");

		System.out.println(postNewErp(paramMap,"statistic/getBasicDetails"));
	}
	/**
	 * 员工或门店排名
	 * @throws Exception
	 */
	@Test
	public void getProfitCountOffUser() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-12");
		paramMap.put("endTime", "2017-07-12");
		paramMap.put("serchRange", "AREA");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("dimension", "DEPT");
		System.out.println(postNewErp(paramMap,"statistic/getProfitCountOffUser"));
	}
	/**
	 * 转化率分析图表-转化率走势分析
	 * @author 何传强
	 * @since 2017年7月25日
	 * @throws Exception
	 */
	@Test
	public void getConversionRatioAnalysisOffCouvert() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-05-01");
		paramMap.put("endTime", "2017-08-01");
		paramMap.put("serchRange", "DEPT");
		paramMap.put("serchRangeId", "12001");
		//paramMap.put("userId", "1");
		paramMap.put("caseType", "102");//1=买卖业务,2=租赁业务," "=全部
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getConversionRatioAnalysisOffCouvert"));
	}
	
	/**
	 * 带看量排名
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getConversionRatioAnalysisOffDkan() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2016-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("serchRange", "AREA");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("caseType", "102");// 1=出售 2= 出租 3=求购 4=求租
		paramMap.put("dimension", "USER");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getConversionRatioAnalysisOffDkan"));
	}
	
	/**
	 * 带看量排名
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getConversionRatioAnalysisOffVariousParts() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("serchRange", "AREA");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("caseType", "102");//1=出售,2=出租
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getConversionRatioAnalysisOffVariousParts"));
	}
	
	/**
	 * 运营数据分析
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getOperationalDataAnalysisSaleChart() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2018-06-18 00:00:00");
		paramMap.put("endTime", "2018-07-14 23:59:59");
		paramMap.put("serchRange", "COMP");
		//paramMap.put("serchRangeId", "2001");
		//paramMap.put("caseType", "102");//1=出售,2=出租
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getOperationalDataAnalysisSaleChart"));
	}
	
	/**
	 * 运营数据分析
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getPerformanceMarketingAnalysis() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		System.err.println(postNewErp(paramMap,"statistic/getPerformanceMarketingAnalysis"));
	}
	
	/**
	 * 运营数据分析
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getOperationalDataAnalysisLeaseChart() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("serchRange", "AREA");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("caseType", "102");//1=出售,2=出租
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getOperationalDataAnalysisLeaseChart"));
	}
	
	/**
	 * 运营数据分析-报表
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getOperationalDataAnalysisReport() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("serchRange", "AREA");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("caseType", "102");//1=出售,2=出租
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getOperationalDataAnalysisReport"));
	}
	/**
	 * 运营数据分析-饼图
	 * @author flj
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getOperationalDataAnalysisSalePie() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("serchRange", "USER");
		paramMap.put("serchRangeId", "2001");
		paramMap.put("caseType", "102");//1=出售,2=出租
		paramMap.put("dateType", "1");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getOperationalDataAnalysisSalePie"));
	}
	

	
	/**
	 * 转化率分析报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getConversionRatioAnalysisOffReport() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2017-07-26");//日统计,周统计
		paramMap.put("endTime", "2017-08-14");
		paramMap.put("userId", "20321077");
//		paramMap.put("startTime", "2017-03");//月统计
//		paramMap.put("endTime", "2017-07");
		paramMap.put("dimension", "USER");//组织维度AREA,REG,DEPT,GROUP,USER
		paramMap.put("serchRange", "COMP");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("caseType", "102");//1=买卖业务,2=租赁业务," "=全部
		paramMap.put("dateType", "0");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getConversionRatioAnalysisOffReport"));
	}
	
	/**
	 * 运营分析与业绩分析-图表
	 * @author 
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void getOperationsAndProfitCountOffChart() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startTime", "2010-06-01");
		paramMap.put("endTime", "2017-07-01");
		paramMap.put("userId", "20321077");
		//paramMap.put("dimension", "AREA");//组织维度AREA,REG,DEPT,GR,USER
		paramMap.put("serchRange", "USER");
		paramMap.put("serchRangeId", "10098058");
		paramMap.put("caseType", "102");//1=买卖业务,2=租赁业务," "=全部
		paramMap.put("dateType", "0");//0=日统计,1=周统计,2=月统计
		System.err.println(postNewErp(paramMap,"statistic/getOperationsAndProfitCountOffChart"));
	}
	/**
	 * 运营分析与业绩分析-图表
	 * @author 
	 * @since 2017年7月27日
	 * @throws Exception
	 */
	@Test
	public void moveOrganization() throws Exception{
		/*@ApiModelProperty(value = "组织id")
		private Integer organizationId;
		@ApiModelProperty(value = "老pid")
		private Integer oldPid;
		@ApiModelProperty(value = "新pid")
		private Integer newPid;*/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("organizationId", "204950");
		paramMap.put("oldPid", "204949");
		paramMap.put("newPid", "0");
		//paramMap.put("dimension", "AREA");//组织维度AREA,REG,DEPT,GR,USER
		System.err.println(postNewErp(paramMap,"common/moveOrganization"));
	}
	
}
