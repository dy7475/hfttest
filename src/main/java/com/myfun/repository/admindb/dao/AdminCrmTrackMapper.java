package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCrmTrack;
import com.myfun.repository.admindb.po.AdminCrmTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCrmTrackMapper extends BaseMapper<AdminCrmTrack, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCrmTrack> selectByExampleWithBLOBs(AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCrmTrack> selectByExample(AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCrmTrack record, @Param("example") AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AdminCrmTrack record, @Param("example") AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCrmTrack record, @Param("example") AdminCrmTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminCrmTrack record);
}