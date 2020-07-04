package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class ErpFunKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer keyId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型:1出售2出租")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙所属门店")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙编号")
	private String keyNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "员工ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private String creatorTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙状态 0=只有钥匙备注 1=借出 2=归还 3=删除")
	private Byte keyStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙日志ID")
	private Integer keyLogId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用途")
	private Byte useage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙所在门店ID")
	private Integer keyDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙借用日志 1=内部 2=外部")
	private Integer logType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "归档时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "注销时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用时间")
	private Date borrowKeyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用人电话")
	private String borrowPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "押金")
	private Integer currentDeposit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记人")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用人")
	private String borrowUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "到期时间")
	private Date maxBorrowTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = " 已支付=1 已退还=2   已扣押=3 正在支付=4")
	private Integer depositStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙凭证")
	private String keyVoucher;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte keyType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer keyCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date gatherTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer lendCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String keyPassword;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getKeyId() {
		return keyId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
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
	 * @mbggenerated 房源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源类型:1出售2出租
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型:1出售2出租
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 钥匙所属门店
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 钥匙所属门店
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 钥匙跟进ID
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 钥匙跟进ID
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public String getKeyNum() {
		return keyNum;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}

	/**
	 * @mbggenerated 员工ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 员工ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreatorTime() {
		return creatorTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreatorTime(String creatorTime) {
		this.creatorTime = creatorTime;
	}

	/**
	 * @mbggenerated 钥匙状态 0=只有钥匙备注 1=借出 2=归还 3=删除
	 */
	public Byte getKeyStatus() {
		return keyStatus;
	}

	/**
	 * @mbggenerated 钥匙状态 0=只有钥匙备注 1=借出 2=归还 3=删除
	 */
	public void setKeyStatus(Byte keyStatus) {
		this.keyStatus = keyStatus;
	}

	/**
	 * @mbggenerated 钥匙日志ID
	 */
	public Integer getKeyLogId() {
		return keyLogId;
	}

	/**
	 * @mbggenerated 钥匙日志ID
	 */
	public void setKeyLogId(Integer keyLogId) {
		this.keyLogId = keyLogId;
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
	 * @mbggenerated 用途
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated 用途
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated 钥匙所在门店ID
	 */
	public Integer getKeyDeptId() {
		return keyDeptId;
	}

	/**
	 * @mbggenerated 钥匙所在门店ID
	 */
	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}

	/**
	 * @mbggenerated 钥匙借用日志 1=内部 2=外部
	 */
	public Integer getLogType() {
		return logType;
	}

	/**
	 * @mbggenerated 钥匙借用日志 1=内部 2=外部
	 */
	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	/**
	 * @mbggenerated 归档时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 归档时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 注销时间
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 注销时间
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated 借用时间
	 */
	public Date getBorrowKeyTime() {
		return borrowKeyTime;
	}

	/**
	 * @mbggenerated 借用时间
	 */
	public void setBorrowKeyTime(Date borrowKeyTime) {
		this.borrowKeyTime = borrowKeyTime;
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
		this.borrowPhone = borrowPhone;
	}

	/**
	 * @mbggenerated 押金
	 */
	public Integer getCurrentDeposit() {
		return currentDeposit;
	}

	/**
	 * @mbggenerated 押金
	 */
	public void setCurrentDeposit(Integer currentDeposit) {
		this.currentDeposit = currentDeposit;
	}

	/**
	 * @mbggenerated 登记人
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 登记人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 借用人
	 */
	public String getBorrowUser() {
		return borrowUser;
	}

	/**
	 * @mbggenerated 借用人
	 */
	public void setBorrowUser(String borrowUser) {
		this.borrowUser = borrowUser;
	}

	/**
	 * @mbggenerated 到期时间
	 */
	public Date getMaxBorrowTime() {
		return maxBorrowTime;
	}

	/**
	 * @mbggenerated 到期时间
	 */
	public void setMaxBorrowTime(Date maxBorrowTime) {
		this.maxBorrowTime = maxBorrowTime;
	}

	/**
	 * @mbggenerated 已支付=1 已退还=2   已扣押=3 正在支付=4
	 */
	public Integer getDepositStatus() {
		return depositStatus;
	}

	/**
	 * @mbggenerated 已支付=1 已退还=2   已扣押=3 正在支付=4
	 */
	public void setDepositStatus(Integer depositStatus) {
		this.depositStatus = depositStatus;
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
	 * @mbggenerated 钥匙凭证
	 */
	public String getKeyVoucher() {
		return keyVoucher;
	}

	/**
	 * @mbggenerated 钥匙凭证
	 */
	public void setKeyVoucher(String keyVoucher) {
		this.keyVoucher = keyVoucher;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getKeyType() {
		return keyType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setKeyType(Byte keyType) {
		this.keyType = keyType;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getKeyCount() {
		return keyCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setKeyCount(Integer keyCount) {
		this.keyCount = keyCount;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getGatherTime() {
		return gatherTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setGatherTime(Date gatherTime) {
		this.gatherTime = gatherTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getLendCount() {
		return lendCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLendCount(Integer lendCount) {
		this.lendCount = lendCount;
	}

	/**
	 * @mbggenerated -
	 */
	public String getKeyPassword() {
		return keyPassword;
	}

	/**
	 * @mbggenerated -
	 */
	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunKey(Integer shardCityId, Integer keyId) {
		super(shardCityId);
		this.keyId = keyId;
	}
}