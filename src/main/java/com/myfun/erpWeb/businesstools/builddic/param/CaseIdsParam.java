package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/4/11
 */
public class CaseIdsParam extends AbstractEncryParam implements EncryParamIfc {

    @ApiModelProperty(value = "1=出售 2=出租 3=求购 4=求租", required = true)
    private Integer caseType;

    @ApiModelProperty(value = "房源ID(用,分隔开)", required = true)
    private String caseIds;

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getCaseIds() {
        return caseIds;
    }

    public void setCaseIds(String caseIds) {
        this.caseIds = caseIds;
    }
}