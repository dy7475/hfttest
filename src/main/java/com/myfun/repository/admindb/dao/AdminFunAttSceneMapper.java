package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunAttScene;
import com.myfun.repository.admindb.po.AdminFunAttSceneExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunAttSceneMapper extends BaseMapper<AdminFunAttScene, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunAttSceneExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunAttSceneExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunAttScene> selectByExample(AdminFunAttSceneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunAttScene record,
			@Param("example") AdminFunAttSceneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunAttScene record, @Param("example") AdminFunAttSceneExample example);

	List<AdminFunAttScene> selectAllScene();
}