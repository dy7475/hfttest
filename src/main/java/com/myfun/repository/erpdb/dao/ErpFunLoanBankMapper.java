package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.erpdb.po.ErpFunLoanBank;
import com.myfun.repository.erpdb.po.ErpFunLoanBankExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface ErpFunLoanBankMapper extends BaseMapper<ErpFunLoanBank, ErpFunLoanBank> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunLoanBankExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunLoanBankExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunLoanBank> selectByExample(ErpFunLoanBankExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunLoanBank record,
			@Param("example") ErpFunLoanBankExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunLoanBank record, @Param("example") ErpFunLoanBankExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunLoanBank> getList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("bkNameSet")Set<String> bkNameSet);
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void initLoadBankList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);
}