package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class FunDeptsParam extends ErpFunDepts implements EncryParamIfc {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(hidden = true)
	private Integer selfUserId; // 自己的userIds
	@ApiModelProperty(hidden = true)
	private Integer cityId; // 城市Id
	@ApiModelProperty(hidden = true)
	private String selfCompNo; // 自己公司的COMP_NO
	@ApiModelProperty("物业版项目管理员userId")
	private Integer propertyManagerUserId;
	@ApiModelProperty(value = "跟进人姓名",hidden = true)
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getSelfCompNo() {
		return selfCompNo;
	}

	public void setSelfCompNo(String selfCompNo) {
		this.selfCompNo = selfCompNo;
	}

	public Integer getPropertyManagerUserId() {
		return propertyManagerUserId;
	}

	public void setPropertyManagerUserId(Integer propertyManagerUserId) {
		this.propertyManagerUserId = propertyManagerUserId;
	}
}
