package com.myfun.service.business.erpdb;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpAttendanceDto;
import com.myfun.repository.erpdb.po.ErpAttendance;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateAttendanceParam;
import com.myfun.service.business.erpdb.bean.param.UpdateAttenceOffCountParam;

public interface ErpAttendanceSerice extends BaseMapper<ErpAttendance, ErpAttendance> {
	void insertAttendance(Integer cityId, CreateOrUpdateAttendanceParam param) throws Exception;

	List<?> getMgrStatList(BaseMapParam param) throws Exception;

	Integer updateMgrAtt(UpdateAttenceOffCountParam param) throws Exception;

	void updateMgrAttForLeaveAudit(Integer cityId, Integer compId, Integer currentUserId, String currentUserName,
			String attReason, Integer sourceUserId, Integer sourceDeptId, Date startTime, Date endTime, Integer leaveStartType, Integer leaveEndType);

	List<ErpAttendanceDto> getAttendanceList(BaseMapParam param) throws Exception;
}
