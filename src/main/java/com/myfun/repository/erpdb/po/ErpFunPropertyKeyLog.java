package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunPropertyKeyLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "日志ID")
	private Integer funPropertyKeyLogId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用人电话")
	private String borrowPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用人姓名")
	private String borrowName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当前押金金额")
	private BigDecimal currentDeposit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "支付订单ID")
	private String payId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开始借用时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配置的借用时间")
	private Integer maxBorrowHour;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙状态 归还=2 借出中=1超时中=3  正在被借=4")
	private Integer keyStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "押金状态 已支付=1 已退还=2   已扣押=3 正在支付=4")
	private Integer depositStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记人ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "关联的钥匙ID")
	private Integer funKeyId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型 1出租  2出售")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "过期时间")
	private Date maxBorrowTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼号")
	private String buildFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改日期")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋号")
	private String buildRoof;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元")
	private String buildUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "号")
	private String buildNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记人姓名")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "身份证号码")
	private String idCardNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司Id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源Id")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "小区名称")
	private String buildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 日志ID
	 */
	public Integer getFunPropertyKeyLogId() {
		return funPropertyKeyLogId;
	}

	/**
	 * @mbggenerated 日志ID
	 */
	public void setFunPropertyKeyLogId(Integer funPropertyKeyLogId) {
		this.funPropertyKeyLogId = funPropertyKeyLogId;
	}

	/**
	 * @mbggenerated 借用人电话
	 */
	public String getBorrowPhone() {
		return borrowPhone;
	}

	/**
	 * @mbggenerated 借用人电话
	 */
	public void setBorrowPhone(String borrowPhone) {
		this.borrowPhone = borrowPhone == null ? null : borrowPhone.trim();
	}

	/**
	 * @mbggenerated 借用人姓名
	 */
	public String getBorrowName() {
		return borrowName;
	}

	/**
	 * @mbggenerated 借用人姓名
	 */
	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName == null ? null : borrowName.trim();
	}

	/**
	 * @mbggenerated 当前押金金额
	 */
	public BigDecimal getCurrentDeposit() {
		return currentDeposit;
	}

	/**
	 * @mbggenerated 当前押金金额
	 */
	public void setCurrentDeposit(BigDecimal currentDeposit) {
		this.currentDeposit = currentDeposit;
	}

	/**
	 * @mbggenerated 支付订单ID
	 */
	public String getPayId() {
		return payId;
	}

	/**
	 * @mbggenerated 支付订单ID
	 */
	public void setPayId(String payId) {
		this.payId = payId == null ? null : payId.trim();
	}

	/**
	 * @mbggenerated 开始借用时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 开始借用时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 配置的借用时间
	 */
	public Integer getMaxBorrowHour() {
		return maxBorrowHour;
	}

	/**
	 * @mbggenerated 配置的借用时间
	 */
	public void setMaxBorrowHour(Integer maxBorrowHour) {
		this.maxBorrowHour = maxBorrowHour;
	}

	/**
	 * @mbggenerated 钥匙状态 归还=2 借出中=1超时中=3  正在被借=4
	 */
	public Integer getKeyStatus() {
		return keyStatus;
	}

	/**
	 * @mbggenerated 钥匙状态 归还=2 借出中=1超时中=3  正在被借=4
	 */
	public void setKeyStatus(Integer keyStatus) {
		this.keyStatus = keyStatus;
	}

	/**
	 * @mbggenerated 押金状态 已支付=1 已退还=2   已扣押=3 正在支付=4
	 */
	public Integer getDepositStatus() {
		return depositStatus;
	}

	/**
	 * @mbggenerated 押金状态 已支付=1 已退还=2   已扣押=3 正在支付=4
	 */
	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
	}

	/**
	 * @mbggenerated 登记人ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 登记人ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 关联的钥匙ID
	 */
	public Integer getFunKeyId() {
		return funKeyId;
	}

	/**
	 * @mbggenerated 关联的钥匙ID
	 */
	public void setFunKeyId(Integer funKeyId) {
		this.funKeyId = funKeyId;
	}

	/**
	 * @mbggenerated 房源类型 1出租  2出售
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型 1出租  2出售
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 过期时间
	 */
	public Date getMaxBorrowTime() {
		return maxBorrowTime;
	}

	/**
	 * @mbggenerated 过期时间
	 */
	public void setMaxBorrowTime(Date maxBorrowTime) {
		this.maxBorrowTime = maxBorrowTime;
	}

	/**
	 * @mbggenerated 楼号
	 */
	public String getBuildFloor() {
		return buildFloor;
	}

	/**
	 * @mbggenerated 楼号
	 */
	public void setBuildFloor(String buildFloor) {
		this.buildFloor = buildFloor == null ? null : buildFloor.trim();
	}

	/**
	 * @mbggenerated 修改日期
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改日期
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 栋号
	 */
	public String getBuildRoof() {
		return buildRoof;
	}

	/**
	 * @mbggenerated 栋号
	 */
	public void setBuildRoof(String buildRoof) {
		this.buildRoof = buildRoof == null ? null : buildRoof.trim();
	}

	/**
	 * @mbggenerated 单元
	 */
	public String getBuildUnit() {
		return buildUnit;
	}

	/**
	 * @mbggenerated 单元
	 */
	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit == null ? null : buildUnit.trim();
	}

	/**
	 * @mbggenerated 号
	 */
	public String getBuildNum() {
		return buildNum;
	}

	/**
	 * @mbggenerated 号
	 */
	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum == null ? null : buildNum.trim();
	}

	/**
	 * @mbggenerated 登记人姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 登记人姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated 身份证号码
	 */
	public String getIdCardNum() {
		return idCardNum;
	}

	/**
	 * @mbggenerated 身份证号码
	 */
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum == null ? null : idCardNum.trim();
	}

	/**
	 * @mbggenerated 公司Id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司Id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 房源Id
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源Id
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 小区名称
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated 小区名称
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPropertyKeyLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPropertyKeyLog(Integer shardCityId, Integer funPropertyKeyLogId) {
		super(shardCityId);
		this.funPropertyKeyLogId = funPropertyKeyLogId;
	}
}