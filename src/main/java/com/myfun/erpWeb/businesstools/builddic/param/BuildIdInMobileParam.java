package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildIdInMobileParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "是否是模板 0=不是模板 1=模板")
    private Integer buildTemplate;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildTemplate() {
        return buildTemplate;
    }

    public void setBuildTemplate(Integer buildTemplate) {
        this.buildTemplate = buildTemplate;
    }
}