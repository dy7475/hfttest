package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.buildData.param.BuildLogListParam;
import com.myfun.repository.erpdb.po.ErpBuildLog;
import com.myfun.repository.erpdb.po.ErpBuildLogExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildLogMapper extends BaseMapper<ErpBuildLog, ErpBuildLog> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildLogExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildLogExample example);
	/**
	 * @mbggenerated
	 */List<ErpBuildLog> selectByExample(ErpBuildLogExample example);
	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildLog record,@Param("example") ErpBuildLogExample example);
	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildLog record,@Param("example") ErpBuildLogExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildLog> getBuildLogListByBuildIds(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("buildIdList") List<Integer> buildIdList);
	List<ErpBuildLog> getBuildLogList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("param")BuildLogListParam param);

	List<ErpBuildLog> getMaxIdList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("buildIdList") List<Integer> buildIdList);
}