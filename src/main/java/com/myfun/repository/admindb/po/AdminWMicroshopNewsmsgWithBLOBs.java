package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopNewsmsgWithBLOBs extends AdminWMicroshopNewsmsg implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String desc;

    /**
     *
     * @mbggenerated
     */
    private String content;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
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
}