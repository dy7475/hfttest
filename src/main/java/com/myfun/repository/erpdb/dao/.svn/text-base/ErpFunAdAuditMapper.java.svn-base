package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAdAudit;
import com.myfun.repository.erpdb.po.ErpFunAdAuditExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAdAuditMapper extends BaseMapper<ErpFunAdAudit, ErpFunAdAudit> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunAdAuditExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunAdAuditExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunAdAudit> selectByExample(ErpFunAdAuditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunAdAudit record, @Param("example") ErpFunAdAuditExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunAdAudit record, @Param("example") ErpFunAdAuditExample example);

	void deleteByCaseId(@Param("shardCityId")Integer cityId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType);
	public void deleteAdByWriteoffOrDown(@Param("shardCityId")Integer cityId,@Param("caseType")Integer caseType,@Param("caseId")Integer caseId);
}