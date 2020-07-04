package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.sysmanager.param.QueryPartnerOrgParam;
import com.myfun.repository.erpdb.dto.PartnerOrgDto;
import com.myfun.repository.erpdb.po.ErpFunPartnerDept;
import com.myfun.repository.erpdb.po.ErpFunPartnerOrg;
import com.myfun.repository.erpdb.po.ErpFunPartnerOrgExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPartnerOrgMapper extends BaseMapper<ErpFunPartnerOrg, ErpFunPartnerOrg> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunPartnerOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunPartnerOrgExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunPartnerOrg> selectByExample(ErpFunPartnerOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunPartnerOrg record, @Param("example") ErpFunPartnerOrgExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunPartnerOrg record, @Param("example") ErpFunPartnerOrgExample example);


    int countByPartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("partnerId")Integer partnerId);

    List<PartnerOrgDto> selectPartnerOrgList(@Param("shardCityId")Integer cityId, @Param("param") QueryPartnerOrgParam param);

    ErpFunPartnerOrg selectByOrgId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("organizationId")Integer organizationId);

    void updatePartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("orgPath")String orgPath, @Param("partnerId")Integer newPartnerId);
}