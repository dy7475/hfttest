package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminPropertyWithdrawManage implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市id")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司编号")
	private String compNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp库公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp库门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店编号")
	private String deptNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打款状态 0:待打款 1已打款 2：已到账")
	private Byte withdrawStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请时间")
	private Date applyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打款时间")
	private Date withdrawTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "到账时间")
	private Date arrivalTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "银行")
	private Integer receiveBankType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "银行名称")
	private String receiveBankName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "银行账号")
	private String receiveBankNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提现金额")
	private BigDecimal withdrawAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请人")
	private Integer applyUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请人电话")
	private String applyUserMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手续费")
	private BigDecimal brokerageFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店名称")
	private String deptName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请人名称")
	private String applyUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总申请提现金额")
	private BigDecimal totalApplyMoney;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 城市id
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市id
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 公司编号
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated 公司编号
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @mbggenerated erp库公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated erp库公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated erp库门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated erp库门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 门店编号
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @mbggenerated 门店编号
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @mbggenerated 打款状态 0:待打款 1已打款 2：已到账
	 */
	public Byte getWithdrawStatus() {
		return withdrawStatus;
	}

	/**
	 * @mbggenerated 打款状态 0:待打款 1已打款 2：已到账
	 */
	public void setWithdrawStatus(Byte withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	/**
	 * @mbggenerated 申请时间
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * @mbggenerated 申请时间
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @mbggenerated 打款时间
	 */
	public Date getWithdrawTime() {
		return withdrawTime;
	}

	/**
	 * @mbggenerated 打款时间
	 */
	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	/**
	 * @mbggenerated 到账时间
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @mbggenerated 到账时间
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @mbggenerated 银行
	 */
	public Integer getReceiveBankType() {
		return receiveBankType;
	}

	/**
	 * @mbggenerated 银行
	 */
	public void setReceiveBankType(Integer receiveBankType) {
		this.receiveBankType = receiveBankType;
	}

	/**
	 * @mbggenerated 银行名称
	 */
	public String getReceiveBankName() {
		return receiveBankName;
	}

	/**
	 * @mbggenerated 银行名称
	 */
	public void setReceiveBankName(String receiveBankName) {
		this.receiveBankName = receiveBankName;
	}

	/**
	 * @mbggenerated 银行账号
	 */
	public String getReceiveBankNo() {
		return receiveBankNo;
	}

	/**
	 * @mbggenerated 银行账号
	 */
	public void setReceiveBankNo(String receiveBankNo) {
		this.receiveBankNo = receiveBankNo;
	}

	/**
	 * @mbggenerated 提现金额
	 */
	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	/**
	 * @mbggenerated 提现金额
	 */
	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	/**
	 * @mbggenerated 申请人
	 */
	public Integer getApplyUserId() {
		return applyUserId;
	}

	/**
	 * @mbggenerated 申请人
	 */
	public void setApplyUserId(Integer applyUserId) {
		this.applyUserId = applyUserId;
	}

	/**
	 * @mbggenerated 申请人电话
	 */
	public String getApplyUserMobile() {
		return applyUserMobile;
	}

	/**
	 * @mbggenerated 申请人电话
	 */
	public void setApplyUserMobile(String applyUserMobile) {
		this.applyUserMobile = applyUserMobile;
	}

	/**
	 * @mbggenerated 手续费
	 */
	public BigDecimal getBrokerageFee() {
		return brokerageFee;
	}

	/**
	 * @mbggenerated 手续费
	 */
	public void setBrokerageFee(BigDecimal brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

	/**
	 * @mbggenerated 门店名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 门店名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @mbggenerated 申请人名称
	 */
	public String getApplyUserName() {
		return applyUserName;
	}

	/**
	 * @mbggenerated 申请人名称
	 */
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	/**
	 * @mbggenerated 总申请提现金额
	 */
	public BigDecimal getTotalApplyMoney() {
		return totalApplyMoney;
	}

	/**
	 * @mbggenerated 总申请提现金额
	 */
	public void setTotalApplyMoney(BigDecimal totalApplyMoney) {
		this.totalApplyMoney = totalApplyMoney;
	}
}