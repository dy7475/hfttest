package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminWMicroshopMasssendHistory;

public interface AdminWMicroshopMasssendHistoryMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer historyId);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminWMicroshopMasssendHistory record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminWMicroshopMasssendHistory record);

    /**
     *
     * @mbggenerated
     */
    AdminWMicroshopMasssendHistory selectByPrimaryKey(Integer historyId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminWMicroshopMasssendHistory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminWMicroshopMasssendHistory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminWMicroshopMasssendHistory record);
}