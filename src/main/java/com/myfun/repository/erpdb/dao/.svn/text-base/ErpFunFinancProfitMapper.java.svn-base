package com.myfun.repository.erpdb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunFinancProfit;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunFinancProfitMapper extends BaseMapper<ErpFunFinancProfit, ErpFunFinancProfit> {

	/**
	 * 试用开库附加逻辑
	 * @param cityId
	 * @param erpCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertProfitComp(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId);
}