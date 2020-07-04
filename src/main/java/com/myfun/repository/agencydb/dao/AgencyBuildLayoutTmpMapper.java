package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyBuildLayoutTmp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildLayoutTmpMapper extends BaseMapper<AgencyBuildLayoutTmp, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyBuildLayoutTmp record);
}