package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.param.WageLogListParam;
import com.myfun.repository.erpdb.po.ErpFunWageLog;
import com.myfun.repository.erpdb.po.ErpFunWageLogExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
@SwitchDB
public interface ErpFunWageLogMapper extends BaseMapper<ErpFunWageLog, ErpFunWageLog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWageLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWageLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWageLog> selectByExample(ErpFunWageLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWageLog record, @Param("example") ErpFunWageLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWageLog record, @Param("example") ErpFunWageLogExample example);

	List<ErpFunWageLog> getFunWageLogList(@Param("shardCityId")Integer cityId, @Param("param") WageLogListParam param);
}