package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunDealRecordDto;
import com.myfun.repository.erpdb.po.ErpFunDealRecord;
import com.myfun.repository.erpdb.po.ErpFunDealRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDealRecordMapper extends BaseMapper<ErpFunDealRecord, ErpFunDealRecord> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealRecord> selectByExampleWithBLOBs(ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealRecord> selectByExample(ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealRecord record,
			@Param("example") ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunDealRecord record,
			@Param("example") ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealRecord record, @Param("example") ErpFunDealRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunDealRecord record);

	/**
	 * 获取合同日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param cityId
	 * @param dealId
	 * @param compId
	 * @return
	 */
	List<ErpFunDealRecordDto> getMgrDealNoteList(@Param("shardCityId") Integer cityId, @Param("dealId") String dealId, @Param("compId") Integer compId, @Param("logType") Integer logType);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunDealRecord getLastRecordId(@Param("shardCityId")Integer cityId, @Param("agreementNo")Integer agreementNo,
									 @Param("updateType") Byte type,@Param("pfActual")Byte pfActual);

}


