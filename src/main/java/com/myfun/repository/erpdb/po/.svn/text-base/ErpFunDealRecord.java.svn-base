package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunDealRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 记录ID，主键
	 */
	private Integer recordId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 合同编号 虽然字段名是AGREEMENT_NO 实际上存的是DEAL_ID  原因是  这个表是旧表  所以没有修改字段名  仍然实现原来的字段名
	 */
	private String agreementNo;
	/**
	 * @mbggenerated 修改时间
	 */
	private String updateDate;
	/**
	 * @mbggenerated 修改人
	 */
	private Integer updateUid;
	/**
	 * @mbggenerated 分店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 修改者姓名
	 */
	private String updateUserName;
	/**
	 * @mbggenerated 跟进内容
	 */
	private String trackContent;
	/**
	 * @mbggenerated 修改类型 0:合同 1:财务 2 业绩 3:指标 4:买方税费5：卖方税费
	 */
	private Byte updateType;
	/**
	 * @mbggenerated 更新分类
	 */
	private String updateClassic;
	/**
	 * @mbggenerated 前置记录ID
	 */
	private Integer frontRecordId;
	/**
	 * @mbggenerated 用于区分是应收日志还是实收日志
	 */
	private Byte pfActual;
	/**
	 * @mbggenerated 合同审核状态，参考FUN_DEAL表YOU_ADUIT_STATUS字段
	 */
	private Integer aduitStatus;
	/**
	 * @mbggenerated 合同修改内容(JSON)包含业绩 财务 合同三部分 key为表名
	 */
	private String updateContent;
	/**
	 * @mbggenerated 业绩分配内容(JSON)KEY为PRO
	 */
	private String proContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	public String getAgreementNo() {
		return agreementNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo == null ? null : agreementNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
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
	public String getUpdateUserName() {
		return updateUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName == null ? null : updateUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTrackContent() {
		return trackContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent == null ? null : trackContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUpdateType() {
		return updateType;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateType(Byte updateType) {
		this.updateType = updateType;
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateClassic() {
		return updateClassic;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateClassic(String updateClassic) {
		this.updateClassic = updateClassic == null ? null : updateClassic.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFrontRecordId() {
		return frontRecordId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFrontRecordId(Integer frontRecordId) {
		this.frontRecordId = frontRecordId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPfActual() {
		return pfActual;
	}

	/**
	 * @mbggenerated
	 */
	public void setPfActual(Byte pfActual) {
		this.pfActual = pfActual;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAduitStatus() {
		return aduitStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setAduitStatus(Integer aduitStatus) {
		this.aduitStatus = aduitStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateContent() {
		return updateContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent == null ? null : updateContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getProContent() {
		return proContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setProContent(String proContent) {
		this.proContent = proContent == null ? null : proContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealRecord(Integer shardCityId, Integer recordId) {
		super(shardCityId);
		this.recordId = recordId;
	}
}