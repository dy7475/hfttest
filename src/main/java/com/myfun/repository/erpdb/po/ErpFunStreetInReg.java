package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunStreetInReg extends ShardDb implements Serializable {
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
    private Integer streetRegId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer streetId;

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
    @ApiModelProperty(value= "null")
    private Byte isDel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer delUserId;

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
    public Integer getStreetRegId() {
        return streetRegId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setStreetRegId(Integer streetRegId) {
        this.streetRegId = streetRegId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getStreetId() {
        return streetId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
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
    public Integer getDelUserId() {
        return delUserId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setDelUserId(Integer delUserId) {
        this.delUserId = delUserId;
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
     */
    public ErpFunStreetInReg() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunStreetInReg(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}