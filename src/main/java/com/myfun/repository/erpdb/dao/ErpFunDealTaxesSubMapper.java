package com.myfun.repository.erpdb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunDealTaxesSub;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesSubExample;
import java.util.List;

public interface ErpFunDealTaxesSubMapper extends BaseMapper<ErpFunDealTaxesSub, ErpFunDealTaxesSub> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealTaxesSubExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealTaxesSubExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunDealTaxesSub> selectByExample(ErpFunDealTaxesSubExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealTaxesSub record,
			@Param("example") ErpFunDealTaxesSubExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealTaxesSub record,
			@Param("example") ErpFunDealTaxesSubExample example);
	/**
	 * 试用开库附加逻辑
	 * @param cityId
	 * @param erpCompId
	 * @param id 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertTaxesSubComp(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId, @Param("id") Integer id);
	/**
	 * 试用开库附加逻辑
	 * @param cityId
	 * @param erpCompId
	 * @param id 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertTaxesSubCompTax(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId, @Param("id") Integer id);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void insertBathList(@Param("shardCityId") Integer cityId,@Param("subList") List<ErpFunDealTaxesSub> subList);
}