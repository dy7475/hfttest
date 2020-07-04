package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.openApi.attendance.vo.ErpFunAttendanceStatisticsVO;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceStatisticsDto;
import com.myfun.repository.erpdb.param.ErpAttendanceStatisticalAnalysisParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatistics;
import com.myfun.repository.erpdb.po.ErpFunAttendanceStatisticsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceStatisticsMapper extends BaseMapper<ErpFunAttendanceStatistics, ErpFunAttendanceStatistics> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceStatistics> selectByExample(ErpFunAttendanceStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceStatistics record,
			@Param("example") ErpFunAttendanceStatisticsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceStatistics record,
			@Param("example") ErpFunAttendanceStatisticsExample example);

	List<Map<String, Object>> getAttendanceStatisticlAnalysisReportOffMonth(@Param("shardCityId")Integer cityId,
			@Param("param")ErpAttendanceStatisticalAnalysisParam param ,@Param("currentDate") String currentDate,@Param("currentAttDate") String currentAttDate,@Param("lastMissCardDate") String lastMissCardDate);

	List<ErpFunAttendanceStatistics> getAttendanceStatisticlAnalysisList(@Param("shardCityId")Integer cityId,
			@Param("param")ErpAttendanceStatisticalAnalysisParam param);

	List<ErpFunAttendanceStatistics> getAttendanceStatisticlMinerList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("archiveId") Integer archiveId,
			@Param("startTime") String startTime, @Param("endTime") String endTime , @Param("attResult") String attResult);
	
	/**
	 * 查询
	 * @author fangliji
	 * @date 2017年12月6日
	 */
	ErpFunAttendanceStatistics getAttendanceStatisticOffUser(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("archiveId")Integer archiveId,
			@Param("attDate")String attDate);
	
	/**
	 * 查询某一天的考勤统计列表
	 * @author fangliji
	 * @date 2017年12月6日
	 */
	List<ErpFunAttendanceStatistics> getAttendanceStatisticListOffOneDay(@Param("shardCityId")Integer cityId, 
																			@Param("compId")Integer compId, 
																			@Param("areaId")Integer areaId,
																			@Param("regId")Integer regId, 
																			@Param("deptId")Integer deptId, 
																			@Param("grId")Integer grId, 
																			@Param("userId")Integer userId, 
																			@Param("attDate")String attDateStr , 
																			@Param("userIdList")List<Integer> userIdList);
	
	/**
	 * 查询一个月的考勤统计列表
	 * 
	 * OFF_WORK = 0的考勤数据
	 * 
	 * @author 陈文超
	 * @date 2017年12月8日 下午9:37:41
	 */
	List<ErpFunAttendanceStatistics> getAttendanceStatisticListOffOneMonth(@Param("shardCityId")Integer cityId, 
																			@Param("compId")Integer compId, 
																			@Param("areaId")Integer areaId,
																			@Param("regId")Integer regId, 
																			@Param("deptId")Integer deptId, 
																			@Param("grId")Integer grId, 
																			@Param("userId")Integer userId, 
																			@Param("attStartDate")String attStartDate, 
																			@Param("attEndDate")String attEndDate, 
																			@Param("userIdList")List<Integer> userIdList,
																			@Param("attDateList")List<String> attDateList);
	
	/**
	 * 查询一个月的考勤统计列表查询不包含缺卡的统计列表
	 * 
	 * 只用于个人统计数据查询
	 * @author 陈文超
	 * @date 2017年12月8日 下午9:37:41
	 */
	List<ErpFunAttendanceStatistics> getAttendanceNotMissCardStatisticListOffOneMonth(@Param("shardCityId")Integer cityId, 
																						@Param("compId")Integer compId, 
																						@Param("areaId")Integer areaId,
																						@Param("regId")Integer regId, 
																						@Param("deptId")Integer deptId, 
																						@Param("grId")Integer grId, 
																						@Param("userId")Integer userId, 
																						@Param("attStartDate")String attStartDate, 
																						@Param("attEndDate")String attEndDate, 
																						@Param("userIdList")List<Integer> userIdList);
	
	/**
	 * 查询一个月的考勤统计列表
	 * @author 陈文超
	 * @date 2017年12月8日 下午9:37:41
	 */
	List<ErpFunAttendanceStatistics> getAttendanceStatisticsListMapByRange(@Param("shardCityId")Integer cityId,
																			@Param("compId") Integer compId,
																			@Param("userIdList")List<Integer> userIdList, 
																			@Param("attDate")String attDateStr);

	List<ErpFunAttendanceStatisticsDto> selectByDtoExample(ErpFunAttendanceStatisticsExample example);
	
	List<ErpFunAttendanceStatisticsDto> selectPageAttByUserByDtoExample(ErpFunAttendanceStatisticsExample example);
	
	List<ErpFunAttendanceStatisticsVO> selectVoByExample(ErpFunAttendanceStatisticsExample example);
	
	void updateAttendanceStatistics(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("attClassId")Integer attClassId,@Param("attDate")String attDate, @Param("userId")Integer userId, @Param("offWork")Byte offWork);

	Integer getMaxAttSumCountOfMonth(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("attDateStart")String attDateStart,@Param("attDateEnd")String attDateEnd);

    List<Map<String, Object>> getAttendanceStatisticlAnalysisReportOffMonthNeworg(@Param("shardCityId")Integer cityId,
																				  @Param("param")ErpAttendanceStatisticalAnalysisParam param ,
																				  @Param("currentDate") String currentDate,
																				  @Param("currentAttDate") String currentAttDate,
																				  @Param("lastMissCardDate") String lastMissCardDate);
}