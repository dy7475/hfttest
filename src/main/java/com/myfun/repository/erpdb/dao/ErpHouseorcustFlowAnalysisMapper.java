package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpHouseorcustFlowAnalysis;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpHouseorcustFlowAnalysisMapper extends BaseMapper<ErpHouseorcustFlowAnalysis, ErpHouseorcustFlowAnalysis> {

	/**
	 * 获取符合条件的列表
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getHouseCustFlowAnalysisCountList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);
}