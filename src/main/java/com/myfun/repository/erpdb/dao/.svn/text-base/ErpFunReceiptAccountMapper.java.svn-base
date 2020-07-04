package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunReceiptAccount;
import com.myfun.repository.erpdb.po.ErpFunReceiptAccountExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunReceiptAccountMapper extends BaseMapper<ErpFunReceiptAccount, ErpFunReceiptAccount> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunReceiptAccountExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunReceiptAccountExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunReceiptAccount> selectByExample(ErpFunReceiptAccountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunReceiptAccount record,
			@Param("example") ErpFunReceiptAccountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunReceiptAccount record,
			@Param("example") ErpFunReceiptAccountExample example);

	@SwitchDB(type=SwitchDBType.CITY_ID)
    List<ErpFunReceiptAccount> getListByCompId(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId);
    
    @SwitchDB(type=SwitchDBType.CITY_ID)
    int updateListByCompId(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId);
    
    int updateAccountById(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId, @Param("id")Integer id);
}