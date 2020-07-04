package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.buildData.vo.*;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.po.ErpFunBuildTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBuildTrackMapper extends BaseMapper<ErpFunBuildTrack, ErpFunBuildTrack> {
	void deleteBuildTrackbyBuild(@Param("shardCityId") Integer shardCityId,@Param("param") Map<String, Object> param);
	
	/**
	 * 获取转租售统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getTrackAndTransSaleLeaseData(@Param("shardCityId") Integer cityId,@Param("auth")Byte auth,@Param("userId")Integer userId,
                                                            @Param("deptId")Integer deptId,@Param("param") Map<String, Object> map);
	
	/**
	 * 获取统计的跟进列表
	 * @author 张宏利
	 * @since 2017年12月18日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<HouseTrackListVo> getHouseTrackList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 获取楼盘资料ip拨号统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getIpCallBuildData(@Param("shardCityId") Integer cityId, @Param("auth")Byte auth,@Param("userId")Integer userId,
                                                 @Param("deptId")Integer deptId,@Param("param") Map<String, Object> param);

	/**
	 * 获取楼盘资料ip拨号语音列表
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<BuildDataIpCallVo> getBuildDataIpCallList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> param);

	List<ErpFunBuildTrackDto> getFloorTrackList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("haveAuth")Byte haveAuth,
												@Param("buildRuleId") Integer buildRuleId,@Param("userId")Integer userId);

	void deleteTrack(@Param("shardCityId")Integer cityId,@Param("entityIds") String[] entityIds);

	ErpFunBuildTrack getRcentCallPhoneLog(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("trackContent")String trackContent,
										  @Param("userId") Integer userId,@Param("buildRuleId")Integer buildRuleId,@Param("startTime")String startTime,@Param("endTime")String endTime);

	List<BuildDataTrackDataVo> getBuildDataTrackData(@Param("shardCityId") Integer cityId, @Param("auth") Byte auth, @Param("userId") Integer userId,
													 @Param("deptId") Integer deptId, @Param("param") Map<String, Object> map);

	List<BuildDataTrackDataVo> getBuildDataTrackDataCount(@Param("shardCityId") Integer cityId, @Param("buildRuleIds") List<Integer> buildRuleIds,
														  @Param("createUserId") Integer createUserId, @Param("startTime") String startTime,
														  @Param("endTime") String endTime);

	List<IpCallDataVo> getIpCallDataList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> param);

	List<IpCallDataVo> getIpCallDataCount(@Param("shardCityId") Integer cityId, @Param("buildRuleIds") List<Integer> buildRuleIds,
										  @Param("callUserId") Integer callUserId, @Param("startTime") String startTime,
										  @Param("endTime") String endTime);
}