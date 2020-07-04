package com.myfun.erpWeb.customer;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import org.junit.Before;
import org.junit.Test;
import scala.annotation.meta.param;

import java.util.HashMap;
import java.util.Map;

public class CustomerControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");

	}

	/**
	 * 客源求购带看列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */	
	@Test
	public void getRentCustomerDaiKanList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("rentCustIds","2106923,2106918,2106917,2106916,2106915,2106914,2106913,2106912,2106911,2106904,2106903,2106901,2106900,2106899");
		System.err.println(postNewErp(pMap,"/customer/getRentCustomerDaiKanList"));
	}

	/**
	 * 获取客源带看列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */
	@Test
	public void getBuyCustomerDaiKanList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buyCustIds","2271463,2271462,2271450,2271449,2271439,2271426,2271417,2271415,2271414,2271384,2271372,2271371,2271370,2271347,2271319,2271316,2271276,2271136,2271135,2271134,2271133,2271125,2271123,2271098,2271097,2271094,2271090,2271088,2271082,2271080,2271078,2271053,2271046,2270971,2270973,2270970,2270969,2270968,2270967,2270858,2270857,2270851,2270847,2270845,2270839,2270838,2270837,2270821,2270819,2270818");
		System.err.println(postNewErp(pMap,"/customer/getBuyCustomerDaiKanList"));
	}

	/**
	 * 获取核心信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/3
	 */	
	@Test
	public void getComCoreInfoById() throws Exception{
		/*
		* {"CASE_ID":"6639123","CASE_TYPE":"1","CLIENTKEY":"8f0eb67aa9059816d8e8d429a5063d24","USEAGE":"1"}
		* {"CASE_ID":"3336759","CASE_TYPE":"2","CLIENTKEY":"8f0eb67aa9059816d8e8d429a5063d24","USEAGE":"1"}
		* */
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseId","3336759");
		pMap.put("caseType",2);
		pMap.put("useage",1);
		System.err.println(postNewErp(pMap,"/common/getComCoreInfoById"));
	}

	/**
	 * 获取求购数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/4
	 */
	@Test
	public void getCustomBuyCustom() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buyCustId",2271497);
		System.err.println(postNewErp(pMap,"/customer/getCustomBuyCustom"));
	}

	/**
	 * 获取客源求购列表-单条信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */
	@Test
	public void getOneBuyCustomerLikeList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buyCustId",2271497);
		pMap.put("bound",0);
		System.err.println(postNewErp(pMap,"/customer/getOneBuyCustomerLikeList"));
	}

	/**
	 * 获取客源求租列表-单条信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */
	@Test
	public void getOneRentCustomerLikeList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("rentCustId",2106954);
		pMap.put("bound",0);
		System.err.println(postNewErp(pMap,"/house/getOneRentCustomerLikeList"));
	}

	@Test
	public void getProxyTemplate() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("templateType",1);
		pMap.put("caseType",1);
		System.out.println(postNewErp(pMap,"/house/getProxyTemplate"));
	}

	@Test
	public void saveProxyTemplate() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("templateType",1);
		pMap.put("caseType",1);
		pMap.put("templateContent","带看确认书内容");
		System.err.println(postNewErp(pMap,"/house/saveProxyTemplate"));
	}
}
