package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunContractHistroy;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunContractHistroyMapper extends BaseMapper<AdminFunContractHistroy, Integer> {
	/**
	 * 删除历史合同
	 * @param deptId
	 */
	void deleteByDeptId(Integer deptId);

	/**
	 * 更加ID倒序查询一条数据
	 * @param deptId
	 * @return
	 */
	AdminFunContractHistroy selectByDeptIdIdDescTop1(Integer deptId);
}