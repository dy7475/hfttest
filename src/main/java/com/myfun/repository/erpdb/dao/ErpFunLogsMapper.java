package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunLogs;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunLogsMapper extends BaseMapper<ErpFunLogs, ErpFunLogs> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunLogsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunLogsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunLogs> selectByExample(ErpFunLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunLogs record, @Param("example") ErpFunLogsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunLogs record, @Param("example") ErpFunLogsExample example);
}