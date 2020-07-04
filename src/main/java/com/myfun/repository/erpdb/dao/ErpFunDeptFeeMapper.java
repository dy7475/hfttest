package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDeptFee;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDeptFeeMapper extends BaseMapper<ErpFunDeptFee, ErpFunDeptFee> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunDeptFeeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunDeptFeeExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunDeptFee> selectByExample(ErpFunDeptFeeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunDeptFee record, @Param("example") ErpFunDeptFeeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunDeptFee record, @Param("example") ErpFunDeptFeeExample example);

	ErpFunDeptFee getDeptFeeByName(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("feeName") String feeName);

	void updateFunDeptFee(@Param("shardCityId")Integer cityId, @Param("currentTime") Date currentTime, @Param("feeId") Integer feeId);
}