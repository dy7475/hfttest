package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyVipQueue implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer wfId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 信息ID、房客源
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 类别，1出售、2出租、3求购、4求租
	 */
	private Byte caseType;
	/**
	 * @mbggenerated 信息标题摘要
	 */
	private String caseSubject;
	/**
	 * @mbggenerated 描述
	 */
	private String caseDesc;
	/**
	 * @mbggenerated 信息的创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 接单人数
	 */
	private Byte jiedanCount;
	/**
	 * @mbggenerated 悬赏金额度(求租求购才可能有)
	 */
	private Integer wfReward;
	/**
	 * @mbggenerated C端愿意付的佣金比例
	 */
	private String wfFee;
	/**
	 * @mbggenerated 状态(-2 已删除,-1未正常支付的,0无效1正常,2成交)  查询列表的时候-1和-2的不查询
	 */
	private Integer wfStatus;
	/**
	 * @mbggenerated 微信ID，目前作为USER_ID使用
	 */
	private Integer wxId;
	/**
	 * @mbggenerated 关联房源ID
	 */
	private Integer wfRelateId;
	/**
	 * @mbggenerated 意向经纪人性别
	 */
	private Byte wfSex;
	/**
	 * @mbggenerated ID区域
	 */
	private Integer wfRegion;
	/**
	 * @mbggenerated 商圈ID
	 */
	private Integer wfSection;
	/**
	 * @mbggenerated 补数据(有值的表示补数据)
	 */
	private Integer wfFix;
	/**
	 * @mbggenerated
	 */
	private Byte wfRecomed;
	/**
	 * @mbggenerated 是否是专属委托 1：是、0：否
	 */
	private Byte isVip;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 专属委托时候才有 经纪人的ID
	 */
	private String archiveId;
	/**
	 * @mbggenerated
	 */
	private Byte lockNum;
	/**
	 * @mbggenerated 已抽奖次数，默认：0
	 */
	private Byte lotteryTimes;
	/**
	 * @mbggenerated 砸蛋次数，默认次数：3
	 */
	private Byte remainTimes;
	/**
	 * @mbggenerated 中奖次数，中奖次数
	 */
	private Byte winningTimes;
	/**
	 * @mbggenerated 是否合租
	 */
	private Integer ishezu;
	/**
	 * @mbggenerated 委托来源 1 微信  2 APP 3solr转入 4来自优家登记（老的需求-沿用）、uuApp--优优好房--10、hftmobileApp--掌上好房通--11、uuWeb-来源网站--12、uuWap-来源wap站--13、uuPc--优优PC版--14
	 */
	private Byte sourceType;
	/**
	 * @mbggenerated 关联房源来源，用户从房源详情中选择【悬赏找好房】1ERP、2搜搜中介、3搜搜个人、4优优、5搜搜合租
	 */
	private Byte wfRelateSource;
	/**
	 * @mbggenerated 用途
	 */
	private String houseUseage;
	/**
	 * @mbggenerated 发布委托的优优用户名
	 */
	private String youyouUsername;
	/**
	 * @mbggenerated 防止数据并发请求时重复提交的唯一MD5码，（具体的唯一策略在程序中自行实现），例如：WX_ID + TIME（控制在分钟内）
	 */
	private String onlyMd5Str;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getWfId() {
		return wfId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfId(Integer wfId) {
		this.wfId = wfId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	public String getCaseSubject() {
		return caseSubject;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseSubject(String caseSubject) {
		this.caseSubject = caseSubject == null ? null : caseSubject.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseDesc() {
		return caseDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseDesc(String caseDesc) {
		this.caseDesc = caseDesc == null ? null : caseDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getJiedanCount() {
		return jiedanCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setJiedanCount(Byte jiedanCount) {
		this.jiedanCount = jiedanCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfReward() {
		return wfReward;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfReward(Integer wfReward) {
		this.wfReward = wfReward;
	}

	/**
	 * @mbggenerated
	 */
	public String getWfFee() {
		return wfFee;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfFee(String wfFee) {
		this.wfFee = wfFee == null ? null : wfFee.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfStatus() {
		return wfStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfStatus(Integer wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxId(Integer wxId) {
		this.wxId = wxId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfRelateId() {
		return wfRelateId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfRelateId(Integer wfRelateId) {
		this.wfRelateId = wfRelateId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWfSex() {
		return wfSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfSex(Byte wfSex) {
		this.wfSex = wfSex;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfRegion() {
		return wfRegion;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfRegion(Integer wfRegion) {
		this.wfRegion = wfRegion;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfSection() {
		return wfSection;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfSection(Integer wfSection) {
		this.wfSection = wfSection;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfFix() {
		return wfFix;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfFix(Integer wfFix) {
		this.wfFix = wfFix;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWfRecomed() {
		return wfRecomed;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfRecomed(Byte wfRecomed) {
		this.wfRecomed = wfRecomed;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsVip() {
		return isVip;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsVip(Byte isVip) {
		this.isVip = isVip;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId == null ? null : archiveId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLockNum() {
		return lockNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setLockNum(Byte lockNum) {
		this.lockNum = lockNum;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLotteryTimes() {
		return lotteryTimes;
	}

	/**
	 * @mbggenerated
	 */
	public void setLotteryTimes(Byte lotteryTimes) {
		this.lotteryTimes = lotteryTimes;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRemainTimes() {
		return remainTimes;
	}

	/**
	 * @mbggenerated
	 */
	public void setRemainTimes(Byte remainTimes) {
		this.remainTimes = remainTimes;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWinningTimes() {
		return winningTimes;
	}

	/**
	 * @mbggenerated
	 */
	public void setWinningTimes(Byte winningTimes) {
		this.winningTimes = winningTimes;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getIshezu() {
		return ishezu;
	}

	/**
	 * @mbggenerated
	 */
	public void setIshezu(Integer ishezu) {
		this.ishezu = ishezu;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSourceType() {
		return sourceType;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWfRelateSource() {
		return wfRelateSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfRelateSource(Byte wfRelateSource) {
		this.wfRelateSource = wfRelateSource;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage == null ? null : houseUseage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getYouyouUsername() {
		return youyouUsername;
	}

	/**
	 * @mbggenerated
	 */
	public void setYouyouUsername(String youyouUsername) {
		this.youyouUsername = youyouUsername == null ? null : youyouUsername.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOnlyMd5Str() {
		return onlyMd5Str;
	}

	/**
	 * @mbggenerated
	 */
	public void setOnlyMd5Str(String onlyMd5Str) {
		this.onlyMd5Str = onlyMd5Str == null ? null : onlyMd5Str.trim();
	}
}