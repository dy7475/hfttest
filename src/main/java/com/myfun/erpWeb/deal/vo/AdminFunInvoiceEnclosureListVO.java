package com.myfun.erpWeb.deal.vo;

import java.io.Serializable;
import java.util.List;

import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;

import io.swagger.annotations.ApiModelProperty;

public class AdminFunInvoiceEnclosureListVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("图片集合")
	private List<AdminFunInvoiceEnclosure> 	adminFunInvoiceEnclosureList;

	public List<AdminFunInvoiceEnclosure> getAdminFunInvoiceEnclosureList() {
		return adminFunInvoiceEnclosureList;
	}

	public void setAdminFunInvoiceEnclosureList(List<AdminFunInvoiceEnclosure> adminFunInvoiceEnclosureList) {
		this.adminFunInvoiceEnclosureList = adminFunInvoiceEnclosureList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
