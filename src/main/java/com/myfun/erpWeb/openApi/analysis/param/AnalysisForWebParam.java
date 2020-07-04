package com.myfun.erpWeb.openApi.analysis.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AnalysisForWebParam implements EncryParamIfc {
	@ApiModelProperty(value = "开始时间,例如：2018-08-01")
	private String startTime;
	@ApiModelProperty(value = "结束时间,例如：2018-08-31")
	private String endTime;

	@ApiModelProperty(value = "日期类型 SIGN_DATE=签约时间， DEAL_VERIFY_TIME=结算时间")
	private String dateType;
	@ApiModelProperty(value = "日期统计类型，0=日统计 1=周统计 2=月统计")
	private String dateCountType;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer cityId;

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

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getDateCountType() {
		return dateCountType;
	}

	public void setDateCountType(String dateCountType) {
		this.dateCountType = dateCountType;
	}
}
