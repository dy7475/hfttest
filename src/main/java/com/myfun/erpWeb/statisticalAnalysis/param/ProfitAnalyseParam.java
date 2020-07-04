package com.myfun.erpWeb.statisticalAnalysis.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProfitAnalyseParam  extends AbstractEncryParam {
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "查询范围")
	private String serchRange;
	@ApiModelProperty(value = "选择年份")
	private Integer year;
	@ApiModelProperty(hidden = true)
	private String startTime;
	@ApiModelProperty(hidden = true)
	private String endTime;
	@ApiModelProperty(value = "0=应收 1=实收")
	private Integer pfActual;
	@ApiModelProperty(value = "查询范围ID")
	private Integer serchRangeId;
	@ApiModelProperty(value = "MONTH 月份 QUARTER 季度")
	private String dateRange;
	@ApiModelProperty(value = "1=套数 2=金额")
	private Integer dataType;
	@ApiModelProperty(hidden = true)
	private String sumStr;
	@ApiModelProperty(hidden = true)
	private String columnStr;
	@ApiModelProperty(value = "日期类型 SIGN_DATE签约日期DEAL_VERIFY_TIME结算日期")
	private String dateType;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getSerchRange() {
		return serchRange;
	}

	public void setSerchRange(String serchRange) {
		this.serchRange = serchRange;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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

	public Integer getPfActual() {
		return pfActual;
	}

	public void setPfActual(Integer pfActual) {
		this.pfActual = pfActual;
	}

	public Integer getSerchRangeId() {
		return serchRangeId;
	}

	public void setSerchRangeId(Integer serchRangeId) {
		this.serchRangeId = serchRangeId;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getSumStr() {
		return sumStr;
	}

	public void setSumStr(String sumStr) {
		this.sumStr = sumStr;
	}

	public String getColumnStr() {
		return columnStr;
	}

	public void setColumnStr(String columnStr) {
		this.columnStr = columnStr;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
}
