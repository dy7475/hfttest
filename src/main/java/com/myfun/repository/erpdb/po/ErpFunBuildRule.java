package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class ErpFunBuildRule extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键") private Integer entityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店ID") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="栋") private String roof;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="单元") private String unit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼") private String num;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="号") private String house;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="单元栋号详细地址") private String address;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="第几楼") private String floor;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="总楼数") private String floors;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="行政区域ID") private Integer regionId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="行政区域名称") private String regionName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="片区ID") private Integer sectionId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="片区名") private String sectionName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="区域iD") private Integer sectorId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="街道名称") private String sectorName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘的地址") private String houseRound;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="环域DD") private Byte roundDd;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘名称") private String buildName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘检索码") private String buildCode;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘ID") private Integer buildId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="用途") private Byte useage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业主") private String owner;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="身份证") private String idCard;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="权属") private Byte houseRight;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋类型") private Byte houseType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋结构") private Byte houseStruct;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋年代") private Integer houseYear;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋朝向") private Byte houseDirect;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否临街") private Byte houseStreet;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="装修") private Byte houseFitment;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="梯") private Byte houseLadder;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="几户") private Byte houseDoors;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="现状") private String houseStituat;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="腾房日") private String leaveTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="出证日期") private String certTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋面积") private BigDecimal houseArea;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋总价") private BigDecimal saleTotalPrice;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋底价") private BigDecimal saleLowestPrice;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="单价") private BigDecimal saleUnitPrice;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="结算") private String saleAccount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="租金") private BigDecimal leaseTotalPrice;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="租金单位") private Byte leasePriceUnit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="租金底价") private Integer leaseLowestPrice;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="付款方式") private Byte leaseAccount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="押金") private Integer leaseDeposit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="租房期限") private Byte leaseLimite;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="几室") private Byte room;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="几厅") private Byte hall;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="几卫") private Byte wei;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="几阳台") private Byte yang;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="联系电话") private String cellPhone;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="地址唯一标记") private String sameFlag;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="转租房源ID") private Integer leaseId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="转售房源ID") private Integer saleId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private String creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="共有人姓名") private String shareUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="共有人电话") private String shareCellPhone;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人ID") private Integer userId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="查看时间") private Date checkTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="0 已查看  1 已转入") private Byte status;
	 /**
	 * @mbggenerated
	 */@ApiModelProperty(value="电话类型  0 座机  1 手机  2境外") private Byte phoneType;
	 /**
	 * @mbggenerated
	 */@ApiModelProperty(value="共有人电话类型  0 座机  1 手机 2境外") private Byte sharePhoneType;
	 /**
	  * @mbggenerated
	 */@ApiModelProperty(value="电话类型2 0 座机  1 手机 2境外") private Byte phoneTypeTwo;
 
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getEntityId() {
		return entityId;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 栋
	 */
	public String getRoof() {
		return roof;
	}

	/**
	 * @mbggenerated 栋
	 */
	public void setRoof(String roof) {
		this.roof = roof == null ? null : roof.trim();
	}

	/**
	 * @mbggenerated 单元
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @mbggenerated 单元
	 */
	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	/**
	 * @mbggenerated 楼
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @mbggenerated 楼
	 */
	public void setNum(String num) {
		this.num = num == null ? null : num.trim();
	}

	/**
	 * @mbggenerated 号
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @mbggenerated 号
	 */
	public void setHouse(String house) {
		this.house = house == null ? null : house.trim();
	}

	/**
	 * @mbggenerated 单元栋号详细地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @mbggenerated 单元栋号详细地址
	 */
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/**
	 * @mbggenerated 第几楼
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @mbggenerated 第几楼
	 */
	public void setFloor(String floor) {
		this.floor = floor == null ? null : floor.trim();
	}

	/**
	 * @mbggenerated 总楼数
	 */
	public String getFloors() {
		return floors;
	}

	/**
	 * @mbggenerated 总楼数
	 */
	public void setFloors(String floors) {
		this.floors = floors == null ? null : floors.trim();
	}

	/**
	 * @mbggenerated 行政区域ID
	 */
	public Integer getRegionId() {
		return regionId;
	}

	/**
	 * @mbggenerated 行政区域ID
	 */
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	/**
	 * @mbggenerated 行政区域名称
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @mbggenerated 行政区域名称
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName == null ? null : regionName.trim();
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @mbggenerated 片区名
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @mbggenerated 片区名
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName == null ? null : sectionName.trim();
	}

	/**
	 * @mbggenerated 区域iD
	 */
	public Integer getSectorId() {
		return sectorId;
	}

	/**
	 * @mbggenerated 区域iD
	 */
	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	/**
	 * @mbggenerated 街道名称
	 */
	public String getSectorName() {
		return sectorName;
	}

	/**
	 * @mbggenerated 街道名称
	 */
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName == null ? null : sectorName.trim();
	}

	/**
	 * @mbggenerated 楼盘的地址
	 */
	public String getHouseRound() {
		return houseRound;
	}

	/**
	 * @mbggenerated 楼盘的地址
	 */
	public void setHouseRound(String houseRound) {
		this.houseRound = houseRound == null ? null : houseRound.trim();
	}

	/**
	 * @mbggenerated 环域DD
	 */
	public Byte getRoundDd() {
		return roundDd;
	}

	/**
	 * @mbggenerated 环域DD
	 */
	public void setRoundDd(Byte roundDd) {
		this.roundDd = roundDd;
	}

	/**
	 * @mbggenerated 楼盘名称
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated 楼盘名称
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated 楼盘检索码
	 */
	public String getBuildCode() {
		return buildCode;
	}

	/**
	 * @mbggenerated 楼盘检索码
	 */
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode == null ? null : buildCode.trim();
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 用途
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated 用途
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated 业主
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @mbggenerated 业主
	 */
	public void setOwner(String owner) {
		this.owner = owner == null ? null : owner.trim();
	}

	/**
	 * @mbggenerated 身份证
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @mbggenerated 身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	/**
	 * @mbggenerated 权属
	 */
	public Byte getHouseRight() {
		return houseRight;
	}

	/**
	 * @mbggenerated 权属
	 */
	public void setHouseRight(Byte houseRight) {
		this.houseRight = houseRight;
	}

	/**
	 * @mbggenerated 房屋类型
	 */
	public Byte getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated 房屋类型
	 */
	public void setHouseType(Byte houseType) {
		this.houseType = houseType;
	}

	/**
	 * @mbggenerated 房屋结构
	 */
	public Byte getHouseStruct() {
		return houseStruct;
	}

	/**
	 * @mbggenerated 房屋结构
	 */
	public void setHouseStruct(Byte houseStruct) {
		this.houseStruct = houseStruct;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public Integer getHouseYear() {
		return houseYear;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public void setHouseYear(Integer houseYear) {
		this.houseYear = houseYear;
	}

	/**
	 * @mbggenerated 房屋朝向
	 */
	public Byte getHouseDirect() {
		return houseDirect;
	}

	/**
	 * @mbggenerated 房屋朝向
	 */
	public void setHouseDirect(Byte houseDirect) {
		this.houseDirect = houseDirect;
	}

	/**
	 * @mbggenerated 是否临街
	 */
	public Byte getHouseStreet() {
		return houseStreet;
	}

	/**
	 * @mbggenerated 是否临街
	 */
	public void setHouseStreet(Byte houseStreet) {
		this.houseStreet = houseStreet;
	}

	/**
	 * @mbggenerated 装修
	 */
	public Byte getHouseFitment() {
		return houseFitment;
	}

	/**
	 * @mbggenerated 装修
	 */
	public void setHouseFitment(Byte houseFitment) {
		this.houseFitment = houseFitment;
	}

	/**
	 * @mbggenerated 梯
	 */
	public Byte getHouseLadder() {
		return houseLadder;
	}

	/**
	 * @mbggenerated 梯
	 */
	public void setHouseLadder(Byte houseLadder) {
		this.houseLadder = houseLadder;
	}

	/**
	 * @mbggenerated 几户
	 */
	public Byte getHouseDoors() {
		return houseDoors;
	}

	/**
	 * @mbggenerated 几户
	 */
	public void setHouseDoors(Byte houseDoors) {
		this.houseDoors = houseDoors;
	}

	/**
	 * @mbggenerated 现状
	 */
	public String getHouseStituat() {
		return houseStituat;
	}

	/**
	 * @mbggenerated 现状
	 */
	public void setHouseStituat(String houseStituat) {
		this.houseStituat = houseStituat == null ? null : houseStituat.trim();
	}

	/**
	 * @mbggenerated 腾房日
	 */
	public String getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @mbggenerated 腾房日
	 */
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime == null ? null : leaveTime.trim();
	}

	/**
	 * @mbggenerated 出证日期
	 */
	public String getCertTime() {
		return certTime;
	}

	/**
	 * @mbggenerated 出证日期
	 */
	public void setCertTime(String certTime) {
		this.certTime = certTime == null ? null : certTime.trim();
	}

	/**
	 * @mbggenerated 房屋面积
	 */
	public BigDecimal getHouseArea() {
		return houseArea;
	}

	/**
	 * @mbggenerated 房屋面积
	 */
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	/**
	 * @mbggenerated 房屋总价
	 */
	public BigDecimal getSaleTotalPrice() {
		return saleTotalPrice;
	}

	/**
	 * @mbggenerated 房屋总价
	 */
	public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
		this.saleTotalPrice = saleTotalPrice;
	}

	/**
	 * @mbggenerated 房屋底价
	 */
	public BigDecimal getSaleLowestPrice() {
		return saleLowestPrice;
	}

	/**
	 * @mbggenerated 房屋底价
	 */
	public void setSaleLowestPrice(BigDecimal saleLowestPrice) {
		this.saleLowestPrice = saleLowestPrice;
	}

	/**
	 * @mbggenerated 单价
	 */
	public BigDecimal getSaleUnitPrice() {
		return saleUnitPrice;
	}

	/**
	 * @mbggenerated 单价
	 */
	public void setSaleUnitPrice(BigDecimal saleUnitPrice) {
		this.saleUnitPrice = saleUnitPrice;
	}

	/**
	 * @mbggenerated 结算
	 */
	public String getSaleAccount() {
		return saleAccount;
	}

	/**
	 * @mbggenerated 结算
	 */
	public void setSaleAccount(String saleAccount) {
		this.saleAccount = saleAccount == null ? null : saleAccount.trim();
	}

	/**
	 * @mbggenerated 租金
	 */
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金
	 */
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金单位
	 */
	public Byte getLeasePriceUnit() {
		return leasePriceUnit;
	}

	/**
	 * @mbggenerated 租金单位
	 */
	public void setLeasePriceUnit(Byte leasePriceUnit) {
		this.leasePriceUnit = leasePriceUnit;
	}

	/**
	 * @mbggenerated 租金底价
	 */
	public Integer getLeaseLowestPrice() {
		return leaseLowestPrice;
	}

	/**
	 * @mbggenerated 租金底价
	 */
	public void setLeaseLowestPrice(Integer leaseLowestPrice) {
		this.leaseLowestPrice = leaseLowestPrice;
	}

	/**
	 * @mbggenerated 付款方式
	 */
	public Byte getLeaseAccount() {
		return leaseAccount;
	}

	/**
	 * @mbggenerated 付款方式
	 */
	public void setLeaseAccount(Byte leaseAccount) {
		this.leaseAccount = leaseAccount;
	}

	/**
	 * @mbggenerated 押金
	 */
	public Integer getLeaseDeposit() {
		return leaseDeposit;
	}

	/**
	 * @mbggenerated 押金
	 */
	public void setLeaseDeposit(Integer leaseDeposit) {
		this.leaseDeposit = leaseDeposit;
	}

	/**
	 * @mbggenerated 租房期限
	 */
	public Byte getLeaseLimite() {
		return leaseLimite;
	}

	/**
	 * @mbggenerated 租房期限
	 */
	public void setLeaseLimite(Byte leaseLimite) {
		this.leaseLimite = leaseLimite;
	}

	/**
	 * @mbggenerated 几室
	 */
	public Byte getRoom() {
		return room;
	}

	/**
	 * @mbggenerated 几室
	 */
	public void setRoom(Byte room) {
		this.room = room;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public Byte getHall() {
		return hall;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public void setHall(Byte hall) {
		this.hall = hall;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public Byte getWei() {
		return wei;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public void setWei(Byte wei) {
		this.wei = wei;
	}

	/**
	 * @mbggenerated 几阳台
	 */
	public Byte getYang() {
		return yang;
	}

	/**
	 * @mbggenerated 几阳台
	 */
	public void setYang(Byte yang) {
		this.yang = yang;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone == null ? null : cellPhone.trim();
	}

	/**
	 * @mbggenerated 地址唯一标记
	 */
	public String getSameFlag() {
		return sameFlag;
	}

	/**
	 * @mbggenerated 地址唯一标记
	 */
	public void setSameFlag(String sameFlag) {
		this.sameFlag = sameFlag == null ? null : sameFlag.trim();
	}

	/**
	 * @mbggenerated 转租房源ID
	 */
	public Integer getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated 转租房源ID
	 */
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @mbggenerated 转售房源ID
	 */
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @mbggenerated 转售房源ID
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime == null ? null : creationTime.trim();
	}

	/**
	 * @mbggenerated 共有人姓名
	 */
	public String getShareUser() {
		return shareUser;
	}

	/**
	 * @mbggenerated 共有人姓名
	 */
	public void setShareUser(String shareUser) {
		this.shareUser = shareUser == null ? null : shareUser.trim();
	}

	/**
	 * @mbggenerated 共有人电话
	 */
	public String getShareCellPhone() {
		return shareCellPhone;
	}

	/**
	 * @mbggenerated 共有人电话
	 */
	public void setShareCellPhone(String shareCellPhone) {
		this.shareCellPhone = shareCellPhone == null ? null : shareCellPhone.trim();
	}

	/**
	 * @mbggenerated 创建人ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 创建人ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 查看时间
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @mbggenerated 查看时间
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @mbggenerated 0 已查看  1 已转入
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated 0 已查看  1 已转入
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildRule() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildRule(Integer shardCityId, Integer entityId) {
		super(shardCityId);
		this.entityId = entityId;
	}

	public Byte getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Byte phoneType) {
		this.phoneType = phoneType;
	}

	public Byte getSharePhoneType() {
		return sharePhoneType;
	}

	public void setSharePhoneType(Byte sharePhoneType) {
		this.sharePhoneType = sharePhoneType;
	}

	public Byte getPhoneTypeTwo() {
		return phoneTypeTwo;
	}

	public void setPhoneTypeTwo(Byte phoneTypeTwo) {
		this.phoneTypeTwo = phoneTypeTwo;
	}
	
	
}