package com.myfun.repository.admindb.po;

public class AdminQrtzJobDetails extends AdminQrtzJobDetailsKey {
    /**
     *
     * @mbggenerated
     */
    private String description;

    /**
     *
     * @mbggenerated
     */
    private String jobClassName;

    /**
     *
     * @mbggenerated
     */
    private String isDurable;

    /**
     *
     * @mbggenerated
     */
    private String isNonconcurrent;

    /**
     *
     * @mbggenerated
     */
    private String isUpdateData;

    /**
     *
     * @mbggenerated
     */
    private String requestsRecovery;

    /**
     *
     * @mbggenerated
     */
    private byte[] jobData;

    /**
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getJobClassName() {
        return jobClassName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName == null ? null : jobClassName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIsDurable() {
        return isDurable;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable == null ? null : isDurable.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent == null ? null : isNonconcurrent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIsUpdateData() {
        return isUpdateData;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData == null ? null : isUpdateData.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery == null ? null : requestsRecovery.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public byte[] getJobData() {
        return jobData;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }
}