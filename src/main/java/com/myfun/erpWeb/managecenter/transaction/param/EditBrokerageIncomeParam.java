package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class EditBrokerageIncomeParam implements EncryParamIfc {
    @ApiModelProperty(value = "分佣比列表")
    private String commionList;
    @ApiModelProperty(value = "分佣比展示规则")
    private String profitPercentRule;

    public String getCommionList() {
        return commionList;
    }

    public void setCommionList(String commionList) {
        this.commionList = commionList;
    }

    public String getProfitPercentRule() {
        return profitPercentRule;
    }

    public void setProfitPercentRule(String profitPercentRule) {
        this.profitPercentRule = profitPercentRule;
    }
}
