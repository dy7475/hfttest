package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpBuildingPhotoBak extends ShardDb {
    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer photoId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private Integer uploadUser;

    /**
     *
     * @mbggenerated
     */
    private String uploadDate;

    /**
     *
     * @mbggenerated
     */
    private Boolean vertifyFlag;

    /**
     *
     * @mbggenerated
     */
    private Integer relativeId;

    /**
     *
     * @mbggenerated
     */
    private Boolean isFirst;

    /**
     *
     * @mbggenerated
     */
    private Byte photoType;

    /**
     *
     * @mbggenerated
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPhotoId() {
        return photoId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
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
    public Integer getUploadUser() {
        return uploadUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUploadUser(Integer uploadUser) {
        this.uploadUser = uploadUser;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUploadDate() {
        return uploadDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate == null ? null : uploadDate.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getVertifyFlag() {
        return vertifyFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVertifyFlag(Boolean vertifyFlag) {
        this.vertifyFlag = vertifyFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRelativeId() {
        return relativeId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRelativeId(Integer relativeId) {
        this.relativeId = relativeId;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getIsFirst() {
        return isFirst;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPhotoType() {
        return photoType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoType(Byte photoType) {
        this.photoType = photoType;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpBuildingPhotoBak() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpBuildingPhotoBak(Integer shardCityId, Short cityId, Integer photoId) {
        super(shardCityId);
        this.cityId = cityId;
        this.photoId = photoId;
    }
}