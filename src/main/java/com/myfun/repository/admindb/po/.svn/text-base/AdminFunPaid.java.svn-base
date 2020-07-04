package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminFunPaid implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增")
	private Integer paidId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "资金账户ID")
	private Integer uaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "消费记录大类，GIFT=赠送、PAY=支出、INCOME=充值、CRMVIRE=CRM转账 ERPVIRE=ERP转账")
	private String paidCatigory;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "冲值方式（字典类型DD：PAID_TYPE）(DIC_DEFINITIONS)")
	private String paidType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "冲值卡号，From:FUN_CARD.CARD_NO")
	private String cardno;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手机卡充值订单号")
	private String orderno;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "冲值(消费)金额")
	private Double amount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "冲值(消费)日期")
	private Date padiTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务ID")
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提现状态状态（0未审核 1已审核 2现金提现中 3现金提现成功 4现金提现失败），以前：手机充值卡状态   （物业分账逻辑 0=未结算，1=已结算不可提现，2=结算可提现，3=提现中，4=提现成功，5=提现失败）")
	private Integer status;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "此次操作前的增值服务时间")
	private Date oldTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "记录描述")
	private String desc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作前的账户余额")
	private Double amountBefore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作后的账户余额")
	private Double amountAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "CRM_COMP_ID")
	private Integer crmCompId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "消费来源，0=ERP、1=CRM、2=youyou、3=admin")
	private Byte paidSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "微信标记,1:是")
	private Byte realWeixin;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "使用了多少优惠券-只是做记录（消费赠送好房豆）")
	private Double amountQuan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "使用了多少好房币-只是做记录(消费购买好房豆)")
	private Double amountCoin;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "关联订单id")
	private Integer ptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0代表没有收据，但可能有发票，1代表只有收据，2代表两个都有")
	private Byte hasReceipt;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "消费后好房币余额")
	private Double buyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "服务开始时间")
	private Date serviceStartTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "服务结束时间")
	private Date serviceEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三方交易流水号 例：10020171021111636703dyJ2nqItlH")
	private String transactionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分享奖励金")
	private Double amountShareMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "使用余额支付")
	private Double amountCashMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "支付宝或微信支付金额")
	private Double amountPayment;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "充值的好房豆用于什么业务 dd：PAID_TYPE  COIN_NEW_BUILD")
	private String subPaidType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "AMOUNT_PAYMENT 类型 支付宝=ALIPAY 微信=TENPAY")
	private String amountPayType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分享奖励金使用后的余额 对应SHARE_MONEY")
	private Double amountShareMoneyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "现金使用后余额 对应CASH_MONEY")
	private Double amountCashMoneyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源保证金")
	private Double trueBailMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司现金")
	private Double compCashMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司好房豆")
	private Double compCoinMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源保证金消费后")
	private Double trueBailMoneyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司现金消费后")
	private Double compCashMoneyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司好房豆消费后")
	private Double compCoinMoneyAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实际支付金额")
	private Double actualMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID（ADMIN库，强烈建议写上，很多统计使用）")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "综合字段")
	private String json;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增
	 */
	public Integer getPaidId() {
		return paidId;
	}

	/**
	 * @mbggenerated 主键自增
	 */
	public void setPaidId(Integer paidId) {
		this.paidId = paidId;
	}

	/**
	 * @mbggenerated 资金账户ID
	 */
	public Integer getUaId() {
		return uaId;
	}

	/**
	 * @mbggenerated 资金账户ID
	 */
	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}

	/**
	 * @mbggenerated 档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 消费记录大类，GIFT=赠送、PAY=支出、INCOME=充值、CRMVIRE=CRM转账 ERPVIRE=ERP转账
	 */
	public String getPaidCatigory() {
		return paidCatigory;
	}

	/**
	 * @mbggenerated 消费记录大类，GIFT=赠送、PAY=支出、INCOME=充值、CRMVIRE=CRM转账 ERPVIRE=ERP转账
	 */
	public void setPaidCatigory(String paidCatigory) {
		this.paidCatigory = paidCatigory;
	}

	/**
	 * @mbggenerated 冲值方式（字典类型DD：PAID_TYPE）(DIC_DEFINITIONS)
	 */
	public String getPaidType() {
		return paidType;
	}

	/**
	 * @mbggenerated 冲值方式（字典类型DD：PAID_TYPE）(DIC_DEFINITIONS)
	 */
	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}

	/**
	 * @mbggenerated 冲值卡号，From:FUN_CARD.CARD_NO
	 */
	public String getCardno() {
		return cardno;
	}

	/**
	 * @mbggenerated 冲值卡号，From:FUN_CARD.CARD_NO
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	/**
	 * @mbggenerated 手机卡充值订单号
	 */
	public String getOrderno() {
		return orderno;
	}

	/**
	 * @mbggenerated 手机卡充值订单号
	 */
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	/**
	 * @mbggenerated 冲值(消费)金额
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @mbggenerated 冲值(消费)金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @mbggenerated 冲值(消费)日期
	 */
	public Date getPadiTime() {
		return padiTime;
	}

	/**
	 * @mbggenerated 冲值(消费)日期
	 */
	public void setPadiTime(Date padiTime) {
		this.padiTime = padiTime;
	}

	/**
	 * @mbggenerated 业务ID
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 业务ID
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 提现状态状态（0未审核 1已审核 2现金提现中 3现金提现成功 4现金提现失败），以前：手机充值卡状态   （物业分账逻辑 0=未结算，1=已结算不可提现，2=结算可提现，3=提现中，4=提现成功，5=提现失败）
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @mbggenerated 提现状态状态（0未审核 1已审核 2现金提现中 3现金提现成功 4现金提现失败），以前：手机充值卡状态   （物业分账逻辑 0=未结算，1=已结算不可提现，2=结算可提现，3=提现中，4=提现成功，5=提现失败）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @mbggenerated 此次操作前的增值服务时间
	 */
	public Date getOldTime() {
		return oldTime;
	}

	/**
	 * @mbggenerated 此次操作前的增值服务时间
	 */
	public void setOldTime(Date oldTime) {
		this.oldTime = oldTime;
	}

	/**
	 * @mbggenerated 记录描述
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @mbggenerated 记录描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @mbggenerated 操作前的账户余额
	 */
	public Double getAmountBefore() {
		return amountBefore;
	}

	/**
	 * @mbggenerated 操作前的账户余额
	 */
	public void setAmountBefore(Double amountBefore) {
		this.amountBefore = amountBefore;
	}

	/**
	 * @mbggenerated 操作后的账户余额
	 */
	public Double getAmountAfter() {
		return amountAfter;
	}

	/**
	 * @mbggenerated 操作后的账户余额
	 */
	public void setAmountAfter(Double amountAfter) {
		this.amountAfter = amountAfter;
	}

	/**
	 * @mbggenerated CRM_COMP_ID
	 */
	public Integer getCrmCompId() {
		return crmCompId;
	}

	/**
	 * @mbggenerated CRM_COMP_ID
	 */
	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	/**
	 * @mbggenerated 消费来源，0=ERP、1=CRM、2=youyou、3=admin
	 */
	public Byte getPaidSource() {
		return paidSource;
	}

	/**
	 * @mbggenerated 消费来源，0=ERP、1=CRM、2=youyou、3=admin
	 */
	public void setPaidSource(Byte paidSource) {
		this.paidSource = paidSource;
	}

	/**
	 * @mbggenerated 微信标记,1:是
	 */
	public Byte getRealWeixin() {
		return realWeixin;
	}

	/**
	 * @mbggenerated 微信标记,1:是
	 */
	public void setRealWeixin(Byte realWeixin) {
		this.realWeixin = realWeixin;
	}

	/**
	 * @mbggenerated 使用了多少优惠券-只是做记录（消费赠送好房豆）
	 */
	public Double getAmountQuan() {
		return amountQuan;
	}

	/**
	 * @mbggenerated 使用了多少优惠券-只是做记录（消费赠送好房豆）
	 */
	public void setAmountQuan(Double amountQuan) {
		this.amountQuan = amountQuan;
	}

	/**
	 * @mbggenerated 使用了多少好房币-只是做记录(消费购买好房豆)
	 */
	public Double getAmountCoin() {
		return amountCoin;
	}

	/**
	 * @mbggenerated 使用了多少好房币-只是做记录(消费购买好房豆)
	 */
	public void setAmountCoin(Double amountCoin) {
		this.amountCoin = amountCoin;
	}

	/**
	 * @mbggenerated 关联订单id
	 */
	public Integer getPtId() {
		return ptId;
	}

	/**
	 * @mbggenerated 关联订单id
	 */
	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}

	/**
	 * @mbggenerated 0代表没有收据，但可能有发票，1代表只有收据，2代表两个都有
	 */
	public Byte getHasReceipt() {
		return hasReceipt;
	}

	/**
	 * @mbggenerated 0代表没有收据，但可能有发票，1代表只有收据，2代表两个都有
	 */
	public void setHasReceipt(Byte hasReceipt) {
		this.hasReceipt = hasReceipt;
	}

	/**
	 * @mbggenerated 消费后好房币余额
	 */
	public Double getBuyAfter() {
		return buyAfter;
	}

	/**
	 * @mbggenerated 消费后好房币余额
	 */
	public void setBuyAfter(Double buyAfter) {
		this.buyAfter = buyAfter;
	}

	/**
	 * @mbggenerated 服务开始时间
	 */
	public Date getServiceStartTime() {
		return serviceStartTime;
	}

	/**
	 * @mbggenerated 服务开始时间
	 */
	public void setServiceStartTime(Date serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	/**
	 * @mbggenerated 服务结束时间
	 */
	public Date getServiceEndTime() {
		return serviceEndTime;
	}

	/**
	 * @mbggenerated 服务结束时间
	 */
	public void setServiceEndTime(Date serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	/**
	 * @mbggenerated 第三方交易流水号 例：10020171021111636703dyJ2nqItlH
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @mbggenerated 第三方交易流水号 例：10020171021111636703dyJ2nqItlH
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @mbggenerated 分享奖励金
	 */
	public Double getAmountShareMoney() {
		return amountShareMoney;
	}

	/**
	 * @mbggenerated 分享奖励金
	 */
	public void setAmountShareMoney(Double amountShareMoney) {
		this.amountShareMoney = amountShareMoney;
	}

	/**
	 * @mbggenerated 使用余额支付
	 */
	public Double getAmountCashMoney() {
		return amountCashMoney;
	}

	/**
	 * @mbggenerated 使用余额支付
	 */
	public void setAmountCashMoney(Double amountCashMoney) {
		this.amountCashMoney = amountCashMoney;
	}

	/**
	 * @mbggenerated 支付宝或微信支付金额
	 */
	public Double getAmountPayment() {
		return amountPayment;
	}

	/**
	 * @mbggenerated 支付宝或微信支付金额
	 */
	public void setAmountPayment(Double amountPayment) {
		this.amountPayment = amountPayment;
	}

	/**
	 * @mbggenerated 充值的好房豆用于什么业务 dd：PAID_TYPE  COIN_NEW_BUILD
	 */
	public String getSubPaidType() {
		return subPaidType;
	}

	/**
	 * @mbggenerated 充值的好房豆用于什么业务 dd：PAID_TYPE  COIN_NEW_BUILD
	 */
	public void setSubPaidType(String subPaidType) {
		this.subPaidType = subPaidType;
	}

	/**
	 * @mbggenerated AMOUNT_PAYMENT 类型 支付宝=ALIPAY 微信=TENPAY
	 */
	public String getAmountPayType() {
		return amountPayType;
	}

	/**
	 * @mbggenerated AMOUNT_PAYMENT 类型 支付宝=ALIPAY 微信=TENPAY
	 */
	public void setAmountPayType(String amountPayType) {
		this.amountPayType = amountPayType;
	}

	/**
	 * @mbggenerated 分享奖励金使用后的余额 对应SHARE_MONEY
	 */
	public Double getAmountShareMoneyAfter() {
		return amountShareMoneyAfter;
	}

	/**
	 * @mbggenerated 分享奖励金使用后的余额 对应SHARE_MONEY
	 */
	public void setAmountShareMoneyAfter(Double amountShareMoneyAfter) {
		this.amountShareMoneyAfter = amountShareMoneyAfter;
	}

	/**
	 * @mbggenerated 现金使用后余额 对应CASH_MONEY
	 */
	public Double getAmountCashMoneyAfter() {
		return amountCashMoneyAfter;
	}

	/**
	 * @mbggenerated 现金使用后余额 对应CASH_MONEY
	 */
	public void setAmountCashMoneyAfter(Double amountCashMoneyAfter) {
		this.amountCashMoneyAfter = amountCashMoneyAfter;
	}

	/**
	 * @mbggenerated 真房源保证金
	 */
	public Double getTrueBailMoney() {
		return trueBailMoney;
	}

	/**
	 * @mbggenerated 真房源保证金
	 */
	public void setTrueBailMoney(Double trueBailMoney) {
		this.trueBailMoney = trueBailMoney;
	}

	/**
	 * @mbggenerated 公司现金
	 */
	public Double getCompCashMoney() {
		return compCashMoney;
	}

	/**
	 * @mbggenerated 公司现金
	 */
	public void setCompCashMoney(Double compCashMoney) {
		this.compCashMoney = compCashMoney;
	}

	/**
	 * @mbggenerated 公司好房豆
	 */
	public Double getCompCoinMoney() {
		return compCoinMoney;
	}

	/**
	 * @mbggenerated 公司好房豆
	 */
	public void setCompCoinMoney(Double compCoinMoney) {
		this.compCoinMoney = compCoinMoney;
	}

	/**
	 * @mbggenerated 真房源保证金消费后
	 */
	public Double getTrueBailMoneyAfter() {
		return trueBailMoneyAfter;
	}

	/**
	 * @mbggenerated 真房源保证金消费后
	 */
	public void setTrueBailMoneyAfter(Double trueBailMoneyAfter) {
		this.trueBailMoneyAfter = trueBailMoneyAfter;
	}

	/**
	 * @mbggenerated 公司现金消费后
	 */
	public Double getCompCashMoneyAfter() {
		return compCashMoneyAfter;
	}

	/**
	 * @mbggenerated 公司现金消费后
	 */
	public void setCompCashMoneyAfter(Double compCashMoneyAfter) {
		this.compCashMoneyAfter = compCashMoneyAfter;
	}

	/**
	 * @mbggenerated 公司好房豆消费后
	 */
	public Double getCompCoinMoneyAfter() {
		return compCoinMoneyAfter;
	}

	/**
	 * @mbggenerated 公司好房豆消费后
	 */
	public void setCompCoinMoneyAfter(Double compCoinMoneyAfter) {
		this.compCoinMoneyAfter = compCoinMoneyAfter;
	}

	/**
	 * @mbggenerated 实际支付金额
	 */
	public Double getActualMoney() {
		return actualMoney;
	}

	/**
	 * @mbggenerated 实际支付金额
	 */
	public void setActualMoney(Double actualMoney) {
		this.actualMoney = actualMoney;
	}

	/**
	 * @mbggenerated 门店ID（ADMIN库，强烈建议写上，很多统计使用）
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID（ADMIN库，强烈建议写上，很多统计使用）
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 综合字段
	 */
	public String getJson() {
		return json;
	}

	/**
	 * @mbggenerated 综合字段
	 */
	public void setJson(String json) {
		this.json = json;
	}

}