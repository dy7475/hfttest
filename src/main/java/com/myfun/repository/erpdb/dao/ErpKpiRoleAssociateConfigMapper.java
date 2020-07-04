package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpKpiRoleAssociateConfig;
import com.myfun.repository.erpdb.po.ErpKpiRoleAssociateConfigExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpKpiRoleAssociateConfigMapper extends BaseMapper<ErpKpiRoleAssociateConfig, ErpKpiRoleAssociateConfig> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpKpiRoleAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpKpiRoleAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpKpiRoleAssociateConfig> selectByExample(ErpKpiRoleAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpKpiRoleAssociateConfig record, @Param("example") ErpKpiRoleAssociateConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpKpiRoleAssociateConfig record, @Param("example") ErpKpiRoleAssociateConfigExample example);
}