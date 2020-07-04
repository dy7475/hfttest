package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminCrmPaymentTasks implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "任务ID")
    private Integer ptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "支付类型：1＝软件购买 2＝签约续费(很少用) 3＝团购服务 4＝个人服务（直充精英版） 5＝空间续费(最新物业版续费) 6＝版本升级 7=团购漫游  8=会员升级 9=开通公众号 10=公众号管理费 11=充值公司好房币 12=充值个人好房币 13=O2O服务费   14=购买软件绑定开通公众号  15=个人优家楼盘VIP  16 = 公司优家楼盘VIP  17 = 真房源罚金 18=经纪人真房源 19=查看物业数据支付  20=买断物业数据支付 21 = 恢复接单保证金-陈文超  22 = 直播打赏 23=分享充值  24=打车费用 25=红包 26=购买需求中心隐号合作保证金 27=购买大公盘付费数据 28=分销充值vip 29=打车保证金 30=购买vr相机  31=门店定金 32=门店租用年付  33=真房源押金 34=个人余额(现金)充值 35=知道打赏 36=软件租用续费  37=定金转购买 38=软件差价租用(定金转租用) 39=小程序购买 40=小程序升级 41=销售提成已占用，请勿使用 42=门店赠送 43=充值公司余额 101=业绩统计占用，请勿使用 44=软件租用转购买 45=优优好房加盟软件补差 46=优优好房出租出售恢复抢单保证金  47=培训券充值  48=新营销版升级 49=物业版升级 ；50= 抵扣+赠品；51=抵扣+折扣 ; 52=KA套餐 ; 53=租用门店账号购买 ;54=门店意向金缴纳;55=KA意向金缴纳")
    private Integer ptType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "分店ID   admin")
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "档案ID")
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "帐户ID")
    private Integer uaId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "购买服务月份/空间年数（升级白金会员时为2，版本升级时，该字段为升级至的版本(1=Pro.;2=Link.)，购买软件为赠送O2O年数）/软件套数/vr台数")
    private Integer srvMonth;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送服务天数")
    private Integer srvGift;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送币数")
    private Integer cionGift;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "0=否，1＝是 参与买1增1活动")
    private Byte isPromotion;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "支付金额")
    private Double totalMoney;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单生成人crm人员 和BROKER_ARCHIVE_ID不能同时存在")
    private Integer ptCreator;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "生成时间")
    private Date ptTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "0=否，1＝是 是否支付 2=已退款")
    private Byte isClear;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "支付时间")
    private Date clearTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单说明")
    private String paymentsDesc;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "优惠券赠送金额(现在为赠送好房豆)")
    private Integer quanGift;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Boolean autoTask;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单状态  0 删除 1 有效 2 过期")
    private Byte paymentStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "存外键关联的ID那些")
    private String targetIds;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单扩展字段(json数据)  【购买培训券时为课程id，租用续费购买账号】")
    private String extField;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否同步开通微信  0=否 1=免费赠送 2=优惠绑定开通")
    private Byte openWeinxinStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否同步开通白金会员  0=否  1=免费赠送 2=优惠绑定开通")
    private Byte openCustLevel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "支付来源 1 微信、2 支付宝、默认值：0")
    private Byte paySource;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "O2o充值三年赠送vr活动标记 0=否 1=送两头 2=送三头")
    private Byte otoVrActivity;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "推荐分享销售分佣比例")
    private Double commisionRate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单编号目前只有分享充值使用")
    private String orderNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "付款模式 0=普通 1=欠款 目前oto续费在用")
    private Byte payModel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司id")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "组合字段 根据订单类型 活动类型 比如 购买软件加购VR等")
    private String activityNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否加购VR 0=否 1=是 加购vr台数")
    private Byte addVr;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "vr成本价格用于算业绩和返点 用户vip 软件购买 o2o等(成本价)")
    private Double vrPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "使用抵扣券金额")
    private BigDecimal dkqPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客服ID")
    private Integer serverId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "退款时间")
    private Date refundTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "如果是推荐的  写推荐ID CRM_RECOMMEND_MOBI")
    private Integer recommendId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "余额支付，用于erp混合支付")
    private BigDecimal balancePrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "加购VR金额 用于vip支付（实际支付价格）")
    private Double addVrPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单更新时间")
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "来源0=ERP 1=CRM 2=掌上好房通 3=网站分享充值 4:钉钉 5=推手代充值")
    private Integer source;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "花呗分期期数")
    private Integer hbFqNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "花呗分期商户承担手续费比例 0=用户支付 100=商家支付")
    private BigDecimal hbFqSellerPercent;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "第三方支付渠道")
    private String fundChannel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "第三方订单实际支付金额 目前只有支付宝 花呗使用")
    private BigDecimal receivable;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "花呗分期税率商家承担")
    private BigDecimal hbFqSellerPrecentRate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送vr台数")
    private Integer giftVrNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送培训券金额")
    private Integer trainTicket;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "软件价格")
    private Integer softPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "VR价格")
    private Integer bindVrUnitPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "微店价格")
    private Integer bindWxPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "白金会员价格")
    private Integer bindCustPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "小程序价格")
    private Integer bindSmaleProgramPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "白金会员续费年数")
    private Integer bindCustVipNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "OTO续费年数")
    private Integer bindOtoNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "OTO价格")
    private Integer bindOtoPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "服务开始时间（VIP，OTO，白金会员，企业微店）")
    private Date serviceStartTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "服务结束时间（VIP，OTO，白金会员，企业微店）")
    private Date serviceEndTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单子类型 pt_type=4(0=销售给经纪人充值 1=经纪人给经纪人充值)")
    private String subPtType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "真房源分享奖励金")
    private BigDecimal sharePrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单生成人fun_archive的id 和 PT_CREATOR不能同时存在")
    private Integer brokerArchiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送网商卡数量")
    private Double giftWskNum;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司账户抵扣金额")
    private BigDecimal compAccountMoney;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司资金账户ID（记录信息，不在程序中实际运算）")
    private Integer compUaId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 任务ID
     */
    public Integer getPtId() {
        return ptId;
    }

    /**
     *
     * @mbggenerated
     * 任务ID
     */
    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    /**
     *
     * @mbggenerated
     * 支付类型：1＝软件购买 2＝签约续费(很少用) 3＝团购服务 4＝个人服务（直充精英版） 5＝空间续费(最新物业版续费) 6＝版本升级 7=团购漫游  8=会员升级 9=开通公众号 10=公众号管理费 11=充值公司好房币 12=充值个人好房币 13=O2O服务费   14=购买软件绑定开通公众号  15=个人优家楼盘VIP  16 = 公司优家楼盘VIP  17 = 真房源罚金 18=经纪人真房源 19=查看物业数据支付  20=买断物业数据支付 21 = 恢复接单保证金-陈文超  22 = 直播打赏 23=分享充值  24=打车费用 25=红包 26=购买需求中心隐号合作保证金 27=购买大公盘付费数据 28=分销充值vip 29=打车保证金 30=购买vr相机  31=门店定金 32=门店租用年付  33=真房源押金 34=个人余额(现金)充值 35=知道打赏 36=软件租用续费  37=定金转购买 38=软件差价租用(定金转租用) 39=小程序购买 40=小程序升级 41=销售提成已占用，请勿使用 42=门店赠送 43=充值公司余额 101=业绩统计占用，请勿使用 44=软件租用转购买 45=优优好房加盟软件补差 46=优优好房出租出售恢复抢单保证金  47=培训券充值  48=新营销版升级 49=物业版升级 ；50= 抵扣+赠品；51=抵扣+折扣 ; 52=KA套餐 ; 53=租用门店账号购买 ;54=门店意向金缴纳;55=KA意向金缴纳
     */
    public Integer getPtType() {
        return ptType;
    }

    /**
     *
     * @mbggenerated
     * 支付类型：1＝软件购买 2＝签约续费(很少用) 3＝团购服务 4＝个人服务（直充精英版） 5＝空间续费(最新物业版续费) 6＝版本升级 7=团购漫游  8=会员升级 9=开通公众号 10=公众号管理费 11=充值公司好房币 12=充值个人好房币 13=O2O服务费   14=购买软件绑定开通公众号  15=个人优家楼盘VIP  16 = 公司优家楼盘VIP  17 = 真房源罚金 18=经纪人真房源 19=查看物业数据支付  20=买断物业数据支付 21 = 恢复接单保证金-陈文超  22 = 直播打赏 23=分享充值  24=打车费用 25=红包 26=购买需求中心隐号合作保证金 27=购买大公盘付费数据 28=分销充值vip 29=打车保证金 30=购买vr相机  31=门店定金 32=门店租用年付  33=真房源押金 34=个人余额(现金)充值 35=知道打赏 36=软件租用续费  37=定金转购买 38=软件差价租用(定金转租用) 39=小程序购买 40=小程序升级 41=销售提成已占用，请勿使用 42=门店赠送 43=充值公司余额 101=业绩统计占用，请勿使用 44=软件租用转购买 45=优优好房加盟软件补差 46=优优好房出租出售恢复抢单保证金  47=培训券充值  48=新营销版升级 49=物业版升级 ；50= 抵扣+赠品；51=抵扣+折扣 ; 52=KA套餐 ; 53=租用门店账号购买 ;54=门店意向金缴纳;55=KA意向金缴纳
     */
    public void setPtType(Integer ptType) {
        this.ptType = ptType;
    }

    /**
     *
     * @mbggenerated
     * 分店ID   admin
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     * 分店ID   admin
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     * 档案ID
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     * 档案ID
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 帐户ID
     */
    public Integer getUaId() {
        return uaId;
    }

    /**
     *
     * @mbggenerated
     * 帐户ID
     */
    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }

    /**
     *
     * @mbggenerated
     * 购买服务月份/空间年数（升级白金会员时为2，版本升级时，该字段为升级至的版本(1=Pro.;2=Link.)，购买软件为赠送O2O年数）/软件套数/vr台数
     */
    public Integer getSrvMonth() {
        return srvMonth;
    }

    /**
     *
     * @mbggenerated
     * 购买服务月份/空间年数（升级白金会员时为2，版本升级时，该字段为升级至的版本(1=Pro.;2=Link.)，购买软件为赠送O2O年数）/软件套数/vr台数
     */
    public void setSrvMonth(Integer srvMonth) {
        this.srvMonth = srvMonth;
    }

    /**
     *
     * @mbggenerated
     * 赠送服务天数
     */
    public Integer getSrvGift() {
        return srvGift;
    }

    /**
     *
     * @mbggenerated
     * 赠送服务天数
     */
    public void setSrvGift(Integer srvGift) {
        this.srvGift = srvGift;
    }

    /**
     *
     * @mbggenerated
     * 赠送币数
     */
    public Integer getCionGift() {
        return cionGift;
    }

    /**
     *
     * @mbggenerated
     * 赠送币数
     */
    public void setCionGift(Integer cionGift) {
        this.cionGift = cionGift;
    }

    /**
     *
     * @mbggenerated
     * 0=否，1＝是 参与买1增1活动
     */
    public Byte getIsPromotion() {
        return isPromotion;
    }

    /**
     *
     * @mbggenerated
     * 0=否，1＝是 参与买1增1活动
     */
    public void setIsPromotion(Byte isPromotion) {
        this.isPromotion = isPromotion;
    }

    /**
     *
     * @mbggenerated
     * 支付金额
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     *
     * @mbggenerated
     * 支付金额
     */
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     *
     * @mbggenerated
     * 订单生成人crm人员 和BROKER_ARCHIVE_ID不能同时存在
     */
    public Integer getPtCreator() {
        return ptCreator;
    }

    /**
     *
     * @mbggenerated
     * 订单生成人crm人员 和BROKER_ARCHIVE_ID不能同时存在
     */
    public void setPtCreator(Integer ptCreator) {
        this.ptCreator = ptCreator;
    }

    /**
     *
     * @mbggenerated
     * 生成时间
     */
    public Date getPtTime() {
        return ptTime;
    }

    /**
     *
     * @mbggenerated
     * 生成时间
     */
    public void setPtTime(Date ptTime) {
        this.ptTime = ptTime;
    }

    /**
     *
     * @mbggenerated
     * 0=否，1＝是 是否支付 2=已退款
     */
    public Byte getIsClear() {
        return isClear;
    }

    /**
     *
     * @mbggenerated
     * 0=否，1＝是 是否支付 2=已退款
     */
    public void setIsClear(Byte isClear) {
        this.isClear = isClear;
    }

    /**
     *
     * @mbggenerated
     * 支付时间
     */
    public Date getClearTime() {
        return clearTime;
    }

    /**
     *
     * @mbggenerated
     * 支付时间
     */
    public void setClearTime(Date clearTime) {
        this.clearTime = clearTime;
    }

    /**
     *
     * @mbggenerated
     * 订单说明
     */
    public String getPaymentsDesc() {
        return paymentsDesc;
    }

    /**
     *
     * @mbggenerated
     * 订单说明
     */
    public void setPaymentsDesc(String paymentsDesc) {
        this.paymentsDesc = paymentsDesc;
    }

    /**
     *
     * @mbggenerated
     * 优惠券赠送金额(现在为赠送好房豆)
     */
    public Integer getQuanGift() {
        return quanGift;
    }

    /**
     *
     * @mbggenerated
     * 优惠券赠送金额(现在为赠送好房豆)
     */
    public void setQuanGift(Integer quanGift) {
        this.quanGift = quanGift;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Boolean getAutoTask() {
        return autoTask;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setAutoTask(Boolean autoTask) {
        this.autoTask = autoTask;
    }

    /**
     *
     * @mbggenerated
     * 订单状态  0 删除 1 有效 2 过期
     */
    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    /**
     *
     * @mbggenerated
     * 订单状态  0 删除 1 有效 2 过期
     */
    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     *
     * @mbggenerated
     * 存外键关联的ID那些
     */
    public String getTargetIds() {
        return targetIds;
    }

    /**
     *
     * @mbggenerated
     * 存外键关联的ID那些
     */
    public void setTargetIds(String targetIds) {
        this.targetIds = targetIds;
    }

    /**
     *
     * @mbggenerated
     * 订单扩展字段(json数据)  【购买培训券时为课程id，租用续费购买账号】
     */
    public String getExtField() {
        return extField;
    }

    /**
     *
     * @mbggenerated
     * 订单扩展字段(json数据)  【购买培训券时为课程id，租用续费购买账号】
     */
    public void setExtField(String extField) {
        this.extField = extField;
    }

    /**
     *
     * @mbggenerated
     * 是否同步开通微信  0=否 1=免费赠送 2=优惠绑定开通
     */
    public Byte getOpenWeinxinStatus() {
        return openWeinxinStatus;
    }

    /**
     *
     * @mbggenerated
     * 是否同步开通微信  0=否 1=免费赠送 2=优惠绑定开通
     */
    public void setOpenWeinxinStatus(Byte openWeinxinStatus) {
        this.openWeinxinStatus = openWeinxinStatus;
    }

    /**
     *
     * @mbggenerated
     * 是否同步开通白金会员  0=否  1=免费赠送 2=优惠绑定开通
     */
    public Byte getOpenCustLevel() {
        return openCustLevel;
    }

    /**
     *
     * @mbggenerated
     * 是否同步开通白金会员  0=否  1=免费赠送 2=优惠绑定开通
     */
    public void setOpenCustLevel(Byte openCustLevel) {
        this.openCustLevel = openCustLevel;
    }

    /**
     *
     * @mbggenerated
     * 支付来源 1 微信、2 支付宝、默认值：0
     */
    public Byte getPaySource() {
        return paySource;
    }

    /**
     *
     * @mbggenerated
     * 支付来源 1 微信、2 支付宝、默认值：0
     */
    public void setPaySource(Byte paySource) {
        this.paySource = paySource;
    }

    /**
     *
     * @mbggenerated
     * O2o充值三年赠送vr活动标记 0=否 1=送两头 2=送三头
     */
    public Byte getOtoVrActivity() {
        return otoVrActivity;
    }

    /**
     *
     * @mbggenerated
     * O2o充值三年赠送vr活动标记 0=否 1=送两头 2=送三头
     */
    public void setOtoVrActivity(Byte otoVrActivity) {
        this.otoVrActivity = otoVrActivity;
    }

    /**
     *
     * @mbggenerated
     * 推荐分享销售分佣比例
     */
    public Double getCommisionRate() {
        return commisionRate;
    }

    /**
     *
     * @mbggenerated
     * 推荐分享销售分佣比例
     */
    public void setCommisionRate(Double commisionRate) {
        this.commisionRate = commisionRate;
    }

    /**
     *
     * @mbggenerated
     * 订单编号目前只有分享充值使用
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     *
     * @mbggenerated
     * 订单编号目前只有分享充值使用
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     *
     * @mbggenerated
     * 付款模式 0=普通 1=欠款 目前oto续费在用
     */
    public Byte getPayModel() {
        return payModel;
    }

    /**
     *
     * @mbggenerated
     * 付款模式 0=普通 1=欠款 目前oto续费在用
     */
    public void setPayModel(Byte payModel) {
        this.payModel = payModel;
    }

    /**
     *
     * @mbggenerated
     * 公司id
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司id
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * 组合字段 根据订单类型 活动类型 比如 购买软件加购VR等
     */
    public String getActivityNum() {
        return activityNum;
    }

    /**
     *
     * @mbggenerated
     * 组合字段 根据订单类型 活动类型 比如 购买软件加购VR等
     */
    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    /**
     *
     * @mbggenerated
     * 是否加购VR 0=否 1=是 加购vr台数
     */
    public Byte getAddVr() {
        return addVr;
    }

    /**
     *
     * @mbggenerated
     * 是否加购VR 0=否 1=是 加购vr台数
     */
    public void setAddVr(Byte addVr) {
        this.addVr = addVr;
    }

    /**
     *
     * @mbggenerated
     * vr成本价格用于算业绩和返点 用户vip 软件购买 o2o等(成本价)
     */
    public Double getVrPrice() {
        return vrPrice;
    }

    /**
     *
     * @mbggenerated
     * vr成本价格用于算业绩和返点 用户vip 软件购买 o2o等(成本价)
     */
    public void setVrPrice(Double vrPrice) {
        this.vrPrice = vrPrice;
    }

    /**
     *
     * @mbggenerated
     * 使用抵扣券金额
     */
    public BigDecimal getDkqPrice() {
        return dkqPrice;
    }

    /**
     *
     * @mbggenerated
     * 使用抵扣券金额
     */
    public void setDkqPrice(BigDecimal dkqPrice) {
        this.dkqPrice = dkqPrice;
    }

    /**
     *
     * @mbggenerated
     * 客服ID
     */
    public Integer getServerId() {
        return serverId;
    }

    /**
     *
     * @mbggenerated
     * 客服ID
     */
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    /**
     *
     * @mbggenerated
     * 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     *
     * @mbggenerated
     * 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     *
     * @mbggenerated
     * 如果是推荐的  写推荐ID CRM_RECOMMEND_MOBI
     */
    public Integer getRecommendId() {
        return recommendId;
    }

    /**
     *
     * @mbggenerated
     * 如果是推荐的  写推荐ID CRM_RECOMMEND_MOBI
     */
    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    /**
     *
     * @mbggenerated
     * 余额支付，用于erp混合支付
     */
    public BigDecimal getBalancePrice() {
        return balancePrice;
    }

    /**
     *
     * @mbggenerated
     * 余额支付，用于erp混合支付
     */
    public void setBalancePrice(BigDecimal balancePrice) {
        this.balancePrice = balancePrice;
    }

    /**
     *
     * @mbggenerated
     * 加购VR金额 用于vip支付（实际支付价格）
     */
    public Double getAddVrPrice() {
        return addVrPrice;
    }

    /**
     *
     * @mbggenerated
     * 加购VR金额 用于vip支付（实际支付价格）
     */
    public void setAddVrPrice(Double addVrPrice) {
        this.addVrPrice = addVrPrice;
    }

    /**
     *
     * @mbggenerated
     * 订单更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     * 订单更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     * 来源0=ERP 1=CRM 2=掌上好房通 3=网站分享充值 4:钉钉 5=推手代充值
     */
    public Integer getSource() {
        return source;
    }

    /**
     *
     * @mbggenerated
     * 来源0=ERP 1=CRM 2=掌上好房通 3=网站分享充值 4:钉钉 5=推手代充值
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期期数
     */
    public Integer getHbFqNum() {
        return hbFqNum;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期期数
     */
    public void setHbFqNum(Integer hbFqNum) {
        this.hbFqNum = hbFqNum;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期商户承担手续费比例 0=用户支付 100=商家支付
     */
    public BigDecimal getHbFqSellerPercent() {
        return hbFqSellerPercent;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期商户承担手续费比例 0=用户支付 100=商家支付
     */
    public void setHbFqSellerPercent(BigDecimal hbFqSellerPercent) {
        this.hbFqSellerPercent = hbFqSellerPercent;
    }

    /**
     *
     * @mbggenerated
     * 第三方支付渠道
     */
    public String getFundChannel() {
        return fundChannel;
    }

    /**
     *
     * @mbggenerated
     * 第三方支付渠道
     */
    public void setFundChannel(String fundChannel) {
        this.fundChannel = fundChannel;
    }

    /**
     *
     * @mbggenerated
     * 第三方订单实际支付金额 目前只有支付宝 花呗使用
     */
    public BigDecimal getReceivable() {
        return receivable;
    }

    /**
     *
     * @mbggenerated
     * 第三方订单实际支付金额 目前只有支付宝 花呗使用
     */
    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期税率商家承担
     */
    public BigDecimal getHbFqSellerPrecentRate() {
        return hbFqSellerPrecentRate;
    }

    /**
     *
     * @mbggenerated
     * 花呗分期税率商家承担
     */
    public void setHbFqSellerPrecentRate(BigDecimal hbFqSellerPrecentRate) {
        this.hbFqSellerPrecentRate = hbFqSellerPrecentRate;
    }

    /**
     *
     * @mbggenerated
     * 赠送vr台数
     */
    public Integer getGiftVrNum() {
        return giftVrNum;
    }

    /**
     *
     * @mbggenerated
     * 赠送vr台数
     */
    public void setGiftVrNum(Integer giftVrNum) {
        this.giftVrNum = giftVrNum;
    }

    /**
     *
     * @mbggenerated
     * 赠送培训券金额
     */
    public Integer getTrainTicket() {
        return trainTicket;
    }

    /**
     *
     * @mbggenerated
     * 赠送培训券金额
     */
    public void setTrainTicket(Integer trainTicket) {
        this.trainTicket = trainTicket;
    }

    /**
     *
     * @mbggenerated
     * 软件价格
     */
    public Integer getSoftPrice() {
        return softPrice;
    }

    /**
     *
     * @mbggenerated
     * 软件价格
     */
    public void setSoftPrice(Integer softPrice) {
        this.softPrice = softPrice;
    }

    /**
     *
     * @mbggenerated
     * VR价格
     */
    public Integer getBindVrUnitPrice() {
        return bindVrUnitPrice;
    }

    /**
     *
     * @mbggenerated
     * VR价格
     */
    public void setBindVrUnitPrice(Integer bindVrUnitPrice) {
        this.bindVrUnitPrice = bindVrUnitPrice;
    }

    /**
     *
     * @mbggenerated
     * 微店价格
     */
    public Integer getBindWxPrice() {
        return bindWxPrice;
    }

    /**
     *
     * @mbggenerated
     * 微店价格
     */
    public void setBindWxPrice(Integer bindWxPrice) {
        this.bindWxPrice = bindWxPrice;
    }

    /**
     *
     * @mbggenerated
     * 白金会员价格
     */
    public Integer getBindCustPrice() {
        return bindCustPrice;
    }

    /**
     *
     * @mbggenerated
     * 白金会员价格
     */
    public void setBindCustPrice(Integer bindCustPrice) {
        this.bindCustPrice = bindCustPrice;
    }

    /**
     *
     * @mbggenerated
     * 小程序价格
     */
    public Integer getBindSmaleProgramPrice() {
        return bindSmaleProgramPrice;
    }

    /**
     *
     * @mbggenerated
     * 小程序价格
     */
    public void setBindSmaleProgramPrice(Integer bindSmaleProgramPrice) {
        this.bindSmaleProgramPrice = bindSmaleProgramPrice;
    }

    /**
     *
     * @mbggenerated
     * 白金会员续费年数
     */
    public Integer getBindCustVipNum() {
        return bindCustVipNum;
    }

    /**
     *
     * @mbggenerated
     * 白金会员续费年数
     */
    public void setBindCustVipNum(Integer bindCustVipNum) {
        this.bindCustVipNum = bindCustVipNum;
    }

    /**
     *
     * @mbggenerated
     * OTO续费年数
     */
    public Integer getBindOtoNum() {
        return bindOtoNum;
    }

    /**
     *
     * @mbggenerated
     * OTO续费年数
     */
    public void setBindOtoNum(Integer bindOtoNum) {
        this.bindOtoNum = bindOtoNum;
    }

    /**
     *
     * @mbggenerated
     * OTO价格
     */
    public Integer getBindOtoPrice() {
        return bindOtoPrice;
    }

    /**
     *
     * @mbggenerated
     * OTO价格
     */
    public void setBindOtoPrice(Integer bindOtoPrice) {
        this.bindOtoPrice = bindOtoPrice;
    }

    /**
     *
     * @mbggenerated
     * 服务开始时间（VIP，OTO，白金会员，企业微店）
     */
    public Date getServiceStartTime() {
        return serviceStartTime;
    }

    /**
     *
     * @mbggenerated
     * 服务开始时间（VIP，OTO，白金会员，企业微店）
     */
    public void setServiceStartTime(Date serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    /**
     *
     * @mbggenerated
     * 服务结束时间（VIP，OTO，白金会员，企业微店）
     */
    public Date getServiceEndTime() {
        return serviceEndTime;
    }

    /**
     *
     * @mbggenerated
     * 服务结束时间（VIP，OTO，白金会员，企业微店）
     */
    public void setServiceEndTime(Date serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    /**
     *
     * @mbggenerated
     * 订单子类型 pt_type=4(0=销售给经纪人充值 1=经纪人给经纪人充值)
     */
    public String getSubPtType() {
        return subPtType;
    }

    /**
     *
     * @mbggenerated
     * 订单子类型 pt_type=4(0=销售给经纪人充值 1=经纪人给经纪人充值)
     */
    public void setSubPtType(String subPtType) {
        this.subPtType = subPtType;
    }

    /**
     *
     * @mbggenerated
     * 真房源分享奖励金
     */
    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    /**
     *
     * @mbggenerated
     * 真房源分享奖励金
     */
    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    /**
     *
     * @mbggenerated
     * 订单生成人fun_archive的id 和 PT_CREATOR不能同时存在
     */
    public Integer getBrokerArchiveId() {
        return brokerArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 订单生成人fun_archive的id 和 PT_CREATOR不能同时存在
     */
    public void setBrokerArchiveId(Integer brokerArchiveId) {
        this.brokerArchiveId = brokerArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 赠送网商卡数量
     */
    public Double getGiftWskNum() {
        return giftWskNum;
    }

    /**
     *
     * @mbggenerated
     * 赠送网商卡数量
     */
    public void setGiftWskNum(Double giftWskNum) {
        this.giftWskNum = giftWskNum;
    }

    /**
     *
     * @mbggenerated
     * 公司账户抵扣金额
     */
    public BigDecimal getCompAccountMoney() {
        return compAccountMoney;
    }

    /**
     *
     * @mbggenerated
     * 公司账户抵扣金额
     */
    public void setCompAccountMoney(BigDecimal compAccountMoney) {
        this.compAccountMoney = compAccountMoney;
    }

    /**
     *
     * @mbggenerated
     * 公司资金账户ID（记录信息，不在程序中实际运算）
     */
    public Integer getCompUaId() {
        return compUaId;
    }

    /**
     *
     * @mbggenerated
     * 公司资金账户ID（记录信息，不在程序中实际运算）
     */
    public void setCompUaId(Integer compUaId) {
        this.compUaId = compUaId;
    }
}