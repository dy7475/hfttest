package com.myfun.repository.erpdb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunDealCodelog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealCodelogExample;
import java.util.List;

public interface ErpFunDealCodelogMapper extends BaseMapper<ErpFunDealCodelog, ErpFunDealCodelog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealCodelogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealCodelog> selectByExample(ErpFunDealCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealCodelog record,
			@Param("example") ErpFunDealCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealCodelog record, @Param("example") ErpFunDealCodelogExample example);

	void updateFunDealCodeLog(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> param);

	int countModelData(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> param);

	Integer getIsAllowCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("codeNo") String codeNo, @Param("dealType") Integer dealType);

	Integer getCodeId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("codeNo") String codeNo,
					  @Param("dealType")  Integer dealType,@Param("deptId") Integer deptId);

	void deleteByCodeId(@Param("shardCityId") Integer cityId,@Param("codeId") Integer codeId);
}