package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncomeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunBrokerageIncomeMapper extends BaseMapper<ErpFunBrokerageIncome, ErpFunBrokerageIncome> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBrokerageIncomeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBrokerageIncomeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBrokerageIncome> selectByExample(ErpFunBrokerageIncomeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBrokerageIncome record,
			@Param("example") ErpFunBrokerageIncomeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBrokerageIncome record,
			@Param("example") ErpFunBrokerageIncomeExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void insertBatch(@Param("shardCityId")Integer cityId, @Param("paramList")List<ErpFunBrokerageIncome> paramList);
}