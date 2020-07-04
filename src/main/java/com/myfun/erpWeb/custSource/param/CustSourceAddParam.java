package com.myfun.erpWeb.custSource.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("客源来源新增")
public class CustSourceAddParam  implements EncryParamIfc {
    @ApiModelProperty(value="来源名称")
    private String sourceName;
    @ApiModelProperty(value="编码")
    private String code;
    @ApiModelProperty(value="是否禁用0否1是")
    private Byte forbidStatus;
    @ApiModelProperty(value="序号")
    private Integer serialNumber;
    @ApiModelProperty(value="描述")
    private String description;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getForbidStatus() {
        return forbidStatus;
    }

    public void setForbidStatus(Byte forbidStatus) {
        this.forbidStatus = forbidStatus;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
