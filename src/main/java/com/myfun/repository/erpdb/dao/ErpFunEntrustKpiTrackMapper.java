package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunEntrustKpiTrack;
import com.myfun.repository.erpdb.po.ErpFunEntrustKpiTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEntrustKpiTrackMapper extends BaseMapper<ErpFunEntrustKpiTrack, ErpFunEntrustKpiTrack> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunEntrustKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunEntrustKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunEntrustKpiTrack> selectByExample(ErpFunEntrustKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunEntrustKpiTrack record, @Param("example") ErpFunEntrustKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunEntrustKpiTrack record, @Param("example") ErpFunEntrustKpiTrackExample example);
}