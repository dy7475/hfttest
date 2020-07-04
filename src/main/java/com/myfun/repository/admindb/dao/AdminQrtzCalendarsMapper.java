package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminQrtzCalendars;
import com.myfun.repository.admindb.po.AdminQrtzCalendarsKey;

public interface AdminQrtzCalendarsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AdminQrtzCalendarsKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminQrtzCalendars record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminQrtzCalendars record);

    /**
     *
     * @mbggenerated
     */
    AdminQrtzCalendars selectByPrimaryKey(AdminQrtzCalendarsKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminQrtzCalendars record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminQrtzCalendars record);
}