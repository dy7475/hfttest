package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPartnerConfig;
import com.myfun.repository.erpdb.po.ErpFunPartnerConfigExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPartnerConfigMapper extends BaseMapper<ErpFunPartnerConfig, ErpFunPartnerConfig> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPartnerConfigExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPartnerConfigExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPartnerConfig> selectByExample(ErpFunPartnerConfigExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPartnerConfig record,
			@Param("example") ErpFunPartnerConfigExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPartnerConfig record,
			@Param("example") ErpFunPartnerConfigExample example);

	ErpFunPartnerConfig selectByPartnerId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("month") Date month);

}