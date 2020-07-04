package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpAttendanceStatisticalAnalysisParam extends AbstractEncryParam{
	/** 0代表每日考勤 1代表每月考勤**/
	@ApiModelProperty("4=考勤明细")
    private Byte countType;
    /** 开始时间 **/
	@ApiModelProperty("时间段")
    private String attDate;
    /** 开始时间 **/
	@ApiModelProperty(value = "开始时间",hidden = true)
    private String startTime;
    /** 结束时间 **/
	@ApiModelProperty(value = "开始时间",hidden = true)
    private String endTime;
    /** 查询范围 USER员工 GROUP 分组 DEPT门店 REG片区 AREA 大区 COMP 公司**/
	@ApiModelProperty("查询范围 USER员工 GROUP 分组 DEPT门店 REG片区 AREA 大区 COMP 公司")
    private String searchRange;
    /** 查询范围ID**/
	@ApiModelProperty(value = "查询范围ID")
    private Integer searchRangeId;
    /** 是否显示异常情况 1 显示 2不显示**/
	@ApiModelProperty("是否显示异常情况 1 显示 2不显示")
    private String attResults;
	@ApiModelProperty("是否导出 1导出")
	private Byte isExport;
    //当前账号人信息
	@ApiModelProperty(value = "公司Id",hidden = true)
    private Integer compId;//公司Id
	@ApiModelProperty(value = "开始时间",hidden = true)
    private Integer cityId;//城市Id
	@ApiModelProperty("等级 1公司 2大区 3片区 4门店 5分组 6用户")
	private Byte level;
	@ApiModelProperty("组织ID")
	private Integer organizationId;
	@ApiModelProperty("员工ID")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public String getAttDate() {
		return attDate;
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public String getAttResults() {
		return attResults;
	}
	public void setAttResults(String attResults) {
		this.attResults = attResults;
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
	public Byte getCountType() {
		return countType;
	}
	public void setCountType(Byte countType) {
		this.countType = countType;
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
	public String getSearchRange() {
		return searchRange;
	}
	public void setSearchRange(String searchRange) {
		this.searchRange = searchRange;
	}
	public Integer getSearchRangeId() {
		return searchRangeId;
	}
	public void setSearchRangeId(Integer searchRangeId) {
		this.searchRangeId = searchRangeId;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
}
