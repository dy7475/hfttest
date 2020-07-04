package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunEmployeeLogDto;
import com.myfun.repository.erpdb.param.ErpFunEmployeeLogParam;
import com.myfun.repository.erpdb.po.ErpFunEmployeeLog;
import com.myfun.repository.erpdb.po.ErpFunEmployeeLogExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunEmployeeLogMapper extends BaseMapper<ErpFunEmployeeLog, ErpFunEmployeeLog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEmployeeLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEmployeeLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEmployeeLog> selectByExample(ErpFunEmployeeLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEmployeeLog record,
			@Param("example") ErpFunEmployeeLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEmployeeLog record,
			@Param("example") ErpFunEmployeeLogExample example);

	@SwitchDB(type= SwitchDBType.CITY_ID)
	List<ErpFunEmployeeLogDto> getEmployeeLogList(@Param("shardCityId") Integer cityId, @Param("param") ErpFunEmployeeLogParam param,@Param("compId") Integer compId);
	
	/**
	 * 通过档案ID获取日志列表
	 * @author 张宏利
	 * @since 2018年1月27日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<ErpFunEmployeeLogDto> getLogListByEmployeeId(@Param("shardCityId") Integer cityId, @Param("employeeId") Integer employeeId);

	List<ErpFunEmployeeLog> selectFunEmployeeLogByArchiveIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("archiveIds")List<Integer> archiveIds);
}

