package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2019/11/27 0027 下午 8:32
 **/
@ApiModel
public class GetEntrustFileConfigVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "是否开启电子委托，1=是，0=否 默认 0")
    private Byte openElectronicEntrust = 0;
    @ApiModelProperty(value = "租售资料共用，1=是，0=否  默认 0")
    private Byte dataSharing = 0;

    public Byte getOpenElectronicEntrust() {
        return openElectronicEntrust == null ? 0 : openElectronicEntrust;
    }

    public void setOpenElectronicEntrust(Byte openElectronicEntrust) {
        this.openElectronicEntrust = openElectronicEntrust;
    }

    public Byte getDataSharing() {
        return dataSharing == null ? 0 : dataSharing;
    }

    public void setDataSharing(Byte dataSharing) {
        this.dataSharing = dataSharing;
    }
}
