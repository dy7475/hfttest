package com.myfun.repository.admindb.param;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.support.param.PageParam;

/***
 * 精英版管理列表参数
 * 
 * @author XIONG CAI
 *
 */
public class RecommendPersonalListpParam extends PageParam {

	private Integer archiveId;

	private String userName;

	private String userIccode;

	private Byte userSex;

	private Date userBirthday;

	private String userEmail;

	private String userMobile;

	private String userFixedph;

	private String userOfficeph;

	private String userQq;

	private Integer provinceId;

	private Short cityId;

	private String serviceReg;

	private String serviceZone;

	private String userAddress;

	private String userPostcode;

	private String userSchool;

	private String userField;

	private String userSchlrecord;

	private String userForeign;

	private String userPolity;

	private String professionSub;

	private String userDesc;

	private String userNumber;

	private String nickName;

	private String icPhoto1;

	private String icPhoto2;

	private String userPhoto;

	private String userPhotoMin;

	private String cardPhoto;

	private String bbsPhoto;

	private String shopInnerPhoto;

	private String shopOuterPhoto;

	private Integer uaId;

	private Integer userRight;

	private Integer userHonest;

	private Integer superUser;

	private Date superStart;

	private Date superEnd;

	private Integer superDays;

	private Date creationTime1;
	
	private Date creationTime2;

	private Integer webstoreStatus;

	private Integer userBidding;

	private Integer houseBidding;

	private Integer copyFrom;

	private Date buySrvEnd;

	private Integer friendFlag;

	private Integer sellComp;

	private Integer sellId;

	private Integer userEdition;

	private Byte mobileValided;

	private BigDecimal highAmount;

	private BigDecimal balance;

	private Byte validAccount;

	private Date lastLoginTime;

	private Byte regFrom;

	private String serviceZoneIds;

	private Byte isDispatcher;

	private Integer uaIdComp;

	private Integer vipStatus;

	private Integer isSellerShare;

	private Integer orderStatus;

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserIccode() {
		return userIccode;
	}

	public void setUserIccode(String userIccode) {
		this.userIccode = userIccode == null ? null : userIccode.trim();
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public String getUserFixedph() {
		return userFixedph;
	}

	public void setUserFixedph(String userFixedph) {
		this.userFixedph = userFixedph == null ? null : userFixedph.trim();
	}

	public String getUserOfficeph() {
		return userOfficeph;
	}

	public void setUserOfficeph(String userOfficeph) {
		this.userOfficeph = userOfficeph == null ? null : userOfficeph.trim();
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq == null ? null : userQq.trim();
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Short getCityId() {
		return cityId;
	}

	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	public String getServiceReg() {
		return serviceReg;
	}

	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg == null ? null : serviceReg.trim();
	}

	public String getServiceZone() {
		return serviceZone;
	}

	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone == null ? null : serviceZone.trim();
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress == null ? null : userAddress.trim();
	}

	public String getUserPostcode() {
		return userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode == null ? null : userPostcode.trim();
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool == null ? null : userSchool.trim();
	}

	public String getUserField() {
		return userField;
	}

	public void setUserField(String userField) {
		this.userField = userField == null ? null : userField.trim();
	}

	public String getUserSchlrecord() {
		return userSchlrecord;
	}

	public void setUserSchlrecord(String userSchlrecord) {
		this.userSchlrecord = userSchlrecord == null ? null : userSchlrecord.trim();
	}

	public String getUserForeign() {
		return userForeign;
	}

	public void setUserForeign(String userForeign) {
		this.userForeign = userForeign == null ? null : userForeign.trim();
	}

	public String getUserPolity() {
		return userPolity;
	}

	public void setUserPolity(String userPolity) {
		this.userPolity = userPolity == null ? null : userPolity.trim();
	}

	public String getProfessionSub() {
		return professionSub;
	}

	public void setProfessionSub(String professionSub) {
		this.professionSub = professionSub == null ? null : professionSub.trim();
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc == null ? null : userDesc.trim();
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber == null ? null : userNumber.trim();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getIcPhoto1() {
		return icPhoto1;
	}

	public void setIcPhoto1(String icPhoto1) {
		this.icPhoto1 = icPhoto1 == null ? null : icPhoto1.trim();
	}

	public String getIcPhoto2() {
		return icPhoto2;
	}

	public void setIcPhoto2(String icPhoto2) {
		this.icPhoto2 = icPhoto2 == null ? null : icPhoto2.trim();
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto == null ? null : userPhoto.trim();
	}

	public String getUserPhotoMin() {
		return userPhotoMin;
	}

	public void setUserPhotoMin(String userPhotoMin) {
		this.userPhotoMin = userPhotoMin == null ? null : userPhotoMin.trim();
	}

	public String getCardPhoto() {
		return cardPhoto;
	}

	public void setCardPhoto(String cardPhoto) {
		this.cardPhoto = cardPhoto == null ? null : cardPhoto.trim();
	}

	public String getBbsPhoto() {
		return bbsPhoto;
	}

	public void setBbsPhoto(String bbsPhoto) {
		this.bbsPhoto = bbsPhoto == null ? null : bbsPhoto.trim();
	}

	public String getShopInnerPhoto() {
		return shopInnerPhoto;
	}

	public void setShopInnerPhoto(String shopInnerPhoto) {
		this.shopInnerPhoto = shopInnerPhoto == null ? null : shopInnerPhoto.trim();
	}

	public String getShopOuterPhoto() {
		return shopOuterPhoto;
	}

	public void setShopOuterPhoto(String shopOuterPhoto) {
		this.shopOuterPhoto = shopOuterPhoto == null ? null : shopOuterPhoto.trim();
	}

	public Integer getUaId() {
		return uaId;
	}

	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}

	public Integer getUserRight() {
		return userRight;
	}

	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}

	public Integer getUserHonest() {
		return userHonest;
	}

	public void setUserHonest(Integer userHonest) {
		this.userHonest = userHonest;
	}

	public Integer getSuperUser() {
		return superUser;
	}

	public void setSuperUser(Integer superUser) {
		this.superUser = superUser;
	}

	public Date getSuperStart() {
		return superStart;
	}

	public void setSuperStart(Date superStart) {
		this.superStart = superStart;
	}

	public Date getSuperEnd() {
		return superEnd;
	}

	public void setSuperEnd(Date superEnd) {
		this.superEnd = superEnd;
	}

	public Integer getSuperDays() {
		return superDays;
	}

	public void setSuperDays(Integer superDays) {
		this.superDays = superDays;
	}

	public Integer getWebstoreStatus() {
		return webstoreStatus;
	}

	public void setWebstoreStatus(Integer webstoreStatus) {
		this.webstoreStatus = webstoreStatus;
	}

	public Integer getUserBidding() {
		return userBidding;
	}

	public void setUserBidding(Integer userBidding) {
		this.userBidding = userBidding;
	}

	public Integer getHouseBidding() {
		return houseBidding;
	}

	public void setHouseBidding(Integer houseBidding) {
		this.houseBidding = houseBidding;
	}

	public Integer getCopyFrom() {
		return copyFrom;
	}

	public void setCopyFrom(Integer copyFrom) {
		this.copyFrom = copyFrom;
	}

	public Date getBuySrvEnd() {
		return buySrvEnd;
	}

	public void setBuySrvEnd(Date buySrvEnd) {
		this.buySrvEnd = buySrvEnd;
	}

	public Integer getFriendFlag() {
		return friendFlag;
	}

	public void setFriendFlag(Integer friendFlag) {
		this.friendFlag = friendFlag;
	}

	public Integer getSellComp() {
		return sellComp;
	}

	public void setSellComp(Integer sellComp) {
		this.sellComp = sellComp;
	}

	public Integer getSellId() {
		return sellId;
	}

	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}

	public Integer getUserEdition() {
		return userEdition;
	}

	public void setUserEdition(Integer userEdition) {
		this.userEdition = userEdition;
	}

	public Byte getMobileValided() {
		return mobileValided;
	}

	public void setMobileValided(Byte mobileValided) {
		this.mobileValided = mobileValided;
	}

	public BigDecimal getHighAmount() {
		return highAmount;
	}

	public void setHighAmount(BigDecimal highAmount) {
		this.highAmount = highAmount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Byte getValidAccount() {
		return validAccount;
	}

	public void setValidAccount(Byte validAccount) {
		this.validAccount = validAccount;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Byte getRegFrom() {
		return regFrom;
	}

	public void setRegFrom(Byte regFrom) {
		this.regFrom = regFrom;
	}

	public String getServiceZoneIds() {
		return serviceZoneIds;
	}

	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds == null ? null : serviceZoneIds.trim();
	}

	public Byte getIsDispatcher() {
		return isDispatcher;
	}

	public void setIsDispatcher(Byte isDispatcher) {
		this.isDispatcher = isDispatcher;
	}

	public Integer getUaIdComp() {
		return uaIdComp;
	}

	public void setUaIdComp(Integer uaIdComp) {
		this.uaIdComp = uaIdComp;
	}

	public Integer getVipStatus() {
		return vipStatus;
	}

	public void setVipStatus(Integer vipStatus) {
		this.vipStatus = vipStatus;
	}

	public Integer getIsSellerShare() {
		return isSellerShare;
	}

	public void setIsSellerShare(Integer isSellerShare) {
		this.isSellerShare = isSellerShare;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreationTime1() {
		return creationTime1;
	}

	public void setCreationTime1(Date creationTime1) {
		this.creationTime1 = creationTime1;
	}

	public Date getCreationTime2() {
		return creationTime2;
	}

	public void setCreationTime2(Date creationTime2) {
		this.creationTime2 = creationTime2;
	}

}
