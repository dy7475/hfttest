package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBuildRuleBatchTemp;
import com.myfun.repository.erpdb.po.ErpBuildRuleBatchTempExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildRuleBatchTempMapper extends BaseMapper<ErpBuildRuleBatchTemp, ErpBuildRuleBatchTemp> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildRuleBatchTempExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildRuleBatchTempExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildRuleBatchTemp> selectByExample(ErpBuildRuleBatchTempExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildRuleBatchTemp record,@Param("example") ErpBuildRuleBatchTempExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildRuleBatchTemp record,@Param("example") ErpBuildRuleBatchTempExample example);
}