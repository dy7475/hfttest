package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditClass;
import com.myfun.repository.erpdb.po.ErpAuditClassExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditClassMapper extends BaseMapper<ErpAuditClass, ErpAuditClass> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditClassExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditClassExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditClass> selectByExample(ErpAuditClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditClass record, @Param("example") ErpAuditClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditClass record, @Param("example") ErpAuditClassExample example);
}