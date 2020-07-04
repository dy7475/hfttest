package com.myfun.erpWeb.openApi.address;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class AddressControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 获取所有省份
	 * @author 何传强
	 * @since 2017年6月19日
	 * @throws Exception
	 */
	@Test
	public void getProvinceList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		System.err.println(postNewErp(param, "/openApi/adress/getProvinceList"));
	}
	
	/**
	 * 根据省份id,获取该省份下的所有城市
	 * @author 何传强
	 * @since 2017年6月19日
	 * @throws Exception
	 */
	@Test
	public void getCityList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("provinceId", 1);
		System.err.println(postNewErp(param, "/openApi/adress/getCityList"));
	}
	
	/**
	 * 根据城市ID,获取该城市下的所有区县
	 * @author 何传强
	 * @since 2017年6月19日
	 * @throws Exception
	 */
	@Test
	public void getRegList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("cityId", 1);
		System.err.println(postNewErp(param, "/openApi/adress/getRegList"));
	}
	
	/**
	 * 生成MD5码
	 * @author 张宏利
	 * @since 2017年12月4日
	 * @throws Exception
	 */
	@Test
	public void createAddrMd5() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("cityId", 1);
		param.put("compId", 12001);
		param.put("roof", 12001);
		param.put("unit", 12001);
		param.put("floor", 12001);
		System.err.println(postNewErp(param, "/openApi/adress/createAddrMd5"));
	}
}
