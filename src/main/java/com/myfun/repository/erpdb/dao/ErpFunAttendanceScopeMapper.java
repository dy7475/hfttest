package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunAttendanceScopeDto;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScope;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceScopeMapper extends BaseMapper<ErpFunAttendanceScope, ErpFunAttendanceScope> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceScopeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceScopeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceScope> selectByExample(ErpFunAttendanceScopeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceScope record, @Param("example") ErpFunAttendanceScopeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceScope record, @Param("example") ErpFunAttendanceScopeExample example);

	List<ErpFunAttendanceScopeDto> getAttendanceScopeList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("keyWords")String keyWords);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunAttendanceScope getUserScope(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("scopeId") Integer scopeId);

	List<ErpFunAttendanceScope> getAttendanceScopeByCompIdDeptId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);

	List<ErpFunAttendanceScope> getAttendanceScopeByCompIdDeptIdNew(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId);
}