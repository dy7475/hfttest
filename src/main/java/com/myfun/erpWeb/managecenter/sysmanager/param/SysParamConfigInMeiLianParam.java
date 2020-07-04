package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/12/20
 */
public class SysParamConfigInMeiLianParam implements EncryParamIfc {

    @ApiModelProperty("系统参数-住宅 工商铺 后勤部门是否分开管控 0=关闭 1=开启")
    private Byte businessApart;

    public Byte getBusinessApart() {
        return businessApart;
    }

    public void setBusinessApart(Byte businessApart) {
        this.businessApart = businessApart;
    }
}