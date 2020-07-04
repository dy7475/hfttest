package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSosoBuildingPhotoFastdfs implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer photoId;

    /**
     *
     * @mbggenerated
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private String oldAddr;

    /**
     *
     * @mbggenerated
     */
    private Byte isDeal;

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
    public String getOldAddr() {
        return oldAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOldAddr(String oldAddr) {
        this.oldAddr = oldAddr == null ? null : oldAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsDeal() {
        return isDeal;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsDeal(Byte isDeal) {
        this.isDeal = isDeal;
    }
}