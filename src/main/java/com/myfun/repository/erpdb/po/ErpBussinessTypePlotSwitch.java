package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpBussinessTypePlotSwitch extends ShardDb implements Serializable {
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
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte organizationBussinessType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte plotSwitch;

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
    public Byte getOrganizationBussinessType() {
        return organizationBussinessType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setOrganizationBussinessType(Byte organizationBussinessType) {
        this.organizationBussinessType = organizationBussinessType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getPlotSwitch() {
        return plotSwitch;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setPlotSwitch(Byte plotSwitch) {
        this.plotSwitch = plotSwitch;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpBussinessTypePlotSwitch() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpBussinessTypePlotSwitch(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}