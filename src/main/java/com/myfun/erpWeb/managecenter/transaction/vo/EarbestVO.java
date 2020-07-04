package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class EarbestVO {
	@ApiModelProperty(value = "诚意金id")
	private Integer earbestId;

	@ApiModelProperty(value = "诚意金id")
	private String receiptNo;


	@ApiModelProperty(value = "公司id")
	private Integer compId;

	@ApiModelProperty(value = "创建记录门店ID")
	private Integer deptId;

	@ApiModelProperty(value = "创建人id")
	private Integer createUserId;

	@ApiModelProperty(value = "创建人名称")
	private String createUserName;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "收款金额")
	private BigDecimal receiptMoney;

	@ApiModelProperty(value = "收款门店")
	private Integer receiptDeptId;

	@ApiModelProperty(value = "收款门店名称")
	private String receiptDeptName;

	@ApiModelProperty(value = "收款人id")
	private Integer receiptUserId;

	@ApiModelProperty(value = "null")
	private String receiptUserName;
	
	@ApiModelProperty(value = "收款时间")
	private Date receiptTime;

	@ApiModelProperty(value = "支付方式")
	private String paymentType;

	@ApiModelProperty(value = "审核门店")
	private Integer auditDeptId;

	@ApiModelProperty(value = "审核门店名称")
	private String auditDeptName;
	
	@ApiModelProperty(value = "审核人ID")
	private Integer auditUserId;

	@ApiModelProperty(value = "审核人姓名")
	private String auditUserName;

	@ApiModelProperty(value = "审核时间")
	private Date auditTime;

	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;

	@ApiModelProperty(value = "房源id")
	private Integer caseId;

	@ApiModelProperty(value = "房源编号")
	private String caseNo;

	@ApiModelProperty(value = "房源类型：1出售，2出租，6新房出售")
	private Byte caseType;

	@ApiModelProperty(value = "厅")
	private Integer houseHall;

	@ApiModelProperty(value = "卫")
	private Integer houseWei;

	@ApiModelProperty(value = "面积")
	private BigDecimal houseArea;
	@ApiModelProperty(value = "房源价格")
	private BigDecimal housePrice;
	@ApiModelProperty(value = "出租房源租金单位，出售不需要，默认万元")
	private Byte housePriceUnit;

	@ApiModelProperty(value = "客源编号")
	private String custNo;


	@ApiModelProperty(value = "客源类型：3求购，4求租")
	private Byte custType;

	@ApiModelProperty(value = "客源名字")
	private String custName;
	
	@ApiModelProperty(value = "客源意向楼盘")
	private String custBuildName;


	@ApiModelProperty(value = "客源证件号，明文")
	private String custIdcardDecode;


	@ApiModelProperty(value = "退诚意金门店")
	private Integer refundDeptId;

	@ApiModelProperty(value = "退款门店")
	private String refundDeptName;

	@ApiModelProperty(value = "退款人")
	private Integer refundUserId;
	
	@ApiModelProperty(value = "退款人姓名")
	private String refundUserName;

	@ApiModelProperty(value = "退款解释")
	private String refundExplain;

	@ApiModelProperty(value = "退款时间")
	private Date refundTime;

	@ApiModelProperty(value = "转成交：合同id")
	private Integer dealId;

	@ApiModelProperty(value = "合同编号")
	private String dealNo;
	
	@ApiModelProperty(value = "当出票方式不等于手动录入时有值")
	private Integer billCodeId;

	@ApiModelProperty(value = "票据编号")
	private String billCodeNo;

	@ApiModelProperty(value = "出票方式  0电子票据 1纸质票薄 2手动录入")
	private Byte billWay;

	@ApiModelProperty(value = "bill_way=1或2时，票据图片")
	private String billPhoto;
	
	@ApiModelProperty(value = "票据已打印标记")
	private Byte isPrint;

	@ApiModelProperty(value = "诚意金状态：0.未审核，1.已审核，2.已作废")
	private Byte earbestStatus;
	
	@ApiModelProperty(value = "诚意金备注")
	private String earbestRemark;

	@ApiModelProperty(value = "操作类别：默认0,  1.转房源，2.代付，3.转客户拥，4.退款，5.作废，6.转业主佣金，7.转定金")
	private Byte operationType;
	
	@ApiModelProperty(value = "是否有效")
	private Byte isDel;
	
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	
	@ApiModelProperty(value = "客源id")
	private Integer custId;
	@ApiModelProperty(value = "客源证件号，密文")
	private String custIdcard;

	@ApiModelProperty(value = "客源手机")
	private String custMobile;
	
	@ApiModelProperty(value = "客户证件类型1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证")
	private Byte custIdCardType;
	
	@ApiModelProperty(value = "客源经济人id")
	private Integer custUserId;
	
	@ApiModelProperty(value = "意向楼盘")
	private String buildName;
	
	@ApiModelProperty(value = "意向价格低")
	private BigDecimal housePriceLow;
	
	@ApiModelProperty(value = "意向价格高")
	private BigDecimal housePriceHigh;
	
	@ApiModelProperty(value = "意向户型小")
	private Byte houseRoomMin;
	
	@ApiModelProperty(value = "意向户型大")
	private Byte houseRoomMax;
	
	@ApiModelProperty(value = "室")
	private Integer houseRoom;
	
	@ApiModelProperty(value = "房源id")
	private Integer houseId;
	
	@ApiModelProperty(value = "经济人id")
	private Integer houseUserId;
	
	@ApiModelProperty(value = "业主姓名")
	private String ownerName;
	
	@ApiModelProperty(value = "产权地址")
	private String propertyAddress;
	
	
	public String getCustBuildName() {
		return custBuildName;
	}

	public void setCustBuildName(String custBuildName) {
		this.custBuildName = custBuildName;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public Integer getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Integer houseRoom) {
		this.houseRoom = houseRoom;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getHouseUserId() {
		return houseUserId;
	}

	public void setHouseUserId(Integer houseUserId) {
		this.houseUserId = houseUserId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Integer getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(Integer custUserId) {
		this.custUserId = custUserId;
	}

	public BigDecimal getHousePriceLow() {
		return housePriceLow;
	}

	public void setHousePriceLow(BigDecimal housePriceLow) {
		this.housePriceLow = housePriceLow;
	}

	public BigDecimal getHousePriceHigh() {
		return housePriceHigh;
	}

	public void setHousePriceHigh(BigDecimal housePriceHigh) {
		this.housePriceHigh = housePriceHigh;
	}

	public Byte getHouseRoomMin() {
		return houseRoomMin;
	}

	public void setHouseRoomMin(Byte houseRoomMin) {
		this.houseRoomMin = houseRoomMin;
	}

	public Byte getHouseRoomMax() {
		return houseRoomMax;
	}

	public void setHouseRoomMax(Byte houseRoomMax) {
		this.houseRoomMax = houseRoomMax;
	}
	
	

	public BigDecimal getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(BigDecimal housePrice) {
		this.housePrice = housePrice;
	}

	public Byte getHousePriceUnit() {
		return housePriceUnit;
	}

	public void setHousePriceUnit(Byte housePriceUnit) {
		this.housePriceUnit = housePriceUnit;
	}

	public Integer getEarbestId() {
		return earbestId;
	}

	public void setEarbestId(Integer earbestId) {
		this.earbestId = earbestId;
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

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}

	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}

	public Integer getReceiptDeptId() {
		return receiptDeptId;
	}

	public void setReceiptDeptId(Integer receiptDeptId) {
		this.receiptDeptId = receiptDeptId;
	}

	public String getReceiptDeptName() {
		return receiptDeptName;
	}

	public void setReceiptDeptName(String receiptDeptName) {
		this.receiptDeptName = receiptDeptName;
	}

	public Integer getReceiptUserId() {
		return receiptUserId;
	}

	public void setReceiptUserId(Integer receiptUserId) {
		this.receiptUserId = receiptUserId;
	}

	public String getReceiptUserName() {
		return receiptUserName;
	}

	public void setReceiptUserName(String receiptUserName) {
		this.receiptUserName = receiptUserName;
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

	public Integer getAuditDeptId() {
		return auditDeptId;
	}

	public void setAuditDeptId(Integer auditDeptId) {
		this.auditDeptId = auditDeptId;
	}

	public String getAuditDeptName() {
		return auditDeptName;
	}

	public void setAuditDeptName(String auditDeptName) {
		this.auditDeptName = auditDeptName;
	}

	public Integer getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
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



	public Integer getHouseHall() {
		return houseHall;
	}

	public void setHouseHall(Integer houseHall) {
		this.houseHall = houseHall;
	}

	public Integer getHouseWei() {
		return houseWei;
	}

	public void setHouseWei(Integer houseWei) {
		this.houseWei = houseWei;
	}

	public BigDecimal getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
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

	public String getCustIdcard() {
		return custIdcard;
	}

	public void setCustIdcard(String custIdcard) {
		this.custIdcard = custIdcard;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustIdcardDecode() {
		return custIdcardDecode;
	}

	public void setCustIdcardDecode(String custIdcardDecode) {
		this.custIdcardDecode = custIdcardDecode;
	}

	public Byte getCustIdCardType() {
		return custIdCardType;
	}

	public void setCustIdCardType(Byte custIdCardType) {
		this.custIdCardType = custIdCardType;
	}

	public Integer getRefundDeptId() {
		return refundDeptId;
	}

	public void setRefundDeptId(Integer refundDeptId) {
		this.refundDeptId = refundDeptId;
	}

	public String getRefundDeptName() {
		return refundDeptName;
	}

	public void setRefundDeptName(String refundDeptName) {
		this.refundDeptName = refundDeptName;
	}

	public Integer getRefundUserId() {
		return refundUserId;
	}

	public void setRefundUserId(Integer refundUserId) {
		this.refundUserId = refundUserId;
	}

	public String getRefundUserName() {
		return refundUserName;
	}

	public void setRefundUserName(String refundUserName) {
		this.refundUserName = refundUserName;
	}

	public String getRefundExplain() {
		return refundExplain;
	}

	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
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

	public String getBillPhoto() {
		return billPhoto;
	}

	public void setBillPhoto(String billPhoto) {
		this.billPhoto = billPhoto;
	}

	public Byte getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(Byte isPrint) {
		this.isPrint = isPrint;
	}

	public Byte getEarbestStatus() {
		return earbestStatus;
	}

	public void setEarbestStatus(Byte earbestStatus) {
		this.earbestStatus = earbestStatus;
	}

	public String getEarbestRemark() {
		return earbestRemark;
	}

	public void setEarbestRemark(String earbestRemark) {
		this.earbestRemark = earbestRemark;
	}

	public Byte getOperationType() {
		return operationType;
	}

	public void setOperationType(Byte operationType) {
		this.operationType = operationType;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
}
