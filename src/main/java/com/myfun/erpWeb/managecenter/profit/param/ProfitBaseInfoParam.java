package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProfitBaseInfoParam extends AbstractEncryParam {
    @ApiModelProperty(value = "开始日期")
    private String date1;
    @ApiModelProperty(value = "结束日期")
    private String date2;
    @ApiModelProperty(value = "状态")
    private Integer dealStatus;
    @ApiModelProperty(value = "类型")
    private Integer dealType;
    @ApiModelProperty(value = "部门ID")
    private Integer deptId;
    private Integer pageOffset;
    private Integer pageRows;
    private Integer sourceDeptId;
    @ApiModelProperty(value = "大区ID")
    private Integer areaId;
    @ApiModelProperty(value = "片区ID")
    private Integer regId;
    @ApiModelProperty(value = "分组ID")
    private Integer grId;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;
    @ApiModelProperty(value = "公司ID")
    private Integer compId;
    
    @ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean isNewOrganization;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;


    public Boolean getIsNewOrganization() {
		return isNewOrganization;
	}

	public void setIsNewOrganization(Boolean isNewOrganization) {
		this.isNewOrganization = isNewOrganization;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public Integer getPageOffset() {
        return pageOffset;
    }

    @Override
    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    @Override
    public Integer getPageRows() {
        return pageRows;
    }

    @Override
    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public Integer getSourceDeptId() {
        return sourceDeptId;
    }

    public void setSourceDeptId(Integer sourceDeptId) {
        this.sourceDeptId = sourceDeptId;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
