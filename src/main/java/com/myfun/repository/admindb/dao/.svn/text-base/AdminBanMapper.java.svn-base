package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminBan;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBanMapper extends BaseMapper<AdminBan, Integer> {

	List<AdminBan> getSlientRecordByArchiveId(AdminBan ban);

	int deleteByArchiveId(AdminBan ban);
	
	List<AdminBan> getBanList(Integer archiveId);
	
	// 查询是否在禁言中
	Integer getIsBanIng(@Param("nowDate") String nowDate, @Param("archiveId") Integer archiveId, @Param("type") Integer type);
	
	Integer deleteBan(Integer archiveId);
	
	/**
	 * 下架房源列表
	 * @param archiveId
	 * @return
	 */
	List<AdminBan> getDownList(Integer archiveId);
}