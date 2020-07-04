package com.myfun.repository.admindb.param;


import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeDataParam 
* @Description:部门调迁查询参数
* @author tangliang1
* @date 2020年6月24日 下午3:11:57 
*
 */
@ApiModel
public class Admin_Sync_OA_ML_DepartmentChangeDataParam extends AbstractEncryParam {
	
	// 对应好房通中的组织id（从组织列表获取，在同步组织树表中的对应的 organizationId）
	private Integer organizationId;
	
	// 查询日期类型：1、生效日期，2、失效日期
	private int queryDateType;
	
	private String queryBeginTime;
	
	private String queryEndTime;

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
	
}
