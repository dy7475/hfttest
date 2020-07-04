package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpMakeLookHouse extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "id 自增")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源id")
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源类型")
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看类型 0=内部 1=外部")
    private Byte lookType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看标题")
    private String makeLookTitle;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看说明")
    private String makeLookDesc;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "外部合作 LOOK_TYPE = 1时，房屋信息")
    private String houseInfo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "内部选择 LOOK_TYPE = 0时,房源id，多个用逗号隔开")
    private String houseIds;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看时间")
    private Date lookTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看的跟进id,审核通过后的")
    private Integer trackId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否通过了审核 1=是")
    private Byte isAudit;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否已约看 1=是")
    private Byte lookStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "档案id")
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "用户id")
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司id")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "约看标题富文本")
    private String makeLookRichTitle;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
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
    public Byte getLookType() {
        return lookType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLookType(Byte lookType) {
        this.lookType = lookType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMakeLookTitle() {
        return makeLookTitle;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMakeLookTitle(String makeLookTitle) {
        this.makeLookTitle = makeLookTitle == null ? null : makeLookTitle.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMakeLookDesc() {
        return makeLookDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMakeLookDesc(String makeLookDesc) {
        this.makeLookDesc = makeLookDesc == null ? null : makeLookDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouseInfo() {
        return houseInfo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo == null ? null : houseInfo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouseIds() {
        return houseIds;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseIds(String houseIds) {
        this.houseIds = houseIds == null ? null : houseIds.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLookTime() {
        return lookTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLookTime(Date lookTime) {
        this.lookTime = lookTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsAudit() {
        return isAudit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsAudit(Byte isAudit) {
        this.isAudit = isAudit;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getLookStatus() {
        return lookStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLookStatus(Byte lookStatus) {
        this.lookStatus = lookStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMakeLookRichTitle() {
        return makeLookRichTitle;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMakeLookRichTitle(String makeLookRichTitle) {
        this.makeLookRichTitle = makeLookRichTitle == null ? null : makeLookRichTitle.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpMakeLookHouse() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpMakeLookHouse(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}