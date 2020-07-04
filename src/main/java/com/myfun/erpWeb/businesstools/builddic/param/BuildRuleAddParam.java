package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/3/20
 */
public class BuildRuleAddParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty("责任人用户ID(楼盘管理人)")
    private Integer buildingManagerId;

    @ApiModelProperty(value = "栋别名(默认:栋)")
    private String buildRoofName;

    @ApiModelProperty("栋座列表")
    private List<RoofAddParam> roofs;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
    }

    public String getBuildRoofName() {
        return buildRoofName;
    }

    public void setBuildRoofName(String buildRoofName) {
        this.buildRoofName = buildRoofName;
    }

    public List<RoofAddParam> getRoofs() {
        return roofs;
    }

    public void setRoofs(List<RoofAddParam> roofs) {
        this.roofs = roofs;
    }
}