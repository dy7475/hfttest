package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.attendance.vo.ErpCheckInRecordDto;
import com.myfun.repository.erpdb.po.ErpCheckInRecord;
import com.myfun.repository.erpdb.po.ErpCheckInRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpCheckInRecordMapper extends BaseMapper<ErpCheckInRecord, ErpCheckInRecord> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpCheckInRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpCheckInRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpCheckInRecord> selectByExample(ErpCheckInRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpCheckInRecord record,
			@Param("example") ErpCheckInRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpCheckInRecord record, @Param("example") ErpCheckInRecordExample example);

	List<ErpCheckInRecordDto> getCheckInRecordList(@Param("shardCityId")Integer cityId,@Param("checkId") Integer checkId,@Param("outId") Integer outId);
}