package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ErpBuildingSetRoom extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "后端计算出的房间ID,例如1-1, 1-2")
	private String sysRoomId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户填的的房间ID")
	private String roomId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几室")
	private Byte houseRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几厅")
	private Byte houseHall;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几卫")
	private Byte houseWei;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "阳台")
	private Byte houseYang;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "朝向，DD：HOUSE_DIRECT")
	private Byte houseDirect;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑面积")
	private BigDecimal houseArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "套内面积")
	private BigDecimal houseInnerarea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座")
	private String buildRoof;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元")
	private String buildUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是规则以外的房间，1=是")
	private Byte beyondRule;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除，1=已删除")
	private Byte delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房间所在楼层")
	private String roomFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合并房间号（一个单元从1~X）")
	private Integer mergeRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主")
	private String houseOwner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主电话")
	private String cellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主性别")
	private Byte ownerSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人")
	private String jointUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人电话")
	private String jointCellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人性别")
	private Byte jointUserSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋ID")
	private Integer buildingSetRoofId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元ID")
	private Integer buildingSetUnitId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层ID")
	private Integer buildingSetFloorId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源栋座号的MD5码 栋名，单元名，楼层名   md5")
	private String addrMd5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否出售")
	private Byte saleFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否出租")
	private Byte leaseFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "售价")
	private BigDecimal salePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金")
	private BigDecimal leasePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "金额单位")
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否邻街，1=是0=否")
	private Byte nearStreet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "层高")
	private BigDecimal floorHeight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "结构")
	private Integer houseStructure;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "卫生间类型")
	private Integer toiletType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "厨房")
	private Integer kitchen;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	 * @mbggenerated 后端计算出的房间ID,例如1-1, 1-2
	 */
	public String getSysRoomId() {
		return sysRoomId;
	}

	/**
	 * @mbggenerated 后端计算出的房间ID,例如1-1, 1-2
	 */
	public void setSysRoomId(String sysRoomId) {
		this.sysRoomId = sysRoomId;
	}

	/**
	 * @mbggenerated 用户填的的房间ID
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * @mbggenerated 用户填的的房间ID
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * @mbggenerated 几室
	 */
	public Byte getHouseRoom() {
		return houseRoom;
	}

	/**
	 * @mbggenerated 几室
	 */
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public Byte getHouseHall() {
		return houseHall;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public Byte getHouseWei() {
		return houseWei;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public void setHouseWei(Byte houseWei) {
		this.houseWei = houseWei;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public Byte getHouseYang() {
		return houseYang;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public void setHouseYang(Byte houseYang) {
		this.houseYang = houseYang;
	}

	/**
	 * @mbggenerated 朝向，DD：HOUSE_DIRECT
	 */
	public Byte getHouseDirect() {
		return houseDirect;
	}

	/**
	 * @mbggenerated 朝向，DD：HOUSE_DIRECT
	 */
	public void setHouseDirect(Byte houseDirect) {
		this.houseDirect = houseDirect;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public BigDecimal getHouseArea() {
		return houseArea;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public BigDecimal getHouseInnerarea() {
		return houseInnerarea;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public void setHouseInnerarea(BigDecimal houseInnerarea) {
		this.houseInnerarea = houseInnerarea;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 栋座
	 */
	public String getBuildRoof() {
		return buildRoof;
	}

	/**
	 * @mbggenerated 栋座
	 */
	public void setBuildRoof(String buildRoof) {
		this.buildRoof = buildRoof;
	}

	/**
	 * @mbggenerated 单元
	 */
	public String getBuildUnit() {
		return buildUnit;
	}

	/**
	 * @mbggenerated 单元
	 */
	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	/**
	 * @mbggenerated 是否是规则以外的房间，1=是
	 */
	public Byte getBeyondRule() {
		return beyondRule;
	}

	/**
	 * @mbggenerated 是否是规则以外的房间，1=是
	 */
	public void setBeyondRule(Byte beyondRule) {
		this.beyondRule = beyondRule;
	}

	/**
	 * @mbggenerated 是否删除，1=已删除
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 是否删除，1=已删除
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated 房间所在楼层
	 */
	public String getRoomFloor() {
		return roomFloor;
	}

	/**
	 * @mbggenerated 房间所在楼层
	 */
	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}

	/**
	 * @mbggenerated 合并房间号（一个单元从1~X）
	 */
	public Integer getMergeRoom() {
		return mergeRoom;
	}

	/**
	 * @mbggenerated 合并房间号（一个单元从1~X）
	 */
	public void setMergeRoom(Integer mergeRoom) {
		this.mergeRoom = mergeRoom;
	}

	/**
	 * @mbggenerated 业主
	 */
	public String getHouseOwner() {
		return houseOwner;
	}

	/**
	 * @mbggenerated 业主
	 */
	public void setHouseOwner(String houseOwner) {
		this.houseOwner = houseOwner;
	}

	/**
	 * @mbggenerated 业主电话
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @mbggenerated 业主电话
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @mbggenerated 业主性别
	 */
	public Byte getOwnerSex() {
		return ownerSex;
	}

	/**
	 * @mbggenerated 业主性别
	 */
	public void setOwnerSex(Byte ownerSex) {
		this.ownerSex = ownerSex;
	}

	/**
	 * @mbggenerated 共有人
	 */
	public String getJointUserName() {
		return jointUserName;
	}

	/**
	 * @mbggenerated 共有人
	 */
	public void setJointUserName(String jointUserName) {
		this.jointUserName = jointUserName;
	}

	/**
	 * @mbggenerated 共有人电话
	 */
	public String getJointCellPhone() {
		return jointCellPhone;
	}

	/**
	 * @mbggenerated 共有人电话
	 */
	public void setJointCellPhone(String jointCellPhone) {
		this.jointCellPhone = jointCellPhone;
	}

	/**
	 * @mbggenerated 共有人性别
	 */
	public Byte getJointUserSex() {
		return jointUserSex;
	}

	/**
	 * @mbggenerated 共有人性别
	 */
	public void setJointUserSex(Byte jointUserSex) {
		this.jointUserSex = jointUserSex;
	}

	/**
	 * @mbggenerated 栋ID
	 */
	public Integer getBuildingSetRoofId() {
		return buildingSetRoofId;
	}

	/**
	 * @mbggenerated 栋ID
	 */
	public void setBuildingSetRoofId(Integer buildingSetRoofId) {
		this.buildingSetRoofId = buildingSetRoofId;
	}

	/**
	 * @mbggenerated 单元ID
	 */
	public Integer getBuildingSetUnitId() {
		return buildingSetUnitId;
	}

	/**
	 * @mbggenerated 单元ID
	 */
	public void setBuildingSetUnitId(Integer buildingSetUnitId) {
		this.buildingSetUnitId = buildingSetUnitId;
	}

	/**
	 * @mbggenerated 楼层ID
	 */
	public Integer getBuildingSetFloorId() {
		return buildingSetFloorId;
	}

	/**
	 * @mbggenerated 楼层ID
	 */
	public void setBuildingSetFloorId(Integer buildingSetFloorId) {
		this.buildingSetFloorId = buildingSetFloorId;
	}

	/**
	 * @mbggenerated 房源栋座号的MD5码 栋名，单元名，楼层名   md5
	 */
	public String getAddrMd5() {
		return addrMd5;
	}

	/**
	 * @mbggenerated 房源栋座号的MD5码 栋名，单元名，楼层名   md5
	 */
	public void setAddrMd5(String addrMd5) {
		this.addrMd5 = addrMd5;
	}

	/**
	 * @mbggenerated 是否出售
	 */
	public Byte getSaleFlag() {
		return saleFlag;
	}

	/**
	 * @mbggenerated 是否出售
	 */
	public void setSaleFlag(Byte saleFlag) {
		this.saleFlag = saleFlag;
	}

	/**
	 * @mbggenerated 是否出租
	 */
	public Byte getLeaseFlag() {
		return leaseFlag;
	}

	/**
	 * @mbggenerated 是否出租
	 */
	public void setLeaseFlag(Byte leaseFlag) {
		this.leaseFlag = leaseFlag;
	}

	/**
	 * @mbggenerated 售价
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	/**
	 * @mbggenerated 售价
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @mbggenerated 租金
	 */
	public BigDecimal getLeasePrice() {
		return leasePrice;
	}

	/**
	 * @mbggenerated 租金
	 */
	public void setLeasePrice(BigDecimal leasePrice) {
		this.leasePrice = leasePrice;
	}

	/**
	 * @mbggenerated 金额单位
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated 金额单位
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public Byte getNearStreet() {
		return nearStreet;
	}

	/**
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public void setNearStreet(Byte nearStreet) {
		this.nearStreet = nearStreet;
	}

	/**
	 * @mbggenerated 层高
	 */
	public BigDecimal getFloorHeight() {
		return floorHeight;
	}

	/**
	 * @mbggenerated 层高
	 */
	public void setFloorHeight(BigDecimal floorHeight) {
		this.floorHeight = floorHeight;
	}

	/**
	 * @mbggenerated 结构
	 */
	public Integer getHouseStructure() {
		return houseStructure;
	}

	/**
	 * @mbggenerated 结构
	 */
	public void setHouseStructure(Integer houseStructure) {
		this.houseStructure = houseStructure;
	}

	/**
	 * @mbggenerated 卫生间类型
	 */
	public Integer getToiletType() {
		return toiletType;
	}

	/**
	 * @mbggenerated 卫生间类型
	 */
	public void setToiletType(Integer toiletType) {
		this.toiletType = toiletType;
	}

	/**
	 * @mbggenerated 厨房
	 */
	public Integer getKitchen() {
		return kitchen;
	}

	/**
	 * @mbggenerated 厨房
	 */
	public void setKitchen(Integer kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetRoom() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetRoom(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}