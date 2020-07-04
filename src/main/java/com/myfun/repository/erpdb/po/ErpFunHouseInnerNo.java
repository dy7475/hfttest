package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunHouseInnerNo extends ShardDb implements Serializable {
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
    private Integer houseAddNo;

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
    public Integer getHouseAddNo() {
        return houseAddNo;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setHouseAddNo(Integer houseAddNo) {
        this.houseAddNo = houseAddNo;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunHouseInnerNo() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunHouseInnerNo(Integer shardCityId, Integer compId) {
        super(shardCityId);
        this.compId = compId;
    }
}