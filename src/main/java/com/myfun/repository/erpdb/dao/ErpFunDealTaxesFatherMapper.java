package com.myfun.repository.erpdb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunDealTaxesFather;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesFatherExample;
import java.util.List;

public interface ErpFunDealTaxesFatherMapper extends BaseMapper<ErpFunDealTaxesFather, ErpFunDealTaxesFather> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealTaxesFatherExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealTaxesFatherExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealTaxesFather> selectByExample(ErpFunDealTaxesFatherExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealTaxesFather record,
			@Param("example") ErpFunDealTaxesFatherExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealTaxesFather record,
			@Param("example") ErpFunDealTaxesFatherExample example);

	/**
	 * 试用开库附加逻辑
	 * @param cityId
	 * @param erpCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer insertTaxesFatherComp(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId, @Param("name") String name);


	List<ErpFunDealTaxesFather> getDealTaxesFatherByCompId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId, @Param("payType")int payType);
}