package com.myfun.repository.fafundb.dto;

import com.myfun.repository.fafundb.po.FafunFafaDetailLog;

public class FafaSiteClickRankDto extends FafunFafaDetailLog{

	private static final long serialVersionUID = 1L;
	private String siteName;// 站点名称
	private String userName;// 用户名称
	private String activeLvl;//活跃度
	private Integer pubCount;// 各站点房源发布量
	private Integer delCount;// 各站点下架量
	private Integer refCount;// 各站点刷新量
	private Integer siteCount;// 站点量
	private Integer sumCount;// 总量
	private Integer ranking;//排名
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPubCount() {
		return pubCount;
	}
	public void setPubCount(Integer pubCount) {
		this.pubCount = pubCount;
	}
	public Integer getDelCount() {
		return delCount;
	}
	public void setDelCount(Integer delCount) {
		this.delCount = delCount;
	}
	public Integer getRefCount() {
		return refCount;
	}
	public void setRefCount(Integer refCount) {
		this.refCount = refCount;
	}
	public String getActiveLvl() {
		return activeLvl;
	}
	public void setActiveLvl(String activeLvl) {
		this.activeLvl = activeLvl;
	}
	public Integer getSiteCount() {
		return siteCount;
	}
	public void setSiteCount(Integer siteCount) {
		this.siteCount = siteCount;
	}
	public Integer getSumCount() {
		return sumCount;
	}
	public void setSumCount(Integer sumCount) {
		this.sumCount = sumCount;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	
}
