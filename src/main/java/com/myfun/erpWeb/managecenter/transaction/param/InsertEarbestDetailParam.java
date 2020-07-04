package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class InsertEarbestDetailParam implements EncryParamIfc{

	@ApiModelProperty(value = "当出票方式不等于手动录入时有值")
	private Integer billCodeId;
	
	@ApiModelProperty(value = "票据编号")
	private String billCodeNo;
	
	@ApiModelProperty(value = "出票方式  0电子票据 1纸质票薄 2手动录入")
	private Byte billWay;
	
	@ApiModelProperty(value = "收款金额")
	private BigDecimal receiptMoney;
	
	@ApiModelProperty(value = "定金备注")
	private String depositRemark;
	
	@ApiModelProperty(value = "收款门店")
	private Integer receiptDeptId;

	@ApiModelProperty(value = "收款人id")
	private Integer receiptUserId;

	@ApiModelProperty(value = "收款时间")
	private Date receiptTime;

	@ApiModelProperty(value = "支付方式")
	private String paymentType;

	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;
	
	@ApiModelProperty("楼盘名称")
	private String buildName;
	
	@ApiModelProperty(value = "房源id")
	private Integer caseId;

	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	
	@ApiModelProperty(value = "房源类型：1出售，2出租，6新房出售")
	private Byte caseType;

	@ApiModelProperty(value = "客源编号")
	private String custNo;

	@ApiModelProperty(value = "客源id")
	private Integer custId;

	@ApiModelProperty(value = "客源类型：3求购，4求租")
	private Byte custType;
	
	@ApiModelProperty(value = "客源方姓名")
	private String custName;
	@ApiModelProperty(value = "客源手机")
	private String custMobile;
	@ApiModelProperty(value = "产权地址")
	private String propertyAddress;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer userId;
	
	@ApiModelProperty(hidden = true)
	private String userName;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	
	@ApiModelProperty(hidden = true)
	private Integer grId;
	
	@ApiModelProperty(hidden = true)
	private Integer areaId;
	
	@ApiModelProperty(hidden = true)
	private Integer regId;
	
	@ApiModelProperty(hidden = true)
	private String deptCName;

	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public Integer getBillCodeId() {
		return billCodeId;
	}
	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}
	public String getBillCodeNo() {
		return billCodeNo;
	}
	public void setBillCodeNo(String billCodeNo) {
		this.billCodeNo = billCodeNo;
	}
	public Byte getBillWay() {
		return billWay;
	}
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}
	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}
	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}
	public String getDepositRemark() {
		return depositRemark;
	}
	public void setDepositRemark(String depositRemark) {
		this.depositRemark = depositRemark;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptCName() {
		return deptCName;
	}
	public void setDeptCName(String deptCName) {
		this.deptCName = deptCName;
	}
	public Integer getReceiptDeptId() {
		return receiptDeptId;
	}
	public void setReceiptDeptId(Integer receiptDeptId) {
		this.receiptDeptId = receiptDeptId;
	}
	public Integer getReceiptUserId() {
		return receiptUserId;
	}
	public void setReceiptUserId(Integer receiptUserId) {
		this.receiptUserId = receiptUserId;
	}
	public Date getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Byte getCaseType() {
		return caseType;
	}
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Byte getCustType() {
		return custType;
	}
	public void setCustType(Byte custType) {
		this.custType = custType;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	
}
