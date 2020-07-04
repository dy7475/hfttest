package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminWfBrokerComment;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminWfBrokerCommentMapper extends BaseMapper<AdminWfBrokerComment, Integer> {
	
	/**
	 * 查询是否有投诉
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param wxId
	 * @param archiveId 
	 * @return
	 */
	int isComplaint(@Param("wxId")String wxId, @Param("archiveId")Integer archiveId);
}