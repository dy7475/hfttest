package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfImFriend;

public interface AgencyWfImFriendMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyWfImFriend record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyWfImFriend record);

    /**
     *
     * @mbggenerated
     */
    AgencyWfImFriend selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyWfImFriend record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyWfImFriend record);
}