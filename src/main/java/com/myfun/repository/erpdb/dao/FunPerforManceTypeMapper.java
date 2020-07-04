package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.FunPerforManceType;
import com.myfun.repository.erpdb.po.FunPerforManceTypeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunPerforManceTypeMapper extends BaseMapper<FunPerforManceType, FunPerforManceType> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(FunPerforManceTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(FunPerforManceTypeExample example);

    /**
     *
     * @mbggenerated
     */
    List<FunPerforManceType> selectByExample(FunPerforManceTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FunPerforManceType record, @Param("example") FunPerforManceTypeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FunPerforManceType record, @Param("example") FunPerforManceTypeExample example);
}