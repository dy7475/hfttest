package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunVoicetransInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String connId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer voipId;

    /**
     *
     * @mbggenerated
     */
    private String callId;

    /**
     *
     * @mbggenerated
     */
    private Byte downStatus;

    /**
     *
     * @mbggenerated
     */
    private Date stopTime;

    /**
     *
     * @mbggenerated
     */
    private String voiceUrl;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getConnId() {
        return connId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setConnId(String connId) {
        this.connId = connId == null ? null : connId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getVoipId() {
        return voipId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVoipId(Integer voipId) {
        this.voipId = voipId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCallId() {
        return callId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCallId(String callId) {
        this.callId = callId == null ? null : callId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDownStatus() {
        return downStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDownStatus(Byte downStatus) {
        this.downStatus = downStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getStopTime() {
        return stopTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getVoiceUrl() {
        return voiceUrl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl == null ? null : voiceUrl.trim();
    }
}