package com.myfun.repository.admindb.param;

import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;

/**
 * 
* @ClassName: UserTransferVo 
* @Description: 同步HRS人员调迁查询参数
* @author tangliang1
* @date 2020年6月29日 下午4:29:00 
*
 */
public class Admin_Sync_OA_ML_UserChangeDataParam extends AbstractEncryParam  {
	
	private Integer hftUserId;
	
	// 对应好房通中的组织id（从组织列表获取，在同步组织树表中的对应的 organizationId）
	private Integer organizationId;
	
	// 查询日期类型：1、生效日期，2、失效日期
	private int queryDateType;
	
	private String queryBeginTime;
	
	private String queryEndTime;
	
	//异动类型代码
	private String typeCode;
	
	//异动事件代码
	private String changeId;

	public Integer getHftUserId() {
		return hftUserId;
	}

	public void setHftUserId(Integer hftUserId) {
		this.hftUserId = hftUserId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public int getQueryDateType() {
		return queryDateType;
	}

	public void setQueryDateType(int queryDateType) {
		this.queryDateType = queryDateType;
	}

	public String getQueryBeginTime() {
		return queryBeginTime;
	}

	public void setQueryBeginTime(String queryBeginTime) {
		this.queryBeginTime = queryBeginTime;
	}

	public String getQueryEndTime() {
		return queryEndTime;
	}

	public void setQueryEndTime(String queryEndTime) {
		this.queryEndTime = queryEndTime;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}
	
}