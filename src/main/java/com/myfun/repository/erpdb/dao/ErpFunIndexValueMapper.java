package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunIndexValueDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunIndexValue;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunIndexValueExample;

public interface ErpFunIndexValueMapper extends BaseMapper<ErpFunIndexValue, ErpFunIndexValue> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunIndexValue> selectByExampleWithBLOBs(ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunIndexValue> selectByExample(ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunIndexValue record,
			@Param("example") ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunIndexValue record,
			@Param("example") ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunIndexValue record, @Param("example") ErpFunIndexValueExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunIndexValue record);

	List<Map<String, Object>> getIndexValue(@Param("shardCityId")Integer cityId,@Param("contractId") Integer contractId);

    List<ErpFunIndexValueDto> getIndexValueList(@Param("shardCityId")Integer cityId, @Param("contractId")List<Integer> contractId, @Param("contractEdition")Integer contractEdition);
}