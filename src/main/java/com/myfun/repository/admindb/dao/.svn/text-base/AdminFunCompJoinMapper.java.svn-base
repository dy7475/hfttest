package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunCompJoin;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunCompJoinMapper extends BaseMapper<AdminFunCompJoin, Integer> {

	/**
	 * 注销当前公司加盟圈和加盟的公司记录
	 * @param compJoin
	 */
	void updateBySubCompNo(AdminFunCompJoin compJoin);

	/**
	 * 根据您SubCompNo查询
	 * @param compNo
	 * @return
	 */
	List<AdminFunCompJoin> selectBySubCompNo(String subCompNo);

	/**
	 * 根据SubCompNo和MainCompNo修改
	 * @param compJoin
	 */
	void updateBySubCompNoAndMainCompNo(AdminFunCompJoin compJoin);
}