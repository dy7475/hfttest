package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpEarbestMoney;
import com.myfun.repository.erpdb.po.ErpEarbestMoneyExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpEarbestMoneyMapper extends BaseMapper<ErpEarbestMoney, ErpEarbestMoney> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpEarbestMoney> selectByExample(ErpEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpEarbestMoney record,
			@Param("example") ErpEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpEarbestMoney record, @Param("example") ErpEarbestMoneyExample example);

	List<ErpFunEarbestMoneyDto> selectEarbestMoneyList(@Param("shardCityId")Integer cityId,
			@Param("param")DaoBaseParam param);

	List<ErpFunEarbestMoneyDto> selectEarbestMoneyListNew(@Param("shardCityId")Integer cityId,
			@Param("param")DaoBaseParam param);

	Integer count(@Param("shardCityId")Integer cityId,@Param("erpEarbestMoney") ErpEarbestMoney erpEarbestMoney);

	ErpFunEarbestMoneyDto selectEarbestMoneyDetail(@Param("shardCityId")Integer cityId,
												   @Param("earbestId") Integer earbestId);

	void delBillPhoto(@Param("shardCityId")Integer cityId,@Param("earbestId") Integer earbestId);
}