package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.dto.AttendanceResultDto;
import com.myfun.repository.erpdb.param.AttendanceSignInParam;
import com.myfun.repository.erpdb.param.ChangeAttendanceResultParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetail;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.text.ParseException;
import java.util.Map;

public interface ErpFunAttendanceRecordDetailService extends BaseMapper<ErpFunAttendanceRecordDetail, ErpFunAttendanceRecordDetail> {
    AttendanceResultDto insertAttendanceRecord(Integer cityId, Integer userId, Integer compId, Integer areaId, Integer regId,
                                               Integer deptId, Integer grId, AttendanceSignInParam attendanceSignInParam);

	Map<String,String> changeAttendanceResult(Integer cityId, Integer compId, Integer deptId, Integer userId,String userName, ChangeAttendanceResultParam param);

	AttendanceResultDto getGreetingInfo();

    void updateMonthCountDayAttendance(Integer cityId, Integer compId, Integer deptId, Integer userId, ChangeAttendanceResultParam param);
}
