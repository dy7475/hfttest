package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditComment;
import com.myfun.repository.erpdb.po.ErpAuditCommentExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditCommentMapper extends BaseMapper<ErpAuditComment, ErpAuditComment> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditCommentExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditCommentExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditComment> selectByExample(ErpAuditCommentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditComment record,
			@Param("example") ErpAuditCommentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditComment record, @Param("example") ErpAuditCommentExample example);
}