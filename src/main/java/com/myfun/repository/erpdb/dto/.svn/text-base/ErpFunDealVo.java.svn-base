package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunDealVo implements Serializable {

    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同ID，自增序列")
    private Integer dealId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公司ID")
    private Integer compId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同编号自动生成【创建合同后系统自动生成的编号，在后台数据库保存的】")
    private String agreementNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统创建时间")
    private String creatorDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "成交类型，DD:CASE_TYPE")
    private Byte dealType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "0,1,2未分配，待结算，已结算")
    private Byte dealStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "主办人(USER_ID)")
    private Integer dealUserId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "此字段已废弃，新字段为DEAL_AUDIT_STATUS")
    private Byte dealComplete;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "结算时间")
    private String dealVerifyTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1")
    private Byte dealBuyStyle;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1")
    private Byte dealSellStyle;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "用途，DD:HOUSE_USEAGE")
    private Byte houseUseage;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源ID")
    private Integer dealCustomerId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源编号")
    private String dealCustomerNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源ID")
    private Integer dealHouseId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源编号")
    private String dealHouseNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方物业地址，产权地址")
    private String sellAddress;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方客户资料")
    private String buyCustinfo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方合作公司")
    private String sellHezuoCompname;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方合作公司")
    private String buyHezuoCompname;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方联系人（历史合同的）")
    private String buyContactuser;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方联系人")
    private String sellContactuser;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方业主姓名")
    private String buyOwnerName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方业主姓名")
    private String sellOwnerName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方联系电话（经纪人）")
    private String buyCallPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方联系电话（经纪人）")
    private String sellCallPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方身份证")
    private String buyIdCard;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方身份证")
    private String sellIdCard;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方付佣")
    private BigDecimal buyPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方付佣")
    private BigDecimal sellPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "其他收入")
    private BigDecimal otherPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "收到的佣金金额")
    private BigDecimal gainMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际买方付佣")
    private BigDecimal realBuyPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际卖方付佣")
    private BigDecimal realSellPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际其他收入")
    private BigDecimal realOtherPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实际分佣金额")
    private BigDecimal realPaymoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "自付金额")
    private String buyPriceMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "按揭方式，DD: MORTGAGE_TYPE     贷款方式")
    private Byte buyMortgageType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "成交金额")
    private BigDecimal sellDealMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方借贷，0:无贷款1:有贷款")
    private Boolean sellIshaveLoan;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "贷款金额")
    private BigDecimal sellLoanMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "还贷方式，0:其他方还1:卖方还")
    private Boolean sellReturnLoan;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "权属，DD:HOUSE_RIGHT")
    private Integer ownerStyle;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "权属类型，丘地号QIUDI_NO   1证书号HENGSHU_NO 2合同号HETONG_NO  3备案号BEIAN_NO   4")
    private Byte ownerType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "权属号")
    private String ownerNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "有无国土证号，1:有0:无")
    private Boolean haveLandcard;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "国土证号")
    private String landcardNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "营业税，1:有0:无")
    private Boolean mangementTax;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "个税，1:有0:无")
    private Boolean ownerTax;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "税费支付，DD:TAX_TYPE")
    private String tax;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "附加条款")
    private String tradeRemarkExplain;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "成交租金")
    private BigDecimal rentDealMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "租金单位，DD:PRICE_UNIT")
    private Byte rentPriceUnit;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "起租时间")
    private String rentDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "到期时间")
    private String rentOverDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "付款方式，DD:RENT_ACCOUNT")
    private Byte rentPayMethod;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "付款间隔")
    private String rentPaySpace;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "付款时间，提示:提前几天付")
    private String rentPayEarly;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "押金支付")
    private BigDecimal rentDepositPay;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "其他费用")
    private BigDecimal rentOtherMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "物品清单")
    private String goodsdetailed;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "水电抄表")
    private String waterlightexpenses;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统记录的时间")
    private String systemRecordTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "分店ID")
    private Integer deptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private Integer creatorUid;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同修改，最后一次修改详情请看修改记录日志")
    private Integer updateUid;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同修改时间")
    private Date updateTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源所属部门名")
    private String custDeptname;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源所属经纪人名")
    private String custUsername;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源所属经纪人ID")
    private Integer custUserUid;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源所属部门人ID")
    private Integer custDeptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源成交时的盘别")
    private Byte custPlate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源所属部门名")
    private String houseDeptname;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源所属经纪人名")
    private String houseUsername;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源所属经纪人ID")
    private Integer houseUserUid;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源所属部门ID")
    private Integer houseDeptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源成交时的盘别")
    private Byte housePlate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同成交时的房源楼盘ID")
    private Integer buildId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同成交时的房源楼盘名")
    private String buildName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同成交时的房源地址描述")
    private String houseaddress;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源的实际价格")
    private BigDecimal realTotalprice;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "主办人的门店id")
    private Integer dealDeptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房源租金到期的提醒任务")
    private Integer houseDuetimeTaskId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客源租金到期的提醒任务")
    private Integer custDuetimeTaskId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程类别，PROCESS_MODEL.MODEL_ID")
    private Integer modelId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同号【合同创建时不论是手动输入还是自动分配的编号】")
    private String contractNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前执行实例的ID，PROCESS_RUNTIME_STEP表的RUNSTEP _ID")
    private Integer runstepId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前执行步骤名")
    private String runstepName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "到期时间，根据时间限制类别根据UPDATE_TIME TIMELIMIT计算出")
    private String timelimitdate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "指定执行人")
    private Integer executor;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核人")
    private Integer completeUser;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核时间")
    private String completeDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程名称")
    private String modelName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "主办人姓名")
    private String dealUserName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核人姓名")
    private String completeUserName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人姓名")
    private String creatorName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房屋面积(手动录入业绩时不要传)")
    private BigDecimal area;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "DD：HOUSE_FITMENT")
    private Byte fitment;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "模板编号")
    private Short modelNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程序号")
    private Short stepNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同修改人姓名")
    private String updateUsername;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同锁定标志")
    private Byte lockFlag;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同内容类型，0:表示非完整合同(用于业绩统计)1:表示完整合同")
    private Byte dealInfoType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同录入类型，1: 手动录入业绩生成的合同(即没有权证的合同,虚拟合同)0 or null: 权证合同")
    private Byte isbyhand;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "片区ID")
    private Integer regId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "大区ID")
    private Integer areaId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约人ID")
    private Integer signUserId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约人姓名")
    private String signUserName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约主管ID")
    private Integer signManagerId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约主管人姓名")
    private String signManagerName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约人门店ID")
    private Integer signUserDeptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约人门店名")
    private String signUserDeptName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约经理门店ID")
    private Integer signManagerDeptId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签约经理门店名")
    private String signManagerDeptName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "财务状态ID")
    private Integer financStatusId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "财务状态名字")
    private String financName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同类别ID")
    private Integer categoryId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同类别名")
    private String categoryName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "签定时间")
    private String signDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "过户日期")
    private String transferDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "取证日期")
    private String evidenceDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方共有人姓名")
    private String buyOwnerNameBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方业主姓名")
    private String sellOwnerNameBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方业主身份证")
    private String buyIdCardBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方业主身份证")
    private String sellIdCardBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方成交价格金额")
    private Byte salePriceUnit;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "出租周期")
    private String rentCycle;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "分配的合同号段ID")
    private Integer codeId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程状态（0：未履行1：履行中2,：已办结）")
    private Byte processStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户电话")
    private String buyCustomerPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户电话带类型")
    private String buyCustomerPhoneencode;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "业主电话")
    private String sellOwnerPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "业主电话带类型")
    private String sellOwnerPhoneencode;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方共有人电话")
    private String sellOwnerPhoneBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方共有人电话")
    private String buyCustomerPhoneBak;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同ID")
    private Integer contractId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付方式ID 1=一次性 2=按揭")
    private Integer paytypeId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "支付方式名称")
    private String paytypeName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "针对you+的合同审核状态，一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 4:等待二审 5:二审通过 6:二审未通过 7：内部审核 8:内审不通过（2017-4-20 取消二审状态）")
    private Byte youAduitStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同审核状态 0=未审核，1=初审，2=复审，3=作废")
    private Byte dealAuditStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "商业贷放款日期")
    private String commercialLoanDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "商业贷贷款日期")
    private String commercialLenderDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "商业贷贷款年限")
    private String commercialLenderLimit;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "商业贷贷款银行")
    private String commercialLenderBank;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公积金贷放款日期")
    private Date providentLoanDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公积金贷贷款日期")
    private Date providentLenderDate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公积金贷贷款年限")
    private String providentLenderLimit;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公积金贷贷款银行")
    private String providentLenderBank;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "应收总计")
    private BigDecimal totalNeedIncome;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实收总计")
    private BigDecimal totalRealIncome;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "应收业绩")
    private BigDecimal totalNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实收业绩")
    private BigDecimal totalRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "应收审核状态")
    private Byte needAduitStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实收审核状态")
    private Byte realAduitStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "智能搜索(CONTRACT_NO=合同编号 BUY_OWNER_NAME=买方业主姓名 HOUSEADDRESS=合同成交时的房源地址描述 SELL_OWNER_NAME=卖方业主姓名 SELL_ADDRESS=卖方物业地址 产权地址 DEAL_HOUSE_NO=房源编号 DEAL_CUSTOMER_NO=客源编号 SELL_CALL_PHONE=卖方联系电话 BUY_CALL_PHONE=买方联系电话 BUY_ID_CARD=买方身份证号 SELL_ID_CARD=业主身份证号)")
    private String intelligentSearch;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "公积金贷款金额")
    private BigDecimal providentLoanMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "商业贷款金额")
    private BigDecimal commercialLoanMoney;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "税费审核默认0代表未审核1代表已审核")
    private Byte taxesAuditStatus;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "税费审核审核人姓名")
    private String taxesAuditName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "税费审核人")
    private Integer taxesAuditUser;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "税费审核时间")
    private Date taxesAuditTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核律师")
    private String dealAuditor;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "律师审核意见")
    private String youAduitOpinion;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否是youjia合同")
    private Byte youDealFlag;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "提交律师审核时间")
    private Date subAduitTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否是youjia合同")
    private Byte youjiaDeal;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "楼盘行政区名称")
    private String buildRegName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "楼盘行政区ID")
    private Integer buildRegId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "流程办结时间")
    private Date processEndTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "补充协议审核状态 一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 7：内部审核 8：内审不通过")
    private Byte youAduitStatusProtocol;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "协议ID")
    private Integer protocolId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "过户应收业绩")
    private BigDecimal transferNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "过户实收业绩")
    private BigDecimal transferRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "二手佣金应收业绩")
    private BigDecimal secondhandNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "二手佣金实收业绩")
    private BigDecimal secondhandRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "新房佣金应收业绩")
    private BigDecimal newhouseNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "新房佣金实收业绩")
    private BigDecimal newhouseRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "租赁应收业绩")
    private BigDecimal leaseNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "租赁实收业绩")
    private BigDecimal leaseRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "金融应收业绩")
    private BigDecimal financeNeedPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "金融实收业绩")
    private BigDecimal financeRealPerformance;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "佣金利率")
    private BigDecimal commissionRate;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "标准佣金项")
    private BigDecimal standardCommission;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合同号类型 0手动录入1自动分配")
    private Byte codeType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "板块ID")
    private Integer sectionId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "业主付佣")
    private BigDecimal sellOwnerCommsion;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户付佣")
    private BigDecimal buyCustomerCommsion;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "规划用途")
    private String planningUse;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "国土证 类型1：划拨 2：出让")
    private Byte landcardType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "抵押情况 0 无抵押 1：有抵押")
    private Byte mortgageType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "租约情况 0不带租约 1带租约")
    private Byte leaseType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方代理人名字")
    private String sellerProxyName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方代理人身份证")
    private String sellerProxyIdcard;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方代理人电话")
    private String sellerProxyPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方代理人电话 带类型")
    private String sellerProxyPhoneencode;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方代理人电话")
    private String buyerProxyName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方代理人身份证")
    private String buyerProxyIdcard;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方代理人电话")
    private String buyerProxyPhone;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方代理人电话 带类型")
    private String buyerProxyPhoneencode;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否带家电 0不带1：带")
    private Byte houseHoldElectrical;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税")
    private String buyerTaxFee;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税")
    private String sellerTaxFee;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "定金支付时间")
    private Date depositPayTime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "定金支付方式 1：通过银行资金 2：甲方收取")
    private Byte depositPayType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "定金其他")
    private String depositPayOther;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款支付方式1是否选择 0未选择 1：选择")
    private Byte downPaymentsPayType1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付转款时间")
    private String downPaymentsPayTime1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式1 是否选择 0未选择 1：选择")
    private Byte housePriceLastPayType1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款转款时间")
    private String housePriceLastPayTime1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "贷款时长")
    private String loanTimeLength;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "贷款机构")
    private String loanAgency;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "未批贷解决方式")
    private Byte noPassSloutionType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "注销抵押申请还款工作日")
    private Integer applicationRepaymentDays;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "注销抵押其他内容")
    private String applicationRepaymentOther;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "权属号")
    private String ownershipObligatiionNumber;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房屋性质")
    private String houseProperty;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方银行账户类型")
    private String sellerBankType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方银行账户名字")
    private String sellerBankUserName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "卖方银行账户账号")
    private String sellerBankAccount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方银行账户银行类型")
    private String buyerBankType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方银行账户名字")
    private String buyerBankUserName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方银行账户账号")
    private String buyerBankAccount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付-银行资金监管专用账户划转")
    private Byte downPaymentsPayType2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款支付方式2的时间或者其他")
    private String downPaymentsPayTime2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款支付方式3 是否开启 0：未选择 1：选择")
    private Byte downPaymentsPayType3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款支付方式3的时间或者条件")
    private String downPaymentsPayTime3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房间余款支付方式2 是否选择")
    private Byte housePriceLastPayType2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式2的约定时间或者其他")
    private String housePriceLastPayTime2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式3 是否开启")
    private Byte housePriceLastPayType3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式3的时间")
    private String housePriceLastPayTime3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "过户时间或者其他")
    private String transferDateStr;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "取件工作日")
    private Integer transferDateDaysPickup;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "办理抵押登记工作日")
    private Integer transferDateDaysRegist;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否漏水")
    private Byte waterLeakage;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "漏水位置")
    private String waterLeakagePosition;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "漏水协商")
    private Byte waterLeakageConsult;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "漏水协商责任承担方")
    private Byte waterLeakageConsultBearParty;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "死亡事件责任承担方")
    private String deathEvent;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否蜕皮")
    private Byte housePeeling;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "脱皮位置")
    private String housePeelingPosition;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "提交贷款资料及费用")
    private String submitLoanInfoFeeDays;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款支付方 买方出贷")
    private Byte downPaymentsPayParty1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款- 第三方出资	")
    private Byte downPaymentsPayParty2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款- 甲乙双方自行出资")
    private Byte downPaymentsPayParty3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方出资银行")
    private String downPaymentsPayBank;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方出资账户户名")
    private String downPaymentsPayAccountName;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "买方出资账户")
    private String downPaymentsPayAccountNo;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "第三方出资 支付方")
    private String downPaymentsThirdParty;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "余下首期放款 支付时间")
    private String downPaymentsRemainingFirstPaytime;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "脱皮责任承担方")
    private Byte housePeelingBearParty;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "余下首期放款")
    private String downPaymentsRemainingFirstAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式3 金额")
    private String housePriceLastPayAmount3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款支付方式2 金额")
    private String housePriceLastPayAmount2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付支付方式3 金额")
    private String downPaymentsPayAmount3;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付支付方式2 金额")
    private String downPaymentsPayAmount2;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "未批贷解决方式 金额")
    private String noPassSloutionAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款 支付方式1 金额 ")
    private String housePriceLastPayAmount1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付支付方式1 金额")
    private String downPaymentsPayAmount1;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房价余款 金额")
    private String housePriceLastAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "首付款金额")
    private String downPaymentsAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "定金 ")
    private String depositAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "抵押情况  ")
    private String mortgageAmount;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "null")
    private Integer signUserArchive;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方证件类型)")
    private Integer buyIdCardType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方证件类型)")
    private Integer sellIdCardType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方共有人证件类型)")
    private Integer sellIdCardBakType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方共有人证件类型)")
    private Integer buyIdCardBakType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方代理人证件类型)")
    private Integer sellerProxyIdcardType;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方代理人证件类型)")
    private Integer buyerProxyIdcardType;

    @ApiModelProperty(value = "托管银行")
    private String entrustBank;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "托管金额")
    private BigDecimal entrustMoney;

    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "应付金额")
    private BigDecimal needPay;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实付金额")
    private BigDecimal realPay;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "应代收金额")
    private BigDecimal insteadNeedIncome;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "实代收金额")
    private BigDecimal insteadRealIncome;
    /**
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    public BigDecimal getNeedPay() {
        return needPay;
    }

    public void setNeedPay(BigDecimal needPay) {
        this.needPay = needPay;
    }

    public BigDecimal getRealPay() {
        return realPay;
    }

    public void setRealPay(BigDecimal realPay) {
        this.realPay = realPay;
    }

    public BigDecimal getInsteadNeedIncome() {
        return insteadNeedIncome;
    }

    public void setInsteadNeedIncome(BigDecimal insteadNeedIncome) {
        this.insteadNeedIncome = insteadNeedIncome;
    }

    public BigDecimal getInsteadRealIncome() {
        return insteadRealIncome;
    }

    public void setInsteadRealIncome(BigDecimal insteadRealIncome) {
        this.insteadRealIncome = insteadRealIncome;
    }

    /**
     * @mbggenerated 合同ID，自增序列
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     * @mbggenerated 合同ID，自增序列
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
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
     * @mbggenerated 合同编号自动生成【创建合同后系统自动生成的编号，在后台数据库保存的】
     */
    public String getAgreementNo() {
        return agreementNo;
    }

    /**
     * @mbggenerated 合同编号自动生成【创建合同后系统自动生成的编号，在后台数据库保存的】
     */
    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo == null ? null : agreementNo.trim();
    }

    /**
     * @mbggenerated 系统创建时间
     */
    public String getCreatorDate() {
        return creatorDate;
    }

    /**
     * @mbggenerated 系统创建时间
     */
    public void setCreatorDate(String creatorDate) {
        this.creatorDate = creatorDate == null ? null : creatorDate.trim();
    }

    /**
     * @mbggenerated 成交类型，DD:CASE_TYPE
     */
    public Byte getDealType() {
        return dealType;
    }

    /**
     * @mbggenerated 成交类型，DD:CASE_TYPE
     */
    public void setDealType(Byte dealType) {
        this.dealType = dealType;
    }

    /**
     * @mbggenerated 0,1,2未分配，待结算，已结算
     */
    public Byte getDealStatus() {
        return dealStatus;
    }

    /**
     * @mbggenerated 0,1,2未分配，待结算，已结算
     */
    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * @mbggenerated 主办人(USER_ID)
     */
    public Integer getDealUserId() {
        return dealUserId;
    }

    /**
     * @mbggenerated 主办人(USER_ID)
     */
    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    /**
     * @mbggenerated 此字段已废弃，新字段为DEAL_AUDIT_STATUS
     */
    public Byte getDealComplete() {
        return dealComplete;
    }

    /**
     * @mbggenerated 此字段已废弃，新字段为DEAL_AUDIT_STATUS
     */
    public void setDealComplete(Byte dealComplete) {
        this.dealComplete = dealComplete;
    }

    /**
     * @mbggenerated 结算时间
     */
    public String getDealVerifyTime() {
        return dealVerifyTime;
    }

    /**
     * @mbggenerated 结算时间
     */
    public void setDealVerifyTime(String dealVerifyTime) {
        this.dealVerifyTime = dealVerifyTime == null ? null : dealVerifyTime.trim();
    }

    /**
     * @mbggenerated 买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1
     */
    public Byte getDealBuyStyle() {
        return dealBuyStyle;
    }

    /**
     * @mbggenerated 买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1
     */
    public void setDealBuyStyle(Byte dealBuyStyle) {
        this.dealBuyStyle = dealBuyStyle;
    }

    /**
     * @mbggenerated 买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1
     */
    public Byte getDealSellStyle() {
        return dealSellStyle;
    }

    /**
     * @mbggenerated 买方是:内部合作OR外部合作，内部合作:inner 0外部合作:out  1
     */
    public void setDealSellStyle(Byte dealSellStyle) {
        this.dealSellStyle = dealSellStyle;
    }

    /**
     * @mbggenerated 用途，DD:HOUSE_USEAGE
     */
    public Byte getHouseUseage() {
        return houseUseage;
    }

    /**
     * @mbggenerated 用途，DD:HOUSE_USEAGE
     */
    public void setHouseUseage(Byte houseUseage) {
        this.houseUseage = houseUseage;
    }

    /**
     * @mbggenerated 客源ID
     */
    public Integer getDealCustomerId() {
        return dealCustomerId;
    }

    /**
     * @mbggenerated 客源ID
     */
    public void setDealCustomerId(Integer dealCustomerId) {
        this.dealCustomerId = dealCustomerId;
    }

    /**
     * @mbggenerated 客源编号
     */
    public String getDealCustomerNo() {
        return dealCustomerNo;
    }

    /**
     * @mbggenerated 客源编号
     */
    public void setDealCustomerNo(String dealCustomerNo) {
        this.dealCustomerNo = dealCustomerNo == null ? null : dealCustomerNo.trim();
    }

    /**
     * @mbggenerated 房源ID
     */
    public Integer getDealHouseId() {
        return dealHouseId;
    }

    /**
     * @mbggenerated 房源ID
     */
    public void setDealHouseId(Integer dealHouseId) {
        this.dealHouseId = dealHouseId;
    }

    /**
     * @mbggenerated 房源编号
     */
    public String getDealHouseNo() {
        return dealHouseNo;
    }

    /**
     * @mbggenerated 房源编号
     */
    public void setDealHouseNo(String dealHouseNo) {
        this.dealHouseNo = dealHouseNo == null ? null : dealHouseNo.trim();
    }

    /**
     * @mbggenerated 卖方物业地址，产权地址
     */
    public String getSellAddress() {
        return sellAddress;
    }

    /**
     * @mbggenerated 卖方物业地址，产权地址
     */
    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress == null ? null : sellAddress.trim();
    }

    /**
     * @mbggenerated 买方客户资料
     */
    public String getBuyCustinfo() {
        return buyCustinfo;
    }

    /**
     * @mbggenerated 买方客户资料
     */
    public void setBuyCustinfo(String buyCustinfo) {
        this.buyCustinfo = buyCustinfo == null ? null : buyCustinfo.trim();
    }

    /**
     * @mbggenerated 卖方合作公司
     */
    public String getSellHezuoCompname() {
        return sellHezuoCompname;
    }

    /**
     * @mbggenerated 卖方合作公司
     */
    public void setSellHezuoCompname(String sellHezuoCompname) {
        this.sellHezuoCompname = sellHezuoCompname == null ? null : sellHezuoCompname.trim();
    }

    /**
     * @mbggenerated 买方合作公司
     */
    public String getBuyHezuoCompname() {
        return buyHezuoCompname;
    }

    /**
     * @mbggenerated 买方合作公司
     */
    public void setBuyHezuoCompname(String buyHezuoCompname) {
        this.buyHezuoCompname = buyHezuoCompname == null ? null : buyHezuoCompname.trim();
    }

    /**
     * @mbggenerated 买方联系人（历史合同的）
     */
    public String getBuyContactuser() {
        return buyContactuser;
    }

    /**
     * @mbggenerated 买方联系人（历史合同的）
     */
    public void setBuyContactuser(String buyContactuser) {
        this.buyContactuser = buyContactuser == null ? null : buyContactuser.trim();
    }

    /**
     * @mbggenerated 卖方联系人
     */
    public String getSellContactuser() {
        return sellContactuser;
    }

    /**
     * @mbggenerated 卖方联系人
     */
    public void setSellContactuser(String sellContactuser) {
        this.sellContactuser = sellContactuser == null ? null : sellContactuser.trim();
    }

    /**
     * @mbggenerated 买方业主姓名
     */
    public String getBuyOwnerName() {
        return buyOwnerName;
    }

    /**
     * @mbggenerated 买方业主姓名
     */
    public void setBuyOwnerName(String buyOwnerName) {
        this.buyOwnerName = buyOwnerName == null ? null : buyOwnerName.trim();
    }

    /**
     * @mbggenerated 卖方业主姓名
     */
    public String getSellOwnerName() {
        return sellOwnerName;
    }

    /**
     * @mbggenerated 卖方业主姓名
     */
    public void setSellOwnerName(String sellOwnerName) {
        this.sellOwnerName = sellOwnerName == null ? null : sellOwnerName.trim();
    }

    /**
     * @mbggenerated 买方联系电话（经纪人）
     */
    public String getBuyCallPhone() {
        return buyCallPhone;
    }

    /**
     * @mbggenerated 买方联系电话（经纪人）
     */
    public void setBuyCallPhone(String buyCallPhone) {
        this.buyCallPhone = buyCallPhone == null ? null : buyCallPhone.trim();
    }

    /**
     * @mbggenerated 卖方联系电话（经纪人）
     */
    public String getSellCallPhone() {
        return sellCallPhone;
    }

    /**
     * @mbggenerated 卖方联系电话（经纪人）
     */
    public void setSellCallPhone(String sellCallPhone) {
        this.sellCallPhone = sellCallPhone == null ? null : sellCallPhone.trim();
    }

    /**
     * @mbggenerated 买方身份证
     */
    public String getBuyIdCard() {
        return buyIdCard;
    }

    /**
     * @mbggenerated 买方身份证
     */
    public void setBuyIdCard(String buyIdCard) {
        this.buyIdCard = buyIdCard == null ? null : buyIdCard.trim();
    }

    /**
     * @mbggenerated 卖方身份证
     */
    public String getSellIdCard() {
        return sellIdCard;
    }

    /**
     * @mbggenerated 卖方身份证
     */
    public void setSellIdCard(String sellIdCard) {
        this.sellIdCard = sellIdCard == null ? null : sellIdCard.trim();
    }

    /**
     * @mbggenerated 买方付佣
     */
    public BigDecimal getBuyPaymoney() {
        return buyPaymoney;
    }

    /**
     * @mbggenerated 买方付佣
     */
    public void setBuyPaymoney(BigDecimal buyPaymoney) {
        this.buyPaymoney = buyPaymoney;
    }

    /**
     * @mbggenerated 卖方付佣
     */
    public BigDecimal getSellPaymoney() {
        return sellPaymoney;
    }

    /**
     * @mbggenerated 卖方付佣
     */
    public void setSellPaymoney(BigDecimal sellPaymoney) {
        this.sellPaymoney = sellPaymoney;
    }

    /**
     * @mbggenerated 其他收入
     */
    public BigDecimal getOtherPaymoney() {
        return otherPaymoney;
    }

    /**
     * @mbggenerated 其他收入
     */
    public void setOtherPaymoney(BigDecimal otherPaymoney) {
        this.otherPaymoney = otherPaymoney;
    }

    /**
     * @mbggenerated 收到的佣金金额
     */
    public BigDecimal getGainMoney() {
        return gainMoney;
    }

    /**
     * @mbggenerated 收到的佣金金额
     */
    public void setGainMoney(BigDecimal gainMoney) {
        this.gainMoney = gainMoney;
    }

    /**
     * @mbggenerated 实际买方付佣
     */
    public BigDecimal getRealBuyPaymoney() {
        return realBuyPaymoney;
    }

    /**
     * @mbggenerated 实际买方付佣
     */
    public void setRealBuyPaymoney(BigDecimal realBuyPaymoney) {
        this.realBuyPaymoney = realBuyPaymoney;
    }

    /**
     * @mbggenerated 实际卖方付佣
     */
    public BigDecimal getRealSellPaymoney() {
        return realSellPaymoney;
    }

    /**
     * @mbggenerated 实际卖方付佣
     */
    public void setRealSellPaymoney(BigDecimal realSellPaymoney) {
        this.realSellPaymoney = realSellPaymoney;
    }

    /**
     * @mbggenerated 实际其他收入
     */
    public BigDecimal getRealOtherPaymoney() {
        return realOtherPaymoney;
    }

    /**
     * @mbggenerated 实际其他收入
     */
    public void setRealOtherPaymoney(BigDecimal realOtherPaymoney) {
        this.realOtherPaymoney = realOtherPaymoney;
    }

    /**
     * @mbggenerated 实际分佣金额
     */
    public BigDecimal getRealPaymoney() {
        return realPaymoney;
    }

    /**
     * @mbggenerated 实际分佣金额
     */
    public void setRealPaymoney(BigDecimal realPaymoney) {
        this.realPaymoney = realPaymoney;
    }

    /**
     * @mbggenerated 自付金额
     */
    public String getBuyPriceMoney() {
        return buyPriceMoney;
    }

    /**
     * @mbggenerated 自付金额
     */
    public void setBuyPriceMoney(String buyPriceMoney) {
        this.buyPriceMoney = buyPriceMoney == null ? null : buyPriceMoney.trim();
    }

    /**
     * @mbggenerated 按揭方式，DD: MORTGAGE_TYPE     贷款方式
     */
    public Byte getBuyMortgageType() {
        return buyMortgageType;
    }

    /**
     * @mbggenerated 按揭方式，DD: MORTGAGE_TYPE     贷款方式
     */
    public void setBuyMortgageType(Byte buyMortgageType) {
        this.buyMortgageType = buyMortgageType;
    }

    /**
     * @mbggenerated 成交金额
     */
    public BigDecimal getSellDealMoney() {
        return sellDealMoney;
    }

    /**
     * @mbggenerated 成交金额
     */
    public void setSellDealMoney(BigDecimal sellDealMoney) {
        this.sellDealMoney = sellDealMoney;
    }

    /**
     * @mbggenerated 卖方借贷，0:无贷款1:有贷款
     */
    public Boolean getSellIshaveLoan() {
        return sellIshaveLoan;
    }

    /**
     * @mbggenerated 卖方借贷，0:无贷款1:有贷款
     */
    public void setSellIshaveLoan(Boolean sellIshaveLoan) {
        this.sellIshaveLoan = sellIshaveLoan;
    }

    /**
     * @mbggenerated 贷款金额
     */
    public BigDecimal getSellLoanMoney() {
        return sellLoanMoney;
    }

    /**
     * @mbggenerated 贷款金额
     */
    public void setSellLoanMoney(BigDecimal sellLoanMoney) {
        this.sellLoanMoney = sellLoanMoney;
    }

    /**
     * @mbggenerated 还贷方式，0:其他方还1:卖方还
     */
    public Boolean getSellReturnLoan() {
        return sellReturnLoan;
    }

    /**
     * @mbggenerated 还贷方式，0:其他方还1:卖方还
     */
    public void setSellReturnLoan(Boolean sellReturnLoan) {
        this.sellReturnLoan = sellReturnLoan;
    }

    /**
     * @mbggenerated 权属，DD:HOUSE_RIGHT
     */
    public Integer getOwnerStyle() {
        return ownerStyle;
    }

    /**
     * @mbggenerated 权属，DD:HOUSE_RIGHT
     */
    public void setOwnerStyle(Integer ownerStyle) {
        this.ownerStyle = ownerStyle;
    }

    /**
     * @mbggenerated 权属类型，丘地号QIUDI_NO   1证书号HENGSHU_NO 2合同号HETONG_NO  3备案号BEIAN_NO   4
     */
    public Byte getOwnerType() {
        return ownerType;
    }

    /**
     * @mbggenerated 权属类型，丘地号QIUDI_NO   1证书号HENGSHU_NO 2合同号HETONG_NO  3备案号BEIAN_NO   4
     */
    public void setOwnerType(Byte ownerType) {
        this.ownerType = ownerType;
    }

    /**
     * @mbggenerated 权属号
     */
    public String getOwnerNo() {
        return ownerNo;
    }

    /**
     * @mbggenerated 权属号
     */
    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo == null ? null : ownerNo.trim();
    }

    /**
     * @mbggenerated 有无国土证号，1:有0:无
     */
    public Boolean getHaveLandcard() {
        return haveLandcard;
    }

    /**
     * @mbggenerated 有无国土证号，1:有0:无
     */
    public void setHaveLandcard(Boolean haveLandcard) {
        this.haveLandcard = haveLandcard;
    }

    /**
     * @mbggenerated 国土证号
     */
    public String getLandcardNo() {
        return landcardNo;
    }

    /**
     * @mbggenerated 国土证号
     */
    public void setLandcardNo(String landcardNo) {
        this.landcardNo = landcardNo == null ? null : landcardNo.trim();
    }

    /**
     * @mbggenerated 营业税，1:有0:无
     */
    public Boolean getMangementTax() {
        return mangementTax;
    }

    /**
     * @mbggenerated 营业税，1:有0:无
     */
    public void setMangementTax(Boolean mangementTax) {
        this.mangementTax = mangementTax;
    }

    /**
     * @mbggenerated 个税，1:有0:无
     */
    public Boolean getOwnerTax() {
        return ownerTax;
    }

    /**
     * @mbggenerated 个税，1:有0:无
     */
    public void setOwnerTax(Boolean ownerTax) {
        this.ownerTax = ownerTax;
    }

    /**
     * @mbggenerated 税费支付，DD:TAX_TYPE
     */
    public String getTax() {
        return tax;
    }

    /**
     * @mbggenerated 税费支付，DD:TAX_TYPE
     */
    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    /**
     * @mbggenerated 附加条款
     */
    public String getTradeRemarkExplain() {
        return tradeRemarkExplain;
    }

    /**
     * @mbggenerated 附加条款
     */
    public void setTradeRemarkExplain(String tradeRemarkExplain) {
        this.tradeRemarkExplain = tradeRemarkExplain == null ? null : tradeRemarkExplain.trim();
    }

    /**
     * @mbggenerated 成交租金
     */
    public BigDecimal getRentDealMoney() {
        return rentDealMoney;
    }

    /**
     * @mbggenerated 成交租金
     */
    public void setRentDealMoney(BigDecimal rentDealMoney) {
        this.rentDealMoney = rentDealMoney;
    }

    /**
     * @mbggenerated 租金单位，DD:PRICE_UNIT
     */
    public Byte getRentPriceUnit() {
        return rentPriceUnit;
    }

    /**
     * @mbggenerated 租金单位，DD:PRICE_UNIT
     */
    public void setRentPriceUnit(Byte rentPriceUnit) {
        this.rentPriceUnit = rentPriceUnit;
    }

    /**
     * @mbggenerated 起租时间
     */
    public String getRentDate() {
        return rentDate;
    }

    /**
     * @mbggenerated 起租时间
     */
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate == null ? null : rentDate.trim();
    }

    /**
     * @mbggenerated 到期时间
     */
    public String getRentOverDate() {
        return rentOverDate;
    }

    /**
     * @mbggenerated 到期时间
     */
    public void setRentOverDate(String rentOverDate) {
        this.rentOverDate = rentOverDate == null ? null : rentOverDate.trim();
    }

    /**
     * @mbggenerated 付款方式，DD:RENT_ACCOUNT
     */
    public Byte getRentPayMethod() {
        return rentPayMethod;
    }

    /**
     * @mbggenerated 付款方式，DD:RENT_ACCOUNT
     */
    public void setRentPayMethod(Byte rentPayMethod) {
        this.rentPayMethod = rentPayMethod;
    }

    /**
     * @mbggenerated 付款间隔
     */
    public String getRentPaySpace() {
        return rentPaySpace;
    }

    /**
     * @mbggenerated 付款间隔
     */
    public void setRentPaySpace(String rentPaySpace) {
        this.rentPaySpace = rentPaySpace == null ? null : rentPaySpace.trim();
    }

    /**
     * @mbggenerated 付款时间，提示:提前几天付
     */
    public String getRentPayEarly() {
        return rentPayEarly;
    }

    /**
     * @mbggenerated 付款时间，提示:提前几天付
     */
    public void setRentPayEarly(String rentPayEarly) {
        this.rentPayEarly = rentPayEarly == null ? null : rentPayEarly.trim();
    }

    /**
     * @mbggenerated 押金支付
     */
    public BigDecimal getRentDepositPay() {
        return rentDepositPay;
    }

    /**
     * @mbggenerated 押金支付
     */
    public void setRentDepositPay(BigDecimal rentDepositPay) {
        this.rentDepositPay = rentDepositPay;
    }

    /**
     * @mbggenerated 其他费用
     */
    public BigDecimal getRentOtherMoney() {
        return rentOtherMoney;
    }

    /**
     * @mbggenerated 其他费用
     */
    public void setRentOtherMoney(BigDecimal rentOtherMoney) {
        this.rentOtherMoney = rentOtherMoney;
    }

    /**
     * @mbggenerated 物品清单
     */
    public String getGoodsdetailed() {
        return goodsdetailed;
    }

    /**
     * @mbggenerated 物品清单
     */
    public void setGoodsdetailed(String goodsdetailed) {
        this.goodsdetailed = goodsdetailed == null ? null : goodsdetailed.trim();
    }

    /**
     * @mbggenerated 水电抄表
     */
    public String getWaterlightexpenses() {
        return waterlightexpenses;
    }

    /**
     * @mbggenerated 水电抄表
     */
    public void setWaterlightexpenses(String waterlightexpenses) {
        this.waterlightexpenses = waterlightexpenses == null ? null : waterlightexpenses.trim();
    }

    /**
     * @mbggenerated 系统记录的时间
     */
    public String getSystemRecordTime() {
        return systemRecordTime;
    }

    /**
     * @mbggenerated 系统记录的时间
     */
    public void setSystemRecordTime(String systemRecordTime) {
        this.systemRecordTime = systemRecordTime == null ? null : systemRecordTime.trim();
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
     * @mbggenerated 创建人
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     * @mbggenerated 创建人
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     * @mbggenerated 合同修改，最后一次修改详情请看修改记录日志
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     * @mbggenerated 合同修改，最后一次修改详情请看修改记录日志
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    /**
     * @mbggenerated 合同修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @mbggenerated 合同修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @mbggenerated 客源所属部门名
     */
    public String getCustDeptname() {
        return custDeptname;
    }

    /**
     * @mbggenerated 客源所属部门名
     */
    public void setCustDeptname(String custDeptname) {
        this.custDeptname = custDeptname == null ? null : custDeptname.trim();
    }

    /**
     * @mbggenerated 客源所属经纪人名
     */
    public String getCustUsername() {
        return custUsername;
    }

    /**
     * @mbggenerated 客源所属经纪人名
     */
    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername == null ? null : custUsername.trim();
    }

    /**
     * @mbggenerated 客源所属经纪人ID
     */
    public Integer getCustUserUid() {
        return custUserUid;
    }

    /**
     * @mbggenerated 客源所属经纪人ID
     */
    public void setCustUserUid(Integer custUserUid) {
        this.custUserUid = custUserUid;
    }

    /**
     * @mbggenerated 客源所属部门人ID
     */
    public Integer getCustDeptId() {
        return custDeptId;
    }

    /**
     * @mbggenerated 客源所属部门人ID
     */
    public void setCustDeptId(Integer custDeptId) {
        this.custDeptId = custDeptId;
    }

    /**
     * @mbggenerated 客源成交时的盘别
     */
    public Byte getCustPlate() {
        return custPlate;
    }

    /**
     * @mbggenerated 客源成交时的盘别
     */
    public void setCustPlate(Byte custPlate) {
        this.custPlate = custPlate;
    }

    /**
     * @mbggenerated 房源所属部门名
     */
    public String getHouseDeptname() {
        return houseDeptname;
    }

    /**
     * @mbggenerated 房源所属部门名
     */
    public void setHouseDeptname(String houseDeptname) {
        this.houseDeptname = houseDeptname == null ? null : houseDeptname.trim();
    }

    /**
     * @mbggenerated 房源所属经纪人名
     */
    public String getHouseUsername() {
        return houseUsername;
    }

    /**
     * @mbggenerated 房源所属经纪人名
     */
    public void setHouseUsername(String houseUsername) {
        this.houseUsername = houseUsername == null ? null : houseUsername.trim();
    }

    /**
     * @mbggenerated 房源所属经纪人ID
     */
    public Integer getHouseUserUid() {
        return houseUserUid;
    }

    /**
     * @mbggenerated 房源所属经纪人ID
     */
    public void setHouseUserUid(Integer houseUserUid) {
        this.houseUserUid = houseUserUid;
    }

    /**
     * @mbggenerated 房源所属部门ID
     */
    public Integer getHouseDeptId() {
        return houseDeptId;
    }

    /**
     * @mbggenerated 房源所属部门ID
     */
    public void setHouseDeptId(Integer houseDeptId) {
        this.houseDeptId = houseDeptId;
    }

    /**
     * @mbggenerated 房源成交时的盘别
     */
    public Byte getHousePlate() {
        return housePlate;
    }

    /**
     * @mbggenerated 房源成交时的盘别
     */
    public void setHousePlate(Byte housePlate) {
        this.housePlate = housePlate;
    }

    /**
     * @mbggenerated 合同成交时的房源楼盘ID
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     * @mbggenerated 合同成交时的房源楼盘ID
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     * @mbggenerated 合同成交时的房源楼盘名
     */
    public String getBuildName() {
        return buildName;
    }

    /**
     * @mbggenerated 合同成交时的房源楼盘名
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
    }

    /**
     * @mbggenerated 合同成交时的房源地址描述
     */
    public String getHouseaddress() {
        return houseaddress;
    }

    /**
     * @mbggenerated 合同成交时的房源地址描述
     */
    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress == null ? null : houseaddress.trim();
    }

    /**
     * @mbggenerated 房源的实际价格
     */
    public BigDecimal getRealTotalprice() {
        return realTotalprice;
    }

    /**
     * @mbggenerated 房源的实际价格
     */
    public void setRealTotalprice(BigDecimal realTotalprice) {
        this.realTotalprice = realTotalprice;
    }

    /**
     * @mbggenerated 主办人的门店id
     */
    public Integer getDealDeptId() {
        return dealDeptId;
    }

    /**
     * @mbggenerated 主办人的门店id
     */
    public void setDealDeptId(Integer dealDeptId) {
        this.dealDeptId = dealDeptId;
    }

    /**
     * @mbggenerated 房源租金到期的提醒任务
     */
    public Integer getHouseDuetimeTaskId() {
        return houseDuetimeTaskId;
    }

    /**
     * @mbggenerated 房源租金到期的提醒任务
     */
    public void setHouseDuetimeTaskId(Integer houseDuetimeTaskId) {
        this.houseDuetimeTaskId = houseDuetimeTaskId;
    }

    /**
     * @mbggenerated 客源租金到期的提醒任务
     */
    public Integer getCustDuetimeTaskId() {
        return custDuetimeTaskId;
    }

    /**
     * @mbggenerated 客源租金到期的提醒任务
     */
    public void setCustDuetimeTaskId(Integer custDuetimeTaskId) {
        this.custDuetimeTaskId = custDuetimeTaskId;
    }

    /**
     * @mbggenerated 流程类别，PROCESS_MODEL.MODEL_ID
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * @mbggenerated 流程类别，PROCESS_MODEL.MODEL_ID
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * @mbggenerated 合同号【合同创建时不论是手动输入还是自动分配的编号】
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * @mbggenerated 合同号【合同创建时不论是手动输入还是自动分配的编号】
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * @mbggenerated 当前执行实例的ID，PROCESS_RUNTIME_STEP表的RUNSTEP _ID
     */
    public Integer getRunstepId() {
        return runstepId;
    }

    /**
     * @mbggenerated 当前执行实例的ID，PROCESS_RUNTIME_STEP表的RUNSTEP _ID
     */
    public void setRunstepId(Integer runstepId) {
        this.runstepId = runstepId;
    }

    /**
     * @mbggenerated 当前执行步骤名
     */
    public String getRunstepName() {
        return runstepName;
    }

    /**
     * @mbggenerated 当前执行步骤名
     */
    public void setRunstepName(String runstepName) {
        this.runstepName = runstepName == null ? null : runstepName.trim();
    }

    /**
     * @mbggenerated 到期时间，根据时间限制类别根据UPDATE_TIME TIMELIMIT计算出
     */
    public String getTimelimitdate() {
        return timelimitdate;
    }

    /**
     * @mbggenerated 到期时间，根据时间限制类别根据UPDATE_TIME TIMELIMIT计算出
     */
    public void setTimelimitdate(String timelimitdate) {
        this.timelimitdate = timelimitdate == null ? null : timelimitdate.trim();
    }

    /**
     * @mbggenerated 指定执行人
     */
    public Integer getExecutor() {
        return executor;
    }

    /**
     * @mbggenerated 指定执行人
     */
    public void setExecutor(Integer executor) {
        this.executor = executor;
    }

    /**
     * @mbggenerated 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @mbggenerated 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @mbggenerated 审核人
     */
    public Integer getCompleteUser() {
        return completeUser;
    }

    /**
     * @mbggenerated 审核人
     */
    public void setCompleteUser(Integer completeUser) {
        this.completeUser = completeUser;
    }

    /**
     * @mbggenerated 审核时间
     */
    public String getCompleteDate() {
        return completeDate;
    }

    /**
     * @mbggenerated 审核时间
     */
    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate == null ? null : completeDate.trim();
    }

    /**
     * @mbggenerated 流程名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @mbggenerated 流程名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * @mbggenerated 主办人姓名
     */
    public String getDealUserName() {
        return dealUserName;
    }

    /**
     * @mbggenerated 主办人姓名
     */
    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName == null ? null : dealUserName.trim();
    }

    /**
     * @mbggenerated 审核人姓名
     */
    public String getCompleteUserName() {
        return completeUserName;
    }

    /**
     * @mbggenerated 审核人姓名
     */
    public void setCompleteUserName(String completeUserName) {
        this.completeUserName = completeUserName == null ? null : completeUserName.trim();
    }

    /**
     * @mbggenerated 创建人姓名
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @mbggenerated 创建人姓名
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * @mbggenerated 房屋面积
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * @mbggenerated 房屋面积
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /**
     * @mbggenerated DD：HOUSE_FITMENT
     */
    public Byte getFitment() {
        return fitment;
    }

    /**
     * @mbggenerated DD：HOUSE_FITMENT
     */
    public void setFitment(Byte fitment) {
        this.fitment = fitment;
    }

    /**
     * @mbggenerated 模板编号
     */
    public Short getModelNo() {
        return modelNo;
    }

    /**
     * @mbggenerated 模板编号
     */
    public void setModelNo(Short modelNo) {
        this.modelNo = modelNo;
    }

    /**
     * @mbggenerated 流程序号
     */
    public Short getStepNo() {
        return stepNo;
    }

    /**
     * @mbggenerated 流程序号
     */
    public void setStepNo(Short stepNo) {
        this.stepNo = stepNo;
    }

    /**
     * @mbggenerated 合同修改人姓名
     */
    public String getUpdateUsername() {
        return updateUsername;
    }

    /**
     * @mbggenerated 合同修改人姓名
     */
    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername == null ? null : updateUsername.trim();
    }

    /**
     * @mbggenerated 合同锁定标志
     */
    public Byte getLockFlag() {
        return lockFlag;
    }

    /**
     * @mbggenerated 合同锁定标志
     */
    public void setLockFlag(Byte lockFlag) {
        this.lockFlag = lockFlag;
    }

    /**
     * @mbggenerated 合同内容类型，0:表示非完整合同(用于业绩统计)1:表示完整合同
     */
    public Byte getDealInfoType() {
        return dealInfoType;
    }

    /**
     * @mbggenerated 合同内容类型，0:表示非完整合同(用于业绩统计)1:表示完整合同
     */
    public void setDealInfoType(Byte dealInfoType) {
        this.dealInfoType = dealInfoType;
    }

    /**
     * @mbggenerated 合同录入类型，1: 手动录入业绩生成的合同(即没有权证的合同,虚拟合同)0 or null: 权证合同
     */
    public Byte getIsbyhand() {
        return isbyhand;
    }

    /**
     * @mbggenerated 合同录入类型，1: 手动录入业绩生成的合同(即没有权证的合同,虚拟合同)0 or null: 权证合同
     */
    public void setIsbyhand(Byte isbyhand) {
        this.isbyhand = isbyhand;
    }

    /**
     * @mbggenerated 片区ID
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     * @mbggenerated 片区ID
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    /**
     * @mbggenerated 大区ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * @mbggenerated 大区ID
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @mbggenerated 签约人ID
     */
    public Integer getSignUserId() {
        return signUserId;
    }

    /**
     * @mbggenerated 签约人ID
     */
    public void setSignUserId(Integer signUserId) {
        this.signUserId = signUserId;
    }

    /**
     * @mbggenerated 签约人姓名
     */
    public String getSignUserName() {
        return signUserName;
    }

    /**
     * @mbggenerated 签约人姓名
     */
    public void setSignUserName(String signUserName) {
        this.signUserName = signUserName == null ? null : signUserName.trim();
    }

    /**
     * @mbggenerated 签约主管ID
     */
    public Integer getSignManagerId() {
        return signManagerId;
    }

    /**
     * @mbggenerated 签约主管ID
     */
    public void setSignManagerId(Integer signManagerId) {
        this.signManagerId = signManagerId;
    }

    /**
     * @mbggenerated 签约主管人姓名
     */
    public String getSignManagerName() {
        return signManagerName;
    }

    /**
     * @mbggenerated 签约主管人姓名
     */
    public void setSignManagerName(String signManagerName) {
        this.signManagerName = signManagerName == null ? null : signManagerName.trim();
    }

    /**
     * @mbggenerated 签约人门店ID
     */
    public Integer getSignUserDeptId() {
        return signUserDeptId;
    }

    /**
     * @mbggenerated 签约人门店ID
     */
    public void setSignUserDeptId(Integer signUserDeptId) {
        this.signUserDeptId = signUserDeptId;
    }

    /**
     * @mbggenerated 签约人门店名
     */
    public String getSignUserDeptName() {
        return signUserDeptName;
    }

    /**
     * @mbggenerated 签约人门店名
     */
    public void setSignUserDeptName(String signUserDeptName) {
        this.signUserDeptName = signUserDeptName == null ? null : signUserDeptName.trim();
    }

    /**
     * @mbggenerated 签约经理门店ID
     */
    public Integer getSignManagerDeptId() {
        return signManagerDeptId;
    }

    /**
     * @mbggenerated 签约经理门店ID
     */
    public void setSignManagerDeptId(Integer signManagerDeptId) {
        this.signManagerDeptId = signManagerDeptId;
    }

    /**
     * @mbggenerated 签约经理门店名
     */
    public String getSignManagerDeptName() {
        return signManagerDeptName;
    }

    /**
     * @mbggenerated 签约经理门店名
     */
    public void setSignManagerDeptName(String signManagerDeptName) {
        this.signManagerDeptName = signManagerDeptName == null ? null : signManagerDeptName.trim();
    }

    /**
     * @mbggenerated 财务状态ID
     */
    public Integer getFinancStatusId() {
        return financStatusId;
    }

    /**
     * @mbggenerated 财务状态ID
     */
    public void setFinancStatusId(Integer financStatusId) {
        this.financStatusId = financStatusId;
    }

    /**
     * @mbggenerated 财务状态名字
     */
    public String getFinancName() {
        return financName;
    }

    /**
     * @mbggenerated 财务状态名字
     */
    public void setFinancName(String financName) {
        this.financName = financName == null ? null : financName.trim();
    }

    /**
     * @mbggenerated 合同类别ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @mbggenerated 合同类别ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @mbggenerated 合同类别名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @mbggenerated 合同类别名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * @mbggenerated 签定时间
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * @mbggenerated 签定时间
     */
    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

    /**
     * @mbggenerated 过户日期
     */
    public String getTransferDate() {
        return transferDate;
    }

    /**
     * @mbggenerated 过户日期
     */
    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate == null ? null : transferDate.trim();
    }

    /**
     * @mbggenerated 取证日期
     */
    public String getEvidenceDate() {
        return evidenceDate;
    }

    /**
     * @mbggenerated 取证日期
     */
    public void setEvidenceDate(String evidenceDate) {
        this.evidenceDate = evidenceDate == null ? null : evidenceDate.trim();
    }

    /**
     * @mbggenerated 买方共有人姓名
     */
    public String getBuyOwnerNameBak() {
        return buyOwnerNameBak;
    }

    /**
     * @mbggenerated 买方共有人姓名
     */
    public void setBuyOwnerNameBak(String buyOwnerNameBak) {
        this.buyOwnerNameBak = buyOwnerNameBak == null ? null : buyOwnerNameBak.trim();
    }

    /**
     * @mbggenerated 卖方业主姓名
     */
    public String getSellOwnerNameBak() {
        return sellOwnerNameBak;
    }

    /**
     * @mbggenerated 卖方业主姓名
     */
    public void setSellOwnerNameBak(String sellOwnerNameBak) {
        this.sellOwnerNameBak = sellOwnerNameBak == null ? null : sellOwnerNameBak.trim();
    }

    /**
     * @mbggenerated 买方业主身份证
     */
    public String getBuyIdCardBak() {
        return buyIdCardBak;
    }

    /**
     * @mbggenerated 买方业主身份证
     */
    public void setBuyIdCardBak(String buyIdCardBak) {
        this.buyIdCardBak = buyIdCardBak == null ? null : buyIdCardBak.trim();
    }

    /**
     * @mbggenerated 卖方业主身份证
     */
    public String getSellIdCardBak() {
        return sellIdCardBak;
    }

    /**
     * @mbggenerated 卖方业主身份证
     */
    public void setSellIdCardBak(String sellIdCardBak) {
        this.sellIdCardBak = sellIdCardBak == null ? null : sellIdCardBak.trim();
    }

    /**
     * @mbggenerated 卖方成交价格金额
     */
    public Byte getSalePriceUnit() {
        return salePriceUnit;
    }

    /**
     * @mbggenerated 卖方成交价格金额
     */
    public void setSalePriceUnit(Byte salePriceUnit) {
        this.salePriceUnit = salePriceUnit;
    }

    /**
     * @mbggenerated 出租周期
     */
    public String getRentCycle() {
        return rentCycle;
    }

    /**
     * @mbggenerated 出租周期
     */
    public void setRentCycle(String rentCycle) {
        this.rentCycle = rentCycle == null ? null : rentCycle.trim();
    }

    /**
     * @mbggenerated 分配的合同号段ID
     */
    public Integer getCodeId() {
        return codeId;
    }

    /**
     * @mbggenerated 分配的合同号段ID
     */
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    /**
     * @mbggenerated 流程状态（0：未履行1：履行中2,：已办结）
     */
    public Byte getProcessStatus() {
        return processStatus;
    }

    /**
     * @mbggenerated 流程状态（0：未履行1：履行中2,：已办结）
     */
    public void setProcessStatus(Byte processStatus) {
        this.processStatus = processStatus;
    }

    /**
     * @mbggenerated 客户电话
     */
    public String getBuyCustomerPhone() {
        return buyCustomerPhone;
    }

    /**
     * @mbggenerated 客户电话
     */
    public void setBuyCustomerPhone(String buyCustomerPhone) {
        this.buyCustomerPhone = buyCustomerPhone == null ? null : buyCustomerPhone.trim();
    }

    /**
     * @mbggenerated 客户电话带类型
     */
    public String getBuyCustomerPhoneencode() {
        return buyCustomerPhoneencode;
    }

    /**
     * @mbggenerated 客户电话带类型
     */
    public void setBuyCustomerPhoneencode(String buyCustomerPhoneencode) {
        this.buyCustomerPhoneencode = buyCustomerPhoneencode == null ? null : buyCustomerPhoneencode.trim();
    }

    /**
     * @mbggenerated 业主电话
     */
    public String getSellOwnerPhone() {
        return sellOwnerPhone;
    }

    /**
     * @mbggenerated 业主电话
     */
    public void setSellOwnerPhone(String sellOwnerPhone) {
        this.sellOwnerPhone = sellOwnerPhone == null ? null : sellOwnerPhone.trim();
    }

    /**
     * @mbggenerated 业主电话带类型
     */
    public String getSellOwnerPhoneencode() {
        return sellOwnerPhoneencode;
    }

    /**
     * @mbggenerated 业主电话带类型
     */
    public void setSellOwnerPhoneencode(String sellOwnerPhoneencode) {
        this.sellOwnerPhoneencode = sellOwnerPhoneencode == null ? null : sellOwnerPhoneencode.trim();
    }

    /**
     * @mbggenerated 卖方共有人电话
     */
    public String getSellOwnerPhoneBak() {
        return sellOwnerPhoneBak;
    }

    /**
     * @mbggenerated 卖方共有人电话
     */
    public void setSellOwnerPhoneBak(String sellOwnerPhoneBak) {
        this.sellOwnerPhoneBak = sellOwnerPhoneBak == null ? null : sellOwnerPhoneBak.trim();
    }

    /**
     * @mbggenerated 买方共有人电话
     */
    public String getBuyCustomerPhoneBak() {
        return buyCustomerPhoneBak;
    }

    /**
     * @mbggenerated 买方共有人电话
     */
    public void setBuyCustomerPhoneBak(String buyCustomerPhoneBak) {
        this.buyCustomerPhoneBak = buyCustomerPhoneBak == null ? null : buyCustomerPhoneBak.trim();
    }

    /**
     * @mbggenerated 合同ID
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * @mbggenerated 合同ID
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * @mbggenerated 支付方式ID 1=一次性 2=按揭
     */
    public Integer getPaytypeId() {
        return paytypeId;
    }

    /**
     * @mbggenerated 支付方式ID 1=一次性 2=按揭
     */
    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    /**
     * @mbggenerated 支付方式名称
     */
    public String getPaytypeName() {
        return paytypeName;
    }

    /**
     * @mbggenerated 支付方式名称
     */
    public void setPaytypeName(String paytypeName) {
        this.paytypeName = paytypeName == null ? null : paytypeName.trim();
    }

    /**
     * @mbggenerated 针对you+的合同审核状态，一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 4:等待二审 5:二审通过 6:二审未通过 7：内部审核 8:内审不通过（2017-4-20 取消二审状态）
     */
    public Byte getYouAduitStatus() {
        return youAduitStatus;
    }

    /**
     * @mbggenerated 针对you+的合同审核状态，一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 4:等待二审 5:二审通过 6:二审未通过 7：内部审核 8:内审不通过（2017-4-20 取消二审状态）
     */
    public void setYouAduitStatus(Byte youAduitStatus) {
        this.youAduitStatus = youAduitStatus;
    }

    /**
     * @mbggenerated 合同审核状态 0=未审核，1=初审，2=复审，3=作废
     */
    public Byte getDealAuditStatus() {
        return dealAuditStatus;
    }

    /**
     * @mbggenerated 合同审核状态 0=未审核，1=初审，2=复审，3=作废
     */
    public void setDealAuditStatus(Byte dealAuditStatus) {
        this.dealAuditStatus = dealAuditStatus;
    }

    /**
     * @mbggenerated 商业贷贷款年限
     */
    public String getCommercialLenderLimit() {
        return commercialLenderLimit;
    }

    /**
     * @mbggenerated 商业贷贷款年限
     */
    public void setCommercialLenderLimit(String commercialLenderLimit) {
        this.commercialLenderLimit = commercialLenderLimit == null ? null : commercialLenderLimit.trim();
    }

    /**
     * @mbggenerated 商业贷贷款银行
     */
    public String getCommercialLenderBank() {
        return commercialLenderBank;
    }

    /**
     * @mbggenerated 商业贷贷款银行
     */
    public void setCommercialLenderBank(String commercialLenderBank) {
        this.commercialLenderBank = commercialLenderBank == null ? null : commercialLenderBank.trim();
    }

    /**
     * @mbggenerated 公积金贷放款日期
     */
    public Date getProvidentLoanDate() {
        return providentLoanDate;
    }

    /**
     * @mbggenerated 公积金贷放款日期
     */
    public void setProvidentLoanDate(Date providentLoanDate) {
        this.providentLoanDate = providentLoanDate;
    }

    /**
     * @mbggenerated 公积金贷贷款日期
     */
    public Date getProvidentLenderDate() {
        return providentLenderDate;
    }

    /**
     * @mbggenerated 公积金贷贷款日期
     */
    public void setProvidentLenderDate(Date providentLenderDate) {
        this.providentLenderDate = providentLenderDate;
    }

    /**
     * @mbggenerated 公积金贷贷款年限
     */
    public String getProvidentLenderLimit() {
        return providentLenderLimit;
    }

    /**
     * @mbggenerated 公积金贷贷款年限
     */
    public void setProvidentLenderLimit(String providentLenderLimit) {
        this.providentLenderLimit = providentLenderLimit == null ? null : providentLenderLimit.trim();
    }

    /**
     * @mbggenerated 公积金贷贷款银行
     */
    public String getProvidentLenderBank() {
        return providentLenderBank;
    }

    /**
     * @mbggenerated 公积金贷贷款银行
     */
    public void setProvidentLenderBank(String providentLenderBank) {
        this.providentLenderBank = providentLenderBank == null ? null : providentLenderBank.trim();
    }

    /**
     * @mbggenerated 应收总计
     */
    public BigDecimal getTotalNeedIncome() {
        return totalNeedIncome;
    }

    /**
     * @mbggenerated 应收总计
     */
    public void setTotalNeedIncome(BigDecimal totalNeedIncome) {
        this.totalNeedIncome = totalNeedIncome;
    }

    /**
     * @mbggenerated 实收总计
     */
    public BigDecimal getTotalRealIncome() {
        return totalRealIncome;
    }

    /**
     * @mbggenerated 实收总计
     */
    public void setTotalRealIncome(BigDecimal totalRealIncome) {
        this.totalRealIncome = totalRealIncome;
    }

    /**
     * @mbggenerated 应收业绩
     */
    public BigDecimal getTotalNeedPerformance() {
        return totalNeedPerformance;
    }

    /**
     * @mbggenerated 应收业绩
     */
    public void setTotalNeedPerformance(BigDecimal totalNeedPerformance) {
        this.totalNeedPerformance = totalNeedPerformance;
    }

    /**
     * @mbggenerated 实收业绩
     */
    public BigDecimal getTotalRealPerformance() {
        return totalRealPerformance;
    }

    /**
     * @mbggenerated 实收业绩
     */
    public void setTotalRealPerformance(BigDecimal totalRealPerformance) {
        this.totalRealPerformance = totalRealPerformance;
    }

    /**
     * @mbggenerated 应收审核状态
     */
    public Byte getNeedAduitStatus() {
        return needAduitStatus;
    }

    /**
     * @mbggenerated 应收审核状态
     */
    public void setNeedAduitStatus(Byte needAduitStatus) {
        this.needAduitStatus = needAduitStatus;
    }

    /**
     * @mbggenerated 实收审核状态
     */
    public Byte getRealAduitStatus() {
        return realAduitStatus;
    }

    /**
     * @mbggenerated 实收审核状态
     */
    public void setRealAduitStatus(Byte realAduitStatus) {
        this.realAduitStatus = realAduitStatus;
    }

    /**
     * @mbggenerated 智能搜索(CONTRACT_NO=合同编号 BUY_OWNER_NAME=买方业主姓名 HOUSEADDRESS=合同成交时的房源地址描述 SELL_OWNER_NAME=卖方业主姓名 SELL_ADDRESS=卖方物业地址 产权地址 DEAL_HOUSE_NO=房源编号 DEAL_CUSTOMER_NO=客源编号 SELL_CALL_PHONE=卖方联系电话 BUY_CALL_PHONE=买方联系电话 BUY_ID_CARD=买方身份证号 SELL_ID_CARD=业主身份证号)
     */
    public String getIntelligentSearch() {
        return intelligentSearch;
    }

    /**
     * @mbggenerated 智能搜索(CONTRACT_NO=合同编号 BUY_OWNER_NAME=买方业主姓名 HOUSEADDRESS=合同成交时的房源地址描述 SELL_OWNER_NAME=卖方业主姓名 SELL_ADDRESS=卖方物业地址 产权地址 DEAL_HOUSE_NO=房源编号 DEAL_CUSTOMER_NO=客源编号 SELL_CALL_PHONE=卖方联系电话 BUY_CALL_PHONE=买方联系电话 BUY_ID_CARD=买方身份证号 SELL_ID_CARD=业主身份证号)
     */
    public void setIntelligentSearch(String intelligentSearch) {
        this.intelligentSearch = intelligentSearch == null ? null : intelligentSearch.trim();
    }

    /**
     * @mbggenerated 公积金贷款金额
     */
    public BigDecimal getProvidentLoanMoney() {
        return providentLoanMoney;
    }

    /**
     * @mbggenerated 公积金贷款金额
     */
    public void setProvidentLoanMoney(BigDecimal providentLoanMoney) {
        this.providentLoanMoney = providentLoanMoney;
    }

    /**
     * @mbggenerated 商业贷款金额
     */
    public BigDecimal getCommercialLoanMoney() {
        return commercialLoanMoney;
    }

    /**
     * @mbggenerated 商业贷款金额
     */
    public void setCommercialLoanMoney(BigDecimal commercialLoanMoney) {
        this.commercialLoanMoney = commercialLoanMoney;
    }

    /**
     * @mbggenerated 税费审核默认0代表未审核1代表已审核
     */
    public Byte getTaxesAuditStatus() {
        return taxesAuditStatus;
    }

    /**
     * @mbggenerated 税费审核默认0代表未审核1代表已审核
     */
    public void setTaxesAuditStatus(Byte taxesAuditStatus) {
        this.taxesAuditStatus = taxesAuditStatus;
    }

    /**
     * @mbggenerated 税费审核审核人姓名
     */
    public String getTaxesAuditName() {
        return taxesAuditName;
    }

    /**
     * @mbggenerated 税费审核审核人姓名
     */
    public void setTaxesAuditName(String taxesAuditName) {
        this.taxesAuditName = taxesAuditName == null ? null : taxesAuditName.trim();
    }

    /**
     * @mbggenerated 税费审核人
     */
    public Integer getTaxesAuditUser() {
        return taxesAuditUser;
    }

    /**
     * @mbggenerated 税费审核人
     */
    public void setTaxesAuditUser(Integer taxesAuditUser) {
        this.taxesAuditUser = taxesAuditUser;
    }

    /**
     * @mbggenerated 税费审核时间
     */
    public Date getTaxesAuditTime() {
        return taxesAuditTime;
    }

    /**
     * @mbggenerated 税费审核时间
     */
    public void setTaxesAuditTime(Date taxesAuditTime) {
        this.taxesAuditTime = taxesAuditTime;
    }

    /**
     * @mbggenerated 审核律师
     */
    public String getDealAuditor() {
        return dealAuditor;
    }

    /**
     * @mbggenerated 审核律师
     */
    public void setDealAuditor(String dealAuditor) {
        this.dealAuditor = dealAuditor == null ? null : dealAuditor.trim();
    }

    /**
     * @mbggenerated 律师审核意见
     */
    public String getYouAduitOpinion() {
        return youAduitOpinion;
    }

    /**
     * @mbggenerated 律师审核意见
     */
    public void setYouAduitOpinion(String youAduitOpinion) {
        this.youAduitOpinion = youAduitOpinion == null ? null : youAduitOpinion.trim();
    }

    /**
     * @mbggenerated 是否是youjia合同
     */
    public Byte getYouDealFlag() {
        return youDealFlag;
    }

    /**
     * @mbggenerated 是否是youjia合同
     */
    public void setYouDealFlag(Byte youDealFlag) {
        this.youDealFlag = youDealFlag;
    }

    /**
     * @mbggenerated 提交律师审核时间
     */
    public Date getSubAduitTime() {
        return subAduitTime;
    }

    /**
     * @mbggenerated 提交律师审核时间
     */
    public void setSubAduitTime(Date subAduitTime) {
        this.subAduitTime = subAduitTime;
    }

    /**
     * @mbggenerated 是否是youjia合同
     */
    public Byte getYoujiaDeal() {
        return youjiaDeal;
    }

    /**
     * @mbggenerated 是否是youjia合同
     */
    public void setYoujiaDeal(Byte youjiaDeal) {
        this.youjiaDeal = youjiaDeal;
    }

    /**
     * @mbggenerated 楼盘行政区名称
     */
    public String getBuildRegName() {
        return buildRegName;
    }

    /**
     * @mbggenerated 楼盘行政区名称
     */
    public void setBuildRegName(String buildRegName) {
        this.buildRegName = buildRegName == null ? null : buildRegName.trim();
    }

    /**
     * @mbggenerated 楼盘行政区ID
     */
    public Integer getBuildRegId() {
        return buildRegId;
    }

    /**
     * @mbggenerated 楼盘行政区ID
     */
    public void setBuildRegId(Integer buildRegId) {
        this.buildRegId = buildRegId;
    }

    /**
     * @mbggenerated 流程办结时间
     */
    public Date getProcessEndTime() {
        return processEndTime;
    }

    /**
     * @mbggenerated 流程办结时间
     */
    public void setProcessEndTime(Date processEndTime) {
        this.processEndTime = processEndTime;
    }

    /**
     * @mbggenerated 补充协议审核状态 一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 7：内部审核 8：内审不通过
     */
    public Byte getYouAduitStatusProtocol() {
        return youAduitStatusProtocol;
    }

    /**
     * @mbggenerated 补充协议审核状态 一般由律师进行审核  1:等待一审 2:一审通过 3:一审未通过 7：内部审核 8：内审不通过
     */
    public void setYouAduitStatusProtocol(Byte youAduitStatusProtocol) {
        this.youAduitStatusProtocol = youAduitStatusProtocol;
    }

    /**
     * @mbggenerated 协议ID
     */
    public Integer getProtocolId() {
        return protocolId;
    }

    /**
     * @mbggenerated 协议ID
     */
    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    /**
     * @mbggenerated 过户应收业绩
     */
    public BigDecimal getTransferNeedPerformance() {
        return transferNeedPerformance;
    }

    /**
     * @mbggenerated 过户应收业绩
     */
    public void setTransferNeedPerformance(BigDecimal transferNeedPerformance) {
        this.transferNeedPerformance = transferNeedPerformance;
    }

    /**
     * @mbggenerated 过户实收业绩
     */
    public BigDecimal getTransferRealPerformance() {
        return transferRealPerformance;
    }

    /**
     * @mbggenerated 过户实收业绩
     */
    public void setTransferRealPerformance(BigDecimal transferRealPerformance) {
        this.transferRealPerformance = transferRealPerformance;
    }

    /**
     * @mbggenerated 二手佣金应收业绩
     */
    public BigDecimal getSecondhandNeedPerformance() {
        return secondhandNeedPerformance;
    }

    /**
     * @mbggenerated 二手佣金应收业绩
     */
    public void setSecondhandNeedPerformance(BigDecimal secondhandNeedPerformance) {
        this.secondhandNeedPerformance = secondhandNeedPerformance;
    }

    /**
     * @mbggenerated 二手佣金实收业绩
     */
    public BigDecimal getSecondhandRealPerformance() {
        return secondhandRealPerformance;
    }

    /**
     * @mbggenerated 二手佣金实收业绩
     */
    public void setSecondhandRealPerformance(BigDecimal secondhandRealPerformance) {
        this.secondhandRealPerformance = secondhandRealPerformance;
    }

    /**
     * @mbggenerated 新房佣金应收业绩
     */
    public BigDecimal getNewhouseNeedPerformance() {
        return newhouseNeedPerformance;
    }

    /**
     * @mbggenerated 新房佣金应收业绩
     */
    public void setNewhouseNeedPerformance(BigDecimal newhouseNeedPerformance) {
        this.newhouseNeedPerformance = newhouseNeedPerformance;
    }

    /**
     * @mbggenerated 新房佣金实收业绩
     */
    public BigDecimal getNewhouseRealPerformance() {
        return newhouseRealPerformance;
    }

    /**
     * @mbggenerated 新房佣金实收业绩
     */
    public void setNewhouseRealPerformance(BigDecimal newhouseRealPerformance) {
        this.newhouseRealPerformance = newhouseRealPerformance;
    }

    /**
     * @mbggenerated 租赁应收业绩
     */
    public BigDecimal getLeaseNeedPerformance() {
        return leaseNeedPerformance;
    }

    /**
     * @mbggenerated 租赁应收业绩
     */
    public void setLeaseNeedPerformance(BigDecimal leaseNeedPerformance) {
        this.leaseNeedPerformance = leaseNeedPerformance;
    }

    /**
     * @mbggenerated 租赁实收业绩
     */
    public BigDecimal getLeaseRealPerformance() {
        return leaseRealPerformance;
    }

    /**
     * @mbggenerated 租赁实收业绩
     */
    public void setLeaseRealPerformance(BigDecimal leaseRealPerformance) {
        this.leaseRealPerformance = leaseRealPerformance;
    }

    /**
     * @mbggenerated 金融应收业绩
     */
    public BigDecimal getFinanceNeedPerformance() {
        return financeNeedPerformance;
    }

    /**
     * @mbggenerated 金融应收业绩
     */
    public void setFinanceNeedPerformance(BigDecimal financeNeedPerformance) {
        this.financeNeedPerformance = financeNeedPerformance;
    }

    /**
     * @mbggenerated 金融实收业绩
     */
    public BigDecimal getFinanceRealPerformance() {
        return financeRealPerformance;
    }

    /**
     * @mbggenerated 金融实收业绩
     */
    public void setFinanceRealPerformance(BigDecimal financeRealPerformance) {
        this.financeRealPerformance = financeRealPerformance;
    }

    /**
     * @mbggenerated 佣金利率
     */
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    /**
     * @mbggenerated 佣金利率
     */
    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * @mbggenerated 标准佣金项
     */
    public BigDecimal getStandardCommission() {
        return standardCommission;
    }

    /**
     * @mbggenerated 标准佣金项
     */
    public void setStandardCommission(BigDecimal standardCommission) {
        this.standardCommission = standardCommission;
    }

    /**
     * @mbggenerated 合同号类型 0手动录入1自动分配
     */
    public Byte getCodeType() {
        return codeType;
    }

    /**
     * @mbggenerated 合同号类型 0手动录入1自动分配
     */
    public void setCodeType(Byte codeType) {
        this.codeType = codeType;
    }

    /**
     * @mbggenerated 板块ID
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * @mbggenerated 板块ID
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * @mbggenerated 业主付佣
     */
    public BigDecimal getSellOwnerCommsion() {
        return sellOwnerCommsion;
    }

    /**
     * @mbggenerated 业主付佣
     */
    public void setSellOwnerCommsion(BigDecimal sellOwnerCommsion) {
        this.sellOwnerCommsion = sellOwnerCommsion;
    }

    /**
     * @mbggenerated 客户付佣
     */
    public BigDecimal getBuyCustomerCommsion() {
        return buyCustomerCommsion;
    }

    /**
     * @mbggenerated 客户付佣
     */
    public void setBuyCustomerCommsion(BigDecimal buyCustomerCommsion) {
        this.buyCustomerCommsion = buyCustomerCommsion;
    }

    /**
     * @mbggenerated 规划用途
     */
    public String getPlanningUse() {
        return planningUse;
    }

    /**
     * @mbggenerated 规划用途
     */
    public void setPlanningUse(String planningUse) {
        this.planningUse = planningUse == null ? null : planningUse.trim();
    }

    /**
     * @mbggenerated 国土证 类型1：划拨 2：出让
     */
    public Byte getLandcardType() {
        return landcardType;
    }

    /**
     * @mbggenerated 国土证 类型1：划拨 2：出让
     */
    public void setLandcardType(Byte landcardType) {
        this.landcardType = landcardType;
    }

    /**
     * @mbggenerated 抵押情况 0 无抵押 1：有抵押
     */
    public Byte getMortgageType() {
        return mortgageType;
    }

    /**
     * @mbggenerated 抵押情况 0 无抵押 1：有抵押
     */
    public void setMortgageType(Byte mortgageType) {
        this.mortgageType = mortgageType;
    }

    /**
     * @mbggenerated 租约情况 0不带租约 1带租约
     */
    public Byte getLeaseType() {
        return leaseType;
    }

    /**
     * @mbggenerated 租约情况 0不带租约 1带租约
     */
    public void setLeaseType(Byte leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * @mbggenerated 卖方代理人名字
     */
    public String getSellerProxyName() {
        return sellerProxyName;
    }

    /**
     * @mbggenerated 卖方代理人名字
     */
    public void setSellerProxyName(String sellerProxyName) {
        this.sellerProxyName = sellerProxyName == null ? null : sellerProxyName.trim();
    }

    /**
     * @mbggenerated 卖方代理人身份证
     */
    public String getSellerProxyIdcard() {
        return sellerProxyIdcard;
    }

    /**
     * @mbggenerated 卖方代理人身份证
     */
    public void setSellerProxyIdcard(String sellerProxyIdcard) {
        this.sellerProxyIdcard = sellerProxyIdcard == null ? null : sellerProxyIdcard.trim();
    }

    /**
     * @mbggenerated 卖方代理人电话
     */
    public String getSellerProxyPhone() {
        return sellerProxyPhone;
    }

    /**
     * @mbggenerated 卖方代理人电话
     */
    public void setSellerProxyPhone(String sellerProxyPhone) {
        this.sellerProxyPhone = sellerProxyPhone == null ? null : sellerProxyPhone.trim();
    }

    /**
     * @mbggenerated 卖方代理人电话 带类型
     */
    public String getSellerProxyPhoneencode() {
        return sellerProxyPhoneencode;
    }

    /**
     * @mbggenerated 卖方代理人电话 带类型
     */
    public void setSellerProxyPhoneencode(String sellerProxyPhoneencode) {
        this.sellerProxyPhoneencode = sellerProxyPhoneencode == null ? null : sellerProxyPhoneencode.trim();
    }

    /**
     * @mbggenerated 买方代理人电话
     */
    public String getBuyerProxyName() {
        return buyerProxyName;
    }

    /**
     * @mbggenerated 买方代理人电话
     */
    public void setBuyerProxyName(String buyerProxyName) {
        this.buyerProxyName = buyerProxyName == null ? null : buyerProxyName.trim();
    }

    /**
     * @mbggenerated 买方代理人身份证
     */
    public String getBuyerProxyIdcard() {
        return buyerProxyIdcard;
    }

    /**
     * @mbggenerated 买方代理人身份证
     */
    public void setBuyerProxyIdcard(String buyerProxyIdcard) {
        this.buyerProxyIdcard = buyerProxyIdcard == null ? null : buyerProxyIdcard.trim();
    }

    /**
     * @mbggenerated 买方代理人电话
     */
    public String getBuyerProxyPhone() {
        return buyerProxyPhone;
    }

    /**
     * @mbggenerated 买方代理人电话
     */
    public void setBuyerProxyPhone(String buyerProxyPhone) {
        this.buyerProxyPhone = buyerProxyPhone == null ? null : buyerProxyPhone.trim();
    }

    /**
     * @mbggenerated 买方代理人电话 带类型
     */
    public String getBuyerProxyPhoneencode() {
        return buyerProxyPhoneencode;
    }

    /**
     * @mbggenerated 买方代理人电话 带类型
     */
    public void setBuyerProxyPhoneencode(String buyerProxyPhoneencode) {
        this.buyerProxyPhoneencode = buyerProxyPhoneencode == null ? null : buyerProxyPhoneencode.trim();
    }

    /**
     * @mbggenerated 是否带家电 0不带1：带
     */
    public Byte getHouseHoldElectrical() {
        return houseHoldElectrical;
    }

    /**
     * @mbggenerated 是否带家电 0不带1：带
     */
    public void setHouseHoldElectrical(Byte houseHoldElectrical) {
        this.houseHoldElectrical = houseHoldElectrical;
    }

    /**
     * @mbggenerated 买方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税
     */
    public String getBuyerTaxFee() {
        return buyerTaxFee;
    }

    /**
     * @mbggenerated 买方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税
     */
    public void setBuyerTaxFee(String buyerTaxFee) {
        this.buyerTaxFee = buyerTaxFee == null ? null : buyerTaxFee.trim();
    }

    /**
     * @mbggenerated 卖方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税
     */
    public String getSellerTaxFee() {
        return sellerTaxFee;
    }

    /**
     * @mbggenerated 卖方税费以，分割  1：维修基金 2：土地出让金 3：增值税及附加 4：个人所得税 5：契税 6：转让手续费 7转移登记 8印花税 9 书证费 10 土地增值税
     */
    public void setSellerTaxFee(String sellerTaxFee) {
        this.sellerTaxFee = sellerTaxFee == null ? null : sellerTaxFee.trim();
    }

    /**
     * @mbggenerated 定金支付时间
     */
    public Date getDepositPayTime() {
        return depositPayTime;
    }

    /**
     * @mbggenerated 定金支付时间
     */
    public void setDepositPayTime(Date depositPayTime) {
        this.depositPayTime = depositPayTime;
    }

    /**
     * @mbggenerated 定金支付方式 1：通过银行资金 2：甲方收取
     */
    public Byte getDepositPayType() {
        return depositPayType;
    }

    /**
     * @mbggenerated 定金支付方式 1：通过银行资金 2：甲方收取
     */
    public void setDepositPayType(Byte depositPayType) {
        this.depositPayType = depositPayType;
    }

    /**
     * @mbggenerated 定金其他
     */
    public String getDepositPayOther() {
        return depositPayOther;
    }

    /**
     * @mbggenerated 定金其他
     */
    public void setDepositPayOther(String depositPayOther) {
        this.depositPayOther = depositPayOther == null ? null : depositPayOther.trim();
    }

    /**
     * @mbggenerated 首付款支付方式1是否选择 0未选择 1：选择
     */
    public Byte getDownPaymentsPayType1() {
        return downPaymentsPayType1;
    }

    /**
     * @mbggenerated 首付款支付方式1是否选择 0未选择 1：选择
     */
    public void setDownPaymentsPayType1(Byte downPaymentsPayType1) {
        this.downPaymentsPayType1 = downPaymentsPayType1;
    }

    /**
     * @mbggenerated 首付转款时间
     */
    public String getDownPaymentsPayTime1() {
        return downPaymentsPayTime1;
    }

    /**
     * @mbggenerated 首付转款时间
     */
    public void setDownPaymentsPayTime1(String downPaymentsPayTime1) {
        this.downPaymentsPayTime1 = downPaymentsPayTime1 == null ? null : downPaymentsPayTime1.trim();
    }

    /**
     * @mbggenerated 房价余款支付方式1 是否选择 0未选择 1：选择
     */
    public Byte getHousePriceLastPayType1() {
        return housePriceLastPayType1;
    }

    /**
     * @mbggenerated 房价余款支付方式1 是否选择 0未选择 1：选择
     */
    public void setHousePriceLastPayType1(Byte housePriceLastPayType1) {
        this.housePriceLastPayType1 = housePriceLastPayType1;
    }

    /**
     * @mbggenerated 房价余款转款时间
     */
    public String getHousePriceLastPayTime1() {
        return housePriceLastPayTime1;
    }

    /**
     * @mbggenerated 房价余款转款时间
     */
    public void setHousePriceLastPayTime1(String housePriceLastPayTime1) {
        this.housePriceLastPayTime1 = housePriceLastPayTime1 == null ? null : housePriceLastPayTime1.trim();
    }

    /**
     * @mbggenerated 贷款时长
     */
    public String getLoanTimeLength() {
        return loanTimeLength;
    }

    /**
     * @mbggenerated 贷款时长
     */
    public void setLoanTimeLength(String loanTimeLength) {
        this.loanTimeLength = loanTimeLength == null ? null : loanTimeLength.trim();
    }

    /**
     * @mbggenerated 贷款机构
     */
    public String getLoanAgency() {
        return loanAgency;
    }

    /**
     * @mbggenerated 贷款机构
     */
    public void setLoanAgency(String loanAgency) {
        this.loanAgency = loanAgency == null ? null : loanAgency.trim();
    }

    /**
     * @mbggenerated 未批贷解决方式
     */
    public Byte getNoPassSloutionType() {
        return noPassSloutionType;
    }

    /**
     * @mbggenerated 未批贷解决方式
     */
    public void setNoPassSloutionType(Byte noPassSloutionType) {
        this.noPassSloutionType = noPassSloutionType;
    }

    /**
     * @mbggenerated 注销抵押申请还款工作日
     */
    public Integer getApplicationRepaymentDays() {
        return applicationRepaymentDays;
    }

    /**
     * @mbggenerated 注销抵押申请还款工作日
     */
    public void setApplicationRepaymentDays(Integer applicationRepaymentDays) {
        this.applicationRepaymentDays = applicationRepaymentDays;
    }

    /**
     * @mbggenerated 注销抵押其他内容
     */
    public String getApplicationRepaymentOther() {
        return applicationRepaymentOther;
    }

    /**
     * @mbggenerated 注销抵押其他内容
     */
    public void setApplicationRepaymentOther(String applicationRepaymentOther) {
        this.applicationRepaymentOther = applicationRepaymentOther == null ? null : applicationRepaymentOther.trim();
    }

    /**
     * @mbggenerated 权属号
     */
    public String getOwnershipObligatiionNumber() {
        return ownershipObligatiionNumber;
    }

    /**
     * @mbggenerated 权属号
     */
    public void setOwnershipObligatiionNumber(String ownershipObligatiionNumber) {
        this.ownershipObligatiionNumber = ownershipObligatiionNumber == null ? null : ownershipObligatiionNumber.trim();
    }

    /**
     * @mbggenerated 房屋性质
     */
    public String getHouseProperty() {
        return houseProperty;
    }

    /**
     * @mbggenerated 房屋性质
     */
    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty == null ? null : houseProperty.trim();
    }

    /**
     * @mbggenerated 卖方银行账户类型
     */
    public String getSellerBankType() {
        return sellerBankType;
    }

    /**
     * @mbggenerated 卖方银行账户类型
     */
    public void setSellerBankType(String sellerBankType) {
        this.sellerBankType = sellerBankType == null ? null : sellerBankType.trim();
    }

    /**
     * @mbggenerated 卖方银行账户名字
     */
    public String getSellerBankUserName() {
        return sellerBankUserName;
    }

    /**
     * @mbggenerated 卖方银行账户名字
     */
    public void setSellerBankUserName(String sellerBankUserName) {
        this.sellerBankUserName = sellerBankUserName == null ? null : sellerBankUserName.trim();
    }

    /**
     * @mbggenerated 卖方银行账户账号
     */
    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    /**
     * @mbggenerated 卖方银行账户账号
     */
    public void setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount == null ? null : sellerBankAccount.trim();
    }

    /**
     * @mbggenerated 买方银行账户银行类型
     */
    public String getBuyerBankType() {
        return buyerBankType;
    }

    /**
     * @mbggenerated 买方银行账户银行类型
     */
    public void setBuyerBankType(String buyerBankType) {
        this.buyerBankType = buyerBankType == null ? null : buyerBankType.trim();
    }

    /**
     * @mbggenerated 买方银行账户名字
     */
    public String getBuyerBankUserName() {
        return buyerBankUserName;
    }

    /**
     * @mbggenerated 买方银行账户名字
     */
    public void setBuyerBankUserName(String buyerBankUserName) {
        this.buyerBankUserName = buyerBankUserName == null ? null : buyerBankUserName.trim();
    }

    /**
     * @mbggenerated 买方银行账户账号
     */
    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    /**
     * @mbggenerated 买方银行账户账号
     */
    public void setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount == null ? null : buyerBankAccount.trim();
    }

    /**
     * @mbggenerated 首付-银行资金监管专用账户划转
     */
    public Byte getDownPaymentsPayType2() {
        return downPaymentsPayType2;
    }

    /**
     * @mbggenerated 首付-银行资金监管专用账户划转
     */
    public void setDownPaymentsPayType2(Byte downPaymentsPayType2) {
        this.downPaymentsPayType2 = downPaymentsPayType2;
    }

    /**
     * @mbggenerated 首付款支付方式2的时间或者其他
     */
    public String getDownPaymentsPayTime2() {
        return downPaymentsPayTime2;
    }

    /**
     * @mbggenerated 首付款支付方式2的时间或者其他
     */
    public void setDownPaymentsPayTime2(String downPaymentsPayTime2) {
        this.downPaymentsPayTime2 = downPaymentsPayTime2 == null ? null : downPaymentsPayTime2.trim();
    }

    /**
     * @mbggenerated 首付款支付方式3 是否开启 0：未选择 1：选择
     */
    public Byte getDownPaymentsPayType3() {
        return downPaymentsPayType3;
    }

    /**
     * @mbggenerated 首付款支付方式3 是否开启 0：未选择 1：选择
     */
    public void setDownPaymentsPayType3(Byte downPaymentsPayType3) {
        this.downPaymentsPayType3 = downPaymentsPayType3;
    }

    /**
     * @mbggenerated 首付款支付方式3的时间或者条件
     */
    public String getDownPaymentsPayTime3() {
        return downPaymentsPayTime3;
    }

    /**
     * @mbggenerated 首付款支付方式3的时间或者条件
     */
    public void setDownPaymentsPayTime3(String downPaymentsPayTime3) {
        this.downPaymentsPayTime3 = downPaymentsPayTime3 == null ? null : downPaymentsPayTime3.trim();
    }

    /**
     * @mbggenerated 房间余款支付方式2 是否选择
     */
    public Byte getHousePriceLastPayType2() {
        return housePriceLastPayType2;
    }

    /**
     * @mbggenerated 房间余款支付方式2 是否选择
     */
    public void setHousePriceLastPayType2(Byte housePriceLastPayType2) {
        this.housePriceLastPayType2 = housePriceLastPayType2;
    }

    /**
     * @mbggenerated 房价余款支付方式2的约定时间或者其他
     */
    public String getHousePriceLastPayTime2() {
        return housePriceLastPayTime2;
    }

    /**
     * @mbggenerated 房价余款支付方式2的约定时间或者其他
     */
    public void setHousePriceLastPayTime2(String housePriceLastPayTime2) {
        this.housePriceLastPayTime2 = housePriceLastPayTime2 == null ? null : housePriceLastPayTime2.trim();
    }

    /**
     * @mbggenerated 房价余款支付方式3 是否开启
     */
    public Byte getHousePriceLastPayType3() {
        return housePriceLastPayType3;
    }

    /**
     * @mbggenerated 房价余款支付方式3 是否开启
     */
    public void setHousePriceLastPayType3(Byte housePriceLastPayType3) {
        this.housePriceLastPayType3 = housePriceLastPayType3;
    }

    /**
     * @mbggenerated 房价余款支付方式3的时间
     */
    public String getHousePriceLastPayTime3() {
        return housePriceLastPayTime3;
    }

    /**
     * @mbggenerated 房价余款支付方式3的时间
     */
    public void setHousePriceLastPayTime3(String housePriceLastPayTime3) {
        this.housePriceLastPayTime3 = housePriceLastPayTime3 == null ? null : housePriceLastPayTime3.trim();
    }

    /**
     * @mbggenerated 过户时间或者其他
     */
    public String getTransferDateStr() {
        return transferDateStr;
    }

    /**
     * @mbggenerated 过户时间或者其他
     */
    public void setTransferDateStr(String transferDateStr) {
        this.transferDateStr = transferDateStr == null ? null : transferDateStr.trim();
    }

    /**
     * @mbggenerated 取件工作日
     */
    public Integer getTransferDateDaysPickup() {
        return transferDateDaysPickup;
    }

    /**
     * @mbggenerated 取件工作日
     */
    public void setTransferDateDaysPickup(Integer transferDateDaysPickup) {
        this.transferDateDaysPickup = transferDateDaysPickup;
    }

    /**
     * @mbggenerated 办理抵押登记工作日
     */
    public Integer getTransferDateDaysRegist() {
        return transferDateDaysRegist;
    }

    /**
     * @mbggenerated 办理抵押登记工作日
     */
    public void setTransferDateDaysRegist(Integer transferDateDaysRegist) {
        this.transferDateDaysRegist = transferDateDaysRegist;
    }

    /**
     * @mbggenerated 是否漏水
     */
    public Byte getWaterLeakage() {
        return waterLeakage;
    }

    /**
     * @mbggenerated 是否漏水
     */
    public void setWaterLeakage(Byte waterLeakage) {
        this.waterLeakage = waterLeakage;
    }

    /**
     * @mbggenerated 漏水位置
     */
    public String getWaterLeakagePosition() {
        return waterLeakagePosition;
    }

    /**
     * @mbggenerated 漏水位置
     */
    public void setWaterLeakagePosition(String waterLeakagePosition) {
        this.waterLeakagePosition = waterLeakagePosition == null ? null : waterLeakagePosition.trim();
    }

    /**
     * @mbggenerated 漏水协商
     */
    public Byte getWaterLeakageConsult() {
        return waterLeakageConsult;
    }

    /**
     * @mbggenerated 漏水协商
     */
    public void setWaterLeakageConsult(Byte waterLeakageConsult) {
        this.waterLeakageConsult = waterLeakageConsult;
    }

    /**
     * @mbggenerated 漏水协商责任承担方
     */
    public Byte getWaterLeakageConsultBearParty() {
        return waterLeakageConsultBearParty;
    }

    /**
     * @mbggenerated 漏水协商责任承担方
     */
    public void setWaterLeakageConsultBearParty(Byte waterLeakageConsultBearParty) {
        this.waterLeakageConsultBearParty = waterLeakageConsultBearParty;
    }

    /**
     * @mbggenerated 死亡事件责任承担方
     */
    public String getDeathEvent() {
        return deathEvent;
    }

    /**
     * @mbggenerated 死亡事件责任承担方
     */
    public void setDeathEvent(String deathEvent) {
        this.deathEvent = deathEvent == null ? null : deathEvent.trim();
    }

    /**
     * @mbggenerated 是否蜕皮
     */
    public Byte getHousePeeling() {
        return housePeeling;
    }

    /**
     * @mbggenerated 是否蜕皮
     */
    public void setHousePeeling(Byte housePeeling) {
        this.housePeeling = housePeeling;
    }

    /**
     * @mbggenerated 脱皮位置
     */
    public String getHousePeelingPosition() {
        return housePeelingPosition;
    }

    /**
     * @mbggenerated 脱皮位置
     */
    public void setHousePeelingPosition(String housePeelingPosition) {
        this.housePeelingPosition = housePeelingPosition == null ? null : housePeelingPosition.trim();
    }

    /**
     * @mbggenerated 提交贷款资料及费用
     */
    public String getSubmitLoanInfoFeeDays() {
        return submitLoanInfoFeeDays;
    }

    /**
     * @mbggenerated 提交贷款资料及费用
     */
    public void setSubmitLoanInfoFeeDays(String submitLoanInfoFeeDays) {
        this.submitLoanInfoFeeDays = submitLoanInfoFeeDays == null ? null : submitLoanInfoFeeDays.trim();
    }

    /**
     * @mbggenerated 首付款支付方 买方出贷
     */
    public Byte getDownPaymentsPayParty1() {
        return downPaymentsPayParty1;
    }

    /**
     * @mbggenerated 首付款支付方 买方出贷
     */
    public void setDownPaymentsPayParty1(Byte downPaymentsPayParty1) {
        this.downPaymentsPayParty1 = downPaymentsPayParty1;
    }

    /**
     * @mbggenerated 首付款- 第三方出资
     */
    public Byte getDownPaymentsPayParty2() {
        return downPaymentsPayParty2;
    }

    /**
     * @mbggenerated 首付款- 第三方出资
     */
    public void setDownPaymentsPayParty2(Byte downPaymentsPayParty2) {
        this.downPaymentsPayParty2 = downPaymentsPayParty2;
    }

    /**
     * @mbggenerated 首付款- 甲乙双方自行出资
     */
    public Byte getDownPaymentsPayParty3() {
        return downPaymentsPayParty3;
    }

    /**
     * @mbggenerated 首付款- 甲乙双方自行出资
     */
    public void setDownPaymentsPayParty3(Byte downPaymentsPayParty3) {
        this.downPaymentsPayParty3 = downPaymentsPayParty3;
    }

    /**
     * @mbggenerated 买方出资银行
     */
    public String getDownPaymentsPayBank() {
        return downPaymentsPayBank;
    }

    /**
     * @mbggenerated 买方出资银行
     */
    public void setDownPaymentsPayBank(String downPaymentsPayBank) {
        this.downPaymentsPayBank = downPaymentsPayBank == null ? null : downPaymentsPayBank.trim();
    }

    /**
     * @mbggenerated 买方出资账户户名
     */
    public String getDownPaymentsPayAccountName() {
        return downPaymentsPayAccountName;
    }

    /**
     * @mbggenerated 买方出资账户户名
     */
    public void setDownPaymentsPayAccountName(String downPaymentsPayAccountName) {
        this.downPaymentsPayAccountName = downPaymentsPayAccountName == null ? null : downPaymentsPayAccountName.trim();
    }

    /**
     * @mbggenerated 买方出资账户
     */
    public String getDownPaymentsPayAccountNo() {
        return downPaymentsPayAccountNo;
    }

    /**
     * @mbggenerated 买方出资账户
     */
    public void setDownPaymentsPayAccountNo(String downPaymentsPayAccountNo) {
        this.downPaymentsPayAccountNo = downPaymentsPayAccountNo == null ? null : downPaymentsPayAccountNo.trim();
    }

    /**
     * @mbggenerated 第三方出资 支付方
     */
    public String getDownPaymentsThirdParty() {
        return downPaymentsThirdParty;
    }

    /**
     * @mbggenerated 第三方出资 支付方
     */
    public void setDownPaymentsThirdParty(String downPaymentsThirdParty) {
        this.downPaymentsThirdParty = downPaymentsThirdParty == null ? null : downPaymentsThirdParty.trim();
    }

    /**
     * @mbggenerated 余下首期放款 支付时间
     */
    public String getDownPaymentsRemainingFirstPaytime() {
        return downPaymentsRemainingFirstPaytime;
    }

    /**
     * @mbggenerated 余下首期放款 支付时间
     */
    public void setDownPaymentsRemainingFirstPaytime(String downPaymentsRemainingFirstPaytime) {
        this.downPaymentsRemainingFirstPaytime = downPaymentsRemainingFirstPaytime == null ? null
                : downPaymentsRemainingFirstPaytime.trim();
    }

    /**
     * @mbggenerated 脱皮责任承担方
     */
    public Byte getHousePeelingBearParty() {
        return housePeelingBearParty;
    }

    /**
     * @mbggenerated 脱皮责任承担方
     */
    public void setHousePeelingBearParty(Byte housePeelingBearParty) {
        this.housePeelingBearParty = housePeelingBearParty;
    }

    /**
     * @mbggenerated 余下首期放款
     */
    public String getDownPaymentsRemainingFirstAmount() {
        return downPaymentsRemainingFirstAmount;
    }

    /**
     * @mbggenerated 余下首期放款
     */
    public void setDownPaymentsRemainingFirstAmount(String downPaymentsRemainingFirstAmount) {
        this.downPaymentsRemainingFirstAmount = downPaymentsRemainingFirstAmount == null ? null
                : downPaymentsRemainingFirstAmount.trim();
    }

    /**
     * @mbggenerated 房价余款支付方式3 金额
     */
    public String getHousePriceLastPayAmount3() {
        return housePriceLastPayAmount3;
    }

    /**
     * @mbggenerated 房价余款支付方式3 金额
     */
    public void setHousePriceLastPayAmount3(String housePriceLastPayAmount3) {
        this.housePriceLastPayAmount3 = housePriceLastPayAmount3 == null ? null : housePriceLastPayAmount3.trim();
    }

    /**
     * @mbggenerated 房价余款支付方式2 金额
     */
    public String getHousePriceLastPayAmount2() {
        return housePriceLastPayAmount2;
    }

    /**
     * @mbggenerated 房价余款支付方式2 金额
     */
    public void setHousePriceLastPayAmount2(String housePriceLastPayAmount2) {
        this.housePriceLastPayAmount2 = housePriceLastPayAmount2 == null ? null : housePriceLastPayAmount2.trim();
    }

    /**
     * @mbggenerated 首付支付方式3 金额
     */
    public String getDownPaymentsPayAmount3() {
        return downPaymentsPayAmount3;
    }

    /**
     * @mbggenerated 首付支付方式3 金额
     */
    public void setDownPaymentsPayAmount3(String downPaymentsPayAmount3) {
        this.downPaymentsPayAmount3 = downPaymentsPayAmount3 == null ? null : downPaymentsPayAmount3.trim();
    }

    /**
     * @mbggenerated 首付支付方式2 金额
     */
    public String getDownPaymentsPayAmount2() {
        return downPaymentsPayAmount2;
    }

    /**
     * @mbggenerated 首付支付方式2 金额
     */
    public void setDownPaymentsPayAmount2(String downPaymentsPayAmount2) {
        this.downPaymentsPayAmount2 = downPaymentsPayAmount2 == null ? null : downPaymentsPayAmount2.trim();
    }

    /**
     * @mbggenerated 未批贷解决方式 金额
     */
    public String getNoPassSloutionAmount() {
        return noPassSloutionAmount;
    }

    /**
     * @mbggenerated 未批贷解决方式 金额
     */
    public void setNoPassSloutionAmount(String noPassSloutionAmount) {
        this.noPassSloutionAmount = noPassSloutionAmount == null ? null : noPassSloutionAmount.trim();
    }

    /**
     * @mbggenerated 房价余款 支付方式1 金额
     */
    public String getHousePriceLastPayAmount1() {
        return housePriceLastPayAmount1;
    }

    /**
     * @mbggenerated 房价余款 支付方式1 金额
     */
    public void setHousePriceLastPayAmount1(String housePriceLastPayAmount1) {
        this.housePriceLastPayAmount1 = housePriceLastPayAmount1 == null ? null : housePriceLastPayAmount1.trim();
    }

    /**
     * @mbggenerated 首付支付方式1 金额
     */
    public String getDownPaymentsPayAmount1() {
        return downPaymentsPayAmount1;
    }

    /**
     * @mbggenerated 首付支付方式1 金额
     */
    public void setDownPaymentsPayAmount1(String downPaymentsPayAmount1) {
        this.downPaymentsPayAmount1 = downPaymentsPayAmount1 == null ? null : downPaymentsPayAmount1.trim();
    }

    /**
     * @mbggenerated 房价余款 金额
     */
    public String getHousePriceLastAmount() {
        return housePriceLastAmount;
    }

    /**
     * @mbggenerated 房价余款 金额
     */
    public void setHousePriceLastAmount(String housePriceLastAmount) {
        this.housePriceLastAmount = housePriceLastAmount == null ? null : housePriceLastAmount.trim();
    }

    /**
     * @mbggenerated 首付款金额
     */
    public String getDownPaymentsAmount() {
        return downPaymentsAmount;
    }

    /**
     * @mbggenerated 首付款金额
     */
    public void setDownPaymentsAmount(String downPaymentsAmount) {
        this.downPaymentsAmount = downPaymentsAmount == null ? null : downPaymentsAmount.trim();
    }

    /**
     * @mbggenerated 定金
     */
    public String getDepositAmount() {
        return depositAmount;
    }

    /**
     * @mbggenerated 定金
     */
    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount == null ? null : depositAmount.trim();
    }

    /**
     * @mbggenerated 抵押情况
     */
    public String getMortgageAmount() {
        return mortgageAmount;
    }

    /**
     * @mbggenerated 抵押情况
     */
    public void setMortgageAmount(String mortgageAmount) {
        this.mortgageAmount = mortgageAmount == null ? null : mortgageAmount.trim();
    }

    /**
     * @mbggenerated -
     */
    public Integer getSignUserArchive() {
        return signUserArchive;
    }

    /**
     * @mbggenerated -
     */
    public void setSignUserArchive(Integer signUserArchive) {
        this.signUserArchive = signUserArchive;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方证件类型)
     */
    public Integer getBuyIdCardType() {
        return buyIdCardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方证件类型)
     */
    public void setBuyIdCardType(Integer buyIdCardType) {
        this.buyIdCardType = buyIdCardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方证件类型)
     */
    public Integer getSellIdCardType() {
        return sellIdCardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方证件类型)
     */
    public void setSellIdCardType(Integer sellIdCardType) {
        this.sellIdCardType = sellIdCardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方共有人证件类型)
     */
    public Integer getSellIdCardBakType() {
        return sellIdCardBakType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方共有人证件类型)
     */
    public void setSellIdCardBakType(Integer sellIdCardBakType) {
        this.sellIdCardBakType = sellIdCardBakType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方共有人证件类型)
     */
    public Integer getBuyIdCardBakType() {
        return buyIdCardBakType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方共有人证件类型)
     */
    public void setBuyIdCardBakType(Integer buyIdCardBakType) {
        this.buyIdCardBakType = buyIdCardBakType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方代理人证件类型)
     */
    public Integer getSellerProxyIdcardType() {
        return sellerProxyIdcardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(卖方代理人证件类型)
     */
    public void setSellerProxyIdcardType(Integer sellerProxyIdcardType) {
        this.sellerProxyIdcardType = sellerProxyIdcardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方代理人证件类型)
     */
    public Integer getBuyerProxyIdcardType() {
        return buyerProxyIdcardType;
    }

    /**
     * @mbggenerated 1=身份证、2=护照、3=军官证、4=士兵证、5=回乡证、6=台胞证(买方代理人证件类型)
     */
    public void setBuyerProxyIdcardType(Integer buyerProxyIdcardType) {
        this.buyerProxyIdcardType = buyerProxyIdcardType;
    }

    public String getCommercialLoanDate() {
        return commercialLoanDate;
    }

    public void setCommercialLoanDate(String commercialLoanDate) {
        this.commercialLoanDate = commercialLoanDate;
    }

    public String getCommercialLenderDate() {
        return commercialLenderDate;
    }

    public void setCommercialLenderDate(String commercialLenderDate) {
        this.commercialLenderDate = commercialLenderDate;
    }

    public String getEntrustBank() {
        return entrustBank;
    }

    public void setEntrustBank(String entrustBank) {
        this.entrustBank = entrustBank;
    }

    public BigDecimal getEntrustMoney() {
        return entrustMoney;
    }

    public void setEntrustMoney(BigDecimal entrustMoney) {
        this.entrustMoney = entrustMoney;
    }
}