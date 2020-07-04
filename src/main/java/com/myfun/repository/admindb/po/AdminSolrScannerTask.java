package com.myfun.repository.admindb.po;

import java.util.Date;

public class AdminSolrScannerTask {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String jobName;

    /**
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     *
     * @mbggenerated
     */
    private Date lastSyncTime;

    /**
     *
     * @mbggenerated
     */
    private Integer queueSize;

    /**
     *
     * @mbggenerated
     */
    private Integer syncCount;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

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
    public String getJobName() {
        return jobName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLastSyncTime() {
        return lastSyncTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLastSyncTime(Date lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getQueueSize() {
        return queueSize;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSyncCount() {
        return syncCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSyncCount(Integer syncCount) {
        this.syncCount = syncCount;
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