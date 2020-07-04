package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminWMicroshopJob;

public interface AdminWMicroshopJobMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer jobId);

    /**
     *
     * @mbggenerated
     */
    int insert(AdminWMicroshopJob record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminWMicroshopJob record);

    /**
     *
     * @mbggenerated
     */
    AdminWMicroshopJob selectByPrimaryKey(Integer jobId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AdminWMicroshopJob record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminWMicroshopJob record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AdminWMicroshopJob record);
}