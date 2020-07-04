package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.util.Date;

public class AttendanceLocationInfoDto implements Serializable {

    private String attScopeId;
    private String attScopeX;
    private String attScopeY;
    private String attDistance;
    private String locationDesc;
    private String locationDescAbb;

    public String getAttScopeId() {
        return attScopeId;
    }

    public void setAttScopeId(String attScopeId) {
        this.attScopeId = attScopeId;
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

    public String getAttDistance() {
        return attDistance;
    }

    public void setAttDistance(String attDistance) {
        this.attDistance = attDistance;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getLocationDescAbb() {
        return locationDescAbb;
    }

    public void setLocationDescAbb(String locationDescAbb) {
        this.locationDescAbb = locationDescAbb;
    }
}
