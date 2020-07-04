package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunContact implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer contactId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Byte groupType;

    /**
     *
     * @mbggenerated
     */
    private String contactName;

    /**
     *
     * @mbggenerated
     */
    private String compName;

    /**
     *
     * @mbggenerated
     */
    private Boolean sex;

    /**
     *
     * @mbggenerated
     */
    private String job;

    /**
     *
     * @mbggenerated
     */
    private String email;

    /**
     *
     * @mbggenerated
     */
    private String qq;

    /**
     *
     * @mbggenerated
     */
    private String phone;

    /**
     *
     * @mbggenerated
     */
    private String phone1;

    /**
     *
     * @mbggenerated
     */
    private String regTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getContactId() {
        return contactId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getGroupType() {
        return groupType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGroupType(Byte groupType) {
        this.groupType = groupType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getContactName() {
        return contactName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCompName() {
        return compName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     *
     * @mbggenerated
     */
    public String getJob() {
        return job;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getQq() {
        return qq;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1 == null ? null : phone1.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }
}