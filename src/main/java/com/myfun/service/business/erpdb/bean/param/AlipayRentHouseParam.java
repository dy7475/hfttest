package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;

public class AlipayRentHouseParam extends AbstractEncryParam implements DaoBaseParam{

	// 支付宝用户Id
	private String  aliUserId;
	// flatsTag为1,则代表单编号 2,代表房型编号
	private Integer flatsTag;
	// 房源编号
	private String  roomCode;
	// 备注
	private String  remark;
	// 看房时间格式yyyy-MM-dd HH:mm
	private String  lookTime;
	// 看房人手机号码
	private String  bookPhone;
	// 性别 0未知 1:男 2:女
	private Integer  bookSex;
	// 芝麻授权Id
	private String  zhimaOpenId;
	// 电话记录时间,格式yyyy-MM-dd HH:mm:ss
	private String  recordTime;
	// 租约id
	private Integer  leaseCode;
	// 小区同步请求号
	private String  commReqId;
	private Integer  status;
	private String  flatNum;
	// "0：惩罚隐藏，1：恢复展示 当状态为恢复展示后，需要KA商家更新房源上架状态，才能上架房源。"
	private Integer  punishmentStatus;
	// 惩罚原因或者恢复原因。
	private String  punishmentReason;
	// 惩罚隐藏时必填，恢复展示时为空。
	private Integer  punishmentDays;
	// 账单编号-ka保证唯一	KA001
	private String  billNo;
	// 租约编号(KA内部租约业务编号)	1001
	private String  leaseNo;
	// 付款时间或交易完成时间yyyy-MM-dd HH:mm:ss	2018-05-01 10:01:00
	private String  payTime;
	// 交易金额	100.00
	private String  amount;
	private String bookName;
	private Integer cityId;
	private Integer caseId;
	private Integer archiveId;

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAliUserId() {
		return this.aliUserId;
	}

	public void setAliUserId(String aliUserId) {
		this.aliUserId = aliUserId;
	}

	public Integer getFlatsTag() {
		return this.flatsTag;
	}

	public void setFlatsTag(Integer flatsTag) {
		this.flatsTag = flatsTag;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLookTime() {
		return this.lookTime;
	}

	public void setLookTime(String lookTime) {
		this.lookTime = lookTime;
	}

	public String getBookPhone() {
		return this.bookPhone;
	}

	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}

	public Integer getBookSex() {
		return this.bookSex;
	}

	public void setBookSex(Integer bookSex) {
		this.bookSex = bookSex;
	}

	public String getZhimaOpenId() {
		return this.zhimaOpenId;
	}

	public void setZhimaOpenId(String zhimaOpenId) {
		this.zhimaOpenId = zhimaOpenId;
	}

	public String getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public Integer getLeaseCode() {
		return this.leaseCode;
	}

	public void setLeaseCode(Integer leaseCode) {
		this.leaseCode = leaseCode;
	}

	public String getCommReqId() {
		return this.commReqId;
	}

	public void setCommReqId(String commReqId) {
		this.commReqId = commReqId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFlatNum() {
		return this.flatNum;
	}

	public void setFlatNum(String flatNum) {
		this.flatNum = flatNum;
	}

	public Integer getPunishmentStatus() {
		return this.punishmentStatus;
	}

	public void setPunishmentStatus(Integer punishmentStatus) {
		this.punishmentStatus = punishmentStatus;
	}

	public String getPunishmentReason() {
		return this.punishmentReason;
	}

	public void setPunishmentReason(String punishmentReason) {
		this.punishmentReason = punishmentReason;
	}

	public Integer getPunishmentDays() {
		return this.punishmentDays;
	}

	public void setPunishmentDays(Integer punishmentDays) {
		this.punishmentDays = punishmentDays;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getLeaseNo() {
		return this.leaseNo;
	}

	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}

	public String getPayTime() {
		return this.payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {

		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("AlipayRentHouseParam{");
		if(StringUtils.isNotBlank(aliUserId)) {
			sb.append("aliUserId='" + aliUserId + '\'');
		}else {
			sb.append("aliUserId=''");
		}
		if(null != flatsTag) {
			sb.append(",flatsTag='" + flatsTag + '\'');
		}else {
			sb.append(",flatsTag=''");
		}
		if(StringUtils.isNotBlank(roomCode)) {
			sb.append(",roomCode='" + roomCode + '\'');
		}else {
			sb.append(",roomCode=''");
		}
		if(StringUtils.isNotBlank(remark)) {
			sb.append(",remark='" + remark + '\'');
		}else {
			sb.append(",remark=''");
		}
		if(StringUtils.isNotBlank(lookTime)) {
			sb.append(",lookTime='" + lookTime + '\'');
		}else {
			sb.append(",lookTime=''");
		}
		if(StringUtils.isNotBlank(bookPhone)) {
			sb.append(",bookPhone='" + bookPhone + '\'');
		}else {
			sb.append(",bookPhone=''");
		}
		if(null != bookSex) {
			sb.append(",bookSex='" + bookSex + '\'');
		}else {
			sb.append(",bookSex=''");
		}
		if(StringUtils.isNotBlank(zhimaOpenId)) {
			sb.append(",zhimaOpenId='" + zhimaOpenId + '\'');
		}else {
			sb.append(",zhimaOpenId=''");
		}
		if(StringUtils.isNotBlank(recordTime)) {
			sb.append(",recordTime='" + recordTime + '\'');
		}else {
			sb.append(",recordTime=''");
		}
		if(StringUtils.isNotBlank(commReqId)) {
			sb.append(",commReqId='" + commReqId + '\'');
		}else {
			sb.append(",commReqId=''");
		}
		if(StringUtils.isNotBlank(flatNum)) {
			sb.append(",flatNum='" + flatNum + '\'');
		}else {
			sb.append(",flatNum=''");
		}
		if(StringUtils.isNotBlank(amount)) {
			sb.append(",amount='" + amount + '\'');
		}else {
			sb.append(",amount=''");
		}
		if(StringUtils.isNotBlank(payTime)) {
			sb.append(",payTime='" + payTime + '\'');
		}else {
			sb.append(",payTime=''");
		}
		if(StringUtils.isNotBlank(leaseNo)) {
			sb.append(",leaseNo='" + leaseNo + '\'');
		}else {
			sb.append(",leaseNo=''");
		}
		if(StringUtils.isNotBlank(billNo)) {
			sb.append(",billNo='" + billNo + '\'');
		}else {
			sb.append(",billNo=''");
		}
		if(StringUtils.isNotBlank(punishmentReason)) {
			sb.append(",punishmentReason='" + punishmentReason + '\'');
		}else {
			sb.append(",punishmentReason=''");
		}
		if(null != leaseCode) {
			sb.append(",leaseCode='" + leaseCode + '\'');
		}else {
			sb.append(",leaseCode=''");
		}
		if(null != status) {
			sb.append(",status='" + status + '\'');
		}else {
			sb.append(",status=''");
		}
		if(null != punishmentStatus) {
			sb.append(",punishmentStatus='" + punishmentStatus + '\'');
		}else {
			sb.append(",punishmentStatus=''");
		}
		if(null != punishmentDays) {
			sb.append(",punishmentDays='" + punishmentDays + '\'');
		}else {
			sb.append(",punishmentDays=''");
		}

		sb.append("}");
		return sb.toString();
	}

}
