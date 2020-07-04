package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetManageInfoParam implements EncryParamIfc {

    @ApiModelProperty("楼盘ID")
    private Integer buildId;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }
}
