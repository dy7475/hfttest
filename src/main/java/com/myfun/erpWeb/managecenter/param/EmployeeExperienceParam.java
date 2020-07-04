package com.myfun.erpWeb.managecenter.param;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EmployeeExperienceParam implements EncryParamIfc {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "员工userId")
    private Integer userId;

    @ApiModelProperty(value = "发生时间")
    private String occurrenceTime;

    @ApiModelProperty(value = "事件说明")
    private String eventExplain;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(String occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getEventExplain() {
        return eventExplain;
    }

    public void setEventExplain(String eventExplain) {
        this.eventExplain = eventExplain;
    }
}
