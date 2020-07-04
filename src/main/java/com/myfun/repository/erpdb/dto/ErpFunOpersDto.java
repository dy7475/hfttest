package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunOpers;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunOpersDto extends ErpFunOpers implements Cloneable {
    @ApiModelProperty("是否高级权限，1=是0=否")
    private Byte isAdvance;

    @ApiModelProperty("组织机构定义ID")
    private Integer organizationDefinitionId;

    @ApiModelProperty("组织机构定义层级")
    private Integer definitionLevel;

    @ApiModelProperty("组织机构定义名")
    private String definitionName;

    public Integer getOrganizationDefinitionId() {
        return organizationDefinitionId;
    }

    public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
        this.organizationDefinitionId = organizationDefinitionId;
    }

    public Integer getDefinitionLevel() {
        return definitionLevel;
    }

    public void setDefinitionLevel(Integer definitionLevel) {
        this.definitionLevel = definitionLevel;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName;
    }

    @Override
    public ErpFunOpersDto clone() {
        try {
            return (ErpFunOpersDto) super.clone();
        } catch (Exception e) {
            return null;
        }
    }

    public Byte getIsAdvance() {
        return isAdvance;
    }

    public void setIsAdvance(Byte isAdvance) {
        this.isAdvance = isAdvance;
    }
}
