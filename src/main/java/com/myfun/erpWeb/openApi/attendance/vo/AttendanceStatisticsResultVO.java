package com.myfun.erpWeb.openApi.attendance.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AttendanceStatisticsResultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private List<ErpFunAttendanceStatisticsVO> result;

	public List<ErpFunAttendanceStatisticsVO> getResult() {
		return result;
	}

	public void setResult(List<ErpFunAttendanceStatisticsVO> result) {
		this.result = result;
	}
}