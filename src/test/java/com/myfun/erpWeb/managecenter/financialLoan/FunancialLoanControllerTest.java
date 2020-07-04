package com.myfun.erpWeb.managecenter.financialLoan;

import com.myfun.erpWeb.BaseTestController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FunancialLoanControllerTest extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.181:8080", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		init("http://192.168.5.174:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}

	@Test
	public void getFinanceInfoPhotoList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("financeId", "68");
		pMap.put("photoType", "1");
		System.out.println(postNewErp(pMap,"/managecenter/financialLoan/getFinanceInfoPhotoList"));
	}

}
