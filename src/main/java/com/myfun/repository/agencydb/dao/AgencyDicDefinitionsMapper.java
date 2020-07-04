package com.myfun.repository.agencydb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyDicDefinitions;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyDicDefinitionsMapper extends BaseMapper<AgencyDicDefinitions, Integer> {
	/**
	 * 获取字段信息
	 * @param dicType
	 * @param dicValue
	 * @return
	 */
	AgencyDicDefinitions getMsg(@Param("dicType")String dicType, @Param("dicValue")String dicValue);
}