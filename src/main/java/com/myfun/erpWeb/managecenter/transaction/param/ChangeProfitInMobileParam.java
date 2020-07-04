package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/3/21
 */
public class ChangeProfitInMobileParam implements EncryParamIfc {

    @ApiModelProperty(value = "合同ID")
    private Integer dealId;

    @ApiModelProperty(value = "业绩JSON")
    private List<ErpFunProfit> profitJson;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public List<ErpFunProfit> getProfitJson() {
        return profitJson;
    }

    public void setProfitJson(List<ErpFunProfit> profitJson) {
        this.profitJson = profitJson;
    }
}