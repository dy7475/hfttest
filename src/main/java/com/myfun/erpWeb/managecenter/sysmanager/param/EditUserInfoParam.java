package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class EditUserInfoParam extends ErpFunUsers implements EncryParamIfc {
	@ApiModelProperty("服务区域区域Id,以空格分隔")
	private String serviceReg;
	@ApiModelProperty("服务片区名,以空格分隔")
	private String serviceZone;
	@ApiModelProperty("服务片区Ids,以空格分隔")
	private String serviceZoneIds;
	@ApiModelProperty("服务片区Ids,以空格分隔")
	private Integer selfUserId;

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public String getServiceReg() {
		return serviceReg;
	}

	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg;
	}

	public String getServiceZone() {
		return serviceZone;
	}

	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}

	public String getServiceZoneIds() {
		return serviceZoneIds;
	}

	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds;
	}
}
