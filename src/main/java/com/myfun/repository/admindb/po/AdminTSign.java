package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTSign implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer tSigninId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Date tSignDate;

    /**
     *
     * @mbggenerated
     */
    private Integer tDayssignIn;

    /**
     *
     * @mbggenerated
     */
    private String tFlag;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer gettSigninId() {
        return tSigninId;
    }

    /**
     *
     * @mbggenerated
     */
    public void settSigninId(Integer tSigninId) {
        this.tSigninId = tSigninId;
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
    public Date gettSignDate() {
        return tSignDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void settSignDate(Date tSignDate) {
        this.tSignDate = tSignDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer gettDayssignIn() {
        return tDayssignIn;
    }

    /**
     *
     * @mbggenerated
     */
    public void settDayssignIn(Integer tDayssignIn) {
        this.tDayssignIn = tDayssignIn;
    }

    /**
     *
     * @mbggenerated
     */
    public String gettFlag() {
        return tFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void settFlag(String tFlag) {
        this.tFlag = tFlag == null ? null : tFlag.trim();
    }
}