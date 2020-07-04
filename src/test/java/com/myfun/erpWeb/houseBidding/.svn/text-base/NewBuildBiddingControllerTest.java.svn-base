package com.myfun.erpWeb.houseBidding;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.AccountParam;

public class NewBuildBiddingControllerTest extends BaseTestController {

	@Before
	public void init() {
		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		// init("http://192.168.0.137:8081",
		// "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do",
		// "506970", "18782920347");
	}

	/**
	 * 获取推新盘顾问列表
	 * 
	 * @author 熊刚
	 * @since 2017年7月5日
	 * @throws Exception
	 */
	@Test
	public void getNewBuildBiddingList() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("pageNum", 1);
		pMap.put("pageSize", 5);
		System.out.println(postNewErp(pMap, "/newBuildBidding/getNewBuildBiddingList"));
	}

	/**
	 * 竞价
	 * 
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void createBidding() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("pageNum", 1);
		pMap.put("pageSize", 5);
		System.out.println(postNewErp(pMap, "/newBuildBidding/createBidding"));
	}

	/**
	 * 
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void getBuildBidDetail() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", 2048708);
		System.out.println(postNewErp(pMap, "/newBuildBidding/getBuildBidDetail"));
	}
	
	/**
	 * 关键字搜索
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void buildSearch() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("key", "万科彩园");
		System.out.println(postNewErp(pMap, "/newBuildBidding/buildSearch"));
	}
	
	/**
	 * 关键字搜索
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void getRanking() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2049524");
		pMap.put("price", "20");
		System.out.println(postNewErp(pMap, "/newBuildBidding/getRanking"));
	}
	
	/**
	 * 扣费
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @throws Exception
	 */
	@Test
	public void getUseBiddingPrice() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("biddingPrice", 20);
		System.out.println(postNewErp(pMap, "/newBuildBidding/getUseBiddingPrice"));
	}
	
	/**
	 * 新房顾问增加推广介绍
	 * @author 熊刚
	 * @since 2017年9月27日
	 * @throws Exception
	 */
	@Test
	public void updateSelfDesc() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", 2048708);
		pMap.put("selfDesc", "123");
		System.out.println(postNewErp(pMap, "/newBuildBidding/updateSelfDesc"));
	}
	
	
}
