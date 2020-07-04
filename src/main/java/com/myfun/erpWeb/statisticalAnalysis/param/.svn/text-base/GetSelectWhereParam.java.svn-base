package com.myfun.erpWeb.statisticalAnalysis.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

public class GetSelectWhereParam implements EncryParamIfc {

    @ApiModelProperty(value = "组织机构ID   (全公司：0)")
    private Integer organizationId;
    @ApiModelProperty(value = "员工字段名，默认USER_ID，但是有的不用USER_ID，比如是U_ID，就传U_ID进来,再比如需要查ARCHIVE_ID,该字段就传ARCHIVE_ID，userId字段就传archiveId")
    private String fileName = "USER_ID";
    @ApiModelProperty(value = "管理范围ID")
    private Integer userId;
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;
    @ApiModelProperty(value = "是否将userId更换为archiveId  true为是,默认为否")
    private Boolean change = false;
    @ApiModelProperty(value = "前缀")
    private String prefix;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Boolean getChange() {
        return change;
    }

    public void setChange(Boolean change) {
        this.change = change;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
