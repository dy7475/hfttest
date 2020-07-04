package com.myfun.erpWeb.historyCustomer.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("移交记录列表")
public class TransferRecordListParam implements EncryParamIfc {
    @ApiModelProperty("历史成交客id")
    private Integer funHistoryDealCustId;

    public Integer getFunHistoryDealCustId() {
        return funHistoryDealCustId;
    }

    public void setFunHistoryDealCustId(Integer funHistoryDealCustId) {
        this.funHistoryDealCustId = funHistoryDealCustId;
    }
}
