package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClass;
import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClassExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunGenerationPaymentClassMapper extends BaseMapper<ErpFunGenerationPaymentClass, ErpFunGenerationPaymentClass> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunGenerationPaymentClassExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunGenerationPaymentClassExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunGenerationPaymentClass> selectByExample(ErpFunGenerationPaymentClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunGenerationPaymentClass record,
			@Param("example") ErpFunGenerationPaymentClassExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunGenerationPaymentClass record,
			@Param("example") ErpFunGenerationPaymentClassExample example);

    ErpFunGenerationPaymentClass getClassById(@Param("shardCityId") Integer cityId, @Param("id") Integer generationPaymentClass);

	List<ErpFunGenerationPaymentClass> getClassByIds(@Param("shardCityId")Integer cityId, @Param("ids") Set<Integer> generationPaymentClassList);
}