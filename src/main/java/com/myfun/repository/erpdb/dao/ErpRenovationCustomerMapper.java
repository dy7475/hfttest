package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpRenovationCustomerMapper extends BaseMapper<ErpRenovationCustomer, ErpRenovationCustomer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpRenovationCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpRenovationCustomerExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpRenovationCustomer> selectByExample(ErpRenovationCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpRenovationCustomer record,
			@Param("example") ErpRenovationCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpRenovationCustomer record,
			@Param("example") ErpRenovationCustomerExample example);
	/**
	 * 装修统计
	 * 
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param serchRange
	 *            查询范围
	 * @param serchRangeId
	 *            范围ID
	 * @param dimension
	 *            统计维度
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	List<ErpRenovationCustomer> getRenovationStatistic(@Param("shardCityId") Integer cityId,
			@Param("compId") Integer compId, @Param("serchRange") String serchRange,
			@Param("serchRangeId") Integer serchRangeId, @Param("dimension") String dimension,
			@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("statisticType") Integer statisticType, @Param("houseAreaSql") String houseAreaSql);
	/**
	 * 查询装修列表信息
	 *@author 朱科
	 *@param houseUseage 用途 intentPricelow 最低价 intentPricehigh 最高价 custStatus 客户状态
	 *@return 
	 *@since 2018年2月27日
	 */
	List<ErpRenovationCustomer> getRenovationList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("userId") Integer userId, @Param("houseUseage") Integer houseUseage,
			@Param("intentPricelow") BigDecimal intentPricelow, @Param("intentPricehigh") BigDecimal intentPricehigh,
			@Param("custStatus") Integer custStatus, @Param("likeStr") String likeStr, @Param("param")Map<String, Object> param);
}
