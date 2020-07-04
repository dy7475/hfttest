package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyFunFafaInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunFafaInfoMapper extends BaseMapper<AgencyFunFafaInfo, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyFunFafaInfo record);
}