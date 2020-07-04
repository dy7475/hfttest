package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunPaid;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminFunPaidDto extends AdminFunPaid{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	
	@ApiModelProperty(value = "用户名称")
	private String userName;
	
	@ApiModelProperty(value = "用户手机号码")
	private String userMobile;
	
	@ApiModelProperty(value = "门店名称")
	private String deptName;
	
	@ApiModelProperty(value = "支付类型；DD：PT_TYPE")
	private Integer ptType;
	
	@ApiModelProperty(value = "发票id")
	private Integer invoiceId;
	
	@ApiModelProperty(value = "订单")
	private Integer orderField;
	
	@ApiModelProperty(value = "发票类型")
	private Integer invoiceType;
	
	@ApiModelProperty(value = "发票抬头")
	private String invoiceHeader;
	
	@ApiModelProperty(value = "创建时间")
	private String creationTime;
	
	@ApiModelProperty(value = "是否有收据")
	private Byte hasReceipt;

	private Integer deptId;
	
	private Byte invoiceStatus;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Byte getHasReceipt() {
		return hasReceipt;
	}

	public void setHasReceipt(Byte hasReceipt) {
		this.hasReceipt = hasReceipt;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getInvoiceHeader() {
		return invoiceHeader;
	}

	public void setInvoiceHeader(String invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Integer getOrderField() {
		return orderField;
	}

	public void setOrderField(Integer orderField) {
		this.orderField = orderField;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getPtType() {
		return ptType;
	}

	public void setPtType(Integer ptType) {
		this.ptType = ptType;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Byte invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}