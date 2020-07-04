package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyRechargeLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyRechargeLogMapper extends BaseMapper<AgencyRechargeLog, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyRechargeLog record);
}