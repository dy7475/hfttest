package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class updateDealFunEarbestParam implements EncryParamIfc {
	@ApiModelProperty(value = "诚意金状态")
	private Byte status;
	@ApiModelProperty(value = "诚意金ID")
	private Integer earbestId;
	@ApiModelProperty(value = "退款说明")
	private String refundExplain;
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "合同编号")
	private String dealNo;

	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private String deptName;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private String userName;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getRefundExplain() {
		return refundExplain;
	}

	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getEarbestId() {
		return earbestId;
	}

	public void setEarbestId(Integer earbestId) {
		this.earbestId = earbestId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}
