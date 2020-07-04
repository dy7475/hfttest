package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBuildingSetLog;
import com.myfun.repository.erpdb.po.ErpBuildingSetLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildingSetLogMapper extends BaseMapper<ErpBuildingSetLog, ErpBuildingSetLog> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetLog> selectByExample(ErpBuildingSetLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetLog record,
			@Param("example") ErpBuildingSetLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetLog record, @Param("example") ErpBuildingSetLogExample example);

	/**
	 * 楼盘规则变动的时候增加日志
	 * 
	 * @author 张宏利
	 * @since 2018年1月18日
	 * @param cityId
	 * @param compId
	 * @param buildRoof
	 * @param buildUnit
	 * @param string
	 */
	void insertLog(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,
			@Param("compId") Integer compId, @Param("buildId") Integer buildId, @Param("buildRoof") String buildRoof,
			@Param("buildUnit") String buildUnit, @Param("logInfo") String logInfo);
}
