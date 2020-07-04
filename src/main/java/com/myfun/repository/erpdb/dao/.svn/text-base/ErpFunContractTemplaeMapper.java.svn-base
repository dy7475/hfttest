package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import com.myfun.repository.erpdb.po.ErpFunContractTemplae;
import com.myfun.repository.erpdb.po.ErpFunContractTemplaeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunContractTemplaeMapper extends BaseMapper<ErpFunContractTemplae, ErpFunContractTemplae> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunContractTemplae> selectByExampleWithBLOBs(ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunContractTemplae> selectByExample(ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunContractTemplae record,
			@Param("example") ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunContractTemplae record,
			@Param("example") ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunContractTemplae record,
			@Param("example") ErpFunContractTemplaeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunContractTemplae record);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    List<ErpFunContractTemplae> getTemplatList(@Param("shardCityId") Integer cityId, @Param("youCityDealNeedExamine") String youCityDealNeedExamine, @Param("youJiaDeptFlag") Boolean youJiaDeptFlag,@Param("templateType")Byte templateType, @Param("compId") Integer compId);

    void addOrEditContractTemplate(ErpFunContractTemplae erpFunContractTemplae, List<ErpFunContractIndex> paramList);

    @SwitchDB(type= SwitchDBType.CITY_ID)
	int countContractTemplete(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("youCityDealNeedExamine")String youCityDealNeedExamine, @Param("youJiaDeptFlag")Boolean youJiaDeptFlag,@Param("templateType")Byte templateType);
}