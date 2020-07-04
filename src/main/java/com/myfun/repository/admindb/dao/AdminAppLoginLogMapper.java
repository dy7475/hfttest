package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminAppLoginLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminAppLoginLogMapper extends BaseMapper<AdminAppLoginLog, Integer> {
	/**
	 * 获取用户第一次登录APP时间
	 * @param archiveId
	 * @param beginDate
	 * @return
	 */
	AdminAppLoginLog AppFirstLogin(@Param("archiveId")Integer archiveId, @Param("beginDate")String beginDate);
}