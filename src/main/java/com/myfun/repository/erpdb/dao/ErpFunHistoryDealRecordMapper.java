package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunHistoryDealRecord;
import com.myfun.repository.erpdb.po.ErpFunHistoryDealRecordExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunHistoryDealRecordMapper extends BaseMapper<ErpFunHistoryDealRecord, ErpFunHistoryDealRecord> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunHistoryDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunHistoryDealRecordExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunHistoryDealRecord> selectByExample(ErpFunHistoryDealRecordExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunHistoryDealRecord record,@Param("example") ErpFunHistoryDealRecordExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunHistoryDealRecord record,@Param("example") ErpFunHistoryDealRecordExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertRecordBatch(@Param("shardCityId")Integer cityId,@Param("list") List<ErpFunHistoryDealRecord> list);
}