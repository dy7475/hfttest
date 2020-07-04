package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.param.FunWageDetailParam;
import com.myfun.erpWeb.managecenter.profit.param.FunWageListParam;
import com.myfun.repository.erpdb.dto.ErpFunWageDto;
import com.myfun.repository.erpdb.param.ErpFunWageParam;
import com.myfun.repository.erpdb.po.ErpFunWage;
import com.myfun.repository.erpdb.po.ErpFunWageExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ErpFunWageMapper extends BaseMapper<ErpFunWage, ErpFunWage> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWageExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWage> selectByExample(ErpFunWageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWage record, @Param("example") ErpFunWageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWage record, @Param("example") ErpFunWageExample example);

	List<ErpFunWageDto> getFunWageList(@Param("shardCityId") Integer cityId, @Param("param") FunWageListParam param,
									   @Param("assessMentMonthSet") Set<String> assessMentMonth);
	
	/**
	 * 通过userIds去查询该月的工资�?
	 * @author 张宏�?
	 * @since 2018�?2�?7�?
	 * @param cityId
	 * @param compId
	 * @param userIdSet
	 * @param assessMentMonth
	 * @return
	 */
	@MapKey("userId")
	Map<Integer, Map<String, Object>> getWageStatistic(@Param("shardCityId") Integer cityId,
			@Param("compId") Integer compId, @Param("userIdSet") Set<Integer> userIdSet,
			@Param("assessMentMonth") String assessMentMonth);

	@Deprecated
	List<ErpFunWage> getStaticWageInfoList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("grId") Integer grId,@Param("userId") Integer userId,@Param("startDate") String startDate,@Param("subDate") String subDate);

    ErpFunWage getFunWageByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("userId")Integer userId, @Param("assessmentMonth") String  assessMentMonth);

    // effectiveThisMonth 本月是否生效，true = 生效  false = 不生效
	void initWageByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("userId")Integer userId, @Param("baseWage")BigDecimal baseWage, @Param("assessmentMonth") String  assessMentMonth, @Param("effectiveThisMonth") Integer effectiveThisMonth);

	/**
	 * 由用户id和结算月获取薪资详情
	 * �?  由薪资id和结算月获取薪资详情
	 * @param cityId
	 * @param param
	 * @return
	 */
	ErpFunWageDto getFunWageDetail(@Param("shardCityId")Integer cityId,@Param("param") FunWageDetailParam param,
								   @Param("assessMentMonthSet") Set<String> assessMonthSet);

    List<ErpFunWageDto> getFunWageListNewOrg(@Param("shardCityId") Integer cityId, @Param("param") FunWageListParam param,
											 @Param("assessMentMonthSet") Set<String> assessMentMonth);
}

