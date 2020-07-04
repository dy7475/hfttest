package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunSmsRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunSmsRecordMapper extends BaseMapper<AdminFunSmsRecord, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminFunSmsRecord record);
}