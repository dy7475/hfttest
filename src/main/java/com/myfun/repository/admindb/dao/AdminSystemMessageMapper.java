package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminSystemMessage;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSystemMessageMapper extends BaseMapper<AdminSystemMessage, Integer> {
	
	int getId();
}