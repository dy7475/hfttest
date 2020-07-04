package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminSosoBuildingPhoto implements Serializable {
    /**
     *
     * @mbggenerated
    主键id
     */
    private Integer photoId;

    /**
     *
     * @mbggenerated
    楼盘id
     */
    private Integer buildingId;

    /**
     *
     * @mbggenerated
    图片名称
     */
    private String photoName;

    /**
     *
     * @mbggenerated
    地址
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
    是否置顶1置顶0不置顶
     */
    private Byte isFirst;

    /**
     *
     * @mbggenerated
    1外景图2效果图3户型图4交通图5规划图6样板图7配套图8实景图9装修案例图10活动现场
     */
    private Byte photoType;

    /**
     *
     * @mbggenerated
    城市id
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    户型id
     */
    private Integer huxingId;

    /**
     *
     * @mbggenerated
    废弃
     */
    private Byte photoCategory;

    /**
     *
     * @mbggenerated
    锁定人
     */
    private Integer lockUser;

    /**
     *
     * @mbggenerated
    审核状态0未审核1审核通过
     */
    private Byte auditStatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
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
    public Byte getIsFirst() {
        return isFirst;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsFirst(Byte isFirst) {
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
    public Integer getHuxingId() {
        return huxingId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHuxingId(Integer huxingId) {
        this.huxingId = huxingId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPhotoCategory() {
        return photoCategory;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoCategory(Byte photoCategory) {
        this.photoCategory = photoCategory;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLockUser() {
        return lockUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLockUser(Integer lockUser) {
        this.lockUser = lockUser;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }
}