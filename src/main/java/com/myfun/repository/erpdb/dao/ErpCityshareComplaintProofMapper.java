package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpCityshareComplaintProof;
import com.myfun.repository.erpdb.po.ErpCityshareComplaintProofExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpCityshareComplaintProofMapper extends BaseMapper<ErpCityshareComplaintProof, ErpCityshareComplaintProof> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpCityshareComplaintProofExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpCityshareComplaintProofExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpCityshareComplaintProof> selectByExample(ErpCityshareComplaintProofExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpCityshareComplaintProof record, @Param("example") ErpCityshareComplaintProofExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpCityshareComplaintProof record, @Param("example") ErpCityshareComplaintProofExample example);
}