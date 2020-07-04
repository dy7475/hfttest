package com.myfun.repository.agencydb.dao;

import java.util.Map;

import com.myfun.repository.agencydb.po.AgencyFunDepts;
import com.myfun.repository.agencydb.po.AgencyFunDeptsKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunDeptsMapper extends BaseMapper<AgencyFunDepts, AgencyFunDeptsKey> {

	Integer updateByCityIdAndDevelopId(Map<String, Object> paramMap);

}