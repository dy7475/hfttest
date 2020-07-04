package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunAttendanceClassDto;
import com.myfun.repository.erpdb.po.ErpFunAttendanceClass;
import com.myfun.repository.erpdb.po.ErpFunAttendanceClassExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

public interface ErpFunAttendanceClassMapper extends BaseMapper<ErpFunAttendanceClass, ErpFunAttendanceClass> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceClassExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceClassExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceClass> selectByExample(ErpFunAttendanceClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceClass record,
			@Param("example") ErpFunAttendanceClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceClass record,
			@Param("example") ErpFunAttendanceClassExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunAttendanceClass  getClassTime(@Param("id") Integer id,@Param("shardCityId")Integer cityId);


	List<ErpFunAttendanceClassDto> getAttendanceClassList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("keyWords")String keyWords);
}