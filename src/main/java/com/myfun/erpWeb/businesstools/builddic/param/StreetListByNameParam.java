package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/14
 */
public class StreetListByNameParam extends AbstractEncryParam {

    @ApiModelProperty(value = "街道模糊名称")
    private String streetName;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}