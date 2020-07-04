package com.myfun.repository.admindb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminBroadcast;
import com.myfun.repository.admindb.po.AdminBroadcastKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBroadcastMapper extends BaseMapper<AdminBroadcast, AdminBroadcastKey> {

	Integer insertAdminBroadCast(Map<String, Object> paramMap);
	
}