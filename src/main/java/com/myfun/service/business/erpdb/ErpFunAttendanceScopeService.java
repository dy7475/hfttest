package com.myfun.service.business.erpdb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScope;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunAttendanceScopeService extends BaseMapper<ErpFunAttendanceScope, ErpFunAttendanceScope>{


	/**
	 * @Title 添加编辑考勤地址
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param 
	 **/
	Integer addEditDetail(Integer cityId, Integer compId, Integer deptId, ErpAttendanceScopeParam erpAttendanceScopeParam);

	/**
	 * @Title 删除考勤地点
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param
	 **/
    Integer delAttendanceScope(Integer cityId, Integer compId, ErpAttendanceScopeParam erpAttendanceScopeParam);
}
