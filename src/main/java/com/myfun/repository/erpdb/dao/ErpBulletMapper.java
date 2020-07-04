package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBullet;
import com.myfun.repository.erpdb.po.ErpBulletWithBLOBs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBulletMapper extends BaseMapper<ErpBullet, ErpBullet> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpBulletWithBLOBs record);
}