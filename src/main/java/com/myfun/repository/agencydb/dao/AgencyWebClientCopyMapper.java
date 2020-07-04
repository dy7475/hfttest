package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWebClientCopy;

public interface AgencyWebClientCopyMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer clientId);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyWebClientCopy record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyWebClientCopy record);

    /**
     *
     * @mbggenerated
     */
    AgencyWebClientCopy selectByPrimaryKey(Integer clientId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyWebClientCopy record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyWebClientCopy record);
}