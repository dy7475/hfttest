package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDeptFeeRecord;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDeptFeeRecordMapper extends BaseMapper<ErpFunDeptFeeRecord, ErpFunDeptFeeRecord> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunDeptFeeRecord> selectByExampleWithBLOBs(ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunDeptFeeRecord> selectByExample(ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunDeptFeeRecord record,@Param("example") ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleWithBLOBs(@Param("record") ErpFunDeptFeeRecord record,@Param("example") ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunDeptFeeRecord record,@Param("example") ErpFunDeptFeeRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunDeptFeeRecord record);
}