package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunSaleToLease extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    房源ID，自增序列
     */
    private Integer saleId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    公司区域ID，From:FUN_REGION
     */
    private Integer regId;

    /**
     *
     * @mbggenerated
    分店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    分组ID
     */
    private Integer grId;

    /**
     *
     * @mbggenerated
    经纪人用户ID，From:FUN_USER
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    经纪人档案ID，与USER_ID对应的ARCHIVE_ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    登记时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    原始登记人ID，该ID移交数据时不变，用于经纪人脱离门店版后的数据复制
     */
    private Integer createArchiveId;

    /**
     *
     * @mbggenerated
    房源编码，时间生存编号
     */
    private String saleNo;

    /**
     *
     * @mbggenerated
     */
    private Integer leaseId;

    /**
     *
     * @mbggenerated
     */
    private String leaseNo;

    /**
     *
     * @mbggenerated
     */
    private Date transTime;

    /**
     *
     * @mbggenerated
    业主姓名
     */
    private String saleOwner;

    /**
     *
     * @mbggenerated
    手机号码  业主
     */
    private String cellPhone;

    /**
     *
     * @mbggenerated
    业主身份证
     */
    private String idCard;

    /**
     *
     * @mbggenerated
    房源标题
     */
    private String saleSubject;

    /**
     *
     * @mbggenerated
    楼盘ID
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
    楼盘名称
     */
    private String buildName;

    /**
     *
     * @mbggenerated
    楼盘检索码
     */
    private String buildCode;

    /**
     *
     * @mbggenerated
    行政区ID
     */
    private Integer saleReg;

    /**
     *
     * @mbggenerated
    行政区名称
     */
    private String regionName;

    /**
     *
     * @mbggenerated
    片区ID
     */
    private Integer sectionId;

    /**
     *
     * @mbggenerated
    片区名称
     */
    private String sectionName;

    /**
     *
     * @mbggenerated
    环域，DD:HOUSE_ROUND
     */
    private Byte saleRound;

    /**
     *
     * @mbggenerated
    商铺地址
     */
    private String tradeAddr;

    /**
     *
     * @mbggenerated
    栋
     */
    private String saleRoof;

    /**
     *
     * @mbggenerated
    单元
     */
    private String saleUnit;

    /**
     *
     * @mbggenerated
    楼
     */
    private String unitFloor;

    /**
     *
     * @mbggenerated
    号
     */
    private String saleNum;

    /**
     *
     * @mbggenerated
    栋(重复)
     */
    private String saleRoofR;

    /**
     *
     * @mbggenerated
    单元(重复)
     */
    private String saleUnitR;

    /**
     *
     * @mbggenerated
    楼(重复)
     */
    private String unitFloorR;

    /**
     *
     * @mbggenerated
    号(重复)
     */
    private String saleNumR;

    /**
     *
     * @mbggenerated
    几梯
     */
    private Integer saleLadder;

    /**
     *
     * @mbggenerated
    几户
     */
    private Byte saleDoors;

    /**
     *
     * @mbggenerated
    几房
     */
    private Byte saleRoom;

    /**
     *
     * @mbggenerated
    几厅
     */
    private Byte saleHall;

    /**
     *
     * @mbggenerated
    几卫
     */
    private Byte saleWei;

    /**
     *
     * @mbggenerated
    阳台
     */
    private Byte saleYang;

    /**
     *
     * @mbggenerated
    类型，DD: HOUSE_TYPE
     */
    private Byte saleType;

    /**
     *
     * @mbggenerated
    楼层
     */
    private Short saleFloor;

    /**
     *
     * @mbggenerated
    总楼层
     */
    private Integer saleFloors;

    /**
     *
     * @mbggenerated
    装修，DD:HOUSE_FITMENT
     */
    private Byte saleFitment;

    /**
     *
     * @mbggenerated
    房源朝向，DD：HOUSE_DIRECT
     */
    private Byte saleDirect;

    /**
     *
     * @mbggenerated
    房屋年代
     */
    private Short saleYear;

    /**
     *
     * @mbggenerated
    房屋结构，DD:HOUSE_STRUCT
     */
    private Byte saleStruct;

    /**
     *
     * @mbggenerated
    房屋用途，DD:HOUSE_USEAGE
     */
    private Byte saleUseage;

    /**
     *
     * @mbggenerated
    商铺用途，DD:SHOP_USAGE
     */
    private String shopUsage;

    /**
     *
     * @mbggenerated
    业主类型，DD: OWNER_TYPE
     */
    private Byte ownerType;

    /**
     *
     * @mbggenerated
    写字楼级别，DD:OFFICE_LEVEL
     */
    private Byte officeLevel;

    /**
     *
     * @mbggenerated
    是否邻街，1=是0=否
     */
    private Boolean saleStreet;

    /**
     *
     * @mbggenerated
    产权，DD:HOUSE_RIGHT
     */
    private Byte saleRight;

    /**
     *
     * @mbggenerated
    现状(按揭)，DD:HOUSE_STITUAT
     */
    private String saleMortgage;

    /**
     *
     * @mbggenerated
    结算，DD:HOUSE_ACCOUNT
     */
    private String saleAccount;

    /**
     *
     * @mbggenerated
    建筑面积
     */
    private BigDecimal saleArea;

    /**
     *
     * @mbggenerated
    售价
     */
    private BigDecimal saleTotalPrice;

    /**
     *
     * @mbggenerated
    单价
     */
    private BigDecimal saleUnitPrice;

    /**
     *
     * @mbggenerated
    底价
     */
    private BigDecimal saleLowestPrice;

    /**
     *
     * @mbggenerated
    物业费
     */
    private BigDecimal saleProperty;

    /**
     *
     * @mbggenerated
    是否可分割，1=是0=否
     */
    private Boolean isSeperator;

    /**
     *
     * @mbggenerated
    腾房日
     */
    private String saleLeaveTime;

    /**
     *
     * @mbggenerated
    厅结构，DD:HALL_STRUCTURE
     */
    private Byte hallStructure;

    /**
     *
     * @mbggenerated
    地下面积
     */
    private BigDecimal ugArea;

    /**
     *
     * @mbggenerated
    地下类型，DD:UG_TYPE
     */
    private Byte ugType;

    /**
     *
     * @mbggenerated
    花园面积
     */
    private BigDecimal gardenArea;

    /**
     *
     * @mbggenerated
    车位数量
     */
    private Byte garageAmount;

    /**
     *
     * @mbggenerated
    配套及特色
     */
    private String saleCharact;

    /**
     *
     * @mbggenerated
    内部备注
     */
    private String saleMemo;

    /**
     *
     * @mbggenerated
    信息来源，DD:HOUSE_SOURCE
     */
    private Byte saleSource;

    /**
     *
     * @mbggenerated
    是否有钥匙，1=是0=否
     */
    private Boolean saleKey;

    /**
     *
     * @mbggenerated
    钥匙编号
     */
    private String saleKeyNum;

    /**
     *
     * @mbggenerated
    钥匙日期
     */
    private Date keyTime;

    /**
     *
     * @mbggenerated
    房勘，1=已勘0=未勘
     */
    private Boolean saleExplrth;

    /**
     *
     * @mbggenerated
    房勘日期
     */
    private Date explrthDatetime;

    /**
     *
     * @mbggenerated
    委托，DD: HOUSE_CONSIGN
     */
    private Byte saleConsign;

    /**
     *
     * @mbggenerated
    委托编号
     */
    private String saleConsignNo;

    /**
     *
     * @mbggenerated
    委托时间
     */
    private Date weituoTime;

    /**
     *
     * @mbggenerated
    是否合作，1=是0=否
     */
    private Boolean saleCooperate;

    /**
     *
     * @mbggenerated
    营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29 
     */
    private Boolean salePublish;

    /**
     *
     * @mbggenerated
    图片张数，默认=0
     */
    private Byte saleMap;

    /**
     *
     * @mbggenerated
    级别，DD: HOUSE_LEVEL
     */
    private Byte saleLevel;

    /**
     *
     * @mbggenerated
    盘别，DD：PLATE_TYPE
     */
    private Byte plateType;

    /**
     *
     * @mbggenerated
    房屋状态，DD：HOUSE_STATUS
     */
    private Byte saleStatus;

    /**
     *
     * @mbggenerated
    最后跟进日期
     */
    private Date trackTime;

    /**
     *
     * @mbggenerated
    批量移交前的跟进时间
     */
    private Date trackTime2;

    /**
     *
     * @mbggenerated
    房勘计时起始时间
     */
    private Date actionTime;

    /**
     *
     * @mbggenerated
    是否从搜搜获得，1=是0=否
     */
    private Boolean fromSoso;

    /**
     *
     * @mbggenerated
    信息重复标记，0=否1=电话重复2=地址重复3=电话地址都重复
     */
    private Byte repeatFlag;

    /**
     *
     * @mbggenerated
    房源类型（全城联网中查询条件：INFO_TYPE<2），0=门店版1=精英版2=已转房源默认=0
     */
    private Byte infoType;

    /**
     *
     * @mbggenerated
    精英版登记，1=是0=否
     */
    private Boolean shareFlag;

    /**
     *
     * @mbggenerated
    是否共享到好友圈，0：否1：是
     */
    private Boolean friendHouse;

    /**
     *
     * @mbggenerated
    首次合作时间
     */
    private Date cooperateTime;

    /**
     *
     * @mbggenerated
    投诉成功标记，1=被投诉0未投诉
     */
    private Boolean complaintFlag;

    /**
     *
     * @mbggenerated
    首次发布时间
     */
    private Date publishTime;

    /**
     *
     * @mbggenerated
    首次上图时间
     */
    private Date photoTime;

    /**
     *
     * @mbggenerated
    红色警示，1=是0=否
     */
    private Boolean redFlag;

    /**
     *
     * @mbggenerated
    橙色警示，1=是0=否
     */
    private Boolean orangeFlag;

    /**
     *
     * @mbggenerated
    转公盘次数，默认=0
     */
    private Byte publicCount;

    /**
     *
     * @mbggenerated
    转公盘日期
     */
    private Date publicTime;

    /**
     *
     * @mbggenerated
    转封盘日期
     */
    private Date specialTime;

    /**
     *
     * @mbggenerated
    转预定日期
     */
    private Date scheduleTime;

    /**
     *
     * @mbggenerated
    转成交日期
     */
    private Date dealTime;

    /**
     *
     * @mbggenerated
    转注销日期
     */
    private Date writeoffTime;

    /**
     *
     * @mbggenerated
    转加密日期
     */
    private Date secrecyTime;

    /**
     *
     * @mbggenerated
    转推荐日期
     */
    private Date commendTime;

    /**
     *
     * @mbggenerated
    转抢盘时间
     */
    private Date privateTime;

    /**
     *
     * @mbggenerated
    是否转自抢盘，1=是0=否
     */
    private Boolean fromPublic;

    /**
     *
     * @mbggenerated
    缩略图文件路径
     */
    private String thumbUrl;

    /**
     *
     * @mbggenerated
    最后更新时间
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
    房源标签，以”|”分隔
     */
    private String tagIds;

    /**
     *
     * @mbggenerated
     */
    private Date saleCertTime;

    /**
     *
     * @mbggenerated
    各网站的发布状态腾讯 ― 10进位上微店 －个进位上，以位表示：1＝否2＝是
     */
    private Integer publishSites;

    /**
     *
     * @mbggenerated
    公司大区ID，From:FUN_AREA
     */
    private Integer areaId;

    /**
     *
     * @mbggenerated
    栋（明文）
     */
    private String saleRoofT;

    /**
     *
     * @mbggenerated
    房号（明文）
     */
    private String saleNumT;

    /**
     *
     * @mbggenerated
    单元（明文）
     */
    private String saleUnitT;

    /**
     *
     * @mbggenerated
    视频数量，Def：0
     */
    private Byte videoNum;

    /**
     *
     * @mbggenerated
    登录人USER_ID
     */
    private Integer creatorUid;

    /**
     *
     * @mbggenerated
    对于批量导入的数据，如果不想进入策略控制:1、把该字段设置成1，2、分享到优家的数据设置成3，Def: 0  2：试用初始化导入的数据
     */
    private Byte isIgnore;

    /**
     *
     * @mbggenerated
    老版center库对应的SALE_ID，Def: 0
     */
    private Integer saleIdOld;

    /**
     *
     * @mbggenerated
    套内面积
     */
    private BigDecimal saleInnerarea;

    /**
     *
     * @mbggenerated
    0:未议价1:已议价，DEF:0
     */
    private Boolean houseBargain;

    /**
     *
     * @mbggenerated
    是否编码 - 已废弃
     */
    private Byte encodeFlag;

    /**
     *
     * @mbggenerated
    锁定标记  - 已废弃
     */
    private Byte lock;

    /**
     *
     * @mbggenerated
    真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源
     */
    private Byte trueFlag;

    /**
     *
     * @mbggenerated
    是否发布上架到腾讯网站，1：是0：否Def:0
     */
    private Byte sendtotencent;

    /**
     *
     * @mbggenerated
    房源数据是否操作过发发功能1：本地2：发发关联3：发发转入
     */
    private Byte houseSourceWay;

    /**
     *
     * @mbggenerated
    U+分享标记 0 未分享 1 已分享
     */
    private Byte youShareFlag;

    /**
     *
     * @mbggenerated
    --U+分享时间
     */
    private Date youShareTime;

    /**
     *
     * @mbggenerated
    购买次数
     */
    private Integer youBuyCount;

    /**
     *
     * @mbggenerated
    所属人性别，1=先生0=女士
     */
    private Byte ownerSex;

    /**
     *
     * @mbggenerated
    分享表ID
     */
    private Integer youShareId;

    /**
     *
     * @mbggenerated
    缩略图版本信息
     */
    private String thumbpicVer;

    /**
     *
     * @mbggenerated
    转抢盘用户的USER_ID,用于判断自己的抢盘的数据不能再次抢盘
     */
    private Integer privateUserId;

    /**
     *
     * @mbggenerated
    房源栋座号的MD5码
     */
    private String addrMd5;

    /**
     *
     * @mbggenerated
    720相机图片有多少张
     */
    private Integer panoramaMap;

    /**
     *
     * @mbggenerated
    移动端用于统计指定界面登记操作的优家数据，1：来自优家分享界面登记的优家数据-陈文超
     */
    private Byte youjiaStatisticFlag;

    /**
     *
     * @mbggenerated
    鸿基广告房源
     */
    private Byte adsFlag;

    /**
     *
     * @mbggenerated
    都三方同步时间，修改房源数据时修改这个时间
     */
    private Date syncTime;

    /**
     *
     * @mbggenerated
    视频审核标记 0 未审核 1 审核通过 2 审核失败
     */
    private Byte videoReviewFlag;

    /**
     *
     * @mbggenerated
    VR显示标记 0 不显示 1 显示
     */
    private Byte hasPanorama;

    /**
     *
     * @mbggenerated
    是否竞价0否1是
     */
    private Boolean biddingFlag;

    /**
     *
     * @mbggenerated
    房源竞价结束时间
     */
    private Date competeEndTime;

    /**
     *
     * @mbggenerated
    房源竞价价格
     */
    private BigDecimal competePrice;

    /**
     *
     * @mbggenerated
    1=已获取分享费，2=已退还分享费，3=已完成、不再退或给分享费
     */
    private Byte youShareMoneyState;

    /**
     *
     * @mbggenerated
    是否发布微店
     */
    private Byte sendtoWeidian;

    /**
     *
     * @mbggenerated
    是否发布优优
     */
    private Byte sendtoYouyou;

    /**
     *
     * @mbggenerated
    优优排除成交的推荐数据，0：未成交、1：成交 - 陈文超-2016-10-01
     */
    private Byte youyouDeal;

    /**
     *
     * @mbggenerated
    封盘保护结束时间
     */
    private Date specialEndTime;

    /**
     *
     * @mbggenerated
    预订保护结束时间
     */
    private Date scheduleEndTime;

    /**
     *
     * @mbggenerated
    核验编号
     */
    private String checkCodeFun;

    /**
     *
     * @mbggenerated
    委托书url
     */
    private String proxyUrl;

    /**
     *
     * @mbggenerated
    权证编号
     */
    private String qzCodeFun;

    /**
     *
     * @mbggenerated
    核验编号图片所在地址
     */
    private String checkCodeUrl;

    /**
     *
     * @mbggenerated
    委托书上传人
     */
    private String uploadProxyUser;

    /**
     *
     * @mbggenerated
    城市大公盘分享状态 0=下架 1=上架
     */
    private Byte cityShareFlag;

    /**
     *
     * @mbggenerated
    品牌中介公司ID
     */
    private Integer brandCompId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getGrId() {
        return grId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreateArchiveId() {
        return createArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateArchiveId(Integer createArchiveId) {
        this.createArchiveId = createArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleNo() {
        return saleNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo == null ? null : saleNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLeaseId() {
        return leaseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLeaseNo() {
        return leaseNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLeaseNo(String leaseNo) {
        this.leaseNo = leaseNo == null ? null : leaseNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTransTime() {
        return transTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleOwner() {
        return saleOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleOwner(String saleOwner) {
        this.saleOwner = saleOwner == null ? null : saleOwner.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleSubject() {
        return saleSubject;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleSubject(String saleSubject) {
        this.saleSubject = saleSubject == null ? null : saleSubject.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildCode() {
        return buildCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode == null ? null : buildCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleReg() {
        return saleReg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleReg(Integer saleReg) {
        this.saleReg = saleReg;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleRound() {
        return saleRound;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRound(Byte saleRound) {
        this.saleRound = saleRound;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTradeAddr() {
        return tradeAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTradeAddr(String tradeAddr) {
        this.tradeAddr = tradeAddr == null ? null : tradeAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleRoof() {
        return saleRoof;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRoof(String saleRoof) {
        this.saleRoof = saleRoof == null ? null : saleRoof.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleUnit() {
        return saleUnit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit == null ? null : saleUnit.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnitFloor() {
        return unitFloor;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnitFloor(String unitFloor) {
        this.unitFloor = unitFloor == null ? null : unitFloor.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleNum() {
        return saleNum;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum == null ? null : saleNum.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleRoofR() {
        return saleRoofR;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRoofR(String saleRoofR) {
        this.saleRoofR = saleRoofR == null ? null : saleRoofR.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleUnitR() {
        return saleUnitR;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleUnitR(String saleUnitR) {
        this.saleUnitR = saleUnitR == null ? null : saleUnitR.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnitFloorR() {
        return unitFloorR;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnitFloorR(String unitFloorR) {
        this.unitFloorR = unitFloorR == null ? null : unitFloorR.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleNumR() {
        return saleNumR;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleNumR(String saleNumR) {
        this.saleNumR = saleNumR == null ? null : saleNumR.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleLadder() {
        return saleLadder;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLadder(Integer saleLadder) {
        this.saleLadder = saleLadder;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleDoors() {
        return saleDoors;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleDoors(Byte saleDoors) {
        this.saleDoors = saleDoors;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleRoom() {
        return saleRoom;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRoom(Byte saleRoom) {
        this.saleRoom = saleRoom;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleHall() {
        return saleHall;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleHall(Byte saleHall) {
        this.saleHall = saleHall;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleWei() {
        return saleWei;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleWei(Byte saleWei) {
        this.saleWei = saleWei;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleYang() {
        return saleYang;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleYang(Byte saleYang) {
        this.saleYang = saleYang;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleType() {
        return saleType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleType(Byte saleType) {
        this.saleType = saleType;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getSaleFloor() {
        return saleFloor;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleFloor(Short saleFloor) {
        this.saleFloor = saleFloor;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleFloors() {
        return saleFloors;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleFloors(Integer saleFloors) {
        this.saleFloors = saleFloors;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleFitment() {
        return saleFitment;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleFitment(Byte saleFitment) {
        this.saleFitment = saleFitment;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleDirect() {
        return saleDirect;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleDirect(Byte saleDirect) {
        this.saleDirect = saleDirect;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getSaleYear() {
        return saleYear;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleYear(Short saleYear) {
        this.saleYear = saleYear;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleStruct() {
        return saleStruct;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleStruct(Byte saleStruct) {
        this.saleStruct = saleStruct;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleUseage() {
        return saleUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleUseage(Byte saleUseage) {
        this.saleUseage = saleUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public String getShopUsage() {
        return shopUsage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShopUsage(String shopUsage) {
        this.shopUsage = shopUsage == null ? null : shopUsage.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getOwnerType() {
        return ownerType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOwnerType(Byte ownerType) {
        this.ownerType = ownerType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getOfficeLevel() {
        return officeLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOfficeLevel(Byte officeLevel) {
        this.officeLevel = officeLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSaleStreet() {
        return saleStreet;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleStreet(Boolean saleStreet) {
        this.saleStreet = saleStreet;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleRight() {
        return saleRight;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRight(Byte saleRight) {
        this.saleRight = saleRight;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleMortgage() {
        return saleMortgage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleMortgage(String saleMortgage) {
        this.saleMortgage = saleMortgage == null ? null : saleMortgage.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleAccount() {
        return saleAccount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleAccount(String saleAccount) {
        this.saleAccount = saleAccount == null ? null : saleAccount.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleArea() {
        return saleArea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleArea(BigDecimal saleArea) {
        this.saleArea = saleArea;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleTotalPrice() {
        return saleTotalPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleUnitPrice() {
        return saleUnitPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleUnitPrice(BigDecimal saleUnitPrice) {
        this.saleUnitPrice = saleUnitPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleLowestPrice() {
        return saleLowestPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLowestPrice(BigDecimal saleLowestPrice) {
        this.saleLowestPrice = saleLowestPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleProperty() {
        return saleProperty;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleProperty(BigDecimal saleProperty) {
        this.saleProperty = saleProperty;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getIsSeperator() {
        return isSeperator;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsSeperator(Boolean isSeperator) {
        this.isSeperator = isSeperator;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleLeaveTime() {
        return saleLeaveTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLeaveTime(String saleLeaveTime) {
        this.saleLeaveTime = saleLeaveTime == null ? null : saleLeaveTime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHallStructure() {
        return hallStructure;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHallStructure(Byte hallStructure) {
        this.hallStructure = hallStructure;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getUgArea() {
        return ugArea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUgArea(BigDecimal ugArea) {
        this.ugArea = ugArea;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUgType() {
        return ugType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUgType(Byte ugType) {
        this.ugType = ugType;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getGardenArea() {
        return gardenArea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGardenArea(BigDecimal gardenArea) {
        this.gardenArea = gardenArea;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getGarageAmount() {
        return garageAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGarageAmount(Byte garageAmount) {
        this.garageAmount = garageAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleCharact() {
        return saleCharact;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleCharact(String saleCharact) {
        this.saleCharact = saleCharact == null ? null : saleCharact.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleMemo() {
        return saleMemo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleMemo(String saleMemo) {
        this.saleMemo = saleMemo == null ? null : saleMemo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleSource() {
        return saleSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleSource(Byte saleSource) {
        this.saleSource = saleSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSaleKey() {
        return saleKey;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleKey(Boolean saleKey) {
        this.saleKey = saleKey;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleKeyNum() {
        return saleKeyNum;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleKeyNum(String saleKeyNum) {
        this.saleKeyNum = saleKeyNum == null ? null : saleKeyNum.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getKeyTime() {
        return keyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setKeyTime(Date keyTime) {
        this.keyTime = keyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSaleExplrth() {
        return saleExplrth;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleExplrth(Boolean saleExplrth) {
        this.saleExplrth = saleExplrth;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getExplrthDatetime() {
        return explrthDatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExplrthDatetime(Date explrthDatetime) {
        this.explrthDatetime = explrthDatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleConsign() {
        return saleConsign;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleConsign(Byte saleConsign) {
        this.saleConsign = saleConsign;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleConsignNo() {
        return saleConsignNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleConsignNo(String saleConsignNo) {
        this.saleConsignNo = saleConsignNo == null ? null : saleConsignNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWeituoTime() {
        return weituoTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWeituoTime(Date weituoTime) {
        this.weituoTime = weituoTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSaleCooperate() {
        return saleCooperate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleCooperate(Boolean saleCooperate) {
        this.saleCooperate = saleCooperate;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getSalePublish() {
        return salePublish;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSalePublish(Boolean salePublish) {
        this.salePublish = salePublish;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleMap() {
        return saleMap;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleMap(Byte saleMap) {
        this.saleMap = saleMap;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleLevel() {
        return saleLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLevel(Byte saleLevel) {
        this.saleLevel = saleLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPlateType() {
        return plateType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPlateType(Byte plateType) {
        this.plateType = plateType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleStatus() {
        return saleStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleStatus(Byte saleStatus) {
        this.saleStatus = saleStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTrackTime() {
        return trackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTrackTime2() {
        return trackTime2;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackTime2(Date trackTime2) {
        this.trackTime2 = trackTime2;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getActionTime() {
        return actionTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getFromSoso() {
        return fromSoso;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFromSoso(Boolean fromSoso) {
        this.fromSoso = fromSoso;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRepeatFlag() {
        return repeatFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRepeatFlag(Byte repeatFlag) {
        this.repeatFlag = repeatFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getInfoType() {
        return infoType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInfoType(Byte infoType) {
        this.infoType = infoType;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getShareFlag() {
        return shareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShareFlag(Boolean shareFlag) {
        this.shareFlag = shareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getFriendHouse() {
        return friendHouse;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFriendHouse(Boolean friendHouse) {
        this.friendHouse = friendHouse;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCooperateTime() {
        return cooperateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCooperateTime(Date cooperateTime) {
        this.cooperateTime = cooperateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getComplaintFlag() {
        return complaintFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintFlag(Boolean complaintFlag) {
        this.complaintFlag = complaintFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPhotoTime() {
        return photoTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoTime(Date photoTime) {
        this.photoTime = photoTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getRedFlag() {
        return redFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRedFlag(Boolean redFlag) {
        this.redFlag = redFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getOrangeFlag() {
        return orangeFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrangeFlag(Boolean orangeFlag) {
        this.orangeFlag = orangeFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPublicCount() {
        return publicCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPublicCount(Byte publicCount) {
        this.publicCount = publicCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPublicTime() {
        return publicTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSpecialTime() {
        return specialTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSpecialTime(Date specialTime) {
        this.specialTime = specialTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getScheduleTime() {
        return scheduleTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWriteoffTime() {
        return writeoffTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWriteoffTime(Date writeoffTime) {
        this.writeoffTime = writeoffTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSecrecyTime() {
        return secrecyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSecrecyTime(Date secrecyTime) {
        this.secrecyTime = secrecyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCommendTime() {
        return commendTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCommendTime(Date commendTime) {
        this.commendTime = commendTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPrivateTime() {
        return privateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPrivateTime(Date privateTime) {
        this.privateTime = privateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getFromPublic() {
        return fromPublic;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFromPublic(Boolean fromPublic) {
        this.fromPublic = fromPublic;
    }

    /**
     *
     * @mbggenerated
     */
    public String getThumbUrl() {
        return thumbUrl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTagIds(String tagIds) {
        this.tagIds = tagIds == null ? null : tagIds.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSaleCertTime() {
        return saleCertTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleCertTime(Date saleCertTime) {
        this.saleCertTime = saleCertTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPublishSites() {
        return publishSites;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPublishSites(Integer publishSites) {
        this.publishSites = publishSites;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleRoofT() {
        return saleRoofT;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleRoofT(String saleRoofT) {
        this.saleRoofT = saleRoofT == null ? null : saleRoofT.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleNumT() {
        return saleNumT;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleNumT(String saleNumT) {
        this.saleNumT = saleNumT == null ? null : saleNumT.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleUnitT() {
        return saleUnitT;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleUnitT(String saleUnitT) {
        this.saleUnitT = saleUnitT == null ? null : saleUnitT.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getVideoNum() {
        return videoNum;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVideoNum(Byte videoNum) {
        this.videoNum = videoNum;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsIgnore() {
        return isIgnore;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsIgnore(Byte isIgnore) {
        this.isIgnore = isIgnore;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleIdOld() {
        return saleIdOld;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleIdOld(Integer saleIdOld) {
        this.saleIdOld = saleIdOld;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getSaleInnerarea() {
        return saleInnerarea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleInnerarea(BigDecimal saleInnerarea) {
        this.saleInnerarea = saleInnerarea;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getHouseBargain() {
        return houseBargain;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseBargain(Boolean houseBargain) {
        this.houseBargain = houseBargain;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getEncodeFlag() {
        return encodeFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEncodeFlag(Byte encodeFlag) {
        this.encodeFlag = encodeFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getLock() {
        return lock;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLock(Byte lock) {
        this.lock = lock;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTrueFlag() {
        return trueFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrueFlag(Byte trueFlag) {
        this.trueFlag = trueFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSendtotencent() {
        return sendtotencent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendtotencent(Byte sendtotencent) {
        this.sendtotencent = sendtotencent;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHouseSourceWay() {
        return houseSourceWay;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseSourceWay(Byte houseSourceWay) {
        this.houseSourceWay = houseSourceWay;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYouShareFlag() {
        return youShareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouShareFlag(Byte youShareFlag) {
        this.youShareFlag = youShareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getYouShareTime() {
        return youShareTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouShareTime(Date youShareTime) {
        this.youShareTime = youShareTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getYouBuyCount() {
        return youBuyCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouBuyCount(Integer youBuyCount) {
        this.youBuyCount = youBuyCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getOwnerSex() {
        return ownerSex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOwnerSex(Byte ownerSex) {
        this.ownerSex = ownerSex;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getYouShareId() {
        return youShareId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouShareId(Integer youShareId) {
        this.youShareId = youShareId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getThumbpicVer() {
        return thumbpicVer;
    }

    /**
     *
     * @mbggenerated
     */
    public void setThumbpicVer(String thumbpicVer) {
        this.thumbpicVer = thumbpicVer == null ? null : thumbpicVer.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPrivateUserId() {
        return privateUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPrivateUserId(Integer privateUserId) {
        this.privateUserId = privateUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAddrMd5() {
        return addrMd5;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAddrMd5(String addrMd5) {
        this.addrMd5 = addrMd5 == null ? null : addrMd5.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPanoramaMap() {
        return panoramaMap;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPanoramaMap(Integer panoramaMap) {
        this.panoramaMap = panoramaMap;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYoujiaStatisticFlag() {
        return youjiaStatisticFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYoujiaStatisticFlag(Byte youjiaStatisticFlag) {
        this.youjiaStatisticFlag = youjiaStatisticFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getAdsFlag() {
        return adsFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdsFlag(Byte adsFlag) {
        this.adsFlag = adsFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSyncTime() {
        return syncTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getVideoReviewFlag() {
        return videoReviewFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVideoReviewFlag(Byte videoReviewFlag) {
        this.videoReviewFlag = videoReviewFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHasPanorama() {
        return hasPanorama;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHasPanorama(Byte hasPanorama) {
        this.hasPanorama = hasPanorama;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getBiddingFlag() {
        return biddingFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingFlag(Boolean biddingFlag) {
        this.biddingFlag = biddingFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCompeteEndTime() {
        return competeEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompeteEndTime(Date competeEndTime) {
        this.competeEndTime = competeEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getCompetePrice() {
        return competePrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompetePrice(BigDecimal competePrice) {
        this.competePrice = competePrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYouShareMoneyState() {
        return youShareMoneyState;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouShareMoneyState(Byte youShareMoneyState) {
        this.youShareMoneyState = youShareMoneyState;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSendtoWeidian() {
        return sendtoWeidian;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendtoWeidian(Byte sendtoWeidian) {
        this.sendtoWeidian = sendtoWeidian;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSendtoYouyou() {
        return sendtoYouyou;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendtoYouyou(Byte sendtoYouyou) {
        this.sendtoYouyou = sendtoYouyou;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYouyouDeal() {
        return youyouDeal;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouyouDeal(Byte youyouDeal) {
        this.youyouDeal = youyouDeal;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSpecialEndTime() {
        return specialEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSpecialEndTime(Date specialEndTime) {
        this.specialEndTime = specialEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getScheduleEndTime() {
        return scheduleEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setScheduleEndTime(Date scheduleEndTime) {
        this.scheduleEndTime = scheduleEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCheckCodeFun() {
        return checkCodeFun;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCheckCodeFun(String checkCodeFun) {
        this.checkCodeFun = checkCodeFun == null ? null : checkCodeFun.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getProxyUrl() {
        return proxyUrl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl == null ? null : proxyUrl.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getQzCodeFun() {
        return qzCodeFun;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQzCodeFun(String qzCodeFun) {
        this.qzCodeFun = qzCodeFun == null ? null : qzCodeFun.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCheckCodeUrl() {
        return checkCodeUrl;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCheckCodeUrl(String checkCodeUrl) {
        this.checkCodeUrl = checkCodeUrl == null ? null : checkCodeUrl.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUploadProxyUser() {
        return uploadProxyUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUploadProxyUser(String uploadProxyUser) {
        this.uploadProxyUser = uploadProxyUser == null ? null : uploadProxyUser.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCityShareFlag() {
        return cityShareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityShareFlag(Byte cityShareFlag) {
        this.cityShareFlag = cityShareFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBrandCompId() {
        return brandCompId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrandCompId(Integer brandCompId) {
        this.brandCompId = brandCompId;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunSaleToLease() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunSaleToLease(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}