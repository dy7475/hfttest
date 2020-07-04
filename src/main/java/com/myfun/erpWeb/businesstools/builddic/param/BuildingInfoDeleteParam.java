package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class BuildingInfoDeleteParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @NotNull
    @ApiModelProperty(value = "1：判断能否删除，2：删除楼盘信息")
    private Byte requestFor;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }


    public Byte getRequestFor() {
        return requestFor;
    }

    public void setRequestFor(Byte requestFor) {
        this.requestFor = requestFor;
    }
}
