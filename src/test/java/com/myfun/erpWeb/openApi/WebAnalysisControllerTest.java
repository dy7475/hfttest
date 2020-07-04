package com.myfun.erpWeb.openApi;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.openApi.analysis.param.AnalysisForWebParam;
import com.myfun.utils.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WebAnalysisControllerTest extends BaseTestController {
	@Before
	public void init(){

		init("http://192.168.200.163:8070/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do",
				"2888", "13408553494");
	}

	@Test
	public void getDealAnalysisForWeb() throws Exception {
		AnalysisForWebParam param=new AnalysisForWebParam();
		param.setStartTime("2018-01-01");
		param.setEndTime("2018-09-01");
		param.setDateCountType("1");
		param.setDateType("SIGN_DATE");
		System.out.println(postNewErp(param, "/web/analysis/getDealAnalysisForWeb"));
	}

	@Test
	public void getCompHouseTotal() throws Exception {
		AnalysisForWebParam param=new AnalysisForWebParam();

		System.out.println(postNewErp(param, "/web/analysis/getCompHouseTotal"));
	}

	@Test
	public void getCompNewHouseCount() throws Exception {
		System.out.println(postNewErp(new HashMap<>(), "/web/analysis/getCompNewHouseCount"));
	}

	@Test
	public void getRegHouseCount() throws Exception {
		System.out.println(postNewErp(new HashMap<>(), "/web/analysis/getRegHouseCount"));
	}

	@Test
	public void getHouseCustAnalysisForWeb() throws Exception {
		AnalysisForWebParam param=new AnalysisForWebParam();
		param.setStartTime("2018-01-01");
		param.setEndTime("2018-09-01");
		param.setDateCountType("2");
		System.out.println(postNewErp(param, "/web/analysis/getHouseCustAnalysisForWeb"));
	}

	@Test
	public void generateBuildRuleByExcel() throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compNo", "AA01");
		System.out.println(postNewErp(paramMap, "/openApi/buildRule/generateBuildRuleByExcel"));
	}

	@Test
	public void buildRuleAddZero() throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compNo", "AA01");
		System.out.println(postNewErp(paramMap, "/openApi/buildRule/buildRuleAddZero"));
	}

	@Test
	public void delBuildRule() throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compNo", "AA01");
		System.out.println(postNewErp(paramMap, "/openApi/buildRule/delBuildRule"));
	}
}
