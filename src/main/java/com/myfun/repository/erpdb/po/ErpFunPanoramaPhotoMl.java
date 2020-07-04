package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPanoramaPhotoMl extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer photoId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer uploadSourceUser;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte photographerFlag;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte isDel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date delTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte complaintStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String complaintView;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer complaintReviewUid;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date complaintReviewTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String complaintReviewView;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getPhotoId() {
        return photoId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getUploadSourceUser() {
        return uploadSourceUser;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setUploadSourceUser(Integer uploadSourceUser) {
        this.uploadSourceUser = uploadSourceUser;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getPhotographerFlag() {
        return photographerFlag;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setPhotographerFlag(Byte photographerFlag) {
        this.photographerFlag = photographerFlag;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getComplaintStatus() {
        return complaintStatus;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setComplaintStatus(Byte complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getComplaintView() {
        return complaintView;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setComplaintView(String complaintView) {
        this.complaintView = complaintView;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getComplaintReviewUid() {
        return complaintReviewUid;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setComplaintReviewUid(Integer complaintReviewUid) {
        this.complaintReviewUid = complaintReviewUid;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getComplaintReviewTime() {
        return complaintReviewTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setComplaintReviewTime(Date complaintReviewTime) {
        this.complaintReviewTime = complaintReviewTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getComplaintReviewView() {
        return complaintReviewView;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setComplaintReviewView(String complaintReviewView) {
        this.complaintReviewView = complaintReviewView;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPanoramaPhotoMl() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPanoramaPhotoMl(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}