package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfDidiTrack;
import com.myfun.repository.agencydb.po.AgencyWfDidiTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyWfDidiTrackMapper extends BaseMapper<AgencyWfDidiTrack, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyWfDidiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyWfDidiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyWfDidiTrack> selectByExample(AgencyWfDidiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyWfDidiTrack record, @Param("example") AgencyWfDidiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyWfDidiTrack record, @Param("example") AgencyWfDidiTrackExample example);
}