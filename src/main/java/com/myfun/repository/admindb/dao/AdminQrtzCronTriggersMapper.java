package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzCronTriggers;
import com.myfun.repository.admindb.po.AdminQrtzCronTriggersKey;

public interface AdminQrtzCronTriggersMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzCronTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzCronTriggers record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzCronTriggers record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzCronTriggers selectByPrimaryKey(AdminQrtzCronTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzCronTriggers record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzCronTriggers record);
}