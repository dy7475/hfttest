package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ErpBuildingInfo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "市(县)ID")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "自增序列")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘名称")
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
	@ApiModelProperty(value = "行政区域")
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
	private Byte buildRound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地铁线路ID(多选)")
	private String subwayIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地铁站点ID(多选)")
	private String stationIds;
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
	@ApiModelProperty(value = "交房日期")
	private String submitDate;
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
	private Integer buildPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "座标X-纬度-lat")
	private String positionX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "座标Y-经度-lng")
	private String positionY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "座标标志，1=是")
	private Short positionFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "典型标志，1=是")
	private Short typicFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核标志，1=是（纠正：入库标记 1-是； 0-否）")
	private Short vertifyFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交时间")
	private String createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "后台校正标记（纠正：审核标记 -2 审核失败 0-未审, 1-全部已审； 2-规范审核中；3 规范审核通过；")
	private Short examFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "纠错时间")
	private String checkTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户在新建房源时更改该楼盘地理信息的次数，Default{0}")
	private Byte addrCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘状态 1=待售 2=在售 3=售罄 4=招商 5=招租")
	private Byte buildStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物业类型描述")
	private String buildUsage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "施工进度")
	private String buildProgress;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "项目特色IDS DD:HOUSE_FEATURE")
	private String projectSpec;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权年限")
	private String rightYears;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘销售许可证")
	private String buildPermission;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开盘日期")
	private String sellDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑年代（以前叫竣工日期）")
	private String finishDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "装修状况IDS DD:BUILD_FITMENT")
	private String buildFitment;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑面积")
	private String constractArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "售楼部地址")
	private String sellAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "售楼电话")
	private String sellTele;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "销售价格")
	private Integer price;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "销售价格描述")
	private String priceText;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "外景图")
	private Integer photoExterior;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "效果图")
	private Integer photoEffects;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "户型图")
	private Integer photoModel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "交通图")
	private Integer photoTraffic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "规划图")
	private Integer photoPlan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配套图")
	private Integer photoSet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "样板图")
	private Integer photoTemplet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "新盘标志")
	private Byte newFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核后的图片张数")
	private Byte examPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "售楼电话1")
	private String sellTele1;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "400电话")
	private String tele400;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "400分机号")
	private String extcode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-物业类型")
	private Integer fpropertyunit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fbroadband;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fdrinkingwater;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fgas;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fparkids;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-投资商")
	private String finvestor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-承建商")
	private String fbuilder;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String flandscape;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private Byte fstatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘别名")
	private String falias;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private Integer fhouseid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String funitids;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-物业费")
	private Double fpropertyfee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fhousetypeids;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "贵说弃用了")
	private Integer buildWebid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "酷家乐楼盘名称")
	private String kjlBuildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地图坐标审核标志")
	private Integer positionCheck;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp房源出售数量")
	private Integer saleNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp房源出租数量")
	private Integer leaseNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "soso出售数量")
	private Integer sosoSaleNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "soso出租数量")
	private Integer sosoLeaseNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "直供出售数据UU")
	private Integer agencySaleNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "直供出租数据UU")
	private Integer agencyLeaseNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合租数量")
	private Integer hezuNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp发送到UU的出售数量")
	private Integer erpUuSaleNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp发送到UU的出租数量")
	private Integer erpUuLeaseNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp发送到微店的出售数量")
	private Integer erpWdSaleNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp发送到微店的出租数量")
	private Integer erpWdLeaseNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp 1个月内 发布 有效 图片大于等于1的房源数量")
	private Integer erpSaleNumsMonth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp 1个月内 发布 有效 图片大于等于1的房源数量")
	private Integer erpLeaseNumsMonth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "云房楼盘Id")
	private Integer yfBuildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否地铁房")
	private Byte isSubway;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否学区房")
	private Byte isSchool;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "均价环比")
	private Double ratioLastMonth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "均价同比")
	private Double ratioLastYear;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "学校")
	private String schools;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "询价次数")
	private Integer inquiryNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "小区竞价的结束时间        -陈文超-  目前用于优优好房的附近经纪人功能")
	private Date biddingEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "小区竞价的经纪人档案ID   -  陈文超  -  目前用于优优好房的附近经纪人功能")
	private Integer biddingArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ERP在优优上真房源数量")
	private Integer erpSaleTrueNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ERP在优优上出租真房源数量")
	private Integer erpLeaseTrueNums;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "默认小区专家档案ID-陈文超")
	private Integer defaultBiddArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String addCaseBk;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘均价扫描程序处理状态 0=未处理 1=处理中 2=处理完成")
	private Byte scanBuildAveragePriceStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘均价扫描程序处理最后处理时间")
	private Date scanBuildAveragePriceTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "入库人")
	private Integer putStorageUserid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "入库时间")
	private Date putStorageTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "维护人")
	private Integer contentMaintainerUserid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "维护时间")
	private Date contentMaintainerTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘是否可以修改")
	private Byte buildIsUpdate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼，楼盘地址） 顺序相同|分割")
	private String searchField;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内容审核时间")
	private Date contentAuditTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内容审核人")
	private Integer contentAuditUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "规范审核时间")
	private Date auditTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "规范审核人")
	private Integer auditUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座维护人")
	private Integer buildingMaintenanceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座维护时间")
	private Date buildingMaintenanceTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座审核人")
	private Integer buildingReviewId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座审核状态 0 未审核   1  审核中  2 审核成功  3  审核失败")
	private Byte buildingReviewStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座审核时间")
	private Date buildingReviewTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房多多楼盘id")
	private Integer fddBuildId;
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
	@ApiModelProperty(value = "小区的全拼(保持唯一)")
	private String xiaoquPy;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "入住率")
	private String occupancyRate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "周边交通")
	private String traffic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总栋数")
	private Integer roofs;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统模板公司ID")
	private Integer templateCompId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首图地址")
	private String headPicUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "注册名 --美联用")
	private String promotionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘用途数据字典 多个用 | 线分隔")
	private String buildingUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "外墙 DD OUTER_WALL_TYPE")
	private Byte mlOuterWall;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "结构(DD: HOUSE_STRUCT )")
	private Byte mlHouseStructure;
	/**
	 * @mbggenerated
	 */
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
	@ApiModelProperty(value = "物业类型  DD TENEMENT_TYPE")
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
	@ApiModelProperty(value = "竣工日期")
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
	@ApiModelProperty(value = "是否临近轨道交通（1，是 0 否）")
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
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地块编号")
	private String mlLandNumber;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联最高物业费")
	private String costStandardA;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联第二个所属街道")
	private String mlBelongToStreetA;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Double metroDistance;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal averagePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal lastAveragePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer parkingSpace;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "保存的FUN_STREET街道表信息,多个用逗号分隔开")
	private String streetIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String ffloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fstruct;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String fequipments;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String ftraffic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对接腾讯-")
	private String finner;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 市(县)ID
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 市(县)ID
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 自增序列
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 自增序列
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
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
	 * @mbggenerated 行政区域
	 */
	public Integer getBuildRegion() {
		return buildRegion;
	}

	/**
	 * @mbggenerated 行政区域
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
	public Byte getBuildRound() {
		return buildRound;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public void setBuildRound(Byte buildRound) {
		this.buildRound = buildRound;
	}

	/**
	 * @mbggenerated 地铁线路ID(多选)
	 */
	public String getSubwayIds() {
		return subwayIds;
	}

	/**
	 * @mbggenerated 地铁线路ID(多选)
	 */
	public void setSubwayIds(String subwayIds) {
		this.subwayIds = subwayIds;
	}

	/**
	 * @mbggenerated 地铁站点ID(多选)
	 */
	public String getStationIds() {
		return stationIds;
	}

	/**
	 * @mbggenerated 地铁站点ID(多选)
	 */
	public void setStationIds(String stationIds) {
		this.stationIds = stationIds;
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
	public Integer getBuildPhoto() {
		return buildPhoto;
	}

	/**
	 * @mbggenerated 图片标记，N=图片张数
	 */
	public void setBuildPhoto(Integer buildPhoto) {
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
	public String getPositionY() {
		return positionY;
	}

	/**
	 * @mbggenerated 座标Y-经度-lng
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	/**
	 * @mbggenerated 座标标志，1=是
	 */
	public Short getPositionFlag() {
		return positionFlag;
	}

	/**
	 * @mbggenerated 座标标志，1=是
	 */
	public void setPositionFlag(Short positionFlag) {
		this.positionFlag = positionFlag;
	}

	/**
	 * @mbggenerated 典型标志，1=是
	 */
	public Short getTypicFlag() {
		return typicFlag;
	}

	/**
	 * @mbggenerated 典型标志，1=是
	 */
	public void setTypicFlag(Short typicFlag) {
		this.typicFlag = typicFlag;
	}

	/**
	 * @mbggenerated 审核标志，1=是（纠正：入库标记 1-是； 0-否）
	 */
	public Short getVertifyFlag() {
		return vertifyFlag;
	}

	/**
	 * @mbggenerated 审核标志，1=是（纠正：入库标记 1-是； 0-否）
	 */
	public void setVertifyFlag(Short vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}

	/**
	 * @mbggenerated 经纪人ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 经纪人ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 提交时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 提交时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 后台校正标记（纠正：审核标记 -2 审核失败 0-未审, 1-全部已审； 2-规范审核中；3 规范审核通过；
	 */
	public Short getExamFlag() {
		return examFlag;
	}

	/**
	 * @mbggenerated 后台校正标记（纠正：审核标记 -2 审核失败 0-未审, 1-全部已审； 2-规范审核中；3 规范审核通过；
	 */
	public void setExamFlag(Short examFlag) {
		this.examFlag = examFlag;
	}

	/**
	 * @mbggenerated 纠错时间
	 */
	public String getCheckTime() {
		return checkTime;
	}

	/**
	 * @mbggenerated 纠错时间
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @mbggenerated 用户在新建房源时更改该楼盘地理信息的次数，Default{0}
	 */
	public Byte getAddrCount() {
		return addrCount;
	}

	/**
	 * @mbggenerated 用户在新建房源时更改该楼盘地理信息的次数，Default{0}
	 */
	public void setAddrCount(Byte addrCount) {
		this.addrCount = addrCount;
	}

	/**
	 * @mbggenerated 楼盘状态 1=待售 2=在售 3=售罄 4=招商 5=招租
	 */
	public Byte getBuildStatus() {
		return buildStatus;
	}

	/**
	 * @mbggenerated 楼盘状态 1=待售 2=在售 3=售罄 4=招商 5=招租
	 */
	public void setBuildStatus(Byte buildStatus) {
		this.buildStatus = buildStatus;
	}

	/**
	 * @mbggenerated 物业类型描述
	 */
	public String getBuildUsage() {
		return buildUsage;
	}

	/**
	 * @mbggenerated 物业类型描述
	 */
	public void setBuildUsage(String buildUsage) {
		this.buildUsage = buildUsage;
	}

	/**
	 * @mbggenerated 施工进度
	 */
	public String getBuildProgress() {
		return buildProgress;
	}

	/**
	 * @mbggenerated 施工进度
	 */
	public void setBuildProgress(String buildProgress) {
		this.buildProgress = buildProgress;
	}

	/**
	 * @mbggenerated 项目特色IDS DD:HOUSE_FEATURE
	 */
	public String getProjectSpec() {
		return projectSpec;
	}

	/**
	 * @mbggenerated 项目特色IDS DD:HOUSE_FEATURE
	 */
	public void setProjectSpec(String projectSpec) {
		this.projectSpec = projectSpec;
	}

	/**
	 * @mbggenerated 产权年限
	 */
	public String getRightYears() {
		return rightYears;
	}

	/**
	 * @mbggenerated 产权年限
	 */
	public void setRightYears(String rightYears) {
		this.rightYears = rightYears;
	}

	/**
	 * @mbggenerated 楼盘销售许可证
	 */
	public String getBuildPermission() {
		return buildPermission;
	}

	/**
	 * @mbggenerated 楼盘销售许可证
	 */
	public void setBuildPermission(String buildPermission) {
		this.buildPermission = buildPermission;
	}

	/**
	 * @mbggenerated 开盘日期
	 */
	public String getSellDate() {
		return sellDate;
	}

	/**
	 * @mbggenerated 开盘日期
	 */
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	/**
	 * @mbggenerated 建筑年代（以前叫竣工日期）
	 */
	public String getFinishDate() {
		return finishDate;
	}

	/**
	 * @mbggenerated 建筑年代（以前叫竣工日期）
	 */
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * @mbggenerated 装修状况IDS DD:BUILD_FITMENT
	 */
	public String getBuildFitment() {
		return buildFitment;
	}

	/**
	 * @mbggenerated 装修状况IDS DD:BUILD_FITMENT
	 */
	public void setBuildFitment(String buildFitment) {
		this.buildFitment = buildFitment;
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
	 * @mbggenerated 售楼部地址
	 */
	public String getSellAddr() {
		return sellAddr;
	}

	/**
	 * @mbggenerated 售楼部地址
	 */
	public void setSellAddr(String sellAddr) {
		this.sellAddr = sellAddr;
	}

	/**
	 * @mbggenerated 售楼电话
	 */
	public String getSellTele() {
		return sellTele;
	}

	/**
	 * @mbggenerated 售楼电话
	 */
	public void setSellTele(String sellTele) {
		this.sellTele = sellTele;
	}

	/**
	 * @mbggenerated 销售价格
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @mbggenerated 销售价格
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @mbggenerated 销售价格描述
	 */
	public String getPriceText() {
		return priceText;
	}

	/**
	 * @mbggenerated 销售价格描述
	 */
	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}

	/**
	 * @mbggenerated 外景图
	 */
	public Integer getPhotoExterior() {
		return photoExterior;
	}

	/**
	 * @mbggenerated 外景图
	 */
	public void setPhotoExterior(Integer photoExterior) {
		this.photoExterior = photoExterior;
	}

	/**
	 * @mbggenerated 效果图
	 */
	public Integer getPhotoEffects() {
		return photoEffects;
	}

	/**
	 * @mbggenerated 效果图
	 */
	public void setPhotoEffects(Integer photoEffects) {
		this.photoEffects = photoEffects;
	}

	/**
	 * @mbggenerated 户型图
	 */
	public Integer getPhotoModel() {
		return photoModel;
	}

	/**
	 * @mbggenerated 户型图
	 */
	public void setPhotoModel(Integer photoModel) {
		this.photoModel = photoModel;
	}

	/**
	 * @mbggenerated 交通图
	 */
	public Integer getPhotoTraffic() {
		return photoTraffic;
	}

	/**
	 * @mbggenerated 交通图
	 */
	public void setPhotoTraffic(Integer photoTraffic) {
		this.photoTraffic = photoTraffic;
	}

	/**
	 * @mbggenerated 规划图
	 */
	public Integer getPhotoPlan() {
		return photoPlan;
	}

	/**
	 * @mbggenerated 规划图
	 */
	public void setPhotoPlan(Integer photoPlan) {
		this.photoPlan = photoPlan;
	}

	/**
	 * @mbggenerated 配套图
	 */
	public Integer getPhotoSet() {
		return photoSet;
	}

	/**
	 * @mbggenerated 配套图
	 */
	public void setPhotoSet(Integer photoSet) {
		this.photoSet = photoSet;
	}

	/**
	 * @mbggenerated 样板图
	 */
	public Integer getPhotoTemplet() {
		return photoTemplet;
	}

	/**
	 * @mbggenerated 样板图
	 */
	public void setPhotoTemplet(Integer photoTemplet) {
		this.photoTemplet = photoTemplet;
	}

	/**
	 * @mbggenerated 新盘标志
	 */
	public Byte getNewFlag() {
		return newFlag;
	}

	/**
	 * @mbggenerated 新盘标志
	 */
	public void setNewFlag(Byte newFlag) {
		this.newFlag = newFlag;
	}

	/**
	 * @mbggenerated 审核后的图片张数
	 */
	public Byte getExamPhoto() {
		return examPhoto;
	}

	/**
	 * @mbggenerated 审核后的图片张数
	 */
	public void setExamPhoto(Byte examPhoto) {
		this.examPhoto = examPhoto;
	}

	/**
	 * @mbggenerated 售楼电话1
	 */
	public String getSellTele1() {
		return sellTele1;
	}

	/**
	 * @mbggenerated 售楼电话1
	 */
	public void setSellTele1(String sellTele1) {
		this.sellTele1 = sellTele1;
	}

	/**
	 * @mbggenerated 400电话
	 */
	public String getTele400() {
		return tele400;
	}

	/**
	 * @mbggenerated 400电话
	 */
	public void setTele400(String tele400) {
		this.tele400 = tele400;
	}

	/**
	 * @mbggenerated 400分机号
	 */
	public String getExtcode() {
		return extcode;
	}

	/**
	 * @mbggenerated 400分机号
	 */
	public void setExtcode(String extcode) {
		this.extcode = extcode;
	}

	/**
	 * @mbggenerated 对接腾讯-物业类型
	 */
	public Integer getFpropertyunit() {
		return fpropertyunit;
	}

	/**
	 * @mbggenerated 对接腾讯-物业类型
	 */
	public void setFpropertyunit(Integer fpropertyunit) {
		this.fpropertyunit = fpropertyunit;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFbroadband() {
		return fbroadband;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFbroadband(String fbroadband) {
		this.fbroadband = fbroadband;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFdrinkingwater() {
		return fdrinkingwater;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFdrinkingwater(String fdrinkingwater) {
		this.fdrinkingwater = fdrinkingwater;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFgas() {
		return fgas;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFgas(String fgas) {
		this.fgas = fgas;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFparkids() {
		return fparkids;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFparkids(String fparkids) {
		this.fparkids = fparkids;
	}

	/**
	 * @mbggenerated 对接腾讯-投资商
	 */
	public String getFinvestor() {
		return finvestor;
	}

	/**
	 * @mbggenerated 对接腾讯-投资商
	 */
	public void setFinvestor(String finvestor) {
		this.finvestor = finvestor;
	}

	/**
	 * @mbggenerated 对接腾讯-承建商
	 */
	public String getFbuilder() {
		return fbuilder;
	}

	/**
	 * @mbggenerated 对接腾讯-承建商
	 */
	public void setFbuilder(String fbuilder) {
		this.fbuilder = fbuilder;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFlandscape() {
		return flandscape;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFlandscape(String flandscape) {
		this.flandscape = flandscape;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public Byte getFstatus() {
		return fstatus;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFstatus(Byte fstatus) {
		this.fstatus = fstatus;
	}

	/**
	 * @mbggenerated 楼盘别名
	 */
	public String getFalias() {
		return falias;
	}

	/**
	 * @mbggenerated 楼盘别名
	 */
	public void setFalias(String falias) {
		this.falias = falias;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public Integer getFhouseid() {
		return fhouseid;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFhouseid(Integer fhouseid) {
		this.fhouseid = fhouseid;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFunitids() {
		return funitids;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFunitids(String funitids) {
		this.funitids = funitids;
	}

	/**
	 * @mbggenerated 对接腾讯-物业费
	 */
	public Double getFpropertyfee() {
		return fpropertyfee;
	}

	/**
	 * @mbggenerated 对接腾讯-物业费
	 */
	public void setFpropertyfee(Double fpropertyfee) {
		this.fpropertyfee = fpropertyfee;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFhousetypeids() {
		return fhousetypeids;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFhousetypeids(String fhousetypeids) {
		this.fhousetypeids = fhousetypeids;
	}

	/**
	 * @mbggenerated 贵说弃用了
	 */
	public Integer getBuildWebid() {
		return buildWebid;
	}

	/**
	 * @mbggenerated 贵说弃用了
	 */
	public void setBuildWebid(Integer buildWebid) {
		this.buildWebid = buildWebid;
	}

	/**
	 * @mbggenerated 酷家乐楼盘名称
	 */
	public String getKjlBuildName() {
		return kjlBuildName;
	}

	/**
	 * @mbggenerated 酷家乐楼盘名称
	 */
	public void setKjlBuildName(String kjlBuildName) {
		this.kjlBuildName = kjlBuildName;
	}

	/**
	 * @mbggenerated 地图坐标审核标志
	 */
	public Integer getPositionCheck() {
		return positionCheck;
	}

	/**
	 * @mbggenerated 地图坐标审核标志
	 */
	public void setPositionCheck(Integer positionCheck) {
		this.positionCheck = positionCheck;
	}

	/**
	 * @mbggenerated erp房源出售数量
	 */
	public Integer getSaleNums() {
		return saleNums;
	}

	/**
	 * @mbggenerated erp房源出售数量
	 */
	public void setSaleNums(Integer saleNums) {
		this.saleNums = saleNums;
	}

	/**
	 * @mbggenerated erp房源出租数量
	 */
	public Integer getLeaseNums() {
		return leaseNums;
	}

	/**
	 * @mbggenerated erp房源出租数量
	 */
	public void setLeaseNums(Integer leaseNums) {
		this.leaseNums = leaseNums;
	}

	/**
	 * @mbggenerated soso出售数量
	 */
	public Integer getSosoSaleNums() {
		return sosoSaleNums;
	}

	/**
	 * @mbggenerated soso出售数量
	 */
	public void setSosoSaleNums(Integer sosoSaleNums) {
		this.sosoSaleNums = sosoSaleNums;
	}

	/**
	 * @mbggenerated soso出租数量
	 */
	public Integer getSosoLeaseNums() {
		return sosoLeaseNums;
	}

	/**
	 * @mbggenerated soso出租数量
	 */
	public void setSosoLeaseNums(Integer sosoLeaseNums) {
		this.sosoLeaseNums = sosoLeaseNums;
	}

	/**
	 * @mbggenerated 直供出售数据UU
	 */
	public Integer getAgencySaleNums() {
		return agencySaleNums;
	}

	/**
	 * @mbggenerated 直供出售数据UU
	 */
	public void setAgencySaleNums(Integer agencySaleNums) {
		this.agencySaleNums = agencySaleNums;
	}

	/**
	 * @mbggenerated 直供出租数据UU
	 */
	public Integer getAgencyLeaseNums() {
		return agencyLeaseNums;
	}

	/**
	 * @mbggenerated 直供出租数据UU
	 */
	public void setAgencyLeaseNums(Integer agencyLeaseNums) {
		this.agencyLeaseNums = agencyLeaseNums;
	}

	/**
	 * @mbggenerated 合租数量
	 */
	public Integer getHezuNum() {
		return hezuNum;
	}

	/**
	 * @mbggenerated 合租数量
	 */
	public void setHezuNum(Integer hezuNum) {
		this.hezuNum = hezuNum;
	}

	/**
	 * @mbggenerated erp发送到UU的出售数量
	 */
	public Integer getErpUuSaleNum() {
		return erpUuSaleNum;
	}

	/**
	 * @mbggenerated erp发送到UU的出售数量
	 */
	public void setErpUuSaleNum(Integer erpUuSaleNum) {
		this.erpUuSaleNum = erpUuSaleNum;
	}

	/**
	 * @mbggenerated erp发送到UU的出租数量
	 */
	public Integer getErpUuLeaseNum() {
		return erpUuLeaseNum;
	}

	/**
	 * @mbggenerated erp发送到UU的出租数量
	 */
	public void setErpUuLeaseNum(Integer erpUuLeaseNum) {
		this.erpUuLeaseNum = erpUuLeaseNum;
	}

	/**
	 * @mbggenerated erp发送到微店的出售数量
	 */
	public Integer getErpWdSaleNum() {
		return erpWdSaleNum;
	}

	/**
	 * @mbggenerated erp发送到微店的出售数量
	 */
	public void setErpWdSaleNum(Integer erpWdSaleNum) {
		this.erpWdSaleNum = erpWdSaleNum;
	}

	/**
	 * @mbggenerated erp发送到微店的出租数量
	 */
	public Integer getErpWdLeaseNum() {
		return erpWdLeaseNum;
	}

	/**
	 * @mbggenerated erp发送到微店的出租数量
	 */
	public void setErpWdLeaseNum(Integer erpWdLeaseNum) {
		this.erpWdLeaseNum = erpWdLeaseNum;
	}

	/**
	 * @mbggenerated erp 1个月内 发布 有效 图片大于等于1的房源数量
	 */
	public Integer getErpSaleNumsMonth() {
		return erpSaleNumsMonth;
	}

	/**
	 * @mbggenerated erp 1个月内 发布 有效 图片大于等于1的房源数量
	 */
	public void setErpSaleNumsMonth(Integer erpSaleNumsMonth) {
		this.erpSaleNumsMonth = erpSaleNumsMonth;
	}

	/**
	 * @mbggenerated erp 1个月内 发布 有效 图片大于等于1的房源数量
	 */
	public Integer getErpLeaseNumsMonth() {
		return erpLeaseNumsMonth;
	}

	/**
	 * @mbggenerated erp 1个月内 发布 有效 图片大于等于1的房源数量
	 */
	public void setErpLeaseNumsMonth(Integer erpLeaseNumsMonth) {
		this.erpLeaseNumsMonth = erpLeaseNumsMonth;
	}

	/**
	 * @mbggenerated 云房楼盘Id
	 */
	public Integer getYfBuildId() {
		return yfBuildId;
	}

	/**
	 * @mbggenerated 云房楼盘Id
	 */
	public void setYfBuildId(Integer yfBuildId) {
		this.yfBuildId = yfBuildId;
	}

	/**
	 * @mbggenerated 是否地铁房
	 */
	public Byte getIsSubway() {
		return isSubway;
	}

	/**
	 * @mbggenerated 是否地铁房
	 */
	public void setIsSubway(Byte isSubway) {
		this.isSubway = isSubway;
	}

	/**
	 * @mbggenerated 是否学区房
	 */
	public Byte getIsSchool() {
		return isSchool;
	}

	/**
	 * @mbggenerated 是否学区房
	 */
	public void setIsSchool(Byte isSchool) {
		this.isSchool = isSchool;
	}

	/**
	 * @mbggenerated 均价环比
	 */
	public Double getRatioLastMonth() {
		return ratioLastMonth;
	}

	/**
	 * @mbggenerated 均价环比
	 */
	public void setRatioLastMonth(Double ratioLastMonth) {
		this.ratioLastMonth = ratioLastMonth;
	}

	/**
	 * @mbggenerated 均价同比
	 */
	public Double getRatioLastYear() {
		return ratioLastYear;
	}

	/**
	 * @mbggenerated 均价同比
	 */
	public void setRatioLastYear(Double ratioLastYear) {
		this.ratioLastYear = ratioLastYear;
	}

	/**
	 * @mbggenerated 学校
	 */
	public String getSchools() {
		return schools;
	}

	/**
	 * @mbggenerated 学校
	 */
	public void setSchools(String schools) {
		this.schools = schools;
	}

	/**
	 * @mbggenerated 询价次数
	 */
	public Integer getInquiryNum() {
		return inquiryNum;
	}

	/**
	 * @mbggenerated 询价次数
	 */
	public void setInquiryNum(Integer inquiryNum) {
		this.inquiryNum = inquiryNum;
	}

	/**
	 * @mbggenerated 小区竞价的结束时间        -陈文超-  目前用于优优好房的附近经纪人功能
	 */
	public Date getBiddingEndTime() {
		return biddingEndTime;
	}

	/**
	 * @mbggenerated 小区竞价的结束时间        -陈文超-  目前用于优优好房的附近经纪人功能
	 */
	public void setBiddingEndTime(Date biddingEndTime) {
		this.biddingEndTime = biddingEndTime;
	}

	/**
	 * @mbggenerated 小区竞价的经纪人档案ID   -  陈文超  -  目前用于优优好房的附近经纪人功能
	 */
	public Integer getBiddingArchiveId() {
		return biddingArchiveId;
	}

	/**
	 * @mbggenerated 小区竞价的经纪人档案ID   -  陈文超  -  目前用于优优好房的附近经纪人功能
	 */
	public void setBiddingArchiveId(Integer biddingArchiveId) {
		this.biddingArchiveId = biddingArchiveId;
	}

	/**
	 * @mbggenerated ERP在优优上真房源数量
	 */
	public Integer getErpSaleTrueNums() {
		return erpSaleTrueNums;
	}

	/**
	 * @mbggenerated ERP在优优上真房源数量
	 */
	public void setErpSaleTrueNums(Integer erpSaleTrueNums) {
		this.erpSaleTrueNums = erpSaleTrueNums;
	}

	/**
	 * @mbggenerated ERP在优优上出租真房源数量
	 */
	public Integer getErpLeaseTrueNums() {
		return erpLeaseTrueNums;
	}

	/**
	 * @mbggenerated ERP在优优上出租真房源数量
	 */
	public void setErpLeaseTrueNums(Integer erpLeaseTrueNums) {
		this.erpLeaseTrueNums = erpLeaseTrueNums;
	}

	/**
	 * @mbggenerated 默认小区专家档案ID-陈文超
	 */
	public Integer getDefaultBiddArchiveId() {
		return defaultBiddArchiveId;
	}

	/**
	 * @mbggenerated 默认小区专家档案ID-陈文超
	 */
	public void setDefaultBiddArchiveId(Integer defaultBiddArchiveId) {
		this.defaultBiddArchiveId = defaultBiddArchiveId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getAddCaseBk() {
		return addCaseBk;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAddCaseBk(String addCaseBk) {
		this.addCaseBk = addCaseBk;
	}

	/**
	 * @mbggenerated 楼盘均价扫描程序处理状态 0=未处理 1=处理中 2=处理完成
	 */
	public Byte getScanBuildAveragePriceStatus() {
		return scanBuildAveragePriceStatus;
	}

	/**
	 * @mbggenerated 楼盘均价扫描程序处理状态 0=未处理 1=处理中 2=处理完成
	 */
	public void setScanBuildAveragePriceStatus(Byte scanBuildAveragePriceStatus) {
		this.scanBuildAveragePriceStatus = scanBuildAveragePriceStatus;
	}

	/**
	 * @mbggenerated 楼盘均价扫描程序处理最后处理时间
	 */
	public Date getScanBuildAveragePriceTime() {
		return scanBuildAveragePriceTime;
	}

	/**
	 * @mbggenerated 楼盘均价扫描程序处理最后处理时间
	 */
	public void setScanBuildAveragePriceTime(Date scanBuildAveragePriceTime) {
		this.scanBuildAveragePriceTime = scanBuildAveragePriceTime;
	}

	/**
	 * @mbggenerated 入库人
	 */
	public Integer getPutStorageUserid() {
		return putStorageUserid;
	}

	/**
	 * @mbggenerated 入库人
	 */
	public void setPutStorageUserid(Integer putStorageUserid) {
		this.putStorageUserid = putStorageUserid;
	}

	/**
	 * @mbggenerated 入库时间
	 */
	public Date getPutStorageTime() {
		return putStorageTime;
	}

	/**
	 * @mbggenerated 入库时间
	 */
	public void setPutStorageTime(Date putStorageTime) {
		this.putStorageTime = putStorageTime;
	}

	/**
	 * @mbggenerated 维护人
	 */
	public Integer getContentMaintainerUserid() {
		return contentMaintainerUserid;
	}

	/**
	 * @mbggenerated 维护人
	 */
	public void setContentMaintainerUserid(Integer contentMaintainerUserid) {
		this.contentMaintainerUserid = contentMaintainerUserid;
	}

	/**
	 * @mbggenerated 维护时间
	 */
	public Date getContentMaintainerTime() {
		return contentMaintainerTime;
	}

	/**
	 * @mbggenerated 维护时间
	 */
	public void setContentMaintainerTime(Date contentMaintainerTime) {
		this.contentMaintainerTime = contentMaintainerTime;
	}

	/**
	 * @mbggenerated 楼盘是否可以修改
	 */
	public Byte getBuildIsUpdate() {
		return buildIsUpdate;
	}

	/**
	 * @mbggenerated 楼盘是否可以修改
	 */
	public void setBuildIsUpdate(Byte buildIsUpdate) {
		this.buildIsUpdate = buildIsUpdate;
	}

	/**
	 * @mbggenerated 楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼，楼盘地址） 顺序相同|分割
	 */
	public String getSearchField() {
		return searchField;
	}

	/**
	 * @mbggenerated 楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼，楼盘地址） 顺序相同|分割
	 */
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	/**
	 * @mbggenerated 内容审核时间
	 */
	public Date getContentAuditTime() {
		return contentAuditTime;
	}

	/**
	 * @mbggenerated 内容审核时间
	 */
	public void setContentAuditTime(Date contentAuditTime) {
		this.contentAuditTime = contentAuditTime;
	}

	/**
	 * @mbggenerated 内容审核人
	 */
	public Integer getContentAuditUserId() {
		return contentAuditUserId;
	}

	/**
	 * @mbggenerated 内容审核人
	 */
	public void setContentAuditUserId(Integer contentAuditUserId) {
		this.contentAuditUserId = contentAuditUserId;
	}

	/**
	 * @mbggenerated 规范审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated 规范审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated 规范审核人
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated 规范审核人
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	/**
	 * @mbggenerated 栋座维护人
	 */
	public Integer getBuildingMaintenanceId() {
		return buildingMaintenanceId;
	}

	/**
	 * @mbggenerated 栋座维护人
	 */
	public void setBuildingMaintenanceId(Integer buildingMaintenanceId) {
		this.buildingMaintenanceId = buildingMaintenanceId;
	}

	/**
	 * @mbggenerated 栋座维护时间
	 */
	public Date getBuildingMaintenanceTime() {
		return buildingMaintenanceTime;
	}

	/**
	 * @mbggenerated 栋座维护时间
	 */
	public void setBuildingMaintenanceTime(Date buildingMaintenanceTime) {
		this.buildingMaintenanceTime = buildingMaintenanceTime;
	}

	/**
	 * @mbggenerated 栋座审核人
	 */
	public Integer getBuildingReviewId() {
		return buildingReviewId;
	}

	/**
	 * @mbggenerated 栋座审核人
	 */
	public void setBuildingReviewId(Integer buildingReviewId) {
		this.buildingReviewId = buildingReviewId;
	}

	/**
	 * @mbggenerated 栋座审核状态 0 未审核   1  审核中  2 审核成功  3  审核失败
	 */
	public Byte getBuildingReviewStatus() {
		return buildingReviewStatus;
	}

	/**
	 * @mbggenerated 栋座审核状态 0 未审核   1  审核中  2 审核成功  3  审核失败
	 */
	public void setBuildingReviewStatus(Byte buildingReviewStatus) {
		this.buildingReviewStatus = buildingReviewStatus;
	}

	/**
	 * @mbggenerated 栋座审核时间
	 */
	public Date getBuildingReviewTime() {
		return buildingReviewTime;
	}

	/**
	 * @mbggenerated 栋座审核时间
	 */
	public void setBuildingReviewTime(Date buildingReviewTime) {
		this.buildingReviewTime = buildingReviewTime;
	}

	/**
	 * @mbggenerated 房多多楼盘id
	 */
	public Integer getFddBuildId() {
		return fddBuildId;
	}

	/**
	 * @mbggenerated 房多多楼盘id
	 */
	public void setFddBuildId(Integer fddBuildId) {
		this.fddBuildId = fddBuildId;
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
	 * @mbggenerated 小区的全拼(保持唯一)
	 */
	public String getXiaoquPy() {
		return xiaoquPy;
	}

	/**
	 * @mbggenerated 小区的全拼(保持唯一)
	 */
	public void setXiaoquPy(String xiaoquPy) {
		this.xiaoquPy = xiaoquPy;
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
	 * @mbggenerated 总栋数
	 */
	public Integer getRoofs() {
		return roofs;
	}

	/**
	 * @mbggenerated 总栋数
	 */
	public void setRoofs(Integer roofs) {
		this.roofs = roofs;
	}

	/**
	 * @mbggenerated 系统模板公司ID
	 */
	public Integer getTemplateCompId() {
		return templateCompId;
	}

	/**
	 * @mbggenerated 系统模板公司ID
	 */
	public void setTemplateCompId(Integer templateCompId) {
		this.templateCompId = templateCompId;
	}

	/**
	 * @mbggenerated 首图地址
	 */
	public String getHeadPicUrl() {
		return headPicUrl;
	}

	/**
	 * @mbggenerated 首图地址
	 */
	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

	/**
	 * @mbggenerated 注册名 --美联用
	 */
	public String getPromotionName() {
		return promotionName;
	}

	/**
	 * @mbggenerated 注册名 --美联用
	 */
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	/**
	 * @mbggenerated 楼盘用途数据字典 多个用 | 线分隔
	 */
	public String getBuildingUseage() {
		return buildingUseage;
	}

	/**
	 * @mbggenerated 楼盘用途数据字典 多个用 | 线分隔
	 */
	public void setBuildingUseage(String buildingUseage) {
		this.buildingUseage = buildingUseage;
	}

	/**
	 * @mbggenerated 外墙 DD OUTER_WALL_TYPE
	 */
	public Byte getMlOuterWall() {
		return mlOuterWall;
	}

	/**
	 * @mbggenerated 外墙 DD OUTER_WALL_TYPE
	 */
	public void setMlOuterWall(Byte mlOuterWall) {
		this.mlOuterWall = mlOuterWall;
	}

	/**
	 * @mbggenerated 结构(DD: HOUSE_STRUCT )
	 */
	public Byte getMlHouseStructure() {
		return mlHouseStructure;
	}

	/**
	 * @mbggenerated 结构(DD: HOUSE_STRUCT )
	 */
	public void setMlHouseStructure(Byte mlHouseStructure) {
		this.mlHouseStructure = mlHouseStructure;
	}

	/**
	 * @mbggenerated 学区房（1是/否0）
	 */
	public Byte getMlSchooleNearbyHouse() {
		return mlSchooleNearbyHouse;
	}

	/**
	 * @mbggenerated 学区房（1是/否0）
	 */
	public void setMlSchooleNearbyHouse(Byte mlSchooleNearbyHouse) {
		this.mlSchooleNearbyHouse = mlSchooleNearbyHouse;
	}

	/**
	 * @mbggenerated 室内停车位
	 */
	public String getMlIndoorParkingSpace() {
		return mlIndoorParkingSpace;
	}

	/**
	 * @mbggenerated 室内停车位
	 */
	public void setMlIndoorParkingSpace(String mlIndoorParkingSpace) {
		this.mlIndoorParkingSpace = mlIndoorParkingSpace;
	}

	/**
	 * @mbggenerated 室外停车位
	 */
	public String getMlOutdoorParkingSpace() {
		return mlOutdoorParkingSpace;
	}

	/**
	 * @mbggenerated 室外停车位
	 */
	public void setMlOutdoorParkingSpace(String mlOutdoorParkingSpace) {
		this.mlOutdoorParkingSpace = mlOutdoorParkingSpace;
	}

	/**
	 * @mbggenerated 室内停车费用
	 */
	public String getMlIndoorParkingCharge() {
		return mlIndoorParkingCharge;
	}

	/**
	 * @mbggenerated 室内停车费用
	 */
	public void setMlIndoorParkingCharge(String mlIndoorParkingCharge) {
		this.mlIndoorParkingCharge = mlIndoorParkingCharge;
	}

	/**
	 * @mbggenerated 室外停车费用
	 */
	public String getMlOutdoorParkingCharge() {
		return mlOutdoorParkingCharge;
	}

	/**
	 * @mbggenerated 室外停车费用
	 */
	public void setMlOutdoorParkingCharge(String mlOutdoorParkingCharge) {
		this.mlOutdoorParkingCharge = mlOutdoorParkingCharge;
	}

	/**
	 * @mbggenerated 所属街道
	 */
	public String getMlBelongToStreet() {
		return mlBelongToStreet;
	}

	/**
	 * @mbggenerated 所属街道
	 */
	public void setMlBelongToStreet(String mlBelongToStreet) {
		this.mlBelongToStreet = mlBelongToStreet;
	}

	/**
	 * @mbggenerated 产权类型 DD HOUSE_NATURE
	 */
	public String getMlPropertyType() {
		return mlPropertyType;
	}

	/**
	 * @mbggenerated 产权类型 DD HOUSE_NATURE
	 */
	public void setMlPropertyType(String mlPropertyType) {
		this.mlPropertyType = mlPropertyType;
	}

	/**
	 * @mbggenerated 物业类型  DD TENEMENT_TYPE
	 */
	public Byte getMlTenementType() {
		return mlTenementType;
	}

	/**
	 * @mbggenerated 物业类型  DD TENEMENT_TYPE
	 */
	public void setMlTenementType(Byte mlTenementType) {
		this.mlTenementType = mlTenementType;
	}

	/**
	 * @mbggenerated 批地日期
	 */
	public Date getMlRatifyLandDate() {
		return mlRatifyLandDate;
	}

	/**
	 * @mbggenerated 批地日期
	 */
	public void setMlRatifyLandDate(Date mlRatifyLandDate) {
		this.mlRatifyLandDate = mlRatifyLandDate;
	}

	/**
	 * @mbggenerated 入伙时间
	 */
	public Date getMlJoinDate() {
		return mlJoinDate;
	}

	/**
	 * @mbggenerated 入伙时间
	 */
	public void setMlJoinDate(Date mlJoinDate) {
		this.mlJoinDate = mlJoinDate;
	}

	/**
	 * @mbggenerated 使用年限开始日期
	 */
	public Date getMlUseStartDate() {
		return mlUseStartDate;
	}

	/**
	 * @mbggenerated 使用年限开始日期
	 */
	public void setMlUseStartDate(Date mlUseStartDate) {
		this.mlUseStartDate = mlUseStartDate;
	}

	/**
	 * @mbggenerated 使用年限结束日期
	 */
	public Date getMlUserEndDate() {
		return mlUserEndDate;
	}

	/**
	 * @mbggenerated 使用年限结束日期
	 */
	public void setMlUserEndDate(Date mlUserEndDate) {
		this.mlUserEndDate = mlUserEndDate;
	}

	/**
	 * @mbggenerated 车位比
	 */
	public String getMlzsParkingRate() {
		return mlzsParkingRate;
	}

	/**
	 * @mbggenerated 车位比
	 */
	public void setMlzsParkingRate(String mlzsParkingRate) {
		this.mlzsParkingRate = mlzsParkingRate;
	}

	/**
	 * @mbggenerated 竣工日期
	 */
	public Date getMlzsCompletionDate() {
		return mlzsCompletionDate;
	}

	/**
	 * @mbggenerated 竣工日期
	 */
	public void setMlzsCompletionDate(Date mlzsCompletionDate) {
		this.mlzsCompletionDate = mlzsCompletionDate;
	}

	/**
	 * @mbggenerated 地铁数量
	 */
	public String getMlzsSubwabNumber() {
		return mlzsSubwabNumber;
	}

	/**
	 * @mbggenerated 地铁数量
	 */
	public void setMlzsSubwabNumber(String mlzsSubwabNumber) {
		this.mlzsSubwabNumber = mlzsSubwabNumber;
	}

	/**
	 * @mbggenerated 临近主干道
	 */
	public String getMlzsNearbyMainStreet() {
		return mlzsNearbyMainStreet;
	}

	/**
	 * @mbggenerated 临近主干道
	 */
	public void setMlzsNearbyMainStreet(String mlzsNearbyMainStreet) {
		this.mlzsNearbyMainStreet = mlzsNearbyMainStreet;
	}

	/**
	 * @mbggenerated 公交条数
	 */
	public String getMlzsBusNumber() {
		return mlzsBusNumber;
	}

	/**
	 * @mbggenerated 公交条数
	 */
	public void setMlzsBusNumber(String mlzsBusNumber) {
		this.mlzsBusNumber = mlzsBusNumber;
	}

	/**
	 * @mbggenerated 临山
	 */
	public String getMlzsNearbyMountain() {
		return mlzsNearbyMountain;
	}

	/**
	 * @mbggenerated 临山
	 */
	public void setMlzsNearbyMountain(String mlzsNearbyMountain) {
		this.mlzsNearbyMountain = mlzsNearbyMountain;
	}

	/**
	 * @mbggenerated 临海
	 */
	public String getMlzsNearbyRiverOrSea() {
		return mlzsNearbyRiverOrSea;
	}

	/**
	 * @mbggenerated 临海
	 */
	public void setMlzsNearbyRiverOrSea(String mlzsNearbyRiverOrSea) {
		this.mlzsNearbyRiverOrSea = mlzsNearbyRiverOrSea;
	}

	/**
	 * @mbggenerated 是否临近轨道交通（1，是 0 否）
	 */
	public String getMlzsRailTraffic() {
		return mlzsRailTraffic;
	}

	/**
	 * @mbggenerated 是否临近轨道交通（1，是 0 否）
	 */
	public void setMlzsRailTraffic(String mlzsRailTraffic) {
		this.mlzsRailTraffic = mlzsRailTraffic;
	}

	/**
	 * @mbggenerated 三甲医院名称
	 */
	public String getMlzsTopThreeHospitalName() {
		return mlzsTopThreeHospitalName;
	}

	/**
	 * @mbggenerated 三甲医院名称
	 */
	public void setMlzsTopThreeHospitalName(String mlzsTopThreeHospitalName) {
		this.mlzsTopThreeHospitalName = mlzsTopThreeHospitalName;
	}

	/**
	 * @mbggenerated 普通医院名称
	 */
	public String getMlzsGeneralHospitalName() {
		return mlzsGeneralHospitalName;
	}

	/**
	 * @mbggenerated 普通医院名称
	 */
	public void setMlzsGeneralHospitalName(String mlzsGeneralHospitalName) {
		this.mlzsGeneralHospitalName = mlzsGeneralHospitalName;
	}

	/**
	 * @mbggenerated 社康中心名称
	 */
	public String getMlzsSocialHealthCenter() {
		return mlzsSocialHealthCenter;
	}

	/**
	 * @mbggenerated 社康中心名称
	 */
	public void setMlzsSocialHealthCenter(String mlzsSocialHealthCenter) {
		this.mlzsSocialHealthCenter = mlzsSocialHealthCenter;
	}

	/**
	 * @mbggenerated 临近公园
	 */
	public String getMlzsNearbyPark() {
		return mlzsNearbyPark;
	}

	/**
	 * @mbggenerated 临近公园
	 */
	public void setMlzsNearbyPark(String mlzsNearbyPark) {
		this.mlzsNearbyPark = mlzsNearbyPark;
	}

	/**
	 * @mbggenerated 康娱机构数量
	 */
	public String getMlzsHealthRecreationNumber() {
		return mlzsHealthRecreationNumber;
	}

	/**
	 * @mbggenerated 康娱机构数量
	 */
	public void setMlzsHealthRecreationNumber(String mlzsHealthRecreationNumber) {
		this.mlzsHealthRecreationNumber = mlzsHealthRecreationNumber;
	}

	/**
	 * @mbggenerated 临近都市总终合体
	 */
	public String getMlzsNearbyUrbanComplex() {
		return mlzsNearbyUrbanComplex;
	}

	/**
	 * @mbggenerated 临近都市总终合体
	 */
	public void setMlzsNearbyUrbanComplex(String mlzsNearbyUrbanComplex) {
		this.mlzsNearbyUrbanComplex = mlzsNearbyUrbanComplex;
	}

	/**
	 * @mbggenerated 临近区域级终合体
	 */
	public String getMlzsNearbyRegionalComplex() {
		return mlzsNearbyRegionalComplex;
	}

	/**
	 * @mbggenerated 临近区域级终合体
	 */
	public void setMlzsNearbyRegionalComplex(String mlzsNearbyRegionalComplex) {
		this.mlzsNearbyRegionalComplex = mlzsNearbyRegionalComplex;
	}

	/**
	 * @mbggenerated 临近社区总终合体
	 */
	public String getMlzsNearbyCommunityComplex() {
		return mlzsNearbyCommunityComplex;
	}

	/**
	 * @mbggenerated 临近社区总终合体
	 */
	public void setMlzsNearbyCommunityComplex(String mlzsNearbyCommunityComplex) {
		this.mlzsNearbyCommunityComplex = mlzsNearbyCommunityComplex;
	}

	/**
	 * @mbggenerated 区域排名前5小学
	 */
	public String getMlzsTopFiveElementarySchool() {
		return mlzsTopFiveElementarySchool;
	}

	/**
	 * @mbggenerated 区域排名前5小学
	 */
	public void setMlzsTopFiveElementarySchool(String mlzsTopFiveElementarySchool) {
		this.mlzsTopFiveElementarySchool = mlzsTopFiveElementarySchool;
	}

	/**
	 * @mbggenerated 区域排名前5中学
	 */
	public String getMlzsTopFiveMiddleSchool() {
		return mlzsTopFiveMiddleSchool;
	}

	/**
	 * @mbggenerated 区域排名前5中学
	 */
	public void setMlzsTopFiveMiddleSchool(String mlzsTopFiveMiddleSchool) {
		this.mlzsTopFiveMiddleSchool = mlzsTopFiveMiddleSchool;
	}

	/**
	 * @mbggenerated 升级指数赋值
	 */
	public String getMlzsUpgradeIndexAssignment() {
		return mlzsUpgradeIndexAssignment;
	}

	/**
	 * @mbggenerated 升级指数赋值
	 */
	public void setMlzsUpgradeIndexAssignment(String mlzsUpgradeIndexAssignment) {
		this.mlzsUpgradeIndexAssignment = mlzsUpgradeIndexAssignment;
	}

	/**
	 * @mbggenerated 地块编号
	 */
	public String getMlLandNumber() {
		return mlLandNumber;
	}

	/**
	 * @mbggenerated 地块编号
	 */
	public void setMlLandNumber(String mlLandNumber) {
		this.mlLandNumber = mlLandNumber;
	}

	/**
	 * @mbggenerated 美联最高物业费
	 */
	public String getCostStandardA() {
		return costStandardA;
	}

	/**
	 * @mbggenerated 美联最高物业费
	 */
	public void setCostStandardA(String costStandardA) {
		this.costStandardA = costStandardA;
	}

	/**
	 * @mbggenerated 美联第二个所属街道
	 */
	public String getMlBelongToStreetA() {
		return mlBelongToStreetA;
	}

	/**
	 * @mbggenerated 美联第二个所属街道
	 */
	public void setMlBelongToStreetA(String mlBelongToStreetA) {
		this.mlBelongToStreetA = mlBelongToStreetA;
	}

	/**
	 * @mbggenerated -
	 */
	public Double getMetroDistance() {
		return metroDistance;
	}

	/**
	 * @mbggenerated -
	 */
	public void setMetroDistance(Double metroDistance) {
		this.metroDistance = metroDistance;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getLastAveragePrice() {
		return lastAveragePrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLastAveragePrice(BigDecimal lastAveragePrice) {
		this.lastAveragePrice = lastAveragePrice;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getParkingSpace() {
		return parkingSpace;
	}

	/**
	 * @mbggenerated -
	 */
	public void setParkingSpace(Integer parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	/**
	 * @mbggenerated 保存的FUN_STREET街道表信息,多个用逗号分隔开
	 */
	public String getStreetIds() {
		return streetIds;
	}

	/**
	 * @mbggenerated 保存的FUN_STREET街道表信息,多个用逗号分隔开
	 */
	public void setStreetIds(String streetIds) {
		this.streetIds = streetIds;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFfloor() {
		return ffloor;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFfloor(String ffloor) {
		this.ffloor = ffloor;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFstruct() {
		return fstruct;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFstruct(String fstruct) {
		this.fstruct = fstruct;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFequipments() {
		return fequipments;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFequipments(String fequipments) {
		this.fequipments = fequipments;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFtraffic() {
		return ftraffic;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFtraffic(String ftraffic) {
		this.ftraffic = ftraffic;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public String getFinner() {
		return finner;
	}

	/**
	 * @mbggenerated 对接腾讯-
	 */
	public void setFinner(String finner) {
		this.finner = finner;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingInfo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingInfo(Integer shardCityId) {
		super(shardCityId);
	}
}