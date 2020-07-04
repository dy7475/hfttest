package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/3/20
 */
public class DealFianacByPerformanceParam implements EncryParamIfc {

    @ApiModelProperty(value = "合同ID")
    private Integer dealId;

    @ApiModelProperty(value = "业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 业绩类别")
    private Byte performanceType;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Byte getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(Byte performanceType) {
        this.performanceType = performanceType;
    }
}