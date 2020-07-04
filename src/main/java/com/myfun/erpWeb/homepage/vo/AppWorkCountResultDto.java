package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppWorkCountResultDto {
//	@ApiModelProperty(value = "#对应的范围ID")
//	private Integer rangeId;
//	@ApiModelProperty(value = "#范围类型")
//	private Integer rangeType;
//	@ApiModelProperty(value = "范围名字")
//	private String rangeName;
	@ApiModelProperty(value = "#完成量")
	private Integer count;
	@ApiModelProperty(value = "目标量")
	private Integer countT;
	@ApiModelProperty(value = "查看类型")
	private Integer lookRankType;
	@ApiModelProperty(value = "用于区分房客源，1为房源2为客源")
	private Integer funCust;
//	@ApiModelProperty(value = "参与人总数")
//	private Integer assessmentTotal;
//	@ApiModelProperty(value = "完成量总量排名")
//	private Integer achievementTotalRank;
//	@ApiModelProperty(value = "完成类型")
//	private Integer achievementType;
//	@ApiModelProperty(value = "完成量人均排名")
//	private double achievementPersonalRank;
//	@ApiModelProperty(value = "完成率")
//	private double completeRatio;
//	@ApiModelProperty(value = "人均占比")
//	private double personalRatio;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCountT() {
		return countT;
	}
	public void setCountT(Integer countT) {
		this.countT = countT;
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
}
