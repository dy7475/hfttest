package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpFunPhotoTemplate extends ShardDb {
    /**
     *
     * @mbggenerated
     */
    private Integer photoId;

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
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private Byte photoType;

    /**
     *
     * @mbggenerated
     */
    private Byte useageType;

    /**
     *
     * @mbggenerated
     */
    private Integer pdId;

    /**
     *
     * @mbggenerated
     */
    private Byte isTop;

    /**
     *
     * @mbggenerated
     */
    private Byte photoSource;

    /**
     *
     * @mbggenerated
     */
    private Byte photoSeq;

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
    public Byte getUseageType() {
        return useageType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUseageType(Byte useageType) {
        this.useageType = useageType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPdId() {
        return pdId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsTop() {
        return isTop;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsTop(Byte isTop) {
        this.isTop = isTop;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPhotoSource() {
        return photoSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoSource(Byte photoSource) {
        this.photoSource = photoSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPhotoSeq() {
        return photoSeq;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoSeq(Byte photoSeq) {
        this.photoSeq = photoSeq;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPhotoTemplate() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPhotoTemplate(Integer shardCityId) {
        super(shardCityId);
    }
}