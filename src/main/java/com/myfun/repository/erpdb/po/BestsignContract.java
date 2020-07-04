package com.myfun.repository.erpdb.po;

import java.util.Date;

/**
 * 上上签电子委托记录 签署人 链接记录
 * @author 伍政康
 * @since 2019年12月20日
 */
public class BestsignContract{
	private String id;
	//合同ID
	private String contractId;
	//模板ID
	private String tid;
	//签署人 account
	private String bestsignPerAccount;
	//签署人 account
	private String bestsignPerPhone;
	//美联系统链接 uri
	private String MLuri;
	//短链接
	private String shortUrl;
	//长链接
	private String longUrl;
	//签署状态 0 带签署  1 已经签署
	private String signState;
	//截至日期  
	private Date expireTime;
	//创建时间
	private Date createTime;
	//切换数据库
	private Integer shardCityId;
	
	//短信通知 0未通知 1通知失败 2已通知
	private String SMS;
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getBestsignPerAccount() {
		return bestsignPerAccount;
	}
	public void setBestsignPerAccount(String bestsignPerAccount) {
		this.bestsignPerAccount = bestsignPerAccount;
	}
	public String getBestsignPerPhone() {
		return bestsignPerPhone;
	}
	public void setBestsignPerPhone(String bestsignPerPhone) {
		this.bestsignPerPhone = bestsignPerPhone;
	}
	public String getMLuri() {
		return MLuri;
	}
	public void setMLuri(String mLuri) {
		MLuri = mLuri;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getSignState() {
		return signState;
	}
	public void setSignState(String signState) {
		this.signState = signState;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSMS() {
		return SMS;
	}
	public void setSMS(String sMS) {
		this.SMS = sMS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getShardCityId() {
		return shardCityId;
	}
	public void setShardCityId(Integer shardCityId) {
		this.shardCityId = shardCityId;
	}
	
}
