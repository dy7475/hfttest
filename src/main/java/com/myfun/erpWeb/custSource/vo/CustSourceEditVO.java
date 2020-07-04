package com.myfun.erpWeb.custSource.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("编辑保存返回客源信息")
public class CustSourceEditVO {
    @ApiModelProperty(value="来源ID")
    private Integer custSourceId;
    @ApiModelProperty(value="序号")
    private String serialNumber;
    @ApiModelProperty(value="是否禁用0否1是")
    private Byte forbidStatus;
    @ApiModelProperty(value="来源名称")
    private String sourceName;
    @ApiModelProperty(value="编码")
    private String code;
    @ApiModelProperty(value="描述")
    private String description;

    public Integer getCustSourceId() {
        return custSourceId;
    }

    public void setCustSourceId(Integer custSourceId) {
        this.custSourceId = custSourceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Byte getForbidStatus() {
        return forbidStatus;
    }

    public void setForbidStatus(Byte forbidStatus) {
        this.forbidStatus = forbidStatus;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
