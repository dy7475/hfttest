package com.myfun.repository.erpdb.param;

import java.util.Date;

import com.myfun.repository.param.EncryParamIfc;

/**
 * 创建外出审核参数
 * @author 张宏利
 * @since 2017年10月11日
 */
public class ErpOaOutAuditParam implements EncryParamIfc{
	private Integer    outType            ;// 外出类型
	private Date       outStartTime       ;// 外出时间
	private Date       outEndTime         ;// 外出返回时间
	private String     outReason          ;// 外出原因
	private String     targetIds          ;// 目标ID，多个以英文逗号分隔
	private String     targetTypes        ;// 目标信息类型，和目标ID一一对应
	private Integer    isMobileApi        ;// 是否来自手机端 1=手机端
	// 会话获取
	private Integer    cityId             ;// 城市ID
	private Integer    compId             ;// 公司ID
	private Integer    selfAreaId         ;// 当前用户大区ID
	private Integer    selfRegId          ;// 当前用户片区ID
	private Integer    selfDeptId         ;// 当前用户门店ID
	private Integer    selfGrId           ;// 当前用户分组ID
	private Integer    selfUserId         ;// 当前用户ID
	private Integer    selfArchiveId      ;// 当前用户档案ID
	private String     selfUserName       ;// 当前登录用户名
	private String     selfDeptName       ;// 当前用户门店名称
	
	private Integer    createAuditDeptId  ;// 创建审核任务的用户门店ID
	private Integer    createAuditUserId  ;// 创建审核任务的用户ID
	
	public Date getOutStartTime() {
		return outStartTime;
	}

	public void setOutStartTime(Date outStartTime) {
		this.outStartTime = outStartTime;
	}

	public Date getOutEndTime() {
		return outEndTime;
	}


	public void setOutEndTime(Date outEndTime) {
		this.outEndTime = outEndTime;
	}


	public String getOutReason() {
		return outReason;
	}


	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getSelfAreaId() {
		return selfAreaId;
	}
	public void setSelfAreaId(Integer selfAreaId) {
		this.selfAreaId = selfAreaId;
	}
	public Integer getSelfRegId() {
		return selfRegId;
	}
	public void setSelfRegId(Integer selfRegId) {
		this.selfRegId = selfRegId;
	}
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public Integer getSelfGrId() {
		return selfGrId;
	}
	public void setSelfGrId(Integer selfGrId) {
		this.selfGrId = selfGrId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	
	public Integer getIsMobileApi() {
		return isMobileApi;
	}

	public void setIsMobileApi(Integer isMobileApi) {
		this.isMobileApi = isMobileApi;
	}

	public Integer getOutType() {
		return outType;
	}


	public void setOutType(Integer outType) {
		this.outType = outType;
	}


	public String getTargetIds() {
		return targetIds;
	}


	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}

	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}

	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}

	public String getSelfUserName() {
		return selfUserName;
	}

	public void setSelfUserName(String selfUserName) {
		this.selfUserName = selfUserName;
	}

	public String getSelfDeptName() {
		return selfDeptName;
	}

	public void setSelfDeptName(String selfDeptName) {
		this.selfDeptName = selfDeptName;
	}

	public Integer getCreateAuditDeptId() {
		return createAuditDeptId;
	}

	public void setCreateAuditDeptId(Integer createAuditDeptId) {
		this.createAuditDeptId = createAuditDeptId;
	}

	public Integer getCreateAuditUserId() {
		return createAuditUserId;
	}

	public void setCreateAuditUserId(Integer createAuditUserId) {
		this.createAuditUserId = createAuditUserId;
	}

	public String getTargetTypes() {
		return targetTypes;
	}

	public void setTargetTypes(String targetTypes) {
		this.targetTypes = targetTypes;
	}
}

