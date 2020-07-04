package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunEntrustRecordKpiTrack;
import com.myfun.repository.erpdb.po.ErpFunEntrustRecordKpiTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEntrustRecordKpiTrackMapper extends BaseMapper<ErpFunEntrustRecordKpiTrack, ErpFunEntrustRecordKpiTrack> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunEntrustRecordKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunEntrustRecordKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunEntrustRecordKpiTrack> selectByExample(ErpFunEntrustRecordKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunEntrustRecordKpiTrack record, @Param("example") ErpFunEntrustRecordKpiTrackExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunEntrustRecordKpiTrack record, @Param("example") ErpFunEntrustRecordKpiTrackExample example);
}