package com.myfun.erpWeb.statisticalAnalysis;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindbRpt.dao.AdmindbRptMarketingCountInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunStatisticTotleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunStatisticRateDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.SortUtil;
import com.myfun.utils.StringUtil;

@RestController
@RequestMapping("/statistic")
public class OperationController extends BaseController{
	@Autowired ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpFunProfitMapper erpFunProfitMapper;
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunStatisticTotleMapper erpFunStatisticTotleMapper;
	@Autowired AdmindbRptMarketingCountInfoMapper admindbRptMarketingCountInfoMapper;
	
	/**
	 * 业绩与营销推广首页接口
	 * @author 方李骥
	 * @since 2017年7月29日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPerformanceMarketingAnalysis")
	public ResponseJson getPerformanceMarketingAnalysis(@RequestBody BaseMapParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		param.setInteger("cityId", cityId);
		param.setInteger("compId",getOperator().getCompId());
		//当月时间
		String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
		param.setString("startTime", timeArr[0]);
		param.setString("endTime", timeArr[1]);
		param.setString("startMonthTime", timeArr[0]);
		// 本月人数
		Integer peopleMonthCount = erpFunUsersMapper.getUserCount(cityId, param.getMap(), timeArr[0], timeArr[1]);
		timeArr = DateUtil.getCurrentWeekByTodayTimeArr();
		// 本周人数
		Integer peopleWeekCount = erpFunUsersMapper.getUserCount(cityId, param.getMap(), timeArr[0], timeArr[1]);
		param.setString("startWeekTime", timeArr[0]);
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		// 小区专家，房源推广，真房源，发布房源
		List<Map<String, Object>> funStatisticTotlelist = reportFunStatisticTotleMapper.PerformanceMarketingAnalysis(cityId, param.getMap());
		// 业绩
		List<Map<String, Object>> totalProfiTcountList = erpFunProfitMapper.getCompActualProfitAndPerProfit(getOperator().getCityId(), param.getMap());
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnData = new HashMap<String, Object>();
		returnList.add(returnData);
		if (totalProfiTcountList != null && !totalProfiTcountList.isEmpty()) {
			if(totalProfiTcountList.get(0) != null) {
				returnData.putAll(totalProfiTcountList.get(0));
			}
		}
		if (funStatisticTotlelist != null && !funStatisticTotlelist.isEmpty()) {
			if(funStatisticTotlelist.get(0) != null) {
				returnData.putAll(funStatisticTotlelist.get(0));
			}
		}
		returnList.stream().forEach((Map<String, Object> dataList) -> {
			dataList.put("peopleMonthCount", peopleMonthCount);
			dataList.put("peopleWeekCount", peopleWeekCount);
		});
		return ErpResponseJson.ok(returnList);
	}
	
	/**
	 * 营销推广与业绩分析-图表
	 * @author 熊刚
	 * @since 2017年7月21日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationsAndProfitCountOffChart")
	public ResponseJson getOperationsAndProfitCountOffChart(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String dateType = param.getString("dateType");
		if("2".equals(dateType)){
			String[] dateTimeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
			param.setString("startTime", dateTimeArr[0]);
			param.setString("endTime", dateTimeArr[1]);
		}else{
			param.setString("endTime",param.getString("endTime")+ " 23:59:59");
		}
		//拼接sql
		String column = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
		String erpProfitequeryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "a.CREATE_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
		param.setString("column", column);
		param.setString("erpProfitequeryColumn", erpProfitequeryColumn);
		List<Map<String,Object>> reportFunStatisticTotleList  = reportFunStatisticTotleMapper.getOperationsAndProfitCountOffChart(param.getMap()); 
		//查询业绩
		List<Map<String,Object>> erpFunDeptsDtoList = erpFunProfitMapper.getProfitDateCount(getOperator().getCityId(),param.getMap());
		
		Map<String, Map<String, Object>> reportFunStatisticTotleListMap = reportFunStatisticTotleList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("dateCount")), val -> val));
		Map<String, Map<String, Object>> erpFunDeptsMap = erpFunDeptsDtoList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("dateCount")), val -> val));
		
		//组装数据
		for (Entry<String, Map<String, Object>> entry : erpFunDeptsMap.entrySet()) {
			Map<String, Object> map = reportFunStatisticTotleListMap.get(entry.getKey());
			if(map == null) {
				reportFunStatisticTotleListMap.put(entry.getKey(), entry.getValue());
			} else {
				map.putAll(entry.getValue());
			}
		}
		List<Map<String, Object>> arrayList = new ArrayList<>(reportFunStatisticTotleListMap.values());
		SortUtil.sortForDateForListMap(arrayList, "dateCount", dateType);
		return ErpResponseJson.ok(arrayList);
	}
	
	/**
	 * 公司运营基本情况对比统计
	 * @author 熊刚
	 * @since 2017年7月13日
	 * @param   serchRange搜索范围  serchRangeId索范围的值 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBasicDetails")
	public ResponseJson getBasicDetails(@RequestBody BaseMapParam param) throws Exception {
		param.setString("dateType", "1");
		Integer compId = getOperator().getCompId();
		String[] fiveWeekTime = DateUtil.getFrontFourWeeksEndByTodayTimeArr();
		String startTime = fiveWeekTime[0];
		String endTime = fiveWeekTime[1];
		param.setString("startTime", startTime);
		param.setString("endTime", endTime+" 23:59:59");
		param.setInteger("compId", compId);
		if("USER".equals(param.getString("serchRange"))){
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		String admindbRptTrackqueryColumn = DateUtil.getDateDimensionGroupBy("1", "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
		param.setString("admindbRptTrackqueryColumn",admindbRptTrackqueryColumn);
		List<Map<String,Object>> erpFunStatisticTotleDtoList = reportFunStatisticTotleMapper.getBasicDetails(getOperator().getCityId(), param.getMap());
		List<Map<String, Object>> houseSignList = new ArrayList<>();
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			houseSignList = erpFunDealMapper.getSignOperationalDataAnalysisHasDealReport(getOperator().getCityId(), param.getMap());
		} else {
			houseSignList = erpFunStatisticTotleMapper.getSignOperationalDataAnalysisNoDealReport(getOperator().getCityId(), param.getMap());
		}
		//合并有合同的结果和无合同签单的结果
		houseSignList.stream().forEach((Map<String,Object> signData)->{
			signData.put("saleCjCount", StringUtil.parseInteger(signData.get("saleSignCount"), 0));
			signData.put("leaseCjCount", StringUtil.parseInteger(signData.get("leaseSignCount"), 0));
		});
		Map<String, Map<String, Integer>> countDateList = erpFunUsersService.getUserCountDateList(getOperator().getCityId(),compId,param.getString("serchRange"), param.getInteger("serchRangeId"),"comp_id", 0, "1",startTime,endTime);
		Map<String,Map<String,Object>> signDataMap = BeanUtil.listMapObjecttoMap(houseSignList, "dateCount");
		List<String> signDataKeys = BeanUtil.buildQueryKeysOffMapObject(houseSignList, "dateCount");
		// 补时间
		Map<String,String> dateDicMap = DateUtil.createDateDicOffConstomOffMap("1",startTime+"~"+endTime,"-",true);
		erpFunStatisticTotleDtoList.stream().forEach((Map<String,Object> dataMap) -> {
			Object val = dataMap.get("weekTime");
			String dateCountStr = val.toString();
			String index = dateDicMap.get(dateCountStr);
			Map<String,Integer> userMap = countDateList.get(compId.toString());
			if (userMap != null) {
				Integer userCount = userMap.get("count_"+index);
				dataMap.put("userCount", userCount);
			}
			Map<String,Object> signData = signDataMap.get(dateCountStr);
			if (signData != null) {
				dataMap.putAll(signData);
				signDataKeys.remove(dateCountStr);
			}
		});
		if(!signDataKeys.isEmpty()){
			signDataKeys.stream().forEach((String key) -> {
				Map<String,Object> signData = signDataMap.get(key);
				String index = dateDicMap.get(key);
				Map<String,Integer> userMap = countDateList.get(compId.toString());
				if (userMap != null) {
					Integer userCount = userMap.get("count_"+index);
					signData.put("userCount", userCount);
				}
				signData.put("weekTime", signData.get("dateCount"));
				erpFunStatisticTotleDtoList.add(signData);
			});
		}
		Map<String,Object> map = new HashMap<>();
		if(erpFunStatisticTotleDtoList!=null && !erpFunStatisticTotleDtoList.isEmpty()) {
			DataAnalysisUtil.repairDateForListMap(erpFunStatisticTotleDtoList, map, startTime, endTime, "1","weekTime");
		}
		return ErpResponseJson.ok(erpFunStatisticTotleDtoList);
	}
	
	/**
	 * 运营分析与业绩分析-报表
	 * @author 方李骥
	 * @since 2017年7月13日
	 * @param   serchRange搜索范围  serchRangeId索范围的值 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationsAndProfitCountOffReport")
	public ResponseJson getOperationsAndProfitCountOffReport(@RequestBody BaseMapParam param) throws Exception {
		param.setString("areaFlag", getOperator().getAreaFlag());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		if("2".equals(param.getString("dateType"))){
			String[] dateTimeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
			param.setString("startTime", dateTimeArr[0]);
			param.setString("endTime", dateTimeArr[1]);
		}else{
			param.setString("endTime",param.getString("endTime")+ " 23:59:59");
		}
		String dimension = param.getString("dimension");
		String areaFlag = param.getString("areaFlag");
		String queryDimensionColumn = DataAnalysisUtil.getRangeGroupbyStr(dimension, areaFlag, "");
		param.setString("queryDimensionColumn", queryDimensionColumn);
		//拼接sql
		String column = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
		String erpProfitequeryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "a.CREATE_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
		param.setString("column", column);
		param.setString("erpProfitequeryColumn", erpProfitequeryColumn);
		List<Map<String,Object>> reportFunStatisticTotleList  = reportFunStatisticTotleMapper.getOperationsAndProfitCountOffChart(param.getMap()); 
		//查询业绩
		List<Map<String,Object>> erpFunDeptsDtoList = erpFunProfitMapper.getOperationsAndProfitCountOffReport(getOperator().getCityId(),param.getMap());
		List<Map<String,Object>> rangeList = erpFunUsersMapper.getRangeListDaTaOfCompAreaToZero(getOperator().getCityId(),getOperator().getCompId() ,getOperator().getArchiveId(), param.getString("dimension"), param.getString("serchRange"), StringUtil.parseInteger(param.getString("serchRangeId"),0), getOperator().getAreaFlag(),"0",param.getString("userId"));
		String[] keyNames = new String[]{"range","countDate"};
		
		Map<String,Map<String,Object>> erpFunDeptsDtoMap = BeanUtil.listMapObjecttoMap(erpFunDeptsDtoList, keyNames);
		List<String> deptsDtoList = BeanUtil.buildQueryKeysOffMapObject(erpFunDeptsDtoList, keyNames);
		
		//补数据通过RANGE作为key来对应数据
		for (Map<String, Object> data : reportFunStatisticTotleList) {
			Object range = data.get("range");
			Object dateCount = data.get("countDate");
			String valStr = range.toString()+"#"+dateCount.toString();
			Map<String, Object> trueHouseData = erpFunDeptsDtoMap.get(valStr);
			if (trueHouseData != null) {
				data.putAll(trueHouseData);
				deptsDtoList.remove(valStr);
			}
		}
		if (!deptsDtoList.isEmpty()) {
			for (String key : deptsDtoList) {
				Map<String, Object> trueHouseData = erpFunDeptsDtoMap.get(key);
				if (trueHouseData != null) {
					reportFunStatisticTotleList.add(trueHouseData);
				}
			}
		}
	
		//查询需要补得时间段
		List<String> dateList = DateUtil.createDateDic(param.getString("dateType"), param.getString("startTime")+"~"+param.getString("endTime"));
		Map<String,List<Map<String,Object>>> dataListMap = BeanUtil.listMapObjecttoMapList(reportFunStatisticTotleList, "range");
		List<Map<String,List<Map<String,Object>>>> returnList = new ArrayList<>();
		
		for(Map<String,Object> rangeData:rangeList){
			Map<String,List<Map<String,Object>>> dataMap = new HashMap<String,List<Map<String,Object>>>();
			boolean flag = false;
			String rangeStr = rangeData.get("range").toString();
			List<Map<String,Object>> dataList = dataListMap.get(rangeStr);
			if(dataList!=null){
				dataMap.put(rangeStr,dataList);
				dataListMap.remove(rangeStr);
			}else{
				flag = true;
				dataList = new ArrayList<Map<String,Object>>();
				dataMap.put(rangeStr, dataList);
			}
			Map<String,Map<String,Object>> map = null;
			if(!flag){
				map = BeanUtil.listMapObjecttoMap(dataList, "countDate");
 			}
			for(String dateStr:dateList){
				if(flag){
						Map<String,Object> data = new HashMap<String,Object>();
						data.put("xqzjCount","0");
						data.put("houseTgCount","0");
						data.put("housePublishCount","0");
						data.put("trueHouseCount","0");
						data.put("dkCount","0");
						data.put("profitCount","0");
						data.put("countDate",dateStr);
						dataList.add(data);
				}else{
					Map<String,Object> data = map.get(dateStr);
					if(data==null){
						data = new HashMap<String,Object>();
						data.put("xqzjCount","0");
						data.put("houseTgCount","0");
						data.put("housePublishCount","0");
						data.put("trueHouseCount","0");
						data.put("dkCount","0");
						data.put("profitCount","0");
						data.put("countDate",dateStr);
						dataList.add(data);
					}
					
				}
			}
			Collections.sort(dataList, new Comparator<Map<String,Object>>() {
				@Override
				public int compare(Map<String, Object> o1, Map<String, Object> o2) {
					return o1.get("countDate").toString().compareTo(o2.get("countDate").toString());
				}
			});
			returnList.add(dataMap);
		}
		if(dataListMap.size()>0){
			for(String key:dataListMap.keySet()){
				Map<String,List<Map<String,Object>>> dataMap = new HashMap<String,List<Map<String,Object>>>();
				List<Map<String,Object>> dataList = dataListMap.get(key);
				dataMap.put(key, dataList);
				Map<String,Map<String,Object>> map = BeanUtil.listMapObjecttoMap(dataList, "countDate");
				for(String dateStr:dateList){
					Map<String,Object> data = map.get(dateStr);
					if(data==null){
						data = new HashMap<String,Object>();
						data.put("xqzjCount","0");
						data.put("houseTgCount","0");
						data.put("housePublishCount","0");
						data.put("trueHouseCount","0");
						data.put("dkCount","0");
						data.put("profitCount","0");
						data.put("countDate",dateStr);
						dataList.add(data);
					}
				}
				Collections.sort(dataList, new Comparator<Map<String,Object>>() {
					@Override
					public int compare(Map<String, Object> o1, Map<String, Object> o2) {
						return o1.get("countDate").toString().compareTo(o2.get("countDate").toString());
					}
				});
				returnList.add(dataMap);
			}
		}
		
		returnList.sort((val1, val2) -> {
			return val1.keySet().toArray(new String[]{})[0].compareTo(val2.keySet().toArray(new String[]{})[0]);
		});
		ErpResponseJson json = new ErpResponseJson(returnList);
		json.setExtra(param.getString("dimension"));
		return json;
	}
	
	/**
	 * 员工或门店业绩排名
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param   serchRange搜索范围  serchRangeId索范围的值 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getProfitCountOffUser")
	public ResponseJson getProfitCountOffUser(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		if(StringUtils.isBlank(param.getString("startTime"))){
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}else{
			if("2".equals(param.getString("dateType"))){
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			}else{
				param.setString("endTime", param.getString("endTime")+ " 23:59:59");
			}
		}
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		//查询数据
		List<Map<String,Object>> profitDataList = erpFunProfitMapper.getProfitCountOffUser(getOperator().getCityId(), param.getMap());
		if(profitDataList==null || profitDataList.isEmpty()){
			return  ErpResponseJson.ok(profitDataList);
		}
		Set<Integer> deptIds = BeanUtilsHelper.buildQueryKeysOffListMap(profitDataList, "deptId");
		Set<Integer> userIds = null;
		List<ErpFunUsers> userList = null;
		Map<String,ErpFunUsers> userMap = null;
		if("USER".equals(param.getString("dimension"))){
			userIds = BeanUtilsHelper.buildQueryKeysOffListMap(profitDataList, "userId");
			userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
			userMap = BeanUtilsHelper.listToMapObject(userList, "userId");
		}
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(getOperator().getCityId(), deptIds);
		Map<String, ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObject(deptList, "deptId");
		for (Map<String, Object> dataMap : profitDataList) {
			Object deptId = dataMap.get("deptId");
			if(deptId == null) {
				continue;
			}
			ErpFunDepts erpFunDepts = deptMap.get(deptId.toString());
			if (erpFunDepts != null) {
				dataMap.put("deptName", erpFunDepts.getDeptCname());
			}
			if ("USER".equals(param.getString("dimension"))) {
				ErpFunUsers erpFunUsers = userMap.get(dataMap.get("userId").toString());
				if (erpFunUsers != null) {
					dataMap.put("userName", erpFunUsers.getUserName());
				}
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(profitDataList);
		return responseJson;
	}
	
	/**
	 * 转换率分析图表 - 带看量排名
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param   serchRange搜索范围  serchRangeId索范围的值 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getConversionRatioAnalysisOffDkan")
	public ResponseJson getConversionRatioAnalysisOffDkan(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String dateType = param.getString("dateType");
		String caseType = param.getString("caseType");
		DataAnalysisController.changeSerchRange(param);
		if (StringUtils.isBlank(startTime)) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			if ("2".equals(dateType)) {
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(startTime, endTime);
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			} else {
				param.setString("endTime", endTime + " 23:59:59");
			}
		}
		Map<String, List<Map<String, Object>>> houseCustMap = new HashMap<>();
		if (StringUtils.isNotBlank(caseType)) {
			String caseHouse = "", caseCust = "";// 还必须要分开查询，前端不分接口就后台分了，房客源的所有组合都有可能
			for (String str : caseType.split(",")) {
				if ("1".equals(str) || "2".equals(str)) {
					caseHouse += str + ",";
				} else {
					caseCust += str + ",";
				}
			}
			if (caseHouse.length() > 0) {// 房源查询房勘量
				param.setObject("countType", "FK_COUNT");
				param.setObject("caseTypeArr", caseHouse.split(","));
				List<Map<String, Object>> profitDataList = reportFunStatisticTotleMapper.getConversionRatioAnalysisOffDkan(getOperator().getCityId(), param.getMap());
				houseCustMap.put("house", profitDataList);
			}
			if (caseHouse.length() > 0) {// 客源查询带看量
				param.setObject("countType", "DK_COUNT");
				param.setObject("caseTypeArr", caseHouse.split(","));
				List<Map<String, Object>> profitDataList = reportFunStatisticTotleMapper.getConversionRatioAnalysisOffDkan(getOperator().getCityId(), param.getMap());
				houseCustMap.put("cust", profitDataList);
			}
		}
		return ErpResponseJson.ok(houseCustMap);
	}
	
	/**
	 * 转换率-带看，房勘，成交转换率对比
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getConversionRatioAnalysisOffVariousParts")
	public ResponseJson getConversionRatioAnalysisOffVariousParts(@RequestBody BaseMapParam param) throws Exception{
		//返回数据的map
		Map<String,Object> dataMap = new HashMap<String,Object>();
		param.setInteger("compId", getOperator().getCompId());
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			if("2".equals(param.getString("dateType"))){
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			}else{
				param.setString("endTime", param.getString("endTime")+" 23:59:59");
			}
		}
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		// 查询带看数据
		List<Map<String, Object>> dkList = reportFunStatisticTotleMapper.getDkContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		// 查询带看总量数据
		Map<String, Object> totalDk = reportFunStatisticTotleMapper.getTotalDkContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		// 查询房勘数据
		List<Map<String, Object>> fkList = reportFunStatisticTotleMapper.getFkContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		// 查询房勘总量数据
		Map<String, Object> totalFk = reportFunStatisticTotleMapper.getTotalFkContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			param.setInteger("deptType", 1);
		}
		// 查询成交数据
		List<Map<String, Object>> cjList = erpFunDealMapper.getCjContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		// 查询成交数据总量
		Map<String, Object> totalCj = erpFunDealMapper.getTotalCjContrastOffRatioAnalysis(getOperator().getCityId(), param.getMap());
		Set<Integer> deptIds = new HashSet<>();
		if (!dkList.isEmpty()) {
			deptIds.addAll(BeanUtilsHelper.buildQueryKeysOffListMap(dkList, "deptId"));
		}
		if (!fkList.isEmpty()) {
			deptIds.addAll(BeanUtilsHelper.buildQueryKeysOffListMap(fkList, "deptId"));
		}
		if (!cjList.isEmpty()) {
			deptIds.addAll(BeanUtilsHelper.buildQueryKeysOffListMap(cjList, "deptId"));
		}
		if (!deptIds.isEmpty()) {
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(getOperator().getCityId(),deptIds);
			Map<String, ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObject(deptList, "deptId");
			if (!dkList.isEmpty()) {
				int total = 0;
				Map<String, Object> otherData = new HashMap<>();
				for (Map<String, Object> data : dkList) {
					ErpFunDepts erpFunDepts = deptMap.get(data.get("deptId").toString());
					if (erpFunDepts != null) {
						data.put("deptName", erpFunDepts.getDeptCname());
					}
					total += StringUtil.parseInteger(data.get("dkCount").toString(), 0);
				}
				Integer otherCount = StringUtil.parseInteger(totalDk.get("totalCount").toString(), 0) - total;
				if (otherCount > 0) {
					otherData.put("deptName", "其他");
					otherData.put("dkCount", otherCount);
					dkList.add(otherData);
				}
				dataMap.put("dkList", dkList);
			}
			if (!fkList.isEmpty()) {
				int total = 0;
				Map<String, Object> otherData = new HashMap<>();
				for (Map<String, Object> data : fkList) {
					ErpFunDepts erpFunDepts = deptMap.get(data.get("deptId").toString());
					if (erpFunDepts != null) {
						data.put("deptName", erpFunDepts.getDeptCname());
					}
					total += StringUtil.parseInteger(data.get("fkCount").toString(), 0);
				}
				Integer otherCount = StringUtil.parseInteger(totalFk.get("totalCount").toString(), 0) - total;
				if (otherCount > 0) {
					otherData.put("deptName", "其他");
					otherData.put("fkCount", otherCount);
					fkList.add(otherData);
				}
				dataMap.put("fkList", fkList);
			}
			if (!cjList.isEmpty()) {
				int total = 0;
				Map<String, Object> otherData = new HashMap<>();
				for (Map<String, Object> data : cjList) {
					ErpFunDepts erpFunDepts = deptMap.get(String.valueOf(data.get("deptId")));
					if (erpFunDepts != null) {
						data.put("deptName", erpFunDepts.getDeptCname());
					}
					total += StringUtil.parseInteger(data.get("cjCount").toString(), 0);
				}
				if (totalCj != null) {
					Integer otherCount = StringUtil.parseInteger(totalCj.get("cjCount")) - total;
					if (otherCount > 0) {
						otherData.put("deptName", "其他");
						otherData.put("cjCount", otherCount);
						cjList.add(otherData);
					}
				}
				dataMap.put("cjList", cjList);
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(dataMap);
		return responseJson;
	}
	
	/**
	 * 运营分析-运营数据柱状图-买卖业务
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationalDataAnalysisSaleChart")
	public ResponseJson getOperationalDataAnalysisSaleChart(@RequestBody BaseMapParam param) throws Exception{
		param.setObject("caseType", "101");
		return getOperationalDataAnalysis(param);
	}
	
	/**
	 * 运营分析-运营数据柱状图-买卖业务
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationalDataAnalysisSalePie")
	public ResponseJson getOperationalDataAnalysisSalePie(@RequestBody BaseMapParam param) throws Exception{
		param.setObject("caseType", "101");
		return getOperationalDataAnalysisPie(param);
	}
	
	/**
	 * 运营分析-运营数据柱状图-买卖业务
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationalDataAnalysisLeasePie")
	public ResponseJson getOperationalDataAnalysisLeasePie(@RequestBody BaseMapParam param) throws Exception{
		param.setObject("caseType", "102");
		return getOperationalDataAnalysisPie(param);
	}
	
	private ResponseJson getOperationalDataAnalysisPie(BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			if("2".equals(param.getString("dateType"))){
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			}
		}
		if("USER".equals(param.getString("serchRange"))){
			ErpFunUsers userInfo = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getInteger("serchRangeId"));
			param.setInteger("archiveId", userInfo.getArchiveId());
		}
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnList.add(returnData);
		//新增量 
		Map<String,Object> houseCustAddData = reportFunStatisticTotleMapper.getHouseCustAddOperationalDataAnalysisPie(getOperator().getCityId(), param.getMap());
		//fk量 
		Map<String,Object> houseFkData = reportFunStatisticTotleMapper.getFkOperationalDataAnalysisPie(getOperator().getCityId(), param.getMap());
		//dk量 
		Map<String,Object> custDkData = reportFunStatisticTotleMapper.getDkOperationalDataAnalysisPie(getOperator().getCityId(), param.getMap());
		//sign量 
		Map<String,Object> signData = null;
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			signData = erpFunDealMapper.getSignOperationalDataAnalysisDealPie(getOperator().getCityId(), param.getMap());
		} else {
			signData = erpFunStatisticTotleMapper.getSignOperationalDataAnalysisNoDealPie(getOperator().getCityId(), param.getMap());
		}
		//totaldk量 
		//sign量
		Map<String,Object> totalDkData = reportFunStatisticTotleMapper.getTotalDkOperationalDataAnalysisPie(getOperator().getCityId(), param.getMap());
		if(houseCustAddData!=null){
			returnData.putAll(houseCustAddData);
		}
		if(houseFkData!=null){
			returnData.putAll(houseFkData);
		}
		if(custDkData!=null){
			returnData.putAll(custDkData);
		}
		if(signData!=null){
			returnData.putAll(signData);
		}
		if(totalDkData!=null){
			returnData.putAll(totalDkData);
		}
		return ErpResponseJson.ok(returnList);
	}
	
	/**
	 * 运营分析-运营数据报表
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationalDataAnalysisReport")
	public ResponseJson getOperationalDataAnalysisReport(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		String dateType = param.getString("dateType");
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		if (StringUtils.isBlank(startTime)) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else if ("2".equals(dateType)) {
			String[] timeArr = DateUtil.getDateRangeOffTwoMonth(startTime, endTime);
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}
		if ("USER".equals(param.getString("serchRange"))) {
			ErpFunUsers userInfo = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getInteger("serchRangeId"));
			param.setInteger("archiveId", userInfo.getArchiveId());
		}
		// 查询带看数据
		List<Map<String, Object>> houseOrCustAddList = reportFunStatisticTotleMapper.getHouseCustAddOperationalDataAnalysisReport(getOperator().getCityId(), param.getMap());
		// 查询房勘数据
		List<Map<String, Object>> houseFkList = reportFunStatisticTotleMapper.getFkOperationalDataAnalysisReport(getOperator().getCityId(), param.getMap());
		// 查询房勘数据
		List<Map<String, Object>> houseDkList = reportFunStatisticTotleMapper.getDkOperationalDataAnalysisReport(getOperator().getCityId(), param.getMap());
		// 查询无合同的单量 
		List<Map<String, Object>> houseSignList = null;
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			houseSignList = erpFunDealMapper.getSignOperationalDataAnalysisHasDealReport(getOperator().getCityId(), param.getMap());
		} else {
			houseSignList = erpFunDealMapper.getSignOperationalDataAnalysisNoDealReport(getOperator().getCityId(), param.getMap());
		}
		Map<String,Map<String,Object>> houseFkMap = BeanUtil.listMapObjecttoMap(houseFkList, "dateCount");
		Map<String,Map<String,Object>> houseDkMap = BeanUtil.listMapObjecttoMap(houseDkList, "dateCount");
		Map<String,Map<String,Object>> houseSignMap = BeanUtil.listMapObjecttoMap(houseSignList, "dateCount");
		List<String> houseFkKeyList = BeanUtil.buildQueryKeysOffMapObject(houseFkList, "dateCount");
		List<String> houseDkKeyList = BeanUtil.buildQueryKeysOffMapObject(houseDkList, "dateCount");
		List<String> houseSignKeyList = BeanUtil.buildQueryKeysOffMapObject(houseSignList, "dateCount");
		//补数据通过RANGE作为key来对应数据
		for (Map<String, Object> data : houseOrCustAddList) {
			Object val = data.get("dateCount");
			String valStr = val.toString();
			Map<String, Object> fkData = houseFkMap.get(valStr);
			if (fkData != null) {
				data.putAll(fkData);
				houseFkKeyList.remove(valStr);
			}
			Map<String, Object> dkData = houseDkMap.get(valStr);
			if (dkData != null) {
				data.putAll(dkData);
				houseDkKeyList.remove(valStr);
			}
			Map<String, Object> signData = houseSignMap.get(valStr);
			if (signData != null) {
				data.putAll(signData);
				houseSignKeyList.remove(valStr);
			}
		}
		if (!houseDkKeyList.isEmpty()) {
			for (String key : houseDkKeyList) {
				Map<String, Object> dkData = houseDkMap.get(key);
				Map<String, Object> fkData = houseFkMap.get(key);
				Map<String, Object> signData = houseSignMap.get(key);
				if (fkData != null) {
					dkData.putAll(fkData);
					houseFkKeyList.remove(key);
				}
				if (signData != null) {
					dkData.putAll(signData);
					houseSignKeyList.remove(key);
				}
				houseOrCustAddList.add(dkData);
			}
		}
		if (!houseFkKeyList.isEmpty()) {
			for (String key : houseFkKeyList) {
				Map<String, Object> fkData = houseFkMap.get(key);
				Map<String, Object> signData = houseSignMap.get(key);
				if (signData != null) {
					fkData.putAll(signData);
					houseSignKeyList.remove(key);
				}
				houseOrCustAddList.add(fkData);
			}
		}
		if (!houseSignKeyList.isEmpty()) {
			for (String key : houseSignKeyList) {
				Map<String, Object> signData = houseSignMap.get(key);
				houseOrCustAddList.add(signData);
			}
		}
		if (houseOrCustAddList != null && !houseOrCustAddList.isEmpty()) {
			// 补时间数据
			DataAnalysisUtil.repairDateForListMap(houseOrCustAddList, new HashMap<>(), param.getString("startTime"), param.getString("endTime"),param.getString("dateType"), "dateCount");
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(houseOrCustAddList);
		return responseJson;
	}
	
	/**
	 * 运营分析-运营数据柱状图-买卖业务
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOperationalDataAnalysisLeaseChart")
	public ResponseJson getOperationalDataAnalysisLeaseChart(@RequestBody BaseMapParam param) throws Exception{
		param.setObject("caseType", "102");
		return getOperationalDataAnalysis(param);
	}
	private ResponseJson getOperationalDataAnalysis(BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		// 判断前端是否传了时间段，如果没有传时间段，那么后台按本月来计算
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		} else {
			if("2".equals(param.getString("dateType"))){
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			}
		}
		if ("USER".equals(param.getString("serchRange"))) {
			ErpFunUsers userInfo = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getInteger("serchRangeId"));
			param.setInteger("archiveId", userInfo.getArchiveId());
		}
		// 查询带看数据
		List<Map<String, Object>> houseOrCustAddList = reportFunStatisticTotleMapper.getOperationalDataAnalysisHouseCustAddCount(getOperator().getCityId(), param.getMap());
		// 查询房勘数据
		List<Map<String, Object>> houseFkList = reportFunStatisticTotleMapper.getOperationalDataAnalysisHouseFkCount(getOperator().getCityId(), param.getMap());
		// 查询房勘数据
		List<Map<String, Object>> houseDkList = reportFunStatisticTotleMapper.getOperationalDataAnalysisCustDkCount(getOperator().getCityId(), param.getMap());
		//55
		List<Map<String, Object>> houseSignList = null;
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			houseSignList = erpFunDealMapper.getOperationalDataAnalysisHouseCjCount(getOperator().getCityId(), param.getMap());
		} else {
			houseSignList = erpFunStatisticTotleMapper.getOperationalDataAnalysisHouseCjNoDealCount(getOperator().getCityId(), param.getMap());
		}
		// 查询签约数据 
		Map<String,Map<String,Object>> houseFkMap = BeanUtil.listMapObjecttoMap(houseFkList, "dateCount");
		Map<String,Map<String,Object>> houseDkMap = BeanUtil.listMapObjecttoMap(houseDkList, "dateCount");
		Map<String,Map<String,Object>> houseSignMap = BeanUtil.listMapObjecttoMap(houseSignList, "dateCount");
		List<String> houseFkKeyList = BeanUtil.buildQueryKeysOffMapObject(houseFkList, "dateCount");
		List<String> houseDkKeyList = BeanUtil.buildQueryKeysOffMapObject(houseDkList, "dateCount");
		List<String> houseSignKeyList = BeanUtil.buildQueryKeysOffMapObject(houseSignList, "dateCount");
		//补数据通过RANGE作为key来对应数据
		for (Map<String, Object> data : houseOrCustAddList) {
			Object val = data.get("dateCount");
			String valStr = val.toString();
			Map<String, Object> fkData = houseFkMap.get(valStr);
			if (fkData != null) {
				data.putAll(fkData);
				houseFkKeyList.remove(valStr);
			}
			Map<String, Object> dkData = houseDkMap.get(valStr);
			if (dkData != null) {
				data.putAll(dkData);
				houseDkKeyList.remove(valStr);
			}
			Map<String, Object> signData = houseSignMap.get(valStr);
			if (signData != null) {
				data.putAll(signData);
				houseSignKeyList.remove(valStr);
			}
		}
		if (!houseDkKeyList.isEmpty()) {
			for (String key : houseDkKeyList) {
				Map<String, Object> dkData = houseDkMap.get(key);
				Map<String, Object> fkData = houseFkMap.get(key);
				Map<String, Object> signData = houseSignMap.get(key);
				if (fkData != null) {
					dkData.putAll(fkData);
					houseFkKeyList.remove(key);
				}
				if (signData != null) {
					dkData.putAll(signData);
					houseSignKeyList.remove(key);
				}
				houseOrCustAddList.add(dkData);
			}
		}
		if (!houseFkKeyList.isEmpty()) {
			for (String key : houseFkKeyList) {
				Map<String, Object> fkData = houseFkMap.get(key);
				Map<String, Object> signData = houseSignMap.get(key);
				if (signData != null) {
					fkData.putAll(signData);
					houseSignKeyList.remove(key);
				}
				houseOrCustAddList.add(fkData);
			}
		}
		if (!houseSignKeyList.isEmpty()) {
			for (String key : houseSignKeyList) {
				Map<String, Object> signData = houseSignMap.get(key);
				houseOrCustAddList.add(signData);
			}
		}
		if (houseOrCustAddList != null && !houseOrCustAddList.isEmpty()) {
			// 补时间数据
			DataAnalysisUtil.repairDateForListMap(houseOrCustAddList, new HashMap<>(), param.getString("startTime"), param.getString("endTime"),param.getString("dateType"), "dateCount");
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(houseOrCustAddList);
		return responseJson;
	}
	
	/**
	 * 转化率分析图表-转化率走势分析
	 * @author 何传强
	 * @since 2017年7月24日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getConversionRatioAnalysisOffCouvert")
	public ResponseJson getConversionRatioAnalysisOffCouvert(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		if ("USER".equals(serchRange)) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		String dateType = param.getString("dateType");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String[] dateArr=new String[2];
		if ("2".equals(dateType)) {
			dateArr = DateUtil.getDateRangeOffTwoMonth(startTime, endTime);
			if (StringUtil.isNotBlank(dateArr[0])) {
				param.setString("startTime", dateArr[0]);
			}
			if (StringUtil.isNotBlank(dateArr[1])) {
				param.setString("endTime", dateArr[1]);
			}
		}else if ("0".equals(dateType) || "1".equals(dateType)) {
			if (StringUtil.isNotBlank(startTime)) {
				param.setString("startTime", startTime+" 00:00:00");
			}
			if (StringUtil.isNotBlank(endTime)) {
				param.setString("endTime", endTime+" 23:59:59");
			}
			dateArr = new String[]{param.getString("startTime"),param.getString("endTime")};
		}else {
			//获取当前时间,向前推四周
			dateArr = DateUtil.getFrontFourWeeksEndByTodayTimeArr();
			if (StringUtil.isNotBlank(dateArr[0])) {
				param.setString("startTime", dateArr[0]+" 00:00:00");
			}
			if (StringUtil.isNotBlank(dateArr[1])) {
				param.setString("endTime", dateArr[1]+" 23:59:59");
			}
			dateType = "1";
		}
		// 时间统计维度（0 = 日统计 1 = 周统计 2月统计）
		String dateColumn = DateUtil.getDateDimensionGroupBy(dateType, "a.CREATE_TIME", dateArr);
		param.setObject("dateColumn", dateColumn);
		String dateColumnB = DateUtil.getDateDimensionGroupBy(dateType, "b.CREATE_TIME", dateArr);
		param.setObject("dateColumnB", dateColumnB);
		String signDateColumnHasDeal = DateUtil.getDateDimensionGroupBy(dateType, "B.SIGN_DATE", dateArr);
		param.setObject("signDateColumnHasDeal", signDateColumnHasDeal);
		String signDateColumnNoDeal = DateUtil.getDateDimensionGroupBy(dateType, "A.CREATE_TIME", dateArr);
		param.setObject("signDateColumnNoDeal", signDateColumnNoDeal);
		Map<String, Object> resultMap = new HashMap<>();
		// 查询带看率 --查询时间范围内，新增的客源
		List<ErpFunStatisticRateDto> daiKanRateDtoList = reportFunStatisticTotleMapper.getDaiKanRateCount(getOperator().getCityId(), param.getMap());
		if (daiKanRateDtoList.size() > 0) {
			for (ErpFunStatisticRateDto erpFunStatisticRateDto : daiKanRateDtoList) {
				String dkRate = erpFunStatisticRateDto.getDkRate();
				BigDecimal dkRateBd = new BigDecimal(dkRate);
				String dkRateStr = new BigDecimal(dkRateBd + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				erpFunStatisticRateDto.setDkRate(dkRateStr);// 将科学计数法转为普通计数
			}
			// 补时间数据
			ErpFunStatisticRateDto baseObj = new ErpFunStatisticRateDto();
			DataAnalysisUtil.repairDateForListObj(daiKanRateDtoList, "dateCount", baseObj, dateArr[0], dateArr[1],
					dateType);
			resultMap.put("daiKanRateDtoList", daiKanRateDtoList);
		}
		//房勘率
		List<ErpFunStatisticRateDto> funKanRateDtoList = reportFunStatisticTotleMapper.getFunKanRateCount(getOperator().getCityId(),param.getMap());
		if (funKanRateDtoList.size() > 0) {
			for (ErpFunStatisticRateDto erpFunStatisticRateDto : funKanRateDtoList) {
				String fkRate = erpFunStatisticRateDto.getFkRate();
				BigDecimal fkRateBd=new BigDecimal(fkRate);
				String fkRateStr = new BigDecimal(fkRateBd+"").setScale(2,BigDecimal.ROUND_HALF_UP).toString();
				erpFunStatisticRateDto.setFkRate(fkRateStr);
			}
			// 补时间数据
			ErpFunStatisticRateDto baseObj = new ErpFunStatisticRateDto();
			DataAnalysisUtil.repairDateForListObj(funKanRateDtoList, "dateCount", baseObj, dateArr[0], dateArr[1], dateType);
			resultMap.put("funKanRateDtoList", funKanRateDtoList);
		}
		//成交率
		List<ErpFunStatisticRateDto> signRateDtoList = new ArrayList<>();
		List<ErpFunStatisticRateDto> signRateCountTempList = null;
		Integer userId = param.getInteger("userId");
		if (userId != null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(getOperator().getCityId(), userId);
			Integer archiveId = erpFunUsers.getArchiveId();
			if (archiveId != null) {
				param.setInteger("archiveId", archiveId);
			}
		}
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			signRateDtoList = reportFunStatisticTotleMapper.getSignRateCountHasDeal(getOperator().getCityId(), param.getMap());
			signRateCountTempList = erpFunDealMapper.getSignRateCountHasDeal(getOperator().getCityId(), param.getMap());
		} else {
			signRateDtoList = reportFunStatisticTotleMapper.getSignRateCountNoDeal(getOperator().getCityId(), param.getMap());
			signRateCountTempList = erpFunDealMapper.getSignRateCountNoDeal(getOperator().getCityId(), param.getMap());
		}
		Map<String, ErpFunStatisticRateDto> dtoCollect = new HashMap<>();
		if(signRateCountTempList != null && signRateCountTempList.size() > 0) {
			dtoCollect = signRateCountTempList.stream().collect(Collectors.toMap(ErpFunStatisticRateDto::getDateCount, val -> val));
		}
		// 组合到一起
		for (ErpFunStatisticRateDto dto : signRateDtoList) {
			ErpFunStatisticRateDto erpFunStatisticRateDto = dtoCollect.get(dto.getDateCount());
			if(erpFunStatisticRateDto != null) {
				Integer dkC = dto.getDkCount();
				if (dkC == null) {
					dkC = 0;
				}
				double dkCount = StringUtil.parseDouble(dto.getDkCount().toString(),0.0);
				double signCount = StringUtil.parseDouble(erpFunStatisticRateDto.getSignCount(),0.0);
				if(dkCount <= 0) {
					dkCount = 1;
				}
				dto.setSignRate(String.valueOf(signCount / dkCount));
			} else {
				dto.setSignRate("0");
			}
		}
		// 查询签单量,签单率 TODO,待改的
		if (signRateDtoList.size() > 0) {
			for (ErpFunStatisticRateDto erpFunStatisticRateDto : signRateDtoList) {
				String signRate = erpFunStatisticRateDto.getSignRate();
				BigDecimal signRateBd = new BigDecimal(signRate);
				String signRateStr = new BigDecimal(signRateBd + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				erpFunStatisticRateDto.setSignRate(signRateStr);
			}
			// 补时间数据
			ErpFunStatisticRateDto baseObj = new ErpFunStatisticRateDto();
			DataAnalysisUtil.repairDateForListObj(signRateDtoList, "dateCount", baseObj, dateArr[0], dateArr[1], dateType);
			resultMap.put("signRateDtoList", signRateDtoList);
		}
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 转化率分析报表
	 * @author 何传强
	 * @since 2017年7月27日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getConversionRatioAnalysisOffReport")
	public ResponseJson getConversionRatioAnalysisOffReport(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		String serchRange = param.getString("serchRange");
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		if ("USER".equals(serchRange)) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		String dateType = param.getString("dateType");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String[] dateArr=new String[2];
		if ("2".equals(dateType)) {
			dateArr = DateUtil.getDateRangeOffTwoMonth(startTime, endTime);
			if (StringUtil.isNotBlank(dateArr[0])) {
				param.setString("startTime", dateArr[0]);
			}
			if (StringUtil.isNotBlank(dateArr[1])) {
				param.setString("endTime", dateArr[1]);
			}
		}else if ("0".equals(dateType) || "1".equals(dateType)) {
			if (StringUtil.isNotBlank(startTime)) {
				param.setString("startTime", startTime+" 00:00:00");
			}
			if (StringUtil.isNotBlank(endTime)) {
				param.setString("endTime", endTime+" 23:59:59");
			}
			dateArr = new String[]{param.getString("startTime"),param.getString("endTime")};
		}else {
			//获取当前时间,向前推四周
			dateArr = DateUtil.getFrontFourWeeksEndByTodayTimeArr();
			if (StringUtil.isNotBlank(dateArr[0])) {
				param.setString("startTime", dateArr[0]+" 00:00:00");
			}
			if (StringUtil.isNotBlank(dateArr[1])) {
				param.setString("endTime", dateArr[1]+" 23:59:59");
			}
			dateType = "1";
		}
		// 时间统计维度（0 = 日统计 1 = 周统计 2月统计）
		String dateColumn = DateUtil.getDateDimensionGroupBy(dateType, "a.CREATE_TIME", dateArr);
		param.setObject("dateColumn", dateColumn);
		String dateColumnB = DateUtil.getDateDimensionGroupBy(dateType, "b.CREATE_TIME", dateArr);
		param.setObject("dateColumnB", dateColumnB);
		String signDateColumnHasDeal = DateUtil.getDateDimensionGroupBy(dateType, "B.SIGN_DATE", dateArr);
		param.setObject("signDateColumnHasDeal", signDateColumnHasDeal);
		String signDateColumnNoDeal = DateUtil.getDateDimensionGroupBy(dateType, "A.CREATE_TIME", dateArr);
		param.setObject("signDateColumnNoDeal", signDateColumnNoDeal);
		// 查询带看率 --查询时间范围内，新增的客源
		List<ErpFunStatisticRateDto> daiKanRateDtoList = reportFunStatisticTotleMapper.getDaiKanRateCount(getOperator().getCityId(), param.getMap());
		for (ErpFunStatisticRateDto erpFunStatisticRateDto : daiKanRateDtoList) {
			String dkRate = erpFunStatisticRateDto.getDkRate();
			BigDecimal dkRateBd = new BigDecimal(dkRate);
			String dkRateStr = new BigDecimal(dkRateBd + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			erpFunStatisticRateDto.setDkRate(dkRateStr);// 将科学计数法转为普通计数
		}
		// 补时间数据
		ErpFunStatisticRateDto baseObj = new ErpFunStatisticRateDto();
		DataAnalysisUtil.repairDateForListObj(daiKanRateDtoList, "dateCount", baseObj, dateArr[0], dateArr[1], dateType);
		Map<String, ErpFunStatisticRateDto> rateDtoCollect = daiKanRateDtoList.stream().collect(Collectors.toMap(ErpFunStatisticRateDto::getDateCount, val -> val));
		//房勘率
		List<ErpFunStatisticRateDto> funKanRateDtoList = reportFunStatisticTotleMapper.getFunKanRateCount(getOperator().getCityId(),param.getMap());
		if (funKanRateDtoList.size() > 0) {
			for (ErpFunStatisticRateDto erpFunStatisticRateDto : funKanRateDtoList) {
				String fkRate = erpFunStatisticRateDto.getFkRate();
				BigDecimal fkRateBd = new BigDecimal(fkRate);
				String fkRateStr = new BigDecimal(fkRateBd + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				ErpFunStatisticRateDto statisticRateDto = rateDtoCollect.get(erpFunStatisticRateDto.getDateCount());
				if(statisticRateDto != null) {
					statisticRateDto.setFkRate(fkRateStr);
				} else {
					rateDtoCollect.put(erpFunStatisticRateDto.getDateCount(), erpFunStatisticRateDto);
				}
			}
		}
		//成交率
		List<ErpFunStatisticRateDto> signRateDtoList = new ArrayList<>();
		List<ErpFunStatisticRateDto> signRateCountTempList = null;
		Integer userId = param.getInteger("userId");
		if (userId != null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(getOperator().getCityId(), userId);
			Integer archiveId = erpFunUsers.getArchiveId();
			if (archiveId != null) {
				param.setInteger("archiveId", archiveId);
			}
		}
		if ("1".equals(getOperator().getAttribute("COMP_TYPE").toString())) {
			signRateDtoList = reportFunStatisticTotleMapper.getSignRateCountHasDeal(getOperator().getCityId(), param.getMap());
			signRateCountTempList = erpFunDealMapper.getSignRateCountHasDeal(getOperator().getCityId(), param.getMap());
		} else {
			signRateDtoList = reportFunStatisticTotleMapper.getSignRateCountNoDeal(getOperator().getCityId(), param.getMap());
			signRateCountTempList = erpFunDealMapper.getSignRateCountNoDeal(getOperator().getCityId(), param.getMap());
		}
		Map<String, ErpFunStatisticRateDto> dtoCollect = new HashMap<>();
		if (signRateCountTempList != null && signRateCountTempList.size() > 0) {
			dtoCollect = signRateCountTempList.stream().collect(Collectors.toMap(ErpFunStatisticRateDto::getDateCount, val -> val));
		}
		// 组合到一起
		for (ErpFunStatisticRateDto dto : signRateDtoList) {
			ErpFunStatisticRateDto erpFunStatisticRateDto = dtoCollect.get(dto.getDateCount());
			if (erpFunStatisticRateDto != null) {
				Integer dkC = dto.getDkCount();
				if (dkC == null) {
					dkC = 0;
				}
				double dkCount = StringUtil.parseDouble(dto.getDkCount().toString(), 0.0);
				double signCount = StringUtil.parseDouble(erpFunStatisticRateDto.getSignCount(), 0.0);
				if (dkCount <= 0) {
					dkCount = 1;
				}
				dto.setSignRate(String.valueOf(signCount / dkCount));
			} else {
				dto.setSignRate("0");
			}
		}
		// 查询签单量,签单率 TODO,待改的
		if (signRateDtoList.size() > 0) {
			for (ErpFunStatisticRateDto erpFunStatisticRateDto : signRateDtoList) {
				String signRate = erpFunStatisticRateDto.getSignRate();
				BigDecimal signRateBd = new BigDecimal(signRate);
				String signRateStr = new BigDecimal(signRateBd + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				ErpFunStatisticRateDto statisticRateDto = rateDtoCollect.get(erpFunStatisticRateDto.getDateCount());
				if(statisticRateDto != null) {
					statisticRateDto.setSignRate(signRateStr);
				} else {
					rateDtoCollect.put(erpFunStatisticRateDto.getDateCount(), erpFunStatisticRateDto);
				}
			}
		}
		List<ErpFunStatisticRateDto> resultList = new LinkedList<>(rateDtoCollect.values());
		SortUtil.sortForDateForListObj(resultList, "dateCount", dateType);
		return ErpResponseJson.ok(resultList);
	}
}
