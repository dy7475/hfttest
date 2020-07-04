package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyMyHftUsermap;

public interface AgencyMyHftUsermapMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer archiveId);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyMyHftUsermap record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyMyHftUsermap record);

    /**
     *
     * @mbggenerated
     */
    AgencyMyHftUsermap selectByPrimaryKey(Integer archiveId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyMyHftUsermap record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyMyHftUsermap record);
}