package com.myfun.erpWeb.bulletin;

import com.myfun.erpWeb.BaseTestController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NoteControllerTest extends BaseTestController {
	@Before
	public void init(){
		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18381306721");
	}
	@Test
	public void bulletinInfo() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("bulletId", 1513351);
		param.put("bulletBound", 2);
		System.err.println(postNewErp(param, "/bulletin/bulletinInfo?bulletId=1513351&bulletBound=2"));
	}
	@Test
	public void BulletinWarmTask() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "bulletin/getBulletinWarmTask"));
	}
}
