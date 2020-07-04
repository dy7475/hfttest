package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminFunUsersCountDto;
import com.myfun.repository.admindb.po.AdminFunUsersCount;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunUsersCountExample;

public interface AdminFunUsersCountMapper extends BaseMapper<AdminFunUsersCount, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunUsersCountExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunUsersCountExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunUsersCount> selectByExample(AdminFunUsersCountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunUsersCount record,
			@Param("example") AdminFunUsersCountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunUsersCount record,
			@Param("example") AdminFunUsersCountExample example);

	List<AdminFunUsersCountDto> getUserScorByArchiveIds(@Param("archiveIds") Integer[] archiveIds);

	@MapKey("archiveId")
	Map<Integer, AdminFunUsersCountDto> getUserScorCountMapKey(@Param("archiveIds") Set<Integer> archiveIds);
}