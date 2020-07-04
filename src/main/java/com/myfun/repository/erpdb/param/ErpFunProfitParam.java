package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ErpFunProfitParam extends AbstractEncryParam implements DaoBaseParam{

	private Integer compId;
	private String startTime;
	private String endTime;
	private Set<Integer> rangIds;
	private Integer rangeType;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Set<Integer> getRangIds() {
		return rangIds;
	}

	public void setRangIds(Set<Integer> rangIds) {
		this.rangIds = rangIds;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
}
