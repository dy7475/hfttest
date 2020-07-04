package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunArchiveLevelMarkingDetail;
import com.myfun.repository.admindb.po.AdminFunArchiveLevelMarkingDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunArchiveLevelMarkingDetailMapper extends BaseMapper<AdminFunArchiveLevelMarkingDetail, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunArchiveLevelMarkingDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunArchiveLevelMarkingDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunArchiveLevelMarkingDetail> selectByExample(AdminFunArchiveLevelMarkingDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunArchiveLevelMarkingDetail record, @Param("example") AdminFunArchiveLevelMarkingDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunArchiveLevelMarkingDetail record, @Param("example") AdminFunArchiveLevelMarkingDetailExample example);
}