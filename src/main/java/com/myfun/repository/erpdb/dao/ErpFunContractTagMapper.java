package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunContractTagDto;
import com.myfun.repository.erpdb.po.ErpFunContractTag;
import com.myfun.repository.erpdb.po.ErpFunContractTagExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunContractTagMapper extends BaseMapper<ErpFunContractTag, ErpFunContractTag> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunContractTag> selectByExampleWithBLOBs(ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunContractTag> selectByExample(ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunContractTag record, @Param("example") ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ErpFunContractTag record, @Param("example") ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunContractTag record, @Param("example") ErpFunContractTagExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ErpFunContractTag record);

    List<ErpFunContractTagDto> selectListDto(@Param("shardCityId") Integer cityId, @Param("contractId") Integer contractId, @Param("compId") Integer compId, @Param("deptId")Integer deptId);
}