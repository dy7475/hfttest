package com.myfun.erpWeb.openApi.attendance;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.openApi.attendance.param.OutLogRecordOpenApiParam;
import com.myfun.erpWeb.openApi.attendance.vo.ErpOutLogVO;
import com.myfun.framework.exception.BusinessException;
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
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpOutLogMapper;
import com.myfun.repository.erpdb.dto.ErpFunCompDto;
import com.myfun.repository.erpdb.param.OutLogRecordParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroupExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunAttendanceRecordDetailService;
import com.myfun.utils.BeanUtilsHelper;
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
@RequestMapping("/openApi/attendanceSignInModule")
public class AttendanceSignInOenApiController extends BaseController {

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
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	
	

	/**
	 * 外出登记统计公共接口
	 * @throws Exception 
	 */
	@ApiOperation(value = "外出登记统计公共接口")
	@ApiResponses(@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpOutLogVO.class, message = "成功"))
	@RequestMapping("/getOutLog")
	public ResponseJson getOutLog(@RequestBody OutLogRecordOpenApiParam openApiParam) throws Exception {
		
		OutLogRecordParam param = new OutLogRecordParam();
		BeanUtilsHelper.copyProperties(param, openApiParam);
		Integer cityId = openApiParam.getCityId();
		ErpFunCompDto erpFunCompDto = erpFunCompMapper.getCompInfoByCompNo(cityId, openApiParam.getCompNo());
		if (null == erpFunCompDto) {
			throw new BusinessException("公司信息异常");
		}
		Integer compId = erpFunCompDto.getCompId();
		
		List<ErpFunUsers> userList = erpFunUsersMapper.getAllUserName(cityId, compId, param.getStartTime());
		Map<Integer, String> userNameMap = userList.stream().collect(Collectors.toMap(ErpFunUsers :: getUserId, ErpFunUsers :: getUserName, (oldValue, newValue) -> oldValue));
		
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		Map<Integer, String> deptNameMap = erpFunDeptsList.stream().collect(Collectors.toMap(ErpFunDepts :: getDeptId, ErpFunDepts :: getDeptName, (oldValue, newValue) -> oldValue));
		
		ErpFunDeptsgroupExample erpFunDeptsgroupExample = new ErpFunDeptsgroupExample();
		erpFunDeptsgroupExample.setShardCityId(cityId);
		erpFunDeptsgroupExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDeptsgroup> erpFunDeptsgroupList = erpFunDeptsgroupMapper.selectByExample(erpFunDeptsgroupExample);
		Map<Integer, String> groupNameMap = erpFunDeptsgroupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup :: getGrId, ErpFunDeptsgroup :: getGrName, (oldValue, newValue) -> oldValue));
		
		List<ErpOutLogVO> outLogRecordList = erpOutLogMapper.getOutLogRecordVoList(cityId, compId, param);
		if (null == outLogRecordList || outLogRecordList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<Integer> auditIdList = outLogRecordList.stream().collect(Collectors.mapping(ErpOutLogVO::getAuditId, Collectors.toList()));
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.selectListByIds(cityId, compId, auditIdList);
		Map<Integer, Integer> auditTypeMap = auditRuntimeList.stream().collect(Collectors.toMap(ErpAuditRuntime::getId, ErpAuditRuntime::getAuditType));
		for (ErpOutLogVO erpOutLog : outLogRecordList) {
			if (null != deptNameMap) {
				erpOutLog.setDeptName(deptNameMap.get(erpOutLog.getDeptId()));
			}
			if (null != groupNameMap) {
				erpOutLog.setGroupName(groupNameMap.get(erpOutLog.getGrId()));
			}
			if (null != userNameMap) {
				erpOutLog.setOutUserName(userNameMap.get(erpOutLog.getOutUser()));
			}
			Integer auditType = auditTypeMap.get(erpOutLog.getAuditId());
			if (null != auditType) {
				erpOutLog.setAuditType(auditType);
			}
			String backTime = erpOutLog.getBackTime();
			String outTime = erpOutLog.getOutTime();
			if(StringUtil.isNotBlank(backTime)){
				Double hoursOfTwoDate = DateTimeHelper.getMinutesOfTwoDate(DateTimeHelper.parseToDate(backTime), DateTimeHelper.parseToDate(outTime));
				erpOutLog.setRealTime(hoursOfTwoDate.intValue());
			}
		}
		return ErpResponseJson.ok(outLogRecordList);
	}
}
