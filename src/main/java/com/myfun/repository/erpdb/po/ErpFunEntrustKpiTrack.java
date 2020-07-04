package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunEntrustKpiTrack extends ShardDb implements Serializable {
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
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer entrustId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String content;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date entrustTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date auditTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer organizationId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String organizationPath;

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
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getEntrustId() {
        return entrustId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getEntrustTime() {
        return entrustTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setEntrustTime(Date entrustTime) {
        this.entrustTime = entrustTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getOrganizationPath() {
        return organizationPath;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
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
    public ErpFunEntrustKpiTrack() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunEntrustKpiTrack(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}