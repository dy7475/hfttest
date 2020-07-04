package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBulletReply;
import com.myfun.repository.erpdb.po.ErpBulletReplyWithBLOBs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBulletReplyMapper extends BaseMapper<ErpBulletReply, ErpBulletReply> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpBulletReplyWithBLOBs record);
}