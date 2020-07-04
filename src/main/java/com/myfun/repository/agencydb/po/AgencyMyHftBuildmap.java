package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyMyHftBuildmap implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String myId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getMyId() {
        return myId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyId(String myId) {
        this.myId = myId == null ? null : myId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }
}