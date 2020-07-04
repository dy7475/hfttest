package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunRecalculateWageInfoMapper extends BaseMapper<AdminFunRecalculateWageInfo, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunRecalculateWageInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunRecalculateWageInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunRecalculateWageInfo> selectByExample(AdminFunRecalculateWageInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunRecalculateWageInfo record,
			@Param("example") AdminFunRecalculateWageInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunRecalculateWageInfo record,
			@Param("example") AdminFunRecalculateWageInfoExample example);
}