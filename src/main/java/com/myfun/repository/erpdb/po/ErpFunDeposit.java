package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunDeposit extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "定金id")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建记录门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人id")
	private Integer createUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收款金额")
	private BigDecimal receiptMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收款门店")
	private Integer receiptDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收款人id")
	private Integer receiptUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收款时间")
	private Date receiptTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "支付方式")
	private String paymentType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核门店")
	private Integer auditDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核人ID")
	private Integer auditUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核时间")
	private Date auditTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源id")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型：1出售，2出租，6新房出售")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源编号")
	private String custNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源id")
	private Integer custId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源类型：3求购，4求租")
	private Byte custType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退定金门店")
	private Integer refundDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退款人")
	private Integer refundUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退款解释")
	private String refundExplain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退款时间")
	private Date refundTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转成交：合同id")
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同编号")
	private String dealNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当出票方式不等于手动录入时有值")
	private Integer billCodeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "票据编号")
	private String billCodeNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出票方式  0电子票据 1纸质票薄 2手动录入")
	private Byte billWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "bill_way=1或2时，票据图片")
	private String billPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "票据已打印标记")
	private Byte isPrint;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "定金状态：0.未审核，1.已审核，2.已作废")
	private Byte depositStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "定金备注")
	private String depositRemark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作类别：0 1.转房源，2代付 3.转拥，4.退款 5=作废")
	private Byte operationType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有效")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "检索字段")
	private String intelligentSearch;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源方姓名")
	private String custName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权地址")
	private String propertyAddress;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘")
	private String buildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户电话")
	private String custMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户身份证")
	private String custIdcard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "证件类型")
	private Byte custIdCardType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 定金id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 定金id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 创建记录门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 创建记录门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 创建人id
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated 创建人id
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 收款金额
	 */
	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}

	/**
	 * @mbggenerated 收款金额
	 */
	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}

	/**
	 * @mbggenerated 收款门店
	 */
	public Integer getReceiptDeptId() {
		return receiptDeptId;
	}

	/**
	 * @mbggenerated 收款门店
	 */
	public void setReceiptDeptId(Integer receiptDeptId) {
		this.receiptDeptId = receiptDeptId;
	}

	/**
	 * @mbggenerated 收款人id
	 */
	public Integer getReceiptUserId() {
		return receiptUserId;
	}

	/**
	 * @mbggenerated 收款人id
	 */
	public void setReceiptUserId(Integer receiptUserId) {
		this.receiptUserId = receiptUserId;
	}

	/**
	 * @mbggenerated 收款时间
	 */
	public Date getReceiptTime() {
		return receiptTime;
	}

	/**
	 * @mbggenerated 收款时间
	 */
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	/**
	 * @mbggenerated 支付方式
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @mbggenerated 支付方式
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @mbggenerated 审核门店
	 */
	public Integer getAuditDeptId() {
		return auditDeptId;
	}

	/**
	 * @mbggenerated 审核门店
	 */
	public void setAuditDeptId(Integer auditDeptId) {
		this.auditDeptId = auditDeptId;
	}

	/**
	 * @mbggenerated 审核人ID
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated 审核人ID
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 房源id
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源id
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @mbggenerated 房源类型：1出售，2出租，6新房出售
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型：1出售，2出租，6新房出售
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 客源编号
	 */
	public String getCustNo() {
		return custNo;
	}

	/**
	 * @mbggenerated 客源编号
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	/**
	 * @mbggenerated 客源id
	 */
	public Integer getCustId() {
		return custId;
	}

	/**
	 * @mbggenerated 客源id
	 */
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	/**
	 * @mbggenerated 客源类型：3求购，4求租
	 */
	public Byte getCustType() {
		return custType;
	}

	/**
	 * @mbggenerated 客源类型：3求购，4求租
	 */
	public void setCustType(Byte custType) {
		this.custType = custType;
	}

	/**
	 * @mbggenerated 退定金门店
	 */
	public Integer getRefundDeptId() {
		return refundDeptId;
	}

	/**
	 * @mbggenerated 退定金门店
	 */
	public void setRefundDeptId(Integer refundDeptId) {
		this.refundDeptId = refundDeptId;
	}

	/**
	 * @mbggenerated 退款人
	 */
	public Integer getRefundUserId() {
		return refundUserId;
	}

	/**
	 * @mbggenerated 退款人
	 */
	public void setRefundUserId(Integer refundUserId) {
		this.refundUserId = refundUserId;
	}

	/**
	 * @mbggenerated 退款解释
	 */
	public String getRefundExplain() {
		return refundExplain;
	}

	/**
	 * @mbggenerated 退款解释
	 */
	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	/**
	 * @mbggenerated 退款时间
	 */
	public Date getRefundTime() {
		return refundTime;
	}

	/**
	 * @mbggenerated 退款时间
	 */
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	/**
	 * @mbggenerated 转成交：合同id
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 转成交：合同id
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 合同编号
	 */
	public String getDealNo() {
		return dealNo;
	}

	/**
	 * @mbggenerated 合同编号
	 */
	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	/**
	 * @mbggenerated 当出票方式不等于手动录入时有值
	 */
	public Integer getBillCodeId() {
		return billCodeId;
	}

	/**
	 * @mbggenerated 当出票方式不等于手动录入时有值
	 */
	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}

	/**
	 * @mbggenerated 票据编号
	 */
	public String getBillCodeNo() {
		return billCodeNo;
	}

	/**
	 * @mbggenerated 票据编号
	 */
	public void setBillCodeNo(String billCodeNo) {
		this.billCodeNo = billCodeNo;
	}

	/**
	 * @mbggenerated 出票方式  0电子票据 1纸质票薄 2手动录入
	 */
	public Byte getBillWay() {
		return billWay;
	}

	/**
	 * @mbggenerated 出票方式  0电子票据 1纸质票薄 2手动录入
	 */
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}

	/**
	 * @mbggenerated bill_way=1或2时，票据图片
	 */
	public String getBillPhoto() {
		return billPhoto;
	}

	/**
	 * @mbggenerated bill_way=1或2时，票据图片
	 */
	public void setBillPhoto(String billPhoto) {
		this.billPhoto = billPhoto;
	}

	/**
	 * @mbggenerated 票据已打印标记
	 */
	public Byte getIsPrint() {
		return isPrint;
	}

	/**
	 * @mbggenerated 票据已打印标记
	 */
	public void setIsPrint(Byte isPrint) {
		this.isPrint = isPrint;
	}

	/**
	 * @mbggenerated 定金状态：0.未审核，1.已审核，2.已作废
	 */
	public Byte getDepositStatus() {
		return depositStatus;
	}

	/**
	 * @mbggenerated 定金状态：0.未审核，1.已审核，2.已作废
	 */
	public void setDepositStatus(Byte depositStatus) {
		this.depositStatus = depositStatus;
	}

	/**
	 * @mbggenerated 定金备注
	 */
	public String getDepositRemark() {
		return depositRemark;
	}

	/**
	 * @mbggenerated 定金备注
	 */
	public void setDepositRemark(String depositRemark) {
		this.depositRemark = depositRemark;
	}

	/**
	 * @mbggenerated 操作类别：0 1.转房源，2代付 3.转拥，4.退款 5=作废
	 */
	public Byte getOperationType() {
		return operationType;
	}

	/**
	 * @mbggenerated 操作类别：0 1.转房源，2代付 3.转拥，4.退款 5=作废
	 */
	public void setOperationType(Byte operationType) {
		this.operationType = operationType;
	}

	/**
	 * @mbggenerated 是否有效
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否有效
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 检索字段
	 */
	public String getIntelligentSearch() {
		return intelligentSearch;
	}

	/**
	 * @mbggenerated 检索字段
	 */
	public void setIntelligentSearch(String intelligentSearch) {
		this.intelligentSearch = intelligentSearch;
	}

	/**
	 * @mbggenerated 客源方姓名
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @mbggenerated 客源方姓名
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @mbggenerated 产权地址
	 */
	public String getPropertyAddress() {
		return propertyAddress;
	}

	/**
	 * @mbggenerated 产权地址
	 */
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	/**
	 * @mbggenerated 楼盘
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated 楼盘
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * @mbggenerated 客户电话
	 */
	public String getCustMobile() {
		return custMobile;
	}

	/**
	 * @mbggenerated 客户电话
	 */
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	/**
	 * @mbggenerated 客户身份证
	 */
	public String getCustIdcard() {
		return custIdcard;
	}

	/**
	 * @mbggenerated 客户身份证
	 */
	public void setCustIdcard(String custIdcard) {
		this.custIdcard = custIdcard;
	}

	/**
	 * @mbggenerated 证件类型
	 */
	public Byte getCustIdCardType() {
		return custIdCardType;
	}

	/**
	 * @mbggenerated 证件类型
	 */
	public void setCustIdCardType(Byte custIdCardType) {
		this.custIdCardType = custIdCardType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeposit() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeposit(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}