package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpUserOpersChangeCity extends ShardDb implements Serializable {
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
    private String operId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer organizationDefinitionId;

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
    public String getOperId() {
        return operId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOperId(String operId) {
        this.operId = operId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getOrganizationDefinitionId() {
        return organizationDefinitionId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
        this.organizationDefinitionId = organizationDefinitionId;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpUserOpersChangeCity() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpUserOpersChangeCity(Integer shardCityId, Integer userId, String operId) {
        super(shardCityId);
        this.userId = userId;
        this.operId = operId;
    }
}