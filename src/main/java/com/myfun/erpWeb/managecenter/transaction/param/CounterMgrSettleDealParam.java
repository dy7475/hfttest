package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class CounterMgrSettleDealParam implements EncryParamIfc {
    @ApiModelProperty("合同ID")
    private Integer dealId;
    @ApiModelProperty("合同结算时间")
    private String dealVerifyTime;
    @ApiModelProperty("合同反结算原因")
    private String dealVerifyCon;

    @ApiModelProperty("如果有共享中心审核配置, 选择的具体共享中心审核流程的ID")
    private Integer classId;

    public String getDealVerifyTime() {
        return dealVerifyTime;
    }

    public void setDealVerifyTime(String dealVerifyTime) {
        this.dealVerifyTime = dealVerifyTime;
    }

    public String getDealVerifyCon() {
        return dealVerifyCon;
    }

    public void setDealVerifyCon(String dealVerifyCon) {
        this.dealVerifyCon = dealVerifyCon;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
