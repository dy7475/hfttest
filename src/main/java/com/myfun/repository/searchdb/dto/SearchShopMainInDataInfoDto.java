package com.myfun.repository.searchdb.dto;

import java.util.Date;

import com.myfun.repository.searchdb.po.SearchShopMain;

/**
 * 搜搜转铺单条数据返回值
 * @author 张宏利
 * @since 2016年8月19日
 */
public class SearchShopMainInDataInfoDto extends SearchShopMain{
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
	private Byte pushmsgLockflag;
	private Date lastPushmsgTime;
	private String pageSours;
	private String readed;
	private String conerted;
	private String mobilePhone;
	private String telePhone;
	private String telSource;
	private Byte complaintFlag;
	private Date complaintTime;
	private Integer houseFlag;
	private String thumbUrl;//图片地址
	private String phone;//电话图片地址
	private Integer registerStatus;//电话登记
	private Integer convertCount;//搜搜转入系统次数
	private String convertTime;//搜搜转入系统時間
	private String pbTime;//查看电话时间
	private String cantViewReson;//是否可查看
	private String isPic;
	private String canViewCount;//普通数据剩余可查看条数
	private String oldCanViewCount;//历史数据剩余可查看条数

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getCantViewReson() {
		return cantViewReson;
	}

	public void setCantViewReson(String cantViewReson) {
		this.cantViewReson = cantViewReson;
	}

	public String getCanViewCount() {
		return canViewCount;
	}

	public void setCanViewCount(String canViewCount) {
		this.canViewCount = canViewCount;
	}

	public String getOldCanViewCount() {
		return oldCanViewCount;
	}

	public void setOldCanViewCount(String oldCanViewCount) {
		this.oldCanViewCount = oldCanViewCount;
	}

	public String getPbTime() {
		return pbTime;
	}

	public void setPbTime(String pbTime) {
		this.pbTime = pbTime;
	}


	public String getIsPic() {
		return isPic;
	}

	public void setIsPic(String isPic) {
		this.isPic = isPic;
	}

	public Integer getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Integer registerStatus) {
		this.registerStatus = registerStatus;
	}

	public Integer getConvertCount() {
		return convertCount;
	}

	public void setConvertCount(Integer convertCount) {
		this.convertCount = convertCount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Integer getHouseFlag() {
		return houseFlag;
	}
	public void setHouseFlag(Integer houseFlag) {
		this.houseFlag = houseFlag;
	}
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
	public Byte getPushmsgLockflag() {
		return pushmsgLockflag;
	}
	public void setPushmsgLockflag(Byte pushmsgLockflag) {
		this.pushmsgLockflag = pushmsgLockflag;
	}
	public Date getLastPushmsgTime() {
		return lastPushmsgTime;
	}
	public void setLastPushmsgTime(Date lastPushmsgTime) {
		this.lastPushmsgTime = lastPushmsgTime;
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
	public Date getComplaintTime() {
		return complaintTime;
	}
	public void setComplaintTime(Date complaintTime) {
		this.complaintTime = complaintTime;
	}
	public Byte getComplaintFlag() {
		return complaintFlag;
	}
	public void setComplaintFlag(Byte complaintFlag) {
		this.complaintFlag = complaintFlag;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getTelSource() {
		return telSource;
	}
	public void setTelSource(String telSource) {
		this.telSource = telSource;
	}

	public String getConvertTime() {
		return convertTime;
	}

	public void setConvertTime(String convertTime) {
		this.convertTime = convertTime;
	}
	
	
}

