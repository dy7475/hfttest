package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunProfitTargetDto;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.param.ProfitDragonTigerParam;
import com.myfun.repository.erpdb.po.ErpFunProfitTarget;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunProfitTargetExample;

public interface ErpFunProfitTargetMapper extends BaseMapper<ErpFunProfitTarget, ErpFunProfitTarget> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProfitTargetExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProfitTargetExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunProfitTarget> selectByExample(ErpFunProfitTargetExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunProfitTarget record,@Param("example") ErpFunProfitTargetExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunProfitTarget record,@Param("example") ErpFunProfitTargetExample example);

	List<Map<String, Object>> getFunProfitReportTargetCount(@Param("shardCityId")Integer cityId,@Param("param") ProfitDragonTigerParam param,
			@Param("target")String targetType);

	List<ErpFunProfitTargetDto> getProfitTargetList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
													@Param("startTime") Date startTime ,
													@Param("manageRangIds") Set<Integer> manageRangIds, @Param("groupRange") Integer groupRange);

	List<ErpFunProfitTarget> getProfitListByMap(@Param("shardCityId")Integer cityId, @Param("param")Map<String,Object> paramMap);

	void deleteByParam(@Param("shardCityId")Integer cityId,@Param("keyFild")String keyFild,@Param("delKeys") String[] delKeys,@Param("profitType") Byte profitType,@Param("profitDate") String profitDate,@Param("ids") String[] ids);

	ErpFunProfitTarget getProfitTargetByCondition(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("profitType") Byte profitType,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("param") ErpFunProfitTarget funProfitTargetPO);

	List<ErpFunProfitTarget> getProfitTarget(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("startDate") String startDate,@Param("subDate") String subDate,@Param("userIds") List<Integer> userIds);

	List<ErpFunDealDto> getTargetListMap(@Param("shardCityId")Integer cityId, @Param("param") BaseMapParam param);

    void insertSelectiveNewOrg(@Param("param") ErpFunProfitTarget profitTargetPO,@Param("dbFieldPath") String dbFieldPath,@Param("orgIds") String orgIds);
}