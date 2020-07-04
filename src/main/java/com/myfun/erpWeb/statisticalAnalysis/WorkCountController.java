package com.myfun.erpWeb.statisticalAnalysis;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.erpWeb.statisticalAnalysis.param.ProfitAnalyseParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.fafundb.dao.FafunFafaDetailLogMapper;
import com.myfun.repository.fafundb.dto.FafunFafaDetailLogDto;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunTrueHouseCountMapper;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.service.business.erpdb.ErpFunProfitService;
import com.myfun.service.business.report.ReportFunStatisticTotleService;
import scala.annotation.meta.param;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

/**
 * 统计分析-工作量统计
 * @author flj
 * @2017-06-09 下午3:02:17
 */
@Api(tags = "统计分析-工作量统计模块")
@RestController
@RequestMapping("/statisticalAnalysis/workCount")
public class WorkCountController extends BaseController{
	@Autowired ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired AdminFunTrueHouseCountMapper adminFunTrueHouseCountMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired ErpFunTrackHisMapper erpFunTrackHisMapper;
	@Autowired AdminIpCallLogMapper adminIpCallLogMapper;
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunProfitService erpFunProfitService;
	@Autowired ReportFunStatisticTotleService reportFunStatisticTotleService;
	@Autowired ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired ErpFunProfitMapper erpFunProfitMapper;
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired ErpFunAreaMapper erpFunAreaMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired ErpHouseInnerdealAnalysisMapper erpHouseInnerdealAnalysisMapper;
	@Autowired FafunFafaDetailLogMapper fafunFafaDetailLogMapper;
	@Autowired ErpFunOutdealMapper erpFunOutdealMapper;
	@Autowired ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired ErpFunOrganizationService erpFunOrganizationService;
	@Autowired ErpSysParaService erpSysParaService;

	/**
	 * 获取IP拨号详情列表
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getWorkCountIpLogList")
	public ResponseJson getWorkCountIpLogList(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		DataAnalysisController.changeSerchRange(param);
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		param.setObject("statisticType", StatisticDetailType.IPCALL_COUNT.getIndex());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<Map<String, Object>> logList = reportFunStatisticDetail1Mapper.getWorkCountTrackIdList(getOperator().getCityId(), param.getMap());
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(logList);
		if(logList != null && logList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		Set<String> trackIdSet = logList.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("trackId")), Collectors.toSet()));
		List<AdminIpCallLog> recordingByIds = adminIpCallLogMapper.getRecordingByIdArr(trackIdSet.toArray(new String[]{}));
		for (AdminIpCallLog adminIpCallLog : recordingByIds) {
			adminIpCallLog.setCallRecordUrl(CommonUtil.getPhotoUrl(adminIpCallLog.getCallRecordUrl()));
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(pageInfo);
		responseJson.setData(recordingByIds);
		return responseJson;
	}

	/**
	 * 查看单个工作量列表页的数量统计
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getWorkCountCounts")
	public ResponseJson getWorkCountCounts(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		String countName = param.getString("countName");
		DataAnalysisController.changeSerchRange(param);
		List<Map<String, Object>> logList = null;
		
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		// 查看电话和拨打电话后未跟进
		if("dhwgjCount".equals(countName)) {
			param.setInteger("statisticTypeMain", StatisticDetailType.CKDH_COUNT.getIndex());
			param.setInteger("statisticTypeSub", StatisticDetailType.DHDGJ_COUNT.getIndex());
			logList = reportFunStatisticDetail1Mapper.getWorkCountCountsForNotTrack(getOperator().getCityId(), param.getMap());
		} else if("ipwgjCount".equals(countName)) {
			param.setInteger("statisticTypeMain", StatisticDetailType.IPCALL_COUNT.getIndex());
			param.setInteger("statisticTypeSub", StatisticDetailType.IPDGJ_COUNT.getIndex());
			logList = reportFunStatisticDetail1Mapper.getWorkCountCountsForNotTrack(getOperator().getCityId(), param.getMap());
		} else {
			if ("saleDjCount".equals(countName)) {
				param.setInteger("caseType", Const.DIC_CASE_TYPE_SALE_FUN);
				param.setInteger("statisticType", StatisticDetailType.DJ_COUNT.getIndex());
			} else if ("leaseDjCount".equals(countName)) {
				param.setInteger("caseType", Const.DIC_CASE_TYPE_LEASE_FUN);
				param.setInteger("statisticType", StatisticDetailType.DJ_COUNT.getIndex());
			} else if ("buyDjCount".equals(countName)) {
				param.setInteger("caseType", Const.DIC_CASE_TYPE_BUY_CUST);
				param.setInteger("statisticType", StatisticDetailType.DJ_COUNT.getIndex());
			} else if ("rentDjCount".equals(countName)) {
				param.setInteger("caseType", Const.DIC_CASE_TYPE_RENT_CUST);
				param.setInteger("statisticType", StatisticDetailType.DJ_COUNT.getIndex());
			} else if ("houseGjCount".equals(countName)) {
				param.setObject("caseTypeArr", new Integer[] { Const.DIC_CASE_TYPE_SALE_FUN, Const.DIC_CASE_TYPE_LEASE_FUN });
				param.setInteger("statisticType", StatisticDetailType.GJ_COUNT.getIndex());
			} else if ("custGjCount".equals(countName)) {
				param.setObject("caseTypeArr", new Integer[]{Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_CASE_TYPE_RENT_CUST});
				param.setInteger("statisticType", StatisticDetailType.GJ_COUNT.getIndex());
			}  else if ("kyykCount".equals(countName)) {//客源约看（约看）
				param.setObject("caseTypeArr", new Integer[] { Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_CASE_TYPE_RENT_CUST });
				param.setInteger("statisticType", StatisticDetailType.KYYK_COUNT.getIndex());
			}  else if ("dzhfCount".equals(countName)) {//店长回访
				param.setObject("caseTypeArr", new Integer[]{Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_CASE_TYPE_RENT_CUST,Const.DIC_CASE_TYPE_SALE_FUN,Const.DIC_CASE_TYPE_LEASE_FUN});
				param.setInteger("statisticType", StatisticDetailType.DZHF_COUNT.getIndex());
			}  else if ("fymtCount".equals(countName)) {//房源面谈
				param.setObject("caseTypeArr", new Integer[]{Const.DIC_CASE_TYPE_SALE_FUN, Const.DIC_CASE_TYPE_LEASE_FUN});
				param.setInteger("statisticType", StatisticDetailType.MT_COUNT.getIndex());
			}	else if ("kymtCount".equals(countName)) {//客源面谈
					param.setObject("caseTypeArr", new Integer[] { Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_CASE_TYPE_RENT_CUST });
					param.setInteger("statisticType", StatisticDetailType.MT_COUNT.getIndex());
			} else {
				StatisticDetailType detailType = StatisticDetailType.serachIndexByName(countName);
				if (detailType != null) {
					param.setObject("statisticType", detailType.getIndex());
				}
			}
			logList = reportFunStatisticDetail1Mapper.getWorkCountCountsForTrack(getOperator().getCityId(), param.getMap());
		}
		return ErpResponseJson.ok(logList);
	}

	/**
	 * 获取未跟进的房源列表
	 * @author 张宏利
	 * @since 2018年7月9日
	 * @param
	 * countName 工作量的名字（djCount..）
	 * serchRange 	查询范围
	 * dateRange 日期范围（年-月-日~年-月-日）
	 * serchRangeId 	查询范围ID
	 * caseType 信息类型（1、2、3、4）
	 * deptId 门店ID
	 * @throws Exception
	 */
	@RequestMapping("/getNotTrackDetailList")
	public ResponseJson getNotTrackDetailList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		param.setInteger("cityId", operator.getCityId());
		String countName = param.getString("countName");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		// 查看电话和拨打电话后未跟进
		if("dhwgjCount".equals(countName)) {
			param.setInteger("statisticTypeMain", StatisticDetailType.CKDH_COUNT.getIndex());
			param.setInteger("statisticTypeSub", StatisticDetailType.DHDGJ_COUNT.getIndex());
		} else if("ipwgjCount".equals(countName)) {
			param.setInteger("statisticTypeMain", StatisticDetailType.IPCALL_COUNT.getIndex());
			param.setInteger("statisticTypeSub", StatisticDetailType.IPDGJ_COUNT.getIndex());
		} else {
			return ErpResponseJson.warn("暂不支持的类型");
		}
		DataAnalysisController.changeSerchRange(param);
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<Map<String, Object>> caseIdList = reportFunStatisticDetail1Mapper.getNotTrackCaseIdList(operator.getCityId(), param.getMap());
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(caseIdList);
		if(caseIdList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		Set<Object> caseIds = caseIdList.stream().collect(Collectors.mapping(map -> map.get("caseId"), Collectors.toSet()));
		param.setObject("caseIdList", caseIds);
		List<Map<String, Object>> detailCaseList = erpFunSaleMapper.getCaseList(operator.getCityId(), param.getMap());
		// 变成map，减少下面的循环次数
		Map<String, Map<String, Object>> poMap = detailCaseList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("caseId")), val -> val));
		// 加上操作次数
		for (Map<String, Object> dataMap : caseIdList) {
			Map<String, Object> detailCase = poMap.get(String.valueOf(dataMap.get("caseId")));
			if (detailCase != null) {
				detailCase.put("counts", dataMap.get("counts"));
			}
		}
		List<Map<String, Object>> returnList = new LinkedList<>(poMap.values());
		returnList.sort((val1, val2) -> {
			return String.valueOf(val1.get("caseId")).compareTo(String.valueOf(val2.get("caseId")));
		});
		ErpResponseJson erpResponseJson = ErpResponseJson.ok(returnList);
		erpResponseJson.setTotal(pageInfo.getTotal());
		return erpResponseJson;
	}

	/**
	 * 获取工作量详情列表
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param
	 * countName 工作量的名字（djCount..）
	 * serchRange 	查询范围
	 * dateRange 日期范围（年-月-日~年-月-日）
	 * serchRangeId 	查询范围ID
	 * caseType 信息类型（1、2、3、4）
	 * deptId 门店ID
	 * @throws Exception
	 */
	@RequestMapping("/getWorkCountDetailList")
	public ResponseJson getWorkCountDetailList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setInteger("compId", operator.getCompId());
		param.setInteger("cityId", operator.getCityId());
		String countName = param.getString("countName");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		Integer caseType = param.getInteger("caseType");
		boolean isSearchType = true;
		if(countName.startsWith("house")){
			countName = countName.substring(5);
			isSearchType = (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType));
		} else if(countName.startsWith("cust")){
			countName = countName.substring(4);
			isSearchType = (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType));
		} else if(countName.startsWith("sale")){
			countName = countName.substring(4);
			isSearchType = Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType);
		} else if(countName.startsWith("lease")){
			countName = countName.substring(5);
			isSearchType = Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType);
		} else if(countName.startsWith("buy")){
			countName = countName.substring(3);
			isSearchType = Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType);
		} else if(countName.startsWith("rent")){
			countName = countName.substring(4);
			isSearchType = Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType);
		}
		if(!isSearchType) {
			return ErpResponseJson.ok();
		}
		// 兼容精英版、、
		if(countName != null && countName.indexOf("_") >= 0) {
			countName = BeanUtil.underlineToCamel(countName);
		}
		// 兼容精英版、、
		if(startTime == null) {
			String[] dateRange = param.getStringCheck("dateRange").split("~");
			startTime = dateRange[0];
			endTime = dateRange[1];
		}
		StatisticDetailType detailType = StatisticDetailType.serachIndexByName(countName);
		if(detailType != null) {
			param.setObject("statisticType", detailType.getIndex());
		}
		DataAnalysisController.changeSerchRange(param);
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<Map<String, Object>> caseIdList = reportFunStatisticDetail1Mapper.getCaseIdList(operator.getCityId(), param.getMap());
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(caseIdList);
		if(caseIdList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		Set<Object> caseIds = caseIdList.stream().collect(Collectors.mapping(map -> map.get("caseId"), Collectors.toSet()));
		param.setObject("caseIdList", caseIds);
		List<Map<String, Object>> detailCaseList = erpFunSaleMapper.getCaseList(operator.getCityId(), param.getMap());
		// 变成map，减少下面的循环次数
		Map<String, Map<String, Object>> poMap = detailCaseList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("caseId")), val -> val));
		// 加上操作次数
		for (Map<String, Object> dataMap : caseIdList) {
			Map<String, Object> detailCase = poMap.get(String.valueOf(dataMap.get("caseId")));
			if (detailCase != null) {
				detailCase.put("counts", dataMap.get("counts"));
			}
		}
		List<Map<String, Object>> returnList = new LinkedList<>(poMap.values());
		returnList.sort((val1, val2) -> {
			return String.valueOf(val1.get("caseId")).compareTo(String.valueOf(val2.get("caseId")));
		});
		ErpResponseJson erpResponseJson = ErpResponseJson.ok(returnList);
		erpResponseJson.setTotal(pageInfo.getTotal());
		return erpResponseJson;
	}

	/**
	 * 数据查看统计
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getWorkCountForDataView")
	public ResponseJson getWorkCountForDataView(@RequestBody BaseMapParam param) {
		param.setInteger("workCountType", 2);
		return getWorkCountStatisticsBase(param);
	}

	/**
	 * 工作量统计
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @param param
	 * @return
	 */
	@PostMapping("/getWorkCountStatistics")
	public ResponseJson getWorkCountStatistics(@RequestBody BaseMapParam param) {
		param.setInteger("workCountType", 1);
		return getWorkCountStatisticsBase(param);
	}

	/**
	 * 工作量统计
	 * @author 张宏利
	 * @since 2017年7月28日
	 * @param param
	 * @return
	 */
	public ResponseJson getWorkCountStatisticsBase(BaseMapParam param) {
		Integer archiveId = null;
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String caseType = param.getString("caseType");
		String dimension = param.getString("dimension");// 组织维度
		String serchRange = param.getString("serchRange");// 范围
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String userId = param.getString("userId");
		Integer workCountType = param.getInteger("workCountType");// 1=工作量统计,2=数据查看统计
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		if("USER".equals(serchRange)){
			ErpFunUsers userInfo = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getInteger("serchRangeId"));
			archiveId = userInfo.getArchiveId();
		}
		String columnSql = DataAnalysisUtil.getRangeGroupbyTargetStrMin(dimension, getOperator().getAreaFlag());
		param.setString("columnSql", columnSql);
		String queryColumnName = DataAnalysisUtil.getRangeGroupbyTargetStr(dimension, getOperator().getAreaFlag());
		param.setString("groupSql", queryColumnName);
		Set<String> caseTypeSet = new HashSet<>();
		if(StringUtils.isNotBlank(caseType)){
			caseTypeSet = new HashSet<>(Arrays.asList(caseType.split(",")));
			param.setObject("caseTypeArr", caseTypeSet.toArray());
		}
		// 范围内的所有维度数据
		List<Map<String,Object>> rangeList = erpFunUsersMapper.getRangeListDaTaOfCompAreaToZero(getOperator().getCityId(),getOperator().getCompId() ,archiveId, dimension, serchRange, param.getInteger("serchRangeId"), getOperator().getAreaFlag(), null, userId);
		// 工作量统计查询
		DataAnalysisController.changeSerchRange(param);
		List<Map<String,Object>> workCountList = null;
		List<Map<String,Object>> workCountListForDk = null;
		if (workCountType == 1) {
			workCountList = reportFunStatisticTotleMapper.getWorkCountStatistics(getOperator().getCityId(), param.getMap());
			// 以下是很逗比的代码
			Set<String> caseTypeDkSet = new HashSet<>();
			if (caseTypeSet.contains("3") && !caseTypeSet.contains("1")) {
				caseTypeDkSet.add("1");
			}
			if (caseTypeSet.contains("4") && !caseTypeSet.contains("2")) {
				caseTypeDkSet.add("2");
			}
			if (!caseTypeDkSet.isEmpty()) {
				param.setObject("caseTypeArr", caseTypeDkSet.toArray());
				workCountListForDk = reportFunStatisticTotleMapper.getWorkCountStatistics(getOperator().getCityId(), param.getMap());
			}
		} else if(workCountType == 2) {
			workCountList = reportFunStatisticTotleMapper.getWorkCountForDataView(getOperator().getCityId(), param.getMap());
		}
		// 合并数据
		Map<String, Map<String, Object>> listRange = rangeList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("range")), val -> val));
		Map<String, Map<String, Object>> workCountListMap = workCountList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("range")), val -> val));
		listRange.putAll(workCountListMap);
		// 以下是很逗比的代码
		if (workCountListForDk != null) {
			for (Map<String, Object> dkMap : workCountListForDk) {
				Map<String, Object> rangMap = workCountListMap.get(dkMap.get("range"));
				if (rangMap != null) {
					Integer count1 = StringUtil.parseInteger(rangMap.get("dkCount"), 0);
					Integer count2 = StringUtil.parseInteger(dkMap.get("dkCount"), 0);
					rangMap.put("dkCount", count1 + count2);
				}
			}
		}
		// 排序
		List<Map<String, Object>> returnList = new ArrayList<>(listRange.values());
		SortUtil.collectionsSortMap(returnList, "range", true);
		ErpResponseJson json = ErpResponseJson.ok(returnList);
		json.setExtra(caseType + "," + dimension);
		return json;
	}

	/**
	 * 工作量统计排名
	 * @author 方李骥
	 * @since 2017年8月24日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getTotalWorkCountRanking")
	public ResponseJson getTotalWorkCountRanking(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String serchRange = param.getString("serchRange");// 范围
		if ("GROUP".equals(serchRange)) {
			param.setString("serchRange", "GR");
		}
		String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
		param.setString("startTime", timeArr[0]);
		param.setString("endTime", timeArr[1]);
		//工作量统计查询
		List<Map<String,Object>> workCountList = reportFunStatisticTotleMapper.getTotalWorkCountRanking(getOperator().getCityId(), param.getMap());
		return ErpResponseJson.ok(workCountList);
	}

	/**
	 * 获取工作量排名
	 * dimension	组织维度,AREA,REG,DEPT,GROUP,USER
	 * serchRange	搜索范围，COMP,AREA,REG,DEPT,GROUP,USER
	 * serchRangeId	搜索范围Id
	 * caseType		数据类型：1=买卖，2=租赁
	 * startTime	起始时间
	 * endTime		结束时间
	 * @author 张宏利
	 * @since 2017年7月31日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWorkCountRanking")
	public ResponseJson getWorkCountRanking(@RequestBody BaseMapParam param){
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("topCount", 15);
		String caseType = param.getString("caseType");
		DataAnalysisController.changeSerchRange(param);
		param.setInteger("houseType", "101".equals(caseType) ? 1 : 2);
		param.setInteger("custType", "101".equals(caseType) ? 3 : 4);
		List<Map<String, String>> rankList = reportFunStatisticTotleMapper.getWorkCountRanking(getOperator().getCityId(), param.getMap());
		Integer totalWorkCount = reportFunStatisticTotleMapper.getTotalWorkCount(getOperator().getCityId(), param.getMap());
		if("GROUP".equals(serchRange)) {
			serchRange = "GR";
		}
		Integer userCount = erpFunUsersMapper.getUserCountByTimeRange(cityId, compId, serchRange, serchRangeId, startTime, endTime);
		if(totalWorkCount == null) {totalWorkCount = 0;}
		if(userCount == null) {userCount = 0;}
		ErpResponseJson responseJson = ErpResponseJson.ok(rankList);
		responseJson.setExtra(totalWorkCount + "," + userCount);
		return responseJson;
	}

	/**
	 * 获取工作量跟进日志列表
	 * @author 臧铁
	 * @since 2017年8月1日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getWorkCountTrackList")
	public ResponseJson getWorkCountTrackList(@RequestBody BaseMapParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		param.setInteger("cityId", cityId);
		param.setInteger("compId", compId);
		String countName = param.getString("countName");
		String serchRange = param.getString("serchRange");
		String caseType = param.getString("caseType");
		Integer deptId = param.getInteger("deptId");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		Integer caseTypeInt = StringUtil.parseInteger(caseType, 0);
		
		DataAnalysisController.changeSerchRange(param);
		// 去除掉头，房源或客源量有一个 HOUSE_的头 例：HOUSE_DJ_COUNT
		boolean isSearchType = true;
		if(countName.startsWith("house")){
			countName = countName.substring(5);
			isSearchType = (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseTypeInt) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseTypeInt));
		} else if(countName.startsWith("cust")){
			countName = countName.substring(4);
			isSearchType = (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseTypeInt) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseTypeInt));
		} else if(countName.startsWith("sale")){
			countName = countName.substring(4);
			isSearchType = Const.DIC_CASE_TYPE_SALE_FUN.equals(caseTypeInt);
		} else if(countName.startsWith("lease")){
			countName = countName.substring(5);
			isSearchType = Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseTypeInt);
		} else if(countName.startsWith("buy")){
			countName = countName.substring(3);
			isSearchType = Const.DIC_CASE_TYPE_BUY_CUST.equals(caseTypeInt);
		} else if(countName.startsWith("rent")){
			countName = countName.substring(4);
			isSearchType = Const.DIC_CASE_TYPE_RENT_CUST.equals(caseTypeInt);
		} else if (countName.equals("fymtCount") || countName.equals("kymtCount")) { //房、客源面谈
			countName = "mtCount";
		}
		if(!isSearchType) {
			return ErpResponseJson.ok();
		}
		// 兼容精英版、、
		if(countName != null && countName.indexOf("_") >= 0) {
			countName = BeanUtil.underlineToCamel(countName);
		}
		// 兼容精英版、、
		if(startTime == null) {
			String[] dateRange = param.getStringCheck("dateRange").split("~");
			startTime = dateRange[0];
			endTime = dateRange[1];
		}
		StatisticDetailType detailType = StatisticDetailType.serachIndexByName(countName);
		if(detailType != null) {
			param.setObject("statisticType", detailType.getIndex());
		}
		if (StringUtil.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtil.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		// 查询0分组时会查询全公司的，所以查为0的分组时传一个dept_id
		if (("GROUP".equals(serchRange) || "USER".equals(serchRange)) && null != deptId) {
			param.setInteger("deptId", deptId);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<Map<String, Object>> logList = reportFunStatisticDetail1Mapper.getWorkCountTrackIdList(getOperator().getCityId(), param.getMap());
		if(logList == null || logList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(logList);
		Set<String> trackIdSet = logList.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("trackId")), Collectors.toSet()));
		List<ErpFunTrack> trackList = erpFunTrackMapper.getByTrackIds(cityId, trackIdSet.toArray(new String[]{}));
		List<Object> resultList = new LinkedList<>();
		if (trackList.size() > 0) {
			for (ErpFunTrack erpFunTrack : trackList) {
				String encryptedText = CommonUtil.convertSecretInfo(erpFunTrack.getTrackContent(), caseType, false);
				erpFunTrack.setTrackContent(encryptedText);
			}
			resultList.addAll(trackList);
		}
		// 如果数量不一致时查询历史跟进'

		if (logList.size() != trackList.size()) {
			List<ErpFunTrackHis> trackHisList = erpFunTrackHisMapper.getByTrackIds(cityId, trackIdSet.toArray(new String[] {}));
			if (trackHisList.size() > 0) {
				for (ErpFunTrackHis erpFunTrack : trackHisList) {
					String encryptedText = CommonUtil.convertSecretInfo(erpFunTrack.getTrackContent(), caseType, false);
					erpFunTrack.setTrackContent(encryptedText);
				}
				resultList.addAll(trackHisList);
			}
		}
		ErpResponseJson erpResponseJson = ErpResponseJson.ok(resultList);
		erpResponseJson.setTotal(pageInfo.getTotal());
		return erpResponseJson;
	}

/**
 * @author 邓永洪
 * @since 2018/4/10
 * @tag 获取当年应收业绩排名
 */
	@ResponseBody
	@RequestMapping("/getThisYearProfitTrend")
	public ResponseJson getThisYearProfitTrend(@RequestBody BaseMapParam param){
		Operator operator=getOperator();
		Integer cityId = operator.getCityId();

		Integer compId = operator.getCompId();
		String serchRange = param.getString("serchRange");
		String serchRangeReal = getRange(serchRange);
		Integer serchRangeId = getSelfRangeId(serchRange);
		// 查询范围，USER、DEPT
		String dimension = param.getString("dimension");
		String realRange = getRange(dimension) +getRangeAlias(dimension);

		List<Map<String, Object>> list=erpFunProfitService.getThisYearProfitTrend(cityId,compId,serchRangeReal,serchRangeId,realRange,dimension);
		return ErpResponseJson.ok(list);
	}

	/**
	 * @author 邓永洪
	 * @tag 获取最近半年业绩走势
	 * @since 2018/4/11
	 */
	@ResponseBody
	@RequestMapping("/getHalfProfitTrend")
	public ResponseJson getHalfProfitTrend(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();

		Integer compId = operator.getCompId();
		String serchRange = param.getString("serchRange");
		String serchRangeId = param.getString("serchRangeId");
		String realRange = getRange(serchRange);
		List<Map<String, Object>> list = erpFunProfitService.getHalfProfitTrend(cityId, compId, serchRangeId, realRange);
		return ErpResponseJson.ok(list);
	}

	/**
	 * @author 邓永洪
	 * @tag 获取门店/员工房客源新增排名和本门店/本人新增数量
	 * @since 2018/4/11
	 */
	@ResponseBody
	@RequestMapping("/getHouseCustRanking")
	public ResponseJson getHouseCustRanking(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String range = param.getString("searchRange");
		String rangeId = param.getString("searchRangeId");
		String dimension = param.getString("dimension");
		// 没有时查全公司
		if (StringUtils.isBlank(range)) {
			range = "COMP";
			rangeId = getOperator().getCompId().toString();
		}
		String realRange = getRange(range);
		range = getRange(dimension) + getRangeAlias(dimension);
		String groupBy = range.split(" ")[0];
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compId", compId);
		paramMap.put("realRange", realRange);
		paramMap.put("range", range);
		paramMap.put("rangeId", rangeId);
		paramMap.put("groupBy", groupBy);
		Map<String, Object> dataMap = reportFunStatisticTotleService.getHouseCustRanking(cityId, paramMap);
		return ErpResponseJson.ok(dataMap);
	}

	/**
	 * 房源信息统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */
	@ResponseBody
	@ApiOperation("房源信息统计")
	@ApiResponses({@ApiResponse(code = 200, message = "success")})
	@PostMapping("/getMyHouseStatisticsInfo")
	public ResponseJson getMyHouseStatisticsInfo(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		param.setString("dataType", "STATUS");
		param.setInteger("status", 1);
		param.setInteger("caseType", Const.DIC_CASE_TYPE_SALE_FUN);
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		Integer perVerUid = operator.isPersonalVersion() ? operator.getUserId() : null;
		param.setInteger("perVerUid", perVerUid);
		List<Object> saleList = getHouseBottomInfo(param);
		param.setInteger("caseType", Const.DIC_CASE_TYPE_LEASE_FUN);
		List<Object> leaseList = getHouseBottomInfo(param);
		ErpFunSaleDto dataMap = !saleList.isEmpty() ? (ErpFunSaleDto) saleList.get(0) : null;
		if (!leaseList.isEmpty() && dataMap != null) {
			ErpFunLeaseDto dataLeaseMap = (ErpFunLeaseDto) leaseList.get(0);
			int counts = dataMap.getCounts() + dataLeaseMap.getCounts();
			int keyCount = dataMap.getKeyCount() + dataLeaseMap.getKeyCount();
			int explrthCount = dataMap.getExplrthCount() + dataLeaseMap.getExplrthCount();
			int trueCount = dataMap.getTrueCount() + dataLeaseMap.getTrueCount();
			int panoramaCount = dataMap.getPanoramaCount() + dataLeaseMap.getPanoramaCount();
			int scheduleCount = dataMap.getScheduleCount() + dataLeaseMap.getScheduleCount();
			dataMap.setCounts(counts);// 总数
			dataMap.setExplrthCount(explrthCount);// 已房勘
			dataMap.setTrueCount(trueCount);// 真房源
			dataMap.setPanoramaCount(panoramaCount);// 有VR
			dataMap.setScheduleCount(scheduleCount);// 预订
			dataMap.setKeyCount(keyCount);// 有钥匙
		}
		return ErpResponseJson.ok(saleList);
	}

	/**
	 * 获取业绩龙虎榜饼图数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */	
	@ResponseBody
	@RequestMapping("/getFunProfitCountChart")
	public ResponseJson getFunProfitCountChart(@RequestBody BaseMapParam param) {
		Integer cityId=getOperator().getCityId();
		param.setInteger("compId",getOperator().getCompId());
		//ThreadLocalUtil.setEXTRA(showType+","+showType+",");
		String serchRange=param.getString("serchRange");
		Integer serchRangeId=param.getInteger("serchRangeId");
		String endTime=param.getString("endTime");
		serchRangeId = "COMP".equals(serchRange) ? getOperator().getCompId() : serchRangeId;
		endTime += " 23:59:59";
		param.setInteger("serchRangeId",serchRangeId);
		param.setString("endTime",endTime);

		if (serchRange.equals("USER")){
			ErpFunUsers erpFunUsers=erpFunUsersMapper.selectDataByUserId(cityId, getOperator().getCompId(),serchRangeId);
			param.setInteger("serchRangeId",erpFunUsers.getArchiveId());
		}

		List<ErpFunProfitDto> dispatchChart =erpFunProfitMapper.getFunProfitDispatchCountChart(cityId,param.getMap());

		List<ErpFunProfitDto> sourceChart =erpFunProfitMapper.getFunProfitSourceCountChart(cityId,param.getMap());

		List<ErpFunProfitDto> compTotalProfit =erpFunProfitMapper.getCompTotalProfit(cityId,param.getMap());

		Map<String, Object> map = new HashMap<>();
		map.put("dispatProfit", dispatchChart);
		map.put("sourceProfit", sourceChart);
		map.put("compTotalProfit", compTotalProfit);
		List<Object> resultList = new ArrayList<>();
		resultList.add(map);
		return ErpResponseJson.ok(resultList);
	}

	/**
	 * 获取业绩龙虎榜的成交价格分布
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	@ApiOperation("获取业绩龙虎榜的成交价格分布")
	@ApiResponses({@ApiResponse(code = 200,responseContainer = "List",response = ErpFunDealDto.class,message = "success")})
	@ResponseBody
	@RequestMapping("/getCompTransactionDistribution")
	public ResponseJson getCompTransactionDistribution(@RequestBody BaseMapParam param) {
		Integer cityId=getOperator().getCityId();
		param.setInteger("compId",getOperator().getCompId());
		String serchRange=param.getString("serchRange");
		Integer serchRangeId=param.getInteger("serchRangeId");
		Integer caseType=param.getInteger("caseType");
		serchRangeId = "COMP".equals(serchRange) ? getOperator().getCompId() : serchRangeId;

		param.setInteger("serchRangeId",serchRangeId);
		param.setString("endTime",param.getString("endTime")+" 23:59:59");
		param.setString("startTime",param.getString("startTime")+" 00:00:00");
		param.setInteger("archiveId",getOperator().getArchiveId());


		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
		param.setString("serchRange",getRange(serchRange));
		String areaUnit = null;
		String priceUnit = null;
		String dealMoneyStr = "SELL_DEAL_MONEY";
		if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(caseType)) {
			dealMoneyStr = "RENT_DEAL_MONEY";
		}

		areaUnit = adminFunCity.getStatisticsAreaSaleOption();
		priceUnit = adminFunCity.getStatisticsPriceSaleOption();
		if(areaUnit==null) {
			throw new BusinessException("该城市面积分段未配置！");
		}
		if(priceUnit==null) {
			throw new BusinessException("该城市价格分段未配置！");
		}

		/*Map<String, String> areaPriceOptionMap = new HashMap<>();
		List<Map<String, String>> areaPriceOptionList = new LinkedList<>();
		areaPriceOptionMap.put("areaOption", areaUnit);
		areaPriceOptionMap.put("priceOption", priceUnit);
		areaPriceOptionList.add(areaPriceOptionMap);*/

		String mainColumn = getCaseWhenSql(priceUnit, dealMoneyStr, caseType, true);
		param.setString("mainColumn",mainColumn);

		List<ErpFunDealDto> erpFunDealDtoList =erpFunDealMapper.getCompTransactionDistribution(cityId,param.getMap());
		return ErpResponseJson.ok(erpFunDealDtoList);
	}

	/**
	 * 获取业绩龙虎榜统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */
	@ResponseBody
	@RequestMapping("/getProfitRankingStatistics")
	public ResponseJson getProfitRankingStatistics(@RequestBody BaseMapParam param) throws Exception {
		Integer cityId=getOperator().getCityId();
		param.setInteger("compId",getOperator().getCompId());
		String searchRange=param.getString("serchRange");
		Integer searchRangeId=param.getInteger("serchRangeId");
		String showType=param.getString("showType");
		String dimension=param.getString("dimension");
		Integer dataType=param.getInteger("dataType");
		searchRangeId = "COMP".equals(searchRange) ? getOperator().getCompId() : searchRangeId;
		param.setString("serchRange",getRange(searchRange));
		param.setString("endTime",param.getString("endTime")+" 23:59:59");
		param.setInteger("serchRangeId",searchRangeId);
		List<ErpFunDealDto> resultList = null;

		if(getOperator().newOrganizationType()) {
			return this.getProfitStatisticsNewOrg(param);
		}
		// 展示快速成交佣金还是走合同流程成交的佣金
//		String showDealProfitType = erpSysParaMapper.getParamValue(cityId,getOperator().getCompId(),"SHOW_DEAL_PROFIT_TYPE");
		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(getOperator().getCompId());
		int count = erpFunProfitMapper.countByExample(example);
		if(count > 0) {
			if (param.getInteger("pfActual") == 0) {
				param.setString("moneyFieldName", "RECEIVABLE_MONEY");
				resultList = geProfitCountReportOffReceiveble(param);
			} else {
				param.setString("moneyFieldName", "PROFIT_MONEY");
				resultList = geProfitCountReportOffReceiveble(param);
			}
		}else {
			// 读取快速成交的数据 todo
			resultList = this.getSimpleDealData(param);
		}

		
		if(null == resultList || resultList.size() <= 0){
			return ErpResponseJson.ok();
		}
//
		if ("USER".equals(dimension)) {
			List<Integer> archiveIds =resultList.stream().collect(Collectors.mapping(ErpFunDealDto::getArchiveId,Collectors.toList()));
			if (archiveIds.size()>0){
				if ("HOME".equals(showType)){
					List<AdminFunArchive> modelDataList = adminFunArchiveMapper.getListByArchiveIds(archiveIds);
					Map<Integer, String> archivePOMap = new HashMap<>();
					for (AdminFunArchive funArchivePO : modelDataList) {
						archivePOMap.put(funArchivePO.getArchiveId(), funArchivePO.getUserPhoto());
					}
					for (int i = resultList.size() - 1; i >= 0; i--) {
						ErpFunDealDto dataObject = resultList.get(i);
						String bbsPhoto = archivePOMap.get(dataObject.getArchiveId());
						dataObject.setBbsPhoto(StringUtil.getBbsPhoto(bbsPhoto));
					}
				}
				List<ErpFunUsers> funUsersList = erpFunUsersMapper.getFunUsersListByAreaIds(cityId,archiveIds);
				Map<Integer, ErpFunUsers> mapByArchiveId =funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId,val->val));
				for (int i = resultList.size() - 1; i >= 0; i--) {
					ErpFunDealDto dataObject = resultList.get(i);
					ErpFunUsers funUsersPO = mapByArchiveId.get(dataObject.getArchiveId());
					if(null != funUsersPO) {
						dataObject.setUserId(funUsersPO.getUserId());
					}
				}
			}
		}

		if("DEPT".equals(dimension)){
			for (int i = resultList.size() - 1; i >= 0; i--) {
				ErpFunDealDto dataObject = resultList.get(i);
				Integer deptId = dataObject.getDeptId();
				if(deptId == null){
					resultList.remove(dataObject);
				}
			}
		}
		if("GROUP".equals(dimension)){
			for (int i = resultList.size() - 1; i >= 0; i--) {
				ErpFunDealDto dataObject = resultList.get(i);
				Integer grId = dataObject.getGrId();
				if(grId == null){
					resultList.remove(dataObject);
				}
			}
		}

		//转在sql 排序
//		if (("CHART".equals(showType) || showType.equals("HOME")) && dataType!=null) {// 首页或图表使用：租赁+买卖的总业绩和（总业绩）排序
//			this.collectionsSortByAdd(resultList, new String[] { "totalProfit" }, dataType==2);
//		} else {// 报表使用组织机构排序
//			//String[] byArrs = getOrderByStr(dimension,showType);
//			String[] byArrs = new String[] { "areaId", "regId", "deptId", "grId", "userId" };
//			this.collectionsSort(resultList, byArrs, true);
//		}

		// 根据参数处理数据
		String isShowProfitData = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId,getOperator().getCompId(),getOperator().getUserId(), "IS_SHOW_PROFIT_DATA");
		if(showType.equals("HOME") && (isShowProfitData ==null || "0".equals(isShowProfitData))) {
			BigDecimal data=new BigDecimal(0);
			for (ErpFunDealDto dataObject : resultList) {
				dataObject.setTransferDealProfit(data);
				dataObject.setSecondhandDealProfit(data);
				dataObject.setNewhouseDealProfit(data);
				dataObject.setLeaseDealProfitl(data);
				dataObject.setFinanceDealProfit(data);
				dataObject.setFinanceTotalProfit(data);
				dataObject.setTotalProfit(data);
				dataObject.setDealTotalProfit(data);
				dataObject.setTransferTotalProfit(data);
				dataObject.setSecondhandTotalProfit(data);
				dataObject.setNewhouseTotalProfit(data);
				dataObject.setLeaseTotalProfit(data);
				dataObject.setFinanceTotalProfit(data);
				dataObject.setNewhouseDealCount(data);
				dataObject.setSecondhandDealCount(data);
				dataObject.setLeaseDealCount(data);
				dataObject.setTotalDealCount(data);
			}
		}
		//倒序排序 dyh 2018/7/23
		resultList.sort(((o1, o2) -> {
			if (o1.getTotalProfit() == null) o1.setTotalProfit(new BigDecimal(0));
			if (o2.getTotalProfit() == null) o2.setTotalProfit(new BigDecimal(0));
			return o2.getTotalProfit().compareTo(o1.getTotalProfit());
		}));
		return ErpResponseJson.ok(resultList);
	}

	/**
	 * 新版组织架构业绩报表
	 * @param param
	 * @return
	 */
	public ResponseJson getProfitStatisticsNewOrg(BaseMapParam param) throws Exception {
		Integer cityId=getOperator().getCityId();
		List<ErpFunDealDto> resultList = null;
		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(getOperator().getCompId());
		int count = erpFunProfitMapper.countByExample(example);
		if(count > 0) {
			if (param.getInteger("pfActual") == 0) {	//应收统计
				param.setString("moneyFieldName", "RECEIVABLE_MONEY");
				resultList = this.geProfitCountReportOffReceivebleNewOrg(param);
			} else {	//实收统计
				param.setString("moneyFieldName", "PROFIT_MONEY");
				resultList = this.geProfitCountReportOffReceivebleNewOrg(param);
			}
		}else {
			// 读取快速成交的数据 todo
			resultList = this.getSimpleDealDataNewOrg(param);
		}


		if(null == resultList || resultList.size() <= 0){
			return ErpResponseJson.ok();
		}



		return ErpResponseJson.ok();
	}


	private List<ErpFunDealDto> geProfitCountReportOffReceivebleNewOrg(BaseMapParam param) throws Exception {
		Integer cityId=getOperator().getCityId();
		String searchRange=param.getString("serchRange");
		String dimension=param.getString("dimension");
		String showType=param.getString("showType");
		Integer serchRangeId=param.getInteger("serchRangeId");
		//获取范围对应查询的列

		GetSelectNmaesParam getSelectNmaesParam = new GetSelectNmaesParam();
		getSelectNmaesParam.setCityId(cityId);
		getSelectNmaesParam.setCompId(param.getInteger("compId"));
		getSelectNmaesParam.setDefId(param.getInteger("defId"));
		if(param.getInteger("defId") == -2){
			getSelectNmaesParam.setSelectName("USER_ID");
		}
		String groupBy = erpFunOrganizationService.getSelectNames(getSelectNmaesParam);
		String concatStr = erpFunOrganizationService.getConcatNames("b."+groupBy.replaceAll("\\,",",b."));
		param.setString("queryStr", "b."+groupBy.replaceAll("\\,",",b.")+ concatStr + "  AS RANGE");
		param.setString("groupBy", "b."+groupBy.replaceAll("\\,",",b."));
		if(param.getInteger("defId") == -2){
			ErpFunUsers erpFunUsers=erpFunUsersMapper.selectDataByUserId(cityId, param.getInteger("compId"),serchRangeId);
			param.setInteger("archiveId",erpFunUsers.getArchiveId());
		}

		GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
		getSelectWhereParam.setOrganizationId(param.getInteger("organizationId"));
		getSelectWhereParam.setCityId(cityId);
		getSelectWhereParam.setUserId(param.getInteger("userId"));
		getSelectWhereParam.setFileName("USER_ID");
		getSelectWhereParam.setPrefix("b.");
		String rangeColumn = erpFunOrganizationService.getSelectWhere(getSelectWhereParam);
		param.setString("rangeColumn",rangeColumn);

		List<ErpFunDealDto> returnList=erpFunDealMapper.getListOFExcuteByParamNewPrg(cityId,param.getMap());
		List<ErpFunDealDto> dealCountList=erpFunDealMapper.getDealCountListByParamNewPrg(cityId,param.getMap());
		List<ErpFunDealDto> officialOrdersCountList=erpFunDealMapper.getofficialOrdersCountListByParamNewPrg(cityId,param.getMap());

		String startTime=param.getString("startTime");
		String endTime=param.getString("endTime");
		param.setString("startTime",DateUtil.getFirstDay(startTime));
		param.setString("endTime",DateUtil.getLastDay(endTime));


		param.setString("targeQueryStr",groupBy+" AS RANGE");
		Integer profitType=Const.Count.PROFIT_COUNT_TYPE_MAP.get(dimension);
		param.setInteger("profitType",profitType);
		param.setString("targeGroupBy",groupBy);
		if(param.getInteger("defId") == -2){
			param.setInteger("userId",serchRangeId);
		}
		//查询目标业绩
		List<ErpFunDealDto> targetList=erpFunDealMapper.getTargetListByParamNewOrg(cityId,param.getMap());

		Map<String,ErpFunDealDto> dealCountMap = dealCountList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		Map<String,ErpFunDealDto> targetMap =targetList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		Map<String,ErpFunDealDto> officialOrdersMap =officialOrdersCountList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		List<String> officialOrdersKeyList = officialOrdersCountList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		List<String> dealCountKeyList = dealCountList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		List<String> targetKeyList = targetList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		//查询需要扑数据的
		Map<String, ErpFunDealDto> listRange = getRangeListDaTaOfComp(param);
		//补数据通过RANGE作为key来对应数据
		for(ErpFunDealDto dataObject:returnList){
			String val= dataObject.getRange();
			ErpFunDealDto dealCountData = dealCountMap.get(val);
			if(dealCountData!=null){
				dataObject.setRange(dealCountData.getRange());
				dealCountKeyList.remove(val);
			}
			ErpFunDealDto officialOrdersData = officialOrdersMap.get(val);
			if(officialOrdersData!=null){
				dataObject.setRange(officialOrdersData.getRange());

				officialOrdersKeyList.remove(val);
			}
			ErpFunDealDto targetData = targetMap.get(val);
			if(targetData!=null){
				dataObject.setRange(targetData.getRange());

				targetKeyList.remove(val);
			}
		}
		if(!dealCountKeyList.isEmpty()){
			for(String key:dealCountKeyList){
				ErpFunDealDto dealCountData = dealCountMap.get(key);
				ErpFunDealDto targetData = targetMap.get(key);
				ErpFunDealDto officialOrdersData = officialOrdersMap.get(key);
				if(targetData!=null){
					dealCountData.setRange(targetData.getRange());
					targetKeyList.remove(key);
				}
				if(officialOrdersData!=null){
					dealCountData.setRange(officialOrdersData.getRange());


					officialOrdersKeyList.remove(key);
				}
				returnList.add(dealCountData);
			}
		}
		if(!officialOrdersKeyList.isEmpty()){
			for(String key:officialOrdersKeyList){
				ErpFunDealDto officialOrdersData = officialOrdersMap.get(key);;
				ErpFunDealDto targetData = targetMap.get(key);
				if(targetData!=null){
					officialOrdersData.setRange(targetData.getRange());

					targetKeyList.remove(key);
				}
				returnList.add(officialOrdersData);
			}
		}
		if (!targetKeyList.isEmpty()) {
			for (String key : targetKeyList) {
				ErpFunDealDto targetData = targetMap.get(key);
				returnList.add(targetData);
			}
		}

		for (ErpFunDealDto dataObject : returnList) {
			String val =  dataObject.getRange();
			listRange.put(val, dataObject);
		}

		List<ErpFunDealDto> returnDataObjectList = new ArrayList<>();
		Iterator<Map.Entry<String, ErpFunDealDto>> entries = listRange.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, ErpFunDealDto> entry = entries.next();
			ErpFunDealDto erpFunDealDto=entry.getValue();
			returnDataObjectList.add(erpFunDealDto);
		}
		return returnDataObjectList;
	}

	private List<ErpFunDealDto> getSimpleDealDataNewOrg(BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		String dimension=param.getString("dimension");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String showType=param.getString("showType");
		boolean isHome = "HOME".equals(showType);
		param.setObject("isHome",isHome);
		if (isHome){
			if ("USER_ID".equals(serchRange)) {
				ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, serchRangeId);
				if (funUsers!=null){
					param.setInteger("archiveId",funUsers.getUserId());
				}
			}
		}
		String queryStr = getRangeQueryStr(dimension,showType);
		param.setString("queryStr",queryStr);
		List<ErpFunDealDto> returnList=erpFunOutdealMapper.getProfitCountList(cityId,param,false);
		List<ErpFunDealDto>  dealCountList = erpFunOutdealMapper.getProfitCountList(cityId,param,true);

		endTime = DateUtil.getLastDay(startTime);
		startTime = DateUtil.getFirstDay(startTime);
		param.setString("startTime",startTime);
		param.setString("endTime",endTime);
		if ("USER_ID".equals(serchRange) && !isHome) {
			ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, serchRangeId);
			if (funUsers!=null){
				param.setInteger("archiveId",funUsers.getUserId());
			}
		}
		String profitType = Constants_DIC.Count.PROFIT_COUNT_TYPE_MAP.get(dimension);
		param.setString("profitType",profitType);
		List<ErpFunDealDto> targetList = erpFunProfitTargetMapper.getTargetListMap(cityId,param);
		Map<String,ErpFunDealDto> targetMap = targetList.stream().collect(Collectors.toMap(map -> map.getRange(), map -> map));
		List<String> targetKeyList = targetList.stream().collect(Collectors.mapping(map -> map.getRange(), Collectors.toList()));

		Map<String, ErpFunDealDto> dealCountMap = dealCountList.stream().collect(Collectors.toMap(map -> map.getRange(), map -> map));
		List<String> dealCountKeyList = dealCountList.stream().collect(Collectors.mapping(map -> map.getRange(), Collectors.toList()));
		Map<String,Map<String, Object>> listRange = getRangeListDaTaOfComp(dimension, serchRange, serchRangeId, showType);

		//TODO 新版组织架构业绩报表查询外成交合同统计信息，待修改，暂无思路
		return null;
	}

	/**
	 * 获取业绩分析
	 * @param
	 * @return  todo 需求有变更
	 * @auther 胡坤
	 * @since 2018/6/4
	 */
	@ApiOperation("获取业绩分析")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunProfitDto.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getProfitAnalyse")
	public ResponseJson getProfitAnalyse(@RequestBody ProfitAnalyseParam param) throws Exception {
		Integer cityId=getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String serchRange=param.getSerchRange();
		Integer year=param.getYear();
		serchRange = "COMP".equals(serchRange) ? StringUtil.toString(getOperator().getCompId())  : serchRange;
		param.setSerchRange(serchRange);
		String startTime=param.getStartTime();
		String endTime=param.getEndTime();
		Integer pfActual=param.getPfActual();
		Integer serchRangeId=param.getSerchRangeId();
		String dateRange=param.getDateRange();
		Integer dataType=param.getDataType();
		param.setCompId(getOperator().getCompId());

		if (year!=null) {
			startTime = year+"-01-01";
			endTime = year+"-12-31 23:59:59";
		} else {
			endTime = endTime+"-01";
			startTime = startTime + "-01";
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateTimeHelper.parseToDate(endTime));
			calendar.set(Calendar.DAY_OF_MONTH,1);
			calendar.add(Calendar.MONTH,1);
			calendar.add(Calendar.DAY_OF_MONTH,-1);
			endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59";
		}
		param.setStartTime(startTime);
		param.setEndTime(endTime);

		if (serchRange.equals("USER")){
			ErpFunUsers erpFunUsers=erpFunUsersMapper.selectDataByUserId(cityId, getOperator().getCompId(),serchRangeId);
			param.setSerchRangeId(erpFunUsers.getArchiveId());
		}

		buildPerformanceTypeString(param);
		List<ErpFunProfitDto> nowFunProfit=null;
		// 展示快速成交佣金还是走合同流程成交的佣金
//		String showDealProfitType = erpSysParaMapper.getParamValue(cityId,compId,"SHOW_DEAL_PROFIT_TYPE");
		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId);
		Integer count = erpFunProfitMapper.countByExample(example);
		if(count > 0) {
			if(pfActual==1){
				nowFunProfit =erpFunProfitMapper.getSSProfitAnalyse(cityId,param);
			}else{
				nowFunProfit=erpFunProfitMapper.getYSProfitAnalyse(cityId,param);
			}
		}else{
			if ("USER".equals(serchRange)){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,serchRangeId);
				serchRangeId = erpFunUsers.getArchiveId();
			}
			nowFunProfit = erpFunProfitMapper.getSimpleDealData(cityId,compId,serchRange, serchRangeId, dataType, startTime, endTime, dateRange);
		}

		Map<String, ErpFunProfitDto> nowFunProfitMap =nowFunProfit.stream().collect(Collectors.toMap(ErpFunProfitDto::getDate,val->val));

		List<String> metadata = "MONTH".equals(dateRange) ? DateUtil.getMonthBetween(startTime, endTime) : Const.QUARTER;
		String[] dateTimeArr = DateUtil.convertTimeRangeToFrontYear(startTime, endTime);
		param.setStartTime(dateTimeArr[0]);
		param.setEndTime(dateTimeArr[1]);
		List<ErpFunProfitDto> prevFunProfit=null;
		if(count > 0) {
			if(pfActual==1){
				prevFunProfit =erpFunProfitMapper.getSSProfitAnalyse(cityId,param);
			}else{
				prevFunProfit=erpFunProfitMapper.getYSProfitAnalyse(cityId,param);
			}
		}else{
			if ("USER".equals(serchRange)){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,serchRangeId);
				serchRangeId = erpFunUsers.getArchiveId();
			}
			prevFunProfit = erpFunProfitMapper.getSimpleDealData(cityId,compId,serchRange, serchRangeId, dataType, startTime, endTime, dateRange);
		}

		Map<String, ErpFunProfitDto> prevFunProfitMap = prevFunProfit.stream().collect(Collectors.toMap(ErpFunProfitDto::getDate,val->val));

		List<ErpFunProfitDto> resutlList = new ArrayList<>();
		for(String row : metadata){
			String month = new String(row);
			if("MONTH".equals(dateRange)){
				row = row.split("-")[1];
			}
			ErpFunProfitDto nowDataObject = nowFunProfitMap.get(row);
			ErpFunProfitDto prevDataObject = prevFunProfitMap.get(row);
			ErpFunProfitDto resultDo = new ErpFunProfitDto();
			BigDecimal nowValue = nowDataObject == null ?  new BigDecimal(0) : dataType==1 ? nowDataObject.getFromCount():new BigDecimal(nowDataObject.getProfitCount());
			BigDecimal prevValue = prevDataObject == null ?  new BigDecimal(0) : dataType==1 ? prevDataObject.getFromCount():new BigDecimal(prevDataObject.getProfitCount());
			resultDo.setDate(month);
			resultDo.setNowCount(nowValue);
			resultDo.setPrevCount(prevValue);
			resutlList.add(resultDo);
		}
		return ErpResponseJson.ok(resutlList);
	}

	/**
	 * 房源成交统计分析
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/5
	 */
	@ResponseBody
	@RequestMapping("/getHouseInnerDealAnalysisCountList")
	public ResponseJson getHouseInnerDealAnalysisCountList(@RequestBody BaseMapParam param) throws Exception {
		String endTime = param.getString("endTime")+"-01";
		String startTime=param.getString("startTime")+"-01";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(endTime));
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.add(Calendar.MONTH,1);
		calendar.add(Calendar.DAY_OF_MONTH,-1);
		endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		param.setString("endTime",endTime+" 23:59:59");
		param.setString("startTime",startTime);
		param.setInteger("compId",getOperator().getCompId());
		param.setInteger("archiveId",getOperator().getArchiveId());
		Integer cityId=getOperator().getCityId();
		String serchRange=param.getString("serchRange");
		if(!"COMP".equals(serchRange)){
			if("GROUP".equals(serchRange)){
				param.setString("serchRange","GR");
			}
		}
		if ("USER".equals(serchRange)) {
			ErpFunUsers funUsers = erpFunUsersMapper.selectByUserId(cityId, param.getInteger("serchRangeId"));
			if (funUsers.getUserLevel()!=null) {
				param.setInteger("userLevel", funUsers.getUserLevel()+2);
			}
		}
		List<ErpHouseInnerdealAnalysisDto> erpHouseInnerdealAnalysisList = erpHouseInnerdealAnalysisMapper.getHouseInnerDealAnalysisCountList(cityId,param.getMap());//查询数据库
		if(erpHouseInnerdealAnalysisList.isEmpty()){
			return ErpResponseJson.ok();
		}
		erpHouseInnerdealAnalysisList = mergedTheSameMonthData(erpHouseInnerdealAnalysisList);//合并封装数据
		List<String> datelList = DateUtil.getMonthBetween(startTime, endTime);
		Map<String,ErpHouseInnerdealAnalysisDto> dataMap =erpHouseInnerdealAnalysisList.stream().collect(Collectors.toMap(ErpHouseInnerdealAnalysisDto::getMonthofyear,val->val));
		for(String dateStr:datelList){
			ErpHouseInnerdealAnalysisDto data = dataMap.get(dateStr);
			if(data==null){
				data = new ErpHouseInnerdealAnalysisDto();
				data.setMonthofyear(dateStr);
				erpHouseInnerdealAnalysisList.add(data);
			}
		}
		Collections.sort(erpHouseInnerdealAnalysisList, new Comparator<ErpHouseInnerdealAnalysisDto>() {
			@Override
			public int compare(ErpHouseInnerdealAnalysisDto o1, ErpHouseInnerdealAnalysisDto o2) {
				return o1.getMonthofyear().compareTo(o2.getMonthofyear());
			}
		});
		return ErpResponseJson.ok(erpHouseInnerdealAnalysisList);
	}

	/**
	 * 最近一周工作情况
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/6
	 */
	@ResponseBody
	@RequestMapping("/getUserMonthWorkCore")
	public ResponseJson getUserMonthWorkCore(@RequestBody BaseMapParam param) {
		int dayOfQuery = 7;
		Operator operator = getOperator();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_YEAR, -dayOfQuery);//（ 现在改成一周的了）
		String dateTimeStr = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		Integer cityId=operator.getCityId();
		Integer userId=operator.getUserId();
		Integer compId=operator.getCompId();
		List<ErpFunStatisticTotleDto> poList =reportFunStatisticTotleMapper.getWorkCountList(cityId,compId,userId,dateTimeStr);
		if(poList == null){
			poList = new LinkedList<>();
		}
		List<FafunFafaDetailLogDto> fafaDetailLogDtoList=fafunFafaDetailLogMapper.getFafaCountList(cityId,compId,userId,dateTimeStr);
		Map<String, ErpFunStatisticTotleDto> dataMap = new HashMap<>();
		for (ErpFunStatisticTotleDto vo : poList) {
			ErpFunStatisticTotleDto voGet = dataMap.get(vo.getCoreTime());
			if(voGet == null) {
				dataMap.put(vo.getCoreTime(), vo);
				continue;
			}
			int totalScore = vo.getTotalScore()+voGet.getTotalScore();
			voGet.setTotalScore(totalScore);
		}
		// 合并发布量和其他量
		for (FafunFafaDetailLogDto dataObject : fafaDetailLogDtoList) {
			ErpFunStatisticTotleDto voGet = dataMap.get(dataObject.getCoreTime());
			if(voGet == null) {
				voGet = new ErpFunStatisticTotleDto();
				voGet.setTotalScore(dataObject.getTotalScore());
				voGet.setCoreTime(dataObject.getCoreTime());
				dataMap.put(dataObject.getCoreTime(), voGet);
				continue;
			}
			int totalScore = dataObject.getTotalScore()+voGet.getTotalScore();
			voGet.setTotalScore(totalScore);
		}
		List<ErpFunStatisticTotleDto> arrayList = new ArrayList<>(dataMap.values());
		Collections.sort(arrayList, new Comparator<ErpFunStatisticTotleDto>() {
			@Override
			public int compare(ErpFunStatisticTotleDto o1, ErpFunStatisticTotleDto o2) {
				return o1.getCoreTime().compareTo(o2.getCoreTime());
			}
		});
		// 拼没有的数据
		for (int i = 0; i < dayOfQuery; i++) {
			String dateTimeTemp = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
			ErpFunStatisticTotleDto vo = null;
			if(arrayList.size() > i) {
				vo = arrayList.get(i);
			}
			if(vo == null || !dateTimeTemp.equals(vo.getCoreTime())){
				ErpFunStatisticTotleDto voInsert = new ErpFunStatisticTotleDto();
				voInsert.setCoreTime(dateTimeTemp);
				voInsert.setTotalScore(0);
				arrayList.add(i, voInsert);
			}
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
		return ErpResponseJson.ok(arrayList);
	}

	/**
	 * 合并封装数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/5
	 */
	private List<ErpHouseInnerdealAnalysisDto> mergedTheSameMonthData(List<ErpHouseInnerdealAnalysisDto> erpHouseInnerdealAnalysisList) {
		Map<String,ErpHouseInnerdealAnalysisDto> map = new HashMap<>();
		for(ErpHouseInnerdealAnalysisDto dataObject:erpHouseInnerdealAnalysisList){
			String monthOffYear = dataObject.getMonthofyear();
			ErpHouseInnerdealAnalysisDto data = map.get(monthOffYear);
			if(data!=null){
				data.setCount1(data.getCount1().add(dataObject.getCount1()));
				data.setCount2(data.getCount2().add(dataObject.getCount2()));
				data.setCount3(data.getCount3().add(dataObject.getCount3()));
				data.setCount4(data.getCount4().add(dataObject.getCount4()));
				data.setCount5(data.getCount5().add(dataObject.getCount5()));
				data.setCount6(data.getCount6().add(dataObject.getCount6()));
				data.setCount7(data.getCount7().add(dataObject.getCount7()));
			}else{
				map.put(monthOffYear, dataObject);
			}
		}
		return new ArrayList<>(map.values());
	}


	/**
	 * 参数设置
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/4
	 */	
	private void buildPerformanceTypeString(ProfitAnalyseParam param){
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		List<ErpFunPerformanceType> funPerformanceTypeList = erpFunPerformanceTypeMapper.getPerformanceType(cityId,compId);
		Map<Integer, ErpFunPerformanceType> funPerformanceTypeMap=funPerformanceTypeList.stream().collect(Collectors.toMap(ErpFunPerformanceType::getPerformanceId,val->val));

		StringBuilder sb = new StringBuilder();
		StringBuilder sumBuilder = new StringBuilder();
		Iterator<Integer> funPerformanceTypeIt = funPerformanceTypeMap.keySet().iterator();
		while (funPerformanceTypeIt.hasNext()) {
			Integer performanceId = funPerformanceTypeIt.next();
			sb.append("[A_" + performanceId + "_COUNT" + "],");
			sumBuilder.append("isnull(A.A_"+performanceId+"_COUNT,0)+");
			//"isnull(B.A_"+po.getPAYMENT_ID() + "_COUNT,0)+"
		}
		String sumStr = sumBuilder.toString();
		sumStr = sumStr.substring(0, sumStr.length()-1);
		String columnStr = sb.toString();
		columnStr = columnStr.substring(0, columnStr.length()-1);
		param.setSumStr(sumStr);
		param.setColumnStr(columnStr);
	}


	/**
	 * 根据维度统计应收，实收签单量，办单量
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */
	private List<ErpFunDealDto> geProfitCountReportOffReceiveble(BaseMapParam param) throws Exception {
		Integer cityId=getOperator().getCityId();
		String searchRange=param.getString("serchRange");
		String dimension=param.getString("dimension");
		String showType=param.getString("showType");
		Integer serchRangeId=param.getInteger("serchRangeId");
		//获取范围对应查询的列
		String queryStr = getRangeQueryStr(dimension, showType);
		param.setString("queryStr",queryStr);
		String groupBy=getRangeGroupbyStr(dimension, showType);
		param.setString("groupBy",groupBy);
		if (searchRange.equals("USER")){
			ErpFunUsers erpFunUsers=erpFunUsersMapper.selectDataByUserId(cityId, param.getInteger("compId"),serchRangeId);
			param.setInteger("archiveId",erpFunUsers.getArchiveId());
		}
		List<ErpFunDealDto> returnList=erpFunDealMapper.getListOFExcuteByParam(cityId,param.getMap());
		List<ErpFunDealDto> dealCountList=erpFunDealMapper.getDealCountListByParam(cityId,param.getMap());
		List<ErpFunDealDto> officialOrdersCountList=erpFunDealMapper.getofficialOrdersCountListByParam(cityId,param.getMap());

		String startTime=param.getString("startTime");
		String endTime=param.getString("endTime");
		param.setString("startTime",DateUtil.getFirstDay(startTime));
		param.setString("endTime",DateUtil.getLastDay(endTime));


		String targeQueryStr = getRangeQueryTargetStr(dimension);
		param.setString("targeQueryStr",targeQueryStr);
		Integer profitType=Const.Count.PROFIT_COUNT_TYPE_MAP.get(dimension);
		param.setInteger("profitType",profitType);
		param.setString("targeGroupBy",getRangeGroupbyTargetStr(dimension));
		//查询目标业绩
		List<ErpFunDealDto> targetList=erpFunDealMapper.getTargetListByParam(cityId,param.getMap());

		Map<String,ErpFunDealDto> dealCountMap = dealCountList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		Map<String,ErpFunDealDto> targetMap =targetList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		Map<String,ErpFunDealDto> officialOrdersMap =officialOrdersCountList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		List<String> officialOrdersKeyList = officialOrdersCountList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		List<String> dealCountKeyList = dealCountList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		List<String> targetKeyList = targetList.stream().collect(Collectors.mapping(ErpFunDealDto::getRange, Collectors.toList()));

		//查询需要扑数据的
		Map<String, ErpFunDealDto> listRange = getRangeListDaTaOfComp(param);
		//补数据通过RANGE作为key来对应数据
		for(ErpFunDealDto dataObject:returnList){
			String val= dataObject.getRange();
			ErpFunDealDto dealCountData = dealCountMap.get(val);
			if(dealCountData!=null){
				dataObject.setRange(dealCountData.getRange());
				dealCountKeyList.remove(val);
			}
			ErpFunDealDto officialOrdersData = officialOrdersMap.get(val);
			if(officialOrdersData!=null){
				dataObject.setRange(officialOrdersData.getRange());

				officialOrdersKeyList.remove(val);
			}
			ErpFunDealDto targetData = targetMap.get(val);
			if(targetData!=null){
				dataObject.setRange(targetData.getRange());

				targetKeyList.remove(val);
			}
		}
		if(!dealCountKeyList.isEmpty()){
			for(String key:dealCountKeyList){
				ErpFunDealDto dealCountData = dealCountMap.get(key);
				ErpFunDealDto targetData = targetMap.get(key);
				ErpFunDealDto officialOrdersData = officialOrdersMap.get(key);
				if(targetData!=null){
					dealCountData.setRange(targetData.getRange());
					targetKeyList.remove(key);
				}
				if(officialOrdersData!=null){
					dealCountData.setRange(officialOrdersData.getRange());


					officialOrdersKeyList.remove(key);
				}
				returnList.add(dealCountData);
			}
		}
		if(!officialOrdersKeyList.isEmpty()){
			for(String key:officialOrdersKeyList){
				ErpFunDealDto officialOrdersData = officialOrdersMap.get(key);;
				ErpFunDealDto targetData = targetMap.get(key);
				if(targetData!=null){
					officialOrdersData.setRange(targetData.getRange());

					targetKeyList.remove(key);
				}
				returnList.add(officialOrdersData);
			}
		}
		if (!targetKeyList.isEmpty()) {
			for (String key : targetKeyList) {
				ErpFunDealDto targetData = targetMap.get(key);
				returnList.add(targetData);
			}
		}

		for (ErpFunDealDto dataObject : returnList) {
			String val =  dataObject.getRange();
			listRange.put(val, dataObject);
		}

		List<ErpFunDealDto> returnDataObjectList = new ArrayList<>();
		Iterator<Map.Entry<String, ErpFunDealDto>> entries = listRange.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, ErpFunDealDto> entry = entries.next();
			ErpFunDealDto erpFunDealDto=entry.getValue();
			returnDataObjectList.add(erpFunDealDto);
		}
		return returnDataObjectList;
	}

	/**
	 * 查询需要扑数据的
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */	
	private Map<String,ErpFunDealDto> getRangeListDaTaOfComp(BaseMapParam param) {
		String dimension=param.getString("dimension");
		String serchRangeId=param.getString("serchRangeId");

		param.setString("serchRangeIds",serchRangeId);

		Integer cityId=getOperator().getCityId();
		Integer flag="1".equals(getOperator().getAreaFlag())?1:0;
		param.setInteger("flag",flag);
		List<ErpFunDealDto> funDealDtoList=erpFunAreaMapper.getRangeListData(cityId, param.getMap());

		//Map<Integer, ErpFunDealDto> funDealDtoMap=funDealDtoList.stream().collect(Collectors.toMap(ErpFunDealDto::getArchiveId,val->val));
		Map<String, ErpFunDealDto> funDealDtoMap = new HashMap<>();
		if ("USER".equals(dimension)){
//			for(ErpFunDealDto obj : funDealDtoList){
//				funDealDtoMap.put(obj.getArchiveId(), obj);
//			}
			funDealDtoMap =funDealDtoList.stream().collect(Collectors.toMap(val->StringUtil.toString(val.getArchiveId()),val->val));
		}else {
//			for(ErpFunDealDto obj : funDealDtoList){
//				funDealDtoMap.put(StringUtil.paseInteger(obj.getRange()), obj);
//			}
			funDealDtoMap =funDealDtoList.stream().collect(Collectors.toMap(ErpFunDealDto::getRange,val->val));
		}
		return funDealDtoMap;
	}

	/**
	 * 获取排序参数
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/6
	 */
	private  String[] getOrderByStr(String orderBy,String showType){
		String resultStr = "";
		if("COMP".equals(orderBy)){
			resultStr = "compId";
		} else if("AREA".equals(orderBy)){
			if(!"1".equals(getOperator().getAreaFlag())){
				resultStr = "compId";
			}else {
				resultStr = "compId,areaId";
			}
		} else if("REG".equals(orderBy)){
			resultStr = "compId,areaId,regId";
		} else if("DEPT".equals(orderBy)){
			resultStr = "compId,areaId,regId,deptId";
		} else if("GROUP".equals(orderBy)){
			resultStr = "compId,areaId,regId,deptId,grId";
		} else if("USER".equals(orderBy)){
			resultStr = "compId,archiveId";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("areaId,'_',", "").replaceAll("areaId,", "");
		}
		String[] result=resultStr.split(",");
		return result;
	}

	/**
	 * 获取范围对应查询的列
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */	
	private  String getRangeQueryStr(String groupby,String showType){
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "b.COMP_ID";
		} else if("AREA".equals(groupby)){
			if(!"1".equals(getOperator().getAreaFlag())){
				resultStr = "b.COMP_ID";
			}else {
				resultStr = "b.COMP_ID,b.AREA_ID,CONCAT(b.AREA_ID,'','') AS RANGE";
			}
		} else if("REG".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'') AS RANGE";
		} else if("DEPT".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID) AS RANGE";
		} else if("GROUP".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID) AS RANGE";
		} else if("USER".equals(groupby)){
			resultStr = "b.COMP_ID,b.ARCHIVE_ID,b.ARCHIVE_ID AS RANGE";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID,", "");
		}
		return resultStr;
	}

	/**
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */
	private  String getRangeQueryTargetStr(String groupby){
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID";
		} else if("AREA".equals(groupby)){
			if(!"1".equals(getOperator().getAreaFlag())){
				resultStr = "COMP_ID";
			}else {
				resultStr = "COMP_ID,AREA_ID,CONCAT(AREA_ID,'','') AS RANGE";
			}
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID,'') AS RANGE";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID) AS RANGE";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID) AS RANGE";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID,", "");
		}
		return resultStr;
	}

	private  String getRangeGroupbyTargetStr(String groupby){
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "COMP_ID";
		} else if("AREA".equals(groupby)){
			if(!"1".equals(getOperator().getAreaFlag())){
				resultStr = "COMP_ID";
			}else {
				resultStr = "COMP_ID,AREA_ID,CONCAT(AREA_ID,'','')";
			}
		} else if("REG".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "COMP_ID,AREA_ID,REG_ID,DEPT_ID,GR_ID,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "COMP_ID,ARCHIVE_ID";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("AREA_ID,'_',", "").replaceAll("AREA_ID,", "");
		}
		return resultStr;
	}

	/**
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */	
	private String getRangeGroupbyStr(String groupby, String showType){
		// return groupby+"_ID";
		String resultStr = "";
		if("COMP".equals(groupby)){
			resultStr = "b.COMP_ID";
		} else if("AREA".equals(groupby)){
			if(!"1".equals(getOperator().getAreaFlag())){
				resultStr = "b.COMP_ID";
			}else {
				resultStr = "b.COMP_ID,b.AREA_ID,CONCAT(b.AREA_ID,'','')";
			}
		} else if("REG".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'')";
		} else if("DEPT".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID)";
		} else if("GROUP".equals(groupby)){
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID)";
		} else if("USER".equals(groupby)){
			resultStr = "b.COMP_ID,b.ARCHIVE_ID";
		}
		if(!"1".equals(getOperator().getAreaFlag())){
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID,", "");
		}
		return resultStr;
	}

	/**
	 * 房源底部统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */	
	private List<Object> getHouseBottomInfo(BaseMapParam param) {
		Integer cityId=getOperator().getCityId();
		String groupBy=getRange(param.getString("groupBy"));
		String serchRange=getRange(param.getString("serchRange"));
		String dataType=param.getString("dataType");
		Integer caseType=param.getInteger("caseType");

		// 获取真实范围
		param.setString("groupBy",groupBy);
		param.setString("serchRange",serchRange);
		String saleLease = null;
		if(caseType == 1){
			saleLease = "SALE";
		} else {
			saleLease = "LEASE";
		}

		Object resultObject=null;
		List<Object> resultList = new LinkedList<>();
		if (dataType.equals("STATUS")){ // 房源状态统计（有钥匙、有图片、有视频、已房勘、微店、真房源、有VR、预订）
			if("SALE".equals(saleLease)){
				resultObject = erpFunSaleMapper.getSaleHouseStatusCount(cityId,param.getMap());
			} else {
				resultObject = erpFunLeaseMapper.getLeaseHouseStatusCount(cityId,param.getMap());
			}
			resultList.add(resultObject);
		}else if (dataType.equals("SOURCE")){ // 房源来源统计（委托方式、房源级别、装修方式）
			if("SALE".equals(saleLease)){
				param.setString("groupBy","SALE_CONSIGN");
				List<ErpFunSaleDto> saleConsign = erpFunSaleMapper.getSaleHouseFromCount(cityId,param.getMap());
				param.setString("groupBy","SALE_LEVEL");
				List<ErpFunSaleDto> saleLevel = erpFunSaleMapper.getSaleHouseFromCount(cityId,param.getMap());
				param.setString("groupBy","SALE_FITMENT");
				List<ErpFunSaleDto> saleFiTment = erpFunSaleMapper.getSaleHouseFromCount(cityId,param.getMap());
				resultList.addAll(saleConsign);
				resultList.addAll(saleLevel);
				resultList.addAll(saleFiTment);
			} else {
				param.setString("groupBy","LEASE_CONSIGN");
				List<ErpFunLeaseDto> leaseConsign = erpFunLeaseMapper.getLeaseHouseFromCount(cityId,param.getMap());
				param.setString("groupBy","LEASE_LEVEL");
				List<ErpFunLeaseDto> leaseLevel = erpFunLeaseMapper.getLeaseHouseFromCount(cityId,param.getMap());
				param.setString("groupBy","LEASE_FITMENT");
				List<ErpFunLeaseDto> leaseFiTment = erpFunLeaseMapper.getLeaseHouseFromCount(cityId,param.getMap());
				resultList.addAll(leaseConsign);
				resultList.addAll(leaseLevel);
				resultList.addAll(leaseFiTment);
			}
		}else if (dataType.equals("REGION")){ // 房源分布区域统计（范围分布、商圈分布、标签占比）
			if("SALE".equals(saleLease)){
				param.setString("groupBy","SALE_ROUND");
				List<ErpFunSaleDto> saleRound = erpFunSaleMapper.getSaleHouseRegionCount(cityId,param.getMap());
				param.setString("groupBy","SECTION_ID");
				List<ErpFunSaleDto> saleSectionId = erpFunSaleMapper.getSaleHouseRegionCount(cityId,param.getMap());
				resultList.addAll(saleRound);
				resultList.addAll(saleSectionId);
			} else {
				param.setString("groupBy","LEASE_ROUND");
				List<ErpFunLeaseDto> leaseRound = erpFunLeaseMapper.getLeaseHouseRegionCount(cityId,param.getMap());
				param.setString("groupBy","SECTION_ID");
				List<ErpFunLeaseDto> leaseSectionId = erpFunLeaseMapper.getLeaseHouseRegionCount(cityId,param.getMap());
				resultList.addAll(leaseRound);
				resultList.addAll(leaseSectionId);
			}
		}else if (dataType.equals("USEAGE")){ // 房源用途统计（住宅、别墅、商铺、写字楼）
			if("SALE".equals(saleLease)){
				param.setString("groupBy","SALE_USEAGE,SALE_TYPE");
				List<ErpFunSaleDto> saleDtoList = erpFunSaleMapper.getSaleHouseSaleCount(cityId,param.getMap());
				resultList.addAll(saleDtoList);
			} else {
				param.setString("groupBy","LEASE_USEAGE,SALE_TYPE");
				List<ErpFunLeaseDto> leaseDtoList = erpFunLeaseMapper.getLeaseHouseSaleCount(cityId,param.getMap());
				resultList.addAll(leaseDtoList);
			}

		}
		return resultList;
	}


	/**
	 * 给数据库字段名别名成驼峰格式
	 *
	 * @param args
	 * @author 张宏利
	 * @since 2017年8月2日
	 */
	public static void main(String[] args) {
		String fileds = "comp_id,rent_cust_id,city_id,gr_id,reg_id,dept_id,user_id,archive_id,creation_time,rent_cust_no,rent_cust_name,rent_cust_sex,rent_cust_age,rent_cust_career,rent_lifebound,rent_ability,cust_level,house_room,house_room_1,house_region,region_name,build_id,build_name,section_id,section_name,house_round,house_type,house_useage,house_fitment,house_direct,plate_type,rent_cust_source,rent_cust_level,house_floor_low,house_floor_high,house_price_low,house_price_high,house_area_low,house_area_high,house_year_low,house_year_high,house_look,cust_request,rent_cust_status,track_time,action_time,repeat_flag,red_flag,orange_flag,public_count,public_time,due_time,special_time,schedule_time,deal_time,writeoff_time,secrecy_time,commend_time,private_time,from_public,cooperate_flag,update_time,friend_house,cooperate_time,area_id,private_user_id,sync_time,you_share_flag,you_share_time,you_share_id,you_buy_count,city_share_flag";
		String[] filedsArr = fileds.split(",");
		StringBuilder builder = new StringBuilder();
		for (String str : filedsArr) {
			builder.append(str).append(" ").append(BeanUtil.underlineToCamel(str)).append(",");
		}
		System.out.println(builder);
	}


	public  Integer getSelfRangeId(String groupby){
		if("COMP".equals(groupby)){
			return getOperator().getCompId();
		} else if("AREA".equals(groupby)){
			return getOperator().getAreaId();
		} else if("REG".equals(groupby)){
			return getOperator().getRegId();
		} else if("DEPT".equals(groupby)){
			return getOperator().getDeptId();
		} else if("GROUP".equals(groupby)){
			return getOperator().getGrId();
		} else if("USER".equals(groupby)){
			return getOperator().getUserId();
		}
		return null;
	}
	public  String getRange(String groupby){
		// return groupby+"_ID";
		if("COMP".equals(groupby)){
			return "COMP_ID";
		} else if("AREA".equals(groupby)){
			return "AREA_ID";
		} else if("REG".equals(groupby)){
			return "REG_ID";
		} else if("DEPT".equals(groupby)){
			return "DEPT_ID";
		} else if("GROUP".equals(groupby)){
			return "GR_ID";
		} else if("USER".equals(groupby)){
			return "USER_ID";
		}
		return "COMP_ID";
	}

    private String getRangeAlias(String range) {
        switch (range) {
            case "COMP":
                return " compId";
            case "AREA":
                return " areaId";
            case "REG":
                return " regId";
            case "DEPT":
                return " deptId";
            case "GROUP":
                return " grId";
            case "USER":
                return " userId";
            default:
                return null;

        }
    }

	private String getCaseWhenSql(String dataStr, String column,Integer caseType, boolean isDealPrice) {
		StringBuilder caseWhen = new StringBuilder();
		String[] strArr = dataStr.split(",");
		if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(caseType) && isDealPrice){
			column = "iif(RENT_PRICE_UNIT=2,ISNULL(RENT_DEAL_MONEY,0)*30,iif(RENT_PRICE_UNIT=3,ISNULL(RENT_DEAL_MONEY,0)*AREA,iif(RENT_PRICE_UNIT=4,ISNULL(RENT_DEAL_MONEY,0)*30*AREA,iif(RENT_PRICE_UNIT=5,ISNULL(RENT_DEAL_MONEY,0)/12,RENT_DEAL_MONEY))))";
		}
		for (int i = 0; i < strArr.length; i++) {
			if(i == 0) {
				caseWhen.append("CASE WHEN ").append(column).append(" <").append(strArr[i]);
			} else {
				caseWhen.append(" WHEN ").append(column).append(" >= ").append(strArr[i-1])
						.append(" AND ").append(column).append(" < ").append(strArr[i]);
			}
			caseWhen.append(" THEN ").append(i+1);
			if(i == strArr.length-1) {
				caseWhen.append(" ELSE ").append(i+2).append(" END ");
			}
		}
		return caseWhen.toString();
	}

	/**
	 * 列表排序，多个字段结果相加排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序，可以多个字段排序
	 * @param isAsc true=升序 false=降序
	 */
	private void collectionsSortByAdd(List<ErpFunDealDto> resultList, final String[] byArrs, final boolean isAsc){
		Collections.sort(resultList, new Comparator<ErpFunDealDto>() {
			@Override
			public int compare(ErpFunDealDto o1, ErpFunDealDto o2) {
				double i1 = 0.0, i2 = 0.0;
				for (String str : byArrs) {
					i1 += o1.getTotalProfit().doubleValue();
					i2 += o2.getTotalProfit().doubleValue();
				}
				if(isAsc){
					return (int) (i1 - i2);
				}
				return (int) (i2 - i1);
			}
		});
	}

	/**
	 * 列表排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序，可以多个字段排序
	 * @param isAsc true=升序 false=降序
	 */
	private void collectionsSort(List<ErpFunDealDto> resultList, final String[] byArrs, final boolean isAsc){
		Collections.sort(resultList, new Comparator<ErpFunDealDto>() {
			@Override
			public int compare(ErpFunDealDto o1, ErpFunDealDto o2) {
				Integer[] ids=new Integer[]{};
				try {
					ids = getArrLastIds(o1, o2, byArrs, new Integer[]{0, 0}, 0);
					if(isAsc){
						return ids[0] - ids[1];
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				return ids[1] - ids[0];

			}
		});
	}

	/**
	 * 递归获取o1 o2 的byArrs指定的ID，用于排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param o1 对象1
	 * @param o2 对象2
	 * @param byArrs 需要排序的项
	 * @param ids 返回的结果数组
	 * @param index 当前索引
	 * @return
	 */
	private static Integer[] getArrLastIds(ErpFunDealDto o1, ErpFunDealDto o2, String[] byArrs, Integer[] ids, int index) throws Exception {
		if(byArrs.length <= index){return ids;}
		Map<String, Object> o1Map=BeanUtil.objectToMap(o1);
		Map<String, Object> o2Map=BeanUtil.objectToMap(o2);
		ids[0] = (Integer) o1Map.get(byArrs[index]);
		ids[1] = (Integer) o2Map.get(byArrs[index]);
		if (ids[0]!=null && ids[1]!=null){
			if(ids[0].equals(ids[1])){
				return getArrLastIds(o1, o2, byArrs, ids, index+1);
			}
		}
		return ids;
	}

	private  List<ErpFunDealDto>  getSimpleDealData(BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		String serchRange = param.getString("serchRange");
		Integer serchRangeId = param.getInteger("serchRangeId");
		String dimension=param.getString("dimension");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String showType=param.getString("showType");
		boolean isHome = "HOME".equals(showType);
		param.setObject("isHome",isHome);
		if (isHome){
			if ("USER_ID".equals(serchRange)) {
				ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, serchRangeId);
				if (funUsers!=null){
					param.setInteger("archiveId",funUsers.getUserId());
				}
			}
		}
		String queryStr = getRangeQueryStr(dimension,showType);
		param.setString("queryStr",queryStr);
		List<ErpFunDealDto> returnList=erpFunOutdealMapper.getProfitCountList(cityId,param,false);
		List<ErpFunDealDto>  dealCountList = erpFunOutdealMapper.getProfitCountList(cityId,param,true);

		endTime = DateUtil.getLastDay(startTime);
		startTime = DateUtil.getFirstDay(startTime);
		param.setString("startTime",startTime);
		param.setString("endTime",endTime);
		if ("USER_ID".equals(serchRange) && !isHome) {
			ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, serchRangeId);
			if (funUsers!=null){
				param.setInteger("archiveId",funUsers.getUserId());
			}
		}
		String profitType = Constants_DIC.Count.PROFIT_COUNT_TYPE_MAP.get(dimension);
		param.setString("profitType",profitType);
		List<ErpFunDealDto> targetList = erpFunProfitTargetMapper.getTargetListMap(cityId,param);
		Map<String,ErpFunDealDto> targetMap = targetList.stream().collect(Collectors.toMap(map -> map.getRange(), map -> map));
		List<String> targetKeyList = targetList.stream().collect(Collectors.mapping(map -> map.getRange(), Collectors.toList()));

		Map<String, ErpFunDealDto> dealCountMap = dealCountList.stream().collect(Collectors.toMap(map -> map.getRange(), map -> map));
		List<String> dealCountKeyList = dealCountList.stream().collect(Collectors.mapping(map -> map.getRange(), Collectors.toList()));
		Map<String,Map<String, Object>> listRange = getRangeListDaTaOfComp(dimension, serchRange, serchRangeId, showType);

	/*	returnList.forEach(dataMap->{
			String range = dataMap.getRange();
			ErpFunDealDto targetData = targetMap.get(range);
			if (targetData!=null){
				dataMap.putAll(targetData);
				targetKeyList.remove(range);
			}
			ErpFunDealDto dealCountData = dealCountMap.get(range);
			if (dealCountData!=null){
				dataMap.putAll(dealCountData);
				dealCountKeyList.remove(range);
			}

		});
		if (!targetKeyList.isEmpty()){
			targetKeyList.forEach(key->{
				returnList.add(targetMap.get(key));
			});
		}
		if (!dealCountKeyList.isEmpty()){
			dealCountKeyList.forEach(key->{
				Map<String, Object> dealCountMapData = dealCountMap.get(key);
				Map<String, Object> targetMapData = targetMap.get(key);
				if (targetMapData!=null){
					dealCountMapData.putAll(targetMapData);
					targetKeyList.remove(key);
				}
				returnList.add(dealCountMapData);
			});
		}
		Map<String, Map<String, Object>> rangeMap = returnList.stream().collect(Collectors.toMap(map -> (String) map.get("RANGE"), map -> map));
		listRange.putAll(rangeMap);*/
		//TODO 未完待续
		return null;
	}

	private Map<String,Map<String,Object>> getRangeListDaTaOfComp(String dimension, String searchRange, Integer serchRangeId, String showType) {
		String tableName = null;
		String columnName = null;
		String whereSql = null;
		String keyField = "RANGE";
		if ("COMP".equals(searchRange)) {
			if ("AREA".equals(dimension)) {
				tableName = "FUN_AREA";
				columnName = "AREA_ID,AREA_ID AS RANGE";
				whereSql = " and IS_DEL=0 and COMP_ID IN (" + serchRangeId + ") ";
			} else if ("REG".equals(dimension)) {
				tableName = "FUN_REGION";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "REG_ID,CONCAT(REG_ID,'') AS RANGE";
				} else {
					columnName = "AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID) AS RANGE";
				}
				whereSql = " and IS_DEL=0 and COMP_ID IN (" + serchRangeId + ") ";
			} else if ("DEPT".equals(dimension)) {
				tableName = "FUN_DEPTS a join hft_admindb..fun_depts b on a.DEPT_NO=b.DEPT_NO and a.COMP_NO = b.COMP_NO";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "a.REG_ID,a.DEPT_ID,CONCAT(a.REG_ID,'_',a.DEPT_ID) AS RANGE";
				} else {
					columnName = "a.AREA_ID,a.REG_ID,a.DEPT_ID,CONCAT(a.AREA_ID,'_',a.REG_ID,'_',a.DEPT_ID) AS RANGE";
				}
				whereSql = " and (b.DEPT_FLAG=2 or (b.DEPT_FLAG=1 and b.try_end >'"+getTimeNow()+"')) and a.COMP_ID IN (" + serchRangeId + ") ";
			} else if ("GROUP".equals(dimension)) {
				String SqlStr = "select c.AREA_ID,b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(c.AREA_ID,'_',b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID) AS RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID left join FUN_REGION c on b.reg_ID=c.reg_ID where "
						+ "a.comp_id IN (" + serchRangeId + ") and a.is_del=0";
				if (!"1".equals(getOperator().getAreaFlag())) {
					SqlStr = "select b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID) AS RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID where "
							+ "a.comp_id IN (" + serchRangeId + ") and a.is_del=0";
				}
			} else if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "DEPT_ID,GR_ID,REG_ID,USER_ID, ARCHIVE_ID, ARCHIVE_ID AS RANGE";
				} else {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID, ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}
				whereSql = " and USER_WRITEOFF=0 and COMP_ID IN (" + serchRangeId + ") ";
			}
		} else if ("AREA".equals(searchRange)) {
			if ("REG".equals(dimension)) {
				tableName = "FUN_REGION";
				columnName = "AREA_ID,REG_ID,CONCAT(AREA_ID,'_',REG_ID) AS RANGE";
				whereSql = " and IS_DEL=0 and COMP_ID=" + getOperator().getCompId() + " and AREA_ID IN (" + serchRangeId + ") ";
			} else if ("DEPT".equals(dimension)) {
				tableName = "FUN_DEPTS a join hft_admindb..fun_depts b on a.DEPT_NO=b.DEPT_NO and a.COMP_NO = b.COMP_NO";
				columnName = "a.DEPT_ID,a.AREA_ID,a.REG_ID,CONCAT(a.AREA_ID,'_',a.REG_ID,'_',a.DEPT_ID) AS RANGE";
				whereSql = " and (b.DEPT_FLAG=2 or (b.DEPT_FLAG=1 and b.try_end>'"+getTimeNow()+"'))  and a.COMP_ID=" + getOperator().getCompId() + " and a.AREA_ID IN (" + serchRangeId + ") ";
			} else if ("GROUP".equals(dimension)) {
				String SqlStr = "select c.AREA_ID,b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(c.AREA_ID,'_',b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID)  as RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID left join fun_region c on b.reg_ID=c.reg_ID where "
						+ " b.AREA_ID IN (" + serchRangeId + ") and  b.COMP_ID="
						+ getOperator().getCompId() + " and a.is_del=0";
			} else if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				if(StringUtils.isNotBlank(showType) && "HOME".equals(showType)) {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID, ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}else {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}

				whereSql = " and USER_WRITEOFF=0 and COMP_ID=" + getOperator().getCompId() + " and AREA_ID IN (" + serchRangeId + ") ";
			}
		} else if ("REG".equals(searchRange)) {
			if ("DEPT".equals(dimension)) {
				tableName = "FUN_DEPTS a join hft_admindb..fun_depts b on a.DEPT_NO=b.DEPT_NO and a.COMP_NO = b.COMP_NO";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "a.DEPT_ID,a.REG_ID,CONCAT(a.REG_ID,'_',a.DEPT_ID) AS RANGE";
				} else {
					columnName = "a.DEPT_ID,a.AREA_ID,a.REG_ID,CONCAT(a.AREA_ID,'_',a.REG_ID,'_',a.DEPT_ID) AS RANGE";
				}
				whereSql = " and (b.DEPT_FLAG=2 or (b.DEPT_FLAG=1 and b.try_end>'"+getTimeNow()+"')) and a.REG_ID IN (" + serchRangeId + ") and a.COMP_ID=" + getOperator().getCompId();
			} else if ("GROUP".equals(dimension)) {
				String SqlStr = "select c.AREA_ID,b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(c.AREA_ID,'_',b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID)  as RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID  left join fun_region c on b.reg_ID=c.reg_ID " +
						"where b.REG_ID IN (" + serchRangeId + ") and b.COMP_ID="
						+ getOperator().getCompId() + " and a.is_del=0";
				if (!"1".equals(getOperator().getAreaFlag())) {
					SqlStr = "select b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID)  as RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID where "
							+ " b.REG_ID IN (" + serchRangeId + ") and b.COMP_ID="
							+ getOperator().getCompId() + " and a.is_del=0";
				}
			} else if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "USER_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				} else {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}
				whereSql = " and USER_WRITEOFF=0 and REG_ID IN (" + serchRangeId + ") and COMP_ID=" + getOperator().getCompId();
			}
		} else if ("DEPT".equals(searchRange)) {
			if ("GROUP".equals(dimension)) {
				String SqlStr = "select c.AREA_ID,b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(c.AREA_ID,'_',b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID)  as RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID  left join fun_region c on b.reg_ID=c.reg_ID where "
						+ "b.DEPT_ID IN (" + serchRangeId + ") and b.COMP_ID="
						+ getOperator().getCompId() + " and a.is_del=0";
				if (!"1".equals(getOperator().getAreaFlag())) {
					SqlStr = "select b.REG_ID,a.DEPT_ID,a.GR_ID,CONCAT(b.REG_ID,'_',a.DEPT_ID,'_',a.GR_ID)  as RANGE from FUN_DEPTSGROUP a left join FUN_DEPTS b on a.DEPT_ID=b.DEPT_ID  where "
							+ " b.DEPT_ID IN (" + serchRangeId + ") and b.COMP_ID="
							+ getOperator().getCompId() + " and a.is_del=0";
				}
			} else if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "USER_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				} else {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}
				whereSql = " and USER_WRITEOFF=0 and DEPT_ID IN (" + serchRangeId + ") and COMP_ID=" + getOperator().getCompId();
			}
		} else if ("GROUP".equals(searchRange)) {
			if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				if (!"1".equals(getOperator().getAreaFlag())) {
					columnName = "USER_ID,DEPT_ID,GR_ID,REG_ID, ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				} else {
					columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID, ARCHIVE_ID,ARCHIVE_ID AS RANGE";
				}
				whereSql = " and USER_WRITEOFF=0 and GR_ID IN (" + serchRangeId + ")  and COMP_ID=" + getOperator().getCompId();
			}
		} else {
			tableName = "FUN_USERS";
			if (!"1".equals(getOperator().getAreaFlag())) {
				columnName = "USER_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
			} else {
				columnName = "USER_ID,AREA_ID,DEPT_ID,GR_ID,REG_ID,ARCHIVE_ID,ARCHIVE_ID AS RANGE";
			}
			whereSql = " and USER_WRITEOFF=0 and USER_ID IN (" + serchRangeId + ") and COMP_ID=" + getOperator().getCompId();
		}
		List<Map<String, Object>> resultList = erpFunAreaMapper.executeBySQL(getOperator().getCityId(), columnName, tableName, whereSql);
		Map<String, Map<String, Object>> resultMap = new HashMap<>();
		if ("USER".equals(dimension)) {
			resultMap = resultList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("ARCHIVE_ID")), map -> map));
		} else {
			resultMap = resultList.stream().collect(Collectors.toMap(map -> String.valueOf(map.get("RANGE")), map -> map));
		}
		return resultMap;
	}

}

