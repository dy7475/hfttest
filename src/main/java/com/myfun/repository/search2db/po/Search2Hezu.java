package com.myfun.repository.search2db.po;

import java.io.Serializable;
import java.util.Date;
import org.apache.solr.client.solrj.beans.Field;

public class Search2Hezu extends Search2HezuKey implements Serializable {

	/**
	 * @mbggenerated 列表显示时间
	 */
	@Field(value = "IN_TIME")
	private Date inTime;
	/**
	 * @mbggenerated 标题
	 */
	@Field(value = "TITLE")
	private String title;
	/**
	 * @mbggenerated 户主名称
	 */
	@Field(value = "OWNER")
	private String owner;
	/**
	 * @mbggenerated 手机
	 */
	@Field(value = "MOBILE_PHONE")
	private String mobilePhone;
	/**
	 * @mbggenerated 固定电话
	 */
	@Field(value = "TELE_PHONE")
	private String telePhone;
	/**
	 * @mbggenerated 楼盘名称
	 */
	@Field(value = "BUILD_NAME")
	private String buildName;
	/**
	 * @mbggenerated 行政区
	 */
	@Field(value = "REGION")
	private String region;
	/**
	 * @mbggenerated 地域
	 */
	@Field(value = "SECTORS")
	private String sectors;
	/**
	 * @mbggenerated 环域
	 */
	@Field(value = "ROUND")
	private String round;
	/**
	 * @mbggenerated 商圈
	 */
	@Field(value = "SECTION")
	private String section;
	/**
	 * @mbggenerated 室
	 */
	@Field(value = "ROOM")
	private Integer room;
	/**
	 * @mbggenerated 厅
	 */
	@Field(value = "HALL")
	private Integer hall;
	/**
	 * @mbggenerated 卫
	 */
	@Field(value = "WEI")
	private Integer wei;
	/**
	 * @mbggenerated 阳台
	 */
	@Field(value = "YANG")
	private Integer yang;
	/**
	 * @mbggenerated 房屋类型
	 */
	@Field(value = "HOUSE_TYPE")
	private String houseType;
	/**
	 * @mbggenerated 楼层
	 */
	@Field(value = "FLOOR")
	private Integer floor;
	/**
	 * @mbggenerated 总楼层
	 */
	@Field(value = "FLOORS")
	private Integer floors;
	/**
	 * @mbggenerated 装修
	 */
	@Field(value = "FITMENT")
	private String fitment;
	/**
	 * @mbggenerated 朝向
	 */
	@Field(value = "DIRECT")
	private String direct;
	/**
	 * @mbggenerated 年代
	 */
	@Field(value = "HOUSE_YEAR")
	private String houseYear;
	/**
	 * @mbggenerated 房屋结构
	 */
	@Field(value = "HOUSE_STRUCT")
	private String houseStruct;
	/**
	 * @mbggenerated 用途
	 */
	@Field(value = "USEAGE")
	private String useage;
	/**
	 * @mbggenerated 产权
	 */
	@Field(value = "HOUSE_RIGHT")
	private String houseRight;
	/**
	 * @mbggenerated 付款方式
	 */
	@Field(value = "HOUSE_ACCOUNT")
	private String houseAccount;
	/**
	 * @mbggenerated 总面积
	 */
	@Field(value = "AREA")
	private Double area;
	/**
	 * @mbggenerated 室内面积
	 */
	@Field(value = "AREA2")
	private Double area2;
	/**
	 * @mbggenerated 租金
	 */
	@Field(value = "TOTAL_PRICE")
	private Double totalPrice;
	/**
	 * @mbggenerated 单位
	 */
	@Field(value = "PRICE_UNIT")
	private String priceUnit;
	/**
	 * @mbggenerated 押金
	 */
	@Field(value = "LEASE_DEPOSIT")
	private Double leaseDeposit;
	/**
	 * @mbggenerated 腾房时间
	 */
	@Field(value = "LEAVE_TIME")
	private String leaveTime;
	/**
	 * @mbggenerated 租赁期选
	 */
	@Field(value = "LEASE_LIMIT")
	private String leaseLimit;
	/**
	 * @mbggenerated 配台设置
	 */
	@Field(value = "HOUSE_SET")
	private String houseSet;
	/**
	 * @mbggenerated 描述
	 */
	@Field(value = "CHARACT")
	private String charact;
	/**
	 * @mbggenerated 站点id
	 */
	@Field(value = "SITE_ID")
	private Integer siteId;
	/**
	 * @mbggenerated 页面编号
	 */
	@Field(value = "PRIMITIVE_ID")
	private String primitiveId;
	/**
	 * @mbggenerated 站点名称
	 */
	@Field(value = "SITE_NAME")
	private String siteName;
	/**
	 * @mbggenerated 电话重复次数
	 */
	@Field(value = "TEL_COUNT")
	private Integer telCount;
	/**
	 * @mbggenerated 网站地址
	 */
	@Field(value = "PAGE_SOURS")
	private String pageSours;
	/**
	 * @mbggenerated 图片电话地址
	 */
	@Field(value = "TEL_SOURCE")
	private String telSource;
	/**
	 * @mbggenerated 参照sale_in的该字段
	 */
	@Field(value = "STATUS_FLAG")
	private Integer statusFlag;
	/**
	 * @mbggenerated 性别限制
	 */
	@Field(value = "LEASE_SEX")
	private String leaseSex;
	/**
	 * @mbggenerated 地图坐标X
	 */
	@Field(value = "POSITION_X")
	private String positionX;
	/**
	 * @mbggenerated 地图坐标Y
	 */
	@Field(value = "POSITION_Y")
	private String positionY;
	/**
	 * @mbggenerated 房源图片数
	 */
	@Field(value = "IMG_FLAG")
	private Byte imgFlag;
	/**
	 * @mbggenerated 缩率图路劲
	 */
	@Field(value = "SMALL_PIC")
	private String smallPic;
	/**
	 * @mbggenerated 栋号
	 */
	@Field(value = "ROOF_NUM")
	private String roofNum;
	/**
	 * @mbggenerated 刷新标记
	 */
	@Field(value = "REFRESH_FLAG")
	private Boolean refreshFlag;
	/**
	 * @mbggenerated 扩展标记位
	 */
	@Field(value = "EXT_BIT")
	private Integer extBit;
	/**
	 * @mbggenerated 数据来源
	 */
	@Field(value = "DATA_SOURCE")
	private Integer dataSource;
	/**
	 * @mbggenerated 关联标识
	 */
	@Field(value = "RELATE_ID")
	private Integer relateId;
	/**
	 * @mbggenerated 是否显示业主电话
	 */
	@Field(value = "SHOW_TEL")
	private Byte showTel;
	/**
	 * @mbggenerated 其他平台是否显示
	 */
	@Field(value = "SHOW_OTHER")
	private Byte showOther;
	/**
	 * @mbggenerated 是否进入直供
	 */
	@Field(value = "VIP_FLAG")
	private Byte vipFlag;
	/**
	 * @mbggenerated 是否与soso数据重复
	 */
	@Field(value = "VIP_REPEAT")
	private Byte vipRepeat;
	/**
	 * @mbggenerated 下架时间
	 */
	@Field(value = "VIP_DOWN_TIME")
	private Date vipDownTime;
	/**
	 * @mbggenerated 最后退费时间
	 */
	@Field(value = "VIP_REFUND_TIME")
	private Date vipRefundTime;
	/**
	 * @mbggenerated 楼盘id
	 */
	@Field(value = "BUILD_ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@Field(value = "MASTER_ROOM")
	private Boolean masterRoom;
	/**
	 * @mbggenerated 更新时间
	 */
	@Field(value = "UPDATE_TIME")
	private Date updateTime;
	/**
	 * @mbggenerated 发布时间
	 */
	@Field(value = "PUB_TIME")
	private Date pubTime;
	/**
	 * @mbggenerated
	 */
	@Field(value = "PUSHMSG_LOCKFLAG")
	private Byte pushmsgLockflag;
	/**
	 * @mbggenerated
	 */
	@Field(value = "LAST_PUSHMSG_TIME")
	private Date lastPushmsgTime;
	/**
	 * @mbggenerated 商圈id
	 */
	@Field(value = "SECTION_ID")
	private Integer sectionId;
	/**
	 * @mbggenerated 行政区id
	 */
	@Field(value = "REGION_ID")
	private Integer regionId;
	/**
	 * @mbggenerated
	 */
	@Field(value = "MONGO_DELETE")
	private Byte mongoDelete;
	/**
	 * @mbggenerated 图片下架
	 */
	@Field(value = "IMG_DOWNLOAD")
	private Integer imgDownload;
	/**
	 * @mbggenerated 空或0代表58普通数据，为1则代表是58专属数据
	 */
	@Field(value = "SECRET_PHONE")
	private Integer secretPhone;
	/**
	 * @mbggenerated 经纪人房源标记数量
	 */
	@Field(value = "COMPLAINT_AGENCY")
	private Integer complaintAgency;
	/**
	 * @mbggenerated 假房源标记数量
	 */
	@Field(value = "COMPLAINT_FAKE")
	private Integer complaintFake;
	/**
	 * @mbggenerated 房源已售
	 */
	@Field(value = "COMPLAINT_SOLD")
	private Integer complaintSold;
	/**
	 * @mbggenerated 暂不出售
	 */
	@Field(value = "COMPLAINT_KEEP")
	private Integer complaintKeep;
	/**
	 * @mbggenerated
	 */
	@Field(value = "REPEAT_ID")
	private Integer repeatId;
	/**
	 * @mbggenerated
	 */
	@Field(value = "SITE_FLAG")
	private Integer siteFlag;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Date getInTime() {
		return inTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwner(String owner) {
		this.owner = owner == null ? null : owner.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTelePhone() {
		return telePhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone == null ? null : telePhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSectors() {
		return sectors;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectors(String sectors) {
		this.sectors = sectors == null ? null : sectors.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRound() {
		return round;
	}

	/**
	 * @mbggenerated
	 */
	public void setRound(String round) {
		this.round = round == null ? null : round.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @mbggenerated
	 */
	public void setSection(String section) {
		this.section = section == null ? null : section.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRoom() {
		return room;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoom(Integer room) {
		this.room = room;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHall() {
		return hall;
	}

	/**
	 * @mbggenerated
	 */
	public void setHall(Integer hall) {
		this.hall = hall;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWei() {
		return wei;
	}

	/**
	 * @mbggenerated
	 */
	public void setWei(Integer wei) {
		this.wei = wei;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getYang() {
		return yang;
	}

	/**
	 * @mbggenerated
	 */
	public void setYang(Integer yang) {
		this.yang = yang;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType == null ? null : houseType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFloor() {
		return floor;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFloors() {
		return floors;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	/**
	 * @mbggenerated
	 */
	public String getFitment() {
		return fitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setFitment(String fitment) {
		this.fitment = fitment == null ? null : fitment.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDirect() {
		return direct;
	}

	/**
	 * @mbggenerated
	 */
	public void setDirect(String direct) {
		this.direct = direct == null ? null : direct.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseYear() {
		return houseYear;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseYear(String houseYear) {
		this.houseYear = houseYear == null ? null : houseYear.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseStruct() {
		return houseStruct;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseStruct(String houseStruct) {
		this.houseStruct = houseStruct == null ? null : houseStruct.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseage(String useage) {
		this.useage = useage == null ? null : useage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRight() {
		return houseRight;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRight(String houseRight) {
		this.houseRight = houseRight == null ? null : houseRight.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseAccount() {
		return houseAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseAccount(String houseAccount) {
		this.houseAccount = houseAccount == null ? null : houseAccount.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getArea() {
		return area;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea(Double area) {
		this.area = area;
	}

	/**
	 * @mbggenerated
	 */
	public Double getArea2() {
		return area2;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea2(Double area2) {
		this.area2 = area2;
	}

	/**
	 * @mbggenerated
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public String getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit == null ? null : priceUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getLeaseDeposit() {
		return leaseDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseDeposit(Double leaseDeposit) {
		this.leaseDeposit = leaseDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime == null ? null : leaveTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseLimit() {
		return leaseLimit;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLimit(String leaseLimit) {
		this.leaseLimit = leaseLimit == null ? null : leaseLimit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseSet() {
		return houseSet;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseSet(String houseSet) {
		this.houseSet = houseSet == null ? null : houseSet.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCharact() {
		return charact;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharact(String charact) {
		this.charact = charact == null ? null : charact.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @mbggenerated
	 */
	public String getPrimitiveId() {
		return primitiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrimitiveId(String primitiveId) {
		this.primitiveId = primitiveId == null ? null : primitiveId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName == null ? null : siteName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTelCount() {
		return telCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setTelCount(Integer telCount) {
		this.telCount = telCount;
	}

	/**
	 * @mbggenerated
	 */
	public String getPageSours() {
		return pageSours;
	}

	/**
	 * @mbggenerated
	 */
	public void setPageSours(String pageSours) {
		this.pageSours = pageSours == null ? null : pageSours.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTelSource() {
		return telSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setTelSource(String telSource) {
		this.telSource = telSource == null ? null : telSource.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getStatusFlag() {
		return statusFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseSex() {
		return leaseSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseSex(String leaseSex) {
		this.leaseSex = leaseSex == null ? null : leaseSex.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * @mbggenerated
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX == null ? null : positionX.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPositionY() {
		return positionY;
	}

	/**
	 * @mbggenerated
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY == null ? null : positionY.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getImgFlag() {
		return imgFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setImgFlag(Byte imgFlag) {
		this.imgFlag = imgFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getSmallPic() {
		return smallPic;
	}

	/**
	 * @mbggenerated
	 */
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic == null ? null : smallPic.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRoofNum() {
		return roofNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoofNum(String roofNum) {
		this.roofNum = roofNum == null ? null : roofNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getRefreshFlag() {
		return refreshFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRefreshFlag(Boolean refreshFlag) {
		this.refreshFlag = refreshFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getExtBit() {
		return extBit;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtBit(Integer extBit) {
		this.extBit = extBit;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDataSource() {
		return dataSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRelateId() {
		return relateId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getShowTel() {
		return showTel;
	}

	/**
	 * @mbggenerated
	 */
	public void setShowTel(Byte showTel) {
		this.showTel = showTel;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getShowOther() {
		return showOther;
	}

	/**
	 * @mbggenerated
	 */
	public void setShowOther(Byte showOther) {
		this.showOther = showOther;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getVipFlag() {
		return vipFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getVipRepeat() {
		return vipRepeat;
	}

	/**
	 * @mbggenerated
	 */
	public void setVipRepeat(Byte vipRepeat) {
		this.vipRepeat = vipRepeat;
	}

	/**
	 * @mbggenerated
	 */
	public Date getVipDownTime() {
		return vipDownTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setVipDownTime(Date vipDownTime) {
		this.vipDownTime = vipDownTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getVipRefundTime() {
		return vipRefundTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setVipRefundTime(Date vipRefundTime) {
		this.vipRefundTime = vipRefundTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getMasterRoom() {
		return masterRoom;
	}

	/**
	 * @mbggenerated
	 */
	public void setMasterRoom(Boolean masterRoom) {
		this.masterRoom = masterRoom;
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
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPushmsgLockflag() {
		return pushmsgLockflag;
	}

	/**
	 * @mbggenerated
	 */
	public void setPushmsgLockflag(Byte pushmsgLockflag) {
		this.pushmsgLockflag = pushmsgLockflag;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLastPushmsgTime() {
		return lastPushmsgTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLastPushmsgTime(Date lastPushmsgTime) {
		this.lastPushmsgTime = lastPushmsgTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegionId() {
		return regionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMongoDelete() {
		return mongoDelete;
	}

	/**
	 * @mbggenerated
	 */
	public void setMongoDelete(Byte mongoDelete) {
		this.mongoDelete = mongoDelete;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getImgDownload() {
		return imgDownload;
	}

	/**
	 * @mbggenerated
	 */
	public void setImgDownload(Integer imgDownload) {
		this.imgDownload = imgDownload;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecretPhone() {
		return secretPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecretPhone(Integer secretPhone) {
		this.secretPhone = secretPhone;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getComplaintAgency() {
		return complaintAgency;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintAgency(Integer complaintAgency) {
		this.complaintAgency = complaintAgency;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getComplaintFake() {
		return complaintFake;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintFake(Integer complaintFake) {
		this.complaintFake = complaintFake;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getComplaintSold() {
		return complaintSold;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintSold(Integer complaintSold) {
		this.complaintSold = complaintSold;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getComplaintKeep() {
		return complaintKeep;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintKeep(Integer complaintKeep) {
		this.complaintKeep = complaintKeep;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRepeatId() {
		return repeatId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSiteFlag() {
		return siteFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSiteFlag(Integer siteFlag) {
		this.siteFlag = siteFlag;
	}
}