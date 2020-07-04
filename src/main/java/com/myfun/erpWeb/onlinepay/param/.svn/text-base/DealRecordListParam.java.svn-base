package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DealRecordListParam implements EncryParamIfc {

    @ApiModelProperty("时间起， 时间起止都不传默认查询今日, 时间格式 yyyy-MM-dd")
    private String timeStart;
    @ApiModelProperty("时间止,时间起止都不传默认查询今日, 时间格式 yyyy-MM-dd")
    private String timeEnd;
    @ApiModelProperty("时间类型 0=日 1=周 2=月")
    private Integer timeType = 0;
    @ApiModelProperty("账户ID")
    private Integer accountId;
    @ApiModelProperty(value = "城市ID", hidden = true)
    private Integer cityId;
    @ApiModelProperty(value = "公司Id", hidden = true)
    private Integer compId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
