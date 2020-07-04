package com.myfun.erpWeb.houseBidding;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class HouseBiddingTestController extends BaseTestController{

    @Before
    public void init(){
    	//init("http://192.168.0.179:8001/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
//		init("http://192.168.0.137:8081",     "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//        init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
        init("http://192.168.5.186:8080/erpWeb", "http://192.168.5.186:8081/hftWebService/web/api/authentication/per.do", "506504", "18566547985");
    }

    @Test
    public void getUserInfoAndAccountInfo() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
        System.out.println(postNewErp(pMap,"/houseBidding/getUserInfoAndAccountInfo"));
    }
    @Test
    public void getHouseInfoSEQ() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
        System.out.println(postNewErp(pMap,"/houseBidding/getHouseInfoSEQ"));
    }
    
    /**
     * 获取推广房源列表
     * @author 熊刚
     * @since 2017年7月5日
     * @throws Exception
     */
    @Test
    public void getHouseBiddingList() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("saleLease", "1");
        pMap.put("pageOffset", "1");
        pMap.put("pageRows", "10");
        pMap.put("compId", "12001");
        pMap.put("archiveId", "508357");
       // pMap.put("buildId", "2028079");
        System.out.println(postNewErp(pMap,"/houseBidding/getHouseBiddingList"));
    }
    
    /**
     * 获取竞价列表
     * @author 熊刚
     * @since 2017年7月5日
     * @throws Exception
     */
    @Test
    public void getBuildBiddInfo() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
		pMap.put("isCanExtension",1);
      
        System.out.println(postNewErp(pMap,"/houseBidding/getBuildBiddInfo"));
    }
    
    /**
     * 关注一个小区
     * @auther 胡坤
     * @since 2018/4/11
     * @throws Exception
     *
     */
    @Test
    public void addBuildAttentionInfo() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("buildId","19");
        pMap.put("buildName","彩蝶花园");
        System.out.println(postNewErp(pMap,"/houseBidding/addBuildAttentionInfo"));
    }
	
    /**
     * 更换关注小区
     * @auther 胡坤
     * @since 2018/4/11
     * @throws Exception
     *
     */
	@Test
	public void deleteBuildAttentionInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("newBuildId","21");
		pMap.put("buildName","朝阳名宅");
		pMap.put("oldBuildId","19");
		System.out.println(postNewErp(pMap,"/houseBidding/deleteBuildAttentionInfo"));
	}
 
	
	/**
	 * 获取房源库存
	 *  @auther 胡坤
     * @since 2018/4/12
     * @throws Exception
	 *
	 */
    @Test
    public void getHousePubFlagAll() throws Exception{
        Map<String, Object> pMap = new HashMap<>();
        
        System.out.println(postNewErp(pMap,"/houseBidding/getHousePubFlagAll"));
    }
    
    /**
     * 小区竞价预扣费
     * @author ZangTie
     * @since 2018年7月19日 下午9:59:54
     * @throws Exception
     * Modified XXX ZangTie 2018年7月19日
     */
	@Test
	public void getBuildInfoSEQ() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2016609");
		pMap.put("biddPrice", "30");
		pMap.put("buildName", "碧云路小区");
		System.out.println(postNewErp(pMap, "/houseBidding/getBuildInfoSEQ"));
	}
	
	/**
	 * 查询楼盘的当前最高出价
	 * @author ZangTie
	 * @since 2018年7月20日 上午10:32:41
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月20日
	 */
	@Test
	public void getBidPrice() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2016609");
		System.out.println(postNewErp(pMap, "/houseBidding/getBidPrice"));
	}
	
	/**
	 * 创建一个楼盘竞价信息
	 * @author ZangTie
	 * @since 2018年7月25日 下午6:10:36
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月25日
	 */
	@Test
	public void createBuildBiddInfo() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("biddPrice", "34");
		pMap.put("buildId", "2016609");
		pMap.put("buildName", "碧云路小区");
		System.out.println(postNewErp(pMap, "/houseBidding/createBuildBiddInfo"));
	}
}
