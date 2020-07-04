package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditCommentFile;
import com.myfun.repository.erpdb.po.ErpAuditCommentFileExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditCommentFileMapper extends BaseMapper<ErpAuditCommentFile, ErpAuditCommentFile> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditCommentFileExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditCommentFileExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditCommentFile> selectByExample(ErpAuditCommentFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditCommentFile record,
			@Param("example") ErpAuditCommentFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditCommentFile record,
			@Param("example") ErpAuditCommentFileExample example);
}