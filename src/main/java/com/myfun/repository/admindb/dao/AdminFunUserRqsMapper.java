package com.myfun.repository.admindb.dao;

import java.util.Map;

import com.myfun.repository.admindb.po.AdminFunUserRqs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunUserRqsMapper extends BaseMapper<AdminFunUserRqs, Integer> {

	void updatePhoneNum(Map<String, Object> map);
	/**
	 * 统计经纪人认证信息
	 * @author 陈文超
	 * @date 2018年6月4日 下午2:25:31
	 */
	Integer getCountByPrimaryKey(Integer archiveId);
}