package com.myfun.erpWeb.statisticalAnalysis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.myfun.erpWeb.statisticalAnalysis.param.DealAnalysisParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.support.constant.Const;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitTargetMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.param.ProfitDragonTigerParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.fafundb.dao.FafunFafaDetailLogMapper;
import com.myfun.repository.fafundb.dto.FafunFafaDetailLogDto;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.dto.ReportFunStatisticTotleDto;
import com.myfun.repository.reportdb.po.ReportFunStatisticTotle;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.SortUtil;
import com.myfun.utils.StringUtil;

/**
 * 统计分析-业绩龙虎版统计
 * @author flj
 * @2017-02-08 下午3:02:17
 */
@RestController
@RequestMapping("/statisticalAnalysis/profitCount")
public class ProfitStatisticalController extends BaseController{
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired private ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired private FafunFafaDetailLogMapper fafunFafaDetailLogMapper;
	@Autowired private AdminFunCityMapper adminFunCityMapper;

	/**
	 * 公司近半年业绩数据统计
	 * @param serchRange:查询范围 serchRangeId:查询范围id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCompProfitOffHalfYear")
	public ResponseJson getCompProfitOffHalfYear(@RequestBody BaseMapParam param) throws Exception{
		//计算半年时间
		String[] timeArr = DateUtil.getFrontHalfYearEndByTodayTimeArr();
		param.setInteger("compId", getOperator().getCompId());
		param.setString("startTime", timeArr[0]);
		param.setString("endTime", timeArr[1]);
		
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		// 查询数据
		List<Map<String, Object>> profitDataList = erpFunProfitMapper.getCompProfitOffHalfYear(getOperator().getCityId(), param.getMap());
		if (profitDataList != null && !profitDataList.isEmpty()) {
			Map<String, Object> baseMap = new HashMap<String, Object>();
			baseMap.put("receivableProfit", "0");
			baseMap.put("actualProfit", "0");
			// 补时间数据
			DataAnalysisUtil.repairDateForListMap(profitDataList, baseMap, timeArr[0], timeArr[1], "2", "dateCount");
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(profitDataList);
		return responseJson;
	}
	
	/**
	 * 查询公司人均业绩，总业绩等
	 * @param serchRange:查询范围 serchRangeId:查询范围id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTotalProfitCount")
	public ResponseJson getTotalProfitCount(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		//判断时间是否为空
		if (StringUtils.isBlank(param.getString("startTime"))) {
			String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}else{
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
		//查询数据
		List<Map<String,Object>> profitDataList = erpFunProfitMapper.getCompActualProfitAndPerProfit(getOperator().getCityId(), param.getMap());
		ErpResponseJson responseJson = ErpResponseJson.ok(profitDataList);
		return responseJson;
	}
	
	/**
	 * 查询成交分析中成交总业绩
	 * @param serchRange:查询范围 serchRangeId:查询范围id startTime:开始时间 endTime:结束时间 dateType:SIGN_DATE签约时间 DEAL_VERIFY_TIME结算时间 caseType:1=出售 2=出租
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTotalProfitOffDealAnalysis")
	public ResponseJson getTotalProfitOffDealAnalysis(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		//计算时间
		if(StringUtils.isNotBlank(param.getString("startTime"))){
			if(param.getString("startTime").split("-").length==3){
				param.setString("endTime", param.getString("endTime")+" 23:59:59");
			}
			if(param.getString("startTime").split("-").length==2){
				String[] timeArr = DateUtil.getDateRangeOffTwoMonth(param.getString("startTime"), param.getString("endTime"));
				param.setString("startTime", timeArr[0]);
				param.setString("endTime", timeArr[1]);
			}
		}
		if ("USER".equals(param.getString("serchRange"))) {
			param.setInteger("archiveId", getOperator().getArchiveId());
		}
		if (!getOperator().isGeneralManager() && "GROUP".equals(param.getString("serchRange"))) {
			// 判断当前的人的统计分析查看范围
			boolean operFlag = null != erpUserOpersMapper.selectPerPermissionByName(getOperator().getCityId(), getOperator().getUserId(),
					"DATA_ANALYSIS_GROUP_VIEW");
			if (operFlag) {
				param.setInteger("deptId", getOperator().getDeptId());
			}
		}
		//查询数据
		List<Map<String,Object>> profitDataList = erpFunProfitMapper.getTotalProfitOffDealAnalysis(getOperator().getCityId(), param.getMap());
		ErpResponseJson responseJson = ErpResponseJson.ok(profitDataList);
		return responseJson;
	}
	/**
	 * 业绩龙虎版报表演示案例
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFunProfitCountReport")
	public ResponseJson getFunProfitCountReport(@RequestBody ProfitDragonTigerParam param) throws Exception{
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		boolean isCharts = "CHART".equals(param.getShowType());
		boolean isReceivable = "0".equals(param.getPfActual());
		param.setEndTime(param.getEndTime() + " 23:59:59");
		List<Map<String,Object>> resultList = null;
		if(isReceivable){
			resultList = geProfitCountReportOffReceiveble(param,"RECEIVABLE_MONEY");
	    }else{
	    	resultList = geProfitCountReportOffReceiveble(param,"PROFIT_MONEY");
	    }
		if(isCharts){// 图表使用租赁+买卖的总业绩和（总业绩）排序
			SortUtil.collectionsSort(resultList, new String[]{"totalProfit"}, "2".equals(param.getDataType()));
		} else {// 报表使用组织机构排序
			SortUtil.collectionsSort(resultList, new String[]{"areaId","regId","deptId","grId","userId"}, "2".equals(param.getDataType()));
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(resultList);
		responseJson.setExtra(param.getPfActual()+","+param.getShowType()+",");
		return responseJson;
	}
	
	/**
	 * 业绩龙虎版报表统计
	 * @param param
	 * @param string
	 * @return
	 * @throws Exception 
	 */
	private List<Map<String, Object>> geProfitCountReportOffReceiveble(ProfitDragonTigerParam param, String countFiledName) throws Exception {
		//获取范围对应查询的列
		String queryStr = getRangeQueryStr(param.getDimension());
		String groupStr = getRangeGroupbyStr(param.getDimension());
		param.setQueryStr(queryStr);
		param.setGroupStr(groupStr);
		String targetQueryStr = getRangeQueryTargetStr(param.getDimension());
		String targetGroupByStr = getRangeGroupbyTargetStr(param.getDimension());
		if ("USER".equals(param.getSearchRange())) {
			ErpFunUsers user = erpFunUsersMapper.getUserInfoByUserId(param.getCityId(), param.getSearchRangeId());
			param.setArchiveId(user.getArchiveId());
		}
		//查询业绩
		List<Map<String,Object>> profitList = erpFunDealMapper.getFunProfitCount(param.getCityId(),param,countFiledName);
		//查询成交信息
		List<Map<String,Object>> dealCountList = erpFunDealMapper.getFunProfitReportDealCount(param.getCityId(),param);
		//查询办单量信息
		List<Map<String,Object>> officialOrdersCountList = erpFunDealMapper.getFunProfitReportOfficialOrdersCountCount(param.getCityId(),param);
		String endTime = DateUtil.getLastDay(param.getStartTime());
		String startTime = DateUtil.getFirstDay(param.getStartTime());
		param.setEndTime(endTime);
		param.setStartTime(startTime);
		String targetType = Constants_DIC.Count.PROFIT_COUNT_TYPE_MAP.get(param.getDimension());
		param.setQueryStr(targetQueryStr);
		param.setGroupStr(targetGroupByStr);
		List<Map<String,Object>> profitTargetList = erpFunProfitTargetMapper.getFunProfitReportTargetCount(param.getCityId(),param,targetType);
		Map<String,Map<String,Object>> dealCountMap = BeanUtil.listMapObjecttoMap(dealCountList, "range");
		Map<String,Map<String,Object>> targetMap = BeanUtil.listMapObjecttoMap(profitTargetList, "range");
		Map<String,Map<String,Object>> officialOrdersMap = BeanUtil.listMapObjecttoMap(officialOrdersCountList, "range");
		List<String> officialOrdersKeyList = BeanUtil.buildQueryKeysOffMapObject(officialOrdersCountList, "range");
		List<String> dealCountKeyList = BeanUtil.buildQueryKeysOffMapObject(dealCountList, "range");
		List<String> targetKeyList = BeanUtil.buildQueryKeysOffMapObject(profitTargetList, "range");
		//查询需要扑数据的
		List<Map<String,Object>> rangeList = erpFunUsersMapper.getRangeListDaTaOfComp(param.getCityId(),param.getCompId() ,param.getArchiveId(), param.getDimension(), param.getSearchRange(), param.getSearchRangeId(), getOperator().getAreaFlag());
		Map<String,Map<String,Object>> listRange = BeanUtil.listMapObjecttoMap(rangeList, "range");
		//补数据通过RANGE作为key来对应数据
		for (Map<String, Object> data : profitList) {
			Object val = data.get("range");
			String valStr = val.toString();
			Map<String, Object> dealCountData = dealCountMap.get(valStr);
			if (dealCountData != null) {
				data.putAll(dealCountData);
				dealCountKeyList.remove(valStr);
			}
			Map<String, Object> officialOrdersData = officialOrdersMap.get(valStr);
			if (officialOrdersData != null) {
				data.putAll(officialOrdersData);
				officialOrdersKeyList.remove(valStr);
			}
			Map<String, Object> targetData = targetMap.get(valStr);
			if (targetData != null) {
				data.putAll(targetData);
				targetKeyList.remove(valStr);
			}
		}
		if (!dealCountKeyList.isEmpty()) {
			for (String key : dealCountKeyList) {
				Map<String, Object> dealCountData = dealCountMap.get(key);
				Map<String, Object> targetData = targetMap.get(key);
				Map<String, Object> officialOrdersData = officialOrdersMap.get(key);
				if (targetData != null) {
					dealCountData.putAll(targetData);
					targetKeyList.remove(key);
				}
				if (officialOrdersData != null) {
					dealCountData.putAll(officialOrdersData);
					officialOrdersKeyList.remove(key);
				}
				profitList.add(dealCountData);
			}
		}
		if (!officialOrdersKeyList.isEmpty()) {
			for (String key : officialOrdersKeyList) {
				Map<String, Object> officialOrdersData = officialOrdersMap.get(key);
				Map<String, Object> targetData = targetMap.get(key);
				if (targetData != null) {
					officialOrdersData.putAll(targetData);
					targetKeyList.remove(key);
				}
				profitList.add(officialOrdersData);
			}
		}
		if (!targetKeyList.isEmpty()) {
			for (String key : targetKeyList) {
				Map<String, Object> targetData = targetMap.get(key);
				profitList.add(targetData);
			}
		}
		for (Map<String, Object> data : profitList) {
			Object val = data.get("range");
			if (val != null) {
				listRange.put(val.toString(), data);
			} 
		}
		return new ArrayList<>(listRange.values());
	}
	
	/*private Map<String, Map<String, Object>> getRangeListDaTaOfComp(String dimension, String serchRange,
			Integer serchRangeId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/**
	 * 获取需要查询的组织机构列
	 * @param dimension
	 * @return
	 */
	private String getRangeQueryStr(String dimension) {
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(dimension)){
			resultStr = "b.COMP_ID as compId";
		} else if("AREA".equals(dimension)){
			resultStr = "b.COMP_ID as compId,b.AREA_ID as areaId,CONCAT(b.AREA_ID,'') AS range";
		} else if("REG".equals(dimension)){
			resultStr = "b.COMP_ID as compId,b.AREA_ID as areaId,b.REG_ID as regId,CONCAT(b.AREA_ID ,'_',b.REG_ID,'') AS range";
		} else if("DEPT".equals(dimension)){
			resultStr = "b.COMP_ID as compId,b.AREA_ID as areaId,b.REG_ID as regId,b.DEPT_ID as deptId,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID) AS range";
		} else if("GROUP".equals(dimension)){
			resultStr = "b.COMP_ID as compId,b.AREA_ID as areaId,b.REG_ID as regId,b.DEPT_ID as deptId,b.GR_ID as grId,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID) AS range";
		} else if("USER".equals(dimension)){
			resultStr = "b.COMP_ID as compId,b.AREA_ID as areaId,b.REG_ID as regId,b.DEPT_ID as deptId,b.GR_ID as grId,b.USER_ID as userId,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID,'_',b.USER_ID) AS range";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID as areaId,", "");
		}
		return resultStr;
	}
	
	/**
	 * 需要分组维度的列
	 * @param groupby
	 * @return
	 */
	public String getRangeGroupbyStr(String groupby){
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "b.COMP_ID";
		} else if("AREA".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,CONCAT(b.AREA_ID,'')";
		} else if("REG".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID ,CONCAT(b.AREA_ID,'_',b.REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,b.USER_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID,'_',b.USER_ID)";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID,", "");
		}
		return resultStr;
	}
	
	public String getRangeQueryTargetStr(String groupby){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID as compId";
		} else if("AREA".equals(groupby)){
			resultStr = "COMP_ID as compId,AREA_ID as areaId,CONCAT(AREA_ID,'') as range";
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID as compId,AREA_ID as areaId,REG_ID as regId,CONCAT(AREA_ID,'_',REG_ID,'') as range";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID as compId,AREA_ID as areaId,REG_ID as regId,DEPT_ID as deptId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID) as range";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID as compId,AREA_ID as areaId,REG_ID as regId,DEPT_ID as deptId,GR_ID as grId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID) as range";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID as compId,AREA_ID as areaId,REG_ID as regId,DEPT_ID as deptId,GR_ID as grId,USER_ID as userId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID,'_',USER_ID) as range";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID as areaId,", "");
		}
		return resultStr;
	}
	
	public String getRangeGroupbyTargetStr(String groupby){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID";
		} else if("AREA".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,CONCAT(AREA_ID,'')";
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,USER_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID,'_',USER_ID)";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID,", "");
		}
		return resultStr;
	}
	
	/**
	 * 获取公司员工指定日期范围跑分排名接口移植
	 * @author 朱科
	 * @since 2018年7月20日
	 * @return
	 */
	@RequestMapping("/getCompUserTopRanking")
	public ResponseJson getCompUserTopRanking(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfUserId = operator.getUserId();
		Integer selfArchiveId = operator.getArchiveId();
		List<Map<String, Object>> resultList = new LinkedList<Map<String, Object>>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		String yesterday = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		String dayBeforeYesterday = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		// 设置查询条数
		List<ReportFunStatisticTotleDto> specifyWorkCountList1 = this.getSpecifyWorkCountList(cityId, compId, yesterday);
		List<ReportFunStatisticTotleDto> specifyWorkCountList2 = this.getSpecifyWorkCountList(cityId, compId, dayBeforeYesterday);
		// 设置分数升降 
		for (int i = 0; i < specifyWorkCountList1.size(); i++) {
			ReportFunStatisticTotleDto funStatisticTotleDto1 = specifyWorkCountList1.get(i);
			funStatisticTotleDto1.setRankingStatus(1);
			for (int j = 0; j < specifyWorkCountList2.size(); j++) {
				ReportFunStatisticTotleDto funStatisticTotleDto2 = specifyWorkCountList2.get(j);
				if(funStatisticTotleDto1.getUserId().equals(funStatisticTotleDto2.getUserId())){
					if(i > j){ // 下降
						funStatisticTotleDto1.setRankingStatus(-1);
					} else if(i == j){
						funStatisticTotleDto1.setRankingStatus(0);
					}
					break;
				}
			}
			funStatisticTotleDto1.setCountUserId(funStatisticTotleDto1.getUserId());
		}
		// 获取自己的分数
		List<ReportFunStatisticTotleDto> myOperationStatistics = this.getMyOperationStatistics(cityId, compId, selfUserId, selfArchiveId, yesterday);
		// 处理掉多余的数据
		if(myOperationStatistics != null && !myOperationStatistics.isEmpty()){
			ReportFunStatisticTotleDto funStatisticTotleDto = myOperationStatistics.get(0);
			funStatisticTotleDto.setCountUserId(funStatisticTotleDto.getUserId());
		}
		// 为0的不展示
		for (int i = specifyWorkCountList1.size() - 1; i >= 0; i--) {
			ReportFunStatisticTotleDto reportFunStatisticTotleDto = specifyWorkCountList1.get(i);
			Integer totalScore = reportFunStatisticTotleDto.getTotalScore();
			if(totalScore <= 0){
				specifyWorkCountList1.remove(i);
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rankingList", specifyWorkCountList1);
		resultMap.put("myRanking", myOperationStatistics);
		resultList.add(resultMap);
		return ErpResponseJson.ok(resultList);
	}

	/**
	 * @tag 报表
	 * @author 邓永洪
	 * @since 2018/9/12
	 */
	@RequestMapping("/getDealAnalysisForExport")
	public ResponseJson getDealAnalysisForExport(@RequestBody DealAnalysisParam param) {
		param.setShowType(1);
		return this.getDealAnalysis(param);
	}

	/**
	 * @tag  成交统计分析表
	 * @author 邓永洪
	 * @since 2018/7/24
	 */
	@RequestMapping("/getDealAnalysis")
	public ResponseJson getDealAnalysis(@RequestBody DealAnalysisParam param) {
		Operator operator=getOperator();
		Integer cityId = operator.getCityId();
		param.setCompId(operator.getCompId());
		AdminFunCity funCity = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
		param.setSerchRange(DataAnalysisUtil.getRange(param.getSerchRange()));
		String tableName = "FUN_DEAL A JOIN DEAL_USER_RELATIVE B ON A.DEAL_ID = B.DEAL_ID AND A.SIGN_USER_ID = B.USER_ID AND B.RELATE_TYPE = 3 LEFT JOIN FUN_SALE C ON A.DEAL_HOUSE_ID = C.SALE_ID ";
		if (102==param.getCaseType()) {
			tableName = "FUN_DEAL A JOIN DEAL_USER_RELATIVE B ON A.DEAL_ID = B.DEAL_ID AND A.SIGN_USER_ID = B.USER_ID AND B.RELATE_TYPE = 3 LEFT JOIN FUN_LEASE C ON A.DEAL_HOUSE_ID = C.LEASE_ID ";
		}
		param.setTableName(tableName);
		String areaUnit = null;
		String priceUnit = null;
		String dealMoneyStr = null;
		String roomColumn = "";
		String dimisionName = null;
		String regSectionName = "(convert(varchar,A.BUILD_REG_ID)+'_'+convert(varchar,A.SECTION_ID))";
		if (Const.DIC_CASE_TYPE_SALE_DEAL==param.getCaseType()) {
			areaUnit = funCity.getStatisticsAreaSaleOption();
			priceUnit = funCity.getStatisticsPriceSaleOption();
			roomColumn = "C.SALE_DOORS";
			dealMoneyStr = "SELL_DEAL_MONEY";
		} else {
			areaUnit = funCity.getStatisticsAreaLeaseOption();
			priceUnit = funCity.getStatisticsPriceLeaseOption();
			roomColumn = "C.LEASE_DOORS";
			dealMoneyStr = "RENT_DEAL_MONEY";
		}
		String roomStr = "iif(" + roomColumn + "<6," + roomColumn + ",6)";
		if (StringUtils.isBlank(areaUnit)) {
			// areaUnit = "70,90,120,200";
			throw new BusinessException("该城市面积分段未配置！");
		}
		if (StringUtils.isBlank(priceUnit)) {
			// priceUnit =
			// "3000000,5000000,7000000,9000000,12000000,15000000,20000000,40000000";
			throw new BusinessException("该城市价格分段未配置！");
		}
		Map<String, Object> areaPriceOptionMap = new HashMap<>();
		List<Map<String, Object>> areaPriceOptionList = new LinkedList<>();
		areaPriceOptionMap.put("areaOption", areaUnit);
		areaPriceOptionMap.put("priceOption", priceUnit);
		areaPriceOptionList.add(areaPriceOptionMap);
		if ("USER_ID".equals(param.getSerchRange())) {
			param.setArchiveId(operator.getArchiveId());
		}
		if (StringUtils.isNotBlank(param.getDateType())) {
			param.setStartTime(param.getStartTime() + " 00:00:00");
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		if (StringUtils.isNotBlank(param.getSectionIds())) {
			param.setSectionIdArr(param.getSectionIds().split(","));
		}
		List<Map<String,Object>> priceList = null;
		List<Map<String,Object>> roomList = null;
		List<Map<String,Object>> areaList = null;
		List<Map<String,Object>> regList = null;
		List<Map<String,Object>> useageList = null;
		List<Map<String,Object>> payMethodList = null;
		String mainColumn = null;
		Integer showType = param.getShowType();
		if ("PRICE".equals(param.getDimension())) {
			dimisionName = "PRICE";
			mainColumn = getCaseWhenSql(priceUnit, dealMoneyStr, param.getCaseType(), true);
			dealAnalysisColumn( param,mainColumn,  "price",  null,  null,  showType);
			priceList=erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn,"price",getCaseWhenSql(areaUnit, "A.AREA", null, false),"area",showType);
			areaList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,  mainColumn, "PRICE", "ISNULL(A.HOUSE_USEAGE,0)", "useage",showType);
			useageList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "PRICE", regSectionName, "regSection",showType);
			regList=erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "PRICE", roomStr, "room", showType);
			roomList=erpFunProfitMapper.getDealAnalysis(cityId,param);
		}else if ("AREA".equals(param.getDimension())) {
			dimisionName = "AREA";
			mainColumn = getCaseWhenSql(areaUnit, "A.AREA", null, false);
			dealAnalysisColumn( param,mainColumn, "AREA", null, null, showType);
			areaList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "AREA",
					getCaseWhenSql(priceUnit, dealMoneyStr, param.getCaseType(), true), "price", showType);
			priceList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "AREA", regSectionName, "regSection",showType);
			regList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "AREA", "ISNULL(HOUSE_USEAGE,0)", "useage",showType);
			useageList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "AREA", roomStr, "room", showType);
			roomList = erpFunProfitMapper.getDealAnalysis(cityId,param);
		}else if ("USEAGE".equals(param.getDimension())) {
			dimisionName = "USEAGE";
			mainColumn = "ISNULL(A.HOUSE_USEAGE,0)";
			dealAnalysisColumn( param,mainColumn, "USEAGE", null, null, showType);
			useageList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,mainColumn, "USEAGE",
					getCaseWhenSql(areaUnit, "AREA", null, false), "area", showType);
			areaList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "USEAGE",
					getCaseWhenSql(priceUnit, dealMoneyStr, param.getCaseType(), true), "price", showType);
			priceList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "USEAGE", regSectionName, "regSection",showType);
			regList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "USEAGE", roomStr, "room", showType);
			regList = erpFunProfitMapper.getDealAnalysis(cityId,param);
		}else if ("REG".equals(param.getDimension())) {
			dimisionName = "REG_NAME";
			mainColumn = regSectionName;
			dealAnalysisColumn( param,  mainColumn, "regSection", null, null, showType);
			regList = erpFunProfitMapper.getDealAnalysis(cityId,param);
			dealAnalysisColumn( param,  mainColumn, "regSection", "ISNULL(HOUSE_USEAGE,0)","useage", showType);
			useageList = erpFunProfitMapper.getDealAnalysis(cityId,param);
			dealAnalysisColumn( param,  mainColumn, "regSection",
					getCaseWhenSql(areaUnit, "AREA", null, false), "area", showType);
			areaList = erpFunProfitMapper.getDealAnalysis(cityId,param);
			dealAnalysisColumn( param, mainColumn, "regSection",
					getCaseWhenSql(priceUnit, dealMoneyStr, param.getCaseType(), true), "price", showType);
			priceList=erpFunProfitMapper.getDealAnalysis(cityId,param);
			dealAnalysisColumn( param, mainColumn, "regSection", roomStr, "room",showType);
			roomList=erpFunProfitMapper.getDealAnalysis(cityId,param);
		}else if ("ROOM".equals(param.getDimension())) {
			dimisionName = "ROOM";
			mainColumn = roomStr;
			dealAnalysisColumn( param,  mainColumn, "ROOM", regSectionName, "regSection",showType);
			regList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,  mainColumn, "ROOM", "ISNULL(HOUSE_USEAGE,0)", "useage",showType);
			useageList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param,  mainColumn, "ROOM",
					getCaseWhenSql(areaUnit, "AREA", null, false), "area", showType);
			areaList = erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "regSection",
					getCaseWhenSql(priceUnit, dealMoneyStr, param.getCaseType(), true), "price", showType);
			priceList=erpFunProfitMapper.getDealAnalysis(cityId,param);

			dealAnalysisColumn( param, mainColumn, "regSection", roomStr, "room",showType);
			roomList=erpFunProfitMapper.getDealAnalysis(cityId,param);
		}
		if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(param.getCaseType())) {
			dealAnalysisColumn( param,  mainColumn, dimisionName, "RENT_PAY_METHOD",
					"payMethod", showType);
			payMethodList = erpFunProfitMapper.getDealAnalysis(cityId,param);
		}
		Map<String, List<Map<String, Object>>> resultMap = new HashMap<>();
		resultMap.put("priceList",priceList);
		resultMap.put("areaList", areaList);
		resultMap.put("regList", regList);
		resultMap.put("useageList", useageList);
		resultMap.put("payMethodList", payMethodList);
		resultMap.put("roomList", roomList);
		resultMap.put("areaPriceOptionList", areaPriceOptionList);
		return ErpResponseJson.ok(resultMap);
	}

	private void dealAnalysisColumn(DealAnalysisParam param, String mainColumn, String mainName, String subColumn, String subName, Integer showType) {
		if (StringUtils.isBlank(subColumn)) {
			String orderBy = mainColumn;
			StringBuilder columns = new StringBuilder();
			if (showType == null && "regSection".equals(mainName)) {
				columns.append(" top 8 " + mainColumn + " as " + mainName);
				columns.append(",COUNT(1) as counts");
				columns.append(",sum(SELL_DEAL_MONEY) as priceUnit");
				columns.append(",sum(AREA) as areaTotle");
				orderBy = "counts DESC";

			} else {
				columns.append(mainColumn + " as " + mainName);
				columns.append(",COUNT(1) as counts");
				columns.append(",sum(SELL_DEAL_MONEY) as priceUnit");
				columns.append(",sum(AREA) as AREA_TOTLE");
			}
			param.setGroupBy(mainColumn);
			param.setOrderBy(orderBy);
			param.setColumns(columns.toString());
		} else {
			StringBuilder columns = new StringBuilder();
			if (showType != null && showType == 1) {
				columns.append(mainColumn + " as " + mainName);
				columns.append("," + subColumn + " as " + subName);
				columns.append(",COUNT(1) as counts");
				param.setGroupBy(mainColumn + "," + subColumn);
				param.setOrderBy(mainName);
				param.setColumns(columns.toString());
			} else {
				columns.append(subColumn + " as " + subName);
				columns.append(",COUNT(1) as counts");
				param.setGroupBy(subColumn);
				param.setOrderBy("counts DESC");
				param.setColumns(columns.toString());
			}
		}
	}

	private String getCaseWhenSql(String dataStr, String column, Integer caseType, boolean isDealPrice) {
		StringBuilder caseWhen = new StringBuilder();
		String[] strArr = dataStr.split(",");
		if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(caseType) && isDealPrice) {
			column = "iif(RENT_PRICE_UNIT=2,ISNULL(RENT_DEAL_MONEY,0)*30,iif(RENT_PRICE_UNIT=3,ISNULL(RENT_DEAL_MONEY,0)*AREA,iif(RENT_PRICE_UNIT=4,ISNULL(RENT_DEAL_MONEY,0)*30*AREA,iif(RENT_PRICE_UNIT=5,ISNULL(RENT_DEAL_MONEY,0)/12,RENT_DEAL_MONEY))))";
		}
		// iif(RENT_PRICE_UNIT=2,ISNULL(RENT_DEAL_MONEY,0)*30,iif(RENT_PRICE_UNIT=3,ISNULL(RENT_DEAL_MONEY,0)*AREA,iif(RENT_PRICE_UNIT=4,ISNULL(RENT_DEAL_MONEY,0)*30*AREA,iif(RENT_PRICE_UNIT=5,ISNULL(RENT_DEAL_MONEY,0)/12,RENT_DEAL_MONEY))))
		for (int i = 0; i < strArr.length; i++) {
			if (i == 0) {
				caseWhen.append("CASE WHEN ").append(column).append(" <").append(strArr[i]);
			} else {
				caseWhen.append(" WHEN ").append(column).append(" >= ").append(strArr[i - 1]).append(" AND ")
						.append(column).append(" < ").append(strArr[i]);
			}
			caseWhen.append(" THEN ").append(i + 1);
			if (i == strArr.length - 1) {
				caseWhen.append(" ELSE ").append(i + 2).append(" END ");
			}
		}
		return caseWhen.toString();
	}

	private List<ReportFunStatisticTotleDto> getSpecifyWorkCountList(Integer cityId, Integer compId, String dateTime){
		List<ReportFunStatisticTotleDto> specifyWorkCountList = reportFunStatisticTotleMapper.getSpecifyWorkCountList(cityId, compId, dateTime);
		if(null == specifyWorkCountList || specifyWorkCountList.isEmpty()){
			return new LinkedList<ReportFunStatisticTotleDto>();
		}
		Set<Integer> userIds = specifyWorkCountList.stream().collect(Collectors.mapping(ReportFunStatisticTotle::getUserId, Collectors.toSet()));
		List<ErpFunUsers> funUserList = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		List<Integer> archiveIds = funUserList.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toList()));
		// 再查档案表上的头像地址
		List<AdminFunArchive> funArchiveList = adminFunArchiveMapper.getListByArchiveIds(archiveIds);
		Map<Integer, AdminFunArchive> archiveMap = funArchiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val ->val));
		List<FafunFafaDetailLogDto> specifyFafaCountList = fafunFafaDetailLogMapper.getSpecifyFafaCountList(cityId, compId, new ArrayList<>(userIds), dateTime, null);
		for(ReportFunStatisticTotleDto funStatisticTotledDto: specifyWorkCountList){
			for (FafunFafaDetailLogDto fafunFafaDetailLogDto : specifyFafaCountList) {
				if(funStatisticTotledDto.getUserId().equals(fafunFafaDetailLogDto.getUserId())){
					funStatisticTotledDto.setWlfbCount(specifyFafaCountList.get(0).getFfCount());
				}
			}
			int totleScore = 0;
			totleScore += funStatisticTotledDto.getDjCount() * StatisticDetailType.DJ_COUNT.getScore();
			totleScore += funStatisticTotledDto.getGjCount() * StatisticDetailType.GJ_COUNT.getScore();
			totleScore += funStatisticTotledDto.getFkCount() * StatisticDetailType.FK_COUNT.getScore();
			totleScore += funStatisticTotledDto.getYstjCount() * StatisticDetailType.YSTJ_COUNT.getScore();
			totleScore += funStatisticTotledDto.getTpscCount() * StatisticDetailType.TPSC_COUNT.getScore();
			totleScore += funStatisticTotledDto.getSpscCount() * StatisticDetailType.SPSC_COUNT.getScore();
			totleScore += funStatisticTotledDto.getWlfbCount() * StatisticDetailType.WLFB_COUNT.getScore();
			totleScore += funStatisticTotledDto.getDkCount() * StatisticDetailType.DK_COUNT.getScore();
			totleScore += funStatisticTotledDto.getCjCount() * StatisticDetailType.CJ_COUNT.getScore();
			totleScore += funStatisticTotledDto.getCkdhCount() * StatisticDetailType.CKDH_COUNT.getScore();
			funStatisticTotledDto.setTotalScore(totleScore);
			AdminFunArchive adminFunArchive = archiveMap.get(funStatisticTotledDto.getArchiveId());
			funStatisticTotledDto.setUserPhoto(StringUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
		}
		return specifyWorkCountList;
	}
	
	private List<ReportFunStatisticTotleDto> getMyOperationStatistics(Integer cityId, Integer compId, Integer selfUserId, Integer selfArchiveId, String dateTime){
		List<ReportFunStatisticTotleDto> specifyWorkCountList = reportFunStatisticTotleMapper.getSpecifyWorkCountList(cityId, compId, dateTime);
		ReportFunStatisticTotleDto funStatisticTotleDto = null;
		if (null == specifyWorkCountList || specifyWorkCountList.isEmpty()) {
			funStatisticTotleDto = new ReportFunStatisticTotleDto();
			funStatisticTotleDto.setUserId(selfUserId);
		} else {
			funStatisticTotleDto = specifyWorkCountList.get(0);
		}
		List<FafunFafaDetailLogDto> specifyFafaCountList = fafunFafaDetailLogMapper.getSpecifyFafaCountList(cityId, compId, null, dateTime, selfArchiveId);
		if(null != specifyFafaCountList && !specifyFafaCountList.isEmpty()){
			funStatisticTotleDto.setWlfbCount(specifyFafaCountList.get(0).getFfCount());
		}
		int totleScore = 0;
		totleScore += funStatisticTotleDto.getDjCount() * StatisticDetailType.DJ_COUNT.getScore();
		totleScore += funStatisticTotleDto.getGjCount() * StatisticDetailType.GJ_COUNT.getScore();
		totleScore += funStatisticTotleDto.getFkCount() * StatisticDetailType.FK_COUNT.getScore();
		totleScore += funStatisticTotleDto.getYstjCount() * StatisticDetailType.YSTJ_COUNT.getScore();
		totleScore += funStatisticTotleDto.getTpscCount() * StatisticDetailType.TPSC_COUNT.getScore();
		totleScore += funStatisticTotleDto.getSpscCount() * StatisticDetailType.SPSC_COUNT.getScore();
		totleScore += funStatisticTotleDto.getWlfbCount() * StatisticDetailType.WLFB_COUNT.getScore();
		totleScore += funStatisticTotleDto.getDkCount() * StatisticDetailType.DK_COUNT.getScore();
		totleScore += funStatisticTotleDto.getCjCount() * StatisticDetailType.CJ_COUNT.getScore();
		totleScore += funStatisticTotleDto.getCkdhCount() * StatisticDetailType.CKDH_COUNT.getScore();
		funStatisticTotleDto.setTotalScore(totleScore);
		List<ReportFunStatisticTotleDto> resultList = new LinkedList<>();
		resultList.add(funStatisticTotleDto);
		return resultList;
	}
}
