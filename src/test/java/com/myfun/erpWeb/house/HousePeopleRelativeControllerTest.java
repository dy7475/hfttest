package com.myfun.erpWeb.house;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;

public class HousePeopleRelativeControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.11.101:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
		initOnlyAddr("http://192.168.5.145:8087/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1279576", "13700000137");
		
		super.setClientKey("70e7885f8bce91cc680be65d1fab63d4");
	}
	/**
	 * 获取相关房源人员列表
	 * @author 熊刚
	 * @since 2017年9月7日
	 * @throws Exception
	 */
	@Test
	public void getHousePeopleRelativeList() throws Exception{
		 Map<String, Object> param = new HashMap<>();
		 param.put("caseType", "1");
		 param.put("caseId", "6643425");
		System.out.println(postNewErp(param,"house/getHousePeopleRelativeList"));
	}
	/**
	 * 房源相关人单元测试
	 * @author 熊刚
	 * @since 2017年9月7日
	 * @throws Exception
	 */
	@Test
	public void updateHousePeopleRelative() throws Exception{
		HousePeopleRelativeParam param = new HousePeopleRelativeParam();
		param.setSaleRelativeId(18276);
		param.setCaseType(1);
		param.setCaseId(6643425);
		param.setCaseNo("CSCD1906291415163");
		param.setPeopleType(1);
		param.setUserId(20330630);
		param.setBeforUserId(20329935);
		param.setDelFlag(0);
		param.setCaseNo("123456");
		param.setRemarksContent("aaaaaa");
		//param.setEntrustType(1);
		System.out.println(postNewErp(param,"house/updateHousePeopleRelative"));
	}


}
