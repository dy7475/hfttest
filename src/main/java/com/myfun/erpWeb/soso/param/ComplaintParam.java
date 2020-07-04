package com.myfun.erpWeb.soso.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ComplaintParam extends AbstractEncryParam {
	@ApiModelProperty(value = "时间")
	private String time;
	@ApiModelProperty(value = "搜搜ID")
	private Integer sosoId;
	@ApiModelProperty(value = "重复房源ID")
	private Integer repeatId;
	@ApiModelProperty(value = "类型")
	private Integer complaintType;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getSosoId() {
		return sosoId;
	}

	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}

	public Integer getRepeatId() {
		return repeatId;
	}

	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}

	public Integer getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(Integer complaintType) {
		this.complaintType = complaintType;
	}
}
