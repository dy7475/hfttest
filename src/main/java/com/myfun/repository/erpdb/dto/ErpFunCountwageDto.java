package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunWage;
import com.myfun.repository.erpdb.po.ErpFunWageType;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ErpFunCountwageDto implements Serializable {
	private ErpFunWageType funWageType;
	private ErpFunWageTypeNew funWageTypeNew;
	private List<ErpFunCountwage> funCountwageList;

	public ErpFunWageType getFunWageType() {
		return funWageType;
	}

	public void setFunWageType(ErpFunWageType funWageType) {
		this.funWageType = funWageType;
	}

	public ErpFunWageTypeNew getFunWageTypeNew() {
		return funWageTypeNew;
	}

	public void setFunWageTypeNew(ErpFunWageTypeNew funWageTypeNew) {
		this.funWageTypeNew = funWageTypeNew;
	}

	public List<ErpFunCountwage> getFunCountwageList() {
		return funCountwageList;
	}

	public void setFunCountwageList(List<ErpFunCountwage> funCountwageList) {
		this.funCountwageList = funCountwageList;
	}
}
