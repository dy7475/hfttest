package com.myfun.erpWeb.businesstools.joblog;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class WorkLogTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
	}
	/**
	 * 添加工作日志
	 * @author 熊刚
	 * @since 2017年6月14日
	 * @throws Exception
	 */
	@Test
	public void createOrUpdateWorkLog() throws Exception{
		String jsonStr = "[{\"wpTime\":\"时间段\",\"wpFinally\":\"完成情况\",\"wpProject\":\"工作总结\"}]";
		Map<String, String> paramMap = new HashMap<String, String>();
		/*List<Map<String,String>> jsonList = new ArrayList<Map<String,String>>();
		Map<String,String> jsonMap = new HashMap<String, String>();
		jsonList.add(jsonMap);
		jsonMap.put("WP_TIME", "时间段");
		jsonMap.put("WP_FINALLY", "完成情况");
		jsonMap.put("WP_PROJECT", "项目");
		paramMap.put("clientkey", "6ab8637cbc21efca794a82d235cd2824");*/
		paramMap.put("wlSummary","工作总结");
		paramMap.put("otherCount","2");
		paramMap.put("totalCount","2");
		paramMap.put("planJson", jsonStr);
		//paramMap.put("PLAN_LIST", JSON.toJSONString(jsonList));
		System.out.println(postNewErp(paramMap,"businesstools/jobLog/createOrUpdateWorkLog"));
	}
	@Test
	public void adultWorkLog() throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("examinLevel","A");
		paramMap.put("examinDescript", "123456");
		String jsonStr = "[{\"wpTime\":\"时间段\",\"wpFinally\":\"完成情况\",\"wpProject\":\"工作总结\"}]";
		paramMap.put("planJson", jsonStr);
		paramMap.put("wlId", "4");
		paramMap.put("wlTime", "2017-06-15 13:44:34");
		System.out.println(postNewErp(paramMap,"businesstools/jobLog/adultWorkLog"));
	}
}
