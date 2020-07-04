package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyMyBuildPicture implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer myPictureId;

    /**
     *
     * @mbggenerated
     */
    private String buildingId;

    /**
     *
     * @mbggenerated
     */
    private String groupId;

    /**
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     *
     * @mbggenerated
     */
    private String pictureSrc;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getMyPictureId() {
        return myPictureId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyPictureId(Integer myPictureId) {
        this.myPictureId = myPictureId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildingId() {
        return buildingId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPictureSrc() {
        return pictureSrc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc == null ? null : pictureSrc.trim();
    }
}