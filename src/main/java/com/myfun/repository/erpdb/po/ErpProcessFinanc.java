package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpProcessFinanc extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="帐务ID，自增序列") private Integer pfId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="合同ID") private Integer dealId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="款项名称，1：佣金2：定金3：代收款4：营业税5：其他") private String pfName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否实付，0=应收 1=实收") private Byte pfActual;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="收款方，3:中介   dic:PROCESS_FINANC_GETER") private String pfGeter;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="付款方，1:客户2:业主   dic:PROCESS_FINANC_PAYER") private String pfPayer;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="付款金额") private BigDecimal payAmount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="付款备注") private String pfDesc;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="付款时间") private Date pfTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="财务款项ID") private Integer paymentId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中") private String auditStatus;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="财务款项新增计划截至日期") private Date dueDate;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="财务款项新增审核日期") private Date auditTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核人") private String auditUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核人姓名") private String auditUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="实收编号") private String actualReceiptNum;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否计入业绩   废弃") private Byte isProfit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 业绩类别") private Byte performanceType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="折扣比例，理论上来讲这个比例应该是佣金项来计算") private BigDecimal discount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="支付方式") private Integer paymentType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="支付账号") private String payAccount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="订单编号") private String orderNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="支付方式注释") private String payTypeDesc;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="收款人") private Integer receiptMoneyUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="收款门店") private Integer receiptMoneyDept;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否打印过了1=打印过了，默认0") private Byte isPrint;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="编号使用的号段分配id") private Integer billCodeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="票据号") private String billCodeNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="票据图片地址") private String billPhoto;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte billWay;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人") private Integer createUid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="回执单文件ID") private Integer onlinePaymentReceiptFileId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="支付方式 1=原有的方式（收讫或者手动录入，暂时没时间分开） 3=新网银行（在线收款）") private Integer payType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="来源类型：1.诚意金，2.定金") private Byte itemSource;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="来源id") private Integer sourceId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="流水号") private String serialNumber;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 帐务ID，自增序列
	 */
	public Integer getPfId() {
		return pfId;
	}

	/**
	 * @mbggenerated 帐务ID，自增序列
	 */
	public void setPfId(Integer pfId) {
		this.pfId = pfId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 款项名称，1：佣金2：定金3：代收款4：营业税5：其他
	 */
	public String getPfName() {
		return pfName;
	}

	/**
	 * @mbggenerated 款项名称，1：佣金2：定金3：代收款4：营业税5：其他
	 */
	public void setPfName(String pfName) {
		this.pfName = pfName;
	}

	/**
	 * @mbggenerated 是否实付，0=应收 1=实收
	 */
	public Byte getPfActual() {
		return pfActual;
	}

	/**
	 * @mbggenerated 是否实付，0=应收 1=实收
	 */
	public void setPfActual(Byte pfActual) {
		this.pfActual = pfActual;
	}

	/**
	 * @mbggenerated 收款方，3:中介   dic:PROCESS_FINANC_GETER
	 */
	public String getPfGeter() {
		return pfGeter;
	}

	/**
	 * @mbggenerated 收款方，3:中介   dic:PROCESS_FINANC_GETER
	 */
	public void setPfGeter(String pfGeter) {
		this.pfGeter = pfGeter;
	}

	/**
	 * @mbggenerated 付款方，1:客户2:业主   dic:PROCESS_FINANC_PAYER
	 */
	public String getPfPayer() {
		return pfPayer;
	}

	/**
	 * @mbggenerated 付款方，1:客户2:业主   dic:PROCESS_FINANC_PAYER
	 */
	public void setPfPayer(String pfPayer) {
		this.pfPayer = pfPayer;
	}

	/**
	 * @mbggenerated 付款金额
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}

	/**
	 * @mbggenerated 付款金额
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * @mbggenerated 付款备注
	 */
	public String getPfDesc() {
		return pfDesc;
	}

	/**
	 * @mbggenerated 付款备注
	 */
	public void setPfDesc(String pfDesc) {
		this.pfDesc = pfDesc;
	}

	/**
	 * @mbggenerated 付款时间
	 */
	public Date getPfTime() {
		return pfTime;
	}

	/**
	 * @mbggenerated 付款时间
	 */
	public void setPfTime(Date pfTime) {
		this.pfTime = pfTime;
	}

	/**
	 * @mbggenerated 财务款项ID
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	/**
	 * @mbggenerated 财务款项ID
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @mbggenerated 财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中
	 */
	public String getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated 财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated 财务款项新增计划截至日期
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @mbggenerated 财务款项新增计划截至日期
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @mbggenerated 财务款项新增审核日期
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated 财务款项新增审核日期
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public String getAuditUser() {
		return auditUser;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	/**
	 * @mbggenerated 审核人姓名
	 */
	public String getAuditUserName() {
		return auditUserName;
	}

	/**
	 * @mbggenerated 审核人姓名
	 */
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	/**
	 * @mbggenerated 实收编号
	 */
	public String getActualReceiptNum() {
		return actualReceiptNum;
	}

	/**
	 * @mbggenerated 实收编号
	 */
	public void setActualReceiptNum(String actualReceiptNum) {
		this.actualReceiptNum = actualReceiptNum;
	}

	/**
	 * @mbggenerated 是否计入业绩   废弃
	 */
	public Byte getIsProfit() {
		return isProfit;
	}

	/**
	 * @mbggenerated 是否计入业绩   废弃
	 */
	public void setIsProfit(Byte isProfit) {
		this.isProfit = isProfit;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 业绩类别
	 */
	public Byte getPerformanceType() {
		return performanceType;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 业绩类别
	 */
	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * @mbggenerated 折扣比例，理论上来讲这个比例应该是佣金项来计算
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @mbggenerated 折扣比例，理论上来讲这个比例应该是佣金项来计算
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * @mbggenerated 支付方式
	 */
	public Integer getPaymentType() {
		return paymentType;
	}

	/**
	 * @mbggenerated 支付方式
	 */
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @mbggenerated 支付账号
	 */
	public String getPayAccount() {
		return payAccount;
	}

	/**
	 * @mbggenerated 支付账号
	 */
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	/**
	 * @mbggenerated 订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @mbggenerated 订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @mbggenerated 支付方式注释
	 */
	public String getPayTypeDesc() {
		return payTypeDesc;
	}

	/**
	 * @mbggenerated 支付方式注释
	 */
	public void setPayTypeDesc(String payTypeDesc) {
		this.payTypeDesc = payTypeDesc;
	}

	/**
	 * @mbggenerated 收款人
	 */
	public Integer getReceiptMoneyUser() {
		return receiptMoneyUser;
	}

	/**
	 * @mbggenerated 收款人
	 */
	public void setReceiptMoneyUser(Integer receiptMoneyUser) {
		this.receiptMoneyUser = receiptMoneyUser;
	}

	/**
	 * @mbggenerated 收款门店
	 */
	public Integer getReceiptMoneyDept() {
		return receiptMoneyDept;
	}

	/**
	 * @mbggenerated 收款门店
	 */
	public void setReceiptMoneyDept(Integer receiptMoneyDept) {
		this.receiptMoneyDept = receiptMoneyDept;
	}

	/**
	 * @mbggenerated 是否打印过了1=打印过了，默认0
	 */
	public Byte getIsPrint() {
		return isPrint;
	}

	/**
	 * @mbggenerated 是否打印过了1=打印过了，默认0
	 */
	public void setIsPrint(Byte isPrint) {
		this.isPrint = isPrint;
	}

	/**
	 * @mbggenerated 编号使用的号段分配id
	 */
	public Integer getBillCodeId() {
		return billCodeId;
	}

	/**
	 * @mbggenerated 编号使用的号段分配id
	 */
	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}

	/**
	 * @mbggenerated 票据号
	 */
	public String getBillCodeNo() {
		return billCodeNo;
	}

	/**
	 * @mbggenerated 票据号
	 */
	public void setBillCodeNo(String billCodeNo) {
		this.billCodeNo = billCodeNo;
	}

	/**
	 * @mbggenerated 票据图片地址
	 */
	public String getBillPhoto() {
		return billPhoto;
	}

	/**
	 * @mbggenerated 票据图片地址
	 */
	public void setBillPhoto(String billPhoto) {
		this.billPhoto = billPhoto;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getBillWay() {
		return billWay;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
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
	 * @mbggenerated 创建人
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated 回执单文件ID
	 */
	public Integer getOnlinePaymentReceiptFileId() {
		return onlinePaymentReceiptFileId;
	}

	/**
	 * @mbggenerated 回执单文件ID
	 */
	public void setOnlinePaymentReceiptFileId(Integer onlinePaymentReceiptFileId) {
		this.onlinePaymentReceiptFileId = onlinePaymentReceiptFileId;
	}

	/**
	 * @mbggenerated 支付方式 1=原有的方式（收讫或者手动录入，暂时没时间分开） 3=新网银行（在线收款）
	 */
	public Integer getPayType() {
		return payType;
	}

	/**
	 * @mbggenerated 支付方式 1=原有的方式（收讫或者手动录入，暂时没时间分开） 3=新网银行（在线收款）
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	/**
	 * @mbggenerated 来源类型：1.诚意金，2.定金
	 */
	public Byte getItemSource() {
		return itemSource;
	}

	/**
	 * @mbggenerated 来源类型：1.诚意金，2.定金
	 */
	public void setItemSource(Byte itemSource) {
		this.itemSource = itemSource;
	}

	/**
	 * @mbggenerated 来源id
	 */
	public Integer getSourceId() {
		return sourceId;
	}

	/**
	 * @mbggenerated 来源id
	 */
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @mbggenerated 流水号
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @mbggenerated 流水号
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @mbggenerated
	 */
	public ErpProcessFinanc() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpProcessFinanc(Integer shardCityId, Integer pfId) {
		super(shardCityId);
		this.pfId = pfId;
	}
}