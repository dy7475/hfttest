package com.myfun.erpWeb.openApi;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpfunTrueHouseAuditParam;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.utils.rijindael.AESHelper;

public class UpdateTrueHouseAuditStateControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "672037", "15202839705");
//		init("http://192.168.0.179:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	@Test
	public void updateTrueHouseAuditState() throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("caseIds", "6625773");
	    param.put("caseType", 1);
	    param.put("cityId", 1);
	    param.put("type", 3);   //type： 1.VR  2.视频 3.图片
		System.out.println(postNewErp(param,"/openApi/trueHouse/updateTrueHouseState"));
	}
	
	@Test
	public void updateHouseExtension() throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("archiveId", 507823);
		System.out.println(postNewErp(param,"/openApi/trueHouse/updateHouseExtension"));
	}
	
	@Test
	public void updateHouseExtensionDept() throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("compNo", 1);
		param.put("cityId", 1);
		param.put("deptNo", 3);   //type： 1.VR  2.视频 3.图片
		System.out.println(postNewErp(param,"/openApi/trueHouse/updateHouseExtensionDept"));
	}
	
	@Test
	public void validateDownTrueHouse() throws Exception{
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("source", 2);
		param.put("cityId", 1);
		param.put("caseId", 6640117);   //type： 1.VR  2.视频 3.图片
		param.put("caseType", 1);   //type： 1.VR  2.视频 3.图片
		System.out.println(postNewErp(param,"/openApi/trueHouse/validateDownTrueHouse"));
	}
}
