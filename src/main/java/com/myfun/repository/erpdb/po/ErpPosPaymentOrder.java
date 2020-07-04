package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class ErpPosPaymentOrder extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 1:诚意金 2：合同 3:普通
	 */
	private Byte financeType;
	/**
	 * @mbggenerated 发起时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 款项Id
	 */
	private Integer financeId;
	/**
	 * @mbggenerated 订单号
	 */
	private String orderNo;
	/**
	 * @mbggenerated ERP库公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated ERP库门店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 支付时间
	 */
	private Date paymentTime;
	/**
	 * @mbggenerated 0未支付 1：已支付 2：取消 3：作废
	 */
	private Byte payStatus;
	/**
	 * @mbggenerated 101：出售  102：出租
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 合同表主键ID
	 */
	private Integer dealId;
	/**
	 * @mbggenerated 款项金额
	 */
	private BigDecimal financeMoney;
	/**
	 * @mbggenerated 款项名称
	 */
	private String financeName;
	/**
	 * @mbggenerated 付款账户
	 */
	private String payAccount;
	/**
	 * @mbggenerated 客户名字
	 */
	private String payUserName;
	/**
	 * @mbggenerated 房源编号
	 */
	private String caseNo;
	/**
	 * @mbggenerated pos机ID
	 */
	private String posMachineId;
	/**
	 * @mbggenerated 创建人
	 */
	private Integer createUid;
	/**
	 * @mbggenerated 诚意金-1 代收-2 合同的 按照款项ID
	 */
	private Integer paymentId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFinanceType() {
		return financeType;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceType(Byte financeType) {
		this.financeType = financeType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFinanceId() {
		return financeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}

	/**
	 * @mbggenerated
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPayStatus() {
		return payStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getFinanceMoney() {
		return financeMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceMoney(BigDecimal financeMoney) {
		this.financeMoney = financeMoney;
	}

	/**
	 * @mbggenerated
	 */
	public String getFinanceName() {
		return financeName;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceName(String financeName) {
		this.financeName = financeName == null ? null : financeName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPayAccount() {
		return payAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount == null ? null : payAccount.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPayUserName() {
		return payUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayUserName(String payUserName) {
		this.payUserName = payUserName == null ? null : payUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo == null ? null : caseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPosMachineId() {
		return posMachineId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPosMachineId(String posMachineId) {
		this.posMachineId = posMachineId == null ? null : posMachineId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpPosPaymentOrder() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpPosPaymentOrder(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}