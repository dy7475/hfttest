package com.myfun.repository.agencydb.dto;

/**
 * 用于我的委托列表统计经纪人推送了多少房源
 * @author 陈文超
 * @date 2016年6月20日 下午3:50:42
 */
public class EntrustCountDto {
// select a.CASE_ID,b.WX_ID,a.CASE_TYPE,a.ARCHIVE_ID,b.BROKER_MOBILE,b.PUSH_STATUS,b.REQUIRE_STATUS from WF_RECOM_HOUSE a 
// join WF_PUSH_LOG b on a.PUSH_LOG_ID = b.ID 
// where b.CITY_ID = #{cityId,jdbcType=INTEGER} and b.WX_ID = #{wxId,jdbcType=INTEGER} and b.PUSH_STATUS > 0 order by b.ID
	/**
	 * 用户发送的委托信息的ID
	 */
	private String caseId;
	/**
	 * ERP库的房源ID，表示经纪人给用户推荐的房源
	 */
	private String erpCaseId;
	private String caseType;
	private String wxId;
	private String archiveId;
	private String brokerMobile;
	private String pushStatus;
	private String requireStatus;
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}
	public String getBrokerMobile() {
		return brokerMobile;
	}
	public void setBrokerMobile(String brokerMobile) {
		this.brokerMobile = brokerMobile;
	}
	public String getPushStatus() {
		return pushStatus;
	}
	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}
	public String getRequireStatus() {
		return requireStatus;
	}
	public void setRequireStatus(String requireStatus) {
		this.requireStatus = requireStatus;
	}
	public String getErpCaseId() {
		return erpCaseId;
	}
	public void setErpCaseId(String erpCaseId) {
		this.erpCaseId = erpCaseId;
	}
}
