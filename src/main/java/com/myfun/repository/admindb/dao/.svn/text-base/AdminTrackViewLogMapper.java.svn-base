package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminTrackViewLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminTrackViewLogMapper extends BaseMapper<AdminTrackViewLog, Integer> {

	/**
	 * 自己是否对经纪人查看电话
	 * @param fId
	 * @param fromTable
	 * @param archiveId
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	int countTrackLog(@Param("fId") Integer fId, @Param("fromTable") String fromTable, @Param("archiveId") Integer archiveId, @Param("dateStart") String dateStart, @Param("dateEnd") String dateEnd);
}