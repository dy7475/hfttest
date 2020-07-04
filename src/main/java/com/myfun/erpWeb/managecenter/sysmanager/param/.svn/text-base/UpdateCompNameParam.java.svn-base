package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Auther: zhaoyang
 * @Date: 2018/12/22 11:50
 * @Description:更新公司部門名字的參數接受類
 */
public class UpdateCompNameParam implements EncryParamIfc , Serializable {

    @ApiModelProperty(value = "公司部門名称")
    private String headName;

    @ApiModelProperty(value = "公司BUSINESS名字")
    private String businessName;

    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
