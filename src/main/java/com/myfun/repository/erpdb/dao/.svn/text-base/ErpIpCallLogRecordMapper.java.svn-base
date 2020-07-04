package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpIpCallLogRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpIpCallLogRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpIpCallLogRecordMapper extends BaseMapper<ErpIpCallLogRecord, ErpIpCallLogRecord> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpIpCallLogRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpIpCallLogRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpIpCallLogRecord> selectByExample(ErpIpCallLogRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpIpCallLogRecord record,
			@Param("example") ErpIpCallLogRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpIpCallLogRecord record,
			@Param("example") ErpIpCallLogRecordExample example);

	void addHouseCallCount(ErpIpCallLogRecord record);
}