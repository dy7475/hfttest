package com.myfun.repository.searchdb.dto;

import java.util.Date;

import com.myfun.repository.searchdb.po.SearchLeaseIn;

public class SearchLeaseInDto extends SearchLeaseIn{
	private static final long serialVersionUID = 1L;
	private String title;
	private String region;
	private String useage;
	private String houseType;
	private String buildName;
	private String siteName;
	private String pageSours;
	private String readed = "0";
	private String conerted;
	private Date viewTime;
	private Date convertTime;
	private Byte complaintFlag;
	private Date complaintTime;
	private Integer houseFlag;
	private String thumbUrl;//图片地址
	private String phone;//电话图片
	private Integer registerStatus;//电话登记
	private Integer convertCount;//搜搜转入系统次数
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
	public String getUseage() {
		return useage;
	}
	public void setUseage(String useage) {
		this.useage = useage;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
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
	public Date getViewTime() {
		return viewTime;
	}
	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}
	public Date getConvertTime() {
		return convertTime;
	}
	public void setConvertTime(Date convertTime) {
		this.convertTime = convertTime;
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
	
	
}

