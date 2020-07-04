package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
@ApiModel
public class CreateOrUpdateAttendanceParam  implements EncryParamIfc {
	@ApiModelProperty(hidden = true)
	private Integer compId;//业务层需要使用当前用户所在公司
	@ApiModelProperty(hidden = true)
	private Integer cityId;//切库所需要使用的城市ID
	@ApiModelProperty(hidden = true)
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	@ApiModelProperty(hidden = true)
	private Integer currentUserId;//业务层需要使用当前用户Id
	@ApiModelProperty(hidden = true)
	private String userName;//业务层需要使用当前用户名称
	@ApiModelProperty(hidden = true)
	private String currentDeptName;//业务层需要使用当前用户名称
	@ApiModelProperty(hidden = true)
	private Integer currentDeptId;//当前用户所在门店ID
	@ApiModelProperty("上下班签到说明")
	private String attLateReason;//上下班签到说明
	@ApiModelProperty("签到员工")
	private Integer attUser;//签到员工
	@NotBlank
	@ApiModelProperty("登录密码")
	private String loginPassword;//登录密码
	@ApiModelProperty("班别")
	private String workType;//工作类型
	private String lateTimeSkip;
	@ApiModelProperty("门店ID")
	private Integer deptId;
	@ApiModelProperty("上班时间")
	private String onTime;
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentDeptName() {
		return currentDeptName;
	}
	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	public String getAttLateReason() {
		return attLateReason;
	}
	public void setAttLateReason(String attLateReason) {
		this.attLateReason = attLateReason;
	}
	public Integer getAttUser() {
		return attUser;
	}
	public void setAttUser(Integer attUser) {
		this.attUser = attUser;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getLateTimeSkip() {
		return lateTimeSkip;
	}
	public void setLateTimeSkip(String lateTimeSkip) {
		this.lateTimeSkip = lateTimeSkip;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getOnTime() {
		return onTime;
	}
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	
	
}
