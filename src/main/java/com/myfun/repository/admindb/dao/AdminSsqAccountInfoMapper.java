package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminSsqAccountInfo;
import com.myfun.repository.admindb.po.AdminSsqAccountInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminSsqAccountInfoMapper extends BaseMapper<AdminSsqAccountInfo, String> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminSsqAccountInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminSsqAccountInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminSsqAccountInfo> selectByExample(AdminSsqAccountInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminSsqAccountInfo record,
			@Param("example") AdminSsqAccountInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminSsqAccountInfo record,
			@Param("example") AdminSsqAccountInfoExample example);
}