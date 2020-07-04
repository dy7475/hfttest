package com.myfun.erpWeb.homepage;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.app.param.AppAchieveMonthStatisticsRankDetailParam;
import com.myfun.erpWeb.homepage.param.AppWorkAchieveParam;
import com.myfun.erpWeb.homepage.param.AppWorkCountStatisticsRankParam;
import com.myfun.repository.erpdb.param.ErpFunProfitParam;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页相关接口单元测试
 * @author 张宏利
 * @since 2018年2月7日
 */
public class HomePageControllerTest extends BaseTestController{
	
	@Before
	public void init(){
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "507422", "18900018989");
//		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.249:80/hftWebService/web/api/authentication/per.do", "669615", "15082231470");
//		init("http://hft.51vfang.cn/erpWeb", "http://hft.51vfang.cn/hftWebService/web/api/authentication/per.do", "1077084", "13548998494");
	//	init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		//init("http://192.168.200.163:8068/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do",
				//"1280737", "18202855728");
		// 18202855728   17800000009
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "670483", "13562854326");
		//init("http://192.168.5.173:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "671052", "13664522525");
		init("http://192.168.200.163:8068/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do",
				"11", "17800000009");
	}
	
	/**
	 * 工作情况统计
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @throws Exception
	 */
	@Test
	public void getWorkCountStatistic() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("dateType", "1");
		System.err.println(postNewErp(pMap, "homepage/getWorkCountStatistic"));
	}
	
	@Test
	public void getBasicFollowCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap, "homepage/getBasicFollowCount"));
	}
	
	@Test
	public void updateProfessionSub() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("professionSub", "我是小宏利！");
		System.out.println(postNewErp(pMap, "homepage/updateProfessionSub"));
	}
	
	@Test
	public void getManageFollowCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap, "homepage/getManageFollowCount"));
	}
	
	@Test
	public void getBasicDaiKanHotrank() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("houseCust", 2);
		System.out.println(postNewErp(pMap, "/homepage/getBasicDaiKanHotrank"));
	}

	/**
	 * @Title 业绩目标
	 * @Author lcb
	 * @Date 2018/2/8
	 * @Param
	 **/
	@Test
	public void getProfitTargetAndProfit() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("houseCust", 2);
		System.out.println(postNewErp(pMap, "/homepage/getProfitTargetAndProfit"));
	}

	/**
	 * @Title 业绩目标
	 * @Author lcb
	 * @Date 2018/2/8
	 * @Param
	 **/
	@Test
	public void getCompProfitMonth() throws Exception{
		ErpFunProfitParam pMap = new ErpFunProfitParam();
		pMap.setRangeType(2);
		System.out.println(postNewErp(pMap, "/homepage/getCompProfitMonth"));
	}
	
	@Test
	public void getPersonalRank() throws Exception{
		ErpFunProfitParam pMap = new ErpFunProfitParam();
		pMap.setRangeType(1);
		System.out.println(postNewErp(pMap, "/homepage/getPersonalRank"));
	}
	
	@Test
	public void getManageDaiKanHotrank() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("houseCust", 2);
		System.out.println(postNewErp(pMap, "/homepage/getManageDaiKanHotrank"));
	}
	
	@Test
	public void getBasicCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("countType", 2);
		System.out.println(postNewErp(pMap, "/homepage/getBasicCount"));
	}

	@Test
	public void getManagerCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("countType", 2);
		System.out.println(postNewErp(pMap, "/homepage/getManagerCount"));
	}
	
	@Test
	public void getWorkCountStatisticRank() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("dateType", 1);
		pMap.put("lookRankType", 1);
		pMap.put("rangeId", 12001);
		pMap.put("rangeType", 4);
		// 排名范围类型
		System.out.println(postNewErp(pMap, "/homepage/getWorkCountStatisticRank"));
	}

	/**
	 * 工作情况统计报表数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/7
	 */
	@Test
	public void getWorkCountStatisticReport() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("endTime","2018-06-11 23:59:59");
		param.put("startTime","2018-06-04 00:00:00");
		param.put("standard",0);
		param.put("userId","20322795");
		param.put("userPosition","");
		param.put("dateType",2);
		System.out.println(postNewErp(param, "/homepage/getWorkCountStatisticReport"));
	}


	@Test
	public void getAppWorkCountStatistic() throws Exception {
		AppWorkAchieveParam param = new AppWorkAchieveParam();
		param.setDateType(2);
		param.setEndDate("2018-08-16");
		param.setStartDate("2018-08-10");
		param.setRangeIds("46204");
		param.setRangeType(1);
		//param.put("deptId",12001);
		System.out.println(postNewErp(param, "/homepage/getAppWorkCountStatistic"));
	}

	@Test
	public void getAppWorkCountStatisticRank() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dateType",2);
		param.put("rangeType",4);// 2:大区3：片区 4：门店 5：分组 6：到人
		param.put("rangeId",903456);
		param.put("funCust",1);

		//param.put("deptId",12001);
		param.put("lookRankType",1);
		param.put("achievementType",2);
		System.out.println(postNewErp(param, "/homepage/getAppWorkCountStatisticRank"));
	}
	
	@Test
	public void getAppWorkCountAverageStatistic() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("dateType",2);
		param.put("rangeType",5);// 2:大区3：片区 4：门店 5：分组 6：到人
		param.put("rangeId",252483);
		System.out.println(postNewErp(param, "/homepage/getAppWorkCountAverageStatistic"));
	}
	
	@Test
	public void getAppWorkCountAchieveStatisticsSummaryRank() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("rangeType",6);// 2:大区3：片区 4：门店 5：分组 6：到人
		param.put("rangeIds","20324989");
		System.out.println(postNewErp(param, "/homepage/getAppWorkCountAchieveStatisticsSummaryRank"));
	}

	@Test
	public void getDayUserScoreCount() throws Exception {
		Map<String, Object> param =new HashMap<>();
		param.put("userId","20322814");
		System.out.println(postNewErp(param, "/userScore/getDayUserScoreCount"));
	}


	@Test
	public void getAppAchieveMonthStatisticsRank() throws Exception {
//		{"assessmentMonth":"2019-09-01","assessmentType":1,"deptId":894307,
//			"fjdRangeType":2,"lookType":6,"pageOffset":1,"pageRows":20,"rangeIds":"20332186","rangeType":6}
		Map<String, Object> param =new HashMap<>();
		param.put("rangeIds","20332186");
		param.put("assessmentMonth","2019-09-01");
		param.put("assessmentType",1);
		param.put("lookType",6);
		param.put("fjdRangeType",2);
		param.put("rangeType",6);
		param.put("deptId",894307);
		System.out.println(postNewErp(param, "/homepage/getAppAchieveMonthStatisticsRank"));
	}

	@Test
	public void getAppWorkCountAchieveStatisticsRangeRank() throws Exception {
		AppWorkCountStatisticsRankParam param =new AppWorkCountStatisticsRankParam();
		param.setRangeType(1);
		param.setRangeIds("47362");
		param.setLookRankType(-16);
		param.setFunCust(0);
		param.setStartDate("2019-05-01");
		param.setEndDate("2019-05-31");
		param.setDateType(3);
		System.out.println(postNewErp(param, "/homepage/getAppWorkCountAchieveStatisticsRangeRank"));
	}
	
	@Test
	public void getAppAchieveMonthStatisticsRankDetail() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param =new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
//		param.setAssessmentType(6);
		param.setDeptId(888227);
		System.out.println(postNewErp(param, "/homepage/getAppAchieveMonthStatisticsRankDetail"));
	}
}
