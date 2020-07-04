package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunAttendanceGroupParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroup;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunAttendanceGroupService extends BaseMapper<ErpFunAttendanceGroup, ErpFunAttendanceGroup>{

	/**
	 * @Title 删除考勤组
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	Integer delAttendanceGroupList(Integer cityId, Integer compId, Integer id);

    Integer addEditAttendanceGroup(Integer cityId, Integer compId, Integer deptId, ErpFunAttendanceGroupParam param);
}
