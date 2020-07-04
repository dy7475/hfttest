package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfPushLog1;

public interface AgencyWfPushLog1Mapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyWfPushLog1 record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyWfPushLog1 record);

    /**
     *
     * @mbggenerated
     */
    AgencyWfPushLog1 selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyWfPushLog1 record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyWfPushLog1 record);
}