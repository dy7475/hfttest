package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminGoodNewsTemplete;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminGoodNewsTempleteMapper extends BaseMapper<AdminGoodNewsTemplete, Integer> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminGoodNewsTemplete record);

	AdminGoodNewsTemplete selectLastUseTemplet(Integer compId);
}