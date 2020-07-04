package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminJrFinanceInfo implements Serializable {

	/**
	 * @mbggenerated 主键自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 楼盘名称
	 */
	private String buildName;
	/**
	 * @mbggenerated 楼盘ID
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 产权地址
	 */
	private String rightAddr;
	/**
	 * @mbggenerated 产权号（权证编号）
	 */
	private String rightNum;
	/**
	 * @mbggenerated 建筑面积
	 */
	private BigDecimal area;
	/**
	 * @mbggenerated 房屋用途：0-住宅，1-商铺，2-别墅，3-公寓，4-写字楼
	 */
	private Byte useage;
	/**
	 * @mbggenerated 看房电话
	 */
	private String housePhone;
	/**
	 * @mbggenerated 房产信息描述
	 */
	private String houseDesc;
	/**
	 * @mbggenerated 姓名主贷人
	 */
	private String mainApplyName;
	/**
	 * @mbggenerated 主贷人身份证
	 */
	private String mainApplyIdcard;
	/**
	 * @mbggenerated 主贷人电话
	 */
	private String mainApplyPhone;
	/**
	 * @mbggenerated 婚姻状况 0-未婚，1-已婚 ，2-离异
	 */
	private Byte mainMarryStatus;
	/**
	 * @mbggenerated 主贷人房屋情况 1-首套 2-二套 。。。
	 */
	private Byte mainOwnerHouse;
	/**
	 * @mbggenerated 主贷人征信情况 0-不良 1-良好
	 */
	private Byte mainCreditStatus;
	/**
	 * @mbggenerated 主贷人工作单位1=国企；2=私企；3=个体；4=自由职业
	 */
	private String mainWorkUnit;
	/**
	 * @mbggenerated 共有人姓名
	 */
	private String secondApplyName;
	/**
	 * @mbggenerated 共有人身份证
	 */
	private String secondApplyIdcard;
	/**
	 * @mbggenerated 共有人电话
	 */
	private String secondApplyPhone;
	/**
	 * @mbggenerated 买方担保人姓名
	 */
	private String underwriterName;
	/**
	 * @mbggenerated 买方担保人电话
	 */
	private String underwriterPhone;
	/**
	 * @mbggenerated 贷款方式 1-商业；2-公积金；3-组合贷款
	 */
	private Byte financeMethod;
	/**
	 * @mbggenerated 银行流水 0-无；1-有
	 */
	private Byte bankRecord;
	/**
	 * @mbggenerated 贷款人描述
	 */
	private String financeInfoDesc;
	/**
	 * @mbggenerated 合同签约时间
	 */
	private Date contractSignTime;
	/**
	 * @mbggenerated 成交金额
	 */
	private BigDecimal dealPrice;
	/**
	 * @mbggenerated 贷款金额
	 */
	private BigDecimal applyPrice;
	/**
	 * @mbggenerated 贷款年限
	 */
	private Byte financeYear;
	/**
	 * @mbggenerated 贷款利率
	 */
	private String financeRate;
	/**
	 * @mbggenerated 是否资金监管 0-否；1-是
	 */
	private Byte fundSupervisionFlag;
	/**
	 * @mbggenerated 是否承诺服务0-否；1-是
	 */
	private Byte trustServiceFlag;
	/**
	 * @mbggenerated 双签银行 0-否；1-是
	 */
	private Byte doubleBankFlag;
	/**
	 * @mbggenerated 银行1
	 */
	private Integer mainBankId;
	/**
	 * @mbggenerated 银行2（双签银行为1时显示）
	 */
	private Integer secondBankId;
	/**
	 * @mbggenerated 报评时间
	 */
	private Date previewsTime;
	/**
	 * @mbggenerated 贷款方案描述
	 */
	private String financeMethodDesc;
	/**
	 * @mbggenerated 是否收费 0-否；1-是
	 */
	private Byte chargeFlag;
	/**
	 * @mbggenerated 收费方式 DD 0-现金，1-刷卡，2-转账，3-微信支付，4-支付宝支付 
	 */
	private String chargeMethod;
	/**
	 * @mbggenerated 基础费用
	 */
	private BigDecimal baseCharge;
	/**
	 * @mbggenerated 我司收费
	 */
	private BigDecimal hftCharge;
	/**
	 * @mbggenerated 代收费
	 */
	private BigDecimal proxyCharge;
	/**
	 * @mbggenerated 其他费用
	 */
	private BigDecimal otherCharge;
	/**
	 * @mbggenerated 费用描述
	 */
	private String chargeDesc;
	/**
	 * @mbggenerated 业务员
	 */
	private Integer businessUserId;
	/**
	 * @mbggenerated 签单人员  
	 */
	private Integer dealUserId;
	/**
	 * @mbggenerated 评估员
	 */
	private Integer assessmentUserId;
	/**
	 * @mbggenerated 公司编号
	 */
	private String compNo;
	/**
	 * @mbggenerated 门店编号
	 */
	private String deptNo;
	/**
	 * @mbggenerated ERP公司ID
	 */
	private Integer erpCompId;
	/**
	 * @mbggenerated ERP门店ID
	 */
	private Integer erpDeptId;
	/**
	 * @mbggenerated 经纪人门店名称
	 */
	private String brokerDeptName;
	/**
	 * @mbggenerated 经纪人行政区域
	 */
	private String brokerRegName;
	/**
	 * @mbggenerated 经纪人行政区域ID
	 */
	private Integer brokerRegId;
	/**
	 * @mbggenerated 经纪人档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 经纪人姓名
	 */
	private String brokerUserName;
	/**
	 * @mbggenerated 经纪人电话
	 */
	private String brokerUserMobile;
	/**
	 * @mbggenerated 贷款编号  生成方式 贷款类型首字母+年月日十分秒
	 */
	private String financeNo;
	/**
	 * @mbggenerated CRM审核状态 1:一审 2：二审
	 */
	private Byte crmAudit;
	/**
	 * @mbggenerated ERP审核标记 0 未审核 1 已审核 (CRM登记默认为1)
	 */
	private Byte erpAudit;
	/**
	 * @mbggenerated 贷款状态 DD：LOAN_STATUS(CRM登记默认为代办)
	 */
	private Integer financeStatus;
	/**
	 * @mbggenerated 客户类型 0-加盟店；1-非加盟店；2-直客
	 */
	private Byte custType;
	/**
	 * @mbggenerated 门店来源 0-CRM，1-ERP，2-公众号
	 */
	private Byte source;
	/**
	 * @mbggenerated 创建人
	 */
	private Integer createUserId;
	/**
	 * @mbggenerated 创建人姓名
	 */
	private String createUserName;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 装修情况：1-清水，2-简装，3-精装，6-豪装
	 */
	private Byte fitmentStatus;
	/**
	 * @mbggenerated 房屋年代
	 */
	private String houseYears;
	/**
	 * @mbggenerated 评估总价
	 */
	private BigDecimal assessAmount;
	/**
	 * @mbggenerated 出评时间
	 */
	private Date assessedDate;
	/**
	 * @mbggenerated 是否调价：0-不调，1-加调，2-高评，3-低评
	 */
	private Byte ifAdjust;
	/**
	 * @mbggenerated 调后评估价
	 */
	private BigDecimal adjustedPrice;
	/**
	 * @mbggenerated 调价收费
	 */
	private Integer adjustCharge;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 是否办理网签：0-不办理，1-办理
	 */
	private Byte ifNetSign;
	/**
	 * @mbggenerated 是否签订并提交抵押合同：0-否，1-是
	 */
	private Byte ifSubmitPledge;
	/**
	 * @mbggenerated 办理抵押时间
	 */
	private Date pledgeDate;
	/**
	 * @mbggenerated 首付
	 */
	private BigDecimal downPayment;
	/**
	 * @mbggenerated 还款方式 0-本金；1-本息
	 */
	private Byte repaymentType;
	/**
	 * @mbggenerated 月供
	 */
	private Integer monthlyPayment;
	/**
	 * @mbggenerated 是否提交正评报告：0-否，1-是
	 */
	private Byte ifSubmitZpreport;
	/**
	 * @mbggenerated 是否已放款：0-否，1-是
	 */
	private Byte ifLended;
	/**
	 * @mbggenerated 过户抵押信息
	 */
	private String pledgeRemark;
	/**
	 * @mbggenerated 门店大区ID
	 */
	private Integer erpAreaId;
	/**
	 * @mbggenerated 门店片区ID
	 */
	private Integer erpRegId;
	/**
	 * @mbggenerated 实际贷款金额
	 */
	private BigDecimal realLoanPrice;
	/**
	 * @mbggenerated 件别：0-正常件，1-网申件
	 */
	private Byte houseSource;
	/**
	 * @mbggenerated 评估公司1
	 */
	private Integer mainAssessment;
	/**
	 * @mbggenerated 评估公司2
	 */
	private Integer secondAssessment;
	/**
	 * @mbggenerated 数据来源(从哪端登记过来的)：0-CRM，1-ERP，2-公众号----弃用
	 */
	private Byte dataResource;
	/**
	 * @mbggenerated 创建者类型：0-优加员工，1-经纪人，2-系统自动生成
	 */
	private Byte creatorType;
	/**
	 * @mbggenerated 收入证明 0-无;1-有
	 */
	private Byte incomeProof;
	/**
	 * @mbggenerated ERP分组ID
	 */
	private Integer erpGrId;
	/**
	 * @mbggenerated 银行1名称
	 */
	private String mainBankName;
	/**
	 * @mbggenerated 银行2名称
	 */
	private String secondBankName;
	/**
	 * @mbggenerated 评估公司1名称
	 */
	private String mainAssessName;
	/**
	 * @mbggenerated 评估公司2名称
	 */
	private String secondAssessName;
	/**
	 * @mbggenerated 放款描述
	 */
	private String tranceferPledgeDesc;
	/**
	 * @mbggenerated 是否地址变更0-否，1-是
	 */
	private Byte ifAddressChange;
	/**
	 * @mbggenerated 评估单价
	 */
	private BigDecimal assessUnitPrice;
	/**
	 * @mbggenerated 卖方是否赎楼，0-否，1-是
	 */
	private Byte ifRedeemHouse;
	/**
	 * @mbggenerated 送审时间
	 */
	private Date sentApprovalTime;
	/**
	 * @mbggenerated 注意事项（银行）
	 */
	private String bankAttentionMatters;
	/**
	 * @mbggenerated 过户人员
	 */
	private Integer transferEmployee;
	/**
	 * @mbggenerated 抵押人员
	 */
	private Integer pledgeEmployee;
	/**
	 * @mbggenerated 是否关联0-否，1-是
	 */
	private Byte ifRelevance;
	/**
	 * @mbggenerated 关联时间
	 */
	private Date relevanceTime;
	/**
	 * @mbggenerated 办理过户时间
	 */
	private Date transactionTransferTime;
	/**
	 * @mbggenerated 卖方有无委托
	 */
	private Byte ifVendorEntrust;
	/**
	 * @mbggenerated 买方有无委托
	 */
	private Byte ifVendeeEntrust;
	/**
	 * @mbggenerated 接收人
	 */
	private Integer reveicer;
	/**
	 * @mbggenerated 正评时间
	 */
	private Date zhengpingTime;
	/**
	 * @mbggenerated 过户税价
	 */
	private String transferTaxPrice;
	/**
	 * @mbggenerated 证件类型0-身份证，1-军官证，2-其他证件
	 */
	private Byte papersType;
	/**
	 * @mbggenerated 是否移交资料0-否，1-是
	 */
	private Byte ifHandOverInformation;
	/**
	 * @mbggenerated 是否收取产权证原件0-否，1-是
	 */
	private Byte ifGatherOriginalChanquan;
	/**
	 * @mbggenerated 是否收取国土证原件0-否，1-是
	 */
	private Byte ifGatherOriginalGuotu;
	/**
	 * @mbggenerated 是否发布房源0-否，1-是
	 */
	private Byte ifPublishHouse;
	/**
	 * @mbggenerated 网签办理人
	 */
	private Integer netSignTransactor;
	/**
	 * @mbggenerated 拥有方式0-共同所有，1-按份共有，2-单独所有
	 */
	private Byte ownshipType;
	/**
	 * @mbggenerated 注意事项（过户）
	 */
	private String transferAttentionMatters;
	/**
	 * @mbggenerated 垫资方式0-赎楼，1-提放
	 */
	private Byte payForAnotherType;
	/**
	 * @mbggenerated 还款年限
	 */
	private Integer havePaidYears;
	/**
	 * @mbggenerated 抵押情况0-一抵，1-二抵
	 */
	private Byte pledgeCondition;
	/**
	 * @mbggenerated 还款机构1
	 */
	private String firstPayOrganization;
	/**
	 * @mbggenerated 垫资金额1
	 */
	private BigDecimal firstAnotherPayPrice;
	/**
	 * @mbggenerated 预计办理时间1
	 */
	private Date firstTransactionTimePredict;
	/**
	 * @mbggenerated 实际办理时间1
	 */
	private Date firstTransactionTimeReal;
	/**
	 * @mbggenerated 预计还款时间1
	 */
	private Date firstPayTimePredict;
	/**
	 * @mbggenerated 实际还款时间1
	 */
	private Date firstPayTimeReal;
	/**
	 * @mbggenerated 还款机构2
	 */
	private String secondPayOrganization;
	/**
	 * @mbggenerated 垫资金额2
	 */
	private BigDecimal secondAnotherPayPrice;
	/**
	 * @mbggenerated 预计办理时间2
	 */
	private Date secondTransactionTimePredict;
	/**
	 * @mbggenerated 实际办理时间2
	 */
	private Date secondTransactionTimeReal;
	/**
	 * @mbggenerated 预计还款时间2
	 */
	private Date secondPayTimePredict;
	/**
	 * @mbggenerated 实际还款时间2
	 */
	private Date secondPayTimeReal;
	/**
	 * @mbggenerated 预计顺位时间
	 */
	private Date sequencePositonTimePredict;
	/**
	 * @mbggenerated 实际顺位时间
	 */
	private Date sequencePositonTimeReal;
	/**
	 * @mbggenerated 预计注销时间
	 */
	private Date signoutTimePredict;
	/**
	 * @mbggenerated 实际注销时间
	 */
	private Date signoutTimeReal;
	/**
	 * @mbggenerated 预计垫付时间
	 */
	private Date anotherPayTimePredict;
	/**
	 * @mbggenerated 实际垫付时间
	 */
	private Date anotherPayTimeReal;
	/**
	 * @mbggenerated 垫付尾款
	 */
	private BigDecimal anotherPayBalance;
	/**
	 * @mbggenerated 监管支取条件
	 */
	private String superviseDrawRestrict;
	/**
	 * @mbggenerated 是否取他权
	 */
	private Byte ifQutaRight;
	/**
	 * @mbggenerated 是否移交银行
	 */
	private Byte ifHandOverBank;
	/**
	 * @mbggenerated 移交人
	 */
	private Integer handOverEmployee;
	/**
	 * @mbggenerated 放款时间
	 */
	private Date loanTime;
	/**
	 * @mbggenerated 卖方姓名
	 */
	private String vendorName;
	/**
	 * @mbggenerated 卖方身份证号码
	 */
	private String vendorIdNumber;
	/**
	 * @mbggenerated 卖方电话号码
	 */
	private String vendorPhone;
	/**
	 * @mbggenerated 卖方共有人姓名
	 */
	private String vendorCommonOwnerName;
	/**
	 * @mbggenerated 卖方共有人身份证号码
	 */
	private String vendorCommonOwnerIdNumber;
	/**
	 * @mbggenerated 卖方共有人电话号码
	 */
	private String vendorCommonOwnerPhone;
	/**
	 * @mbggenerated 卖方担保人姓名
	 */
	private String vendorSuretyName;
	/**
	 * @mbggenerated 卖方担保人身份证号码
	 */
	private String vendorSuretyIdNumber;
	/**
	 * @mbggenerated 卖方担保人电话号码
	 */
	private String vendorSuretyPhone;
	/**
	 * @mbggenerated 审批通过时间
	 */
	private Date approvalPassTime;
	/**
	 * @mbggenerated 卖方情况描述
	 */
	private String vendorConditionDescription;
	/**
	 * @mbggenerated 买方情况描述
	 */
	private String vendeeConditionDescription;
	/**
	 * @mbggenerated 买方担保人身份证号码
	 */
	private String vendeeSuretyIdcard;
	/**
	 * @mbggenerated 提放预计办理时间
	 */
	private Date tfTransactionTimePredict;
	/**
	 * @mbggenerated 提放实际办理时间
	 */
	private Date tfTransactionTimeReal;
	/**
	 * @mbggenerated 从哪一端注销的：0-CRM,1-ERP,2-公众号
	 */
	private Byte signOutClient;
	/**
	 * @mbggenerated
	 */
	private Byte delStatus;
	/**
	 * @mbggenerated 贷款类型 1=按揭，2=过户，3=结按，4=赎楼，5=车位过户
	 */
	private Byte financeModel;
	/**
	 * @mbggenerated 首付款
	 */
	private BigDecimal downPaymentPrice;
	/**
	 * @mbggenerated 定金	
	 */
	private BigDecimal depositPrice;
	/**
	 * @mbggenerated 资金监管金额
	 */
	private BigDecimal fundSupervisionPrice;
	/**
	 * @mbggenerated 风险等级
	 */
	private String riskLevel;
	/**
	 * @mbggenerated 回款来源
	 */
	private String paymentSource;
	/**
	 * @mbggenerated 受委托人姓名
	 */
	private String entrustedName;
	/**
	 * @mbggenerated 受委托人身份证
	 */
	private String entrustedIccard;
	/**
	 * @mbggenerated 还款银行
	 */
	private String repaymentBankName;
	/**
	 * @mbggenerated 已还年限
	 */
	private Integer hasPaidYears;
	/**
	 * @mbggenerated 是否预约 1=有；0-无
	 */
	private Boolean isAppointment;
	/**
	 * @mbggenerated 随时还款 1=是；0-否
	 */
	private Boolean isRepaymentAnytime;
	/**
	 * @mbggenerated 接受渠道安排还款时间 1=接受；0-不接受
	 */
	private Boolean acceptChannelRepaymentTime;
	/**
	 * @mbggenerated 是否过户车位 1=是；0-否 （废弃）
	 */
	private Boolean ifTransferParking;
	/**
	 * @mbggenerated 是否换证 1=是；0-否
	 */
	private Boolean ifReplaceCredentials;
	/**
	 * @mbggenerated 结按还款金额
	 */
	private Integer repaymentPrice;
	/**
	 * @mbggenerated 结按还款时间
	 */
	private Date repaymentTime;
	/**
	 * @mbggenerated 结按还款渠道
	 */
	private String repaymentChannel;
	/**
	 * @mbggenerated 结按注意事项
	 */
	private String repaymentDesc;
	/**
	 * @mbggenerated 赎楼源ID
	 */
	private Integer copySourceId;
	/**
	 * @mbggenerated 取件时间
	 */
	private Date deliveryTime;
	/**
	 * @mbggenerated 递件时间
	 */
	private Date redeliveryTime;
	/**
	 * @mbggenerated 收款编号
	 */
	private String receivablesNo;
	/**
	 * @mbggenerated 是否双签门店0-否，1-是
	 */
	private Boolean doubleDeptFlag;
	/**
	 * @mbggenerated 第二门店客户类型 0-加盟店；1-非加盟店；2-直客
	 */
	private Byte secondDeptCustType;
	/**
	 * @mbggenerated 第二门店城市ID
	 */
	private Integer secondDeptCityId;
	/**
	 * @mbggenerated 第二门店区域ID
	 */
	private Integer secondDeptRegId;
	/**
	 * @mbggenerated 第二门店公司编号
	 */
	private String secondCompNo;
	/**
	 * @mbggenerated 第二门店门店编号
	 */
	private String secondDeptNo;
	/**
	 * @mbggenerated 第二门店ERP公司ID
	 */
	private Integer secondErpCompId;
	/**
	 * @mbggenerated 第二门店ERP门店ID
	 */
	private Integer secondErpDeptId;
	/**
	 * @mbggenerated 第二门店经纪人门店名称
	 */
	private String secondBrokerDeptName;
	/**
	 * @mbggenerated 第二门店经纪人行政区域
	 */
	private String secondBrokerRegName;
	/**
	 * @mbggenerated 第二门店经纪人行政区域ID
	 */
	private Integer secondBrokerRegId;
	/**
	 * @mbggenerated 第二门店经纪人档案ID
	 */
	private Integer secondArchiveId;
	/**
	 * @mbggenerated 第二门店经纪人姓名
	 */
	private String secondBrokerUserName;
	/**
	 * @mbggenerated 第二门店经纪人电话
	 */
	private String secondBrokerUserMobile;
	/**
	 * @mbggenerated 是否打印经济服务合同0-否 1-是
	 */
	private Boolean isPrintBrokerServiceContract;
	/**
	 * @mbggenerated 产权类型 0-个人产权 1-公司产权
	 */
	private Byte propertyRightType;
	/**
	 * @mbggenerated 公司产权代理人姓名 
	 */
	private String compPropertyRightAgent;
	/**
	 * @mbggenerated 预计过户时间
	 */
	private Date transferTimePredict;
	/**
	 * @mbggenerated 是否归档至总部 0-否 1-是
	 */
	private Boolean hqPigeonholeFlag;
	/**
	 * @mbggenerated 楼盘城市ID
	 */
	private Integer buildCityId;
	/**
	 * @mbggenerated 购房发票 0-无 ，1-有
	 */
	private Boolean houseInvoice;
	/**
	 * @mbggenerated 流程变为归档的时间
	 */
	private Date pigeonholeTime;
	/**
	 * @mbggenerated 合同id
	 */
	private Integer dealId;
	/**
	 * @mbggenerated 公司区域id
	 */
	private Integer crmCompId;
	/**
	 * @mbggenerated 卖方银行名称
	 */
	private String vendorBankName;
	/**
	 * @mbggenerated 卖方银行卡号
	 */
	private String vendorBankCardNumber;
	/**
	 * @mbggenerated 国土性质  1.出让  2.划拨
	 */
	private Byte territorialNature;
	/**
	 * @mbggenerated 抵押银行ID
	 */
	private Integer mortgageBank;
	/**
	 * @mbggenerated 抵押金额
	 */
	private BigDecimal mortgageAmount;
	/**
	 * @mbggenerated 抵押银行名称
	 */
	private String mortgageBankName;
	/**
	 * @mbggenerated 抵押评估公司名称
	 */
	private String mortgageAssessmentName;
	/**
	 * @mbggenerated 抵押评估公司ID
	 */
	private Integer mortgageAssessment;
	/**
	 * @mbggenerated 回款时间
	 */
	private Date receivableTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public String getRightAddr() {
		return rightAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setRightAddr(String rightAddr) {
		this.rightAddr = rightAddr == null ? null : rightAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRightNum() {
		return rightNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setRightNum(String rightNum) {
		this.rightNum = rightNum == null ? null : rightNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getArea() {
		return area;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated
	 */
	public String getHousePhone() {
		return housePhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setHousePhone(String housePhone) {
		this.housePhone = housePhone == null ? null : housePhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseDesc() {
		return houseDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc == null ? null : houseDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMainApplyName() {
		return mainApplyName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainApplyName(String mainApplyName) {
		this.mainApplyName = mainApplyName == null ? null : mainApplyName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMainApplyIdcard() {
		return mainApplyIdcard;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainApplyIdcard(String mainApplyIdcard) {
		this.mainApplyIdcard = mainApplyIdcard == null ? null : mainApplyIdcard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMainApplyPhone() {
		return mainApplyPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainApplyPhone(String mainApplyPhone) {
		this.mainApplyPhone = mainApplyPhone == null ? null : mainApplyPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMainMarryStatus() {
		return mainMarryStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainMarryStatus(Byte mainMarryStatus) {
		this.mainMarryStatus = mainMarryStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMainOwnerHouse() {
		return mainOwnerHouse;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainOwnerHouse(Byte mainOwnerHouse) {
		this.mainOwnerHouse = mainOwnerHouse;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMainCreditStatus() {
		return mainCreditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainCreditStatus(Byte mainCreditStatus) {
		this.mainCreditStatus = mainCreditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getMainWorkUnit() {
		return mainWorkUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainWorkUnit(String mainWorkUnit) {
		this.mainWorkUnit = mainWorkUnit == null ? null : mainWorkUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondApplyName() {
		return secondApplyName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondApplyName(String secondApplyName) {
		this.secondApplyName = secondApplyName == null ? null : secondApplyName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondApplyIdcard() {
		return secondApplyIdcard;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondApplyIdcard(String secondApplyIdcard) {
		this.secondApplyIdcard = secondApplyIdcard == null ? null : secondApplyIdcard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondApplyPhone() {
		return secondApplyPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondApplyPhone(String secondApplyPhone) {
		this.secondApplyPhone = secondApplyPhone == null ? null : secondApplyPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUnderwriterName() {
		return underwriterName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnderwriterName(String underwriterName) {
		this.underwriterName = underwriterName == null ? null : underwriterName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUnderwriterPhone() {
		return underwriterPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnderwriterPhone(String underwriterPhone) {
		this.underwriterPhone = underwriterPhone == null ? null : underwriterPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFinanceMethod() {
		return financeMethod;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceMethod(Byte financeMethod) {
		this.financeMethod = financeMethod;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBankRecord() {
		return bankRecord;
	}

	/**
	 * @mbggenerated
	 */
	public void setBankRecord(Byte bankRecord) {
		this.bankRecord = bankRecord;
	}

	/**
	 * @mbggenerated
	 */
	public String getFinanceInfoDesc() {
		return financeInfoDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceInfoDesc(String financeInfoDesc) {
		this.financeInfoDesc = financeInfoDesc == null ? null : financeInfoDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getContractSignTime() {
		return contractSignTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setContractSignTime(Date contractSignTime) {
		this.contractSignTime = contractSignTime;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getApplyPrice() {
		return applyPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setApplyPrice(BigDecimal applyPrice) {
		this.applyPrice = applyPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFinanceYear() {
		return financeYear;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceYear(Byte financeYear) {
		this.financeYear = financeYear;
	}

	/**
	 * @mbggenerated
	 */
	public String getFinanceRate() {
		return financeRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceRate(String financeRate) {
		this.financeRate = financeRate == null ? null : financeRate.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFundSupervisionFlag() {
		return fundSupervisionFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setFundSupervisionFlag(Byte fundSupervisionFlag) {
		this.fundSupervisionFlag = fundSupervisionFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTrustServiceFlag() {
		return trustServiceFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrustServiceFlag(Byte trustServiceFlag) {
		this.trustServiceFlag = trustServiceFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDoubleBankFlag() {
		return doubleBankFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setDoubleBankFlag(Byte doubleBankFlag) {
		this.doubleBankFlag = doubleBankFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMainBankId() {
		return mainBankId;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainBankId(Integer mainBankId) {
		this.mainBankId = mainBankId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondBankId() {
		return secondBankId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBankId(Integer secondBankId) {
		this.secondBankId = secondBankId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPreviewsTime() {
		return previewsTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPreviewsTime(Date previewsTime) {
		this.previewsTime = previewsTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getFinanceMethodDesc() {
		return financeMethodDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceMethodDesc(String financeMethodDesc) {
		this.financeMethodDesc = financeMethodDesc == null ? null : financeMethodDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getChargeFlag() {
		return chargeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setChargeFlag(Byte chargeFlag) {
		this.chargeFlag = chargeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getChargeMethod() {
		return chargeMethod;
	}

	/**
	 * @mbggenerated
	 */
	public void setChargeMethod(String chargeMethod) {
		this.chargeMethod = chargeMethod == null ? null : chargeMethod.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getBaseCharge() {
		return baseCharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setBaseCharge(BigDecimal baseCharge) {
		this.baseCharge = baseCharge;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getHftCharge() {
		return hftCharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftCharge(BigDecimal hftCharge) {
		this.hftCharge = hftCharge;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getProxyCharge() {
		return proxyCharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setProxyCharge(BigDecimal proxyCharge) {
		this.proxyCharge = proxyCharge;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getOtherCharge() {
		return otherCharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setOtherCharge(BigDecimal otherCharge) {
		this.otherCharge = otherCharge;
	}

	/**
	 * @mbggenerated
	 */
	public String getChargeDesc() {
		return chargeDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc == null ? null : chargeDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBusinessUserId() {
		return businessUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBusinessUserId(Integer businessUserId) {
		this.businessUserId = businessUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealUserId() {
		return dealUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAssessmentUserId() {
		return assessmentUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessmentUserId(Integer assessmentUserId) {
		this.assessmentUserId = assessmentUserId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo == null ? null : compNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo == null ? null : deptNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getErpCompId() {
		return erpCompId;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpCompId(Integer erpCompId) {
		this.erpCompId = erpCompId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getErpDeptId() {
		return erpDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpDeptId(Integer erpDeptId) {
		this.erpDeptId = erpDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public String getBrokerDeptName() {
		return brokerDeptName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerDeptName(String brokerDeptName) {
		this.brokerDeptName = brokerDeptName == null ? null : brokerDeptName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBrokerRegName() {
		return brokerRegName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerRegName(String brokerRegName) {
		this.brokerRegName = brokerRegName == null ? null : brokerRegName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBrokerRegId() {
		return brokerRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerRegId(Integer brokerRegId) {
		this.brokerRegId = brokerRegId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getBrokerUserName() {
		return brokerUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerUserName(String brokerUserName) {
		this.brokerUserName = brokerUserName == null ? null : brokerUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBrokerUserMobile() {
		return brokerUserMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerUserMobile(String brokerUserMobile) {
		this.brokerUserMobile = brokerUserMobile == null ? null : brokerUserMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFinanceNo() {
		return financeNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceNo(String financeNo) {
		this.financeNo = financeNo == null ? null : financeNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCrmAudit() {
		return crmAudit;
	}

	/**
	 * @mbggenerated
	 */
	public void setCrmAudit(Byte crmAudit) {
		this.crmAudit = crmAudit;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getErpAudit() {
		return erpAudit;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpAudit(Byte erpAudit) {
		this.erpAudit = erpAudit;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFinanceStatus() {
		return financeStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceStatus(Integer financeStatus) {
		this.financeStatus = financeStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCustType() {
		return custType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCustType(Byte custType) {
		this.custType = custType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSource() {
		return source;
	}

	/**
	 * @mbggenerated
	 */
	public void setSource(Byte source) {
		this.source = source;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFitmentStatus() {
		return fitmentStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setFitmentStatus(Byte fitmentStatus) {
		this.fitmentStatus = fitmentStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseYears() {
		return houseYears;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseYears(String houseYears) {
		this.houseYears = houseYears == null ? null : houseYears.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAssessAmount() {
		return assessAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessAmount(BigDecimal assessAmount) {
		this.assessAmount = assessAmount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAssessedDate() {
		return assessedDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessedDate(Date assessedDate) {
		this.assessedDate = assessedDate;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfAdjust() {
		return ifAdjust;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfAdjust(Byte ifAdjust) {
		this.ifAdjust = ifAdjust;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAdjustedPrice() {
		return adjustedPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setAdjustedPrice(BigDecimal adjustedPrice) {
		this.adjustedPrice = adjustedPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAdjustCharge() {
		return adjustCharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setAdjustCharge(Integer adjustCharge) {
		this.adjustCharge = adjustCharge;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfNetSign() {
		return ifNetSign;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfNetSign(Byte ifNetSign) {
		this.ifNetSign = ifNetSign;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfSubmitPledge() {
		return ifSubmitPledge;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfSubmitPledge(Byte ifSubmitPledge) {
		this.ifSubmitPledge = ifSubmitPledge;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPledgeDate() {
		return pledgeDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setPledgeDate(Date pledgeDate) {
		this.pledgeDate = pledgeDate;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getDownPayment() {
		return downPayment;
	}

	/**
	 * @mbggenerated
	 */
	public void setDownPayment(BigDecimal downPayment) {
		this.downPayment = downPayment;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRepaymentType() {
		return repaymentType;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentType(Byte repaymentType) {
		this.repaymentType = repaymentType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMonthlyPayment() {
		return monthlyPayment;
	}

	/**
	 * @mbggenerated
	 */
	public void setMonthlyPayment(Integer monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfSubmitZpreport() {
		return ifSubmitZpreport;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfSubmitZpreport(Byte ifSubmitZpreport) {
		this.ifSubmitZpreport = ifSubmitZpreport;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfLended() {
		return ifLended;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfLended(Byte ifLended) {
		this.ifLended = ifLended;
	}

	/**
	 * @mbggenerated
	 */
	public String getPledgeRemark() {
		return pledgeRemark;
	}

	/**
	 * @mbggenerated
	 */
	public void setPledgeRemark(String pledgeRemark) {
		this.pledgeRemark = pledgeRemark == null ? null : pledgeRemark.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getErpAreaId() {
		return erpAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpAreaId(Integer erpAreaId) {
		this.erpAreaId = erpAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getErpRegId() {
		return erpRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpRegId(Integer erpRegId) {
		this.erpRegId = erpRegId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getRealLoanPrice() {
		return realLoanPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealLoanPrice(BigDecimal realLoanPrice) {
		this.realLoanPrice = realLoanPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseSource() {
		return houseSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseSource(Byte houseSource) {
		this.houseSource = houseSource;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMainAssessment() {
		return mainAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainAssessment(Integer mainAssessment) {
		this.mainAssessment = mainAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondAssessment() {
		return secondAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondAssessment(Integer secondAssessment) {
		this.secondAssessment = secondAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDataResource() {
		return dataResource;
	}

	/**
	 * @mbggenerated
	 */
	public void setDataResource(Byte dataResource) {
		this.dataResource = dataResource;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCreatorType() {
		return creatorType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorType(Byte creatorType) {
		this.creatorType = creatorType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIncomeProof() {
		return incomeProof;
	}

	/**
	 * @mbggenerated
	 */
	public void setIncomeProof(Byte incomeProof) {
		this.incomeProof = incomeProof;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getErpGrId() {
		return erpGrId;
	}

	/**
	 * @mbggenerated
	 */
	public void setErpGrId(Integer erpGrId) {
		this.erpGrId = erpGrId;
	}

	/**
	 * @mbggenerated
	 */
	public String getMainBankName() {
		return mainBankName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainBankName(String mainBankName) {
		this.mainBankName = mainBankName == null ? null : mainBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondBankName() {
		return secondBankName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBankName(String secondBankName) {
		this.secondBankName = secondBankName == null ? null : secondBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMainAssessName() {
		return mainAssessName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainAssessName(String mainAssessName) {
		this.mainAssessName = mainAssessName == null ? null : mainAssessName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondAssessName() {
		return secondAssessName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondAssessName(String secondAssessName) {
		this.secondAssessName = secondAssessName == null ? null : secondAssessName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTranceferPledgeDesc() {
		return tranceferPledgeDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setTranceferPledgeDesc(String tranceferPledgeDesc) {
		this.tranceferPledgeDesc = tranceferPledgeDesc == null ? null : tranceferPledgeDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfAddressChange() {
		return ifAddressChange;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfAddressChange(Byte ifAddressChange) {
		this.ifAddressChange = ifAddressChange;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAssessUnitPrice() {
		return assessUnitPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessUnitPrice(BigDecimal assessUnitPrice) {
		this.assessUnitPrice = assessUnitPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfRedeemHouse() {
		return ifRedeemHouse;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfRedeemHouse(Byte ifRedeemHouse) {
		this.ifRedeemHouse = ifRedeemHouse;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSentApprovalTime() {
		return sentApprovalTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setSentApprovalTime(Date sentApprovalTime) {
		this.sentApprovalTime = sentApprovalTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getBankAttentionMatters() {
		return bankAttentionMatters;
	}

	/**
	 * @mbggenerated
	 */
	public void setBankAttentionMatters(String bankAttentionMatters) {
		this.bankAttentionMatters = bankAttentionMatters == null ? null : bankAttentionMatters.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTransferEmployee() {
		return transferEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public void setTransferEmployee(Integer transferEmployee) {
		this.transferEmployee = transferEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPledgeEmployee() {
		return pledgeEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public void setPledgeEmployee(Integer pledgeEmployee) {
		this.pledgeEmployee = pledgeEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfRelevance() {
		return ifRelevance;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfRelevance(Byte ifRelevance) {
		this.ifRelevance = ifRelevance;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRelevanceTime() {
		return relevanceTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setRelevanceTime(Date relevanceTime) {
		this.relevanceTime = relevanceTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getTransactionTransferTime() {
		return transactionTransferTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTransactionTransferTime(Date transactionTransferTime) {
		this.transactionTransferTime = transactionTransferTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfVendorEntrust() {
		return ifVendorEntrust;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfVendorEntrust(Byte ifVendorEntrust) {
		this.ifVendorEntrust = ifVendorEntrust;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfVendeeEntrust() {
		return ifVendeeEntrust;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfVendeeEntrust(Byte ifVendeeEntrust) {
		this.ifVendeeEntrust = ifVendeeEntrust;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getReveicer() {
		return reveicer;
	}

	/**
	 * @mbggenerated
	 */
	public void setReveicer(Integer reveicer) {
		this.reveicer = reveicer;
	}

	/**
	 * @mbggenerated
	 */
	public Date getZhengpingTime() {
		return zhengpingTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setZhengpingTime(Date zhengpingTime) {
		this.zhengpingTime = zhengpingTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getTransferTaxPrice() {
		return transferTaxPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setTransferTaxPrice(String transferTaxPrice) {
		this.transferTaxPrice = transferTaxPrice == null ? null : transferTaxPrice.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPapersType() {
		return papersType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPapersType(Byte papersType) {
		this.papersType = papersType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfHandOverInformation() {
		return ifHandOverInformation;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfHandOverInformation(Byte ifHandOverInformation) {
		this.ifHandOverInformation = ifHandOverInformation;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfGatherOriginalChanquan() {
		return ifGatherOriginalChanquan;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfGatherOriginalChanquan(Byte ifGatherOriginalChanquan) {
		this.ifGatherOriginalChanquan = ifGatherOriginalChanquan;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfGatherOriginalGuotu() {
		return ifGatherOriginalGuotu;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfGatherOriginalGuotu(Byte ifGatherOriginalGuotu) {
		this.ifGatherOriginalGuotu = ifGatherOriginalGuotu;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfPublishHouse() {
		return ifPublishHouse;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfPublishHouse(Byte ifPublishHouse) {
		this.ifPublishHouse = ifPublishHouse;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getNetSignTransactor() {
		return netSignTransactor;
	}

	/**
	 * @mbggenerated
	 */
	public void setNetSignTransactor(Integer netSignTransactor) {
		this.netSignTransactor = netSignTransactor;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getOwnshipType() {
		return ownshipType;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnshipType(Byte ownshipType) {
		this.ownshipType = ownshipType;
	}

	/**
	 * @mbggenerated
	 */
	public String getTransferAttentionMatters() {
		return transferAttentionMatters;
	}

	/**
	 * @mbggenerated
	 */
	public void setTransferAttentionMatters(String transferAttentionMatters) {
		this.transferAttentionMatters = transferAttentionMatters == null ? null : transferAttentionMatters.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPayForAnotherType() {
		return payForAnotherType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayForAnotherType(Byte payForAnotherType) {
		this.payForAnotherType = payForAnotherType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHavePaidYears() {
		return havePaidYears;
	}

	/**
	 * @mbggenerated
	 */
	public void setHavePaidYears(Integer havePaidYears) {
		this.havePaidYears = havePaidYears;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPledgeCondition() {
		return pledgeCondition;
	}

	/**
	 * @mbggenerated
	 */
	public void setPledgeCondition(Byte pledgeCondition) {
		this.pledgeCondition = pledgeCondition;
	}

	/**
	 * @mbggenerated
	 */
	public String getFirstPayOrganization() {
		return firstPayOrganization;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstPayOrganization(String firstPayOrganization) {
		this.firstPayOrganization = firstPayOrganization == null ? null : firstPayOrganization.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getFirstAnotherPayPrice() {
		return firstAnotherPayPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstAnotherPayPrice(BigDecimal firstAnotherPayPrice) {
		this.firstAnotherPayPrice = firstAnotherPayPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFirstTransactionTimePredict() {
		return firstTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstTransactionTimePredict(Date firstTransactionTimePredict) {
		this.firstTransactionTimePredict = firstTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFirstTransactionTimeReal() {
		return firstTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstTransactionTimeReal(Date firstTransactionTimeReal) {
		this.firstTransactionTimeReal = firstTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFirstPayTimePredict() {
		return firstPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstPayTimePredict(Date firstPayTimePredict) {
		this.firstPayTimePredict = firstPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFirstPayTimeReal() {
		return firstPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstPayTimeReal(Date firstPayTimeReal) {
		this.firstPayTimeReal = firstPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondPayOrganization() {
		return secondPayOrganization;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondPayOrganization(String secondPayOrganization) {
		this.secondPayOrganization = secondPayOrganization == null ? null : secondPayOrganization.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getSecondAnotherPayPrice() {
		return secondAnotherPayPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondAnotherPayPrice(BigDecimal secondAnotherPayPrice) {
		this.secondAnotherPayPrice = secondAnotherPayPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSecondTransactionTimePredict() {
		return secondTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondTransactionTimePredict(Date secondTransactionTimePredict) {
		this.secondTransactionTimePredict = secondTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSecondTransactionTimeReal() {
		return secondTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondTransactionTimeReal(Date secondTransactionTimeReal) {
		this.secondTransactionTimeReal = secondTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSecondPayTimePredict() {
		return secondPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondPayTimePredict(Date secondPayTimePredict) {
		this.secondPayTimePredict = secondPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSecondPayTimeReal() {
		return secondPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondPayTimeReal(Date secondPayTimeReal) {
		this.secondPayTimeReal = secondPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSequencePositonTimePredict() {
		return sequencePositonTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setSequencePositonTimePredict(Date sequencePositonTimePredict) {
		this.sequencePositonTimePredict = sequencePositonTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSequencePositonTimeReal() {
		return sequencePositonTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setSequencePositonTimeReal(Date sequencePositonTimeReal) {
		this.sequencePositonTimeReal = sequencePositonTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSignoutTimePredict() {
		return signoutTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setSignoutTimePredict(Date signoutTimePredict) {
		this.signoutTimePredict = signoutTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getSignoutTimeReal() {
		return signoutTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setSignoutTimeReal(Date signoutTimeReal) {
		this.signoutTimeReal = signoutTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAnotherPayTimePredict() {
		return anotherPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setAnotherPayTimePredict(Date anotherPayTimePredict) {
		this.anotherPayTimePredict = anotherPayTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAnotherPayTimeReal() {
		return anotherPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setAnotherPayTimeReal(Date anotherPayTimeReal) {
		this.anotherPayTimeReal = anotherPayTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAnotherPayBalance() {
		return anotherPayBalance;
	}

	/**
	 * @mbggenerated
	 */
	public void setAnotherPayBalance(BigDecimal anotherPayBalance) {
		this.anotherPayBalance = anotherPayBalance;
	}

	/**
	 * @mbggenerated
	 */
	public String getSuperviseDrawRestrict() {
		return superviseDrawRestrict;
	}

	/**
	 * @mbggenerated
	 */
	public void setSuperviseDrawRestrict(String superviseDrawRestrict) {
		this.superviseDrawRestrict = superviseDrawRestrict == null ? null : superviseDrawRestrict.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfQutaRight() {
		return ifQutaRight;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfQutaRight(Byte ifQutaRight) {
		this.ifQutaRight = ifQutaRight;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIfHandOverBank() {
		return ifHandOverBank;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfHandOverBank(Byte ifHandOverBank) {
		this.ifHandOverBank = ifHandOverBank;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHandOverEmployee() {
		return handOverEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public void setHandOverEmployee(Integer handOverEmployee) {
		this.handOverEmployee = handOverEmployee;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLoanTime() {
		return loanTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName == null ? null : vendorName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorIdNumber() {
		return vendorIdNumber;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorIdNumber(String vendorIdNumber) {
		this.vendorIdNumber = vendorIdNumber == null ? null : vendorIdNumber.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorPhone() {
		return vendorPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone == null ? null : vendorPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorCommonOwnerName() {
		return vendorCommonOwnerName;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorCommonOwnerName(String vendorCommonOwnerName) {
		this.vendorCommonOwnerName = vendorCommonOwnerName == null ? null : vendorCommonOwnerName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorCommonOwnerIdNumber() {
		return vendorCommonOwnerIdNumber;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorCommonOwnerIdNumber(String vendorCommonOwnerIdNumber) {
		this.vendorCommonOwnerIdNumber = vendorCommonOwnerIdNumber == null ? null : vendorCommonOwnerIdNumber.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorCommonOwnerPhone() {
		return vendorCommonOwnerPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorCommonOwnerPhone(String vendorCommonOwnerPhone) {
		this.vendorCommonOwnerPhone = vendorCommonOwnerPhone == null ? null : vendorCommonOwnerPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorSuretyName() {
		return vendorSuretyName;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorSuretyName(String vendorSuretyName) {
		this.vendorSuretyName = vendorSuretyName == null ? null : vendorSuretyName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorSuretyIdNumber() {
		return vendorSuretyIdNumber;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorSuretyIdNumber(String vendorSuretyIdNumber) {
		this.vendorSuretyIdNumber = vendorSuretyIdNumber == null ? null : vendorSuretyIdNumber.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorSuretyPhone() {
		return vendorSuretyPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorSuretyPhone(String vendorSuretyPhone) {
		this.vendorSuretyPhone = vendorSuretyPhone == null ? null : vendorSuretyPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getApprovalPassTime() {
		return approvalPassTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setApprovalPassTime(Date approvalPassTime) {
		this.approvalPassTime = approvalPassTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorConditionDescription() {
		return vendorConditionDescription;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorConditionDescription(String vendorConditionDescription) {
		this.vendorConditionDescription = vendorConditionDescription == null ? null : vendorConditionDescription.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendeeConditionDescription() {
		return vendeeConditionDescription;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendeeConditionDescription(String vendeeConditionDescription) {
		this.vendeeConditionDescription = vendeeConditionDescription == null ? null : vendeeConditionDescription.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendeeSuretyIdcard() {
		return vendeeSuretyIdcard;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendeeSuretyIdcard(String vendeeSuretyIdcard) {
		this.vendeeSuretyIdcard = vendeeSuretyIdcard == null ? null : vendeeSuretyIdcard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getTfTransactionTimePredict() {
		return tfTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setTfTransactionTimePredict(Date tfTransactionTimePredict) {
		this.tfTransactionTimePredict = tfTransactionTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Date getTfTransactionTimeReal() {
		return tfTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public void setTfTransactionTimeReal(Date tfTransactionTimeReal) {
		this.tfTransactionTimeReal = tfTransactionTimeReal;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSignOutClient() {
		return signOutClient;
	}

	/**
	 * @mbggenerated
	 */
	public void setSignOutClient(Byte signOutClient) {
		this.signOutClient = signOutClient;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDelStatus() {
		return delStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelStatus(Byte delStatus) {
		this.delStatus = delStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFinanceModel() {
		return financeModel;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceModel(Byte financeModel) {
		this.financeModel = financeModel;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getDownPaymentPrice() {
		return downPaymentPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setDownPaymentPrice(BigDecimal downPaymentPrice) {
		this.downPaymentPrice = downPaymentPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getDepositPrice() {
		return depositPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setDepositPrice(BigDecimal depositPrice) {
		this.depositPrice = depositPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getFundSupervisionPrice() {
		return fundSupervisionPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setFundSupervisionPrice(BigDecimal fundSupervisionPrice) {
		this.fundSupervisionPrice = fundSupervisionPrice;
	}

	/**
	 * @mbggenerated
	 */
	public String getRiskLevel() {
		return riskLevel;
	}

	/**
	 * @mbggenerated
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel == null ? null : riskLevel.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPaymentSource() {
		return paymentSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource == null ? null : paymentSource.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getEntrustedName() {
		return entrustedName;
	}

	/**
	 * @mbggenerated
	 */
	public void setEntrustedName(String entrustedName) {
		this.entrustedName = entrustedName == null ? null : entrustedName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getEntrustedIccard() {
		return entrustedIccard;
	}

	/**
	 * @mbggenerated
	 */
	public void setEntrustedIccard(String entrustedIccard) {
		this.entrustedIccard = entrustedIccard == null ? null : entrustedIccard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRepaymentBankName() {
		return repaymentBankName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentBankName(String repaymentBankName) {
		this.repaymentBankName = repaymentBankName == null ? null : repaymentBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHasPaidYears() {
		return hasPaidYears;
	}

	/**
	 * @mbggenerated
	 */
	public void setHasPaidYears(Integer hasPaidYears) {
		this.hasPaidYears = hasPaidYears;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsAppointment() {
		return isAppointment;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsAppointment(Boolean isAppointment) {
		this.isAppointment = isAppointment;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsRepaymentAnytime() {
		return isRepaymentAnytime;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsRepaymentAnytime(Boolean isRepaymentAnytime) {
		this.isRepaymentAnytime = isRepaymentAnytime;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getAcceptChannelRepaymentTime() {
		return acceptChannelRepaymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAcceptChannelRepaymentTime(Boolean acceptChannelRepaymentTime) {
		this.acceptChannelRepaymentTime = acceptChannelRepaymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIfTransferParking() {
		return ifTransferParking;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfTransferParking(Boolean ifTransferParking) {
		this.ifTransferParking = ifTransferParking;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIfReplaceCredentials() {
		return ifReplaceCredentials;
	}

	/**
	 * @mbggenerated
	 */
	public void setIfReplaceCredentials(Boolean ifReplaceCredentials) {
		this.ifReplaceCredentials = ifReplaceCredentials;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRepaymentPrice() {
		return repaymentPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentPrice(Integer repaymentPrice) {
		this.repaymentPrice = repaymentPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRepaymentTime() {
		return repaymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getRepaymentChannel() {
		return repaymentChannel;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentChannel(String repaymentChannel) {
		this.repaymentChannel = repaymentChannel == null ? null : repaymentChannel.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRepaymentDesc() {
		return repaymentDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepaymentDesc(String repaymentDesc) {
		this.repaymentDesc = repaymentDesc == null ? null : repaymentDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCopySourceId() {
		return copySourceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCopySourceId(Integer copySourceId) {
		this.copySourceId = copySourceId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRedeliveryTime() {
		return redeliveryTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setRedeliveryTime(Date redeliveryTime) {
		this.redeliveryTime = redeliveryTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getReceivablesNo() {
		return receivablesNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setReceivablesNo(String receivablesNo) {
		this.receivablesNo = receivablesNo == null ? null : receivablesNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getDoubleDeptFlag() {
		return doubleDeptFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setDoubleDeptFlag(Boolean doubleDeptFlag) {
		this.doubleDeptFlag = doubleDeptFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSecondDeptCustType() {
		return secondDeptCustType;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondDeptCustType(Byte secondDeptCustType) {
		this.secondDeptCustType = secondDeptCustType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondDeptCityId() {
		return secondDeptCityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondDeptCityId(Integer secondDeptCityId) {
		this.secondDeptCityId = secondDeptCityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondDeptRegId() {
		return secondDeptRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondDeptRegId(Integer secondDeptRegId) {
		this.secondDeptRegId = secondDeptRegId;
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondCompNo() {
		return secondCompNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondCompNo(String secondCompNo) {
		this.secondCompNo = secondCompNo == null ? null : secondCompNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondDeptNo() {
		return secondDeptNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondDeptNo(String secondDeptNo) {
		this.secondDeptNo = secondDeptNo == null ? null : secondDeptNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondErpCompId() {
		return secondErpCompId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondErpCompId(Integer secondErpCompId) {
		this.secondErpCompId = secondErpCompId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondErpDeptId() {
		return secondErpDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondErpDeptId(Integer secondErpDeptId) {
		this.secondErpDeptId = secondErpDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondBrokerDeptName() {
		return secondBrokerDeptName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBrokerDeptName(String secondBrokerDeptName) {
		this.secondBrokerDeptName = secondBrokerDeptName == null ? null : secondBrokerDeptName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondBrokerRegName() {
		return secondBrokerRegName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBrokerRegName(String secondBrokerRegName) {
		this.secondBrokerRegName = secondBrokerRegName == null ? null : secondBrokerRegName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondBrokerRegId() {
		return secondBrokerRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBrokerRegId(Integer secondBrokerRegId) {
		this.secondBrokerRegId = secondBrokerRegId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSecondArchiveId() {
		return secondArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondArchiveId(Integer secondArchiveId) {
		this.secondArchiveId = secondArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondBrokerUserName() {
		return secondBrokerUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBrokerUserName(String secondBrokerUserName) {
		this.secondBrokerUserName = secondBrokerUserName == null ? null : secondBrokerUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondBrokerUserMobile() {
		return secondBrokerUserMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondBrokerUserMobile(String secondBrokerUserMobile) {
		this.secondBrokerUserMobile = secondBrokerUserMobile == null ? null : secondBrokerUserMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsPrintBrokerServiceContract() {
		return isPrintBrokerServiceContract;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsPrintBrokerServiceContract(Boolean isPrintBrokerServiceContract) {
		this.isPrintBrokerServiceContract = isPrintBrokerServiceContract;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPropertyRightType() {
		return propertyRightType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPropertyRightType(Byte propertyRightType) {
		this.propertyRightType = propertyRightType;
	}

	/**
	 * @mbggenerated
	 */
	public String getCompPropertyRightAgent() {
		return compPropertyRightAgent;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompPropertyRightAgent(String compPropertyRightAgent) {
		this.compPropertyRightAgent = compPropertyRightAgent == null ? null : compPropertyRightAgent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getTransferTimePredict() {
		return transferTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public void setTransferTimePredict(Date transferTimePredict) {
		this.transferTimePredict = transferTimePredict;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getHqPigeonholeFlag() {
		return hqPigeonholeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setHqPigeonholeFlag(Boolean hqPigeonholeFlag) {
		this.hqPigeonholeFlag = hqPigeonholeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildCityId() {
		return buildCityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildCityId(Integer buildCityId) {
		this.buildCityId = buildCityId;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getHouseInvoice() {
		return houseInvoice;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseInvoice(Boolean houseInvoice) {
		this.houseInvoice = houseInvoice;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPigeonholeTime() {
		return pigeonholeTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPigeonholeTime(Date pigeonholeTime) {
		this.pigeonholeTime = pigeonholeTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCrmCompId() {
		return crmCompId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorBankName() {
		return vendorBankName;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorBankName(String vendorBankName) {
		this.vendorBankName = vendorBankName == null ? null : vendorBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVendorBankCardNumber() {
		return vendorBankCardNumber;
	}

	/**
	 * @mbggenerated
	 */
	public void setVendorBankCardNumber(String vendorBankCardNumber) {
		this.vendorBankCardNumber = vendorBankCardNumber == null ? null : vendorBankCardNumber.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTerritorialNature() {
		return territorialNature;
	}

	/**
	 * @mbggenerated
	 */
	public void setTerritorialNature(Byte territorialNature) {
		this.territorialNature = territorialNature;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMortgageBank() {
		return mortgageBank;
	}

	/**
	 * @mbggenerated
	 */
	public void setMortgageBank(Integer mortgageBank) {
		this.mortgageBank = mortgageBank;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getMortgageAmount() {
		return mortgageAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setMortgageAmount(BigDecimal mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}

	/**
	 * @mbggenerated
	 */
	public String getMortgageBankName() {
		return mortgageBankName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMortgageBankName(String mortgageBankName) {
		this.mortgageBankName = mortgageBankName == null ? null : mortgageBankName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMortgageAssessmentName() {
		return mortgageAssessmentName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMortgageAssessmentName(String mortgageAssessmentName) {
		this.mortgageAssessmentName = mortgageAssessmentName == null ? null : mortgageAssessmentName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMortgageAssessment() {
		return mortgageAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public void setMortgageAssessment(Integer mortgageAssessment) {
		this.mortgageAssessment = mortgageAssessment;
	}

	/**
	 * @mbggenerated
	 */
	public Date getReceivableTime() {
		return receivableTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setReceivableTime(Date receivableTime) {
		this.receivableTime = receivableTime;
	}
}