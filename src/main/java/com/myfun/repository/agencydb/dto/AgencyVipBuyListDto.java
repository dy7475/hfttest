package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyVipBuy;

/**
 * 搜搜求购单条数据返回值
 * @author 张宏利
 * @since 2016年8月19日
 */
public class AgencyVipBuyListDto extends AgencyVipBuy{
	private static final long serialVersionUID = 1L;
	private String title;
	private String buildName;
	private String region;
	private String sectors;
	private String transferFee;
	private String priceUnit;
	private String section;
	private String owner;
	private String smallPic;
	private String charact;
	private String pageSours;
	private String readed;
	private String conerted;
	
	
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSectors() {
		return sectors;
	}
	public void setSectors(String sectors) {
		this.sectors = sectors;
	}
	public String getTransferFee() {
		return transferFee;
	}
	public void setTransferFee(String transferFee) {
		this.transferFee = transferFee;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	public String getCharact() {
		return charact;
	}
	public void setCharact(String charact) {
		this.charact = charact;
	}
	public String getPageSours() {
		return pageSours;
	}
	public void setPageSours(String pageSours) {
		this.pageSours = pageSours;
	}
	public String getReaded() {
		return readed;
	}
	public void setReaded(String readed) {
		this.readed = readed;
	}
	public String getConerted() {
		return conerted;
	}
	public void setConerted(String conerted) {
		this.conerted = conerted;
	}
	
	
}

