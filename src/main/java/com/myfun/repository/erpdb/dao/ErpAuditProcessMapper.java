package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditProcess;
import com.myfun.repository.erpdb.po.ErpAuditProcessExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditProcessMapper extends BaseMapper<ErpAuditProcess, ErpAuditProcess> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditProcessExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditProcessExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditProcess> selectByExample(ErpAuditProcessExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditProcess record,
			@Param("example") ErpAuditProcessExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditProcess record, @Param("example") ErpAuditProcessExample example);
}