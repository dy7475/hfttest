package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class UpdateCompCustomerPropertuParam extends AbstractEncryParam {

    @ApiModelProperty(value = "list 对象", example = "1111")
    private String customerPropertyList;

    public String getCustomerPropertyList() {
        return customerPropertyList;
    }

    public void setCustomerPropertyList(String customerPropertyList) {
        this.customerPropertyList = customerPropertyList;
    }
}
