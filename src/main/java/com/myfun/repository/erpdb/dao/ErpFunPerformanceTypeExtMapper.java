package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunPerformanceTypeExtListDto;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExt;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExtExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPerformanceTypeExtMapper extends BaseMapper<ErpFunPerformanceTypeExt, ErpFunPerformanceTypeExt> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPerformanceTypeExtExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPerformanceTypeExtExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunPerformanceTypeExt> selectByExample(ErpFunPerformanceTypeExtExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunPerformanceTypeExt record,@Param("example") ErpFunPerformanceTypeExtExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunPerformanceTypeExt record,@Param("example") ErpFunPerformanceTypeExtExample example);

	List<ErpFunPerformanceTypeExtListDto> getErpFunPerformanceTypeExtList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	void updateTargetPerformanceIdNull(@Param("shardCityId") Integer cityId,@Param("extId") Integer extId);
}