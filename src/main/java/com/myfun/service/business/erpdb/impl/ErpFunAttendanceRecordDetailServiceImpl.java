package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminAttendanceScanningRecordMapper;
import com.myfun.repository.admindb.dao.AdminFunAttSceneMapper;
import com.myfun.repository.admindb.dao.AdminFunAttStimulateImgMapper;
import com.myfun.repository.admindb.dao.AdminFunAttStimulateLangMapper;
import com.myfun.repository.admindb.po.AdminAttendanceScanningRecord;
import com.myfun.repository.admindb.po.AdminFunAttScene;
import com.myfun.repository.admindb.po.AdminFunAttStimulateImg;
import com.myfun.repository.admindb.po.AdminFunAttStimulateLang;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.AttendanceResultDto;
import com.myfun.repository.erpdb.param.AttendanceSignInParam;
import com.myfun.repository.erpdb.param.ChangeAttendanceResultParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceRecordDetailService;
import com.myfun.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scala.annotation.meta.param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ErpFunAttendanceRecordDetailServiceImpl
		extends AbstractService<ErpFunAttendanceRecordDetail, ErpFunAttendanceRecordDetail>
		implements ErpFunAttendanceRecordDetailService {
	@Autowired
	ErpFunAttendanceRecordDetailMapper erpFunAttendanceRecordDetailMapper;
	@Autowired
	ErpFunAttendanceStatisticsMapper erpFunAttendanceStatisticsMapper;
	@Autowired
	ErpFunAttendanceClassMapper erpFunAttendanceClassMapper;
	@Autowired
	ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;
	@Autowired
	ErpFunAttendanceScopeMapper erpFunAttendanceScopeMapper;
	@Autowired
	ErpFunAttendanceParamMapper erpFunAttendanceParamMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminFunAttSceneMapper adminFunAttSceneMapper;
	@Autowired
	AdminFunAttStimulateImgMapper adminFunAttStimulateImgMapper;
	@Autowired
	AdminFunAttStimulateLangMapper adminFunAttStimulateLangMapper;
	@Autowired
	ErpFunAttendanceExtraMapper erpFunAttendanceExtraMapper;
	@Autowired
	AdminAttendanceScanningRecordMapper adminAttendanceScanningRecordMapper;
	@Autowired
	ErpAttendanceChangeRecordMapper erpAttendanceChangeRecordMapper;


	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceRecordDetailMapper;
	}

	/**
	 * 考勤打卡
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	@Transactional
	@Override
	public AttendanceResultDto insertAttendanceRecord(Integer cityId, Integer userId, Integer compId, Integer areaId,
													  Integer regId, Integer deptId, Integer grId, AttendanceSignInParam attendanceSignInParam) {
		Date date = new Date();
		date.setTime(Long.parseLong(attendanceSignInParam.getLocalAttTime()));
		ErpFunAttendanceRecordDetailExample erpFunAttendanceRecordDetailExample = new ErpFunAttendanceRecordDetailExample();
		erpFunAttendanceRecordDetailExample.setShardCityId(cityId);
		try {
			erpFunAttendanceRecordDetailExample.createCriteria()
					.andDeviceIdEqualTo(getAttDeviceId(attendanceSignInParam.getDeviceId()))
					.andCreateTimeLessThan(date)
					.andCreateTimeGreaterThan(DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(date), DateTimeHelper.FMT_yyyyMMdd));
		} catch (ParseException e) {
			throw new BusinessException("打卡日期出错");
		}
		List<ErpFunAttendanceRecordDetail> attendanceRecordDetailList = erpFunAttendanceRecordDetailMapper.selectByExample(erpFunAttendanceRecordDetailExample);
		if (attendanceRecordDetailList != null && attendanceRecordDetailList.size() > 0) {
			if (!attendanceRecordDetailList.get(0).getUserId().equals(userId)) {
				throw new BusinessException("同一手机不能同时对多个帐号进行打卡");
			}
		}
		// 地点考勤打卡结果状态，默认正常（没有配置打卡地点）
		byte locationAttResult = 1;
		// 时间考勤打卡结果状态，默认正常（没有配置打卡时间）
		byte timeAttResult = 4;
		String attClassName = null;
		if (!"2".equals(attendanceSignInParam.getAttRest())) {//有考勤配置
			ErpFunAttendanceClass attendanceClass = null;
			ErpFunAttendanceStatistics statics = erpFunAttendanceStatisticsMapper.getAttendanceStatisticOffUser(cityId, compId, attendanceSignInParam.getArchiveId(), DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMdd));
			if (statics!=null) {
				attClassName = statics.getAttClassName();
				attendanceClass = new ErpFunAttendanceClass();
				switch (attendanceSignInParam.getAttNum()) {// 获取打卡班次打卡时间
				case "1":
					attendanceClass.setFirstUp(statics.getFirstWorkOnconfigtime());
					attendanceClass.setFirstDown(statics.getFirstWorkOffconfigtime());
					break;
				case "2":
					attendanceClass.setSecondUp(statics.getSecondWorkOnconfigtime());
					attendanceClass.setSecondDown(statics.getSecondWorkOffconfigtime());
					break;
				case "3":
					attendanceClass.setThreeUp(statics.getThreeWorkOnconfigtime());
					attendanceClass.setThreeDown(statics.getThreeWorkOffconfigtime());
					break;
				}
			} else {
				ErpFunAttendanceClassExample classExample = new ErpFunAttendanceClassExample();
				classExample.setShardCityId(cityId);
				classExample.createCriteria()
				.andIdEqualTo(Integer.parseInt(attendanceSignInParam.getAttClassId()))
				.andCompIdEqualTo(compId)
				.andDelFlagEqualTo(((byte) 0));
				classExample.setOrderByClause("CREATE_TIME DESC");
				List<ErpFunAttendanceClass> erpFunAttendanceClasses = erpFunAttendanceClassMapper.selectByExample(classExample);
				attendanceClass = erpFunAttendanceClasses.get(0);
			}
			// 查询考勤班次信息
			if (attendanceClass != null) {
				attClassName = attendanceClass.getClassName();
				timeAttResult = handleDateAttendance(cityId, compId, attendanceSignInParam, attendanceClass);
			} else {
				throw new BusinessException("无班次记录");
			}
		} else {
			Integer attSumCount = StringUtil.parseInteger(attendanceSignInParam.getAttSumCount(), 0);
			attSumCount = attSumCount == 0 ? 3 : attSumCount;
			attendanceSignInParam.setAttSumCount(attSumCount.toString());
		}
		// 查询个人考勤范围详细数据
		locationAttResult = getLocationAttResult(cityId, attendanceSignInParam);
		if (StringUtil.isEmpty(attendanceSignInParam.getAttId())) {
			//普通打卡,插入打卡数据
			insertAttendanceRecordData(cityId, userId, compId, areaId, regId, deptId, grId, attendanceSignInParam, attClassName, locationAttResult, timeAttResult);
		} else {
			//更新打卡
			updateAttendanceRecord(cityId, attendanceSignInParam, locationAttResult, timeAttResult);
		}
		/*
		 * 打卡结果
		 */
		AttendanceResultDto attendanceResultDto = new AttendanceResultDto();
		attendanceResultDto.setLocationAttStatus(String.valueOf(locationAttResult));
		attendanceResultDto.setTimeAttResult(String.valueOf(timeAttResult));
		attendanceResultDto.setServerAttTime(attendanceSignInParam.getLocalAttTime());
		/*
		 * 激励语
		 */
		AttendanceResultDto greetingInfo = getGreetingInfo();
		attendanceResultDto.setStartGreeting(greetingInfo.getStartGreeting());
		attendanceResultDto.setEndGreeting(greetingInfo.getEndGreeting());

		attendanceResultDto.setStartPhotoUrl(CommonUtil.getPhotoUrl(greetingInfo.getStartPhotoUrl()));
		attendanceResultDto.setEndPhotoUrl(CommonUtil.getPhotoUrl(greetingInfo.getEndPhotoUrl()));
		return attendanceResultDto;
	}

	/**
	 * 获取地点考勤结果
	 *
	 * @author hemingli
	 * @2017-12-13
	 */
	private byte getLocationAttResult(Integer cityId, AttendanceSignInParam attendanceSignInParam) {
		byte locationAttResult;
		if (attendanceSignInParam.getAttScopeId() != null) {
			ErpFunAttendanceScopeExample erpFunAttendanceScopeExample = new ErpFunAttendanceScopeExample();
			erpFunAttendanceScopeExample.setShardCityId(cityId);
			erpFunAttendanceScopeExample.createCriteria()
					.andAttScopeIdEqualTo(Integer.parseInt(attendanceSignInParam.getAttScopeId()))
					.andIsDelEqualTo((byte) 0);
			erpFunAttendanceScopeExample.setOrderByClause("CREATE_TIME DESC");

			List<ErpFunAttendanceScope> erpFunAttendanceScopes = erpFunAttendanceScopeMapper
					.selectByExample(erpFunAttendanceScopeExample);

			if (null == erpFunAttendanceScopes || erpFunAttendanceScopes.size() == 0) {
				throw new BusinessException("考勤范围记录出错");
			} else {
				locationAttResult = handleLocationAttendance(attendanceSignInParam, erpFunAttendanceScopes);
			}
		} else {
			locationAttResult = 1;
		}

		return locationAttResult;
	}

	/**
	 * 截取设备id
	 *
	 * @param deviceId 设备id
	 * @author hemingli
	 * @2017-12-13
	 */
	private String getAttDeviceId(String deviceId) {
		return deviceId.length() > 20 ?
				deviceId.substring(0, deviceId.length()) : deviceId;
	}


	/**
	 * 插入数据
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	private void insertAttendanceRecordData(Integer cityId, Integer userId, Integer compId, Integer areaId,
											Integer regId, Integer deptId, Integer grId, AttendanceSignInParam attendanceSignInParam, String attClassName,
											byte locationAttResult, byte timeAttResult) {
		ErpFunAttendanceRecordDetail erpFunAttendanceRecordDetail = new ErpFunAttendanceRecordDetail();
		erpFunAttendanceRecordDetail.setArchiveId(attendanceSignInParam.getArchiveId());
		erpFunAttendanceRecordDetail.setShardCityId(cityId);
		erpFunAttendanceRecordDetail.setCompId(compId);
		erpFunAttendanceRecordDetail.setUserId(userId);
		erpFunAttendanceRecordDetail.setAreaId(areaId);
		erpFunAttendanceRecordDetail.setRegId(regId);
		erpFunAttendanceRecordDetail.setDeptId(deptId);
		erpFunAttendanceRecordDetail.setGrId(grId);
		erpFunAttendanceRecordDetail.setCityId(cityId);
		erpFunAttendanceRecordDetail.setCreateTime(new Date());
		erpFunAttendanceRecordDetail.setServerAttTime(new Date());
		// 地点考勤结果
		erpFunAttendanceRecordDetail.setLocationAttResult(locationAttResult);
		erpFunAttendanceRecordDetail.setManageLocationAttResult(locationAttResult);
		// 时间考勤结果
		erpFunAttendanceRecordDetail.setTimeAttResult(timeAttResult);
		erpFunAttendanceRecordDetail.setManageTimeAttResult(timeAttResult);
		//迟到早退时间
		erpFunAttendanceRecordDetail.setBelateMinute(attendanceSignInParam.getBelateMinute());
		/*
		 * 打卡地点信息
		 */
		erpFunAttendanceRecordDetail.setLocalAttTime(new Date(Long.parseLong(attendanceSignInParam.getLocalAttTime())));
		erpFunAttendanceRecordDetail.setLocationDesc(attendanceSignInParam.getLocationDesc());
		erpFunAttendanceRecordDetail.setAttAttribute(Byte.valueOf(attendanceSignInParam.getAttAttribute()));
		erpFunAttendanceRecordDetail.setAttRest(StringUtil.isEmpty(attendanceSignInParam.getAttRest()) ? (byte) 2 : Byte.parseByte(attendanceSignInParam.getAttRest()));
		erpFunAttendanceRecordDetail.setOffLineUpload(StringUtil.isEmpty(attendanceSignInParam.getOffLineUpload()) ? (byte) 0 : Byte.parseByte(attendanceSignInParam.getOffLineUpload()));
		erpFunAttendanceRecordDetail.setAttResultWeight(computeAttResultOffWeight(timeAttResult, locationAttResult).byteValue());
		try {
			erpFunAttendanceRecordDetail.setAttOughtDate(DateTimeHelper.parseToDate(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(attendanceSignInParam.getCurrentAttDate())), "yyyy-MM-dd"));
		} catch (ParseException e) {
			throw new BusinessException("打卡日期出错");
		}
		erpFunAttendanceRecordDetail.setAttX(attendanceSignInParam.getAttendanceX());
		erpFunAttendanceRecordDetail.setAttY(attendanceSignInParam.getAttendanceY());
		/*
		 * 考勤组和班次信息
		 */
		erpFunAttendanceRecordDetail.setAttClassId(Integer.valueOf(attendanceSignInParam.getAttClassId()));
		erpFunAttendanceRecordDetail.setAttNum(Byte.valueOf(attendanceSignInParam.getAttNum()));
		erpFunAttendanceRecordDetail.setAttSumCount(Byte.valueOf(attendanceSignInParam.getAttSumCount()));
		erpFunAttendanceRecordDetail.setAttGrId(Integer.valueOf(attendanceSignInParam.getAttGrId()));
		erpFunAttendanceRecordDetail.setAttType((Byte.valueOf(attendanceSignInParam.getAttType())));
		if( attendanceSignInParam.getAttScopeId()!=null) {
			erpFunAttendanceRecordDetail.setAttScopeId(Integer.valueOf(attendanceSignInParam.getAttScopeId()));
		}
		erpFunAttendanceRecordDetail.setAttClassName(attClassName);
		erpFunAttendanceRecordDetail.setAttGroupName(attendanceSignInParam.getGroupName());

		//上传图片文件处理
		if (!StringUtil.isEmpty(attendanceSignInParam.getExtraType())) {
			erpFunAttendanceRecordDetail.setExtraType(Byte.valueOf(attendanceSignInParam.getExtraType()));
			erpFunAttendanceRecordDetail.setExtraPath(attendanceSignInParam.getExtraPath());
			erpFunAttendanceRecordDetail.setExtraExist((byte) 1);
		}
		//备注
		erpFunAttendanceRecordDetail.setAttRemark(attendanceSignInParam.getAttRemark());
		/*
		 * 打卡设备相关
         */
		erpFunAttendanceRecordDetail.setDeviceId(getAttDeviceId(attendanceSignInParam.getDeviceId()));
		erpFunAttendanceRecordDetail.setDeviceName(attendanceSignInParam.getDeviceName());
		erpFunAttendanceRecordDetail.setDeviceType(Byte.valueOf(attendanceSignInParam.getDeviceType()));

        /*
		 * 考勤地点，范围 上下班时间段配置
         */
		erpFunAttendanceRecordDetail.setAttConfigDistance(Double.valueOf(attendanceSignInParam.getAttConfigDistance()).intValue());
		erpFunAttendanceRecordDetail.setAttConfigLocation(attendanceSignInParam.getAttConfigLocation());
		erpFunAttendanceRecordDetail.setAttClassClocktime(attendanceSignInParam.getAttClassClockTime());
		erpFunAttendanceRecordDetail.setConfigAttTime(attendanceSignInParam.getAttConfigTimeDate());
		erpFunAttendanceRecordDetailMapper.insertSelective(erpFunAttendanceRecordDetail);
		//插入附件信息
		if (erpFunAttendanceRecordDetail.getExtraExist() != null && 1 == erpFunAttendanceRecordDetail.getExtraExist()) {
			ErpFunAttendanceExtra erpFunAttendanceExtra = new ErpFunAttendanceExtra();
			erpFunAttendanceExtra.setShardCityId(cityId);
			erpFunAttendanceExtra.setAttId(erpFunAttendanceRecordDetail.getAttId());
			erpFunAttendanceExtra.setFilePath(erpFunAttendanceRecordDetail.getExtraPath());
			erpFunAttendanceExtra.setResultful((byte) 1);
			erpFunAttendanceExtra.setExtraType(erpFunAttendanceRecordDetail.getExtraType().intValue());
			erpFunAttendanceExtra.setCreateTime(new Date());
			erpFunAttendanceExtraMapper.insertSelective(erpFunAttendanceExtra);
		}

	}

	/**
	 * 更新数据
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	private void updateAttendanceRecord(Integer cityId, AttendanceSignInParam attendanceSignInParam, byte locationAttResult, byte timeAttResult) {
		ErpFunAttendanceRecordDetailExample erpFunAttendanceRecordDetailExample = new ErpFunAttendanceRecordDetailExample();
		erpFunAttendanceRecordDetailExample.setShardCityId(cityId);
		erpFunAttendanceRecordDetailExample.setOrderByClause("CREATE_TIME DESC");
		erpFunAttendanceRecordDetailExample.createCriteria().andAttIdEqualTo(Integer.parseInt(attendanceSignInParam.getAttId()));
		List<ErpFunAttendanceRecordDetail> attendanceRecordDetailList = erpFunAttendanceRecordDetailMapper.selectByExample(erpFunAttendanceRecordDetailExample);
		if (null != attendanceRecordDetailList) {
			ErpFunAttendanceRecordDetail recordDetail = attendanceRecordDetailList.get(0);
			verifyAttTime(timeAttResult, recordDetail.getManageTimeAttResult());
			recordDetail.setShardCityId(cityId);
			recordDetail.setServerAttTime(new Date());
			// 更新地点考勤结果
			recordDetail.setLocationAttResult(locationAttResult);
			recordDetail.setManageLocationAttResult(locationAttResult);
			//更新时间考勤结果
			recordDetail.setTimeAttResult(timeAttResult);
			recordDetail.setManageTimeAttResult(timeAttResult);
			//更新迟到早退时间
			recordDetail.setBelateMinute(attendanceSignInParam.getBelateMinute());

			/*
			 * 更新打卡地点信息
		     */
			recordDetail.setLocalAttTime(new Date(Long.parseLong(attendanceSignInParam.getLocalAttTime())));
			recordDetail.setLocationDesc(attendanceSignInParam.getLocationDesc());
			recordDetail.setOffLineUpload(StringUtil.isEmpty(attendanceSignInParam.getOffLineUpload()) ? (byte) 0 : Byte.parseByte(attendanceSignInParam.getOffLineUpload()));
			recordDetail.setAttX(attendanceSignInParam.getAttendanceX());
			recordDetail.setAttY(attendanceSignInParam.getAttendanceY());
			recordDetail.setAttResultWeight(computeAttResultOffWeight(timeAttResult, locationAttResult).byteValue());

			//更新图片文件处理
			if (!StringUtil.isEmpty(attendanceSignInParam.getExtraType())) {
				recordDetail.setExtraType(Byte.valueOf(attendanceSignInParam.getExtraType()));
				recordDetail.setExtraPath(attendanceSignInParam.getExtraPath());
				recordDetail.setExtraExist((byte) 1);
			} else {
				recordDetail.setExtraExist((byte) 0);
			}
			//更新备注
			recordDetail.setAttRemark(attendanceSignInParam.getAttRemark());
			erpFunAttendanceRecordDetailMapper.updateByPrimaryKeySelective(recordDetail);
			//更新附件
			List<ErpFunAttendanceExtra> erpFunAttendanceExtras = erpFunAttendanceExtraMapper.selectByAttId(cityId, recordDetail.getAttId());
			if (null != erpFunAttendanceExtras && erpFunAttendanceExtras.size() > 0) {
				ErpFunAttendanceExtra erpFunAttendanceExtra = erpFunAttendanceExtras.get(0);
				erpFunAttendanceExtra.setShardCityId(cityId);
				if (recordDetail.getExtraExist() != null && 1 == recordDetail.getExtraExist()) {
					erpFunAttendanceExtra.setAttId(recordDetail.getAttId());
					erpFunAttendanceExtra.setFilePath(recordDetail.getExtraPath());
					erpFunAttendanceExtra.setResultful((byte) 1);
					erpFunAttendanceExtra.setExtraType(recordDetail.getExtraType().intValue());
				} else {
					erpFunAttendanceExtra.setResultful((byte) 0);
				}
				erpFunAttendanceExtraMapper.updateByPrimaryKeySelective(erpFunAttendanceExtra);

			}
		}
	}

	/**
	 * 时间考勤结果验证
	 *
	 * @author hemingli
	 * @2017-12-12
	 */
	private void verifyAttTime(byte timeAttResult, Byte oldAttResult) {
		if ((Const.TimeAttendanceResult.NORMAL.equals(oldAttResult)
				|| Const.TimeAttendanceResult.BE_LATE.equals(oldAttResult)
				|| Const.TimeAttendanceResult.BE_LATE_BADLY.equals(oldAttResult)
				|| Const.TimeAttendanceResult.BE_LATE_ABSENTEEISM.equals(oldAttResult)) &&
				oldAttResult != timeAttResult) {
			throw new BusinessException(String.format("%s状态不能更新为%s状态",
					Const.TimeAttendanceResult.ATT_RESULT_CN.get(oldAttResult),
					Const.TimeAttendanceResult.ATT_RESULT_CN.get(timeAttResult)));
		}
	}

	/**
	 * 地点考勤逻辑判断
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	private byte handleLocationAttendance(AttendanceSignInParam attendanceSignInParam,
			List<ErpFunAttendanceScope> erpFunAttendanceScopeList) {
		byte locationAttResult = 1;
		for (ErpFunAttendanceScope erpFunAttendanceScope : erpFunAttendanceScopeList) {
			double startLat = StringUtil.parseDouble(erpFunAttendanceScope.getAttScopeX());
			double startLon = StringUtil.parseDouble(erpFunAttendanceScope.getAttScopeY());
			double endLat = StringUtil.parseDouble(attendanceSignInParam.getAttendanceX());
			double endLon = StringUtil.parseDouble(attendanceSignInParam.getAttendanceY());
			// 考勤范围距离小于打卡上传地点和考勤地点之间距离，则结果为外勤 2，否则为正常 1
			if (erpFunAttendanceScope.getAttDistance().longValue() < MathUtil.getDistance(startLat, startLon, endLat,
					endLon)) {
				locationAttResult = 2;
			} else {
				locationAttResult = 1;
				break;
			}
		}
		return locationAttResult;
	}

	/**
	 * 考勤时间逻辑判断
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	private byte handleDateAttendance(Integer cityId, Integer compId, AttendanceSignInParam attendanceSignInParam,
									  ErpFunAttendanceClass erpFunAttendanceClass) {
		byte timeAttResult;
		String attendanceUpTime = "00:00";// 上班考勤时间
		String attendanceDownTime = "00:00";// 下班考勤时间
		int compareResult;// 考勤时间比较结果
		switch (attendanceSignInParam.getAttNum()) {// 获取打卡班次打卡时间
			case "1":
				attendanceUpTime = erpFunAttendanceClass.getFirstUp();
				attendanceDownTime = erpFunAttendanceClass.getFirstDown();
				break;
			case "2":
				attendanceUpTime = erpFunAttendanceClass.getSecondUp();
				attendanceDownTime = erpFunAttendanceClass.getSecondDown();
				break;
			case "3":
				attendanceUpTime = erpFunAttendanceClass.getThreeUp();
				attendanceDownTime = erpFunAttendanceClass.getThreeDown();
				break;
		}

		/*
		 * 判断打卡状态 迟到、正常、早退 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工
		 */
		double minutesOfTwoDate;
		Date attConfigTimeDate;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat sdfNext = new SimpleDateFormat("yyyy-MM-dd");
			if (attendanceSignInParam.isAttendanceUp()) {// 上班
				compareResult = compareTwoDate(attendanceSignInParam.getLocalAttTime(), attendanceUpTime);
				minutesOfTwoDate = Math.abs(getMinutesOfTwoDate(attendanceSignInParam.getLocalAttTime(), attendanceUpTime));
				timeAttResult = getTimeAttResult(cityId, compId, true, minutesOfTwoDate, compareResult);
				attConfigTimeDate = DateTimeHelper
						.parseToDate(sdfNext.format(Long.valueOf(attendanceSignInParam.getCurrentAttDate())) + " "
								+ attendanceUpTime, "yyyy-MM-dd HH:mm");
			} else {// 下班
				int downTimeCompareUpTime = DateTimeHelper.compareTwoDate(
						DateTimeHelper.parseToDate(attendanceDownTime, "HH:mm"),
						DateTimeHelper.parseToDate(attendanceUpTime, "HH:mm"));
				if (downTimeCompareUpTime < 0) {// 当日下班 18:00 -20:00
					compareResult = compareTwoDate(attendanceSignInParam.getLocalAttTime(), attendanceDownTime);
					minutesOfTwoDate = Math
							.abs(getMinutesOfTwoDate(attendanceSignInParam.getLocalAttTime(), attendanceDownTime));
					attConfigTimeDate = DateTimeHelper
							.parseToDate(sdfNext.format(Long.valueOf(attendanceSignInParam.getCurrentAttDate())) + " "
									+ attendanceDownTime, "yyyy-MM-dd HH:mm");
				} else {// 跨日下班 22:00 -04:00

					Date localAttTime = DateTimeHelper.parseToDate(
							sdf.format(Long.valueOf(attendanceSignInParam.getLocalAttTime())), "yyyy-MM-dd HH:mm");
					Date nextDayDate = DateTimeHelper.addDays(DateTimeHelper
							.parseToDate(sdfNext.format(Long.valueOf(attendanceSignInParam.getCurrentAttDate())) + " "
									+ attendanceDownTime, "yyyy-MM-dd HH:mm"), 1);
					attConfigTimeDate = nextDayDate;
					compareResult = DateTimeHelper.compareTwoDate(localAttTime, nextDayDate);
					minutesOfTwoDate = Math.abs(DateTimeHelper.getMinutesOfTwoDate(localAttTime, nextDayDate));
				}
				timeAttResult = getTimeAttResult(cityId, compId, false, minutesOfTwoDate, compareResult);
			}
		} catch (ParseException e) {
			throw new BusinessException("打卡时间错误");
		}
		//设置迟到早退时间
		attendanceSignInParam.setBelateMinute((int) minutesOfTwoDate);
		attendanceSignInParam.setAttConfigTimeDate(attConfigTimeDate);
		return timeAttResult;
	}

	/**
	 * 上下班结果逻辑判断
	 *
	 * @param isAttendanceUp   上班（true） 下班（false）
	 * @param minutesOfTwoDate 打卡时间和配置打卡时间相差多时间（分钟）
	 * @param compareResult    比较两个时间的先后顺序。如果时间d1在d2之前：1,如果时间d1在d2之后：-1，如果二者相等：0
	 * @author hemingli
	 * @date 2017-11-28
	 */
	private byte getTimeAttResult(Integer cityId, Integer compId, boolean isAttendanceUp, double minutesOfTwoDate, int compareResult)
			throws ParseException {
		ErpFunAttendanceParamExample erpFunAttendanceParamExample = new ErpFunAttendanceParamExample();
		erpFunAttendanceParamExample.setShardCityId(cityId);
		erpFunAttendanceParamExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunAttendanceParam> erpFunAttendanceParams = erpFunAttendanceParamMapper.selectByExample(erpFunAttendanceParamExample);
		double beLateBadly = 0;// 严重迟到
		double beLateAbsenteeism = 0;// 迟到旷工
		double leaveEarly = 0;// 早退限制时间
		if (null != erpFunAttendanceParams && 0 < erpFunAttendanceParams.size()) {
			for (ErpFunAttendanceParam attendanceParam : erpFunAttendanceParams) {
				switch (attendanceParam.getParamType()) {
					case "2":
						beLateBadly = Double.valueOf(attendanceParam.getRuleValue());
						break;
					case "3":
						beLateAbsenteeism = Double.valueOf(attendanceParam.getRuleValue());
						break;
					case "4":
						leaveEarly = Double.valueOf(attendanceParam.getRuleValue());
						break;
					default:
						break;
				}
			}
		}
		byte timeAttResult;// 正常
		if (isAttendanceUp) {
			if (compareResult >= 0) {
				timeAttResult = Const.TimeAttendanceResult.NORMAL;
			} else {// 迟到
				if (beLateBadly < minutesOfTwoDate && beLateAbsenteeism > minutesOfTwoDate) {
					timeAttResult = Const.TimeAttendanceResult.BE_LATE_BADLY;
				} else if (beLateAbsenteeism <= minutesOfTwoDate) {
					timeAttResult = Const.TimeAttendanceResult.BE_LATE_ABSENTEEISM;
				} else if (0 < minutesOfTwoDate && beLateBadly > minutesOfTwoDate) {
					timeAttResult = Const.TimeAttendanceResult.BE_LATE;
				} else {
					timeAttResult = Const.TimeAttendanceResult.BE_LATE;
				}
			}
		} else {
			if (compareResult > 0) {// 早退
				if (leaveEarly < minutesOfTwoDate) {
					timeAttResult = Const.TimeAttendanceResult.LEAVE_EARLY_ABSENTEEISM;
				} else {
					timeAttResult = Const.TimeAttendanceResult.LEAVE_EARLY;
				}

			} else {
				timeAttResult = Const.TimeAttendanceResult.NORMAL;
			}
		}

		return timeAttResult;
	}

	/**
	 * 比较两个时间大小
	 *
	 * @param localAttTime   时间戳 字符串
	 * @param attendanceTime 考勤时间 "12:00"
	 * @return
	 * @author hemingli
	 * @2017-11-28
	 */
	private int compareTwoDate(String localAttTime, String attendanceTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date localDate;
		try {
			localDate = DateTimeHelper.parseToDate(sdf.format(Long.valueOf(localAttTime)), "HH:mm");
			Date attendanceDate = DateTimeHelper.parseToDate(attendanceTime, "HH:mm");
			return DateTimeHelper.compareTwoDate(localDate, attendanceDate);
		} catch (ParseException e) {
			throw new BusinessException("打卡时间错误");
		}
	}

	/**
	 * 修改考勤结果
	 * flj
	 */
	@Transactional
	@Override
	public Map<String,String> changeAttendanceResult(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, ChangeAttendanceResultParam param) {
		Byte manageLocationAttResult = (byte) 0;
		Byte attResult = param.getAttResult();
		Byte attAttribute = param.getAttAttribute();
		Integer lateMinutes = param.getLateMinutes();
		String editRemark = param.getEditRemark();
		Integer attId = param.getAttId();
		Integer archiveId = null;
		String attDate = null;
		String attIdStr = "";
		String attendanceScanRecordIdStr = "";
		if (attId != null) {
			ErpFunAttendanceRecordDetail id = new ErpFunAttendanceRecordDetail();
			id.setShardCityId(cityId);
			id.setAttId(attId);
			ErpFunAttendanceRecordDetail recordDetail = erpFunAttendanceRecordDetailMapper.selectByPrimaryKey(id);
			manageLocationAttResult = recordDetail.getManageLocationAttResult();
			if (Byte.valueOf("12").equals(recordDetail.getManageTimeAttResult())) {
				throw new BusinessException("来自请假审批的考勤结果不允许修改！");
			}
			archiveId = recordDetail.getArchiveId();
			attDate = DateTimeHelper.formatDateTimetoString(recordDetail.getAttOughtDate(), "yyyy-MM-dd");
		}
		ErpFunAttendanceRecordDetail record = new ErpFunAttendanceRecordDetail();
		if (Const.TimeAttendanceResult.NORMAL.equals(attResult)) {
			record.setManageLocationAttResult((byte) 1);//1正常 2外勤
			attResult = Const.TimeAttendanceResult.NORMAL;//正常
		} else if (Const.TimeAttendanceResult.BE_LATE.equals(attResult)) {
			try {
				//上班
				if (Byte.valueOf("1").equals(attAttribute)) {
					attResult = getTimeAttResult(cityId, compId, true, lateMinutes + 0.0, -1);
				} else if (Byte.valueOf("2").equals(attAttribute)) {//下班
					attResult = getTimeAttResult(cityId, compId, false, lateMinutes + 0.0, 1);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Integer attResultWeight = computeAttResultOffWeight(attResult, manageLocationAttResult);
		record.setAttResultWeight(attResultWeight.byteValue());
		record.setShardCityId(cityId);
		record.setCityId(cityId);
		record.setBelateMinute(lateMinutes);
		record.setManageTimeAttResult(attResult);
		record.setEditRemark(editRemark);
		record.setEditDeptId(deptId);
		record.setEditUserId(userId);
		record.setEditDate(new Date());
		ErpFunUsers userPo = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
		if (!Byte.valueOf("0").equals(attResult)) {
			record.setAttRest(Byte.valueOf("0"));
		}
		ErpFunAttendanceStatistics statisticOffUser = erpFunAttendanceStatisticsMapper.getAttendanceStatisticOffUser(cityId, compId, userPo.getArchiveId(), DateTimeHelper.formatDateTimetoString(param.getAttOughtDate(), "yyyy-MM-dd"));
		if (attId != null) {
			record.setAttId(attId);
			attIdStr = attId.toString();
			erpFunAttendanceRecordDetailMapper.updateByPrimaryKeySelective(record);
			attendanceScanRecordIdStr = ""+insertAdminAttendanceScanningRecord(cityId, compId, attId);
		} else { // 没有考勤id，说明缺了卡
			Integer attUserId = param.getUserId();
			if(Byte.valueOf("11").equals(attResult)) {
				record.setAttRest(Byte.valueOf("1"));
			}
			
			if("-1".equals(param.getOldAttRecordStatus()+"")) {
				// 查询当天得配置统计
				if(null != statisticOffUser) {
					
					record.setCompId(compId);
					record.setCityId(cityId);
					// 第一次上下班，两条detail
					param.setAttClassClocktime(statisticOffUser.getAttClassClocktime());
					param.setAttSumCount(statisticOffUser.getAttSumCount());
					param.setAttGrId(statisticOffUser.getAttGrId());
					param.setAttClassId(statisticOffUser.getAttClassId());
					param.setAttClassName(statisticOffUser.getAttClassName());
					param.setConfigAttTime(DateUtil.DateToString(statisticOffUser.getAttDate()));
					param.setAttOughtDate(param.getAttOughtDate());// ？
					// 查询配置
					int i = statisticOffUser.getAttSumCount().intValue();
					if (isHaveLeave(statisticOffUser)) {
						throw new BusinessException("考勤中有来自审批的请假，不允许修改考勤结果！");
					}
					if(i > 0) {
						param.setAttNum((byte) 1);
						// 1上班 2：下班
						param.setAttAttribute((byte )1);
						Integer tempAttId = insertDetailLog(record, param, userPo, statisticOffUser.getFirstWorkOntime());
						attIdStr= attIdStr +","+ tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
						param.setAttNum((byte) 1);
						// 1上班 2：下班
						param.setAttAttribute((byte )2);
						tempAttId = insertDetailLog(record, param, userPo,statisticOffUser.getFirstWorkOfftime());
						attIdStr= attIdStr +","+ tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
					}
					if(i > 1) {
						param.setAttNum((byte) 2);
						// 1上班 2：下班
						param.setAttAttribute((byte )1);
						Integer tempAttId = insertDetailLog(record, param, userPo, statisticOffUser.getSecondWorkOntime());
						attIdStr= attIdStr +","+tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
						param.setAttNum((byte) 2);
						// 1上班 2：下班
						param.setAttAttribute((byte )2);
						tempAttId = insertDetailLog(record, param, userPo, statisticOffUser.getSecondWorkOfftime());
						attIdStr= attIdStr +","+ tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
					}
					if(i > 2) {
						param.setAttNum((byte) 3);
						// 1上班 2：下班
						param.setAttAttribute((byte )1);
						Integer tempAttId = insertDetailLog(record, param, userPo, statisticOffUser.getThreeWorkOntime());
						attIdStr= attIdStr +","+tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
						param.setAttNum((byte) 3);
						// 1上班 2：下班
						param.setAttAttribute((byte )2);
						tempAttId = insertDetailLog(record, param, userPo, statisticOffUser.getThreeWorkOfftime());
						attIdStr= attIdStr +","+tempAttId;
						attendanceScanRecordIdStr = attendanceScanRecordIdStr+","+insertAdminAttendanceScanningRecord(cityId, compId, tempAttId);
					}
				}else {
					throw new BusinessException("数据错误，请联系客服！");
				}
			}else {
				archiveId = userPo.getArchiveId();
				record.setAttClassClocktime(param.getAttClassClocktime());
				record.setAttOughtDate(DateTimeHelper.parseToDate(param.getAttOughtDate()));
				attDate = DateTimeHelper.formatDateTimetoString(record.getAttOughtDate(), "yyyy-MM-dd");
				record.setAttNum(param.getAttNum());
				record.setAttAttribute(param.getAttAttribute());
				record.setAttSumCount(param.getAttSumCount());
				
				record.setAttType(Byte.valueOf("0"));
				record.setOffLineUpload(Byte.valueOf("0"));
				record.setAttGrId(param.getAttGrId());
				record.setAttClassId(param.getAttClassId());
				// 取班次名称
				ErpFunAttendanceClass erpFunAttendanceClass = new ErpFunAttendanceClass();
				erpFunAttendanceClass.setShardCityId(cityId);
				erpFunAttendanceClass.setId(param.getAttClassId());
				erpFunAttendanceClass = erpFunAttendanceClassMapper.selectByPrimaryKey(erpFunAttendanceClass);
				if(null != erpFunAttendanceClass) {
					record.setAttClassName(erpFunAttendanceClass.getClassName());
				}
				record.setArchiveId(userPo.getArchiveId());
				record.setUserId(attUserId);
				record.setCompId(compId);
				record.setAreaId(userPo.getAreaId());
				record.setRegId(userPo.getRegId() == null ? 0 : userPo.getRegId());
				record.setDeptId(userPo.getDeptId());
				record.setGrId(userPo.getGrId() == null ? 0 : userPo.getGrId());
				if (StringUtil.isBlank(param.getConfigAttTime())) {
					record.setConfigAttTime(new Date());
				} else {
					record.setConfigAttTime(DateTimeHelper.parseToDate(param.getConfigAttTime()));
				}
				record.setAttX("0");
				record.setAttY("0");
				record.setLocationDesc("暂无");
				if (!isJudgeCanEdit(record.getAttNum(), record.getAttAttribute(), statisticOffUser)) {
					throw new BusinessException("当前考勤结果为来自请假审批，不允许修改!");
				}
				//判断是否能修改
				erpFunAttendanceRecordDetailMapper.insertSelective(record);
				attIdStr= record.getAttId().toString();
				attendanceScanRecordIdStr = "" + insertAdminAttendanceScanningRecord(cityId, compId, record.getAttId());
			}
		/*	// 改休息时改考勤统计的状态
			if(null != attResult && 11 == attResult.intValue() && StringUtil.isNotBlank(param.getAttOughtDate())){
				erpFunAttendanceStatisticsMapper.updateAttendanceStatistics(cityId, compId, param.getAttClassId(), param.getAttOughtDate(), attUserId,(byte) 1);
			}*/
		}
		//增加系统考勤修改记录日志
		ErpAttendanceChangeRecord sysRecord = new ErpAttendanceChangeRecord();
		//考勤记录Id
		sysRecord.setAttendanceId(record.getAttId());
		//考勤原始时间
		if (null != param.getAttOughtDate()) {
			sysRecord.setSourceCreateTime(DateTimeHelper.parseToDate(param.getAttOughtDate()));
		} else {
			sysRecord.setSourceCreateTime(record.getCreateTime());
		}
		//公司ID
		sysRecord.setCompId(compId);
		//上班还是下班 0上班 1下班
		if (attAttribute != null && attAttribute == 1) {// 上班
			sysRecord.setWorkType((byte) 0);
		} else if (attAttribute != null && attAttribute == 2) {// 下班
			sysRecord.setWorkType((byte) 1);
		} else {
			sysRecord.setWorkType((byte) 2);// 报表中修改时是修改一整天的结果，没有上下班之分，所以这里用2区分
		}
		//具体上班类型（1.4正常2.5值班3.6晚班)2019/3/1号没有了,现在全整成1
		sysRecord.setWorkDetailType(Byte.valueOf(Const.DIC_WORK_TYPE_ONWORK));
		//考勤所属人的ID
		sysRecord.setSourceUserId(param.getUserId());
		sysRecord.setOrganizationPath(userPo.getTissueLine());//zt组织机构
		//考勤所属人门店ID
		sysRecord.setSourceDeptId(userPo.getDeptId());
		//考勤所属人姓名
		sysRecord.setSourceUserName(userPo.getUserName());
		//考勤修改人ID
		sysRecord.setChangeUserId(userId);
		//考勤修改人姓名
		sysRecord.setChangeUserName(userName);
//		时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息
		//考勤状态变更
		String changeStatus1 = "";
		switch (param.getManageTimeAttResult()) {
			case "0":
				changeStatus1 = "缺卡->";
				break;
			case "1":
				changeStatus1 = "早退->";
				break;
			case "2":
				changeStatus1 = "迟到->";
				break;
			case "3":
				changeStatus1 = "旷工->";
				break;
			case "4":
				changeStatus1 = "正常->";
				break;
			case "5":
				changeStatus1 = "等待打卡->";
				break;
			case "6":
				changeStatus1 = "严重迟到->";
				break;
			case "7":
				changeStatus1 = "早退旷工->";
				break;
			case "8":
				changeStatus1 = "迟到旷工->";
				break;
			case "9":
				changeStatus1 = "事假->";
				break;
			case "10":
				changeStatus1 = "病假->";
				break;
			case "11":
				changeStatus1 = "休息->";
				break;
			default:
				changeStatus1 = "空->";
				break;
		}
		String changeStatus2 = "";
		switch (param.getAttResult().toString()) {
			case "0":
				changeStatus2 = "缺卡";
				break;
			case "1":
				changeStatus2 = "早退";
				break;
			case "2":
				changeStatus2 = "迟到";
				break;
			case "3":
				changeStatus2 = "旷工";
				break;
			case "4":
				changeStatus2 = "正常";
				break;
			case "5":
				changeStatus2 = "等待打卡";
				break;
			case "6":
				changeStatus2 = "严重迟到";
				break;
			case "7":
				changeStatus2 = "早退旷工";
				break;
			case "8":
				changeStatus2 = "迟到旷工";
				break;
			case "9":
				changeStatus2 = "事假";
				break;
			case "10":
				changeStatus2 = "病假";
				break;
			case "11":
				changeStatus2 = "休息";
				break;
			default:
				changeStatus2 = "空";
				break;
		}
		sysRecord.setChangeState(changeStatus1+changeStatus2);
		//修改原因
		sysRecord.setChangeReason(param.getEditRemark()== null ? "" : param.getEditRemark());
		
//		if (StringUtil.isNotEmpty(param.getOriginTime())) {// originTime参数前端没有传递
//			sysRecord.setSourceCreateTime(DateTimeHelper.parseToDate(param.getOriginTime()));
//		} else {
//			sysRecord.setSourceCreateTime(new Date());
//		}

		//创建时间
		sysRecord.setCreateTime(new Date());
		sysRecord.setShardCityId(cityId);
		erpAttendanceChangeRecordMapper.insertSelective(sysRecord);

		//推送消息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "43");
		jsonObject.put("receiver", archiveId);
		jsonObject.put("content", "管理员" + param.getCurrentUserName() + "修改了您" + attDate + "号的打卡结果，点击查看明细");
		jsonObject.put("date", attDate);
		jsonObject.put("attId", attId);
		KafkaBizUtils.pushMsgByTemplate(jsonObject);

	/*	AdminAttendanceScanningRecord adminAttendanceScanningRecord = new AdminAttendanceScanningRecord();
		adminAttendanceScanningRecord.setAttId(attId);
		adminAttendanceScanningRecord.setCityId(cityId);
		adminAttendanceScanningRecord.setCompId(compId);
		adminAttendanceScanningRecord.setDealType(Byte.valueOf("0"));
		adminAttendanceScanningRecordMapper.insertSelective(adminAttendanceScanningRecord);*/
		Map<String,String> attInfoMap = new HashMap<>();
		attInfoMap.put("cityId", cityId.toString());
		attInfoMap.put("compId", compId.toString());
		attInfoMap.put("attIds", attIdStr);
		attInfoMap.put("ids", attendanceScanRecordIdStr);
		return attInfoMap;
	}
	
	
	private boolean isJudgeCanEdit(Byte attNum, Byte attAtribute, ErpFunAttendanceStatistics statist) {
		Byte attResult = null;
		if (Byte.valueOf("1").equals(attNum)) {
			if (Byte.valueOf("1").equals(attAtribute)) {
				attResult = statist.getFirstWorkOn();
			} else {
				attResult = statist.getFirstWorkOff();
			}
		} else if (Byte.valueOf("2").equals(attNum)) {
			if (Byte.valueOf("1").equals(attAtribute)) {
				attResult = statist.getSecondWorkOn();
			} else {
				attResult = statist.getSecondWorkOff();
			}
		} else if (Byte.valueOf("3").equals(attNum)) {
			if (Byte.valueOf("1").equals(attAtribute)) {
				attResult = statist.getThreeWorkOn();
			} else {
				attResult = statist.getThreeWorkOff();
			}
		}
		if (Byte.valueOf("12").equals(attResult)) {
			return false;
		}
		return  true;
	}
	  /**
     * 计算一天中的9.10.12 Const.TimeAttendanceResult.AUDIT_LEAVE
     * @return
     */
    private boolean isHaveLeave(ErpFunAttendanceStatistics statist) { 
    	boolean flag = false;
    	if (statist.getAttClassId() ==null || statist.getAttClassId()<=0) {
			return false;
		}
    	Byte attSumCount = statist.getAttSumCount();
    	if (Byte.valueOf("1").equals(attSumCount)) {
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOff())) {
    			flag = true;
    		}
    	} else if (Byte.valueOf("2").equals(attSumCount)) {
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOff())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getSecondWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getSecondWorkOff())) {
    			flag = true;
    		}
    	
    	} else if (Byte.valueOf("3").equals(attSumCount)) {
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getFirstWorkOff())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getSecondWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getSecondWorkOff())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getThreeWorkOn())) {
    			flag = true;
    		}
    		if (Const.TimeAttendanceResult.AUDIT_LEAVE.equals(statist.getThreeWorkOff())) {
    			flag = true;
    		}
    	}
		return flag;
    	
    }
	
    private Integer insertAdminAttendanceScanningRecord(Integer cityId, Integer compId, Integer attId) {
    	AdminAttendanceScanningRecord adminAttendanceScanningRecord = new AdminAttendanceScanningRecord();
		adminAttendanceScanningRecord.setAttId(attId);
		adminAttendanceScanningRecord.setCityId(cityId);
		adminAttendanceScanningRecord.setCompId(compId);
		adminAttendanceScanningRecord.setDealType(Byte.valueOf("0"));
		adminAttendanceScanningRecordMapper.insertSelective(adminAttendanceScanningRecord);
		return adminAttendanceScanningRecord.getId();
    }
    
	private Integer insertDetailLog(ErpFunAttendanceRecordDetail record, ChangeAttendanceResultParam param, ErpFunUsers  userPo, Date locaTime) {
		Integer attUserId = param.getUserId();
		record.setAttClassClocktime(param.getAttClassClocktime());
		record.setAttOughtDate(DateTimeHelper.parseToDate(param.getAttOughtDate()));
		record.setAttNum(param.getAttNum());
		record.setAttAttribute(param.getAttAttribute());
		record.setAttSumCount(param.getAttSumCount());
		record.setAttType(Byte.valueOf("0"));
		record.setOffLineUpload(Byte.valueOf("0"));
		record.setAttGrId(param.getAttGrId());
		record.setAttClassId(param.getAttClassId());
		record.setArchiveId(userPo.getArchiveId());
		record.setUserId(attUserId);
		record.setCompId(record.getCompId());
		record.setAreaId(userPo.getAreaId());
		record.setRegId(userPo.getRegId());
		record.setDeptId(userPo.getDeptId());
		record.setGrId(userPo.getGrId());
		if (StringUtil.isBlank(param.getConfigAttTime())) {
			record.setConfigAttTime(new Date());
		} else {
			record.setConfigAttTime(DateTimeHelper.parseToDate(param.getConfigAttTime()));
		}
		record.setAttX("0");
		record.setAttY("0");
		record.setLocationDesc("暂无");
		record.setLocalAttTime(locaTime);
		record.setServerAttTime(locaTime);
		record.setEditDate(new Date());
		erpFunAttendanceRecordDetailMapper.insertSelective(record);
		return record.getAttId();
	}

	/**
	 * 获得两个日期之间相差的分钟数
	 *
	 * @param localAttTime   时间戳 字符串
	 * @param attendanceTime 考勤时间 "12:00"
	 * @throws ParseException
	 * @author hemingli
	 * @2017-11-28
	 */
	private double getMinutesOfTwoDate(String localAttTime, String attendanceTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date localDate = DateTimeHelper.parseToDate(sdf.format(Long.valueOf(localAttTime)), "HH:mm");
		Date attendanceDate = DateTimeHelper.parseToDate(attendanceTime, "HH:mm");
		return DateTimeHelper.getMinutesOfTwoDate(localDate, attendanceDate);
	}

	/**
	 * 获取激励语配置
	 *
	 * @author hemingli
	 * @2017-11-28
	 */
	@Override
	public AttendanceResultDto getGreetingInfo() {
		AttendanceResultDto resultDto = new AttendanceResultDto();
		AdminFunAttScene earlyUpScene = null;
		AdminFunAttScene upScene = null;
		AdminFunAttScene downScene = null;
		AdminFunAttScene lateScene = null;
		List<AdminFunAttScene> adminFunAttScenes = adminFunAttSceneMapper.selectAllScene();
		for (AdminFunAttScene funAttScene : adminFunAttScenes) {
			switch (funAttScene.getSceneType()) {
				case 1:
					earlyUpScene = funAttScene;
					break;
				case 2:
					upScene = funAttScene;
					break;
				case 3:
					downScene = funAttScene;
					break;
				case 4:
					lateScene = funAttScene;
					break;
				case 5:
					break;
				default:
					break;
			}
		}
		if (earlyUpScene != null) {
			if (DateTimeHelper.getHoursOfDay(new Date()) >= earlyUpScene.getClockStartTime()
					&& DateTimeHelper.getHoursOfDay(new Date()) < earlyUpScene.getClockEndTime()) {
				List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(earlyUpScene.getSceneId());
				List<AdminFunAttStimulateImg> stimulateImgList = adminFunAttStimulateImgMapper.selectBySceneId(earlyUpScene.getSceneId());
				if (!stimulateLangList.isEmpty()) {
					int nextInt = stimulateImgList.size() - 1;
					if (nextInt==0) {
						nextInt = 1;
					}
					resultDto.setEndGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
				}
				if (!stimulateImgList.isEmpty()) {
					int nextInt = stimulateImgList.size() - 1;
					if (nextInt==0) {
						nextInt = 1;
					}
					resultDto.setEndPhotoUrl(stimulateImgList.get(new Random().nextInt(nextInt)).getStimulateImgPath());
				}		
			} else {
				List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(upScene.getSceneId());
				if (!stimulateLangList.isEmpty()) {
					int nextInt = stimulateLangList.size() - 1;
					if (nextInt==0) {
						nextInt = 1;
					}
					resultDto.setStartGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
				}
			}
		}
		//跨日下班
		if (lateScene != null) {
			if (lateScene.getClockStartTime() > lateScene.getClockEndTime()) {
				if (DateTimeHelper.getHoursOfDay(new Date()) > lateScene.getClockStartTime()
						|| DateTimeHelper.getHoursOfDay(new Date()) < lateScene.getClockEndTime()) {
					List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(lateScene.getSceneId());
					List<AdminFunAttStimulateImg> stimulateImgList = adminFunAttStimulateImgMapper.selectBySceneId(lateScene.getSceneId());
					if (!stimulateLangList.isEmpty()) {
						int nextInt = stimulateImgList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
					}
					if (!stimulateImgList.isEmpty()) {
						int nextInt = stimulateImgList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndPhotoUrl(stimulateImgList.get(new Random().nextInt(nextInt)).getStimulateImgPath());
					}	
				} else {
					List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(downScene.getSceneId());
					if (!stimulateLangList.isEmpty()) {
						int nextInt = stimulateLangList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
					}
				}
			} else {
				if (DateTimeHelper.getHoursOfDay(new Date()) >= lateScene.getClockStartTime()
						&& DateTimeHelper.getHoursOfDay(new Date()) < lateScene.getClockEndTime()) {
					List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(lateScene.getSceneId());
					List<AdminFunAttStimulateImg> stimulateImgList = adminFunAttStimulateImgMapper.selectBySceneId(lateScene.getSceneId());
					if (!stimulateLangList.isEmpty()) {
						int nextInt = stimulateImgList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
					}
					if (!stimulateImgList.isEmpty()) {
						int nextInt = stimulateImgList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndPhotoUrl(stimulateImgList.get(new Random().nextInt(nextInt)).getStimulateImgPath());
					}			
				} else {
					List<AdminFunAttStimulateLang> stimulateLangList = adminFunAttStimulateLangMapper.selectBySceneId(downScene.getSceneId());
					if (!stimulateLangList.isEmpty()) {
						int nextInt = stimulateLangList.size() - 1;
						if (nextInt==0) {
							nextInt = 1;
						}
						resultDto.setEndGreeting(stimulateLangList.get(new Random().nextInt(nextInt)).getStimulateLangDesc());
					}
				}
			}
		}
		return resultDto;
	}

	/**
	 * 根据考勤结果计算权重
	 *
	 * @param attResult
	 * @param locastionResult
	 * @return
	 */
	public Integer computeAttResultOffWeight(Byte attResult, Byte locastionResult) {
		Integer weight = Const.TimeAttendanceResult.ATT_RESULT_TRANSFER_WEIGHT.get(attResult);
		if (weight == null) {
			return 0;
		}
		if (weight <= 3) {//小于3的时候，判断是否是外勤，如果是外勤，则取外勤的权重
			if (Byte.valueOf("2").equals(locastionResult)) {
				weight = 3;
			}
		}
		return weight;
	}

	/**
	  * 方法修改考勤的注释
	  * @author 李成兵
	  * @since 2018/4/27
	  * @param 
	  * @return
	  */
	@Transactional
    @Override
    public void updateMonthCountDayAttendance(Integer cityId, Integer compId, Integer deptId, Integer userId, ChangeAttendanceResultParam param) {
        Byte attResult = param.getAttResult();
        Date d = DateUtil.StringToDate(param.getAttOughtDate());
        Byte oldAttRecordStatus = param.getOldAttRecordStatus();
        // 用于业务的
        Byte bussinessAttResult = param.getOldAttRecordStatus();

        // 修改考勤明细
        ErpFunAttendanceRecordDetailExample example = new ErpFunAttendanceRecordDetailExample();
        example.setShardCityId(cityId);
		ErpFunAttendanceRecordDetailExample.Criteria criteria = example.createCriteria().andCompIdEqualTo(compId).andAttOughtDateEqualTo(d);
		if(null != param.getAttAttribute()) {
			criteria.andAttAttributeEqualTo(param.getAttAttribute());
		}

        ErpFunAttendanceRecordDetail paramPo = new ErpFunAttendanceRecordDetail();
        if("-2".equals(oldAttRecordStatus)) {
            bussinessAttResult = (byte)0;
            criteria.andTimeAttResultEqualTo(bussinessAttResult);
            paramPo.setAttAttribute((byte) 1);
        }else if("-3".equals(oldAttRecordStatus)) {
            paramPo.setAttAttribute((byte) 2);
            bussinessAttResult = (byte)0;
            criteria.andTimeAttResultEqualTo(bussinessAttResult);
        }else {
            criteria.andTimeAttResultEqualTo(oldAttRecordStatus);
        }
        paramPo.setManageTimeAttResult(attResult);
        paramPo.setEditDeptId(deptId);
        paramPo.setEditRemark(param.getEditRemark());
        paramPo.setEditUserId(userId);
        Integer attResultWeight = computeAttResultOffWeight(bussinessAttResult, param.getAttResult());
        paramPo.setAttResultWeight(attResultWeight.byteValue());
        erpFunAttendanceRecordDetailMapper.updateByExampleSelective(paramPo, example);

		Integer userId1 = param.getUserId();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId1);

		
		//推送消息
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "43");
		jsonObject.put("receiver", erpFunUsers.getArchiveId());
		jsonObject.put("content", "管理员" + param.getCurrentUserName() + "修改了您" + param.getAttOughtDate() + "号的打卡结果，点击查看明细");
		jsonObject.put("date", param.getAttOughtDate());
		KafkaBizUtils.pushMsgByTemplate(jsonObject);
    }

}