package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpYstemSettingLogs;

public interface ErpYstemSettingLogsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(ErpYstemSettingLogs record);

    /**
     *
     * @mbggenerated
     */
    int insert(ErpYstemSettingLogs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ErpYstemSettingLogs record);

    /**
     *
     * @mbggenerated
     */
    ErpYstemSettingLogs selectByPrimaryKey(ErpYstemSettingLogs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ErpYstemSettingLogs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ErpYstemSettingLogs record);
}