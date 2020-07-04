package com.myfun.erpWeb.managecenter.attendance;

import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunAttFestivalMapper;
import com.myfun.repository.admindb.po.AdminFunAttFestival;
import com.myfun.repository.admindb.po.AdminFunAttFestivalExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceGroupDto;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceGroupParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 管理中心-考勤组模块
 * @author lcb
 * @2017-11-22
 */
@RestController
@RequestMapping("/managerCenter/attendanceGroupModule")
public class AttendanceGroupController extends BaseController {

	@Autowired
	private ErpFunAttendanceGroupMapper erpFunAttendanceGroupMapper;
	@Autowired
	private ErpFunAttendanceGroupService erpFunAttendanceGroupService;
	@Autowired
	private ErpFunAttendanceGroupBizMapper erpFunAttendanceGroupBizMapper;
	@Autowired
	private ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	private ErpFunAttendanceFestivalMapper erpFunAttendanceFestivalMapper;
	@Autowired
	private ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	private AdminFunAttFestivalMapper adminFunAttFestivalMapper;

	/**
	 * 查询考勤组列表
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceGroupList")
	public ResponseJson getList(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		List<ErpFunAttendanceGroup> resList = erpFunAttendanceGroupMapper.getGroupList(operator.getCityId(), operator.getCompId(), operator.getDeptId(), param.getKeyWords());
		return ErpResponseJson.ok(resList);
	}

	/**
	 * 删除
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delAttendanceGroup")
	public ResponseJson delAttendanceGroupList(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		Integer delCount = erpFunAttendanceGroupService.delAttendanceGroupList(operator.getCityId(), operator.getCompId(), param.getId());
		return ErpResponseJson.ok(delCount);
	}

	/**
	 * 新建编辑固定排班
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addEditAttendanceGroup")
	public ResponseJson addEditAttendanceFixGroup(@Valid @RequestBody ErpFunAttendanceGroupParam param) {
		Operator operator = getOperator();
		Integer res = erpFunAttendanceGroupService.addEditAttendanceGroup(operator.getCityId(), operator.getCompId(), operator.getDeptId(), param);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 查询固定排版考勤组
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param 
	 **/
	@RequestMapping("/getAttendanceGroupDetail")
	public ResponseJson getAttendanceGroupDetail(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();

		//1:查询住对象group
		ErpFunAttendanceGroupDto erpFunAttendanceGroupDto = erpFunAttendanceGroupMapper.selectGroupById(cityId, param.getId());
		//2:查询组织机构数据
		if(null != erpFunAttendanceGroupDto) {
			ErpFunAttendanceGroupBizExample erpFunAttendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
			erpFunAttendanceGroupBizExample.setShardCityId(cityId);
			erpFunAttendanceGroupBizExample.createCriteria().andAttGroupIdEqualTo(erpFunAttendanceGroupDto.getId()).andIsDelEqualTo((byte)0 );
			List<ErpFunAttendanceGroupBiz> erpFunAttendanceGroupBizs = erpFunAttendanceGroupBizMapper.selectByExample(erpFunAttendanceGroupBizExample);
			erpFunAttendanceGroupDto.setGroupBizListst(erpFunAttendanceGroupBizs);
			//3:查询钱10 详细人员列表（注销的不查询？？？？）
			List<ErpFunAttendanceGroupBizPerson> groupBizPersonList = erpFunAttendanceGroupBizPersonMapper.getUserList(cityId, erpFunAttendanceGroupDto.getId());
			erpFunAttendanceGroupDto.setGroupBizPersonListst(groupBizPersonList);

			// 行政班
			if(1 == erpFunAttendanceGroupDto.getClassType()) {
				//4:查询特殊考勤日关联查询班次
				ErpFunAttendanceFestivalExample erpFunAttendanceFestivalExample = new ErpFunAttendanceFestivalExample();
				erpFunAttendanceFestivalExample.setShardCityId(cityId);
				erpFunAttendanceFestivalExample.createCriteria().andAttGrIdEqualTo(erpFunAttendanceGroupDto.getId()).andIsDelNotEqualTo((byte) 1);
				List<ErpFunAttendanceFestival> erpFunAttendanceFestivalList = erpFunAttendanceFestivalMapper.selectByExample(erpFunAttendanceFestivalExample);
				erpFunAttendanceGroupDto.setFunAttendanceFestivalList(erpFunAttendanceFestivalList);

//				Calendar calendar = Calendar.getInstance();
//				calendar.set(Calendar.DAY_OF_MONTH, 1);
//				calendar.set(Calendar.MONTH, 1);
//				calendar.set(Calendar.HOUR_OF_DAY, 0);
//				calendar.set(Calendar.MINUTE, 0);
//				calendar.set(Calendar.SECOND, 0);
//				calendar.add(Calendar.MONTH,-1);
//				Date startTime = calendar.getTime();
//				calendar.add(Calendar.YEAR, 1);
//				Date endTime = calendar.getTime();
//
//				AdminFunAttFestivalExample adminFunAttFestivalExample = new AdminFunAttFestivalExample();
//				adminFunAttFestivalExample.createCriteria().andYearTimeBetween(startTime, endTime);
//				List<AdminFunAttFestival> adminFunAttFestivals = adminFunAttFestivalMapper.selectByExample(adminFunAttFestivalExample);
//				erpFunAttendanceGroupDto.setNationalHolidayList(adminFunAttFestivals);
			}
		}

		return ErpResponseJson.ok(erpFunAttendanceGroupDto);
	}

	/**
	 * 新建编辑固定排班
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceUserClassList")
	public ResponseJson getAttendanceUserClassList(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		List<ErpFunAttendanceUserClassDetail> userClassDetailList = erpFunAttendanceUserClassDetailMapper.getUserClassList(operator.getCityId(), operator.getCompId(), param.getId(), param.getScheduleMonth());
		return ErpResponseJson.ok(userClassDetailList);
	}

	/**
	 * 节假日查询
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFunAttfestivalList")
	public ResponseJson getFunAttfestivalList(@Valid @RequestBody ErpAttendanceModuleParam param) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.MONTH,-1);
		Date startTime = calendar.getTime();
		calendar.add(Calendar.YEAR, 1);
		Date endTime = calendar.getTime();

		AdminFunAttFestivalExample adminFunAttFestivalExample = new AdminFunAttFestivalExample();
		adminFunAttFestivalExample.createCriteria().andYearTimeBetween(startTime, endTime);
		List<AdminFunAttFestival> adminFunAttFestivals = adminFunAttFestivalMapper.selectByExample(adminFunAttFestivalExample);

		return ErpResponseJson.ok(adminFunAttFestivals);
	}


}
