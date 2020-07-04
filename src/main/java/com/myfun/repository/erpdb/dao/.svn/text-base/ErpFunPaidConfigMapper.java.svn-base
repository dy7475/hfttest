package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPaidConfig;
import com.myfun.repository.erpdb.po.ErpFunPaidConfigExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunPaidConfigMapper extends BaseMapper<ErpFunPaidConfig, ErpFunPaidConfig> {
	/**
	 *
	 * @mbggenerated
	 */
	int countByExample(ErpFunPaidConfigExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPaidConfigExample example);

	/**
	 *
	 * @mbggenerated
	 */
	List<ErpFunPaidConfig> selectByExample(ErpFunPaidConfigExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPaidConfig record, @Param("example") ErpFunPaidConfigExample example);

	/**
	 *
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPaidConfig record, @Param("example") ErpFunPaidConfigExample example);

	ErpFunPaidConfig getFunPaidConfig(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
}