package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunKeyOperationLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙ID")
	private Integer keyId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙编号")
	private String keyNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作人ID")
	private Integer operationUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核人ID")
	private Integer confirmUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作描述")
	private String operationDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙状态")
	private Byte keyStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内借1 外借2")
	private Integer borrowType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "借用人")
	private String borrowUser;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @mbggenerated 钥匙ID
	 */
	public Integer getKeyId() {
		return keyId;
	}

	/**
	 * @mbggenerated 钥匙ID
	 */
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
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
		this.keyNum = keyNum == null ? null : keyNum.trim();
	}

	/**
	 * @mbggenerated 操作人ID
	 */
	public Integer getOperationUser() {
		return operationUser;
	}

	/**
	 * @mbggenerated 操作人ID
	 */
	public void setOperationUser(Integer operationUser) {
		this.operationUser = operationUser;
	}

	/**
	 * @mbggenerated 审核人ID
	 */
	public Integer getConfirmUser() {
		return confirmUser;
	}

	/**
	 * @mbggenerated 审核人ID
	 */
	public void setConfirmUser(Integer confirmUser) {
		this.confirmUser = confirmUser;
	}

	/**
	 * @mbggenerated 操作时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 操作时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 操作描述
	 */
	public String getOperationDesc() {
		return operationDesc;
	}

	/**
	 * @mbggenerated 操作描述
	 */
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc == null ? null : operationDesc.trim();
	}

	/**
	 * @mbggenerated 钥匙状态
	 */
	public Byte getKeyStatus() {
		return keyStatus;
	}

	/**
	 * @mbggenerated 钥匙状态
	 */
	public void setKeyStatus(Byte keyStatus) {
		this.keyStatus = keyStatus;
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
		this.caseNo = caseNo == null ? null : caseNo.trim();
	}

	/**
	 * @mbggenerated 内借1 外借2
	 */
	public Integer getBorrowType() {
		return borrowType;
	}

	/**
	 * @mbggenerated 内借1 外借2
	 */
	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
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
		this.borrowUser = borrowUser == null ? null : borrowUser.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunKeyOperationLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunKeyOperationLog(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}