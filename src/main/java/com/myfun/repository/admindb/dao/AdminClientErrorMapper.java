package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminClientError;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminClientErrorMapper extends BaseMapper<AdminClientError, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminClientError record);
}