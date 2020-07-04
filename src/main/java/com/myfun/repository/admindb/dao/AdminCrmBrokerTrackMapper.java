package com.myfun.repository.admindb.dao;

import com.github.pagehelper.Page;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmBrokerTrackMapper extends BaseMapper<AdminCrmBrokerTrack, Integer> {

	Integer getId();

	/**
	 * 看跟?
	 * @param archiveId
	 * @return
	 */
	Page<AdminCrmBrokerTrack> selectByArchiveId(Integer archiveId);
}