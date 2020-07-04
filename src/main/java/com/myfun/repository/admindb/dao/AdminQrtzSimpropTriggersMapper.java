package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzSimpropTriggers;
import com.myfun.repository.admindb.po.AdminQrtzSimpropTriggersKey;

public interface AdminQrtzSimpropTriggersMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzSimpropTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzSimpropTriggers record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzSimpropTriggers record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzSimpropTriggers selectByPrimaryKey(AdminQrtzSimpropTriggersKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzSimpropTriggers record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzSimpropTriggers record);
}