package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfTask implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer taskId;

    /**
     *
     * @mbggenerated
     */
    private String taskUrl;

    /**
     *
     * @mbggenerated
     */
    private Byte taskStatus;

    /**
     *
     * @mbggenerated
     */
    private Date taskTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTaskUrl() {
        return taskUrl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl == null ? null : taskUrl.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTaskStatus() {
        return taskStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTaskTime() {
        return taskTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }
}