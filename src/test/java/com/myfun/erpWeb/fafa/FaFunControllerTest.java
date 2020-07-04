package com.myfun.erpWeb.fafa;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FaFunControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		init("http://192.168.5.182:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "670452", "15982820924");
	}
	
	/**
	 * 查询用户的联系方式
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/18
	 * @return 
	 * 
	 */
	@Test
	public void updatePersonalInfo() throws Exception {
		Map<String,Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/fafun/getFFContactData"));
	}
	
	
	/**
	 * 修改用户的联系方式
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/18
	 * @return
	 *
	 */
	@Test
	public void updateFFContactData() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("contactFlag","1");
		System.out.println(postNewErp(param,"/fafun/updateFFContactData"));
	}
}
