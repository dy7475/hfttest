package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class InsertComBuildParam implements EncryParamIfc {
    @ApiModelProperty(hidden = true)
    private Integer sid;
    @ApiModelProperty(hidden = true)
    private String createTime;
    @ApiModelProperty(hidden = true)
    private Integer archiveId;
    @ApiModelProperty(hidden = true)
    private Integer provinceId;
    @ApiModelProperty(hidden = true)
    private Short cityId;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private Integer deptId;
    @ApiModelProperty(value = "楼盘id")
    private Integer buildId;
    @ApiModelProperty(value = "楼盘名")
    private String buildName;
    @ApiModelProperty(value = "检索码")
    private String buildCode;
    @ApiModelProperty(value = "开发商")
    private String buildDevloper;
    @ApiModelProperty(value = "楼盘位置")
    private String buildAddr;
    @ApiModelProperty(value = "行政区域Id")
    private Integer buildRegion;
    @ApiModelProperty(value = "片区ID")
    private Integer sectionId;
    @ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
    private Byte buildRound;
    @ApiModelProperty(value = "配套情况")
    private String addCase;
    @ApiModelProperty(value = "产权办理")
    private String rightConduct;
    @ApiModelProperty(value = "建筑类型  | 隔开")
    private String buildType;
    @ApiModelProperty(value = "占地面积")
    private String buildArea;
    @ApiModelProperty(value = "建筑面积")
    private String constractArea;
    @ApiModelProperty(value = "项目套数(总户数)")
    private String projectCover;
    @ApiModelProperty(value = "容积率")
    private String projectSpace;
    @ApiModelProperty(value = "绿化率")
    private String projectGreen;
    @ApiModelProperty(value = "车位情况")
    private String carsCase;
    @ApiModelProperty(value = "公交线路")
    private String busLine;
    @ApiModelProperty(value = "物管公司")
    private String propertyComp;
    @ApiModelProperty(value = "物管电话")
    private String propertycompTele;
    @ApiModelProperty(value = "收费标准 物业费")
    private String costStandard;
    @ApiModelProperty(value = "楼盘简介")
    private String buildDescript;
    @ApiModelProperty(value = "图片标记，N=图片张数")
    private Byte buildPhoto;
    @ApiModelProperty(value = "座标X-纬度-lat")
    private String positionX;
    @ApiModelProperty(value = "座标Y-经度-lng")
    private String postionY;
    @ApiModelProperty(value = "审核标志")
    private Byte checkFlag;
    @ApiModelProperty(value = "0 楼盘纠错  1商圈纠错")
    private Byte dataType;
    @ApiModelProperty(value = "商圈名字")
    private String sectionName;
    @ApiModelProperty(value = "区名")
    private String regionName;
    @ApiModelProperty(value = "null")
    private String sectionMark;
    @ApiModelProperty(value = "栋数")
    private Integer roofs;
    @ApiModelProperty(value = "单元数")
    private Integer units;
    @ApiModelProperty(value = "户数")
    private Integer doors;
    @ApiModelProperty(value = "停车方式")
    private String parkingMode;
    @ApiModelProperty(value = "停车费")
    private String parkingRate;
    @ApiModelProperty(value = "供电方式")
    private String powerSupplyMode;
    @ApiModelProperty(value = "供水方式")
    private String waterSupplyMode;
    @ApiModelProperty(value = "供气方式")
    private String airSupplyMode;
    @ApiModelProperty(value = "供暖方式")
    private String heatingMode;
    @ApiModelProperty(value = "电费")
    private String electricityFees;
    @ApiModelProperty(value = "水费")
    private String waterFees;
    @ApiModelProperty(value = "天然气费")
    private String naturalGasFees;
    @ApiModelProperty(value = "暖气费")
    private String heatingFees;
    @ApiModelProperty(value = "入住率")
    private String occupancyRate;
    @ApiModelProperty("周边交通")
    private String traffic;
    @ApiModelProperty(value = "周边学校")
    private String schools;
    @ApiModelProperty("建筑年代")
    private String finishDate;

    @ApiModelProperty("1=该楼盘已存在")
    private Integer hasBuild;
    @ApiModelProperty(value = "推广名")
    private String promotionName;

    @ApiModelProperty(value = "外墙 DD OUTER_WALL_TYPE")
    private Byte mlOuterWall;

    @ApiModelProperty(value = "结构 DD: HOUSE_STRUCT")
    private Byte mlHouseStructure;

    @ApiModelProperty(value = "学区房（1是/否0）")
    private Byte mlSchooleNearbyHouse;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "室内停车位")
    private String mlIndoorParkingSpace;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "室外停车位")
    private String mlOutdoorParkingSpace;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "室内停车费用")
    private String mlIndoorParkingCharge;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "室外停车费用")
    private String mlOutdoorParkingCharge;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属街道")
    private String mlBelongToStreet;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "产权类型 DD HOUSE_NATURE")
    private String mlPropertyType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "物业类型  DD TENEMENT_TYPE ")
    private Byte mlTenementType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "批地日期")
    private Date mlRatifyLandDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "入伙时间")
    private Date mlJoinDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用年限开始日期")
    private Date mlUseStartDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用年限结束日期")
    private Date mlUserEndDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "车位比")
    private String mlzsParkingRate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "竣工日期 ")
    private Date mlzsCompletionDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "地铁数量")
    private String mlzsSubwabNumber;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临近主干道")
    private String mlzsNearbyMainStreet;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公交条数")
    private String mlzsBusNumber;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临山")
    private String mlzsNearbyMountain;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临海")
    private String mlzsNearbyRiverOrSea;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否临近轨道交通 1，是 0 否")
    private String mlzsRailTraffic;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "三甲医院名称")
    private String mlzsTopThreeHospitalName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "普通医院名称")
    private String mlzsGeneralHospitalName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "社康中心名称")
    private String mlzsSocialHealthCenter;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临近公园")
    private String mlzsNearbyPark;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "康娱机构数量")
    private String mlzsHealthRecreationNumber;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临近都市总终合体")
    private String mlzsNearbyUrbanComplex;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临近区域级终合体")
    private String mlzsNearbyRegionalComplex;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "临近社区总终合体")
    private String mlzsNearbyCommunityComplex;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域排名前5小学")
    private String mlzsTopFiveElementarySchool;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域排名前5中学")
    private String mlzsTopFiveMiddleSchool;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "升级指数赋值")
    private String mlzsUpgradeIndexAssignment;
    @ApiModelProperty(value = "地块编号")
    private String mlLandNumber;
    @ApiModelProperty(value = "美联最高物业费 ")
    private String costStandardA;
    @ApiModelProperty(value = "产权年限")
    private String rightYears;
    @ApiModelProperty(value = "物业类型描述 多个用 | 分隔")
    private String buildUsage;
    @ApiModelProperty(value = "楼盘用途数据字典 多个用 | 线分隔 DD：HOUSE_USEAGE" )
    private String buildingUseage;
    @ApiModelProperty(value = "美联第二个街道")
    private String mlBelongToStreetA;

    @ApiModelProperty(value = "保存的FUN_STREET街道表信息,多个用逗号分隔开")
    private String streetIds;

    public String getStreetIds() {
        return streetIds;
    }

    public void setStreetIds(String streetIds) {
        this.streetIds = streetIds;
    }

    public String getMlBelongToStreetA() {
        return mlBelongToStreetA;
    }

    public void setMlBelongToStreetA(String mlBelongToStreetA) {
        this.mlBelongToStreetA = mlBelongToStreetA;
    }

    public String getBuildingUseage() {
        return buildingUseage;
    }

    public void setBuildingUseage(String buildingUseage) {
        this.buildingUseage = buildingUseage;
    }

    public String getBuildUsage() {
        return buildUsage;
    }

    public void setBuildUsage(String buildUsage) {
        this.buildUsage = buildUsage;
    }

    public String getRightYears() {
        return rightYears;
    }

    public void setRightYears(String rightYears) {
        this.rightYears = rightYears;
    }

    public String getCostStandardA() {
        return costStandardA;
    }

    public void setCostStandardA(String costStandardA) {
        this.costStandardA = costStandardA;
    }

    public String getMlLandNumber() {
        return mlLandNumber;
    }

    public void setMlLandNumber(String mlLandNumber) {
        this.mlLandNumber = mlLandNumber;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Byte getMlOuterWall() {
        return mlOuterWall;
    }

    public void setMlOuterWall(Byte mlOuterWall) {
        this.mlOuterWall = mlOuterWall;
    }

    public Byte getMlHouseStructure() {
        return mlHouseStructure;
    }

    public void setMlHouseStructure(Byte mlHouseStructure) {
        this.mlHouseStructure = mlHouseStructure;
    }

    public Byte getMlSchooleNearbyHouse() {
        return mlSchooleNearbyHouse;
    }

    public void setMlSchooleNearbyHouse(Byte mlSchooleNearbyHouse) {
        this.mlSchooleNearbyHouse = mlSchooleNearbyHouse;
    }







    public String getMlBelongToStreet() {
        return mlBelongToStreet;
    }

    public void setMlBelongToStreet(String mlBelongToStreet) {
        this.mlBelongToStreet = mlBelongToStreet;
    }

    public String getMlPropertyType() {
        return mlPropertyType;
    }

    public void setMlPropertyType(String mlPropertyType) {
        this.mlPropertyType = mlPropertyType;
    }

    public Byte getMlTenementType() {
        return mlTenementType;
    }

    public void setMlTenementType(Byte mlTenementType) {
        this.mlTenementType = mlTenementType;
    }

    public Date getMlRatifyLandDate() {
        return mlRatifyLandDate;
    }

    public void setMlRatifyLandDate(Date mlRatifyLandDate) {
        this.mlRatifyLandDate = mlRatifyLandDate;
    }

    public Date getMlJoinDate() {
        return mlJoinDate;
    }

    public void setMlJoinDate(Date mlJoinDate) {
        this.mlJoinDate = mlJoinDate;
    }

    public Date getMlUseStartDate() {
        return mlUseStartDate;
    }

    public void setMlUseStartDate(Date mlUseStartDate) {
        this.mlUseStartDate = mlUseStartDate;
    }

    public Date getMlUserEndDate() {
        return mlUserEndDate;
    }

    public void setMlUserEndDate(Date mlUserEndDate) {
        this.mlUserEndDate = mlUserEndDate;
    }



    public Date getMlzsCompletionDate() {
        return mlzsCompletionDate;
    }

    public void setMlzsCompletionDate(Date mlzsCompletionDate) {
        this.mlzsCompletionDate = mlzsCompletionDate;
    }



    public String getMlzsNearbyMainStreet() {
        return mlzsNearbyMainStreet;
    }

    public void setMlzsNearbyMainStreet(String mlzsNearbyMainStreet) {
        this.mlzsNearbyMainStreet = mlzsNearbyMainStreet;
    }



    public String getMlzsNearbyMountain() {
        return mlzsNearbyMountain;
    }

    public void setMlzsNearbyMountain(String mlzsNearbyMountain) {
        this.mlzsNearbyMountain = mlzsNearbyMountain;
    }

    public String getMlzsNearbyRiverOrSea() {
        return mlzsNearbyRiverOrSea;
    }

    public void setMlzsNearbyRiverOrSea(String mlzsNearbyRiverOrSea) {
        this.mlzsNearbyRiverOrSea = mlzsNearbyRiverOrSea;
    }

    public String getMlzsRailTraffic() {
        return mlzsRailTraffic;
    }

    public void setMlzsRailTraffic(String mlzsRailTraffic) {
        this.mlzsRailTraffic = mlzsRailTraffic;
    }

    public String getMlzsTopThreeHospitalName() {
        return mlzsTopThreeHospitalName;
    }

    public void setMlzsTopThreeHospitalName(String mlzsTopThreeHospitalName) {
        this.mlzsTopThreeHospitalName = mlzsTopThreeHospitalName;
    }

    public String getMlzsGeneralHospitalName() {
        return mlzsGeneralHospitalName;
    }

    public void setMlzsGeneralHospitalName(String mlzsGeneralHospitalName) {
        this.mlzsGeneralHospitalName = mlzsGeneralHospitalName;
    }

    public String getMlzsSocialHealthCenter() {
        return mlzsSocialHealthCenter;
    }

    public void setMlzsSocialHealthCenter(String mlzsSocialHealthCenter) {
        this.mlzsSocialHealthCenter = mlzsSocialHealthCenter;
    }

    public String getMlzsNearbyPark() {
        return mlzsNearbyPark;
    }

    public void setMlzsNearbyPark(String mlzsNearbyPark) {
        this.mlzsNearbyPark = mlzsNearbyPark;
    }



    public String getMlzsNearbyUrbanComplex() {
        return mlzsNearbyUrbanComplex;
    }

    public void setMlzsNearbyUrbanComplex(String mlzsNearbyUrbanComplex) {
        this.mlzsNearbyUrbanComplex = mlzsNearbyUrbanComplex;
    }

    public String getMlzsNearbyRegionalComplex() {
        return mlzsNearbyRegionalComplex;
    }

    public void setMlzsNearbyRegionalComplex(String mlzsNearbyRegionalComplex) {
        this.mlzsNearbyRegionalComplex = mlzsNearbyRegionalComplex;
    }

    public String getMlzsNearbyCommunityComplex() {
        return mlzsNearbyCommunityComplex;
    }

    public void setMlzsNearbyCommunityComplex(String mlzsNearbyCommunityComplex) {
        this.mlzsNearbyCommunityComplex = mlzsNearbyCommunityComplex;
    }

    public String getMlzsTopFiveElementarySchool() {
        return mlzsTopFiveElementarySchool;
    }

    public void setMlzsTopFiveElementarySchool(String mlzsTopFiveElementarySchool) {
        this.mlzsTopFiveElementarySchool = mlzsTopFiveElementarySchool;
    }

    public String getMlzsTopFiveMiddleSchool() {
        return mlzsTopFiveMiddleSchool;
    }

    public void setMlzsTopFiveMiddleSchool(String mlzsTopFiveMiddleSchool) {
        this.mlzsTopFiveMiddleSchool = mlzsTopFiveMiddleSchool;
    }



    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getHasBuild() {
        return hasBuild;
    }

    public void setHasBuild(Integer hasBuild) {
        this.hasBuild = hasBuild;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
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

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
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

    public String getBuildDevloper() {
        return buildDevloper;
    }

    public void setBuildDevloper(String buildDevloper) {
        this.buildDevloper = buildDevloper;
    }

    public String getBuildAddr() {
        return buildAddr;
    }

    public void setBuildAddr(String buildAddr) {
        this.buildAddr = buildAddr;
    }

    public Integer getBuildRegion() {
        return buildRegion;
    }

    public void setBuildRegion(Integer buildRegion) {
        this.buildRegion = buildRegion;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Byte getBuildRound() {
        return buildRound;
    }

    public void setBuildRound(Byte buildRound) {
        this.buildRound = buildRound;
    }

    public String getAddCase() {
        return addCase;
    }

    public void setAddCase(String addCase) {
        this.addCase = addCase;
    }

    public String getRightConduct() {
        return rightConduct;
    }

    public void setRightConduct(String rightConduct) {
        this.rightConduct = rightConduct;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea;
    }

    public String getConstractArea() {
        return constractArea;
    }

    public void setConstractArea(String constractArea) {
        this.constractArea = constractArea;
    }

    public String getProjectCover() {
        return projectCover;
    }

    public void setProjectCover(String projectCover) {
        this.projectCover = projectCover;
    }

    public String getProjectSpace() {
        return projectSpace;
    }

    public void setProjectSpace(String projectSpace) {
        this.projectSpace = projectSpace;
    }

    public String getProjectGreen() {
        return projectGreen;
    }

    public void setProjectGreen(String projectGreen) {
        this.projectGreen = projectGreen;
    }

    public String getCarsCase() {
        return carsCase;
    }

    public void setCarsCase(String carsCase) {
        this.carsCase = carsCase;
    }

    public String getBusLine() {
        return busLine;
    }

    public void setBusLine(String busLine) {
        this.busLine = busLine;
    }

    public String getPropertyComp() {
        return propertyComp;
    }

    public void setPropertyComp(String propertyComp) {
        this.propertyComp = propertyComp;
    }

    public String getPropertycompTele() {
        return propertycompTele;
    }

    public void setPropertycompTele(String propertycompTele) {
        this.propertycompTele = propertycompTele;
    }

    public String getCostStandard() {
        return costStandard;
    }

    public void setCostStandard(String costStandard) {
        this.costStandard = costStandard;
    }

    public String getBuildDescript() {
        return buildDescript;
    }

    public void setBuildDescript(String buildDescript) {
        this.buildDescript = buildDescript;
    }

    public Byte getBuildPhoto() {
        return buildPhoto;
    }

    public void setBuildPhoto(Byte buildPhoto) {
        this.buildPhoto = buildPhoto;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPostionY() {
        return postionY;
    }

    public void setPostionY(String postionY) {
        this.postionY = postionY;
    }

    public Byte getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Byte checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSectionMark() {
        return sectionMark;
    }

    public void setSectionMark(String sectionMark) {
        this.sectionMark = sectionMark;
    }

    public Integer getRoofs() {
        return roofs;
    }

    public void setRoofs(Integer roofs) {
        this.roofs = roofs;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public String getParkingMode() {
        return parkingMode;
    }

    public void setParkingMode(String parkingMode) {
        this.parkingMode = parkingMode;
    }

    public String getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(String parkingRate) {
        this.parkingRate = parkingRate;
    }

    public String getPowerSupplyMode() {
        return powerSupplyMode;
    }

    public void setPowerSupplyMode(String powerSupplyMode) {
        this.powerSupplyMode = powerSupplyMode;
    }

    public String getWaterSupplyMode() {
        return waterSupplyMode;
    }

    public void setWaterSupplyMode(String waterSupplyMode) {
        this.waterSupplyMode = waterSupplyMode;
    }

    public String getAirSupplyMode() {
        return airSupplyMode;
    }

    public void setAirSupplyMode(String airSupplyMode) {
        this.airSupplyMode = airSupplyMode;
    }

    public String getHeatingMode() {
        return heatingMode;
    }

    public void setHeatingMode(String heatingMode) {
        this.heatingMode = heatingMode;
    }

    public String getElectricityFees() {
        return electricityFees;
    }

    public void setElectricityFees(String electricityFees) {
        this.electricityFees = electricityFees;
    }

    public String getWaterFees() {
        return waterFees;
    }

    public void setWaterFees(String waterFees) {
        this.waterFees = waterFees;
    }

    public String getNaturalGasFees() {
        return naturalGasFees;
    }

    public void setNaturalGasFees(String naturalGasFees) {
        this.naturalGasFees = naturalGasFees;
    }

    public String getHeatingFees() {
        return heatingFees;
    }

    public void setHeatingFees(String heatingFees) {
        this.heatingFees = heatingFees;
    }

    public String getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(String occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public String getMlIndoorParkingSpace() {
        return mlIndoorParkingSpace;
    }

    public void setMlIndoorParkingSpace(String mlIndoorParkingSpace) {
        this.mlIndoorParkingSpace = mlIndoorParkingSpace;
    }

    public String getMlOutdoorParkingSpace() {
        return mlOutdoorParkingSpace;
    }

    public void setMlOutdoorParkingSpace(String mlOutdoorParkingSpace) {
        this.mlOutdoorParkingSpace = mlOutdoorParkingSpace;
    }

    public String getMlIndoorParkingCharge() {
        return mlIndoorParkingCharge;
    }

    public void setMlIndoorParkingCharge(String mlIndoorParkingCharge) {
        this.mlIndoorParkingCharge = mlIndoorParkingCharge;
    }

    public String getMlOutdoorParkingCharge() {
        return mlOutdoorParkingCharge;
    }

    public void setMlOutdoorParkingCharge(String mlOutdoorParkingCharge) {
        this.mlOutdoorParkingCharge = mlOutdoorParkingCharge;
    }

    public String getMlzsParkingRate() {
        return mlzsParkingRate;
    }

    public void setMlzsParkingRate(String mlzsParkingRate) {
        this.mlzsParkingRate = mlzsParkingRate;
    }

    public String getMlzsSubwabNumber() {
        return mlzsSubwabNumber;
    }

    public void setMlzsSubwabNumber(String mlzsSubwabNumber) {
        this.mlzsSubwabNumber = mlzsSubwabNumber;
    }

    public String getMlzsBusNumber() {
        return mlzsBusNumber;
    }

    public void setMlzsBusNumber(String mlzsBusNumber) {
        this.mlzsBusNumber = mlzsBusNumber;
    }

    public String getMlzsHealthRecreationNumber() {
        return mlzsHealthRecreationNumber;
    }

    public void setMlzsHealthRecreationNumber(String mlzsHealthRecreationNumber) {
        this.mlzsHealthRecreationNumber = mlzsHealthRecreationNumber;
    }

    public String getMlzsUpgradeIndexAssignment() {
        return mlzsUpgradeIndexAssignment;
    }

    public void setMlzsUpgradeIndexAssignment(String mlzsUpgradeIndexAssignment) {
        this.mlzsUpgradeIndexAssignment = mlzsUpgradeIndexAssignment;
    }
}
