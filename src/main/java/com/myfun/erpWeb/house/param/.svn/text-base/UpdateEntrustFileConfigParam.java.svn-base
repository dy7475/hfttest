package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author 蔡春林
 * @Date 2019/11/27 0027 下午 8:39
 **/
@ApiModel
public class UpdateEntrustFileConfigParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "是否开启电子委托，1=是，0=否")
    private Byte openElectronicEntrust;
    @ApiModelProperty(value = "租售资料共用，1=是，0=否")
    private Byte dataSharing;

    public Byte getOpenElectronicEntrust() {
        return openElectronicEntrust;
    }

    public void setOpenElectronicEntrust(Byte openElectronicEntrust) {
        this.openElectronicEntrust = openElectronicEntrust;
    }

    public Byte getDataSharing() {
        return dataSharing;
    }

    public void setDataSharing(Byte dataSharing) {
        this.dataSharing = dataSharing;
    }
}
