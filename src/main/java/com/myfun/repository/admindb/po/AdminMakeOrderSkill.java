package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminMakeOrderSkill implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer skillId;

    /**
     *
     * @mbggenerated
     */
    private String skillTitle;

    /**
     *
     * @mbggenerated
     */
    private Byte isMain;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer viewCount;

    /**
     *
     * @mbggenerated
     */
    private Integer shareCount;

    /**
     *
     * @mbggenerated
     */
    private String dateGroup;

    /**
     *
     * @mbggenerated
     */
    private Integer createUid;

    /**
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     *
     * @mbggenerated
     */
    private String mainPhoto;

    /**
     *
     * @mbggenerated
     */
    private String skillContent;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSkillId() {
        return skillId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSkillTitle() {
        return skillTitle;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSkillTitle(String skillTitle) {
        this.skillTitle = skillTitle == null ? null : skillTitle.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsMain() {
        return isMain;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsMain(Byte isMain) {
        this.isMain = isMain;
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
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getShareCount() {
        return shareCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDateGroup() {
        return dateGroup;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDateGroup(String dateGroup) {
        this.dateGroup = dateGroup == null ? null : dateGroup.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
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

    /**
     *
     * @mbggenerated
     */
    public String getMainPhoto() {
        return mainPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto == null ? null : mainPhoto.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSkillContent() {
        return skillContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSkillContent(String skillContent) {
        this.skillContent = skillContent == null ? null : skillContent.trim();
    }
}