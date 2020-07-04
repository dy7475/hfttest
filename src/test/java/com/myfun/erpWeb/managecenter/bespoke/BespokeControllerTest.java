package com.myfun.erpWeb.managecenter.bespoke;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BespokeControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}

	/**
	 * title ：a
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@Test
	public void getDaiKanList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		//param.put("startTime", "2016-11-01");
		//param.put("endTime", "2017-11-08");
		param.put("deptId", "12001");
		param.put("userId", "20289880");
		System.out.println(postNewErp(param,"/manageCenter/bespoke/getDaiKanList"));
	}

	/**
	 * title ：a
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@Test
	public void setManager() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId", "20321557");
		System.out.println(postNewErp(param,"/manageCenter/bespoke/setManager"));
	}

	/**
	 * title ：a
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@Test
	public void getBespokeModuleManager() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("deptId", 12001);
		param.put("deptId", 12001);
		System.out.println(postNewErp(param,"/manageCenter/bespoke/getBespokeModuleManager"));
	}

}
