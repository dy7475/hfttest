package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunProcessLog;
import com.myfun.repository.erpdb.po.ErpFunProcessLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunProcessLogMapper extends BaseMapper<ErpFunProcessLog, ErpFunProcessLog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProcessLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProcessLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunProcessLog> selectByExample(ErpFunProcessLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunProcessLog record,
			@Param("example") ErpFunProcessLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunProcessLog record, @Param("example") ErpFunProcessLogExample example);
}