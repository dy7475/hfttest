package com.myfun.repository.admindb.po;

public class AdminWMicroshopJobApply {
    /**
     *
     * @mbggenerated
     */
    private Integer applyId;

    /**
     *
     * @mbggenerated
     */
    private Integer jobId;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     *
     * @mbggenerated
     */
    private Integer ctime;

    /**
     *
     * @mbggenerated
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCtime() {
        return ctime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }
}