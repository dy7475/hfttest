package com.myfun.repository.erpdb.dto;

import java.io.Serializable;


public class AttendanceResultDto implements Serializable {

    /**
     * 开始激励语
     */
    private String startGreeting;
    /**
     * 结束激励语
     */
    private String endGreeting;
    /**
     * 开始打卡弹框背景图
     */
    private String startPhotoUrl;
    /**
     * 结束打卡背景图
     */
    private String endPhotoUrl;
    /**
     * "2 外勤 、1正常"
     */
    private String locationAttStatus;
    /**
     * 判断打卡状态 迟到、正常、早退 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工
     */
    private String timeAttResult;
    /**
     * 打卡时间
     */
    private String serverAttTime;

    public String getStartGreeting() {
        return startGreeting;
    }

    public void setStartGreeting(String startGreeting) {
        this.startGreeting = startGreeting;
    }

    public String getEndGreeting() {
        return endGreeting;
    }

    public void setEndGreeting(String endGreeting) {
        this.endGreeting = endGreeting;
    }

    public String getStartPhotoUrl() {
        return startPhotoUrl;
    }

    public void setStartPhotoUrl(String startPhotoUrl) {
        this.startPhotoUrl = startPhotoUrl;
    }

    public String getEndPhotoUrl() {
        return endPhotoUrl;
    }

    public void setEndPhotoUrl(String endPhotoUrl) {
        this.endPhotoUrl = endPhotoUrl;
    }

    public void setLocationAttStatus(String locationAttStatus) {
        this.locationAttStatus = locationAttStatus;
    }

    public String getLocationAttStatus() {
        return locationAttStatus;
    }

    public void setTimeAttResult(String timeAttResult) {
        this.timeAttResult = timeAttResult;
    }

    public String getTimeAttResult() {
        return timeAttResult;
    }

    public void setServerAttTime(String serverAttTime) {
        this.serverAttTime = serverAttTime;
    }

    public String getServerAttTime() {
        return serverAttTime;
    }
}
