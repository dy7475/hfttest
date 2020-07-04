package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunStreetInReg;
import com.myfun.repository.erpdb.po.ErpFunStreetInRegExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetInRegMapper extends BaseMapper<ErpFunStreetInReg, ErpFunStreetInReg> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunStreetInRegExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunStreetInRegExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunStreetInReg> selectByExample(ErpFunStreetInRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunStreetInReg record, @Param("example") ErpFunStreetInRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunStreetInReg record, @Param("example") ErpFunStreetInRegExample example);

	void batchAddStreetInReg(@Param("shardCityId")Integer cityId, @Param("inRegs")List<ErpFunStreetInReg> inRegs);
}