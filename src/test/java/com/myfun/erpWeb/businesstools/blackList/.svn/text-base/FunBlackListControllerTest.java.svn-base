package com.myfun.erpWeb.businesstools.blackList;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.businesstools.blackList.param.GetBlackListParam;

public class FunBlackListControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://172.16.13.4:8080/hftWebService/web/api/authentication/per.do", "671052", "18410816545");
	}
	
	/**
	 * 查询黑名单列表
	 * @author 臧铁
	 * @param param keywordQuery ：关键字 电话1和电话2和名字和公司的模糊查询
	 * @since 2017年8月23日
	 * @throws Exception
	 */
	@Test
	public void getBlackList() throws Exception{
		GetBlackListParam param = new GetBlackListParam();
//		pMap.put("phone1", "18182920000");
//		pMap.put("phone2", "18182920001");
//		pMap.put("userName", "王大");
//		pMap.put("blackComp", "通天虫洞公司");
//		pMap.put("pageOffset", "1");
//		pMap.put("pageRows", "50");
//		pMap.put("keywordQuery", "1818");
		param.setKeywordQuery("18");
		System.out.println(postNewErp(param,"/businesstools/blackList/getBlackList"));
	}
	
	/**
	 * 获取黑名单详情
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @throws Exception
	 */
	@Test
	public void getBlackListByData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("id", "6");
		System.out.println(postNewErp(pMap,"/businesstools/blackList/getBlackListByData"));
	}
	
	/**
	 * 插入黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @throws Exception
	 */
	@Test
	public void insertBlackList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userName", "王五");
		pMap.put("userSex", "0");
		pMap.put("phone1", "18182920009");
		pMap.put("phoneType1", "1");
		pMap.put("phone2", "18182920010");
		pMap.put("phoneType2", "1");
		pMap.put("blackComp", "通天虫洞公司");
		pMap.put("remarks", "备注5");
		System.out.println(postNewErp(pMap,"/businesstools/blackList/insertBlackList"));
	}
	
	/**
	 * 修改黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @throws Exception
	 */
	@Test
	public void editBlackList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userName", "王大");
		pMap.put("id", "6");
		pMap.put("userSex", "1");
		pMap.put("phone1", "18182920003");
		pMap.put("phoneType1", "1");
		pMap.put("phone2", "18182920004");
		pMap.put("phoneType2", "2");
		pMap.put("blackComp", "通天虫洞公司");
		pMap.put("remarks", "备注1");
		System.out.println(postNewErp(pMap,"/businesstools/blackList/editBlackList"));
	}
	
	/**
	 * 删除黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @throws Exception
	 */
	@Test
	public void delBlackListById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("id", "4");
		System.out.println(postNewErp(pMap,"/businesstools/blackList/delBlackListById"));
	}
}
