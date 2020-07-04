package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DealRecordCountParam implements EncryParamIfc {

    @ApiModelProperty("时间起， 时间起止都不传默认查询今日")
    private String timeStart;
    @ApiModelProperty("时间止,时间起止都不传默认查询今日")
    private String timeEnd;

    @ApiModelProperty(value = "uaId", hidden = true)
    private Integer uaId;

    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
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
