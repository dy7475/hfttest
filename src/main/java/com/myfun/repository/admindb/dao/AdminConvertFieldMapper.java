package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminConvertField;
import com.myfun.repository.admindb.po.AdminConvertFieldKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminConvertFieldMapper extends BaseMapper<AdminConvertField, AdminConvertFieldKey> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminConvertField record);
}