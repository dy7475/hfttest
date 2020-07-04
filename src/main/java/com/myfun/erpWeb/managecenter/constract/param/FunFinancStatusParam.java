package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class FunFinancStatusParam implements EncryParamIfc {
    @ApiModelProperty("财务状态ID")
    private Integer financStatusId;

    public Integer getFinancStatusId() {
        return financStatusId;
    }

    public void setFinancStatusId(Integer financStatusId) {
        this.financStatusId = financStatusId;
    }
}
