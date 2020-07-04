package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyBuildActivity;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildActivityMapper extends BaseMapper<AgencyBuildActivity, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyBuildActivity record);
}