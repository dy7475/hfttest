package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyTestClass;

public interface AgencyTestClassMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer classId);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyTestClass record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyTestClass record);

    /**
     *
     * @mbggenerated
     */
    AgencyTestClass selectByPrimaryKey(Integer classId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyTestClass record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyTestClass record);
}