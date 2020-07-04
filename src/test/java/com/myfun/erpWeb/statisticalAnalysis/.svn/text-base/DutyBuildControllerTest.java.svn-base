package com.myfun.erpWeb.statisticalAnalysis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

/**
 * 运营分析-责任盘相关
 * @author 张宏利
 * @since 2017年9月28日
 */
public class DutyBuildControllerTest  extends BaseTestController {
	
	@Before
	public void init(){
		init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 责任盘的增删改
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * @return
	 */
	@Test
	public void updateDeptDutyBuild() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("dutyBuildJson", "[{\"buildId\":\"2032664\",\"buildName\":\"英郡一期\"},{\"buildId\":\"2017744\",\"buildName\":\"十八步岛别墅\"},{\"buildId\":\"2032183\",\"buildName\":\"天府软件园C区\"},{\"buildId\":\"2030111\",\"buildName\":\"青年一号\"}]");
		param.put("deptId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/dutyBuild/updateDeptDutyBuild"));
	}
	
	/**
	 * 获取责任盘列表
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * @return
	 */
	@Test
	public void getDeptDutyBuild() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		System.err.println(postNewErp(param, "/statisticalAnalysis/dutyBuild/getDeptDutyBuild"));
	}
	
	/**
	 * 获取责任盘列表
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param param
	 * serchRange	查询范围 COMP,AREA,REG,DEPT
	 * serchRangeId	查询范围ID
	 * caseType	房源类型（1：出售，2：出租，其他或不传：全部）
	 * startTime	起始时间
	 * endTime	结束时间
	 * dateType	0=日统计 1= 周统计 2=月统计
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getDutyBuildStatistic() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("startTime", "2017-01-01");
		param.put("endTime", "2017-11-26");
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		param.put("dateType", "1");
		param.put("caseType", "");
		System.err.println(postNewErp(param, "/statisticalAnalysis/dutyBuild/getDutyBuildStatistic"));
	}
}

