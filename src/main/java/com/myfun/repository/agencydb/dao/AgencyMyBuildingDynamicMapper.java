package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyMyBuildingDynamic;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyMyBuildingDynamicMapper extends BaseMapper<AgencyMyBuildingDynamic, String> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyMyBuildingDynamic record);
}