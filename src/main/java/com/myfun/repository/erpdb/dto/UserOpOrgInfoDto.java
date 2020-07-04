package com.myfun.repository.erpdb.dto;

public class UserOpOrgInfoDto {

    //select b.USER_ID userId, a.OPER_ID operId, a.ORGANIZATION_DEFINITION_ID defId,b.ORGANIZATION_ID organizationId,b.TISSUE_LINE organizationPath
    private Integer userId;
    private Integer organizationId;
    private Integer orgDefLevel;
    private String organizationPath;
    private Integer authDefId;
    private Integer authOrgId;
    private Integer authDefLevel;
    private String userPosition;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getOrgDefLevel() {
        return orgDefLevel;
    }

    public void setOrgDefLevel(Integer orgDefLevel) {
        this.orgDefLevel = orgDefLevel;
    }

    public String getOrganizationPath() {
        return organizationPath;
    }

    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
    }

    public Integer getAuthDefId() {
        return authDefId;
    }

    public void setAuthDefId(Integer authDefId) {
        this.authDefId = authDefId;
    }

    public Integer getAuthOrgId() {
        return authOrgId;
    }

    public void setAuthOrgId(Integer authOrgId) {
        this.authOrgId = authOrgId;
    }

    public Integer getAuthDefLevel() {
        return authDefLevel;
    }

    public void setAuthDefLevel(Integer authDefLevel) {
        this.authDefLevel = authDefLevel;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
}
