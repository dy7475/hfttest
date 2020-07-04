package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminZhiYeViewLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminZhiYeViewLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminZhiYeViewLogMapper extends BaseMapper<AdminZhiYeViewLog, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminZhiYeViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminZhiYeViewLogExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminZhiYeViewLog> selectByExample(AdminZhiYeViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminZhiYeViewLog record,
			@Param("example") AdminZhiYeViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminZhiYeViewLog record, @Param("example") AdminZhiYeViewLogExample example);
}