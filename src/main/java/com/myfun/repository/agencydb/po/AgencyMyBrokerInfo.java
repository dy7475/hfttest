package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyMyBrokerInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer myBrokerId;

    /**
     *
     * @mbggenerated
     */
    private String brokerId;

    /**
     *
     * @mbggenerated
     */
    private String buildingId;

    /**
     *
     * @mbggenerated
     */
    private Integer checkStatus;

    /**
     *
     * @mbggenerated
     */
    private String cstId;

    /**
     *
     * @mbggenerated
     */
    private Integer cstStatus;

    /**
     *
     * @mbggenerated
     */
    private String reason;

    /**
     *
     * @mbggenerated
     */
    private Date saveEnddate;

    /**
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getMyBrokerId() {
        return myBrokerId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyBrokerId(Integer myBrokerId) {
        this.myBrokerId = myBrokerId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBrokerId() {
        return brokerId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId == null ? null : brokerId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildingId() {
        return buildingId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCheckStatus() {
        return checkStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCstId() {
        return cstId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCstId(String cstId) {
        this.cstId = cstId == null ? null : cstId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCstStatus() {
        return cstStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCstStatus(Integer cstStatus) {
        this.cstStatus = cstStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSaveEnddate() {
        return saveEnddate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaveEnddate(Date saveEnddate) {
        this.saveEnddate = saveEnddate;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}