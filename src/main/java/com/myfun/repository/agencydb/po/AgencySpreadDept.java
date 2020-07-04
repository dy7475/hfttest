package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencySpreadDept implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer spreadId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    private String deptName;

    /**
     *
     * @mbggenerated
     */
    private String dsConnectionId;

    /**
     *
     * @mbggenerated
     */
    private Integer isSend;

    /**
     *
     * @mbggenerated
     */
    private Date pushTime;

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
    public Integer getSpreadId() {
        return spreadId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSpreadId(Integer spreadId) {
        this.spreadId = spreadId;
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
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDsConnectionId() {
        return dsConnectionId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDsConnectionId(String dsConnectionId) {
        this.dsConnectionId = dsConnectionId == null ? null : dsConnectionId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getIsSend() {
        return isSend;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}