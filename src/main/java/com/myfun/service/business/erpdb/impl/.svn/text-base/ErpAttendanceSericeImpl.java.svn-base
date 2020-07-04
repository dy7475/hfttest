package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpAttendanceChangeRecordMapper;
import com.myfun.repository.erpdb.dao.ErpAttendanceMapper;
import com.myfun.repository.erpdb.dao.ErpFineMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpAttendanceDto;
import com.myfun.repository.erpdb.dto.ErpFineDto;
import com.myfun.repository.erpdb.po.ErpAttendance;
import com.myfun.repository.erpdb.po.ErpAttendanceChangeRecord;
import com.myfun.repository.erpdb.po.ErpFine;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSysParaKey;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAttendanceSerice;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateAttendanceParam;
import com.myfun.service.business.erpdb.bean.param.UpdateAttenceOffCountParam;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;
@Service
public class ErpAttendanceSericeImpl extends AbstractService<ErpAttendance, ErpAttendance> implements
		ErpAttendanceSerice {
	@Autowired
	ErpAttendanceMapper erpAttendanceMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFineMapper erpFineMapper;
	@Autowired
	ErpAttendanceChangeRecordMapper erpAttendanceChangeRecordMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAttendanceMapper;

	}

	@Override
	public void insertAttendance(Integer cityId,
			CreateOrUpdateAttendanceParam param) throws Exception {
		String passWord = EnCodeHelper.MD5Encode(param.getLoginPassword());
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, param.getAttUser());
		if(!passWord.equals(erpFunUsers.getLoginPassword())){
			throw new BusinessException("对不起，用户密码错误！");
		}
		String nowDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		checkCurrentUserAttendanceToDay(cityId,nowDate,param.getAttUser(),param.getWorkType(),param);
	}

	private void checkCurrentUserAttendanceToDay(Integer cityId,String nowDate,Integer userId,String workType,CreateOrUpdateAttendanceParam param) throws Exception {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectUserNameByUserId(cityId, userId);
		String attendanceModel = erpSysParaMapper.getParamValue(cityId, param.getCompId(), "ATTENDANCE_MODEL");
		if(workType.equals(Constants_DIC.DIC_WORK_TYPE_ONWORK) //ONWORK
				|| workType.equals(Constants_DIC.DIC_WORK_TYPE_LATEWORK) //LATEWORK
				|| workType.equals(Constants_DIC.DIC_WORK_TYPE_DUTYWORK)){//DUTYWORK
			String workTypeCondition = null;
			if("1".equals(attendanceModel)){
				workTypeCondition = workType;
			}
			ErpAttendance erpAttendance = erpAttendanceMapper.selectByDateAndUserId(cityId,nowDate,userId, workTypeCondition, null);
			if(erpAttendance!=null&&erpAttendance.getAttOnStatus()!=null){
				throw new BusinessException("对不起，你已经打考勤了！");
			}
			onWork(cityId, param,attendanceModel,erpFunUsers);
		}else if(workType.equals(Constants_DIC.DIC_WORK_TYPE_FREE) //FREE
				|| workType.equals(Constants_DIC.DIC_WORK_TYPE_EARYFREE) //EARYFREE
				|| workType.equals(Constants_DIC.DIC_WORK_TYPE_DUTYFREE)){//DUTYFREE
			String workTypeCondition = null;
			if("1".equals(attendanceModel)){
				workTypeCondition = workType;
			}
			ErpAttendance erpAttendance = erpAttendanceMapper.selectByDateAndUserId(cityId,nowDate,userId, null, workTypeCondition);
			if(erpAttendance!=null&&erpAttendance.getAttOffStatus()!=null){
				throw new BusinessException("对不起，你已经打考勤了！");
			}
			outWork(cityId, param,attendanceModel,erpFunUsers);
		}
	}
	private void onWork(Integer cityId,CreateOrUpdateAttendanceParam param,String attendanceModel,ErpFunUsers erpFunUsers) throws Exception {
		String workType = param.getWorkType();
		String onTime = "";
		ErpSysParaKey  sysParaKey = new ErpSysParaKey();
		sysParaKey.setShardCityId(cityId);
		if(workType.equals(Constants_DIC.DIC_WORK_TYPE_ONWORK)){//ONWORK
			onTime =erpSysParaMapper.getParamValue(cityId,param.getCompId(),"COMMON_ON_TIME");
		}else if(workType.equals(Constants_DIC.DIC_WORK_TYPE_DUTYWORK)){//DUTYWORK
			onTime =erpSysParaMapper.getParamValue(cityId,param.getCompId(),"DUTY_ON_TIME");
		}else if(workType.equals(Constants_DIC.DIC_WORK_TYPE_LATEWORK)){//LATEWORK
			onTime =erpSysParaMapper.getParamValue(cityId,param.getCompId(),"LATE_ON_TIME");
		}
		Date nowTime = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm"));
		Date commonTime = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd") + " " + onTime);
		double lateTime = DateTimeHelper.getMinutesOfTwoDate(nowTime, commonTime);
		float lateSkip = Float.parseFloat(erpSysParaMapper.getParamValue(cityId,param.getCompId(),"LATE_TIME_SKIP"));
		String attOnStatus = "";
		int attLateTime = 0;
		if(lateTime > lateSkip * 60){
			attOnStatus = Constants_DIC.DIC_WORK_STATUS_FREE;//SKIP
			attLateTime = (int)lateTime;
		}else if(lateTime > 0 ){
			attOnStatus = Constants_DIC.DIC_WORK_STATUS_DUTYWORK;//LATETIME
			attLateTime =(int)lateTime;
		}else{
			attOnStatus = Constants_DIC.DIC_WORK_STATUS_ONWORK;//ONTIME
		}
		String nowDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		String workTypeCondition = null;
		if("1".equals(attendanceModel)){
			workTypeCondition =  Constants_DIC.WORKONTOOFF.get(param.getWorkType());
		}
		ErpAttendance erpAttendance = erpAttendanceMapper.selectByDateAndUserId(cityId, nowDate, param.getAttUser(), null, workTypeCondition);
		if(erpAttendance!=null&&erpAttendance.getAttOffStatus()!=null){
			ErpAttendance updateModel = new ErpAttendance();
			updateModel.setShardCityId(cityId);
			updateModel.setAttId(erpAttendance.getAttId());
			updateModel.setWorkOnType(Byte.valueOf(param.getWorkType()));
			updateModel.setAttOnStatus(Byte.valueOf(attOnStatus));
			updateModel.setAttOnTime(DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			updateModel.setAttLateTime(attLateTime);
			updateModel.setCreateWorkonUser(param.getCurrentUserId());
			updateModel.setAttLateReason(StringUtils.isNotBlank(param.getAttLateReason())?param.getAttLateReason():" ");
			erpAttendanceMapper.updateByPrimaryKeySelective(updateModel);
		}else{
			ErpAttendance insertModel = new ErpAttendance();
			insertModel.setShardCityId(cityId);
			insertModel.setCompId(param.getCompId());
			insertModel.setAttDate(DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd"));
			insertModel.setDeptId(erpFunUsers.getDeptId());
			insertModel.setWorkOnType(Byte.valueOf(workType));
			insertModel.setAttOnStatus(Byte.valueOf(attOnStatus));
			insertModel.setAttOnTime(DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd HH:mm:ss"));
			insertModel.setAttLateTime(Integer.valueOf(attLateTime));
			insertModel.setCreateWorkonUser(param.getCurrentUserId());
			insertModel.setAttUser(param.getAttUser());
			insertModel.setAttLateReason(param.getAttLateReason());
			erpAttendanceMapper.insertSelective(insertModel);
		}
	}
	private void outWork(Integer cityId,CreateOrUpdateAttendanceParam param,String attendanceModel, ErpFunUsers erpFunUsers) throws Exception {
		String workType = param.getWorkType();
		String onTime = "";
		ErpSysParaKey  sysParaKey = new ErpSysParaKey();
		sysParaKey.setShardCityId(cityId);
		if(workType.equals(Constants_DIC.DIC_WORK_TYPE_FREE)){//FREE
			onTime = erpSysParaMapper.getParamValue(cityId,param.getCompId(),"COMMON_OFF_TIME");
		}else if(workType.equals(Constants_DIC.DIC_WORK_TYPE_DUTYFREE)){//DUTYFREE
			onTime = erpSysParaMapper.getParamValue(cityId,param.getCompId(),"DUTY_OFF_TIME");
		}else if(workType.equals(Constants_DIC.DIC_WORK_TYPE_EARYFREE)){//EARYFREE
			onTime = erpSysParaMapper.getParamValue(cityId,param.getCompId(),"EARLY_OFF_TIME");
		}
		Date nowTime = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm"));
		Date commonTime = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd") + " " + onTime);
		double earlyTime = DateTimeHelper.getMinutesOfTwoDate(commonTime, nowTime);
		float earlySkip = Float.parseFloat(erpSysParaMapper.getParamValue(cityId,param.getCompId(),"EARLY_TIME_SKIP"));
		String attOffStatus = "";
		String attEarlyTime = "";
		if(earlyTime > earlySkip * 60){
			attOffStatus = Constants_DIC.DIC_WORK_STATUS_FREE;//SKIP
			attEarlyTime = String.valueOf((int)earlyTime);
		}else if(earlyTime > 0 ){
			attOffStatus = Constants_DIC.DIC_WORK_STATUS_LATEWORK;//EARLYTIME
			attEarlyTime = String.valueOf((int)earlyTime);
		}else{
			attOffStatus = Constants_DIC.DIC_WORK_STATUS_ONWORK;//ONTIME
		}
		ErpAttendance insertModel = new ErpAttendance();
		insertModel.setWorkOffType(Byte.valueOf(workType));
		insertModel.setAttOffTime(DateTimeHelper.formatDateTimetoString(nowTime));
		insertModel.setAttOffStatus(Byte.valueOf(attOffStatus));
		insertModel.setAttEarlyTime(StringUtil.parseInteger(attEarlyTime));
		insertModel.setCreateWorkoffUser(param.getCurrentUserId());
		insertModel.setShardCityId(cityId);
		insertModel.setAttEarlyReason(param.getAttLateReason());
		insertModel.setAttDate(DateTimeHelper.formatDateTimetoString(nowTime,DateTimeHelper.FMT_yyyyMMdd));
		String workTypeCondition = null;
		if("1".equals(attendanceModel)){
			workTypeCondition = Constants_DIC.WORKOFFTOON.get(workType);
		}
		ErpAttendance erpAttendance = erpAttendanceMapper.selectByDateAndUserId(cityId,DateTimeHelper.formatDateTimetoString(nowTime,"yyyy-MM-dd"),param.getAttUser(),workTypeCondition,null);
		if(erpAttendance!=null&&erpAttendance.getAttOnStatus()!=null){
			insertModel.setAttId(erpAttendance.getAttId());
			//如果状态为旷工，则更新上班状态为旷工
			if(Constants_DIC.DIC_WORK_STATUS_FREE.equals(attOffStatus)){
				insertModel.setAttOnStatus(Byte.valueOf(attOffStatus));
			//如果上班状态为旷工，则状态为旷工
			}else if(Constants_DIC.DIC_WORK_STATUS_FREE.equals(erpAttendance.getAttOffStatus())){
				insertModel.setAttOffStatus(Byte.valueOf(Constants_DIC.DIC_WORK_STATUS_FREE));
			}
			insertModel.setWorkOffType(Byte.valueOf(workType));
			//下午说明
			insertModel.setAttEarlyReason(param.getAttLateReason());
			erpAttendanceMapper.updateByPrimaryKeySelective(insertModel);
		}else {
			insertModel.setCompId(param.getCompId());
			insertModel.setAttDate(DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd"));
			//如果未打上班考勤，则补充上、下班为旷工
			insertModel.setAttOffStatus(Byte.valueOf(Constants_DIC.DIC_WORK_STATUS_FREE));
			insertModel.setAttOnStatus(Byte.valueOf(Constants_DIC.DIC_WORK_STATUS_FREE));
			insertModel.setAttOnTime(DateTimeHelper.formatDateTimetoString(nowTime));
			if(erpFunUsers!=null){
				insertModel.setDeptId(erpFunUsers.getDeptId());
			}
			insertModel.setAttLateReason("未打上班考勤！");
			insertModel.setCreateWorkoffUser(param.getCurrentUserId());
			insertModel.setAttEarlyReason(param.getAttLateReason());
			insertModel.setAttUser(param.getAttUser());
			insertModel.setWorkOffType(Byte.valueOf(workType));
			erpAttendanceMapper.insertSelective(insertModel);
		}
	}

	@Override
	public List getMgrStatList(BaseMapParam param) throws Exception {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<ErpAttendance> list = getStatList(param);
		List<ErpFunUsers> userList = getUserList(param);
		List<ErpFineDto> fineList = getFineTotal(param);
		List returnList = new ArrayList();
		String date = param.getString("attendanceDate");
		String[] dateArr = date.split("-");
		date = date+"-01";
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(date));*/
		HashMap hm = new HashMap();
		hm.put("year", dateArr[0]);
		hm.put("month", dateArr[1]);
		hm.put("days", DateTimeHelper.getDaysOfMonth(DateTimeHelper.parseToDate(date)));
		hm.put("deptId", param.getInteger("deptId"));
		List tmp = new ArrayList();
		tmp.add(hm);
		dataMap.put("atts", list);
		dataMap.put("users", userList);
		dataMap.put("fines", fineList);
		dataMap.put("info",  tmp);
		returnList.add(dataMap);
		//这个是很大的坑，现在为了做桥接，暂时不改
/*		HashMap hm = new HashMap();
		hm.put("year", year);
		hm.put("month", month);
		hm.put("days", String.valueOf(days));
		hm.put("deptId", deptId);
		List tmp = new ArrayList();
		tmp.add(hm);
		HashMap dataM = new HashMap();
		dataM.put("users", usersList);
		dataM.put("fines", fineTotalList);
		dataM.put("atts", attsList);
		dataM.put("INFO", tmp);
		List returnList = new ArrayList();
		returnList.add(dataM);
		returnMap.put("DATA", returnList);*/
		return returnList;
	}

	private List<ErpFineDto> getFineTotal(BaseMapParam param) throws Exception {
		Date nowDay = DateTimeHelper.getSystemDate();
		String statStart = param.getString("attendanceDate")+"-01 00:00:00";
		String statEnd = param.getString("attendanceDate") +"-"+ DateTimeHelper.getDaysOfMonth(nowDay) + " 23:59:59";
		param.setString("statStart", statStart);
		param.setString("statEnd", statEnd);
		List<ErpFineDto> list = erpFineMapper.getFineTotal(param.getInteger("cityId"),param.getMap());
		return list;
	}

	private List<ErpFunUsers> getUserList(BaseMapParam param) throws Exception {
		Date nowDay = DateTimeHelper.getSystemDate();
		String statStart = param.getString("attendanceDate")+"-01 00:00:00";
		String statEnd = param.getString("attendanceDate") +"-"+ DateTimeHelper.getDaysOfMonth(nowDay) + " 23:59:59";
		List<ErpFunUsers> returnFunUserList = new ArrayList<ErpFunUsers>();
		Date startDate = DateTimeHelper.parseToDate(statStart, "yyyy-MM-dd HH:mm:ss");
//		List<ErpFunUsers> list = erpFunUsersService.getUserListByCompId(param.getInteger("cityId"),param.getInteger("compId"));
		List<ErpFunUsers> list = erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(param.getInteger("cityId"),param.getInteger("compId"), 0);
		for (ErpFunUsers erpFunUsers : list) {
			if (param.getInteger("deptId").equals(erpFunUsers.getDeptId())) {
				String updateTime = erpFunUsers.getWriteoffTime();
				boolean writeoff = erpFunUsers.getUserWriteoff();
				if (!writeoff
						|| (writeoff && updateTime != null && DateTimeHelper.compareTwoDate(startDate,
								DateTimeHelper.parseToDate(updateTime, "yyyy-MM-dd HH:mm:ss")) != -1)) {
					returnFunUserList.add(erpFunUsers);
				}
			}
		}
		return returnFunUserList;
	}

	private List<ErpAttendance> getStatList(BaseMapParam param) throws Exception {
		Calendar calendar = Calendar.getInstance();
		String statStart = param.getString("attendanceDate")+"-01 00:00:00";
		calendar.setTime(DateTimeHelper.parseToDate(statStart));
		String statEnd = param.getString("attendanceDate") +"-"+ DateTimeHelper.getDaysOfMonth(calendar.getTime()) + " 23:59:59";
		param.setObject("statStart",statStart);
		param.setObject("statEnd", statEnd);
		String paramValue = erpSysParaMapper.getParamValue(param.getInteger("cityId"), param.getInteger("compId"), "ATTENDANCE_MODEL");
		param.setString("attendanceModel", paramValue);
		if(StringUtils.isNotBlank(param.getString("workType"))){
			param.setString("workOffType",Constants_DIC.WORKONTOOFF.get(param.getString("workType")));
		}
		return erpAttendanceMapper.selectStatList(param.getInteger("cityId"),param.getMap());
	}

	@Transactional
	@Override
	public Integer updateMgrAtt(UpdateAttenceOffCountParam param) throws Exception{
		ErpAttendanceChangeRecord erpAttendanceChangeRecord = new ErpAttendanceChangeRecord();
		ErpAttendance erpAttendance = BeanUtilsHelper.convertClass(param, ErpAttendance.class);
		if (!("FINE").equals(param.getTargetWorkStatus())) {
			erpAttendance.setUpdateTime(DateTimeHelper.getSystemDate());
			erpAttendanceChangeRecord.setCompId(param.getCompId());
			erpAttendanceChangeRecord.setCreateTime(DateTimeHelper.getSystemDate());
			erpAttendanceChangeRecord.setChangeUserId(param.getCurrentUserId());
			erpAttendanceChangeRecord.setChangeUserName(param.getCurrentUserName());
			erpAttendanceChangeRecord.setChangeReason(param.getAttReason());
			erpAttendanceChangeRecord.setAttendanceId(param.getAttId());
			erpAttendanceChangeRecord.setWorkType(Byte.valueOf(param.getWorkDetailType()));
			erpAttendanceChangeRecord.setSourceUserId(param.getSourceUserId());
			erpAttendanceChangeRecord.setSourceDeptId(param.getSourceDeptId());
			erpAttendanceChangeRecord.setSourceUserName(param.getCurrentUserName());
			erpAttendanceChangeRecord.setSourceCreateTime(DateTimeHelper.parseToDate(param.getAttDate()));
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(param.getCityId(), param.getSourceUserId());
			if (erpFunUsers != null) {
				erpAttendanceChangeRecord.setOrganizationPath(erpFunUsers.getTissueLine());//zt组织机构
			}

			String changeStatus = "";
			switch (param.getSourceWorkStatus()) {
			case "1":
				changeStatus = "准时->";
				break;
			case "2":
				changeStatus = "迟到->";
				break;
			case "3":
				changeStatus = "早退->";
				break;
			case "4":
				changeStatus = "旷工->";
				break;
			case "5":
				changeStatus = "病假->";
				break;
			case "6":
				changeStatus = "事假->";
				break;
			case "7":
				changeStatus = "休假->";
				break;
			default:
				changeStatus = "空->";
				break;
			}
			switch (param.getTargetWorkStatus()) {
			case "1":
				changeStatus += "准时";
				break;
			case "2":
				changeStatus += "迟到";
				break;
			case "3":
				changeStatus += "早退";
				break;
			case "4":
				changeStatus += "旷工";
				break;
			case "5":
				changeStatus += "病假";
				break;
			case "6":
				changeStatus += "事假";
				break;
			case "7":
				changeStatus += "休假";
				break;
			}
			erpAttendanceChangeRecord.setChangeState(changeStatus);
			erpAttendance.setUpdateUser(param.getCurrentUserId());
			erpAttendance.setShardCityId(param.getCityId());
			if ("up".equals(param.getFlag())) {
				erpAttendance.setAttOnStatus(Byte.valueOf(param.getTargetWorkStatus()));
				erpAttendance.setAttLateReason(param.getAttReason());
				erpAttendance.setAttOnTime(param.getAttDate());
				if (StringUtils.isNotBlank(param.getWorkDetailType())) {
					param.setWorkDetailType(Constants_DIC.DIC_WORK_TYPE_ONWORK);
				}
				erpAttendance.setWorkOnType(Byte.valueOf(param.getTargetWorkStatus()));
				erpAttendanceChangeRecord.setWorkDetailType(Byte.valueOf(param.getWorkDetailType()));
			} else if (("down").equals(param.getFlag())) {
				erpAttendance.setAttOffStatus(Byte.valueOf(changeStatus));
				erpAttendance.setAttEarlyReason(param.getAttReason());
				erpAttendance.setAttOffTime(param.getAttDate());
				if (StringUtils.isNotBlank(param.getWorkDetailType())) {
					param.setWorkDetailType(Constants_DIC.DIC_WORK_TYPE_FREE);
				}
				erpAttendance.setWorkOffType(Byte.valueOf(param.getWorkDetailType()));
				erpAttendanceChangeRecord.setWorkDetailType(Byte.valueOf(param.getWorkDetailType()));
			}
			Integer attID = null;
			if (erpAttendance.getAttId() != null) {
				erpAttendance.setShardCityId(param.getCityId());
				erpAttendanceMapper.updateByPrimaryKeySelective(erpAttendance);
				attID = erpAttendance.getAttId();
				erpAttendanceChangeRecord.setShardCityId(param.getCityId());
				erpAttendanceChangeRecordMapper.insertSelective(erpAttendanceChangeRecord);
			} else {
				erpAttendance.setShardCityId(param.getCityId());
				erpAttendance.setCompId(param.getCompId());
				erpAttendance.setAttDate(param.getFineTime());
				erpAttendanceChangeRecord.setShardCityId(param.getCityId());
				if (("up").equals(param.getFlag())) {
					erpAttendanceChangeRecord.setWorkDetailType(Byte.valueOf(Constants_DIC.DIC_WORK_TYPE_ONWORK));
					erpAttendance.setWorkOnType(Byte.valueOf(Constants_DIC.DIC_WORK_TYPE_ONWORK));
				}
				if (("down").equals(param.getFlag())) {
					erpAttendanceChangeRecord.setWorkDetailType(Byte.valueOf(Constants_DIC.DIC_WORK_TYPE_FREE));
					erpAttendance.setWorkOffType(Byte.valueOf(Constants_DIC.DIC_WORK_TYPE_FREE));
				}
				erpAttendanceMapper.insertSelective(erpAttendance);
				attID = erpAttendance.getAttId();
				erpAttendanceChangeRecord.setAttendanceId(erpAttendance.getAttId());
				erpAttendanceChangeRecordMapper.insertSelective(erpAttendanceChangeRecord);
			}
			return attID;
		} else {
			ErpFine fine = BeanUtilsHelper.convertClass(param, ErpFine.class);
			fine.setShardCityId(param.getCityId());
			erpFineMapper.insertSelective(fine);
			return erpAttendance.getAttId();
		}
	}
	@Override
	public void updateMgrAttForLeaveAudit(Integer cityId, Integer compId, Integer currentUserId, String currentUserName, String attReason,
			Integer sourceUserId, Integer sourceDeptId, Date startTime, Date endTime, Integer leaveStartType, Integer leaveEndType) {
		Byte targetWorkStatus = Byte.valueOf(Const.DIC_WORK_STATUS_EARYFREE);
		String startTimeStr = DateTimeHelper.formatDateTimetoString(startTime);
		String endTimeStr = DateTimeHelper.formatDateTimetoString(endTime);
		ErpAttendance erpAttendance = new ErpAttendance();
		// TODO 交互没出这里没法写了
//		if ("up".equals(flag)) {
//			erpAttendance.setAttOnStatus(targetWorkStatus);
//			erpAttendance.setAttLateReason(attReason);
//			erpAttendance.setAttOnTime(startTimeStr);
//			erpAttendance.setWorkOnType(targetWorkStatus);
//		} else if ("down".equals(flag)) {
//			erpAttendance.setAttOffStatus(targetWorkStatus);
//			erpAttendance.setAttEarlyReason(attReason);
//			erpAttendance.setAttOffTime(endTimeStr);
//			erpAttendance.setWorkOffType(targetWorkStatus);
//		}
		erpAttendance.setUpdateUser(currentUserId);
		erpAttendance.setShardCityId(cityId);
		erpAttendance.setUpdateTime(DateTimeHelper.getSystemDate());
		// 查询是否存在
		ErpAttendance attendanceSel = erpAttendanceMapper.selectByDateAndUserId(cityId, startTimeStr, sourceUserId, null, null);
		Byte sourceWorkStatus = 0;
		if (attendanceSel == null) {
			erpAttendance.setAttUser(sourceUserId);
			erpAttendance.setCompId(compId);
			erpAttendance.setAttDate(startTimeStr);
			erpAttendanceMapper.insertSelective(erpAttendance);
		} else {
			erpAttendance.setAttId(attendanceSel.getAttId());
			erpAttendanceMapper.updateByPrimaryKeySelective(erpAttendance);
//			sourceWorkStatus = attendanceSel.getAttOnStatus();
//			// 修改记录
//			ErpAttendanceChangeRecord changeRecord = new ErpAttendanceChangeRecord();
//			changeRecord.setWorkDetailType(targetWorkStatus);
//			changeRecord.setCompId(compId);
//			changeRecord.setCreateTime(new Date());
//			changeRecord.setChangeUserId(currentUserId);
//			changeRecord.setChangeUserName(currentUserName);
//			changeRecord.setChangeReason(attReason);
//			changeRecord.setWorkType(targetWorkStatus);
//			changeRecord.setSourceUserId(sourceUserId);
//			changeRecord.setSourceDeptId(sourceDeptId);
//			changeRecord.setSourceUserName(currentUserName);
//			String changeStatus = this.getWorkStatusCn(sourceWorkStatus.intValue()) + "->"
//					+ this.getWorkStatusCn(targetWorkStatus.intValue());
//			changeRecord.setChangeState(changeStatus);
//			changeRecord.setShardCityId(cityId);
//			changeRecord.setAttendanceId(erpAttendance.getAttId());
//			erpAttendanceChangeRecordMapper.insertSelective(changeRecord);
		}
	}

	private String getWorkStatusCn(Integer workStatus) {
		if(workStatus == 1)return "准时";
		if(workStatus == 2)return "迟到";
		if(workStatus == 3)return "早退";
		if(workStatus == 4)return "旷工";
		if(workStatus == 5)return "病假";
		if(workStatus == 6)return "事假";
		if(workStatus == 7)return "休假";
		return "空";
	}

	@Override
	public List<ErpAttendanceDto> getAttendanceList(BaseMapParam param) throws Exception {
		String deptId = param.getString("deptId");
		Integer regId = param.getInteger("regId");
		Integer areaId = param.getInteger("areaId");
		param.setInteger("compId", param.getInteger("compId"));
		String[] deptIds=null;
		if(StringUtils.isNotBlank(deptId)){
			deptIds=new String[]{deptId};
		}
		ErpFunDepts record = new ErpFunDepts();
		if(regId!=null) {
			record.setRegId(regId);
			List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByRange(param.getInteger("cityId"), record);
			deptIds=BeanUtil.buildQueryKeys(list, "deptId");
		}else if(areaId!=null) {
			record.setAreaId(areaId);
			List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByRange(param.getInteger("cityId"), record);
			deptIds=BeanUtil.buildQueryKeys(list, "deptId");
		}
		if(deptIds!=null && deptIds.length > 0){
			param.setObject("deptIds", deptIds);
		}
		String paramValue = erpSysParaMapper.getParamValue(param.getInteger("cityId"), param.getInteger("compId"), "ATTENDANCE_MODEL");
		param.setString("attendanceModel", paramValue);
		List<ErpAttendanceDto> list = erpAttendanceMapper.selectAttendanceListByParam(param.getInteger("cityId"), param.getMap());
		if(list.isEmpty()){
			return list;
		}
		Set<Integer> userIds = new HashSet<Integer>();
		for(ErpAttendanceDto dto:list){
			if(dto.getAttUser()!=null){
				userIds.add(dto.getAttUser());
			}
			if(dto.getUpdateUser()!=null){
				userIds.add(dto.getUpdateUser());
			}
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(param.getInteger("cityId"), userIds);
		Map<Object,ErpFunUsers> userMap = BeanUtilsHelper.listToMapObjectOffKeyType(userList,"userId");
		for(ErpAttendanceDto dto:list){
			if(dto.getAttUser()!=null){
				ErpFunUsers erpFunUsers = userMap.get(dto.getAttUser());
				if(erpFunUsers!=null){
					dto.setUserName(erpFunUsers.getUserName());
				}
			}
			if(dto.getUpdateUser()!=null){
				ErpFunUsers erpFunUsers = userMap.get(dto.getUpdateUser());
				if(erpFunUsers!=null){
					dto.setUpdateUserName(erpFunUsers.getUserName());
				}
			}
		}
		return list;
	}
}



