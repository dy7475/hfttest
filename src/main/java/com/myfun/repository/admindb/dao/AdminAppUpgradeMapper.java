package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminAppUpgrade;
import org.apache.ibatis.annotations.Param;

public interface AdminAppUpgradeMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(AdminAppUpgrade record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminAppUpgrade record);

    String selectAndroidDownloadUrl(@Param("deviceType")Integer deviceType);
}