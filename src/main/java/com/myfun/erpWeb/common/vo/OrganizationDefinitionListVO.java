package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("组织机构相关返回值对象")
public class OrganizationDefinitionListVO {


    @ApiModelProperty("组织机构定义列表")
    private List<OrganizationDefinitionVO> organizationDefinitionList;

    public List<OrganizationDefinitionVO> getOrganizationDefinitionList() {
        return organizationDefinitionList;
    }

    public void setOrganizationDefinitionList(List<OrganizationDefinitionVO> organizationDefinitionList) {
        this.organizationDefinitionList = organizationDefinitionList;
    }
}
