package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunWageConfig;
import com.myfun.repository.erpdb.po.ErpFunWageConfigExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunWageConfigMapper extends BaseMapper<ErpFunWageConfig, ErpFunWageConfig> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWageConfigExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWageConfigExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWageConfig> selectByExample(ErpFunWageConfigExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWageConfig record,
			@Param("example") ErpFunWageConfigExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWageConfig record, @Param("example") ErpFunWageConfigExample example);

	ErpFunWageConfig getLastUpdateConfig(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("updateTime") Date updateTime);

	ErpFunWageConfig getCurrentCycleConfig(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
	ErpFunWageConfig selectThisMonthConfig(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);
}