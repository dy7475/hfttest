package com.myfun.erpWeb.businesstools.Attendance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.businesstools.Attendance.param.AttendanceOnAndOffParam;
import com.myfun.erpWeb.businesstools.Attendance.param.AttendanceParam;
import com.myfun.erpWeb.businesstools.Attendance.param.GetMgrFineListParam;
import com.myfun.erpWeb.businesstools.Attendance.vo.GetMgrFineListVo;
import com.myfun.erpWeb.businesstools.vo.GetMgrOutLogListVo;
import com.myfun.erpWeb.common.vo.ErpCompRolesVo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAttendanceMapper;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFineMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpOutLogMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpAttendanceDto;
import com.myfun.repository.erpdb.dto.ErpFineDto;
import com.myfun.repository.erpdb.dto.ErpOutLogDto;
import com.myfun.repository.erpdb.po.ErpAttendance;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpAttendanceSerice;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpOutLogService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateAttendanceParam;
import com.myfun.service.business.erpdb.bean.param.CreateOutLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;
import com.myfun.service.business.erpdb.bean.param.UpdateAttenceOffCountParam;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
* @ClassName: FunAttendanceController
* @Description: 考勤管理类
* @author 方李骥
* @date 2016-9-24 下午5:53:13
 */
@Api(tags = "考勤管理模块")
@RequestMapping(value="/businesstools/attendance",method=RequestMethod.POST)
@RestController
public class FunAttendanceController extends BaseController{
	@Autowired
	ErpAttendanceMapper erpAttendanceMapper;
	@Autowired
	ErpAttendanceSerice erpAttendanceSerice;
	@Autowired
	ErpOutLogService erpOutLogService;
	@Autowired
	ErpFineMapper erpFineMapper;
	@Autowired
	ErpFunDeptsService erpFunDeptsService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpOutLogMapper erpOutLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;


	/**
	 * 获取上下班人数
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取上下班人数")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/getAttendanceOnAndOff")
	public ResponseJson getAttendanceOnAndOff(@Valid @RequestBody AttendanceOnAndOffParam param) throws Exception{
		Operator operator = getOperator();
		String deptId = param.getDeptId();
		Integer regId = param.getRegId();
		Integer areaId = param.getAreaId();
		param.setCompId(operator.getCompId());
		String[] deptIds=null;
		if(StringUtils.isNotBlank(deptId)){
			deptIds=new String[]{deptId};
		}
		ErpFunDepts record = new ErpFunDepts();
		if(regId!=null) {
			record.setRegId(regId);
			List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByRange(operator.getCityId(), record);
			deptIds=BeanUtil.buildQueryKeys(list, "deptId");
		}else if(areaId!=null) {
			record.setAreaId(areaId);
			List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByRange(operator.getCityId(), record);
			deptIds=BeanUtil.buildQueryKeys(list, "deptId");
		}
		if(deptIds!=null && deptIds.length > 0){
			param.setDeptIds(deptIds);
		}
		String paramValue = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ATTENDANCE_MODEL");
		param.setAttendanceModel(paramValue);
		Map<String,Object> resultMap = erpAttendanceMapper.getAttendanceOnAndOff(operator.getCityId(),param);
		return ErpResponseJson.ok(resultMap);
	}

	/**
	* @Date:2016-10-13
	* @Athor:方李骥
	* @Title: insertAttendance
	* @Description: (新增考勤)
	* @param param
	* @return
	* @throws Exception
	* @return ResponseJson    返回类型
	* @throws
	 */
	@ApiOperation("新增考勤")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/insertAttendance")
	public ResponseJson insertAttendance(@Valid @RequestBody CreateOrUpdateAttendanceParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		erpAttendanceSerice.insertAttendance(getOperator().getCityId(),param);
		return ErpResponseJson.ok();
	}

	/**
	 * @Date:2016-10-13
	 * @Athor:方李骥
	 * @Title: createOutLog
	 * @Description: 填写外出登录日志
	 * @param param
	 * @return
	 * @throws Exception
	 * @return ResponseJson    返回类型
	 * @throws
	 */
	@ApiOperation("填写外出登录日志")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/createOutLog")
	public ResponseJson createOutLog(@Valid @RequestBody CreateOutLogParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		erpOutLogService.createOutLog(getOperator().getCityId(),param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取外出登记日志列表
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取外出登记日志列表,需求:8214,作者:陈峰")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/getMgrOutLogList")
	@Deprecated
	public ResponseJson getMgrOutLogList(@Valid @RequestBody QueryOutLogParam param) throws Exception{
		GetMgrOutLogListVo getMgrOutLogListVo = new GetMgrOutLogListVo();
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getOutTime1(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getOutTime2(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("OUT_TIME DESC");
		Integer cityId = getOperator().getCityId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer grId = param.getGrId();
		Integer userId = param.getUserId();
		Integer deptId = param.getDeptId();
		Map<Integer, ErpFunUsers> userMap = new HashMap<Integer, ErpFunUsers>();
		Map<Integer, ErpFunDepts> deptMap = new HashMap<Integer, ErpFunDepts>();
		List<Integer> deptIds = new ArrayList<>();
		List<ErpOutLogDto> list = new ArrayList<ErpOutLogDto>();
		if (userId != null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
			userMap.put(userId, erpFunUsers);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptId(cityId, erpFunUsers.getDeptId());
			deptMap.put(erpFunUsers.getDeptId(), erpFunDepts);
		} else if (deptId != null) {
			deptIds.add(deptId);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getUserListByDeptId(cityId, deptId);
			Map<Integer, ErpFunUsers> usersTempMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers :: getUserId, user -> user, (oldValue, newValue) -> oldValue));
			userMap.putAll(usersTempMap);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptId(cityId, deptId);
			deptMap.put(deptId, erpFunDepts);
		} else {
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getFunUsersListByCompId(cityId, getOperator().getCompId());
			Map<Integer, ErpFunUsers> usersTempMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers :: getUserId, user -> user, (oldValue, newValue) -> oldValue));
			userMap.putAll(usersTempMap);
			ErpFunDepts erpFunDepts = new ErpFunDepts();
			erpFunDepts.setShardCityId(cityId);
			erpFunDepts.setCompId(getOperator().getCompId());
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListByCompId(erpFunDepts);
			Map<Integer, ErpFunDepts> deptTempMap = erpFunDeptsList.stream().collect(Collectors.toMap(ErpFunDepts :: getDeptId, dept -> dept, (oldValue, newValue) -> oldValue));
			deptMap.putAll(deptTempMap);
		}
		ErpFunDepts queryDeptCondition = new ErpFunDepts();
		queryDeptCondition.setCompId(param.getCompId());
		queryDeptCondition.setShardCityId(cityId);
		if (areaId != null) {
			queryDeptCondition.setAreaId(param.getAreaId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			List<String> deptsList = Arrays.asList(BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId"));
			deptsList.stream().forEach(a -> {
				deptIds.add(StringUtil.parseInteger(a));
			});
		}
		if (regId != null) {
			queryDeptCondition.setRegId(param.getRegId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			List<String> deptsList = Arrays.asList(BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId"));
			deptsList.stream().forEach(a -> {
				deptIds.add(StringUtil.parseInteger(a));
			});
		}

		//选择分组的情况
		List<Integer> userIds = new ArrayList<Integer>();
		if (grId != null && userId == null) {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andGrIdEqualTo(grId).andUserWriteoffEqualTo(false);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			List<String> userIdList = Arrays.asList(BeanUtil.buildQueryKeys(erpFunUsersList, "userId"));
			if (userIdList.size() > 0) {
				userIdList.stream().forEach(a -> {
					userIds.add(StringUtil.parseInteger(a));
				});
			} else {
				list = Collections.emptyList();
			}
		}
		list = erpOutLogMapper.selectOutLogListByDeptAndUserId(cityId, param, userIds, deptIds);
		if (!list.isEmpty()) {
			for (ErpOutLogDto dto : list) {
				if (dto != null) {
					if (deptMap.get(dto.getDeptId()) != null) {
						dto.setDeptName(deptMap.get(dto.getDeptId()).getDeptName());
					}
				}
			}
		}
		getMgrOutLogListVo.setList(list);
		return ErpResponseJson.ok(getMgrOutLogListVo);
		
	  /*GetMgrOutLogListVo getMgrOutLogListVo = new GetMgrOutLogListVo();
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getOutTime1(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getOutTime2(), "yyyy-MM-dd 23:59:59"));
		Integer cityId = getOperator().getCityId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		String[] deptIds = null;
		ErpFunDepts queryDeptCondition = new ErpFunDepts();
		queryDeptCondition.setCompId(param.getCompId());
		queryDeptCondition.setShardCityId(cityId);
		if (areaId != null) {
			queryDeptCondition.setAreaId(param.getAreaId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			deptIds = BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId");
		}
		if (regId != null) {
			queryDeptCondition.setRegId(param.getRegId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			deptIds = BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId");
		}
		if (deptId != null) {
			deptIds = new String[] { deptId.toString() };
		}
		if (deptIds != null && deptIds.length <= 0) {
			deptIds = null;
		}
		List<ErpOutLogDto> list = erpOutLogMapper.selectOutLogList(cityId, param, deptIds);
		ErpFunDepts condition = new ErpFunDepts();
		condition.setCompId(param.getCompId());
		Map<Object, ErpFunDepts> map = erpFunDeptsService.getAllDeptListByRange(cityId, condition);
		if (!list.isEmpty()) {
			for (ErpOutLogDto dto : list) {
				if (dto != null) {
					if (map.get(dto.getDeptId()) != null) {
						dto.setDeptName(map.get(dto.getDeptId()).getDeptName());
					}
				}
			}
		}
		getMgrOutLogListVo.setList(list);
		return ErpResponseJson.ok(getMgrOutLogListVo);*/
	}

	/**
	 * @Date:2016-10-14
	 * @Athor:方李骥
	 * @Title: getMgrStatList
	 * @Description: 外出登记日志
	 * @param param attendanceDate//统计考勤的日期
	 * @return
	 * @throws Exception
	 * @return ResponseJson    返回类型
	 * @throws
	 */
	@ApiOperation("外出登记日志")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/getMgrStatList")
	@NotBlank({"attendanceDate","deptId"})
	public ResponseJson getMgrStatList(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
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
		return ErpResponseJson.ok(returnList);
	}

	/**
	 * @Date:2016-10-19
	 * @Athor:方李骥
	 * @Title: updateMgrAtt
	 * @Description: 更新考勤
	 * @param param
	 * @return
	 * @throws Exception
	 * @return ResponseJson    返回类型
	 * @throws
	 */
	@RequestMapping("/updateMgrAtt")
	public ResponseJson updateMgrAtt(@Valid @RequestBody UpdateAttenceOffCountParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setCityId(getOperator().getCityId());
		erpAttendanceSerice.updateMgrAtt(param);
		ErpResponseJson json = new ErpResponseJson();
		json.setErrCode(Const.ResponseCode.SUCCESS);
		json.setErrMsg("更新考勤成功!");
		return json;
	}

//	/**
//	 * @Date:2016-10-20
//	 * @Athor:方李骥
//	 * @Title: getMgrFineList
//	 * @Description: 获取罚款列表
//	 * @param param
//	 * @return
//	 * @throws Exception
//	 * @return ResponseJson    返回类型
//	 * @throws
//	 */
//	@RequestMapping("/getMgrFineList")
//	@NotBlank({"fineDest","fineTime"})
//	public ResponseJson getMgrFineList(@Valid @RequestBody BaseMapParam param){
//		param.setString("currentUserName", getCurrentUserName());
//		param.setString("userName",getOperator().getUserName());
//		param.setInteger("currentDeptId", getOperator().getDeptId());
//		param.setInteger("compId", getOperator().getCompId());
//		param.setInteger("currentUserId",getOperator().getUserId());
//		param.setInteger("cityId", getOperator().getCityId());
//		String fineTime = param.getString("fineTime");
//		Date fineDate  = DateTimeHelper.parseToDate(fineTime);
//		int year = DateTimeHelper.getYearOfDate(fineDate);
//		int month = DateTimeHelper.getMonthOfYear(fineDate);
//		String statStart = year + "-" + month + "-01 00:00:00";
//		String statEnd = year + "-" + month + "-" + DateTimeHelper.getDaysOfMonth(fineDate) + " 23:59:59";
//		param.setString("statStart", statStart);
//		param.setString("statEnd", statEnd);
//		List<ErpFine> list = erpFineMapper.selectMgrFineList(param.getInteger("cityId"),param.getMap());
//		ErpResponseJson json = new ErpResponseJson();
//		json.setErrCode(Const.ResponseCode.SUCCESS);
//		json.setData(list);
//		json.setErrMsg("成功!");
//		return json;
//	}

	/**
	 * @Date:2018-10-20
	 * @Athor:王淳
	 * @Title: getMgrFineList
	 * @Description: 获取罚款列表
	 * @param param
	 * @return
	 */
	@ApiOperation("获取罚款列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/getMgrFineList")
	@NotBlank({"fineDest","fineTime"})
	public ResponseJson getMgrFineList(@Valid @RequestBody GetMgrFineListParam param){
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId( getOperator().getDeptId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		String fineTime = param.getFineTime();
		Date fineDate = DateTimeHelper.parseToDate(fineTime);
		int year = DateTimeHelper.getYearOfDate(fineDate);
		int month = DateTimeHelper.getMonthOfYear(fineDate);
		String statStart = year + "-" + month + "-01 00:00:00";
		String statEnd = year + "-" + month + "-" + DateTimeHelper.getDaysOfMonth(fineDate) + " 23:59:59";
		param.setStatStart(statStart);
		param.setStatEnd(statEnd);
		GetMgrFineListVo vo = new GetMgrFineListVo();
		vo.setList(erpFineMapper.selectMgrFineList(getOperator().getCityId(),param));
		return ErpResponseJson.ok(vo);
	}


	/**
	 * 员工考勤
	 * flj
	 * @throws Exception
	 * **/
	@ApiOperation("员工考勤")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpAttendanceDto.class, message = "成功")
	})
	@PostMapping("/getMgrAttendanceList")
	public ErpResponseJson getAttendanceList(@Valid @RequestBody AttendanceParam param) {
		/*param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		List<ErpAttendanceDto> resList = erpAttendanceSerice.getAttendanceList(param);
		ErpResponseJson erpResponseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resList);
		return erpResponseJson;*/
		Operator operator = getOperator();
		Byte workType = param.getWorkType();
		String attDate1 = param.getAttDate1();
		String attDate2 = param.getAttDate2();
		param.setCompId(operator.getCompId());
		String attendanceModel = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ATTENDANCE_MODEL");
		if ("1".equals(attendanceModel)) {
			if (workType != null) {
				param.setWorkOnType(workType);
				param.setWorkOffType(StringUtil.parseByte(Const.WORKONTOOFF.get(workType)));
			}
		}
		if (StringUtils.isNotBlank(attDate1)) {
			param.setAttDate1(DateTimeHelper.formatDateTimetoString(attDate1, "yyyy-MM-dd 00:00:00"));
		}
		if (StringUtils.isNotBlank(attDate2)) {
			param.setAttDate2(DateTimeHelper.formatDateTimetoString(attDate2, "yyyy-MM-dd 23:59:59"));
		}
		List<ErpAttendanceDto> resList = erpAttendanceMapper.getAttendanceList(operator.getCityId(), param);
		if (resList != null && resList.isEmpty()) {
			return ErpResponseJson.ok(resList);
		}
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(operator.getCityId());
		usersExample.createCriteria().andCompIdEqualTo(operator.getCompId());
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(usersExample);
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user));
		resList.forEach(attendanceDto -> {
			ErpFunUsers users = usersMap.get(attendanceDto.getAttUser());
			if (users != null) {
				attendanceDto.setUserName(users.getUserName());
			}
			users = usersMap.get(attendanceDto.getUpdateUser());
			if (users != null) {
				attendanceDto.setUpdateUserName(users.getUserName());
			}
		});
		return ErpResponseJson.ok(resList);
	}

	/**
	 * 获取权限角色列表
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/17
	 * @return
	 */
	@ApiOperation("获取权限角色列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpCompRolesVo.class, message = "成功")})
	@RequestMapping("/getMgrRoleList")
	public ErpResponseJson getMgrRoleList(@RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer compType = operator.getCompType(); // 企业类型，1=企业版2=专业版3=赢销版0=城市 4=新赢销版 5=物业版
		boolean isMix = Const.DIC_DEPT_TYPE_3.equals(compType) || (Const.DIC_COMP_TYPE_4.equals(compType));
		boolean propertyFlag = false; // 物业版查询出所有权限 Const.DIC_COMP_TYPE_5.equals(compType);
		boolean signleDeptFlag = Const.DIC_COMP_TYPE_6.equals(compType);
		boolean newHouseFlag = Const.DIC_COMP_TYPE_7.equals(compType);
		List<ErpCompRoles> erpCompRolesList = erpCompRolesMapper.getLowerRolesList(operator.getCityId(), operator.getCompId(), operator.getUserPosition(), isMix, propertyFlag);
		// 去掉系统管理员职位 陈文超
		for (Integer i = erpCompRolesList.size()-1 ; i>=0; i--) {
			ErpCompRoles erpCompRoles = erpCompRolesList.get(i);
			if(propertyFlag){
				if("COMMON_BIZ".equals(erpCompRoles.getRoleId()) && "正式经纪人".equals(erpCompRoles.getRoleName())){
					erpCompRoles.setRoleName("项目员工");
				} else if ("BRANCH_MANAGER".equals(erpCompRoles.getRoleId()) && "门店经理".equals(erpCompRoles.getRoleName())){
					erpCompRoles.setRoleName("项目经理");
				}
			}
			if (signleDeptFlag && ("BIZ_GENERAL".equals(erpCompRoles.getRoleId()) || "REGION_MANAGER".equals(erpCompRoles.getRoleId()))) {
				erpCompRolesList.remove(erpCompRoles);
			}
			if (Const.DIC_ROLE_NAME_SYSTEM_MANAGE.equals(erpCompRoles.getRoleId())) {
				erpCompRolesList.remove(erpCompRoles);
			}

			if(newHouseFlag) {
				Byte isCompRole = erpCompRoles.getIsCompRole();
				// 新房版  移除 系统角色  除开总经理和经纪人
				if(null != isCompRole && 0 == isCompRole && !Const.DIC_ROLE_NAME_COMMON_BIZ.equals(erpCompRoles.getRoleId())
						&& !Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(erpCompRoles.getRoleId())) {
					erpCompRolesList.remove(erpCompRoles);
				}

			}

		}
		ErpCompRolesVo erpCompRolesVo = new ErpCompRolesVo();
		erpCompRolesVo.setCompRolesList(erpCompRolesList);
		return ErpResponseJson.ok(erpCompRolesVo);
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

	private List<ErpFunUsers> getUserList(BaseMapParam param) throws Exception {
		Date nowDay = DateTimeHelper.getSystemDate();
		String statStart = param.getString("attendanceDate")+"-01 00:00:00";
		String statEnd = param.getString("attendanceDate") +"-"+ DateTimeHelper.getDaysOfMonth(nowDay) + " 23:59:59";
		List<ErpFunUsers> returnFunUserList = new ArrayList<ErpFunUsers>();
		Date startDate = DateTimeHelper.parseToDate(statStart, "yyyy-MM-dd HH:mm:ss");
		List<ErpFunUsers> list = erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(param.getInteger("cityId"), param.getInteger("compId"), 0);
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

	private List<ErpFineDto> getFineTotal(BaseMapParam param) throws Exception {
		Date nowDay = DateTimeHelper.getSystemDate();
		String statStart = param.getString("attendanceDate")+"-01 00:00:00";
		String statEnd = param.getString("attendanceDate") +"-"+ DateTimeHelper.getDaysOfMonth(nowDay) + " 23:59:59";
		param.setString("statStart", statStart);
		param.setString("statEnd", statEnd);
		List<ErpFineDto> list = erpFineMapper.getFineTotal(param.getInteger("cityId"),param.getMap());
		return list;
	}
}
