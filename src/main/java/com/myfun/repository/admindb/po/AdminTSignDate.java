package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTSignDate implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer tDateId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Date tDate;

    /**
     *
     * @mbggenerated
     */
    private Date tGetTime;

    /**
     *
     * @mbggenerated
     */
    private String tGetStatu;

    /**
     *
     * @mbggenerated
     */
    private String tSignDay;

    /**
     *
     * @mbggenerated
     */
    private String tPrizeMoney;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer gettDateId() {
        return tDateId;
    }

    /**
     *
     * @mbggenerated
     */
    public void settDateId(Integer tDateId) {
        this.tDateId = tDateId;
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
    public Date gettDate() {
        return tDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Date gettGetTime() {
        return tGetTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void settGetTime(Date tGetTime) {
        this.tGetTime = tGetTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String gettGetStatu() {
        return tGetStatu;
    }

    /**
     *
     * @mbggenerated
     */
    public void settGetStatu(String tGetStatu) {
        this.tGetStatu = tGetStatu == null ? null : tGetStatu.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String gettSignDay() {
        return tSignDay;
    }

    /**
     *
     * @mbggenerated
     */
    public void settSignDay(String tSignDay) {
        this.tSignDay = tSignDay == null ? null : tSignDay.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String gettPrizeMoney() {
        return tPrizeMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void settPrizeMoney(String tPrizeMoney) {
        this.tPrizeMoney = tPrizeMoney == null ? null : tPrizeMoney.trim();
    }
}