package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpCityshareBorkerPurchase;
import com.myfun.repository.erpdb.po.ErpCityshareBorkerPurchaseExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpCityshareBorkerPurchaseMapper extends BaseMapper<ErpCityshareBorkerPurchase, ErpCityshareBorkerPurchase> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpCityshareBorkerPurchaseExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpCityshareBorkerPurchaseExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpCityshareBorkerPurchase> selectByExample(ErpCityshareBorkerPurchaseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpCityshareBorkerPurchase record, @Param("example") ErpCityshareBorkerPurchaseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpCityshareBorkerPurchase record, @Param("example") ErpCityshareBorkerPurchaseExample example);
}