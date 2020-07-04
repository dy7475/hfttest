package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModelProperty;

public class SubwayVO {
    /**
     *
     * @mbggenerated
    地铁ID
     */
    @ApiModelProperty("地铁ID")
    private Integer swId;

    /**
     *
     * @mbggenerated
    城市ID
     */
    @ApiModelProperty("城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
    地铁名称
     */
    @ApiModelProperty("地铁名称")
    private String swName;

    /**
     *
     * @mbggenerated
    序号
     */
    @ApiModelProperty("序号")
    private Integer seqNo;

    public Integer getSwId() {
        return swId;
    }

    public void setSwId(Integer swId) {
        this.swId = swId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getSwName() {
        return swName;
    }

    public void setSwName(String swName) {
        this.swName = swName;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}
