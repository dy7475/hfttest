package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzSimpleTriggers;
import com.myfun.repository.admindb.po.AdminQrtzSimpleTriggersKey;

public interface AdminQrtzSimpleTriggersMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzSimpleTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzSimpleTriggers record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzSimpleTriggers record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzSimpleTriggers selectByPrimaryKey(AdminQrtzSimpleTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzSimpleTriggers record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzSimpleTriggers record);
}