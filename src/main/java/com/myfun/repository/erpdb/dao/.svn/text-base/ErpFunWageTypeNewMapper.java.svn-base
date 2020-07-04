package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunWageTypeNewDto;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNewExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpFunWageTypeNewMapper extends BaseMapper<ErpFunWageTypeNew, ErpFunWageTypeNew> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWageTypeNewExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWageTypeNewExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunWageTypeNew> selectByExample(ErpFunWageTypeNewExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunWageTypeNew record,@Param("example") ErpFunWageTypeNewExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunWageTypeNew record,@Param("example") ErpFunWageTypeNewExample example);

	List<ErpFunWageTypeNew> selectWageTypeNewListByComp(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId);

	List<ErpFunWageTypeNew> getSalaryPlanByComp(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId);

	List<ErpFunWageTypeNew> getSalaryPlanByUserId(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("userId")Integer userId);

	void clearManagePlanInfo(@Param("shardCityId")Integer cityId,@Param("updateModel")ErpFunWageTypeNew inErpFunWageTypeNew);

	List<ErpFunWageTypeNew> selectMyWageTypeList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("managePlan")Integer managePlan, @Param("performanceType")Integer performanceType, @Param("wageTypeName")String wageTypeName);

	List<ErpFunWageTypeNew> getFunWageTypeNewByComp(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	/**
	 * 由主键IDs批量获取提成方案 返回的是PO类型
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpFunWageTypeNew> getMyWageTypeListByIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("idList")List<String> dList);

	/**
	 * 由主键IDs批量获取提成方案  返回的是DTO类型
	 * @param cityId
	 * @param compId
	 * @param dList
	 * @return
	 */
	List<ErpFunWageTypeNewDto> getMyWageTypeDtoListByIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("idList")List<String> dList);

	/**
	 *  由主键IDs批量删除提成方案
	 * @param cityId 原来的老数据方案不会删除
	 * @param compId
	 * @param wagetypeIds
	 * @return
	 */
	int deleteBatchByIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("idList")List<String> wagetypeIds);
}