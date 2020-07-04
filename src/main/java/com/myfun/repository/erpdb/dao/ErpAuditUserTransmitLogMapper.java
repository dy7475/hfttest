package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditUserTransmitLog;
import com.myfun.repository.erpdb.po.ErpAuditUserTransmitLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditUserTransmitLogMapper extends BaseMapper<ErpAuditUserTransmitLog, ErpAuditUserTransmitLog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditUserTransmitLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditUserTransmitLogExample example);

	/**
	 * @mbggenerated
	 */List<ErpAuditUserTransmitLog> selectByExample(ErpAuditUserTransmitLogExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpAuditUserTransmitLog record,@Param("example") ErpAuditUserTransmitLogExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpAuditUserTransmitLog record,@Param("example") ErpAuditUserTransmitLogExample example);
}