package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyBuildingPhoto extends AgencyBuildingPhotoKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Byte photoType;

    /**
     *
     * @mbggenerated
     */
    private String photoDesc;

    /**
     *
     * @mbggenerated
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private Byte isFirst;

    /**
     *
     * @mbggenerated
     */
    private Integer layoutId;

    /**
     *
     * @mbggenerated
     */
    private Byte layoutFirst;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private Integer uploadUser;

    /**
     *
     * @mbggenerated
     */
    private Date uploadDate;

    /**
     *
     * @mbggenerated
     */
    private Byte editFlag;

    /**
     *
     * @mbggenerated
     */
    private Byte defFfimgFlag;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getPhotoDesc() {
        return photoDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc == null ? null : photoDesc.trim();
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
    public Integer getLayoutId() {
        return layoutId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getLayoutFirst() {
        return layoutFirst;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLayoutFirst(Byte layoutFirst) {
        this.layoutFirst = layoutFirst;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
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
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getEditFlag() {
        return editFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEditFlag(Byte editFlag) {
        this.editFlag = editFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDefFfimgFlag() {
        return defFfimgFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDefFfimgFlag(Byte defFfimgFlag) {
        this.defFfimgFlag = defFfimgFlag;
    }

	@Override
	public String toString() {
		return "AgencyBuildingPhoto [photoType=" + photoType + ", photoDesc=" + photoDesc + ", photoAddr=" + photoAddr
				+ ", isFirst=" + isFirst + ", layoutId=" + layoutId + ", layoutFirst=" + layoutFirst + ", seqNo="
				+ seqNo + ", uploadUser=" + uploadUser + ", uploadDate=" + uploadDate + ", editFlag=" + editFlag
				+ ", defFfimgFlag=" + defFfimgFlag + "]";
	}
    
    
}