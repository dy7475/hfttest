package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunSaleToLease;
import com.myfun.repository.erpdb.po.ErpFunSaleToLeaseExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunSaleToLeaseMapper extends BaseMapper<ErpFunSaleToLease, ErpFunSaleToLease> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunSaleToLeaseExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunSaleToLeaseExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunSaleToLease> selectByExample(ErpFunSaleToLeaseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunSaleToLease record, @Param("example") ErpFunSaleToLeaseExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunSaleToLease record, @Param("example") ErpFunSaleToLeaseExample example);
	
    /**
     * 根据房源ID查询出售房源数据
     * @param 
     * @auther 胡坤
     * @since 2018/5/7
     * @return 
     * 
     */
	ErpFunSaleToLease getFunSaleToLeaseById(@Param("shardCityId") Integer cityId,@Param("caseId")  Integer caseId);
}