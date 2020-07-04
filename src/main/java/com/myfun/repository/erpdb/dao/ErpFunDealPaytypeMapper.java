package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.erpdb.po.ErpFunDealPaytypeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealPaytypeMapper extends BaseMapper<ErpFunDealPaytype, ErpFunDealPaytype> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealPaytypeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealPaytypeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealPaytype> selectByExample(ErpFunDealPaytypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealPaytype record,
			@Param("example") ErpFunDealPaytypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealPaytype record, @Param("example") ErpFunDealPaytypeExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void createCompTempleteDealPayTypeList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
}