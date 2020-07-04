package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunStreetInSection extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键自增")
    private Integer id;

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
    @ApiModelProperty(value= "街道商圈表ID")
    private Integer streetSectionId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "街道表ID, 一个街道关联多个商圈")
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
     * 主键自增
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键自增
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 街道商圈表ID
     */
    public Integer getStreetSectionId() {
        return streetSectionId;
    }

    /**
     *
     * @mbggenerated
     * 街道商圈表ID
     */
    public void setStreetSectionId(Integer streetSectionId) {
        this.streetSectionId = streetSectionId;
    }

    /**
     *
     * @mbggenerated
     * 街道表ID, 一个街道关联多个商圈
     */
    public Integer getStreetId() {
        return streetId;
    }

    /**
     *
     * @mbggenerated
     * 街道表ID, 一个街道关联多个商圈
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
    public ErpFunStreetInSection() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunStreetInSection(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}