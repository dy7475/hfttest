package com.myfun.erpWeb.openApi.inviteRegist;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.utils.rijindael.AESHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InviteRegistControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		//init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1279612", "14411114444");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18782923250");// zt门店
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "a123456", "13350007000");// ios胡门店
//		init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "13123213123");// 王六

	}


	@Test
	public void addCompInviteUser() throws Exception{
		Map<String, Object> param = new HashMap<>();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cityId", 1);
		paramMap.put("compId", 47588);
		paramMap.put("compNo", "CEH8");
		String paramStr = AESHelper.encode(JSON.toJSONString(paramMap));

		param.put("param", paramStr);
		param.put("password", "a123456");
		param.put("regIds", "5,6");
		param.put("sectionIds", "5,6");
		param.put("serviceZone", "汪家拐 府南");
		param.put("inviteId", "2618");

		System.out.println(postNewErp(param,"/openApi/inviteRegist/addCompInviteUser"));
	}
	
	@Test
	public void ztGetAppLoginLogs() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("startTime", "2019-12-10");
		param.put("endTime", "2019-12-10");
		param.put("compId", "47931");
//		param.put("organizationId", "204998");

		System.out.println(postNewErp(param,"/managerCenter/systemMonitor/ztGetAppLoginLogs"));
	}
}
