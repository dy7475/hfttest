package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunBrokerageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunBrokerageMapper extends BaseMapper<ErpFunBrokerage, ErpFunBrokerage> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBrokerageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBrokerageExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBrokerage> selectByExample(ErpFunBrokerageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBrokerage record,
			@Param("example") ErpFunBrokerageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBrokerage record, @Param("example") ErpFunBrokerageExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertBatch(@Param("shardCityId")Integer cityId, @Param("paramList")List<ErpFunBrokerage> paramList);

	void initBrokerageModel(@Param("shardCityId")Integer cityId);
	
	List<ErpFunBrokerage> getBrokerageByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("saleLease")Integer saleLease);
}