package com.myfun.erpWeb.managecenter.profit.param;


import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取员工薪资列表
 * 筛选条件(部门 、 员工 、 月份 、 角色 ）请求参数封装
 * create by 程二狗 on 2018/11/16 0016
 */
@ApiModel
public class FunWageListParam implements EncryParamIfc {
    @ApiModelProperty(value = "角色ID")
    private String roleId;
    @ApiModelProperty(value = "职级ID，格式：1,2,3,4,5")
    private String roleLevelId;
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    @ApiModelProperty(value = "薪资ID")
    private Integer wageId;
    @ApiModelProperty(value = "公司ID",hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "结算月",required = true)
    private String assessmentMonth;
    @ApiModelProperty("开始日期")
    private String date1;
    @ApiModelProperty("结束日期")
    private String date2;
    @ApiModelProperty("大区Id")
    private Integer areaId;
    @ApiModelProperty("片区Id")
    private Integer regId;
    @ApiModelProperty("部门Id")
    private Integer deptId;
    @ApiModelProperty("分组Id")
    private Integer grId;
    @ApiModelProperty("页码")
    private Integer pageOffset =  Const.CURRENT_PAGE; // 1 第几页
    @ApiModelProperty("每页显示数量")
    private Integer pageRows = Const.PAGE_NUMBER;// 50 一页多少条
    @ApiModelProperty("是否导出")
    private Integer isExport = 0;
    @ApiModelProperty(value = "是否要统计数量",hidden = true)
    private Boolean isNeedCount;
    
    @ApiModelProperty(value = "权限范围 0=本人 1=下级所有 2= 本人团队[仅房基地才传]")
    private Integer operLevel;
    @ApiModelProperty(value = "用户成级",hidden = true)
    private Integer userLevel;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;
    @ApiModelProperty(value = "是否新组织机构",hidden = true)
    private boolean newOrganization = false;


    public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(Integer operLevel) {
		this.operLevel = operLevel;
	}

	public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public Boolean getNeedCount() {
        return getPageOffset() == 1;
    }

    public void setNeedCount(Boolean needCount) {
        isNeedCount = needCount;
    }

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
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

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWageId() {
        return wageId;
    }

    public void setWageId(Integer wageId) {
        this.wageId = wageId;
    }

	public String getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(String roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	public Boolean getIsNeedCount() {
		return isNeedCount;
	}

	public void setIsNeedCount(Boolean isNeedCount) {
		this.isNeedCount = isNeedCount;
	}

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public boolean isNewOrganization() {
        return newOrganization;
    }

    public void setNewOrganization(boolean newOrganization) {
        this.newOrganization = newOrganization;
    }
}
