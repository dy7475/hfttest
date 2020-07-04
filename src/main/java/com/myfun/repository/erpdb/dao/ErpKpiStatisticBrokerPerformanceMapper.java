package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpKpiStatisticBrokerPerformance;
import com.myfun.repository.erpdb.po.ErpKpiStatisticBrokerPerformanceExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpKpiStatisticBrokerPerformanceMapper extends BaseMapper<ErpKpiStatisticBrokerPerformance, ErpKpiStatisticBrokerPerformance> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpKpiStatisticBrokerPerformanceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpKpiStatisticBrokerPerformanceExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpKpiStatisticBrokerPerformance> selectByExample(ErpKpiStatisticBrokerPerformanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpKpiStatisticBrokerPerformance record,
			@Param("example") ErpKpiStatisticBrokerPerformanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpKpiStatisticBrokerPerformance record,
			@Param("example") ErpKpiStatisticBrokerPerformanceExample example);

	/**
     * 查询一条数据
     * @detail [2020年04月10日] HuangJiang 
     * @author HuangJiang
     * @since 2020年04月10日 14:42
     * @param example
     * @return com.myfun.repository.erpdb.po.ErpKpiStatisticBrokerPerformance
     * Modified XXX HuangJiang 2020年04月10日
     */
    ErpKpiStatisticBrokerPerformance selectOneByExample(ErpKpiStatisticBrokerPerformanceExample example);
}