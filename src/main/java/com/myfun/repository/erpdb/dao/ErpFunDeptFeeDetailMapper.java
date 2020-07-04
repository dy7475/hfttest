package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDeptFeeDetail;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDeptFeeDetailMapper extends BaseMapper<ErpFunDeptFeeDetail, ErpFunDeptFeeDetail> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunDeptFeeDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunDeptFeeDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunDeptFeeDetail> selectByExample(ErpFunDeptFeeDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunDeptFeeDetail record, @Param("example") ErpFunDeptFeeDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunDeptFeeDetail record, @Param("example") ErpFunDeptFeeDetailExample example);

	List<ErpFunDeptFeeDetail> getFunDeptFeeDetailList(@Param("shardCityId")Integer cityId, @Param("feeId")Integer feeId, @Param("currentTime")Date currentTime);
}