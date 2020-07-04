package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCrmDeptsMap;
import com.myfun.repository.admindb.po.AdminCrmDeptsMapExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCrmDeptsMapMapper extends BaseMapper<AdminCrmDeptsMap, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminCrmDeptsMapExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminCrmDeptsMapExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminCrmDeptsMap> selectByExample(AdminCrmDeptsMapExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminCrmDeptsMap record,
			@Param("example") AdminCrmDeptsMapExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminCrmDeptsMap record, @Param("example") AdminCrmDeptsMapExample example);

    void updateByDeptId(AdminCrmDeptsMap crmDeptsMap);
}