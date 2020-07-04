package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunContract;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Map;
import com.myfun.repository.erpdb.po.ErpFunContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunContractMapper extends BaseMapper<ErpFunContract, ErpFunContract> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunContract> selectByExampleWithBLOBs(ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunContract> selectByExample(ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunContract record,
			@Param("example") ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunContract record,
			@Param("example") ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunContract record, @Param("example") ErpFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunContract record);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    Map<String,Object> getLinkInfo(ErpFunContract erpFunContract);
}