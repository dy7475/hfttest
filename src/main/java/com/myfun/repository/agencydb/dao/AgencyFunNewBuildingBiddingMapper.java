package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyFunNewBuildingBidding;
import com.myfun.repository.agencydb.po.AgencyFunNewBuildingBiddingExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyFunNewBuildingBiddingMapper extends BaseMapper<AgencyFunNewBuildingBidding, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyFunNewBuildingBiddingExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyFunNewBuildingBiddingExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyFunNewBuildingBidding> selectByExample(AgencyFunNewBuildingBiddingExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyFunNewBuildingBidding record, @Param("example") AgencyFunNewBuildingBiddingExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyFunNewBuildingBidding record, @Param("example") AgencyFunNewBuildingBiddingExample example);
    
    void updateEndTimeToLastTime(@Param("archiveIds")List<Integer> archiveIds, @Param("endTime")String endTime, @Param("nowDate")String nowDate);
}