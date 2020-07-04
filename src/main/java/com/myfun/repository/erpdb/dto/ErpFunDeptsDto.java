package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunDeptsDto extends ErpFunDepts{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer agentNum;
	@ApiModelProperty(value = "片区名字")
	private String regionName;
	@ApiModelProperty(value = "大区名字")
	private String areaName;
	@ApiModelProperty(value = "总人数")
	private Integer countUser;
	@ApiModelProperty(value = "门店验证码")
	private String pwdDesc;
	@ApiModelProperty(value = "支持物业标记 0=不支持 1=支持 默认0")
	private Byte supportPropertyFlag;
	@ApiModelProperty(value = "门店店主")
	private String deptContact;
	@ApiModelProperty(value = "店主手机号")
	private String contactPhone;
	@ApiModelProperty(value = "物业版服务小区id")
	private Integer buildId;
	@ApiModelProperty(value = "物业版服务小区名称")
	private String buildName;
	@ApiModelProperty(value = "物业版服务小区管理员id(userId)")
	private Integer buildManager;
	
	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Integer getBuildManager() {
		return buildManager;
	}

	public void setBuildManager(Integer buildManager) {
		this.buildManager = buildManager;
	}

	public String getDeptContact() {
		return deptContact;
	}

	public void setDeptContact(String deptContact) {
		this.deptContact = deptContact;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Byte getSupportPropertyFlag() {
		return supportPropertyFlag;
	}

	public void setSupportPropertyFlag(Byte supportPropertyFlag) {
		this.supportPropertyFlag = supportPropertyFlag;
	}

	public String getPwdDesc() {
		return pwdDesc;
	}

	public void setPwdDesc(String pwdDesc) {
		this.pwdDesc = pwdDesc;
	}

	public Integer getCountUser() {
		return countUser;
	}

	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getAgentNum() {
		return agentNum;
	}

	public void setAgentNum(Integer agentNum) {
		this.agentNum = agentNum;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	
	
}
