package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveMonthStatisticsRankParam extends AbstractEncryParam {

	@ApiModelProperty(value = "管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人", required = true)
	private  Integer rangeType;
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId,多个Id,用逗号隔开）", required = true)
	private  String rangeIds;
	@ApiModelProperty(value = "查询分组的情况把deptId带上，其他情况不传")
	private  Integer deptId;
	@ApiModelProperty(value = "月统计时间。如:2018-08-01", required = true)
	private  String assessmentMonth;
	@ApiModelProperty(value = "1=业绩2=房增3=客增4=带看5=钥匙6=房勘")
	private  Integer assessmentType;
	@ApiModelProperty(value = "2=按大区3=按片区4=按门店5=按分组6按员工")
	private Integer lookType;
	@ApiModelProperty(value = "房基地查询范围，1=全公司，2=我的团队")
	private  Integer fjdRangeType;


	@ApiModelProperty(value = "层级主键ID   (员工:-2)")
	private Integer defId;

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}


	public Integer getLookType() {
		return lookType;
	}
	public void setLookType(Integer lookType) {
		this.lookType = lookType;
	}
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public String getRangeIds() {
		return rangeIds;
	}
	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getAssessmentMonth() {
		return assessmentMonth;
	}
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}
	public Integer getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(Integer assessmentType) {
		this.assessmentType = assessmentType;
	}
	public Integer getFjdRangeType() {
		return fjdRangeType;
	}
	public void setFjdRangeType(Integer fjdRangeType) {
		this.fjdRangeType = fjdRangeType;
	}
}
