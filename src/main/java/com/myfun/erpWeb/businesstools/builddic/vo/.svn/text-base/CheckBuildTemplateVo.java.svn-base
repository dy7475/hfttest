package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/3
 */
public class CheckBuildTemplateVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否有楼盘规则 0=没有规则 1=有规则")
    private Integer haveBuildRule;

    @ApiModelProperty(value = "是否有模板信息(0没有模板, 1有模板)")
    private Integer haveBuildTemplate;

    @ApiModelProperty("是否锁定，0=未锁定 1=锁定")
    private Integer buildLock = 0;

    @ApiModelProperty("责任人用户ID")
    private Integer buildingManagerId;

    public Integer getHaveBuildRule() {
        return haveBuildRule;
    }

    public void setHaveBuildRule(Integer haveBuildRule) {
        this.haveBuildRule = haveBuildRule;
    }

    public Integer getHaveBuildTemplate() {
        return haveBuildTemplate;
    }

    public void setHaveBuildTemplate(Integer haveBuildTemplate) {
        this.haveBuildTemplate = haveBuildTemplate;
    }

    public Integer getBuildLock() {
        return buildLock;
    }

    public void setBuildLock(Integer buildLock) {
        this.buildLock = buildLock;
    }

    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
    }
}