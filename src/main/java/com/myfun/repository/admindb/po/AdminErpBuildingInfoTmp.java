package com.myfun.repository.admindb.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class AdminErpBuildingInfoTmp implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer sid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案id")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "省id")
	private Integer provinceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市id")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "部门id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘名")
	private String buildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "检索码")
	private String buildCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开发商")
	private String buildDevloper;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘位置")
	private String buildAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区域Id")
	private Integer buildRegion;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID")
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
	private String buildRound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配套情况")
	private String addCase;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权办理")
	private String rightConduct;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑类型")
	private String buildType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑日期")
	private String buildDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "占地面积")
	private String buildArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "项目套数(总户数)")
	private String projectCover;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "容积率")
	private String projectSpace;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "绿化率")
	private String projectGreen;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "车位情况")
	private String carsCase;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公交线路")
	private String busLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物管公司")
	private String propertyComp;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物管电话")
	private String propertycompTele;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收费标准 物业费")
	private String costStandard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘简介")
	private String buildDescript;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片标记，N=图片张数")
	private Byte buildPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "座标X-纬度-lat")
	private String positionX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "座标Y-经度-lng")
	private String postionY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核标志")
	private Byte checkFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "交房日期")
	private String submitDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0 楼盘纠错  1商圈纠错")
	private Byte dataType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "商圈名字")
	private String sectionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "区名")
	private String regionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String sectionMark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋数")
	private Integer roofs;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "停车方式")
	private String parkingMode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "停车费")
	private String parkingRate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "供电方式")
	private String powerSupplyMode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "供水方式")
	private String waterSupplyMode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "供气方式")
	private String airSupplyMode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "供暖方式")
	private String heatingMode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电费")
	private String electricityFees;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "水费")
	private String waterFees;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "天然气费")
	private String naturalGasFees;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "暖气费")
	private String heatingFees;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "入住率")
	private String occupancyRate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑面积")
	private String constractArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "周边学校")
	private String schools;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "周边交通")
	private String traffic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑年代（竣工日期）")
	private String finishDate;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getSid() {
		return sid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 档案id
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 档案id
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 省id
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated 省id
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @mbggenerated 城市id
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市id
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 部门id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 部门id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 楼盘名
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated 楼盘名
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * @mbggenerated 检索码
	 */
	public String getBuildCode() {
		return buildCode;
	}

	/**
	 * @mbggenerated 检索码
	 */
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	/**
	 * @mbggenerated 开发商
	 */
	public String getBuildDevloper() {
		return buildDevloper;
	}

	/**
	 * @mbggenerated 开发商
	 */
	public void setBuildDevloper(String buildDevloper) {
		this.buildDevloper = buildDevloper;
	}

	/**
	 * @mbggenerated 楼盘位置
	 */
	public String getBuildAddr() {
		return buildAddr;
	}

	/**
	 * @mbggenerated 楼盘位置
	 */
	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr;
	}

	/**
	 * @mbggenerated 行政区域Id
	 */
	public Integer getBuildRegion() {
		return buildRegion;
	}

	/**
	 * @mbggenerated 行政区域Id
	 */
	public void setBuildRegion(Integer buildRegion) {
		this.buildRegion = buildRegion;
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
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public String getBuildRound() {
		return buildRound;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public void setBuildRound(String buildRound) {
		this.buildRound = buildRound;
	}

	/**
	 * @mbggenerated 配套情况
	 */
	public String getAddCase() {
		return addCase;
	}

	/**
	 * @mbggenerated 配套情况
	 */
	public void setAddCase(String addCase) {
		this.addCase = addCase;
	}

	/**
	 * @mbggenerated 产权办理
	 */
	public String getRightConduct() {
		return rightConduct;
	}

	/**
	 * @mbggenerated 产权办理
	 */
	public void setRightConduct(String rightConduct) {
		this.rightConduct = rightConduct;
	}

	/**
	 * @mbggenerated 建筑类型
	 */
	public String getBuildType() {
		return buildType;
	}

	/**
	 * @mbggenerated 建筑类型
	 */
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	/**
	 * @mbggenerated 建筑日期
	 */
	public String getBuildDate() {
		return buildDate;
	}

	/**
	 * @mbggenerated 建筑日期
	 */
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	/**
	 * @mbggenerated 占地面积
	 */
	public String getBuildArea() {
		return buildArea;
	}

	/**
	 * @mbggenerated 占地面积
	 */
	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}

	/**
	 * @mbggenerated 项目套数(总户数)
	 */
	public String getProjectCover() {
		return projectCover;
	}

	/**
	 * @mbggenerated 项目套数(总户数)
	 */
	public void setProjectCover(String projectCover) {
		this.projectCover = projectCover;
	}

	/**
	 * @mbggenerated 容积率
	 */
	public String getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @mbggenerated 容积率
	 */
	public void setProjectSpace(String projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * @mbggenerated 绿化率
	 */
	public String getProjectGreen() {
		return projectGreen;
	}

	/**
	 * @mbggenerated 绿化率
	 */
	public void setProjectGreen(String projectGreen) {
		this.projectGreen = projectGreen;
	}

	/**
	 * @mbggenerated 车位情况
	 */
	public String getCarsCase() {
		return carsCase;
	}

	/**
	 * @mbggenerated 车位情况
	 */
	public void setCarsCase(String carsCase) {
		this.carsCase = carsCase;
	}

	/**
	 * @mbggenerated 公交线路
	 */
	public String getBusLine() {
		return busLine;
	}

	/**
	 * @mbggenerated 公交线路
	 */
	public void setBusLine(String busLine) {
		this.busLine = busLine;
	}

	/**
	 * @mbggenerated 物管公司
	 */
	public String getPropertyComp() {
		return propertyComp;
	}

	/**
	 * @mbggenerated 物管公司
	 */
	public void setPropertyComp(String propertyComp) {
		this.propertyComp = propertyComp;
	}

	/**
	 * @mbggenerated 物管电话
	 */
	public String getPropertycompTele() {
		return propertycompTele;
	}

	/**
	 * @mbggenerated 物管电话
	 */
	public void setPropertycompTele(String propertycompTele) {
		this.propertycompTele = propertycompTele;
	}

	/**
	 * @mbggenerated 收费标准 物业费
	 */
	public String getCostStandard() {
		return costStandard;
	}

	/**
	 * @mbggenerated 收费标准 物业费
	 */
	public void setCostStandard(String costStandard) {
		this.costStandard = costStandard;
	}

	/**
	 * @mbggenerated 楼盘简介
	 */
	public String getBuildDescript() {
		return buildDescript;
	}

	/**
	 * @mbggenerated 楼盘简介
	 */
	public void setBuildDescript(String buildDescript) {
		this.buildDescript = buildDescript;
	}

	/**
	 * @mbggenerated 图片标记，N=图片张数
	 */
	public Byte getBuildPhoto() {
		return buildPhoto;
	}

	/**
	 * @mbggenerated 图片标记，N=图片张数
	 */
	public void setBuildPhoto(Byte buildPhoto) {
		this.buildPhoto = buildPhoto;
	}

	/**
	 * @mbggenerated 座标X-纬度-lat
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * @mbggenerated 座标X-纬度-lat
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	/**
	 * @mbggenerated 座标Y-经度-lng
	 */
	public String getPostionY() {
		return postionY;
	}

	/**
	 * @mbggenerated 座标Y-经度-lng
	 */
	public void setPostionY(String postionY) {
		this.postionY = postionY;
	}

	/**
	 * @mbggenerated 审核标志
	 */
	public Byte getCheckFlag() {
		return checkFlag;
	}

	/**
	 * @mbggenerated 审核标志
	 */
	public void setCheckFlag(Byte checkFlag) {
		this.checkFlag = checkFlag;
	}

	/**
	 * @mbggenerated 交房日期
	 */
	public String getSubmitDate() {
		return submitDate;
	}

	/**
	 * @mbggenerated 交房日期
	 */
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	/**
	 * @mbggenerated 0 楼盘纠错  1商圈纠错
	 */
	public Byte getDataType() {
		return dataType;
	}

	/**
	 * @mbggenerated 0 楼盘纠错  1商圈纠错
	 */
	public void setDataType(Byte dataType) {
		this.dataType = dataType;
	}

	/**
	 * @mbggenerated 商圈名字
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @mbggenerated 商圈名字
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @mbggenerated 区名
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @mbggenerated 区名
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @mbggenerated -
	 */
	public String getSectionMark() {
		return sectionMark;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSectionMark(String sectionMark) {
		this.sectionMark = sectionMark;
	}

	/**
	 * @mbggenerated 栋数
	 */
	public Integer getRoofs() {
		return roofs;
	}

	/**
	 * @mbggenerated 栋数
	 */
	public void setRoofs(Integer roofs) {
		this.roofs = roofs;
	}

	/**
	 * @mbggenerated 停车方式
	 */
	public String getParkingMode() {
		return parkingMode;
	}

	/**
	 * @mbggenerated 停车方式
	 */
	public void setParkingMode(String parkingMode) {
		this.parkingMode = parkingMode;
	}

	/**
	 * @mbggenerated 停车费
	 */
	public String getParkingRate() {
		return parkingRate;
	}

	/**
	 * @mbggenerated 停车费
	 */
	public void setParkingRate(String parkingRate) {
		this.parkingRate = parkingRate;
	}

	/**
	 * @mbggenerated 供电方式
	 */
	public String getPowerSupplyMode() {
		return powerSupplyMode;
	}

	/**
	 * @mbggenerated 供电方式
	 */
	public void setPowerSupplyMode(String powerSupplyMode) {
		this.powerSupplyMode = powerSupplyMode;
	}

	/**
	 * @mbggenerated 供水方式
	 */
	public String getWaterSupplyMode() {
		return waterSupplyMode;
	}

	/**
	 * @mbggenerated 供水方式
	 */
	public void setWaterSupplyMode(String waterSupplyMode) {
		this.waterSupplyMode = waterSupplyMode;
	}

	/**
	 * @mbggenerated 供气方式
	 */
	public String getAirSupplyMode() {
		return airSupplyMode;
	}

	/**
	 * @mbggenerated 供气方式
	 */
	public void setAirSupplyMode(String airSupplyMode) {
		this.airSupplyMode = airSupplyMode;
	}

	/**
	 * @mbggenerated 供暖方式
	 */
	public String getHeatingMode() {
		return heatingMode;
	}

	/**
	 * @mbggenerated 供暖方式
	 */
	public void setHeatingMode(String heatingMode) {
		this.heatingMode = heatingMode;
	}

	/**
	 * @mbggenerated 电费
	 */
	public String getElectricityFees() {
		return electricityFees;
	}

	/**
	 * @mbggenerated 电费
	 */
	public void setElectricityFees(String electricityFees) {
		this.electricityFees = electricityFees;
	}

	/**
	 * @mbggenerated 水费
	 */
	public String getWaterFees() {
		return waterFees;
	}

	/**
	 * @mbggenerated 水费
	 */
	public void setWaterFees(String waterFees) {
		this.waterFees = waterFees;
	}

	/**
	 * @mbggenerated 天然气费
	 */
	public String getNaturalGasFees() {
		return naturalGasFees;
	}

	/**
	 * @mbggenerated 天然气费
	 */
	public void setNaturalGasFees(String naturalGasFees) {
		this.naturalGasFees = naturalGasFees;
	}

	/**
	 * @mbggenerated 暖气费
	 */
	public String getHeatingFees() {
		return heatingFees;
	}

	/**
	 * @mbggenerated 暖气费
	 */
	public void setHeatingFees(String heatingFees) {
		this.heatingFees = heatingFees;
	}

	/**
	 * @mbggenerated 入住率
	 */
	public String getOccupancyRate() {
		return occupancyRate;
	}

	/**
	 * @mbggenerated 入住率
	 */
	public void setOccupancyRate(String occupancyRate) {
		this.occupancyRate = occupancyRate;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public String getConstractArea() {
		return constractArea;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public void setConstractArea(String constractArea) {
		this.constractArea = constractArea;
	}

	/**
	 * @mbggenerated 周边学校
	 */
	public String getSchools() {
		return schools;
	}

	/**
	 * @mbggenerated 周边学校
	 */
	public void setSchools(String schools) {
		this.schools = schools;
	}

	/**
	 * @mbggenerated 周边交通
	 */
	public String getTraffic() {
		return traffic;
	}

	/**
	 * @mbggenerated 周边交通
	 */
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	/**
	 * @mbggenerated 建筑年代（竣工日期）
	 */
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * @mbggenerated 建筑年代（竣工日期）
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
}