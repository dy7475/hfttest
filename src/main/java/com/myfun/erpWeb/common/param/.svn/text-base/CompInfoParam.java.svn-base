package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class CompInfoParam extends AbstractEncryParam {

    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市ID参数缺失")
    private Integer cityId;
    @ApiModelProperty("公司ID")
    @NotNull(message = "公司ID参数缺失")
    private Integer compId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

}
