package com.myfun.repository.erpdb.dto;

import java.io.Serializable;

public class ErpPerformanceAssessmentCountDto implements Serializable {

    private Integer userId;
    private Integer deptId;
    private String userPosition;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
}
