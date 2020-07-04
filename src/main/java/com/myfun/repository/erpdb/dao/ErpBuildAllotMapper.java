package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBuildAllot;
import com.myfun.repository.erpdb.po.ErpBuildAllotExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildAllotMapper extends BaseMapper<ErpBuildAllot, ErpBuildAllot> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildAllotExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildAllotExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildAllot> selectByExample(ErpBuildAllotExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildAllot record,@Param("example") ErpBuildAllotExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildAllot record,@Param("example") ErpBuildAllotExample example);


	int deleteBeforConfigBuild(@Param("shardCityId") Integer cityid,@Param("compId") Integer compId,@Param("buildId") Integer buildId);
}