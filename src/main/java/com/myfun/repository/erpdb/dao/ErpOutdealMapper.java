package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.param.GetContractDealParam;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpOutdealDto;
import com.myfun.repository.erpdb.param.ErpFunOutdealParam;
import com.myfun.repository.erpdb.po.ErpOutdeal;
import com.myfun.repository.erpdb.po.ErpOutdealExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpOutdealMapper extends BaseMapper<ErpOutdeal, ErpOutdeal> {
	/**
	 *
	 * @mbggenerated
	 */
	int countByExample(ErpOutdealExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int deleteByExample(ErpOutdealExample example);

	/**
	 *
	 * @mbggenerated
	 */
	List<ErpOutdeal> selectByExample(ErpOutdealExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpOutdeal record, @Param("example") ErpOutdealExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpOutdeal record, @Param("example") ErpOutdealExample example);

	List<ErpOutdeal> getOutDealInfo(@Param("shardCityId") Integer cityId,@Param("param") ErpFunOutdealParam param);

	List<ErpOutdeal> getContractDealList(@Param("shardCityId") Integer cityId,@Param("param") GetContractDealParam param);

	@ResultType(value = Map.class)
	Map<String,Object> getContractDealTotalPrice(@Param("shardCityId") Integer cityId, @Param("param") GetContractDealParam param);
}