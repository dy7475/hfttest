package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;

/**
 * 修改房源的楼盘参数
 * @author 张宏利
 * @since 2017年8月23日
 */
public class ErpUpdateHouseBuildParam implements EncryParamIfc{
	private Integer caseId;// 房源ID
	private String caseNo;// 房源编号
	private Integer caseType;// 房源类型
	private Integer buildId;// 需要更新成的楼盘ID
	private String buildName;// 需要更新成的楼盘名称
	private String reasons;// 修改原因
	private Integer caseDeptId;// 房源门店ID
	private Integer caseUserId;// 房源用户ID
	private Integer caseStatus;// 房源状态
	private String oldBuildName;// 之前的楼盘名
	
	private Integer cityId;// 城市ID
	private Integer compId;// 公司ID
	private Integer deptId;// 门店ID
	private Integer userId;// 当前用户ID
	private String deptUserName;// 门店和用户名
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
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
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDeptUserName() {
		return deptUserName;
	}
	public void setDeptUserName(String deptUserName) {
		this.deptUserName = deptUserName;
	}
	public Integer getCaseDeptId() {
		return caseDeptId;
	}
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}
	public Integer getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}
	public Integer getCaseUserId() {
		return caseUserId;
	}
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	public String getOldBuildName() {
		return oldBuildName;
	}
	public void setOldBuildName(String oldBuildName) {
		this.oldBuildName = oldBuildName;
	}
	
}
