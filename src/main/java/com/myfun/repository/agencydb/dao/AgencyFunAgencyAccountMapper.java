package com.myfun.repository.agencydb.dao;

import java.util.Map;

import com.myfun.repository.agencydb.po.AgencyFunAgencyAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunAgencyAccountMapper extends BaseMapper<AgencyFunAgencyAccount, Integer> {

	Integer getAccountCount(Map<String, Object> pMap);
}