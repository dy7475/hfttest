package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @create by 程二狗 on 2019/2/19 0019
 **/
@ApiModel
public class BuildListParam implements EncryParamIfc {
    @ApiModelProperty("商圈Id，多个逗号隔开")
    private String sectionId;
    @ApiModelProperty("区域Id")
    private Integer  regId;
    @ApiModelProperty("楼盘ID")
    private Integer  buildId;
    @ApiModelProperty("页码")
    private  Integer pageOffset = 1; // 1 第几页
    @ApiModelProperty("每页显示数量")
    private  Integer pageRows = 50; // 50 一页多少条

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

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

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
}
