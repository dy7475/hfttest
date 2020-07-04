package com.myfun.erpWeb.house;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;

public class FunSaleControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/openLogin", "394072", "15228861532");
	}
	
	@Test
	public void getHouseSaleList() throws Exception{
		QueryHouseCustListParam param = new QueryHouseCustListParam();
		param.setNo("CSCD1601031117465");
		param.setBound(0);
		System.out.println(postNewErp(param,"house/getHouseSaleList"));
	}
}
