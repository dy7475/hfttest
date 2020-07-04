package com.myfun.erpWeb.businesstools.renovation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

public class RenovationFileControllerTest extends BaseTestController{

	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 保存装修客户附件资料
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void addRenovationFile() throws Exception{
		Map<String, Object> param =new HashMap<>();
		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("fileType", "1");
		paramMap.put("fileAddr", "http://www.baidu.com");
		paramMap.put("renovationCustomerId", "3");
		paramList.add(paramMap);
		param.put("fileList", paramList);
		System.out.println(postNewErp(param,"renovation/addRenovationFile"));
	}
	
	/**
	 * 删除装修客户附件资料
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void deleteRenovationFile() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setString("idS", "2,3");
		System.out.println(postNewErp(param,"renovation/deleteRenovationFile"));
	}

	/**
	 * 获取装修客户附件资料列表
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void getRenovationFileList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("id", 2);
		System.out.println(postNewErp(param,"renovation/getRenovationFileList"));
	}
}
