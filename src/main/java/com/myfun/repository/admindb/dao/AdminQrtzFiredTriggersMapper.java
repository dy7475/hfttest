package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzFiredTriggers;
import com.myfun.repository.admindb.po.AdminQrtzFiredTriggersKey;

public interface AdminQrtzFiredTriggersMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzFiredTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzFiredTriggers record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzFiredTriggers record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzFiredTriggers selectByPrimaryKey(AdminQrtzFiredTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzFiredTriggers record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzFiredTriggers record);
}