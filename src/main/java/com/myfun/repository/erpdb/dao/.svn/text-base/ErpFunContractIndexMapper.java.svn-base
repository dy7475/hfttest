package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import com.myfun.repository.erpdb.po.ErpFunContractIndexExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunContractIndexMapper extends BaseMapper<ErpFunContractIndex, ErpFunContractIndex> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunContractIndexExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunContractIndexExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunContractIndex> selectByExample(ErpFunContractIndexExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunContractIndex record,@Param("example") ErpFunContractIndexExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunContractIndex record,@Param("example") ErpFunContractIndexExample example);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    List<ErpFunContractIndex> getList(@Param("shardCityId")Integer cityId, @Param("caseType")Integer caseType);
}