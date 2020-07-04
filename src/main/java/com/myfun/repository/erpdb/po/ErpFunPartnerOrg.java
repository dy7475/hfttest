package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPartnerOrg extends ShardDb implements Serializable {
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
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer partnerId;

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
    private Byte partnerType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date cooperateStartTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date cooperateEndTime;

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
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date updateTime;

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
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
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
    public Byte getPartnerType() {
        return partnerType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setPartnerType(Byte partnerType) {
        this.partnerType = partnerType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getCooperateStartTime() {
        return cooperateStartTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCooperateStartTime(Date cooperateStartTime) {
        this.cooperateStartTime = cooperateStartTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getCooperateEndTime() {
        return cooperateEndTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCooperateEndTime(Date cooperateEndTime) {
        this.cooperateEndTime = cooperateEndTime;
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
     * -
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPartnerOrg() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPartnerOrg(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}