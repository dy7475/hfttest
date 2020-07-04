package com.myfun.erpWeb.historyCustomer.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("历史成交客列表参数")
public class HistoryCustomerListParam  extends AbstractEncryParam {
    @ApiModelProperty("筛选类型1归属人2成交人")
    private Integer conditionType;
    @ApiModelProperty("范围（归属人范围或成交人范围）")
    private Integer orgId;
    @ApiModelProperty("归属员工(成交人)")
    private Integer userId;
    @ApiModelProperty("成交类型 1卖方2出租方3买方4承租方")
    private Integer dealType;
    @ApiModelProperty("楼盘")
    private Integer buildId;
    @ApiModelProperty("楼盘成交时间开始")
    private Date dealStartTime;
    @ApiModelProperty("楼盘成交时间结束")
    private Date dealEndTime;
    @ApiModelProperty("客户姓名，电话，编号检索")
    private  String keyWords;

    public Integer getConditionType() {
        return conditionType;
    }

    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }



    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Date getDealStartTime() {
        return dealStartTime;
    }

    public void setDealStartTime(Date dealStartTime) {
        this.dealStartTime = dealStartTime;
    }

    public Date getDealEndTime() {
        return dealEndTime;
    }

    public void setDealEndTime(Date dealEndTime) {
        this.dealEndTime = dealEndTime;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
