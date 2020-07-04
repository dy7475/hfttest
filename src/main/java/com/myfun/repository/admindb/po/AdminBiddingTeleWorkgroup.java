package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminBiddingTeleWorkgroup implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String guid;

    /**
     *
     * @mbggenerated
     */
    private Integer biddingId;

    /**
     *
     * @mbggenerated
     */
    private Integer custId;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String bigCode;

    /**
     *
     * @mbggenerated
     */
    private String extCode;

    /**
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private String extension;

    /**
     *
     * @mbggenerated
     */
    private String userList;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getGuid() {
        return guid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBiddingId() {
        return biddingId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingId(Integer biddingId) {
        this.biddingId = biddingId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
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
    public String getBigCode() {
        return bigCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBigCode(String bigCode) {
        this.bigCode = bigCode == null ? null : bigCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getExtCode() {
        return extCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExtCode(String extCode) {
        this.extCode = extCode == null ? null : extCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserList() {
        return userList;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserList(String userList) {
        this.userList = userList == null ? null : userList.trim();
    }
}