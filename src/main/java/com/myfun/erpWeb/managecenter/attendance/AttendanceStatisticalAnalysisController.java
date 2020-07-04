package com.myfun.erpWeb.managecenter.attendance;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.attendance.param.AttendanceRecordDetailParam;
import com.myfun.erpWeb.managecenter.attendance.vo.AttendanceRecordDetailVO;
import com.myfun.erpWeb.managecenter.attendance.vo.AttendanceStatisticsVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.filter.CaptureFilter;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunArchiveExample;
import com.myfun.repository.erpdb.dao.ErpAuditRuntimeMapper;
import com.myfun.repository.erpdb.dao.ErpFunAreaMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceFestivalMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendancePushLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceRecordDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceStatisticsMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceUserClassDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceStatisticsDto;
import com.myfun.repository.erpdb.param.AttendanceRecordParam;
import com.myfun.repository.erpdb.param.ChangeAttendanceResultParam;
import com.myfun.repository.erpdb.param.ErpAttendanceStatisticalAnalysisParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpAuditRuntimeExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceFestival;
import com.myfun.repository.erpdb.po.ErpFunAttendanceFestivalExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroup;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendancePushLogExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetailExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatistics;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatisticsExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatisticsExample.Criteria;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetailExample;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.erpdb.ErpFunAttendancePushLogService;
import com.myfun.service.business.erpdb.ErpFunAttendanceRecordDetailService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

/**
 * 管理中心-考勤统计
 *
 * @author flj @2017-11-24
 */
@RestController
@RequestMapping("/managerCenter/attendanceStatisticalAnalysisModule")
public class AttendanceStatisticalAnalysisController extends BaseController {

	
	@Autowired
	private ErpFunAttendanceRecordDetailMapper erpFunAttendanceRecordDetailMapper;
	@Autowired
	private ErpFunAttendanceStatisticsMapper erpFunAttendanceStatisticsMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunAttendanceRecordDetailService erpFunAttendanceRecordDetailService;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunArchiveService adminFunArchiveService;
	@Autowired
	ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	ErpFunAttendanceGroupMapper erpFunAttendanceGroupMapper;
	@Autowired
	ErpFunAttendanceFestivalMapper erpFunAttendanceFestivalMapper;
	@Autowired
	ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
	ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunAttendancePushLogService erpFunAttendancePushLogService;
	@Autowired
	ErpFunAttendancePushLogMapper erpFunAttendancePushLogMapper;
	@Autowired
	ErpAuditRuntimeMapper erpAuditRuntimeMapper;

	/**
	 * 查询考勤统计
	 *
	 * @return
	 * @throws Exception
	 * @author flj
	 * @Date 2017-11-24
	 */
	@ApiOperation(value = "查询考勤统计",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpFunAttendanceStatisticsDto.class,message = "success")})
	@RequestMapping("/getAttendanceStatisticlAnalysis")
	public ResponseJson getAttendanceStatisticlAnalysis(
			@Valid @RequestBody ErpAttendanceStatisticalAnalysisParam param) {

		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());

		Byte countType = param.getCountType();// 0代表每日考勤 1代表每月考勤
		String attDate = param.getAttDate();// 开始日期
		if (Byte.valueOf("1").equals(countType)) {// 每月
			attDate = attDate + "-01";// 每月第一天
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateTimeHelper.parseToDate(attDate));
			calendar.add(Calendar.MONTH, 1);// 得到当前月份
			calendar.add(Calendar.DAY_OF_MONTH, -1);// 得到前提天
			param.setStartTime(attDate);// 开始时间
			param.setEndTime(DateTimeHelper.formatDateTimetoString(calendar.getTime()));// 结束时间
		} else if (Byte.valueOf("0").equals(countType)) {// 每日
			param.setStartTime(attDate);
			param.setEndTime(attDate);
		}else if (Byte.valueOf("4").equals(countType)) {//考勤明细
            if (StringUtil.isNotEmpty(attDate)) {
              param.setStartTime(DateTimeHelper.getFirstDayOfMonth(attDate));
              param.setEndTime(DateTimeHelper.getLastDayOfMonth(attDate));
            }
        }
        Map<String,Object> maps = getAttendanceStatisticlAnalysisReport(param);
		//考勤明细时，按人分一下组
		if (4 == countType ) {
			List<ErpFunAttendanceStatisticsDto> returnList = (List<ErpFunAttendanceStatisticsDto>) (maps.get("data"));
			if (CollectionUtils.isEmpty(returnList)) {
			    return ErpResponseJson.ok();
            }
            //按人分组，
//			Map<String,List<ErpFunAttendanceStatisticsDto>> returnMap =  returnList.stream().filter(val -> val.getUserId() != null).collect(Collectors.groupingBy(val->val.getUserId().toString(),Collectors.toList()));
			ErpResponseJson res = new ErpResponseJson();
            AttendanceStatisticsVO vo = new AttendanceStatisticsVO();
            vo.setResult(returnList);
            res.setData(vo);
            res.setTotal((Long)(maps.get("total")));
            res.setPageSize(param.getPageRows());
            res.setPageNum(param.getPageOffset());
			return res;

		}
		return ErpResponseJson.ok(maps.get("data"));
	}

	/**
	 * 查询考勤统计
	 *
	 * @return
	 * @throws Exception
	 * @author flj
	 * @Date 2017-11-24
	 */
	@RequestMapping("/getAttendanceStatisticlAnalysisExport")
	public ResponseJson getAttendanceStatisticlAnalysisExport(
			@Valid @RequestBody ErpAttendanceStatisticalAnalysisParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());
		Byte countType = param.getCountType();
		String attDate = param.getAttDate();
		if (Byte.valueOf("1").equals(countType)) {// 每月
			attDate = attDate + "-01";
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateTimeHelper.parseToDate(attDate));
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			param.setStartTime(attDate);
			param.setEndTime(DateTimeHelper.formatDateTimetoString(calendar.getTime()));// 拿到当前是几月几号
		} else if (Byte.valueOf("0").equals(countType)) {// 每日
			param.setStartTime(attDate);
			param.setEndTime(attDate);
		} else if (Byte.valueOf("4").equals(countType)) {//查询某个月的考勤明细
			param.setStartTime(DateTimeHelper.getFirstDayOfMonth(attDate));
			param.setEndTime(DateTimeHelper.getLastDayOfMonth(attDate));
		}
		Map<String,Object> maps = getAttendanceStatisticlAnalysisReport(param);
        //考勤明细时，按人分一下组
        if (4 == countType ) {
            List<ErpFunAttendanceStatisticsDto> returnList = (List<ErpFunAttendanceStatisticsDto>) (maps.get("data"));
            if (CollectionUtils.isEmpty(returnList)) {
                return ErpResponseJson.ok();
            }
            //按人分组，
//			Map<String,List<ErpFunAttendanceStatisticsDto>> returnMap =  returnList.stream().filter(val -> val.getUserId() != null).collect(Collectors.groupingBy(val->val.getUserId().toString(),Collectors.toList()));
            ErpResponseJson res = new ErpResponseJson();
            AttendanceStatisticsVO vo = new AttendanceStatisticsVO();
            vo.setResult(returnList);
            res.setData(vo);
            res.setTotal((Long)(maps.get("total")));
            res.setPageSize(param.getPageRows());
            res.setPageNum(param.getPageOffset());
            return res;
        }
		return ErpResponseJson.ok(maps.get("data"));
	}

	/**
	 * 查询考勤统计-报表
	 *
	 * @return
	 * @throws Exception
	 * @author flj
	 * @Date 2017-11-24
	 */
	private Map<String,Object>  getAttendanceStatisticlAnalysisReport(ErpAttendanceStatisticalAnalysisParam param) {
	    //需要返回的数据
        Map<String,Object> maps = new HashMap<>();
		//1.首先查询考勤详细记录表统计信息
		List<Map<String, Object>> dataStatisticData = new ArrayList<Map<String, Object>>();
		Map<String, Object> returnData = new HashMap<String, Object>();
		dataStatisticData.add(returnData);
		ErpFunAttendanceStatisticsExample example = new ErpFunAttendanceStatisticsExample();
		example.setShardCityId(param.getCityId());
        Criteria criteria = example.createCriteria();
        criteria.andCompIdEqualTo(param.getCompId());
        param.setLevel((byte)1);

        if ("COMP".equals(param.getSearchRange())) {
			param.setSearchRangeId(param.getCompId());
		}
		if ("AREA".equals(param.getSearchRange())) {
			criteria.andAreaIdEqualTo(param.getSearchRangeId());
            param.setLevel((byte)2);
		} else if ("REG".equals(param.getSearchRange())) {
			criteria.andRegIdEqualTo(param.getSearchRangeId());
            param.setLevel((byte)3);
		} else if ("DEPT".equals(param.getSearchRange())) {
			criteria.andDeptIdEqualTo(param.getSearchRangeId());
            param.setLevel((byte)4);
		} else if ("GROUP".equals(param.getSearchRange())) {
			criteria.andGrIdEqualTo(param.getSearchRangeId());
            param.setLevel((byte)5);
		} else if ("USER".equals(param.getSearchRange())) {
			ErpFunUsers userPo = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getSearchRangeId());
			param.setSearchRange("ARCHIVE");
            param.setLevel((byte)6);
			if (userPo != null) {
				param.setSearchRangeId(userPo.getArchiveId());
                criteria.andArchiveIdEqualTo(param.getSearchRangeId());
			}
		}
		if (getOperator().newOrganizationType()) {
			if (param.getOrganizationId() != null && param.getOrganizationId() != 0) {
				criteria.andOrganizationPathLike("%:"+param.getOrganizationId()+":%");
			}
		}
		if (param.getUserId() != null) {
			criteria.andUserIdEqualTo(param.getUserId());
		}
		criteria.andAttDateBetween(DateTimeHelper.parseToDate(param.getStartTime()), DateTimeHelper.parseToDate(param.getEndTime()));

		//如果是每日考勤明细，需要进行一下分页
		if (param.getCountType() != null && param.getCountType() == 4){
            //如果是导出，就不需要进行分页
			if (param.getIsExport() != null && param.getIsExport() == 1){

			}else{
				//按人头进行分页
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(),true);
			}
			example.setOrderByClause("USER_ID ASC");
			List<ErpFunAttendanceStatisticsDto> userList = erpFunAttendanceStatisticsMapper.selectPageAttByUserByDtoExample(example);
			// 范围下没有人就直接返回MMP
			if (userList.isEmpty()) {
				maps.put("total", 0L);
				maps.put("data", new ArrayList<Map<String, Object>>());
				return maps;
			}
			PageInfo<ErpFunAttendanceStatisticsDto> pageInfo = new PageInfo<>(userList);
			maps.put("total",pageInfo.getTotal());		
			List<Integer> users = userList.stream().map(val -> val.getUserId()).collect(Collectors.toList());
            criteria.andUserIdIn(users);
			example.setOrderByClause("RANGE,ATT_DATE ASC");
		}
		List<ErpFunAttendanceStatisticsDto> returnList = erpFunAttendanceStatisticsMapper.selectByDtoExample(example);
		String attResults = param.getAttResults();
		Date dateNow = new Date();
		if (StringUtils.isNotBlank(param.getAttResults())) {
			boolean isOutSideType = attResults.contains("-1");//是否包含外勤的查询
			String attResultArr[] = attResults.split(",");
			boolean isMissCardFlag = false;
			StringBuilder newResults = new StringBuilder();
			for (String attResult:attResultArr) {
				if ("0".equals(attResult.trim())) {
					isMissCardFlag = true;
				} else {
					newResults.append(",").append(attResult).append(",");
				}
			}
			attResults = newResults.toString();
			if (StringUtils.isNotBlank(attResults)) {
				attResults.contains(",10,");
				attResults = attResults+",12,";
			}
			List<ErpFunAttendanceStatisticsDto> returnDataList = new ArrayList<>();
			for (ErpFunAttendanceStatisticsDto erpFunAttendanceStatistics : returnList) {
				boolean isAddFlag = false;
				Byte attSumCount = erpFunAttendanceStatistics.getAttSumCount();
				Byte firstWorkonType = erpFunAttendanceStatistics.getFirstWorkonType();
				Byte firstWorkoffType = erpFunAttendanceStatistics.getFirstWorkoffType();
				Byte secondWorkonType = erpFunAttendanceStatistics.getSecondWorkonType();
				Byte secondWorkoffType = erpFunAttendanceStatistics.getSecondWorkoffType();
				Byte threeWorkonType = erpFunAttendanceStatistics.getThreeWorkonType();
				Byte threeWorkoffType = erpFunAttendanceStatistics.getThreeWorkoffType();
				Byte firstWorkOn = erpFunAttendanceStatistics.getFirstWorkOn();
				Byte firstWorkOff = erpFunAttendanceStatistics.getFirstWorkOff();
				Byte secondWorkOn = erpFunAttendanceStatistics.getSecondWorkOn();
				Byte secondWorkOff = erpFunAttendanceStatistics.getSecondWorkOff();
				Byte threeWorkOn = erpFunAttendanceStatistics.getThreeWorkOn();
				Byte threeWorkOff = erpFunAttendanceStatistics.getThreeWorkOff();
				if (isMissCardFlag) {
					if (addMissCardCountOffRoundClass(erpFunAttendanceStatistics, dateNow)) {
						returnDataList.add(erpFunAttendanceStatistics);
						continue;
					}
				}
				if (isOutSideType) {
					if (Byte.valueOf("2").equals(firstWorkonType) || Byte.valueOf("2").equals(secondWorkonType) || Byte.valueOf("2").equals(threeWorkonType) || Byte.valueOf("2").equals(firstWorkoffType) || Byte.valueOf("2").equals(secondWorkoffType) || Byte.valueOf("2").equals(threeWorkoffType)) {
						isAddFlag = true;
						returnDataList.add(erpFunAttendanceStatistics);
					}
				}
				if (!isAddFlag) {
					if (Byte.valueOf("1").equals(attSumCount)) {
						if (attResults.contains(","+firstWorkOn.toString()+",") || attResults.contains(","+firstWorkOff.toString()+",")) {
							returnDataList.add(erpFunAttendanceStatistics);
						}
					} else if (Byte.valueOf("2").equals(attSumCount)) {
						if (attResults.contains(","+firstWorkOn.toString()+",") || attResults.contains(","+secondWorkOn.toString()+",") || attResults.contains(","+firstWorkOff.toString()+",") || attResults.contains(","+secondWorkOff.toString()+",")) {
							returnDataList.add(erpFunAttendanceStatistics);
						}
					} else if (Byte.valueOf("3").equals(attSumCount)) {
						if (attResults.contains(","+firstWorkOn.toString()+",") || attResults.contains(","+secondWorkOn.toString()+",") || attResults.contains(","+threeWorkOn.toString()+",") || attResults.contains(","+firstWorkOff.toString()+",") || attResults.contains(","+secondWorkOff.toString()+",") || attResults.contains(","+threeWorkOff.toString()+",")) {
							returnDataList.add(erpFunAttendanceStatistics);
						}
					}
				}
			}
			returnList = returnDataList;
		}
		if (Byte.valueOf("0").equals(param.getCountType())) {
			for (ErpFunAttendanceStatisticsDto erpFunAttendanceStatistics : returnList){
				if (erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("0")) || erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("3"))) {
					if (erpFunAttendanceStatistics.getAttClassId()!=null && erpFunAttendanceStatistics.getAttClassId()>0) {
						Byte attSumCount = erpFunAttendanceStatistics.getAttSumCount();
						if (Byte.valueOf("1").equals(attSumCount)) {
							judgeFirstRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("2").equals(attSumCount)) {
							judgeSecondRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("3").equals(attSumCount)) {
							judgeThreeRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						}
					}
				}
			}
		} if (Byte.valueOf("1").equals(param.getCountType())) {
			if ("GROUP".equals(param.getSearchRange())) {
				param.setSearchRange("GR_ID");
			} else {
				if (StringUtil.isEmpty(param.getSearchRange())) {
					param.setSearchRange(null);
				} else {
					param.setSearchRange(param.getSearchRange() + "_ID");
				}
			}
			Calendar calendar = Calendar.getInstance();
			Date currentDate = new Date();
			calendar.add(Calendar.HOUR_OF_DAY, -6);
			calendar.add(Calendar.MINUTE, -1);
			List<Map<String, Object>> reportDataList = new ArrayList<>();
			if (getOperator().newOrganizationType()) {
				reportDataList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticlAnalysisReportOffMonthNeworg(param.getCityId(), param, DateTimeHelper.formatDateTimetoString(currentDate), DateTimeHelper.formatDateTimetoString(currentDate, "yyyy-MM-dd"),DateTimeHelper.formatDateTimetoString(calendar.getTime()));
			} else {
				reportDataList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticlAnalysisReportOffMonth(param.getCityId(), param, DateTimeHelper.formatDateTimetoString(currentDate), DateTimeHelper.formatDateTimetoString(currentDate, "yyyy-MM-dd"),DateTimeHelper.formatDateTimetoString(calendar.getTime()));
			}

			Map<String, List<ErpFunAttendanceStatisticsDto>> returnMap = returnList.stream().collect(Collectors.groupingBy(ErpFunAttendanceStatisticsDto::getRange, Collectors.toList()));
			
			ErpAuditRuntimeExample runtimeExample = new ErpAuditRuntimeExample();
			runtimeExample.setShardCityId(param.getCityId());
			com.myfun.repository.erpdb.po.ErpAuditRuntimeExample.Criteria criteriaRuntime = runtimeExample.createCriteria();
			criteriaRuntime.andCompIdEqualTo(param.getCompId()).andAuditResourceEqualTo(Byte.valueOf("2")).andAuditStatusEqualTo(Byte.valueOf("1")).andTargetStartTimeGreaterThanOrEqualTo(DateTimeHelper.parseToDate(param.getStartTime())).andTargetEndTimeLessThanOrEqualTo(DateTimeHelper.parseToDate(param.getEndTime() + " 23:59:59"));
			if ("AREA_ID".equals(param.getSearchRange())) {
				criteriaRuntime.andAreaIdEqualTo(param.getSearchRangeId());
			} else if ("REG_ID".equals(param.getSearchRange())) {
				criteriaRuntime.andRegIdEqualTo(param.getSearchRangeId());
			} else if ("DEPT_ID".equals(param.getSearchRange())) {
				criteriaRuntime.andDeptIdEqualTo(param.getSearchRangeId());
			} else if ("GR_ID".equals(param.getSearchRange())) {
				criteriaRuntime.andGrIdEqualTo(param.getSearchRangeId());
			} else if ("USER_ID".equals(param.getSearchRange())) {
				criteriaRuntime.andUserIdEqualTo(param.getSearchRangeId());
			}
			List<ErpAuditRuntime> runtimeList = erpAuditRuntimeMapper.selectByExample(runtimeExample);
			Map<Integer,ErpAuditRuntime> runtimeMap = runtimeList.stream().collect(Collectors.toMap(ErpAuditRuntime::getId, val->val));
			reportDataList.forEach(dataMap -> {
				Object range = dataMap.get("range");
				if (range != null) {
					List<ErpFunAttendanceStatisticsDto> list = returnMap.get(range.toString());
					BigDecimal leaveDay = null;
					if (list!=null) {
						leaveDay = countOneMonthLeaveDays(list,runtimeMap);
					} else {
						leaveDay = BigDecimal.ZERO;
					}
					dataMap.put("leaveDay", leaveDay);
					dataMap.put("detailList", returnMap.get(range.toString()));
				}
				
			});
			maps.put("data",reportDataList);
			return maps;
		} else if (Byte.valueOf("3").equals(param.getCountType())) {
			for (ErpFunAttendanceStatisticsDto erpFunAttendanceStatistics : returnList) {
				if (erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("0")) || erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("3"))) {
					if (erpFunAttendanceStatistics.getAttClassId()!=null && erpFunAttendanceStatistics.getAttClassId()>0) {
						Byte attSumCount = erpFunAttendanceStatistics.getAttSumCount();
						if (Byte.valueOf("1").equals(attSumCount)) {
							judgeFirstRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("2").equals(attSumCount)) {
							judgeSecondRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("3").equals(attSumCount)) {
							judgeThreeRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						}
					}
				}
			}
		} else if (Byte.valueOf("4").equals(param.getCountType())) {
			for (ErpFunAttendanceStatisticsDto erpFunAttendanceStatistics : returnList) {
				if (erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("0")) || erpFunAttendanceStatistics.getOffWork().equals(Byte.valueOf("3"))) {
					if (erpFunAttendanceStatistics.getAttClassId()!=null && erpFunAttendanceStatistics.getAttClassId()>0) {
						Byte attSumCount = erpFunAttendanceStatistics.getAttSumCount();
						if (Byte.valueOf("1").equals(attSumCount)) {
							judgeFirstRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("2").equals(attSumCount)) {
							judgeSecondRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						} else if (Byte.valueOf("3").equals(attSumCount)) {
							judgeThreeRroundMissCard(erpFunAttendanceStatistics, dateNow, true);
						}
					}
				}
			}
		}
		maps.put("data",returnList);
		return maps;
	}
	
	

	private void judgeFirstRroundMissCard(ErpFunAttendanceStatisticsDto statistics , Date nowDate ,boolean isLastRround ) {
		Byte firstWorkOn = statistics.getFirstWorkOn();
		Byte firstWorkOff = statistics.getFirstWorkOff();
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOn)
				&& statistics.getFirstWorkOntime() != null
				&& nowDate.compareTo(statistics.getFirstWorkOntime()) < 0)
				 ) {
			statistics.setFirstWorkOn(Const.TimeAttendanceResult.WAITE_WORK);
		}
		Date compareDate = null;
		if (statistics.getFirstWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(statistics.getFirstWorkOfftime().getTime());
			if (isLastRround) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOff)
					&& statistics.getFirstWorkOfftime() != null
					&& nowDate.compareTo(compareDate) < 0){
				statistics.setFirstWorkOff(Const.TimeAttendanceResult.WAITE_WORK);
			}
		}
	}
	
	private void judgeSecondRroundMissCard(ErpFunAttendanceStatisticsDto statistics , Date nowDate ,boolean isLastRround ) {
		judgeFirstRroundMissCard(statistics, nowDate, false);
		Byte secondWorkOn = statistics.getSecondWorkOn();
		Byte secondWorkOff = statistics.getSecondWorkOff();
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOn)
				&& statistics.getSecondWorkOntime() != null
				&& nowDate.compareTo(statistics.getSecondWorkOntime()) < 0)
				 ) {
			statistics.setSecondWorkOn(Const.TimeAttendanceResult.WAITE_WORK);
		}
		Date compareDate = null;
		if (statistics.getSecondWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(statistics.getSecondWorkOfftime().getTime());
			if (isLastRround) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOff)
					&& statistics.getSecondWorkOfftime() != null
					&& nowDate.compareTo(compareDate) < 0){
				statistics.setSecondWorkOff(Const.TimeAttendanceResult.WAITE_WORK);
			}
		}
	}
	
	private void judgeThreeRroundMissCard(ErpFunAttendanceStatisticsDto statistics , Date nowDate ,boolean isLastRround ) {
		judgeSecondRroundMissCard(statistics, nowDate, false);
		Byte threeWorkOn = statistics.getThreeWorkOn();
		Byte threeWorkOff = statistics.getThreeWorkOff();
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(threeWorkOn)
				&& statistics.getThreeWorkOntime() != null
				&& nowDate.compareTo(statistics.getThreeWorkOntime()) < 0)
				 ) {
			statistics.setThreeWorkOn(Const.TimeAttendanceResult.WAITE_WORK);
		}
		Date compareDate = null;
		if (statistics.getThreeWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(statistics.getThreeWorkOfftime().getTime());
			if (isLastRround) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(threeWorkOff)
					&& statistics.getThreeWorkOfftime() != null
					&& nowDate.compareTo(compareDate) < 0){
				statistics.setThreeWorkOff(Const.TimeAttendanceResult.WAITE_WORK);
			}
		}
	}
	

	/**
	 * 考勤修改日志
	 *
	 * @return
	 * @throws Exception
	 * @author flj
	 * @Date 2017-11-24
	 */
	@ApiOperation(value = "考勤修改日志",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class,message = "success")})
	@RequestMapping("/changeAttendanceResult")
	public ResponseJson changeAttendanceResult(@Valid @RequestBody ChangeAttendanceResultParam param) {
		Operator operator = getOperator();
		param.setCurrentUserName(operator.getUserName());
		Map<String,String> attInfoMap = erpFunAttendanceRecordDetailService.changeAttendanceResult(operator.getCityId(), operator.getCompId(), operator.getDeptId(), operator.getUserId(), operator.getUserName(), param);
		CaptureFilter.syncFunAttendanceRecordDetail(attInfoMap);
		return ErpResponseJson.ok();
	}

	/**
	 * 查询考勤流水日志
	 *
	 * @return
	 * @throws Exception
	 * @author flj
	 * @Date 2017-11-24
	 */
	@RequestMapping("/getAttendanceRecordDetailList")
	@ApiOperation("统计分析-业绩首页-本月业绩情况test1..")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = AttendanceRecordDetailVO.class)})
	public ResponseJson getAttendanceRecordDetailList(@Valid @RequestBody AttendanceRecordDetailParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = param.getUserId();
		String attDate = param.getAttDate();
		String attResult = param.getAttResult();
		Integer isOutAtt = param.getIsOutAtt();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		Integer archiveId = erpFunUsers.getArchiveId();
		List<Map<String, Object>> reordDetailList = null;
		if (StringUtils.isNotBlank(attResult)) {
			String transAttResult = attResult;
			attDate = attDate + "-01";
			Calendar calendar = Calendar.getInstance();
			String currentDate = DateTimeHelper.formatDateTimetoString(calendar.getTime(),"yyyy-MM-dd");
			calendar.setTime(DateTimeHelper.parseToDate(attDate));
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			String startTime = attDate;
			String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
			if ("-1".equals(attResult) || "-2".equals(attResult) || "-3".equals(attResult)) {
				if ("-1".equals(attResult)) {
					transAttResult = "3";//旷工
				} else {
					//具体班缺卡
					transAttResult = "-2";//旷工
				}
				List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticlMinerList(cityId, compId, archiveId, startTime, endTime, transAttResult);
				reordDetailList = buildAttendanceRecordStatics(erpFunAttendanceStatisticsList, transAttResult,attResult);
			} else if (StringUtils.isNotBlank(attResult)) {
				reordDetailList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordDetailListMap(cityId, compId,
						archiveId, attDate, null, null, attResult, startTime, endTime,isOutAtt);
				reordDetailList.forEach(map -> {
					Object extraPath = map.get("extraPath");
					if (extraPath != null) {
						String photoAddrStr = extraPath.toString();
						map.put("extraPath", CommonUtil.getCommonPhotoUrl(photoAddrStr));
					}
					Object editRemark=  map.get("attRemark");
					if (editRemark!=null){
						map.put("attRemark",editRemark.toString());
					}
				});
			}
		} else {
			reordDetailList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordDetailListMap(cityId, compId,
					archiveId, attDate, null, null, null, null, null,isOutAtt);
			reordDetailList.forEach(map -> {
				Object extraPath = map.get("extraPath");
				if (extraPath != null) {
					String photoAddrStr = extraPath.toString();
					map.put("extraPath", CommonUtil.getCommonPhotoUrl(photoAddrStr));
				}
				Object editRemark=  map.get("attRemark");
				if (editRemark!=null){
					map.put("attRemark",editRemark.toString());
				}
			});
			ErpFunAttendanceStatistics attendanceStatistics = erpFunAttendanceStatisticsMapper.getAttendanceStatisticOffUser(cityId, compId, archiveId, attDate);
			if (!Byte.valueOf("1").equals(attendanceStatistics.getOffWork()) && !Byte.valueOf("2").equals(attendanceStatistics.getOffWork())) {
				Date currentDate = new Date();
				Map<String, Map<String, Object>> recordDetailMap = null;
				if (!reordDetailList.isEmpty()) {
					recordDetailMap = BeanUtil.listMapObjecttoMap(reordDetailList, new String[]{"attNum", "attAttribute"});
				} //查询获取到考勤记录
				if (attendanceStatistics != null) {
					Byte attSumCount = attendanceStatistics.getAttSumCount();
					if (Byte.valueOf("1").equals(attSumCount)) {
						createFirstRoundClass(attendanceStatistics, reordDetailList, recordDetailMap, currentDate);
					} else if (Byte.valueOf("2").equals(attSumCount)) {
						createSecondRoundClass(attendanceStatistics, reordDetailList, recordDetailMap, currentDate);
					} else if (Byte.valueOf("3").equals(attSumCount)) {
						createThreeRoundClass(attendanceStatistics, reordDetailList, recordDetailMap, currentDate);
					}
				}
			}
			Collections.sort(reordDetailList, new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> o1, Map<String, Object> o2) {
					String attNum1 = o1.get("attNum").toString();
					String attNum2 = o2.get("attNum").toString();
					int result = attNum1.compareTo(attNum2);
					if (result == 0) {
						String attAttribute1 = o1.get("attAttribute").toString();
						String attAttribute2 = o2.get("attAttribute").toString();
						return attAttribute1.compareTo(attAttribute2);
					}
					return result;
				}
			});
		}

		if (isOutAtt != null && isOutAtt == 1) {
			// 因为外勤是由另外一个字段控制，所有把前端传来的标记返回回去，前端通过这个标记判断
			for (Map<String, Object> map : reordDetailList) {
				map.put("isOutAtt", isOutAtt);
			}
		}
		if (reordDetailList!=null && !reordDetailList.isEmpty()) {
			for (Map<String, Object> recordDetailMap : reordDetailList) {
				recordDetailMap.put("userId", param.getUserId());
			}
		}
		return ErpResponseJson.ok(reordDetailList);
	}

	/**
	 * 创建只有一轮打卡的考勤缺卡记录
	 */
	private void createFirstRoundClass(ErpFunAttendanceStatistics attendanceStatistics, List<Map<String, Object>> reordDetailList, Map<String, Map<String, Object>> recordDetailMap, Date currentDate) {
		Map<String, Object> detailMap = null;
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("1#1");
		}
		if (detailMap == null) {
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("1"), Byte.valueOf("1"), currentDate);
			//新增一条缺卡
			if (data != null) {
				reordDetailList.add(data);
			}
		}
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("1#2");
		}
		if (detailMap == null) {
			//新增一条缺卡
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("1"), Byte.valueOf("2"), currentDate);
			//新增一条缺卡
			if (data != null) {
				reordDetailList.add(data);
			}
		}
	}

	/**
	 * 创建只有两轮打卡的考勤缺卡记录
	 */
	private void createSecondRoundClass(ErpFunAttendanceStatistics attendanceStatistics, List<Map<String, Object>> reordDetailList, Map<String, Map<String, Object>> recordDetailMap, Date currentDate) {
		createFirstRoundClass(attendanceStatistics, reordDetailList, recordDetailMap, currentDate);
		Map<String, Object> detailMap = null;
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("2#1");
		}
		if (detailMap == null) {
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("2"), Byte.valueOf("1"), currentDate);
			if (data != null) {
				reordDetailList.add(data);
			}
		}
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("2#2");
		}
		if (detailMap == null) {
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("2"), Byte.valueOf("2"), currentDate);
			if (data != null) {
				reordDetailList.add(data);
			}
		}
	}

	/**
	 * 创建只有三轮打卡的考勤缺卡记录
	 */
	private void createThreeRoundClass(ErpFunAttendanceStatistics attendanceStatistics, List<Map<String, Object>> reordDetailList, Map<String, Map<String, Object>> recordDetailMap, Date currentDate) {
		createSecondRoundClass(attendanceStatistics, reordDetailList, recordDetailMap, currentDate);
		Map<String, Object> detailMap = null;
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("3#1");
		}
		if (detailMap == null) {
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("3"), Byte.valueOf("1"), currentDate);
			if (data != null) {
				reordDetailList.add(data);
			}
		}
		if (recordDetailMap != null) {
			detailMap = recordDetailMap.get("3#2");
		}
		if (detailMap == null) {
			Map<String, Object> data = createRecordDetail(attendanceStatistics, Byte.valueOf("3"), Byte.valueOf("2"), currentDate);
			if (data != null) {
				reordDetailList.add(data);
			}
		}
	}

	//start-------------

	/**
	 * 統計上下班缺卡次數
	 */
	private Integer countMissCardCountOffRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentTime, List<Map<String,String>> missCardList) {
		Integer resultCount = 0;
		Byte attSumCount = attendanceStatistics.getAttSumCount();//打卡轮数
		if (Byte.valueOf("1").equals(attSumCount)) {
			resultCount = countMissCardOffFirstRoundClass(attendanceStatistics, currentTime, missCardList, true);
		} else if (Byte.valueOf("2").equals(attSumCount)) {
			resultCount = countMissCardOffSecondRoundClass(attendanceStatistics, currentTime, missCardList, true);
		} else if (Byte.valueOf("3").equals(attSumCount)) {
			resultCount = countMissCardOffThreeRoundClass(attendanceStatistics, currentTime, missCardList, true);
		}
		return resultCount;
	}


	/**
	 * 判断第一轮打卡中是否有缺卡的轮数
	 */
	private Integer countMissCardOffFirstRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentTime, List<Map<String,String>> missCardList, boolean isLastRoundClass) {
		Integer resultCount = 0;
		Date date = attendanceStatistics.getFirstWorkOntime();
		if (date != null) {
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOn()) && currentTime.compareTo(date) >= 0) {
				resultCount += 1;
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("1"), attendanceStatistics.getFirstWorkOn(), attendanceStatistics.getFirstWorkOntime());
			}
		}
		date = attendanceStatistics.getFirstWorkOfftime();
		if (date != null) {
			Date compareDate = new Date();
			compareDate.setTime(date.getTime());
			if (isLastRoundClass) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOff()) && currentTime.compareTo(compareDate) >= 0) {
				resultCount += 1;
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("2"), attendanceStatistics.getFirstWorkOff(), attendanceStatistics.getFirstWorkOfftime());
			}
		}
		return resultCount;
	}

	
	/**
	 * 判断第二轮打卡中是否有缺卡的轮数
	 */
	private Integer countMissCardOffSecondRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentTime, List<Map<String,String>> missCardList, boolean isLastRoundClass) {
		Integer resultCount = 0;
		resultCount += countMissCardOffFirstRoundClass(attendanceStatistics, currentTime, missCardList, false);
		Date date = attendanceStatistics.getSecondWorkOntime();
		if (date != null) {
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOn()) && currentTime.compareTo(date) >= 0) {
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("1"), attendanceStatistics.getSecondWorkOn(), attendanceStatistics.getSecondWorkOntime());
				resultCount += 1;
			}
		}
		date = attendanceStatistics.getSecondWorkOfftime();
		if (date != null) {
			Date compareDate = new Date();
			compareDate.setTime(date.getTime());
			if (isLastRoundClass) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOff()) && currentTime.compareTo(compareDate) >= 0) {
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("2"), attendanceStatistics.getSecondWorkOff(), attendanceStatistics.getSecondWorkOfftime());
				resultCount += 1;
			}
		}
		return resultCount;
	}

	/**
	 * 判断第三轮打卡中是否有缺卡的轮数
	 */
	private Integer countMissCardOffThreeRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentTime , List<Map<String,String>> missCardList, boolean isLastRoundClass) {
		Integer resultCount = 0;
		resultCount += countMissCardOffSecondRoundClass(attendanceStatistics, currentTime ,missCardList, false);
		Date date = attendanceStatistics.getThreeWorkOntime();
		if (date != null) {
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOn()) && currentTime.compareTo(date) >= 0) {
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("1"), attendanceStatistics.getThreeWorkOn(), attendanceStatistics.getThreeWorkOntime());
				resultCount += 1;
			}
		}
		date = attendanceStatistics.getThreeWorkOfftime();
		if (date != null) {
			Date compareDate = new Date();
			compareDate.setTime(date.getTime());
			if (isLastRoundClass) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOff()) && currentTime.compareTo(compareDate) >= 0) {
				createMissCardRecordOffSelfMonth(missCardList, Byte.valueOf("2"), attendanceStatistics.getThreeWorkOff(), attendanceStatistics.getThreeWorkOfftime());
				resultCount += 1;
			}
		}
		return resultCount;
	}

	private void createMissCardRecordOffSelfMonth(List<Map<String, String>> missCardList, Byte attAttribute, Byte attResult, Date attDate) {
		String attAttStr = attAttribute.toString();
		Map<String,String> record = new HashMap<>();
		record.put("attType", "4");//该字段不允许为null出现
		record.put("dateStr", DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_yyyyMMdd));
		record.put("weekStr", DateTimeHelper.transferWeekDayOffCn(attDate));
		record.put("timeStr", DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_HHmm));
		//上班还是下班、早退或者迟到等
		//考勤上班或者下班。上班：1 、下班：2 (默认 0)
		record.put("attAttribute", attAttribute.toString());
		//打卡结果：0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假
		record.put("attResult", "0");
		String attAttributeStr = "";
		if ("1".equals(attAttStr)) {
			attAttributeStr = "上班";
		} else if ("2".equals(attAttStr)) {
			attAttributeStr = "下班";
		}
		String leftStr = DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_yyyyMMdd)
				+ "(" + DateTimeHelper.transferWeekDayOffCn(attDate) + ") "
				+ DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_HHmm);
		String rightStr = attAttributeStr + Const.TimeAttendanceResult.ATT_RESULT_CN.get(attResult);
		record.put("leftStr", leftStr);
		record.put("rightStr", rightStr);
		missCardList.add(record);
	}

	private Map<String, Object> constractParamMap(Integer attAttribute, String attClassClocktime, Integer attClassId,
												  String attClassName, Integer attGrId, Byte attNum,  Byte attSumCount) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("attAttribute", attAttribute);
		paramMap.put("attClassClocktime", attClassClocktime);
		paramMap.put("attClassId", attClassId);
		paramMap.put("attClassName", attClassName);
		paramMap.put("attGrId", attGrId);
		paramMap.put("attNum", attNum);
//		paramMap.put("attOughtDate", attOughtDate);
		paramMap.put("attSumCount", attSumCount);
//		paramMap.put("configAttTime", configAttTime);
		return  paramMap;
	}

	/**
	 * 判断第一轮打卡中是否有缺卡的轮数
	 */
	private void createMissCardOffFirstRoundClass(String attResult, ErpFunAttendanceStatistics attStatic, List<Map<String, Object>> returnList, Map<String, Object> recordDetailData, Date attDate, Date currentDate , boolean isLastRroundClass) {
		Byte firstWorkOn = attStatic.getFirstWorkOn();
		Byte firstWorkOff = attStatic.getFirstWorkOff();
		if ("-2".equals(attResult)) {//上班缺卡
			if ("0".equals(firstWorkOn.toString())) {
				Map<String, Object> paramMap = constractParamMap(1, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
				, attStatic.getGrId(),  (byte)1, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getFirstWorkOntime(), recordDetailData,
						currentDate, false, paramMap);
			}
		} else if ("-3".equals(attResult)) {
			if ("0".equals(firstWorkOff.toString())) {
				Map<String, Object> paramMap = constractParamMap(2, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
						, attStatic.getGrId(),  (byte)1, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getFirstWorkOfftime(), recordDetailData, currentDate , isLastRroundClass, paramMap);
			}
		}
	}


	/**
	 * 判断第二轮打卡中是否有缺卡的轮数
	 */
	private void createMissCardOffSecondRoundClass(String attResult, ErpFunAttendanceStatistics attStatic, List<Map<String, Object>> returnList, Map<String, Object> recordDetailData, Date attDate, Date currentDate, boolean isLastRroundClass) {
		createMissCardOffFirstRoundClass(attResult, attStatic, returnList, recordDetailData, attDate, currentDate, false);
		Byte secondWorkOn = attStatic.getSecondWorkOn();
		Byte secondWorkOff = attStatic.getSecondWorkOff();
		if ("-2".equals(attResult)) {//上班缺卡
			if ("0".equals(secondWorkOn.toString())) {
				Map<String, Object> paramMap = constractParamMap(1, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
						, attStatic.getGrId(),  (byte)2, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getSecondWorkOntime(), recordDetailData, currentDate, false, paramMap);
			}
		} else if ("-3".equals(attResult)) {
			if ("0".equals(secondWorkOff.toString())) {
				Map<String, Object> paramMap = constractParamMap(2, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
						, attStatic.getGrId(),  (byte)2, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getSecondWorkOfftime(), recordDetailData, currentDate, isLastRroundClass, paramMap);
			}
		}
	}

	/**
	 * 判断第三轮打卡中是否有缺卡的轮数
	 */
	private void createMissCardOffThreeRoundClass(String attResult, ErpFunAttendanceStatistics attStatic, List<Map<String, Object>> returnList, Map<String, Object> recordDetailData, Date attDate, Date currentDate, boolean isLastRroundClass) {
		createMissCardOffSecondRoundClass(attResult, attStatic, returnList, recordDetailData, attDate, currentDate, false);
		Byte threeWorkOn = attStatic.getThreeWorkOn();
		Byte threeWorkOff = attStatic.getThreeWorkOff();
		if ("-2".equals(attResult)) {//上班缺卡
			if ("0".equals(threeWorkOn.toString())) {
				Map<String, Object> paramMap = constractParamMap(1, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
						, attStatic.getGrId(),  (byte)3, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getThreeWorkOntime(), recordDetailData, currentDate, false, paramMap);
			}
		} else if ("-3".equals(attResult)) {
			if ("0".equals(threeWorkOff.toString())) {
				Map<String, Object> paramMap = constractParamMap(2, attStatic.getAttClassClocktime(), attStatic.getAttClassId(), attStatic.getAttClassName()
						, attStatic.getGrId(),  (byte)3, attStatic.getAttSumCount());
				createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(returnList, attDate, attStatic.getThreeWorkOfftime(), recordDetailData, currentDate, isLastRroundClass, paramMap);
			}
		}
	}

	/**
	 * 创建缺卡动态记录
	 *
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> createRecordDetail(ErpFunAttendanceStatistics statistics, Byte sumCount, Byte attAttribute, Date currentTime) {
		Byte totalSumCount = statistics.getAttSumCount();
		boolean isLastRroundClass = sumCount.equals(totalSumCount);
		String attClassClockTime = statistics.getAttClassClocktime();
		Date attOughtDate = statistics.getAttDate();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("attSumCount", statistics.getAttSumCount());
		returnMap.put("attGrId", statistics.getAttGrId());
		returnMap.put("attClassId", statistics.getAttClassId());
		returnMap.put("attNum", sumCount);
		returnMap.put("attOughtDate", DateTimeHelper.formatDateTimetoString(attOughtDate, "yyyy-MM-dd"));
		returnMap.put("attAttribute", attAttribute);//考勤配置的时间
		returnMap.put("manageTimeAttResult", "0");//缺卡
		returnMap.put("userId", statistics.getUserId());
		returnMap.put("attClassClocktime", attClassClockTime);
		returnMap.put("locationAttResult", "1");//实际位置考勤结果 - (1)正常、2外勤
		returnMap.put("manageLocationAttResult", "1");//实际位置考勤结果 - (1)正常、2外勤
		returnMap.put("attClassName", statistics.getAttClassName());
		
		//当前第一轮
		if (Byte.valueOf("1").equals(sumCount)) {
			Date dateOn = statistics.getFirstWorkOntime();
			Date dateOff = statistics.getFirstWorkOfftime();
			returnMap = createOneNumClass(attAttribute, dateOn, dateOff, currentTime, statistics, returnMap, isLastRroundClass);
			//当前第二轮
		} else if (Byte.valueOf("2").equals(sumCount)) {
			Date dateOn = statistics.getSecondWorkOntime();
			Date dateOff = statistics.getSecondWorkOfftime();
			returnMap = createOneNumClass(attAttribute, dateOn, dateOff, currentTime, statistics, returnMap, isLastRroundClass);
			//当前第三轮
		} else if (Byte.valueOf("3").equals(sumCount)) {
			Date dateOn = statistics.getThreeWorkOntime();
			Date dateOff = statistics.getThreeWorkOfftime();
			returnMap = createOneNumClass(attAttribute, dateOn, dateOff, currentTime, statistics, returnMap, isLastRroundClass);
		}
		return returnMap;
	}

	/**
	 * 判断某一个班别是否需要补却卡
	 *
	 * @author 陈文超
	 * @date 2017年12月10日 下午10:49:33
	 */
	private Map<String, Object> createOneNumClass(Byte attAttribute, Date dateOn, Date dateOff, Date currentTime, ErpFunAttendanceStatistics statistics, Map<String, Object> returnMap, boolean isLastRroundClass) {
		if (dateOn == null) {
			if (!Byte.valueOf("1").equals(statistics.getOffWork()) && !Byte.valueOf("2").equals(statistics.getOffWork())  && statistics.getAttClassId()!=null && statistics.getAttClassId()==0 ){
				return returnMap;
			}
			return null;
		}
		if (Byte.valueOf("1").equals(attAttribute)) {//上班
			if (currentTime.compareTo(dateOn) >= 0) {
				returnMap.put("configAttTime", dateOn);
			} else {
				return null;
			}
		} else if (Byte.valueOf("2").equals(attAttribute)) {//下班
			if (dateOff == null) {
				if (!Byte.valueOf("1").equals(statistics.getOffWork()) && !Byte.valueOf("2").equals(statistics.getOffWork()) && statistics.getAttClassId()!=null && statistics.getAttClassId()==0 ){
					return returnMap;
				}
				return null;
			}
			Date compareDate = new Date();
			compareDate.setTime(dateOff.getTime());
			if (isLastRroundClass) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (currentTime.compareTo(compareDate) >= 0) {
				returnMap.put("configAttTime", dateOff);
			} else {
				return null;
			}
		}
		return returnMap;
	}
	private boolean judgeAllowNeedNextDay(ErpFunAttendanceStatistics statistic, Date attDate) {
		if (statistic == null) {
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(attDate);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		attDate = calendar.getTime();
		if (!Byte.valueOf("1").equals(statistic.getOffWork()) && !Byte.valueOf("2").equals(statistic.getOffWork())) {
			Byte attSumCount = statistic.getAttSumCount();
			Date workOffTime = null;
			if (Byte.valueOf("1").equals(attSumCount)) {
				if (statistic.getFirstWorkoffType() == null && Byte.valueOf("0").equals(statistic.getFirstWorkOff())) {
					workOffTime = statistic.getFirstWorkOfftime();
				}
			} else if (Byte.valueOf("2").equals(attSumCount)) {
				if (statistic.getSecondWorkoffType() == null && Byte.valueOf("0").equals(statistic.getSecondWorkOff())) {
					workOffTime = statistic.getSecondWorkOfftime();
				}
			} else if (Byte.valueOf("3").equals(attSumCount)) {
				if (statistic.getThreeWorkoffType() == null && Byte.valueOf("0").equals(statistic.getThreeWorkOff())) {
					workOffTime = statistic.getThreeWorkOfftime();
				}
			}
			if (workOffTime == null) {
				return false;
			}
			//最后一次的打卡时间已经在第二天了，说明次日了
			if (workOffTime.compareTo(attDate) >= 0) {
				return true;
			} else {
				//加6个小时，判断是否还在次日可以打卡
				calendar.setTime(workOffTime);
				calendar.add(Calendar.HOUR_OF_DAY, 6);
				calendar.add(Calendar.MINUTE, 1);
				if (calendar.getTime().compareTo(attDate) >= 0) {
					return true;
				}
			}

		}
		return false;
	}
	/**
	 * 考勤统计数据向日志记录转换
	 *
	 * @author flj
	 * @date 2017年12月6日 下午3:24:41
	 */
	private List<Map<String, Object>> buildAttendanceRecordStatics(List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList, String transferAttResult, String attResult) {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Date currentDate = new Date();
		for (ErpFunAttendanceStatistics erpFunAttendanceStatistics : erpFunAttendanceStatisticsList) {
			Map<String, Object> recordDetailData = null;
			Date attDate = erpFunAttendanceStatistics.getAttDate();
			Byte attSumCount = erpFunAttendanceStatistics.getAttSumCount();
			if ("3".equals(transferAttResult)) {//缺卡
				if (!DateTimeHelper.formatDateTimetoString(currentDate,"yyyy-MM-dd").equals(DateTimeHelper.formatDateTimetoString(attDate,"yyyy-MM-dd"))) {
					Byte firstWorkOn = erpFunAttendanceStatistics.getFirstWorkOn();
					Byte firstWorkOff = erpFunAttendanceStatistics.getFirstWorkOff();
					Byte secondWorkOn = erpFunAttendanceStatistics.getSecondWorkOn();
					Byte secondWorkOff = erpFunAttendanceStatistics.getSecondWorkOff();
					Byte threeWorkOn = erpFunAttendanceStatistics.getThreeWorkOn();
					Byte threeWorkOff = erpFunAttendanceStatistics.getThreeWorkOff();
					if (Byte.valueOf("1").equals(attSumCount)) {
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOff))) {
							continue;
						}
					} else if (Byte.valueOf("2").equals(attSumCount)) {
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOff))) {
							continue;
						}
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOff))) {
							continue;
						}
					} else if (Byte.valueOf("3").equals(attSumCount)) {
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(firstWorkOff))) {
							continue;
						}
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(secondWorkOff))) {
							continue;
						}
						if (!(Const.TimeAttendanceResult.LACK_OF_CARD.equals(threeWorkOn) && Const.TimeAttendanceResult.LACK_OF_CARD.equals(threeWorkOff))) {
							continue;
						}
					}
					recordDetailData = new HashMap<String, Object>();
					recordDetailData.put("attOughtDate", erpFunAttendanceStatistics.getAttDate());
					recordDetailData.put("manageTimeAttResult", "3");
					recordDetailData.put("attClassClocktime", erpFunAttendanceStatistics.getAttClassClocktime());
					recordDetailData.put("attClassName", erpFunAttendanceStatistics.getAttClassName());
					recordDetailData.put("attGrId", erpFunAttendanceStatistics.getAttGrId());
					returnList.add(recordDetailData);
				}
			} else {
				recordDetailData = new HashMap<String, Object>();
				if (Byte.valueOf("1").equals(attSumCount)) {
					createMissCardOffFirstRoundClass(attResult, erpFunAttendanceStatistics, returnList, recordDetailData, attDate, currentDate, true);
				} else if (Byte.valueOf("2").equals(attSumCount)) {
					createMissCardOffSecondRoundClass(attResult, erpFunAttendanceStatistics, returnList, recordDetailData, attDate, currentDate, true);
				} else if (Byte.valueOf("3").equals(attSumCount)) {
					createMissCardOffThreeRoundClass(attResult, erpFunAttendanceStatistics, returnList, recordDetailData, attDate, currentDate, true);
				}
			}
		}
		return returnList;
	}

	private void createMissCardExcludeConfigAttTimeGreaterThanCurrentDate(List<Map<String, Object>> returnList, Date attDate, Date configDate,
																		  Map<String, Object> recordDetailData, Date currentDate, boolean isLastRroundClass, Map<String, Object> paramMap) {
		if (configDate != null) {
			Date compareDate = new Date();
			compareDate.setTime(configDate.getTime());
			if (isLastRroundClass) {
				compareDate = DateTimeHelper.addHours(compareDate, 6);
				compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			}
			if (currentDate.compareTo(compareDate) >= 0) {
				recordDetailData = new HashMap<String, Object>();
				recordDetailData.put("attOughtDate", attDate);
				recordDetailData.put("manageTimeAttResult", "0");//缺卡
				recordDetailData.put("configAttTime", configDate);
				recordDetailData.putAll(paramMap);
				returnList.add(recordDetailData);
			}
		}
	}

	/**
	 * 查询总出勤天数信息
	 *
	 * @author 陈文超
	 * @date 2017年12月10日 下午6:10:16
	 */
	private List<String> createAttendanceDaysList(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, String startDate, String endDate) {
		//首先查询出所有的考勤统计查0,1,2的缺卡的3就不算在出勤天数里面了、
		List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceNotMissCardStatisticListOffOneMonth(cityId, compId, areaId, regId, deptId, grId, userId, startDate, endDate, null);
		List<String> dataList = new ArrayList<>();//初始化出勤天数统计值为0
		for (ErpFunAttendanceStatistics erpFunAttendanceStatistics : erpFunAttendanceStatisticsList) {
			Byte offWork = erpFunAttendanceStatistics.getOffWork();
			if (!Byte.valueOf("0").equals(offWork)) {
				Byte firstWorkOn = erpFunAttendanceStatistics.getFirstWorkOn();//获取第一次打卡结果，因为这个时候计算休息和排班是否进入出勤天数的时候，是需要判断有没有打过卡，而第一次打卡的结果逻辑是正常
				if (Const.TimeAttendanceResult.NORMAL.equals(firstWorkOn)) {
					dataList.add(DateTimeHelper.formatDateTimetoString(erpFunAttendanceStatistics.getAttDate(), "yyyy-MM-dd"));
				}
			} else {
				dataList.add(DateTimeHelper.formatDateTimetoString(erpFunAttendanceStatistics.getAttDate(), "yyyy-MM-dd"));
			}
		}
		return dataList;
	}

	/**
	 * 管理者看的日统计页面
	 * 包含有统计饼图的页面
	 * 统计大区、片区、或者门店范围内的所有应该打考勤的数据
	 * 业务与getAttendanceRecordDayDetial接口连用
	 *
	 * @throws Exception
	 * @author liucheng
	 * @date 2017年12月6日 下午4:01:28
	 */
	@RequestMapping("/getAttendanceRecordDay")
	public ResponseJson getAttendanceRecordDay(@Valid @RequestBody AttendanceRecordParam attendanceRecordParam) throws Exception {
		Operator operator = getOperator();
		String attDateStr = attendanceRecordParam.getAttDate();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer areaId = attendanceRecordParam.getAreaId();
		Integer regId = attendanceRecordParam.getRegId();
		Integer deptId = attendanceRecordParam.getDeptId();
		Integer grId = attendanceRecordParam.getGrId();
		Integer userId = attendanceRecordParam.getUserId();
		List<Map<String, Integer>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, null, attDateStr);
		Map<String, List<Integer>> userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attResultWeight").toString(), Collectors.mapping(map -> Integer.valueOf(map.get("userId")), Collectors.toList())));
		//后面查考勤统计表的时候需要排除权重最高的
		List<Integer> userList = userManageMap.get(String.valueOf(5));
		List<Integer> absenteeismList = userManageMap.get(String.valueOf(6));
		if (CollectionUtils.isNotEmpty(userList)) {
			if (CollectionUtils.isNotEmpty(absenteeismList)) {
				userList.addAll(absenteeismList);
			} 
		} else {
			userList = absenteeismList;
		}
		Date currentDate = new Date();
		List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, attDateStr, userList);
		List<Integer> totalMisscardUserIds = new ArrayList<>();//只剩下统计
		for (ErpFunAttendanceStatistics statistics : erpFunAttendanceStatisticsList) {
			if (addMissCardCountOffRoundClass(statistics, currentDate)) {
				totalMisscardUserIds.add(statistics.getUserId());
			}
		}

		int sumUsers = 0;
		List<HashMap<String, String>> attRecords = new ArrayList<HashMap<String, String>>();
		for (Integer key : Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.keySet()) {
			//迟到和早退单独统计累加
			if (key == 4 || key == 5 || key == 6 || key == 11 || key == 12) {//过滤掉多余的考勤类型项
				continue;
			}
			List<Integer> attCountList = userManageMap.get(key.toString());
			Integer size = 0;
			if (key < 4) {
				//当权重小于4对应的缺卡的时候，过滤掉缺卡的人
				if (attCountList != null) {
					attCountList.removeAll(totalMisscardUserIds);
					if (userList!=null) {
						attCountList.removeAll(userList);
					}
					size = attCountList.size();
				}
			}
			HashMap<String, String> map = new HashMap<>();
			map.put("attType", key.toString());
			map.put("attNum", Const.TimeAttendanceResult.ATT_WEIGHT_SHOW_ORDER.get(key.toString()));
			map.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(key));
			map.put("userAttNum", size.toString());
			sumUsers = sumUsers + size;
			attRecords.add(map);
		}

		HashMap<String, String> mapLateEarly = new HashMap<>();
		mapLateEarly.put("attNum", Const.TimeAttendanceResult.ATT_WEIGHT_SHOW_ORDER.get("11"));
		mapLateEarly.put("attType", "11");
		mapLateEarly.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(11));
		//计算早退和迟到记录的和
		if (userList!=null) {
			mapLateEarly.put("userAttNum", String.valueOf(userList.size()));
			sumUsers = sumUsers + userList.size();
		}
		attRecords.add(mapLateEarly);
		HashMap<String, String> map = new HashMap<>();
		map.put("attNum", Const.TimeAttendanceResult.ATT_WEIGHT_SHOW_ORDER.get("4"));
		map.put("attType", "4");
		map.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(4));
		map.put("userAttNum", String.valueOf(totalMisscardUserIds.size()));
		attRecords.add(map);
		Collections.sort(attRecords, new Comparator<HashMap<String, String>>() {
			@Override
			public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
				String attNum1 = o1.get("attNum").toString();
				String attNum2 = o2.get("attNum").toString();
				int result = attNum1.compareTo(attNum2);
				return result;
			}
		});
		Map<String, Object> result = new HashMap<>();
		result.put("attRecords", attRecords);
		sumUsers = sumUsers + totalMisscardUserIds.size();
		result.put("sumUsers", String.valueOf(sumUsers));//已打考勤的总人数

		//查询出今天需要打考勤的人数
		ErpFunUsersExample example = new ErpFunUsersExample();
		example.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (areaId != null) {
			criteria.andAreaIdEqualTo(areaId);
		}
		if (regId != null) {
			criteria.andRegIdEqualTo(regId);
		}
		if (deptId != null) {
			criteria.andDeptIdEqualTo(deptId);
		}
		if (grId != null) {
			criteria.andGrIdEqualTo(grId);
		}
		if (userId != null) {
			criteria.andUserIdEqualTo(userId);
		}
		criteria.andUserWriteoffEqualTo(false);
		int needSumUsers = erpFunUsersMapper.countByExample(example);
		//这里还需要排除掉今天不需要打卡的用户

		result.put("needSumUsers", String.valueOf(needSumUsers));//需要打考勤的总人数
		return ErpResponseJson.ok(result);
	}

	/**
	 * 管理者看的日统计考勤详情
	 * 用于从饼图考勤统计页面查询具体的考勤类型详情，例如：正常、迟到早退等考勤详情的查询
	 * 统计大区、片区、或者门店范围内的所有应该打考勤的数据，包含有打卡用户的详细信息，头像等
	 * 业务与getAttendanceRecordDay接口连用
	 *		att:[
	 *  {
	 *     user:{
	 *       userId:"123456",
	 *       photo:"http://xxxx",
	 *       name:"张三",
	 *       deptInfo:"龙泉大区-红树片区-犀浦门店",
	 *     }
	 *     attInfo:[
	 *       {
	 *         clockIn:"上班1：迟到3分钟",
	 *         clockInNormal:"上班是否正常：1正常，非1不正常",
	 *         clockOut:"下班1：正常",
	 *         clockOutNormal:"下班是否正常：1正常，非1不正常",  
	 *       }
	 *     ]
	 *   }
	 * ]
	 * @author 陈文超
	 * @date 2017年12月13日 上午11:02:14
	 */
	@RequestMapping("/getAttendanceRecordDayDetial")
	public ResponseJson getAttendanceRecordDayDetial(@Valid @RequestBody AttendanceRecordParam attendanceRecordParam) throws Exception {
		List<Map<String,Object>> returnDataList = new ArrayList<>();
		String attDateStr = attendanceRecordParam.getAttDate();
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer areaId = attendanceRecordParam.getAreaId();
		Integer regId = attendanceRecordParam.getRegId();
		Integer deptId = attendanceRecordParam.getDeptId();
		Integer grId = attendanceRecordParam.getGrId();
		Integer userId = attendanceRecordParam.getUserId();
		Integer attType = attendanceRecordParam.getAttType();//等价于考勤结果权重值
		List<Integer> attTypeList = new ArrayList<>();
		if (attType.equals(11)) {
			attTypeList.add(5);
			attTypeList.add(6);
		} else {
			attTypeList.add(attType);
		}
		Date currentDate = new Date();
		List<Integer> notInUserList = null;
		List<Map<String, Integer>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailListOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, attTypeList, attDateStr);
		Map<String, List<Integer>> userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attResultWeight").toString(),Collectors.mapping(map->Integer.valueOf(map.get("userId")),Collectors.toList())));
		List<Integer> userList = null;
		if (attType.equals(11)) {
			userList = userManageMap.get("5");
			if (userList!=null) {
				if (userManageMap.get("6")!=null) {
					userList.addAll(userManageMap.get("6"));
				}
			} else {
				userList = userManageMap.get("6");
			}
		} else {
			userList = userManageMap.get(attType.toString());//后面查考勤统计表的时候需要排除权重最高的
		}
		if (attType<=4) { //特殊处理
			List<Integer> attWight5List = new ArrayList<>();
			attWight5List.add(5);
			recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailListOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, attWight5List, attDateStr);
			userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attResultWeight").toString(),Collectors.mapping(map->Integer.valueOf(map.get("userId")),Collectors.toList())));
			notInUserList = userManageMap.get("5");//后面查考勤统计表的时候需要排除权重最高的
			List<Integer> attWight6List = new ArrayList<>();
			attWight6List.add(6);
			recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailListOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, attWight6List, attDateStr);
			userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attResultWeight").toString(),Collectors.mapping(map->Integer.valueOf(map.get("userId")),Collectors.toList())));
			if (notInUserList==null) {
				notInUserList = userManageMap.get("6");//后面查考勤统计表的时候需要排除权重最高的
			} else {
				if (userManageMap.get("6") != null) {
					notInUserList.addAll(userManageMap.get("6"));
				}
			}
			List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneDay(cityId, compId, areaId, regId, deptId, grId, userId, attDateStr, notInUserList);
			List<Integer> totalMisscardUserIds = new ArrayList<>();//只剩下统计
			for (ErpFunAttendanceStatistics statistics: erpFunAttendanceStatisticsList) {
				if (addMissCardCountOffRoundClass(statistics, currentDate)) {
					totalMisscardUserIds.add(statistics.getUserId());
				}
			}
			if (attType<=3) {
				if (userList!=null) {
					if (notInUserList!=null) {
						userList.removeAll(notInUserList);
					}	
					userList.removeAll(totalMisscardUserIds);
				} 
			} else {
				if (notInUserList!=null) {
					totalMisscardUserIds.removeAll(notInUserList);
				}
				userList = totalMisscardUserIds;
			}
		} 
		if (userList != null && !userList.isEmpty()) {
			//人员查出来了，就查每一个人的record记录表
			List<Map<String,Object>> reordDetailList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordDetailListMapByRange(cityId, compId, userList, attDateStr);
			List<Integer> archiveIds = reordDetailList.stream().map(map -> Integer.valueOf(map.get("archiveId").toString())).collect(Collectors.toList());
			List<Integer> userIds =  reordDetailList.stream().map(map -> Integer.valueOf(map.get("userId").toString())).collect(Collectors.toList());
			//查询用户的头像图片
					
			AdminFunArchiveExample archiveIdExample = new AdminFunArchiveExample();
			archiveIdExample.createCriteria().andArchiveIdIn(archiveIds);
			List<AdminFunArchive> adminFunArchives = adminFunArchiveMapper.selectByExample(archiveIdExample);
			//用户头像集合
			Map<Integer, String> photoUrlsMap = new HashMap<>();
			for (AdminFunArchive tmpArchive : adminFunArchives) {
				String photoUrl = adminFunArchiveService.getUserPhotoUrl(tmpArchive);
				photoUrlsMap.put(tmpArchive.getArchiveId(), photoUrl);
			}
	
			//查询用户信息集合
			ErpFunUsersExample userIdExample = new ErpFunUsersExample();
			userIdExample.setShardCityId(cityId);
			userIdExample.createCriteria().andUserIdIn(userIds).andCompIdEqualTo(compId);
			List<ErpFunUsers> erpUsers = erpFunUsersMapper.selectByExample(userIdExample);
			List<Integer> deptIds = erpUsers.stream().map(a -> a.getDeptId()).collect(Collectors.toList());
			Map<String, ErpFunUsers> userInfoMap = BeanUtil.listObjToMapObj(erpUsers, "userId");
	
		/*	//查询公司下所有大区、片区、门店的信息
	        ErpFunAreaExample exampleArea = new ErpFunAreaExample();
	        exampleArea.setShardCityId(cityId);
	        exampleArea.createCriteria().andCompIdEqualTo(compId).andAreaIdIn(areaIds).andIsDelEqualTo((byte) 0);
	        List<ErpFunArea> erpFunAreas = erpFunAreaMapper.selectByExample(exampleArea);
	      //片区信息集合
	        Map<String, ErpFunArea> areaMap = BeanUtilsHelper.listToMapObject(erpFunAreas, "areaId");
	        
	        //查询大区下所有片区、门店的信息
	        ErpFunRegionExample regionExample = new ErpFunRegionExample();
	        regionExample.setShardCityId(cityId);
	        regionExample.createCriteria().andCompIdEqualTo(compId).andRegIdIn(regIds).andIsDelEqualTo((byte) 0);
	        List<ErpFunRegion> erpFunRegions = erpFunRegionMapper.selectByExample(regionExample);
	        //片区信息集合
	        Map<String, ErpFunRegion> regionMap = BeanUtilsHelper.listToMapObject(erpFunRegions, "regId");
	        */
	        //查询片区下所有门店的信息
	        ErpFunDeptsExample deptExample = new ErpFunDeptsExample();
	        deptExample.setShardCityId(cityId);
	        deptExample.createCriteria().andCompIdEqualTo(compId).andDeptIdIn(deptIds);
	        List<ErpFunDepts> erpFunDepts = erpFunDeptsMapper.selectByExample(deptExample);
	        //门店信息集合
	        Map<String, ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObject(erpFunDepts, "deptId");
			Map<Integer, List<Map<String, Object>>> reordDetailMap = reordDetailList.stream().collect(Collectors.groupingBy(reg -> Integer.valueOf(reg.get("userId").toString())));
			//人员查出来了，就查每一个人的stattiscList统计表
			List<ErpFunAttendanceStatistics> stattiscList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticsListMapByRange(cityId, compId, userList, attDateStr);
			Map<Integer,ErpFunAttendanceStatistics> statiscMap = stattiscList.stream().collect(Collectors.toMap(ErpFunAttendanceStatistics::getUserId , stat -> stat));
			if (userList != null) {
				userList.forEach(currentUserId -> {
					String userIdStr = currentUserId.toString();
					List<Map<String, Object>> currRecordDereordDetailList = reordDetailMap.get(currentUserId);
					if (currRecordDereordDetailList == null) {
						currRecordDereordDetailList = new ArrayList<>();
					}
					ErpFunUsers erpFunUsers = userInfoMap.get(userIdStr);
					if (erpFunUsers== null) {
						return;
					}
					String deptIdStr = erpFunUsers.getDeptId().toString();
					Map<String, Object> rsMap = new HashMap<>();
					Map<String, String> userRsMap = new HashMap<>();
					userRsMap.put("userId", userIdStr);
					userRsMap.put("photo", photoUrlsMap.get(erpFunUsers.getArchiveId()));
					userRsMap.put("name", erpFunUsers.getUserName());
					
					//格式：大区-片区-门店
					StringBuilder deptInfo = new StringBuilder();
					if (StringUtils.isNotBlank(deptIdStr)) {
						deptInfo.append(deptMap.get(deptIdStr).getDeptCname());
					}
					userRsMap.put("deptInfo", deptInfo.toString());
					rsMap.put("user", userRsMap);
					ErpFunAttendanceStatistics statisc = statiscMap.get(currentUserId);
					createOneDayRecordList(currRecordDereordDetailList, statisc, rsMap, currentDate);
					returnDataList.add(rsMap);
				});
			}
		}
		return ErpResponseJson.ok(returnDataList);
	}
	/**
	 * 创建考勤记录统计数据
	 * workOn/workOff：0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假
	 * workOnType/workOffType：(默认0)正常、1外勤
	 *
	 * @author 陈文超
	 * @date 2017年12月12日 下午6:38:36
	 */
	private Map<String, String> createAttValueMap(Byte attAttribute , Byte attResult ,Byte workType ,Integer belateMinute , boolean isWeightResultFlag) {
		int normalVal = 4;
		if (isWeightResultFlag) {
			normalVal = 1;
		}
		Map<String, String> attValueRsMap = new HashMap<>();
		String minuteDesc = "";
		if (belateMinute > 0) {
			try {
				if (attResult != normalVal && attResult != 0 && attResult != 9 && attResult != 10) {
					minuteDesc = createLateMinutesDesc(belateMinute);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Byte.valueOf("1").equals(attAttribute)) {
			if (workType != null) {
				if (attResult != normalVal && workType != 2) {
					attValueRsMap.put("clockIn", "上班：" + Const.TimeAttendanceResult.ATT_RESULT_CN.get(attResult) +minuteDesc);
					attValueRsMap.put("clockInNormal", "0");
				} else if (workType == 2) {
					if (attResult==normalVal) {
						attValueRsMap.put("clockIn", "上班：外勤");
						attValueRsMap.put("clockInNormal", "0");
					} else {
						attValueRsMap.put("clockIn", "上班：" + Const.TimeAttendanceResult.ATT_RESULT_CN.get(attResult) +minuteDesc);
						attValueRsMap.put("clockInNormal", "0");
					}
				} else {
					attValueRsMap.put("clockIn", "上班：正常");
					attValueRsMap.put("clockInNormal", "1");
				}
			}
		} else {
			if (workType != null) {
				if (attResult != normalVal && workType != 2) {
					attValueRsMap.put("clockIn", "下班：" + Const.TimeAttendanceResult.ATT_RESULT_CN.get(attResult) +minuteDesc);
					attValueRsMap.put("clockInNormal", "0");
				} else if (workType == 2) {
					if (attResult==normalVal) {
						attValueRsMap.put("clockIn", "下班：外勤");
						attValueRsMap.put("clockInNormal", "0");
					} else {
						attValueRsMap.put("clockIn", "下班：" + Const.TimeAttendanceResult.ATT_RESULT_CN.get(attResult) +minuteDesc);
						attValueRsMap.put("clockInNormal", "0");
					}
				}  else {
					attValueRsMap.put("clockIn", "下班：正常");
					attValueRsMap.put("clockInNormal", "1");
				}
			}
		}
		return attValueRsMap;
	}
	/**
	 * 创建某一人一天的考勤记录列表
	 * @author liucheng
	 * @date 2017年12月8日 下午9:35:21
	 */
	private void createOneDayRecordList(List<Map<String,Object>> reordDetailList,ErpFunAttendanceStatistics attendanceStatistics, Map<String,Object> resMap, Date currentDate){
		if (null == attendanceStatistics.getOffWork()) {
			return;
		}
		if (!Byte.valueOf("1").equals(attendanceStatistics.getOffWork())) {
			Map<String,Map<String,Object>> recordDetailMap = null;
			if (!reordDetailList.isEmpty()) {
				recordDetailMap = BeanUtil.listMapObjecttoMap(reordDetailList, new String[]{"attNum","attAttribute"});
			} else {
				return;
			}
			//查询获取到考勤记录
			if (attendanceStatistics!=null) {
				Byte attSumCount = attendanceStatistics.getAttSumCount();
				if (Byte.valueOf("1").equals(attSumCount)) {
					createFirstRoundClass(attendanceStatistics, reordDetailList, recordDetailMap ,currentDate);
				} else if (Byte.valueOf("2").equals(attSumCount)) {
					createSecondRoundClass(attendanceStatistics, reordDetailList, recordDetailMap ,currentDate);
				} else if (Byte.valueOf("3").equals(attSumCount)) {
					createThreeRoundClass(attendanceStatistics, reordDetailList, recordDetailMap ,currentDate);
				}
			}
		}
		Collections.sort(reordDetailList, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				String attNum1 = o1.get("attNum").toString();
				String attNum2 = o2.get("attNum").toString();
				int result = attNum1.compareTo(attNum2);
				if (result == 0) {
					String attAttribute1 = o1.get("attAttribute").toString();
					String attAttribute2 = o2.get("attAttribute").toString();
					return attAttribute1.compareTo(attAttribute2);
				}
				return result;
			}
		});
		List<Map<String, String>> attInfoMap = new ArrayList<>();
		if (reordDetailList==null) {
			return;
		}
		reordDetailList.forEach(map->{
			Byte attAttribute = StringUtil.parseByte(String.valueOf(map.get("attAttribute")),(byte)0);
			Byte attResult =  StringUtil.parseByte(String.valueOf(map.get("manageTimeAttResult")),(byte)0);
			Byte workType = StringUtil.parseByte(String.valueOf(map.get("manageLocationAttResult")),(byte)0);
			Integer belateMinute = StringUtil.parseInteger(map.get("belateMinute"),0);
			//第一轮打卡，需要判断是否为空
			attInfoMap.add(this.createAttValueMap(attAttribute ,attResult ,workType ,belateMinute, false));
		});
		resMap.put("attInfo", attInfoMap);
	}
	
	/*---------------------------以下为个人考勤月统计功能-------------------------*/

	/**
	 * 只用于个人考勤月统计次数的数据
	 * 该方法目前只有个人月统计的查询，后期可能要扩展成查询门店、片区、大区的数据
	 * <p>
	 * 与minAttendanceRecordMonthDetailData4Self联合使用
	 *
	 * @throws Exception
	 * @author liucheng
	 * @date 2017年12月5日 下午6:14:41
	 * <p>
	 * 数据结构
	 * "attRecords": [
	 * {
	 * "attType": "1,2,3,4,5,6,12",
	 * "attCn": "考勤文案描述:12出勤天数,6:迟到,5:早退,4:缺卡,3:外勤打卡,2:请假,1:正常打卡",
	 * "userAttNum": "次数",
	 * "list": [
	 * {
	 * "attType": "可以不用关注这个值",
	 * "dateStr": "打考勤的时间",
	 * "weekStr": "星期几",
	 * "timeStr": "迟到时间、早退时间",
	 * "attAttribute": "考勤上班或者下班。上班：1 、下班：2 (默认 0)",
	 * "attResult": "打卡结果：0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假",
	 * "belateMinute": "如果迟到，那么迟到几分钟、如果早退，早退多少分钟。单位：分钟"
	 * },
	 * ]
	 * }
	 * ]
	 * }
	 */
	@RequestMapping("/getAttRecordMonth4Self")
	public ResponseJson getAttRecordMonth4Self(@Valid @RequestBody AttendanceRecordParam attendanceRecordParam) throws Exception {
		Operator operator = getOperator();
		String attDateStr = attendanceRecordParam.getAttDate();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String startDate = attDateStr + "-01";// 开始日期
		String endDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(DateTimeHelper.parseToDate(startDate), 1));// 结束日期
		List<Map<String, Object>> attRecords = new ArrayList<>();
		List<Map<Integer, Integer>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalCountGroupByWeight(cityId, compId, userId, startDate, endDate);
		//统计出勤的天数
		List<String> attendanceDays = createAttendanceDaysList(cityId, compId, null, null, null, null, userId, startDate, endDate);
		HashMap<String, Object> map = new HashMap<>();
		map.put("attType", "12");
		map.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(12));
		map.put("userAttNum", String.valueOf(attendanceDays.size()) + "天");
		//总出勤天数，休息时如果打了卡也算出勤
		List<String> turnOutForWorkDays = this.createAttendanceDaysList(cityId, compId, null, null, null, null, userId, startDate, endDate);
		List<Map<String, String>> realTurnOutForWork = new ArrayList<>();
		for (String turnOutForWorkDay : turnOutForWorkDays) {
			HashMap<String, String> attDays = new HashMap<String, String>();
			attDays.put("attType", "12");
			attDays.put("dateStr", DateTimeHelper.formatDateTimetoString(turnOutForWorkDay, DateTimeHelper.FMT_yyyyMMdd));
			attDays.put("weekStr", DateTimeHelper.transferWeekDayOffCn(DateTimeHelper.parseToDate(turnOutForWorkDay)));
			attDays.put("leftStr", DateTimeHelper.formatDateTimetoString(turnOutForWorkDay, DateTimeHelper.FMT_yyyyMMdd) + "(" + DateTimeHelper.transferWeekDayOffCn(DateTimeHelper.parseToDate(turnOutForWorkDay)) + ")");
			realTurnOutForWork.add(attDays);
		}
		map.put("list", realTurnOutForWork);
		attRecords.add(map);

		//TODO 未排除小的權重
		// 查询所选月份考勤记录，查询的时间条件：2017-12-01 至 2018-01-01
		List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneMonth(cityId, compId, null, null, null, null, userId, startDate, endDate, null, null);
		Integer totalMissCardTime = 0;
		Date currentDate = new Date();
		List<Map<String,String>> missCardList = new ArrayList<>();
		for (ErpFunAttendanceStatistics statistics : erpFunAttendanceStatisticsList) {
			Byte offWork = statistics.getOffWork();
			if (Byte.valueOf("0").equals(offWork)) {
				totalMissCardTime += countMissCardCountOffRoundClass(statistics, currentDate ,missCardList);
			}
		}

		//缺卡的
		Map<String, Object> mapAttInfo = new HashMap<>();
		mapAttInfo.put("attType", "4");
		mapAttInfo.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(4));
		mapAttInfo.put("userAttNum", String.valueOf(totalMissCardTime) + "次");
		mapAttInfo.put("list", missCardList);
		attRecords.add(mapAttInfo);

		//count(1) as attResultCount, ATT_RESULT_WEIGHT as attResultWeight
		for (Map<Integer, Integer> dataMap : recordList) {
			Integer attResultCount = dataMap.get("attResultCount");
			Integer attResultWeight = dataMap.get("attResultWeight");
			Map<String, Object> data = new HashMap<>();
			data.put("attType", attResultWeight.toString());
			data.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(attResultWeight));
			data.put("userAttNum", String.valueOf(attResultCount) + "次");
			attRecords.add(data);
		}

		//合并各项统计数据的详细数据
		this.minAttendanceRecordMonthDetailData4Self(attDateStr, userId, attRecords);
		
		//添加默认数据-当某种考勤没有数据的时候
		Set<String> attTypeIsExist = new HashSet<>();
		for (Map<String, Object> tmp : attRecords) {
			attTypeIsExist.add(tmp.get("attType").toString());
		}

		for (Integer key : Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.keySet()) {
			if (key ==1 || key ==11) {
				continue;
			}
			if (!attTypeIsExist.contains(key.toString())) {
				Map<String, Object> data = new HashMap<>();
				data.put("attType", key.toString());
				data.put("attCn", Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.get(key));
				if (key == 12) {
					data.put("userAttNum", "0天");
				} else {
					data.put("userAttNum", "0次");
				}
				attRecords.add(data);
			}
		}
		
		//处理矿工的条数
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		String currentDateStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(),"yyyy-MM-dd");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String currentMonthFirstDayStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd");
		
		Date startTime = null;
		Date endTime = null;
		if (currentMonthFirstDayStr.equals(startDate)) {
			startTime = DateTimeHelper.parseToDate(currentMonthFirstDayStr);
			endTime = DateTimeHelper.parseToDate(currentDateStr);
		} else {
			startTime = DateTimeHelper.parseToDate(startDate);
			endTime = DateTimeHelper.parseToDate(endDate);
		}
		ErpFunAttendanceStatisticsExample example = new ErpFunAttendanceStatisticsExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andAttDateLessThan(endTime).andAttDateGreaterThanOrEqualTo(startTime).andOffWorkEqualTo(Byte.valueOf("3"));
		erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.selectByExample(example);
		//矿工的
		List<Map<String,String>> absenteeismAttList = new ArrayList<>();
		
		Map<String, Object> absenteeismAttInfo = new HashMap<>();
		absenteeismAttInfo.put("attType", "21");
		absenteeismAttInfo.put("attCn", "旷工");
		absenteeismAttInfo.put("userAttNum", String.valueOf(erpFunAttendanceStatisticsList.size()) + "天");
		absenteeismAttInfo.put("list", absenteeismAttList);
		attRecords.add(absenteeismAttInfo);
		erpFunAttendanceStatisticsList.forEach(statics->{
			Date attDate = statics.getAttDate();
			Map<String, String> attDays = new HashMap<String, String>();
			attDays.put("attType", "21");
			attDays.put("dateStr", DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_yyyyMMdd));
			attDays.put("weekStr", DateTimeHelper.transferWeekDayOffCn(attDate));
			attDays.put("leftStr", DateTimeHelper.formatDateTimetoString(attDate, DateTimeHelper.FMT_yyyyMMdd) + "(" + DateTimeHelper.transferWeekDayOffCn(attDate) + ")");
			absenteeismAttList.add(attDays);
		});
		/*erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneMonth(cityId, compId, null, null, null, null, userId, startDate, endDate, null, null);*/
		//缺卡记录次数
		//最後把出勤的計算出來
		Collections.sort(attRecords, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String attNum1 = Const.TimeAttendanceResult.ATT_MYSTATICS_SHOW_ORDER.get(o1.get("attType").toString());
				String attNum2 = Const.TimeAttendanceResult.ATT_MYSTATICS_SHOW_ORDER.get(o2.get("attType").toString());
				int result = attNum1.compareTo(attNum2);
				if (result == 0) {
					String attAttribute1 = o1.get("attAttribute").toString();
					String attAttribute2 = o2.get("attAttribute").toString();
					return attAttribute1.compareTo(attAttribute2);
				}
				return result;
			}
		});
		Map<String, Object> result = new HashMap<>();
		result.put("attRecords", attRecords);
		return ErpResponseJson.ok(result);
	}

	/**
	 * 该方法目前只有个人月统计的查询，后期可能要扩展成查询门店、片区、大区的数据
	 * 与getAttRecordMonth4Self关联使用
	 *
	 * @author 陈文超
	 * @date 2017年12月9日 下午3:32:37
	 */
	private void minAttendanceRecordMonthDetailData4Self(String attDateStr, Integer userId, List<Map<String, Object>> attRecords) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String startDate = attDateStr + "-01";// 开始日期
		String endDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(DateTimeHelper.parseToDate(startDate), 1));// 结束日期
		ErpFunAttendanceRecordDetailExample example = new ErpFunAttendanceRecordDetailExample();
		example.setShardCityId(cityId);
		example.setOrderByClause("ATT_OUGHT_DATE asc, ATT_NUM asc");
		ErpFunAttendanceRecordDetailExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		criteria.andUserIdEqualTo(userId);
		criteria.andAttOughtDateGreaterThanOrEqualTo(DateTimeHelper.parseToDate(startDate));
		criteria.andAttResultWeightNotEqualTo(Byte.valueOf("4"));
		criteria.andAttOughtDateLessThan(DateTimeHelper.parseToDate(endDate));
		/**
		 * 查询当前月的考勤详情数据
		 */
		List<ErpFunAttendanceRecordDetail> results = erpFunAttendanceRecordDetailMapper.selectByExample(example);
		for (ErpFunAttendanceRecordDetail tmpRs : results) {
			HashMap<String, String> record = new HashMap<String, String>();
			Byte attTypeValue = tmpRs.getAttResultWeight();
			record.put("attType", attTypeValue.toString());//该字段不允许为null出现
			if (tmpRs.getLocalAttTime()!=null) {
				record.put("dateStr", DateTimeHelper.formatDateTimetoString(tmpRs.getLocalAttTime(), DateTimeHelper.FMT_yyyyMMdd));
				record.put("weekStr", DateTimeHelper.transferWeekDayOffCn(tmpRs.getLocalAttTime()));
				record.put("timeStr", DateTimeHelper.formatDateTimetoString(tmpRs.getLocalAttTime(), DateTimeHelper.FMT_HHmm));
			}
			//上班还是下班、早退或者迟到等
			//考勤上班或者下班。上班：1 、下班：2 (默认 0)
			record.put("attAttribute", tmpRs.getAttAttribute().toString());
			//打卡结果：0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假
			record.put("attResult", tmpRs.getManageTimeAttResult().toString());
			String attAttributeStr = "";
			if ("1".equals(tmpRs.getAttAttribute().toString())) {
				attAttributeStr = "上班";
			} else if ("2".equals(tmpRs.getAttAttribute().toString())) {
				attAttributeStr = "下班";
			}
			String leftStr = null;
			if (tmpRs.getLocalAttTime()!=null) {
				leftStr = DateTimeHelper.formatDateTimetoString(tmpRs.getLocalAttTime(), DateTimeHelper.FMT_yyyyMMdd)
					+ "(" + DateTimeHelper.transferWeekDayOffCn(tmpRs.getLocalAttTime()) + ") "
					+ DateTimeHelper.formatDateTimetoString(tmpRs.getLocalAttTime(), DateTimeHelper.FMT_HHmm);
			}
			String rightStr = attAttributeStr + Const.TimeAttendanceResult.ATT_RESULT_CN.get(tmpRs.getManageTimeAttResult());
			if (tmpRs.getBelateMinute() != null && tmpRs.getBelateMinute() >0 && !"4".equals(tmpRs.getManageTimeAttResult().toString()) && !"0".equals(tmpRs.getManageTimeAttResult().toString()) && !"9".equals(tmpRs.getManageTimeAttResult().toString()) && !"10".equals(tmpRs.getManageTimeAttResult().toString())) {
//				如果迟到，那么迟到几分钟、如果早退，早退多少分钟。单位：分钟
				Integer lateMinutes = tmpRs.getBelateMinute();
				record.put("belateMinute", lateMinutes.toString());
				rightStr += createLateMinutesDesc(lateMinutes);
			}
			record.put("leftStr", leftStr);
			record.put("rightStr", rightStr);

			for (Map<String, Object> tmp : attRecords) {
				//合并考勤详细数据-考勤的详细数据合并到统计项中
				if (tmp.get("attType") != null
						&& tmp.get("attType").toString().equals(attTypeValue.toString())) {
					if (tmp.get("list") != null) {
						((List<Map<String, String>>) tmp.get("list")).add(record);
					} else {
						List<Map<String, String>> list = new ArrayList<>();
						list.add(record);
						tmp.put("list", list);
					}
				}
			}
		}
	}
	
	/**
	 * 创建迟到分钟的描述
	 * @param lateMinutes
	 * @return
	 * @throws Exception
	 */
	private String createLateMinutesDesc(Integer lateMinutes) throws Exception{
		if (lateMinutes<60) {
			return lateMinutes + "分钟";
		}
		if (lateMinutes%60==0) {
			return lateMinutes/60 + "小时";
		}
		return lateMinutes/60 + "小时" + lateMinutes%60+ "分钟";
		
	}
	/**
	 * 只查询个人
	 * 獲取一個月每天的考勤狀態信息
	 * 月日历考勤页面样式
	 * <p>
	 * 查询出每天打卡的记录
	 * 缺卡的记录
	 * 休息的记录
	 * 最后进行合并
	 * <p>
	 * {
	 * "attRecords": [
	 * {
	 * "attDate": "2017-01-01",
	 * "attType": "11：迟到早退、4：缺卡、3：外勤打卡、2请假、1正常打卡",
	 * "isRest": "是否是休息：1是、0否",
	 * "isOutWork": "是否是外勤：1是、0否",
	 * "attStatus": "1正常考勤、0不正常考勤"
	 * }
	 * ]
	 * }
	 *
	 * @author 陈文超
	 * @date 2017年12月9日 下午3:32:37
	 */
	@RequestMapping("/getAttMonthDayStausList4Self1")
	public ResponseJson getAttMonthDayStausList4Self(@Valid @RequestBody AttendanceRecordParam attendanceRecordParam) throws Exception {
		Operator operator = getOperator();
		String attDateStr = attendanceRecordParam.getAttDate();//格式：2017-01，只精确到月
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = attendanceRecordParam.getUserId();
		String startDate = attDateStr + "-01";// 开始日期
		String endDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(DateTimeHelper.parseToDate(startDate), 1));// 结束日期
		// 查询所选月份考勤记录，查询的时间条件：2017-12-01 至 2018-01-01（从考勤详细记录表中，按照日期和权重分组，每天按照最优先的权重类型返回数据）
		List<Map<String, Object>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailOffOneMonth(cityId, compId, userId, startDate, endDate);
		//格式化时间
		for (Map<String, Object> tmp : recordList) {
			if (tmp.get("attDate") != null) {
				Timestamp timestamp = (Timestamp) tmp.get("attDate");
				Date date = new Date();
				date.setTime(timestamp.getTime());
				tmp.put("attDate", DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMdd));
			}
		}

		Map<String, Object> returnList = new HashMap<>();
		//查询用户考勤组信息
		// 拿到用户的考勤组ID
		List<ErpFunAttendanceGroupBizPerson> groupByUserId = erpFunAttendanceGroupBizPersonMapper.findGroupByUserId(cityId, userId);
		ErpFunAttendanceGroup attendanceGroup = null;//考勤组信息
		//休息日集合
		List<String> restAttDates = new ArrayList<>();
		//所有的上班日期
		List<String> workOnDates = new ArrayList<>();
		if (null != groupByUserId && groupByUserId.size() > 0) {
			//通过考勤组ID判断考勤类型
			attendanceGroup = erpFunAttendanceGroupMapper.findClassType(cityId, groupByUserId.get(0).getAttGroupId());
			//固定班
			if (attendanceGroup.getClassType() == 1) {
				//公司的特殊考勤日
				ErpFunAttendanceFestivalExample example = new ErpFunAttendanceFestivalExample();
				example.setShardCityId(cityId);
				ErpFunAttendanceFestivalExample.Criteria festivalCriteria = example.createCriteria();
				festivalCriteria.andCompIdEqualTo(compId);
				festivalCriteria.andAttGrIdEqualTo(attendanceGroup.getId());
				festivalCriteria.andFestivalDataGreaterThanOrEqualTo(DateTimeHelper.parseToDate(startDate));
				festivalCriteria.andFestivalDataLessThan(DateTimeHelper.parseToDate(endDate));
				festivalCriteria.andIsDelEqualTo((byte) 0);
				List<ErpFunAttendanceFestival> festivalDateClass = erpFunAttendanceFestivalMapper.selectByExample(example);
				if (CollectionUtils.isNotEmpty(festivalDateClass)) {
					for (ErpFunAttendanceFestival tmp : festivalDateClass) {
						//特殊考勤日不休息就是上班
						if (tmp.getAttClassId() == -1) {
							restAttDates.add(DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd));
						} else {
							workOnDates.add(DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd));
						}
					}
				}

				//国家的规定的节假日集合
				ErpFunAttendanceFestivalExample exampleCountry = new ErpFunAttendanceFestivalExample();
				exampleCountry.setShardCityId(cityId);
				ErpFunAttendanceFestivalExample.Criteria countryCriteria = exampleCountry.createCriteria();
				countryCriteria.andCompIdEqualTo(0);
				countryCriteria.andFestivalDataGreaterThanOrEqualTo(DateTimeHelper.parseToDate(startDate));
				countryCriteria.andFestivalDataLessThan(DateTimeHelper.parseToDate(endDate));
				countryCriteria.andIsDelEqualTo((byte) 0);
				List<ErpFunAttendanceFestival> countryDateClass = erpFunAttendanceFestivalMapper.selectByExample(exampleCountry);
				if (CollectionUtils.isNotEmpty(countryDateClass)) {
					for (ErpFunAttendanceFestival tmp : countryDateClass) {
						//国家的规定的节假日不在设置的要上班的考勤集合中才写入休息日集合
						String tmpDate = DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd);
						if (1 == attendanceGroup.getFestivals() && !workOnDates.contains(tmpDate)) {
							restAttDates.add(tmpDate);
						}
					}
				}

				int monthDays = DateTimeHelper.getDaysOfMonth(DateTimeHelper.parseToDate(startDate));
				for (int i = 0; i < monthDays; i++) {
					int classId = 0;
					Date tmp = DateTimeHelper.addDays(DateTimeHelper.parseToDate(startDate), i);
					int week = DateTimeHelper.getDayOfWeek(tmp);
					switch (week) {
						case 1:
							classId = attendanceGroup.getMonClass();
							break;
						case 2:
							classId = attendanceGroup.getTuesCalss();
							break;
						case 3:
							classId = attendanceGroup.getWebClass();
							break;
						case 4:
							classId = attendanceGroup.getThurClass();
							break;
						case 5:
							classId = attendanceGroup.getFirClass();
							break;
						case 6:
							classId = attendanceGroup.getStaClass();
							break;
						case 0:
							classId = attendanceGroup.getSunClass();
							break;
					}

					//是休息日并且不在特殊上班日期集合中就视为休息日
					String weekRestDate = DateTimeHelper.formatDateTimetoString(tmp, DateTimeHelper.FMT_yyyyMMdd);
					if (classId == -1 && !workOnDates.contains(weekRestDate)) {
						restAttDates.add(weekRestDate);
					}
				}
				//排班记录
			} else if (attendanceGroup.getClassType() == 2) {
				ErpFunAttendanceUserClassDetailExample example = new ErpFunAttendanceUserClassDetailExample();
				example.setShardCityId(cityId);
				ErpFunAttendanceUserClassDetailExample.Criteria criteria = example.createCriteria();
				criteria.andCompIdEqualTo(compId);
				criteria.andAttClassIdEqualTo(-1);
				criteria.andAttTimeGreaterThanOrEqualTo(DateTimeHelper.parseToDate(startDate));
				criteria.andAttTimeLessThan(DateTimeHelper.parseToDate(endDate));
				List<ErpFunAttendanceUserClassDetail> erpFunAttendanceUserClassDetails = erpFunAttendanceUserClassDetailMapper.selectByExample(example);
				for (ErpFunAttendanceUserClassDetail tmp : erpFunAttendanceUserClassDetails) {
					restAttDates.add(DateTimeHelper.formatDateTimetoString(tmp.getAttTime(), DateTimeHelper.FMT_yyyyMMdd));
				}
			}
		}
		//判断休息日信息、特殊休息日、休息日上班等
		returnList.put("attRecords", recordList);
		returnList.put("attRests", restAttDates.toArray());
		System.out.println(JSON.toJSONString(returnList));
		return ErpResponseJson.ok(returnList);
	}
	

	/**
	 * 只查询个人
	 * 獲取一個月每天的考勤狀態信息
	 * 月日历考勤页面样式
	 * <p>
	 * 查询出每天打卡的记录
	 * 缺卡的记录
	 * 休息的记录
	 * 最后进行合并
	 * <p>
	 * {
	 * "attRecords": [
	 * {
	 * "attDate": "2017-01-01",
	 * "attType": "11：迟到早退、4：缺卡、3：外勤打卡、2请假、1正常打卡",
	 * "isRest": "是否是休息：1是、0否",
	 * "isOutWork": "是否是外勤：1是、0否",
	 * "attStatus": "1正常考勤、0不正常考勤"
	 * }
	 * ]
	 * }
	 *
	 * @author 陈文超
	 * @date 2017年12月9日 下午3:32:37
	 */
	@RequestMapping("/getAttMonthDayStausList4Self")
	public ResponseJson getAttendanceMonthDayStausList(@Valid @RequestBody AttendanceRecordParam attendanceRecordParam) throws Exception {
		Operator operator = getOperator();
		String attDateStr = attendanceRecordParam.getAttDate();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer areaId = attendanceRecordParam.getAreaId();
		Integer regId = attendanceRecordParam.getRegId();
		Integer deptId = attendanceRecordParam.getDeptId();
		Integer grId = attendanceRecordParam.getGrId();
		Integer userId = attendanceRecordParam.getUserId();
		String startDate = attDateStr + "-01";// 开始日期
		String endDate = null;// 结束日期
		String nextMonthFirstDayStr = null;
		boolean isQueryAttConfigFlag = false;//是否需要查询配置信息
		Calendar calendar = Calendar.getInstance();
		String currentDayStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);//获取当前日期，做一个时间对比
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		String nextDayStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);//获取当前日期，做一个时间对比
		calendar.set(Calendar.DAY_OF_MONTH, 1);//设置当前时间为当月的1号
		String currMonthFirstDayStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		calendar.add(Calendar.MONTH, 1);
		nextMonthFirstDayStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		if (!startDate.equals(currMonthFirstDayStr)) {
			endDate = nextMonthFirstDayStr;
		} else {
			endDate = nextDayStr;
			isQueryAttConfigFlag = true;
		}
		// 查询所选月份考勤记录，查询的时间条件：2017-12-01 至 
		List<Map<String, Object>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailOffOneMonth(cityId, compId, userId, startDate, endDate);
		Map<String, List<String>> userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attType").toString(), Collectors.mapping(map->map.get("attDate").toString(), Collectors.toList())));
		List<String> dateStrList = userManageMap.get("5");//EARLY
		List<String> lateDateStrList = userManageMap.get("6");
		if (CollectionUtils.isNotEmpty(lateDateStrList)) {
			if (CollectionUtils.isNotEmpty(dateStrList)) {
				dateStrList.addAll(lateDateStrList);
			} else {
				dateStrList = lateDateStrList;
			}
		}
		List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneMonth(cityId, compId, areaId, regId, deptId, grId, userId, startDate, endDate, null,dateStrList);
		List<String> restDayList = new ArrayList<>();
		List<String> needDeleteDays =  new ArrayList<>();
		//List<Integer> totalCommnoAttUserIds = new ArrayList<>();//出勤记录统计数据，如果休息日打卡那么也要算出勤
		List<String> totalMisscardDate = new ArrayList<>();//缺卡记录统计数据
		Date currentDate = new Date();
		for (ErpFunAttendanceStatistics statistics: erpFunAttendanceStatisticsList) {
			String attDate = DateTimeHelper.formatDateTimetoString(statistics.getAttDate(),"yyyy-MM-dd");
			if (Byte.valueOf("1").equals(statistics.getOffWork())) {
				restDayList.add(attDate);
				continue;
			}
			if (addMissCardCountOffRoundClass(statistics, currentDate)) {
				totalMisscardDate.add(attDate);
			}
		}
		Map<Integer,List<String>> totalData = new HashMap<>(); 
		for (Integer key : Const.TimeAttendanceResult.ATT_WEIGHT_MAP_ATT_TYPE.keySet()) {
			List<String> attCountList = userManageMap.get(key.toString());
			if (attCountList!=null) {
				needDeleteDays.addAll(attCountList);
			} else {
				continue;
			}
			if (key < 4) {
				//当权重小于4对应的缺卡的时候，过滤掉缺卡的人
				if (attCountList != null) {
					attCountList.removeAll(totalMisscardDate);
				}
			}
			totalData.put(key, attCountList);
		}
		totalData.put(4, totalMisscardDate);
		needDeleteDays.addAll(totalMisscardDate);
		//最後把出勤的計算出來
		List<String> attendanceDays = createAttendanceDaysList(cityId, compId, areaId, regId, deptId, grId, userId, startDate, endDate);
		attendanceDays.removeAll(needDeleteDays);
		Map<String, Object> returnData = new HashMap<>();
		List<Map<String,String>> returnList = new ArrayList<>();
		for (Integer key : totalData.keySet()) {
			List<String> attCountList = totalData.get(key);
			if (attCountList != null) {
				needDeleteDays.addAll(attCountList);
			}
			if (key==1) {
				continue;
			}
			for (String attendanceDay:attCountList) {
				Map<String,String> attendanceMap = new HashMap<>();
				attendanceMap.put("attType", key.toString());
				attendanceMap.put("attDate", attendanceDay);
				returnList.add(attendanceMap);
			}
		}
		for (String attendanceDay:attendanceDays) {
			Map<String,String> attendanceMap = new HashMap<>();
			attendanceMap.put("attType", "1");
			attendanceMap.put("attDate", attendanceDay);
			returnList.add(attendanceMap);
		}
		if (isQueryAttConfigFlag) {
			startDate = currentDayStr;
			endDate = nextMonthFirstDayStr;
			restDayList.addAll(getAfterDayRestList(cityId, compId, userId, startDate, endDate));
		}
		//判断休息日信息、特殊休息日、休息日上班等，正常的考勤结果单独添加
		returnData.put("attRecords", returnList);
		returnData.put("attRests", restDayList);
		//System.out.println(JSON.toJSONString(returnData));
		return ErpResponseJson.ok(returnData);	
	} 
	
	
	/**
	 * 考勤月历，查询当前日期之后的数据，这个数据从当前日期之后计算
	 * @return
	 * @throws Exception
	 */
	private List<String> getAfterDayRestList(Integer cityId, Integer compId, Integer userId, String startDate, String endDate) throws Exception {
		//查询用户考勤组信息
		// 拿到用户的考勤组ID
		List<ErpFunAttendanceGroupBizPerson> groupByUserId = erpFunAttendanceGroupBizPersonMapper.findGroupByUserId(cityId, userId);
		ErpFunAttendanceGroup attendanceGroup = null;//考勤组信息
		//休息日集合
		List<String> restAttDates = new ArrayList<>();
		//所有的上班日期
		List<String> workOnDates = new ArrayList<>();
		if (groupByUserId.isEmpty()) {
			return restAttDates;
		}
		Integer groupId = groupByUserId.get(0).getAttGroupId();
		if (null != groupByUserId && groupByUserId.size() > 0) {
			//通过考勤组ID判断考勤类型
			attendanceGroup = erpFunAttendanceGroupMapper.findClassType(cityId, groupByUserId.get(0).getAttGroupId());
			//固定班
			if (attendanceGroup.getClassType() == 1) {
				//公司的特殊考勤日
				ErpFunAttendanceFestivalExample example = new ErpFunAttendanceFestivalExample();
				example.setShardCityId(cityId);
				ErpFunAttendanceFestivalExample.Criteria festivalCriteria = example.createCriteria();
				festivalCriteria.andCompIdEqualTo(compId);
				festivalCriteria.andAttGrIdEqualTo(attendanceGroup.getId());
				festivalCriteria.andFestivalDataGreaterThan(DateTimeHelper.parseToDate(startDate));
				festivalCriteria.andFestivalDataLessThan(DateTimeHelper.parseToDate(endDate));
				festivalCriteria.andIsDelEqualTo((byte) 0);
				List<ErpFunAttendanceFestival> festivalDateClass = erpFunAttendanceFestivalMapper.selectByExample(example);
				if (CollectionUtils.isNotEmpty(festivalDateClass)) {
					for (ErpFunAttendanceFestival tmp : festivalDateClass) {
						//特殊考勤日不休息就是上班
						if (tmp.getAttClassId() == -1) {
							restAttDates.add(DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd));
						} else {
							workOnDates.add(DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd));
						}
					}
				}
				
				//国家的规定的节假日集合
				ErpFunAttendanceFestivalExample exampleCountry = new ErpFunAttendanceFestivalExample();
				exampleCountry.setShardCityId(cityId);
				ErpFunAttendanceFestivalExample.Criteria countryCriteria = exampleCountry.createCriteria();
				countryCriteria.andCompIdEqualTo(0);
				countryCriteria.andFestivalDataGreaterThan(DateTimeHelper.parseToDate(startDate));
				countryCriteria.andFestivalDataLessThan(DateTimeHelper.parseToDate(endDate));
				countryCriteria.andIsDelEqualTo((byte) 0);
				List<ErpFunAttendanceFestival> countryDateClass = erpFunAttendanceFestivalMapper.selectByExample(exampleCountry);
				if (CollectionUtils.isNotEmpty(countryDateClass)) {
					for (ErpFunAttendanceFestival tmp : countryDateClass) {
						//国家的规定的节假日不在设置的要上班的考勤集合中才写入休息日集合
						String tmpDate = DateTimeHelper.formatDateTimetoString(tmp.getFestivalData(), DateTimeHelper.FMT_yyyyMMdd);
						if (1 == attendanceGroup.getFestivals() && !workOnDates.contains(tmpDate)) {
							restAttDates.add(tmpDate);
						}
					}
				}
				
				int monthDays = DateTimeHelper.getBetweenDaysCount(startDate, endDate, true);
				for (int i = 0; i < monthDays; i++) {
					int classId = 0;
					Date tmp = DateTimeHelper.addDays(DateTimeHelper.parseToDate(startDate), i);
					int week = DateTimeHelper.getDayOfWeek(tmp);
					switch (week) {
					case 1:
						classId = attendanceGroup.getMonClass();
						break;
					case 2:
						classId = attendanceGroup.getTuesCalss();
						break;
					case 3:
						classId = attendanceGroup.getWebClass();
						break;
					case 4:
						classId = attendanceGroup.getThurClass();
						break;
					case 5:
						classId = attendanceGroup.getFirClass();
						break;
					case 6:
						classId = attendanceGroup.getStaClass();
						break;
					case 0:
						classId = attendanceGroup.getSunClass();
						break;
					}
					
					//是休息日并且不在特殊上班日期集合中就视为休息日
					String weekRestDate = DateTimeHelper.formatDateTimetoString(tmp, DateTimeHelper.FMT_yyyyMMdd);
					if (classId == -1 && !workOnDates.contains(weekRestDate)) {
						restAttDates.add(weekRestDate);
					}
				}
				//排班记录
			} else if (attendanceGroup.getClassType() == 2) {
				ErpFunAttendanceUserClassDetailExample example = new ErpFunAttendanceUserClassDetailExample();
				example.setShardCityId(cityId);
				ErpFunAttendanceUserClassDetailExample.Criteria criteria = example.createCriteria();
				criteria.andCompIdEqualTo(compId);
				criteria.andAttClassIdEqualTo(-1);
				criteria.andAttTimeGreaterThanOrEqualTo(DateTimeHelper.parseToDate(startDate));
				criteria.andUserIdEqualTo(userId);
				criteria.andIsDelEqualTo((byte)0);
				criteria.andGrIdEqualTo(groupId);
				criteria.andAttTimeLessThan(DateTimeHelper.parseToDate(endDate));
				List<ErpFunAttendanceUserClassDetail> erpFunAttendanceUserClassDetails = erpFunAttendanceUserClassDetailMapper.selectByExample(example);
				for (ErpFunAttendanceUserClassDetail tmp : erpFunAttendanceUserClassDetails) {
					restAttDates.add(DateTimeHelper.formatDateTimetoString(tmp.getAttTime(), DateTimeHelper.FMT_yyyyMMdd));
				}
			}
		}
		return restAttDates;
	}
	
	/**
	 * 只查询个人
	 * 獲取一個月每天的考勤狀態信息
	 * 月日历考勤页面样式
	 * <p>
	 * 查询出每天打卡的记录
	 * 缺卡的记录
	 * 休息的记录
	 * 最后进行合并
	 * <p>
	 * {
	 * "attRecords": [
	 * {
	 * "attDate": "2017-01-01",
	 * "attType": "11：迟到早退、4：缺卡、3：外勤打卡、2请假、1正常打卡",
	 * "isRest": "是否是休息：1是、0否",
	 * "isOutWork": "是否是外勤：1是、0否",
	 * "attStatus": "1正常考勤、0不正常考勤"
	 * }
	 * ]
	 * }
	 *
	 * @author 陈文超
	 * @date 2017年12月9日 下午3:32:37
	 */
	@RequestMapping("/getLastDayStatisticInfo")
	public ResponseJson getLastDayStatisticInfo () throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Integer archiveId = operator.getArchiveId();
		Integer compId = operator.getCompId();
		Integer areaId = null;
		Integer regId = null;
		Integer deptId = null;
		Map<String,String> returnMap = new HashMap<String,String>();
		returnMap.put("isPushStatistic", "0");
		boolean isQueryFlag = false;
		//公司考勤统计查看权
		boolean countViewCompFlag = erpUserOpersService.judgePermission(cityId, userId, "ATTENDANCE_COUNT_VIEW_COMP");
		//大区考勤统计查看权
		boolean countViewAreaFlag = erpUserOpersService.judgePermission(cityId, userId, "ATTENDANCE_COUNT_VIEW_AREA");
		//片区考勤统计查看权
		boolean countViewRegFlag = erpUserOpersService.judgePermission(cityId, userId, "ATTENDANCE_COUNT_VIEW_REG");
		//门店考勤统计查看权
		boolean countViewDeptFlag = erpUserOpersService.judgePermission(cityId, userId, "ATTENDANCE_COUNT_VIEW_DEPT");
		if (countViewCompFlag) {
			isQueryFlag = true;
		} else if (countViewAreaFlag) {
			isQueryFlag = true;
			areaId = operator.getAreaId();
		} else if (countViewRegFlag) {
			isQueryFlag = true;
			regId = operator.getRegId();
		} else if (countViewDeptFlag) {
			isQueryFlag = true;	
			deptId = operator.getDeptId();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String attDateStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd");//昨天的考勤日期字符串形式
		Date attDate = DateTimeHelper.parseToDate(attDateStr);
		ErpFunAttendancePushLogExample example = new ErpFunAttendancePushLogExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andPushAttDateEqualTo(attDate);
		int pushCount = erpFunAttendancePushLogMapper.countByExample(example);
		if (isQueryFlag && pushCount==0) {
			List<Map<String, Integer>> recordList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordStatisticalAnalysisDetailOffOneDay(cityId, compId, areaId, regId, deptId, null, null, null, attDateStr);
			Map<String, List<Integer>> userManageMap = recordList.stream().collect(Collectors.groupingBy(reg -> reg.get("attResultWeight").toString(), Collectors.mapping(map -> Integer.valueOf(map.get("userId")), Collectors.toList())));
			//后面查考勤统计表的时候需要排除权重最高的
			List<Integer> commonUserList = userManageMap.get("1");
			List<Integer> userList = userManageMap.get("5");
			List<Integer> absenteeismList = userManageMap.get("6");
			if (CollectionUtils.isNotEmpty(userList)) {
				if (CollectionUtils.isNotEmpty(absenteeismList)) {
					userList.addAll(absenteeismList);
				} 
			} else {
				userList = absenteeismList;
			}
			Integer totalErrorCount = 0;
			Integer nomalCount = 0;
			Date currentDate = new Date();
			List<ErpFunAttendanceStatistics> erpFunAttendanceStatisticsList = erpFunAttendanceStatisticsMapper.getAttendanceStatisticListOffOneDay(cityId, compId, areaId, regId, deptId, null, null, attDateStr, userList);
			List<Integer> totalMisscardUserIds = new ArrayList<>();//只剩下统计
			for (ErpFunAttendanceStatistics statistics : erpFunAttendanceStatisticsList) {
				if (addMissCardCountOffRoundClass(statistics, currentDate)) {
					totalMisscardUserIds.add(statistics.getUserId());
					totalErrorCount++;
				}
			}
			if (userList!= null) {
				totalErrorCount+= userList.size();
				userList.addAll(totalMisscardUserIds);
			}
			if (commonUserList!=null) {
				if (userList!= null) {
					commonUserList.removeAll(userList);
				}
				nomalCount = commonUserList.size();
			}
			if (!(nomalCount==0&&totalErrorCount ==0)){
				returnMap.put("isPushStatistic", "1");
				erpFunAttendancePushLogService.pushAttStaticsByManageRange(cityId, compId, attDateStr, userId, archiveId, totalErrorCount, nomalCount);
			}
			//先查询普通的
		}
		return ErpResponseJson.ok(returnMap);
	}
	/**
	 * 创建只有一轮打卡的考勤缺卡记录
	 */
	private boolean addMissCardCountOffRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentDate) {
		boolean flag = false;
		if (!(Byte.valueOf("0").equals(attendanceStatistics.getOffWork()) || Byte.valueOf("3").equals(attendanceStatistics.getOffWork()))) {
			return false;
		}
		Byte attSumCount = attendanceStatistics.getAttSumCount();// 打卡轮数
		if (Byte.valueOf("1").equals(attSumCount)) {
			flag = isHaveMissCardOffFirstRoundClass(attendanceStatistics, currentDate, true);
		} else if (Byte.valueOf("2").equals(attSumCount)) {
			flag = isHaveMissCardOffSecondRoundClass(attendanceStatistics, currentDate, true);
		} else if (Byte.valueOf("3").equals(attSumCount)) {
			flag = isHaveMissCardOffThreeRoundClass(attendanceStatistics, currentDate, true);
		}
		return flag;
	}

	/**
	 * 判断第一轮打卡中是否有缺卡的轮数
	 */
	private boolean isHaveMissCardOffFirstRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentDate,
			boolean isLastRoundClass) {
		boolean flag = false;
		Date compareDate = null;
		if (attendanceStatistics.getFirstWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(attendanceStatistics.getFirstWorkOfftime().getTime());
		}
		if (isLastRoundClass && compareDate!=null) {
			compareDate = DateTimeHelper.addHours(compareDate, 6);
			compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			if (Byte.valueOf("3").equals(attendanceStatistics.getOffWork()) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOff())
					&& attendanceStatistics.getFirstWorkOfftime() != null
					&& currentDate.compareTo(compareDate) >= 0) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOn())
							&& attendanceStatistics.getFirstWorkOntime() != null
							&& currentDate.compareTo(attendanceStatistics.getFirstWorkOntime()) >= 0)) {
				return false;
			}
		}
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOn())
				&& attendanceStatistics.getFirstWorkOntime() != null
				&& currentDate.compareTo(attendanceStatistics.getFirstWorkOntime()) >= 0)
				|| (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getFirstWorkOff())
						&& attendanceStatistics.getFirstWorkOfftime() != null
						&& currentDate.compareTo(compareDate) >= 0)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断第二轮打卡中是否有缺卡的轮数
	 */
	private boolean isHaveMissCardOffSecondRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentDate,
			boolean isLastRoundClass) {
		boolean flag = isHaveMissCardOffFirstRoundClass(attendanceStatistics, currentDate, false);
		Date compareDate = null;
		if (attendanceStatistics.getSecondWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(attendanceStatistics.getSecondWorkOfftime().getTime());
		}
		if (isLastRoundClass && compareDate!=null) {
			compareDate = DateTimeHelper.addHours(compareDate, 6);
			compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			if (Byte.valueOf("3").equals(attendanceStatistics.getOffWork()) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOff())
					&& attendanceStatistics.getSecondWorkOfftime() != null
					&& currentDate.compareTo(compareDate) >= 0) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOn())
							&& attendanceStatistics.getSecondWorkOntime() != null
							&& currentDate.compareTo(attendanceStatistics.getSecondWorkOntime()) >= 0)) {
				return false;
			}
		}
		if (flag) {
			return flag;
		}
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOn())
				&& attendanceStatistics.getSecondWorkOntime() != null
				&& currentDate.compareTo(attendanceStatistics.getSecondWorkOntime()) >= 0)
				|| (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getSecondWorkOff())
						&& attendanceStatistics.getSecondWorkOfftime() != null
						&& currentDate.compareTo(compareDate) >= 0)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断第三轮打卡中是否有缺卡的轮数
	 */
	private boolean isHaveMissCardOffThreeRoundClass(ErpFunAttendanceStatistics attendanceStatistics, Date currentDate,
			boolean isLastRoundClass) {
		boolean flag = isHaveMissCardOffSecondRoundClass(attendanceStatistics, currentDate, false);
		Date compareDate = null;
		if (attendanceStatistics.getThreeWorkOfftime() != null) {
			compareDate = new Date();
			compareDate.setTime(attendanceStatistics.getThreeWorkOfftime().getTime());
		}
		if (isLastRoundClass && compareDate!=null) {
			compareDate = DateTimeHelper.addHours(compareDate, 6);
			compareDate = DateTimeHelper.addMinutes(compareDate, 1);
			if (Byte.valueOf("3").equals(attendanceStatistics.getOffWork()) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOn())
					&& attendanceStatistics.getThreeWorkOntime() != null
					&& currentDate.compareTo(attendanceStatistics.getThreeWorkOntime()) >= 0) && (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOff())
					&& attendanceStatistics.getThreeWorkOfftime() != null
					&& currentDate.compareTo(compareDate) >= 0)) {	
				return false;
			}
		}
 		if (flag) {
			return flag;
		}
		if ((Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOn())
				&& attendanceStatistics.getThreeWorkOntime() != null
				&& currentDate.compareTo(attendanceStatistics.getThreeWorkOntime()) >= 0)
				|| (Const.TimeAttendanceResult.LACK_OF_CARD.equals(attendanceStatistics.getThreeWorkOff())
						&& attendanceStatistics.getThreeWorkOfftime() != null
						&& currentDate.compareTo(compareDate) >= 0)) {
			flag = true;
		}
		return flag;
	}

    /**
      * 修改月度统计中的记录
      * @author 李成兵
      * @since 2018/4/27
      * private  attResult打卡结果
	  * private editRemark修改备注
	  *	private lateMinutes迟到分钟数
	 *	private attOughtDate考勤时间
	 *	private userId 员工userId
      * @return
      */
    @RequestMapping("/updateMonthCountDayAttendance")
    public ResponseJson updateMonthCountDayAttendance(@Valid @RequestBody ChangeAttendanceResultParam param) {

		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer deptId = operator.getDeptId();
		Integer userId = operator.getUserId();
		param.setCurrentUserName(operator.getUserName());
		erpFunAttendanceRecordDetailService.updateMonthCountDayAttendance(cityId, compId, deptId, userId, param);
        return ErpResponseJson.ok();
    }
    
	  /**
     * 计算一个月的请假天数
     * @param statistList
     * @return
     */
    private BigDecimal countOneMonthLeaveDays (List<ErpFunAttendanceStatisticsDto> statistList,Map<Integer,ErpAuditRuntime> runtimeMap) {
    	BigDecimal  valBigDecimal = BigDecimal.ZERO;
    	if (statistList==null || statistList.isEmpty()) {
    		return BigDecimal.ZERO;
    	}
    	for (ErpFunAttendanceStatistics statist : statistList) {
    		try {
				valBigDecimal = valBigDecimal.add(countOneDayLeaveDays(statist,runtimeMap));
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
		return valBigDecimal;
    }
	public BigDecimal countOneDayLeaveDays(ErpFunAttendanceStatistics statist,Map<Integer,ErpAuditRuntime> runtimeMap) throws Exception {
		BigDecimal totalDay = BigDecimal.ZERO;
		Byte attSumCount = statist.getAttSumCount();
		if (attSumCount==null) {
			return totalDay;
		}
    	int attRestArrLength = attSumCount*2;
    	List<Byte> attResultArr = new ArrayList<>(attRestArrLength);
    	List<String> attConfigTimeArr = new ArrayList<>(attRestArrLength);
    	List<Integer> attAuditId = new ArrayList<>(attRestArrLength);
    	List<Integer> attCustomEditList = new ArrayList<>();
       	String attDate = DateTimeHelper.formatDateTimetoString(statist.getAttDate(), DateTimeHelper.FMT_yyyyMMdd);
    	boolean isAllFromAudit = true;
    	Set<Integer> auditIdSet = new HashSet<>();
    	Set<String> auditInfoSet = new HashSet<>();
    	if (Byte.valueOf("1").equals(attSumCount)) {
    		attResultArr.add(statist.getFirstWorkOn());
    		attResultArr.add(statist.getFirstWorkOff());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOffconfigtime());
    		attAuditId.add(statist.getFirstWorkonAuditId());
    		attAuditId.add(statist.getFirstWorkoffAuditId());
    	} else if (Byte.valueOf("2").equals(attSumCount)) {
    		attResultArr.add(statist.getFirstWorkOn());
    		attResultArr.add(statist.getFirstWorkOff());
    		attResultArr.add(statist.getSecondWorkOn());
    		attResultArr.add(statist.getSecondWorkOff());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOffconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getSecondWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getSecondWorkOffconfigtime());
    		attAuditId.add(statist.getFirstWorkonAuditId());
    		attAuditId.add(statist.getFirstWorkoffAuditId());
    		attAuditId.add(statist.getSecondWorkonAuditId());
    		attAuditId.add(statist.getSecondWorkoffAuditId());
    	} else if (Byte.valueOf("3").equals(attSumCount)) {
    		attResultArr.add(statist.getFirstWorkOn());
    		attResultArr.add(statist.getFirstWorkOff());
    		attResultArr.add(statist.getSecondWorkOn());
    		attResultArr.add(statist.getSecondWorkOff());
    		attResultArr.add(statist.getThreeWorkOn());
    		attResultArr.add(statist.getThreeWorkOff());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getFirstWorkOffconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getSecondWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getSecondWorkOffconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getThreeWorkOnconfigtime());
    		attConfigTimeArr.add(attDate+" "+statist.getThreeWorkOffconfigtime());
    		attAuditId.add(statist.getFirstWorkonAuditId());
    		attAuditId.add(statist.getFirstWorkoffAuditId());
    		attAuditId.add(statist.getSecondWorkonAuditId());
    		attAuditId.add(statist.getSecondWorkoffAuditId());
      		attAuditId.add(statist.getThreeWorkonAuditId());
    		attAuditId.add(statist.getThreeWorkoffAuditId());
    	}
    	long totalAttendanceTime = 0l;
    	//1.先判断来自请假的有几条，时间是多少
    	for (int i=0;i<attSumCount;i++) {
    		int onIndex = 2*i;
    		int offIndex = onIndex + 1;
    		if (!Const.TimeAttendanceResult.AUDIT_LEAVE.equals(attResultArr.get(onIndex))) {
    			isAllFromAudit = false;
    		} else {
    			if (!auditIdSet.contains(attAuditId.get(onIndex))) {
    				auditInfoSet.add(onIndex+"_"+attAuditId.get(onIndex));
    			}
    			auditIdSet.add(attAuditId.get(onIndex));
    		}
    		
    		if (!Const.TimeAttendanceResult.AUDIT_LEAVE.equals(attResultArr.get(offIndex))) {
    			isAllFromAudit = false;
    		} else {
    			if (!auditIdSet.contains(attAuditId.get(offIndex))) {
    				auditInfoSet.add(offIndex+"_"+attAuditId.get(offIndex));
    			}
    			auditIdSet.add(attAuditId.get(offIndex));
    		}
    		
    		
   /* 		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(attResultArr.get(onIndex)) && (Const.TimeAttendanceResult.COMPASSIONATE_LEAVE.equals(attResultArr.get(offIndex)) || Const.TimeAttendanceResult.SICK_LEAVE.equals(attResultArr.get(offIndex)))) {
    			zeroDayRecordIndex = offIndex;
    		}
    		
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(attResultArr.get(offIndex)) && (Const.TimeAttendanceResult.COMPASSIONATE_LEAVE.equals(attResultArr.get(onIndex)) || Const.TimeAttendanceResult.SICK_LEAVE.equals(attResultArr.get(onIndex)))) {
    			zeroDayRecordIndex = onIndex;
    		}*/
    		if ((Const.TimeAttendanceResult.COMPASSIONATE_LEAVE.equals(attResultArr.get(onIndex)) || Const.TimeAttendanceResult.SICK_LEAVE.equals(attResultArr.get(onIndex))) && (Const.TimeAttendanceResult.COMPASSIONATE_LEAVE.equals(attResultArr.get(offIndex)) || Const.TimeAttendanceResult.SICK_LEAVE.equals(attResultArr.get(offIndex)))) {
    			attCustomEditList.add(i);
    		}
    		String startTime = attConfigTimeArr.get(onIndex);
    		String endTime = attConfigTimeArr.get(offIndex);
    		totalAttendanceTime = totalAttendanceTime + (DateTimeHelper.parseToDate(endTime).getTime()-DateTimeHelper.parseToDate(startTime).getTime())/1000;
    	}
    	BigDecimal zeroPointFive = new BigDecimal(0.5);
    	boolean isNotNeedCountConstom = false;
    	// 所有情况都判断出来了，那么下一步就是生成记录，分3个记录来创建吧
    	//1.创建请假的记录
		//1.判断size计算请假时间段，当set里面size为2时，不说了一个上午一个下午，只有一个就是整天
		if (auditIdSet.size()>0) {
			if (isAllFromAudit) {
				return BigDecimal.ONE;
			} else {
				
				for (String info : auditInfoSet) {
					String[] arr = info.split("_");
					if (Integer.valueOf("0").equals(Integer.valueOf(arr[0]))) {
						totalDay = zeroPointFive;
						Integer auditId = attAuditId.get(Integer.valueOf(arr[0]));
						ErpAuditRuntime tmpRuntime = runtimeMap.get(auditId);
						if (tmpRuntime!=null) {
							BigDecimal leaveDay = countOneDay(tmpRuntime.getTargetStartTime(),tmpRuntime.getTargetEndTime(), DateTimeHelper.formatDateTimetoString(statist.getAttDate(), DateTimeHelper.FMT_yyyyMMdd), tmpRuntime.getTargetStartType().intValue(), tmpRuntime.getTargetEndType().intValue());
							if (leaveDay!=null && leaveDay.equals(BigDecimal.ONE)) {
								totalDay = BigDecimal.ONE;	
								isNotNeedCountConstom = true;
								break;
							}
						}
	
					} else {
						totalDay = zeroPointFive;
						Integer auditId = attAuditId.get(Integer.valueOf(arr[0]));
						ErpAuditRuntime tmpRuntime = runtimeMap.get(auditId);
						if (tmpRuntime!=null) {
							BigDecimal leaveDay = countOneDay(tmpRuntime.getTargetStartTime(),tmpRuntime.getTargetEndTime(), DateTimeHelper.formatDateTimetoString(statist.getAttDate(), DateTimeHelper.FMT_yyyyMMdd), tmpRuntime.getTargetStartType().intValue(), tmpRuntime.getTargetEndType().intValue());
							if (leaveDay!=null && leaveDay.equals(BigDecimal.ONE)) {
								totalDay = BigDecimal.ONE;	
								isNotNeedCountConstom = true;
								break;
							}
						}
					}
				}
			
			}
		}
    	//这个时候再去生成一下
    	if (attCustomEditList.size()>0 && !isNotNeedCountConstom) {
    		if (Integer.valueOf(statist.getAttSumCount().toString()).equals(attCustomEditList.size())) {
    			return BigDecimal.ONE;
    		}
    		long totalMills = 0l;
    		for (Integer i:attCustomEditList) {
    			int onIndex = 2*i;
        		int offIndex = onIndex + 1;
        				Date tmpStartDate = DateTimeHelper.parseToDate(attConfigTimeArr.get(onIndex));
        		Date tmpEndDate = DateTimeHelper.parseToDate(attConfigTimeArr.get(offIndex));
        		totalMills = totalMills + ((tmpEndDate.getTime() - tmpStartDate.getTime())/1000);
        	
    		}
    		BigDecimal day = (totalMills+0.0)/totalAttendanceTime >0.5 ?BigDecimal.ONE:zeroPointFive;
    		totalDay = totalDay.add(day).compareTo(BigDecimal.ONE)>0?BigDecimal.ONE:totalDay.add(day);
    		
    	}
		return totalDay;
	}
    
	private BigDecimal countOneDay (Date targetStartTime,Date targetEndTime,String attDateStr,Integer leaveStartType,Integer leaveEndType) throws Exception{
		String sTime = DateTimeHelper.formatDateTimetoString(targetStartTime,DateTimeHelper.FMT_yyyyMMdd);
		String etime = DateTimeHelper.formatDateTimetoString(targetEndTime,DateTimeHelper.FMT_yyyyMMdd);
		List<String> dateStrList = DateUtil.getBetweenDays(sTime, etime);
		Map<String,BigDecimal> dateLeaveDayMap = new HashMap<String,BigDecimal>();
		dateStrList.forEach(dateStr -> {
			dateLeaveDayMap.put(dateStr, BigDecimal.ONE);
		});
		//如果考勤时间和起始时间或者是同一天，那么就有以下3个情况 情况1 请的上午 （两个时间是同一天，开始的上午 结束时的上午） 
		//情况2 请的下午，（（两个时间是同一天，开始的上午 结束时的上午））情况3 开始时间和结束时间不在一天，如果是结束时间和考勤日期相等，类型是上午，请假的上午 类型的是下午，请假整天 ，如果是开始时间是上午，请假整天，否则请假下午
		//开始日期和结束时间一样的情况下
		BigDecimal zeroPointFive = new BigDecimal("0.5");
		if (sTime.equals(etime)) {
			//如果开始是上午，结束是下午请假一天
			if (Integer.valueOf("1").equals(leaveStartType) && Integer.valueOf("2").equals(leaveEndType)) {
				dateLeaveDayMap.put(sTime, BigDecimal.ONE);
			} else if (Integer.valueOf("1").equals(leaveStartType)) {
				//说明请假上午
				dateLeaveDayMap.put(sTime, zeroPointFive);
			} else {
				//否则请假下午
				dateLeaveDayMap.put(etime, zeroPointFive);
			}
			//如果开始时间和结束时间不是同一天，如果开始时间是上午，则说明开始时间是请的一天
		} else if (Integer.valueOf("1").equals(leaveStartType)) {
			dateLeaveDayMap.put(sTime, BigDecimal.ONE);
			//如果结束时间请假的上午，说明结束时间请假为上午
			if (Integer.valueOf("1").equals(leaveEndType)) {
				dateLeaveDayMap.put(etime, zeroPointFive);
			} else {
				//否则结束时间请假也为一天
				dateLeaveDayMap.put(etime, BigDecimal.ONE);
			}
		} else if (Integer.valueOf("2").equals(leaveStartType)) {
			//如果开始时间是从下午开始，则说明开始时间请假0.5天
			dateLeaveDayMap.put(sTime, zeroPointFive);
			//如果结束时间请假为上午，则请假为半天
			if (Integer.valueOf("1").equals(leaveEndType)) {
				dateLeaveDayMap.put(etime, zeroPointFive);
			} else {
				//否则请假一天
				dateLeaveDayMap.put(etime, BigDecimal.ONE);
			}
		}
		return dateLeaveDayMap.get(attDateStr);
	}
	
    

}