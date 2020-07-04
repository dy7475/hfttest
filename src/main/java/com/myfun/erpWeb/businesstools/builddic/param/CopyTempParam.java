package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/20
 */
public class CopyTempParam implements EncryParamIfc {

    @ApiModelProperty(value = "当前需要拷贝的楼盘ID")
    private Integer buildId;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

}