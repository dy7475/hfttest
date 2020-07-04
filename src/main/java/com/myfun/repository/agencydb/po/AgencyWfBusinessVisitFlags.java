package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfBusinessVisitFlags implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer visitFlagId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private String page;

    /**
     *
     * @mbggenerated
     */
    private Date lastTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getVisitFlagId() {
        return visitFlagId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVisitFlagId(Integer visitFlagId) {
        this.visitFlagId = visitFlagId;
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
    public String getPage() {
        return page;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}