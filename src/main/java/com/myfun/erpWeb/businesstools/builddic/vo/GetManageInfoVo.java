package com.myfun.erpWeb.businesstools.builddic.vo;

import com.myfun.repository.erpdb.dto.RoofInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class GetManageInfoVo {
    @ApiModelProperty("楼盘责任人")
    private Integer buildManager;
    @ApiModelProperty("栋座信息")
    private List<RoofInfoDto> roofInfos;

    public Integer getBuildManager() {
        return buildManager;
    }

    public void setBuildManager(Integer buildManager) {
        this.buildManager = buildManager;
    }

    public List<RoofInfoDto> getRoofInfos() {
        return roofInfos;
    }

    public void setRoofInfos(List<RoofInfoDto> roofInfos) {
        this.roofInfos = roofInfos;
    }
}
