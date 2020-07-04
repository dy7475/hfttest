package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunBuildingBidding;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunBuildingBiddingExample;

public interface AdminFunBuildingBiddingMapper extends BaseMapper<AdminFunBuildingBidding, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunBuildingBiddingExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunBuildingBiddingExample example);

	/**
	 * @mbggenerated
	 */List<AdminFunBuildingBidding> selectByExample(AdminFunBuildingBiddingExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminFunBuildingBidding record,@Param("example") AdminFunBuildingBiddingExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminFunBuildingBidding record,@Param("example") AdminFunBuildingBiddingExample example);

	/**
	 * 查询某个小区的小区转件
	 * @author 陈文超
	 * @date 2016年6月2日 下午3:33:02
	 */
	List<AdminFunBuildingBidding> getFunBuildBiddingSuccInfo(AdminFunBuildingBidding adminFunBuildingBidding) throws Exception;

    Integer getBuildBiddingCount(@Param("archiveId") Integer archiveId);
    
    void updateBiddingEndTimeToLastTime(@Param("archiveIds")List<Integer> archiveIds, @Param("endTime") String endTime, @Param("nowDate")String nowDate);
    
    /**
     * 获取所有楼盘的当前竞价人
     * @param cityId
     * @param buildIds
     * @return
     */
    List<AdminFunBuildingBidding> getNowBuildingUserInfo(@Param("cityId")Integer cityId, @Param("buildIds")Set<Integer> buildIds);
    
    /**
     * 获取用户参与了下一期竞价的数据
     * @param cityId
     * @param buildIds
     * @return
     */
    List<AdminFunBuildingBidding> getFutureBuildBiddList(@Param("cityId")Integer cityId, @Param("selfArchiveId")Integer selfArchiveId, @Param("buildIds")Set<Integer> buildIds);

    /**
     * 通过条件查询一个对象
     * @author ZangTie
     * @since 2018年7月20日 上午9:55:21
     * @param adminFunBuildingBiddingExample
     * @return
     * Modified XXX ZangTie 2018年7月20日
     */
	AdminFunBuildingBidding selectOneByExample(AdminFunBuildingBiddingExample adminFunBuildingBiddingExample);

	List<AdminFunBuildingBidding> getSelfBiddList(@Param("cityId")Integer cityId, @Param("srcArchiveId")Integer srcArchiveId, @Param("nowTime")String nowTime);

	List<AdminFunBuildingBidding> getBiddSuccList(@Param("cityId")Integer cityId,@Param("buildIds") String buildIds,@Param("srcArchiveId") Integer srcArchiveId,@Param("nowTime") String nowTime);
}