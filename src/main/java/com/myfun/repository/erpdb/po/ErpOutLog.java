package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ErpOutLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 系统自增
	 */
	@ApiModelProperty(value = "外出id")
	private Integer outId;
	/**
	 * @mbggenerated 公司ID
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 分店ID
	 */
	@ApiModelProperty(value = "分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated 外出员工，USER_ID
	 */
	@ApiModelProperty(value = "外出员工，USER_ID")
	private Integer outUser;
	/**
	 * @mbggenerated 外出时间
	 */
	@ApiModelProperty(value = "外出时间")
	private String outTime;
	/**
	 * @mbggenerated 预计返回时间，DD:EXPECT_BACKTIMESS
	 */
	@ApiModelProperty(value = "预计返回时间，DD:EXPECT_BACKTIMESS")
	private Integer expectBacktime;
	/**
	 * @mbggenerated 外出事由
	 */
	@ApiModelProperty(value = "外出事由")
	private String outDesc;
	/**
	 * @mbggenerated 返回时间
	 */
	@ApiModelProperty(value = "返回时间")
	private String backTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "外出员工姓名")
	private String outUserName;
	/**
	 * @mbggenerated 签到次数
	 */
	@ApiModelProperty(value = "签到次数")
	private Integer checkInCount;
	/**
	 * @mbggenerated 审核Id
	 */
	@ApiModelProperty(value = "审核Id")
	private Integer auditId;
	/**
	 * @mbggenerated 考核月
	 */
	@ApiModelProperty(value = "考核月")
	private String assessmentMonth;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getOutId() {
		return outId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutId(Integer outId) {
		this.outId = outId;
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
	public Integer getOutUser() {
		return outUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutUser(Integer outUser) {
		this.outUser = outUser;
	}

	/**
	 * @mbggenerated
	 */
	public String getOutTime() {
		return outTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutTime(String outTime) {
		this.outTime = outTime == null ? null : outTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getExpectBacktime() {
		return expectBacktime;
	}

	/**
	 * @mbggenerated
	 */
	public void setExpectBacktime(Integer expectBacktime) {
		this.expectBacktime = expectBacktime;
	}

	/**
	 * @mbggenerated
	 */
	public String getOutDesc() {
		return outDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutDesc(String outDesc) {
		this.outDesc = outDesc == null ? null : outDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBackTime() {
		return backTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBackTime(String backTime) {
		this.backTime = backTime == null ? null : backTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOutUserName() {
		return outUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName == null ? null : outUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCheckInCount() {
		return checkInCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckInCount(Integer checkInCount) {
		this.checkInCount = checkInCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpOutLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpOutLog(Integer shardCityId, Integer outId) {
		super(shardCityId);
		this.outId = outId;
	}
}