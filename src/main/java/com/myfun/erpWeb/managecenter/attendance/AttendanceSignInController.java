package com.myfun.erpWeb.managecenter.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.attendance.vo.ErpOutLogVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAuditRuntimeMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceFestivalMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceRecordDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceStatisticsMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceUserClassDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpOutLogMapper;
import com.myfun.repository.erpdb.dto.AttendanceBaseInfoDto;
import com.myfun.repository.erpdb.dto.AttendanceLocationInfoDto;
import com.myfun.repository.erpdb.dto.AttendanceRecordResultDto;
import com.myfun.repository.erpdb.dto.AttendanceResultDto;
import com.myfun.repository.erpdb.dto.ErpOutLogDto;
import com.myfun.repository.erpdb.param.AttendanceBaseInfo;
import com.myfun.repository.erpdb.param.AttendanceSignInParam;
import com.myfun.repository.erpdb.param.OutLogRecordParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpFunAttendanceClass;
import com.myfun.repository.erpdb.po.ErpFunAttendanceFestival;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroup;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScope;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatistics;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunAttendanceRecordDetailService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 管理中心-打卡模块
 *
 * @Author heMingLi
 * @Date 2017-12-08
 * @Param
 */
@RestController
@RequestMapping("/managerCenter/attendanceSignInModule")
public class AttendanceSignInController extends BaseController {

	@Autowired
	ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	ErpFunAttendanceGroupMapper erpFunAttendanceGroupMapper;
	@Autowired
	ErpFunAttendanceClassMapper erpFunAttendanceClassMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;
	@Autowired
	ErpFunAttendanceScopeMapper erpFunAttendanceScopeMapper;
	@Autowired
	ErpFunAttendanceFestivalMapper erpFunAttendanceFestivalMapper;
	@Autowired
	ErpFunAttendanceRecordDetailService erpFunAttendanceRecordDetailService;
	@Autowired
	ErpFunAttendanceRecordDetailMapper erpFunAttendanceRecordDetailMapper;
	@Autowired
	ErpFunAttendanceStatisticsMapper erpFunAttendanceStatisticsMapper;
	@Autowired
	ErpOutLogMapper erpOutLogMapper;
	@Autowired
	ErpAuditRuntimeMapper erpAuditRuntimeMapper;

	/**
	 * 获取打卡基本信息
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	@RequestMapping("/getBaseInfo")
	public ErpResponseJson getBaseInfo(@Valid @RequestBody AttendanceBaseInfo attendanceBaseInfo) {
		Map<String, Object> map = new HashMap<>();
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer userId = attendanceBaseInfo.getUserId();
		Integer archiveId = null;
		if (userId == null) {
			userId = operator.getUserId();
			archiveId = operator.getArchiveId();
		} else {
			archiveId = erpFunUsersMapper.getUserInfoByUserId(cityId, userId).getArchiveId();
		}
		Long attDateTImestamp = attendanceBaseInfo.getAttDate();
		Date date = new Date();
		date.setTime(attDateTImestamp);
		String attDateStr = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd");
		String currentDate = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd");
		String isToday = null;//是否是当天
		Boolean isTodayFlag = attDateStr.equals(currentDate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);//当前时间的前一天之前的数据需要查询历史数据，因为打卡页面也会进这里，并且需要判断当前日期的最后一次是不是次日打卡
		ErpFunAttendanceStatistics statics = erpFunAttendanceStatisticsMapper.getAttendanceStatisticOffUser(cityId, compId, archiveId, attDateStr);
		boolean isHasStatics = statics == null?false:true;
		boolean flag = false;
		List<AttendanceRecordResultDto> resultList = new ArrayList<>();//班次打卡记录结果
		AttendanceResultDto attendanceResultDto = erpFunAttendanceRecordDetailService.getGreetingInfo();
		AttendanceBaseInfoDto baseInfoVo = new AttendanceBaseInfoDto();
		if (attDateStr.equals(DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd"))) {
			//判断当前这个人的打卡是否存在次日打卡
			flag = judgeAllowNeedNextDay(statics, DateTimeHelper.parseToDate(attDateStr));
		}
		if (!flag && DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd")).compareTo(DateTimeHelper.parseToDate(attDateStr)) >= 0) {
			createBeforeBaseInfo(cityId, compId, userId, archiveId, attDateStr, map, statics);
		} else {
			if (attDateStr.equals(currentDate)) {
				isToday = "1";
			} else {
				isToday = "0";
			}
			ErpFunAttendanceGroup attendanceGroup = null;//考勤组信息
			ErpFunAttendanceClass attendanceClass = null;//班次信息
			int upLimitTime = -2;//提前上班时间限制
			int downLimitTime = 6;//最迟下班打卡时间限制
			int attRest = 0;// 考勤配置
			Integer classId = null;//班次id
			// 激励语
			baseInfoVo.setIsToday(isToday);
			baseInfoVo.setStartGreeting(attendanceResultDto.getStartGreeting());
			baseInfoVo.setEndGreeting(attendanceResultDto.getEndGreeting());
			baseInfoVo.setStartPhotoUrl(CommonUtil.getPhotoUrl(attendanceResultDto.getStartPhotoUrl()));
			baseInfoVo.setEndPhotoUrl(CommonUtil.getPhotoUrl(attendanceResultDto.getEndPhotoUrl()));
			if ((isTodayFlag||flag) && isHasStatics) {
				classId = statics.getAttClassId();
				attendanceClass = new ErpFunAttendanceClass();
				attendanceClass.setCalssNumber(statics.getAttSumCount()==null?0:statics.getAttSumCount().intValue());
				attendanceClass.setClassName(statics.getAttClassName());
				attendanceClass.setClassType(statics.getAttClassType());
				attendanceClass.setId(classId);
				attendanceClass.setFirstUp(statics.getFirstWorkOnconfigtime());
				attendanceClass.setFirstDown(statics.getFirstWorkOffconfigtime());
				attendanceClass.setSecondUp(statics.getSecondWorkOnconfigtime());
				attendanceClass.setSecondDown(statics.getSecondWorkOffconfigtime());
				attendanceClass.setThreeUp(statics.getThreeWorkOnconfigtime());
				attendanceClass.setThreeDown(statics.getThreeWorkOffconfigtime());
				attendanceGroup = new ErpFunAttendanceGroup();
				attendanceGroup.setGroupName(statics.getAttGrName());
				attendanceGroup.setId(statics.getAttGrId());
				attendanceGroup.setClassType(statics.getAttClassType());
				
			} else {
				// 拿到用户的考勤组ID
				List<ErpFunAttendanceGroupBizPerson> groupByUserId = erpFunAttendanceGroupBizPersonMapper.findGroupByUserId(cityId, userId);
				if (null != groupByUserId && groupByUserId.size() > 0) {
					// 通过考勤组ID判断考勤类型
					attendanceGroup = erpFunAttendanceGroupMapper.findClassType(cityId, groupByUserId.get(0).getAttGroupId());
					//获取班次id
					classId = getAttClassId(compId, cityId, userId, date, attDateStr, attendanceGroup);
					attendanceClass = erpFunAttendanceClassMapper.getClassTime(classId, cityId);
				}
			}
			if (attendanceGroup!=null) {
				baseInfoVo.setGroupId(attendanceGroup.getId()==null?null:attendanceGroup.getId().toString());
				baseInfoVo.setGroupName(attendanceGroup.getGroupName());
				baseInfoVo.setAttType(attendanceGroup.getClassType()==null?null:attendanceGroup.getClassType().toString());
			}
			if (classId!= null) {
				if (Integer.valueOf(-1).equals(classId)) {
					attRest = 1;// 休息
				} else if (Integer.valueOf(0).equals(classId)) {
					attRest = 2;//班次配置还未生效
					setAttRecord(compId, cityId, userId, attDateStr, resultList);
				} else if (classId>0) {
					attRest = 0;// 不休息
					//考勤班次时间配置
					String[] configAttTimeArray = new String[]{attendanceClass.getFirstUp(), attendanceClass.getFirstDown(),
							attendanceClass.getSecondUp(), attendanceClass.getSecondDown(), attendanceClass.getThreeUp(), attendanceClass.getThreeDown()};
					//生成一天总共需要的打卡次数记录
					for (int i = 0; i < attendanceClass.getCalssNumber(); i++) {
						for (int j = 0; j < 2; j++) {//上班下班
							AttendanceRecordResultDto recordResultDto = new AttendanceRecordResultDto();
							//默认未就绪
							recordResultDto.setAttTimeResult(Const.TimeAttendanceResult.NOT_READY.toString());
							recordResultDto.setAttNum(String.valueOf(i + 1));
							recordResultDto.setAttAttribute(String.valueOf(j + 1));
							resultList.add(recordResultDto);
						}
					}
					//设置打卡记录状态
					setAttRecord(compId, cityId, userId, attDateStr, resultList);
					//打卡日期转换
					List<Date> currentAttDateList;
					currentAttDateList = changeAttTime(attendanceBaseInfo, attendanceClass);
					//设置当日打卡记录状态流程
					handleAttTimeResult(downLimitTime, resultList, currentAttDateList, attendanceClass.getCalssNumber());
					//统一添加上班配置时间
					for (int i = 0; i < resultList.size(); i++) {
						resultList.get(i).setAttConfigTime(configAttTimeArray[i]);
						//设置打卡限制时间
						if (i % 2 == 0) {
							resultList.get(i).setAttLimitTime(String.valueOf(DateTimeHelper.addHours(currentAttDateList.get(i), upLimitTime).getTime()));
						} else {
							resultList.get(i).setAttLimitTime(String.valueOf(DateTimeHelper.addHours(currentAttDateList.get(i), downLimitTime).getTime()));
						}
					}
				}
				baseInfoVo.setAttType(attendanceGroup.getClassType()==null?null:attendanceGroup.getClassType().toString());
				baseInfoVo.setClassId(String.valueOf(classId));
				if (null != attendanceClass) {
					baseInfoVo.setClassNumber(attendanceClass.getCalssNumber().toString());
				}
				if (attRest==3) {
					baseInfoVo.setAttRest("0");
				} else {
					baseInfoVo.setAttRest(String.valueOf(attRest));
				}
				map.put("baseInfo", baseInfoVo);
				map.put("attConfigLocationInfo", getAttendanceLocationInfoVo(compId, cityId, userId));
				map.put("attRecordList", resultList);
			} else {
				//无考勤组配置
				setAttRecord(compId, cityId, userId, attDateStr, resultList);
				map.put("baseInfo", baseInfoVo);
				map.put("attConfigLocationInfo", getAttendanceLocationInfoVo(compId, cityId, userId));
				map.put("attRecordList", resultList);
			}
		}	
		System.out.println(JSON.toJSONString(map));
		return ErpResponseJson.ok(map);
	}

	/**
	 * 创建考勤日期之前的考勤
	 *
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param archiveId
	 * @param attDateStr
	 * @param returnData
	 * @param statics
	 */
	private void createBeforeBaseInfo(Integer cityId, Integer compId, Integer userId, Integer archiveId, String attDateStr, Map<String, Object> returnData, ErpFunAttendanceStatistics statics) {
		if (statics == null) {
			AttendanceBaseInfoDto baseInfoVo = new AttendanceBaseInfoDto();
			baseInfoVo.setIsToday("0");
			baseInfoVo.setAttRest("2");
			returnData.put("baseInfo", baseInfoVo);
			return;
		}
		List<AttendanceRecordResultDto> resultList = new ArrayList<>();//班次打卡记录结果 
		Map<String, AttendanceRecordResultDto> resultMap = new HashMap<>();
		Byte attSumCount = statics.getAttSumCount();
		if (statics.getAttSumCount() == null) {
			AttendanceBaseInfoDto baseInfoVo = new AttendanceBaseInfoDto();
			baseInfoVo.setIsToday("0");
			baseInfoVo.setAttRest(String.valueOf(statics.getOffWork()));
			returnData.put("baseInfo", baseInfoVo);
			return;
		}
		setAttRecordOffHistory(compId, cityId, userId, attSumCount.toString(), statics.getOffWork().toString(), attDateStr, resultList, resultMap, returnData);
		if (!Byte.valueOf("1").equals(statics.getOffWork()) && !Byte.valueOf("2").equals(statics.getOffWork())) {
			if (Byte.valueOf("1").equals(attSumCount)) {
				createMissCardRecordOffOneClass(resultList, statics, resultMap);
			} else if (Byte.valueOf("2").equals(attSumCount)) {
				createMissCardRecordOffTwoClass(resultList, statics, resultMap);
			} else if (Byte.valueOf("3").equals(attSumCount)) {
				createMissCardRecordOffThreeClass(resultList, statics, resultMap);
			}
		}
		returnData.put("attRecordList", resultList);
	}

	/**
	 * 创建一轮上下班缺卡记录
	 */
	private void createMissCardRecordOffOneClass(List<AttendanceRecordResultDto> resultList, ErpFunAttendanceStatistics statistics, Map<String, AttendanceRecordResultDto> resultMap) {
		AttendanceRecordResultDto detailDto = null;
		detailDto = resultMap.get("1#1");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "1", "1", statistics.getFirstWorkOntime());
		}
		detailDto = resultMap.get("1#2");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "1", "2", statistics.getFirstWorkOfftime());
		}
	}

	/**
	 * 创建两轮上下班缺卡记录
	 */
	private void createMissCardRecordOffTwoClass(List<AttendanceRecordResultDto> resultList, ErpFunAttendanceStatistics statistics, Map<String, AttendanceRecordResultDto> resultMap) {
		createMissCardRecordOffOneClass(resultList, statistics, resultMap);
		AttendanceRecordResultDto detailDto = null;
		detailDto = resultMap.get("2#1");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "2", "1", statistics.getSecondWorkOntime());
		}
		detailDto = resultMap.get("2#2");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "2", "2", statistics.getSecondWorkOfftime());
		}
	}

	/**
	 * 创建三轮上下班缺卡记录
	 */
	private void createMissCardRecordOffThreeClass(List<AttendanceRecordResultDto> resultList, ErpFunAttendanceStatistics statistics, Map<String, AttendanceRecordResultDto> resultMap) {
		createMissCardRecordOffTwoClass(resultList, statistics, resultMap);
		AttendanceRecordResultDto detailDto = null;
		detailDto = resultMap.get("3#1");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "3", "1", statistics.getThreeWorkOntime());
		}
		detailDto = resultMap.get("3#2");
		if (detailDto == null) {
			createMissCardDtoReocord(resultList, "3", "2", statistics.getThreeWorkOfftime());
		}
	}

	private void createMissCardDtoReocord(List<AttendanceRecordResultDto> resultList, String attNum, String attAttribute, Date attConfigDate) {
		AttendanceRecordResultDto detailDto = new AttendanceRecordResultDto();
		detailDto.setAttAttribute(attAttribute);
		detailDto.setAttNum(attNum);
		detailDto.setAttTimeResult("0");
		detailDto.setAttLocationResult("1");
		detailDto.setAttFlag("0");
		detailDto.setAttConfigTime(DateTimeHelper.formatDateTimetoString(attConfigDate, DateTimeHelper.FMT_HHmm));
		resultList.add(detailDto);
	}

	/**
	 * @return
	 * @Param statistic 考勤汇总数据 attDate 考勤日
	 * 判断当天的打卡班次最后一次下班是否是次日打卡
	 */
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
	 * 获取考勤范围配置
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private List<AttendanceLocationInfoDto> getAttendanceLocationInfoVo(Integer compId, Integer cityId, Integer userId) {
		//基本考勤范围信息
		List<AttendanceLocationInfoDto> locationInfoDtoList = new ArrayList<>();
		List<Integer> scopeIdSet = new ArrayList<>();
		List<ErpFunAttendanceScopeBizPerson> scopeIdList = erpFunAttendanceScopeBizPersonMapper.getScopeId(cityId, userId);
		if (scopeIdList != null && scopeIdList.size() > 0) {
			for (ErpFunAttendanceScopeBizPerson bizPerson : scopeIdList) {
				scopeIdSet.add(bizPerson.getAttScopeId());
			}
			ErpFunAttendanceScopeExample scopeExample = new ErpFunAttendanceScopeExample();
			scopeExample.setShardCityId(cityId);
			scopeExample.createCriteria()
					.andAttScopeIdIn(scopeIdSet)
					.andIsDelEqualTo((byte) 0)
					.andCompIdEqualTo(compId);
			List<ErpFunAttendanceScope> erpFunAttendanceScopes = erpFunAttendanceScopeMapper.selectByExample(scopeExample);

			if (erpFunAttendanceScopes != null && erpFunAttendanceScopes.size() > 0) {
				for (ErpFunAttendanceScope scope : erpFunAttendanceScopes) {
					AttendanceLocationInfoDto locationInfoVo = new AttendanceLocationInfoDto();
					locationInfoVo.setAttDistance(scope.getAttDistance().toString()); //打卡范围
					locationInfoVo.setAttScopeX(scope.getAttScopeX()); //x坐标
					locationInfoVo.setAttScopeY(scope.getAttScopeY());// y坐标
					locationInfoVo.setLocationDesc(scope.getLocationDesc());// 全称
					locationInfoVo.setLocationDescAbb(scope.getLocationDescAbb());//简称
					locationInfoVo.setAttScopeId(scope.getAttScopeId().toString());
					locationInfoDtoList.add(locationInfoVo);
				}
			} else {
				throw new BusinessException("无考勤地点范围配置");
			}
		}
		return locationInfoDtoList;
	}

	/**
	 * 获取班次id
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private int getAttClassId(Integer compId, Integer cityId, Integer userId, Date date, String attDateStr, ErpFunAttendanceGroup attendanceGroup) {
		int classId = 0;
		switch (attendanceGroup.getClassType()) {
			case 1: // classType==1为固定班次
				//是否是特殊考勤日
				List<ErpFunAttendanceFestival> festivalDateClass = erpFunAttendanceFestivalMapper.getFestivalDateClass(cityId, attDateStr, compId);
				if (null != festivalDateClass && festivalDateClass.size() > 0) {
					classId = festivalDateClass.get(0).getAttClassId();
					break;
				} else {
					//是否是国家节假日
					List<ErpFunAttendanceFestival> festival = erpFunAttendanceFestivalMapper.getFestivalCount(cityId, attDateStr);
					if (null != festival && festival.size() > 0) {
						if (1 == attendanceGroup.getFestivals()) {
							classId = -1;
							break;
						}
					}
				}
				int week = DateTimeHelper.getDayOfWeek(date);
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
					default:
						break;
				}
				break;
			case 2:  // 如果是排班制
				List<ErpFunAttendanceUserClassDetail> funAttendanceUserClassDetails = erpFunAttendanceUserClassDetailMapper.getClassId(cityId, compId, attendanceGroup.getId(), userId, attDateStr);
				if (null != funAttendanceUserClassDetails && funAttendanceUserClassDetails.size() > 0) {
					classId = funAttendanceUserClassDetails.get(0).getAttClassId();
				} else {
					classId = 0;
				}
				break;
			default:
				break;
		}
		return classId;
	}

	/**
	 * 设置打卡记录
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private void setAttRecord(Integer compId, Integer cityId, Integer userId, String attDateStr, List<AttendanceRecordResultDto> resultList) {
		//打卡记录查询，更新当天打卡记录流程信息
		List<ErpFunAttendanceRecordDetail> attendanceRecordDetailList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordDetailList(cityId, compId, userId, attDateStr, null, null);
		if (null != attendanceRecordDetailList && attendanceRecordDetailList.size() > 0) {
			for (ErpFunAttendanceRecordDetail recordDetail : attendanceRecordDetailList) {
				AttendanceRecordResultDto resultDto = null;
				if (recordDetail.getAttRest() != null && 2 != recordDetail.getAttRest()) {//有配置考勤组数据
					if (recordDetail.getAttAttribute() != null && 1 == recordDetail.getAttAttribute()) {
						resultDto = resultList.get(recordDetail.getAttNum() * 2 - 2);
						setAttRecord(resultDto, recordDetail);
					} else {
						resultDto = resultList.get(recordDetail.getAttNum() * 2 - 1);
						setAttRecord(resultDto, recordDetail);
					}
				} else {//没有配置考勤组数据
					resultDto = new AttendanceRecordResultDto();
					resultDto.setAttId(recordDetail.getAttId().toString());
					resultDto.setAttTimeResult(recordDetail.getManageTimeAttResult().toString());
					resultDto.setAttLocalTime(String.valueOf(recordDetail.getLocalAttTime().getTime()));
					resultDto.setAttLocationResult(recordDetail.getManageLocationAttResult().toString());
					resultDto.setAttAttribute(recordDetail.getAttAttribute().toString());
					resultDto.setAttNum(recordDetail.getAttNum().toString());
					resultDto.setLocationDesc(recordDetail.getLocationDesc());
					resultDto.setAttRemark(recordDetail.getAttRemark());
					if (recordDetail.getExtraExist() != null && 1 == recordDetail.getExtraExist()) {
						resultDto.setExtraPath(recordDetail.getExtraPath());
					}
					resultDto.setAttFlag("1");
					resultList.add(resultDto);
				}
			}
		}
	}

	/**
	 * 设置历史打卡记录
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private void setAttRecordOffHistory(Integer compId, Integer cityId, Integer userId, String attSumCount, String attRest, String attDateStr, List<AttendanceRecordResultDto> resultList, Map<String, AttendanceRecordResultDto> resultMap, Map<String, Object> returnData) {
		//打卡记录查询，更新当天打卡记录流程信息
		AttendanceBaseInfoDto baseInfoVo = new AttendanceBaseInfoDto();
		baseInfoVo.setIsToday("0");
		baseInfoVo.setClassNumber(attSumCount);
		if ("3".equals(attRest)) {
			baseInfoVo.setAttRest("0");
		} else {
			baseInfoVo.setAttRest(attRest);
		}
		List<ErpFunAttendanceRecordDetail> attendanceRecordDetailList = erpFunAttendanceRecordDetailMapper.getAttendanceRecordDetailList(cityId, compId, userId, attDateStr, null, null);
		if (null != attendanceRecordDetailList && attendanceRecordDetailList.size() > 0) {
			String groupName = null;
			for (ErpFunAttendanceRecordDetail recordDetail : attendanceRecordDetailList) {
				AttendanceRecordResultDto resultDto = null;
				resultDto = new AttendanceRecordResultDto();
				if (recordDetail.getConfigAttTime() != null) {
					resultDto.setAttConfigTime(DateTimeHelper.formatDateTimetoString(recordDetail.getConfigAttTime(), DateTimeHelper.FMT_HHmm));
				}
				resultDto.setAttId(recordDetail.getAttId().toString());
				resultDto.setAttTimeResult(recordDetail.getManageTimeAttResult().toString());
				resultDto.setAttLocalTime(String.valueOf(recordDetail.getLocalAttTime()==null?"":recordDetail.getLocalAttTime().getTime()));
				resultDto.setAttLocationResult(recordDetail.getManageLocationAttResult().toString());
				resultDto.setAttAttribute(recordDetail.getAttAttribute().toString());
				resultDto.setAttNum(recordDetail.getAttNum().toString());
				resultDto.setLocationDesc(recordDetail.getLocationDesc());
				resultDto.setAttRemark(recordDetail.getAttRemark());
				if (recordDetail.getExtraExist() != null && 1 == recordDetail.getExtraExist()) {
					resultDto.setExtraPath(recordDetail.getExtraPath());
				}
				resultDto.setAttFlag("1");
				resultList.add(resultDto);
				groupName = recordDetail.getAttGroupName();
				if (resultMap != null) {
					//用打卡轮数和上下班标志作为每条数据的key
					String key = resultDto.getAttNum() + "#" + resultDto.getAttAttribute();
					resultMap.put(key, resultDto);
				}
			}
			baseInfoVo.setGroupName(groupName);
		}
		returnData.put("baseInfo", baseInfoVo);
	}

	/**
	 * 处理考勤日期状态
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */

	private void handleAttTimeResult(int downLimitTime, List<AttendanceRecordResultDto> resultList, List<Date> currentAttDateList, int classNumber) {
		for (int i = 0; i < resultList.size(); i++) {
			AttendanceRecordResultDto resultDto = resultList.get(i);
			if (!"1".equals(resultDto.getAttFlag())) {
				//上班打卡时，当前时间在下班之前可以打卡，之后就为缺卡
				if ("1".equals(resultDto.getAttAttribute())) {//上班
					if (DateTimeHelper.compareTwoDate(new Date(), currentAttDateList.get(Integer.parseInt(resultDto.getAttNum()) * 2 - 1)) > 0) {
						updateTimeAttResult(resultList, i);
						resultDto.setAttTimeResult(Const.TimeAttendanceResult.WAITE_WORK.toString());
						break;
					} else {
						resultDto.setAttTimeResult(Const.TimeAttendanceResult.LACK_OF_CARD.toString());
					}
				} else {//下班
					updateTimeAttResult(resultList, i);
					//超过了限制下班打卡时间
					if (DateTimeHelper.compareTwoDate(DateTimeHelper.addHours(currentAttDateList.get(i), downLimitTime), new Date()) > 0) {
						resultDto.setAttTimeResult(Const.TimeAttendanceResult.LACK_OF_CARD.toString());
					} else {
						resultDto.setAttTimeResult(Const.TimeAttendanceResult.WAITE_WORK.toString());
						//不是最后一次下班，且下班时间在上班时间之前，跳出循环
						if (i != classNumber * 2 - 1 && DateTimeHelper.compareTwoDate(new Date(), currentAttDateList.get(i + 1)) > 0) {
							break;
						}
					}
				}
			} else {
				updateTimeAttResult(resultList, i);
			}
		}
	}

	/**
	 * 逻辑上处理为缺卡
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private void updateTimeAttResult(List<AttendanceRecordResultDto> resultList, int i) {
		for (int j = 0; j < i; j++) {
			if (Const.TimeAttendanceResult.WAITE_WORK.toString().equals(resultList.get(j).getAttTimeResult())) {
				resultList.get(j).setAttTimeResult(Const.TimeAttendanceResult.LACK_OF_CARD.toString());
			}
		}
	}


	/**
	 * 转换当天配置打卡日期
	 *
	 * @Author heMingLi
	 * @Date 2017-12-08
	 */
	private List<Date> changeAttTime(AttendanceBaseInfo attendanceBaseInfo, ErpFunAttendanceClass attendanceClass) {
		ArrayList<Date> currentAttDateList = new ArrayList<>();
		for (int i = 0; i < attendanceClass.getCalssNumber(); i++) {
			String attendanceUpTime = "00:00";// 上班考勤时间
			String attendanceDownTime = "00:00";// 下班考勤时间
			Date currentAttUpDate;//当前上班时间date
			Date currentAttDownDate;//当前下班时间date
			int downTimeCompareUpTime;//是否是跨日上班
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			switch (i + 1) {// 获取打卡班次打卡时间
				case 1:
					attendanceUpTime = attendanceClass.getFirstUp();
					attendanceDownTime = attendanceClass.getFirstDown();
					break;
				case 2:
					attendanceUpTime = attendanceClass.getSecondUp();
					attendanceDownTime = attendanceClass.getSecondDown();
					break;
				case 3:
					attendanceUpTime = attendanceClass.getThreeUp();
					attendanceDownTime = attendanceClass.getThreeDown();
					break;
			}
			try {
				downTimeCompareUpTime = DateTimeHelper.compareTwoDate(DateTimeHelper.parseToDate(attendanceDownTime, "HH:mm"),
						DateTimeHelper.parseToDate(attendanceUpTime, "HH:mm"));
				//是否是跨日下班
				if (downTimeCompareUpTime < 0) {// 当日下班 18:00 -20:00
					currentAttUpDate = DateTimeHelper
							.parseToDate(sdf.format(attendanceBaseInfo.getAttDate()) + " "
									+ attendanceUpTime, "yyyy-MM-dd HH:mm");
					currentAttDownDate = DateTimeHelper
							.parseToDate(sdf.format(attendanceBaseInfo.getAttDate()) + " "
									+ attendanceDownTime, "yyyy-MM-dd HH:mm");

				} else {// 跨日下班 22:00 -04:00
					currentAttUpDate = DateTimeHelper
							.parseToDate(sdf.format(attendanceBaseInfo.getAttDate()) + " "
									+ attendanceUpTime, "yyyy-MM-dd HH:mm");
					currentAttDownDate = DateTimeHelper.addDays(DateTimeHelper
							.parseToDate(sdf.format(attendanceBaseInfo.getAttDate()) + " "
									+ attendanceDownTime, "yyyy-MM-dd HH:mm"), 1);
				}

				currentAttDateList.add(currentAttUpDate);
				currentAttDateList.add(currentAttDownDate);
			} catch (ParseException e) {
				throw new BusinessException("打卡时间错误");
			}

		}
		return currentAttDateList;
	}

	/**
	 * 设置考勤记录
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	private void setAttRecord(AttendanceRecordResultDto recordResultDto, ErpFunAttendanceRecordDetail recordDetail) {
		Date localAttTime = recordDetail.getLocalAttTime();
		if (localAttTime!=null) {
			recordResultDto.setAttLocalTime(String.valueOf(localAttTime.getTime()));
		}
		recordResultDto.setAttId(recordDetail.getAttId().toString());
		recordResultDto.setAttTimeResult(recordDetail.getManageTimeAttResult().toString());
		recordResultDto.setAttLocationResult(recordDetail.getManageLocationAttResult().toString());
		recordResultDto.setAttAttribute(recordDetail.getAttAttribute().toString());
		recordResultDto.setAttNum(recordDetail.getAttNum().toString());
		recordResultDto.setLocationDesc(recordDetail.getLocationDesc());
		recordResultDto.setAttRemark(recordDetail.getAttRemark());
		if (recordDetail.getExtraExist() != null && 1 == recordDetail.getExtraExist()) {
			recordResultDto.setExtraPath(recordDetail.getExtraPath());
		}
		recordResultDto.setAttFlag("1");
	}

	/**
	 * 考勤打卡
	 *
	 * @author hemingli
	 * @2017-11-28
	 **/
	@RequestMapping("/signIn")
	public ResponseJson signIn(@Valid @RequestBody AttendanceSignInParam attendanceSignInParam) {
		Operator operator = getOperator();
		AttendanceResultDto attendanceResultDto = erpFunAttendanceRecordDetailService.insertAttendanceRecord(
				operator.getCityId(),
				operator.getUserId(),
				operator.getCompId(),
				operator.getAreaId(),
				operator.getRegId(),
				operator.getDeptId(),
				operator.getGrId(),
				attendanceSignInParam);
		return ErpResponseJson.ok(attendanceResultDto);
	}
	
	/**
	 * 外出登记统计
	 * @author 朱科
	 * @since 2018年7月18日
	 * @return
	 */
	@ApiOperation(value = "获取审核类型列表")
	@ApiResponses(
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpOutLogVo.class, message = "成功")
	)
	@RequestMapping("/getOutLog")
	public ResponseJson getOutLog(@RequestBody OutLogRecordParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setNewOrg(operator.newOrganizationType());
		List<ErpOutLogDto> outLogRecordList = erpOutLogMapper.getOutLogRecordList(cityId, compId, param);
		if (null == outLogRecordList || outLogRecordList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<Integer> auditIdList = outLogRecordList.stream().collect(Collectors.mapping(ErpOutLogDto::getAuditId, Collectors.toList()));
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.selectListByIds(cityId, compId, auditIdList);
		Map<Integer, Integer> auditTypeMap = auditRuntimeList.stream().collect(Collectors.toMap(ErpAuditRuntime::getId, ErpAuditRuntime::getAuditType));
		for (ErpOutLogDto erpOutLogDto : outLogRecordList) {
			Integer auditType = auditTypeMap.get(erpOutLogDto.getAuditId());
			if (null != auditType) {
				erpOutLogDto.setAuditType(auditType);
			}
			String backTime = erpOutLogDto.getBackTime();
			String outTime = erpOutLogDto.getOutTime();
			if(StringUtil.isNotBlank(backTime)){
				Double hoursOfTwoDate = DateTimeHelper.getMinutesOfTwoDate(DateTimeHelper.parseToDate(backTime), DateTimeHelper.parseToDate(outTime));
				erpOutLogDto.setRealTime(hoursOfTwoDate.intValue());
			}
		}
		return ErpResponseJson.ok(outLogRecordList);
	}
}
