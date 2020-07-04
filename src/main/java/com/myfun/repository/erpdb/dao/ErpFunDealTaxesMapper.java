package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealTaxes;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealTaxesMapper extends BaseMapper<ErpFunDealTaxes, ErpFunDealTaxes> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealTaxesExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealTaxes> selectByExample(ErpFunDealTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealTaxes record,
			@Param("example") ErpFunDealTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealTaxes record, @Param("example") ErpFunDealTaxesExample example);

	List<ErpFunDealTaxes> getModelDataList(@Param("shardCityId")Integer shardCityId,@Param("dealId") Integer dealId,@Param("payType") String payType);
}