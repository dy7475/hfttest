package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCompGiftCoinRecord;
import com.myfun.repository.admindb.po.AdminCompGiftCoinRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCompGiftCoinRecordMapper extends BaseMapper<AdminCompGiftCoinRecord, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCompGiftCoinRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCompGiftCoinRecordExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCompGiftCoinRecord> selectByExample(AdminCompGiftCoinRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCompGiftCoinRecord record, @Param("example") AdminCompGiftCoinRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCompGiftCoinRecord record, @Param("example") AdminCompGiftCoinRecordExample example);
}