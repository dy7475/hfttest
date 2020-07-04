package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportZfbTransDetail;
import com.myfun.repository.reportdb.po.ReportZfbTransDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportZfbTransDetailMapper extends BaseMapper<ReportZfbTransDetail, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ReportZfbTransDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ReportZfbTransDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<ReportZfbTransDetail> selectByExample(ReportZfbTransDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ReportZfbTransDetail record, @Param("example") ReportZfbTransDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ReportZfbTransDetail record, @Param("example") ReportZfbTransDetailExample example);
}