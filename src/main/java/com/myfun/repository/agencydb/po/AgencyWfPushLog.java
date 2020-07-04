package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class AgencyWfPushLog implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Լ")
	private Integer wxId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID,ź÷ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ͣ1|2|3|4⣩")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ɽƼԴIDWF_RECOM_HOUSE")
	private Integer recomHouseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ֻ")
	private String brokerMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "΢ûֻ")
	private String wxMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Ŀǰδʹ")
	private String settingFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "״̬󹺣0ܾ 1(ʹ-ѷ) 2 3 4ɽ 5Ƽ(ۣ0Ѿܾ 2ѽ 3ϵ 4뷿 5ͬⷿ 6תϵͳ 7 9ͬί(ѷ) 10ɽ)")
	private Byte pushStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ί״̬0ȡ 1ί 2ѳɽ")
	private Byte requireStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "״̬")
	private Byte receiveStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ȡ = 1   PUSH_STATUSҪ³0")
	private Byte cancelStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Date actTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Date pushTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ܾԭ")
	private String refuseReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = ",499齱жǷϳ齱,ʾֵ")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Integer daikanCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "499־  -1 δͨ 0 δн1 н2 C֧3 B֧4 BC֧")
	private Integer lotteryFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "º㣬û¹ξҪۼӸֵǰ˿ƺչʾ")
	private Byte updateFlagCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "嵥־  -1 δͨ 0δ 1ͨ 2 ֧")
	private Integer chongdanFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VIP_QUEUEIDжϸίǷѾ˽")
	private Integer vipQueueId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ѡͶ   ʽ1,2,3,4")
	private String refuseTagIndex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ȡѡȡ ʽ1,2,3,4")
	private String cancelTagIndex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ȡ")
	private String cancelReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Ĭ:0δɾ1ɾ-  Ƿɾ˸")
	private Byte brokerDelStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ɾ")
	private Date brokerDelStatusTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ϵͳȡı 1:ȡ0:Ĭֵ")
	private Byte sysCancelStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ϵͳȡ")
	private Date sysCancelTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1ǰѱǣĬ:0")
	private Byte expireWarnFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ѵ")
	private Date expireWarnTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Ƿп1:С0:û   ߼ɽCû ۡ۶5ǣ֧500ԪӶ")
	private Byte dealPrizeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ǷнŻȯ1:С0:û   ߼˽ƼԴܻŻȯ")
	private Byte recomPrizeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ڼ¼Դڸپ˽;-1ݣ1ERPĶίС3Сת2Ѻϲݴľ4żҹںţ5ƥͣ 6 Ժ󻹻-ĳ")
	private Integer bizType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ƬID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ŵID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ûID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Date fangkanTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer crmUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ѵjson")
	private String robPayJson;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "BӶ")
	private String brokerMoneyFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ǷѾɨ")
	private Byte isScanner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = " 1=ʹ")
	private Integer pushType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "֯ۺϲѯֶ")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated Լ
	 */
	public Integer getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated Լ
	 */
	public void setWxId(Integer wxId) {
		this.wxId = wxId;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated ID,ź÷ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated ID,ź÷ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated ͣ1|2|3|4⣩
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated ͣ1|2|3|4⣩
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated ɽƼԴIDWF_RECOM_HOUSE
	 */
	public Integer getRecomHouseId() {
		return recomHouseId;
	}

	/**
	 * @mbggenerated ɽƼԴIDWF_RECOM_HOUSE
	 */
	public void setRecomHouseId(Integer recomHouseId) {
		this.recomHouseId = recomHouseId;
	}

	/**
	 * @mbggenerated ֻ
	 */
	public String getBrokerMobile() {
		return brokerMobile;
	}

	/**
	 * @mbggenerated ֻ
	 */
	public void setBrokerMobile(String brokerMobile) {
		this.brokerMobile = brokerMobile == null ? null : brokerMobile.trim();
	}

	/**
	 * @mbggenerated ΢ûֻ
	 */
	public String getWxMobile() {
		return wxMobile;
	}

	/**
	 * @mbggenerated ΢ûֻ
	 */
	public void setWxMobile(String wxMobile) {
		this.wxMobile = wxMobile == null ? null : wxMobile.trim();
	}

	/**
	 * @mbggenerated Ŀǰδʹ
	 */
	public String getSettingFee() {
		return settingFee;
	}

	/**
	 * @mbggenerated Ŀǰδʹ
	 */
	public void setSettingFee(String settingFee) {
		this.settingFee = settingFee == null ? null : settingFee.trim();
	}

	/**
	 * @mbggenerated ״̬󹺣0ܾ 1(ʹ-ѷ) 2 3 4ɽ 5Ƽ(ۣ0Ѿܾ 2ѽ 3ϵ 4뷿 5ͬⷿ 6תϵͳ 7 9ͬί(ѷ) 10ɽ)
	 */
	public Byte getPushStatus() {
		return pushStatus;
	}

	/**
	 * @mbggenerated ״̬󹺣0ܾ 1(ʹ-ѷ) 2 3 4ɽ 5Ƽ(ۣ0Ѿܾ 2ѽ 3ϵ 4뷿 5ͬⷿ 6תϵͳ 7 9ͬί(ѷ) 10ɽ)
	 */
	public void setPushStatus(Byte pushStatus) {
		this.pushStatus = pushStatus;
	}

	/**
	 * @mbggenerated ί״̬0ȡ 1ί 2ѳɽ
	 */
	public Byte getRequireStatus() {
		return requireStatus;
	}

	/**
	 * @mbggenerated ί״̬0ȡ 1ί 2ѳɽ
	 */
	public void setRequireStatus(Byte requireStatus) {
		this.requireStatus = requireStatus;
	}

	/**
	 * @mbggenerated ״̬
	 */
	public Byte getReceiveStatus() {
		return receiveStatus;
	}

	/**
	 * @mbggenerated ״̬
	 */
	public void setReceiveStatus(Byte receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	/**
	 * @mbggenerated ȡ = 1   PUSH_STATUSҪ³0
	 */
	public Byte getCancelStatus() {
		return cancelStatus;
	}

	/**
	 * @mbggenerated ȡ = 1   PUSH_STATUSҪ³0
	 */
	public void setCancelStatus(Byte cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Date getActTime() {
		return actTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPushTime() {
		return pushTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}

	/**
	 * @mbggenerated ܾԭ
	 */
	public String getRefuseReason() {
		return refuseReason;
	}

	/**
	 * @mbggenerated ܾԭ
	 */
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason == null ? null : refuseReason.trim();
	}

	/**
	 * @mbggenerated ,499齱жǷϳ齱,ʾֵ
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated ,499齱жǷϳ齱,ʾֵ
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 
	 */
	public Integer getDaikanCount() {
		return daikanCount;
	}

	/**
	 * @mbggenerated 
	 */
	public void setDaikanCount(Integer daikanCount) {
		this.daikanCount = daikanCount;
	}

	/**
	 * @mbggenerated 499־  -1 δͨ 0 δн1 н2 C֧3 B֧4 BC֧
	 */
	public Integer getLotteryFlag() {
		return lotteryFlag;
	}

	/**
	 * @mbggenerated 499־  -1 δͨ 0 δн1 н2 C֧3 B֧4 BC֧
	 */
	public void setLotteryFlag(Integer lotteryFlag) {
		this.lotteryFlag = lotteryFlag;
	}

	/**
	 * @mbggenerated º㣬û¹ξҪۼӸֵǰ˿ƺչʾ
	 */
	public Byte getUpdateFlagCount() {
		return updateFlagCount;
	}

	/**
	 * @mbggenerated º㣬û¹ξҪۼӸֵǰ˿ƺչʾ
	 */
	public void setUpdateFlagCount(Byte updateFlagCount) {
		this.updateFlagCount = updateFlagCount;
	}

	/**
	 * @mbggenerated 嵥־  -1 δͨ 0δ 1ͨ 2 ֧
	 */
	public Integer getChongdanFlag() {
		return chongdanFlag;
	}

	/**
	 * @mbggenerated 嵥־  -1 δͨ 0δ 1ͨ 2 ֧
	 */
	public void setChongdanFlag(Integer chongdanFlag) {
		this.chongdanFlag = chongdanFlag;
	}

	/**
	 * @mbggenerated VIP_QUEUEIDжϸίǷѾ˽
	 */
	public Integer getVipQueueId() {
		return vipQueueId;
	}

	/**
	 * @mbggenerated VIP_QUEUEIDжϸίǷѾ˽
	 */
	public void setVipQueueId(Integer vipQueueId) {
		this.vipQueueId = vipQueueId;
	}

	/**
	 * @mbggenerated ѡͶ   ʽ1,2,3,4
	 */
	public String getRefuseTagIndex() {
		return refuseTagIndex;
	}

	/**
	 * @mbggenerated ѡͶ   ʽ1,2,3,4
	 */
	public void setRefuseTagIndex(String refuseTagIndex) {
		this.refuseTagIndex = refuseTagIndex == null ? null : refuseTagIndex.trim();
	}

	/**
	 * @mbggenerated ȡѡȡ ʽ1,2,3,4
	 */
	public String getCancelTagIndex() {
		return cancelTagIndex;
	}

	/**
	 * @mbggenerated ȡѡȡ ʽ1,2,3,4
	 */
	public void setCancelTagIndex(String cancelTagIndex) {
		this.cancelTagIndex = cancelTagIndex == null ? null : cancelTagIndex.trim();
	}

	/**
	 * @mbggenerated ȡ
	 */
	public String getCancelReason() {
		return cancelReason;
	}

	/**
	 * @mbggenerated ȡ
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason == null ? null : cancelReason.trim();
	}

	/**
	 * @mbggenerated Ĭ:0δɾ1ɾ-  Ƿɾ˸
	 */
	public Byte getBrokerDelStatus() {
		return brokerDelStatus;
	}

	/**
	 * @mbggenerated Ĭ:0δɾ1ɾ-  Ƿɾ˸
	 */
	public void setBrokerDelStatus(Byte brokerDelStatus) {
		this.brokerDelStatus = brokerDelStatus;
	}

	/**
	 * @mbggenerated ɾ
	 */
	public Date getBrokerDelStatusTime() {
		return brokerDelStatusTime;
	}

	/**
	 * @mbggenerated ɾ
	 */
	public void setBrokerDelStatusTime(Date brokerDelStatusTime) {
		this.brokerDelStatusTime = brokerDelStatusTime;
	}

	/**
	 * @mbggenerated ϵͳȡı 1:ȡ0:Ĭֵ
	 */
	public Byte getSysCancelStatus() {
		return sysCancelStatus;
	}

	/**
	 * @mbggenerated ϵͳȡı 1:ȡ0:Ĭֵ
	 */
	public void setSysCancelStatus(Byte sysCancelStatus) {
		this.sysCancelStatus = sysCancelStatus;
	}

	/**
	 * @mbggenerated ϵͳȡ
	 */
	public Date getSysCancelTime() {
		return sysCancelTime;
	}

	/**
	 * @mbggenerated ϵͳȡ
	 */
	public void setSysCancelTime(Date sysCancelTime) {
		this.sysCancelTime = sysCancelTime;
	}

	/**
	 * @mbggenerated 1ǰѱǣĬ:0
	 */
	public Byte getExpireWarnFlag() {
		return expireWarnFlag;
	}

	/**
	 * @mbggenerated 1ǰѱǣĬ:0
	 */
	public void setExpireWarnFlag(Byte expireWarnFlag) {
		this.expireWarnFlag = expireWarnFlag;
	}

	/**
	 * @mbggenerated ѵ
	 */
	public Date getExpireWarnTime() {
		return expireWarnTime;
	}

	/**
	 * @mbggenerated ѵ
	 */
	public void setExpireWarnTime(Date expireWarnTime) {
		this.expireWarnTime = expireWarnTime;
	}

	/**
	 * @mbggenerated Ƿп1:С0:û   ߼ɽCû ۡ۶5ǣ֧500ԪӶ
	 */
	public Byte getDealPrizeFlag() {
		return dealPrizeFlag;
	}

	/**
	 * @mbggenerated Ƿп1:С0:û   ߼ɽCû ۡ۶5ǣ֧500ԪӶ
	 */
	public void setDealPrizeFlag(Byte dealPrizeFlag) {
		this.dealPrizeFlag = dealPrizeFlag;
	}

	/**
	 * @mbggenerated ǷнŻȯ1:С0:û   ߼˽ƼԴܻŻȯ
	 */
	public Byte getRecomPrizeFlag() {
		return recomPrizeFlag;
	}

	/**
	 * @mbggenerated ǷнŻȯ1:С0:û   ߼˽ƼԴܻŻȯ
	 */
	public void setRecomPrizeFlag(Byte recomPrizeFlag) {
		this.recomPrizeFlag = recomPrizeFlag;
	}

	/**
	 * @mbggenerated ڼ¼Դڸپ˽;-1ݣ1ERPĶίС3Сת2Ѻϲݴľ4żҹںţ5ƥͣ 6 Ժ󻹻-ĳ
	 */
	public Integer getBizType() {
		return bizType;
	}

	/**
	 * @mbggenerated ڼ¼Դڸپ˽;-1ݣ1ERPĶίС3Сת2Ѻϲݴľ4żҹںţ5ƥͣ 6 Ժ󻹻-ĳ
	 */
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated ƬID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated ƬID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated ŵID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated ŵID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated ûID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated ûID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFangkanTime() {
		return fangkanTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setFangkanTime(Date fangkanTime) {
		this.fangkanTime = fangkanTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCrmUserId() {
		return crmUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCrmUserId(Integer crmUserId) {
		this.crmUserId = crmUserId;
	}

	/**
	 * @mbggenerated ѵjson
	 */
	public String getRobPayJson() {
		return robPayJson;
	}

	/**
	 * @mbggenerated ѵjson
	 */
	public void setRobPayJson(String robPayJson) {
		this.robPayJson = robPayJson == null ? null : robPayJson.trim();
	}

	/**
	 * @mbggenerated BӶ
	 */
	public String getBrokerMoneyFee() {
		return brokerMoneyFee;
	}

	/**
	 * @mbggenerated BӶ
	 */
	public void setBrokerMoneyFee(String brokerMoneyFee) {
		this.brokerMoneyFee = brokerMoneyFee == null ? null : brokerMoneyFee.trim();
	}

	/**
	 * @mbggenerated ǷѾɨ
	 */
	public Byte getIsScanner() {
		return isScanner;
	}

	/**
	 * @mbggenerated ǷѾɨ
	 */
	public void setIsScanner(Byte isScanner) {
		this.isScanner = isScanner;
	}

	/**
	 * @mbggenerated  1=ʹ
	 */
	public Integer getPushType() {
		return pushType;
	}

	/**
	 * @mbggenerated  1=ʹ
	 */
	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}

	/**
	 * @mbggenerated ֯ۺϲѯֶ
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated ֯ۺϲѯֶ
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath == null ? null : organizationPath.trim();
	}
}