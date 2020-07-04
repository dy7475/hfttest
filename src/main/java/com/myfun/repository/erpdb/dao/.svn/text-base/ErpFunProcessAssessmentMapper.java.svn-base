package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.erpdb.po.ErpFunProcessAssessment;
import com.myfun.repository.erpdb.po.ErpFunProcessAssessmentExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunProcessAssessmentMapper extends BaseMapper<ErpFunProcessAssessment, ErpFunProcessAssessment> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunProcessAssessmentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunProcessAssessmentExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunProcessAssessment> selectByExample(ErpFunProcessAssessmentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunProcessAssessment record, @Param("example") ErpFunProcessAssessmentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunProcessAssessment record, @Param("example") ErpFunProcessAssessmentExample example);

	void updateAmountById(@Param("shardCityId") Integer cityId, @Param("totalAmount")BigDecimal totalAmount, @Param("param")ErpProfitMessageFormParam param);
}