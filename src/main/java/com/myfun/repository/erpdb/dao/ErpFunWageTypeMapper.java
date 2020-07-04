package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunWageType;
import com.myfun.repository.erpdb.po.ErpFunWageTypeKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunWageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunWageTypeMapper extends BaseMapper<ErpFunWageType, ErpFunWageTypeKey> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWageTypeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWageTypeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWageType> selectByExample(ErpFunWageTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWageType record,
			@Param("example") ErpFunWageTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWageType record, @Param("example") ErpFunWageTypeExample example);
	
}