package com.myfun.repository.agencydb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AgencyWfDidiTrack implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "自增主键ID")
    private Integer wfId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "VIP_BUY,VIP_RENT,VIP_SALE,VIP_LEASE表的ID")
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "1出售 2出租 3求购 4求租")
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建房源 1，抢单 2，房勘 3，带看 4，成交 5，拒绝 0 ，同意委托 6，推荐房源7， 撤销房源8， 带看评价9，邀请带看评价10，支付邀请11，完成服务评价12，有奖委托投诉13，支付奖励金14，转入系统15")
    private String trackType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "跟进内容")
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "被跟进信息的经纪人ARCHIVE_ID")
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "0默认,1:优优好房 , 2:ERP")
    private Byte trackSource;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "跟进标题")
    private String trackTitle;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "0C端 1经纪人用来区别头像")
    private Byte fromSource;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "0C端用的跟进1B端用的跟进")
    private Byte isB;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 自增主键ID
     */
    public Integer getWfId() {
        return wfId;
    }

    /**
     *
     * @mbggenerated
     * 自增主键ID
     */
    public void setWfId(Integer wfId) {
        this.wfId = wfId;
    }

    /**
     *
     * @mbggenerated
     * VIP_BUY,VIP_RENT,VIP_SALE,VIP_LEASE表的ID
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     * VIP_BUY,VIP_RENT,VIP_SALE,VIP_LEASE表的ID
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 1出售 2出租 3求购 4求租
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     * 1出售 2出租 3求购 4求租
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     * 创建房源 1，抢单 2，房勘 3，带看 4，成交 5，拒绝 0 ，同意委托 6，推荐房源7， 撤销房源8， 带看评价9，邀请带看评价10，支付邀请11，完成服务评价12，有奖委托投诉13，支付奖励金14，转入系统15
     */
    public String getTrackType() {
        return trackType;
    }

    /**
     *
     * @mbggenerated
     * 创建房源 1，抢单 2，房勘 3，带看 4，成交 5，拒绝 0 ，同意委托 6，推荐房源7， 撤销房源8， 带看评价9，邀请带看评价10，支付邀请11，完成服务评价12，有奖委托投诉13，支付奖励金14，转入系统15
     */
    public void setTrackType(String trackType) {
        this.trackType = trackType == null ? null : trackType.trim();
    }

    /**
     *
     * @mbggenerated
     * 跟进内容
     */
    public String getTrackContent() {
        return trackContent;
    }

    /**
     *
     * @mbggenerated
     * 跟进内容
     */
    public void setTrackContent(String trackContent) {
        this.trackContent = trackContent == null ? null : trackContent.trim();
    }

    /**
     *
     * @mbggenerated
     * 被跟进信息的经纪人ARCHIVE_ID
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     * 被跟进信息的经纪人ARCHIVE_ID
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     * 0默认,1:优优好房 , 2:ERP
     */
    public Byte getTrackSource() {
        return trackSource;
    }

    /**
     *
     * @mbggenerated
     * 0默认,1:优优好房 , 2:ERP
     */
    public void setTrackSource(Byte trackSource) {
        this.trackSource = trackSource;
    }

    /**
     *
     * @mbggenerated
     * 跟进标题
     */
    public String getTrackTitle() {
        return trackTitle;
    }

    /**
     *
     * @mbggenerated
     * 跟进标题
     */
    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle == null ? null : trackTitle.trim();
    }

    /**
     *
     * @mbggenerated
     * 0C端 1经纪人用来区别头像
     */
    public Byte getFromSource() {
        return fromSource;
    }

    /**
     *
     * @mbggenerated
     * 0C端 1经纪人用来区别头像
     */
    public void setFromSource(Byte fromSource) {
        this.fromSource = fromSource;
    }

    /**
     *
     * @mbggenerated
     * 0C端用的跟进1B端用的跟进
     */
    public Byte getIsB() {
        return isB;
    }

    /**
     *
     * @mbggenerated
     * 0C端用的跟进1B端用的跟进
     */
    public void setIsB(Byte isB) {
        this.isB = isB;
    }
}