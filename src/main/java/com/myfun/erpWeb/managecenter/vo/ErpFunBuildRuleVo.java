package com.myfun.erpWeb.managecenter.vo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "获取楼盘的栋单元楼列表VO")
public class ErpFunBuildRuleVo implements Serializable {
    /**
     * @mbggenerated 主键
     */
    private Integer entityId;
    /**
     * @mbggenerated 公司ID
     */
    private Integer compId;
    /**
     * @mbggenerated 门店ID
     */
    private Integer deptId;
    /**
     * @mbggenerated 栋
     */
    private String roof;
    /**
     * @mbggenerated 单元
     */
    private String unit;
    /**
     * @mbggenerated 楼
     */
    private String num;
    /**
     * @mbggenerated 号
     */
    private String house;
    /**
     * @mbggenerated 单元栋号详细地址
     */
    private String address;
    /**
     * @mbggenerated 第几楼
     */
    private String floor;
    /**
     * @mbggenerated 总楼数
     */
    private String floors;
    /**
     * @mbggenerated 行政区域ID
     */
    private Integer regionId;
    /**
     * @mbggenerated 行政区域名称
     */
    private String regionName;
    /**
     * @mbggenerated 片区ID
     */
    private Integer sectionId;
    /**
     * @mbggenerated 片区名
     */
    private String sectionName;
    /**
     * @mbggenerated 区域iD
     */
    private Integer sectorId;
    /**
     * @mbggenerated 街道名称
     */
    private String sectorName;
    /**
     * @mbggenerated 楼盘的地址
     */
    private String houseRound;
    /**
     * @mbggenerated 环域DD
     */
    private Byte roundDd;
    /**
     * @mbggenerated 楼盘名称
     */
    private String buildName;
    /**
     * @mbggenerated 楼盘检索码
     */
    private String buildCode;
    /**
     * @mbggenerated 楼盘ID
     */
    private Integer buildId;
    /**
     * @mbggenerated 用途
     */
    private Byte useage;
    /**
     * @mbggenerated 业主
     */
    private String owner;
    /**
     * @mbggenerated 身份证
     */
    private String idCard;
    /**
     * @mbggenerated 权属
     */
    private Byte houseRight;
    /**
     * @mbggenerated 房屋类型
     */
    private Byte houseType;
    /**
     * @mbggenerated 房屋结构
     */
    private Byte houseStruct;
    /**
     * @mbggenerated 房屋年代
     */
    private Integer houseYear;
    /**
     * @mbggenerated 房屋朝向
     */
    private Byte houseDirect;
    /**
     * @mbggenerated 是否临街
     */
    private Byte houseStreet;
    /**
     * @mbggenerated 装修
     */
    private Byte houseFitment;
    /**
     * @mbggenerated 梯
     */
    private Byte houseLadder;
    /**
     * @mbggenerated 几户
     */
    private Byte houseDoors;
    /**
     * @mbggenerated 现状
     */
    private String houseStituat;
    /**
     * @mbggenerated 腾房日
     */
    private String leaveTime;
    /**
     * @mbggenerated 出证日期
     */
    private String certTime;
    /**
     * @mbggenerated 房屋面积
     */
    private BigDecimal houseArea;
    /**
     * @mbggenerated 房屋总价
     */
    private BigDecimal saleTotalPrice;
    /**
     * @mbggenerated 房屋底价
     */
    private BigDecimal saleLowestPrice;
    /**
     * @mbggenerated 单价
     */
    private BigDecimal saleUnitPrice;
    /**
     * @mbggenerated 结算
     */
    private String saleAccount;
    /**
     * @mbggenerated 租金
     */
    private BigDecimal leaseTotalPrice;
    /**
     * @mbggenerated 租金单位
     */
    private Byte leasePriceUnit;
    /**
     * @mbggenerated 租金底价
     */
    private Integer leaseLowestPrice;
    /**
     * @mbggenerated 付款方式
     */
    private Byte leaseAccount;
    /**
     * @mbggenerated 押金
     */
    private Integer leaseDeposit;
    /**
     * @mbggenerated 租房期限
     */
    private Byte leaseLimite;
    /**
     * @mbggenerated 几室
     */
    private Byte room;
    /**
     * @mbggenerated 几厅
     */
    private Byte hall;
    /**
     * @mbggenerated 几卫
     */
    private Byte wei;
    /**
     * @mbggenerated 几阳台
     */
    private Byte yang;
    /**
     * @mbggenerated 联系电话
     */
    private String cellPhone;
    /**
     * @mbggenerated 地址唯一标记
     */
    private String sameFlag;
    /**
     * @mbggenerated 转租房源ID
     */
    private Integer leaseId;
    /**
     * @mbggenerated 转售房源ID
     */
    private Integer saleId;
    /**
     * @mbggenerated 创建时间
     */
    private String creationTime;
    /**
     * @mbggenerated 共有人姓名
     */
    private String shareUser;
    /**
     * @mbggenerated 共有人电话
     */
    private String shareCellPhone;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getHouseRound() {
        return houseRound;
    }

    public void setHouseRound(String houseRound) {
        this.houseRound = houseRound;
    }

    public Byte getRoundDd() {
        return roundDd;
    }

    public void setRoundDd(Byte roundDd) {
        this.roundDd = roundDd;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Byte getUseage() {
        return useage;
    }

    public void setUseage(Byte useage) {
        this.useage = useage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Byte getHouseRight() {
        return houseRight;
    }

    public void setHouseRight(Byte houseRight) {
        this.houseRight = houseRight;
    }

    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    public Byte getHouseStruct() {
        return houseStruct;
    }

    public void setHouseStruct(Byte houseStruct) {
        this.houseStruct = houseStruct;
    }

    public Integer getHouseYear() {
        return houseYear;
    }

    public void setHouseYear(Integer houseYear) {
        this.houseYear = houseYear;
    }

    public Byte getHouseDirect() {
        return houseDirect;
    }

    public void setHouseDirect(Byte houseDirect) {
        this.houseDirect = houseDirect;
    }

    public Byte getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(Byte houseStreet) {
        this.houseStreet = houseStreet;
    }

    public Byte getHouseFitment() {
        return houseFitment;
    }

    public void setHouseFitment(Byte houseFitment) {
        this.houseFitment = houseFitment;
    }

    public Byte getHouseLadder() {
        return houseLadder;
    }

    public void setHouseLadder(Byte houseLadder) {
        this.houseLadder = houseLadder;
    }

    public Byte getHouseDoors() {
        return houseDoors;
    }

    public void setHouseDoors(Byte houseDoors) {
        this.houseDoors = houseDoors;
    }

    public String getHouseStituat() {
        return houseStituat;
    }

    public void setHouseStituat(String houseStituat) {
        this.houseStituat = houseStituat;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getCertTime() {
        return certTime;
    }

    public void setCertTime(String certTime) {
        this.certTime = certTime;
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public BigDecimal getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public BigDecimal getSaleLowestPrice() {
        return saleLowestPrice;
    }

    public void setSaleLowestPrice(BigDecimal saleLowestPrice) {
        this.saleLowestPrice = saleLowestPrice;
    }

    public BigDecimal getSaleUnitPrice() {
        return saleUnitPrice;
    }

    public void setSaleUnitPrice(BigDecimal saleUnitPrice) {
        this.saleUnitPrice = saleUnitPrice;
    }

    public String getSaleAccount() {
        return saleAccount;
    }

    public void setSaleAccount(String saleAccount) {
        this.saleAccount = saleAccount;
    }

    public BigDecimal getLeaseTotalPrice() {
        return leaseTotalPrice;
    }

    public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
        this.leaseTotalPrice = leaseTotalPrice;
    }

    public Byte getLeasePriceUnit() {
        return leasePriceUnit;
    }

    public void setLeasePriceUnit(Byte leasePriceUnit) {
        this.leasePriceUnit = leasePriceUnit;
    }

    public Integer getLeaseLowestPrice() {
        return leaseLowestPrice;
    }

    public void setLeaseLowestPrice(Integer leaseLowestPrice) {
        this.leaseLowestPrice = leaseLowestPrice;
    }

    public Byte getLeaseAccount() {
        return leaseAccount;
    }

    public void setLeaseAccount(Byte leaseAccount) {
        this.leaseAccount = leaseAccount;
    }

    public Integer getLeaseDeposit() {
        return leaseDeposit;
    }

    public void setLeaseDeposit(Integer leaseDeposit) {
        this.leaseDeposit = leaseDeposit;
    }

    public Byte getLeaseLimite() {
        return leaseLimite;
    }

    public void setLeaseLimite(Byte leaseLimite) {
        this.leaseLimite = leaseLimite;
    }

    public Byte getRoom() {
        return room;
    }

    public void setRoom(Byte room) {
        this.room = room;
    }

    public Byte getHall() {
        return hall;
    }

    public void setHall(Byte hall) {
        this.hall = hall;
    }

    public Byte getWei() {
        return wei;
    }

    public void setWei(Byte wei) {
        this.wei = wei;
    }

    public Byte getYang() {
        return yang;
    }

    public void setYang(Byte yang) {
        this.yang = yang;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getSameFlag() {
        return sameFlag;
    }

    public void setSameFlag(String sameFlag) {
        this.sameFlag = sameFlag;
    }

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public String getShareCellPhone() {
        return shareCellPhone;
    }

    public void setShareCellPhone(String shareCellPhone) {
        this.shareCellPhone = shareCellPhone;
    }
}
