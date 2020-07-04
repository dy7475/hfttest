package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunCrossCompUser;
import com.myfun.repository.erpdb.po.ErpFunCrossCompUserExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunCrossCompUserMapper extends BaseMapper<ErpFunCrossCompUser, ErpFunCrossCompUser> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunCrossCompUserExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunCrossCompUserExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunCrossCompUser> selectByExample(ErpFunCrossCompUserExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunCrossCompUser record,
			@Param("example") ErpFunCrossCompUserExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunCrossCompUser record,
			@Param("example") ErpFunCrossCompUserExample example);

	List<ErpFunCrossCompUser> getCrossCompUser(@Param("shardCityId")Integer cityId);
}