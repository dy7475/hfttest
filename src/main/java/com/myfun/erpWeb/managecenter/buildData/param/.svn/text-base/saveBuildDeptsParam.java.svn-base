package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.erpdb.po.ErpBuildAllot;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @create by 程二狗 on 2019/2/20 0020
 **/
@ApiModel
public class saveBuildDeptsParam implements EncryParamIfc{
    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("门店Ids多个,号隔开")
    private String deptIds;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }
}
