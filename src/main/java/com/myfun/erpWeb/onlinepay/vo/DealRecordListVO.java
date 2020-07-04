package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApiModel
public class DealRecordListVO implements Serializable {
    @ApiModelProperty("列表数据")
    private List<OnlinePaymentOrderVO> tableList;
    @ApiModelProperty("图形列表")
    private List<Map<String, BigDecimal>> graphicslist;
    @ApiModelProperty("总金额")
    private BigDecimal totalIncomeAmount;

    public List<Map<String, BigDecimal>> getGraphicslist() {
        return graphicslist;
    }

    public void setGraphicslist(List<Map<String, BigDecimal>> graphicslist) {
        this.graphicslist = graphicslist;
    }

    public List<OnlinePaymentOrderVO> getTableList() {
        return tableList;
    }

    public void setTableList(List<OnlinePaymentOrderVO> tableList) {
        this.tableList = tableList;
    }

    public BigDecimal getTotalIncomeAmount() {
        return totalIncomeAmount;
    }

    public void setTotalIncomeAmount(BigDecimal totalIncomeAmount) {
        this.totalIncomeAmount = totalIncomeAmount;
    }
}
