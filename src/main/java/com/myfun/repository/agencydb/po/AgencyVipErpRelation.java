package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyVipErpRelation implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer wfId;

    /**
     *
     * @mbggenerated
    VIP表中的SALE_ID，LEASE_ID，BUY_ID，RENT_ID
     */
    private Integer vipId;

    /**
     *
     * @mbggenerated
    城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    ERP中的房源和客源ID
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    关联类型(出售1,出租2,求购3求租4)
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
    有效状态（1有效，0无效）
     */
    private Integer status;

    /**
     *
     * @mbggenerated
    经纪人是否需要同步编辑数据 1:是、0:否
     */
    private Byte updateSyncFlag;

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
    public Integer getVipId() {
        return vipId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVipId(Integer vipId) {
        this.vipId = vipId;
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
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUpdateSyncFlag() {
        return updateSyncFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateSyncFlag(Byte updateSyncFlag) {
        this.updateSyncFlag = updateSyncFlag;
    }
}