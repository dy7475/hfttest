package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 展开奖罚下拉列表
 * 请求参数封装
 * create by 程二狗 on 2018/11/17 0017
 */
@ApiModel
public class RewardPunishmentDetailListParam implements EncryParamIfc {
    @ApiModelProperty("结算月份")
    private String occMonth;
    @ApiModelProperty(" 奖罚类别 1=奖励 2=罚款")
    private Integer rewardPunishmentType;
    @ApiModelProperty("薪资人的ID")
    private Integer userId;
    @ApiModelProperty("公司ID")
    private Integer compId;
    @ApiModelProperty("大区ID")
    private Integer areaId;
    @ApiModelProperty("片区ID")
    private Integer regId;
    @ApiModelProperty("门店ID")
    private Integer deptId;
    @ApiModelProperty("分组ID")
    private Integer grId;
    @ApiModelProperty("奖惩类别Id")
    private Integer rewardPunishmentClass;
    @ApiModelProperty("时间类型")
    private Integer timeType;

    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty("页码")
    private Integer pageOffset =  Const.CURRENT_PAGE; // 1 第几页
    @ApiModelProperty("每页显示数量")
    private Integer pageRows = Const.PAGE_NUMBER;// 50 一页多少条
    @ApiModelProperty("是否导出")
    private Integer isExport = 0;
    @ApiModelProperty(value = "是否要统计数量",hidden = true)
    private Boolean needCoun;
    @ApiModelProperty("开始时间")
    private Date startTimeDate;
    @ApiModelProperty("结束时间")
    private Date endTimeDate;

    @ApiModelProperty(hidden = true)
    @DefaultValue(value = "false")
    private Boolean newOrganization;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;


	public Boolean getNewOrganization() {
	
		return newOrganization;
	}

	public void setNewOrganization(Boolean newOrganization) {
	
		this.newOrganization = newOrganization;
	}

	public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}

	public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public Boolean getNeedCoun() {
        return getPageOffset() == 1;
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

    public Integer getRewardPunishmentClass() {
        return rewardPunishmentClass;
    }

    public void setRewardPunishmentClass(Integer rewardPunishmentClass) {
        this.rewardPunishmentClass = rewardPunishmentClass;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public void setNeedCoun(Boolean needCoun) {
        this.needCoun = needCoun;
    }

    public String getOccMonth() {
        return occMonth;
    }

    public void setOccMonth(String occMonth) {
        this.occMonth = occMonth;
    }

    public Integer getRewardPunishmentType() {
        return rewardPunishmentType;
    }

    public void setRewardPunishmentType(Integer rewardPunishmentType) {
        this.rewardPunishmentType = rewardPunishmentType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTimeDate() {
        return startTimeDate;
    }

    public void setStartTimeDate(Date startTimeDate) {
        this.startTimeDate = startTimeDate;
    }

    public Date getEndTimeDate() {
        return endTimeDate;
    }

    public void setEndTimeDate(Date endTimeDate) {
        this.endTimeDate = endTimeDate;
    }
}
