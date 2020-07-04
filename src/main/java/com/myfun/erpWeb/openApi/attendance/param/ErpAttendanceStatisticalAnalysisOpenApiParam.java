package com.myfun.erpWeb.openApi.attendance.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpAttendanceStatisticalAnalysisOpenApiParam extends AbstractEncryParam {

	@ApiModelProperty(value = "城市Id", required = true)
    private Integer cityId;
	
	@ApiModelProperty(value = "公司编号", required = true)
    private String compNo;
	
	@ApiModelProperty(value = "公司Id", hidden = true)
	private Integer compId;
	
	@ApiModelProperty("4=考勤明细")
    private Byte countType;
	
	@ApiModelProperty(value = "时间段", required = true)
    private String attDate;
	
	@ApiModelProperty(value = "开始时间", hidden = true)
    private String startTime;
	
	@ApiModelProperty(value = "开始时间", hidden = true)
    private String endTime;
	
	@ApiModelProperty(value = "查询范围	USER员工	GROUP分组	DEPT门店	REG片区	AREA大区	COMP公司", required = true)
    private String searchRange;
	
	@ApiModelProperty(value = "查询范围ID", required = true)
    private Integer searchRangeId;
	
	@ApiModelProperty("等级 1公司 2大区 3片区 4门店 5分组 6用户")
	private Byte level;
	

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
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

	public String getAttDate() {
		return attDate;
	}

	public void setAttDate(String attDate) {
		this.attDate = attDate;
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

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}
}