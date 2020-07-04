package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfAttach;

public interface AgencyWfAttachMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyWfAttach record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyWfAttach record);

    /**
     *
     * @mbggenerated
     */
    AgencyWfAttach selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyWfAttach record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyWfAttach record);
}