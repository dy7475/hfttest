package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class QueryPartnerDeptParam extends AbstractEncryParam {

	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private String compNo;
	@ApiModelProperty(value = "加盟商id")
	private Integer partnerId;
	@ApiModelProperty(value = "经营模式：0.直营，1.加盟")
	private Integer partnerType;
	@ApiModelProperty(value = "到期时间",hidden = true)
	private String dueDate;
	@ApiModelProperty(value = "到期时间范围开始")
	private String startTime;
	@ApiModelProperty(value = "到期时间范围结束")
	private String endTime;
	@ApiModelProperty("时间内有效")
	private String availableTime;
	@ApiModelProperty(hidden = true)
	private List<String> deptNos;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public List<String> getDeptNos() {
		return deptNos;
	}

	public void setDeptNos(List<String> deptNos) {
		this.deptNos = deptNos;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
