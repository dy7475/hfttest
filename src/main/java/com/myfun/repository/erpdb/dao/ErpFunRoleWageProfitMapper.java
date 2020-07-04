package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunRoleWageProfit;
import com.myfun.repository.erpdb.po.ErpFunRoleWageProfitExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunRoleWageProfitMapper extends BaseMapper<ErpFunRoleWageProfit, ErpFunRoleWageProfit> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRoleWageProfitExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRoleWageProfitExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRoleWageProfit> selectByExample(ErpFunRoleWageProfitExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRoleWageProfit record,
			@Param("example") ErpFunRoleWageProfitExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRoleWageProfit record,
			@Param("example") ErpFunRoleWageProfitExample example);

	void updateById(@Param("shardCityId") Integer cityId, @Param("param")ErpFunRoleWageProfit erpFunRoleWageProfit);
}