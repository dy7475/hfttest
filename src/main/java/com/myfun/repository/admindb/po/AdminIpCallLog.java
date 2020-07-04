package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class AdminIpCallLog implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发沙发沙发")
	private String logId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息类型，1：出售2：出租3：求购4：求租5:搜搜出售6:搜搜出租7:搜搜转铺8:搜搜合租9:直供出售10:直供出租11:直供求购12:直供求租13:需求出售14:需求出租15:需求求购16:需求求租17:滴滴求购18:滴滴求租23:YOU+出售24:YOU+出租25:YOU+楼盘 26:管理中心楼盘资料 27:好房YOU+求购 28:YOUYOU好房 38:房源联卖  39:物业版合作拨打 40:物业版历史访客客户 41:crm开单豹注册邀约 42:开单豹抢客")
	private Byte callType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人手机号码")
	private String callPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "被叫号码")
	private String calledPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人公司ID")
	private Integer callCompId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人门店ID")
	private Integer callDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人用户ID")
	private Integer callUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人档案ID")
	private Integer callArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人资金账户ID")
	private Integer callUaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer callCityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源Id")
	private Integer targetId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer targetDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1.出售 2.出租  3.求购 4.求租")
	private Byte targetType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte targetPlateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源所属人ID")
	private Integer targetOwnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer targetUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String targetNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "计费开始时间")
	private Date startTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "计费结束时间")
	private Date endTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打时长（单位秒，计费时长）")
	private Integer callLength;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打费用(单位元，1分钟0.1元)")
	private BigDecimal callFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal callAmountBefore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal callAmountAfter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte cutReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte reasonDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "路径")
	private String callRecordUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否下载")
	private Byte isDownloadRecord;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "FUN_PAID表主键")
	private Integer paidId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1= 去电 2=来电")
	private Byte logSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打时间（非打通时间，不是计费开始的时间）")
	private Date callTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer voipPoolId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三方语音地址")
	private String thirdRecordUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String poolLockId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal compAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal userAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte thirdChannel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte isCallback;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer voipMinute;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0 = 来电 1=（app） 2 =（pc）")
	private Byte targetSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "扩展字段，保存json格式的字符串")
	private String extendJson;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户使用的好房币")
	private BigDecimal userCoin;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户使用的优惠券")
	private BigDecimal userQuan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司使用的好房币")
	private BigDecimal compCoin;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司使用的优惠券")
	private BigDecimal compQuan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人大区ID")
	private Integer callAreaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人片区ID")
	private Integer callRegId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "拨打人分组ID")
	private Integer callGrId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "个人扣除金额")
	private BigDecimal cashMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司扣除")
	private BigDecimal compCashMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是房多多（0.否，1.是）")
	private Byte isFdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "虚拟号码")
	private String fddHiddenNumber;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "AXB拨打记录的数据唯一标识.")
	private String callId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0只记录1已经扣费")
	private Integer axbStyle;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "扣费失败原因")
	private String deductionFailureReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "父LOG_ID")
	private String parentLogId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "联卖需求增加字段 1=客服2=经纪人")
	private Integer housingSaleFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源状态 DD: HOUSE_STATUS")
	private Byte targetCaseStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构线")
	private String tissueLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String bindX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org1;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org2;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org3;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org4;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org6;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org7;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org8;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org9;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org10;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org11;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org12;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org13;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org14;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String callUserName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated -
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 发沙发沙发
	 */
	public String getLogId() {
		return logId;
	}

	/**
	 * @mbggenerated 发沙发沙发
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}

	/**
	 * @mbggenerated 信息类型，1：出售2：出租3：求购4：求租5:搜搜出售6:搜搜出租7:搜搜转铺8:搜搜合租9:直供出售10:直供出租11:直供求购12:直供求租13:需求出售14:需求出租15:需求求购16:需求求租17:滴滴求购18:滴滴求租23:YOU+出售24:YOU+出租25:YOU+楼盘 26:管理中心楼盘资料 27:好房YOU+求购 28:YOUYOU好房 38:房源联卖  39:物业版合作拨打 40:物业版历史访客客户 41:crm开单豹注册邀约 42:开单豹抢客
	 */
	public Byte getCallType() {
		return callType;
	}

	/**
	 * @mbggenerated 信息类型，1：出售2：出租3：求购4：求租5:搜搜出售6:搜搜出租7:搜搜转铺8:搜搜合租9:直供出售10:直供出租11:直供求购12:直供求租13:需求出售14:需求出租15:需求求购16:需求求租17:滴滴求购18:滴滴求租23:YOU+出售24:YOU+出租25:YOU+楼盘 26:管理中心楼盘资料 27:好房YOU+求购 28:YOUYOU好房 38:房源联卖  39:物业版合作拨打 40:物业版历史访客客户 41:crm开单豹注册邀约 42:开单豹抢客
	 */
	public void setCallType(Byte callType) {
		this.callType = callType;
	}

	/**
	 * @mbggenerated 拨打人手机号码
	 */
	public String getCallPhone() {
		return callPhone;
	}

	/**
	 * @mbggenerated 拨打人手机号码
	 */
	public void setCallPhone(String callPhone) {
		this.callPhone = callPhone;
	}

	/**
	 * @mbggenerated 被叫号码
	 */
	public String getCalledPhone() {
		return calledPhone;
	}

	/**
	 * @mbggenerated 被叫号码
	 */
	public void setCalledPhone(String calledPhone) {
		this.calledPhone = calledPhone;
	}

	/**
	 * @mbggenerated 拨打人公司ID
	 */
	public Integer getCallCompId() {
		return callCompId;
	}

	/**
	 * @mbggenerated 拨打人公司ID
	 */
	public void setCallCompId(Integer callCompId) {
		this.callCompId = callCompId;
	}

	/**
	 * @mbggenerated 拨打人门店ID
	 */
	public Integer getCallDeptId() {
		return callDeptId;
	}

	/**
	 * @mbggenerated 拨打人门店ID
	 */
	public void setCallDeptId(Integer callDeptId) {
		this.callDeptId = callDeptId;
	}

	/**
	 * @mbggenerated 拨打人用户ID
	 */
	public Integer getCallUserId() {
		return callUserId;
	}

	/**
	 * @mbggenerated 拨打人用户ID
	 */
	public void setCallUserId(Integer callUserId) {
		this.callUserId = callUserId;
	}

	/**
	 * @mbggenerated 拨打人档案ID
	 */
	public Integer getCallArchiveId() {
		return callArchiveId;
	}

	/**
	 * @mbggenerated 拨打人档案ID
	 */
	public void setCallArchiveId(Integer callArchiveId) {
		this.callArchiveId = callArchiveId;
	}

	/**
	 * @mbggenerated 拨打人资金账户ID
	 */
	public Integer getCallUaId() {
		return callUaId;
	}

	/**
	 * @mbggenerated 拨打人资金账户ID
	 */
	public void setCallUaId(Integer callUaId) {
		this.callUaId = callUaId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCallCityId() {
		return callCityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCallCityId(Integer callCityId) {
		this.callCityId = callCityId;
	}

	/**
	 * @mbggenerated 房源Id
	 */
	public Integer getTargetId() {
		return targetId;
	}

	/**
	 * @mbggenerated 房源Id
	 */
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getTargetDept() {
		return targetDept;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}

	/**
	 * @mbggenerated 1.出售 2.出租  3.求购 4.求租
	 */
	public Byte getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated 1.出售 2.出租  3.求购 4.求租
	 */
	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getTargetPlateType() {
		return targetPlateType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTargetPlateType(Byte targetPlateType) {
		this.targetPlateType = targetPlateType;
	}

	/**
	 * @mbggenerated 房源所属人ID
	 */
	public Integer getTargetOwnerId() {
		return targetOwnerId;
	}

	/**
	 * @mbggenerated 房源所属人ID
	 */
	public void setTargetOwnerId(Integer targetOwnerId) {
		this.targetOwnerId = targetOwnerId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getTargetUseage() {
		return targetUseage;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTargetUseage(Integer targetUseage) {
		this.targetUseage = targetUseage;
	}

	/**
	 * @mbggenerated -
	 */
	public String getTargetNo() {
		return targetNo;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	/**
	 * @mbggenerated 计费开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @mbggenerated 计费开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @mbggenerated 计费结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @mbggenerated 计费结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @mbggenerated 拨打时长（单位秒，计费时长）
	 */
	public Integer getCallLength() {
		return callLength;
	}

	/**
	 * @mbggenerated 拨打时长（单位秒，计费时长）
	 */
	public void setCallLength(Integer callLength) {
		this.callLength = callLength;
	}

	/**
	 * @mbggenerated 拨打费用(单位元，1分钟0.1元)
	 */
	public BigDecimal getCallFee() {
		return callFee;
	}

	/**
	 * @mbggenerated 拨打费用(单位元，1分钟0.1元)
	 */
	public void setCallFee(BigDecimal callFee) {
		this.callFee = callFee;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getCallAmountBefore() {
		return callAmountBefore;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCallAmountBefore(BigDecimal callAmountBefore) {
		this.callAmountBefore = callAmountBefore;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getCallAmountAfter() {
		return callAmountAfter;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCallAmountAfter(BigDecimal callAmountAfter) {
		this.callAmountAfter = callAmountAfter;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getCutReason() {
		return cutReason;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCutReason(Byte cutReason) {
		this.cutReason = cutReason;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getReasonDesc() {
		return reasonDesc;
	}

	/**
	 * @mbggenerated -
	 */
	public void setReasonDesc(Byte reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	/**
	 * @mbggenerated 路径
	 */
	public String getCallRecordUrl() {
		return callRecordUrl;
	}

	/**
	 * @mbggenerated 路径
	 */
	public void setCallRecordUrl(String callRecordUrl) {
		this.callRecordUrl = callRecordUrl;
	}

	/**
	 * @mbggenerated 是否下载
	 */
	public Byte getIsDownloadRecord() {
		return isDownloadRecord;
	}

	/**
	 * @mbggenerated 是否下载
	 */
	public void setIsDownloadRecord(Byte isDownloadRecord) {
		this.isDownloadRecord = isDownloadRecord;
	}

	/**
	 * @mbggenerated FUN_PAID表主键
	 */
	public Integer getPaidId() {
		return paidId;
	}

	/**
	 * @mbggenerated FUN_PAID表主键
	 */
	public void setPaidId(Integer paidId) {
		this.paidId = paidId;
	}

	/**
	 * @mbggenerated 1= 去电 2=来电
	 */
	public Byte getLogSource() {
		return logSource;
	}

	/**
	 * @mbggenerated 1= 去电 2=来电
	 */
	public void setLogSource(Byte logSource) {
		this.logSource = logSource;
	}

	/**
	 * @mbggenerated 拨打时间（非打通时间，不是计费开始的时间）
	 */
	public Date getCallTime() {
		return callTime;
	}

	/**
	 * @mbggenerated 拨打时间（非打通时间，不是计费开始的时间）
	 */
	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getVoipPoolId() {
		return voipPoolId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setVoipPoolId(Integer voipPoolId) {
		this.voipPoolId = voipPoolId;
	}

	/**
	 * @mbggenerated 第三方语音地址
	 */
	public String getThirdRecordUrl() {
		return thirdRecordUrl;
	}

	/**
	 * @mbggenerated 第三方语音地址
	 */
	public void setThirdRecordUrl(String thirdRecordUrl) {
		this.thirdRecordUrl = thirdRecordUrl;
	}

	/**
	 * @mbggenerated -
	 */
	public String getPoolLockId() {
		return poolLockId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPoolLockId(String poolLockId) {
		this.poolLockId = poolLockId;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getCompAmount() {
		return compAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompAmount(BigDecimal compAmount) {
		this.compAmount = compAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getUserAmount() {
		return userAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserAmount(BigDecimal userAmount) {
		this.userAmount = userAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getThirdChannel() {
		return thirdChannel;
	}

	/**
	 * @mbggenerated -
	 */
	public void setThirdChannel(Byte thirdChannel) {
		this.thirdChannel = thirdChannel;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getIsCallback() {
		return isCallback;
	}

	/**
	 * @mbggenerated -
	 */
	public void setIsCallback(Byte isCallback) {
		this.isCallback = isCallback;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getVoipMinute() {
		return voipMinute;
	}

	/**
	 * @mbggenerated -
	 */
	public void setVoipMinute(Integer voipMinute) {
		this.voipMinute = voipMinute;
	}

	/**
	 * @mbggenerated 0 = 来电 1=（app） 2 =（pc）
	 */
	public Byte getTargetSource() {
		return targetSource;
	}

	/**
	 * @mbggenerated 0 = 来电 1=（app） 2 =（pc）
	 */
	public void setTargetSource(Byte targetSource) {
		this.targetSource = targetSource;
	}

	/**
	 * @mbggenerated 扩展字段，保存json格式的字符串
	 */
	public String getExtendJson() {
		return extendJson;
	}

	/**
	 * @mbggenerated 扩展字段，保存json格式的字符串
	 */
	public void setExtendJson(String extendJson) {
		this.extendJson = extendJson;
	}

	/**
	 * @mbggenerated 用户使用的好房币
	 */
	public BigDecimal getUserCoin() {
		return userCoin;
	}

	/**
	 * @mbggenerated 用户使用的好房币
	 */
	public void setUserCoin(BigDecimal userCoin) {
		this.userCoin = userCoin;
	}

	/**
	 * @mbggenerated 用户使用的优惠券
	 */
	public BigDecimal getUserQuan() {
		return userQuan;
	}

	/**
	 * @mbggenerated 用户使用的优惠券
	 */
	public void setUserQuan(BigDecimal userQuan) {
		this.userQuan = userQuan;
	}

	/**
	 * @mbggenerated 公司使用的好房币
	 */
	public BigDecimal getCompCoin() {
		return compCoin;
	}

	/**
	 * @mbggenerated 公司使用的好房币
	 */
	public void setCompCoin(BigDecimal compCoin) {
		this.compCoin = compCoin;
	}

	/**
	 * @mbggenerated 公司使用的优惠券
	 */
	public BigDecimal getCompQuan() {
		return compQuan;
	}

	/**
	 * @mbggenerated 公司使用的优惠券
	 */
	public void setCompQuan(BigDecimal compQuan) {
		this.compQuan = compQuan;
	}

	/**
	 * @mbggenerated 拨打人大区ID
	 */
	public Integer getCallAreaId() {
		return callAreaId;
	}

	/**
	 * @mbggenerated 拨打人大区ID
	 */
	public void setCallAreaId(Integer callAreaId) {
		this.callAreaId = callAreaId;
	}

	/**
	 * @mbggenerated 拨打人片区ID
	 */
	public Integer getCallRegId() {
		return callRegId;
	}

	/**
	 * @mbggenerated 拨打人片区ID
	 */
	public void setCallRegId(Integer callRegId) {
		this.callRegId = callRegId;
	}

	/**
	 * @mbggenerated 拨打人分组ID
	 */
	public Integer getCallGrId() {
		return callGrId;
	}

	/**
	 * @mbggenerated 拨打人分组ID
	 */
	public void setCallGrId(Integer callGrId) {
		this.callGrId = callGrId;
	}

	/**
	 * @mbggenerated 个人扣除金额
	 */
	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	/**
	 * @mbggenerated 个人扣除金额
	 */
	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
	}

	/**
	 * @mbggenerated 公司扣除
	 */
	public BigDecimal getCompCashMoney() {
		return compCashMoney;
	}

	/**
	 * @mbggenerated 公司扣除
	 */
	public void setCompCashMoney(BigDecimal compCashMoney) {
		this.compCashMoney = compCashMoney;
	}

	/**
	 * @mbggenerated 是否是房多多（0.否，1.是）
	 */
	public Byte getIsFdd() {
		return isFdd;
	}

	/**
	 * @mbggenerated 是否是房多多（0.否，1.是）
	 */
	public void setIsFdd(Byte isFdd) {
		this.isFdd = isFdd;
	}

	/**
	 * @mbggenerated 虚拟号码
	 */
	public String getFddHiddenNumber() {
		return fddHiddenNumber;
	}

	/**
	 * @mbggenerated 虚拟号码
	 */
	public void setFddHiddenNumber(String fddHiddenNumber) {
		this.fddHiddenNumber = fddHiddenNumber;
	}

	/**
	 * @mbggenerated AXB拨打记录的数据唯一标识.
	 */
	public String getCallId() {
		return callId;
	}

	/**
	 * @mbggenerated AXB拨打记录的数据唯一标识.
	 */
	public void setCallId(String callId) {
		this.callId = callId;
	}

	/**
	 * @mbggenerated 0只记录1已经扣费
	 */
	public Integer getAxbStyle() {
		return axbStyle;
	}

	/**
	 * @mbggenerated 0只记录1已经扣费
	 */
	public void setAxbStyle(Integer axbStyle) {
		this.axbStyle = axbStyle;
	}

	/**
	 * @mbggenerated 扣费失败原因
	 */
	public String getDeductionFailureReason() {
		return deductionFailureReason;
	}

	/**
	 * @mbggenerated 扣费失败原因
	 */
	public void setDeductionFailureReason(String deductionFailureReason) {
		this.deductionFailureReason = deductionFailureReason;
	}

	/**
	 * @mbggenerated 父LOG_ID
	 */
	public String getParentLogId() {
		return parentLogId;
	}

	/**
	 * @mbggenerated 父LOG_ID
	 */
	public void setParentLogId(String parentLogId) {
		this.parentLogId = parentLogId;
	}

	/**
	 * @mbggenerated 联卖需求增加字段 1=客服2=经纪人
	 */
	public Integer getHousingSaleFlag() {
		return housingSaleFlag;
	}

	/**
	 * @mbggenerated 联卖需求增加字段 1=客服2=经纪人
	 */
	public void setHousingSaleFlag(Integer housingSaleFlag) {
		this.housingSaleFlag = housingSaleFlag;
	}

	/**
	 * @mbggenerated 房源状态 DD: HOUSE_STATUS
	 */
	public Byte getTargetCaseStatus() {
		return targetCaseStatus;
	}

	/**
	 * @mbggenerated 房源状态 DD: HOUSE_STATUS
	 */
	public void setTargetCaseStatus(Byte targetCaseStatus) {
		this.targetCaseStatus = targetCaseStatus;
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
	 * @mbggenerated 组织机构线
	 */
	public String getTissueLine() {
		return tissueLine;
	}

	/**
	 * @mbggenerated 组织机构线
	 */
	public void setTissueLine(String tissueLine) {
		this.tissueLine = tissueLine;
	}

	/**
	 * @mbggenerated -
	 */
	public String getBindX() {
		return bindX;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBindX(String bindX) {
		this.bindX = bindX;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg1() {
		return org1;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg1(Integer org1) {
		this.org1 = org1;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg2() {
		return org2;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg2(Integer org2) {
		this.org2 = org2;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg3() {
		return org3;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg3(Integer org3) {
		this.org3 = org3;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg4() {
		return org4;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg4(Integer org4) {
		this.org4 = org4;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg5() {
		return org5;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg5(Integer org5) {
		this.org5 = org5;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg6() {
		return org6;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg6(Integer org6) {
		this.org6 = org6;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg7() {
		return org7;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg7(Integer org7) {
		this.org7 = org7;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg8() {
		return org8;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg8(Integer org8) {
		this.org8 = org8;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg9() {
		return org9;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg9(Integer org9) {
		this.org9 = org9;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg10() {
		return org10;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg10(Integer org10) {
		this.org10 = org10;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg11() {
		return org11;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg11(Integer org11) {
		this.org11 = org11;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg12() {
		return org12;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg12(Integer org12) {
		this.org12 = org12;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg13() {
		return org13;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg13(Integer org13) {
		this.org13 = org13;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg14() {
		return org14;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg14(Integer org14) {
		this.org14 = org14;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCallUserName() {
		return callUserName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCallUserName(String callUserName) {
		this.callUserName = callUserName;
	}
}