package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetLogListParam;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpSystemSettingLogsDto;
import com.myfun.repository.erpdb.po.ErpSystemSettingLogs;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpSystemSettingLogsExample;

public interface ErpSystemSettingLogsMapper extends BaseMapper<ErpSystemSettingLogs, ErpSystemSettingLogs> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpSystemSettingLogs> selectByExampleWithBLOBs(
			ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpSystemSettingLogs> selectByExample(
			ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpSystemSettingLogs record,
			@Param("example") ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpSystemSettingLogs record,
			@Param("example") ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpSystemSettingLogs record,
			@Param("example") ErpSystemSettingLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpSystemSettingLogs record);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    Integer getMaxId(@Param("shardCityId")Integer cityId);
	
	@SwitchDB(type= SwitchDBType.CITY_ID)
	List<ErpSystemSettingLogsDto> getLogList(@Param("pMap")GetLogListParam pMap,@Param("shardCityId")Integer cityId);

	List<ErpSystemSettingLogs> getErpSystemSettingLogsList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userIdSet")List<Integer> userIdSet);
	
	/**
	 * 员工动�??
	 * @author 熊刚
	 * @since 2017�?11�?6�?
	 * @param cityId
	 * @param compId
	 * @param influenceUid
	 * @return
	 */
	List<ErpSystemSettingLogsDto> getEnclosureLogs(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId ,@Param("archiveId")Integer archiveId,  @Param("isChange")Integer isChange);
	
	/**
	 * 员工动�??
	 * @author 熊刚
	 * @since 2017�?11�?6�?
	 * @param cityId
	 * @param compId
	 * @param influenceUid
	 * @return
	 */
	ErpSystemSettingLogsDto getChangeEnclosureLogs(@Param("shardCityId")Integer cityId,@Param("systemSettingLogsId")Integer systemSettingLogsId);
	@SwitchDB(type= SwitchDBType.CITY_ID)
	Integer getListCount(@Param("pMap")GetLogListParam pMap, @Param("shardCityId")Integer cityId);
}