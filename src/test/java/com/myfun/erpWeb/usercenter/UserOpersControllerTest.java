package com.myfun.erpWeb.usercenter;

import com.myfun.erpWeb.BaseTestController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserOpersControllerTest extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.181:8080", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		init("http://localhost:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "8", "18121913023");
	}
	
	// 请求楼盘列表
	@Test
	public void getDistBuildListOffIndex() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("plateType", "1"); // gongsi
		pMap.put("queryType", "1"); // xinpan
		System.out.println(postNewErp(pMap,"/distribution/getDistBuildListOffIndex"));
	}


	// 获取首页广告列表
	@Test
	public void getDistAdsOnIndex() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		/*pMap.put("plateType", "1"); // gongsi
		pMap.put("queryType", "1"); // xinpan*/
		System.out.println(postNewErp(pMap,"/distribution/getDistAdsOnIndex"));
	}
	
	//  楼盘卖点->导向网页
	@Test
	public void getUserInfoData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getBuildSellPoint"));
	}
	//  拓客技巧->导向网页
	@Test
	public void getMoreCustomerSkill() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getMoreCustomerSkill"));
	}
	//  分销须知->导向网页
	@Test
	public void getDistNotice() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/distNotice"));
	}
	
	//  政策动态->导向网页
	@Test
	public void getPolicyInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getPolicyInfo"));
	}
	
	//  (客户管理)获取带看客户统计信息
	@Test
	public void getDistCountCustInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistCountCustInfo"));
	}
	
	//  获取业绩趋势走向图数据
	@Test
	public void getDistCountOfferToBuy() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistCountOfferToBuy"));
	}
	
	// 根据公司和门店查询出当前参与的楼盘
	@Test
	public void getDistBuildByComp() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistBuildByComp"));
	}
	
	// 查询报备客户列表信息
	@Test
	public void getDistCustList() throws Exception{
//		Map<String, Object> pMap = new HashMap<>();
//		System.out.println(postNewErp(pMap,"/distribution/getDistCustList"));
	}
	
	//  查询我的佣金数据/（我的联动)获取平台/公司分销/加盟圈佣金信息
	@Test
	public void getDistCountBorkerAmmount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistCountBorkerAmmount"));
	}
	
	// （我的联动)获取最近一年的收入信息
	@Test
	public void getDistCountMoneyOfYear() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistCountMoneyOfYear"));
	}
	
	//  我的佣金(个人佣金记录)
	@Test
	public void getDistPersonalCommList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", 12001);
//		pMap.put("deptId", 12001);
//		pMap.put("grId", 40143);
		pMap.put("compId", "12001");
		pMap.put("status", "0");
		pMap.put("buildId", "9555");
		pMap.put("bCityId", "1");
		pMap.put("keyword", "xx");
		pMap.put("endTime", "2018-08-08");
		pMap.put("startTime", "2015-08-08");
		System.out.println(postNewErp(pMap,"/distribution/getDistPersonalCommList"));
	}
	
	//  片区列表
	@Test
	public void getDistCustDealList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", 12001);
//		pMap.put("deptId", 12001);
//		pMap.put("grId", 40143);
		pMap.put("compId", "12001");
		pMap.put("status", "0");
		pMap.put("buildId", "9555");
		pMap.put("bCityId", "1");
		pMap.put("keyword", "xx");
		pMap.put("endTime", "2018-08-08");
		pMap.put("startTime", "2015-08-08");
		System.out.println(postNewErp(pMap,"/distribution/getDistCustDealList"));
	}
	//   我的佣金(带看奖励列表)
	@Test
	public void getDistDaikanRewardsList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", 12001);
//		pMap.put("deptId", 12001);
//		pMap.put("grId", 40143);
		pMap.put("compId", "12001");
		pMap.put("status", "0");
		pMap.put("buildId", "9555");
		pMap.put("bCityId", "1");
		pMap.put("keyword", "xx");
		pMap.put("endTime", "2018-08-08");
		pMap.put("startTime", "2015-08-08");
		System.out.println(postNewErp(pMap,"/distribution/getDistDaikanRewardsList"));
	}
	// 我的佣金(提现记录)
	@Test
	public void getDistAmountHistory() throws Exception{
//		Map<String, Object> pMap = new HashMap<>();
//		System.out.println(postNewErp(pMap,"/distribution/getDistAmountHistory"));
	}
	// 最新系统消息
	@Test
	public void getDistSystemMessage() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistSystemMessage"));
		// 最新系统消息
	}
	@Test
	public void getDistMsgConnllectionList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistMsgConnllectionList"));
	}
	// 楼盘管理员
	@Test
	public void getDistCompRealAdmin() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		
		System.out.println(postNewErp(pMap,"/distribution/getDistCompRealAdmin"));
	}
	@Test
	public void getDistBuildInfoAdmin() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		
		System.out.println(postNewErp(pMap,"/distribution/getDistBuildInfoAdmin"));
	}
	@Test
	public void getBuildInfoList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", 12001);
//		pMap.put("deptId", 12001);
//		pMap.put("grId", 40143);
		pMap.put("compId", "12001");
		pMap.put("status", "0");
		pMap.put("buildId", "9555");
		pMap.put("bCityId", "1");
		pMap.put("keyword", "xx");
		pMap.put("endTime", "2018-08-08");
		pMap.put("startTime", "2015-08-08");
		System.out.println(postNewErp(pMap,"/distribution/getBuildInfoList"));
	}
	@Test
	public void getFunCustList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("areaId", 12001);
//		pMap.put("deptId", 12001);
//		pMap.put("grId", 40143);
		pMap.put("compId", "12001");
		pMap.put("status", "0");
		pMap.put("buildId", "9555");
		pMap.put("bCityId", "1");
		pMap.put("keyword", "xx");
		pMap.put("endTime", "2018-08-08");
		pMap.put("startTime", "2015-08-08");
		System.out.println(postNewErp(pMap,"/distribution/getFunCustList"));
	}
	// 跟进列表
	@Test
	public void getDistFunCustTrackList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("custId", "43154");
		System.out.println(postNewErp(pMap,"/distribution/getDistFunCustTrackList"));
	}
	// 客户信息
	@Test
	public void getFunCustDetail() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("custId", "43154");
		System.out.println(postNewErp(pMap,"/distribution/getFunCustDetail"));
	}
	/*
	* 修改后：
	* {
    "data":{
        "addCase":"赛维洗衣·生活馆,中国电信天府软件园营业厅,丹马士成都客户服务中心,韩韩国度皇室造型,公共自行车软件园D区2站,沙石站,敦豪全球货运(中国)公司成都分公司,天华路南自行车租赁点,满城房产(会展中心店),景印图文,1",
        "agencyStatus":0,
        "agencyType":0,
        "buildAddr":"成都市高新区天府软件园6栋",
        "buildArea":"8000",
        "buildCode":"HFLDCSLP",
        "buildDate":"2015-01-01",
        "buildDescript":"此楼盘为好房通科技股份有限公司新盘联动分销功能测试数据，纯属虚构，如有雷同，纯属巧合。",
        "buildFitment":"毛坯",
        "buildId":2037513,
        "buildName":"好房联动演示楼盘",
        "buildRegion":4,
        "buildSource":0,
        "buildStatus":2,
        "buildType":"电梯",
        "busLine":"298,102,115,118,84,夜间专线298,504A,1096,171A,171B,236,240,华阳4A路,124,501,华阳5路,华阳4B,1",
        "cityId":1,
        "compCname":"拳头地产",
        "confirmNum":128,
        "createTime":"2014-12-03 11:48:45",
        "crmCompId":1,
        "crmUserId":214,
        "dealNum":108,
        "devloperCityId":1,
        "devloperId":1004,
        "devloperName":"拳头地产有限该公司",
        "draw":0,
        "editFlag":1,
        "examPhoto":0,
        "floorText":"35",
        "haofangAmount":0,
        "isTop":0,
        "landArea":"4455",
        "newFlag":0,
        "openDate":"2015-01-01 00:00:00",
        "phoneLimitMode":1,
        "photoEffects":108,
        "photoExterior":74,
        "photoModel":113,
        "photoPlan":5,
        "photoSet":0,
        "photoTemplet":21,
        "photoTraffic":0,
        "price":10000,
        "priceText":"10000",
        "provinceId":1,
        "regName":"高新区",
        "rightYears":"40年",
        "roomText":"1 2",
        "sectionId":135,
        "sectionName":"高新区",
        "sellTele":"800-400-8548",
        "seqNo":196,
        "submitDate":"2015-12-08",
        "systemFlag":true,
        "updateTime":"2018-10-27 12:04:27",
        "useageType":"住宅"
    },
    "errCode":200,
    "serverTime":"2019-01-17 10:17:58"。


}
	* */
	// 楼盘信息
	@Test
	public void getBuildInfoDetailed() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2037513");
		System.out.println(postNewErp(pMap,"/distribution/getBuildInfoDetailed"));
	}
	// 楼盘规则
	@Test
	public void getDistCooperationRuleDetailed() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2037867");
		pMap.put("ruleId", "2037867");
		pMap.put("devloperId", "2037867");
		System.out.println(postNewErp(pMap,"/distribution/getDistCooperationRuleDetailed"));
	}
	// 楼盘规则
	@Test
	public void getBuildLayoutList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2037867");
		System.out.println(postNewErp(pMap,"/distribution/getBuildLayoutList"));
	}
	// 设置管理员
	@Test
	public void setDistCompRealAdmin() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("oldUserId", "20059151");
		pMap.put("newUserId", "20059151");
		pMap.put("buildId", "2037867");
		System.out.println(postNewErp(pMap,"/distribution/setDistCompRealAdmin"));
	}
	// 设置管理员
	@Test
	public void addEditDeveloper() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
////		pMap.put("oldUserId", "20059151");
////		pMap.put("newUserId", "20059151");
////		pMap.put("buildId", "2037867");
//		System.out.println(postNewErp(pMap,"/distribution/addEditDeveloper"));
	}
	// 楼盘图片列表
	@Test
	public void getDistBuildPhotoList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2037867");
		System.out.println(postNewErp(pMap,"/distribution/getDistBuildPhotoList"));
	}
	@Test
	public void saveOrUpdateDistBuildLayout() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		System.out.println(postNewErp(pMap,"/distribution/saveOrUpdateDistBuildLayout"));
	}
	@Test
	public void updateDistFunCust() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		System.out.println(postNewErp(pMap,"/distribution/updateDistFunCust"));
	}
	// 分销状态
	@Test
	public void updateDistBuildstatus() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		System.out.println(postNewErp(pMap,"/distribution/updateDistBuildstatus"));
	}
	// 分销状态
	@Test
	public void checkDistMobileRepreated() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2037867");
		pMap.put("firstMobile", "18782920347");
		System.out.println(postNewErp(pMap,"/distribution/checkDistMobileRepreated"));
	}
	@Test
	public void createDistCust() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("buildId", "2037867");
//		pMap.put("firstMobile", "18782920347");
//		System.out.println(postNewErp(pMap,"/distribution/createDistCust"));
	}
	// 我的客户-管理-详情
	@Test
	public void getDistCustInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("custId", "43154");
		System.out.println(postNewErp(pMap,"/distribution/getDistCustInfo"));
	}
	@Test
	public void getDistUserBindBankList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistUserBindBankList"));
	}
	@Test
	public void addDistUserBank() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("uaType", "1");
		pMap.put("userIccode", "111");
		pMap.put("accountType", "111");
		pMap.put("accountBank", "111");
		pMap.put("bankUserName", "111");
		pMap.put("accountNo", "111");
		pMap.put("custMobile", "111");
		pMap.put("accountNo", "111");
		System.out.println(postNewErp(pMap,"/distribution/addDistUserBank"));
	}
	@Test
	public void getDistCompCommissionRate() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getDistCompCommissionRate"));
	}
	@Test
	public void setCompCommissionRate() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("paidRate", "23");
		System.out.println(postNewErp(pMap,"/distribution/setCompCommissionRate"));
	}
	@Test
	public void updateDistMsgConnllection() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("operType", "1");
		pMap.put("spreadId", "1");
		System.out.println(postNewErp(pMap,"/distribution/updateDistMsgConnllection"));
	}
	@Test
	public void getDistFunCompRealList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("compCName", "1");
//		pMap.put("salesManager", "1");
//		pMap.put("salesMobile", "1");
		pMap.put("startTime", "2016-11-01");
		pMap.put("endTime", "2016-11-16");
		pMap.put("pageOffset", "1");
		pMap.put("pageRows", "50"); ; // 1 第几页
		System.out.println(postNewErp(pMap,"/distribution/getDistFunCompRealList"));
	}
	@Test
	public void getFunCompRealInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("devloperId", "10235");
		System.out.println(postNewErp(pMap,"/distribution/getFunCompRealInfo"));
	}
	
	/**
	 * 同意新房分销使用协议
	 * @author 臧铁
	 * @since 2017年7月10日
	 * @throws Exception
	 */
	@Test
	public void agreeAgencyUseRule() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/agreeAgencyUseRule"));
	}
	
	/**
	 * 获取新房分销使用协议状态
	 * @author 臧铁
	 * @since 2017年7月10日
	 * @throws Exception
	 */
	@Test
	public void getAgencyUseFlag() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/distribution/getAgencyUseFlag"));
	}
}
