package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunSale;

import java.math.BigDecimal;
import java.util.Date;

public class ErpFunSaleDto extends ErpFunSale{
	/**
	 * @author 熊刚
	 * @since 2017年7月12日
	 */
	private static final long serialVersionUID = 1L;
	private String biddingDays;
	private String biddingPrice;
	private String yyStatus;
	private String saleLease;
	private String remainsDays;
	private String remainsHours;
	private String biddEndTime;
	private String biddFlag;
	private String  buildAddr;
	private String userPhoto;
	private String userName;
	private String userNo;
	private String floorsType;
	// 富文本
	private String richText;
	private String richTextFitment; // 装修描述富文本
	private String richTextLayout; // 户型介绍富文本
	private String richTextRights; // 权属抵押富文本
	private String onlyTextCore; // 核心卖点纯文本
	private String onlyTextFitment; // 装修描述纯文本
	private String onlyTextLayout; // 户型介绍纯文本
	private String onlytextRight; // 权属抵押纯文本
	private Integer userRight;
	private String userMobile;
	private byte trueComplaintType;// 投诉状态
	private Date trueAppealTime;//申诉时间
	private String trueDealContent;//处理描述
	private Date trueCreationTime;//投诉时间
	private byte trueDealStatus;//处理状态
	private byte trueDealType;//处理类型
	private Integer favoriteId;
	private String deptName;
	private String deptPhone;
	private String keyDeptName;//钥匙所在门店名称
	private String keyStatus;//钥匙存储状态
	private String keyNote;
	private String keyNoteUsername;
	private String dealLockFlag;
	private String qrcodeAddr;
	private String leaseBuileId;// 出租信息的BUILD_ID
	private byte leaseUseage;// 出租信息的LEASE_USEAGE
	private Integer leaseId;// 出租信息的LEASE_ID
	private Integer leaseStatus;// 出租信息的  房屋状态，DD：HOUSE_STATUS
	private byte priceUnit;// 出租信息的  租金单位，DD:PRICE_UNIT
	private BigDecimal leaseTotalPrice;// 出租信息的  租金金额
	private String biddingStatus; // 推广标记
	private Date modifyPriceStart;// 修改价格时间
	private BigDecimal modifyPriceBefor;// 修改之前的价格
	private BigDecimal modifyPriceAfter;// 修改之后的价格

	// 有效房源状态
	private Integer counts;//总共有效房源
	private Integer keyCount;//有效钥匙
	private Integer explrthCount;//已房勘
	private Integer publishCount;//
	private Integer trueCount;//预定
	private Integer photoCount;//
	private Integer voidoCount;//
	private Integer panoramaCount;//有VR
	private Integer scheduleCount;//

	private Integer houseConsign;//
	private Integer houseLeve;//
	private Integer houseFitment;//
	private Integer houseRound;
	private Integer houseUseage;
	private Integer houseType;

	private String phoneSend;

	private Integer level;
	private Integer attrname;

	public String getFloorsType() {
		return floorsType;
	}

	public void setFloorsType(String floorsType) {
		this.floorsType = floorsType;
	}

	public String getPhoneSend() {
		return phoneSend;
	}

	public void setPhoneSend(String phoneSend) {
		this.phoneSend = phoneSend;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getAttrname() {
		return attrname;
	}

	public void setAttrname(Integer attrname) {
		this.attrname = attrname;
	}

	public String getBuildAddr() {
		return buildAddr;
	}

	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr;
	}
	public String getRemainsDays() {
		return remainsDays;
	}
	public void setRemainsDays(String remainsDays) {
		this.remainsDays = remainsDays;
	}
	public String getRemainsHours() {
		return remainsHours;
	}
	public void setRemainsHours(String remainsHours) {
		this.remainsHours = remainsHours;
	}
	public String getBiddFlag() {
		return biddFlag;
	}
	public void setBiddFlag(String biddFlag) {
		this.biddFlag = biddFlag;
	}
	public String getSaleLease() {
		return saleLease;
	}
	public void setSaleLease(String saleLease) {
		this.saleLease = saleLease;
	}
	public String getYyStatus() {
		return yyStatus;
	}
	public void setYyStatus(String yyStatus) {
		this.yyStatus = yyStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBiddingDays() {
		return biddingDays;
	}
	public void setBiddingDays(String biddingDays) {
		this.biddingDays = biddingDays;
	}
	public String getBiddingPrice() {
		return biddingPrice;
	}
	public void setBiddingPrice(String biddingPrice) {
		this.biddingPrice = biddingPrice;
	}
	public String getBiddEndTime() {
		return biddEndTime;
	}
	public void setBiddEndTime(String biddEndTime) {
		this.biddEndTime = biddEndTime;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	
	public String getOnlytextRight() {
		return onlytextRight;
	}
	
	public void setOnlytextRight(String onlytextRight) {
		this.onlytextRight = onlytextRight;
	}
	
	
	
	public byte getTrueComplaintType() {
		return trueComplaintType;
	}
	
	public void setTrueComplaintType(byte trueComplaintType) {
		this.trueComplaintType = trueComplaintType;
	}
	
	public Date getTrueAppealTime() {
		return trueAppealTime;
	}
	
	public void setTrueAppealTime(Date trueAppealTime) {
		this.trueAppealTime = trueAppealTime;
	}
	
	public String getTrueDealContent() {
		return trueDealContent;
	}
	
	public void setTrueDealContent(String trueDealContent) {
		this.trueDealContent = trueDealContent;
	}
	
	public Date getTrueCreationTime() {
		return trueCreationTime;
	}
	
	public void setTrueCreationTime(Date trueCreationTime) {
		this.trueCreationTime = trueCreationTime;
	}
	
	public byte getTrueDealStatus() {
		return trueDealStatus;
	}
	
	public void setTrueDealStatus(byte trueDealStatus) {
		this.trueDealStatus = trueDealStatus;
	}
	
	public byte getTrueDealType() {
		return trueDealType;
	}
	
	public void setTrueDealType(byte trueDealType) {
		this.trueDealType = trueDealType;
	}
	
	public Integer getUserRight() {
		return userRight;
	}
	
	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}
	
	public String getUserMobile() {
		return userMobile;
	}
	
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	public Integer getFavoriteId() {
		return favoriteId;
	}
	
	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String getDeptPhone() {
		return deptPhone;
	}
	
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
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
	
	public String getDealLockFlag() {
		return dealLockFlag;
	}
	
	public void setDealLockFlag(String dealLockFlag) {
		this.dealLockFlag = dealLockFlag;
	}
	
	public String getQrcodeAddr() {
		return qrcodeAddr;
	}
	
	public void setQrcodeAddr(String qrcodeAddr) {
		this.qrcodeAddr = qrcodeAddr;
	}
	
	public String getLeaseBuileId() {
		return leaseBuileId;
	}
	
	public void setLeaseBuileId(String leaseBuileId) {
		this.leaseBuileId = leaseBuileId;
	}
	
	public byte getLeaseUseage() {
		return leaseUseage;
	}
	
	public void setLeaseUseage(byte leaseUseage) {
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
	
	public byte getPriceUnit() {
		return priceUnit;
	}
	
	public void setPriceUnit(byte priceUnit) {
		this.priceUnit = priceUnit;
	}
	
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}
	
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}
	
	public String getBiddingStatus() {
		return biddingStatus;
	}
	
	public void setBiddingStatus(String biddingStatus) {
		this.biddingStatus = biddingStatus;
	}
	
	public Date getModifyPriceStart() {
		return modifyPriceStart;
	}
	
	public void setModifyPriceStart(Date modifyPriceStart) {
		this.modifyPriceStart = modifyPriceStart;
	}
	
	public BigDecimal getModifyPriceBefor() {
		return modifyPriceBefor;
	}
	
	public void setModifyPriceBefor(BigDecimal modifyPriceBefor) {
		this.modifyPriceBefor = modifyPriceBefor;
	}
	
	public BigDecimal getModifyPriceAfter() {
		return modifyPriceAfter;
	}
	
	public void setModifyPriceAfter(BigDecimal modifyPriceAfter) {
		this.modifyPriceAfter = modifyPriceAfter;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(Integer keyCount) {
		this.keyCount = keyCount;
	}

	public Integer getExplrthCount() {
		return explrthCount;
	}

	public void setExplrthCount(Integer explrthCount) {
		this.explrthCount = explrthCount;
	}

	public Integer getPublishCount() {
		return publishCount;
	}

	public void setPublishCount(Integer publishCount) {
		this.publishCount = publishCount;
	}

	public Integer getTrueCount() {
		return trueCount;
	}

	public void setTrueCount(Integer trueCount) {
		this.trueCount = trueCount;
	}

	public Integer getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(Integer photoCount) {
		this.photoCount = photoCount;
	}

	public Integer getVoidoCount() {
		return voidoCount;
	}

	public void setVoidoCount(Integer voidoCount) {
		this.voidoCount = voidoCount;
	}

	public Integer getPanoramaCount() {
		return panoramaCount;
	}

	public void setPanoramaCount(Integer panoramaCount) {
		this.panoramaCount = panoramaCount;
	}

	public Integer getScheduleCount() {
		return scheduleCount;
	}

	public void setScheduleCount(Integer scheduleCount) {
		this.scheduleCount = scheduleCount;
	}

	public Integer getHouseConsign() {
		return houseConsign;
	}

	public void setHouseConsign(Integer houseConsign) {
		this.houseConsign = houseConsign;
	}

	public Integer getHouseLeve() {
		return houseLeve;
	}

	public void setHouseLeve(Integer houseLeve) {
		this.houseLeve = houseLeve;
	}

	public Integer getHouseFitment() {
		return houseFitment;
	}

	public void setHouseFitment(Integer houseFitment) {
		this.houseFitment = houseFitment;
	}

	public Integer getHouseRound() {
		return houseRound;
	}

	public void setHouseRound(Integer houseRound) {
		this.houseRound = houseRound;
	}


	public Integer getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(Integer houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}
}
