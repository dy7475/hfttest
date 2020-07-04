package com.myfun.repository.fafundb.dao;

import com.myfun.repository.fafundb.dto.FafunTHouseTrendsDto;
import com.myfun.repository.fafundb.po.FafunTHouseTrends;
import com.myfun.repository.fafundb.po.FafunTHouseTrendsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FafunTHouseTrendsMapper extends BaseMapper<FafunTHouseTrends, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(FafunTHouseTrendsExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(FafunTHouseTrendsExample example);
	/**
	 * @mbggenerated
	 */
	List<FafunTHouseTrends> selectByExample(FafunTHouseTrendsExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") FafunTHouseTrends record,
			@Param("example") FafunTHouseTrendsExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") FafunTHouseTrends record, @Param("example") FafunTHouseTrendsExample example);
	/**
     * 点击量排名统?
     * @author 何传?
     * @since 2017?7?13?
     * @param map
     * @return
     */
	List<FafunTHouseTrendsDto> getClickRankCount(@Param("param") Map<String, Object> param);
	/**
	 * 总点击量查询
	 * @author 何传?
	 * @since 2017?7?15?
	 * @param param
	 * @return
	 */
	List<FafunTHouseTrendsDto> getClickCoun(@Param("param")Map<String, Object> param);
	/**
	 * 通过房源ID查询点击?
	 * @author 何传?
	 * @since 2017?7?15?
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getClickCountByHouseId(@Param("param")Map<String, Object> param);
	/**
	 * 点击量按天时间分?
	 * @author 熊刚
	 * @since 2017?7?14?
	 * @param param
	 * @return
	 */
	FafunTHouseTrendsDto getClickCountByDateTime(@Param("param") Map<String, Object> param);
	/**
	 * 点击量按天月分析
	 * @author 熊刚
	 * @since 2017?7?14?
	 * @param param
	 * @return
	 */
	List<FafunTHouseTrendsDto> getClickCountByMonthTime(@Param("param") Map<String, Object> param);
	
	
	/**
	 * 点击量按站点分析
	 * @author 熊刚
	 * @since 2017?7?14?
	 * @param param
	 * @return
	 */
	List<FafunTHouseTrendsDto> getClickCountBySite(@Param("param") Map<String, Object> param);
	/**
	 * 点击量按组织机构分析
	 * @author 熊刚
	 * @since 2017?7?15?
	 * @param param
	 * @return
	 */
	List<FafunTHouseTrendsDto> getClickCountByOrg(@Param("param") Map<String, Object> param);
	
	/**
	 * 点击量按房源分析
	 * @author 熊刚
	 * @since 2017?7?15?
	 * @param param
	 * @return
	 */
	List<FafunTHouseTrendsDto> getClickCountByHouse(@Param("param") Map<String, Object> param);
	
	List<Map<String, Object>> getTopFiveSitelist(@Param("param") Map<String, Object> param);
	/**
	 * 按组织还查询对应网站点击
	 * @author 熊刚
	 * @since 2017年7月25日
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getClickOrg(@Param("param")Map<String, Object> param);
	/**
	 * 按组织房源对应网站点击
	 * @author 熊刚
	 * @since 2017年7月25日
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getSiteByHouseType(@Param("param")Map<String, Object> param);
}