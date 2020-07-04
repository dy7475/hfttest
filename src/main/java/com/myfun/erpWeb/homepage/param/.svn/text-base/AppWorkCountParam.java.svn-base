package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class AppWorkCountParam implements EncryParamIfc {
	@ApiModelProperty(value = "时间类型，1=日统计 2=周统计")
	private  Integer dateType;
	@ApiModelProperty(value = "管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人")
	private  Integer rangeType;
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId）")
	private  Integer rangeId;
	@ApiModelProperty(value = "完成类型，1=完成量，2=完成率 3 =人均完成量 4=完成总量")
	private  Integer achievementType;
	@ApiModelProperty(value = "查看类型")
	private  Integer lookRankType;
	@ApiModelProperty(value = "用于区分房客源跟进，登记 1=房源，2=客源")
	private  Integer funCust;
	@ApiModelProperty(value = "查询分组的情况把deptId带上，其他情况不传")
	private  Integer deptId;
	@ApiModelProperty(value = "开始时间")
	private  String startDate;
	@ApiModelProperty(value = "结束时间")
	private  String endDate;

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public Integer getRangeId() {
		return rangeId;
	}

	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}

	public Integer getAchievementType() {
		return achievementType;
	}

	public void setAchievementType(Integer achievementType) {
		this.achievementType = achievementType;
	}

	public Integer getLookRankType() {
		return lookRankType;
	}

	public void setLookRankType(Integer lookRankType) {
		this.lookRankType = lookRankType;
	}

	public Integer getFunCust() {
		return funCust;
	}

	public void setFunCust(Integer funCust) {
		this.funCust = funCust;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
