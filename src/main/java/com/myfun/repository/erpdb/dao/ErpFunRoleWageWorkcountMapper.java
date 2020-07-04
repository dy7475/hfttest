package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcount;
import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcountExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunRoleWageWorkcountMapper extends BaseMapper<ErpFunRoleWageWorkcount, ErpFunRoleWageWorkcount> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRoleWageWorkcountExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRoleWageWorkcountExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRoleWageWorkcount> selectByExample(ErpFunRoleWageWorkcountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRoleWageWorkcount record,
			@Param("example") ErpFunRoleWageWorkcountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRoleWageWorkcount record,
			@Param("example") ErpFunRoleWageWorkcountExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateWorkCountById(ErpFunRoleWageWorkcount erpFunRoleWageWorkcount);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunRoleWageWorkcount selectConfigByRoleId(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("checkType")Integer checkType,
												 @Param("roleId")String roleId, @Param("assessmentMonth")String assessmentMonth);
}