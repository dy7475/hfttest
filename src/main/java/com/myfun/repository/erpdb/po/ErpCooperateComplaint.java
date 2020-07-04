package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpCooperateComplaint extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer ccId;
	/**
	 * @mbggenerated
	 */
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	private Byte ccType;
	/**
	 * @mbggenerated
	 */
	private Integer ccUserId;
	/**
	 * @mbggenerated
	 */
	private Integer defUserId;
	/**
	 * @mbggenerated
	 */
	private Integer ccArchiveId;
	/**
	 * @mbggenerated
	 */
	private Integer defArchiveId;
	/**
	 * @mbggenerated
	 */
	private String ccTime;
	/**
	 * @mbggenerated
	 */
	private String ccContent;
	/**
	 * @mbggenerated
	 */
	private Byte ccResult;
	/**
	 * @mbggenerated
	 */
	private String resultCon;
	/**
	 * @mbggenerated
	 */
	private Byte dealType;
	/**
	 * @mbggenerated
	 */
	private String dealTime;
	/**
	 * @mbggenerated
	 */
	private Byte readFlag;
	/**
	 * @mbggenerated
	 */
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	private Integer msgCount;
	/**
	 * @mbggenerated
	 */
	private Integer ccFId;
	/**
	 * @mbggenerated
	 */
	private Byte useage;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getCcId() {
		return ccId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}

	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCcType() {
		return ccType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcType(Byte ccType) {
		this.ccType = ccType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCcUserId() {
		return ccUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcUserId(Integer ccUserId) {
		this.ccUserId = ccUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDefUserId() {
		return defUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDefUserId(Integer defUserId) {
		this.defUserId = defUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCcArchiveId() {
		return ccArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcArchiveId(Integer ccArchiveId) {
		this.ccArchiveId = ccArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDefArchiveId() {
		return defArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDefArchiveId(Integer defArchiveId) {
		this.defArchiveId = defArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCcTime() {
		return ccTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcTime(String ccTime) {
		this.ccTime = ccTime == null ? null : ccTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCcContent() {
		return ccContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcContent(String ccContent) {
		this.ccContent = ccContent == null ? null : ccContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCcResult() {
		return ccResult;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcResult(Byte ccResult) {
		this.ccResult = ccResult;
	}

	/**
	 * @mbggenerated
	 */
	public String getResultCon() {
		return resultCon;
	}

	/**
	 * @mbggenerated
	 */
	public void setResultCon(String resultCon) {
		this.resultCon = resultCon == null ? null : resultCon.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	/**
	 * @mbggenerated
	 */
	public String getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime == null ? null : dealTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getReadFlag() {
		return readFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setReadFlag(Byte readFlag) {
		this.readFlag = readFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMsgCount() {
		return msgCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setMsgCount(Integer msgCount) {
		this.msgCount = msgCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCcFId() {
		return ccFId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCcFId(Integer ccFId) {
		this.ccFId = ccFId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated
	 */
	public ErpCooperateComplaint() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpCooperateComplaint(Integer shardCityId, Integer ccId) {
		super(shardCityId);
		this.ccId = ccId;
	}
}