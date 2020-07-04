package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author czq
 * @since 2018/12/14
 */
@ApiModel
public class ErpBuildingSetSettingParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘id")
    private Integer buildId;

    @ApiModelProperty(value = "楼盘是否锁定(1锁定)")
    private Integer lockFlag;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(Integer lockFlag) {
        this.lockFlag = lockFlag;
    }

}