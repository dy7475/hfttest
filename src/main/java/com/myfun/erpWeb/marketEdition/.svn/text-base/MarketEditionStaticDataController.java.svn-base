package com.myfun.erpWeb.marketEdition;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.reportdb.dao.ReportMarketEditionStaticDataMapper;
import com.myfun.repository.reportdb.po.ReportMarketEditionStaticData;
import com.myfun.repository.reportdb.po.ReportMarketEditionStaticDataExample;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
  * 营销版样本数据
  * @author 李成兵
  * @since 2018/5/31
  * @param
  * @return
  */
@RestController
public class MarketEditionStaticDataController extends BaseController {

	@Autowired
	private ReportMarketEditionStaticDataMapper reportMarketEditionStaticDataMapper;

	public String needQueryData(String action, Map<String, Object> allAtrtibute) throws Exception{
		String returnData = "";
		if(StringUtil.isBlank(action)){
			return returnData;
		}
		String[] strings = judgeMethodParam(action, allAtrtibute);
		if ("0".equals(strings[1])) {
			returnData = strings[0];
		}else if("1".equals(strings[1])) {
			returnData = getReturnData(strings[0]);
		}else {
			returnData = getReturnData(action);
		}
		return returnData;
	}

	/**
	 * 查询数据存储得静态数据
	 * @author 李成兵
	 * @since 2018/5/31
	 * @param
	 * @return
	 */
	private String getReturnData(String action) {
		ReportMarketEditionStaticDataExample example = new ReportMarketEditionStaticDataExample();
		example.createCriteria().andStatusEqualTo((byte) 1).andActionEqualTo(action);
		example.setOrderByClause(" ID DESC");
		List<ReportMarketEditionStaticData> resList = reportMarketEditionStaticDataMapper.selectByExample(example);
		if (resList.size() > 0) {
			return resList.get(0).getReturnData();
		}
		return null;
	}

	/**
	 * 判断是否要加参数
	 * @author 李成兵
	 * @since 2018/5/31
	 * @parap judueRes：0：无需查询数据， 1
	 * @param1：如果是手动造数据， 那第一个返回值就是数据
	 * @param2：方法需要多个数据，那根据参数 返回action，再去查询数据，返回对应得数据
	 * @param2：如果什么都不要干涉，那直接查询数据，返回数据
	 * @return
	 */
	public String[] judgeMethodParam(String action, Map<String, Object> allAtrtibute) {
		String judueRes = "2";
		String resDataOrAction = "";
		// 手动造得动态数据，比如月份要变化等
		Map<String, Object> resMap = new HashMap<>();
		if ("getCompProfitMonth".equals(action) || "getCompProfitOffHalfYear".equals(action)) {
			List<Map<String, Object>> resList = new ArrayList<>();
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 6);
			resMap.put("data", resList);
			// 动态处理半年数据
			for (Integer i = 4; i >= -1; i--) {
				Map<String, Object> rMap = new HashMap<>();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, -i);
				int moth = calendar.get(Calendar.MONTH);
				int year = calendar.get(Calendar.YEAR);
				String yearMonth = getYearAndMonth(moth, year);
				rMap.put("dateCount", yearMonth);
				rMap.put("receivableProfit", (moth + 1) * 1000);
				rMap.put("actualProfit", (moth + 1) * 1500);
				resList.add(rMap);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if ("getBasicDetails".equals(action)) {
			List<Map<String, Object>> resList = new ArrayList<>();
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", resList);
			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			for (Integer i = 1; i <= 4; i++) {
				Map<String, Object> rMap = new HashMap<>();
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				rMap.put("dkCount", 840 * i);
				rMap.put("leaseCjCount", 350 * i);
				rMap.put("custDjCount", 225 * i);
				rMap.put("userCount", 225 * i);
				rMap.put("leaseSignCount", 33 * i);
				rMap.put("weekTime", yearAndMonthDay + "-" + yearAndMonthDay2);
				rMap.put("fkCount", 150 * i);
				rMap.put("saleSignCount", 15 * i);
				rMap.put("saleCjCount", 30 * i);
				rMap.put("houseDjCount", 350 * i);
				rMap.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				resList.add(rMap);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";

		} else if ("getConversionRatioAnalysisOffCouvert".equals(action)) {
			Map<String, List<Map<String, Object>>> dataList = new HashMap<>();
			List<Map<String, Object>> funKanRateDtoList = new ArrayList<>();
			List<Map<String, Object>> daiKanRateDtoList = new ArrayList<>();
			List<Map<String, Object>> signRateDtoList = new ArrayList<>();
			dataList.put("funKanRateDtoList", funKanRateDtoList);
			dataList.put("daiKanRateDtoList", daiKanRateDtoList);
			dataList.put("signRateDtoList", signRateDtoList);
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", dataList);
			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			for (Integer i = 1; i <= 4; i++) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				Map<String, Object> fkMap = new HashMap<>();
				fkMap.put("fkRate", 0.2 * i);
				fkMap.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				funKanRateDtoList.add(fkMap);
				Map<String, Object> dkMap = new HashMap<>();
				dkMap.put("dkRate", 0.3 * i);
				dkMap.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				daiKanRateDtoList.add(dkMap);
				Map<String, Object> srMap = new HashMap<>();
				srMap.put("dkCount", 0.5 * i);
				srMap.put("signRate", 0.1 * i);
				srMap.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				signRateDtoList.add(srMap);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if ("getHouseCustAddCountData".equals(action)) {
			Object o = allAtrtibute.get("caseType");
			// 制造浮动系数
			Double num = 18.2d;
			if ("102".equals(o)) {
				num = 14.8d;
			}
			Map<String, List<Map<String, Object>>> dataList = new HashMap<>();
			List<Map<String, Object>> house0 = new ArrayList<>();
			List<Map<String, Object>> house1 = new ArrayList<>();
			List<Map<String, Object>> house2 = new ArrayList<>();
			List<Map<String, Object>> house3 = new ArrayList<>();
			List<Map<String, Object>> cust1 = new ArrayList<>();
			List<Map<String, Object>> cust2 = new ArrayList<>();
			List<Map<String, Object>> cust3 = new ArrayList<>();
			List<Map<String, Object>> cust4 = new ArrayList<>();
			dataList.put("house0", house0);
			dataList.put("house1", house1);
			dataList.put("house2", house2);
			dataList.put("house3", house3);
			dataList.put("cust1", cust1);
			dataList.put("cust2", cust2);
			dataList.put("cust3", cust3);
			dataList.put("cust4", cust4);
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", dataList);
			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			for (Integer i = 1; i <= 4; i++) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				Map<String, Object> house0Map = new HashMap<>();
				house0Map.put("house", 3 * num);
				house0Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				house0.add(house0Map);
				Map<String, Object> house1Map = new HashMap<>();
				house1Map.put("house", 2 * num);
				house1Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				house1.add(house1Map);
				Map<String, Object> house2Map = new HashMap<>();
				house2Map.put("house", 4 * num);
				house2Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				house2.add(house2Map);
				Map<String, Object> house3Map = new HashMap<>();
				house3Map.put("house", 5 * num);
				house3Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				house3.add(house3Map);
				Map<String, Object> cust4Map = new HashMap<>();
				cust4Map.put("cust", 6 * num);
				cust4Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				cust4.add(cust4Map);
				Map<String, Object> cust1Map = new HashMap<>();
				cust1Map.put("cust", 3 * num);
				cust1Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				cust1.add(cust1Map);
				Map<String, Object> cust2Map = new HashMap<>();
				cust2Map.put("cust", 5 * num);
				cust2Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				cust2.add(cust2Map);
				Map<String, Object> cust3Map = new HashMap<>();
				cust3Map.put("cust", 4 * num);
				cust3Map.put("date", yearAndMonthDay + "-" + yearAndMonthDay2);
				cust3.add(cust3Map);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if ("getProfitRankingStatistics".equals(action)) {
			resDataOrAction = action + "_" + allAtrtibute.get("DIMENSION");
			// 多维度得返回数据
			judueRes = "1";
		} else if ("getWarmTaskList".equals(action) || "getMgrPhoneList".equals(action)
				|| "getAuditTaskList".equals(action) || "getHouseCustStatusData".equals(action)
				|| "getBuildSupplyDemandComparison".equals(action) || "getHouseBuyingPowerData".equals(action)) {
			resDataOrAction = action + "_" + allAtrtibute.get("caseType");
			// 多维度得返回数据
			judueRes = "1";
		} else if ("getMgrSubmitKeyLog".equals(action)) {
			resDataOrAction = action + "_" + allAtrtibute.get("sCaseType");
			judueRes = "1";
		} else if ("getProfitCountOffUser".equals(action) || "getTotalWorkCountRanking".equals(action)) {
			if ("USER".equals(allAtrtibute.get("dimension") + "")) {
				resDataOrAction = action + "_user";
				// 多维度得返回数据
				judueRes = "1";
			} else if ("DEPT".equals(allAtrtibute.get("dimension") + "")) {
				resDataOrAction = action + "_dept";
				// 多维度得返回数据
				judueRes = "1";
			}
		} else if ("getAuditTemplate".equals(action)) {
			Integer caseType = StringUtil.paseInteger((String) allAtrtibute.get("caseType"), 0);
			// 多维度得返回数据
			if (1 == caseType) {
				resDataOrAction = action + "_sale";
			} else if (2 == caseType) {
				resDataOrAction = action + "_lease";
			} else if (3 == caseType) {
				resDataOrAction = action + "_buy";
			} else if (4 == caseType) {
				resDataOrAction = action + "_rent";
			} else {
				resDataOrAction = action + "_out";
			}
			judueRes = "1";
		} else if ("getHouseCustAddRank".equals(action)) {
			Integer order = StringUtil.paseInteger((String) allAtrtibute.get("order"), 0);
			resDataOrAction = action + "_" + order;
			// 多维度得返回数据
			judueRes = "1";
		} else if ("getStoreDataDaiKan".equals(action) || "getStoreDataAnalysis".equals(action)
				|| "getStoreDataAnalysisByPrice".equals(action) || "getStoreDataRanking".equals(action)
				|| "getStoreDataCount".equals(action) || "getHouseCustFlowAnalysisCountList".equals(action)
				|| "getHouseCustFlowAnalysisCountListForReport".equals(action)) {
			Integer caseType = StringUtil.paseInteger((String) allAtrtibute.get("caseType"), 0);
			resDataOrAction = action + "_" + caseType;
			judueRes = "1";
		} else if ("getOperationalDataAnalysisLeaseChart".equals(action)) {
			List<Map<String, Object>> dataList = new ArrayList<>();
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", dataList);

			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			int num = 13;
			for (Integer i = 0; i <= 3; i++) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				Map<String, Object> map = new HashMap<>();
				map.put("leaseFkCount", (2 + i) * num);
				map.put("rentAddCount", (3 + i) * num);
				map.put("rentDkCount", (1 + i) * num);
				map.put("leaseAddCount", (4 + i) * num);
				map.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				dataList.add(map);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if ("getOperationalDataAnalysisSaleChart".equals(action)) {
			List<Map<String, Object>> dataList = new ArrayList<>();
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", dataList);

			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			int num = 13;
			for (Integer i = 0; i <= 3; i++) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				Map<String, Object> map = new HashMap<>();
				map.put("saleAddCount", (2 + i) * num);
				map.put("buyDkCount", (3 + i) * num);
				map.put("saleFkCount", (1 + i) * num);
				map.put("saleSignCount", (5 + i) * num);
				map.put("buyAddCount", (4 + i) * num);
				map.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				dataList.add(map);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if ("getOperationsAndProfitCountOffChart".equals(action)) {
			List<Map<String, Object>> dataList = new ArrayList<>();
			resMap.put("errCode", 200);
			resMap.put("serverTime", DateTimeHelper.getSystemDate());
			resMap.put("total", 4);
			resMap.put("data", dataList);
			// 当前日期
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.WEEK_OF_MONTH, -3);
			c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			int num = 13;
			for (Integer i = 0; i <= 3; i++) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				Integer day = c1.get(Calendar.DAY_OF_MONTH);
				Integer month = c1.get(Calendar.MONTH) + 1;
				Integer year = c1.get(Calendar.YEAR);
				String yearAndMonthDay = getYearAndMonthDay(day, month, year);
				c1.add(Calendar.WEEK_OF_MONTH, 1);
				c1.add(Calendar.DAY_OF_MONTH, -1);
				Calendar c = Calendar.getInstance();
				if (c1.after(c)) {
					c1 = c;
				}
				Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
				Integer month2 = c1.get(Calendar.MONTH) + 1;
				Integer year2 = c1.get(Calendar.YEAR);
				String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);
				Map<String, Object> map = new HashMap<>();
				map.put("houseTgCount", (2 + i) * num);
				map.put("profitCount", (3 + i) * num);
				map.put("xqzjCount", (1 + i) * num);
				map.put("dkCount", (6 + i) * num);
				map.put("housePublishCount", (3 + i) * num);
				map.put("trueHouseCount", (5 + i) * num);
				map.put("countDate", yearAndMonthDay + "-" + yearAndMonthDay2);
				map.put("dateCount", yearAndMonthDay + "-" + yearAndMonthDay2);
				dataList.add(map);
			}
			resDataOrAction = JSON.toJSONString(resMap);
			judueRes = "0";
		} else if("getWorkCountStatistic".equals(action)) {
			Integer dateType = StringUtil.paseInteger((String) allAtrtibute.get("dateType"), 0);
			resDataOrAction = action + "_" + dateType;
			// 多维度得返回数据
			judueRes = "1";
		} else {
			// 无需处理的数据
			resDataOrAction = action;
		}
		return new String[] { resDataOrAction, judueRes };
	}

	private String getYearAndMonth(Integer month, Integer year) {
		String yearMonth = "";
		if(month < 9) {
			if(0 == month) {
				year = year-1;
				yearMonth = year + "-12";
			}else {
				yearMonth = year + "-0" + month;
			}
		}else {
			yearMonth = year + "-" + month;
		}
		return yearMonth;
	}

	private static String getYearAndMonthDay(Integer day, Integer month, Integer year) {
		String yearMonth = "";
		if(month < 9) {
			if(0 == month) {
				year = year-1;
				yearMonth = year + "-12";
			}else {
				yearMonth = year + "-0" + month;
			}
		}else {
			yearMonth = year + "-" + month;
		}

		if(day < 10) {
			yearMonth = year + "-" + month+"-0"+day;
		}else {
			yearMonth = year + "-" + month+"-"+day;
		}
		return yearMonth;
	}

	public static void main(String[] args) {
		// 当前日期
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.WEEK_OF_MONTH, -3);
		c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c1.add(Calendar.DAY_OF_MONTH, -1);

		for (Integer i = 0;i <=3; i++) {
			Map<String, Object> rMap = new HashMap<>();
			c1.add(Calendar.DAY_OF_MONTH, 1);
			Integer day = c1.get(Calendar.DAY_OF_MONTH);
			Integer month = c1.get(Calendar.MONTH)+1;
			Integer year = c1.get(Calendar.YEAR);
			String yearAndMonthDay = getYearAndMonthDay(day, month, year);
			c1.add(Calendar.WEEK_OF_MONTH, 1);
			c1.add(Calendar.DAY_OF_MONTH, -1);
			Calendar c = Calendar.getInstance();
			if(c1.after(c)) {
				c1 = c;
			}
			Integer day2 = c1.get(Calendar.DAY_OF_MONTH);
			Integer month2 = c1.get(Calendar.MONTH)+1;
			Integer year2 = c1.get(Calendar.YEAR);
			String yearAndMonthDay2 = getYearAndMonthDay(day2, month2, year2);

			rMap.put("dkCount", "84");
			rMap.put("leaseCjCount", "10");
			rMap.put("custDjCount", "225");
			rMap.put("userCount", "200");
			rMap.put("leaseSignCount", "15");
			rMap.put("weekTime", yearAndMonthDay+"-"+yearAndMonthDay2);
			rMap.put("fkCount", "193");
			rMap.put("saleSignCount", "2");
			rMap.put("saleCjCount", "2");
			rMap.put("houseDjCount", "359");
			rMap.put("dateCount", yearAndMonthDay+"-"+yearAndMonthDay2);
			System.out.println(rMap);
		}
	}
}
