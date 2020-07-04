package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.support.constant.Const;
import org.apache.solr.client.solrj.beans.Field;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunSale extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID，自增序列")
	@Field(value = "SALE_ID")
	private Integer saleId;
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
	@Field(value = "SALE_NO")
	private String saleNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主姓名")
	@Field(value = "SALE_OWNER")
	private String saleOwner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手机号码  业主")
	@Field(value = "CELL_PHONE")
	private String cellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业主身份证")
	@Field(value = "ID_CARD")
	private String idCard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源标题")
	@Field(value = "SALE_SUBJECT")
	private String saleSubject;
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
	@ApiModelProperty(value = "行政区ID，区域ID")
	@Field(value = "SALE_REG")
	private Integer saleReg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区名称，区域名称")
	@Field(value = "REGION_NAME")
	private String regionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID，板块ID")
	@Field(value = "SECTION_ID")
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区名称，板块名称")
	@Field(value = "SECTION_NAME")
	private String sectionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
	@Field(value = "SALE_ROUND")
	private Byte saleRound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "商铺、厂房、车库、仓库：地址")
	@Field(value = "TRADE_ADDR")
	private String tradeAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋")
	@Field(value = "SALE_ROOF")
	private String saleRoof;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座规则下：单元、号室规则下：号")
	@Field(value = "SALE_UNIT")
	private String saleUnit;
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
	@Field(value = "SALE_NUM")
	private String saleNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋(重复)")
	@Field(value = "SALE_ROOF_R")
	private String saleRoofR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元(重复)")
	@Field(value = "SALE_UNIT_R")
	private String saleUnitR;
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
	@Field(value = "SALE_NUM_R")
	private String saleNumR;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几梯")
	@Field(value = "SALE_LADDER")
	private Integer saleLadder;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几户")
	@Field(value = "SALE_DOORS")
	private Integer saleDoors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几房/几室")
	@Field(value = "SALE_ROOM")
	private Byte saleRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几厅")
	@Field(value = "SALE_HALL")
	private Byte saleHall;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几卫")
	@Field(value = "SALE_WEI")
	private Byte saleWei;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "阳台")
	@Field(value = "SALE_YANG")
	private Byte saleYang;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "类型，DD: HOUSE_TYPE")
	@Field(value = "SALE_TYPE")
	private Byte saleType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层")
	@Field(value = "SALE_FLOOR")
	private Short saleFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总楼层")
	@Field(value = "SALE_FLOORS")
	private Integer saleFloors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "装修，DD:HOUSE_FITMENT")
	@Field(value = "SALE_FITMENT")
	private Byte saleFitment;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源朝向，DD：HOUSE_DIRECT")
	@Field(value = "SALE_DIRECT")
	private Byte saleDirect;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋年代")
	@Field(value = "SALE_YEAR")
	private Short saleYear;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋结构，DD:HOUSE_STRUCT")
	@Field(value = "SALE_STRUCT")
	private Byte saleStruct;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋用途，DD:HOUSE_USEAGE")
	@Field(value = "SALE_USEAGE")
	private Byte saleUseage;
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
	@ApiModelProperty(value = "是否邻街，1=是0=否")
	@Field(value = "SALE_STREET")
	private Boolean saleStreet;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权，DD:HOUSE_RIGHT")
	@Field(value = "SALE_RIGHT")
	private Byte saleRight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "现状(按揭)，DD:HOUSE_STITUAT")
	@Field(value = "SALE_MORTGAGE")
	private String saleMortgage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "结算，DD:HOUSE_ACCOUNT")
	@Field(value = "SALE_ACCOUNT")
	private String saleAccount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑面积")
	@Field(value = "SALE_AREA")
	private BigDecimal saleArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "售价")
	@Field(value = "SALE_TOTAL_PRICE")
	private BigDecimal saleTotalPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单价")
	@Field(value = "SALE_UNIT_PRICE")
	private BigDecimal saleUnitPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "底价")
	@Field(value = "SALE_LOWEST_PRICE")
	private BigDecimal saleLowestPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物业费")
	@Field(value = "SALE_PROPERTY")
	private BigDecimal saleProperty;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否可分割，1=是0=否")
	@Field(value = "IS_SEPERATOR")
	private Boolean isSeperator;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "腾房日")
	@Field(value = "SALE_LEAVE_TIME")
	private String saleLeaveTime;
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
	private Byte ugType;
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
	private Byte garageAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配套及特色")
	@Field(value = "SALE_CHARACT")
	private String saleCharact;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内部备注")
	@Field(value = "SALE_MEMO")
	private String saleMemo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息来源，DD:HOUSE_SOURCE")
	@Field(value = "SALE_SOURCE")
	private Byte saleSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有钥匙，1=是0=否")
	@Field(value = "SALE_KEY")
	private Boolean saleKey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙编号")
	@Field(value = "SALE_KEY_NUM")
	private String saleKeyNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙日期")
	@Field(value = "KEY_TIME")
	private Date keyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘，1=已勘0=未勘")
	@Field(value = "SALE_EXPLRTH")
	private Boolean saleExplrth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘日期")
	@Field(value = "EXPLRTH_DATETIME")
	private Date explrthDatetime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托，DD: HOUSE_CONSIGN")
	@Field(value = "SALE_CONSIGN")
	private Byte saleConsign;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托编号")
	@Field(value = "SALE_CONSIGN_NO")
	private String saleConsignNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托时间")
	@Field(value = "WEITUO_TIME")
	private Date weituoTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否合作，1=是0=否（弃用-2018-05-25-陈文超）")
	@Field(value = "SALE_COOPERATE")
	private Boolean saleCooperate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0")
	@Field(value = "SALE_PUBLISH")
	private Boolean salePublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片张数，默认=0")
	@Field(value = "SALE_MAP")
	private Byte saleMap;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "级别，DD: HOUSE_LEVEL")
	@Field(value = "SALE_LEVEL")
	private Byte saleLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "盘别，DD：PLATE_TYPE")
	@Field(value = "PLATE_TYPE")
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋状态，DD：HOUSE_STATUS")
	@Field(value = "SALE_STATUS")
	private Byte saleStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后跟进日期(ge)")
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
	@ApiModelProperty(value = "房勘计时起始时间")
	@Field(value = "ACTION_TIME")
	private Date actionTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否从搜搜获得，1=是0=否")
	@Field(value = "FROM_SOSO")
	private Boolean fromSoso;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复")
	@Field(value = "REPEAT_FLAG")
	private Byte repeatFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型（全城联网中查询条件：INFO_TYPE<2），0=门店版1=精英版2=已转房源默认=0  3=开单豹")
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
	@ApiModelProperty(value = "首次合作时间")
	@Field(value = "COOPERATE_TIME")
	private Date cooperateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "投诉成功标记，1=被投诉0未投诉")
	@Field(value = "COMPLAINT_FLAG")
	private Boolean complaintFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次发布时间")
	@Field(value = "PUBLISH_TIME")
	private Date publishTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次上图时间")
	@Field(value = "PHOTO_TIME")
	private Date photoTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "红色警示，1=是0=否（房源是房堪，客源是带看）")
	@Field(value = "RED_FLAG")
	private Boolean redFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "橙色警示，1=是0=否(带跟进)")
	@Field(value = "ORANGE_FLAG")
	private Boolean orangeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘次数，默认=0")
	@Field(value = "PUBLIC_COUNT")
	private Integer publicCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘日期")
	@Field(value = "PUBLIC_TIME")
	private Date publicTime;
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
	@ApiModelProperty(value = "转私盘时间")
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
	@Field(value = "SALE_CERT_TIME")
	private Date saleCertTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "各网站的发布状态腾讯 ― 10进位上微店 －个进位上，以位表示：1＝否2＝是")
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
	@Field(value = "SALE_ROOF_T")
	private String saleRoofT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房号（明文）")
	@Field(value = "SALE_NUM_T")
	private String saleNumT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元（明文）")
	@Field(value = "SALE_UNIT_T")
	private String saleUnitT;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频数量，Def：0")
	@Field(value = "VIDEO_NUM")
	private Byte videoNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录人USER_ID")
	@Field(value = "CREATOR_UID")
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1，2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据")
	@Field(value = "IS_IGNORE")
	private Byte isIgnore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "老版center库对应的SALE_ID，Def: 0")
	@Field(value = "SALE_ID_OLD")
	private Integer saleIdOld;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "套内面积")
	@Field(value = "SALE_INNERAREA")
	private BigDecimal saleInnerarea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0:未议价1:已议价，DEF:0")
	@Field(value = "HOUSE_BARGAIN")
	private Boolean houseBargain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否编码 - 已废弃")
	@Field(value = "ENCODE_FLAG")
	private Byte encodeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "锁定标记  - 已废弃")
	@Field(value = "LOCK")
	private Byte lock;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源  3=正在投诉中4=投诉后连带下架（不在优优展示）")
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
	@ApiModelProperty(value = "房源数据是否操作过发发功能1：本地2：发发关联3：发发转入")
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
	@ApiModelProperty(value = "房源栋座号的MD5码")
	@Field(value = "ADDR_MD5")
	private String addrMd5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "720相机图片有多少张")
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
	@ApiModelProperty(value = "鸿基广告房源")
	@Field(value = "ADS_FLAG")
	private Byte adsFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三方同步时间，修改房源数据时修改这个时间")
	@Field(value = "SYNC_TIME")
	private Date syncTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频审核标记 0=未审核 1=审核通过 2=审核失败")
	@Field(value = "VIDEO_REVIEW_FLAG")
	private Byte videoReviewFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR显示标记 0=不显示（crm审核不通过） 1=显示")
	@Field(value = "HAS_PANORAMA")
	private Byte hasPanorama;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否竞价0否1是")
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
	@ApiModelProperty(value = "核验编号")
	@Field(value = "CHECK_CODE_FUN")
	private String checkCodeFun;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托书url")
	@Field(value = "PROXY_URL")
	private String proxyUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权证编号")
	@Field(value = "QZ_CODE_FUN")
	private String qzCodeFun;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "核验编号图片所在地址")
	@Field(value = "CHECK_CODE_URL")
	private String checkCodeUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托书上传人")
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
	@ApiModelProperty(value = "暂时没有使用-但是线上sql脚本已经生成，删除该字段时候注意检查线上环境-陈文超")
	@Field(value = "COMP_ID2")
	private Integer compId2;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超")
	@Field(value = "FILE_SYSTEM_TYPE")
	private Byte fileSystemType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权属类型DD：OWNERSHIP_TYPE")
	@Field(value = "OWNERSHIP_TYPE")
	private Byte ownershipType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源有效期号")
	@Field(value = "EFFECTIVE_DATE")
	private Date effectiveDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "--房管局销售状态 DD:FUNMANAGER_SALESTATUS数据字典按城市分")
	@Field(value = "FUNMANAGER_SALESTATUS")
	private Byte funmanagerSalestatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次房堪标记0=代表还没有房堪1=已经房堪，已废弃，使用 SALE_EXPLRTH 字段")
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
	@ApiModelProperty(value = "可租售ID，和FUN_LEASE对应，只会一对一")
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
	@ApiModelProperty(value = "委托截止时间 ")
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
	@ApiModelProperty(value = "房屋现状，DD：HOUSE_SITUATION")
	@Field(value = "HOUSE_SITUATION")
	private Byte houseSituation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房堪时间，最近带看时间，带看跟进写成功之后，需更新该字段")
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
	@ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证")
	@Field(value = "JOINT_ID_CARD_TYPE")
	private Integer jointIdCardType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证")
	@Field(value = "ID_CARD_TYPE")
	private Integer idCardType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开间")
	@Field(value = "SALE_BAY")
	private BigDecimal saleBay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "进深")
	@Field(value = "SALE_DEPTH")
	private BigDecimal saleDepth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "层高")
	@Field(value = "SALE_STOREY")
	private BigDecimal saleStorey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋结构：DD：HOUSE_GRADATION")
	@Field(value = "SALE_GRADATION")
	private Byte saleGradation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权性质：DD：HOUSE_NATURE")
	@Field(value = "SALE_NATURE")
	private Byte saleNature;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "别墅类型：DD：VILLA_TYPE")
	@Field(value = "VILLA_TYPE")
	private Byte villaType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑风格：DD：HOUSE_STYLE")
	@Field(value = "SALE_STYLE")
	private Byte saleStyle;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "功能类型：DD：ACTION_TYPE")
	@Field(value = "ACTION_TYPE")
	private Byte actionType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "景观类型：DD：SCENERY_TYPE")
	@Field(value = "SCENERY_TYPE")
	private Byte sceneryType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收款方式：DD：RECEIPT_TYPE")
	@Field(value = "RECEIPT_TYPE")
	private Byte receiptType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "抵押情况：DD：GUARANTY_TYPE")
	@Field(value = "GUARANTY_TYPE")
	private Byte guarantyType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "看房时间")
	@Field(value = "CHECK_TIME")
	private String checkTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转聚焦日期-笋盘")
	@Field(value = "FOCUS_TIME")
	private Date focusTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户层级-房基地、新版组织架构保存的是机构定义表中的数据ID")
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
	@ApiModelProperty(value = "购入价")
	@Field(value = "SALE_BUY_PRICE")
	private BigDecimal saleBuyPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID-关联加盟商表：直营的组织机构为：-1、总部为：0、加盟商的ID > 0")
	@Field(value = "PARTNER_ID")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘人UserID")
	@Field(value = "FUNKAN_USER_ID")
	private Integer funkanUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙人User_ID")
	@Field(value = "SALE_KEY_USER_ID")
	private Integer saleKeyUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案编码")
	@Field(value = "FILE_CODING")
	private String fileCoding;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "按揭银行")
	@Field(value = "MORTGAGE_BANK")
	private String mortgageBank;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "按揭欠款")
	@Field(value = "ARREARS")
	private BigDecimal arrears;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当前租金")
	@Field(value = "CURRENT_RENT")
	private BigDecimal currentRent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "回报率")
	@Field(value = "TURN_RATE")
	private BigDecimal turnRate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源是否需要审核 0=正常登记 1=审核中 2=审核不通过 3=申诉中")
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
	@ApiModelProperty(value = "组织机构ID")
	@Field(value = "ORGANIZATION_ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租转到期时间")
	@Field(value = "LEASE_EXPIRATION_TIME")
	private Date leaseExpirationTime;
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
	@Field(value = "HAS_RECORDED")
	private Byte hasRecorded;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	@Field(value = "SALE_ENTRUST_PRICE")
	private BigDecimal saleEntrustPrice;
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
	@Field(value = "SALE_AMOUNT_CHANGE_TIME")
	private Date saleAmountChangeTime;
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
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @mbggenerated 房源ID，自增序列
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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
	public String getSaleNo() {
		return saleNo;
	}

	/**
	 * @mbggenerated 系统编码
	 */
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}

	/**
	 * @mbggenerated 业主姓名
	 */
	public String getSaleOwner() {
		return saleOwner;
	}

	/**
	 * @mbggenerated 业主姓名
	 */
	public void setSaleOwner(String saleOwner) {
		this.saleOwner = saleOwner;
	}

	/**
	 * @mbggenerated 手机号码  业主
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @mbggenerated 手机号码  业主
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @mbggenerated 业主身份证
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @mbggenerated 业主身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @mbggenerated 房源标题
	 */
	public String getSaleSubject() {
		return saleSubject;
	}

	/**
	 * @mbggenerated 房源标题
	 */
	public void setSaleSubject(String saleSubject) {
		this.saleSubject = saleSubject;
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
	 * @mbggenerated 行政区ID，区域ID
	 */
	public Integer getSaleReg() {
		return saleReg;
	}

	/**
	 * @mbggenerated 行政区ID，区域ID
	 */
	public void setSaleReg(Integer saleReg) {
		this.saleReg = saleReg;
	}

	/**
	 * @mbggenerated 行政区名称，区域名称
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @mbggenerated 行政区名称，区域名称
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @mbggenerated 片区ID，板块ID
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated 片区ID，板块ID
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @mbggenerated 片区名称，板块名称
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @mbggenerated 片区名称，板块名称
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public Byte getSaleRound() {
		return saleRound;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public void setSaleRound(Byte saleRound) {
		this.saleRound = saleRound;
	}

	/**
	 * @mbggenerated 商铺、厂房、车库、仓库：地址
	 */
	public String getTradeAddr() {
		return tradeAddr;
	}

	/**
	 * @mbggenerated 商铺、厂房、车库、仓库：地址
	 */
	public void setTradeAddr(String tradeAddr) {
		this.tradeAddr = tradeAddr;
	}

	/**
	 * @mbggenerated 栋
	 */
	public String getSaleRoof() {
		return saleRoof;
	}

	/**
	 * @mbggenerated 栋
	 */
	public void setSaleRoof(String saleRoof) {
		this.saleRoof = saleRoof;
	}

	/**
	 * @mbggenerated 栋座规则下：单元、号室规则下：号
	 */
	public String getSaleUnit() {
		return saleUnit;
	}

	/**
	 * @mbggenerated 栋座规则下：单元、号室规则下：号
	 */
	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
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
	public String getSaleNum() {
		return saleNum;
	}

	/**
	 * @mbggenerated 栋座规则下：号、号室规则下：室；商铺用途时为：号位
	 */
	public void setSaleNum(String saleNum) {
		this.saleNum = saleNum;
	}

	/**
	 * @mbggenerated 栋(重复)
	 */
	public String getSaleRoofR() {
		return saleRoofR;
	}

	/**
	 * @mbggenerated 栋(重复)
	 */
	public void setSaleRoofR(String saleRoofR) {
		this.saleRoofR = saleRoofR;
	}

	/**
	 * @mbggenerated 单元(重复)
	 */
	public String getSaleUnitR() {
		return saleUnitR;
	}

	/**
	 * @mbggenerated 单元(重复)
	 */
	public void setSaleUnitR(String saleUnitR) {
		this.saleUnitR = saleUnitR;
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
	public String getSaleNumR() {
		return saleNumR;
	}

	/**
	 * @mbggenerated 号(重复)
	 */
	public void setSaleNumR(String saleNumR) {
		this.saleNumR = saleNumR;
	}

	/**
	 * @mbggenerated 几梯
	 */
	public Integer getSaleLadder() {
		return saleLadder;
	}

	/**
	 * @mbggenerated 几梯
	 */
	public void setSaleLadder(Integer saleLadder) {
		this.saleLadder = saleLadder;
	}

	/**
	 * @mbggenerated 几户
	 */
	public Integer getSaleDoors() {
		return saleDoors;
	}

	/**
	 * @mbggenerated 几户
	 */
	public void setSaleDoors(Integer saleDoors) {
		this.saleDoors = saleDoors;
	}

	/**
	 * @mbggenerated 几房/几室
	 */
	public Byte getSaleRoom() {
		return saleRoom;
	}

	/**
	 * @mbggenerated 几房/几室
	 */
	public void setSaleRoom(Byte saleRoom) {
		this.saleRoom = saleRoom;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public Byte getSaleHall() {
		return saleHall;
	}

	/**
	 * @mbggenerated 几厅
	 */
	public void setSaleHall(Byte saleHall) {
		this.saleHall = saleHall;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public Byte getSaleWei() {
		return saleWei;
	}

	/**
	 * @mbggenerated 几卫
	 */
	public void setSaleWei(Byte saleWei) {
		this.saleWei = saleWei;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public Byte getSaleYang() {
		return saleYang;
	}

	/**
	 * @mbggenerated 阳台
	 */
	public void setSaleYang(Byte saleYang) {
		this.saleYang = saleYang;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public Byte getSaleType() {
		return saleType;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public void setSaleType(Byte saleType) {
		this.saleType = saleType;
	}

	/**
	 * @mbggenerated 楼层
	 */
	public Short getSaleFloor() {
		return saleFloor;
	}

	/**
	 * @mbggenerated 楼层
	 */
	public void setSaleFloor(Short saleFloor) {
		this.saleFloor = saleFloor;
	}

	/**
	 * @mbggenerated 总楼层
	 */
	public Integer getSaleFloors() {
		return saleFloors;
	}

	/**
	 * @mbggenerated 总楼层
	 */
	public void setSaleFloors(Integer saleFloors) {
		this.saleFloors = saleFloors;
	}

	/**
	 * @mbggenerated 装修，DD:HOUSE_FITMENT
	 */
	public Byte getSaleFitment() {
		return saleFitment;
	}

	/**
	 * @mbggenerated 装修，DD:HOUSE_FITMENT
	 */
	public void setSaleFitment(Byte saleFitment) {
		this.saleFitment = saleFitment;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public Byte getSaleDirect() {
		return saleDirect;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public void setSaleDirect(Byte saleDirect) {
		this.saleDirect = saleDirect;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public Short getSaleYear() {
		return saleYear;
	}

	/**
	 * @mbggenerated 房屋年代
	 */
	public void setSaleYear(Short saleYear) {
		this.saleYear = saleYear;
	}

	/**
	 * @mbggenerated 房屋结构，DD:HOUSE_STRUCT
	 */
	public Byte getSaleStruct() {
		return saleStruct;
	}

	/**
	 * @mbggenerated 房屋结构，DD:HOUSE_STRUCT
	 */
	public void setSaleStruct(Byte saleStruct) {
		this.saleStruct = saleStruct;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public Byte getSaleUseage() {
		return saleUseage;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public void setSaleUseage(Byte saleUseage) {
		this.saleUseage = saleUseage;
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
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public Boolean getSaleStreet() {
		return saleStreet;
	}

	/**
	 * @mbggenerated 是否邻街，1=是0=否
	 */
	public void setSaleStreet(Boolean saleStreet) {
		this.saleStreet = saleStreet;
	}

	/**
	 * @mbggenerated 产权，DD:HOUSE_RIGHT
	 */
	public Byte getSaleRight() {
		return saleRight;
	}

	/**
	 * @mbggenerated 产权，DD:HOUSE_RIGHT
	 */
	public void setSaleRight(Byte saleRight) {
		this.saleRight = saleRight;
	}

	/**
	 * @mbggenerated 现状(按揭)，DD:HOUSE_STITUAT
	 */
	public String getSaleMortgage() {
		return saleMortgage;
	}

	/**
	 * @mbggenerated 现状(按揭)，DD:HOUSE_STITUAT
	 */
	public void setSaleMortgage(String saleMortgage) {
		this.saleMortgage = saleMortgage;
	}

	/**
	 * @mbggenerated 结算，DD:HOUSE_ACCOUNT
	 */
	public String getSaleAccount() {
		return saleAccount;
	}

	/**
	 * @mbggenerated 结算，DD:HOUSE_ACCOUNT
	 */
	public void setSaleAccount(String saleAccount) {
		this.saleAccount = saleAccount;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public BigDecimal getSaleArea() {
		return saleArea;
	}

	/**
	 * @mbggenerated 建筑面积
	 */
	public void setSaleArea(BigDecimal saleArea) {
		this.saleArea = saleArea;
	}

	/**
	 * @mbggenerated 售价
	 */
	public BigDecimal getSaleTotalPrice() {
		return saleTotalPrice;
	}

	/**
	 * @mbggenerated 售价
	 */
	public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
		this.saleTotalPrice = saleTotalPrice;
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
	 * @mbggenerated 底价
	 */
	public BigDecimal getSaleLowestPrice() {
		return saleLowestPrice;
	}

	/**
	 * @mbggenerated 底价
	 */
	public void setSaleLowestPrice(BigDecimal saleLowestPrice) {
		this.saleLowestPrice = saleLowestPrice;
	}

	/**
	 * @mbggenerated 物业费
	 */
	public BigDecimal getSaleProperty() {
		return saleProperty;
	}

	/**
	 * @mbggenerated 物业费
	 */
	public void setSaleProperty(BigDecimal saleProperty) {
		this.saleProperty = saleProperty;
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
	 * @mbggenerated 腾房日
	 */
	public String getSaleLeaveTime() {
		return saleLeaveTime;
	}

	/**
	 * @mbggenerated 腾房日
	 */
	public void setSaleLeaveTime(String saleLeaveTime) {
		this.saleLeaveTime = saleLeaveTime;
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
	public Byte getUgType() {
		return ugType;
	}

	/**
	 * @mbggenerated 地下类型，DD:UG_TYPE
	 */
	public void setUgType(Byte ugType) {
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
	public Byte getGarageAmount() {
		return garageAmount;
	}

	/**
	 * @mbggenerated 车位数量
	 */
	public void setGarageAmount(Byte garageAmount) {
		this.garageAmount = garageAmount;
	}

	/**
	 * @mbggenerated 配套及特色
	 */
	public String getSaleCharact() {
		return saleCharact;
	}

	/**
	 * @mbggenerated 配套及特色
	 */
	public void setSaleCharact(String saleCharact) {
		this.saleCharact = saleCharact;
	}

	/**
	 * @mbggenerated 内部备注
	 */
	public String getSaleMemo() {
		return saleMemo;
	}

	/**
	 * @mbggenerated 内部备注
	 */
	public void setSaleMemo(String saleMemo) {
		this.saleMemo = saleMemo;
	}

	/**
	 * @mbggenerated 信息来源，DD:HOUSE_SOURCE
	 */
	public Byte getSaleSource() {
		return saleSource;
	}

	/**
	 * @mbggenerated 信息来源，DD:HOUSE_SOURCE
	 */
	public void setSaleSource(Byte saleSource) {
		this.saleSource = saleSource;
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public Boolean getSaleKey() {
		return saleKey;
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public void setSaleKey(Boolean saleKey) {
		this.saleKey = saleKey;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public String getSaleKeyNum() {
		return saleKeyNum;
	}

	/**
	 * @mbggenerated 钥匙编号
	 */
	public void setSaleKeyNum(String saleKeyNum) {
		this.saleKeyNum = saleKeyNum;
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
	 * @mbggenerated 房勘，1=已勘0=未勘
	 */
	public Boolean getSaleExplrth() {
		return saleExplrth;
	}

	/**
	 * @mbggenerated 房勘，1=已勘0=未勘
	 */
	public void setSaleExplrth(Boolean saleExplrth) {
		this.saleExplrth = saleExplrth;
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
	 * @mbggenerated 委托，DD: HOUSE_CONSIGN
	 */
	public Byte getSaleConsign() {
		return saleConsign;
	}

	/**
	 * @mbggenerated 委托，DD: HOUSE_CONSIGN
	 */
	public void setSaleConsign(Byte saleConsign) {
		this.saleConsign = saleConsign;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public String getSaleConsignNo() {
		return saleConsignNo;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public void setSaleConsignNo(String saleConsignNo) {
		this.saleConsignNo = saleConsignNo;
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
	 * @mbggenerated 是否合作，1=是0=否（弃用-2018-05-25-陈文超）
	 */
	public Boolean getSaleCooperate() {
		return saleCooperate;
	}

	/**
	 * @mbggenerated 是否合作，1=是0=否（弃用-2018-05-25-陈文超）
	 */
	public void setSaleCooperate(Boolean saleCooperate) {
		this.saleCooperate = saleCooperate;
	}

	/**
	 * @mbggenerated 营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0
	 */
	public Boolean getSalePublish() {
		return salePublish;
	}

	/**
	 * @mbggenerated 营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0
	 */
	public void setSalePublish(Boolean salePublish) {
		this.salePublish = salePublish;
	}

	/**
	 * @mbggenerated 图片张数，默认=0
	 */
	public Byte getSaleMap() {
		return saleMap;
	}

	/**
	 * @mbggenerated 图片张数，默认=0
	 */
	public void setSaleMap(Byte saleMap) {
		this.saleMap = saleMap;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public Byte getSaleLevel() {
		return saleLevel;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public void setSaleLevel(Byte saleLevel) {
		this.saleLevel = saleLevel;
	}

	/**
	 * @mbggenerated 盘别，DD：PLATE_TYPE
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated 盘别，DD：PLATE_TYPE
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public Byte getSaleStatus() {
		return saleStatus;
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public void setSaleStatus(Byte saleStatus) {
		this.saleStatus = saleStatus;
	}

	/**
	 * @mbggenerated 最后跟进日期(ge)
	 */
	public Date getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated 最后跟进日期(ge)
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
	 * @mbggenerated 房勘计时起始时间
	 */
	public Date getActionTime() {
		return actionTime;
	}

	/**
	 * @mbggenerated 房勘计时起始时间
	 */
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	/**
	 * @mbggenerated 是否从搜搜获得，1=是0=否
	 */
	public Boolean getFromSoso() {
		return fromSoso;
	}

	/**
	 * @mbggenerated 是否从搜搜获得，1=是0=否
	 */
	public void setFromSoso(Boolean fromSoso) {
		this.fromSoso = fromSoso;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复
	 */
	public Byte getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复
	 */
	public void setRepeatFlag(Byte repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated 房源类型（全城联网中查询条件：INFO_TYPE<2），0=门店版1=精英版2=已转房源默认=0  3=开单豹
	 */
	public Byte getInfoType() {
		return infoType;
	}

	/**
	 * @mbggenerated 房源类型（全城联网中查询条件：INFO_TYPE<2），0=门店版1=精英版2=已转房源默认=0  3=开单豹
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
	 * @mbggenerated 投诉成功标记，1=被投诉0未投诉
	 */
	public Boolean getComplaintFlag() {
		return complaintFlag;
	}

	/**
	 * @mbggenerated 投诉成功标记，1=被投诉0未投诉
	 */
	public void setComplaintFlag(Boolean complaintFlag) {
		this.complaintFlag = complaintFlag;
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
	 * @mbggenerated 红色警示，1=是0=否（房源是房堪，客源是带看）
	 */
	public Boolean getRedFlag() {
		return redFlag;
	}

	/**
	 * @mbggenerated 红色警示，1=是0=否（房源是房堪，客源是带看）
	 */
	public void setRedFlag(Boolean redFlag) {
		this.redFlag = redFlag;
	}

	/**
	 * @mbggenerated 橙色警示，1=是0=否(带跟进)
	 */
	public Boolean getOrangeFlag() {
		return orangeFlag;
	}

	/**
	 * @mbggenerated 橙色警示，1=是0=否(带跟进)
	 */
	public void setOrangeFlag(Boolean orangeFlag) {
		this.orangeFlag = orangeFlag;
	}

	/**
	 * @mbggenerated 转抢盘次数，默认=0
	 */
	public Integer getPublicCount() {
		return publicCount;
	}

	/**
	 * @mbggenerated 转抢盘次数，默认=0
	 */
	public void setPublicCount(Integer publicCount) {
		this.publicCount = publicCount;
	}

	/**
	 * @mbggenerated 转抢盘日期
	 */
	public Date getPublicTime() {
		return publicTime;
	}

	/**
	 * @mbggenerated 转抢盘日期
	 */
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
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
	 * @mbggenerated 转私盘时间
	 */
	public Date getPrivateTime() {
		return privateTime;
	}

	/**
	 * @mbggenerated 转私盘时间
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
	public Date getSaleCertTime() {
		return saleCertTime;
	}

	/**
	 * @mbggenerated 出证日期
	 */
	public void setSaleCertTime(Date saleCertTime) {
		this.saleCertTime = saleCertTime;
	}

	/**
	 * @mbggenerated 各网站的发布状态腾讯 ― 10进位上微店 －个进位上，以位表示：1＝否2＝是
	 */
	public Integer getPublishSites() {
		return publishSites;
	}

	/**
	 * @mbggenerated 各网站的发布状态腾讯 ― 10进位上微店 －个进位上，以位表示：1＝否2＝是
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
	public String getSaleRoofT() {
		return saleRoofT;
	}

	/**
	 * @mbggenerated 栋（明文）
	 */
	public void setSaleRoofT(String saleRoofT) {
		this.saleRoofT = saleRoofT;
	}

	/**
	 * @mbggenerated 房号（明文）
	 */
	public String getSaleNumT() {
		return saleNumT;
	}

	/**
	 * @mbggenerated 房号（明文）
	 */
	public void setSaleNumT(String saleNumT) {
		this.saleNumT = saleNumT;
	}

	/**
	 * @mbggenerated 单元（明文）
	 */
	public String getSaleUnitT() {
		return saleUnitT;
	}

	/**
	 * @mbggenerated 单元（明文）
	 */
	public void setSaleUnitT(String saleUnitT) {
		this.saleUnitT = saleUnitT;
	}

	/**
	 * @mbggenerated 视频数量，Def：0
	 */
	public Byte getVideoNum() {
		return videoNum;
	}

	/**
	 * @mbggenerated 视频数量，Def：0
	 */
	public void setVideoNum(Byte videoNum) {
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
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1，2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据
	 */
	public Byte getIsIgnore() {
		return isIgnore;
	}

	/**
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1，2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据
	 */
	public void setIsIgnore(Byte isIgnore) {
		this.isIgnore = isIgnore;
	}

	/**
	 * @mbggenerated 老版center库对应的SALE_ID，Def: 0
	 */
	public Integer getSaleIdOld() {
		return saleIdOld;
	}

	/**
	 * @mbggenerated 老版center库对应的SALE_ID，Def: 0
	 */
	public void setSaleIdOld(Integer saleIdOld) {
		this.saleIdOld = saleIdOld;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public BigDecimal getSaleInnerarea() {
		return saleInnerarea;
	}

	/**
	 * @mbggenerated 套内面积
	 */
	public void setSaleInnerarea(BigDecimal saleInnerarea) {
		this.saleInnerarea = saleInnerarea;
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
	 * @mbggenerated 是否编码 - 已废弃
	 */
	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	/**
	 * @mbggenerated 是否编码 - 已废弃
	 */
	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	/**
	 * @mbggenerated 锁定标记  - 已废弃
	 */
	public Byte getLock() {
		return lock;
	}

	/**
	 * @mbggenerated 锁定标记  - 已废弃
	 */
	public void setLock(Byte lock) {
		this.lock = lock;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源  3=正在投诉中4=投诉后连带下架（不在优优展示）
	 */
	public Byte getTrueFlag() {
		return trueFlag;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源  3=正在投诉中4=投诉后连带下架（不在优优展示）
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
	 * @mbggenerated 房源数据是否操作过发发功能1：本地2：发发关联3：发发转入
	 */
	public Byte getHouseSourceWay() {
		return houseSourceWay;
	}

	/**
	 * @mbggenerated 房源数据是否操作过发发功能1：本地2：发发关联3：发发转入
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
	 * @mbggenerated 房源栋座号的MD5码
	 */
	public String getAddrMd5() {
		return addrMd5;
	}

	/**
	 * @mbggenerated 房源栋座号的MD5码
	 */
	public void setAddrMd5(String addrMd5) {
		this.addrMd5 = addrMd5;
	}

	/**
	 * @mbggenerated 720相机图片有多少张
	 */
	public Integer getPanoramaMap() {
		return panoramaMap;
	}

	/**
	 * @mbggenerated 720相机图片有多少张
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
	 * @mbggenerated 鸿基广告房源
	 */
	public Byte getAdsFlag() {
		return adsFlag;
	}

	/**
	 * @mbggenerated 鸿基广告房源
	 */
	public void setAdsFlag(Byte adsFlag) {
		this.adsFlag = adsFlag;
	}

	/**
	 * @mbggenerated 第三方同步时间，修改房源数据时修改这个时间
	 */
	public Date getSyncTime() {
		return syncTime;
	}

	/**
	 * @mbggenerated 第三方同步时间，修改房源数据时修改这个时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	/**
	 * @mbggenerated 视频审核标记 0=未审核 1=审核通过 2=审核失败
	 */
	public Byte getVideoReviewFlag() {
		return videoReviewFlag;
	}

	/**
	 * @mbggenerated 视频审核标记 0=未审核 1=审核通过 2=审核失败
	 */
	public void setVideoReviewFlag(Byte videoReviewFlag) {
		this.videoReviewFlag = videoReviewFlag;
	}

	/**
	 * @mbggenerated VR显示标记 0=不显示（crm审核不通过） 1=显示
	 */
	public Byte getHasPanorama() {
		return hasPanorama;
	}

	/**
	 * @mbggenerated VR显示标记 0=不显示（crm审核不通过） 1=显示
	 */
	public void setHasPanorama(Byte hasPanorama) {
		this.hasPanorama = hasPanorama;
	}

	/**
	 * @mbggenerated 是否竞价0否1是
	 */
	public Boolean getBiddingFlag() {
		return biddingFlag;
	}

	/**
	 * @mbggenerated 是否竞价0否1是
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
	 * @mbggenerated 核验编号
	 */
	public String getCheckCodeFun() {
		return checkCodeFun;
	}

	/**
	 * @mbggenerated 核验编号
	 */
	public void setCheckCodeFun(String checkCodeFun) {
		this.checkCodeFun = checkCodeFun;
	}

	/**
	 * @mbggenerated 委托书url
	 */
	public String getProxyUrl() {
		return proxyUrl;
	}

	/**
	 * @mbggenerated 委托书url
	 */
	public void setProxyUrl(String proxyUrl) {
		this.proxyUrl = proxyUrl;
	}

	/**
	 * @mbggenerated 权证编号
	 */
	public String getQzCodeFun() {
		return qzCodeFun;
	}

	/**
	 * @mbggenerated 权证编号
	 */
	public void setQzCodeFun(String qzCodeFun) {
		this.qzCodeFun = qzCodeFun;
	}

	/**
	 * @mbggenerated 核验编号图片所在地址
	 */
	public String getCheckCodeUrl() {
		return checkCodeUrl;
	}

	/**
	 * @mbggenerated 核验编号图片所在地址
	 */
	public void setCheckCodeUrl(String checkCodeUrl) {
		this.checkCodeUrl = checkCodeUrl;
	}

	/**
	 * @mbggenerated 委托书上传人
	 */
	public String getUploadProxyUser() {
		return uploadProxyUser;
	}

	/**
	 * @mbggenerated 委托书上传人
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
	 * @mbggenerated 暂时没有使用-但是线上sql脚本已经生成，删除该字段时候注意检查线上环境-陈文超
	 */
	public Integer getCompId2() {
		return compId2;
	}

	/**
	 * @mbggenerated 暂时没有使用-但是线上sql脚本已经生成，删除该字段时候注意检查线上环境-陈文超
	 */
	public void setCompId2(Integer compId2) {
		this.compId2 = compId2;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public Byte getFileSystemType() {
		return fileSystemType;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public void setFileSystemType(Byte fileSystemType) {
		this.fileSystemType = fileSystemType;
	}

	/**
	 * @mbggenerated 权属类型DD：OWNERSHIP_TYPE
	 */
	public Byte getOwnershipType() {
		return ownershipType;
	}

	/**
	 * @mbggenerated 权属类型DD：OWNERSHIP_TYPE
	 */
	public void setOwnershipType(Byte ownershipType) {
		this.ownershipType = ownershipType;
	}

	/**
	 * @mbggenerated 房源有效期号
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @mbggenerated 房源有效期号
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @mbggenerated --房管局销售状态 DD:FUNMANAGER_SALESTATUS数据字典按城市分
	 */
	public Byte getFunmanagerSalestatus() {
		return funmanagerSalestatus;
	}

	/**
	 * @mbggenerated --房管局销售状态 DD:FUNMANAGER_SALESTATUS数据字典按城市分
	 */
	public void setFunmanagerSalestatus(Byte funmanagerSalestatus) {
		this.funmanagerSalestatus = funmanagerSalestatus;
	}

	/**
	 * @mbggenerated 首次房堪标记0=代表还没有房堪1=已经房堪，已废弃，使用 SALE_EXPLRTH 字段
	 */
	public Byte getHasFunkan() {
		return hasFunkan;
	}

	/**
	 * @mbggenerated 首次房堪标记0=代表还没有房堪1=已经房堪，已废弃，使用 SALE_EXPLRTH 字段
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
	 * @mbggenerated 可租售ID，和FUN_LEASE对应，只会一对一
	 */
	public Integer getSaleLeaseId() {
		return saleLeaseId;
	}

	/**
	 * @mbggenerated 可租售ID，和FUN_LEASE对应，只会一对一
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
	 * @mbggenerated 委托截止时间 
	 */
	public Date getEntrustEndTime() {
		return entrustEndTime;
	}

	/**
	 * @mbggenerated 委托截止时间 
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
	 * @mbggenerated 房屋现状，DD：HOUSE_SITUATION
	 */
	public Byte getHouseSituation() {
		return houseSituation;
	}

	/**
	 * @mbggenerated 房屋现状，DD：HOUSE_SITUATION
	 */
	public void setHouseSituation(Byte houseSituation) {
		this.houseSituation = houseSituation;
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
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证
	 */
	public Integer getJointIdCardType() {
		return jointIdCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证
	 */
	public void setJointIdCardType(Integer jointIdCardType) {
		this.jointIdCardType = jointIdCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证
	 */
	public Integer getIdCardType() {
		return idCardType;
	}

	/**
	 * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证
	 */
	public void setIdCardType(Integer idCardType) {
		this.idCardType = idCardType;
	}

	/**
	 * @mbggenerated 开间
	 */
	public BigDecimal getSaleBay() {
		return saleBay;
	}

	/**
	 * @mbggenerated 开间
	 */
	public void setSaleBay(BigDecimal saleBay) {
		this.saleBay = saleBay;
	}

	/**
	 * @mbggenerated 进深
	 */
	public BigDecimal getSaleDepth() {
		return saleDepth;
	}

	/**
	 * @mbggenerated 进深
	 */
	public void setSaleDepth(BigDecimal saleDepth) {
		this.saleDepth = saleDepth;
	}

	/**
	 * @mbggenerated 层高
	 */
	public BigDecimal getSaleStorey() {
		return saleStorey;
	}

	/**
	 * @mbggenerated 层高
	 */
	public void setSaleStorey(BigDecimal saleStorey) {
		this.saleStorey = saleStorey;
	}

	/**
	 * @mbggenerated 房屋结构：DD：HOUSE_GRADATION
	 */
	public Byte getSaleGradation() {
		return saleGradation;
	}

	/**
	 * @mbggenerated 房屋结构：DD：HOUSE_GRADATION
	 */
	public void setSaleGradation(Byte saleGradation) {
		this.saleGradation = saleGradation;
	}

	/**
	 * @mbggenerated 产权性质：DD：HOUSE_NATURE
	 */
	public Byte getSaleNature() {
		return saleNature;
	}

	/**
	 * @mbggenerated 产权性质：DD：HOUSE_NATURE
	 */
	public void setSaleNature(Byte saleNature) {
		this.saleNature = saleNature;
	}

	/**
	 * @mbggenerated 别墅类型：DD：VILLA_TYPE
	 */
	public Byte getVillaType() {
		return villaType;
	}

	/**
	 * @mbggenerated 别墅类型：DD：VILLA_TYPE
	 */
	public void setVillaType(Byte villaType) {
		this.villaType = villaType;
	}

	/**
	 * @mbggenerated 建筑风格：DD：HOUSE_STYLE
	 */
	public Byte getSaleStyle() {
		return saleStyle;
	}

	/**
	 * @mbggenerated 建筑风格：DD：HOUSE_STYLE
	 */
	public void setSaleStyle(Byte saleStyle) {
		this.saleStyle = saleStyle;
	}

	/**
	 * @mbggenerated 功能类型：DD：ACTION_TYPE
	 */
	public Byte getActionType() {
		return actionType;
	}

	/**
	 * @mbggenerated 功能类型：DD：ACTION_TYPE
	 */
	public void setActionType(Byte actionType) {
		this.actionType = actionType;
	}

	/**
	 * @mbggenerated 景观类型：DD：SCENERY_TYPE
	 */
	public Byte getSceneryType() {
		return sceneryType;
	}

	/**
	 * @mbggenerated 景观类型：DD：SCENERY_TYPE
	 */
	public void setSceneryType(Byte sceneryType) {
		this.sceneryType = sceneryType;
	}

	/**
	 * @mbggenerated 收款方式：DD：RECEIPT_TYPE
	 */
	public Byte getReceiptType() {
		return receiptType;
	}

	/**
	 * @mbggenerated 收款方式：DD：RECEIPT_TYPE
	 */
	public void setReceiptType(Byte receiptType) {
		this.receiptType = receiptType;
	}

	/**
	 * @mbggenerated 抵押情况：DD：GUARANTY_TYPE
	 */
	public Byte getGuarantyType() {
		return guarantyType;
	}

	/**
	 * @mbggenerated 抵押情况：DD：GUARANTY_TYPE
	 */
	public void setGuarantyType(Byte guarantyType) {
		this.guarantyType = guarantyType;
	}

	/**
	 * @mbggenerated 看房时间
	 */
	public String getCheckTime() {
		return checkTime;
	}

	/**
	 * @mbggenerated 看房时间
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @mbggenerated 转聚焦日期-笋盘
	 */
	public Date getFocusTime() {
		return focusTime;
	}

	/**
	 * @mbggenerated 转聚焦日期-笋盘
	 */
	public void setFocusTime(Date focusTime) {
		this.focusTime = focusTime;
	}

	/**
	 * @mbggenerated 用户层级-房基地、新版组织架构保存的是机构定义表中的数据ID
	 */
	public Integer getUserLevel() {
		return userLevel;
	}

	/**
	 * @mbggenerated 用户层级-房基地、新版组织架构保存的是机构定义表中的数据ID
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
	 * @mbggenerated 购入价
	 */
	public BigDecimal getSaleBuyPrice() {
		return saleBuyPrice;
	}

	/**
	 * @mbggenerated 购入价
	 */
	public void setSaleBuyPrice(BigDecimal saleBuyPrice) {
		this.saleBuyPrice = saleBuyPrice;
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
	 * @mbggenerated 房勘人UserID
	 */
	public Integer getFunkanUserId() {
		return funkanUserId;
	}

	/**
	 * @mbggenerated 房勘人UserID
	 */
	public void setFunkanUserId(Integer funkanUserId) {
		this.funkanUserId = funkanUserId;
	}

	/**
	 * @mbggenerated 钥匙人User_ID
	 */
	public Integer getSaleKeyUserId() {
		return saleKeyUserId;
	}

	/**
	 * @mbggenerated 钥匙人User_ID
	 */
	public void setSaleKeyUserId(Integer saleKeyUserId) {
		this.saleKeyUserId = saleKeyUserId;
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
	 * @mbggenerated 按揭银行
	 */
	public String getMortgageBank() {
		return mortgageBank;
	}

	/**
	 * @mbggenerated 按揭银行
	 */
	public void setMortgageBank(String mortgageBank) {
		this.mortgageBank = mortgageBank;
	}

	/**
	 * @mbggenerated 按揭欠款
	 */
	public BigDecimal getArrears() {
		return arrears;
	}

	/**
	 * @mbggenerated 按揭欠款
	 */
	public void setArrears(BigDecimal arrears) {
		this.arrears = arrears;
	}

	/**
	 * @mbggenerated 当前租金
	 */
	public BigDecimal getCurrentRent() {
		return currentRent;
	}

	/**
	 * @mbggenerated 当前租金
	 */
	public void setCurrentRent(BigDecimal currentRent) {
		this.currentRent = currentRent;
	}

	/**
	 * @mbggenerated 回报率
	 */
	public BigDecimal getTurnRate() {
		return turnRate;
	}

	/**
	 * @mbggenerated 回报率
	 */
	public void setTurnRate(BigDecimal turnRate) {
		this.turnRate = turnRate;
	}

	/**
	 * @mbggenerated 房源是否需要审核 0=正常登记 1=审核中 2=审核不通过 3=申诉中
	 */
	public Byte getHouseVerify() {
		return houseVerify;
	}

	/**
	 * @mbggenerated 房源是否需要审核 0=正常登记 1=审核中 2=审核不通过 3=申诉中
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
	 * @mbggenerated 组织机构ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 出租转到期时间
	 */
	public Date getLeaseExpirationTime() {
		return leaseExpirationTime;
	}

	/**
	 * @mbggenerated 出租转到期时间
	 */
	public void setLeaseExpirationTime(Date leaseExpirationTime) {
		this.leaseExpirationTime = leaseExpirationTime;
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
	public BigDecimal getSaleEntrustPrice() {
		return saleEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSaleEntrustPrice(BigDecimal saleEntrustPrice) {
		this.saleEntrustPrice = saleEntrustPrice;
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
	public Date getSaleAmountChangeTime() {
		return saleAmountChangeTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSaleAmountChangeTime(Date saleAmountChangeTime) {
		this.saleAmountChangeTime = saleAmountChangeTime;
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
	public ErpFunSale() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSale(Integer shardCityId, Integer saleId) {
		super(shardCityId);
		this.saleId = saleId;
	}

	public void hideCoreInfo(String isShowHouseRoof, String isShowHouseUnit, String isShowHouseNum, String showShopOtherAddr) {
		if("0".equals(isShowHouseRoof)) {
			this.saleRoofT = "-";
		}
		if("0".equals(isShowHouseUnit)) {
			this.saleUnitT = "-";
		}
		if("0".equals(isShowHouseNum)) {
			this.saleNumT = "-";
		}
		if(showShopOtherAddr==null || "0".equals(showShopOtherAddr)) {
			if(Const.DIC_HOUSE_USEAGE_TRADE.equals(this.saleUseage)) {
				this.tradeAddr = "-";
			}
		}
	}
}