package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzJobDetails;
import com.myfun.repository.admindb.po.AdminQrtzJobDetailsKey;

public interface AdminQrtzJobDetailsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzJobDetailsKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzJobDetails record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzJobDetails record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzJobDetails selectByPrimaryKey(AdminQrtzJobDetailsKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzJobDetails record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminQrtzJobDetails record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminQrtzJobDetails record);
}