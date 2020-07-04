package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.PageParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class SignStatisticsListParam  extends PageParam implements EncryParamIfc {
    @ApiModelProperty("统计类型  1：按门店统计  2：按分组统计")
    private Integer statisticsType;
    @ApiModelProperty(value = "开始时间")
    private String startTime;// 开始时间
    @ApiModelProperty(value = "结束时间")
    private String endTime;// 结束时间

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

}
