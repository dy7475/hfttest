package com.myfun.erpWeb.managecenter.profit;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.managecenter.profit.param.PerformanceAssessmentCountListParam;
import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.BaseTestController;

/**
 * 薪资方案控制器
 * @author 张宏利
 * @since 2017年5月16日
 */
@Controller
@RequestMapping(value="/managecenter/profit")
public class SalarySchemeTestController  extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		init("http://192.168.200.169:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1281399", "18811110331");
	}
	
	/**
	 * 获取薪资方案
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @throws Exception
	 */
	@Test
	public void getSalaryScheme() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("showType", 2);
		pMap.put("deptId", 12001);
		pMap.put("userId", 12001);
		pMap.put("wageTypeCn", "通提提成");
		pMap.put("performanceType", 1);
		System.out.println(postNewErp(pMap, "managecenter/profit/getSalarySchemeList"));
	}


	@Test
	public void getPerformanceAssessmentCountList() throws Exception{
		PerformanceAssessmentCountListParam param = new PerformanceAssessmentCountListParam();
//		param.setUserId(20289880);
//		param.setCheckType(1);
//		param.setRoleId("DEPUTY_MANAGER");
//		param.setAssessmentMonth("2018-01");
		param.setOrganizationId(894657);
		System.out.println(postNewErp(param, "managecenter/profit/getPerformanceAssessmentCountList"));
	}
}
