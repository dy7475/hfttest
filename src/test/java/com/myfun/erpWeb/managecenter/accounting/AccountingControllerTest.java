package com.myfun.erpWeb.managecenter.accounting;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.AccountParam;

public class AccountingControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
	}
	/**
	 * 
	 * @author 熊刚
	 * @since 2017年9月7日
	 * @throws Exception
	 */
	@Test
	public void getMgrUsrIsInAt() throws Exception{
		 Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"managerCenter/accounting/getMgrUsrIsInAt"));
	}
	
	/**
	 * 导出
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void getMgrMyAtList() throws Exception {
		AccountParam param= new AccountParam();
		param.setAtId(72474);
		param.setCreationTime1("2015-06-18");
		param.setCreationTime2("2017-09-18");
		System.out.println(postNewErp(param, "/managerCenter/accounting/getMgrMyAtList"));
	}
}
