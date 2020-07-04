package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/12/27
 */
public class GetBusinessApartVO {

    @ApiModelProperty(value = "是否开启住宅 工商铺 后勤部门分开管控")
    private Byte businessApart;

    public Byte getBusinessApart() {
        return businessApart;
    }

    public void setBusinessApart(Byte businessApart) {
        this.businessApart = businessApart;
    }
}