package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminServerErrorLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer serverType;

    /**
     *
     * @mbggenerated
     */
    private Integer errorCode;

    /**
     *
     * @mbggenerated
     */
    private String errorMsg;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private String exceptionText;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public Integer getServerType() {
        return serverType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     *
     * @mbggenerated
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getExceptionText() {
        return exceptionText;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExceptionText(String exceptionText) {
        this.exceptionText = exceptionText == null ? null : exceptionText.trim();
    }
}