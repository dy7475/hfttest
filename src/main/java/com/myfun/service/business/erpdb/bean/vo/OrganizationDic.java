package com.myfun.service.business.erpdb.bean.vo;


public class OrganizationDic {
    //(value = "组织Id",example = "12001")
    private Integer orgId;
    //(value = "层级名称",example = "org1")
    private String dbFieldPath;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getDbFieldPath() {
        return dbFieldPath;
    }

    public void setDbFieldPath(String dbFieldPath) {
        this.dbFieldPath = dbFieldPath;
    }
}
