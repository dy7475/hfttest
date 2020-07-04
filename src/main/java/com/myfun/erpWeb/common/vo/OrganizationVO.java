package com.myfun.erpWeb.common.vo;

import com.myfun.repository.erpdb.po.ErpFunOrganization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("组织机构相关对象")
public class OrganizationVO extends ErpFunOrganization {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("组织机构定义层级 如果等于100或者等于null 代表未指定层级")
    private Integer definitionLevel;

    public Integer getDefinitionLevel() {
        return definitionLevel;
    }

    public void setDefinitionLevel(Integer definitionLevel) {
        this.definitionLevel = definitionLevel;
    }
}
