package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class ErpFunWageLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "薪资调整日志ID")
	private Integer wageLogId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "薪资表ID")
	private Integer wageId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备注说明")
	private String explain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "增加工资")
	private BigDecimal addWage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "减少薪资")
	private BigDecimal reduceWage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "工资调整人ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "工资调整人名字")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "调整薪资（基于原始值）")
	private BigDecimal adjustWage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "数据是否删除 0 未删除 1删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "日志类型 1=调整 2=代扣代缴 3=奖金  4=扣款 5=审核")
	private Integer logType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "薪资所属人")
	private Integer wageUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织综合查询字段 :12001:12002:12003:")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 薪资调整日志ID
	 */
	public Integer getWageLogId() {
		return wageLogId;
	}

	/**
	 * @mbggenerated 薪资调整日志ID
	 */
	public void setWageLogId(Integer wageLogId) {
		this.wageLogId = wageLogId;
	}

	/**
	 * @mbggenerated 薪资表ID
	 */
	public Integer getWageId() {
		return wageId;
	}

	/**
	 * @mbggenerated 薪资表ID
	 */
	public void setWageId(Integer wageId) {
		this.wageId = wageId;
	}

	/**
	 * @mbggenerated 备注说明
	 */
	public String getExplain() {
		return explain;
	}

	/**
	 * @mbggenerated 备注说明
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}

	/**
	 * @mbggenerated 增加工资
	 */
	public BigDecimal getAddWage() {
		return addWage;
	}

	/**
	 * @mbggenerated 增加工资
	 */
	public void setAddWage(BigDecimal addWage) {
		this.addWage = addWage;
	}

	/**
	 * @mbggenerated 减少薪资
	 */
	public BigDecimal getReduceWage() {
		return reduceWage;
	}

	/**
	 * @mbggenerated 减少薪资
	 */
	public void setReduceWage(BigDecimal reduceWage) {
		this.reduceWage = reduceWage;
	}

	/**
	 * @mbggenerated 工资调整人ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 工资调整人ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 工资调整人名字
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 工资调整人名字
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 调整薪资（基于原始值）
	 */
	public BigDecimal getAdjustWage() {
		return adjustWage;
	}

	/**
	 * @mbggenerated 调整薪资（基于原始值）
	 */
	public void setAdjustWage(BigDecimal adjustWage) {
		this.adjustWage = adjustWage;
	}

	/**
	 * @mbggenerated 数据是否删除 0 未删除 1删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 数据是否删除 0 未删除 1删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 操作时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 操作时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	 * @mbggenerated 日志类型 1=调整 2=代扣代缴 3=奖金  4=扣款 5=审核
	 */
	public Integer getLogType() {
		return logType;
	}

	/**
	 * @mbggenerated 日志类型 1=调整 2=代扣代缴 3=奖金  4=扣款 5=审核
	 */
	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	/**
	 * @mbggenerated 薪资所属人
	 */
	public Integer getWageUserId() {
		return wageUserId;
	}

	/**
	 * @mbggenerated 薪资所属人
	 */
	public void setWageUserId(Integer wageUserId) {
		this.wageUserId = wageUserId;
	}

	/**
	 * @mbggenerated 大区ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
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
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageLog(Integer shardCityId, Integer wageLogId) {
		super(shardCityId);
		this.wageLogId = wageLogId;
	}
}