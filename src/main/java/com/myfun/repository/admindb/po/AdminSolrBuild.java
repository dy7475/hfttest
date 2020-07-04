package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminSolrBuild implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String buildName;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }
}