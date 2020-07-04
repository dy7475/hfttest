package com.myfun.service.business.erpdb.bean.param;

import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class AccountTypeParam extends AbstractEncryParam implements DaoBaseParam{
	
	private Integer atId;
	private Integer compId;
	private String atNo;
	private String atName;
	private Integer deptId;
	private Integer auditor;
	private Integer charger;
	private Integer creatorUid;
	private Date creationTime;
	private Integer cityId;
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getAtId() {
		return atId;
	}
	public void setAtId(Integer atId) {
		this.atId = atId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public String getAtNo() {
		return atNo;
	}
	public void setAtNo(String atNo) {
		this.atNo = atNo;
	}
	public String getAtName() {
		return atName;
	}
	public void setAtName(String atName) {
		this.atName = atName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getAuditor() {
		return auditor;
	}
	public void setAuditor(Integer auditor) {
		this.auditor = auditor;
	}
	public Integer getCharger() {
		return charger;
	}
	public void setCharger(Integer charger) {
		this.charger = charger;
	}
	public Integer getCreatorUid() {
		return creatorUid;
	}
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	

}
