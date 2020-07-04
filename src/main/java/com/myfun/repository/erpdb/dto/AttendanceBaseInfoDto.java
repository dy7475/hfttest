package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.util.Date;

public class AttendanceBaseInfoDto implements Serializable {

    private String groupId;
    private String attScopeId;
    private String classId;
    private String groupName;
    private String attScopeX;
    private String attScopeY;
    private String attDistance;
    private String locationDesc;
    private String locationDescAbb;
    private String serverAttTime = String.valueOf(new Date().getTime());
    private String classNumber = "0";
    private String attRest = "2";
    private String attType;
    private String endGreeting;
    private String startGreeting;
    private String startPhotoUrl;
    private String endPhotoUrl;
    private String isToday;

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

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }

    public String getEndGreeting() {
        return endGreeting;
    }

    public void setEndGreeting(String endGreeting) {
        this.endGreeting = endGreeting;
    }

    public String getStartGreeting() {
        return startGreeting;
    }

    public void setStartGreeting(String startGreeting) {
        this.startGreeting = startGreeting;
    }

    public String getIsToday() {
        return isToday;
    }

    public void setIsToday(String isToday) {
        this.isToday = isToday;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setAttScopeId(String attScopeId) {
        this.attScopeId = attScopeId;
    }

    public String getAttScopeId() {
        return attScopeId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassId() {
        return classId;
    }


    public String getAttScopeX() {
        return attScopeX;
    }

    public void setAttScopeX(String attScopeX) {
        this.attScopeX = attScopeX;
    }

    public String getAttScopeY() {
        return attScopeY;
    }

    public void setAttScopeY(String attScopeY) {
        this.attScopeY = attScopeY;
    }

    public void setAttDistance(String attDistance) {
        this.attDistance = attDistance;
    }

    public String getAttDistance() {
        return attDistance;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDescAbb(String locationDescAbb) {
        this.locationDescAbb = locationDescAbb;
    }

    public String getLocationDescAbb() {
        return locationDescAbb;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getServerAttTime() {
        return serverAttTime;
    }

    public void setServerAttTime(String serverAttTime) {
        this.serverAttTime = serverAttTime;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getAttRest() {
        return attRest;
    }

    public void setAttRest(String attRest) {
        this.attRest = attRest;
    }


}
