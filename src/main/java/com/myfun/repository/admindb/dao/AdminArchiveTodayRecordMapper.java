package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminArchiveTodayRecord;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminArchiveTodayRecordMapper extends BaseMapper<AdminArchiveTodayRecord, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminArchiveTodayRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminArchiveTodayRecordExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminArchiveTodayRecord> selectByExample(AdminArchiveTodayRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminArchiveTodayRecord record, @Param("example") AdminArchiveTodayRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminArchiveTodayRecord record, @Param("example") AdminArchiveTodayRecordExample example);
}