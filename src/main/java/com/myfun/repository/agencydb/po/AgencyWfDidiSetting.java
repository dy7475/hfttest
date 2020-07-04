package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfDidiSetting implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer wfId;

    /**
     *
     * @mbggenerated
     */
    private String wfKey;

    /**
     *
     * @mbggenerated
     */
    private String wfValue;

    /**
     *
     * @mbggenerated
     */
    private String wfDesc;

    /**
     *
     * @mbggenerated
     */
    private Byte wfStatus;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer operatorId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getWfId() {
        return wfId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfId(Integer wfId) {
        this.wfId = wfId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfKey() {
        return wfKey;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfKey(String wfKey) {
        this.wfKey = wfKey == null ? null : wfKey.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfValue() {
        return wfValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfValue(String wfValue) {
        this.wfValue = wfValue == null ? null : wfValue.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfDesc() {
        return wfDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfDesc(String wfDesc) {
        this.wfDesc = wfDesc == null ? null : wfDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfStatus() {
        return wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfStatus(Byte wfStatus) {
        this.wfStatus = wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}