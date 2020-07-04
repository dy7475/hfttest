package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealTaxesRecord;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealTaxesRecordMapper extends BaseMapper<ErpFunDealTaxesRecord, ErpFunDealTaxesRecord> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunDealTaxesRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunDealTaxesRecordExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunDealTaxesRecord> selectByExample(ErpFunDealTaxesRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunDealTaxesRecord record, @Param("example") ErpFunDealTaxesRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunDealTaxesRecord record, @Param("example") ErpFunDealTaxesRecordExample example);

    ErpFunDealTaxesRecord getDealTaxesRecord(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId,
                                             @Param("compId") Integer compId,@Param("feeType") Byte payType);

    void updateByDealId(@Param("shardCityId")Integer cityId,@Param("auditUserName") String auditUserName,@Param("dealId") Integer dealId);

	List<ErpFunDealTaxesRecord> getModelDataList(@Param("shardCityId")Integer shardCityId,@Param("dealId") Integer dealId,@Param("payType")  String payType);
}