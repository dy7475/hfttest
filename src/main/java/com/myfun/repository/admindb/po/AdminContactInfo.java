package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminContactInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private String contactMan;

    /**
     *
     * @mbggenerated
     */
    private String contactPhone;

    /**
     *
     * @mbggenerated
     */
    private String contactEmail;

    /**
     *
     * @mbggenerated
     */
    private Integer contactFlag;

    /**
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getContactMan() {
        return contactMan;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getContactFlag() {
        return contactFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactFlag(Integer contactFlag) {
        this.contactFlag = contactFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}