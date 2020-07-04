package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class TrackScoreMessage extends MqMessage {

    /** 城市Id **/
    private Integer cityId;
    /** 审核记录Id **/
    private Integer trackId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }
}
