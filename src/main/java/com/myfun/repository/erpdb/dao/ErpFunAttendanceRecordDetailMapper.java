package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceRecordDetailExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceRecordDetailMapper extends BaseMapper<ErpFunAttendanceRecordDetail, ErpFunAttendanceRecordDetail> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceRecordDetailExample example);





	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceRecordDetailExample example);





	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceRecordDetail> selectByExample(ErpFunAttendanceRecordDetailExample example);





	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceRecordDetail record,
			@Param("example") ErpFunAttendanceRecordDetailExample example);





	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceRecordDetail record,
			@Param("example") ErpFunAttendanceRecordDetailExample example);





	/**
     * 查询打卡详情记录，用于更新打卡状态
     *
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunAttendanceRecordDetail> getRecordByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,@Param("attDate")String attDate);
    
    
    
    
    
    /**
     * 查询打卡详情记录记录
     *
     * @param cityId       城市id
     * @param userId       用户id
     * @param attDate 考勤日期
     * @param attNum 考勤第几轮打卡
     * @param attAttribute 上班或者下班
     * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceRecordDetail> getAttendanceRecordDetailList( @Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId,
			@Param("attDate") String attDate,@Param("attNum") Integer attNum, @Param("attAttribute") Integer attAttribute);
    
    /**
     * 查询打卡详情记录记录
     *
     * @param userId       用户id
     * @param cityId       城市id
     * @param attDate 考勤日期
     * @param attNum 考勤第几轮打卡
     * @param attAttribute 上班或者下班
     * @param isOutAtt
	 * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<Map<String,Object>> getAttendanceRecordDetailListMap(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("archiveId") Integer archiveId,
															  @Param("attDate") String attDate, @Param("attNum") Integer attNum, @Param("attAttribute") Integer attAttribute,
															  @Param("attResult") String attResult, @Param("startTime") String startTime, @Param("endTime") String endTime,
															  @Param("isOutAtt") Integer isOutAtt);
    
    /**
	 * 查询本人某月的所有打卡详情
	 * @author liucheng
	 * @date 2017年12月6日 上午9:50:53
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAttendanceRecordDetail> getAttendanceALLRecordByMonth(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,@Param("startDate") String startDate, @Param("endDate") String endDate);


    /**
     * 根据userId和attDate查询打卡的详情
     * @author liucheng
     * @date 2017年12月7日 上午10:20:08
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunAttendanceRecordDetail>  getAttendanceRecordByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,@Param("attDate") String attDate);




    /**
     * 根据组织机构id和attDate考勤日期查询统计结果
     * @author liucheng
     * @date 2017年12月7日 上午10:20:08
     */
	List<Map<String, Integer>> getAttendanceRecordStatisticalAnalysisDetailOffOneDay(@Param("shardCityId") Integer cityId, 
																					@Param("compId") Integer compId,
																					@Param("areaId")Integer areaId, 
																					@Param("regId") Integer regId, 
																					@Param("deptId") Integer deptId, 
																					@Param("grId")Integer grId, 
																					@Param("userId") Integer userId, 
																					@Param("attWeightTypes") List<Integer> attWeightType, 
																					@Param("attDate") String attDateStr);
	/**
	 * 根据组织机构id和attDate考勤日期查询统计结果
	 * @author liucheng
	 * @date 2017年12月7日 上午10:20:08
	 */
	List<Map<String, Integer>> getAttendanceRecordStatisticalAnalysisDetailListOffOneDay(@Param("shardCityId") Integer cityId, 
			@Param("compId") Integer compId,
			@Param("areaId")Integer areaId, 
			@Param("regId") Integer regId, 
			@Param("deptId") Integer deptId, 
			@Param("grId")Integer grId, 
			@Param("userId") Integer userId, 
			@Param("attWeightTypes") List<Integer> attWeightType, 
			@Param("attDate") String attDateStr);
	
	/**
	 * 查询某个月的个人考勤统计
	 * @author 陈文超
	 * @date 2017年12月8日 下午9:15:30
	 */
	List<Map<String, Object>> getAttendanceRecordStatisticalAnalysisDetailOffOneMonth(@Param("shardCityId")Integer cityId,
																						@Param("compId")Integer compId, 
																						@Param("userId")Integer userId, 
																						@Param("startDate")String startDate, 
																						@Param("endDate")String endDate);
	
	/**
     * 查询打卡详情记录记录
     * @author liucheng
     * @date 2017年12月7日 上午10:20:08
     * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<Map<String,Object>> getAttendanceRecordDetailListMapByRange(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userIds") List<Integer> userIds, @Param("attDate") String attDate);




    /**
     * 查询打卡详情记录记录
     * @author liucheng
     * @date 2017年12月7日 上午10:20:08
     * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<Map<Integer, Integer>> getAttendanceRecordStatisticalCountGroupByWeight(@Param("shardCityId")Integer cityId, 
																					@Param("compId")Integer compId, 
																					@Param("userId")Integer userId, 
																					@Param("startDate")String startDate, 
																					@Param("endDate")String endDate);
    
}
