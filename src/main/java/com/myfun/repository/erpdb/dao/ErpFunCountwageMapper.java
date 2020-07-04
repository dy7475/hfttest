package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunCountwageExample;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunCountwageMapper extends BaseMapper<ErpFunCountwage, ErpFunCountwage> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunCountwageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunCountwageExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunCountwage> selectByExample(ErpFunCountwageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunCountwage record,
			@Param("example") ErpFunCountwageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunCountwage record, @Param("example") ErpFunCountwageExample example);

	void delFunCountwageByWageTypeId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("wagetypeId")Integer wagetypeId);
	
	void delFunCountwageNotInwageCountIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("wagetypeId")Integer wagetypeId, @Param("wageCountIds")Set<Integer> wageCountIds);

	List<ErpFunCountwage> selectFunCountWageListByWageTypeId(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("wageTypeIdList")Integer wagetypeId);

	List<ErpFunCountwage> getFunCountwageByCompIdAndWageTypeIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("wageTypeIds") List<Integer> wageTypeIds);

	/**
	 * 由提成方案的IDs获取详情列表页
	 * @param cityId
	 * @param compId
	 * @param wageTypeIds 提成方案id
	 * @return
	 */
	List<ErpFunCountwage> getFunCountwageListByWageTypeIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
														   @Param("wageTypeIds") List<String> wageTypeIds);

	/**
	 * 由提成方案的Id批量删除提成区间
	 * @param cityId
	 * @param compId
	 * @param wageTypeIds
	 */
	int deleteByWageTypeId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
							@Param("wageTypeId") Integer wageTypeIds);

	/**
	 * 批量插入方案下的提成区间
	 * @param cityId
	 * @param countWageList
	 * @return
	 */
	int insertBatch(@Param("shardCityId")Integer cityId,@Param("countWageList")List<ErpFunCountwage> countWageList);

	/**
	 *批量删除多个方案下的多个提成区间
	 * @param cityId
	 * @param compId
	 * @param deleteTypeIds
	 * @return
	 */
	int deleteBatchByWageTypeId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("wagetypeIds")List<String> deleteTypeIds);

}