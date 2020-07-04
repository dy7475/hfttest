package com.myfun.erpWeb.managecenter.constract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * create by 程二狗 on 2018/11/2 0002
 */
@ApiModel
public class MgrDealNoteDataVo implements Serializable {
    @ApiModelProperty("")
    private String updateType;
    @ApiModelProperty("")
    private String newVal;
    @ApiModelProperty("")
    private String newFianacId;
    @ApiModelProperty("")
    private String newTaxesVal;
    @ApiModelProperty("")
    private String oldVal;
    @ApiModelProperty("")
    private String oldFianacId;
    @ApiModelProperty("")
    private String oldTaxesVal;

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }

    public String getNewFianacId() {
        return newFianacId;
    }

    public void setNewFianacId(String newFianacId) {
        this.newFianacId = newFianacId;
    }

    public String getNewTaxesVal() {
        return newTaxesVal;
    }

    public void setNewTaxesVal(String newTaxesVal) {
        this.newTaxesVal = newTaxesVal;
    }

    public String getOldVal() {
        return oldVal;
    }

    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    public String getOldFianacId() {
        return oldFianacId;
    }

    public void setOldFianacId(String oldFianacId) {
        this.oldFianacId = oldFianacId;
    }

    public String getOldTaxesVal() {
        return oldTaxesVal;
    }

    public void setOldTaxesVal(String oldTaxesVal) {
        this.oldTaxesVal = oldTaxesVal;
    }
}
