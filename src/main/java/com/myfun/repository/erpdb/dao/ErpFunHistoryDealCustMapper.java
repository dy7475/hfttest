package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.historyCustomer.param.HistoryCustomerListParam;
import com.myfun.repository.erpdb.po.ErpFunHistoryDealCust;
import com.myfun.repository.erpdb.po.ErpFunHistoryDealCustExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunHistoryDealCustMapper extends BaseMapper<ErpFunHistoryDealCust, ErpFunHistoryDealCust> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunHistoryDealCustExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunHistoryDealCustExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunHistoryDealCust> selectByExample(ErpFunHistoryDealCustExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunHistoryDealCust record,@Param("example") ErpFunHistoryDealCustExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunHistoryDealCust record,@Param("example") ErpFunHistoryDealCustExample example);
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunHistoryDealCust>  getHistoryDealCustList(@Param("shardCityId")Integer cityId,@Param("param")HistoryCustomerListParam param);


}