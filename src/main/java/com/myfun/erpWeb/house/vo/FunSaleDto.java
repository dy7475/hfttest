package com.myfun.erpWeb.house.vo;

import java.math.BigDecimal;

import com.myfun.repository.erpdb.po.ErpFunSale;

public class FunSaleDto extends ErpFunSale {

	private static final long serialVersionUID = 1L;
	private String buildUserName;
	private String buildUserPhoto;
	private String buildShowTime;
	private Byte buildBiddflag;
	private String buildBeginDate;
	private String buildEndDate;
	private String fafaSites;
	private String userPhoto;
	private String userName;
	private String userNo;
	private String richText; // 富文本
	private String richTextFitment; // 装修描述富文本
	private String richTextLayout; // 户型介绍富文本
	private String richTextRights; // 权属抵押富文本
	private String onlyTextCore; // 核心卖点纯文本
	private String onlyTextFitment; // 装修描述纯文本
	private String onlyTextLayout; // 户型介绍纯文本
	private String onlyTextRights; // 权属抵押纯文本
	private String deptName;
	private String phoneSend;
	private String dealLockFlag;
	private String keyDeptId;// 钥匙的所在门店
	private String userMobile;
	private String deptPhone;
	private String localHouseId;
	private String qrcodeAddr;
	private Integer userRight;
	private String cellPhone;// 电话号码
	private String ownerName;// 所属人
	private String commitKeyUser;// 钥匙提交人
	private String keyDeptName;// 钥匙所在门店名称
	private String keyStatus;// 钥匙存储状态
	private String keyNote;
	private String keyNoteUsername;
	private Integer favoriteId;
	private String trueComplaintType;// 投诉状态
	private String trueAppealTime;// 申诉时间
	private String trueDealContent;// 处理描述
	private String trueCreationTime;// 投诉时间
	private String trueDealStatus;// 处理状态
	private Integer trueDealType;// 处理类型
	private Integer biddingStatus; // 推广标记
	private Integer floorsType;// 低层,中层, 高层, 超高层
	private Integer leaseBuildId;// 出租信息的BUILDID
	private Byte leaseUseage;// 出租信息的LEASEUSEAGE
	private Integer leaseId;// 出租信息的LEASEID
	private Integer leaseStatus;// 出租信息的 房屋状态，DD：HOUSESTATUS
	private Byte priceUnit;// 出租信息的 租金单位，DD:PRICEUNIT
	private BigDecimal leaseTotalPrice;// 出租信息的 租金金额
	private String compName;// 所属人公司名
	private String modifyPriceStart;// 修改价格时间
	private BigDecimal modifyPriceBefore;// 修改之前的价格
	private BigDecimal modifyPriceAfter;// 修改之后的价格
	private Integer lookCount;// 带看次数
	private Integer commissionRate;// 城市公盘分佣比例
	private String websiteState;	//美联发布官网状态 0=未发布 1=已发布
	public String getBuildUserName() {
		return buildUserName;
	}
	public void setBuildUserName(String buildUserName) {
		this.buildUserName = buildUserName;
	}
	public String getBuildUserPhoto() {
		return buildUserPhoto;
	}
	public void setBuildUserPhoto(String buildUserPhoto) {
		this.buildUserPhoto = buildUserPhoto;
	}
	public String getBuildShowTime() {
		return buildShowTime;
	}
	public void setBuildShowTime(String buildShowTime) {
		this.buildShowTime = buildShowTime;
	}
	public Byte getBuildBiddflag() {
		return buildBiddflag;
	}
	public void setBuildBiddflag(Byte buildBiddflag) {
		this.buildBiddflag = buildBiddflag;
	}
	public String getBuildBeginDate() {
		return buildBeginDate;
	}
	public void setBuildBeginDate(String buildBeginDate) {
		this.buildBeginDate = buildBeginDate;
	}
	public String getBuildEndDate() {
		return buildEndDate;
	}
	public void setBuildEndDate(String buildEndDate) {
		this.buildEndDate = buildEndDate;
	}
	public String getFafaSites() {
		return fafaSites;
	}
	public void setFafaSites(String fafaSites) {
		this.fafaSites = fafaSites;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getRichText() {
		return richText;
	}
	public void setRichText(String richText) {
		this.richText = richText;
	}
	public String getRichTextFitment() {
		return richTextFitment;
	}
	public void setRichTextFitment(String richTextFitment) {
		this.richTextFitment = richTextFitment;
	}
	public String getRichTextLayout() {
		return richTextLayout;
	}
	public void setRichTextLayout(String richTextLayout) {
		this.richTextLayout = richTextLayout;
	}
	public String getRichTextRights() {
		return richTextRights;
	}
	public void setRichTextRights(String richTextRights) {
		this.richTextRights = richTextRights;
	}
	public String getOnlyTextCore() {
		return onlyTextCore;
	}
	public void setOnlyTextCore(String onlyTextCore) {
		this.onlyTextCore = onlyTextCore;
	}
	public String getOnlyTextFitment() {
		return onlyTextFitment;
	}
	public void setOnlyTextFitment(String onlyTextFitment) {
		this.onlyTextFitment = onlyTextFitment;
	}
	public String getOnlyTextLayout() {
		return onlyTextLayout;
	}
	public void setOnlyTextLayout(String onlyTextLayout) {
		this.onlyTextLayout = onlyTextLayout;
	}
	public String getOnlyTextRights() {
		return onlyTextRights;
	}
	public void setOnlyTextRights(String onlyTextRights) {
		this.onlyTextRights = onlyTextRights;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPhoneSend() {
		return phoneSend;
	}
	public void setPhoneSend(String phoneSend) {
		this.phoneSend = phoneSend;
	}
	public String getDealLockFlag() {
		return dealLockFlag;
	}
	public void setDealLockFlag(String dealLockFlag) {
		this.dealLockFlag = dealLockFlag;
	}
	public String getKeyDeptId() {
		return keyDeptId;
	}
	public void setKeyDeptId(String keyDeptId) {
		this.keyDeptId = keyDeptId;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getDeptPhone() {
		return deptPhone;
	}
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}
	public String getLocalHouseId() {
		return localHouseId;
	}
	public void setLocalHouseId(String localHouseId) {
		this.localHouseId = localHouseId;
	}
	public String getQrcodeAddr() {
		return qrcodeAddr;
	}
	public void setQrcodeAddr(String qrcodeAddr) {
		this.qrcodeAddr = qrcodeAddr;
	}
	public Integer getUserRight() {
		return userRight;
	}
	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCommitKeyUser() {
		return commitKeyUser;
	}
	public void setCommitKeyUser(String commitKeyUser) {
		this.commitKeyUser = commitKeyUser;
	}
	public String getKeyDeptName() {
		return keyDeptName;
	}
	public void setKeyDeptName(String keyDeptName) {
		this.keyDeptName = keyDeptName;
	}
	public String getKeyStatus() {
		return keyStatus;
	}
	public void setKeyStatus(String keyStatus) {
		this.keyStatus = keyStatus;
	}
	public String getKeyNote() {
		return keyNote;
	}
	public void setKeyNote(String keyNote) {
		this.keyNote = keyNote;
	}
	public String getKeyNoteUsername() {
		return keyNoteUsername;
	}
	public void setKeyNoteUsername(String keyNoteUsername) {
		this.keyNoteUsername = keyNoteUsername;
	}
	public Integer getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getTrueComplaintType() {
		return trueComplaintType;
	}
	public void setTrueComplaintType(String trueComplaintType) {
		this.trueComplaintType = trueComplaintType;
	}
	public String getTrueAppealTime() {
		return trueAppealTime;
	}
	public void setTrueAppealTime(String trueAppealTime) {
		this.trueAppealTime = trueAppealTime;
	}
	public String getTrueDealContent() {
		return trueDealContent;
	}
	public void setTrueDealContent(String trueDealContent) {
		this.trueDealContent = trueDealContent;
	}
	public String getTrueCreationTime() {
		return trueCreationTime;
	}
	public void setTrueCreationTime(String trueCreationTime) {
		this.trueCreationTime = trueCreationTime;
	}
	public String getTrueDealStatus() {
		return trueDealStatus;
	}
	public void setTrueDealStatus(String trueDealStatus) {
		this.trueDealStatus = trueDealStatus;
	}
	public Integer getLeaseBuildId() {
		return leaseBuildId;
	}
	public void setLeaseBuildId(Integer leaseBuildId) {
		this.leaseBuildId = leaseBuildId;
	}
	public Byte getLeaseUseage() {
		return leaseUseage;
	}
	public void setLeaseUseage(Byte leaseUseage) {
		this.leaseUseage = leaseUseage;
	}
	public Integer getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}
	public Integer getLeaseStatus() {
		return leaseStatus;
	}
	public void setLeaseStatus(Integer leaseStatus) {
		this.leaseStatus = leaseStatus;
	}
	public Byte getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getModifyPriceStart() {
		return modifyPriceStart;
	}
	public void setModifyPriceStart(String modifyPriceStart) {
		this.modifyPriceStart = modifyPriceStart;
	}
	public Integer getLookCount() {
		return lookCount;
	}
	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
	}
	public Integer getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(Integer commissionRate) {
		this.commissionRate = commissionRate;
	}
	public Integer getTrueDealType() {
		return trueDealType;
	}
	public void setTrueDealType(Integer trueDealType) {
		this.trueDealType = trueDealType;
	}
	public Integer getBiddingStatus() {
		return biddingStatus;
	}
	public void setBiddingStatus(Integer biddingStatus) {
		this.biddingStatus = biddingStatus;
	}
	public Integer getFloorsType() {
		return floorsType;
	}
	public void setFloorsType(Integer floorsType) {
		this.floorsType = floorsType;
	}
	public BigDecimal getModifyPriceBefore() {
		return modifyPriceBefore;
	}
	public void setModifyPriceBefore(BigDecimal modifyPriceBefore) {
		this.modifyPriceBefore = modifyPriceBefore;
	}
	public BigDecimal getModifyPriceAfter() {
		return modifyPriceAfter;
	}
	public void setModifyPriceAfter(BigDecimal modifyPriceAfter) {
		this.modifyPriceAfter = modifyPriceAfter;
	}

	public String getWebsiteState() {
		return websiteState;
	}

	public void setWebsiteState(String websiteState) {
		this.websiteState = websiteState;
	}
}
