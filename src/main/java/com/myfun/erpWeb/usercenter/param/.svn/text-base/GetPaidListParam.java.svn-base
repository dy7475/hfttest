package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetPaidListParam extends AbstractEncryParam implements DaoBaseParam{
	
	// 前端传的参数
	@ApiModelProperty("类型：INCOME=收入 PAY=支出  GIFT=赠送")
	private String paidCatigory; // 类型：INCOME=收入 PAY=支出  GIFT=赠送
	@ApiModelProperty("日期范围 2016-01-01~2016-01-05")
	private String dateRange; // 日期范围 2016-01-01~2016-01-05
	@ApiModelProperty("选择日期查询条件范围 0=全部 1=一天 2=一周 3=一月 4=一季 5=半年 6=半年前 7=一年 8=一年前 9=两年前 10=三天内")
	private String date; // 选择日期查询条件范围 0=全部 1=一天 2=一周 3=一月 4=一季 5=半年 6=半年前 7=一年 8=一年前 9=两年前 10=三天内
	@ApiModelProperty("交易账户 1=个人 2=公司")
	private Integer paidAccount; // 交易账户 1=个人 2=公司
	@ApiModelProperty("交易类型  VOIP=语音拨打 BIDDING=小区竞价 HOUSE_BIDDING=房源推广 TRUEHOUSE_LIGHT=点亮真房源 SRV_QUAN=赠送优惠券 CLEAR4PAST=过期清除")
	private String paidType; // 交易类型  VOIP=语音拨打 BIDDING=小区竞价 HOUSE_BIDDING=房源推广 TRUEHOUSE_LIGHT=点亮真房源 SRV_QUAN=赠送优惠券 CLEAR4PAST=过期清除
	@ApiModelProperty("支付方式  0=其他 1=好房币 2=优惠券")
	private Integer paidMode; // 支付方式  0=其他 1=好房币 2=优惠券
	
	// 组装的参数
	@ApiModelProperty(hidden = true)
	private String paidTimeLess; //
	@ApiModelProperty(hidden = true)
	private String paidTimeGreater; //
	@ApiModelProperty(hidden = true)
	private Integer selfUaId; // 个人资金账户
	@ApiModelProperty(hidden = true)
	private Integer selfCompUaId; // 公司资金账户
	@ApiModelProperty(hidden = true)
	private Integer selfArchiveId; // 档案Id
	@ApiModelProperty(hidden = true)
	private String selfUserPosition; //

	public String getPaidCatigory() {
		return paidCatigory;
	}
	public void setPaidCatigory(String paidCatigory) {
		this.paidCatigory = paidCatigory;
	}
	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getPaidAccount() {
		return paidAccount;
	}
	public void setPaidAccount(Integer paidAccount) {
		this.paidAccount = paidAccount;
	}
	public String getPaidType() {
		return paidType;
	}
	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}
	public Integer getPaidMode() {
		return paidMode;
	}
	public void setPaidMode(Integer paidMode) {
		this.paidMode = paidMode;
	}
	public Integer getSelfUaId() {
		return selfUaId;
	}
	public void setSelfUaId(Integer selfUaId) {
		this.selfUaId = selfUaId;
	}
	public Integer getSelfCompUaId() {
		return selfCompUaId;
	}
	public void setSelfCompUaId(Integer selfCompUaId) {
		this.selfCompUaId = selfCompUaId;
	}
	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}
	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}
	public String getSelfUserPosition() {
		return selfUserPosition;
	}
	public void setSelfUserPosition(String selfUserPosition) {
		this.selfUserPosition = selfUserPosition;
	}
	public String getPaidTimeLess() {
		return paidTimeLess;
	}
	public void setPaidTimeLess(String paidTimeLess) {
		this.paidTimeLess = paidTimeLess;
	}
	public String getPaidTimeGreater() {
		return paidTimeGreater;
	}
	public void setPaidTimeGreater(String paidTimeGreater) {
		this.paidTimeGreater = paidTimeGreater;
	}
}
