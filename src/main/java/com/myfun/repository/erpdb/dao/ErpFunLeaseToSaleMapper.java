package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunLeaseToSale;
import com.myfun.repository.erpdb.po.ErpFunLeaseToSaleExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunLeaseToSaleMapper extends BaseMapper<ErpFunLeaseToSale, ErpFunLeaseToSale> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunLeaseToSaleExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunLeaseToSaleExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunLeaseToSale> selectByExample(ErpFunLeaseToSaleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunLeaseToSale record, @Param("example") ErpFunLeaseToSaleExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunLeaseToSale record, @Param("example") ErpFunLeaseToSaleExample example);
	
    /**
     * 更具ID获取出租房源数据
     * @param
     * @auther 胡坤
     * @since 2018/5/7
     * @return
     *
     */
	ErpFunLeaseToSale getFunLeaseToSaleById(@Param("shardCityId") Integer cityId,@Param("caseId") Integer caseId);
}