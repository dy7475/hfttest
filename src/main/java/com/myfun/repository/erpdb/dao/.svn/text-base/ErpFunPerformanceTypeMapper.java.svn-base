package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ErpFunPerformanceTypeMapper extends BaseMapper<ErpFunPerformanceType, ErpFunPerformanceType> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPerformanceTypeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPerformanceTypeExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunPerformanceType> selectByExample(ErpFunPerformanceTypeExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunPerformanceType record,@Param("example") ErpFunPerformanceTypeExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunPerformanceType record,@Param("example") ErpFunPerformanceTypeExample example);

	List<ErpFunPerformanceType> getDataListByCompId(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);

    void insertFunPerforManceType(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);

    void insertFunPerforManceTypeForFjd(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
    void insertFunPerforManceTypeForInit(@Param("shardDbName") String shardDbName, @Param("compId")Integer compId);

    /**
     * 
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/15
     */
    Integer getHasunPerformanceTypeId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("performanceName") String performanceName);

    Integer getFjdHasunPerformanceTypeId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("performanceName") String performanceName,@Param("alias") String alias,@Param("collectionType") Byte collectionType,@Param("commissionType") Byte commissionType);

	List<ErpFunPerformanceType> getPerformanceType(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	ErpFunPerformanceType selectOneByExample(ErpFunPerformanceTypeExample example);

	@Select("SELECT COMP_ID from FUN_PERFORMANCE_TYPE WHERE COMP_ID>0 GROUP BY COMP_ID order by COMP_ID")
	List<Integer> getAllCompId(@Param("shardDbName") String shardDbName);

	List<ErpFunPerformanceType> getFjdDataListByCompId(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
}