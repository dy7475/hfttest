package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunBuyCustomer extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "求购ID，自增序列")
	private Integer buyCustId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司区域ID，From:FUN_REGION")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人门店ID，From:FUN_USER")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人档案ID，与USER_ID对应的ARCHIVE_ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记时间")
	private String creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录人USER_ID")
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "原始登记人ID，该ID移交数据时不变，用于经纪人脱离门店版后的数据复制")
	private Integer createArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户编码")
	private String buyCustNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户姓名")
	private String buyCustName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户性别，1=先生0=女士")
	private Boolean buyCustSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户年龄，DD:AGE_TYPE")
	private Byte buyCustAge;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "职业，DD:CAREER_TYPE")
	private Byte buyCustCareer;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手机号码")
	private String cellPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "身份证（保存的是加密串，长度为36）")
	private String idCard;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地址")
	private String custAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "生活圈")
	private String buyLifebound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购房目的，DD:GOAL_TYPE")
	private Byte buyGoal;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "需求期限，DD:LENGTH_TYPE")
	private Byte buyLength;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购买能力，DD:ABILITY_TYPE")
	private Byte buyAbility;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "付款方式，DD:BUY_PAYTYPE")
	private Byte buyPaytype;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户等级，{1、2、3、4}")
	private String custLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "盘别，DD：PLATE_TYPE")
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "来源，DD:HOUSE_SOURCE")
	private Byte buyCustSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "级别，DD: HOUSE_LEVEL")
	private Byte buyCustLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房1")
	private Byte houseRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房2")
	private Byte houseRoom1;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区IDS")
	private String houseRegion;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区名称")
	private String regionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区IDS，板块IDS")
	private String sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区名称，板块名称")
	private String sectionName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘IDS")
	private String buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘名称")
	private String buildName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "环域，DD:HOUSE_ROUND")
	private String houseRound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋类型，DD: HOUSE_TYPE")
	private String houseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋用途，DD:HOUSE_USEAGE")
	private String houseUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "装修情况，DD:HOUSE_FITMENT")
	private Byte houseFitment;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源朝向，DD：HOUSE_DIRECT")
	private String houseDirect;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层1")
	private Short houseFloorLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层2")
	private Short houseFloorHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格1")
	private BigDecimal housePriceLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格2")
	private BigDecimal housePriceHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "面积1")
	private BigDecimal houseAreaLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "面积2")
	private BigDecimal houseAreaHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "年代1，10000 代指空")
	private Short houseYearLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "年代2，10000 代指空")
	private Short houseYearHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否带看，1=是0=否")
	private Boolean houseLook;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户补充需求")
	private String custRequest;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户情况备注")
	private String custMemo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息状态，DD: HOUSE_STATUS")
	private Byte buyCustStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后跟进日期")
	private String trackTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息重复标记，0=否1=是")
	private Boolean repeatFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型，（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0")
	private Byte infoType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "精英版登记，1=是0=否")
	private Boolean shareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "红色警示，1=是0=否")
	private Boolean redFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "橙色警示，1=是0=否")
	private Boolean orangeFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转公盘次数，默认=0")
	private Integer publicCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转公盘日期")
	private String publicTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转封盘日期")
	private String specialTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转转预定日期")
	private String scheduleTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转成交日期")
	private String dealTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转注销日期")
	private String writeoffTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转加密日期")
	private String secrecyTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转推荐日期")
	private String commendTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看起始计时时间")
	private String actionTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘时间")
	private String privateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否转自抢盘，1=是0=否")
	private Boolean fromPublic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作状态 1=合作")
	private Integer cooperateFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作的房子")
	private Byte friendHouse;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作时间")
	private Date cooperateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "投诉成功标记，1=被投诉0 or null 未投诉")
	private Boolean complaintFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司大区ID，From:FUN_AREA")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对于批量导入的数据，如果不想进入策略控制，就把该字段设置成1，Def: 0  2：试用初始化导入的数据")
	private Byte isIgnore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "U+分享标记 0 未分享 1 已分享")
	private Byte youShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "U+分享时间")
	private Date youShareTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购买次数")
	private Integer youBuyCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转抢盘用户的USER_ID,用于判断自己的抢盘的数据不能再次抢盘")
	private Integer privateUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后开放接口同步时间")
	private Date syncTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市公盘分享表ID")
	private Integer youShareId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "封盘保护结束时间")
	private Date specialEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "预订保护结束时间")
	private Date scheduleEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市大公盘分享状态 0=下架 1=上架")
	private Byte cityShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "意向干道ID，多个空格分隔")
	private String roadsId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "意向干道名字，多个空格分隔")
	private String roadsName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "暂缓保护到期时间")
	private Date respiteEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte isSaleLease;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "初始为登记时间，转有效之后为转有效的时间，主要用于房客源列表排序")
	private Date availableTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "	房堪时间，最近带看时间，带看跟进写成功之后，需更新该字段")
	private Date lastDkanTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "微信号")
	private String wechatNumber;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户头像")
	private String custPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证")
	private Integer idCardType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购房资格，DD:BUY_QUALIFY")
	private Byte buyQualify;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购买的第几套房，DD: BUY_NUM")
	private Byte buyNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户当前状态，DD: CURRENT_STATUS")
	private Byte buyCurrentStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "购房征信情况:DD:CREDIT_TYPE")
	private Byte credit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "交通工具：DD:VEHICLE_TYPE")
	private Byte vehicle;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户心态：DD:MENTALITY_TYPE")
	private Byte mentality;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "C端用户ID")
	private Integer cUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户成级")
	private Integer userLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织架构线")
	private String tissueLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID-关联加盟商表：直营的组织机构为：-1、总部为：0、加盟商的ID > 0")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户渠道来源-字典：CUST_SOURCE")
	private Integer custSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源意向：1二手房、2新房")
	private Integer custIntention;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于 客户姓名仅限姓氏或姓氏+性别（如李、李先生、张女士）楼盘名称环域，DD:HOUSE_ROUND客户补充需求，客户标签 模糊查询")
	private String fuzzySearch;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 求购ID，自增序列
	 */
	public Integer getBuyCustId() {
		return buyCustId;
	}

	/**
	 * @mbggenerated 求购ID，自增序列
	 */
	public void setBuyCustId(Integer buyCustId) {
		this.buyCustId = buyCustId;
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
	 * @mbggenerated 经纪人门店ID，From:FUN_USER
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人门店ID，From:FUN_USER
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
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 登记时间
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
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
	 * @mbggenerated 客户编码
	 */
	public String getBuyCustNo() {
		return buyCustNo;
	}

	/**
	 * @mbggenerated 客户编码
	 */
	public void setBuyCustNo(String buyCustNo) {
		this.buyCustNo = buyCustNo;
	}

	/**
	 * @mbggenerated 客户姓名
	 */
	public String getBuyCustName() {
		return buyCustName;
	}

	/**
	 * @mbggenerated 客户姓名
	 */
	public void setBuyCustName(String buyCustName) {
		this.buyCustName = buyCustName;
	}

	/**
	 * @mbggenerated 客户性别，1=先生0=女士
	 */
	public Boolean getBuyCustSex() {
		return buyCustSex;
	}

	/**
	 * @mbggenerated 客户性别，1=先生0=女士
	 */
	public void setBuyCustSex(Boolean buyCustSex) {
		this.buyCustSex = buyCustSex;
	}

	/**
	 * @mbggenerated 客户年龄，DD:AGE_TYPE
	 */
	public Byte getBuyCustAge() {
		return buyCustAge;
	}

	/**
	 * @mbggenerated 客户年龄，DD:AGE_TYPE
	 */
	public void setBuyCustAge(Byte buyCustAge) {
		this.buyCustAge = buyCustAge;
	}

	/**
	 * @mbggenerated 职业，DD:CAREER_TYPE
	 */
	public Byte getBuyCustCareer() {
		return buyCustCareer;
	}

	/**
	 * @mbggenerated 职业，DD:CAREER_TYPE
	 */
	public void setBuyCustCareer(Byte buyCustCareer) {
		this.buyCustCareer = buyCustCareer;
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
	 * @mbggenerated 身份证（保存的是加密串，长度为36）
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @mbggenerated 身份证（保存的是加密串，长度为36）
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @mbggenerated 地址
	 */
	public String getCustAddr() {
		return custAddr;
	}

	/**
	 * @mbggenerated 地址
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	/**
	 * @mbggenerated 生活圈
	 */
	public String getBuyLifebound() {
		return buyLifebound;
	}

	/**
	 * @mbggenerated 生活圈
	 */
	public void setBuyLifebound(String buyLifebound) {
		this.buyLifebound = buyLifebound;
	}

	/**
	 * @mbggenerated 购房目的，DD:GOAL_TYPE
	 */
	public Byte getBuyGoal() {
		return buyGoal;
	}

	/**
	 * @mbggenerated 购房目的，DD:GOAL_TYPE
	 */
	public void setBuyGoal(Byte buyGoal) {
		this.buyGoal = buyGoal;
	}

	/**
	 * @mbggenerated 需求期限，DD:LENGTH_TYPE
	 */
	public Byte getBuyLength() {
		return buyLength;
	}

	/**
	 * @mbggenerated 需求期限，DD:LENGTH_TYPE
	 */
	public void setBuyLength(Byte buyLength) {
		this.buyLength = buyLength;
	}

	/**
	 * @mbggenerated 购买能力，DD:ABILITY_TYPE
	 */
	public Byte getBuyAbility() {
		return buyAbility;
	}

	/**
	 * @mbggenerated 购买能力，DD:ABILITY_TYPE
	 */
	public void setBuyAbility(Byte buyAbility) {
		this.buyAbility = buyAbility;
	}

	/**
	 * @mbggenerated 付款方式，DD:BUY_PAYTYPE
	 */
	public Byte getBuyPaytype() {
		return buyPaytype;
	}

	/**
	 * @mbggenerated 付款方式，DD:BUY_PAYTYPE
	 */
	public void setBuyPaytype(Byte buyPaytype) {
		this.buyPaytype = buyPaytype;
	}

	/**
	 * @mbggenerated 客户等级，{1、2、3、4}
	 */
	public String getCustLevel() {
		return custLevel;
	}

	/**
	 * @mbggenerated 客户等级，{1、2、3、4}
	 */
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
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
	 * @mbggenerated 来源，DD:HOUSE_SOURCE
	 */
	public Byte getBuyCustSource() {
		return buyCustSource;
	}

	/**
	 * @mbggenerated 来源，DD:HOUSE_SOURCE
	 */
	public void setBuyCustSource(Byte buyCustSource) {
		this.buyCustSource = buyCustSource;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public Byte getBuyCustLevel() {
		return buyCustLevel;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public void setBuyCustLevel(Byte buyCustLevel) {
		this.buyCustLevel = buyCustLevel;
	}

	/**
	 * @mbggenerated 房1
	 */
	public Byte getHouseRoom() {
		return houseRoom;
	}

	/**
	 * @mbggenerated 房1
	 */
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	/**
	 * @mbggenerated 房2
	 */
	public Byte getHouseRoom1() {
		return houseRoom1;
	}

	/**
	 * @mbggenerated 房2
	 */
	public void setHouseRoom1(Byte houseRoom1) {
		this.houseRoom1 = houseRoom1;
	}

	/**
	 * @mbggenerated 行政区IDS
	 */
	public String getHouseRegion() {
		return houseRegion;
	}

	/**
	 * @mbggenerated 行政区IDS
	 */
	public void setHouseRegion(String houseRegion) {
		this.houseRegion = houseRegion;
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
	 * @mbggenerated 片区IDS，板块IDS
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated 片区IDS，板块IDS
	 */
	public void setSectionId(String sectionId) {
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
	 * @mbggenerated 楼盘IDS
	 */
	public String getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘IDS
	 */
	public void setBuildId(String buildId) {
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
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public String getHouseRound() {
		return houseRound;
	}

	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	public void setHouseRound(String houseRound) {
		this.houseRound = houseRound;
	}

	/**
	 * @mbggenerated 房屋类型，DD: HOUSE_TYPE
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated 房屋类型，DD: HOUSE_TYPE
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated 装修情况，DD:HOUSE_FITMENT
	 */
	public Byte getHouseFitment() {
		return houseFitment;
	}

	/**
	 * @mbggenerated 装修情况，DD:HOUSE_FITMENT
	 */
	public void setHouseFitment(Byte houseFitment) {
		this.houseFitment = houseFitment;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public String getHouseDirect() {
		return houseDirect;
	}

	/**
	 * @mbggenerated 房源朝向，DD：HOUSE_DIRECT
	 */
	public void setHouseDirect(String houseDirect) {
		this.houseDirect = houseDirect;
	}

	/**
	 * @mbggenerated 楼层1
	 */
	public Short getHouseFloorLow() {
		return houseFloorLow;
	}

	/**
	 * @mbggenerated 楼层1
	 */
	public void setHouseFloorLow(Short houseFloorLow) {
		this.houseFloorLow = houseFloorLow;
	}

	/**
	 * @mbggenerated 楼层2
	 */
	public Short getHouseFloorHigh() {
		return houseFloorHigh;
	}

	/**
	 * @mbggenerated 楼层2
	 */
	public void setHouseFloorHigh(Short houseFloorHigh) {
		this.houseFloorHigh = houseFloorHigh;
	}

	/**
	 * @mbggenerated 价格1
	 */
	public BigDecimal getHousePriceLow() {
		return housePriceLow;
	}

	/**
	 * @mbggenerated 价格1
	 */
	public void setHousePriceLow(BigDecimal housePriceLow) {
		this.housePriceLow = housePriceLow;
	}

	/**
	 * @mbggenerated 价格2
	 */
	public BigDecimal getHousePriceHigh() {
		return housePriceHigh;
	}

	/**
	 * @mbggenerated 价格2
	 */
	public void setHousePriceHigh(BigDecimal housePriceHigh) {
		this.housePriceHigh = housePriceHigh;
	}

	/**
	 * @mbggenerated 面积1
	 */
	public BigDecimal getHouseAreaLow() {
		return houseAreaLow;
	}

	/**
	 * @mbggenerated 面积1
	 */
	public void setHouseAreaLow(BigDecimal houseAreaLow) {
		this.houseAreaLow = houseAreaLow;
	}

	/**
	 * @mbggenerated 面积2
	 */
	public BigDecimal getHouseAreaHigh() {
		return houseAreaHigh;
	}

	/**
	 * @mbggenerated 面积2
	 */
	public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
		this.houseAreaHigh = houseAreaHigh;
	}

	/**
	 * @mbggenerated 年代1，10000 代指空
	 */
	public Short getHouseYearLow() {
		return houseYearLow;
	}

	/**
	 * @mbggenerated 年代1，10000 代指空
	 */
	public void setHouseYearLow(Short houseYearLow) {
		this.houseYearLow = houseYearLow;
	}

	/**
	 * @mbggenerated 年代2，10000 代指空
	 */
	public Short getHouseYearHigh() {
		return houseYearHigh;
	}

	/**
	 * @mbggenerated 年代2，10000 代指空
	 */
	public void setHouseYearHigh(Short houseYearHigh) {
		this.houseYearHigh = houseYearHigh;
	}

	/**
	 * @mbggenerated 是否带看，1=是0=否
	 */
	public Boolean getHouseLook() {
		return houseLook;
	}

	/**
	 * @mbggenerated 是否带看，1=是0=否
	 */
	public void setHouseLook(Boolean houseLook) {
		this.houseLook = houseLook;
	}

	/**
	 * @mbggenerated 客户补充需求
	 */
	public String getCustRequest() {
		return custRequest;
	}

	/**
	 * @mbggenerated 客户补充需求
	 */
	public void setCustRequest(String custRequest) {
		this.custRequest = custRequest;
	}

	/**
	 * @mbggenerated 客户情况备注
	 */
	public String getCustMemo() {
		return custMemo;
	}

	/**
	 * @mbggenerated 客户情况备注
	 */
	public void setCustMemo(String custMemo) {
		this.custMemo = custMemo;
	}

	/**
	 * @mbggenerated 信息状态，DD: HOUSE_STATUS
	 */
	public Byte getBuyCustStatus() {
		return buyCustStatus;
	}

	/**
	 * @mbggenerated 信息状态，DD: HOUSE_STATUS
	 */
	public void setBuyCustStatus(Byte buyCustStatus) {
		this.buyCustStatus = buyCustStatus;
	}

	/**
	 * @mbggenerated 最后跟进日期
	 */
	public String getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated 最后跟进日期
	 */
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否1=是
	 */
	public Boolean getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否1=是
	 */
	public void setRepeatFlag(Boolean repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated 房源类型，（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0
	 */
	public Byte getInfoType() {
		return infoType;
	}

	/**
	 * @mbggenerated 房源类型，（全城联网中查询条件：INFO_TYPE<2），0=企业版1=精英版2=已转房源 默认=0
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
	public String getPublicTime() {
		return publicTime;
	}

	/**
	 * @mbggenerated 转公盘日期
	 */
	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}

	/**
	 * @mbggenerated 转封盘日期
	 */
	public String getSpecialTime() {
		return specialTime;
	}

	/**
	 * @mbggenerated 转封盘日期
	 */
	public void setSpecialTime(String specialTime) {
		this.specialTime = specialTime;
	}

	/**
	 * @mbggenerated 转转预定日期
	 */
	public String getScheduleTime() {
		return scheduleTime;
	}

	/**
	 * @mbggenerated 转转预定日期
	 */
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	/**
	 * @mbggenerated 转成交日期
	 */
	public String getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated 转成交日期
	 */
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @mbggenerated 转注销日期
	 */
	public String getWriteoffTime() {
		return writeoffTime;
	}

	/**
	 * @mbggenerated 转注销日期
	 */
	public void setWriteoffTime(String writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	/**
	 * @mbggenerated 转加密日期
	 */
	public String getSecrecyTime() {
		return secrecyTime;
	}

	/**
	 * @mbggenerated 转加密日期
	 */
	public void setSecrecyTime(String secrecyTime) {
		this.secrecyTime = secrecyTime;
	}

	/**
	 * @mbggenerated 转推荐日期
	 */
	public String getCommendTime() {
		return commendTime;
	}

	/**
	 * @mbggenerated 转推荐日期
	 */
	public void setCommendTime(String commendTime) {
		this.commendTime = commendTime;
	}

	/**
	 * @mbggenerated 带看起始计时时间
	 */
	public String getActionTime() {
		return actionTime;
	}

	/**
	 * @mbggenerated 带看起始计时时间
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	/**
	 * @mbggenerated 转抢盘时间
	 */
	public String getPrivateTime() {
		return privateTime;
	}

	/**
	 * @mbggenerated 转抢盘时间
	 */
	public void setPrivateTime(String privateTime) {
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
	 * @mbggenerated 合作状态 1=合作
	 */
	public Integer getCooperateFlag() {
		return cooperateFlag;
	}

	/**
	 * @mbggenerated 合作状态 1=合作
	 */
	public void setCooperateFlag(Integer cooperateFlag) {
		this.cooperateFlag = cooperateFlag;
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
	 * @mbggenerated 合作的房子
	 */
	public Byte getFriendHouse() {
		return friendHouse;
	}

	/**
	 * @mbggenerated 合作的房子
	 */
	public void setFriendHouse(Byte friendHouse) {
		this.friendHouse = friendHouse;
	}

	/**
	 * @mbggenerated 合作时间
	 */
	public Date getCooperateTime() {
		return cooperateTime;
	}

	/**
	 * @mbggenerated 合作时间
	 */
	public void setCooperateTime(Date cooperateTime) {
		this.cooperateTime = cooperateTime;
	}

	/**
	 * @mbggenerated 投诉成功标记，1=被投诉0 or null 未投诉
	 */
	public Boolean getComplaintFlag() {
		return complaintFlag;
	}

	/**
	 * @mbggenerated 投诉成功标记，1=被投诉0 or null 未投诉
	 */
	public void setComplaintFlag(Boolean complaintFlag) {
		this.complaintFlag = complaintFlag;
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
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制，就把该字段设置成1，Def: 0  2：试用初始化导入的数据
	 */
	public Byte getIsIgnore() {
		return isIgnore;
	}

	/**
	 * @mbggenerated 对于批量导入的数据，如果不想进入策略控制，就把该字段设置成1，Def: 0  2：试用初始化导入的数据
	 */
	public void setIsIgnore(Byte isIgnore) {
		this.isIgnore = isIgnore;
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
	 * @mbggenerated U+分享时间
	 */
	public Date getYouShareTime() {
		return youShareTime;
	}

	/**
	 * @mbggenerated U+分享时间
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
	 * @mbggenerated 最后开放接口同步时间
	 */
	public Date getSyncTime() {
		return syncTime;
	}

	/**
	 * @mbggenerated 最后开放接口同步时间
	 */
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	/**
	 * @mbggenerated 城市公盘分享表ID
	 */
	public Integer getYouShareId() {
		return youShareId;
	}

	/**
	 * @mbggenerated 城市公盘分享表ID
	 */
	public void setYouShareId(Integer youShareId) {
		this.youShareId = youShareId;
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
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=上架
	 */
	public Byte getCityShareFlag() {
		return cityShareFlag;
	}

	/**
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=上架
	 */
	public void setCityShareFlag(Byte cityShareFlag) {
		this.cityShareFlag = cityShareFlag;
	}

	/**
	 * @mbggenerated 意向干道ID，多个空格分隔
	 */
	public String getRoadsId() {
		return roadsId;
	}

	/**
	 * @mbggenerated 意向干道ID，多个空格分隔
	 */
	public void setRoadsId(String roadsId) {
		this.roadsId = roadsId;
	}

	/**
	 * @mbggenerated 意向干道名字，多个空格分隔
	 */
	public String getRoadsName() {
		return roadsName;
	}

	/**
	 * @mbggenerated 意向干道名字，多个空格分隔
	 */
	public void setRoadsName(String roadsName) {
		this.roadsName = roadsName;
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
	 * @mbggenerated -
	 */
	public Byte getIsSaleLease() {
		return isSaleLease;
	}

	/**
	 * @mbggenerated -
	 */
	public void setIsSaleLease(Byte isSaleLease) {
		this.isSaleLease = isSaleLease;
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
	 * @mbggenerated 微信号
	 */
	public String getWechatNumber() {
		return wechatNumber;
	}

	/**
	 * @mbggenerated 微信号
	 */
	public void setWechatNumber(String wechatNumber) {
		this.wechatNumber = wechatNumber;
	}

	/**
	 * @mbggenerated 客户头像
	 */
	public String getCustPhoto() {
		return custPhoto;
	}

	/**
	 * @mbggenerated 客户头像
	 */
	public void setCustPhoto(String custPhoto) {
		this.custPhoto = custPhoto;
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
	 * @mbggenerated 购房资格，DD:BUY_QUALIFY
	 */
	public Byte getBuyQualify() {
		return buyQualify;
	}

	/**
	 * @mbggenerated 购房资格，DD:BUY_QUALIFY
	 */
	public void setBuyQualify(Byte buyQualify) {
		this.buyQualify = buyQualify;
	}

	/**
	 * @mbggenerated 购买的第几套房，DD: BUY_NUM
	 */
	public Byte getBuyNum() {
		return buyNum;
	}

	/**
	 * @mbggenerated 购买的第几套房，DD: BUY_NUM
	 */
	public void setBuyNum(Byte buyNum) {
		this.buyNum = buyNum;
	}

	/**
	 * @mbggenerated 客户当前状态，DD: CURRENT_STATUS
	 */
	public Byte getBuyCurrentStatus() {
		return buyCurrentStatus;
	}

	/**
	 * @mbggenerated 客户当前状态，DD: CURRENT_STATUS
	 */
	public void setBuyCurrentStatus(Byte buyCurrentStatus) {
		this.buyCurrentStatus = buyCurrentStatus;
	}

	/**
	 * @mbggenerated 购房征信情况:DD:CREDIT_TYPE
	 */
	public Byte getCredit() {
		return credit;
	}

	/**
	 * @mbggenerated 购房征信情况:DD:CREDIT_TYPE
	 */
	public void setCredit(Byte credit) {
		this.credit = credit;
	}

	/**
	 * @mbggenerated 交通工具：DD:VEHICLE_TYPE
	 */
	public Byte getVehicle() {
		return vehicle;
	}

	/**
	 * @mbggenerated 交通工具：DD:VEHICLE_TYPE
	 */
	public void setVehicle(Byte vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @mbggenerated 客户心态：DD:MENTALITY_TYPE
	 */
	public Byte getMentality() {
		return mentality;
	}

	/**
	 * @mbggenerated 客户心态：DD:MENTALITY_TYPE
	 */
	public void setMentality(Byte mentality) {
		this.mentality = mentality;
	}

	/**
	 * @mbggenerated C端用户ID
	 */
	public Integer getcUserId() {
		return cUserId;
	}

	/**
	 * @mbggenerated C端用户ID
	 */
	public void setcUserId(Integer cUserId) {
		this.cUserId = cUserId;
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
	 * @mbggenerated 客户渠道来源-字典：CUST_SOURCE
	 */
	public Integer getCustSource() {
		return custSource;
	}

	/**
	 * @mbggenerated 客户渠道来源-字典：CUST_SOURCE
	 */
	public void setCustSource(Integer custSource) {
		this.custSource = custSource;
	}

	/**
	 * @mbggenerated 客源意向：1二手房、2新房
	 */
	public Integer getCustIntention() {
		return custIntention;
	}

	/**
	 * @mbggenerated 客源意向：1二手房、2新房
	 */
	public void setCustIntention(Integer custIntention) {
		this.custIntention = custIntention;
	}

	/**
	 * @mbggenerated 用于 客户姓名仅限姓氏或姓氏+性别（如李、李先生、张女士）楼盘名称环域，DD:HOUSE_ROUND客户补充需求，客户标签 模糊查询
	 */
	public String getFuzzySearch() {
		return fuzzySearch;
	}

	/**
	 * @mbggenerated 用于 客户姓名仅限姓氏或姓氏+性别（如李、李先生、张女士）楼盘名称环域，DD:HOUSE_ROUND客户补充需求，客户标签 模糊查询
	 */
	public void setFuzzySearch(String fuzzySearch) {
		this.fuzzySearch = fuzzySearch;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuyCustomer() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuyCustomer(Integer shardCityId, Integer buyCustId) {
		super(shardCityId);
		this.buyCustId = buyCustId;
	}
}