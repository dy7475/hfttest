package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunFinancStatus;
import com.myfun.repository.erpdb.po.ErpFunFinancStatusExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunFinancStatusMapper extends BaseMapper<ErpFunFinancStatus, ErpFunFinancStatus> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunFinancStatusExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunFinancStatusExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunFinancStatus> selectByExample(ErpFunFinancStatusExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunFinancStatus record, @Param("example") ErpFunFinancStatusExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunFinancStatus record, @Param("example") ErpFunFinancStatusExample example);

	ErpFunFinancStatus getFunFinancStatus(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("type") String type);
}