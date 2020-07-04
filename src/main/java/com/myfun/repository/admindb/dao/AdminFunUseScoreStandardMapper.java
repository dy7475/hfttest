package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunScoreStandardMonth;
import com.myfun.repository.admindb.po.AdminFunUseScoreStandard;
import com.myfun.repository.admindb.po.AdminFunUseScoreStandardExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminFunUseScoreStandardMapper extends BaseMapper<AdminFunUseScoreStandard, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunUseScoreStandardExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunUseScoreStandardExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunUseScoreStandard> selectByExample(AdminFunUseScoreStandardExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunUseScoreStandard record, @Param("example") AdminFunUseScoreStandardExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunUseScoreStandard record, @Param("example") AdminFunUseScoreStandardExample example);

    AdminFunUseScoreStandard selectCondition(@Param("pMap") Map<String, Object> pMap);
}