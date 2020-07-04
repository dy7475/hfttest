package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class DeleteCompParam extends AbstractEncryParam {

    @ApiModelProperty(value = "城市")
    @NotNull
    private Integer cityId;

    @ApiModelProperty("公司编号")
    @NotNull
    private String compNo;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }
}
