package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserListInfoParam extends AbstractEncryParam {
	
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	@ApiModelProperty(value = "查询关键字(现在只支持姓名查询)id")
	private String  keyWord;
	@ApiModelProperty(value = "是否需要返回权限列表，是=1，否=0")
	private Integer  isNeedOpers;
	@ApiModelProperty(value = "是否需要返回员工异动情况，默认返回，传0不返回")
	private Integer  isNeedUserLog;
	@ApiModelProperty(value = "是否需要返回角色名和门店名，是=1，否=0")
	private Integer  isNeedRoleAndDeptName;
	@ApiModelProperty(value = "1=按姓名2=按角色3=按入职时间4=按离职时间5=按员工状态")
	private Integer sortType;
	@ApiModelProperty(value = "首字母，传对应的字母，#就传#")
	private String headCharacter;
	@ApiModelProperty(value = "排序方式,DESC降序,ASC升序")
	private String orderBy;
	@ApiModelProperty(value = "员工状态，1为离职，0为在职（默认在职）")
	private Integer userWriteoff;
	@ApiModelProperty(value = "全员档案标记,1是0否")
	private Integer allUsersFlag;
	@ApiModelProperty(value = "1=是导出，0不是", hidden = true)
	private Byte isExport;
	@ApiModelProperty(value = "角色id")
	private String roleId;
	@ApiModelProperty(value = "无推荐人")
	private String notInviteRole;
	@ApiModelProperty(value = "员工id")
	private Integer userId;
	@ApiModelProperty(value = "查询该员工团队所有人标记(和userId一起传的) 1=查询")
	private Integer teamUserFlag;
	@ApiModelProperty(value = "新版组织架构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "是否是新版组织架构", hidden = true)
	private Boolean newOrganization = false;

	public Boolean getNewOrganization() {
		return newOrganization;
	}

	public void setNewOrganization(Boolean newOrganization) {
		this.newOrganization = newOrganization;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUserId() {
	
		return userId;
	}

	public void setUserId(Integer userId) {
	
		this.userId = userId;
	}

	public Integer getTeamUserFlag() {
	
		return teamUserFlag;
	}

	public void setTeamUserFlag(Integer teamUserFlag) {
	
		this.teamUserFlag = teamUserFlag;
	}

	public String getNotInviteRole() {
	
		return notInviteRole;
	}

	public void setNotInviteRole(String notInviteRole) {
	
		this.notInviteRole = notInviteRole;
	}

	public String getRoleId() {
	
		return roleId;
	}

	public void setRoleId(String roleId) {
	
		this.roleId = roleId;
	}

	public Integer getAllUsersFlag() {
		return allUsersFlag;
	}

	public void setAllUsersFlag(Integer allUsersFlag) {
		this.allUsersFlag = allUsersFlag;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public Integer getUserWriteoff() {
		return userWriteoff;
	}

	public void setUserWriteoff(Integer userWriteoff) {
		this.userWriteoff = userWriteoff;
	}

	public String getHeadCharacter() {
		return headCharacter;
	}

	public void setHeadCharacter(String headCharacter) {
		this.headCharacter = headCharacter;
	}

	public Integer getSortType() {
		return sortType;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}

	public Integer getIsNeedUserLog() {
		return isNeedUserLog;
	}

	public void setIsNeedUserLog(Integer isNeedUserLog) {
		this.isNeedUserLog = isNeedUserLog;
	}

	public Integer getIsNeedRoleAndDeptName() {
		return isNeedRoleAndDeptName;
	}

	public void setIsNeedRoleAndDeptName(Integer isNeedRoleAndDeptName) {
		this.isNeedRoleAndDeptName = isNeedRoleAndDeptName;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getIsNeedOpers() {
		return isNeedOpers;
	}

	public void setIsNeedOpers(Integer isNeedOpers) {
		this.isNeedOpers = isNeedOpers;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}
}