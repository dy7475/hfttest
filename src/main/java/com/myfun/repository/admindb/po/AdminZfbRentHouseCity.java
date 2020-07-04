package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminZfbRentHouseCity implements Serializable {
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
    private Integer cityId;

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
    @ApiModelProperty(value= "1开通 0未开通")
    private Byte cityStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String storeId;

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
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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
     * 1开通 0未开通
     */
    public Byte getCityStatus() {
        return cityStatus;
    }

    /**
     *
     * @mbggenerated
     * 1开通 0未开通
     */
    public void setCityStatus(Byte cityStatus) {
        this.cityStatus = cityStatus;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}