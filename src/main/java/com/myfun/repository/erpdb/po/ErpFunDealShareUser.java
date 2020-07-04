package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunDealShareUser extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "id,自增")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同id")
    private Integer dealId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "买方openId")
    private String buyOpenId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "买方userId")
    private String buyUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "卖方openId")
    private String sellOpenId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "卖方userId")
    private String sellUserId;

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
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * id,自增
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * id,自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 合同id
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     *
     * @mbggenerated
     * 合同id
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     *
     * @mbggenerated
     * 买方openId
     */
    public String getBuyOpenId() {
        return buyOpenId;
    }

    /**
     *
     * @mbggenerated
     * 买方openId
     */
    public void setBuyOpenId(String buyOpenId) {
        this.buyOpenId = buyOpenId;
    }

    /**
     *
     * @mbggenerated
     * 买方userId
     */
    public String getBuyUserId() {
        return buyUserId;
    }

    /**
     *
     * @mbggenerated
     * 买方userId
     */
    public void setBuyUserId(String buyUserId) {
        this.buyUserId = buyUserId;
    }

    /**
     *
     * @mbggenerated
     * 卖方openId
     */
    public String getSellOpenId() {
        return sellOpenId;
    }

    /**
     *
     * @mbggenerated
     * 卖方openId
     */
    public void setSellOpenId(String sellOpenId) {
        this.sellOpenId = sellOpenId;
    }

    /**
     *
     * @mbggenerated
     * 卖方userId
     */
    public String getSellUserId() {
        return sellUserId;
    }

    /**
     *
     * @mbggenerated
     * 卖方userId
     */
    public void setSellUserId(String sellUserId) {
        this.sellUserId = sellUserId;
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
     */
    public ErpFunDealShareUser() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunDealShareUser(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}