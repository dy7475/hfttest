package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class RemoveListingMessage extends MqMessage {
    private Integer cityId;
    private Integer archiveId;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}
