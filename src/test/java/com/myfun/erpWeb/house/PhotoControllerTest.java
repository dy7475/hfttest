package com.myfun.erpWeb.house;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class PhotoControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.200.159:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "648691", "15928053575");
	}

	@Test
	public void getHousePhoto() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseId", "6732123");
		pMap.put("caseType", "1");
//		pMap.put("trackId", "1");
		System.out.println(postNewErp(pMap,"/house/getHousePhoto"));
	}
}
