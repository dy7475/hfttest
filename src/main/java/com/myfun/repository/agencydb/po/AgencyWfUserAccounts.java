package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfUserAccounts implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer dduaId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String userName;

    /**
     *
     * @mbggenerated
     */
    private String userMobile;

    /**
     *
     * @mbggenerated
     */
    private Long amountIncome;

    /**
     *
     * @mbggenerated
     */
    private Long offlineAmountIncome;

    /**
     *
     * @mbggenerated
     */
    private Long awardAmount;

    /**
     *
     * @mbggenerated
     */
    private Long awardClosingAmount;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getDduaId() {
        return dduaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDduaId(Integer dduaId) {
        this.dduaId = dduaId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
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
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Long getAmountIncome() {
        return amountIncome;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAmountIncome(Long amountIncome) {
        this.amountIncome = amountIncome;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getOfflineAmountIncome() {
        return offlineAmountIncome;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOfflineAmountIncome(Long offlineAmountIncome) {
        this.offlineAmountIncome = offlineAmountIncome;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getAwardAmount() {
        return awardAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAwardAmount(Long awardAmount) {
        this.awardAmount = awardAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getAwardClosingAmount() {
        return awardClosingAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAwardClosingAmount(Long awardClosingAmount) {
        this.awardClosingAmount = awardClosingAmount;
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
}