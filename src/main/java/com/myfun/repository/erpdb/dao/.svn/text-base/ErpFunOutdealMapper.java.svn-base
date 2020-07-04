package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.param.ErpFunOutdealParam;
import com.myfun.repository.erpdb.po.ErpFunOutdeal;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunOutdealExample;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunOutdealMapper extends BaseMapper<ErpFunOutdeal, ErpFunOutdeal> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunOutdealExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunOutdealExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunOutdeal> selectByExample(ErpFunOutdealExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunOutdeal record,@Param("example") ErpFunOutdealExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunOutdeal record,@Param("example") ErpFunOutdealExample example);

	public Integer getOutDealId(@Param("shardCityId")Integer cityId);

	/**
	 * 通过条件获取外成交列表
	 * @author ZangTie
	 * @param cityId 
	 * @since 2018年7月27日 上午11:11:44
	 * @param param
	 * @return
	 * Modified XXX ZangTie 2018年7月27日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	public List<ErpFunOutdeal> getOutDealListByCondition(@Param("shardCityId")Integer cityId, @Param("param")ErpFunOutdealParam param);
	
	/**
	 * 掌通运营分析排行榜
	 * @author 朱科
	 * @since 2018年9月20日
	 * @return
	 */
	public List<Map<String, Object>> getOutDealStatisticsRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("lookType")Integer lookType, @Param("rangeType")Integer rangeType, @Param("rangeIds")Set<Integer> rangeIds, @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("selfDeptId")Integer selfDeptId, @Param("profitShowType")Integer profitShowType, @Param("isFjdFlag") boolean isFjdFlag);


	List<Map<String, Object>> getOutDealStatisticsRankForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("startTime")String startTime, @Param("endTime")String endTime,@Param("groupByCause")String groupByCause,
															 @Param("whereCause") String whereCause);

	/**
	 * 掌通运营分析汇总表
	 * @author 朱科
	 * @since 2018年9月20日
	 * @return
	 */
	public Map<String, Integer> getAppCompProfit(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds, 
			@Param("rangeType") Integer rangeType, @Param("startTime") String startTime, @Param("deptId")  Integer deptId);

	List<ErpFunDealDto> getProfitCountList(@Param("shardCityId")Integer cityId, @Param("param") BaseMapParam param, boolean dealCount);
}
