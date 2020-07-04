package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzSchedulerState;
import com.myfun.repository.admindb.po.AdminQrtzSchedulerStateKey;

public interface AdminQrtzSchedulerStateMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzSchedulerStateKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzSchedulerState record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzSchedulerState record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzSchedulerState selectByPrimaryKey(AdminQrtzSchedulerStateKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzSchedulerState record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzSchedulerState record);
}