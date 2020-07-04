package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminXwBankAccount;
import com.myfun.repository.admindb.po.AdminXwBankAccountExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminXwBankAccountMapper extends BaseMapper<AdminXwBankAccount, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminXwBankAccountExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminXwBankAccountExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminXwBankAccount> selectByExample(AdminXwBankAccountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminXwBankAccount record,
			@Param("example") AdminXwBankAccountExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminXwBankAccount record,
			@Param("example") AdminXwBankAccountExample example);
}