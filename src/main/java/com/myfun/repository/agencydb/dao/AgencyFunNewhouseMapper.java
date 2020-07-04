package com.myfun.repository.agencydb.dao;

import java.util.Map;

import com.myfun.repository.agencydb.po.AgencyFunNewhouse;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunNewhouseMapper extends BaseMapper<AgencyFunNewhouse, Integer> {

	Integer updateByBuildId(Map<String, Object> paramMap);
}