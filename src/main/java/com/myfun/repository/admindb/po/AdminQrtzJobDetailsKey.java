package com.myfun.repository.admindb.po;

public class AdminQrtzJobDetailsKey {
    /**
     *
     * @mbggenerated
     */
    private String schedName;

    /**
     *
     * @mbggenerated
     */
    private String jobName;

    /**
     *
     * @mbggenerated
     */
    private String jobGroup;

    /**
     *
     * @mbggenerated
     */
    public String getSchedName() {
        return schedName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSchedName(String schedName) {
        this.schedName = schedName == null ? null : schedName.trim();
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
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }
}