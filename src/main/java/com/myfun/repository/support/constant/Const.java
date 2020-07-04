


package com.myfun.repository.support.constant;

import com.myfun.utils.DateUtil;

import java.util.*;

/**
 * 全局常量类
 *
 * @ClassName: Constant
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午4:28:07
 *
 */
public  class Const {
	public static final Map<String,String> PERFORMANCETYPENAME_MAP = new HashMap<String,String>();
	public static final Map<Integer,String> PLATETYPEMSG_MAP = new HashMap<Integer,String>();
	public final static Map<String,Integer> RANGE_LEVEL = new HashMap<String,Integer>();
	public final static Map<String,Integer> PERFORMANCE_USER_RELATIVE = new HashMap<>();
	public final static Map<Integer,String> USER_PERFORMANCE_RELATIVE = new HashMap<>();
	public final static Map<String,String> WORKONTOOFF = new HashMap<String,String>();


	public final static String DIC_DEAL_UPDATE_CLASSIC_TAXESUPDATE = "税费更新";
	public final static String DIC_DEAL_UPDATE_CLASSIC_ADUIT = "合同审核";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALINVALID = "合同作废";
	public final static String DIC_DEAL_UPDATE_CLASSIC_STEPADD = "步骤添加";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE = "流程修改";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEALLDEAL = "流程办结";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEAL = "办结合同";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEAL_COUNT = "撤销办结";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCOMPLETION = "流程撤销办结";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEDEAL = "步骤完成";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSINFO = "基础信息";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEL_PHOTO = "附件管理";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATE = "流程创建";
	public final static String DIC_DEAL_UPDATE_CLASSIC_TAXESCREATE = "税费创建";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACSTATUSCHANGE = "财务状态更新";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCHANGE = "流程变更";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALSETTLEMENT = "结算合同";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALCOUNTERAUDIT = "撤销审核";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALEDIT = "合同修改";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALCREATE = "合同创建";


	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACCREATE = "【财务款项创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACAUDITACCOUNTRECEIVABLE = "【应收应付审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACREALINCOMEAUDIT  = "【实收实付审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITDELETE = "【业绩删除】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACUPDATE = "【财务款项更新】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACDEL = "【财务款项删除】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCOMMSIONCHANGE = "财务更新";
	public final static String DIC_DEAL_UPDATE_CLASSIC_TAXESADULT = "税费审核";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITCREATE = "【业绩创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITUPDATE = "【业绩更新】";

	
	public final static Byte DIC_DEPOSIT_ADULT = (byte)1;
	public final static Byte DIC_DEPOSIT_CANCEL_ADULT = (byte)0;
	public final static Byte DIC_DEPOSIT_INVALID = (byte)2;
	
	//权证流程排序映射
	public  final static Map<String,String> dealContractTaskOrderMap = new HashMap<>();
	public  final static Map<String,String> dealContractTaskTransactOrderMap = new HashMap<>();
	public  final static Map<Byte,String> depositTransMap = new HashMap<>();
	public final static Map<String,List<String>> switchCompOperMap = new HashMap<>();
	public final static List<String> switchCompOperList = new ArrayList<>();
	public final static List<String> switchCompRemoveOperList = new ArrayList<>();

	static {
		depositTransMap.put(DIC_DEPOSIT_ADULT, "审核");
		depositTransMap.put(DIC_DEPOSIT_CANCEL_ADULT, "撤销审核");
		depositTransMap.put(DIC_DEPOSIT_INVALID, "作废");
		dealContractTaskOrderMap.put("signDate","A.SIGN_DATE ");
		dealContractTaskOrderMap.put("signUserDeptName","A.SIGN_USER_DEPT_NAME ");
		dealContractTaskOrderMap.put("sellAddress","A.SELL_ADDRESS ");
		dealContractTaskOrderMap.put("commercialLoanMoney","A.COMMERCIAL_LOAN_MONEY ");
		dealContractTaskOrderMap.put("sellDealMoney","A.SELL_DEAL_MONEY ");
		dealContractTaskOrderMap.put("sellOwnerName","A.SELL_OWNER_NAME ");
		dealContractTaskOrderMap.put("buyOwnerName","A.BUY_OWNER_NAME ");
		dealContractTaskOrderMap.put("dealUserName","A.DEAL_USER_NAME ");
		dealContractTaskOrderMap.put("modelName","A.MODEL_NAME ");
		dealContractTaskOrderMap.put("timelimitdate","B.TIMELIMITDATE ");
		dealContractTaskOrderMap.put("updateTime","A.UPDATE_TIME ");
		dealContractTaskOrderMap.put("stepId","B.STEP_ID ");
		dealContractTaskOrderMap.put("updateUser","B.UPDATE_USER ");
		dealContractTaskOrderMap.put("flowcontent","B.FLOWCONTENT ");
		dealContractTaskOrderMap.put("contractNo","A.CONTRACT_NO ");
		dealContractTaskOrderMap.put("stepNums","A.STEP_NUMS ");

		dealContractTaskTransactOrderMap.put("signDate","A.SIGN_DATE ");
		dealContractTaskTransactOrderMap.put("signUserDeptName","A.SIGN_USER_DEPT_NAME ");
		dealContractTaskTransactOrderMap.put("sellAddress","A.SELL_ADDRESS ");
		dealContractTaskTransactOrderMap.put("commercialLoanMoney","A.COMMERCIAL_LOAN_MONEY ");
		dealContractTaskTransactOrderMap.put("sellDealMoney","A.SELL_DEAL_MONEY ");
		dealContractTaskTransactOrderMap.put("sellOwnerName","A.SELL_OWNER_NAME ");
		dealContractTaskTransactOrderMap.put("buyOwnerName","A.BUY_OWNER_NAME ");
		dealContractTaskTransactOrderMap.put("dealUserName","A.DEAL_USER_NAME ");
		dealContractTaskTransactOrderMap.put("modelName","A.MODEL_NAME ");
		dealContractTaskTransactOrderMap.put("timelimitdate","B.TIMELIMITDATE ");
		dealContractTaskTransactOrderMap.put("updateTime","B.UPDATE_TIME ");
		dealContractTaskTransactOrderMap.put("stepId","B.STEP_ID ");
		dealContractTaskTransactOrderMap.put("updateUser","B.UPDATE_USER ");
		dealContractTaskTransactOrderMap.put("flowcontent","B.FLOWCONTENT ");
		dealContractTaskTransactOrderMap.put("contractNo","A.CONTRACT_NO ");
		dealContractTaskTransactOrderMap.put("stepNums","A.STEP_NUMS ");

		USER_PERFORMANCE_RELATIVE.put(1,"HOUSE_CREATE");
		USER_PERFORMANCE_RELATIVE.put(2,"HOUSE_GUARDIAN");
		USER_PERFORMANCE_RELATIVE.put(3,"KEY");
		USER_PERFORMANCE_RELATIVE.put(4,"FANKAN");
		USER_PERFORMANCE_RELATIVE.put(5,"WEITUO");
		USER_PERFORMANCE_RELATIVE.put(6,"YIJIA");	
		switchCompOperMap.put("HOUSE_VIEW", Arrays.asList(new String[]{"VIEW_ORGANIZATION_HOUSE_LIST_INFO","VIEW_ORGANIZATION_HOUSE","QUERY_OTHER_SALE_PHONE","VIEW_SHARE_HOUSE_CUST","QUERY_OTHER_LEASE_PHONE"}));
		switchCompOperMap.put("GUEST_VIEW", Arrays.asList(new String[]{"VIEW_REG_CUST_LIST_ORGANIZATION","VIEW_ORGANIZATION_CUST","VIEW_SHARE_HOUSE_CUST","QUERY_OTHER_BUY_PHONE","QUERY_OTHER_RENT_PHONE"}));
		switchCompOperMap.put("NEW_HOUSE_VIEW", Arrays.asList(new String[]{"VIEW_REG_CUST_LIST_ORGANIZATION","LOOK_CUST_RANGE","SHARE_CUST_RANGE","PUBLIC_CUST_RANGE"}));
		switchCompOperMap.put("STATISTICS_VIEW", Arrays.asList(new String[]{"DATA_ANALYSIS_ORGANIZATION_VIEW"}));
		switchCompOperMap.put("CONTRACT_MANAGE", Arrays.asList(new String[]{"DEAL_MANAGE_CONFIGURE"}));
		switchCompOperMap.put("PERFORMANCE_VIEW", Arrays.asList(new String[]{"VIEW_ORGANIZATION_DEAL","FUN_WAG_CHECK_ORGANIZATION"}));
		switchCompOperMap.put("FINANCE_VIEW", Arrays.asList(new String[]{"VIEW_ORGANIZATION_DEAL"}));
		switchCompOperMap.put("ORGANIZATION_MANAGE", Arrays.asList(new String[]{"ORGANIZATION_MANAGE","MANAGE_ORGANIZATION_ORGANIZATION"}));
		switchCompOperMap.put("SALARY_MANAGE", Arrays.asList(new String[]{"FUN_WAGE_CONFIG","FUN_WAG_CHECK_ORGANIZATION"}));
		switchCompOperMap.put("ATTENDANCE_MANAGE", Arrays.asList(new String[]{"EMPLOYEE_CHECK"}));
		switchCompOperMap.put("ASSESS_MANAGE", Arrays.asList(new String[]{""}));
		switchCompOperMap.put("ROLE_MANAGE", Arrays.asList(new String[]{"ROLE_CONFIGURE"}));
		switchCompOperMap.put("EMPLOYEE_OPER_MANAGE", Arrays.asList(new String[]{"ROLE_MANAGE"}));
		switchCompOperMap.put("PARAM_MANAGE", Arrays.asList(new String[]{"PARA_MANAGE"}));
		switchCompOperList.add("VIEW_ORGANIZATION_HOUSE_LIST_INFO");//房源业务查看
		switchCompOperList.add("VIEW_ORGANIZATION_HOUSE");//房源业务查看
		switchCompOperList.add("QUERY_OTHER_SALE_PHONE");//房源业务查看
		switchCompOperList.add("QUERY_OTHER_LEASE_PHONE");//房源业务查看
		switchCompOperList.add("VIEW_REG_CUST_LIST_ORGANIZATION");//客源业务查看
		switchCompOperList.add("VIEW_ORGANIZATION_CUST");//客源业务查看
		switchCompOperList.add("VIEW_SHARE_HOUSE_CUST");//客源业务查看
		switchCompOperList.add("QUERY_OTHER_BUY_PHONE");//客源业务查看
		switchCompOperList.add("QUERY_OTHER_RENT_PHONE");//客源业务查看
		switchCompOperList.add("LOOK_CUST_RANGE");//客源业务查看
		switchCompOperList.add("SHARE_CUST_RANGE");//客源业务查看
		switchCompOperList.add("PUBLIC_CUST_RANGE");//客源业务查看
		switchCompOperList.add("DEAL_MANAGE_CONFIGURE");//交易合同配置、查看
		switchCompOperList.add("VIEW_ORGANIZATION_DEAL");//业绩信息查看
		switchCompOperList.add("FUN_WAG_CHECK_ORGANIZATION");//业绩信息查看
		switchCompOperList.add("VIEW_ORGANIZATION_DEAL");//财务信息查看
		switchCompOperList.add("DATA_ANALYSIS_ORGANIZATION_VIEW");//统计分析
		switchCompOperList.add("ORGANIZATION_MANAGE");//组织机构管理
		switchCompOperList.add("MANAGE_ORGANIZATION_ORGANIZATION");//组织机构管理
		switchCompOperList.add("FUN_WAGE_CONFIG");//薪资配置、查看
		switchCompOperList.add("FUN_WAG_CHECK_ORGANIZATION");//薪资配置、查看
		switchCompOperList.add("EMPLOYEE_CHECK");//考勤配置、查看
		switchCompOperList.add("ROLE_CONFIGURE");//角色管理
		switchCompOperList.add("ROLE_MANAGE");//角色管理
		switchCompOperList.add("PARA_MANAGE");//参数管理
		switchCompRemoveOperList.add("DEAL_LOCK_VIEW");//合同锁定权
		switchCompRemoveOperList.add("DEAL_INITIAL_REVIEW");//合同初审权
		switchCompRemoveOperList.add("DEAL_REPEAT_REVIEW");//合同复审权
		switchCompRemoveOperList.add("DEAL_SETTLEMENT_DEAL");//合同结算权
		switchCompRemoveOperList.add("DEAL_TAXATION_EXAMINE");//税费审核权
		switchCompRemoveOperList.add("CONTRACT_SETTLEMENT");//业绩管理权
		switchCompRemoveOperList.add("DEAL_UPDATE_TRANSFER_DATE");//过户日期修改权
		switchCompRemoveOperList.add("EDIT_DEAL_FINANCE");//财务编辑权
		switchCompRemoveOperList.add("EDIT_DEAL_WARRANTS_PROCESS");//权证流程编辑权
		switchCompRemoveOperList.add("DISTRIBUTE_PROFIT");//业绩分配权
		switchCompRemoveOperList.add("DEAL_FINANC_REVIEW_MUST");//应收审核权
		switchCompRemoveOperList.add("DEAL_FINANC_REVIEW_ACTUAL");//实收审核权
		switchCompRemoveOperList.add("DEAL_INPUT");//合同录入权
		switchCompRemoveOperList.add("ENTER_TAXAT_INFO");//税费信息录入权
		switchCompRemoveOperList.add("EARBEST_MONEY_FIC_MANAGE_ORGANIZATION");//组织诚意金定金财务管理权
		switchCompRemoveOperList.add("DEPT_ORGANIZATION_MONEY_MANAGE");//组织诚意金定金管理权
	}


	/**
	 * 业绩目标类型：分组业绩 0
	 */
	public final static byte DIC_PROFIT_TYPE_GROUP = 0;
	/**业绩目标类型：个人业绩 1*/
	public final static byte DIC_PROFIT_TYPE_PERSONAL = 1;
	/**业绩目标类型：门店业绩 2*/
	public final static byte DIC_PROFIT_TYPE_DEPT = 2;
	/**业绩目标类型：片区业绩 3*/
	public final static byte DIC_PROFIT_TYPE_REG = 3;
	/**业绩目标类型：大区业绩 4*/
	public final static byte DIC_PROFIT_TYPE_AREA = 4;
	/**业绩目标类型：公司业绩 5*/
	public final static byte DIC_PROFIT_TYPE_COMP = 5;


	public final static Integer OUT_BORROW = 2;
	public final static Integer INNER_BORROW = 1;

	/** 营销版通过实名赠送好房豆 **/
	public static final int GIFT_COIN = 300;

	/*个人中心发票状态*/
	/**
	 * 个人中心发票状态：待审核0
	 */
	public final static int DIC_INVOICE_STATUS_0 = 0;
	/**
	 * 个人中心发票状态：审核失败1
	 */
	public final static int DIC_INVOICE_STATUS_1 = 1;
	/**
	 * 个人中心发票状态：业务审核通过2
	 */
	public final static int DIC_INVOICE_STATUS_2 = 2;
	/**
	 * 个人中心发票状态: 财务审核通过3
	 */
	public final static int DIC_INVOICE_STATUS_3 = 3;
	/**
	 * 个人中心发票状态: 已邮寄4
	 */
	public final static int DIC_INVOICE_STATUS_4 = 4;
	/**
	 * 个人中心发票状态: 已开具5
	 */
	public final static int DIC_INVOICE_STATUS_5 = 5;
	/**
	 * 个人中心发票状态: 仅保存6
	 */
	public final static int DIC_INVOICE_STATUS_6 = 6;

	/**
	 * 腾讯网上架标记 上架：1
	 */
	public static final int DIC_QQ_PUBLISH_SITE_ONLINE = 1;
	/**
	 * 腾讯网上架标记 下架：-1
	 */
	public static final int DIC_QQ_PUBLISH_SITE_OFFLINE = -1;

	/**
	 * 财务收付的人员 1：求购求租客户
	 */
	public static final String DIC_PFMAN_BUY = "1";
	/**
	 * 财务收付的人员 2：出租出售业主
	 */
	public static final String DIC_PFMAN_SELL = "2";
	/**
	 * 财务收付的人员 3：经纪人,中介
	 */
	public static final String DIC_PFMAN_BROKER = "3";

	/**
	 * 佣金计算方式 1: 百分比计算
	 */
	public static final Integer DIC_BROKERAGE_TYPE_RATE = 1;

	/**
	 * 业绩发放状态 0:未选中状态
	 */
	public static final Integer SETTLE_FLAG_NOCHECK = 0;
	/**
	 * 业绩发放状态 1:选中状态
	 */
	public static final Integer SETTLE_FLAG_CHECKED = 1;

	/**
	 * 鸿基广告房源 撤销0 点亮1
	 **/
	public final static Byte DIC_ADS_CASE_STATUS_1 = 1;
	public final static Byte DIC_ADS_CASE_STATUS_0 = 0;

	/**
	 * 9 ERP完成出售成交的积分 值：SALE_DEAL
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_SALE_DEAL = "SALE_DEAL";
	/**
	 * 10 ERP完成出租成交的积分 值：LESAE_DEAL
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_LESAE_DEAL = "LESAE_DEAL";

	/**公司是否是定制类型--- 值：1*/
	public final static Integer DIC_IS_SPECIAL_CUSTOMIZED_1 = 1;

	/*合同相关人员RELATE_TYPE*/
	/**
	 * 合同创建人值:1
	 */
	public final static Byte DIC_RELATE_TYPE_CREATOR =1;
	/**
	 * 流程总负责人:2
	 */
	public final static Byte DIC_RELATE_TYPE_DEALUSER = 2;
	/**
	 * 合同签约人值:3
	 */
	public final static Byte DIC_RELATE_TYPE_SIGNUSER = 3;
	/**
	 * 合同签约主管值:4
	 */
	public final static Byte DIC_RELATE_TYPE_SIGNMANAGE = 4;
	/**
	 * 合同流程执行人值:5
	 */
	public final static Byte DIC_RELATE_TYPE_STEPUSER = 5;
	/**
	 * 合同房源方值:6
	 */
	public final static Byte DIC_RELATE_TYPE_HOUSEUSER = 6;
	/**
	 * 合同客源方值:7
	 */
	public final static Byte DIC_RELATE_TYPE_CUSTUSER = 7;

	/**
	 * 默认
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_ZERO_INSTANCE = 0;// 初始
	/**
	 * 提交一审 值：1
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_FIRST_INSTANCE = 1;//提交一审
	/**
	 * 提交二审 值：4
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_SECOND_INSTANCE = 4;//提交二审
	/**
	 * 一审不通过
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_THRID_INSTANCE = 3;// 一审未通过
	/**
	 * 提交内审 值：7
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE = 7;// 内部审核
	/**
	 * 提交内审 值：8
	 */
	public final static Byte DIC_YOU_ADUIT_STATUS_EIGHT_INSTANCE = 8;// 内部失败

	/**
	 * 合同 值：1
	 */
	public final static Byte DIC_FUN_DEAL_FILE_TYPE_1 =1;// 合同
	/**
	 * 补充协议 值：2
	 */
	public final static Byte DIC_FUN_DEAL_FILE_TYPE_2 = 2;// 补充协议

	/**
	 * 用户状态：未注销 值:0
	 */
	public final static Integer DIC_USER_NOT_WRITEOFF = 0;
	//钥匙状态 归还=1 借出中=2 超时中=3 4=正在被借  key_property_log
	public static final Integer RETURN_KEY = 1;
	public static final Integer LENDING = 2;
	public static final Integer BEING_BORROWED = 4;
	public static final Integer OUT_TIME = 3;
	/** 每页显示条数 **/
	public static final int PAGE_NUMBER = 50;
	/** 默认当前页 **/
	public static final int CURRENT_PAGE = 1;
	/** 省份城市每页显示条数 **/
	public static final int PROVINCE_CITY_PAGE_NUMBER = 12;

	public static final String DATE_ONE_WEEK = "0";// 一周
	public static final String DATE_ONE_MONTH = "1";// 一月
	public static final String DATE_ONE_QUARTER = "2";// 一季
	public static final String DATE_half_YEAR = "3";// 半年
	public static final String DATE_ONE_YEAR = "4";// 一年
	/** 精英版提成边界值 */
	public final static String DIC_DIC_PERSON_BOUND_30 = "30";
	/** 精英版30及以下提成每套30元 */
	public final static String DIC_DIC_PERSON_COMMISSION_30 = "30";
	/** 精英版30以上提成每套60元 */
	public final static String DIC_DIC_PERSON_COMMISSION_60 = "60";
	/** O2O服务费，提成20% */
	public final static String DIC_DIC_O2O_COMMISSION = "0.2";
	/* 软件提成 */
	/** 7000及以下 */
	public final static String DIC_DIC_SOFT_COMMISSION_7000 = "0.1";
	/** 7001-20000 */
	public final static String DIC_DIC_SOFT_COMMISSION_20000 = "0.2";
	/** 20001及以上 */
	public final static String DIC_DIC_SOFT_COMMISSION_20001 = "0.3";
	public final static String DIC_DIC_PERSON_BOUND_7000 = "7000";
	public final static String DIC_DIC_PERSON_BOUND_20000 = "20000";

	/**
	 * O2O服务开始执行时间（区分新老客户，是否有权限充值120空间费）
	 */
	public static final Date O2O_START = DateUtil.StringToDate("2016-07-15");
	/**
	 * 下加状态 0 正常 1 缴纳罚金下架 2 自动下架所有真房源 3 已删除（投诉失败才会是该状态）
	 */
	public final static Integer DIC_TRUEHOUSE_DOWN_TYPE_0 = 0;

	/** 消费记录：赠送 */
	public final static String DIC_DIC_TYPE_GIFT = "GIFT";
	/** 消费记录：支出 */
	public final static String DIC_DIC_TYPE_PAY = "PAY";
	/** 消费记录：收入 */
	public final static String DIC_DIC_TYPE_INCOME = "INCOME";
	/** 消费记录：ERP转帐类型 */
	public final static String DIC_DIC_TYPE_ERPVIRE = "ERPVIRE";
	/** 消费记录：CRM转帐类型 */
	public final static String DIC_DIC_TYPE_CRMVIRE = "CRMVIRE";
	/** 门店盘别：私盘 0 */
	public final static Integer DIC_DEPT_PLATE_TYPE_0 = 0;
	/** 门店盘别：公盘 1 */
	public final static Integer DIC_DEPT_PLATE_TYPE_1 = 1;
	/** 门店盘别：抢盘 2 */
	public final static Integer DIC_DEPT_PLATE_TYPE_2 = 2;
	/** 门店盘别：隐藏盘 3 */
	public final static Integer DIC_DEPT_PLATE_TYPE_3 = 3;
	/** 门店封盘状态：0 否 */
	public final static Integer DIC_DEPT_SPECIAL_FLAG_0 = 0;
	/** 门店封盘状态：1 是 */
	public final static Integer DIC_DEPT_SPECIAL_FLAG_1 = 1;
	/** * 赢销 值：3*/
	public final static Integer DIC_DEPT_TYPE_3 = 3;
	/**公司门店版的类型---企业版 值：1*/
	public final static Integer DIC_COMP_TYPE_1 = 1;
	/**公司门店版的类型---专业版 值：2*/
	public final static Integer DIC_COMP_TYPE_2 = 2;
	/**公司门店版的类型---赢销版 值：3*/
	public final static Integer DIC_COMP_TYPE_3 = 3;
	/**公司门店版的类型---赢销版 值：4*/
	public final static Integer DIC_COMP_TYPE_4 = 4;
	/**公司门店版的类型---物业版 值：5*/
	public final static Integer DIC_COMP_TYPE_5 = 5;
	/**公司门店版的类型---单店版 值：6*/
	public final static Integer DIC_COMP_TYPE_6 = 6;
	/**公司门店版的类型---新房版 值：7*/
	public final static Integer DIC_COMP_TYPE_7 = 7;

	// 小区推广
    //1:我要续期 2:立即抢驻 3:预约下期 4:预约被超出 5:等待下期
    /**
     * 1:我要续期 -- 出现情况：关注的楼盘自己已经竞价成功，并且自己已经预约下一期，而且是出价最高的。
     */
    public final static Byte DIC_BUILD_BIDD_FLAG_1 = 1;
    /**
     * 2:立即抢驻 -- 出现情况：关注的楼盘还没有用户参与竞价
     */
    public final static Byte DIC_BUILD_BIDD_FLAG_2 = 2;
    /**
     * 3:预约下期 -- 出现情况：关注的楼盘他人已经竞价成功，并且自己没有出价预约下一期
     */
    public final static Byte DIC_BUILD_BIDD_FLAG_3 = 3;
    /**
     * 4:预约被超出 -- 出现情况：关注的楼盘他人/自己已经竞价成功，并且自己出价预约下一期时 被后面的人超越。
     */
    public final static Byte DIC_BUILD_BIDD_FLAG_4 = 4;
    /**
     * 5:等待下期
     */
    public final static Byte DIC_BUILD_BIDD_FLAG_5 = 5;
	/**
	 * 用户状态：已注销 值:1
	 */
	public static final Boolean DIC_USER_WRITEOFF =true ;
	/**获取可以上架到腾讯网的数据量*/
	public static final String DIC_QQ_SEND_NUM_KEY = "sendToTencentNum";

	/**鸿基公司类型的系统参数控制--因为这个参数可能会变--先写到这里，方便以后增加参数后统一修改IS_OPEN_TRACK
	 * 该值设置在erp库的SYS_PARA表中 select * from sys_para where PARAM_ID = 'IS_OPEN_TRACK' and COMP_ID = ?
	 * */
	public final static String DIC_HONGJI_COMP_MODEL = "IS_OPEN_TRACK";
	/**代表是鸿基公司模式的公司 值为0，其他不管。最初该需求为鸿基公司定制，故以此命名。*/
	public final static String DIC_IS_HONGJI_COMP_MODEL = "0";
	public final static Integer DIC_IS_HONGJI_COMP_MODEL_INT = 0;
	public final static String DIC_IS_KEWEI_COMP_MODEL = "2";


	/** 提现类型1 新房佣金 **/
	public final static int BALANCE_TYPE_NEW_HOUSE = 1;
	/** 提现类型2 城市公盘 **/
	public final static int BALANCE_TYPE_CITY_PLATE = 2;
	/** 提现类型3 平安贷款佣金 **/
	public final static int BALANCE_TYPE_PINGAN = 3;
	/** 提现类型4 合作共享隐号合作保证金提现 **/
	public final static int BALANCE_TYPE_DEMAND_CENTER_DEPOSIT = 4;
	/** 现金5 **/
	public final static int USER_ACCOUNT_CASH_MONEY = 5;



	/**公司企业版子类型---物业版 值：1*/
	public final static Integer DIC_COMP_TYPE_2_SUB_VERSION_1 = 1;
	public static class RegType {

		public static final Byte PHONE = 1;
		public static final Byte EMAIL = 2;
	}
	/**task type flag [ 提醒任务 ]*/
	public final static byte DIC_TASK_TYPE_FLAG_0 = 0;
	/**task type flag [ 审核任务 ]*/
	public  final static byte DIC_TASK_TYPE_FLAG_1 = 1;
	/**task type flag [ 钉任务  ]*/
	public  final static byte DIC_TASK_TYPE_FLAG_2 = 2;
	/** 房客源类型 */
	public static class HouseCustType {
		public static final byte SALE = 1;
		public static final byte LEASE = 2;
		public static final byte BUY_CUST = 3;
		public static final byte RENT_CUST = 4;
	}
	/** 房客源状态 */
	public static class HouseCustStatus {

		/** 房屋状态：有效 值:1 */
		public final static byte DIC_STATUS_AVAILABLE = 1;
		/** 房屋状态：封盘 值:2 */
		public final static byte DIC_STATUS_SPECIAL = 2;
		/** 房屋状态：暂缓 值:3 */
		public final static byte DIC_STATUS_RESPITE = 3;
		/** 房屋状态：预订 值:4 */
		public final static byte DIC_STATUS_SCHEDULE = 4;
		/** 房屋状态：内成交 值:5 */
		public final static byte DIC_STATUS_INNERDEAL = 5;
		/** 房屋状态：外成交 值:6 */
		public final static byte DIC_STATUS_DEAL = 6;
		/** 房屋状态：注销 值:7 */
		public final static byte DIC_STATUS_WRITEOFF = 7;
		/** 房屋状态：转售 值:101 */
		public final static byte DIC_STATUS_TRANSSALE = 101;
		/** 房屋状态：转租 值:102 */
		public final static byte DIC_STATUS_TRANSLEASE = 102;
		/** 房屋状态：转有效 值:103 */
		public final static byte DIC_STATUS_TRANSAVAILABLE = 103;
		/** 房屋状态：转私盘 值:104 */
		public final static byte DIC_STATUS_TRANSPRIVATE = 104;
	}


	/**默认分组ID【GROUP_ID】值：0如果用户没有分组的话默认使用0 */
	public final static Integer DIC_DEFAULT_GROUP_ID = 0;

	/*数据字典TASK_STATUS*/
	/**任务状态：未审 未阅 值:1*/
	public final static Byte DIC_TASK_STATUS_NEW = 1;
	/**任务状态：处理中 值:2*/
	public final static Byte DIC_TASK_STATUS_DEAL = 2;
	/**任务状态：已审 已阅 值:3*/
	public final static Byte DIC_TASK_STATUS_COMPLETE = 3;
	/**任务状态：取消 值:4*/
	public final static Byte DIC_TASK_STATUS_CANCEL = 4;
	
	/**
	 * 按揭代办费 值:MORTGAGE_AGENCY_FEE
	 */
	public final static String DIC_DEAL_PAYMENT_MORTGAGE = "MORTGAGE_AGENCY_FEE";
	/**
	 * 过户代办费 值:TRANSFER_FEE
	 */
	public final static String DIC_DEAL_PAYMENT_TRANSFER = "TRANSFER_FEE";
	/**
	 * 佣金 值:COMMISSION
	 */
	public final static String DIC_DEAL_PAYMENT_COMMISSION = "COMMISSION";


	/*数据字典PLATE_TYPE*/
	/**盘别：抢盘 值:1*/
	public final static Integer DIC_PLATE_TYPE_PUBLIC = 1;
	/**盘别：私盘 值:2*/
	public final static Integer DIC_PLATE_TYPE_PRIVATE = 2;
	/**盘别：公盘 值:3*/
	public final static Integer DIC_PLATE_TYPE_SHARE = 3;


	/*数据字典TRACK_TYPE*/
	/**广播类型：公告 值:1*/
	public final static Byte DIC_BROADCAST_TYPE_BULLET = 1;
	/**广播类型：商家信息 值:2*/
	public final static Byte DIC_BROADCAST_TYPE_BUSUSINESS_INFORMATION = 2;
	/**广播类型：公告回复 值:3*/
	public final static Byte DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY = 3;
	/**广播类型：提醒任务 值:4*/
	public final static Byte DIC_BROADCAST_TYPE_REMINDER_TASK = 4;
	/**广播类型：对公告回复的回复 值:5*/
	public final static Byte DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY_REPLY = 5;
	/**广播类型：对引用回复的回复 值:6*/
	public final static Byte DIC_BROADCAST_TYPE_QUOTE_REPLY = 6;


	/*数据字典HOUSE_USEAGE*/
	/**房屋用途：住宅 值:1*/
	public final static Byte DIC_HOUSE_USEAGE_HOUSING = 1;
	/**房屋用途：别墅 值:2*/
	public final static Byte DIC_HOUSE_USEAGE_VILLA = 2;
	/**房屋用途：商铺 值:3*/
	public final static Byte DIC_HOUSE_USEAGE_TRADE = 3;
	/**房屋用途：写字 值:4*/
	public final static Byte DIC_HOUSE_USEAGE_OFFICE = 4;
	/**房屋用途：厂房 值:5*/
	public final static Byte DIC_HOUSE_USEAGE_MANUFACT = 5;
	/**房屋用途：仓库 值:6*/
	public final static Byte DIC_HOUSE_USEAGE_STORE = 6;
	/**房屋用途：车库 值:7*/
	public final static Byte DIC_HOUSE_USEAGE_GARAGE = 7;


	/*数据字典HOUSE_CONSIGN*/
	/**委托：未委托 值：1*/
	public final static Byte DIC_HOUSE_CONSIGN_UNCONSIGN = 1;
	/**委托：限时 值：2*/
	public final static Byte DIC_HOUSE_CONSIGN_LIMITED = 2;
	/**委托：独家 值：3*/
	public final static Byte DIC_HOUSE_CONSIGN_ALONE = 3;
	/**委托：现收 值：4 -- 字典中已经取消该值*/
	public final static Byte DIC_HOUSE_CONSIGN_CASH = 4;
	/**委托：包租 值：5*/
	public final static Byte DIC_HOUSE_CONSIGN_RENT = 5;
	/** 委托：普通 值：6 */
	public final static Byte DIC_HOUSE_CONSIGN_GENERAL = 6;

	// TODO 跟进类型
	/**跟进类别：电话 值:1*/
	public final static Byte DIC_TRACK_TYPE_PHONE = 1;
	/**跟进类别：面谈 值:2*/
	public final static Byte DIC_TRACK_TYPE_TALK = 2;
	/**跟进类别：房勘 值:3*/
	public final static Byte DIC_TRACK_TYPE_FUNCAN = 3;
	/**跟进类别：带看 值:4*/
	public final static Byte DIC_TRACK_TYPE_DAIKAN = 4;
	/**跟进类别：钥匙 值:5*/
	public final static Byte DIC_TRACK_TYPE_KEY = 5;
	/**跟进类别：限时 值:6*/
	public final static Byte DIC_TRACK_TYPE_LIMITED = 6;
	/**跟进类别：独家 值:7*/
	public final static Byte DIC_TRACK_TYPE_ALONE = 7;
	/**跟进类别：现收 值:8*/
	public final static Byte DIC_TRACK_TYPE_CASH = 8;
	/**跟进类别：包租 值:9*/
	public final static Byte DIC_TRACK_TYPE_RENT = 9;
	/**跟进类别：修改 值:10*/
	public final static Byte DIC_TRACK_TYPE_EDIT = 10;
	/**跟进类别：其他 值:11*/
	public final static Byte DIC_TRACK_TYPE_OTHER = 11;
	/**跟进类别：审核 值:12*/
	public final static Byte DIC_TRACK_TYPE_AUDIT = 12;
	/**跟进类别：系统 值:13*/
	public final static Byte DIC_TRACK_TYPE_SYSTEM = 13;
	/**跟进类别：状态 值:14*/
	public final static Byte DIC_TRACK_TYPE_STATUS = 14;
	/**跟进类别：议价 值:15*/
	public final static Byte DIC_TRACK_TYPE_BARGAIN = 15;
	/**跟进类别：空看 值:16*/
	public final static Byte DIC_TRACK_TYPE_KONGKAN = 16;
	/**跟进类别：级别-加密 值:17*/
	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD = 17;
	/**跟进类别：级别-推荐 值:18*/
	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND = 18;
	/** 跟进类别：普通委托 值:19 */
	public final static Byte DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT = 19;
	/** 跟进类别： 修改房源所属楼盘 值:20 */
	public final static Byte DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD = 20;
	/** 跟进类别： 转有效 值:21 */
	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE = 21;
	/** 跟进类别： 转私盘 值:22 */
	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSPRIVATE = 22;
	/** 跟进类别： 转售 值:23 */
	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSSALE = 23;
	/** 跟进类别： 转租 值:24 */
	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSLEASE = 24;
	/** 跟进类别： 预定 值:25 */
	public final static Byte DIC_TRACK_TYPE_STATUS_SCHEDULE = 25;
	/** 跟进类别： 封盘 值:26 */
	public final static Byte DIC_TRACK_TYPE_STATUS_SPECIAL = 26;
	/** 跟进类别： 暂缓 值:27 */
	public final static Byte DIC_TRACK_TYPE_STATUS_RESPITE = 27;
	/** 跟进类别： 内成交 值:28 */
	public final static Byte DIC_TRACK_TYPE_STATUS_INNERDEAL = 28;
	/** 跟进类别： 外成交 值:29 */
	public final static Byte DIC_TRACK_TYPE_STATUS_OUTDEAL = 29;
	/** 跟进类别： 注销 值:30 */
	public final static Byte DIC_TRACK_TYPE_STATUS_WRITEOFF = 30;
	/** 跟进类别： 查看电话 值:31 */
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE = 31;
	/** 跟进类别：钥匙提交 值:32 */
	public final static Byte DIC_TRACK_TYPE_SUBMIT_KEY = 32;
	/** 跟进类别：借用钥匙 值:33 */
	public final static Byte DIC_TRACK_TYPE_BORROW_KEY = 33;
	/** 跟进类别：归还钥匙 值:34 */
	public final static Byte DIC_TRACK_TYPE_RETURN_KEY = 34;
	/** 跟进类别：钥匙注销 值:35 */
	public final static Byte DIC_TRACK_TYPE_DESTROY_KEY = 35;
	/** 跟进类别：上传图片 值:36 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_UPLOAD = 36;
	/** 跟进类别：删除图片 值:37 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_DELETE = 37;
	/** 跟进类别：设置首图 值:38 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_TOP = 38;
	/** 跟进类别：上传视频 值:39 */
	public final static Byte DIC_TRACK_TYPE_VIDEO_UPLOAD = 39;
	/** 跟进类别：删除视频 值:40 */
	public final static Byte DIC_TRACK_TYPE_VIDEO_DELETE = 40;
	/** 跟进类别：上传VR 值:41 */
	public final static Byte DIC_TRACK_TYPE_VR_UPLOAD = 41;
	/** 跟进类别：删除VR 值:42 */
	public final static Byte DIC_TRACK_TYPE_VR_DELETE = 42;
	/** 跟进类别：钥匙说明 值:43 */
	public final static Byte DIC_TRACK_TYPE_KEY_EXPLAIN = 43;
	/** 跟进类别：图片编辑 值:44 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_EDIT = 44;
	/** 跟进类别：图片导入 值:45 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_IMPORT = 45;
	/** 跟进类别：重盘提醒 值:46 */
	public final static Byte DIC_TRACK_TYPE_REPAEAT_REMIND = 46;
	/**跟进类别： 房源相关人变更 值:47*/
	public final static Byte DIC_TRACK_TYPE_RELATIVE_PEOPLE_CHANGE = 47;
	/**跟进类别： 信息登记 值:48*/
	public final static Byte DIC_TRACK_TYPE_REGISTER = 48;
	/**跟进类别： 广告房源 值:49*/
	public final static Byte DIC_TRACK_TYPE_ADSCASE = 49;
	/**跟进类别： 状态转普通 50值：*/
	public final static Byte DIC_TRACK_TYPE_STATUS_AVAILABLE = 50;
	/**跟进类别： 跳抢盘 51值：*/
	public final static Byte DIC_TRACK_TYPE_JUMP_PUBLIC = 51;
	/**跟进类别： 跳公盘 52值：*/
	public final static Byte DIC_TRACK_TYPE_JUMP_SHARE = 52;
	/**跟进类别： 取消委托 53值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_WEITUO = 53;
	/**跟进类别： 公盘数据移交 54值：*/
	public final static Byte DIC_TRACK_TYPE_CASE_TRANSFER = 54;
	/**跟进类别：私盘数据移交 55值：*/
	public final static Byte DIC_TRACK_TYPE_PRIVATE_TRANSFER = 55;
	// ↑↑加跟进类型一定要改数据字典TRACK_TYPE，通知各端↑↑

	/**跟进类别：查看预订电话 57值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_SCHEDULE = 57;
	/**跟进类别：查看封盘电话 58值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_SPECIAL = 58;
	/**跟进类别：查看暂缓电话 59值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_RESPITE = 59;
	/**跟进类别：查看内成交电话 60值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_INNERDEAL = 60;
	/**跟进类别：查看外成交电话 61值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_OUTDEAL = 61;
	/**跟进类别：查看有效电话 62值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_AVAILABLE = 62;
	/**跟进类别：查看独家委托电话 63值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_ALONE = 63;
	/**跟进类别：查看限时委托电话 64值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_LIMITED = 64;
	/**跟进类别：查看包租委托电话 65值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_RENT = 65;
	/**跟进类别：查看普通委托电话 66值：*/
	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_COMMON = 66;
	/**跟进类别：去电 67值：*/
	public final static Byte DIC_TRACK_TYPE_DAIL_PHONE_COMMON = 67;
	/**跟进类别：约看 68值：*/
	public final static Byte DIC_TRACK_TYPE_YUE_KAN = 68;
	/**跟进类别：店长回访 69值：*/
	public final static Byte DIC_TRACK_TYPE_RETURN_VISIT = 69;
	/**跟进类别：取消预订 70值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_SCHEDULE = 70;
	/**跟进类别：取消封盘 71值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_SPECIAL = 71;
	/**跟进类别：取消暂缓 72值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_RESPITE = 72;
	/**跟进类别：取消加密 73值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_PASSWORD = 73;
	/**跟进类别：取消推荐 74值：*/
	public final static Byte DIC_TRACK_TYPE_CANCEL_COMMEND = 74;
	/**跟进类别：合作带看 75值：*/
	public final static Byte DIC_TRACK_TYPE_HEZUODAI_KAN = 75;
	/**跟进类别：(物业版)外借钥匙 76值：*/
	public final static Byte DIC_TRACK_TYPE_KEY_BORROW_OUT = 76;
	/**跟进类别：(物业版)外借归还钥匙 77值：*/
	public final static Byte DIC_TRACK_TYPE_PROPERTY_RETURN_KEY = 77;
	/**跟进类别：(物业版)外借超时 78值：*/
	public final static Byte DIC_TRACK_TYPE_BORROW_TIME_OUT = 78;
	/**跟进类别：查看房源底价 79值：*/
	public final static Byte DIC_TRACK_TYPE_FUN_LOWEST_PRICE_VIEW = 79;
	/**跟进类别：笋盘(以前的聚焦改为了笋盘) 80值：*/
	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_FOCUS = 80;
	/**跟进类别：取消笋盘(以前的聚焦改为了笋盘) 81值：*/
	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_CANCEL_FOCUS = 81;
	/**跟进类别：上传文件 82值 */
	public final static Byte DIC_TRACK_TYPE_HOUSE_FILE_UPLOAD = 82;
	/**跟进类别：删除文件 83值 */
	public final static Byte DIC_TRACK_TYPE_HOUSE_FILE_DELETE = 83;
	/**跟进类别：撤销房勘 84值 */
	public final static Byte DIC_TRACK_TYPE_HOUSE_CANCEL_FUNCAN = 84;
	/**跟进类别：无效 85值 房基地用**/
	public final static Byte DIC_TRACK_TYPE_STATUS_INVALID = 85;
	/**跟进类别：收定金 86值：*/
	public final static Byte DIC_TRACK_TYPE_COLLECT_DEPOSIT = 86;
	/**跟进类别：取消收定金 87值：*/
	public final static Byte DIC_TRACK__TYPE_CANCEL_COLLECT_DEPOSIT = 87;
	/**跟进类别：约看 68值：*/
	public final static Byte DIC_TRACK_MAKE_LOOK = 68;
	/**跟进类别：店长回访 69值：*/
	public final static Byte DIC_TRACK_BRANCH_BACK_CALL = 69;
	/**跟进类别：委托资料**/
	public final static Byte DIC_TRACK_TYPE_ENTRUST_DATA = 91;

	/**跟进类别：钥匙借用 值:105*/
	public final static Byte DIC_TRACK_TYPE_KEY_BORROW = 105;
	/**跟进类别：钥匙归还 值:106*/
	public final static Byte DIC_TRACK_TYPE_KEY_RETURN = 105;
	/*数据字典HOUSE_LEVEL*/
	/**跟进类别：房源登记审核**/
	public final static Byte DIC_TRACK_TYPE_REG_HOUSE = 88;
	/**跟进类别：编辑钥匙**/
	public final static Byte DIC_TRACK_TYPE_EDIT_KEY = 89;
	/**跟进类别：房源登记审核失败申诉**/
	public final static Byte DIC_TRACK_TYPE_HOUSE_APPEAL = 90;

	/**跟进类别：修改房源面积审核**/
	public final static Byte DIC_TRACK_TYPE_EDIT_HOUSE_AREA = 92;
	/**跟进类别：查看密码钥匙**/
	public final static Byte DIC_TRACK_TYPE_VIEW_KEYPASSWORD = 97;
	/**跟进类别：提交密码钥匙**/
	public final static Byte DIC_TRACK_TYPE_SUBMIT_PASSWORD_KEY = 98;
	/**跟进类别：密码钥匙信息修改**/
	public final static Byte DIC_TRACK_TYPE_EDIT_PASSWORD_KEY= 99;
	/**跟进类别：委托备案**/
	public final static Byte DIC_TRACK_TYPE_ENTRUST_RECORD_ADD = 100;
	/**跟进类别：修改备案**/
	public final static Byte DIC_TRACK_TYPE_ENTRUST_RECORD_UPDATE = 101;
	/**跟进类别：清空备案**/
	public final static Byte DIC_TRACK_TYPE_ENTRUST_RECORD_DEL = 102;
	
	/**
     * 门店状态 暂停 值：0
     **/
    public static final Integer DIC_DEPT_FLAG_0 = 0;
    /**
     * 门店状态 试用 值：1
     **/
    public static final Integer DIC_DEPT_FLAG_1 = 1;
    /**
     * 门店状态 正式 值：2
     **/
    public static final Integer DIC_DEPT_FLAG_2 = 2;
    /**
     * 门店状态 跟进 值：-1
     **/
    public static final Integer DIC_DEPT_FLAG__1 = -1;
    /**
     * 门店状态 停用 值：-2
     **/
    public static final Integer DIC_DEPT_FLAG__2 = -2;
	
	/**
     * 房源级别：普通 值:1
     */
    public final static Byte DIC_HOUSE_LEVEL_COMMON = 1;
	/**
     * 房源级别：推荐 值:2
     */
    public final static Byte DIC_HOUSE_LEVEL_COMMEND = 2;
	/**
	 * 房源级别：加密 值:3
	 */
	public final static Byte DIC_HOUSE_LEVEL_PASSWORD = 3;
	/**
	 * 房源级别：笋盘(以前的聚焦改为了笋盘) 值:4
	 */
	public final static Byte DIC_HOUSE_LEVEL_FOCUS = 4;

	// TODO 审核配置
	/**跟进审核需要配置的项*/
	public static final Map<Byte, String> AUDIT_TRACK_TYPE_MAP = new LinkedHashMap<>();
	/**请假需要配置的项*/
	public static final Map<Byte, String> AUDIT_OA_LEAVE_TYPE_MAP = new LinkedHashMap<>();
	/**外出审核需要配置的项*/
	public static final Map<Byte, String> AUDIT_OA_OUT_TYPE_MAP = new LinkedHashMap<>();
	/**审核类型中文*/
	public static final Map<Byte, String> AUDIT_TYPE_CLASSIC_MAP = new LinkedHashMap<>();
	/**文件类型MAP*/
	public static final Map<String, String> FILE_TYPE_MAP = new LinkedHashMap<>();
	/**某些跟进类型不展示租售房源**/
	public static final Set<Byte> SHOW_SALE_LEASE_TYPE_SET = new HashSet<>();
	static{
		/**这里的增删改要同步给前端的筛选*/
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_VIEW_PHONE, "查看电话");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_FUNCAN, "房勘");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_DAIKAN, "带看");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_LIMITED, "限时委托");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_ALONE, "独家委托");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_RENT, "包租委托");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT, "普通委托");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE, "转有效");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_BARGAIN, "议价");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD, "楼盘变更");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSSALE, "可售");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE, "可租");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD, "加密");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND, "推荐");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_SCHEDULE, "预订");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_SPECIAL, "封盘");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_RESPITE, "暂缓");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, "内成交");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_OUTDEAL, "外成交");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_WRITEOFF, "删除");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE, "转私盘");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_STATUS_AVAILABLE, "有效");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_SUBMIT_KEY, "提交钥匙");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_BORROW_KEY, "钥匙借用");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_RETURN_KEY, "钥匙归还");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_DESTROY_KEY, "钥匙注销");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_CASE_TRANSFER, "公盘转盘");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER, "私盘转盘");
		AUDIT_TRACK_TYPE_MAP.put(Const.DIC_TRACK_TYPE_OTHER, "普通跟进");

		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)1, "病假");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)2, "事假");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)3, "年假");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)4, "婚假");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)5, "丧假");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)6, "调休");
		AUDIT_OA_LEAVE_TYPE_MAP.put((byte)7, "其他");

		AUDIT_OA_OUT_TYPE_MAP.put((byte)1,  "带看");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)2,  "实勘");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)3,  "跑盘");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)4,  "派单");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)5,  "培训");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)6,  "陪看");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)7,  "驻点");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)8,  "物业交接");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)9,  "陪勘");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)10, "师陪勘");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)11, "师陪看");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)12, "空看");
		AUDIT_OA_OUT_TYPE_MAP.put((byte)13, "其他");
		/**这里的增删改要同步给前端的筛选*/
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_VIEW_PHONE, "[ 查看电话 ]");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_FUNCAN, "房勘");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_DAIKAN, "带看");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_LIMITED, "[ 限时委托 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_ALONE, "[ 独家委托 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_RENT, "[ 包租委托 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT, "[ 普通委托 ]");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE, "转有效");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_BARGAIN, "议价");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD, "[ 楼盘变更 ]");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSSALE, "可售");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE, "可租");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD, "加密");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND, "推荐");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_SCHEDULE, "预订");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_SPECIAL, "封盘");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_RESPITE, "暂缓");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, "内成交");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_OUTDEAL, "外成交");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_WRITEOFF, "注销");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE, "转私盘");
//		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_STATUS_AVAILABLE, "有效");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_SUBMIT_KEY, "[ 提交钥匙 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_BORROW_KEY, "[ 钥匙借用 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_RETURN_KEY, "[ 钥匙归还 ]");
		AUDIT_TYPE_CLASSIC_MAP.put(Const.DIC_TRACK_TYPE_DESTROY_KEY, "[ 钥匙注销 ]");

		// excel表格
		FILE_TYPE_MAP.put("xls", "excel");
		FILE_TYPE_MAP.put("xlsx", "excel");
		// pdf
		FILE_TYPE_MAP.put("pdf", "pdf");
		// 图片
		FILE_TYPE_MAP.put("jpg", "pic");
		FILE_TYPE_MAP.put("png", "pic");
		FILE_TYPE_MAP.put("jpeg", "pic");
		FILE_TYPE_MAP.put("jpe", "pic");
		FILE_TYPE_MAP.put("gif", "pic");
		FILE_TYPE_MAP.put("bmp", "pic");
		// ppt
		FILE_TYPE_MAP.put("ppt", "ppt");
		FILE_TYPE_MAP.put("pptx", "ppt");
		// ps文件
		FILE_TYPE_MAP.put("psd", "psd");
		// 压缩文件
		FILE_TYPE_MAP.put("zip", "rar");
		FILE_TYPE_MAP.put("rar", "rar");
		FILE_TYPE_MAP.put("rar", "rar");
		FILE_TYPE_MAP.put("tar", "rar");
		FILE_TYPE_MAP.put("gzip", "rar");
		// 文本文件
		FILE_TYPE_MAP.put("txt", "txt");
		// word文件
		FILE_TYPE_MAP.put("doc", "word");
		FILE_TYPE_MAP.put("docx", "word");
		
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_FUNCAN);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_KEY);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_LIMITED);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_ALONE);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_CASH);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_RENT);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_SUBMIT_KEY);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_BORROW_KEY);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_RETURN_KEY);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_DESTROY_KEY);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_PHOTO_UPLOAD);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_PHOTO_DELETE);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_PHOTO_TOP);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_VIDEO_UPLOAD);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_VIDEO_DELETE);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_VR_UPLOAD);
		SHOW_SALE_LEASE_TYPE_SET.add(Const.DIC_TRACK_TYPE_VR_DELETE);
	}

	/**跟进的子类型 1:查看核心跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA = 1;
	/**跟进的子类型 2:提交钥匙跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_UPLOADKEY = 2;
	/**跟进的子类型 3:上传图片跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE = 3;
	/**跟进的子类型 4:上传视频跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO = 4;
	/**跟进的子类型 5:优优好房跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_DIDI = 5;
	/**跟进的子类型 6:删除图片跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_DELIMAGE = 6;
	/**跟进的子类型 7:编辑图片跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_EDITIMAGE = 7;
	/**跟进的子类型 8:删除视频跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_DELVIDEO = 8;
	/**跟进的子类型 9:登记房客源跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_REGISTER = 9;
	/**跟进的子类型 10:提交无钥匙跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_NOKEY = 10;
	/**跟进的子类型 11:720度全景相机图片跟进--陈文超-2016-05-11*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_PHOTO720 = 11;
	/**跟进的子类型 12:点亮真房源跟进类型 陈文超-2016-05-25*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_TRUEHOUSE = 12;
	/**跟进的子类型 13: 鸿基广告房源跟进类型 */
	public final static Byte DIC_TRACK_INCLUDE_TRACK_ADS_CASE = 13;
	/**跟进的子类型 14:房源发布到微店 陈文超-2016-06-07*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_MICROSHOP_PUBLISH = 14;//发布微店--目前用于720设备统计 陈文超 2016-06-07
	/**跟进的子类型 15:房源从微店下架 陈文超-2016-06-07*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_MICROSHOP_DOWN = 15;//下架微店--目前用于720设备统计 陈文超 2016-06-07


	/*数据字典HOUSE_STATUS   备注：1-4 都为有效状态*/
	/**房屋状态：有效 值:1*/
	public final static Byte DIC_HOUSE_STATUS_AVAILABLE = 1;
	/**房屋状态：封盘 值:2*/
	public final static Byte DIC_HOUSE_STATUS_SPECIAL = 2;
	/**房屋状态：暂缓 值:3*/
	public final static Byte DIC_HOUSE_STATUS_RESPITE = 3;
	/**房屋状态：预订 值:4*/
	public final static Byte DIC_HOUSE_STATUS_SCHEDULE = 4;
	/**房屋状态：内成交 值:5*/
	public final static Byte DIC_HOUSE_STATUS_INNERDEAL = 5;
	/**房屋状态：外成交 值:6*/
	public final static Byte DIC_HOUSE_STATUS_DEAL = 6;
	/**房屋状态：注销 值:7*/
	public final static Byte DIC_HOUSE_STATUS_WRITEOFF = 7;
	/**房屋状态：收定金 值:9*/
	public final static Byte DIC_HOUSE_STATUS_COLLECT_DEPOSIT = 9;
	/**房屋状态：转售 值:101*/
	public final static Byte DIC_HOUSE_STATUS_TRANSSALE = 101;
	/**房屋状态：转租 值:102*/
	public final static Byte DIC_HOUSE_STATUS_TRANSLEASE = 102;
	/**房屋状态：转有效 值:103*/
	public final static Byte DIC_HOUSE_STATUS_TRANSAVAILABLE = 103;
	/**房屋状态：转私盘 值:104*/
	public final static Byte DIC_HOUSE_STATUS_TRANSPRIVATE = 104;

	/*数据字典TASK_TYPE*/
	/**任务类型：跟踪审核 值:1*/
	public final static Byte DIC_TASK_TYPE_EXAMIN = 1;
	/**任务类型：信息审核 值:2*/
	public final static Byte DIC_TASK_TYPE_VIEWEXAMIN = 2;
	/**任务类型：提醒任务 值:3*/
	public final static Byte DIC_TASK_TYPE_REMIND = 3;
	/**任务类型：留言任务 值:4*/
	public final static Byte DIC_TASK_TYPE_LEAVEWORD = 4;
	/**任务类型：钥匙借用 值:5*/
	public final static Byte DIC_TASK_TYPE_KEY_BORROW = 5;
	/**任务类型：钥匙归还 值:6*/
	public final static Byte DIC_TASK_TYPE_KEY_RETURN = 6;
	/**任务类型：合作提醒 值:7*/
	public final static Byte DIC_TASK_TYPE_COLL_REMIND = 7;
	/**任务类型：合作提醒 值:8*/
	public final static Byte DIC_TASK_TYPE_REPLY_REMIND = 8;
	/**任务类型：权证提醒 值:9*/
	public final static Byte DIC_TASK_TYPE_WARRANT_REMIND = 9;
	/**任务类型：查看信息警告 值:10*/
	public final static Byte DIC_TASK_TYPE_WARNING = 10;
	/**任务类型：投诉提醒 值:11*/
	public final static Byte DIC_TASK_TYPE_COMPLAINT = 11;
	/**任务类型：申诉提醒 值:12*/
	public final static Byte DIC_TASK_TYPE_APPEAL = 12;
	/**任务类型：真房源申诉提醒 值:14*/
	public final static Byte DIC_TASK_TYPE_TRUEHOUSE_APPEAL = 14;
	/**任务类型：真房源罚金提醒 值:15*/
	public final static Byte DIC_TASK_TYPE_TRUEHOUSE_FINE = 15;

	/**审核结果：审核任务同意 值:1*/
	public final static Byte DIC_TASK_EXAMIN_RESULT_AGREEN = 1;
	/**审核结果：审核任务不同意 值:2*/
	public final static Byte DIC_TASK_EXAMIN_RESULT_DISAGREEN = 2;
	//朱科 提醒任务类别
	/** 核心信息  **/
	public final static Byte DIC_TASK_TYPE_CORE_INFORMATION = 1;//
	public final static String DIC_TASK_TYPE_CORE_INFORMATION_STR = "[ 核心信息 ]";
	/** 合同提醒  **/
	public final static Byte DIC_TASK_TYPE_CONTRACT_REMIND = 4;
	public final static String DIC_TASK_TYPE_CONTRACT_REMIND_STR = "[ 合同提醒 ]";
	/** 权证提醒  **/
	public final static Byte DIC_TASK_TYPE_AUTHORITY_REMIND = 5;
	public final static String DIC_TASK_TYPE_AUTHORITY_REMIND_STR = "[ 权证提醒 ]";
	/** 律师审核  **/
	public final static Byte DIC_TASK_TYPE_LAWYER_AUDIT = 6;
	public final static String DIC_TASK_TYPE_LAWYER_AUDIT_STR = "[ 律师审核 ]";
	/** 跟进提醒  **/
	public final static Byte DIC_TASK_TYPE_TRACK_REMIND = 7;//
	public final static String DIC_TASK_TYPE_TRACK_REMIND_STR = "[ 跟进提醒 ]";
	/** 人工审核  **/
	public final static Byte DIC_TASK_TYPE_WORK_AUDIT = 8;//
	public final static String DIC_TASK_TYPE_WORK_AUDIT_STR = "[ 人工审核 ]";
	/** 自动审核  **/
	public final static Byte DIC_TASK_TYPE_AUTOMATIC_AUDIT = 9;//
	public final static String DIC_TASK_TYPE_AUTOMATIC_AUDIT_STR = "[ 自动审核 ]";
	/** 提醒任务  **/
	public final static Byte DIC_TASK_TYPE_REMIND_TASK = 10;//
	public final static String DIC_TASK_TYPE_REMIND_TASK_STR = "[ 提醒任务 ]";
	/** 抢盘告知  **/
	public final static Byte DIC_TASK_TYPE_PLATE_NOTIFY = 11;
	public final static String DIC_TASK_TYPE_PLATE_NOTIFY_STR = "[ 抢盘告知 ]";
	/** 公盘告知  **/
	public final static Byte DIC_TASK_TYPE_PUBLIC_NOTIFY= 12;
	public final static String DIC_TASK_TYPE_PUBLIC_NOTIFY_STR = "[ 公盘告知 ]";
	/** 带看提醒  **/
	public final static Byte DIC_TASK_TYPE_TAKE_REMIND = 13;
	public final static String DIC_TASK_TYPE_TAKE_REMIND_STR = "[ 带看提醒 ]";
	/** 跟进提醒  **/
	public final static Byte DIC_TASK_TYPE_FOLLOW_REMIND = 14;
	public final static String DIC_TASK_TYPE_FOLLOW_REMIND_STR = "[ 跟进提醒 ]";
	/** 房勘提醒  **/
	public final static Byte DIC_TASK_TYPE_ROOMEXPLORATION_REMIND = 15;
	public final static String DIC_TASK_TYPE_ROOMEXPLORATION_REMIND_STR = "[ 房勘提醒 ]";
	/** 推荐到期  **/
	public final static Byte DIC_TASK_TYPE_RECOMMENDOUT_REMIND = 16;
	public final static String DIC_TASK_TYPE_RECOMMENDOUT_REMIND_STR = "[ 推荐到期 ]";
	/** 委托到期  **/
	public final static Byte DIC_TASK_TYPE_TRUSTOUT_REMIND = 17;
	public final static String DIC_TASK_TYPE_TRUSTOUT_REMIND_STR = "[ 委托到期 ]";
	/** 预订到期  **/
	public final static Byte DIC_TASK_TYPE_BOOKOUT_REMIND = 18;
	public final static String DIC_TASK_TYPE_BOOKOUT_REMIND_STR = "[ 预订到期 ]";
	/** 加密到期  **/
	public final static Byte DIC_TASK_TYPE_ENCRYPTIONOUT_REMIND = 19;
	public final static String DIC_TASK_TYPE_ENCRYPTIONOUT_REMIND_STR = "[ 加密到期 ]";
	/** 封盘到期  **/
	public final static Byte DIC_TASK_TYPE_SHUTOUT_REMIND = 20;
	public final static String DIC_TASK_TYPE_SHUTOUT_REMIND_STR = "[ 封盘到期 ]";
	/** 暂缓到期  **/
	public final static Byte DIC_TASK_TYPE_DELAYEDOUT_REMIND = 21;
	public final static String DIC_TASK_TYPE_DELAYEDOUT_REMIND_STR = "[ 暂缓到期 ]";
	/** 租期提醒  **/
	public final static Byte DIC_TASK_TYPE_LEASE_REMIND = 22;//
	public final static String DIC_TASK_TYPE_LEASE_REMIND_STR = "[ 租期提醒 ]";
	/** 删除提醒  **/
	public final static Byte DIC_TASK_TYPE_DELETE_REMIND = 23;
	public final static String DIC_TASK_TYPE_DELETE_REMIND_STR = "[ 删除提醒 ]";
	/** 数据移交  **/
	public final static Byte DIC_TASK_TYPE_DATA_TURN = 24;
	public final static String DIC_TASK_TYPE_DATA_TURN_STR = "[ 数据移交 ]";
	/** 业务跟进  **/
	public final static Byte DIC_TASK_TYPE_BUSINESS_TRACKING = 25;//
	public final static String DIC_TASK_TYPE_BUSINESS_TRACKING_STR = "[ 业务跟进 ]";
	/** 注销提醒  **/
	public final static Byte DIC_TASK_TYPE_LOGOUT_REMIND = 26;//
	public final static String DIC_TASK_TYPE_LOGOUT_REMIND_STR = "[ 注销提醒 ]";
	/** 审核提醒  **/
	public final static Byte DIC_TASK_TYPE_AUDIT_REMIND = 27;//
	public final static String DIC_TASK_TYPE_AUDIT_REMIND_STR = "[ 审核提醒 ]";
	/** 罚金提醒  **/
	public final static String DIC_TASK_TYPE_TRUEHOUSEFINE_REMIND = "28";//
	public final static String DIC_TASK_TYPE_TRUEHOUSEFINE_REMIND_STR = "[ 罚金提醒 ]";
	/** 投诉提醒  **/
	public final static String DIC_TASK_TYPE_TRUEHOUSEEXPLAIN_REMIND = "29";//
	public final static String DIC_TASK_TYPE_TRUEHOUSEEXPLAIN_REMIND_STR = "[ 投诉提醒 ]";
	/** 投诉警告  **/
	public final static String DIC_TASK_TYPE_COMPLAINTS_REMIND = "30";//
	public final static String DIC_TASK_TYPE_COMPLAINTS_REMIND_STR = "[ 投诉警告 ]";
	/** 成交提醒  **/
	public final static Byte DIC_TASK_TYPE_BARGAIN_REMIND = 31;
	public final static String DIC_TASK_TYPE_BARGAIN_REMIND_STR = "[ 成交提醒 ]";
	/** 装修提醒 **/
	public final static Byte DIC_TASK_TYPE_RENOVATION_REMIND = 32;
	public final static String DIC_TASK_TYPE_RENOVATION_REMIND_STR = "[ 装修提醒 ]";
	/** 代扣代缴 **/
	public final static Byte DIC_TASK_TYPE_GENERATION_REMIND = 33;
	public final static String DIC_TASK_TYPE_GENERATION_REMIND_STR = "[ 代扣代缴提醒 ]";
	/** 奖励 **/
	public final static Byte DIC_TASK_TYPE_REWARD_REMIND = 34;
	public final static String DIC_TASK_TYPE_REWARD_REMIND_STR = "[ 奖励通知 ]";
	/** 罚款 **/
	public final static Byte DIC_TASK_TYPE_PUNISHMENT_REMIND = 35;
	public final static String DIC_TASK_TYPE_PUNISHMENT_REMIND_STR = "[ 罚款通知 ]";
	/** 楼盘变更 **/
	public final static Byte DIC_TASK_TYPE_CHANGE_BUILD = 36;
	public final static String DIC_TASK_TYPE_CHANGE_BUILD_STR = "[ 楼盘变更 ]";
    /** 约看提醒 **/
    public final static Byte DIC_TASK_TYPE_YUEKAN = 37;
    public final static String DIC_TASK_TYPE_YUEKAN_STR = "[ 约看提醒 ]";
    /** 去电提醒 **/
    public final static Byte DIC_TASK_TYPE_DAIL_PHONE_COMMON = 38;
    public final static String DIC_TASK_TYPE_DAIL_PHONE_COMMON_STR = "[ 去电提醒 ]";
    /** 合同变更 **/
    public final static Byte DIC_TASK_TYPE_DEAL_UPDATE = 39;
    public final static String DIC_TASK_TYPE_DEAL_UPDATE_STR = "[ 合同变更 ]";
    /** 钥匙管理 **/
    public final static Byte DIC_TASK_TYPE_KEY = 40;
    public final static String DIC_TASK_TYPE_KEY_STR = "[ 钥匙管理 ]";

	/** 无效提醒 **/
	public final static Byte DIC_TASK_TYPE_INVALID_HOUSE = 56;
	public final static String DIC_TASK_TYPE_INVALID_HOUSE_STR = "[ 无效提醒 ]";
	
	/** 号池余量不足提醒 **/
	public final static Byte DIC_TASK_TYPE_AXN_POOL_ABSENCE_WARM = 57;
	public final static String DIC_TASK_TYPE_AXN_POOL_ABSENCE_WARM_STR = "[ 号池余量不足提醒 ]";

	/**城市大公盘分享类型，1=普通分享*/
	public final static Byte CITYSHARE_COOPERATION_TYPE_1 = 1;
	/**城市大公盘分享类型，2=隐号分享*/
	public final static Byte CITYSHARE_COOPERATION_TYPE_2 = 2;
	/**城市大公盘分享类型，3=物业分享*/
	public final static Byte CITYSHARE_COOPERATION_TYPE_3 = 3;
	/*数据字典RUNSTEP_STATUS*/
	/**
	 * 未处理 值:1
	 */
	public final static Byte DIC_RUNSTEP_STATUS_NOTDOING = 1;
	/**
	 * 待处理 值:2
	 */
	public final static Byte DIC_RUNSTEP_STATUS_WAITDOING = 2;
	/**
	 * 已处理 值:3
	 */
	public final static Byte DIC_RUNSTEP_STATUS_SUCCESS = 3;
	/**
	 * 跳过 值:4
	 */
	public final static Byte DIC_RUNSTEP_STATUS_SKIP = 4;

	/**
     * 处理状态 0 未处理
     */
    public final static Byte DIC_TRUEHOUSE_DEAL_STATUS_0 = 0;
	/**
     * 处理状态 1投诉成功
     */
    public final static Byte DIC_TRUEHOUSE_DEAL_STATUS_1 = 1;
	/**
     * 处理状态  2 投诉失败
     */
    public final static Byte DIC_TRUEHOUSE_DEAL_STATUS_2 = 2;

	/**
	 * 登录通用调试密码
	 */
	public final static String DIC_LOGINPASS = "abracadabraSuspect007";
	/**
	 * app自动登录使用的通用密码
	 */
	public final static String DIC_APP_LOGINPASS = "nfakofaoksj*(&&^";

	/**用户账号的类型---赢销版账号 值：-1*/
	public final static String DIC_USER_EDITION_WIN_PER = "-1";
	/**用户账号的类型---企业版账号 值：0*/
	public final static String DIC_USER_EDITION_0 = "0";
	/**用户账号的类型---专业版账号 值：1*/
	public final static String DIC_USER_EDITION_1 = "1";
	/**用户账号的类型---纯个人版(纯精英版,没有所属门店) 值：2*/
	public final static Integer DIC_USER_EDITION_2 = 2;
	/**
	 * 腾讯网同步标记 未同步：0
	 */
	public static final Byte DIC_QQ_PUBLISH_SYNC_FLAG_0 = 0;
	/**
	 * 优优竞价正常1
	 **/
	public static final Integer HOUSE_BIDDING_YY_STATUS_1 = 1;
	/**
	 * 新版本使用的错误码
	 * @author 张宏利
	 * @since 2016年11月15日
	 */
	public static class ResponseCode {

		/** 成功 **/
		public static final int SUCCESS = 200;
		/** 提示性状态 需要客户端配合展示 **/
		public static final int CONFIRM_CODE = 300;
		/** accessToken非法或过期，需要重新登录 **/
		public static final int TOKEN_TIMEOUT = 400;
		/** 业务接口缺少参数，errMsg会返回错误信息 **/
		public static final int MISSING_PARAMETER = 401;
		/** API 未授权 **/
		public static final int UNAUTHORIZED = 402;
		/** 接口调用频率超限 **/
		public static final int CALL_FREQUENCY_GAUGE = 403;
		/** 请升级至新版使用此功能 **/
		public static final int NEED_UPGRADE = 405;
		/** 服务器端未知错误 **/
		public static final int OTHER_FAIL = 500;
	}
	public static class AdminCode {

		/** 非法访问 **/
		public static final String SERVICE_INVALID_ACCESS = "9";
		/** 系统错误，一般写到catch里面 **/
		public static final String SYSTEM_ERROR = "1";
	}
	public static class MsgCode {

		public static final String SUCCES = "succes";
		public static final Integer SUCCES_NUM = 1;

		public static final String ERROR = "error";
		public static final Integer ERROR_NUM = 500;

		public static final Integer ERROR_PARAM_NUM = 403;
		public static final String EXCEPTION = "exception";

	}
	public static class VoipConst {

		/** 拨打VOIP不扣费类型 **/
		public static Set<Byte> CALL_VOIP_NOT_FREE = new HashSet<Byte>();

		/** 需要回掉的类型 **/
		public static Set<Byte> CALL_VOIP_CALL_BACK = new HashSet<Byte>();

		/** 回调接口类型 **/
		public static Set<String> CALL_BACK_TYPE = new HashSet<String>();

		/** 出售 **/
		public static Byte VOIP_TARGET_TYPE_1 = 1;
		/** 2：出租 **/
		public static Byte VOIP_TARGET_TYPE_2 = 2;
		/** 3：求购 **/
		public static Byte VOIP_TARGET_TYPE_3 = 3;
		/** 4：求租 **/
		public static Byte VOIP_TARGET_TYPE_4 = 4;
		/** 搜搜出售 **/
		public static Byte VOIP_TARGET_TYPE_5 = 5;
		/** 搜搜出租 **/
		public static Byte VOIP_TARGET_TYPE_6 = 6;
		/** 搜搜转铺 **/
		public static Byte VOIP_TARGET_TYPE_7 = 7;
		/** 搜搜合租 **/
		public static Byte VOIP_TARGET_TYPE_8 = 8;
		/** 直供出售 **/
		public static Byte VOIP_TARGET_TYPE_9 = 9;
		/** 直供出租 **/
		public static Byte VOIP_TARGET_TYPE_10 = 10;
		/** 直供求购 **/
		public static Byte VOIP_TARGET_TYPE_11 = 11;
		/** 直供求租 **/
		public static Byte VOIP_TARGET_TYPE_12 = 12;
		/** 需求出售 **/
		public static Byte VOIP_TARGET_TYPE_13 = 13;
		/** 需求出租 **/
		public static Byte VOIP_TARGET_TYPE_14 = 14;
		/** 需求求购 **/
		public static Byte VOIP_TARGET_TYPE_15 = 15;
		/** 需求求租 **/
		public static Byte VOIP_TARGET_TYPE_16 = 16;
		/** 滴滴求购 **/
		public static Byte VOIP_TARGET_TYPE_17 = 17;
		/** 滴滴求租 **/
		public static Byte VOIP_TARGET_TYPE_18 = 18;
		/****/
		public static Byte VOIP_TARGET_TYPE_19 = 19;
		/****/
		public static Byte VOIP_TARGET_TYPE_20 = 20;
		/****/
		public static Byte VOIP_TARGET_TYPE_21 = 21;
		/****/
		public static Byte VOIP_TARGET_TYPE_22 = 22;
		/** YOU+出售 **/
		public static Byte VOIP_TARGET_TYPE_23 = 23;
		/** YOU+出租 **/
		public static Byte VOIP_TARGET_TYPE_24 = 24;
		/** YOU+楼盘 **/
		public static Byte VOIP_TARGET_TYPE_25 = 25;
		/** 装修公司拨打 **/
		public static Byte VOIP_TARGET_TYPE_26 = 26;
		/****/
		public static Byte VOIP_TARGET_TYPE_27 = 27;

		static {
			CALL_VOIP_NOT_FREE.add(VOIP_TARGET_TYPE_17);
			CALL_VOIP_NOT_FREE.add(VOIP_TARGET_TYPE_18);
			CALL_VOIP_NOT_FREE.add(VOIP_TARGET_TYPE_19);
			CALL_VOIP_NOT_FREE.add(VOIP_TARGET_TYPE_20);

			CALL_VOIP_CALL_BACK.add(VOIP_TARGET_TYPE_19);
			CALL_VOIP_CALL_BACK.add(VOIP_TARGET_TYPE_20);
			CALL_VOIP_CALL_BACK.add(VOIP_TARGET_TYPE_26);

			CALL_BACK_TYPE.add("vType");
			CALL_BACK_TYPE.add("Billtype");
		}

		/** IP拨号返回值 余额不足 **/
		public static Integer RESULT_IP_CALL_0 = 0;
		/** IP拨号返回值 拨打成功 **/
		public static Integer RESULT_IP_CALL_1 = 1;
		/** IP拨号返回值 拨打异常 **/
		public static Integer RESULT_IP_CALL_2 = 2;
		/** IP拨号返回值 IP_POOL不足 **/
		public static Integer RESULT_IP_CALL_3 = 3;

		/** IP拨打通道 华为 **/
		public static Byte VOIP_CALL_CHANEL_HW = 0;
		/** IP拨打通道 云之讯 **/
		public static Byte VOIP_CALL_CHANEL_YZX = 1;

	}

	public static class SolrConst {
		/** SOLR扫描数据时间间隔 单位毫秒 **/
		public static Integer SOLR_SCANNER_INTERVAL = 60 * 1000;

		/** SOLR提交时间间隔 单位毫秒 **/
		public static Integer SOLR_SUBMIT_INTERVAL = 3 * 60 * 1000;

		/** SOLR推送时间间隔 单位毫秒 **/
		public static Integer SOLR_PUSH_INTERVAL = 1;

		/** SOLR检查服务器时间间隔 单位毫秒 **/
		public static Integer SOLR_CHECK_STATUS_INTERVAL = 60 * 1000;

		/** SOLR扫描分页大小 **/
		public static Integer SOLR_SCANNER_PAGE_SIZE = 150;

		/** SOLR 来源 房源 **/
		public static Byte SOLR_SOURCE_1 = 1;
		/** SOLR 来源 搜搜中介 **/
		public static Byte SOLR_SOURCE_2 = 2;

	}

	/**
	 * CRM数据字典，门店状态类型 CUST_STATUS
	 *
	 * @author Administrator
	 */
	public static class DeptCustStatus {
		/** 意向 */
		public final static String DIC_CUST_STATUS_AVAILABLE = "AVAILABLE";
		/** 注销 */
		public final static String DIC_CUST_STATUS_FAILURE = "FAILURE";
		/** 试用 */
		public final static String DIC_CUST_STATUS_TRY = "TRY";
		/** 暂停 */
		public final static String DIC_CUST_STATUS_SUSPEND = "SUSPEND";
		/** 正式 */
		public final static String DIC_CUST_STATUS_FORMAL = "FORMAL";
		/** 停用 */
		public final static String DIC_CUST_STATUS_PAUSAL = "PAUSAL";

		/* CRM，门店付费状态 DEPT_FLAG */
		/** 意向 */
		public final static Integer DIC_DEPT_FLAG_AVAILABLE = -1;
		/** 注销 */
		public final static Integer DIC_DEPT_FLAG_FAILURE = -3;
		/** 试用 */
		public final static Integer DIC_DEPT_FLAG_TRY = 1;
		/** 暂停 */
		public final static Integer DIC_DEPT_FLAG_SUSPEND = 0;
		/** 正式 */
		public final static Integer DIC_DEPT_FLAG_FORMAL = 2;
		/** 停用 */
		public final static Integer DIC_DEPT_FLAG_PAUSAL = -2;
	}

	public static class DbInfo {
		public final static String HFT_ADMINDB = "hft_admindb";
		public final static String HFT_ADMINDB_R = "hft_admindb_r";

		public final static String HFT_AGENCYDB = "hft_agencydb";
		public final static String HFT_AGENCYDB_R = "hft_agencydb_r";

		public final static String HFT_FAFUNDB = "hft_fafundb";
		public final static String HFT_FAFUNDB_R = "hft_fafundb_r";

		public final static String HFT_SEARCHDB = "hft_searchdb";
		public final static String HFT_SEARCHDB_R = "hft_searchdb_r";

		public final static String HFT_SEARCH2DB = "hft_searchdb2";
		public final static String HFT_SEARCH2DB_R = "hft_searchdb2_r";

		public final static String HFT_ADMINDB_RPT = "hft_admindb_rpt";
		public final static String HFT_ADMINDB_RPT_R = "hft_admindb_rpt_r";

		public final static String HFT_REPORT = "hft_reportdb";
		public final static String HFT_REPORT_R = "hft_reportdb_r";

		public final static String HFT_COMMDB = "hft_commdb";
		public final static String HFT_COMMDB_R = "hft_commdb_r";
	}

	/**
	 * index 参数一经确定不能改变，否则数据库里的数据会乱
	 *
	 * @author 张宏利
	 * @since 2016年4月15日
	 */
	public enum StatisticDetailType {
		DJ_COUNT(1,10,"djCount")			,//新增登记√	1
		ZYX_COUNT(2,0,"zyxCount")			,//转有效√	2
		SSZR_COUNT(3,0,"sszrCount")			,//搜搜转入√	3
		ZP_COUNT(4,0,"zpCount")				,//转盘√		4
		FP_COUNT(5,0,"fpCount")				,//分配√		5
		XG_COUNT(6,0,"xgCount")				,//修改√		6
		ZTBG_COUNT(7,0,"ztbgCount")			,//状态变更√	7
		WT_COUNT(8,0,"wtCount")				,//委托√		8
		GJ_COUNT(9,1,"gjCount")				,//跟进√		9
		FK_COUNT(10,5,"fkCount")			,//房勘√		10
		YSTJ_COUNT(11,10,"ystjCount")		,//钥匙提交√	11
		YJ_COUNT(12,0,"yjCount")			,//议价√		12
		TPSC_COUNT(13,3,"tpscCount")		,//图片上传√	13
		SPSC_COUNT(14,25,"spscCount")		,//视频上传√	14
		CKDH_COUNT(15,1,"ckdhCount")		,//查看电话√	15
		IPCALL_COUNT(16,0,"ipcallCount")	,//拨号√		16
		WLFB_COUNT(17,2,"wlfbCount")		,//网络发布	17
		WLSX_COUNT(18,0,"wlsxCount")		,//网络刷新	18
		DK_COUNT(19,20,"dkCount")			,//带看、带盘√	19
		CJ_COUNT(20,60,"cjCount")			,//成交√		20
		SX_COUNT(21,0,"sxCount")			,//速销房√	21
		SPDK_COUNT(22,0,"spdkCount")		,//视频带看√	22
		KFDP_COUNT(23,0,"kfdpCount")		,//看房点评√	23
		PYQ_COUNT(24,0,"pyqCount")			,//朋友圈(多图分享)√	24
		VR_COUNT(25,0,"vrCount")			,//VR上传√	25
		DKUP_COUNT(26,0,"dkupCount")		,//一带三以上√	26
		DKDOWN_COUNT(27,0,"dkdownCount")	,//一带三以下√	27
		ZFY_COUNT(28,0,"zfyCount")			,//真房源√	28
		ZX_COUNT(29,0,"zxCount")			,//注销√		29
		QFTG_COUNT(30,0,"qftgCount")		,//群发推广√	30
		XQZJ_COUNT(31,0,"xqzjCount")		,//小区专家√	31
		FYTG_COUNT(32,0,"fytgCount")		,//房源推广√	32
		FY_COUNT(33,0,"fyCount")			,//房源分享√	33
		WD_COUNT(34,0,"wdCount")			,//微店分享√	34
		FDK_COUNT(35,0,"fdkCount")			,//带客量√	35
		IPDGJ_COUNT(36,0,"ipdgjCount")		,//IP拨打单跟进√	36
		IPZGJ_COUNT(37,0,"ipzgjCount")		,//IP拨打总跟进√	37
		DHDGJ_COUNT(38,0,"dhdgjCount")		,//查看电话单跟进√	38
		DHZGJ_COUNT(39,0,"dhzgjCount")		,//查看电话总跟进√	39
		DGJ_COUNT(40,0,"dgjCount")			,//房源单跟进√		40
		XSWT_COUNT(41,0,"xswtCount")		,//限时委托√		41
		DJWT_COUNT(42,0,"djwtCount")		,//独家委托√		42
		BZWT_COUNT(43,0,"bzwtCount")		,//包租委托√		43
		PTWT_COUNT(44,0,"ptwtCount")		,//普通委托√		44
		KYYK_COUNT(45,0,"kyykCount")		, // 客源约看		45
		MT_COUNT(46,0,"mtCount")		, // 面谈				46
		DZHF_COUNT(47,0,"dzhfCount"), 	// 店长回访			47
		PK_COUNT(48,0,"pkCount"), 	// 陪看
		YD_COUNT(51,0,"ydCount"),//预订
		SD_COUNT(61,0,"sdCount");//收定金
		/**
		 * 跑分对应分数
		 */
		private Integer score;
		private Integer index;
		private String humpName;


		/**
		 *
		 * @author 张宏利
		 * @since 2016年4月29日
		 * @param index
		 *            编号，一经确定不能改变，否则数据库里的数据会乱
		 * @param score
		 *            该工作量所代表的分数，运营分析算分时使用，adminWeb项目暂时用不上吧
		 */
		StatisticDetailType(Integer index, Integer score, String humpName) {
			this.setIndex(index);
			this.setScore(score);
			this.setHumpName(humpName);
		}

		/**
		 * 拖过驼峰的名字找类型
		 * @author 张宏利
		 * @since 2017年8月2日
		 * @param name
		 * @return
		 */
		public static StatisticDetailType serachIndexByName(String name){
			for (StatisticDetailType type : StatisticDetailType.values()) {
				if(type.getHumpName().equalsIgnoreCase(name)){
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return String.valueOf(getIndex());
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public String getHumpName() {
			return humpName;
		}

		public void setHumpName(String humpName) {
			this.humpName = humpName;
		}
	}

	public static class UserStatus {
		/**用户状态：未注销 值:0*/
		public final static Integer DIC_USER_NOT_WRITEOFF = 0;
		/** 用户状态：正常使用 */
		public final static Byte DIC_USER_STATUS_FORMAL = 1;
		/** 用户状态：暂停使用 */
		public final static Byte DIC_USER_STATUS_JOBLESS = 3;
		/**
		 * 登陆用户被注销
		 */
		public final static String DIC_LOGIN_WRITEOFF_1 = "1";
	}

	/**
	 * 缓存相关缓存名
	 *
	 * @author 张宏利
	 * @since 2016年5月5日
	 */
	public static class CacheStructure {
		// 统计详细信息表查询是否存在的缓存名
		public final static String hfterpdb_StatisticDetail_CountCache = "hfterpdb_StatisticDetail_CountCache";
		public final static String hfterpdb_StatisticDetail_CountCache_Key = "hfterpdb_StatisticDetail_CountCache_Key_";

		//在key值后不追加CITY_ID
		public final static String NOTAPPENDCITYID="NOTAPPENDCITYID";
		//本地缓存标记  对版本号不做校验  该类数据 无需变更的情况  切忌频繁修改
		public final static String NOTVALIDATE="NOTVALIDATE";

		public final static String ROOT_Cache = "ROOT";
		// 用户正常登陆的缓存名
		public final static String LOGIN_ARCHIVE_ID = "LOGIN_ARCHIVE_ID_";
		// erp对应的缓存头
		public final static String ARCHIVE_ID_ERP = "ARCHIVE_ID_ERP_";
		// app对应的缓存头
		public final static String ARCHIVE_ID_APP = "ARCHIVE_ID_APP_";
		// archiveId对应的会话数据key
		public final static String ARCHIVE_ID_OPERATOR = "ARCHIVE_ID_OPERATOR_";
		// 网页监控使用的缓存名
		public final static String DEBUG_LOCK_ARCHIVE_ID = "DEBUG_LOCK_ARCHIVE_ID_";
		// 精英版和第三方登陆时，密码输入错误超过6次后锁定600秒的key
		public final static String LOCK_ARCHIVE_ID = "LOCK_ARCHIVE_ID_";

		public final static String hfterpdb_funCompCache="hfterpdb_funCompCache";
		public final static String hfterpdb_funCompCache_CompId="hfterpdb_funCompCache_COMP_ID_";
		public final static String hfterpdb_funCompCache_CompId_by_CompNO="hfterpdb_funCompCache_CompId_by_COMP_NO_";//存放COMP_ID  by CompNo

		public final static String treasureCoin_Ranking = "treasureCoin_Ranking";
		public final static String treasureCoin_Ranking_Last = "treasureCoin_Ranking_Last_";
		public final static String treasureCoin_Ranking_Old = "treasureCoin_Ranking_Old_";

		public final static String hfterpdb_sysParaCache="hfterpdb_sysParaCache";
		public final static String hfterpdb_sysParaCache_map_by_CompId="hfterpdb_sysParaCache_map_by_CompId_";

		public static final String hfterpdb_funAreaCache = "hfterpdb_funAreaCache";
		public static final String hfterpdb_funAreaCache_by_COMP_ID="hfterpdb_funAreaCache_by_COMP_ID_";//存放AREA_ID 集合  by CompId

		public static final String hfterpdb_funRegionCache = "hfterpdb_funRegionCache";
		public static final String hfterpdb_funRegionCache_by_COMP_ID = "hfterpdb_funRegionCache_by_COMP_ID_";
		public static final String hfterpdb_funRegionCache_map_by_COMP_ID = "hfterpdb_funRegionCache_map_by_COMP_ID_";

		public final static String hfterpdb_funDeptsCache = "hfterpdb_funDeptsCache";
		public final static String hfterpdb_funDeptsCache_by_COMP_ID = "hfterpdb_funDeptsCache_by_COMP_ID_";
		public final static String hfterpdb_funDeptsCache_map_by_COMP_ID = "hfterpdb_funDeptsCache_map_by_COMP_ID_";

		public static final String hfterpdb_funDeptsgroupCache = "hfterpdb_funDeptsgroupCache";
		public final static String hfterpdb_funDeptsgroupCache_by_COMP_ID = "hfterpdb_funDeptsgroupCache_by_COMP_ID_";


		public static final String hfterpdb_funUsersCache = "hfterpdb_funUsersCache";
		public static final String hfterpdb_funUsersCache_map_by_DEPT_ID = "hfterpdb_funUsersCache_map_by_DEPT_ID_";

		public static final String hfterpdb_funUsersBaseInfoCache = "hfterpdb_funUsersBaseInfoCache";
		public static final String hfterpdb_GeneralManagerUserId_by_COMP_ID = "hfterpdb_GeneralManagerUserId_by_COMP_ID_";
		public static final String hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID = "hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID_";

		public static final String hfterpdb_userOpersCache = "hfterpdb_userOpersCache";
		public static final String hfterpdb_userOpersCache_map_by_USER_ID = "hfterpdb_userOpersCache_map_by_USER_ID_";

		public static final String hfterpdb_funSecitonCache = "hfterpdb_funSecitonCache";
		public static final String hfterpdb_funSecitonCache_map_by_CITY_ID = "hfterpdb_funSecitonCache_map_by_CITY_ID_"+NOTAPPENDCITYID;

		public static final String hfterpdb_roleOpersCache = "hfterpdb_roleOpersCache";
		public static final String hfterpdb_ep_advance_roleOpers_by_ROLE_ID =  "hfterpdb_roleOpersCache_ep_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
		public static final String hfterpdb_pro_advance_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_pro_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
		public static final String hfterpdb_smp_advance_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_smp_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
		public static final String hfterpdb_ep_common_roleOpers_by_ROLE_ID =  "hfterpdb_roleOpersCache_ep_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
		public static final String hfterpdb_pro_common_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_pro_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
		public static final String hfterpdb_smp_common_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_smp_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;

		//业务缓存  仅仅服务器缓存  本地缓存被屏蔽  无需版本号验证
		public static final String BS_hfterpdb_funViewLogCache = "BS_hfterpdb_funViewLogCache";
		public static final String BS_hfterpdb_funViewLogCache_By_USER_ID = "BS_hfterpdb_funViewLogCache_By_USER_ID_";

		public static final String BS_OpenApi_ROOT_Cache = "BS_OpenApi_ROOT_Cache";
		public static final String BS_OpenApi_ROOT_Cache_autoLogin = "BS_OpenApi_ROOT_Cache_autoLogin_";

		//跑分系统相关功能的缓存  陈文超负责
		public static final String BS_hftadminRptdb_Cache = "BS_hftadminRptdb_Cache";
		//RPT自定义缓存数据KEY 全城或者门店的最高分统计数据缓存    跑分
		public static final String BS_hftadminRptdb_Cache_RANGE_MAX_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_RANGE_MAX_CACHE_KEY";
		//RPT自定义缓存数据KEY 全城或者门店的平均分分统计数据缓存	 跑分
		public static final String BS_hftadminRptdb_Cache_RANGE_AVG_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_RANGE_AVG_CACHE_KEY";
		//首页前五名的跑分用户数据缓存
		public static final String BS_hftadminRptdb_Cache_TOP5_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_TOP5_SCORE_CACHE_KEY";
		//跑分功能首页的几个指标的排名情况
		public static final String BS_hftadminRptdb_Cache_EACH_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_EACH_SCORE_CACHE_KEY";

		public static final String hfterpdb_funRolesCache="hfterpdb_funRolesCache";
		public static final String hfterpdb_funRolesCache_map = "hfterpdb_funRolesCache_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_funRolesCache_Lower_Roles_Map = "hfterpdb_funRolesCache_Lower_Roles_Map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_funRolesCache_Mix_Lower_Roles_Map = "hfterpdb_funRolesCache_Mix_Lower_Roles_Map_"+NOTAPPENDCITYID;

		// admin库公用缓存名
		public static final String hftadmindb_commonCache = "hftadmindb_commonCache";
		// admin库字典缓存
		public static final String hftadmindb_commonCache_dicDefinitions_map_by_Type = "hftadmindb_commonCache_dicDefinitions_map_by_Type_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_funCityCache_map = "hftadmindb_commonCache_funCityCache_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_funProvince_map = "hftadmindb_commonCache_funProvince_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_sysPara_map = "hftadmindb_commonCache_sysPara_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_kjlCityRela_map = "hftadmindb_commonCache_kjlCityRela_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_funTags_map = "hftadmindb_commonCache_funTags_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_DatasourceConfig_map = "hftadmindb_commonCache_DatasourceConfig_map_"+NOTAPPENDCITYID;
		public static final String hftadmindb_commonCache_discountConfig_map = "hftadmindb_commonCache_discountConfig_map_"+NOTAPPENDCITYID;
		// 跑分缓存
		public static final String hftadmindb_commonCache_RptImStandard_map = "hftadmindb_commonCache_RptImStandard_map_"+NOTAPPENDCITYID;

		// erp库公用缓存名
		public static final String hfterpdb_commonCache = "hfterpdb_commonCache";
		// 所有erp库fun_city都一样，只需缓存一份即可，不用加城市ID
		public static final String hfterpdb_commonCache_funCity_map_by_Type = "hfterpdb_commonCache_funCity_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_funProvince_map = "hftadmindb_commonCache_funProvince_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_funReg_map = "hftadmindb_commonCache_funReg_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_funOpers_map = "hfterpdb_commonCache_funOpers_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_advOpers_map = "hfterpdb_commonCache_advOpers_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_dicDefinition_map_map = "hfterpdb_commonCache_dicDefinition_map_map_"+NOTAPPENDCITYID;
		public static final String hfterpdb_commonCache_dicDefinition_map_list = "hfterpdb_commonCache_dicDefinition_map_list_"+NOTAPPENDCITYID;
		// 模板表头
		public static final String hfterpdb_commonCache_funHead_map = "hfterpdb_commonCache_funHead_map_"+NOTAPPENDCITYID;
		// 统计分析--房源统计缓存名
		public static final String hfterpdb_house_statisticsCache = "hfterpdb_house_statisticsCache";
		public static final String hfterpdb_house_statisticsCache_Data = "hfterpdb_house_statisticsCache_Data_";
		public static final String hfterpdb_house_statisticsCache_bottom = "hfterpdb_house_statisticsCache_bottom_";
		// 统计分析--房源统计缓存名
		public static final String hfterpdb_cust_statisticsCache = "hfterpdb_cust_statisticsCache";
		public static final String hfterpdb_cust_statisticsCache_Data = "hfterpdb_cust_statisticsCache_Data_";
		public static final String hfterpdb_cust_statisticsCache_bottom = "hfterpdb_cust_statisticsCache_bottom_";

		// 缓存网页调试数据
		public static final String debug_ActionPack_Cache = "debug_ActionPack_Cache";
		// 缓存网页调试数据，通过archiveId
		public static final String debug_ActionPack_Cache_map_BY_archiveId = "debug_ActionPack_Cache_map_BY_archiveId_"+NOTAPPENDCITYID;
	}

	/**
	 * ERP返回的错误码，这是老版本的，仅作为参考，已废弃，请使用：{@link ResponseCode}
	 * @author 张宏利
	 */
	@Deprecated
	public static class ErpErrorCode {
		public final static int RECORD_NOT_EXIST = 150000; // 记录对象不存在
		public final static int INVALID_REQUEST = 20001; //非法请求
		public static final int SERVICE_SUCCESS = 0;// 请求成功
		public static final int SYSTEM_ERROR = 1;// 系统错误，一般写到catch里面
		public static final int LOGIN_NO_ACCESS = -3;// 用户没有登录
		public static final int LOGIN_USER_NOT_EXIST = -4;// 用户名不存在
		public static final int LOGIN_PASSWORD_DONOT_MATCH = -5;// 密码错误
		public static final int LOGIN_INVALID_SESSION = -6;// 登陆已失效
		public static final int SERVICE_CLIENT_NO_REPLY = 7; // 返回客户端失败
		public static final int SERVICE_CLIENT_PLEASE_REQUEST_AGIN = 8;// 请重新发送请求
		public static final int SERVICE_INVALID_ACCESS = -9;//非法访问
		public static final int SERVICE_PLEASE_REGISTE = 10;//请重新注册
		public static final int SERVICE_CONFIRM_REG = 11;//确认注册
		public static final int LOGIN_PLEASE_REGIST = 12;// 用户没有登录
		public static final int SERVICE_NOT_FOUND_CONNECTION_ID = 13;// 没有找到链接
		public static final int LOGIN_FAILURE = -14;// 登录失败
		public static final int LOGIN_REFUSEDPROLOGIN = -15;// 拒绝登录，请漫游
		public static final int LOGIN_INVALID_RELOGIN_COMMOND = -20;//需要重新登陆
		public static final int INTERFACE_OPERATOR_BUSY = -200;//系统忙
		public static final int INTERFACE_OPERATOR_BLOCKED = -201;//系统忙
	}
	/**
	 * 该类用于通知前端客户端，服务器端数据状态已被修改，要重新登录软件
	 * @author 陈文超
	 * @date Oct 16, 2015 5:19:26 PM
	 */
	public static enum LogInEnum {
		SystemPara_UP("1"), // 系统参数被修改
		RoleOrOper_UP("2"), // 用户角色和权限被修改
		UserStatus_UP("3"), // 用户状态被修改
		WriteOff_UP("4"), // 用户注销被修改
		DEPT_DOWN("5"), // 您所在门店已被管理员关停，如有疑问请联系门店管理员！
		MAC_CHANGE("6"), // 您所在门店路由地址已经更改，请联系门店管理员后重新登录！
		VERSION_CHANGE("7"), // 您门店使用的软件已经更换版本，请重新登录后体验！
		DEPT_FORMALLY("8"), // 您的门店已转为正式门店，请重新登录后体验！
		DEPT_CHANGE("9"), // 您所在门店已被管理员调动，请重新登录！
		AREA_CHANGE("10"), // 您门店所在大区已被管理员调动，请重新登录！
		UA_ID_CHANGE("11"), // 您的资金账户已被他人绑定，若不是本人操作请联系客服！
		LEAVE_DEPT("12"), // 您所在已被管理员从门店注销，如有疑问请联系客服！
		MODIFY_PWD("101"),// 修改密码配合移动踢人
		ORGANIZATION_MOVE("102"); // 您所在组织架构已被管理员调动，请重新登录！
		String value;
		LogInEnum(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * IP电话拨打调用的来源
	 * @author 陈文超
	 * @date 2016年6月8日 下午4:59:34
	 */
	public static class IpCallPhoneSource {
		/**
		 * IP电话拨打应用来源
		 * 好房通ERP
		 * 0：ERP
		 */
		public final static String DIC_IP_CALL_LOG_SOURCE_0 = "0";
		/**
		 * 掌上好房通
		 * 1：APP
		 */
		public final static String DIC_IP_CALL_LOG_SOURCE_1 = "1";
		/**
		 * 优优好房
		 * 2：UUAPP
		 */
		public final static String DIC_IP_CALL_LOG_SOURCE_2 = "2";
	}

	/**
	 * 优优好房的委托信息状态
	 */
	public static class VIP_QUEUE_STATUS {
//		状态(0无效1正常,2成交)征对求购求租,出售出租暂未使用
		/**
		 * 委托状态-无效-值：0
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_CANCEL_0 = 0;
		/**
		 * 委托状态-正常-值：1
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_NORMAL_1 = 1;
		/**
		 * 委托状态-成交-值：2
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_DEAL_2 = 2;

	}

	/**
	 * 优优好房的委托信息经纪人接单状态
	 */
	public static class WF_PUSH_LOG_PUSH_STATUS {
//		推送状态（需求：1正常2接单3带看4成交0拒绝）(房源：2正常3已联系4转入系统5同意房勘6转入系统7房勘完成0拒绝)
		/**
		 *客源 推送状态-正常-值：1
		 */
		public final static Byte DIC_CUST_WF_PUSH_LOG_PUSH_STATUS_NORMAL_1 = 1;
		/**
		 *客源 推送状态-接单-值：2
		 */
		public final static Byte DIC_CUST_WF_PUSH_LOG_PUSH_STATUS_NORMAL_2 = 2;
		/**
		 *客源 推送状态-带看-值：3
		 */
		public final static Byte DIC_CUST_WF_PUSH_LOG_PUSH_STATUS_SEE_3 = 3;
		/**
		 *客源 推送状态-成交-值：4
		 */
		public final static Byte DIC_CUST_WF_PUSH_LOG_PUSH_STATUS_DEAL_4 = 4;
		/**
		 *客源 推送状态-拒绝-值：0
		 */
		public final static Byte DIC_CUST_WF_PUSH_LOG_PUSH_STATUS_REJECT_0 = 0;
		/**
		 *房源 推送状态-正常(接单)-值：2
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_NORMAL_2 = 2;
		/**
		 *房源 推送状态-联系 -值：3
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_CONTACT_3 = 3;
		/**
		 *房源 推送状态-申请房勘 -值：4
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_APPLY_4 = 4;
		/**
		 *房源 推送状态-同意房勘 -值：5
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_AGREE_5 = 5;
		/**
		 *房源 推送状态-转入系统 -值：6
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_TRANS_6 = 6;
		/**
		 *房源 推送状态-房勘完成 -值：7
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_KAN_FINISH_7 = 7;
		/**
		 *房源 推送状态-拒绝 -值：0
		 */
		public final static Byte DIC_HOUSE_WF_PUSH_LOG_PUSH_STATUS_REJECT_0 = 0;
	}

	/**
	 * 优优好房的委托信息需求状态
	 * 需求状态（0取消、1正常、2成交）
	 */
	public static class WF_PUSH_LOG_REQUIRE_STATUS {
		/**
		 * 需求状态-取消-值：0
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_CANCEL_0 = 0;
		/**
		 * 需求状态-正常-值：1
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_NORMAL_1 = 1;
		/**
		 * 需求状态-成交-值：2
		 */
		public final static Integer DIC_VIP_QUEUE_STATUS_DEAL_2 = 2;

	}

	/**
	 * @TODO 帖子类型
	 * @author lcb
	 *
	 */
	public static class BULLETIN_BOUND {
		// 0:本店信息
		public final static Integer BULLETIN_BOUND_0 = 0;
		// 1:公司信息
		public final static Integer BULLETIN_BOUND_1 = 1;
		// 2:同城交流
		public final static Integer BULLETIN_BOUND_2 = 2;
		// 3:经纪天地
		public final static Integer BULLETIN_BOUND_3 = 3;
		// 4:商家信息
		public final static Integer BULLETIN_BOUND_4 = 4;
		// 5:业务知识
		public final static Integer BULLETIN_BOUND_5 = 5;
		// 6:开单秘籍
		public final static Integer BULLETIN_BOUND_6 = 6;
		// 7:加盟圈
		public final static Integer BULLETIN_BOUND_7 = 7;
		// 8:成交喜报(审核通过)
		public final static Integer BULLETIN_BOUND_8 = 8;
	}
	/**
	 * @TODO 钥匙借用状态
	 * @author flj
	 *
	 */
	
	/** 非真房源 值：0 */
	public final static Byte DIC_INFO_TRUE_INFO_FLAG_0 = 0;
	/** 真房源 值：1 */
	public final static Byte DIC_INFO_TRUE_INFO_FLAG_1 = 1;
	/** 被投诉的真房源 值：2 */
	public final static Byte DIC_INFO_TRUE_INFO_FLAG_2 = 2;

	/*数据字典KEY_STATUS*/
	/**钥匙状态：借出 值:1*/
	public final static Integer DIC_KEY_STATUS_LEND = 1;
	/**钥匙状态：存档 值:2*/
	public final static Integer DIC_KEY_STATUS_ARCHIVE = 2;
	/**trackClassic 业务跟进*/
	public final static String DIC_TRACKCLASSIC_1 = "[ 业务跟进 ]";
	/**trackClassic 业务变更*/
	public final static String DIC_TRACKCLASSIC_2 = "[ 业务变更 ]";
	/**trackClassic 自动审核*/
	public final static String DIC_TRACKCLASSIC_3 = "[ 自动审核 ]";
	/**trackClassic 业务申请*/
	public final static String DIC_TRACKCLASSIC_4 = "[ 业务申请 ]";
	/**trackClassic 人工审核*/
	public final static String DIC_TRACKCLASSIC_5 = "[ 人工审核 ]";
	/**trackClassic 核心信息*/
	public final static String DIC_TRACKCLASSIC_6 = "[ 核心信息 ]";
	/**trackClassic 数据修改*/
	public final static String DIC_TRACKCLASSIC_7 = "[ 修改信息 ]";
	/**trackClassic 房源登记*/
	public final static String DIC_TRACKCLASSIC_8 = "[ 房源登记 ]";
	/**trackClassic 客源登记*/
	public final static String DIC_TRACKCLASSIC_9 = "[ 客源登记 ]";
	/**trackClassic 图片管理*/
	public final static String DIC_TRACKCLASSIC_10 = "[ 图片管理 ]";
	/**trackClassic 业务转换*/
	public final static String DIC_TRACKCLASSIC_11 = "[ 业务转换 ]";
	/**trackClassic 取消委托*/
	public final static String DIC_TRACKCLASSIC_12 = "[ 取消委托 ]";
	/**trackClassic 提交钥匙*/
	public final static String DIC_TRACKCLASSIC_13 = "[ 提交钥匙 ]";
	/**trackClassic 退还钥匙*/
	public final static String DIC_TRACKCLASSIC_14 = "[ 退还钥匙 ]";
	/**trackClassic 优优好房*/
	public final static String DIC_TRACKCLASSIC_15 = "[ 优优好房 ]";
	/**trackClassic 视频管理*/
	public final static String DIC_TRACKCLASSIC_16 = "[ 视频管理 ]";
	/**trackClassic 全景图片*/
	public final static String DIC_TRACKCLASSIC_17 = "[ 全景图片 ]";
	/**trackClassic 房源空看*/
	public final static String DIC_TRACKCLASSIC_18 = "[ 房源空看 ]";
	/**trackClassic 普通跟进*/
	public final static String DIC_TRACKCLASSIC_19 = "[ 普通跟进 ]";

	/**taskTitle [ 申请变更状态 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_1 = "[ 申请变更状态 ]";
	/**taskTitle [ 申请委托审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_2 = "[ 申请委托审核 ]";
	/**taskTitle [ 申请房勘审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_3 = "[ 申请房勘审核 ]";
	/**taskTitle [ 申请带看审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_4 = "[ 申请带看审核 ]";
	/**taskTitle [ 租期提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_5 = "[ 租期提醒 ]";
	/**taskTitle [ 申请房勘审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_6 = "[ 申请房勘审核 ]";
	/**taskTitle [ 申请借用钥匙 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_7 = "[ 申请借用钥匙 ]";
	/**taskTitle [ 申请归还钥匙 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_8 = "[ 申请归还钥匙 ]";
	/**taskTitle [ 跟进提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_9 = "[ 跟进提醒 ]";
	/**taskTitle [ 人工审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_10 = "[ 人工审核 ]";
	/**taskTitle [ 成交提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_11 = "[ 成交提醒 ]";
	/**taskTitle [ 申诉提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_12 = "[ 申诉提醒 ]";
	/**taskTitle [ 申请提交钥匙 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_13 = "[ 申请提交钥匙 ]";
	/**taskTitle [ 申请退还钥匙 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_14 = "[ 申请退还钥匙 ]";
	/**taskTitle [ 成交提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_15 = "[ 成交提醒 ]";
	/**taskTitle [ 申请查看信息 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_16 = "[ 申请查看信息 ]";
	/**taskTitle [ 申请议价审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_17 = "[ 申请议价审核 ]";
	/**taskTitle [ 查看记录 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_18 = "[ 查看记录 ]";
	/**taskTitle [ 注销提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_19 = "[ 注销提醒 ]";
	/**taskTitle [ 审核任务失效 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_20 = "[ 审核任务失效 ]";
	/**taskTitle [ 优优好房 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_21 = "[ 优优好房 ]";
	/**taskTitle [ 申请加密审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_22 = "[ 申请加密审核 ]";
	/**taskTitle [ 申请推荐审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_23 = "[ 申请推荐审核 ]";
	/**taskTitle [ 广告房源  ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_24 = "[ 广告房源 ]";
	/**taskTitle [ 投诉提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_25 = "[ 投诉提醒 ]";
	/**taskTitle [ 权证提醒 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_26 = "[ 权证提醒 ]";
	/**taskTitle [ 律师审核 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_27 = "[ 律师审核 ]";
	/**taskTitle [ 合同修改 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_28 = "[ 合同修改 ]";
    /**taskTitle [ 注销审核 ]*/
    public final static String DIC_TASK_SUBJECT_HEAD_29 = "[ 注销审核 ]";
	/**taskTitle [ 变更楼盘 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_30 = "[ 变更楼盘 ]";
	/**taskTitle [ 核心信息 ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_31 = "[ 核心信息 ]";
	/*数据字典CASE_TYPE*/
	/**跟踪类别：出售房源 1*/
	public final static Integer DIC_CASE_TYPE_SALE_FUN = 1;
	public final static Byte DIC_CASE_TYPE_SALE_FUN_BYTE = 1;
	/**跟踪类别：出租房源 2*/
	public final static Integer DIC_CASE_TYPE_LEASE_FUN = 2;
	public final static Byte DIC_CASE_TYPE_LEASE_FUN_BYTE = 2;
	/**跟踪类别：求购客户 3*/
	public final static Integer DIC_CASE_TYPE_BUY_CUST = 3;
	/**跟踪类别：求租客户 4*/
	public final static Integer DIC_CASE_TYPE_RENT_CUST = 4;
	/**类型：搜搜砖铺*/
	public final static Integer DIC_CASE_TYPE_SHOP_MAIN = 5;
	/**类型：搜搜合租*/
	public final static Integer DIC_CASE_TYPE_HEZU = 6;
	/**跟踪类别：出售合同 101*/
	public final static Integer DIC_CASE_TYPE_SALE_DEAL = 101;
	public final static Byte DIC_CASE_TYPE_SALE_DEAL_BYTE = 101;
	/**跟踪类别：出租合同 102*/
	public final static Integer DIC_CASE_TYPE_RENT_DEAL = 102;
	public final static Byte DIC_CASE_TYPE_RENT_DEAL_BYTE = 102;
	/**类型：金融 103*/
	public final static Integer DIC_CASE_TYPE_FINANCIAL = 103;
	/*数据字典EXAMIN_RESULT任务结果*/
	/**同意*/
	public final static Byte DIC_EXAMIN_RESULT_AGREEN = 1;
	/**不同意*/
	public final static Byte DIC_EXAMIN_RESULT_DISAGREEN = 2;

	/**未审核 值：0*/
	public final static Byte DIC_DEAL_COMPLETE_INIT = 0;//未审核
	/**初审核通过 值：1*/
	public final static Byte DIC_DEAL_FIRSTCOMPLETE_OK = 1;//审核通过 更改为初审 2016-05-06 flj
	/**复审通过 值：2*/
	public final static Byte DIC_DEAL_REPEATCOMPLETE_OK = 2;//审核不通过 更改为复审 2016-05-06 flj
	/**作废 值：3*/
	public final static Byte DIC_DEAL_COMPLETE_FAIL = 3;//审核不通过 更改为复审 2016-05-06 flj
	
	/* 数据字典DEAL_STATUS */
	/** 未履行 值: 0 */
	public final static Byte DIC_DEAL_STATUS_NODO = 0;
	public final static String DIC_DEAL_STATUS_NODODIC_CN_MSG = "未履行";
	/** 履行中 值:1 */
	public final static Byte DIC_DEAL_STATUS_DOING = 1;
	public final static String DIC_DEAL_STATUS_DOINGDIC_CN_MSG = "履行中";
	/** 已办结 值:2 */
	public final static Byte DIC_DEAL_STATUS_TRANSACT = 2;
	public final static String DIC_DEAL_STATUS_TRANSACTDIC_CN_MSG = "已办结";
	/** 未办结 值:3 */
	public final static Byte DIC_DEAL_STATUS_NOTTRANSACT = 3;
	/** 未作废 值：4 */
	public final static Byte DIC_DEAL_COMPLETE_NOTFAIL = 4;// 未作废2016-05-06flj
	/** 合同状态 5：已撤销 */
	public final static Byte DIC_DEAL_STATUS_CLOSE = 5;
	/** 合同状态 6：未结算 */
	public final static Byte DIC_DEAL_STATUS_NOTDEAL = 6;
	/** 尚未分配:0 */
	public final static Byte DIC_DEAL_STATUS_NOTASSIGNED = 0;
	/** 待结算 值:1 */
	public final static Byte DIC_DEAL_STATUS_WAITDEAL = 1;// 以前待结算值为3，在2016-05-23这期需求里面待结算值改为1，已结算改为2，新增尚未分配状态，合同创建的时候默认状态为尚未分配
	/** 已结算 值:2 */
	public final static Byte DIC_DEAL_STATUS_DEALOVER = 2;// 以前已结算为4，同上改为2.

	/*数据字典HOUSE_SOURCE*/
	/**房源来源：到店 值:1*/
	public final static Byte DIC_HOUSE_SOURCE_DIAN = 1;
	/**房源来源：开发 值:2*/
	public final static Byte DIC_HOUSE_SOURCE_DEVELOP = 2;
	/**房源来源：搜搜 值:3*/
	public final static Byte DIC_HOUSE_SOURCE_SOSO = 3;
	/**房源来源：发发 值:4*/
	public final static Byte DIC_HOUSE_SOURCE_FAFA = 4;
	/**房源来源：分配 值:5*/
	public final static Byte DIC_HOUSE_SOURCE_ALLOT = 5;
	/**房源来源：间接 值:6*/
	public final static Byte DIC_HOUSE_SOURCE_INDIRECT = 6;
	/**房源来源：现收 值:7*/
	public final static Byte DIC_HOUSE_SOURCE_CASH = 7;
	/**房源来源：搜房网 值:8*/
	public final static Byte DIC_HOUSE_SOURCE_SOUFUN_FAFA = 8;
	/**房源来源：房东网 值:9*/
	public final static Byte DIC_HOUSE_SOURCE_FUNDON_FAFA = 9;
	/**房源来源：赶集网 值:10*/
	public final static Byte DIC_HOUSE_SOURCE_GANJI_FAFA = 10;
	/**房源来源：安居客 值:11*/
	public final static Byte DIC_HOUSE_SOURCE_ANJUKE_FAFA = 11;
	/**房源来源：58同城 值:12*/
	public final static Byte DIC_HOUSE_SOURCE_58_FAFA = 12;
	/**房源来源：好房在线 值:13*/
	public final static Byte DIC_HOUSE_SOURCE_HFZX = 13;
	/**房源来源：网络来源 用于鸿基 值:14*/
	public final static Byte DIC_HOUSE_SOURCE_WEB = 14;
	/**房源来源：网络来源 用于赶集推广 值:15*/
	public final static Byte DIC_HOUSE_SOURCE_GANJITUIGUANG_FAFA = 15;
	/**房源来源：优优好房 值:18*/
	public final static Byte DIC_HOUSE_SOURCE_DIDI_HOUSE = 18;

	/**系统运行模式-全公盘制 值：PUBLIC*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC = "PUBLIC";
	/**系统运行模式-仅公客制 值：PUBCUST*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST = "PUBCUST";
	/**系统运行模式-仅公房制 值：PUBFUN*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN = "PUBFUN";
	/**系统运行模式-私盘制 值：PRIVATE*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE = "PRIVATE";
	
	/**
	 * 不是YOU+房源 值：0
	 */
	public final static Byte DIC_YOU_SHARE_FLAG_0 = 0;
	/**公司加盟模式**/
	public final static Byte COMP_MODEL_2 = 2;
	/** 优家积分支付，系统参数中的所需金额  0获取首次购买金额 */
	public final static String DIC_YOU_HOUSE_FIRST_COST_SCORE = "YOU_HOUSE_FIRST_COST_SCORE";
	/**
	 * 房源分享成功所得积分
	 */
	public final static String DIC_YOU_SHARE_HOUSE_GAIN_SCORE = "YOU_SHARE_HOUSE_GAIN_SCORE";
	public final static String DIC_YOU_COOPERATE_COST_SCORE = "COOPERATE_COST_SCORE";
	/** 优家积分支付类型 1楼盘资料明文电话 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_1 = "1";
	
	/** 优家积分支付，系统参数中的所需金额  1楼盘资料首次拨打电话购买金额 */
	public final static String DIC_YOU_BUILDINFO_FIRST_CALL_SCORE = "BUILDINFO_CALL_SCORE";
	/** 优家积分支付，系统参数中的所需金额  2楼盘资料明文电话购买金额 */
	public final static String DIC_YOU_BUILDINFO_SHOWPHONE_SCORE = "BUILDINFO_SHOWPHONE_SCORE";
	/**
	 * 物业版分享房源得积分
	 */
	public final static String DIC_YOU_PROPERTY_VER_HOUSEGAINSCORE = "YOU_PROPERTY_VER_HOUSEGAINSCORE";
	/**
	 * 标记为YOU+房源 值：1
	 */
	public final static Byte DIC_YOU_SHARE_FLAG_1 = 1;
	/**门店是否开通You+**/
	public final static Byte YOUJIA_DEPT_FLAG_1 = 1;
	/**显示YOU+按钮**/
	public final static String YOUJIA_SHOW_FLAG_1 = "1";
	/**隐藏YOU+按钮**/
	public final static Byte YOUJIA_SHOW_FLAG_2 = 2;
	/**YOU+默认值为0**/
	public final static Byte YOUJIA_SHOW_FLAG_0 = 0;
	/** 钥匙状态 借出状态 1 */
	public final static Byte KEY_STATUS_BORROWOUT = 1;
	/** 钥匙状态 存档状态 2 */
	public final static Byte KEY_STATUS_HOLDON = 2;

	/**
	 * 日子来源
	 * @author jsg
	 *
	 */
	public static class AccessLogProject {
		/** ERP日志 **/
		public static final int ACCESS_LOG_1 = 1;
		/** CRM 日志 **/
		public static final int ACCESS_LOG_2 = 2;
		/** YOUYOU日志 **/
		public static final int ACCESS_LOG_3 = 3;
	}
    /*上班类型*/
    /**
     * 正常上班
     */
    public final static String DIC_WORK_TYPE_ONWORK = "1";
    /**
     * 上班(值)
     */
    public final static String DIC_WORK_TYPE_DUTYWORK = "2";
    /**
     * 上班(晚)
     */
    public final static String DIC_WORK_TYPE_LATEWORK = "3";
    /**
     * 正常下班
     */
    public final static String DIC_WORK_TYPE_FREE = "4";
    /**
     * 下班(值)
     */
    public final static String DIC_WORK_TYPE_DUTYFREE = "5";
    /**
     * 下班(早)
     */
    public final static String DIC_WORK_TYPE_EARYFREE = "6";
	/*上班状态*/
    /**
     * 准时
     */
    public final static String DIC_WORK_STATUS_ONWORK = "1";
    /**
     * 迟到
     */
    public final static String DIC_WORK_STATUS_DUTYWORK = "2";
    /**
     * 早退
     */
    public final static String DIC_WORK_STATUS_LATEWORK = "3";
    /**
     * 旷工
     */
    public final static String DIC_WORK_STATUS_FREE = "4";
    /**
     * 病假
     */
    public final static String DIC_WORK_STATUS_DUTYFREE = "5";
    /**
     * 事假
     */
    public final static String DIC_WORK_STATUS_EARYFREE = "6";
	/**
	 * 休假
	 */
	public final static String DIC_WORK_STATUS_VACATION = "7";

	public static final Map<Integer,String> EXCEPTION_STATUS_NAME_MAP = new HashMap<Integer,String>();
	/** 合同审批配置类型 **/
	public final static Map<Integer,String> AUDIT_DEAL_TYPE_MAP = new HashMap<Integer,String>();
	static{
		EXCEPTION_STATUS_NAME_MAP.put(106004, "数据错误");
		EXCEPTION_STATUS_NAME_MAP.put(101001, "标题字数不足");
		EXCEPTION_STATUS_NAME_MAP.put(101002, "标题字数过长");
		EXCEPTION_STATUS_NAME_MAP.put(101003, "非法标题");
		EXCEPTION_STATUS_NAME_MAP.put(101004, "数据错误");
		EXCEPTION_STATUS_NAME_MAP.put(101005, "标题含有数字");
		EXCEPTION_STATUS_NAME_MAP.put(101006, "标题含有电话");
		EXCEPTION_STATUS_NAME_MAP.put(101007, "房源描述超长");
		EXCEPTION_STATUS_NAME_MAP.put(101008, "房源描述字数不足");
		EXCEPTION_STATUS_NAME_MAP.put(101009, "房源描述含有数字");
		EXCEPTION_STATUS_NAME_MAP.put(101010, "房源描述含有电话");
		EXCEPTION_STATUS_NAME_MAP.put(101011, "非法房源描述");
		EXCEPTION_STATUS_NAME_MAP.put(101012, "户型错误(室)");
		EXCEPTION_STATUS_NAME_MAP.put(101013, "户型错误(室)");
		EXCEPTION_STATUS_NAME_MAP.put(101014, "户型错误(厅)");
		EXCEPTION_STATUS_NAME_MAP.put(101015, "户型错误(厅)");
		EXCEPTION_STATUS_NAME_MAP.put(101016, "户型错误(卫)");
		EXCEPTION_STATUS_NAME_MAP.put(101017, "户型错误(卫)");
		EXCEPTION_STATUS_NAME_MAP.put(101018, "重复房源(标题重复)");
		EXCEPTION_STATUS_NAME_MAP.put(101019, "重复房源(其他信息重复)");
		EXCEPTION_STATUS_NAME_MAP.put(106010, "验证码错误");

		EXCEPTION_STATUS_NAME_MAP.put(1010190, "验证码错误");
		EXCEPTION_STATUS_NAME_MAP.put(101999, "验证码错误");
		EXCEPTION_STATUS_NAME_MAP.put(1010000, "验证码错误");

		AUDIT_DEAL_TYPE_MAP.put(1, "初审");
		AUDIT_DEAL_TYPE_MAP.put(2, "复审");
		AUDIT_DEAL_TYPE_MAP.put(3, "结算");
		AUDIT_DEAL_TYPE_MAP.put(4, "合同作废");
		AUDIT_DEAL_TYPE_MAP.put(5, "撤销初审");
		AUDIT_DEAL_TYPE_MAP.put(6, "撤销复审");
		AUDIT_DEAL_TYPE_MAP.put(7, "撤销结算");
		AUDIT_DEAL_TYPE_MAP.put(8, "应收");
		AUDIT_DEAL_TYPE_MAP.put(9, "实收");
		AUDIT_DEAL_TYPE_MAP.put(10, "撤销应收审核");
		AUDIT_DEAL_TYPE_MAP.put(11, "撤销实收审核");
	}

	/**
	 * 用户提示性消息记录表--admin.FUN_USER_MESSAGE
	 * 消息所属模块
	 *
	 * @author 张宏利
	 * @since 2016年9月2日
	 */
	public static class MsgModule {
		/**房源**/
		public final static Integer HOUSE = 1;
		/**客源**/
		public final static Integer CUST = 2;
		/**城市公盘**/
		public final static Integer YOUJIA = 3;
		/**搜搜推送**/
		public final static Integer SOSO_PUSH = 4;
	}

	/**
	 * 用户提示性消息记录表--admin.FUN_USER_MESSAGE
	 * 消息所属模块的详细类型
	 *
	 * @author 张宏利
	 * @since 2016年9月2日
	 */
	public static class MsgModuleType {
		/**强制写跟进**/
		public final static Integer WRITE_TRACK_BY_VIEW = 1;
		/**IP拨号**/
		public final static Integer IP_CALL = 2;
		/**查看电话**/
		public final static Integer VIEW_PHONE = 3;
		/**写跟进**/
		public final static Integer WRITE_TRACK = 4;
		/**修改信息**/
		public final static Integer UPDATE_HOUSE_CUST_INFO = 5;
		/**上传图片**/
		public final static Integer UPLOAD_PHOTO = 6;
		/**删除图片**/
		public final static Integer DELETE_PHOTO = 7;
		/**注销房源**/
		public final static Integer WRITEOFF_HOUSE_CUST = 8;
		/**创建合同的房源成交**/
		public final static Integer DEAL_HOUSE_CUST_BY_CONTRACT = 9;
		/**收藏的房源被注销**/
		public final static Integer FAVORITE_HOUSE_CUST_WRITEOFF = 10;
		/**收藏的房源被成交**/
		public final static Integer FAVORITE_HOUSE_CUST_DEAL = 11;
		/**提交钥匙**/
		public final static Integer SUBMIT_KEY = 12;
		/**优家房源被投诉**/
		public final static Integer YOU_HOUSE_CUST_COMPLAINED = 13;
		/**优家我参与的房源下架**/
		public final static Integer YOU_INVOLVEMENT_WRITEOFF = 14;
		/**优家新增的房客源**/
		public final static Integer YOU_HOUSE_CUST_NEW = 15;
		/**搜搜出售推送**/
		public final static Integer SOSO_PUSH_SALE = 16;
		/**搜搜出租推送**/
		public final static Integer SOSO_PUSH_LEASE = 17;
		/**搜搜转铺推送**/
		public final static Integer SOSO_PUSH_ZHUANPU = 18;
		/**搜搜合租推送**/
		public final static Integer SOSO_PUSH_HEZU = 19;
		/**搜搜求购推送**/
		public final static Integer SOSO_PUSH_BUY = 20;
		/**搜搜求租推送**/
		public final static Integer SOSO_PUSH_RENT = 21;
		/** 薪资小秘书 **/
		public final static Integer FUN_WAGE_BILL = 27;
	}

	public final static String[] decodeFieldsCN = new String[]{
			"电话",
			"业主",
			"身份证",
			"栋座",
			"单元",
			"楼",
			"号",
			"备注",
			"客户",
			"住址",
			"共有人姓名",
			"共有人电话",
			"共有人身份证",
	};

	/**注销房客源的查看，不参与统计 值:0 */
	public final static Byte DIC_VIEW_STATUS_WRITEOFF = 0;
	/**有效查看，参与统计 值:1 */
	public final static Byte DIC_VIEW_STATUS_AVAILABLE = 1;
	/**task type flag [ 系统用户ID 统一使用999 包含：系统任务、系统跟进、系统留言等] */
	public final static Integer DIC_SYSTEM_USERID_999 = 999;
	/**优优好房用户ID 998 */
	public final static Integer DIC_SYSTEM_USERID_998 = 998;
	/**优优好房用户名 998*/
	public final static String DIC_SYSTEM_USERNAME_998 = "优优好房";
	/**系统默认用户名[ 公告不存在的用户名、 ]**/
	public final static String DIC_SYSTEM_USERNAME = "好房达人";

	/**房源数据的重复判断 ERP SYS_PARA 表中的参数*/
	/**允许录入重复数据，值：0 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_0 = "0";
	/**不允许录入地址重复的房源数据，值：1 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_1 = "1";
	/**不允许录入地址和电话同时重复的房源，值：2 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_2 = "2";

	/**选择队列，1=root*/
	public final static Integer DIC_JMS_SEND_PRODUCER_1 = 1;
	/**选择队列，2=软件购买队列*/
	public final static Integer DIC_JMS_SEND_PRODUCER_2 = 2;
	/**选择队列，3=延迟支付队列*/
	public final static Integer DIC_JMS_SEND_PRODUCER_3 = 3;
	/**选择队列，4=用户相关异步处理*/
	public final static Integer DIC_JMS_SEND_PRODUCER_4 = 4;
	/**选择队列，5=经济人跑分队列*/
	public final static Integer DIC_JMS_SEND_PRODUCER_5 = 5;
	

	/** 房源相关人类型 相关人类型，1=所属人 2=接盘人 3=钥匙 4=房勘人 5=委托人 */
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_1 = 1;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 */
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_2 = 2;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 */
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_3= 3;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 */
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_4 = 4;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 */
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_5 = 5;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 6=议价人 */
	public final static String HOUSE_RELATIVE_PEOPLE_TYPE_6 = "6";;
	/** 房源相关人类型 相关人类型，1=所属人 2=售接盘人 3=钥匙 4=房勘人 5=委托人 6=议价人 7=楼盘责任人*/
	public final static Integer HOUSE_RELATIVE_PEOPLE_TYPE_7 = 7;

	/* 数据字典PRICE_UNIT租金单位 */
	/** 元/月 值:1 */
	public final static Byte DIC_PRICE_UNIT_PERMONTH = 1;
	/** 元/天 值:2 */
	public final static Byte DIC_PRICE_UNIT_PERDAY = 2;
	/** 元/平米*月 值:3 */
	public final static Byte DIC_PRICE_UNIT_PERCENTIARE = 3;
	/** 元/平米*天 值:4 */
	public final static Byte DIC_PRICE_UNIT_PERDAYCENT = 4;
	/** 元/年 值:5 */
	public final static Byte DIC_PRICE_UNIT_PERYEAR = 5;
	
	/**用户注销类型：直接注销 值:0*/
	public final static Byte DIC_USER_WRITEOFF_TYPE_0 = 0;
	/**用户注销类型：调店注销 值:1*/
	public final static Byte DIC_USER_WRITEOFF_TYPE_1 = 1;
	
	
	/** 员工调店 */
	public final static String DIC_STAFF_MOVE_TO_NEWDEPTSTRING = "员工调店";
	/** 员工管理  */
	public final static String DIC_STAFF_MOVE_TO_MANAGE = "员工管理";
	/** 调动组织机构  */
	public final static String DIC_STAFF_MOVE_ORGANIZATION = "调动组织";
	/** 员工调动 调组 */
	public final static Byte DIC_STAFF_MOVE_TO_NEWGROUP = 7;
	/** 员工调动 调店 */
	public final static Byte DIC_STAFF_MOVE_TO_NEWDEPT = 6;
	/** 员工调动 组织机构 */
	public final static Byte DIC_STAFF_MOVE_TO_ORGANIZATION = 8;
	/** 编辑员工档案 */
	public final static Byte DIC_STAFF_EDIT_EMPLOYEEDOC = 5;
	
	/**盘别英文描述：抢盘 值:PUBLIC*/
	public final static String DIC_PLATE_TYPE_PUBLIC_EN = "PUBLIC";
	/**盘别英文描述：私盘 值:PRIVATE*/
	public final static String DIC_PLATE_TYPE_PRIVATE_EN = "PRIVATE";
	/**盘别英文描述：公盘 值:SHARE*/
	public final static String DIC_PLATE_TYPE_SHARE_EN = "SHARE";
	/**
	 * 0 全公司【本公司】 范围
	 */
	public static final Integer DIC_BOUND_0 = 0;
	/**
	 * 1 共享圈 范围
	 */
	public static final Integer DIC_BOUND_1 = 1;
	/**
	 * 2 全系统 范围
	 */
	public static final Integer DIC_BOUND_2 = 2;
	/**
	 * 3 好友圈 范围  至于为什么要用3，不要问为什么，用就是了。
	 */
	public static final Integer DIC_BOUND_3 = 3;
	
	/**系统管理员 系统中暂时不显示出来*/
	public final static String DIC_ROLE_NAME_SYSTEM_MANAGE = "SYSTEM_MANAGE";
	/**见习经纪人*/
	public final static String DIC_ROLE_NAME_PRACTY_BIZ = "PRACTY_BIZ";
	/**正式经纪人*/
	public final static String DIC_ROLE_NAME_COMMON_BIZ = "COMMON_BIZ";
	/**权证专员*/
	public final static String DIC_ROLE_NAME_PROPERTY_SERVER = "PROPERTY_SERVER";
	/**客服专员*/
	public final static String DIC_ROLE_NAME_CUST_SERVER = "CUST_SERVER";
	/**销售组长*/
	public final static String DIC_ROLE_NAME_BIZ_MANAGER = "BIZ_MANAGER";
	/**店务秘书*/
	public final static String DIC_ROLE_NAME_SECRETARIAL = "SECRETARIAL";
	/**门店经理 -- 通俗叫法“店长” 中介门店的店长*/
	public final static String DIC_ROLE_NAME_BRANCH_MANAGER = "BRANCH_MANAGER";
	/**片区经理*/
	public final static String DIC_ROLE_NAME_REGION_MANAGER = "REGION_MANAGER";
	/**大区经理*/
	public final static String DIC_ROLE_NAME_BIZ_GENERAL = "BIZ_GENERAL";
	/**副总经理*/
	public final static String DIC_ROLE_NAME_DEPUTY_MANAGER = "DEPUTY_MANAGER";
	/**总经理*/
	public final static String DIC_ROLE_NAME_GENERAL_MANAGER = "GENERAL_MANAGER";
	
	/*数据映射日期*/
	/**全部 值：0*/
	public final static String DIC_DATE_SEARCH_TYPE_ALL = "0";
	/**一天 值：1*/
	public final static String DIC_DATE_SEARCH_TYPE_DAY = "1";
	/**一周 值：2*/
	public final static String DIC_DATE_SEARCH_TYPE_WEEK = "2";
	/**一月 值：3*/
	public final static String DIC_DATE_SEARCH_TYPE_MONTH = "3";
	/**一季 值：4*/
	public final static String DIC_DATE_SEARCH_TYPE_SEASON = "4";
	/**半年 值：5*/
	public final static String DIC_DATE_SEARCH_TYPE_HALFYEAR = "5";
	/**半年前 值：6*/
	public final static String DIC_DATE_SEARCH_TYPE_BEFORE_HALFYEAR = "6";
	/**一年 值：7*/
	public final static String DIC_DATE_SEARCH_TYPE_YEAR = "7";
	/**一年前 值：8*/
	public final static String DIC_DATE_SEARCH_TYPE_BEFORE_YEAR = "8";
	/**两年前 值：9*/
	public final static String DIC_DATE_SEARCH_TYPE_BEFORE_TWOYEAR = "9";
	/**今天 值：10*/
	public final static String DIC_DATE_SEARCH_TYPE_TODAY = "10";
	/**昨天 值:11*/
	public final static String DIC_DATE_SEARCH_TYPE_YESTERDAY = "11";
	/**本周 值:12*/
	public final static String DIC_DATE_SEARCH_TYPE_BENWEEK = "12";
	/**本月 值:13*/
	public final static String DIC_DATE_SEARCH_TYPE_BENMONTH = "13";
	/**本季 值：14*/
	public final static String DIC_DATE_SEARCH_TYPE_BENSEASON = "14";
	/**三天内 值：15*/
	public final static String DIC_DATE_SEARCH_TYPE_THREEDAYS = "15";

	/**
	 * 时间考勤结果状态 管理中心，考勤所属模块 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假
	 *
	 * @author 何明礼
	 * @since 2017年11月29日
	 */
	public static class TimeAttendanceResult {
		/**缺卡**/
		public final static Byte LACK_OF_CARD = 0;
		/**早退**/
		public final static Byte LEAVE_EARLY = 1;
		/**迟到**/
		public final static Byte BE_LATE = 2;
		/**旷工**/
		public final static Byte ABSENTEEISM = 3;
		/**正常**/
		public final static Byte NORMAL = 4;
		/**等待打卡**/
		public final static Byte WAITE_WORK = 5;
		/**严重迟到**/
		public final static Byte BE_LATE_BADLY = 6;
		/**早退旷工**/
		public final static Byte LEAVE_EARLY_ABSENTEEISM = 7;
		/**迟到旷工**/
		public final static Byte BE_LATE_ABSENTEEISM = 8;
		/**事假**/
		public final static Byte COMPASSIONATE_LEAVE = 9;
		/**病假**/
		public final static Byte SICK_LEAVE = 10;
		/**未就绪**/
		public final static Byte NOT_READY  = 11;
		/**代表审批来的请假**/
		public final static Byte AUDIT_LEAVE  = 12;
		/** 考勤结果对应字典**/
		public final static Map<Byte,String> ATT_RESULT_CN = new HashMap<>();
		/** 考勤结果权重对应字典**/
		public final static Map<Byte,Integer> ATT_RESULT_TRANSFER_WEIGHT = new HashMap<Byte,Integer>();
		/** 考勤结果权重对应字典**/
		public final static Map<String,String> ATT_WEIGHT_SHOW_ORDER = new HashMap<String,String>();
		/** 考勤结果权重对应字典**/
		public final static Map<String,String> ATT_MYSTATICS_SHOW_ORDER = new HashMap<String,String>();


		/**
		 * 打卡结果中文描述
		 */
		public final static Map<Byte, String> ATT_RESULT_DESC = new HashMap<Byte,String>();


		/** 权重对应考勤统计类型**/
		public final static Map<Integer, String> ATT_WEIGHT_MAP_ATT_TYPE = new HashMap<Integer, String>();

		static {
			//考勤结果对应字典
			ATT_RESULT_CN.put(LACK_OF_CARD,"缺卡");
			ATT_RESULT_CN.put(LEAVE_EARLY,"早退");
			ATT_RESULT_CN.put(BE_LATE,"迟到");
			ATT_RESULT_CN.put(ABSENTEEISM,"旷工");
			ATT_RESULT_CN.put(NORMAL,"正常");
			ATT_RESULT_CN.put(WAITE_WORK,"等待打卡");
			ATT_RESULT_CN.put(BE_LATE_BADLY,"严重迟到");
			ATT_RESULT_CN.put(LEAVE_EARLY_ABSENTEEISM,"早退旷工");
			ATT_RESULT_CN.put(BE_LATE_ABSENTEEISM,"迟到旷工");
			ATT_RESULT_CN.put(COMPASSIONATE_LEAVE,"事假");
			ATT_RESULT_CN.put(SICK_LEAVE,"病假");
			ATT_RESULT_CN.put(NOT_READY,"未就绪");

			//迟到>早退>缺卡>外勤>请假>正常打卡
			ATT_RESULT_TRANSFER_WEIGHT.put(LEAVE_EARLY, 5);
			ATT_RESULT_TRANSFER_WEIGHT.put(ABSENTEEISM, 6);
			ATT_RESULT_TRANSFER_WEIGHT.put(BE_LATE, 6);
			ATT_RESULT_TRANSFER_WEIGHT.put(BE_LATE_BADLY, 6);
			ATT_RESULT_TRANSFER_WEIGHT.put(BE_LATE_ABSENTEEISM, 6);
			ATT_RESULT_TRANSFER_WEIGHT.put(LEAVE_EARLY_ABSENTEEISM, 5);
			ATT_RESULT_TRANSFER_WEIGHT.put(LACK_OF_CARD, 4);
			ATT_RESULT_TRANSFER_WEIGHT.put(Byte.valueOf("36"), 3);//代表外勤，特殊处理，取一个较大值，后期好做中间值的增加
			ATT_RESULT_TRANSFER_WEIGHT.put(COMPASSIONATE_LEAVE, 2);
			ATT_RESULT_TRANSFER_WEIGHT.put(SICK_LEAVE, 2);
			ATT_RESULT_TRANSFER_WEIGHT.put(NORMAL, 1);

			//出勤天数和迟到早退都属于组合衍生出来的类型，type值尽量与其他的字段分开
			ATT_WEIGHT_MAP_ATT_TYPE.put(12, "出勤天数");
			ATT_WEIGHT_MAP_ATT_TYPE.put(11, "迟到早退");

			ATT_WEIGHT_MAP_ATT_TYPE.put(6, "迟到");
			ATT_WEIGHT_MAP_ATT_TYPE.put(5, "早退");
			ATT_WEIGHT_MAP_ATT_TYPE.put(4, "缺卡");
			ATT_WEIGHT_MAP_ATT_TYPE.put(3, "外勤");
			ATT_WEIGHT_MAP_ATT_TYPE.put(2, "请假");
			ATT_WEIGHT_MAP_ATT_TYPE.put(1, "正常打卡");
			ATT_WEIGHT_SHOW_ORDER.put("1", "1");
			ATT_WEIGHT_SHOW_ORDER.put("11", "2");
			ATT_WEIGHT_SHOW_ORDER.put("4", "3");
			ATT_WEIGHT_SHOW_ORDER.put("3", "4");
			ATT_WEIGHT_SHOW_ORDER.put("2", "5");
			ATT_MYSTATICS_SHOW_ORDER.put("12", "1");
			ATT_MYSTATICS_SHOW_ORDER.put("6", "2");
			ATT_MYSTATICS_SHOW_ORDER.put("5", "3");
			ATT_MYSTATICS_SHOW_ORDER.put("3", "4");
			ATT_MYSTATICS_SHOW_ORDER.put("4", "5");
			ATT_MYSTATICS_SHOW_ORDER.put("21", "6");
			ATT_MYSTATICS_SHOW_ORDER.put("2", "7");

		}
		
	}
	/**
	 * 目前允许的楼盘关注最大数据
	 */
	public final static int MAX_BIDDING_NUM = 6;
	
	/**
	 * 陈文超 2016-06-13
	 * 真房源的图片数量
	 * 值：5
	 */
	public final static String DIC_TRUE_HOUSE_RULE_IMGCOUNT = "5";

	/**
	 * 注册用户时的通用验证码-- 测试方便
	 */
	public final static String TEST_MOBILE_KEY_USER_REGISTER_PWD = "974726";

	/**
	 * profit count type 业绩统计方式 按公司统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_COMP = 5;
	/**
	 * profit count type 业绩统计方式 按大区统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_AREA = 4;
	/**
	 * profit count type 业绩统计方式 按片区统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_REG = 3;
	/**
	 * profit count type 业绩统计方式 按门店统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_DEPT = 2;
	/**
	 * profit count type 业绩统计方式 按分组统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_GROUP = 0;
	/**
	 * profit count type 业绩统计方式 按员工统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_USER = 1;
	/**
	 * profit count type 业绩统计方式 无限组织架构统计
	 */
	public final static Integer DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION = -1;

	public static class Count {
		public static Map<String, Integer> PROFIT_COUNT_TYPE_MAP = new HashMap<>();

		static {
			PROFIT_COUNT_TYPE_MAP.put("AREA", Const.DIC_PROFIT_COUNT_TYPE_AREA);
			PROFIT_COUNT_TYPE_MAP.put("REG", Const.DIC_PROFIT_COUNT_TYPE_REG);
			PROFIT_COUNT_TYPE_MAP.put("DEPT", Const.DIC_PROFIT_COUNT_TYPE_DEPT);
			PROFIT_COUNT_TYPE_MAP.put("GROUP", Const.DIC_PROFIT_COUNT_TYPE_GROUP);
			PROFIT_COUNT_TYPE_MAP.put("USER", Const.DIC_PROFIT_COUNT_TYPE_USER);
		}
	}

	public static List<String> QUARTER = new ArrayList<>();
	static{
		QUARTER.add("1");
		QUARTER.add("2");
		QUARTER.add("3");
		QUARTER.add("4");
	}

	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_1 = "1";

	/**
	 * 房源类型的权限 值：1
	 */
	public final static int DIC_OPER_RANGE_TYPE_1 =1;
	/**
	 * 客源类型的权限 值：2
	 */
	public final static int DIC_OPER_RANGE_TYPE_2 = 2;

	/**
	 * 查看房源核心信息的权限类型
	 */
	public final static int DIC_FUN_OPERS_OPER_TYPE_1 = 1;
	/**
	 * 查看客源核心信息的权限类型
	 */
	public final static int DIC_FUN_OPERS_OPER_TYPE_2 = 2;

	/**
	 * 查看客源列表信息的权限类型
	 */
	public final static int DIC_FUN_OPERS_OPER_TYPE_13 = 13;
	/**
	 * 查看房源列表信息的权限类型
	 */
	public final static int DIC_FUN_OPERS_OPER_TYPE_14 = 14;

	/**
	 * 5:分组 < 4:门店 < 3:片区 < 2:大区 < 1:全公司
	 */
	/**
	 * 1:全公司范围的权限
	 */
	public final static int DIC_OPER_RANGE_LEVEL_SEQ_1 = 1;
	/**
	 * 2:大区范围的权限
	 */
	public final static int DIC_OPER_RANGE_LEVEL_SEQ_2 = 2;
	/**
	 * 3:片区范围的权限
	 */
	public final static int DIC_OPER_RANGE_LEVEL_SEQ_3 = 3;
	/**
	 * 4:门店范围的权限
	 */
	public final static int DIC_OPER_RANGE_LEVEL_SEQ_4 = 4;
	/**
	 * 5:分组范围的权限
	 */
	public final static int DIC_OPER_RANGE_LEVEL_SEQ_5 = 5;

	/**
	 * 是否隐号拨打
	 * 1：开启
	 * 0：关闭
	 */
	public final static String IS_OPEN_HIDEPHONE_1 = "1";
	/**
	 * 是否隐号拨打个人数据
	 * 1：开启
	 * 0：关闭
	 */
	public final static String IS_OPEN_HIDE_SELF_PHONE_1 = "1";
	/**
	 * 统一模式不区分盘别
	 */
	public final static String DIC_PLATE_TYPE_ALL_EN = "ALL";
	/**
	 * 跟进带看标记：有效带看 值:1
	 */
	public final static Integer DIC_TRACK_TARGET_FLAG_1 = 1;

	/** 优家楼盘资料当前查看状态 3已转入系统出售，灰勾 */
	public final static Integer DIC_YOU_BUILD_VIEW_STATUS_3 = 3;
	/** 优家楼盘资料当前查看状态 4已转入系统出租，灰勾 */
	public final static Integer DIC_YOU_BUILD_VIEW_STATUS_4 = 4;

	/**
	 * 语音记录是否已下载标志 1已下载
	 */
	public final static byte DIC_VOIP_VOIC_DOWNLOAD = 1;

	public static class ScoreTypeDIC{
		/**1=房源客源匹配*/
		public final static Integer SCORE_TYPE_1 = 1;
		/**2=通过好房通发布多图朋友圈*/
		public final static Integer SCORE_TYPE_2 = 2;
		/**3=将房源同步到同城交流或者合作共享*/
		public final static Integer SCORE_TYPE_3 = 3;
		/**4=税单打印*/
		public final static Integer SCORE_TYPE_4 = 4;
		/**5=门店标贴打印*/
		public final static Integer SCORE_TYPE_5 = 5;
		/**6=发发统计功能点击*/
		public final static Integer SCORE_TYPE_6 = 6;
		/**7=工作量统计点击*/
		public final static Integer SCORE_TYPE_7 = 7;
		/**8=房源客源统计点击*/
		public final static Integer SCORE_TYPE_8 = 8;
		/**9=更新业绩目标*/
		public final static Integer SCORE_TYPE_9 = 9;
		/**10=设置为上班接单中状态*/
		public final static Integer SCORE_TYPE_10 = 10;
		/**11=通过掌上好房通个人微店、单独推房源 */
		public final static Integer SCORE_TYPE_11 = 11;
		/**12=软件参数配置及打印张贴*/
		public final static Integer SCORE_TYPE_12 = 12;
		/**13= 发发功能点击*/
		public final static Integer SCORE_TYPE_13 = 13;
		/**14= 数据分析*/
		public final static Integer SCORE_TYPE_14 = 14;
		/**14= 运营分析*/
		public final static Integer SCORE_TYPE_15 = 15;
	}


	static{
		PERFORMANCETYPENAME_MAP.put("0","总业绩");
		PERFORMANCETYPENAME_MAP.put("1","过户业绩");
		PERFORMANCETYPENAME_MAP.put("2","二手");
		PERFORMANCETYPENAME_MAP.put("3","新房");
		PERFORMANCETYPENAME_MAP.put("4","租赁");
		PERFORMANCETYPENAME_MAP.put("5","金融");
		PLATETYPEMSG_MAP.put(1, "抢盘");
		PLATETYPEMSG_MAP.put(2, "私盘");
		PLATETYPEMSG_MAP.put(3, "公盘");
		RANGE_LEVEL.put("COMP_ID", 5);
		RANGE_LEVEL.put("AREA_ID", 4);
		RANGE_LEVEL.put("REG_ID", 3);
		RANGE_LEVEL.put("DEPT_ID", 2);
		RANGE_LEVEL.put("GR_ID", 1);
		RANGE_LEVEL.put("USER_ID", 0);
		WORKONTOOFF.put(DIC_WORK_TYPE_ONWORK, DIC_WORK_TYPE_FREE);
		WORKONTOOFF.put(DIC_WORK_TYPE_DUTYWORK, DIC_WORK_TYPE_DUTYFREE);
		WORKONTOOFF.put(DIC_WORK_TYPE_LATEWORK, DIC_WORK_TYPE_EARYFREE);
		PERFORMANCE_USER_RELATIVE.put("HOUSE_CREATE",1);
		PERFORMANCE_USER_RELATIVE.put("HOUSE_GUARDIAN",2);
		PERFORMANCE_USER_RELATIVE.put("KEY",3);
		PERFORMANCE_USER_RELATIVE.put("FANKAN",4);
		PERFORMANCE_USER_RELATIVE.put("WEITUO",5);
		PERFORMANCE_USER_RELATIVE.put("DUJIAWEITUO",5);
		PERFORMANCE_USER_RELATIVE.put("YIJIA",6);
		PERFORMANCE_USER_RELATIVE.put("BUILD_MANAGER",7);


	}


	// 引导类型，1=房源管理 2=客源管理 3=好房搜搜 4=好房发发 5=好房推广 6=组织机构 7=权限配置
	/**引导类型，6=组织机构*/
	public final static Integer DIC_ERP_USER_GUIDE_TYPE_6 = 6;
	/**引导类型，7=权限配置*/
	public final static Integer DIC_ERP_USER_GUIDE_TYPE_7 = 7;

	
	public static Map<String, Byte> AUDIT_ITEM_MAP = new HashMap<String, Byte>();
	public static List<String> realSettlementTypeList =new ArrayList<>();
	public static List<String> settlementTypeList =new ArrayList<>();
	static {
		AUDIT_ITEM_MAP.put("FENGPAN", DIC_TRACK_TYPE_STATUS_SPECIAL);
		AUDIT_ITEM_MAP.put("FUNCAN", DIC_TRACK_TYPE_FUNCAN);
		AUDIT_ITEM_MAP.put("JIAMI", DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD);
		AUDIT_ITEM_MAP.put("NEICHENGJIAO", DIC_TRACK_TYPE_STATUS_INNERDEAL);
		AUDIT_ITEM_MAP.put("TUIJIAN", DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND);
		AUDIT_ITEM_MAP.put("WAICHENGJIAO", DIC_TRACK_TYPE_STATUS_OUTDEAL);
		//AUDIT_ITEM_MAP.put("WEITUO", DIC_TRACK_TYPE_LIMITED);
		AUDIT_ITEM_MAP.put("YIJIA", DIC_TRACK_TYPE_BARGAIN);
		AUDIT_ITEM_MAP.put("YUDING", DIC_TRACK_TYPE_STATUS_SCHEDULE);
		AUDIT_ITEM_MAP.put("ZANHUAN", DIC_TRACK_TYPE_STATUS_RESPITE);
		AUDIT_ITEM_MAP.put("ZHUANYOUXIAO", DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE);
		AUDIT_ITEM_MAP.put("ZHUXIAO", DIC_TRACK_TYPE_STATUS_WRITEOFF);
		AUDIT_ITEM_MAP.put("DAIKAN", DIC_TRACK_TYPE_DAIKAN);

		realSettlementTypeList.add("1");
		realSettlementTypeList.add("4");
		settlementTypeList.add("2");
		settlementTypeList.add("3");
		settlementTypeList.add("5");

	}
	
	/**
	 * APP使用的跳转
	 * @author 尹振兴
	 * @since 2018年1月24日
	 */
	public static class ResponseErrorCode {
		/** 刷新登录 **/
		public static final String REFRESH_TOKEN = "-4001";
		/** 跳转实名认证 **/
		public static final String USER_VALIDATE = "-4002";
		/** 充值好房豆 :系统弹出**/
		public static final String USER_RECHARGE_COIN = "-4003";
		/** 充值vip :系统弹出**/
		public static final String USER_RECHARGE_VIP = "-4004";
		/** 订单被他人抢走了 :系统弹出**/
		public static final String USER_ROBENTRUST_FAILE = "-40041";
		/** 跳转绑定资金账户 **/
		public static final String BIND_ACCOUNT = "-4005";
		/** 跳转房源编辑 ,主要用于敏感词会过滤**/
		public static final String HOUSE_EDIT = "-4006";
		/** 实名认证  && VIP的弹窗 **/
		public static final String RECHARGE_VIP_VALIDATE = "-4007";
		/** 实名认证  && O2O的弹窗  **/
		public static final String RECHARGE_OTO_VALIDATE = "-4008";
		/** ios客户端崩溃 **/
		public static final String CLIENT_CRASH = "-5001";
		/** 小区专家未登记房源 :系统弹出**/
		public static final String BUILD_EXPERT_NO_HOUSE = "-4009";
		/** 小区专家未点亮网络推广 :系统弹出**/
		public static final String BUILD_EXPERT_NONETPUSH_HOUSE = "-4010";
		/** 小区专家，无图片 :系统弹出**/
		public static final String BUILD_EXPERT_NOPHOTO_HOUSE = "-4011";
		/** 当前界面充值保证金：系统弹出**/
		public static final String CURR_PAGE_USER_RECHARGE_BOND = "-4012";
		/** 经纪人所在公司未开通微店**/
		public static final String NOT_OPEN_WEIXIN  = "-4013";
		/** 客源用户未关注微信**/
		public static final String CUSTOMER_NOT_GZ_WEIXIN = "-4014";
		/** 网络推广核验编号**/
		public static final String NEED_EDIT_HOUSE = "-4015";
		/** 充值现金余额 **/
		public static final String RECHARGE_MONEY = "-4016";
		/** 真房源投诉中，不能操作 **/
		public static final String TRUE_HOUSE_IN_COMPLAINT = "-4017";
		/** 新赢销版，需要引导升级 */
		public static final String UPGRADE_GUIDE = "-4018";
		/** 新赢销版充值好房豆送VIP **/
		public static final String RECHARGE_COIN_GIFT_VIP = "-4019";

		/** 使用好房豆查看历史数据 */
		public static final String USE_BEAN_VIEW_HISTORY_SOSO_CODE = "-4020";
		/** 通用弹框 **/
		public static final String COMMON_ALERT = "-4021";
		/** soso查看数据需要用VIP*/
		public static final String OT_BE_VIP_CODE = "-4022";
		/**免费精英版充值vip和点亮真房源**/
		public static final String RECHARGE_VIP_TRUEHOUSE = "-4023";
		/**
		 * 新赢销版充值好房豆送VIP 针对真房源VIP优惠逻辑
		 * 非VIP：100元点亮 5条真房源
		 *  VIP：100元点亮 10条真房源
		 */
		public static final String TRUE_HOUSE_HINT_BECOME_VIP = "-4024";
		
		/** 实名认证  && 预存好房豆  **/
		public static final String RECHARGE_COIN_VALIDATE = "-4025";
		
		/** 取消委托错误码  **/
		public static final String CANCEL_ENTRUST_ERROR = "-4026";
		
		/** 真房源图片张数不足  **/
		public static final String TRUE_HOUSE_IMG_ERROR = "-4028";
		
		/**新赢销版CODE**/
		public static final String NEW_MARKET_CODE = "-4030";
	}
	
	public static class COMP_TYPE_DIC {
		public static Byte MARKET_EDTION = 4;
	}
	public static class DEPT_TYPE_DIC {
		public static Byte DEPT_TYPE_5 = 5;
	}
	
	public static class AUDIT_RESOURCE {
		/**跟进**/
		public static Byte AUDIT_RESOURCE_TRACK = 1;
		/**请假**/
		public static Byte AUDIT_RESOURCE_LEAVE = 2;
		/**外出**/
		public static Byte AUDIT_RESOURCE_OUT = 3;
		/**合同**/
		public static Byte AUDIT_RESOURCE_DEAL = 4;
		/**房源投诉**/
		public static Byte AUDIT_RESOURCE_HOUSE_COMPLAIN = 5;
		/**通用审核**/
		public static Byte AUDIT_RESOURCE_COMMON = 6;
	}

	public static class EarbestDepositOperator {
		//默认0,  1.转房源，2.代付，3.转拥，4.退款，5.作废，6.业主佣金 7.转定金
		public static Integer OPTION_TYPE_DEFAULT = 0;
		public static Integer OPTION_TYPE_TRANS2HOUSE = 1;
		public static Integer OPTION_TYPE_PAY2OWNER = 2;
		public static Integer OPTION_TYPE_PAY4CUST = 3;
		public static Integer OPTION_TYPE_REFUND= 4;
		public static Integer OPTION_TYPE_CANCEL = 5;
		public static Integer OPTION_TYPE_PAY4OWNER = 6;
		public static Integer OPTION_TYPE_TRANS2DEPOSIT = 7;

	}


	public static class PartnerConfig{

		public static final Map<String, String> PARTNER_PARAM = new HashMap<>();
		public static final Map<String, List<String>> PARTNER_DEPART_PARAM = new HashMap<>();
		public static final Map<String, String> PARTNER_TRANS_PARAM = new HashMap<>();
		static {
			//隐号拨打
			PARTNER_PARAM.put("IS_OPEN_HIDEPHONE","IMPLICIT_CALL_APART");
			PARTNER_PARAM.put("IS_OPEN_HIDE_SELF_PHONE_HOUSE","IMPLICIT_CALL_APART");
			PARTNER_PARAM.put("IS_OPEN_HIDE_SELF_PHONE_CUSTOMER","IMPLICIT_CALL_APART");
			PARTNER_PARAM.put("IPCALL_HIDEPHONE_COUNT","IMPLICIT_CALL_APART");
			PARTNER_PARAM.put("IPCALL_AREA_HIDEPHONE_COUNT","IMPLICIT_CALL_APART");
			PARTNER_PARAM.put("VOIP_USE_COMP_MONEY","IMPLICIT_CALL_APART");
			//转盘
			PARTNER_PARAM.put("HOUSE_TRANSFER_FOR_WHO","TRANS_PLATE_RULE_APART");
			PARTNER_PARAM.put("PRIVATE_HOUSE_TRANSFER","TRANS_PLATE_RULE_APART");
			PARTNER_PARAM.put("PUBLIC_HOUSE_TRANSFER","TRANS_PLATE_RULE_APART");
			PARTNER_PARAM.put("PUBLIC_CUST_TRANSFER","TRANS_PLATE_RULE_APART");
			PARTNER_PARAM.put("PRIVATE_HOUSE_TRANSFER_PUBLIC","TRANS_PLATE_RULE_APART");
			PARTNER_PARAM.put("PRIVATE_CUST_TRANSFER_PUBLIC","TRANS_PLATE_RULE_APART");

			//公盘抢盘配置
			PARTNER_PARAM.put("SHARE_HOUSE_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("SHARE_CUST_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("PUBLIC_HOUSE_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("PUBLIC_CUST_RANGE","PLATE_RANGE_APART");

			//核心信息
			PARTNER_PARAM.put("SHARE_FUN_CORE_DEPT","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_FUN_CORE_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_CUST_CORE_DEPT","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_CUST_CORE_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_SELF","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_OTHER_APP","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_SELF","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_OTHER_APP","CORE_INFO_APART");

			//策略参数自行配置
			PARTNER_PARAM.put("SPECIAL_PROTECT_DAYS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PASSWORD_RECORDS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("INFO_MAX_SECRECY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("SCHEDULE_PROTECT_DAYS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("WARMDAY_OF_RENTDUE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RESPITE_PROTECT_DAYS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("DEPT_COMMEND_RECORDS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("COMMEND_RECORDS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("INFO_MAX_COMMEND_DAYS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("INFO_MAX_FOCUS_DAYS","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("FANGKAN_RED_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_FANGKAN_PUBLIC_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("TRACK_RED_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_TRACK_PUBLIC_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_RED_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_RED_TRACK_PUBLIC_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_CANCEL_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_NOTGET_CANCEL_SELL","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("FANGKAN_RED_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_FANGKAN_PUBLIC_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("TRACK_RED_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_TRACK_PUBLIC_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_RED_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_RED_TRACK_PUBLIC_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_CANCEL_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_NOTGET_CANCEL_LEASE","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("FANGKAN_RED_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_FANGKAN_PUBLIC_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("TRACK_RED_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_TRACK_PUBLIC_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_RED_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_RED_TRACK_PUBLIC_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_CANCEL_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_NOTGET_CANCEL_BUY","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("FANGKAN_RED_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_FANGKAN_PUBLIC_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("TRACK_RED_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("RED_TRACK_PUBLIC_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_PUBLIC_RED_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("GET_RED_TRACK_PUBLIC_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_CANCEL_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("PUBLIC_NOTGET_CANCEL_RENT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("SALE_LIMIT","STRATEGY_PARAM_APART");
			PARTNER_PARAM.put("LEASE_LIMIT","STRATEGY_PARAM_APART");
			//隐号拨打
			List<String> param1= new ArrayList<>();
			List<String> param2= new ArrayList<>();
			List<String> param3= new ArrayList<>();
			List<String> param4= new ArrayList<>();
			List<String> param5= new ArrayList<>();
			PARTNER_DEPART_PARAM.put("IMPLICIT_CALL_APART",param1);
			PARTNER_DEPART_PARAM.put("TRANS_PLATE_RULE_APART",param2);
			PARTNER_DEPART_PARAM.put("PLATE_RANGE_APART",param3);
			PARTNER_DEPART_PARAM.put("CORE_INFO_APART",param4);
			PARTNER_DEPART_PARAM.put("STRATEGY_PARAM_APART",param5);
			param1.add("IS_OPEN_HIDEPHONE");
			param1.add("IS_OPEN_HIDE_SELF_PHONE_HOUSE");
			param1.add("IS_OPEN_HIDE_SELF_PHONE_CUSTOMER");
			param1.add("IPCALL_HIDEPHONE_COUNT");
			param1.add("IPCALL_AREA_HIDEPHONE_COUNT");
			param1.add("VOIP_USE_COMP_MONEY");
			//转盘
			param2.add("HOUSE_TRANSFER_FOR_WHO");
			param2.add("PRIVATE_HOUSE_TRANSFER");
			param2.add("PUBLIC_HOUSE_TRANSFER");
			param2.add("PUBLIC_CUST_TRANSFER");
			param2.add("PRIVATE_HOUSE_TRANSFER_PUBLIC");
			param2.add("PRIVATE_CUST_TRANSFER_PUBLIC");
			//公盘抢盘配置
			param3.add("SHARE_HOUSE_RANGE");
			param3.add("SHARE_CUST_RANGE");
			param3.add("PUBLIC_HOUSE_RANGE");
			param3.add("PUBLIC_CUST_RANGE");
			//核心信息
			param4.add("SHARE_FUN_CORE_DEPT");
			param4.add("SHARE_FUN_CORE_OTHER");
			param4.add("SHARE_CUST_CORE_DEPT");
			param4.add("SHARE_CUST_CORE_OTHER");
			param4.add("VIEW_HOUSE_COUNT_SELF");
			param4.add("VIEW_HOUSE_COUNT_OTHER");
			param4.add("VIEW_HOUSE_COUNT_OTHER_APP");
			param4.add("VIEW_CUST_COUNT_OTHER");
			param4.add("VIEW_CUST_COUNT_OTHER_APP");
			param5.add("SPECIAL_PROTECT_DAYS");
			param5.add("PASSWORD_RECORDS");
			param5.add("INFO_MAX_SECRECY");
			param5.add("SCHEDULE_PROTECT_DAYS");
			param5.add("WARMDAY_OF_RENTDUE");
			param5.add("RESPITE_PROTECT_DAYS");
			param5.add("DEPT_COMMEND_RECORDS");
			param5.add("COMMEND_RECORDS");
			param5.add("INFO_MAX_COMMEND_DAYS");
			param5.add("INFO_MAX_FOCUS_DAYS");
			param5.add("FANGKAN_RED_LEASE");
			param5.add("RED_FANGKAN_PUBLIC_LEASE");
			param5.add("TRACK_RED_LEASE");
			param5.add("RED_TRACK_PUBLIC_LEASE");
			param5.add("GET_PUBLIC_LEASE");
			param5.add("GET_PUBLIC_RED_LEASE");
			param5.add("GET_RED_TRACK_PUBLIC_LEASE");
			param5.add("PUBLIC_CANCEL_LEASE");
			param5.add("PUBLIC_NOTGET_CANCEL_LEASE");
			param5.add("FANGKAN_RED_BUY");
			param5.add("RED_FANGKAN_PUBLIC_BUY");
			param5.add("TRACK_RED_BUY");
			param5.add("RED_TRACK_PUBLIC_BUY");
			param5.add("GET_PUBLIC_BUY");
			param5.add("GET_PUBLIC_RED_BUY");
			param5.add("GET_RED_TRACK_PUBLIC_BUY");
			param5.add("PUBLIC_CANCEL_BUY");
			param5.add("PUBLIC_NOTGET_CANCEL_BUY");
			param5.add("FANGKAN_RED_RENT");
			param5.add("RED_FANGKAN_PUBLIC_RENT");
			param5.add("TRACK_RED_RENT");
			param5.add("RED_TRACK_PUBLIC_RENT");
			param5.add("GET_PUBLIC_RENT");
			param5.add("GET_PUBLIC_RED_RENT");
			param5.add("GET_RED_TRACK_PUBLIC_RENT");
			param5.add("PUBLIC_CANCEL_RENT");
			param5.add("PUBLIC_NOTGET_CANCEL_RENT");

			PARTNER_TRANS_PARAM.put("FANGKAN_RED_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("TRACK_RED_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_SELL","STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_SELL", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_SELL", "STRATEGY_PARAM_APART");


			PARTNER_TRANS_PARAM.put("FANGKAN_RED_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("TRACK_RED_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_LEASE", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_LEASE ", "STRATEGY_PARAM_APART");


			PARTNER_TRANS_PARAM.put("FANGKAN_RED_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("TRACK_RED_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_BUY", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_BUY", "STRATEGY_PARAM_APART");

			PARTNER_TRANS_PARAM.put("FANGKAN_RED_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("TRACK_RED_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_RENT", "STRATEGY_PARAM_APART");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_RENT", "STRATEGY_PARAM_APART");

			/*//公盘抢盘配置
			PARTNER_PARAM.put("SHARE_HOUSE_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("SHARE_CUST_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("PUBLIC_HOUSE_RANGE","PLATE_RANGE_APART");
			PARTNER_PARAM.put("PUBLIC_CUST_RANGE","PLATE_RANGE_APART");

			//核心信息
			PARTNER_PARAM.put("SHARE_FUN_CORE_DEPT","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_FUN_CORE_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_CUST_CORE_DEPT","CORE_INFO_APART");
			PARTNER_PARAM.put("SHARE_CUST_CORE_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_SELF","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_HOUSE_COUNT_OTHER_APP","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_SELF","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_OTHER","CORE_INFO_APART");
			PARTNER_PARAM.put("VIEW_CUST_COUNT_OTHER_APP","CORE_INFO_APART");*/
			
		/*	//转盘
			param2.add("HOUSE_TRANSFER_FOR_WHO");
			param2.add("PRIVATE_HOUSE_TRANSFER");
			param2.add("PUBLIC_HOUSE_TRANSFER");
			param2.add("PUBLIC_CUST_TRANSFER");
			param2.add("PRIVATE_HOUSE_TRANSFER_PUBLIC");
			param2.add("PRIVATE_CUST_TRANSFER_PUBLIC");*/
			PARTNER_TRANS_PARAM.put("HOUSE_TRANSFER_FOR_WHO", "成交、删除的房客源转为有效时所属人是否变更为操作人 1=是 0=否");
			PARTNER_TRANS_PARAM.put("PRIVATE_HOUSE_TRANSFER", "私盘房源是否允许申请转盘 1=是 0=否");
			PARTNER_TRANS_PARAM.put("PUBLIC_HOUSE_TRANSFER", "公盘房源数据是否允许移交，0=不允许，1=允许");
			PARTNER_TRANS_PARAM.put("PUBLIC_CUST_TRANSFER", "公盘客源数据是否允许移交，0=不允许，1=允许");
			PARTNER_TRANS_PARAM.put("PRIVATE_HOUSE_TRANSFER_PUBLIC", "私盘房源源移交至公盘  1=允许0=不允许");
			PARTNER_TRANS_PARAM.put("PRIVATE_CUST_TRANSFER_PUBLIC", "私盘客源源移交至公盘  1=允许0=不允许");
			PARTNER_TRANS_PARAM.put("SHARE_HOUSE_RANGE", "房源公盘查看及可抢盘范围：1:全公司,2:大区,3:片区,4:门店,5:分组");
			PARTNER_TRANS_PARAM.put("SHARE_CUST_RANGE", "客源公盘查看及可抢盘范围：1:全公司,2:大区,3:片区,4:门店,5:分组");
			PARTNER_TRANS_PARAM.put("PUBLIC_HOUSE_RANGE", "房源抢盘查看及可抢盘范围：1:全公司,2:大区,3:片区,4:门店,5:分组");
			PARTNER_TRANS_PARAM.put("PUBLIC_CUST_RANGE", "客源抢盘查看及可抢盘范围：1:全公司,2:大区,3:片区,4:门店,5:分组");
			PARTNER_TRANS_PARAM.put("SHARE_FUN_CORE_DEPT", "每人每天可查看本店公房核心信息最大条数");
			PARTNER_TRANS_PARAM.put("SHARE_FUN_CORE_OTHER", "每人每天可查看他店公房核心信息最大条数：");
			PARTNER_TRANS_PARAM.put("SHARE_CUST_CORE_DEPT", "每人每天可查看本店公客核心信息最大条数：");
			PARTNER_TRANS_PARAM.put("SHARE_CUST_CORE_OTHER", "每人每天可查看他店公客核心信息最大条数：");
			PARTNER_TRANS_PARAM.put("VIEW_HOUSE_COUNT_SELF", "每日可查看本人房源核心信息条数");
			PARTNER_TRANS_PARAM.put("VIEW_HOUSE_COUNT_OTHER", "每日可查看他人房源核心信息条数：");
			PARTNER_TRANS_PARAM.put("VIEW_HOUSE_COUNT_OTHER_APP", "每日APP可查看他人房源核心信息条数：");
			PARTNER_TRANS_PARAM.put("VIEW_CUST_COUNT_SELF", "每日可查看本人客源核心信息条数：");
			PARTNER_TRANS_PARAM.put("VIEW_CUST_COUNT_OTHER", "每日可查看他人客源核心信息条数：");
			PARTNER_TRANS_PARAM.put("VIEW_CUST_COUNT_OTHER_APP", "每日APP可查看他人客源核心信息条数：");
			PARTNER_TRANS_PARAM.put("IS_OPEN_HIDEPHONE", "房客源电话是否开启隐号拨打");
			PARTNER_TRANS_PARAM.put("IS_OPEN_HIDE_SELF_PHONE_HOUSE", "查看本人房源隐号");
			PARTNER_TRANS_PARAM.put("IS_OPEN_HIDE_SELF_PHONE_CUSTOMER", "查看本人客源隐号");
			PARTNER_TRANS_PARAM.put("IPCALL_HIDEPHONE_COUNT", "每人每天可隐号拨打房源电话条数 ");
			PARTNER_TRANS_PARAM.put("IPCALL_AREA_HIDEPHONE_COUNT", "每人每天可隐号拨打房源电话中，拨打其他大区电话的条数 ");
			PARTNER_TRANS_PARAM.put("VOIP_USE_COMP_MONEY", "每人每天可用公司资金账户多少元现金拨打隐号电话");
			PARTNER_TRANS_PARAM.put("PASSWORD_RECORDS", "各类加密信息每人可分别设置多少条 ");
			PARTNER_TRANS_PARAM.put("INFO_MAX_SECRECY", "各类加密信息每人可分别设置，有效期为多少条，期内他人不可查看电话");
			PARTNER_TRANS_PARAM.put("SPECIAL_PROTECT_DAYS", "各类封盘信息多少天之内不执行策略参数跳盘规则，期满自动转为普通信息 ");
			PARTNER_TRANS_PARAM.put("SCHEDULE_PROTECT_DAYS", "各类预订信息多少天之内不执行策略参数跳盘规则，期满自动转为普通信息");
			PARTNER_TRANS_PARAM.put("WARMDAY_OF_RENTDUE", "已成交出租房，租赁到期提前多少天提醒");
			PARTNER_TRANS_PARAM.put("RESPITE_PROTECT_DAYS", "暂缓保护器多少天，期满自动转为删除");
			PARTNER_TRANS_PARAM.put("DEPT_COMMEND_RECORDS", "租客推荐每店可分别推荐多少条");
			PARTNER_TRANS_PARAM.put("COMMEND_RECORDS", "租客推荐每店可分别推荐，每人可分别设置多少条");
			PARTNER_TRANS_PARAM.put("INFO_MAX_COMMEND_DAYS", "有效期为多少天，期满自动转为普通信息");
			PARTNER_TRANS_PARAM.put("INFO_MAX_FOCUS_DAYS", "租售房源笋盘有效期为多少天，期满自动转为普通信息");
			PARTNER_TRANS_PARAM.put("SALE_LIMIT", "每人可拥有私盘出售房源条数");
			PARTNER_TRANS_PARAM.put("LEASE_LIMIT", "每人可拥有私盘出租房源条数");

			PARTNER_TRANS_PARAM.put("FANGKAN_RED_SELL", "出售房源登记 FANGKAN_RED_SELL天后未房堪，信息变为红色警告");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_SELL", "出售房源红色警告后 RED_FANGKAN_PUBLIC_SELL 天后仍未房堪，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("TRACK_RED_SELL", "出售房源两次跟进间隔超过 TRACK_RED_SELL 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_SELL", "出售房源信息变为橙色警告，橙色警告后 RED_TRACK_PUBLIC_SELL 天仍未跟进，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_SELL", "每人每天最多可获 GET_PUBLIC_SELL 条出售抢盘信息");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_SELL", "所获出售房源抢盘信息未按规则跟进间隔超过 GET_PUBLIC_RED_SELL 天");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_SELL", "出售房源信息变为橙色警告抢盘信息橙色警告后 GET_RED_TRACK_PUBLIC_SELL 天未跟进，再次转为抢盘");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_SELL", "出售信息经过 PUBLIC_CANCEL_SELL 次抢盘后，永久转为公司资源");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_SELL", "出售房源抢盘信息 PUBLIC_NOTGET_CANCEL_SELL 天无人获取，永久转为公司资源");


			PARTNER_TRANS_PARAM.put("FANGKAN_RED_LEASE", "出租信息登记 FANGKAN_RED_LEASE 天后未房堪，信息变为红色警告");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_LEASE", "出租红色警告后 RED_FANGKAN_PUBLIC_LEASE 天后仍未房堪，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("TRACK_RED_LEASE", "出租两次跟进间隔超过 TRACK_RED_LEASE 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_LEASE", "出租橙色警告后 RED_TRACK_PUBLIC_LEASE 天仍未跟进，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_LEASE", "每人每天最多可获 GET_PUBLIC_LEASE 条出租抢盘信息");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_LEASE", "出租所获抢盘信息未按规则跟进间隔超过 GET_PUBLIC_RED_LEASE 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_LEASE", "出租抢盘信息橙色警告后 GET_RED_TRACK_PUBLIC_LEASE 天未跟进，再次转为抢盘");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_LEASE", "出租信息经过 PUBLIC_CANCEL_LEASE 次抢盘后，永久转为公司资源");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_LEASE", "出租抢盘信息 PUBLIC_NOTGET_CANCEL_LEASE 天无人获取，永久转为公司资源");


			PARTNER_TRANS_PARAM.put("FANGKAN_RED_BUY", "求购信息登记 FANGKAN_RED_BUY 天后未带看，信息变为红色警告");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_BUY", "求购红色警告后 RED_FANGKAN_PUBLIC_BUY 天后仍未带看，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("TRACK_RED_BUY", "求购两次跟进间隔超过 TRACK_RED_BUY 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_BUY", "求购橙色警告后 RED_TRACK_PUBLIC_BUY 天仍未跟进，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_BUY", "求购每人每天最多可获 GET_PUBLIC_BUY 条求购抢盘信息");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_BUY", "求购所获抢盘信息未按规则跟进间隔超过 GET_PUBLIC_RED_BUY 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_BUY", "求购抢盘信息橙色警告后 GET_RED_TRACK_PUBLIC_BUY 天未跟进，再次转为抢盘");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_BUY", "求购信息经过 PUBLIC_CANCEL_BUY 次抢盘后，永久转为公司资源");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_BUY", "求购抢盘信息 PUBLIC_NOTGET_CANCEL_BUY 天无人获取，永久转为公司资源");

			PARTNER_TRANS_PARAM.put("FANGKAN_RED_RENT", "求租信息登记 FANGKAN_RED_RENT 天后未带看，信息变为红色警告");
			PARTNER_TRANS_PARAM.put("RED_FANGKAN_PUBLIC_RENT", "求租红色警告后 RED_FANGKAN_PUBLIC_RENT 天后仍未带看，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("TRACK_RED_RENT", "求租两次跟进间隔超过 TRACK_RED_RENT 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("RED_TRACK_PUBLIC_RENT", "求租橙色警告后 RED_TRACK_PUBLIC_RENT 天仍未跟进，信息转为抢盘");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RENT", "求租每人每天最多可获 GET_PUBLIC_RENT 条求购抢盘信息");
			PARTNER_TRANS_PARAM.put("GET_PUBLIC_RED_RENT", "求租所获抢盘信息未按规则跟进间隔超过 GET_PUBLIC_RED_RENT 天，信息变为橙色警告");
			PARTNER_TRANS_PARAM.put("GET_RED_TRACK_PUBLIC_RENT", "求租抢盘信息橙色警告后 GET_RED_TRACK_PUBLIC_RENT 天未跟进，再次转为抢盘");
			PARTNER_TRANS_PARAM.put("PUBLIC_CANCEL_RENT", "求租信息经过 PUBLIC_CANCEL_RENT 次抢盘后，永久转为公司资源");
			PARTNER_TRANS_PARAM.put("PUBLIC_NOTGET_CANCEL_RENT", "求租抢盘信息 PUBLIC_NOTGET_CANCEL_RENT 天无人获取，永久转为公司资源");
		}

	}

	public static class OrganizationConfig{
		public static final Map<String, String> DB_PO_FIELD_MAPPING = new HashMap<>();

		static {
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_1", "columnName1");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_2", "columnName2");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_3", "columnName3");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_4", "columnName4");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_5", "columnName5");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_6", "columnName6");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_7", "columnName7");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_8", "columnName8");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_9", "columnName9");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_10", "columnName10");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_11", "columnName11");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_12", "columnName12");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_13", "columnName13");
			DB_PO_FIELD_MAPPING.put("COLUMN_NAME_14", "columnName14");
		}
	}
	
	// 美联委托失效原因（跟进类型）
	public static class ML_ENTRUST_INCALID_REASON {
		//1 删除委托 2.委托被撤销 3.委托签署时间超限 4.委托有效期时间超限  5.房源转暂缓 6.房源内成交 7房源外成交 8 房源转删除 9清空备案 10 修改价格 11.委托审核失败 12委托审核成功 13=修改委托
		/** 委托被删除 **/
		public static byte INCALID_REASON_1 = 1;
		
		/** 委托被撤销 **/
		public static byte INCALID_REASON_2 = 2;
		
		/** 委托签署时间超限 **/
		public static byte INCALID_REASON_3 = 3;
		
		/** 委托有效期时间超限 **/
		public static byte INCALID_REASON_4 = 4;
		
		/** 房源转暂缓 **/
		public static byte INCALID_REASON_5 = 5;
		
		/** 房源内成交 **/
		public static byte INCALID_REASON_6 = 6;
		
		/** 房源外成交 **/
		public static byte INCALID_REASON_7 = 7;
		
		/** 房源转删除 **/
		public static byte INCALID_REASON_8 = 8;
		
		/** 清空备案 **/
		public static byte INCALID_REASON_9 = 9;
		
		/** 修改价格 **/
		public static byte INCALID_REASON_10 = 10;
		
		/** 委托审核失败 **/
		public static byte INCALID_REASON_11 = 11;
		
		/** 委托审核成功 **/
		public static byte INCALID_REASON_12 = 12;
		
		/** 修改委托 **/
		public static byte INCALID_REASON_13 = 13;
		
	}

	/**正常登记0**/
	public final static Byte HOUSE_VERIFY_0 = 0;
	/**审核中1**/
	public final static Byte HOUSE_VERIFY_1 = 1;
	/**审核不通过2**/
	public final static Byte HOUSE_VERIFY_2 = 2;
	/**申诉中3**/
	public final static Byte HOUSE_VERIFY_3 = 3;

	/**
	 * 门店状态类型 CUST_STATUS
	 *
	 * @author Administrator
	 */
	public static class getDeptCustStatus {
		/** 意向 */
		public final static String DIC_CUST_STATUS_AVAILABLE = "AVAILABLE";
		/** 注销 */
		public final static String DIC_CUST_STATUS_FAILURE = "FAILURE";
		/** 试用 */
		public final static String DIC_CUST_STATUS_TRY = "TRY";
		/** 暂停 */
		public final static String DIC_CUST_STATUS_SUSPEND = "SUSPEND";
		/** 正式 */
		public final static String DIC_CUST_STATUS_FORMAL = "FORMAL";
		/** 停用 */
		public final static String DIC_CUST_STATUS_PAUSAL = "PAUSAL";

		/* CRM，门店付费状态 DEPT_FLAG */
		/** 意向 */
		public final static int DIC_DEPT_FLAG_AVAILABLE = -1;
		/** 注销 */
		public final static int DIC_DEPT_FLAG_FAILURE = -3;
		/** 试用 */
		public final static int DIC_DEPT_FLAG_TRY = 1;
		/** 暂停 */
		public final static int DIC_DEPT_FLAG_SUSPEND = 0;
		/** 正式 */
		public final static int DIC_DEPT_FLAG_FORMAL = 2;
		/** 停用 */
		public final static int DIC_DEPT_FLAG_PAUSAL = -2;
		/** 物业版 */
		public final static int DIC_DEPT_SUB_VERSION = 1;
	}

	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_1 = "房地产复印件";
	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_2 = "产权人身份资料复印件";
	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_3 = "房地产买卖合同复印件";
	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_4 = "购买发票复印件";
	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_5 = "付清房款证明复印件";
	public final static String DIC_DEPOSIT_FILE_FOR_CUSTOM_6 = "产权人委托书";
}


