package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminZfbHouseTrans;
import com.myfun.repository.admindb.po.AdminZfbHouseTransExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminZfbHouseTransMapper extends BaseMapper<AdminZfbHouseTrans, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminZfbHouseTransExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminZfbHouseTransExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminZfbHouseTrans> selectByExample(AdminZfbHouseTransExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminZfbHouseTrans record,
			@Param("example") AdminZfbHouseTransExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminZfbHouseTrans record,
			@Param("example") AdminZfbHouseTransExample example);
}