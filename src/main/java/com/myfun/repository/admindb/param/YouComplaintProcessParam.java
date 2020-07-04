package com.myfun.repository.admindb.param;

public class YouComplaintProcessParam {

	private Integer processResult;
	private Integer yptId;
	private String dealDesc;
	private Integer complaintId;
	private Integer cityId;
	private Integer isAddComplaintNu;

	public Integer getIsAddComplaintNu() {
		return isAddComplaintNu;
	}

	public void setIsAddComplaintNu(Integer isAddComplaintNu) {
		this.isAddComplaintNu = isAddComplaintNu;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProcessResult() {
		return processResult;
	}

	public void setProcessResult(Integer processResult) {
		this.processResult = processResult;
	}

	public Integer getYptId() {
		return yptId;
	}

	public void setYptId(Integer yptId) {
		this.yptId = yptId;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

}
