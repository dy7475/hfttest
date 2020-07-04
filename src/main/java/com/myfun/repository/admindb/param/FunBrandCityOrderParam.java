package com.myfun.repository.admindb.param;

import com.myfun.repository.support.param.PageParam;

public class FunBrandCityOrderParam extends PageParam {
	private Integer cityId;
	private Integer proviceId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getProviceId() {
		return proviceId;
	}

	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

}
