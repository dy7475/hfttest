package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.AttendanceBaseInfo;
import com.myfun.repository.erpdb.param.ErpFunAttendanceClassParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceClass;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunAttendanceClassService extends BaseMapper<ErpFunAttendanceClass, ErpFunAttendanceClass>{

	/** 新增编辑班次 **/
	Integer addEditAttendance(Integer cityId, Integer compId, Integer deptId, ErpFunAttendanceClassParam erpFunAttendanceClassParam);

    Integer delAttendanceClass(Integer cityId, Integer compId, ErpFunAttendanceClassParam erpFunAttendanceClassParam);

}
