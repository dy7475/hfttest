package com.myfun.erpWeb.match;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

public class MatchHouseCustControllerTest extends BaseTestController{
	
	@Before
	public void init() throws Exception{
		init("http://192.168.0.249:8080/erpWeb", "http://192.168.0.249/hftWebService/web/api/authentication/per.do", "506357", "15982667547");
	}
	
	/**
	 * 全公司出售匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@Test
	public void getMatchSalePush() throws Exception {
		BaseMapParam pMap = new BaseMapParam();
		pMap.setInteger("saleId", 6635901);
		System.out.println(postNewErp(pMap,"/match/getMatchSalePush"));
	}
	
	/**
	 * 全公司出租匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@Test
	public void getMatchLeasePush() throws Exception {
		BaseMapParam pMap = new BaseMapParam();
		pMap.setInteger("leaseId", 3335213);
		System.out.println(postNewErp(pMap,"/match/getMatchLeasePush"));
	}
	
	/**
	 * 全公司求购匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@Test
	public void getMatchBuyCustPush() throws Exception {
		BaseMapParam pMap = new BaseMapParam();
		pMap.setInteger("buyCustId", 2270245);
		System.out.println(postNewErp(pMap,"/match/getMatchBuyCustPush"));
	}
	
	/**
	 * 全公司求租匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@Test
	public void getMatchRentCustPush() throws Exception {
		BaseMapParam pMap = new BaseMapParam();
		pMap.setInteger("rentCustId", 2106286);
		System.out.println(postNewErp(pMap,"/match/getMatchRentCustPush"));
		
	}
}


