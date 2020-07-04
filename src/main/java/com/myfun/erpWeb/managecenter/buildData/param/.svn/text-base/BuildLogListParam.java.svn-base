package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @create by 程二狗 on 2019/2/21 0021
 **/
@ApiModel
public class BuildLogListParam implements EncryParamIfc {
    @ApiModelProperty("楼盘Id")
    private  Integer buildId;
    @ApiModelProperty("开始时间")
    private  String startTime;
    @ApiModelProperty("结束时间")
    private  String endTime;
    @ApiModelProperty("页码")
    private  Integer pageOffset = 1; // 1 第几页
    @ApiModelProperty("每页显示数量")
    private  Integer pageRows = 50; // 50 一页多少条

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
