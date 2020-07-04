package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import io.swagger.annotations.ApiModelProperty;

public class ProfiTargetNewOrgVO {

    @ApiModelProperty(value = "组织架构拓展字段名")
    private String mappingDbField;
    @ApiModelProperty(value = "组织架构组织ID")
    private Integer orgId;

    public String getMappingDbField() {
        return mappingDbField;
    }

    public void setMappingDbField(String mappingDbField) {
        this.mappingDbField = mappingDbField;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
