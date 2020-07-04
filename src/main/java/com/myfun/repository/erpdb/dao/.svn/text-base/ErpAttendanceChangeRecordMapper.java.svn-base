package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpAttendanceChangeRecordDto;
import com.myfun.repository.erpdb.po.ErpAttendanceChangeRecord;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAttendanceChangeRecordMapper extends BaseMapper<ErpAttendanceChangeRecord, ErpAttendanceChangeRecord> {
	@SwitchDB(type = SwitchDBType.CITY_ID)
	/**
	 * 考勤修改日志查询
	 */
	List<ErpAttendanceChangeRecordDto> getAttendanceRecordList(@Param("pMap")Map<String, Object> pMap,@Param("shardCityId")Integer cityId);
}