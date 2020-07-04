package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecord;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEarbestMoneyrecordMapper extends BaseMapper<ErpFunEarbestMoneyrecord, ErpFunEarbestMoneyrecord> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEarbestMoneyrecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEarbestMoneyrecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEarbestMoneyrecord> selectByExample(ErpFunEarbestMoneyrecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEarbestMoneyrecord record,
			@Param("example") ErpFunEarbestMoneyrecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEarbestMoneyrecord record,
			@Param("example") ErpFunEarbestMoneyrecordExample example);
}