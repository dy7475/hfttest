package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunUserRankExamination;
import com.myfun.repository.erpdb.po.ErpFunUserRankExaminationExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunUserRankExaminationMapper extends BaseMapper<ErpFunUserRankExamination, ErpFunUserRankExamination> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunUserRankExaminationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunUserRankExaminationExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunUserRankExamination> selectByExample(ErpFunUserRankExaminationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunUserRankExamination record, @Param("example") ErpFunUserRankExaminationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunUserRankExamination record, @Param("example") ErpFunUserRankExaminationExample example);

    /**
     * 查询当前人员的业绩排名
     * @param cityId
     * @param compId
     * @param userId
     * @return
     */
    Integer selectUserRank(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId);
}