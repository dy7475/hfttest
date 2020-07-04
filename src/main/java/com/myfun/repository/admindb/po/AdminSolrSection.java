package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminSolrSection implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String sectionName;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }
}