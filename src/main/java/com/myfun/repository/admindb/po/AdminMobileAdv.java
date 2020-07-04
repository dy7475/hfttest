package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminMobileAdv implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer advLevel;

    /**
     *
     * @mbggenerated
     */
    private String url;

    /**
     *
     * @mbggenerated
     */
    private Integer urlType;

    /**
     *
     * @mbggenerated
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private String advTitle;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Byte advType;

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
    public Integer getAdvLevel() {
        return advLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdvLevel(Integer advLevel) {
        this.advLevel = advLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUrlType() {
        return urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUrlType(Integer urlType) {
        this.urlType = urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPhotoAddr() {
        return photoAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr == null ? null : photoAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdvTitle() {
        return advTitle;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdvTitle(String advTitle) {
        this.advTitle = advTitle == null ? null : advTitle.trim();
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
    public Byte getAdvType() {
        return advType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdvType(Byte advType) {
        this.advType = advType;
    }
}