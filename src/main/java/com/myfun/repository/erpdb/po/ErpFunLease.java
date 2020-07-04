package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.solr.client.solrj.beans.Field;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunLease extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID，自增序列")
	@Field(value = "LEASE_ID")
	private Integer leaseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	@Field(value = "COMP_ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	@Field(value = "CITY_ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司区域ID，From:FUN_REGION")
	@Field(value = "REG_ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分店ID")
	@Field(value = "DEPT_ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	@Field(value = "GR_ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人用户ID，From:FUN_USER")
	@Field(value = "USER_ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人档案ID，与USER_ID对应的ARCHIVE_ID")
	@Field(value = "ARCHIVE_ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记时间")
	@Field(value = "CREATION_TIME")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "原始登记人ID，该ID移交数据时不变，用于经纪人脱离门店版后的数据复制")
	@Field(value = "CREATE_ARCHIVE_ID")
	private Integer createArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统编码")
	@Field(value = "LEASE_NO")
	private String leaseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源标题")
	@Field(value = "LEASE_SUBJECT")
	private String leaseSubject;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房东姓名")
	@Field(value = "LEASE_OWNER")
	private String leaseOwner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手机号码")
	@Field(value = "CELL_PHONE")
	private String cellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房东身份证")
	@Field(value = "ID_CARD")
	private String idCard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	@Field(value = "BUILD_ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘名称")
	@Field(value = "BUILD_NAME")
	private String buildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘检索码")
	@Field(value = "BUILD_CODE")
	private String buildCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区ID")
	@Field(value = "LEASE_REG")
	private Integer leaseReg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区名称")
	@Field(value = "REGION_NAME")
	private String regionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID")
	@Field(value = "SECTION_ID")
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区名称")
	@Field(value = "SECTION_NAME")
	private String sectionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
	@Field(value = "LEASE_ROUND")
	private Byte leaseRound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "商铺地址")
	@Field(value = "TRADE_ADDR")
	private String tradeAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋")
	@Field(value = "LEASE_ROOF")
	private String leaseRoof;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座规则下：单元、号室规则下：号")
	@Field(value = "LEASE_UNIT")
	private String leaseUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼")
	@Field(value = "UNIT_FLOOR")
	private String unitFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座规则下：号、号室规则下：室；商铺用途时为：号位")
	@Field(value = "LEASE_NUM")
	private String leaseNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋(重复)")
	@Field(value = "LEASE_ROOF_R")
	private String leaseRoofR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元(重复)")
	@Field(value = "LEASE_UNIT_R")
	private String leaseUnitR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼(重复)")
	@Field(value = "UNIT_FLOOR_R")
	private String unitFloorR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "号(重复)")
	@Field(value = "LEASE_NUM_R")
	private String leaseNumR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "盘别，DD: PLATE_TYPE")
	@Field(value = "PLATE_TYPE")
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几房")
	@Field(value = "LEASE_ROOM")
	private Byte leaseRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几厅")
	@Field(value = "LEASE_HALL")
	private Byte leaseHall;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几卫")
	@Field(value = "LEASE_WEI")
	private Byte leaseWei;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "阳台")
	@Field(value = "LEASE_YANG")
	private Byte leaseYang;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几梯")
	@Field(value = "LEASE_LADDER")
	private Byte leaseLadder;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几户")
	@Field(value = "LEASE_DOORS")
	private Integer leaseDoors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "类型，DD: HOUSE_TYPE")
	@Field(value = "LEASE_TYPE")
	private Byte leaseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层")
	@Field(value = "LEASE_FLOOR")
	private Short leaseFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总楼层")
	@Field(value = "LEASE_FLOORS")
	private Integer leaseFloors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "装修，DD:HOUSE_FITMENT")
	@Field(value = "LEASE_FITMENT")
	private Byte leaseFitment;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源朝向，DD：HOUSE_DIRECT")
	@Field(value = "LEASE_DIRECT")
	private Byte leaseDirect;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋年代")
	@Field(value = "LEASE_YEAR")
	private Short leaseYear;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋用途，DD:HOUSE_USEAGE")
	@Field(value = "LEASE_USEAGE")
	private Byte leaseUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否邻街，1=是0=否")
	@Field(value = "LEASE_STREET")
	private Boolean leaseStreet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "付款方式，DD:RENT_ACCOUNT")
	@Field(value = "LEASE_ACCOUNT")
	private Integer leaseAccount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租面积")
	@Field(value = "LEASE_AREA")
	private BigDecimal leaseArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金金额")
	@Field(value = "LEASE_TOTAL_PRICE")
	private BigDecimal leaseTotalPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金单位，DD:PRICE_UNIT")
	@Field(value = "PRICE_UNIT")
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金底价")
	@Field(value = "LEASE_LOWEST_PRICE")
	private BigDecimal leaseLowestPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物业费")
	@Field(value = "LEASE_PROPERTY")
	private BigDecimal leaseProperty;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否可分割，1=是0=否")
	@Field(value = "IS_SEPERATOR")
	private Boolean isSeperator;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "商铺用途，DD:SHOP_USAGE")
	@Field(value = "SHOP_USAGE")
	private String shopUsage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主类型，DD: OWNER_TYPE")
	@Field(value = "OWNER_TYPE")
	private Byte ownerType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "写字楼级别，DD:OFFICE_LEVEL")
	@Field(value = "OFFICE_LEVEL")
	private Byte officeLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租房押金")
	@Field(value = "LEASE_DEPOSIT")
	private Integer leaseDeposit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "腾房日")
	@Field(value = "LEASE_LEAVE_TIME")
	private String leaseLeaveTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租房期限，DD:HOUSE_LIMITE")
	@Field(value = "LEASE_LIMITE")
	private Integer leaseLimite;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "厅结构，DD:HALL_STRUCTURE")
	@Field(value = "HALL_STRUCTURE")
	private Byte hallStructure;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地下面积")
	@Field(value = "UG_AREA")
	private BigDecimal ugArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地下类型，DD:UG_TYPE")
	@Field(value = "UG_TYPE")
	private Integer ugType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "花园面积")
	@Field(value = "GARDEN_AREA")
	private BigDecimal gardenArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "车位数量")
	@Field(value = "GARAGE_AMOUNT")
	private Integer garageAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "室内配套，DD:HOUSE_SET")
	@Field(value = "LEASE_SET")
	private String leaseSet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源描述")
	@Field(value = "LEASE_CHARACT")
	private String leaseCharact;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内部备注")
	@Field(value = "LEASE_MEMO")
	private String leaseMemo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "来源，DD:HOUSE_SOURCE")
	@Field(value = "LEASE_SOURCE")
	private Byte leaseSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "级别，DD: HOUSE_LEVEL")
	@Field(value = "LEASE_LEVEL")
	private Byte leaseLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有钥匙，1=是0=否")
	@Field(value = "LEASE_KEY")
	private Boolean leaseKey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙编号")
	@Field(value = "LEASE_KEY_NUM")
	private String leaseKeyNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙日期")
	@Field(value = "KEY_TIME")
	private Date keyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘标志，1=已勘0=未勘")
	@Field(value = "LEASE_EXPLRTH")
	private Boolean leaseExplrth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘日期")
	@Field(value = "EXPLRTH_DATETIME")
	private Date explrthDatetime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托类型，DD: HOUSE_CONSIGN")
	@Field(value = "LEASE_CONSIGN")
	private Integer leaseConsign;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托编号")
	@Field(value = "LEASE_CONSIGN_NO")
	private String leaseConsignNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托时间")
	@Field(value = "WEITUO_TIME")
	private Date weituoTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否合作，1=是0=否 2:投诉下架  不再上架（弃用-2018-05-25-陈文超）")
	@Field(value = "LEASE_COOPERATE")
	private Boolean leaseCooperate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次合作时间")
	@Field(value = "COOPERATE_TIME")
	private Date cooperateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "投诉标记，1=被投诉0未投诉")
	@Field(value = "COMPLAINT_FLAG")
	private Boolean complaintFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否发布到微店，1=是0=否")
	@Field(value = "LEASE_PUBLISH")
	private Boolean leasePublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次发布时间")
	@Field(value = "PUBLISH_TIME")
	private Date publishTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片张数")
	@Field(value = "LEASE_MAP")
	private Integer leaseMap;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次上图时间")
	@Field(value = "PHOTO_TIME")
	private Date photoTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋状态，DD：HOUSE_STATUS")
	@Field(value = "LEASE_STATUS")
	private Integer leaseStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后跟进日期")
	@Field(value = "TRACK_TIME")
	private Date trackTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "批量移交前的跟进时间")
	@Field(value = "TRACK_TIME2")
	private Date trackTime2;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘起始计时时间")
	@Field(value = "ACTION_TIME")
	private Date actionTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否转字搜搜，1=是0=否")
	@Field(value = "FROM_SOSO")
	private Boolean fromSoso;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息重复标记，0=否1=电话重复2=地址重复3=电话地址都重复")
	@Field(value = "REPEAT_FLAG")
	private Integer repeatFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0")
	@Field(value = "INFO_TYPE")
	private Byte infoType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "精英版登记，1=是0=否")
	@Field(value = "SHARE_FLAG")
	private Boolean shareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否共享到好友圈，0：否1：是")
	@Field(value = "FRIEND_HOUSE")
	private Boolean friendHouse;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "红色警示，1=是0=否")
	@Field(value = "RED_FLAG")
	private Boolean redFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "橙色警示，1=是0=否")
	@Field(value = "ORANGE_FLAG")
	private Boolean orangeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转公盘次数，默认=0")
	@Field(value = "PUBLIC_COUNT")
	private Integer publicCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转公盘日期")
	@Field(value = "PUBLIC_TIME")
	private Date publicTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转到期日期")
	@Field(value = "DUE_TIME")
	private Date dueTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转封盘日期")
	@Field(value = "SPECIAL_TIME")
	private Date specialTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转预定日期")
	@Field(value = "SCHEDULE_TIME")
	private Date scheduleTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转成交日期")
	@Field(value = "DEAL_TIME")
	private Date dealTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转注销日期")
	@Field(value = "WRITEOFF_TIME")
	private Date writeoffTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转加密日期")
	@Field(value = "SECRECY_TIME")
	private Date secrecyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转推荐日期")
	@Field(value = "COMMEND_TIME")
	private Date commendTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘时间")
	@Field(value = "PRIVATE_TIME")
	private Date privateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否转自抢盘，1=是0=否")
	@Field(value = "FROM_PUBLIC")
	private Boolean fromPublic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "缩略图文件路径")
	@Field(value = "THUMB_URL")
	private String thumbUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新时间")
	@Field(value = "UPDATE_TIME")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源标签，以”|”分隔")
	@Field(value = "TAG_IDS")
	private String tagIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出证日期")
	@Field(value = "LEASE_CERT_TIME")
	private Date leaseCertTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "各网站的发布状态 腾讯 ― 10进位上 微店 －个进位上，以位表示：1＝否2＝是")
	@Field(value = "PUBLISH_SITES")
	private Integer publishSites;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司大区ID，From:FUN_AREA")
	@Field(value = "AREA_ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋（明文）")
	@Field(value = "LEASE_ROOF_T")
	private String leaseRoofT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房号（明文）")
	@Field(value = "LEASE_NUM_T")
	private String leaseNumT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元（明文）")
	@Field(value = "LEASE_UNIT_T")
	private String leaseUnitT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_RIGHT")
	private Byte leaseRight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频数量，Def:0")
	@Field(value = "VIDEO_NUM")
	private Integer videoNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录人USER_ID")
	@Field(value = "CREATOR_UID")
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1  2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据")
	@Field(value = "IS_IGNORE")
	private Byte isIgnore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "老版center库对应的SALE_ID，Def: 0")
	@Field(value = "LEASE_ID_OLD")
	private Integer leaseIdOld;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "套内面积")
	@Field(value = "LEASE_INNERAREA")
	private BigDecimal leaseInnerarea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0:未议价1:已议价，DEF:0")
	@Field(value = "HOUSE_BARGAIN")
	private Boolean houseBargain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "ENCODE_FLAG")
	private Byte encodeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LOCK")
	private Byte lock;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源 3=正在投诉中")
	@Field(value = "TRUE_FLAG")
	private Byte trueFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否发布上架到腾讯网站，1：是0：否Def:0")
	@Field(value = "SENDTOTENCENT")
	private Byte sendtotencent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源数据是否操作过发发功能1：本地 2：发发关联3：发发转入")
	@Field(value = "HOUSE_SOURCE_WAY")
	private Byte houseSourceWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "U+分享标记 0 未分享 1 已分享")
	@Field(value = "YOU_SHARE_FLAG")
	private Byte youShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "--U+分享时间")
	@Field(value = "YOU_SHARE_TIME")
	private Date youShareTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购买次数")
	@Field(value = "YOU_BUY_COUNT")
	private Integer youBuyCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "所属人性别，1=先生0=女士")
	@Field(value = "OWNER_SEX")
	private Byte ownerSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分享表ID")
	@Field(value = "YOU_SHARE_ID")
	private Integer youShareId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "缩略图版本信息")
	@Field(value = "THUMBPIC_VER")
	private String thumbpicVer;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘用户的USER_ID,用于判断自己的抢盘的数据不能再次抢盘")
	@Field(value = "PRIVATE_USER_ID")
	private Integer privateUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租方式(0整租1合租) DD:LEASE_ROOM_TYPE")
	@Field(value = "LEASE_ROOM_TYPE")
	private Byte leaseRoomType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房间分类()")
	@Field(value = "LEASE_ROOM_CLASSIC")
	private Byte leaseRoomClassic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "FLAT_SHARE_SEX")
	@Field(value = "FLAT_SHARE_SEX")
	private Byte flatShareSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "判重MD5码")
	@Field(value = "ADDR_MD5")
	private String addrMd5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR图片数量")
	@Field(value = "PANORAMA_MAP")
	private Integer panoramaMap;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "移动端用于统计指定界面登记操作的优家数据，1：来自优家分享界面登记的优家数据-陈文超")
	@Field(value = "YOUJIA_STATISTIC_FLAG")
	private Byte youjiaStatisticFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "广告房源标记")
	@Field(value = "ADS_FLAG")
	private Byte adsFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "同步时间，第三方同步接口的同步时间")
	@Field(value = "SYNC_TIME")
	private Date syncTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频审核标记 0 未审核 1 审核通过 2 审核失败")
	@Field(value = "VIDEO_REVIEW_FLAG")
	private Byte videoReviewFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR显示标记 0 不显示 1 显示")
	@Field(value = "HAS_PANORAMA")
	private Byte hasPanorama;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "BIDDING_FLAG")
	private Boolean biddingFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源竞价结束时间")
	@Field(value = "COMPETE_END_TIME")
	private Date competeEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源竞价价格")
	@Field(value = "COMPETE_PRICE")
	private BigDecimal competePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=已获取分享费，2=已退还分享费，3=已完成、不再退或给分享费")
	@Field(value = "YOU_SHARE_MONEY_STATE")
	private Byte youShareMoneyState;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否发布微店")
	@Field(value = "SENDTO_WEIDIAN")
	private Byte sendtoWeidian;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否发布优优")
	@Field(value = "SENDTO_YOUYOU")
	private Byte sendtoYouyou;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优优排除成交的推荐数据，0：未成交、1：成交 - 陈文超-2016-10-01")
	@Field(value = "YOUYOU_DEAL")
	private Byte youyouDeal;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "封盘保护结束时间")
	@Field(value = "SPECIAL_END_TIME")
	private Date specialEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "预订保护结束时间")
	@Field(value = "SCHEDULE_END_TIME")
	private Date scheduleEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托书地址")
	@Field(value = "PROXY_URL")
	private String proxyUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传委托书的人")
	@Field(value = "UPLOAD_PROXY_USER")
	private String uploadProxyUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费")
	@Field(value = "CITY_SHARE_FLAG")
	private Byte cityShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "品牌中介公司ID")
	@Field(value = "BRAND_COMP_ID")
	private Integer brandCompId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "核验编码")
	@Field(value = "CHECK_CODE_FUN")
	private String checkCodeFun;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权证类型 DD:OWNERSHIP_TYPE")
	@Field(value = "OWNERSHIP_TYPE")
	private Byte ownershipType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源有效期")
	@Field(value = "EFFECTIVE_DATE")
	private Date effectiveDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权编号")
	@Field(value = "QZ_CODE_FUN")
	private String qzCodeFun;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "--房管局状态 DD:FUNMANAGER_SALESTATUS")
	@Field(value = "FUNMANAGER_SALESTATUS")
	private Byte funmanagerSalestatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次房堪标记-0代表没有房堪过1，代表已房堪过，已废弃，使用LEASE_EXPLRTH字段")
	@Field(value = "HAS_FUNKAN")
	private Byte hasFunkan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人电话")
	@Field(value = "JOINT_CELL_PHONE")
	private String jointCellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人姓名")
	@Field(value = "JOINT_USER_NAME")
	private String jointUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人性别")
	@Field(value = "JOINT_USER_SEX")
	private Byte jointUserSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共有人身份证号")
	@Field(value = "JOINT_ID_CARD")
	private String jointIdCard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "暂缓保护到期时间")
	@Field(value = "RESPITE_END_TIME")
	private Date respiteEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "可租售ID，和FUN_SLAE对应，只会一对一")
	@Field(value = "SALE_LEASE_ID")
	private Integer saleLeaseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是租售房源，1=是，默认=0=否")
	@Field(value = "IS_SALE_LEASE")
	private Byte isSaleLease;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托截止日期")
	@Field(value = "ENTRUST_END_TIME")
	private Date entrustEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "ENTRUST_CREATE_USER")
	private Integer entrustCreateUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "初始为登记时间，转有效之后为转有效的时间，主要用于房客源列表排序")
	@Field(value = "AVAILABLE_TIME")
	private Date availableTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "调价截止展示时间")
	@Field(value = "MODIFY_PRICE_END")
	private Date modifyPriceEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "调价走势，1=上涨 2=下降")
	@Field(value = "MODIFY_PRICE_TREND")
	private Byte modifyPriceTrend;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "	房堪时间，最近带看时间，带看跟进写成功之后，需更新该字段")
	@Field(value = "LAST_DKAN_TIME")
	private Date lastDkanTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "老的真房源标签")
	@Field(value = "OLD_TRUE_FLAG")
	private Byte oldTrueFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源公司内部编号")
	@Field(value = "INNER_NO")
	private Integer innerNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(共有人证件类型)")
	@Field(value = "JOINT_ID_CARD_TYPE")
	private Integer jointIdCardType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(证件类型)")
	@Field(value = "ID_CARD_TYPE")
	private Integer idCardType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租房性质 DD:OFFICE_CHARACTER")
	@Field(value = "OFFICE_CHARACTER")
	private Byte officeCharacter;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否含税")
	@Field(value = "OFFICE_TAX")
	private Boolean officeTax;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开间")
	@Field(value = "LEASE_BAY")
	private BigDecimal leaseBay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "进深")
	@Field(value = "LEASE_DEPTH")
	private BigDecimal leaseDepth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "层高")
	@Field(value = "LEASE_STOREY")
	private BigDecimal leaseStorey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "CHECK_TIME")
	private String checkTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转聚焦日期")
	@Field(value = "FOCUS_TIME")
	private Date focusTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户成级")
	@Field(value = "USER_LEVEL")
	private Integer userLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织架构线")
	@Field(value = "TISSUE_LINE")
	private String tissueLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID-关联加盟商表：直营的组织机构为：-1、总部为：0、加盟商的ID > 0")
	@Field(value = "PARTNER_ID")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房堪人USER_ID")
	@Field(value = "FUNKAN_USER_ID")
	private Integer funkanUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙提交人USER_ID")
	@Field(value = "LEASE_KEY_USER_ID")
	private Integer leaseKeyUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案编码")
	@Field(value = "FILE_CODING")
	private String fileCoding;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租方 1：业主，2：包租方，3：转租方")
	@Field(value = "LESSOR")
	private Byte lessor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转让费")
	@Field(value = "TRANSFER_FEE")
	private BigDecimal transferFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "回报率")
	@Field(value = "RETURN_RATE")
	private BigDecimal returnRate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "包租方组织机构")
	@Field(value = "ML_RESERVED_COMP")
	private String mlReservedComp;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源是否需要审核 0=正常登中记 1=审核中 2=审核不通过 3=申诉")
	@Field(value = "HOUSE_VERIFY")
	private Byte houseVerify;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "厨房数量")
	@Field(value = "KITCHEN")
	private Byte kitchen;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联 是否是整层1=是")
	@Field(value = "ML_WHOLE_LAYER")
	private Byte mlWholeLayer;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "ORGANIZATION_ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权性质 DD:HOUSE_NATURE")
	@Field(value = "LEASE_NATURE")
	private Byte leaseNature;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_STRUCT")
	private Byte leaseStruct;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_EXPIRATION_TIME")
	private Date leaseExpirationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "HOUSE_SITUATION")
	private Byte houseSituation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "CURRENT_RENT")
	private BigDecimal currentRent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "TRANSACTION_STATUS")
	private Byte transactionStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_UNIT_PRICE")
	private BigDecimal leaseUnitPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "HAS_RECORDED")
	private Byte hasRecorded;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_ENTRUST_PRICE")
	private BigDecimal leaseEntrustPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "HAS_ENTRUST")
	private Byte hasEntrust;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "OFFEREE_TIME")
	private Date offereeTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "LEASE_AMOUNT_CHANGE_TIME")
	private Date leaseAmountChangeTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于楼盘名称,楼盘地址,房源标题,房源描述,配套设施 模糊查询")
	@Field(value = "FUZZY_SEARCH")
	private String fuzzySearch;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 房源ID，自增序列
	 */
	public Integer getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated 房源ID，自增序列
	 */
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
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
	 * @mbggenerated 公司区域ID，From:FUN_REGION
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 公司区域ID，From:FUN_REGION
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 经纪人用户ID，From:FUN_USER
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人用户ID，From:FUN_USER
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 经纪人档案ID，与USER_ID对应的ARCHIVE_ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 经纪人档案ID，与USER_ID对应的ARCHIVE_ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 登记时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 登记时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 原始登记人ID，该ID移交数据时不变，用于经纪人脱离门店版后的数据复制
	 */
	public Integer getCreateArchiveId() {
		return createArchiveId;
	}

	/**
	 * @mbggenerated 原始登记人ID，该ID移交数据时不变，用于经纪人脱离门店版后的数据复制
	 */
	public void setCreateArchiveId(Integer createArchiveId) {
		this.createArchiveId = createArchiveId;
	}

	/**
	 * @mbggenerated 系统编码
	 */
	public String getLeaseNo() {
		return leaseNo;
	}

	/**
	 * @mbggenerated 系统编码
	 */
	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}

	/**
	 * @mbggenerated 房源标题
	 */
	public String getLeaseSubject() {
		return leaseSubject;
	}

	/**
	 * @mbggenerated 房源标题
	 */
	public void setLeaseSubject(String leaseSubject) {
		this.leaseSubject = leaseSubject;
	}

	/**
	 * @mbggenerated 房东姓名
	 */
	public String getLeaseOwner() {
		return leaseOwner;
	}

	/**
	 * @mbggenerated 房东姓名
	 */
	public void setLeaseOwner(String leaseOwner) {
		this.leaseOwner = leaseOwner;
	}

	/**
	 * @mbggenerated 手机号码
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @mbggenerated 手机号码
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @mbggenerated 房东身份证
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @mbggenerated 房东身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	 * @mbggenerated 楼盘检索码
	 */
	public String getBuildCode() {
		return buildCode;
	}

	/**
	 * @mbggenerated 楼盘检索码
	 */
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	/**
	 * @mbggenerated 行政区ID
	 */
	public Integer getLeaseReg() {
		return leaseReg;
	}

	/**
	 * @mbggenerated 行政区ID
	 */
	public void setLeaseReg(Integer leaseReg) {
		this.leaseReg = leaseReg;
	}

	/**
	 * @mbggenerated 行政区名称
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @mbggenerated 行政区名称
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
	 * @mbggenerated 片区名称
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @mbggenerated 片区名称
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public Byte getLeaseRound() {
		return leaseRound;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public void setLeaseRound(Byte leaseRound) {
		this.leaseRound = leaseRound;
	}

	/**
	 * @mbggenerated 商铺地址
	 */
	public String getTradeAddr() {
		return tradeAddr;
	}

	/**
	 * @mbggenerated 商铺地址
	 */
	public void setTradeAddr(String tradeAddr) {
		this.tradeAddr = tradeAddr;
	}

	/**
	 * @mbggenerated 栋
	 */
	public String getLeaseRoof() {
		return leaseRoof;
	}

	/**
	 * @mbggenerated 栋
	 */
	public void setLeaseRoof(String leaseRoof) {
		this.leaseRoof = leaseRoof;
	}

	/**
	 * @mbggenerated 栋座规则下：单元、号室规则下：号
	 */
	public String getLeaseUnit() {
		return leaseUnit;
	}

	/**
	 * @mbggenerated 栋座规则下：单元、号室规则下：号
	 */
	public void setLeaseUnit(String leaseUnit) {
		this.leaseUnit = leaseUnit;
	}

	/**
	 * @mbggenerated 楼
	 */
	public String getUnitFloor() {
		return unitFloor;
	}

	/**
	 * @mbggenerated 楼
	 */
	public void setUnitFloor(String unitFloor) {
		this.unitFloor = unitFloor;
	}

	/**
	 * @mbggenerated 栋座规则下：号、号室规则下：室；商铺用途时为：号位
	 */
	public String getLeaseNum() {
		return leaseNum;
	}

	/**
	 * @mbggenerated 栋座规则下：号、号室规则下：室；商铺用途时为：号位
	 */
	public void setLeaseNum(String leaseNum) {
		this.leaseNum = leaseNum;
	}

	/**
	 * @mbggenerated 栋(重复)
	 */
	public String getLeaseRoofR() {
		return leaseRoofR;
	}

	/**
	 * @mbggenerated 栋(重复)
	 */
	public void setLeaseRoofR(String leaseRoofR) {
		this.leaseRoofR = leaseRoofR;
	}

	/**
	 * @mbggenerated 单元(重复)
	 */
	public String getLeaseUnitR() {
		return leaseUnitR;
	}

	/**
	 * @mbggenerated 单元(重复)
	 */
	public void setLeaseUnitR(String leaseUnitR) {
		this.leaseUnitR = leaseUnitR;
	}

	/**
	 * @mbggenerated 楼(重复)
	 */
	public String getUnitFloorR() {
		return unitFloorR;
	}

	/**
	 * @mbggenerated 楼(重复)
	 */
	public void setUnitFloorR(String unitFloorR) {
		this.unitFloorR = unitFloorR;
	}

	/**
	 * @mbggenerated 号(重复)
	 */
	public String getLeaseNumR() {
		return leaseNumR;
	}

	/**
	 * @mbggenerated 号(重复)
	 */
	public void setLeaseNumR(String leaseNumR) {
		this.leaseNumR = leaseNumR;
	}

	/**
	 * @mbggenerated 盘别，DD: PLATE_TYPE
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated 盘别，DD: PLATE_TYPE
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	/**
	 * @mbggenerated 几房
	 */
	public Byte getLeaseRoom() {
		return leaseRoom;
	}

	/**
	 * @mbggenerated 几房
	 */
	public void setLeaseRoom(Byte leaseRoom) {
		this.leaseRoom = leaseRoom;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public Byte getLeaseHall() {
		return leaseHall;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public void setLeaseHall(Byte leaseHall) {
		this.leaseHall = leaseHall;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public Byte getLeaseWei() {
		return leaseWei;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public void setLeaseWei(Byte leaseWei) {
		this.leaseWei = leaseWei;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public Byte getLeaseYang() {
		return leaseYang;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public void setLeaseYang(Byte leaseYang) {
		this.leaseYang = leaseYang;
	}

	/**
	 * @mbggenerated 几梯
	 */
	public Byte getLeaseLadder() {
		return leaseLadder;
	}

	/**
	 * @mbggenerated 几梯
	 */
	public void setLeaseLadder(Byte leaseLadder) {
		this.leaseLadder = leaseLadder;
	}

	/**
	 * @mbggenerated 几户
	 */
	public Integer getLeaseDoors() {
		return leaseDoors;
	}

	/**
	 * @mbggenerated 几户
	 */
	public void setLeaseDoors(Integer leaseDoors) {
		this.leaseDoors = leaseDoors;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public Byte getLeaseType() {
		return leaseType;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public void setLeaseType(Byte leaseType) {
		this.leaseType = leaseType;
	}

	/**
	 * @mbggenerated 楼层
	 */
	public Short getLeaseFloor() {
		return leaseFloor;
	}

	/**
	 * @mbggenerated 楼层
	 */
	public void setLeaseFloor(Short leaseFloor) {
		this.leaseFloor = leaseFloor;
	}

	/**
	 * @mbggenerated 总楼层
	 */
	public Integer getLeaseFloors() {
		return leaseFloors;
	}

	/**
	 * @mbggenerated 总楼层
	 */
	public void setLeaseFloors(Integer leaseFloors) {
		this.leaseFloors = leaseFloors;
	}

	/**
	 * @mbggenerated 装修，DD:HOUSE_FITMENT
	 */
	public Byte getLeaseFitment() {
		return leaseFitment;
	}

	/**
	 * @mbggenerated 装修，DD:HOUSE_FITMENT
	 */
	public void setLeaseFitment(Byte leaseFitment) {
		this.leaseFitment = leaseFitment;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public Byte getLeaseDirect() {
		return leaseDirect;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public void setLeaseDirect(Byte leaseDirect) {
		this.leaseDirect = leaseDirect;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public Short getLeaseYear() {
		return leaseYear;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public void setLeaseYear(Short leaseYear) {
		this.leaseYear = leaseYear;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public Byte getLeaseUseage() {
		return leaseUseage;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public void setLeaseUseage(Byte leaseUseage) {
		this.leaseUseage = leaseUseage;
	}

	/**
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public Boolean getLeaseStreet() {
		return leaseStreet;
	}

	/**
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public void setLeaseStreet(Boolean leaseStreet) {
		this.leaseStreet = leaseStreet;
	}

	/**
	 * @mbggenerated 付款方式，DD:RENT_ACCOUNT
	 */
	public Integer getLeaseAccount() {
		return leaseAccount;
	}

	/**
	 * @mbggenerated 付款方式，DD:RENT_ACCOUNT
	 */
	public void setLeaseAccount(Integer leaseAccount) {
		this.leaseAccount = leaseAccount;
	}

	/**
	 * @mbggenerated 出租面积
	 */
	public BigDecimal getLeaseArea() {
		return leaseArea;
	}

	/**
	 * @mbggenerated 出租面积
	 */
	public void setLeaseArea(BigDecimal leaseArea) {
		this.leaseArea = leaseArea;
	}

	/**
	 * @mbggenerated 租金金额
	 */
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金金额
	 */
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金单位，DD:PRICE_UNIT
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated 租金单位，DD:PRICE_UNIT
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated 租金底价
	 */
	public BigDecimal getLeaseLowestPrice() {
		return leaseLowestPrice;
	}

	/**
	 * @mbggenerated 租金底价
	 */
	public void setLeaseLowestPrice(BigDecimal leaseLowestPrice) {
		this.leaseLowestPrice = leaseLowestPrice;
	}

	/**
	 * @mbggenerated 物业费
	 */
	public BigDecimal getLeaseProperty() {
		return leaseProperty;
	}

	/**
	 * @mbggenerated 物业费
	 */
	public void setLeaseProperty(BigDecimal leaseProperty) {
		this.leaseProperty = leaseProperty;
	}

	/**
	 * @mbggenerated 是否可分割，1=是0=否
	 */
	public Boolean getIsSeperator() {
		return isSeperator;
	}

	/**
	 * @mbggenerated 是否可分割，1=是0=否
	 */
	public void setIsSeperator(Boolean isSeperator) {
		this.isSeperator = isSeperator;
	}

	/**
	 * @mbggenerated 商铺用途，DD:SHOP_USAGE
	 */
	public String getShopUsage() {
		return shopUsage;
	}

	/**
	 * @mbggenerated 商铺用途，DD:SHOP_USAGE
	 */
	public void setShopUsage(String shopUsage) {
		this.shopUsage = shopUsage;
	}

	/**
	 * @mbggenerated 业主类型，DD: OWNER_TYPE
	 */
	public Byte getOwnerType() {
		return ownerType;
	}

	/**
	 * @mbggenerated 业主类型，DD: OWNER_TYPE
	 */
	public void setOwnerType(Byte ownerType) {
		this.ownerType = ownerType;
	}

	/**
	 * @mbggenerated 写字楼级别，DD:OFFICE_LEVEL
	 */
	public Byte getOfficeLevel() {
		return officeLevel;
	}

	/**
	 * @mbggenerated 写字楼级别，DD:OFFICE_LEVEL
	 */
	public void setOfficeLevel(Byte officeLevel) {
		this.officeLevel = officeLevel;
	}

	/**
	 * @mbggenerated 租房押金
	 */
	public Integer getLeaseDeposit() {
		return leaseDeposit;
	}

	/**
	 * @mbggenerated 租房押金
	 */
	public void setLeaseDeposit(Integer leaseDeposit) {
		this.leaseDeposit = leaseDeposit;
	}

	/**
	 * @mbggenerated 腾房日
	 */
	public String getLeaseLeaveTime() {
		return leaseLeaveTime;
	}

	/**
	 * @mbggenerated 腾房日
	 */
	public void setLeaseLeaveTime(String leaseLeaveTime) {
		this.leaseLeaveTime = leaseLeaveTime;
	}

	/**
	 * @mbggenerated 租房期限，DD:HOUSE_LIMITE
	 */
	public Integer getLeaseLimite() {
		return leaseLimite;
	}

	/**
	 * @mbggenerated 租房期限，DD:HOUSE_LIMITE
	 */
	public void setLeaseLimite(Integer leaseLimite) {
		this.leaseLimite = leaseLimite;
	}

	/**
	 * @mbggenerated 厅结构，DD:HALL_STRUCTURE
	 */
	public Byte getHallStructure() {
		return hallStructure;
	}

	/**
	 * @mbggenerated 厅结构，DD:HALL_STRUCTURE
	 */
	public void setHallStructure(Byte hallStructure) {
		this.hallStructure = hallStructure;
	}

	/**
	 * @mbggenerated 地下面积
	 */
	public BigDecimal getUgArea() {
		return ugArea;
	}

	/**
	 * @mbggenerated 地下面积
	 */
	public void setUgArea(BigDecimal ugArea) {
		this.ugArea = ugArea;
	}

	/**
	 * @mbggenerated 地下类型，DD:UG_TYPE
	 */
	public Integer getUgType() {
		return ugType;
	}

	/**
	 * @mbggenerated 地下类型，DD:UG_TYPE
	 */
	public void setUgType(Integer ugType) {
		this.ugType = ugType;
	}

	/**
	 * @mbggenerated 花园面积
	 */
	public BigDecimal getGardenArea() {
		return gardenArea;
	}

	/**
	 * @mbggenerated 花园面积
	 */
	public void setGardenArea(BigDecimal gardenArea) {
		this.gardenArea = gardenArea;
	}

	/**
	 * @mbggenerated 车位数量
	 */
	public Integer getGarageAmount() {
		return garageAmount;
	}

	/**
	 * @mbggenerated 车位数量
	 */
	public void setGarageAmount(Integer garageAmount) {
		this.garageAmount = garageAmount;
	}

	/**
	 * @mbggenerated 室内配套，DD:HOUSE_SET
	 */
	public String getLeaseSet() {
		return leaseSet;
	}

	/**
	 * @mbggenerated 室内配套，DD:HOUSE_SET
	 */
	public void setLeaseSet(String leaseSet) {
		this.leaseSet = leaseSet;
	}

	/**
	 * @mbggenerated 房源描述
	 */
	public String getLeaseCharact() {
		return leaseCharact;
	}

	/**
	 * @mbggenerated 房源描述
	 */
	public void setLeaseCharact(String leaseCharact) {
		this.leaseCharact = leaseCharact;
	}

	/**
	 * @mbggenerated 内部备注
	 */
	public String getLeaseMemo() {
		return leaseMemo;
	}

	/**
	 * @mbggenerated 内部备注
	 */
	public void setLeaseMemo(String leaseMemo) {
		this.leaseMemo = leaseMemo;
	}

	/**
	 * @mbggenerated 来源，DD:HOUSE_SOURCE
	 */
	public Byte getLeaseSource() {
		return leaseSource;
	}

	/**
	 * @mbggenerated 来源，DD:HOUSE_SOURCE
	 */
	public void setLeaseSource(Byte leaseSource) {
		this.leaseSource = leaseSource;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public Byte getLeaseLevel() {
		return leaseLevel;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public void setLeaseLevel(Byte leaseLevel) {
		this.leaseLevel = leaseLevel;
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public Boolean getLeaseKey() {
		return leaseKey;
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public void setLeaseKey(Boolean leaseKey) {
		this.leaseKey = leaseKey;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public String getLeaseKeyNum() {
		return leaseKeyNum;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public void setLeaseKeyNum(String leaseKeyNum) {
		this.leaseKeyNum = leaseKeyNum;
	}

	/**
	 * @mbggenerated 钥匙日期
	 */
	public Date getKeyTime() {
		return keyTime;
	}

	/**
	 * @mbggenerated 钥匙日期
	 */
	public void setKeyTime(Date keyTime) {
		this.keyTime = keyTime;
	}

	/**
	 * @mbggenerated 房勘标志，1=已勘0=未勘
	 */
	public Boolean getLeaseExplrth() {
		return leaseExplrth;
	}

	/**
	 * @mbggenerated 房勘标志，1=已勘0=未勘
	 */
	public void setLeaseExplrth(Boolean leaseExplrth) {
		this.leaseExplrth = leaseExplrth;
	}

	/**
	 * @mbggenerated 房勘日期
	 */
	public Date getExplrthDatetime() {
		return explrthDatetime;
	}

	/**
	 * @mbggenerated 房勘日期
	 */
	public void setExplrthDatetime(Date explrthDatetime) {
		this.explrthDatetime = explrthDatetime;
	}

	/**
	 * @mbggenerated 委托类型，DD: HOUSE_CONSIGN
	 */
	public Integer getLeaseConsign() {
		return leaseConsign;
	}

	/**
	 * @mbggenerated 委托类型，DD: HOUSE_CONSIGN
	 */
	public void setLeaseConsign(Integer leaseConsign) {
		this.leaseConsign = leaseConsign;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public String getLeaseConsignNo() {
		return leaseConsignNo;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public void setLeaseConsignNo(String leaseConsignNo) {
		this.leaseConsignNo = leaseConsignNo;
	}

	/**
	 * @mbggenerated 委托时间
	 */
	public Date getWeituoTime() {
		return weituoTime;
	}

	/**
	 * @mbggenerated 委托时间
	 */
	public void setWeituoTime(Date weituoTime) {
		this.weituoTime = weituoTime;
	}

	/**
	 * @mbggenerated 是否合作，1=是0=否 2:投诉下架  不再上架（弃用-2018-05-25-陈文超）
	 */
	public Boolean getLeaseCooperate() {
		return leaseCooperate;
	}

	/**
	 * @mbggenerated 是否合作，1=是0=否 2:投诉下架  不再上架（弃用-2018-05-25-陈文超）
	 */
	public void setLeaseCooperate(Boolean leaseCooperate) {
		this.leaseCooperate = leaseCooperate;
	}

	/**
	 * @mbggenerated 首次合作时间
	 */
	public Date getCooperateTime() {
		return cooperateTime;
	}

	/**
	 * @mbggenerated 首次合作时间
	 */
	public void setCooperateTime(Date cooperateTime) {
		this.cooperateTime = cooperateTime;
	}

	/**
	 * @mbggenerated 投诉标记，1=被投诉0未投诉
	 */
	public Boolean getComplaintFlag() {
		return complaintFlag;
	}

	/**
	 * @mbggenerated 投诉标记，1=被投诉0未投诉
	 */
	public void setComplaintFlag(Boolean complaintFlag) {
		this.complaintFlag = complaintFlag;
	}

	/**
	 * @mbggenerated 是否发布到微店，1=是0=否
	 */
	public Boolean getLeasePublish() {
		return leasePublish;
	}

	/**
	 * @mbggenerated 是否发布到微店，1=是0=否
	 */
	public void setLeasePublish(Boolean leasePublish) {
		this.leasePublish = leasePublish;
	}

	/**
	 * @mbggenerated 首次发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @mbggenerated 首次发布时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @mbggenerated 图片张数
	 */
	public Integer getLeaseMap() {
		return leaseMap;
	}

	/**
	 * @mbggenerated 图片张数
	 */
	public void setLeaseMap(Integer leaseMap) {
		this.leaseMap = leaseMap;
	}

	/**
	 * @mbggenerated 首次上图时间
	 */
	public Date getPhotoTime() {
		return photoTime;
	}

	/**
	 * @mbggenerated 首次上图时间
	 */
	public void setPhotoTime(Date photoTime) {
		this.photoTime = photoTime;
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public Integer getLeaseStatus() {
		return leaseStatus;
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public void setLeaseStatus(Integer leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	/**
	 * @mbggenerated 最后跟进日期
	 */
	public Date getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated 最后跟进日期
	 */
	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @mbggenerated 批量移交前的跟进时间
	 */
	public Date getTrackTime2() {
		return trackTime2;
	}

	/**
	 * @mbggenerated 批量移交前的跟进时间
	 */
	public void setTrackTime2(Date trackTime2) {
		this.trackTime2 = trackTime2;
	}

	/**
	 * @mbggenerated 房勘起始计时时间
	 */
	public Date getActionTime() {
		return actionTime;
	}

	/**
	 * @mbggenerated 房勘起始计时时间
	 */
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	/**
	 * @mbggenerated 是否转字搜搜，1=是0=否
	 */
	public Boolean getFromSoso() {
		return fromSoso;
	}

	/**
	 * @mbggenerated 是否转字搜搜，1=是0=否
	 */
	public void setFromSoso(Boolean fromSoso) {
		this.fromSoso = fromSoso;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否1=电话重复2=地址重复3=电话地址都重复
	 */
	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否1=电话重复2=地址重复3=电话地址都重复
	 */
	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated 房源类型（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0
	 */
	public Byte getInfoType() {
		return infoType;
	}

	/**
	 * @mbggenerated 房源类型（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0
	 */
	public void setInfoType(Byte infoType) {
		this.infoType = infoType;
	}

	/**
	 * @mbggenerated 精英版登记，1=是0=否
	 */
	public Boolean getShareFlag() {
		return shareFlag;
	}

	/**
	 * @mbggenerated 精英版登记，1=是0=否
	 */
	public void setShareFlag(Boolean shareFlag) {
		this.shareFlag = shareFlag;
	}

	/**
	 * @mbggenerated 是否共享到好友圈，0：否1：是
	 */
	public Boolean getFriendHouse() {
		return friendHouse;
	}

	/**
	 * @mbggenerated 是否共享到好友圈，0：否1：是
	 */
	public void setFriendHouse(Boolean friendHouse) {
		this.friendHouse = friendHouse;
	}

	/**
	 * @mbggenerated 红色警示，1=是0=否
	 */
	public Boolean getRedFlag() {
		return redFlag;
	}

	/**
	 * @mbggenerated 红色警示，1=是0=否
	 */
	public void setRedFlag(Boolean redFlag) {
		this.redFlag = redFlag;
	}

	/**
	 * @mbggenerated 橙色警示，1=是0=否
	 */
	public Boolean getOrangeFlag() {
		return orangeFlag;
	}

	/**
	 * @mbggenerated 橙色警示，1=是0=否
	 */
	public void setOrangeFlag(Boolean orangeFlag) {
		this.orangeFlag = orangeFlag;
	}

	/**
	 * @mbggenerated 转公盘次数，默认=0
	 */
	public Integer getPublicCount() {
		return publicCount;
	}

	/**
	 * @mbggenerated 转公盘次数，默认=0
	 */
	public void setPublicCount(Integer publicCount) {
		this.publicCount = publicCount;
	}

	/**
	 * @mbggenerated 转公盘日期
	 */
	public Date getPublicTime() {
		return publicTime;
	}

	/**
	 * @mbggenerated 转公盘日期
	 */
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}

	/**
	 * @mbggenerated 转到期日期
	 */
	public Date getDueTime() {
		return dueTime;
	}

	/**
	 * @mbggenerated 转到期日期
	 */
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	/**
	 * @mbggenerated 转封盘日期
	 */
	public Date getSpecialTime() {
		return specialTime;
	}

	/**
	 * @mbggenerated 转封盘日期
	 */
	public void setSpecialTime(Date specialTime) {
		this.specialTime = specialTime;
	}

	/**
	 * @mbggenerated 转预定日期
	 */
	public Date getScheduleTime() {
		return scheduleTime;
	}

	/**
	 * @mbggenerated 转预定日期
	 */
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	/**
	 * @mbggenerated 转成交日期
	 */
	public Date getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated 转成交日期
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @mbggenerated 转注销日期
	 */
	public Date getWriteoffTime() {
		return writeoffTime;
	}

	/**
	 * @mbggenerated 转注销日期
	 */
	public void setWriteoffTime(Date writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	/**
	 * @mbggenerated 转加密日期
	 */
	public Date getSecrecyTime() {
		return secrecyTime;
	}

	/**
	 * @mbggenerated 转加密日期
	 */
	public void setSecrecyTime(Date secrecyTime) {
		this.secrecyTime = secrecyTime;
	}

	/**
	 * @mbggenerated 转推荐日期
	 */
	public Date getCommendTime() {
		return commendTime;
	}

	/**
	 * @mbggenerated 转推荐日期
	 */
	public void setCommendTime(Date commendTime) {
		this.commendTime = commendTime;
	}

	/**
	 * @mbggenerated 转抢盘时间
	 */
	public Date getPrivateTime() {
		return privateTime;
	}

	/**
	 * @mbggenerated 转抢盘时间
	 */
	public void setPrivateTime(Date privateTime) {
		this.privateTime = privateTime;
	}

	/**
	 * @mbggenerated 是否转自抢盘，1=是0=否
	 */
	public Boolean getFromPublic() {
		return fromPublic;
	}

	/**
	 * @mbggenerated 是否转自抢盘，1=是0=否
	 */
	public void setFromPublic(Boolean fromPublic) {
		this.fromPublic = fromPublic;
	}

	/**
	 * @mbggenerated 缩略图文件路径
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}

	/**
	 * @mbggenerated 缩略图文件路径
	 */
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 房源标签，以”|”分隔
	 */
	public String getTagIds() {
		return tagIds;
	}

	/**
	 * @mbggenerated 房源标签，以”|”分隔
	 */
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	/**
	 * @mbggenerated 出证日期
	 */
	public Date getLeaseCertTime() {
		return leaseCertTime;
	}

	/**
	 * @mbggenerated 出证日期
	 */
	public void setLeaseCertTime(Date leaseCertTime) {
		this.leaseCertTime = leaseCertTime;
	}

	/**
	 * @mbggenerated 各网站的发布状态 腾讯 ― 10进位上 微店 －个进位上，以位表示：1＝否2＝是
	 */
	public Integer getPublishSites() {
		return publishSites;
	}

	/**
	 * @mbggenerated 各网站的发布状态 腾讯 ― 10进位上 微店 －个进位上，以位表示：1＝否2＝是
	 */
	public void setPublishSites(Integer publishSites) {
		this.publishSites = publishSites;
	}

	/**
	 * @mbggenerated 公司大区ID，From:FUN_AREA
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 公司大区ID，From:FUN_AREA
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 栋（明文）
	 */
	public String getLeaseRoofT() {
		return leaseRoofT;
	}

	/**
	 * @mbggenerated 栋（明文）
	 */
	public void setLeaseRoofT(String leaseRoofT) {
		this.leaseRoofT = leaseRoofT;
	}

	/**
	 * @mbggenerated 房号（明文）
	 */
	public String getLeaseNumT() {
		return leaseNumT;
	}

	/**
	 * @mbggenerated 房号（明文）
	 */
	public void setLeaseNumT(String leaseNumT) {
		this.leaseNumT = leaseNumT;
	}

	/**
	 * @mbggenerated 单元（明文）
	 */
	public String getLeaseUnitT() {
		return leaseUnitT;
	}

	/**
	 * @mbggenerated 单元（明文）
	 */
	public void setLeaseUnitT(String leaseUnitT) {
		this.leaseUnitT = leaseUnitT;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getLeaseRight() {
		return leaseRight;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseRight(Byte leaseRight) {
		this.leaseRight = leaseRight;
	}

	/**
	 * @mbggenerated 视频数量，Def:0
	 */
	public Integer getVideoNum() {
		return videoNum;
	}

	/**
	 * @mbggenerated 视频数量，Def:0
	 */
	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}

	/**
	 * @mbggenerated 登录人USER_ID
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated 登录人USER_ID
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1  2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据
	 */
	public Byte getIsIgnore() {
		return isIgnore;
	}

	/**
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1  2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据
	 */
	public void setIsIgnore(Byte isIgnore) {
		this.isIgnore = isIgnore;
	}

	/**
	 * @mbggenerated 老版center库对应的SALE_ID，Def: 0
	 */
	public Integer getLeaseIdOld() {
		return leaseIdOld;
	}

	/**
	 * @mbggenerated 老版center库对应的SALE_ID，Def: 0
	 */
	public void setLeaseIdOld(Integer leaseIdOld) {
		this.leaseIdOld = leaseIdOld;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public BigDecimal getLeaseInnerarea() {
		return leaseInnerarea;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public void setLeaseInnerarea(BigDecimal leaseInnerarea) {
		this.leaseInnerarea = leaseInnerarea;
	}

	/**
	 * @mbggenerated 0:未议价1:已议价，DEF:0
	 */
	public Boolean getHouseBargain() {
		return houseBargain;
	}

	/**
	 * @mbggenerated 0:未议价1:已议价，DEF:0
	 */
	public void setHouseBargain(Boolean houseBargain) {
		this.houseBargain = houseBargain;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getLock() {
		return lock;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLock(Byte lock) {
		this.lock = lock;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源 3=正在投诉中
	 */
	public Byte getTrueFlag() {
		return trueFlag;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源 3=正在投诉中
	 */
	public void setTrueFlag(Byte trueFlag) {
		this.trueFlag = trueFlag;
	}

	/**
	 * @mbggenerated 是否发布上架到腾讯网站，1：是0：否Def:0
	 */
	public Byte getSendtotencent() {
		return sendtotencent;
	}

	/**
	 * @mbggenerated 是否发布上架到腾讯网站，1：是0：否Def:0
	 */
	public void setSendtotencent(Byte sendtotencent) {
		this.sendtotencent = sendtotencent;
	}

	/**
	 * @mbggenerated 房源数据是否操作过发发功能1：本地 2：发发关联3：发发转入
	 */
	public Byte getHouseSourceWay() {
		return houseSourceWay;
	}

	/**
	 * @mbggenerated 房源数据是否操作过发发功能1：本地 2：发发关联3：发发转入
	 */
	public void setHouseSourceWay(Byte houseSourceWay) {
		this.houseSourceWay = houseSourceWay;
	}

	/**
	 * @mbggenerated U+分享标记 0 未分享 1 已分享
	 */
	public Byte getYouShareFlag() {
		return youShareFlag;
	}

	/**
	 * @mbggenerated U+分享标记 0 未分享 1 已分享
	 */
	public void setYouShareFlag(Byte youShareFlag) {
		this.youShareFlag = youShareFlag;
	}

	/**
	 * @mbggenerated --U+分享时间
	 */
	public Date getYouShareTime() {
		return youShareTime;
	}

	/**
	 * @mbggenerated --U+分享时间
	 */
	public void setYouShareTime(Date youShareTime) {
		this.youShareTime = youShareTime;
	}

	/**
	 * @mbggenerated 购买次数
	 */
	public Integer getYouBuyCount() {
		return youBuyCount;
	}

	/**
	 * @mbggenerated 购买次数
	 */
	public void setYouBuyCount(Integer youBuyCount) {
		this.youBuyCount = youBuyCount;
	}

	/**
	 * @mbggenerated 所属人性别，1=先生0=女士
	 */
	public Byte getOwnerSex() {
		return ownerSex;
	}

	/**
	 * @mbggenerated 所属人性别，1=先生0=女士
	 */
	public void setOwnerSex(Byte ownerSex) {
		this.ownerSex = ownerSex;
	}

	/**
	 * @mbggenerated 分享表ID
	 */
	public Integer getYouShareId() {
		return youShareId;
	}

	/**
	 * @mbggenerated 分享表ID
	 */
	public void setYouShareId(Integer youShareId) {
		this.youShareId = youShareId;
	}

	/**
	 * @mbggenerated 缩略图版本信息
	 */
	public String getThumbpicVer() {
		return thumbpicVer;
	}

	/**
	 * @mbggenerated 缩略图版本信息
	 */
	public void setThumbpicVer(String thumbpicVer) {
		this.thumbpicVer = thumbpicVer;
	}

	/**
	 * @mbggenerated 转抢盘用户的USER_ID,用于判断自己的抢盘的数据不能再次抢盘
	 */
	public Integer getPrivateUserId() {
		return privateUserId;
	}

	/**
	 * @mbggenerated 转抢盘用户的USER_ID,用于判断自己的抢盘的数据不能再次抢盘
	 */
	public void setPrivateUserId(Integer privateUserId) {
		this.privateUserId = privateUserId;
	}

	/**
	 * @mbggenerated 出租方式(0整租1合租) DD:LEASE_ROOM_TYPE
	 */
	public Byte getLeaseRoomType() {
		return leaseRoomType;
	}

	/**
	 * @mbggenerated 出租方式(0整租1合租) DD:LEASE_ROOM_TYPE
	 */
	public void setLeaseRoomType(Byte leaseRoomType) {
		this.leaseRoomType = leaseRoomType;
	}

	/**
	 * @mbggenerated 房间分类()
	 */
	public Byte getLeaseRoomClassic() {
		return leaseRoomClassic;
	}

	/**
	 * @mbggenerated 房间分类()
	 */
	public void setLeaseRoomClassic(Byte leaseRoomClassic) {
		this.leaseRoomClassic = leaseRoomClassic;
	}

	/**
	 * @mbggenerated FLAT_SHARE_SEX
	 */
	public Byte getFlatShareSex() {
		return flatShareSex;
	}

	/**
	 * @mbggenerated FLAT_SHARE_SEX
	 */
	public void setFlatShareSex(Byte flatShareSex) {
		this.flatShareSex = flatShareSex;
	}

	/**
	 * @mbggenerated 判重MD5码
	 */
	public String getAddrMd5() {
		return addrMd5;
	}

	/**
	 * @mbggenerated 判重MD5码
	 */
	public void setAddrMd5(String addrMd5) {
		this.addrMd5 = addrMd5;
	}

	/**
	 * @mbggenerated VR图片数量
	 */
	public Integer getPanoramaMap() {
		return panoramaMap;
	}

	/**
	 * @mbggenerated VR图片数量
	 */
	public void setPanoramaMap(Integer panoramaMap) {
		this.panoramaMap = panoramaMap;
	}

	/**
	 * @mbggenerated 移动端用于统计指定界面登记操作的优家数据，1：来自优家分享界面登记的优家数据-陈文超
	 */
	public Byte getYoujiaStatisticFlag() {
		return youjiaStatisticFlag;
	}

	/**
	 * @mbggenerated 移动端用于统计指定界面登记操作的优家数据，1：来自优家分享界面登记的优家数据-陈文超
	 */
	public void setYoujiaStatisticFlag(Byte youjiaStatisticFlag) {
		this.youjiaStatisticFlag = youjiaStatisticFlag;
	}

	/**
	 * @mbggenerated 广告房源标记
	 */
	public Byte getAdsFlag() {
		return adsFlag;
	}

	/**
	 * @mbggenerated 广告房源标记
	 */
	public void setAdsFlag(Byte adsFlag) {
		this.adsFlag = adsFlag;
	}

	/**
	 * @mbggenerated 同步时间，第三方同步接口的同步时间
	 */
	public Date getSyncTime() {
		return syncTime;
	}

	/**
	 * @mbggenerated 同步时间，第三方同步接口的同步时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	/**
	 * @mbggenerated 视频审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public Byte getVideoReviewFlag() {
		return videoReviewFlag;
	}

	/**
	 * @mbggenerated 视频审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public void setVideoReviewFlag(Byte videoReviewFlag) {
		this.videoReviewFlag = videoReviewFlag;
	}

	/**
	 * @mbggenerated VR显示标记 0 不显示 1 显示
	 */
	public Byte getHasPanorama() {
		return hasPanorama;
	}

	/**
	 * @mbggenerated VR显示标记 0 不显示 1 显示
	 */
	public void setHasPanorama(Byte hasPanorama) {
		this.hasPanorama = hasPanorama;
	}

	/**
	 * @mbggenerated -
	 */
	public Boolean getBiddingFlag() {
		return biddingFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBiddingFlag(Boolean biddingFlag) {
		this.biddingFlag = biddingFlag;
	}

	/**
	 * @mbggenerated 房源竞价结束时间
	 */
	public Date getCompeteEndTime() {
		return competeEndTime;
	}

	/**
	 * @mbggenerated 房源竞价结束时间
	 */
	public void setCompeteEndTime(Date competeEndTime) {
		this.competeEndTime = competeEndTime;
	}

	/**
	 * @mbggenerated 房源竞价价格
	 */
	public BigDecimal getCompetePrice() {
		return competePrice;
	}

	/**
	 * @mbggenerated 房源竞价价格
	 */
	public void setCompetePrice(BigDecimal competePrice) {
		this.competePrice = competePrice;
	}

	/**
	 * @mbggenerated 1=已获取分享费，2=已退还分享费，3=已完成、不再退或给分享费
	 */
	public Byte getYouShareMoneyState() {
		return youShareMoneyState;
	}

	/**
	 * @mbggenerated 1=已获取分享费，2=已退还分享费，3=已完成、不再退或给分享费
	 */
	public void setYouShareMoneyState(Byte youShareMoneyState) {
		this.youShareMoneyState = youShareMoneyState;
	}

	/**
	 * @mbggenerated 是否发布微店
	 */
	public Byte getSendtoWeidian() {
		return sendtoWeidian;
	}

	/**
	 * @mbggenerated 是否发布微店
	 */
	public void setSendtoWeidian(Byte sendtoWeidian) {
		this.sendtoWeidian = sendtoWeidian;
	}

	/**
	 * @mbggenerated 是否发布优优
	 */
	public Byte getSendtoYouyou() {
		return sendtoYouyou;
	}

	/**
	 * @mbggenerated 是否发布优优
	 */
	public void setSendtoYouyou(Byte sendtoYouyou) {
		this.sendtoYouyou = sendtoYouyou;
	}

	/**
	 * @mbggenerated 优优排除成交的推荐数据，0：未成交、1：成交 - 陈文超-2016-10-01
	 */
	public Byte getYouyouDeal() {
		return youyouDeal;
	}

	/**
	 * @mbggenerated 优优排除成交的推荐数据，0：未成交、1：成交 - 陈文超-2016-10-01
	 */
	public void setYouyouDeal(Byte youyouDeal) {
		this.youyouDeal = youyouDeal;
	}

	/**
	 * @mbggenerated 封盘保护结束时间
	 */
	public Date getSpecialEndTime() {
		return specialEndTime;
	}

	/**
	 * @mbggenerated 封盘保护结束时间
	 */
	public void setSpecialEndTime(Date specialEndTime) {
		this.specialEndTime = specialEndTime;
	}

	/**
	 * @mbggenerated 预订保护结束时间
	 */
	public Date getScheduleEndTime() {
		return scheduleEndTime;
	}

	/**
	 * @mbggenerated 预订保护结束时间
	 */
	public void setScheduleEndTime(Date scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	/**
	 * @mbggenerated 委托书地址
	 */
	public String getProxyUrl() {
		return proxyUrl;
	}

	/**
	 * @mbggenerated 委托书地址
	 */
	public void setProxyUrl(String proxyUrl) {
		this.proxyUrl = proxyUrl;
	}

	/**
	 * @mbggenerated 上传委托书的人
	 */
	public String getUploadProxyUser() {
		return uploadProxyUser;
	}

	/**
	 * @mbggenerated 上传委托书的人
	 */
	public void setUploadProxyUser(String uploadProxyUser) {
		this.uploadProxyUser = uploadProxyUser;
	}

	/**
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费
	 */
	public Byte getCityShareFlag() {
		return cityShareFlag;
	}

	/**
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费
	 */
	public void setCityShareFlag(Byte cityShareFlag) {
		this.cityShareFlag = cityShareFlag;
	}

	/**
	 * @mbggenerated 品牌中介公司ID
	 */
	public Integer getBrandCompId() {
		return brandCompId;
	}

	/**
	 * @mbggenerated 品牌中介公司ID
	 */
	public void setBrandCompId(Integer brandCompId) {
		this.brandCompId = brandCompId;
	}

	/**
	 * @mbggenerated 核验编码
	 */
	public String getCheckCodeFun() {
		return checkCodeFun;
	}

	/**
	 * @mbggenerated 核验编码
	 */
	public void setCheckCodeFun(String checkCodeFun) {
		this.checkCodeFun = checkCodeFun;
	}

	/**
	 * @mbggenerated 产权证类型 DD:OWNERSHIP_TYPE
	 */
	public Byte getOwnershipType() {
		return ownershipType;
	}

	/**
	 * @mbggenerated 产权证类型 DD:OWNERSHIP_TYPE
	 */
	public void setOwnershipType(Byte ownershipType) {
		this.ownershipType = ownershipType;
	}

	/**
	 * @mbggenerated 房源有效期
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @mbggenerated 房源有效期
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @mbggenerated 产权编号
	 */
	public String getQzCodeFun() {
		return qzCodeFun;
	}

	/**
	 * @mbggenerated 产权编号
	 */
	public void setQzCodeFun(String qzCodeFun) {
		this.qzCodeFun = qzCodeFun;
	}

	/**
	 * @mbggenerated --房管局状态 DD:FUNMANAGER_SALESTATUS
	 */
	public Byte getFunmanagerSalestatus() {
		return funmanagerSalestatus;
	}

	/**
	 * @mbggenerated --房管局状态 DD:FUNMANAGER_SALESTATUS
	 */
	public void setFunmanagerSalestatus(Byte funmanagerSalestatus) {
		this.funmanagerSalestatus = funmanagerSalestatus;
	}

	/**
	 * @mbggenerated 首次房堪标记-0代表没有房堪过1，代表已房堪过，已废弃，使用LEASE_EXPLRTH字段
	 */
	public Byte getHasFunkan() {
		return hasFunkan;
	}

	/**
	 * @mbggenerated 首次房堪标记-0代表没有房堪过1，代表已房堪过，已废弃，使用LEASE_EXPLRTH字段
	 */
	public void setHasFunkan(Byte hasFunkan) {
		this.hasFunkan = hasFunkan;
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
	 * @mbggenerated 共有人姓名
	 */
	public String getJointUserName() {
		return jointUserName;
	}

	/**
	 * @mbggenerated 共有人姓名
	 */
	public void setJointUserName(String jointUserName) {
		this.jointUserName = jointUserName;
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
	 * @mbggenerated 共有人身份证号
	 */
	public String getJointIdCard() {
		return jointIdCard;
	}

	/**
	 * @mbggenerated 共有人身份证号
	 */
	public void setJointIdCard(String jointIdCard) {
		this.jointIdCard = jointIdCard;
	}

	/**
	 * @mbggenerated 暂缓保护到期时间
	 */
	public Date getRespiteEndTime() {
		return respiteEndTime;
	}

	/**
	 * @mbggenerated 暂缓保护到期时间
	 */
	public void setRespiteEndTime(Date respiteEndTime) {
		this.respiteEndTime = respiteEndTime;
	}

	/**
	 * @mbggenerated 可租售ID，和FUN_SLAE对应，只会一对一
	 */
	public Integer getSaleLeaseId() {
		return saleLeaseId;
	}

	/**
	 * @mbggenerated 可租售ID，和FUN_SLAE对应，只会一对一
	 */
	public void setSaleLeaseId(Integer saleLeaseId) {
		this.saleLeaseId = saleLeaseId;
	}

	/**
	 * @mbggenerated 是否是租售房源，1=是，默认=0=否
	 */
	public Byte getIsSaleLease() {
		return isSaleLease;
	}

	/**
	 * @mbggenerated 是否是租售房源，1=是，默认=0=否
	 */
	public void setIsSaleLease(Byte isSaleLease) {
		this.isSaleLease = isSaleLease;
	}

	/**
	 * @mbggenerated 委托截止日期
	 */
	public Date getEntrustEndTime() {
		return entrustEndTime;
	}

	/**
	 * @mbggenerated 委托截止日期
	 */
	public void setEntrustEndTime(Date entrustEndTime) {
		this.entrustEndTime = entrustEndTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getEntrustCreateUser() {
		return entrustCreateUser;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustCreateUser(Integer entrustCreateUser) {
		this.entrustCreateUser = entrustCreateUser;
	}

	/**
	 * @mbggenerated 初始为登记时间，转有效之后为转有效的时间，主要用于房客源列表排序
	 */
	public Date getAvailableTime() {
		return availableTime;
	}

	/**
	 * @mbggenerated 初始为登记时间，转有效之后为转有效的时间，主要用于房客源列表排序
	 */
	public void setAvailableTime(Date availableTime) {
		this.availableTime = availableTime;
	}

	/**
	 * @mbggenerated 调价截止展示时间
	 */
	public Date getModifyPriceEnd() {
		return modifyPriceEnd;
	}

	/**
	 * @mbggenerated 调价截止展示时间
	 */
	public void setModifyPriceEnd(Date modifyPriceEnd) {
		this.modifyPriceEnd = modifyPriceEnd;
	}

	/**
	 * @mbggenerated 调价走势，1=上涨 2=下降
	 */
	public Byte getModifyPriceTrend() {
		return modifyPriceTrend;
	}

	/**
	 * @mbggenerated 调价走势，1=上涨 2=下降
	 */
	public void setModifyPriceTrend(Byte modifyPriceTrend) {
		this.modifyPriceTrend = modifyPriceTrend;
	}

	/**
	 * @mbggenerated 房堪时间，最近带看时间，带看跟进写成功之后，需更新该字段
	 */
	public Date getLastDkanTime() {
		return lastDkanTime;
	}

	/**
	 * @mbggenerated 房堪时间，最近带看时间，带看跟进写成功之后，需更新该字段
	 */
	public void setLastDkanTime(Date lastDkanTime) {
		this.lastDkanTime = lastDkanTime;
	}

	/**
	 * @mbggenerated 老的真房源标签
	 */
	public Byte getOldTrueFlag() {
		return oldTrueFlag;
	}

	/**
	 * @mbggenerated 老的真房源标签
	 */
	public void setOldTrueFlag(Byte oldTrueFlag) {
		this.oldTrueFlag = oldTrueFlag;
	}

	/**
	 * @mbggenerated 房源公司内部编号
	 */
	public Integer getInnerNo() {
		return innerNo;
	}

	/**
	 * @mbggenerated 房源公司内部编号
	 */
	public void setInnerNo(Integer innerNo) {
		this.innerNo = innerNo;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(共有人证件类型)
	 */
	public Integer getJointIdCardType() {
		return jointIdCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(共有人证件类型)
	 */
	public void setJointIdCardType(Integer jointIdCardType) {
		this.jointIdCardType = jointIdCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(证件类型)
	 */
	public Integer getIdCardType() {
		return idCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(证件类型)
	 */
	public void setIdCardType(Integer idCardType) {
		this.idCardType = idCardType;
	}

	/**
	 * @mbggenerated 租房性质 DD:OFFICE_CHARACTER
	 */
	public Byte getOfficeCharacter() {
		return officeCharacter;
	}

	/**
	 * @mbggenerated 租房性质 DD:OFFICE_CHARACTER
	 */
	public void setOfficeCharacter(Byte officeCharacter) {
		this.officeCharacter = officeCharacter;
	}

	/**
	 * @mbggenerated 是否含税
	 */
	public Boolean getOfficeTax() {
		return officeTax;
	}

	/**
	 * @mbggenerated 是否含税
	 */
	public void setOfficeTax(Boolean officeTax) {
		this.officeTax = officeTax;
	}

	/**
	 * @mbggenerated 开间
	 */
	public BigDecimal getLeaseBay() {
		return leaseBay;
	}

	/**
	 * @mbggenerated 开间
	 */
	public void setLeaseBay(BigDecimal leaseBay) {
		this.leaseBay = leaseBay;
	}

	/**
	 * @mbggenerated 进深
	 */
	public BigDecimal getLeaseDepth() {
		return leaseDepth;
	}

	/**
	 * @mbggenerated 进深
	 */
	public void setLeaseDepth(BigDecimal leaseDepth) {
		this.leaseDepth = leaseDepth;
	}

	/**
	 * @mbggenerated 层高
	 */
	public BigDecimal getLeaseStorey() {
		return leaseStorey;
	}

	/**
	 * @mbggenerated 层高
	 */
	public void setLeaseStorey(BigDecimal leaseStorey) {
		this.leaseStorey = leaseStorey;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCheckTime() {
		return checkTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @mbggenerated 转聚焦日期
	 */
	public Date getFocusTime() {
		return focusTime;
	}

	/**
	 * @mbggenerated 转聚焦日期
	 */
	public void setFocusTime(Date focusTime) {
		this.focusTime = focusTime;
	}

	/**
	 * @mbggenerated 用户成级
	 */
	public Integer getUserLevel() {
		return userLevel;
	}

	/**
	 * @mbggenerated 用户成级
	 */
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @mbggenerated 组织架构线
	 */
	public String getTissueLine() {
		return tissueLine;
	}

	/**
	 * @mbggenerated 组织架构线
	 */
	public void setTissueLine(String tissueLine) {
		this.tissueLine = tissueLine;
	}

	/**
	 * @mbggenerated 加盟商ID-关联加盟商表：直营的组织机构为：-1、总部为：0、加盟商的ID > 0
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated 加盟商ID-关联加盟商表：直营的组织机构为：-1、总部为：0、加盟商的ID > 0
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated 房堪人USER_ID
	 */
	public Integer getFunkanUserId() {
		return funkanUserId;
	}

	/**
	 * @mbggenerated 房堪人USER_ID
	 */
	public void setFunkanUserId(Integer funkanUserId) {
		this.funkanUserId = funkanUserId;
	}

	/**
	 * @mbggenerated 钥匙提交人USER_ID
	 */
	public Integer getLeaseKeyUserId() {
		return leaseKeyUserId;
	}

	/**
	 * @mbggenerated 钥匙提交人USER_ID
	 */
	public void setLeaseKeyUserId(Integer leaseKeyUserId) {
		this.leaseKeyUserId = leaseKeyUserId;
	}

	/**
	 * @mbggenerated 档案编码
	 */
	public String getFileCoding() {
		return fileCoding;
	}

	/**
	 * @mbggenerated 档案编码
	 */
	public void setFileCoding(String fileCoding) {
		this.fileCoding = fileCoding;
	}

	/**
	 * @mbggenerated 出租方 1：业主，2：包租方，3：转租方
	 */
	public Byte getLessor() {
		return lessor;
	}

	/**
	 * @mbggenerated 出租方 1：业主，2：包租方，3：转租方
	 */
	public void setLessor(Byte lessor) {
		this.lessor = lessor;
	}

	/**
	 * @mbggenerated 转让费
	 */
	public BigDecimal getTransferFee() {
		return transferFee;
	}

	/**
	 * @mbggenerated 转让费
	 */
	public void setTransferFee(BigDecimal transferFee) {
		this.transferFee = transferFee;
	}

	/**
	 * @mbggenerated 回报率
	 */
	public BigDecimal getReturnRate() {
		return returnRate;
	}

	/**
	 * @mbggenerated 回报率
	 */
	public void setReturnRate(BigDecimal returnRate) {
		this.returnRate = returnRate;
	}

	/**
	 * @mbggenerated 包租方组织机构
	 */
	public String getMlReservedComp() {
		return mlReservedComp;
	}

	/**
	 * @mbggenerated 包租方组织机构
	 */
	public void setMlReservedComp(String mlReservedComp) {
		this.mlReservedComp = mlReservedComp;
	}

	/**
	 * @mbggenerated 房源是否需要审核 0=正常登中记 1=审核中 2=审核不通过 3=申诉
	 */
	public Byte getHouseVerify() {
		return houseVerify;
	}

	/**
	 * @mbggenerated 房源是否需要审核 0=正常登中记 1=审核中 2=审核不通过 3=申诉
	 */
	public void setHouseVerify(Byte houseVerify) {
		this.houseVerify = houseVerify;
	}

	/**
	 * @mbggenerated 厨房数量
	 */
	public Byte getKitchen() {
		return kitchen;
	}

	/**
	 * @mbggenerated 厨房数量
	 */
	public void setKitchen(Byte kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * @mbggenerated 美联 是否是整层1=是
	 */
	public Byte getMlWholeLayer() {
		return mlWholeLayer;
	}

	/**
	 * @mbggenerated 美联 是否是整层1=是
	 */
	public void setMlWholeLayer(Byte mlWholeLayer) {
		this.mlWholeLayer = mlWholeLayer;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 产权性质 DD:HOUSE_NATURE
	 */
	public Byte getLeaseNature() {
		return leaseNature;
	}

	/**
	 * @mbggenerated 产权性质 DD:HOUSE_NATURE
	 */
	public void setLeaseNature(Byte leaseNature) {
		this.leaseNature = leaseNature;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getLeaseStruct() {
		return leaseStruct;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseStruct(Byte leaseStruct) {
		this.leaseStruct = leaseStruct;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getLeaseExpirationTime() {
		return leaseExpirationTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseExpirationTime(Date leaseExpirationTime) {
		this.leaseExpirationTime = leaseExpirationTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getHouseSituation() {
		return houseSituation;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHouseSituation(Byte houseSituation) {
		this.houseSituation = houseSituation;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getCurrentRent() {
		return currentRent;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCurrentRent(BigDecimal currentRent) {
		this.currentRent = currentRent;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTransactionStatus(Byte transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getLeaseUnitPrice() {
		return leaseUnitPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseUnitPrice(BigDecimal leaseUnitPrice) {
		this.leaseUnitPrice = leaseUnitPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getHasRecorded() {
		return hasRecorded;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHasRecorded(Byte hasRecorded) {
		this.hasRecorded = hasRecorded;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getLeaseEntrustPrice() {
		return leaseEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseEntrustPrice(BigDecimal leaseEntrustPrice) {
		this.leaseEntrustPrice = leaseEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getHasEntrust() {
		return hasEntrust;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHasEntrust(Byte hasEntrust) {
		this.hasEntrust = hasEntrust;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getOffereeTime() {
		return offereeTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOffereeTime(Date offereeTime) {
		this.offereeTime = offereeTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getLeaseAmountChangeTime() {
		return leaseAmountChangeTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseAmountChangeTime(Date leaseAmountChangeTime) {
		this.leaseAmountChangeTime = leaseAmountChangeTime;
	}

	/**
	 * @mbggenerated 用于楼盘名称,楼盘地址,房源标题,房源描述,配套设施 模糊查询
	 */
	public String getFuzzySearch() {
		return fuzzySearch;
	}

	/**
	 * @mbggenerated 用于楼盘名称,楼盘地址,房源标题,房源描述,配套设施 模糊查询
	 */
	public void setFuzzySearch(String fuzzySearch) {
		this.fuzzySearch = fuzzySearch;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLease() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLease(Integer shardCityId, Integer leaseId) {
		super(shardCityId);
		this.leaseId = leaseId;
	}

	public void hideCoreInfo(String isShowHouseRoof, String isShowHouseUnit, String isShowHouseNum, String showShopOtherAddr) {
		if("0".equals(isShowHouseRoof)) {
			this.leaseRoofT = "-";
		}
		if("0".equals(isShowHouseUnit)) {
			this.leaseUnitT = "-";
		}
		if("0".equals(isShowHouseNum)) {
			this.leaseNumT = "-";
		}
		if(showShopOtherAddr==null || "0".equals(showShopOtherAddr)) {
			if(Const.DIC_HOUSE_USEAGE_TRADE.equals(this.leaseUseage)) {
				this.tradeAddr = "-";
			}
		}
	}
}