package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunCustSource extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "来源ID")
    private Integer custSourceId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建人")
    private Integer createdUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date createdTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "更新人")
    private String updatedUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "更新时间")
    private Date updatedTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否禁用0否1是")
    private Byte forbidStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否删除0否1是")
    private Byte delStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "来源名称")
    private String sourceName;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "编码")
    private String code;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "序号")
    private Integer serialNumber;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "描述")
    private String description;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司ID")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 来源ID
     */
    public Integer getCustSourceId() {
        return custSourceId;
    }

    /**
     *
     * @mbggenerated
     * 来源ID
     */
    public void setCustSourceId(Integer custSourceId) {
        this.custSourceId = custSourceId;
    }

    /**
     *
     * @mbggenerated
     * 创建人
     */
    public Integer getCreatedUserId() {
        return createdUserId;
    }

    /**
     *
     * @mbggenerated
     * 创建人
     */
    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     *
     * @mbggenerated
     * 更新人
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     *
     * @mbggenerated
     * 更新人
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     *
     * @mbggenerated
     * 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     *
     * @mbggenerated
     * 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     *
     * @mbggenerated
     * 是否禁用0否1是
     */
    public Byte getForbidStatus() {
        return forbidStatus;
    }

    /**
     *
     * @mbggenerated
     * 是否禁用0否1是
     */
    public void setForbidStatus(Byte forbidStatus) {
        this.forbidStatus = forbidStatus;
    }

    /**
     *
     * @mbggenerated
     * 是否删除0否1是
     */
    public Byte getDelStatus() {
        return delStatus;
    }

    /**
     *
     * @mbggenerated
     * 是否删除0否1是
     */
    public void setDelStatus(Byte delStatus) {
        this.delStatus = delStatus;
    }

    /**
     *
     * @mbggenerated
     * 来源名称
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     *
     * @mbggenerated
     * 来源名称
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     *
     * @mbggenerated
     * 编码
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbggenerated
     * 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @mbggenerated
     * 序号
     */
    public Integer getSerialNumber() {
        return serialNumber;
    }

    /**
     *
     * @mbggenerated
     * 序号
     */
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunCustSource() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunCustSource(Integer shardCityId, Integer custSourceId) {
        super(shardCityId);
        this.custSourceId = custSourceId;
    }
}