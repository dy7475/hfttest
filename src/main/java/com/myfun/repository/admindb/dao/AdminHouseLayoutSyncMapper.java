package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminHouseLayoutSync;
import com.myfun.repository.admindb.po.AdminHouseLayoutSyncExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminHouseLayoutSyncMapper extends BaseMapper<AdminHouseLayoutSync, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminHouseLayoutSyncExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminHouseLayoutSyncExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminHouseLayoutSync> selectByExample(AdminHouseLayoutSyncExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminHouseLayoutSync record,
			@Param("example") AdminHouseLayoutSyncExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminHouseLayoutSync record,
			@Param("example") AdminHouseLayoutSyncExample example);
}