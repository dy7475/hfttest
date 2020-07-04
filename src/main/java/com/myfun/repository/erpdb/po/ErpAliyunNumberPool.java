package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpAliyunNumberPool extends ShardDb implements Serializable {
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
    private String numberPoolName;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String numberPoolKey;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String aliNumberPoolKey;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte numberPoolType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer orgId;

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
    public String getNumberPoolName() {
        return numberPoolName;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setNumberPoolName(String numberPoolName) {
        this.numberPoolName = numberPoolName;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getNumberPoolKey() {
        return numberPoolKey;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setNumberPoolKey(String numberPoolKey) {
        this.numberPoolKey = numberPoolKey;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getAliNumberPoolKey() {
        return aliNumberPoolKey;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setAliNumberPoolKey(String aliNumberPoolKey) {
        this.aliNumberPoolKey = aliNumberPoolKey;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getNumberPoolType() {
        return numberPoolType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setNumberPoolType(Byte numberPoolType) {
        this.numberPoolType = numberPoolType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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
    public ErpAliyunNumberPool() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpAliyunNumberPool(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}