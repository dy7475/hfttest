package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyVipPhoto extends AgencyVipPhotoKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    private Byte photoType;

    /**
     *
     * @mbggenerated
     */
    private String fphotoid;

    /**
     *
     * @mbggenerated
     */
    private String fphotourl;

    /**
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     *
     * @mbggenerated
     */
    private Byte infoSource;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
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
    public String getFphotoid() {
        return fphotoid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFphotoid(String fphotoid) {
        this.fphotoid = fphotoid == null ? null : fphotoid.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getFphotourl() {
        return fphotourl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFphotourl(String fphotourl) {
        this.fphotourl = fphotourl == null ? null : fphotourl.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getInfoSource() {
        return infoSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInfoSource(Byte infoSource) {
        this.infoSource = infoSource;
    }
}