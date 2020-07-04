package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunCompNos;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunCompNosMapper extends BaseMapper<AdminFunCompNos, String> {
    String selectCompNo();

    void updateBeUseByCompNo(String compNo);
}