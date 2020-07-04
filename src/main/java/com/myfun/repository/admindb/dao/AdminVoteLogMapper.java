package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminVoteLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminVoteLogMapper extends BaseMapper<AdminVoteLog, Integer> {

	List<AdminVoteLog> getAdminVoteLog(AdminVoteLog vl);

	List<AdminVoteLog> getAdminVoteLogByArchive(Integer archivedId);

	List<AdminVoteLog> selectVoteList(@Param("bulletId") Integer bulletId,@Param("archiveId") Integer archiveId);

}