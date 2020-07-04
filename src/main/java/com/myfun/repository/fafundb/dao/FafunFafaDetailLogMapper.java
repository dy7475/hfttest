package com.myfun.repository.fafundb.dao;

import com.myfun.repository.fafundb.dto.FafaSiteClickRankDto;
import com.myfun.repository.fafundb.dto.FafunFafaDetailLogDto;
import com.myfun.repository.fafundb.po.FafunFafaDetailLog;
import com.myfun.repository.fafundb.po.FafunFafaDetailLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FafunFafaDetailLogMapper extends BaseMapper<FafunFafaDetailLog, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(FafunFafaDetailLogExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(FafunFafaDetailLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<FafunFafaDetailLog> selectByExample(FafunFafaDetailLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FafunFafaDetailLog record, @Param("example") FafunFafaDetailLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FafunFafaDetailLog record, @Param("example") FafunFafaDetailLogExample example);
    /**
     * 获取各站点房源发布量统计
     * @author 何传强
     * @since 2017年7月13日
     * @param cityId
     * @param compId
     * @return
     */
    List<FafaSiteClickRankDto> getEachSiteHousePushCount(@Param("param") Map<String, Object> param);
    /**
     * 发布异常分析统计
     * @author 何传强
     * @since 2017年7月13日
     * @param param
     * @return
     */
	List<FafunFafaDetailLogDto> getPushExpectionCount(@Param("param") Map<String, Object> param);
	/**
	 * 综合统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param map
	 * @return
	 */
	List<FafaSiteClickRankDto> getFafaComprehensiveStatistic(@Param("param") Map<String, Object> param);
	/**
	 * 房源发布总量统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param map
	 * @return
	 */
	Integer getHousePushCountData(@Param("param") Map<String, Object> param);
	/**
	 * 按站点统计异常发布量
	 * @author 何传强
	 * @since 2017年7月15日
	 * @param param
	 * @return
	 */
	List<FafunFafaDetailLogDto> getFafaExceptionCountSite(@Param("param")Map<String, Object> param);
	/**
	 * 按人员统计异常发布量
	 * @author 何传强
	 * @since 2017年7月15日
	 * @param param
	 * @return
	 */
	List<FafunFafaDetailLogDto> getFafaExceptionCountUSER(@Param("param")Map<String, Object> param);
	/**
	 * 按次数统计异常
	 * @author 何传强
	 * @since 2017年7月17日
	 * @param param
	 * @return
	 */
	List<FafunFafaDetailLogDto> getExpectionCountStatistic(@Param("param")Map<String, Object> param);
	/**
	 * 按次数统计人员异常量
	 * @author 何传强
	 * @since 2017年7月18日
	 * @param map
	 * @return
	 */
	List<FafunFafaDetailLogDto> getExpectionCountByUser(@Param("param")Map<String, Object> param);
	/**
	 * 按照人员统计站点  报表/图表
	 * @author 何传强
	 * @since 2017年7月24日
	 * @param map
	 * @return
	 */
	List<FafaSiteClickRankDto> getUserTableOrChartCount(@Param("param")Map<String, Object> param);

	List<FafunFafaDetailLogDto> getFafaCountList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userId") Integer userId,@Param("dateTimeStr") String dateTimeStr);
	
	/**
	 * 获取公司员工指定日期范围跑分排名
	 * @author 朱科
	 * @since 2018年7月19日
	 * @return
	 */
	List<FafunFafaDetailLogDto> getSpecifyFafaCountList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userIds")List<Integer> userIds,@Param("dateTime") String dateTime, @Param("archiveId")Integer archiveId);
}