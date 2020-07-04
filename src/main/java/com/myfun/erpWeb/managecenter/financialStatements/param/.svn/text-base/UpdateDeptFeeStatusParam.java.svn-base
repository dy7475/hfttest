package com.myfun.erpWeb.managecenter.financialStatements.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

@ApiModel
public class UpdateDeptFeeStatusParam implements EncryParamIfc {
    @ApiModelProperty("费用id  逗号隔开")
    private String deptFeeListIds;
    @ApiModelProperty(hidden = true)
    private Set<Integer> deptFeeListIdSet;
    @ApiModelProperty("0:默认 1:删除")
    private Byte status;

    public String getDeptFeeListIds() {
        return deptFeeListIds;
    }

    public void setDeptFeeListIds(String deptFeeListIds) {
        this.deptFeeListIds = deptFeeListIds;
    }

    public Set<Integer> getDeptFeeListIdSet() {
        return deptFeeListIdSet;
    }

    public void setDeptFeeListIdSet(Set<Integer> deptFeeListIdSet) {
        this.deptFeeListIdSet = deptFeeListIdSet;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
