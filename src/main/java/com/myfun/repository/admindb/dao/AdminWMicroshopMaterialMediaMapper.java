package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminWMicroshopMaterialMedia;

public interface AdminWMicroshopMaterialMediaMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer materialId);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminWMicroshopMaterialMedia record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminWMicroshopMaterialMedia record);

    /**
     *
     * @mbggenerated
     */
    AdminWMicroshopMaterialMedia selectByPrimaryKey(Integer materialId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminWMicroshopMaterialMedia record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminWMicroshopMaterialMedia record);
}