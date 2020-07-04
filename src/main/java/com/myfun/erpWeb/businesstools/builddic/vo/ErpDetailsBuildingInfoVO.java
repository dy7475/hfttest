package com.myfun.erpWeb.businesstools.builddic.vo;

import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel
public class ErpDetailsBuildingInfoVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增序列")
    private Integer buildId;
    @ApiModelProperty(value = "楼盘名称")
    private String buildName;
    @ApiModelProperty(value = "检索码")
    private String buildCode;
    @ApiModelProperty(value = "开发商")
    private String buildDevloper;
    @ApiModelProperty(value = "楼盘位置")
    private String buildAddr;
    @ApiModelProperty(value = "行政区域")
    private Integer buildRegion;
    @ApiModelProperty(value = "片区ID")
    private Integer sectionId;
    @ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
    private Byte buildRound;
    @ApiModelProperty(value = "地铁线路ID(多选)")
    private String subwayIds;
    @ApiModelProperty(value = "地铁站点ID(多选)")
    private String stationIds;
    @ApiModelProperty(value = "配套情况")
    private String addCase;
    @ApiModelProperty(value = "建筑类型")
    private String buildType;
    @ApiModelProperty(value = "建筑日期")
    private String buildDate;
    @ApiModelProperty(value = "占地面积")
    private String buildArea;
    @ApiModelProperty(value = "容积率")
    private String projectSpace;
    @ApiModelProperty(value = "绿化率")
    private String projectGreen;
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
    @ApiModelProperty(value = "审核标志，1=是（纠正：入库标记 1-是； 0-否）")
    private Short vertifyFlag;
    @ApiModelProperty(value = "后台校正标记（纠正：审核标记 -2 审核失败 0-未审, 1-全部已审； 2-规范审核中；3 规范审核通过；")
    private Short examFlag;
    @ApiModelProperty(value = "纠错时间")
    private String checkTime;
    @ApiModelProperty(value = "用户在新建房源时更改该楼盘地理信息的次数，Default{0}")
    private Byte addrCount;
    @ApiModelProperty(value = "楼盘状态 1=待售 2=在售 3=售罄 4=招商 5=招租")
    private Byte buildStatus;
    @ApiModelProperty(value = "物业类型描述 多个用 | 分隔DD：HOUSE_USEAGE")
    private String buildUsage;
    @ApiModelProperty(value = "建筑面积")
    private String constractArea;
    @ApiModelProperty(value = "新盘标志")
    private Byte newFlag;
    @ApiModelProperty(value = "审核后的图片张数")
    private Byte examPhoto;
    @ApiModelProperty(value = "云房楼盘Id")
    private Integer yfBuildId;
    @ApiModelProperty(value = "是否地铁房")
    private Byte isSubway;
    @ApiModelProperty(value = "是否学区房")
    private Byte isSchool;
    @ApiModelProperty(value = "均价环比")
    private Double ratioLastMonth;
    @ApiModelProperty(value = "均价同比")
    private Double ratioLastYear;
    @ApiModelProperty(value = "周边学校")
    private String schools;
    @ApiModelProperty(value = "null")
    private String addCaseBk;
    @ApiModelProperty(value = "维护人")
    private Integer contentMaintainerUserid;
    @ApiModelProperty(value = "维护时间")
    private Date contentMaintainerTime;
    @ApiModelProperty(value = "楼盘是否可以修改")
    private Byte buildIsUpdate;
    @ApiModelProperty(value = "楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼） 顺序相同|分割")
    private String searchField;
    @ApiModelProperty(value = "内容审核时间")
    private Date contentAuditTime;
    @ApiModelProperty(value = "内容审核人")
    private Integer contentAuditUserId;
    @ApiModelProperty(value = "规范审核时间")
    private Date auditTime;
    @ApiModelProperty(value = "规范审核人")
    private Integer auditUserId;
    @ApiModelProperty(value = "栋座维护人")
    private Integer buildingMaintenanceId;
    @ApiModelProperty(value = "栋座维护时间")
    private Date buildingMaintenanceTime;
    @ApiModelProperty(value = "栋座审核人")
    private Integer buildingReviewId;
    @ApiModelProperty(value = "栋座审核状态 0 未审核   1  审核中  2 审核成功  3  审核失败")
    private Byte buildingReviewStatus;
    @ApiModelProperty(value = "栋座审核时间")
    private Date buildingReviewTime;
    @ApiModelProperty(value = "房多多楼盘id")
    private Integer fddBuildId;
    @ApiModelProperty(value = "车位情况")
    private String carsCase;
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
    @ApiModelProperty("入住率")
    private String occupancyRate;
    @ApiModelProperty("周边交通")
    private String traffic;
    @ApiModelProperty("建筑年代")
    private String finishDate;
    @ApiModelProperty("楼盘责任人")
    private Integer buildManager;
    @ApiModelProperty("栋数")
    private Integer roofs = 0;
    @ApiModelProperty("总户数（项目套数）")
    private String projectCover;
    @ApiModelProperty("别名")
    private String fAlias;
    @ApiModelProperty("座标X-纬度-lat")
    private String positionX;
    @ApiModelProperty("座标Y-经度-lng")
    private String positionY;
    @ApiModelProperty("产权年限")
    private String rightYears;
    @ApiModelProperty("交房日期")
    private String submitDate;
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
    @ApiModelProperty(value = "是否临近轨道交通")
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
    @ApiModelProperty(value = "楼盘用途数据字典 多个用 | 线分隔 DD：HOUSE_USEAGE" )
    private String buildingUseage;
    @ApiModelProperty(value = "美联第二个街道")
    private String mlBelongToStreetA;

    @ApiModelProperty(value = "保存的FUN_STREET街道表信息,多个用逗号分隔开")
    private String streetIds;

    @ApiModelProperty("街道列表数据")
    private List<StreetData> streets;

    @ApiModel
    public static class StreetData {

        @ApiModelProperty(value = "街道ID")
        private Integer id;

        @ApiModelProperty(value = "街道名称")
        private String streetName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }
    }

    public String getStreetIds() {
        return streetIds;
    }

    public void setStreetIds(String streetIds) {
        this.streetIds = streetIds;
    }

    public List<StreetData> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetData> streets) {
        this.streets = streets;
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



    public String getfAlias() {
        return fAlias;
    }

    public void setfAlias(String fAlias) {
        this.fAlias = fAlias;
    }

    private List<ErpBuildingPhoto> buildPhotoList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
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

    public String getSubwayIds() {
        return subwayIds;
    }

    public void setSubwayIds(String subwayIds) {
        this.subwayIds = subwayIds;
    }

    public String getStationIds() {
        return stationIds;
    }

    public void setStationIds(String stationIds) {
        this.stationIds = stationIds;
    }

    public String getAddCase() {
        return addCase;
    }

    public void setAddCase(String addCase) {
        this.addCase = addCase;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(String buildArea) {
        this.buildArea = buildArea;
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

    public Short getVertifyFlag() {
        return vertifyFlag;
    }

    public void setVertifyFlag(Short vertifyFlag) {
        this.vertifyFlag = vertifyFlag;
    }

    public Short getExamFlag() {
        return examFlag;
    }

    public void setExamFlag(Short examFlag) {
        this.examFlag = examFlag;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public Byte getAddrCount() {
        return addrCount;
    }

    public void setAddrCount(Byte addrCount) {
        this.addrCount = addrCount;
    }

    public Byte getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(Byte buildStatus) {
        this.buildStatus = buildStatus;
    }

    public String getBuildUsage() {
        return buildUsage;
    }

    public void setBuildUsage(String buildUsage) {
        this.buildUsage = buildUsage;
    }

    public String getConstractArea() {
        return constractArea;
    }

    public void setConstractArea(String constractArea) {
        this.constractArea = constractArea;
    }

    public Byte getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(Byte newFlag) {
        this.newFlag = newFlag;
    }

    public Byte getExamPhoto() {
        return examPhoto;
    }

    public void setExamPhoto(Byte examPhoto) {
        this.examPhoto = examPhoto;
    }

    public Integer getYfBuildId() {
        return yfBuildId;
    }

    public void setYfBuildId(Integer yfBuildId) {
        this.yfBuildId = yfBuildId;
    }

    public Byte getIsSubway() {
        return isSubway;
    }

    public void setIsSubway(Byte isSubway) {
        this.isSubway = isSubway;
    }

    public Byte getIsSchool() {
        return isSchool;
    }

    public void setIsSchool(Byte isSchool) {
        this.isSchool = isSchool;
    }

    public Double getRatioLastMonth() {
        return ratioLastMonth;
    }

    public void setRatioLastMonth(Double ratioLastMonth) {
        this.ratioLastMonth = ratioLastMonth;
    }

    public Double getRatioLastYear() {
        return ratioLastYear;
    }

    public void setRatioLastYear(Double ratioLastYear) {
        this.ratioLastYear = ratioLastYear;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }

    public String getAddCaseBk() {
        return addCaseBk;
    }

    public void setAddCaseBk(String addCaseBk) {
        this.addCaseBk = addCaseBk;
    }

    public Integer getContentMaintainerUserid() {
        return contentMaintainerUserid;
    }

    public void setContentMaintainerUserid(Integer contentMaintainerUserid) {
        this.contentMaintainerUserid = contentMaintainerUserid;
    }

    public Date getContentMaintainerTime() {
        return contentMaintainerTime;
    }

    public void setContentMaintainerTime(Date contentMaintainerTime) {
        this.contentMaintainerTime = contentMaintainerTime;
    }

    public Byte getBuildIsUpdate() {
        return buildIsUpdate;
    }

    public void setBuildIsUpdate(Byte buildIsUpdate) {
        this.buildIsUpdate = buildIsUpdate;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public Date getContentAuditTime() {
        return contentAuditTime;
    }

    public void setContentAuditTime(Date contentAuditTime) {
        this.contentAuditTime = contentAuditTime;
    }

    public Integer getContentAuditUserId() {
        return contentAuditUserId;
    }

    public void setContentAuditUserId(Integer contentAuditUserId) {
        this.contentAuditUserId = contentAuditUserId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Integer getBuildingMaintenanceId() {
        return buildingMaintenanceId;
    }

    public void setBuildingMaintenanceId(Integer buildingMaintenanceId) {
        this.buildingMaintenanceId = buildingMaintenanceId;
    }

    public Date getBuildingMaintenanceTime() {
        return buildingMaintenanceTime;
    }

    public void setBuildingMaintenanceTime(Date buildingMaintenanceTime) {
        this.buildingMaintenanceTime = buildingMaintenanceTime;
    }

    public Integer getBuildingReviewId() {
        return buildingReviewId;
    }

    public void setBuildingReviewId(Integer buildingReviewId) {
        this.buildingReviewId = buildingReviewId;
    }

    public Byte getBuildingReviewStatus() {
        return buildingReviewStatus;
    }

    public void setBuildingReviewStatus(Byte buildingReviewStatus) {
        this.buildingReviewStatus = buildingReviewStatus;
    }

    public Date getBuildingReviewTime() {
        return buildingReviewTime;
    }

    public void setBuildingReviewTime(Date buildingReviewTime) {
        this.buildingReviewTime = buildingReviewTime;
    }

    public Integer getFddBuildId() {
        return fddBuildId;
    }

    public void setFddBuildId(Integer fddBuildId) {
        this.fddBuildId = fddBuildId;
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

    public Integer getBuildManager() {
        return buildManager;
    }

    public void setBuildManager(Integer buildManager) {
        this.buildManager = buildManager;
    }

    public Integer getRoofs() {
        return roofs;
    }

    public void setRoofs(Integer roofs) {
        this.roofs = roofs;
    }

    public List<ErpBuildingPhoto> getBuildPhotoList() {
        return buildPhotoList;
    }

    public void setBuildPhotoList(List<ErpBuildingPhoto> buildPhotoList) {
        this.buildPhotoList = buildPhotoList;
    }

    public String getCarsCase() {
        return carsCase;
    }

    public void setCarsCase(String carsCase) {
        this.carsCase = carsCase;
    }

    public String getProjectCover() {
        return projectCover;
    }

    public void setProjectCover(String projectCover) {
        this.projectCover = projectCover;
    }

	public String getPositionX() {
		return positionX;
	}

	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	public String getPositionY() {
		return positionY;
	}

	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	public String getRightYears() {
		return rightYears;
	}

	public void setRightYears(String rightYears) {
		this.rightYears = rightYears;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

    public String getMlIndoorParkingSpace() {
        return mlIndoorParkingSpace;
    }

    public void setMlIndoorParkingSpace(String mlIndoorParkingSpace) {
        this.mlIndoorParkingSpace = mlIndoorParkingSpace;
    }
}
