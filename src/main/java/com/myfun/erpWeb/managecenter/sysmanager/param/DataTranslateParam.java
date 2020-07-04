package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

/**
 * 数据移交参数
 * @author 张宏利
 * @since 2018年4月23日
 */
public class DataTranslateParam extends AbstractEncryParam{
	private String caseIds;// 移交的IDs
	private Integer caseType;// 房客源类型
	private String acceptUserId;// 接收人
	private Integer acceptDeptId;// 接收门店
	private String srcUserId;// 来源USER_ID
	private Integer srcDeptId;// 来源DEPT_ID
	private String transReson;
	private boolean isCustom; //
	private Integer currentUserId; //当前用户userId
	private String currentUserNamme; //当前用户名
	private String currentDeptName;
	private Integer compId; //当前公司
	private Integer cityId; //当前城市
	private Integer deptId; //当前分店
	public String getCaseIds() {
		return caseIds;
	}
	public void setCaseIds(String caseIds) {
		this.caseIds = caseIds;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public String getAcceptUserId() {
		return acceptUserId;
	}
	public void setAcceptUserId(String acceptUserId) {
		this.acceptUserId = acceptUserId;
	}
	public Integer getAcceptDeptId() {
		return acceptDeptId;
	}
	public void setAcceptDeptId(Integer acceptDeptId) {
		this.acceptDeptId = acceptDeptId;
	}
	public String getSrcUserId() {
		return srcUserId;
	}
	public void setSrcUserId(String srcUserId) {
		this.srcUserId = srcUserId;
	}
	public Integer getSrcDeptId() {
		return srcDeptId;
	}
	public void setSrcDeptId(Integer srcDeptId) {
		this.srcDeptId = srcDeptId;
	}

	public boolean isCustom() {
		return isCustom;
	}

	public void setCustom(boolean custom) {
		isCustom = custom;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getCurrentUserNamme() {
		return currentUserNamme;
	}

	public void setCurrentUserNamme(String currentUserNamme) {
		this.currentUserNamme = currentUserNamme;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getTransReson() {
		return transReson;
	}

	public void setTransReson(String transReson) {
		this.transReson = transReson;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCurrentDeptName() {
		return currentDeptName;
	}

	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
