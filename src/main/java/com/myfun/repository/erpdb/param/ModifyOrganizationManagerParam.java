package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class ModifyOrganizationManagerParam extends AbstractEncryParam implements DaoBaseParam{

	private Integer cityId;
	private Integer compId;
	private Integer organizationId;
	private String userIds;

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

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
}
