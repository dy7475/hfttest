package com.myfun.erpWeb.businesstools.builddic.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


public class MLErpRegisterBuildingSetFloorAndRoomparam extends ErpRegisterBuildingSetFloorAndRoomparam {
    @ApiModelProperty("登记的房源类型，1：出售，2：出租")
    @NotNull
    private Byte caseType;

    @ApiModelProperty("出租方 1：业主，2：包租方，3：转租方")
    private Byte lessor;

    @ApiModelProperty("当前房源ID")
    private Integer caseId;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }


    public Byte getLessor() {
        return lessor;
    }

    public void setLessor(Byte lessor) {
        this.lessor = lessor;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }
}
