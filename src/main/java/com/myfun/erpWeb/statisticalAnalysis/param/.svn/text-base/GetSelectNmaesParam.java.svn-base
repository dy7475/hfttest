package com.myfun.erpWeb.statisticalAnalysis.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

public class GetSelectNmaesParam implements EncryParamIfc {

    @ApiModelProperty(value = "组织架构定义表主键ID", example = "1")
    private Integer defId;
    @ApiModelProperty(value = "erp公司ID", example = "12001",required = true)
    private Integer compId;
    @ApiModelProperty(value = "城市ID", example = "1",required = true)
    private Integer cityId;
    @ApiModelProperty(value = "若defId为-2，需要在结果集后面加的字段名", example = "USER_ID")
    private String selectName = "USER_ID";

    @ApiModelProperty(value = "组织机构层级", hidden = true)
    private Integer level = -1;

    @ApiModelProperty(value = "是否将所有group字段以下划线连接")
    private Integer hasGroupAll = 1;

    public Integer getHasGroupAll() {
        return hasGroupAll;
    }

    public void setHasGroupAll(Integer hasGroupAll) {
        this.hasGroupAll = hasGroupAll;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDefId() {
        return defId;
    }

    public void setDefId(Integer defId) {
        this.defId = defId;
    }
}
