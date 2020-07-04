package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class CreateSecretNoParam implements EncryParamIfc {
	@ApiModelProperty(value = "楼盘资料主键Id,entityId,如:179672，备注:entityId为楼盘资料拨打才传")
	private Integer entityId;
	@ApiModelProperty(value="拨打电话下标默认1业主 2=备用 3=共有人")
	private Integer phoneIndex = 1;
	@ApiModelProperty(value = "被拨打人手机号码 ,如:18408245192,备注:customerMobile和phoneIndex只传一个")
	private String customerMobile;
	@ApiModelProperty(value = "房客源编号 ,如:6640352，备注:targetId与entityId互斥")
	private Integer targetId;
	@ApiModelProperty(value = "房客源类型 ,如:1=出售2=出租3=求购4=求租，备注:targetType与entityId互斥")
	private Integer targetType;
	@ApiModelProperty(value = "使用方1=C端打B端，2=B端打C端",hidden = true)
	private Integer useDirection;
	@ApiModelProperty(value = "1=扣费,0=不扣费")
	private Integer feeFlag;
	@ApiModelProperty(value = "拨打类型 IM物业合作拨打=39 ,物业版历史访客客户=40")
	private Byte callType;
	@ApiModelProperty(value = "1=app 2=pc")
	private Byte targetSource;
	@ApiModelProperty(value = "租售和客源的业主信息电话ID，对应FUN_PHONE表的ID")
	private Integer phoneId;
	
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public Integer getPhoneIndex() {
		return phoneIndex;
	}
	public void setPhoneIndex(Integer phoneIndex) {
		this.phoneIndex = phoneIndex;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public Integer getTargetType() {
		return targetType;
	}
	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}
	public Integer getUseDirection() {
		return useDirection;
	}
	public void setUseDirection(Integer useDirection) {
		this.useDirection = useDirection;
	}
	public Integer getFeeFlag() {
		return feeFlag;
	}
	public void setFeeFlag(Integer feeFlag) {
		this.feeFlag = feeFlag;
	}
	public Byte getCallType() {
		return callType;
	}
	public void setCallType(Byte callType) {
		this.callType = callType;
	}
	public Byte getTargetSource() {
		return targetSource;
	}
	public void setTargetSource(Byte targetSource) {
		this.targetSource = targetSource;
	}
	public Integer getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
}
