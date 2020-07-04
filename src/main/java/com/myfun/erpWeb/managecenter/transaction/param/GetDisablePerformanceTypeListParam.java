package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetDisablePerformanceTypeListParam implements EncryParamIfc {
    @ApiModelProperty(value="业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 ")
    private Byte collectionType;
    @ApiModelProperty(value="分成项 1房源 2客源 3交易服务4金融服务")
    private Byte commissionType;

    public Byte getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Byte collectionType) {
        this.collectionType = collectionType;
    }

    public Byte getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Byte commissionType) {
        this.commissionType = commissionType;
    }
}
