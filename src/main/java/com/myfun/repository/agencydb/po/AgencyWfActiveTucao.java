package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfActiveTucao implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer wxId;

    /**
     *
     * @mbggenerated
     */
    private String content;

    /**
     *
     * @mbggenerated
     */
    private Date addTime;

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
    public Integer getWxId() {
        return wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}