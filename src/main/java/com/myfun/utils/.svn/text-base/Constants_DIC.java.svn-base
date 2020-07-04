package com.myfun.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统中使用到的字典数据和描述信息，请写在该类中，方便维护和管理。
 * @author 陈文超
 */
public final class Constants_DIC {
	/*上班类型*/
	/**正常上班*/
	public final static String DIC_WORK_TYPE_ONWORK = "1";
	/**上班(值)*/
	public final static String DIC_WORK_TYPE_DUTYWORK = "2";
	/**上班(晚)*/
	public final static String DIC_WORK_TYPE_LATEWORK = "3";
	/**正常下班*/
	public final static String DIC_WORK_TYPE_FREE = "4";
	/**下班(值)*/
	public final static String DIC_WORK_TYPE_DUTYFREE = "5";
	/**下班(早)*/
	public final static String DIC_WORK_TYPE_EARYFREE = "6";
	public final static Map<String,String> WORKONTOOFF = new HashMap<String,String>();
	public final static Map<String,String> WORKOFFTOON = new HashMap<String,String>();
	static{
		WORKONTOOFF.put(DIC_WORK_TYPE_ONWORK, DIC_WORK_TYPE_FREE);
		WORKONTOOFF.put(DIC_WORK_TYPE_DUTYWORK, DIC_WORK_TYPE_DUTYFREE);
		WORKONTOOFF.put(DIC_WORK_TYPE_LATEWORK, DIC_WORK_TYPE_EARYFREE);
		WORKOFFTOON.put(DIC_WORK_TYPE_FREE, DIC_WORK_TYPE_ONWORK);
		WORKOFFTOON.put(DIC_WORK_TYPE_DUTYFREE, DIC_WORK_TYPE_DUTYWORK);
		WORKOFFTOON.put(DIC_WORK_TYPE_EARYFREE, DIC_WORK_TYPE_LATEWORK);
		
	}
	/*数据字典CASE_TYPE*/
	/**跟踪类别：出售房源 1*/
	public final static String DIC_CASE_TYPE_SALE_FUN = "1";
	public final static Byte DIC_CASE_TYPE_SALE_FUN_BYTE = 1;
	/**跟踪类别：出租房源 2*/
	public final static String DIC_CASE_TYPE_LEASE_FUN = "2";
	public final static Byte DIC_CASE_TYPE_LEASE_FUN_BYTE = 2;
	/**跟踪类别：求购客户 3*/
	public final static String DIC_CASE_TYPE_BUY_CUST = "3";
	public final static Byte DIC_CASE_TYPE_BUY_CUST_BYTE = 3;
	/**跟踪类别：求租客户 4*/
	public final static String DIC_CASE_TYPE_RENT_CUST = "4";
	public final static Byte DIC_CASE_TYPE_RENT_CUST_BYTE = 4;
	/**类型：搜搜砖铺*/
	public final static String DIC_CASE_TYPE_SHOP_MAIN = "5";
	/**类型：搜搜合租*/
	public final static String DIC_CASE_TYPE_HEZU = "6";
	/**跟踪类别：出售合同 101*/
	public final static String DIC_CASE_TYPE_SALE_DEAL = "101";
	/**跟踪类别：出租合同 102*/
	public final static String DIC_CASE_TYPE_RENT_DEAL = "102";
	/**类型：金融 103*/
	public final static String DIC_CASE_TYPE_FINANCIAL = "103";
	
	/**发发新盘数据的类型,目前只在发发的COUNT_DONE表中使用,不会与求购的类型冲突 值： 3*/
	public final static String DIC_FAFA_CASE_TYPE_SALE_FUN = "3";
	
	/**跟进带看标记：无效带看 值:0*/
	public final static String DIC_TRACK_TARGET_FLAG_0 = "0";
	/**跟进带看标记：有效带看 值:1*/
	public final static String DIC_TRACK_TARGET_FLAG_1 = "1";

	/** 数据移交  **/
	public final static String DIC_TASK_TYPE_DATA_TURN = "24";//
	public final static String DIC_TASK_TYPE_DATA_TURN_STR = "[ 数据移交 ]";
	
	/*数据字典DEAL_STATUS*/
    /**
     * 未履行 值: 0
     */
    public final static String DIC_DEAL_STATUS_NODO = "0";
    public final static String DIC_DEAL_STATUS_NODODIC_CN_MSG = "未履行";

    /**
     * 履行中 值:1
     */
    public final static String DIC_DEAL_STATUS_DOING = "1";
    public final static String DIC_DEAL_STATUS_DOINGDIC_CN_MSG = "履行中";

    /**
     * 已办结 值:2
     */
    public final static String DIC_DEAL_STATUS_TRANSACT = "2";
    public final static String DIC_DEAL_STATUS_TRANSACTDIC_CN_MSG = "已办结";
    /**
     * 未办结 值:3
     */
    public final static String DIC_DEAL_STATUS_NOTTRANSACT = "3";
    /**
     * 尚未分配:0
     */
    public final static String DIC_DEAL_STATUS_NOTASSIGNED = "0";
    /**
     * 待结算 值:1
     */
    public final static String DIC_DEAL_STATUS_WAITDEAL = "1";//以前待结算值为3，在2016-05-23这期需求里面待结算值改为1，已结算改为2，新增尚未分配状态，合同创建的时候默认状态为尚未分配
    /**
     * 已结算 值:2
     */
    public final static String DIC_DEAL_STATUS_DEALOVER = "2";//以前已结算为4，同上改为2.
    /**
     * 合同状态 5：已撤销
     */
    public final static String DIC_DEAL_STATUS_CLOSE = "5";
    /**
     * 合同状态 6：未结算
     */
    public final static String DIC_DEAL_STATUS_NOTDEAL = "6";
    
    /**
     * 未作废 值：4
     */
    public final static String DIC_DEAL_COMPLETE_NOTFAIL = "4";//未作废2016-05-06 flj
	
	/*合同相关人员RELATE_TYPE*/
    /**
     * 合同创建人值:1
     */
    public final static String DIC_RELATE_TYPE_CREATOR = "1";
    /**
     * 流程总负责人:2
     */
    public final static String DIC_RELATE_TYPE_DEALUSER = "2";
    /**
     * 合同签约人值:3
     */
    public final static String DIC_RELATE_TYPE_SIGNUSER = "3";
    /**
     * 合同签约主管值:4
     */
    public final static String DIC_RELATE_TYPE_SIGNMANAGE = "4";
    /**
     * 合同流程执行人值:5
     */
    public final static String DIC_RELATE_TYPE_STEPUSER = "5";
    /**
     * 合同房源方值:6
     */
    public final static String DIC_RELATE_TYPE_HOUSEUSER = "6";
    /**
	 * 合同客源方值:7
	 */
	public final static String DIC_RELATE_TYPE_CUSTUSER = "7";
	/**
	 * 合同分成人:8
	 */
	public final static String DIC_RELATE_TYPE_PROFIT = "8";
	/*数据字典DEAL_UPDATE_CLASSIC*/
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALCREATE = "【合同创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALFIRSTTRIAL = "【合同初审】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALREPEATTRIAL = "【合同复审】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALCOUNTERAUDIT = "【撤销审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALINVALID = "【合同作废】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_DEALEDIT = "【合同修改】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACCREATE = "【财务款项创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACAUDITACCOUNTRECEIVABLE = "【应收审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACREALINCOMEAUDIT  = "【实收审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACUPDATE = "【财务款项更新】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACDEL = "【财务款项删除】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITCREATE = "【业绩创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITUPDATE = "【业绩更新】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITSETTLEMENT = "【业绩分配】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROFITDELETE = "【业绩删除】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATE = "【流程创建】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEDEAL = "【流程办结】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEALLDEAL = "【全流程办结】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE = "【流程修改】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_ADDCONTRACT = "【生成合同】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_ADDCONTRACT2 = "【生成协议】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_ADUIT2 = "【协议审核】";
	public final static String DIC_DEAL_UPDATE_CLASSIC_UPLOAD_PHOTO = "附件管理";
	/*数据字典TRACK_TYPE*/
	/**广播类型：公告 值:1*/
	public final static String DIC_BROADCAST_TYPE_BULLET = "1";
	/**广播类型：商家信息 值:2*/
	public final static String DIC_BROADCAST_TYPE_BUSUSINESS_INFORMATION = "2";
	/**广播类型：公告回复 值:3*/
	public final static String DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY = "3";
	/**广播类型：提醒任务 值:4*/
	public final static String DIC_BROADCAST_TYPE_REMINDER_TASK = "4";
	/**广播类型：对公告回复的回复 值:5*/
	public final static String DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY_REPLY = "5";
	/**广播类型：对引用回复的回复 值:6*/
	public final static String DIC_BROADCAST_TYPE_QUOTE_REPLY = "6";

//	/**
//	 * 跟进类别：电话 值:1
//	 */
//	public final static Byte DIC_TRACK_TYPE_PHONE = 1;
//	/**
//	 * 跟进类别：面谈 值:2
//	 */
//	public final static Byte DIC_TRACK_TYPE_TALK = 2;
//	/**
//	 * 跟进类别：房勘 值:3
//	 */
//	public final static Byte DIC_TRACK_TYPE_FUNCAN = 3;
//	/**
//	 * 跟进类别：带看 值:4
//	 */
//	public final static Byte DIC_TRACK_TYPE_DAIKAN = 4;
//	/**
//	 * 跟进类别：钥匙 值:5
//	 */
//	public final static Byte DIC_TRACK_TYPE_KEY = 5;
//	/**
//	 * 跟进类别：限时 值:6
//	 */
//	public final static Byte DIC_TRACK_TYPE_LIMITED = 6;
//	/**
//	 * 跟进类别：独家 值:7
//	 */
//	public final static Byte DIC_TRACK_TYPE_ALONE = 7;
//	/**
//	 * 跟进类别：现收 值:8
//	 */
//	public final static Byte DIC_TRACK_TYPE_CASH = 8;
//	/**
//	 * 跟进类别：包租 值:9
//	 */
//	public final static Byte DIC_TRACK_TYPE_RENT = 9;
//	/**
//	 * 跟进类别：修改 值:10
//	 */
//	public final static Byte DIC_TRACK_TYPE_EDIT = 10;
//	/**
//	 * 跟进类别：其他 值:11
//	 */
//	public final static Byte DIC_TRACK_TYPE_OTHER = 11;
//	/**
//	 * 跟进类别：审核 值:12
//	 */
//	public final static Byte DIC_TRACK_TYPE_AUDIT = 12;
//	/**
//	 * 跟进类别：系统 值:13
//	 */
//	public final static Byte DIC_TRACK_TYPE_SYSTEM = 13;
//	/**
//	 * 跟进类别：状态 值:14
//	 */
//	public final static Byte DIC_TRACK_TYPE_STATUS = 14;
//	/**
//	 * 跟进类别：议价 值:15
//	 */
//	public final static Byte DIC_TRACK_TYPE_BARGAIN = 15;
//	/**
//	 * 跟进类别：空看 值:16
//	 */
//	public final static Byte DIC_TRACK_TYPE_KONGKAN = 16;
//	/**
//	 * 跟进类别：级别-加密 值:17
//	 */
//	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD = 17;
//	/**
//	 * 跟进类别：级别-推荐 值:18
//	 */
//	public final static Byte DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND = 18;
//	/**
//	 * 跟进类别：普通委托 值:19
//	 */
//	public final static Byte DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT = 19;
//	/**跟进类别： 修改房源所属楼盘 值:20*/
//	public final static Byte DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD = 20;
//	/** 跟进类别： 转有效 值:21 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE = 21;
//	/** 跟进类别： 转私盘 值:22 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSPRIVATE = 22;
//	/** 跟进类别： 转售 值:23 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSSALE = 23;
//	/** 跟进类别： 转租 值:24 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_TRANSLEASE = 24;
//	/** 跟进类别： 预定 值:25 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_SCHEDULE = 25;
//	/** 跟进类别： 封盘 值:26 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_SPECIAL = 26;
//	/** 跟进类别： 暂缓 值:27 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_RESPITE = 27;
//	/** 跟进类别： 内成交 值:28 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_INNERDEAL = 28;
//	/** 跟进类别： 外成交 值:29 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_OUTDEAL = 29;
//	/** 跟进类别： 注销 值:30 */
//	public final static Byte DIC_TRACK_TYPE_STATUS_WRITEOFF = 30;
//	/** 跟进类别： 查看电话 值:31 */
//	public final static Byte DIC_TRACK_TYPE_VIEW_PHONE = 31;
//	/** 跟进类别：钥匙提交 值:32 */
//	public final static Byte DIC_TRACK_TYPE_SUBMIT_KEY = 32;
//	/** 跟进类别：借用钥匙 值:33 */
//	public final static Byte DIC_TRACK_TYPE_BORROW_KEY = 33;
//	/** 跟进类别：归还钥匙 值:34 */
//	public final static Byte DIC_TRACK_TYPE_RETURN_KEY = 34;
//	/** 跟进类别：钥匙注销 值:35 */
//	public final static Byte DIC_TRACK_TYPE_DESTROY_KEY = 35;
	/** 跟进类别：上传图片 值:36 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_UPLOAD = 36;
//	/** 跟进类别：删除图片 值:37 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_DELETE = 37;
//	/** 跟进类别：设置首图 值:38 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_TOP = 38;
//	/** 跟进类别：上传视频 值:39 */
//	public final static Byte DIC_TRACK_TYPE_VIDEO_UPLOAD = 39;
//	/** 跟进类别：删除视频 值:40 */
//	public final static Byte DIC_TRACK_TYPE_VIDEO_DELETE = 40;
//	/** 跟进类别：上传VR 值:41 */
//	public final static Byte DIC_TRACK_TYPE_VR_UPLOAD = 41;
//	/** 跟进类别：删除VR 值:42 */
//	public final static Byte DIC_TRACK_TYPE_VR_DELETE = 42;
//	/** 跟进类别：钥匙说明 值:43 */
//	public final static Byte DIC_TRACK_TYPE_KEY_EXPLAIN = 43;
//	/** 跟进类别：图片编辑 值:44 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_EDIT = 44;
//	/** 跟进类别：图片导入 值:45 */
	public final static Byte DIC_TRACK_TYPE_PHOTO_IMPORT = 45;
//	/** 跟进类别：重盘提醒 值:46 */
//	public final static Byte DIC_TRACK_TYPE_REPAEAT_REMIND = 46;
//	/**跟进类别： 房源相关人变更 值:47*/
//	public final static Byte DIC_TRACK_TYPE_RELATIVE_PEOPLE_CHANGE = 47;
//	/**跟进类别： 信息登记 值:48*/
//	public final static Byte DIC_TRACK_TYPE_REGISTER = 48;
//	/**跟进类别： 广告房源 值:49*/
//	public final static Byte DIC_TRACK_TYPE_ADSCASE = 49;
//	/**跟进类别： 状态转普通 50值：*/
//	public final static Byte DIC_TRACK_TYPE_STATUS_AVAILABLE = 50;
//	/**跟进类别： 跳抢盘 51值：*/
//	public final static Byte DIC_TRACK_TYPE_JUMP_PUBLIC = 51;
//	/**跟进类别： 跳公盘 52值：*/
//	public final static Byte DIC_TRACK_TYPE_JUMP_SHARE = 52;
//	/**跟进类别： 取消委托 53值：*/
//	public final static Byte DIC_TRACK_TYPE_CANCEL_WEITUO = 53;
//
//	/**跟进类别：钥匙借用 值:105*/
//	public final static Byte DIC_TRACK_TYPE_KEY_BORROW = 105;
//	/**跟进类别：钥匙归还 值:106*/
//	public final static Byte DIC_TRACK_TYPE_KEY_RETURN = 105;

	/**跟进的子类型 1:查看核心跟进 */
	public final static String DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA = "1";
	/** 跟进的子类型 2:提交钥匙跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_UPLOADKEY = "2";
	/** 跟进的子类型 3:上传图片跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE = "3";
	public final static Byte DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE_BYTE = 3;
	/**跟进的子类型 4:上传视频跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO = "4";
	/**跟进的子类型 5:优优好房跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_DIDI = "5";
	/** 跟进的子类型 6:删除图片跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_DELIMAGE = "6";
	public final static Byte DIC_TRACK_INCLUDE_TRACK_DELIMAGE_BYTE = 6;
	/** 跟进的子类型 7:编辑图片跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_EDITIMAGE = "7";
	/** 跟进的子类型 7:编辑图片跟进*/
	public final static Byte DIC_TRACK_INCLUDE_TRACK_EDITIMAGE_BYTE = 7;
	/**跟进的子类型 8:删除视频跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_DELVIDEO = "8";
	/** 跟进的子类型 9:登记房客源跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_REGISTER = "9";
	/**跟进的子类型 10:提交无钥匙跟进*/
	public final static String DIC_TRACK_INCLUDE_TRACK_NOKEY = "10";
	/** 跟进的子类型 11:720度全景相机图片跟进--陈文超-2016-05-11*/
	public final static String DIC_TRACK_INCLUDE_TRACK_PHOTO720 = "11";
	/**跟进的子类型 12:点亮真房源跟进类型 陈文超-2016-05-25*/
	public final static String DIC_TRACK_INCLUDE_TRACK_TRUEHOUSE = "12";
	/**跟进的子类型 13: 鸿基广告房源跟进类型*/
	public final static String DIC_TRACK_INCLUDE_TRACK_ADS_CASE = "13";
	/**跟进的子类型 14:房源发布到微店 陈文超-2016-06-07*/
	public final static String DIC_TRACK_INCLUDE_TRACK_MICROSHOP_PUBLISH = "14";// 发布微店--目前用于720设备统计，陈文超，2016-06-07
	/**跟进的子类型 15:房源从微店下架 陈文超-2016-06-07*/
	public final static String DIC_TRACK_INCLUDE_TRACK_MICROSHOP_DOWN = "15";// 下架微店--目前用于720设备统计陈文超 2016-06-07
	/** 跟进的子类型 16:重盘提醒*/
	public final static String DIC_TRACK_INCLUDE_TRACK_REPAEAT_REMIND = "16";
	/** 跟进的子类型 17:租房分期*/
	public final static String DIC_TRACK_INCLUDE_TRACK_RENT_STAGE = "17";
	
	/*数据字典HOUSE_LEVEL*/
	/**房源级别：普通 值:1*/
	public final static String DIC_HOUSE_LEVEL_COMMON = "1";
	/**房源级别：推荐 值:2*/
	public final static String DIC_HOUSE_LEVEL_COMMEND = "2";
	/**房源级别：加密 值:3*/
	public final static String DIC_HOUSE_LEVEL_PASSWORD = "3";
	
	/*数据字典PLATE_TYPE*/
	/**盘别：抢盘 值:1*/
	public final static String DIC_PLATE_TYPE_PUBLIC = "1";
	/**盘别：私盘 值:2*/
	public final static String DIC_PLATE_TYPE_PRIVATE = "2";
	/**盘别：公盘 值:3*/
	public final static String DIC_PLATE_TYPE_SHARE = "3";

	/**盘别英文描述：抢盘 值:PUBLIC*/
	public final static String DIC_PLATE_TYPE_PUBLIC_EN = "PUBLIC";
	/**盘别英文描述：私盘 值:PRIVATE*/
	public final static String DIC_PLATE_TYPE_PRIVATE_EN = "PRIVATE";
	/**盘别英文描述：公盘 值:SHARE*/
	public final static String DIC_PLATE_TYPE_SHARE_EN = "SHARE";
	/**
	 * 统一模式不区分盘别
	 */
	public final static String DIC_PLATE_TYPE_ALL_EN = "ALL";
	
	
	/*数据字典HOUSE_USEAGE*/
	/**房屋用途：住宅 值:1*/
	public final static String DIC_HOUSE_USEAGE_HOUSING = "1";
	/**房屋用途：别墅 值:2*/
	public final static String DIC_HOUSE_USEAGE_VILLA = "2";
	/**房屋用途：商铺 值:3*/
	public final static String DIC_HOUSE_USEAGE_TRADE = "3";
	/**房屋用途：写字 值:4*/
	public final static String DIC_HOUSE_USEAGE_OFFICE = "4";
	/**房屋用途：厂房 值:5*/
	public final static String DIC_HOUSE_USEAGE_MANUFACT = "5";
	/**房屋用途：仓库 值:6*/
	public final static String DIC_HOUSE_USEAGE_STORE = "6";
	/**房屋用途：车库 值:7*/
	public final static String DIC_HOUSE_USEAGE_GARAGE = "7";
	
	/*数据字典KEY_STATUS*/
	/**钥匙状态：借出 值:1*/
	public final static String DIC_KEY_STATUS_LEND = "1";
	/**钥匙状态：存档 值:2*/
	public final static String DIC_KEY_STATUS_ARCHIVE = "2";
	
	/*数据字典TASK_STATUS*/
	/**任务状态：未审 未阅 值:1*/
	public final static String DIC_TASK_STATUS_NEW = "1";
	public final static Byte DIC_TASK_STATUS_NEW_BYTE = 1;
	/**任务状态：处理中 值:2*/
	public final static String DIC_TASK_STATUS_DEAL = "2";
	/**任务状态：已审 已阅 值:3*/
	public final static String DIC_TASK_STATUS_COMPLETE = "3";
	public final static Byte DIC_TASK_STATUS_COMPLETE_BYTE = 3;
	/**任务状态：取消 值:4*/
	public final static String DIC_TASK_STATUS_CANCEL = "4";
	
	/*电话查看记录*/
	/**注销房客源的查看，不参与统计 值:0*/
	public final static String DIC_VIEW_STATUS_WRITEOFF = "0";
	/**有效查看，参与统计 值:1*/
	public final static String DIC_VIEW_STATUS_AVAILABLE = "1";
	
	/*数据字典HOUSE_STATUS   备注：1-4 都为有效状态*/
	/**房屋状态：有效 值:1*/
	public final static String DIC_HOUSE_STATUS_AVAILABLE = "1";
	/**房屋状态：封盘 值:2*/
	public final static String DIC_HOUSE_STATUS_SPECIAL = "2";
	/**房屋状态：暂缓 值:3*/
	public final static String DIC_HOUSE_STATUS_RESPITE = "3";
	/**房屋状态：预订 值:4*/
	public final static String DIC_HOUSE_STATUS_SCHEDULE = "4";
	/**房屋状态：内成交 值:5*/
	public final static String DIC_HOUSE_STATUS_INNERDEAL = "5";
	/**房屋状态：外成交 值:6*/
	public final static String DIC_HOUSE_STATUS_DEAL = "6";
	/**房屋状态：注销 值:7*/
	public final static String DIC_HOUSE_STATUS_WRITEOFF = "7";
	/**房屋状态：转售 值:101*/
	public final static String DIC_HOUSE_STATUS_TRANSSALE = "101";
	/**房屋状态：转租 值:102*/
	public final static String DIC_HOUSE_STATUS_TRANSLEASE = "102";
	/**房屋状态：转有效 值:103*/
	public final static String DIC_HOUSE_STATUS_TRANSAVAILABLE = "103";
	/**房屋状态：转私盘 值:104*/
	public final static String DIC_HOUSE_STATUS_TRANSPRIVATE = "104";
	
	/*数据字典TASK_TYPE*/
	/**任务类型：跟踪审核 值:1*/
	public final static String DIC_TASK_TYPE_EXAMIN = "1";
	public final static Integer DIC_TASK_TYPE_EXAMIN_INT = 1;
	/**任务类型：信息审核 值:2*/
	public final static Byte DIC_TASK_TYPE_VIEWEXAMIN = 2;
	/**任务类型：提醒任务 值:3*/
	public final static String DIC_TASK_TYPE_REMIND = "3";
	/**任务类型：留言任务 值:4*/
	public final static String DIC_TASK_TYPE_LEAVEWORD = "4";
	/**任务类型：钥匙借用 值:5*/
	public final static String DIC_TASK_TYPE_KEY_BORROW = "5";
	/**任务类型：钥匙归还 值:6*/
	public final static String DIC_TASK_TYPE_KEY_RETURN = "6";
	/**任务类型：合作提醒 值:7*/
	public final static String DIC_TASK_TYPE_COLL_REMIND = "7";
	public final static Integer DIC_TASK_TYPE_COLL_REMIND_INT = 7;
	/**任务类型：合作提醒 值:8*/
	public final static String DIC_TASK_TYPE_REPLY_REMIND = "8";
	/**任务类型：权证提醒 值:9*/
	public final static String DIC_TASK_TYPE_WARRANT_REMIND = "9";
	/**任务类型：查看信息警告 值:10*/
	public final static String DIC_TASK_TYPE_WARNING = "10";
	/**任务类型：投诉提醒 值:11*/
	public final static String DIC_TASK_TYPE_COMPLAINT = "11";
	public final static Integer DIC_TASK_TYPE_COMPLAINT_INT = 11;
	/**任务类型：申诉提醒 值:12*/
	public final static String DIC_TASK_TYPE_APPEAL = "12";
	
	/**审核结果：审核任务同意 值:1*/
	public final static String DIC_TASK_EXAMIN_RESULT_AGREEN = "1";
	/**审核结果：审核任务不同意 值:2*/
	public final static String DIC_TASK_EXAMIN_RESULT_DISAGREEN = "2";

	/*数据字典HOUSE_SOURCE*/
	/**房源来源：到店 值:1*/
	public final static String DIC_HOUSE_SOURCE_DIAN = "1";
	/**房源来源：开发 值:2*/
	public final static String DIC_HOUSE_SOURCE_DEVELOP = "2";
	/**房源来源：搜搜 值:3*/
	public final static String DIC_HOUSE_SOURCE_SOSO = "3";
	/**房源来源：发发 值:4*/
	public final static String DIC_HOUSE_SOURCE_FAFA = "4";
	/**房源来源：分配 值:5*/
	public final static String DIC_HOUSE_SOURCE_ALLOT = "5";
	/**房源来源：间接 值:6*/
	public final static String DIC_HOUSE_SOURCE_INDIRECT = "6";
	/**房源来源：现收 值:7*/
	public final static String DIC_HOUSE_SOURCE_CASH = "7";
	/**房源来源：搜房网 值:8*/
	public final static String DIC_HOUSE_SOURCE_SOUFUN_FAFA = "8";
	/**房源来源：房东网 值:9*/
	public final static String DIC_HOUSE_SOURCE_FUNDON_FAFA = "9";
	/**房源来源：赶集网 值:10*/
	public final static String DIC_HOUSE_SOURCE_GANJI_FAFA = "10";
	/**房源来源：安居客 值:11*/
	public final static String DIC_HOUSE_SOURCE_ANJUKE_FAFA = "11";
	/**房源来源：58同城 值:12*/
	public final static String DIC_HOUSE_SOURCE_58_FAFA = "12";
	/**房源来源：好房在线 值:13*/
	public final static String DIC_HOUSE_SOURCE_HFZX = "13";
	/**房源来源：网络来源 用于鸿基 值:14*/
	public final static String DIC_HOUSE_SOURCE_WEB = "14";
	/**房源来源：网络来源 用于赶集推广 值:15*/
	public final static String DIC_HOUSE_SOURCE_GANJITUIGUANG_FAFA = "15";
	/**房源来源：优优好房 值:18*/
	public final static String DIC_HOUSE_SOURCE_DIDI_HOUSE = "18";
	
//	/**房源来源：网络来源 用于推推99 值:16*/
//	public final static String DIC_HOUSE_SOURCE_TUITUI99_FAFA = "16";
//	/**房源来源：网络来源 用于土地公 值:17*/
//	public final static String DIC_HOUSE_SOURCE_TUDIGONG_FAFA = "17";
//	/**房源来源：网络来源 用于58网邻通 值:18*/
//	public final static String DIC_HOUSE_SOURCE_58WANGLINTONG_FAFA = "18";
//	/**房源来源：网络来源 用于百姓网 值:19*/
//	public final static String DIC_HOUSE_SOURCE_BAIXING_FAFA = "19";
	/**房源来源：中介数据
	 * 数据统计中在用，数据来源于搜搜
	 * */
	public final static String DIC_HOUSE_ZJ_DATA = "101";
	
	/**
	 * 数据的来源 HOUSE_SOURCE_WAY _ 1：本地 2：发发关联 3：发发转入
	 */
	/**
	 * 本地 值：1
	 */
	public final static String DIC_FAFA_HOUSE_SOURCE_WAY_1 = "1";
	/**
	 * 发发关联 值：2
	 */
	public final static String DIC_FAFA_HOUSE_SOURCE_WAY_2 = "2";
	/**
	 * 发发转入 值：3
	 */
	public final static String DIC_FAFA_HOUSE_SOURCE_WAY_3 = "3";
	
	/*数据字典USER_STATUS*/
	/**用户状态：正常使用 值:1*/
	public final static String DIC_USER_STATUS_FORMAL = "1";
	/**用户状态：暂停使用 值:3*/
	public final static String DIC_USER_STATUS_JOBLESS = "3";
	
	/**用户状态：未注销 值:0*/
	public final static String DIC_USER_NOT_WRITEOFF = "0";
	/**用户状态：已注销 值:1*/
	public final static String DIC_USER_WRITEOFF = "1";
	
	//数据库字典字段静态field
	/**内部合作 值:0*/
	public final static String INNERCOOP = "0";
	/**外部合作 值:1*/
	public final static String OUTCOOP = "1";

	/*数据字典RUNSTEP_STATUS*/
	/**未处理 值:7*/
	public final static String DIC_RUNSTEP_STATUS_NOTDOING = "1";
	/**待处理 值:2*/
	public final static String DIC_RUNSTEP_STATUS_WAITDOING = "2";
	/**已处理 值:3*/
	public final static String DIC_RUNSTEP_STATUS_SUCCESS = "3";
	/**跳过 值:4*/
	public final static String DIC_RUNSTEP_STATUS_SKIP = "4";
	
	/*数据字典DEAL_STATUS*/

	
	/*数据字典BUY_PAYTYPE 付款方式*/ 
	/**一次性 值:1*/
	public final static String DIC_DEAL_PAYTYPE_ONCE = "1";
	/**按揭 值:2*/
	public final static String DIC_DEAL_PAYTYPE_ANJIE = "2";
	/**均可 值:3*/
	public final static String DIC_DEAL_PAYTYPE_DOUBLE = "3";
	
	/*数据字典MORTGAGE_TYPE 按揭方式*/
	/**商业贷 值:1*/
	public final static String DIC_DEAL_MORTGAGE_SHOPLOAN = "1";
	/**公积金 值:2*/
	public final static String DIC_DEAL_MORTGAGE_PUBLICMONEY = "2";
	/**组合贷 值:3*/
	public final static String DIC_DEAL_MORTGAGE_MIXLOAN = "3";
	
	/*数据字典HOUSE_RIGHT权属*/
	/**产权 值:1*/
	public final static String DIC_HOUSE_RIGHT_PROPRIGHT = "1";
	/**合同 值:2*/
	public final static String DIC_HOUSE_RIGHT_CONTRACT = "2";
	/**协议 值:3*/
	public final static String DIC_HOUSE_RIGHT_PROTOCOL = "3";
	/**双证 值:4*/
	public final static String DIC_HOUSE_RIGHT_DOUBLE = "4";
	
	/*数据字典PRICE_UNIT租金单位*/
	/**元/月 值:1*/
	public final static String DIC_PRICE_UNIT_PERMONTH = "1";
	/**元/天 值:2*/
	public final static String DIC_PRICE_UNIT_PERDAY = "2";
	/**元/平米*月 值:3*/
	public final static String DIC_PRICE_UNIT_PERCENTIARE = "3";
	/**元/平米*天 值:4*/
	public final static String DIC_PRICE_UNIT_PERDAYCENT = "4";
	/** 元/年 值:5 */
    public final static String DIC_PRICE_UNIT_PERYEAR = "5";
	
	/*数据字典RENT_ACCOUNT出租付款方式*/ 
	/**月付 值:1*/
	public final static String DIC_RENT_ACCOUNT_MONTH = "1";
	/**季付 值:2*/
	public final static String DIC_RENT_ACCOUNT_PERIOD = "2";
	/**半年付 值:3*/
	public final static String DIC_RENT_ACCOUNT_HALFYEAR = "3";
	/**年付 值:4*/
	public final static String DIC_RENT_ACCOUNT_YEAR = "4";
	/**双月付 值:5*/
	public final static String DIC_RENT_ACCOUNT_DOUBLEMONTH= "5";
	
	/*数据字典TAX_TYPE税费支付*/
	/**买方支付 值:1*/
	public final static String DIC_TAX_TYPE_BUYPAY = "1";
	/**卖方支付 值:2*/
	public final static String DIC_TAX_TYPE_SELLPAY = "2";
	/**各自支付 值:3*/
	public final static String DIC_TAX_TYPE_EACHPAY = "3";
	
	/**无贷款 值:0*/
	public final static String  DIC_SELL_ISHAVE_LOAN_NO="0";//无贷款
	/**有贷款 值:1*/
	public final static String  DIC_SELL_ISHAVE_LOAN_YES="1";//有贷款
	
	/**其他还 值:0*/
	public final static String  DIC_SELL_RETURN_LOAN_OTHER="0";//其他还
	/**其他还 值:1*/
	public final static String  DIC_SELL_RETURN_LOAN_SELLER="1";//其他还
	
	/*数据字典 成交权证中管理中的内部合作和外部合作*/
	/**内部合作 值：0*/
	public final static String DIC_DEAL_INNERCOOP = "0";
	/**外部合作 值：1*/
	public final static String DIC_DEAL_OUTCOOP = "1";
	/**丘地号 值：1*/
	public final static String DIC_DEALOWNER_TYPE_QIUDI_NO = "1";
	/**证书号 值：2*/
	public final static String DIC_DEALOWNER_TYPE_ZHENGSHU_NO = "2";
	/**合同号 值：3*/
	public final static String DIC_DEALOWNER_TYPE_HETONG_NO = "3";
	/**证书号 值：4*/
	public final static String DIC_DEALOWNER_TYPE_BEIAN_NO = "4";
	
	/**需要审核 值：1*/
	public final static String DIC_DEAL_CONTRACT_SAVE_EXAM = "1";
	
	/**未审核 值：0*/
	public final static String DIC_DEAL_COMPLETE_INIT = "0";//未审核
	/**初审核通过 值：1*/
	public final static String DIC_DEAL_FIRSTCOMPLETE_OK = "1";//审核通过 更改为初审 2016-05-06 flj
	/**复审通过 值：2*/
	public final static String DIC_DEAL_REPEATCOMPLETE_OK = "2";//审核不通过 更改为复审 2016-05-06 flj
	/**作废 值：3*/
	public final static String DIC_DEAL_COMPLETE_FAIL = "3";//审核不通过 更改为复审 2016-05-06 flj
	
	/*数据字典HOUSE_CONSIGN*/
	/**委托：未委托 值：1*/
	public final static String DIC_HOUSE_CONSIGN_UNCONSIGN = "1";
	/**委托：限时 值：2*/
	public final static String DIC_HOUSE_CONSIGN_LIMITED = "2";
	/**委托：独家 值：3*/
	public final static String DIC_HOUSE_CONSIGN_ALONE = "3";
	/**委托：现收 值：4 -- 字典中已经取消该值*/
	public final static String DIC_HOUSE_CONSIGN_CASH = "4";
	/**委托：包租 值：5*/
	public final static String DIC_HOUSE_CONSIGN_RENT = "5";
	 /** 委托：普通 值：6*/
    public final static String DIC_HOUSE_CONSIGN_GENERAL = "6";

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
	/**半月内 值：16*/
	public final static String DIC_DATE_SEARCH_TYPE_FIFTEENDAYS = "16";
	
	/*上班状态*/
	/**准时*/
	public final static String DIC_WORK_STATUS_ONWORK = "1";
	/**迟到*/
	public final static String DIC_WORK_STATUS_DUTYWORK = "2";
	/**早退*/
	public final static String DIC_WORK_STATUS_LATEWORK = "3";
	/**旷工*/
	public final static String DIC_WORK_STATUS_FREE = "4";
	/**病假*/
	public final static String DIC_WORK_STATUS_DUTYFREE = "5";
	/**事假*/
	public final static String DIC_WORK_STATUS_EARYFREE = "6";
	/**休假*/
	public final static String DIC_WORK_STATUS_VACATION = "7";

	/*数据字典EXAMIN_RESULT任务结果*/ 
	/**同意*/
	public final static String DIC_EXAMIN_RESULT_AGREEN = "1";
	/**不同意*/
	public final static String DIC_EXAMIN_RESULT_DISAGREEN = "2";
	
	/*数据字典HOUSE_TYPE*/
	/**房屋类型：多层(多层)*/
	public final static String DIC_HOUSE_MUILT = "1";
	/**房屋类型：电梯(电梯))*/
	public final static String DIC_HOUSE_ELEVATOR = "2";
	/**房屋类型：底楼花园(底花)*/
	public final static String DIC_HOUSE_GROUND = "3";
	/**房屋类型：顶楼花园(顶花)*/
	public final static String DIC_HOUSE_TOP = "4";
	/**房屋类型：平房*/
	public final static String DIC_HOUSE_BUNGALOW = "5";
	/**房屋类型：独院(独院)*/
	public final static String DIC_HOUSE_ALONE = "6";
	/**房屋类型：商住两用(商住)*/
	public final static String DIC_HOUSE_BIZRESIDENCE = "7";
	/**房屋类型：写住两用(写住)*/
	public final static String DIC_HOUSE_OFCRESIDENCE = "8";
	/**房屋类型：独栋别墅(独栋)*/
	public final static String DIC_HOUSE_ALONEVILLA = "9";
	/**房屋类型：连体别墅(连体)*/
	public final static String DIC_HOUSE_TOGTHERVILLA = "10";
	/**房屋类型：叠拼别墅(叠拼)*/
	public final static String DIC_HOUSE_OVERVILLA = "11";
	/**房屋类型：双拼别墅(双拼)*/
	public final static String DIC_HOUSE_DOUBLEVILLA = "12";
	/**房屋类型：住宅底商(住底)*/
	public final static String DIC_HOUSE_13 = "13";
	/**房屋类型：商业街商铺(街铺)*/
	public final static String DIC_HOUSE_14 = "14";
	/**房屋类型：酒店底商(酒底)*/
	public final static String DIC_HOUSE_15 = "15";
	/**房屋类型：社区商铺(社商)*/
	public final static String DIC_HOUSE_16 = "16";
	/**房屋类型：旅游商铺(旅商)*/
	public final static String DIC_HOUSE_17 = "17";
	/**房屋类型：沿街门脸(门脸)*/
	public final static String DIC_HOUSE_18 = "18";
	/**房屋类型：写字楼配套底商(写底)*/
	public final static String DIC_HOUSE_19 = "19";
	/**房屋类型：购物中心/综合体(综合)*/
	public final static String DIC_HOUSE_20 = "20";
	/**房屋类型：卖场*/
	public final static String DIC_HOUSE_21 = "21";
	/**房屋类型：商住两用(商住)*/
	public final static String DIC_HOUSE_22 = "22";
	/**房屋类型：纯写字楼(写字)*/
	public final static String DIC_HOUSE_23 = "23";
	/**房屋类型：写住两用(写住)*/
	public final static String DIC_HOUSE_24 = "24";
	/**房屋类型：其他*/
	public final static String DIC_HOUSE_25 = "25";
	
	/** * 城市 值：0*/
	public final static String DIC_DEPT_TYPE_0 = "0";
	/** * 企业 值：1*/
	public final static String DIC_DEPT_TYPE_1 = "1";
	/** * 专业 值：2*/
	public final static String DIC_DEPT_TYPE_2 = "2";
	/** * 赢销 值：3*/
	public final static String DIC_DEPT_TYPE_3 = "3";
	
	/**系统运行模式-全公盘制 值：PUBLIC*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC = "PUBLIC";
	/**系统运行模式-仅公客制 值：PUBCUST*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST = "PUBCUST";
	/**系统运行模式-仅公房制 值：PUBFUN*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN = "PUBFUN";
	/**系统运行模式-私盘制 值：PRIVATE*/
	public final static String DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE = "PRIVATE";
	
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
	public final static String DIC_TRACKCLASSIC_7 = "[ 数据修改 ]";
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
	/**taskTitle [ 相关人员  ]*/
	public final static String DIC_TASK_SUBJECT_HEAD_25 = "[ 相关人员 ]";

	/**task type flag [ 系统用户ID 统一使用999 包含：系统任务、系统跟进、系统留言等]*/
	public final static String DIC_SYSTEM_USERID_999 = "999";
	public final static Integer DIC_SYSTEM_USERID_999_INT = 999;
	/** 优优好房用户ID 998 */
	public final static String DIC_SYSTEM_USERID_998 = "998";
	public final static Integer DIC_SYSTEM_USERID_998_INT = 998;
	/** 优优好房用户名 998 */
	public final static String DIC_SYSTEM_USERNAME_998 = "优优好房";
	/**系统默认用户名[ 公告不存在的用户名、 ]**/
	public final static String DIC_SYSTEM_USERNAME = "好房达人";
	
	/**task type flag [ 提醒任务 ]*/
	public final static String DIC_TASK_TYPE_FLAG_0 = "0";
	/**task type flag [ 审核任务 ]*/
	public  final static String DIC_TASK_TYPE_FLAG_1 = "1";
	
	/** profit count type 业绩统计方式 按公司统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_COMP = "5";
	/** profit count type 业绩统计方式 按大区统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_AREA = "4";
	/** profit count type 业绩统计方式 按片区统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_REG = "3";
	/** profit count type 业绩统计方式 按门店统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_DEPT = "2";
	/** profit count type 业绩统计方式 按分组统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_GROUP = "-1";
	/** profit count type 业绩统计方式 按员工统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_USER = "1";
	/** profit count type 业绩统计方式 无限组织架构统计 */
	public final static String DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION = "-1";
	
	/**公司门店版的类型---企业版 值：1*/
	public final static String DIC_COMP_TYPE_1 = "1";
	/**公司门店版的类型---专业版 值：2*/
	public final static String DIC_COMP_TYPE_2 = "2";
	/**公司门店版的类型---赢销版 值：3*/
	public final static String DIC_COMP_TYPE_3 = "3";
	
	/**公司企业版子类型---物业版 值：1*/
	public final static String DIC_COMP_TYPE_2_SUB_VERSION_1 = "1";
	
	/**用户账号的类型---赢销版账号 值：-1*/
	public final static String DIC_USER_EDITION_WIN_PER = "-1";
	/**用户账号的类型---企业版账号 值：0*/
	public final static String DIC_USER_EDITION_0 = "0";
	/**用户账号的类型---专业版账号 值：1*/
	public final static String DIC_USER_EDITION_1 = "1";
	/**用户账号的类型---纯个人版(纯精英版,没有所属门店) 值：2*/
	public final static String DIC_USER_EDITION_2 = "2";
	
	/**鸿基公司类型的系统参数控制--因为这个参数可能会变--先写到这里，方便以后增加参数后统一修改IS_OPEN_TRACK
	 * 该值设置在erp库的SYS_PARA表中 select * from sys_para where PARAM_ID = 'IS_OPEN_TRACK' and COMP_ID = ?
	 * */
	public final static String DIC_HONGJI_COMP_MODEL = "IS_OPEN_TRACK";
	/**代表是鸿基公司模式的公司 值为0，其他不管。最初该需求为鸿基公司定制，故以此命名。*/
	public final static String DIC_IS_HONGJI_COMP_MODEL = "0";
	public final static String DIC_IS_KEWEI_COMP_MODEL = "2";
	/** 加盟总店查看范围：加盟体系 1  */
	public final static String DIC_COMP_VIEW_RANGE = "1";
	/** 加盟总店查看范围：加盟圈 2  */
	public final static String DIC_COMP_VIEW_RANGE_2 = "2";
	
	/** 钥匙状态 借出状态 1 */
	public final static String KEY_STATUS_BORROWOUT = "1";
	/** 钥匙状态 存档状态 2 */
	public final static String KEY_STATUS_HOLDON = "2";
	/** 普通权限 0 */
	public final static String ORDINARY_PERMISSIONS = "0";
	/** 高级权限 1 */
	public final static String ADVANCED_PERMISSIONS = "1";
	
	/**该房源与本公司同小区房源电话、地址重复，是否保存*/
	public final static String DIC_HOUSE_PHONE_REPEAT_3 = "3";
	/**该房源与本公司同小区房源地址重复，是否保存*/
	public final static String DIC_HOUSE_PHONE_REPEAT_2 = "2";
	/**该房源与本公司其他房源电话重复，是否保存*/
	public final static String DIC_HOUSE_PHONE_REPEAT_1 = "1";
	
	/** 未回复 **/
	public final static String DIC_COLL_FLAG_0 = "0";
	/** 请求 **/
	public final static String DIC_COLL_FLAG_1 = "1";
	/** 接收 **/
	public final static String DIC_COLL_FLAG_2 = "2";
	
	/**
	 * 竞价推广使用 只使用了公司 值：1
	 */
	public final static String DIC_BIDD_COMP_UA_TYPE = "1";//只使用了公司
	/**
	 * 竞价推广使用 只使用了个人 值：2
	 */
	public final static String DIC_BIDD_PER_UA_TYPE = "2";//只使用了个人
	/**
	 * 竞价推广使用 公司和个人都是用了 值：3
	 */
	public final static String DIC_BIDD_ALL_UA_TYPE = "3";//公司和个人都是用了
	/**
	 * 竞价推广出价状态正常:0
	 */
	public final static String DIC_CAPITAL_OFFER_YES = "0";
	/**
	 * 竞价推广出价状态异常:1
	 */
	public final static String DIC_CAPITAL_OFFER_NO = "1";
	
    // 小区推广
	//1:我要续期 2:立即抢驻 3:预约下期 4:预约被超出 5:等待下期
	/**
	 * 1:我要续期 -- 出现情况：关注的楼盘自己已经竞价成功，并且自己已经预约下一期，而且是出价最高的。
	 */
	public final static String DIC_BUILD_BIDD_FLAG_1 = "1";
	/**
	 * 2:立即抢驻 -- 出现情况：关注的楼盘还没有用户参与竞价
	 */
	public final static String DIC_BUILD_BIDD_FLAG_2 = "2";
	/**
	 * 3:预约下期 -- 出现情况：关注的楼盘他人已经竞价成功，并且自己没有出价预约下一期
	 */
	public final static String DIC_BUILD_BIDD_FLAG_3 = "3";
	/**
	 * 4:预约被超出 -- 出现情况：关注的楼盘他人/自己已经竞价成功，并且自己出价预约下一期时 被后面的人超越。
	 */
	public final static String DIC_BUILD_BIDD_FLAG_4 = "4";
	/**
	 * 5:等待下期
	 */
	public final static String DIC_BUILD_BIDD_FLAG_5 = "5";
	
	/**
	 * 小区竞价允许的个数,目前最多6个
	 */
	public final static int DIC_BUILD_BIDD_SIZE = 6;
	/**
	 * 腾讯发发网站id
	 * SITE_ID=159
	 */
	public final static String TENCENT_SITE_ID = "159";
	
	/**
	 * 推广竞价的描述语言
	 */
	/**
	 * 竞价时自己的出价没能超越自己之前的出价。
	 */
	public final static String TEXT_BIDD_SELF = "您没能超越您之前的出价 #PRICE#，请重新输入竞价价格！";
	/**
	 * 系统控制的出价最小值
	 */
	public final static String TEXT_BIDD_LIMIT_MIN = "您的出价不能低于系统设定最低价格 #PRICE#，请重新输入竞价价格！";
	/**
	 * 系统控制的出价最大值
	 */
	public final static String TEXT_BIDD_LIMIT_MAX = "您的出价不能超过系统设定最高价格 #PRICE#，请重新输入竞价价格！";
	/**
	 * 用户出价没能超越之前的第一名用户的出价
	 */
	public final static String TEXT_BIDD_BEYOND_OLD_PRICE = "您的出价没能超越 #PRICE# ，请重新输入竞价价格！";
	/**
	 * 佣金计算方式 1: 百分比计算
	 */
	public static final String DIC_BROKERAGE_TYPE_RATE = "1";
	/**
	 * 佣金计算方式 1: 按月计算
	 */
	public static final String DIC_BROKERAGE_TYPE_MONTH = "2";
	/**
	 * 财务收付的款项名称 1:佣金
	 */
	public static final String DIC_PFNAME_YONGJIN = "1";
	/**
	 * 财务收付的款项名称 2:定金
	 */
	public static final String DIC_PFNAME_DINGJIN = "2";
	/**
	 * 财务收付的款项名称 3:代收款
	 */
	public static final String DIC_PFNAME_DAISHOUKUAN = "3";
	/**
	 * 财务收付的款项名称 4:营业税
	 */
	public static final String DIC_PFNAME_YINGYESHUI = "4";
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
	 * 财务收付的类型 0: 应收
	 */
	public static final String DIC_PFTYPE_YINGSHOU = "0";
	/**
	 * 财务收付的类型 1: 实收
	 */
	public static final String DIC_PFTYPE_SHISHOU = "1";
	/**
	 * 提成的计算方式 1:阶梯计算
	 */
	public static final String DIC_WAGE_COUNT_TYPE_JT = "1";
	/**
	 * 提成的计算方式 2:通提计算
	 */
	public static final String DIC_WAGE_COUNT_TYPE_TT = "2";
	/** IP电话拨打类型 房客源  1**/
	public static final String DIC_CALL_TYPE_1 = "1";
	
	/** IP电话拨打类型 搜搜数据  2**/
	public static final String DIC_CALL_TYPE_SOSO = "2";
	
	/** IP电话拨打类型 直供   3**/
	public static final String DIC_CALL_TYPE_VIP = "3";
	/** IP电话拨打类型 搜搜出售   3**/
	public static final String DIC_CALL_TYPE_SOSO_SALE = "5";
	/**直供类别：直供出售 9*/
	public final static String DIC_CALL_TYPE_VIP_SALE_FUN = "9";
	/**直供类别：直供出租 10*/
	public final static String DIC_CALL_TYPE_VIP_LEASE_FUN = "10";
	/**直供类别：直供求购 11*/
	public final static String DIC_CALL_TYPE_VIP_BUY_CUST = "11";
	/**直供类别：直供求租 12*/
	public final static String DIC_CALL_TYPE_VIP_RENT_CUST = "12";
	
	/**好房YOU+电话拨打出售 23*/
	public final static String DIC_CALL_TYPE_VIP_YOU_SALE = "23";
	/**好房YOU+电话拨打出租 24*/
	public final static String DIC_CALL_TYPE_VIP_YOU_LEASE = "24";
	/**好房YOU+电话拨打楼盘 25*/
	public final static String DIC_CALL_TYPE_VIP_YOU_BUILD = "25";
	/**管理中心楼盘资料26*/
	public final static String DIC_CALL_TYPE_BUILD_INFO = "26";
	/**
	 * 房源表分享ID默认值
	 */
	public final static String DIC_YOU_SHARE_ID_DEFAULT_0 = "0";
	
	/**
	 * 0:该公司没有开启大区
	 */
	public static final String DIC_NO_OPEN_AREA = "0";
	/**
	 * 1:该公司开启大区
	 */
	public static final String DIC_OPEN_AREA = "1";
	/**
	 * 发发统计 统计类型 COMP:按公司统计 默认
	 */
	public static final String FAFA_COUNT_TYPE_COMP = "COMP";
	/**
	 * 发发统计 统计类型 AREA:按大区统计
	 */
	public static final String FAFA_COUNT_TYPE_AREA = "AREA";
	/**
	 * 发发统计 统计类型 REG:按片区统计
	 */
	public static final String FAFA_COUNT_TYPE_REG = "REG";
	/**
	 * 发发统计 统计类型 DEPT:按门店统计
	 */
	public static final String FAFA_COUNT_TYPE_DEPT = "DEPT";
	/**
	 * 发发统计 统计类型 GROUP:按分组统计
	 */
	public static final String FAFA_COUNT_TYPE_GROUP = "GROUP";
	/**
	 * 发发统计 统计类型 USER:按员工统计
	 */
	public static final String FAFA_COUNT_TYPE_USER = "USER";
	/**
	 * 发发统计 统计类型 HOUSE:按房源统计
	 */
	public static final String FAFA_COUNT_TYPE_HOUSE = "HOUSE";
	/**
	 * 数据排序类型 ASC:顺序排序,从小到大
	 */
	public static final String DATA_SORT_TYPE_ASC = "ASC";
	/**
	 * 数据排序类型 DESC:顺序排序,从大到小
	 */
	public static final String DATA_SORT_TYPE_DESC = "DESC";
	/**
	 * 租售类型 1: 出售
	 */
	public static final String SALE = "1";
	/**
	 * 租售类型 2: 出租
	 */
	public static final String LEASE = "2";
	/**
	 * 业绩发放状态 0:未选中状态
	 */
	public static final String SETTLE_FLAG_NOCHECK = "0";
	/**
	 * 业绩发放状态 1:选中状态
	 */
	public static final String SETTLE_FLAG_CHECKED = "1";
	/**
	 * 业绩发放状态 2:已发放,只有这种情况会有发放时间 SETTLE_TIME
	 */
	public static final String SETTLE_FLAG_GIVE_OUT = "2";
	/**
	 * 腾讯网上架标记 上架：1
	 */
	public static final String DIC_QQ_PUBLISH_SITE_ONLINE = "1";
	public static final Integer DIC_QQ_PUBLISH_SITE_ONLINE_INT = 1;
	/**
	 * 腾讯网上架标记 下架：-1
	 */
	public static final String DIC_QQ_PUBLISH_SITE_OFFLINE = "-1";
	
	/**
	 * 腾讯网同步标记 未同步：0
	 */
	public static final String DIC_QQ_PUBLISH_SYNC_FLAG_0 = "0";
	/**
	 * 片区表中主城区
	 */
	public static final String DIC_REG_IS_MAIN_REG = "1";
	/**
	 * 片区表中非主城区
	 */
	public static final String DIC_REG_NO_MAIN_REG = "0";
	
	/**
	 * 0 全公司【本公司】 范围
	 */
	public static final String DIC_BOUND_0 = "0";
	/**
	 * 1 共享圈 范围
	 */
	public static final String DIC_BOUND_1 = "1";
	/**
	 * 2 全系统 范围
	 */
	public static final String DIC_BOUND_2 = "2";
	/**
	 * 3 好友圈 范围  至于为什么要用3，不要问为什么，用就是了。
	 */
	public static final String DIC_BOUND_3 = "3";
	
	/**
	 * 用于构建SQL 字段的前缀
	 * 想把字段的 一个值更新为 该表上另一个字段的值
	 * 	table (USER_NAME varchar(30),
	 * 				USER_CNAME varchar(30),
	 * 				USER_ID int)
	 * 例：update TABLE set USER_NAME = USER_CNAME where USER_ID = ?
	 */
	public static final String DIC_SQL_COLUMN = "COLUMN#";
	/** 发发的网络发布 值：101000*/
	public static final String FF_PUB_COUNT = "101000";
	/** 发发的网络刷新 值：104000*/
	public static final String FF_REF_COUNT = "104000";
	/** 操作类型发布 值：1*/
	public static final String OPER_TYPE_PUB_COUNT = "1";
	/** 操作类型刷新 值：4*/
	public static final String OPER_TYPE_REF_COUNT = "4";
	/** 查看核心信息 值：1*/
	public static final String LOOK_CORE_INFO="1";
	/** 房源套内面积 值：1*/
	public static final String HOUSE_INNERAREA = "1";
	/** 已房勘 值：1*/
	public static final String DONE_FK_COUNT = "1";
	/** 已带看 值：1*/
	public static final String DONE_DK_COUNT = "1";
	
	/**
	 * SOLR引擎是否可用 值：1
	 */
	public static final String DIC_SOSO_USE_SOLR_FLAG = "1";
	
	/**门店状态 暂停 值：0**/
	public static final String DIC_DEPT_FLAG_0 = "0";
	/**门店状态 试用 值：1**/
	public static final String DIC_DEPT_FLAG_1 = "1";
	/**门店状态 正式 值：2**/
	public static final String DIC_DEPT_FLAG_2 = "2";
	/**门店状态 跟进 值：-1**/
	public static final String DIC_DEPT_FLAG__1 = "-1";
	/**门店状态 停用 值：-2**/
	public static final String DIC_DEPT_FLAG__2 = "-2";
	
	/**房勘和带看 是否有视频或者图片标记 。 是:1**/
	public static final String DIC_TRACK_RESULT_1 = "1";
	public static final Byte DIC_TRACK_RESULT_1_BYTE = 1;

	/**获取可以上架到腾讯网的数据量*/
	public static final String DIC_QQ_SEND_NUM_KEY = "sendToTencentNum";
	
	/**
	 * 房源数据的重复判断
	 * ERP SYS_PARA 表中的参数
	 */
	/**
	 *允许录入重复数据，值：0
	 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_0 = "0";
	/**
	 *不允许录入地址重复的房源数据，值：1
	 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_1 = "1";
	/**
	 *不允许录入地址和电话同时重复的房源，值：2
	 */
	public static final String DIC_SYSPARA_HOUSE_REPEAT_RULE_2 = "2";
	
	/**
	 *允许录入重复的客源数据，值：1
	 */
	public static final String DIC_SYSPARA_CUST_REPEAT_RULE_0 = "0";
	/**
	 *不允许录入身份证和电话同时重复的客源，值：2
	 */
	public static final String DIC_SYSPARA_CUST_REPEAT_RULE_2 = "2";
	
	/**
	 * 财务状态 FINANC 值：1
	 */
	public static final String DIC_PROFIT_FINANC_TYPE_1 = "1";

	/**
	 * 合同类别 PROFIT 值：2
	 */
	public static final String DIC_PROFIT_FINANC_TYPE_2 = "2";
	
	/**
	 * 小区和房源竞价来源
	 * 1：代表是通过ERP竞价的
	 */
	public static final String DIC_BIDDING_SOURCE_1 = "1";
	
	/** voip 拨号返回值  余额不足0 **/
	public static final String DIC_VOIP_RESULT_LOW = "0";
	/** voip 拨号返回值  成功1 **/
	public static final String DIC_VOIP_RESULT_OK = "1";
	/** voip 拨号返回值  拨打异常2 **/
	public static final String DIC_VOIP_RESULT_FAIL = "2";
	/** IP拨号返回值  IP_POOL不足 **/
	public static final String DIC_VOIP_RESULT_POOL_OVERFLOW = "3";

	/** 拨打IP电话的参数  1：房客源 **/
	public static final String DIC_VOIP_SOURCE_TYPE_HOUSE = "1";
	/** 拨打IP电话的参数  2：搜搜 **/
	public static final String DIC_VOIP_SOURCE_TYPE_SOSO = "2";
	
	/** voip 拨号类型 默认 1 **/
	public static final String DIC_CALL_VOIP_TYPE_1 = "1";
	/** voip 拨号类型 待添加 2 **/
	public static final String DIC_CALL_VOIP_TYPE_2 = "2";
	public static final String DIC_CALL_VOIP_TYPE_3 = "3";
	public static final String DIC_CALL_VOIP_TYPE_4 = "4";

	/** 楼盘设置是否已锁定 是1 **/
	public static final String DIC_BUILDING_IS_LOCK = "1";
	
	/**临时定义 RPT报表数据库名， 这个更换几率很小，后期如果跨服务器请做修改，陈文超 hft_admindb_rpt*/
	public static final String DIC_DBNAME_HFT_ADMINDB_RPT = "hft_admindb_rpt";
	
	/**
	 * 跑分系统-----------------------------开始------------------------
	 */
	/**
	 * 统计全城  值：CITY
	 */
	public final static String DIC_INTEGRAL_COUNT_RANGE_ALL = "CITY";
	/**
	 * 统计本门店  值：DEPT
	 */
	public final static String DIC_INTEGRAL_COUNT_RANGE_DEPT = "DEPT";
	/**
	 * 统计本人  值：USER
	 */
	public final static String DIC_INTEGRAL_COUNT_RANGE_USER = "USER";
	
	/**
	 * 业务指数 值:1
	 */
	public final static String DIC_INTEGRAL_COUNT_TYPE_BIZ = "1";
	/**
	 * 营销指数 值:2
	 */
	public final static String DIC_INTEGRAL_COUNT_TYPE_MARKETING = "2";
	/**
	 * 业绩指数 值:3
	 */
	public final static String DIC_INTEGRAL_COUNT_TYPE_PROFIT = "3";
	/**
	 * 合计指数 值:4
	 */
	public final static String DIC_INTEGRAL_COUNT_TYPE_SUM = "4";
	/**
	 * 1 ERP完成带看积分 值：DAIKAN_TRACK
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_DAIKAN_TRACK = "DAIKAN_TRACK";
	/**
	 * 2 ERP完成登记房源的积分 值：HOUSE
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_HOUSE = "HOUSE";
	/**
	 * 3 ERP完成客源登记的积分 值：CUST
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_CUST = "CUST";
	/**
	 * 4 ERP完成图片上传的积分 值：PIC_SUBMIT
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_PIC_SUBMIT = "PIC_SUBMIT";
	/**
	 * 5 ERP完成钥匙提交的积分 值：KEY
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_KEY = "KEY";
	/**
	 * 6 ERP完成SOSO普通信息查看电话的积分 值：SOSO
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_SOSO_COMMON = "SOSO_COMMON";
	/**
	 * 7 ERP完成楼盘竞价的积分 值：BUILD_BIDDING
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_BUILD_BIDDING = "BUILD_BIDDING";
	/**
	 * 8 ERP完成房源竞价的积分 值：HOUSE_BIDDING
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_HOUSE_BIDDING = "HOUSE_BIDDING";
	/**
	 * 9 ERP完成出售成交的积分 值：SALE_DEAL
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_SALE_DEAL = "SALE_DEAL";
	/**
	 * 10 ERP完成出租成交的积分 值：LESAE_DEAL
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_LESAE_DEAL = "LESAE_DEAL";
	/**
	 * 11 ERP完成SOSO独家和专供查看电话的积分 值：SOSO
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_SOSO_DUJIAZHUANGONG = "SOSO_SPEC";
	/**
	 * 12 ERP完成登记房源的积分 值：HOUSE_WEIPAI
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_HOUSE_WEIPAI = "HOUSE_WEIPAI";
	/**
	 * 13 ERP完成登记房源的积分 值：HOUSE_REMAKER
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_HOUSE_REMAKER = "HOUSE_REMAKER";
	/**
	 * 14 ERP完成房源上架到腾讯的积分 值：HOUSE_PUB_SITE
	 */
	public final static String DIC_INTEGRAL_BIZ_MAP_SCORE_HOUSE_PUB = "HOUSE_PUB";
	/**
	 * 【下降、不变、上升】 = 【1、2、3】
	 */
	public final static String DIC_ORIENTATION_1 = "1";
	/**
	 * 【下降、不变、上升】 = 【1、2、3】
	 */
	public final static String DIC_ORIENTATION_2 = "2";
	/**
	 * 【下降、不变、上升】 = 【1、2、3】
	 */
	public final static String DIC_ORIENTATION_3 = "3";
	/**
	 * 全城、门店的跑分最高得分记录缓存时间  单位:秒
	 * 默认：6分钟
	 */
	public final static int DIC_RANGE_MAX_SCORE_CACHE_TIME = 360;
	/**
	 * 全城、门店的跑分平均得分记录缓存时间  单位:秒
	 * 默认：10分钟
	 */
	public final static int DIC_RANGE_AVG_SCORE_CACHE_TIME = 600;
	/**
	 * 跑分系统前五名的缓存过期时间
	 * 默认：6分钟
	 */
	public final static int DIC_TOP5_SCORE_CACHE_TIME = 300;
	/**
	 * 跑分系统各个指标的排名情况
	 * 默认：5分钟
	 */
	public final static int DIC_EACH_SCORE_CACHE_TIME = 300;
	/**
	 * 跑分系统-----------------------------结束------------------------
	 */

	/** 语音记录是否已下载标志 1已下载 */
	public final static String DIC_VOIP_VOIC_DOWNLOAD = "1";
	
	/** crm任务  客户询价 0 */
	public final static String DIC_CRM_TASK_INQUIRY_MONEY = "0";
	
	/** 自定义服务器执行成功 */
	public final static String DIC_CUSTOM_SUCCESS = "1";
	/** 自定义服务器执行失败，-1：验证失败  */
	public final static String DIC_CUSTOM_AUTH_FIELD = "-1";
	
	/** 微店在个人中心购买还是联系销售购买，1：联系销售购买  */
	public final static String DIC_IS_REAL_WEIXIN = "1";
	
	/** 门店是否O2O，0：正常情况  */
	public final static String DIC_DEPTS_OTO_OK = "0";
	/** 门店是否O2O，1：购买O2O 数量超过  */
	public final static String DIC_DEPTS_OTO_OVER = "1";
	/** 门店是否O2O，2：未购买O2O  数量超过  */
	public final static String DIC_DEPTS_NOT_OTO_OVER = "2";
	/**注册用户时的通用验证码--测试方便*/
	public final static String TEST_MOBILE_KEY_USER_REGISTER_PWD = "859652";
	/**登录通用调试密码*/
	public final static String DIC_LOGINPASS="hft@#mypwdmyfun...";
	/**
	 * 登陆用户被注销
	 */
	public final static String DIC_LOGIN_WRITEOFF_1 = "1";
	/**
	 * 跨店权限标记
	 * 没有跨店的权限
	 */
	public final static String DIC_ALLDEPT_FLAG_0 = "0";
	
	/**
	 * 默认分组ID【GROUP_ID】值：0
	 * 如果用户没有分组的话默认使用0
	 */
	public final static String DIC_DEFAULT_GROUP_ID="0";
	
	/**
	 * ERP对方开发的登录接口来源类型
	 * 来源 目前 第三方:1；手机端:2
	 */
	/**
	 * 第三方接口 值：1
	 */
	public final static String DIC_OPENAPI_LOGIN_FROM_THIRD = "1";
	/**
	 * 移动端接口 值：2
	 */
	public final static String DIC_OPENAPI_LOGIN_FROM_MOBILE = "2";
	
	/**
	 * 楼盘竞价CRM端下架小区竞价数据标记记录
	 * RETURN_PRICE = 15  表示来至CRM的操作
	 * RETURN_PRICE = 10  表示来至移动的操作
	 * RETURN_PRICE = 1   表示来至扣费服务的下架操作
	 * RETURN_PRICE = 2   表示来至扣费服务的上架操作
	 */
	
	
	/**
	 * 房源的地址判断重复逻辑
	 * 所以的字母均转换成大写 例如： a01 转换成  A01 然后作为 数字来判断，最后的判断结果  a01 = A01 = 101
	 * 栋的长度补充：1 = 01 = 001 = 0001= 00001 最长5位
	 * 2015-12-25以前的楼盘栋座规则是3-2-2-4
	 * 2015-12-25今天修改楼盘栋座规则为5-2-2-5
	 */
	/**
	 * 栋的判断重复 字母和数字长度控制 5
	 */
	public final static int DIC_ROOF_REPEAT_LENGTH_LIMIT = 5;
	/**
	 * 单元的判断重复 字母和数字长度控制 4
	 */
	public final static int DIC_UNIT_REPEAT_LENGTH_LIMIT = 4;
	/**
	 * 楼层的判断重复 字母和数字长度控制 2
	 */
	public final static int DIC_FLOOR_REPEAT_LENGTH_LIMIT = 2;
	/**
	 * 房号的判断重复 字母和数字长度控制 5
	 */
	public final static int DIC_NUM_REPEAT_LENGTH_LIMIT = 5;
	
	/** 优家支付类型 0支出 */
	public final static String DIC_YOU_PAID_CATIGORY_EXPEND = "0";
	/** 优家支付类型 1收入 */
	public final static String DIC_YOU_PAID_CATIGORY_INCOME = "1";
	
	/** 优家楼盘资料当前查看状态 1已拨打，绿勾 */
	public final static String DIC_YOU_BUILD_VIEW_STATUS_1 = "1";
	/** 优家楼盘资料当前查看状态 2已拨打，红勾 */
	public final static String DIC_YOU_BUILD_VIEW_STATUS_2 = "2";
	/** 优家楼盘资料当前查看状态 3已转入系统出售，灰勾 */
	public final static String DIC_YOU_BUILD_VIEW_STATUS_3 = "3";
	/** 优家楼盘资料当前查看状态 4已转入系统出租，灰勾 */
	public final static String DIC_YOU_BUILD_VIEW_STATUS_4 = "4";
	
	/** 优家积分支付类型 0首次购买 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_0 = "0";
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
	
	/** 优家积分支付类型 2楼盘资料明文电话 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_2 = "2";
	/**
	 * 投诉成功，退还积分
	 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_3 = "3";
	/**
	 * 被投诉成功，扣罚积分
	 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_4 = "4";
	/**
	 * 分享房源
	 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_5 = "5";
	/**
	 * 赚取的积分
	 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_6 = "6";
	/** 个人中心好房币购买积分 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_7 = "7";
	
	/** 房源下架 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_8 = "8";
	
	/** 修改真房源标记 */
	public final static String DIC_YOU_BORKER_PAY_TYPE_9 = "9";
	
	/**
	 * 积分不足时，返回一个2
	 */
	public final static String YOU_IS_NOT_SCORE = "2";
	
	
	/**
	 * YOU+购买表投诉标记：已投诉
	 */
	public final static String DIC_COMPLAIN_FLAG_TRUE = "2";
	/**
	 * YOU+购买表投诉标记：投诉中
	 */
	public final static String DIC_COMPLAIN_FLAG_COURSE = "1";
	/**
	 * YOU+购买表投诉标记：未投诉
	 */
	public final static String DIC_COMPLAIN_FLAG_FALSE = "0";
	/**
	 * YOU+房源分享方标记:1
	 */
	public final static String DIC_YCT_OWNER_SHARE = "1";
	/**
	 * YOU+房源购买方标记:0
	 */
	public final static String DIC_YCT_OWNER_PURCHASE = "0";
	/**
	 * YOU+房源投诉处理标记 未处理:0
	 */
	public final static String DIC_COMPLAIN_DEAL_STATUS = "0";
	
	/**
	 * YOU+ 数据 成交和注销的下架方式
	 */
	/**
	 * 成交数据下架 值：1
	 */
	public final static String DIC_DOWN_TYPE_DEAL = "1";
	/**
	 * 注销数据下架 值：2
	 */
	public final static String DIC_DOWN_TYPE_WRITEOFF = "2";
	/**
	 * 投诉数据下架 值：3
	 */
	public final static String DIC_DOWN_TYPE_COMPLAIN = "3";
	
	/**
	 * 是否是分享到YOU+的房源
	 */
	/**
	 * 不是YOU+房源 值：0
	 */
	public final static String DIC_YOU_SHARE_FLAG_0 = "0";
	/**
	 * 标记为YOU+房源 值：1
	 */
	public final static String DIC_YOU_SHARE_FLAG_1 = "1";
	/**
	 * 我发布的
	 */
	public final static String DIC_YOU_MY_PUBLISH = "1";
	/**
	 * 我参与的
	 */
	public final static String DIC_YOU_MY_JOIN = "2";
	/**
	 * 本店的
	 */
	public final static String DIC_YOU_MY_DEPT = "3";
	
	/**
	 * 好房YOU+门店已经停权
	 */
	public final static String YOUJIA_DEPT_BAN_FLAG = "1";
	/**
	 * 好房YOU+用户被停权
	 */
	public final static String YOUJIA_USER_BAN_FLAG = "1";
	/**
	 * 优家数据不进入策略参数控制 值：3
	 */
	public final static String DIC_YOUJIA_HOUSE_IS_IGNORE_3 = "3";
	/**
	 * 进入策略参数控制 值：0
	 * 
	 * 情况：1、从优家下架的数据
	 */
	public final static String DIC_YOUJIA_HOUSE_IS_IGNORE_0 = "0";
	
	/**
	 * 单独修改房源的业务标记
	 *  type 1真房源  2合作 3 微店 4腾讯  5 优家房源
	 */
	/**
	 * 非真房源 值：0
	 */
	public final static String DIC_INFO_TRUE_INFO_FLAG_0 = "0";
	/**
	 * 真房源 值：1
	 */
	public final static String DIC_INFO_TRUE_INFO_FLAG_1 = "1";
	/**
	 * 被投诉的真房源 值：2
	 */
	public final static String DIC_INFO_TRUE_INFO_FLAG_2 = "2";
    /**
     * 正在投诉中的真房源 值：3
     */
    public final static String DIC_INFO_TRUE_INFO_FLAG_3 = "3";
	
	/**
	 * 真房源类型 值：1
	 */
	public final static String DIC_INFO_TRUE_INFO_TYPE_1 = "1";
	/**
	 * 删除图片，图片少于三张：5
	 */
	public final static String DIC_INFO_TRUE_INFO_TYPE_5 = "5";
	/**
	 * 删除视频：7
	 */
	public final static String DIC_INFO_TRUE_INFO_TYPE_7 = "7";
	/**
	 * 房源图片的最大值：12
	 */
	public final static Integer HOUSE_PHOTO_MAX = 15;
	/**
	 * 合作类型 值：2
	 */
	public final static String DIC_INFO_COOP_INFO_TYPE_2 = "2";
	/**
	 * 微店类型 值：3
	 */
	public final static String DIC_INFO_WEIDIAN_INFO_TYPE_3 = "3";
	/**
	 * 腾讯类型 值：4
	 */
	public final static String DIC_INFO_TENCENT_INFO_TYPE_4 = "4";
	/**
	 * 优家房源 类型值：6
	 * 5这个值已经被删除图片使用了参考：DIC_INFO_TRUE_INFO_TYPE_5
	 */
	public final static String DIC_INFO_YOU_INFO_TYPE_6 = "6";

	/**
	 * 优家客源 类型值：8(目前物业版客源分享城市公盘)2016-09-10
	 * 5这个值已经被删除图片使用了参考：DIC_INFO_TRUE_INFO_TYPE_5
	 */
	public final static String DIC_INFO_YOU_INFO_TYPE_8 = "8";
	
	/**
	 * 优家数据移交时的描述，优家数据不能直接数据移交
	 */
	public final static String DIC_YOU_TRANSDATA_TIP_INFO = "您所移交的数据含有城市公盘数据，城市公盘数据必须注销或成交后方可移交！";
	
	/**
	 * 用户信息注册来源
	 * 0 :网站  1:app  2: 微信  3:erp,仅创建时有效
	 */
	/**
	 * 网站 来源 值:0
	 */
	public final static String DIC_USER_REG_FROM_0 = "0";
	/**
	 * APP 来源 值:1
	 */
	public final static String DIC_USER_REG_FROM_1 = "1";
	/**
	 * 微信 来源 值:2
	 */
	public final static String DIC_USER_REG_FROM_2 = "2";
	/**
	 * ERP 来源 值:3
	 */
	public final static String DIC_USER_REG_FROM_3 = "3";
	/**
	 * 第三方 来源 值:4  例如：第三方竞价
	 */
	public final static String DIC_USER_REG_FROM_4 = "4";
	
	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_1 = "1";
	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_2 = "2";
	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_3 = "3";
	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_4 = "4";
	/**
	 * 房源列表信息显示范围
	 * LOOK_HOUSE_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 * 客源列表信息显示范围
	 * LOOK_CUST_RANGE		1:全公司,2:大区,3:片区,4:门店,5:分组
	 */
	public final static String DIC_LOOK_RANGE_5 = "5";
	
	/**
	 * 房源类型的权限 值：1
	 */
	public final static String DIC_OPER_RANGE_TYPE_1 = "1";
	/**
	 * 客源类型的权限 值：2
	 */
	public final static String DIC_OPER_RANGE_TYPE_2 = "2";
	/**
	 * 其他业务类型的权限 值：3
	 */
	public final static String DIC_OPER_RANGE_TYPE_3 = "3";
	
	
	/**
	 * SHARE_PUBLIC_FUN_RANGE	公盘查看及可抢盘范围：房源
	 * SHARE_PUBLIC_CUST_RANGE	公盘查看及可抢盘范围：客源
	 */
	/**
	 * 1:全公司,2:大区,3:片区,4:门店
	 * 公盘查看及可抢盘范围
	 * 当前值：1
	 */
	public final static String DIC_SHARE_PUBLIC_RANGE_1 = "1";
	/**
	 * 1:全公司,2:大区,3:片区,4:门店
	 * 公盘查看及可抢盘范围
	 * 当前值：2
	 */
	public final static String DIC_SHARE_PUBLIC_RANGE_2 = "2";
	/**
	 * 1:全公司,2:大区,3:片区,4:门店
	 * 公盘查看及可抢盘范围
	 * 当前值：3
	 */
	public final static String DIC_SHARE_PUBLIC_RANGE_3 = "3";
	/**
	 * 1:全公司,2:大区,3:片区,4:门店
	 * 公盘查看及可抢盘范围
	 * 当前值：4
	 */
	public final static String DIC_SHARE_PUBLIC_RANGE_4 = "4";
	
	/**
	 * 5:分组 < 4:门店 < 3:片区 < 2:大区 < 1:全公司
	 */
	/**
	 * 1:全公司范围的权限
	 */
	public final static String DIC_OPER_RANGE_LEVEL_SEQ_1 = "1";
	/**
	 * 2:大区范围的权限
	 */
	public final static String DIC_OPER_RANGE_LEVEL_SEQ_2 = "2";
	/**
	 * 3:片区范围的权限
	 */
	public final static String DIC_OPER_RANGE_LEVEL_SEQ_3 = "3";
	/**
	 * 4:门店范围的权限
	 */
	public final static String DIC_OPER_RANGE_LEVEL_SEQ_4 = "4";
	/**
	 * 5:分组范围的权限
	 */
	public final static String DIC_OPER_RANGE_LEVEL_SEQ_5 = "5";
		
	/**
	 * 系统管理员  系统中暂时不显示出来
	 */
	public final static String DIC_ROLE_NAME_SYSTEM_MANAGE = "SYSTEM_MANAGE";
	/**
	 * 见习经纪人
	 */
	public final static String DIC_ROLE_NAME_PRACTY_BIZ = "PRACTY_BIZ";
	/**
	 * 正式经纪人
	 */
	public final static String DIC_ROLE_NAME_COMMON_BIZ = "COMMON_BIZ";
	/**
	 * 权证专员
	 */
	public final static String DIC_ROLE_NAME_PROPERTY_SERVER = "PROPERTY_SERVER";
	/**
	 * 客服专员
	 */
	public final static String DIC_ROLE_NAME_CUST_SERVER = "CUST_SERVER";
	/**
	 * 销售组长
	 */
	public final static String DIC_ROLE_NAME_BIZ_MANAGER = "BIZ_MANAGER";
	/**
	 * 店务秘书
	 */
	public final static String DIC_ROLE_NAME_SECRETARIAL = "SECRETARIAL";
	/**
	 * 门店经理 -- 通俗叫法“店长” 中介门店的店长
	 */
	public final static String DIC_ROLE_NAME_BRANCH_MANAGER = "BRANCH_MANAGER";
	/**
	 * 片区经理
	 */
	public final static String DIC_ROLE_NAME_REGION_MANAGER = "REGION_MANAGER";
	/**
	 * 大区经理
	 */
	public final static String DIC_ROLE_NAME_BIZ_GENERAL = "BIZ_GENERAL";
	/**
	 * 副总经理
	 */
	public final static String DIC_ROLE_NAME_DEPUTY_MANAGER = "DEPUTY_MANAGER";
	/**
	 * 总经理
	 */
	public final static String DIC_ROLE_NAME_GENERAL_MANAGER = "GENERAL_MANAGER";
	// 管理员
	public final static String DIC_ROLE_NAME_COMMON_ADMIN = "COMMON_ADMIN";

	/**
	 * 权限的类型
	 * FUN_OPERS【OPER_TYPE】
	 *	1 HOUSE
	 * 2 CUST
	 */
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
	public final static String DIC_FUN_OPERS_OPER_TYPE_13 = "13";
	/**
	 * 查看房源列表信息的权限类型
	 */
	public final static String DIC_FUN_OPERS_OPER_TYPE_14 = "14";
	
	/** 优优好房和ERP关联表的状态 0：有效 */
	public final static String DIC_VIPERP_RELATION_STATUS_VALID = "0";
	/** 优优好房和ERP关联表的状态 1：无效 */
	public final static String DIC_VIPERP_RELATION_STATUS_INVALID = "1";
	
	/**
	 * 是否隐号拨打
	 * 1：开启
	 * 0：关闭
	 */
	public final static String IS_OPEN_HIDEPHONE_0 = "0";
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
	 * FUN_PAI消费来源
	 * 0：ERP
	 * 1：APP
	 * 2：DIDI
	 */
	public final static String DIC_PAID_SOURCE_0 = "0";
	/**
	 * FUN_PAI消费来源
	 * 0：ERP
	 * 1：APP
	 * 2：DIDI
	 */
	public final static String DIC_PAID_SOURCE_1 = "1";
	
	/**
	 * 优家楼盘资料兑换积分
	 * 值：YOUJIA_INTEGRAL_BUILD
	 */
	public final static String DIC_PAID_YOUJIA_INTEGRAL_BUILD = "YOUJIA_INTEGRAL_BUILD";
	/**
	 * 优家房源信息兑换积分
	 * 值：YOUJIA_INTEGRAL_HOUSE
	 */
	public final static String DIC_PAID_YOUJIA_INTEGRAL_HOUSE = "YOUJIA_INTEGRAL_HOUSE";
	/**
	 * 订单状态：删除0
	 */
	public final static String PAYMENT_STATUS_0 = "0";
	
	/**
	 * 订单状态：有效1
	 */
	public final static String PAYMENT_STATUS_1 = "1";
	/**
	 * 订单状态：过期2
	 */
	public final static String PAYMENT_STATUS_2 = "2";
	/**
	 * 订单支付状态：未支付0
	 */
	public final static String ORDER_IS_CLEAR_0 = "0";
	/**
	 * 订单支付状态：已支付1
	 */
	public final static String ORDER_IS_CLEAR_1 = "1";
	/**
	 * 订单支付状态：已支付1
	 */
	public final static String ORDER_PT_TYPE_13 = "13";
	/** 优家楼盘扣费方式：0公司购买了个人还需购买*/
	public final static String YOU_BUILD_VIP_PAY_TYPE_0 = "0";
	/** 优家楼盘扣费方式：1公司购买了，个人可直接查看*/
	public final static String YOU_BUILD_VIP_PAY_TYPE_1 = "1";
	/** 优家楼盘账户类型：0个人账户*/
	public final static String YOU_BUILD_VIP_ACCOUNT_TYPE_0 = "0";
	/** 优家楼盘账户类型：1公司账户*/
	public final static String YOU_BUILD_VIP_ACCOUNT_TYPE_1 = "1";
	/** 优家楼盘账户支付类型：0收入*/
	public final static String YOU_BUILD_VIP_PAID_TYPE_0 = "0";
	/** 优家楼盘账户支付类型：1支出*/
	public final static String YOU_BUILD_VIP_PAID_TYPE_1 = "1";
	/** 优家楼盘账户支付类型：2免费*/
	public final static String YOU_BUILD_VIP_PAID_TYPE_2 = "2";
	
	/** didi房源跟进类型：3房勘 */
	public final static String DIDI_TRACK_TYPE_FANGKAN = "3";
	/** didi房源跟进类型：4带看 */
	public final static String DIDI_TRACK_TYPE_DAIKAN = "4";
	/** didi房源跟进类型：5成交 */
	public final static String DIDI_TRACK_TYPE_CHENGJIAO = "5";
	/** 视频状态：-1 已删除 */
	public final static String DIC_VIDEO_STATUS_1_ = "-1";
	/** 视频状态：0 未审核 */
	public final static String DIC_VIDEO_STATUS_0 = "0";
	/** 视频状态：1 已审核 */
	public final static String DIC_VIDEO_STATUS_1 = "1";
	/** 视频状态：2 审核失败 */
	public final static String DIC_VIDEO_STATUS_2 = "2";
	/**有钥匙**/
	public final static String IS_HAVE_KEY_FLAG = "1";
	/**门店是否开通You+**/
	public final static String YOUJIA_DEPT_FLAG_1 = "1";
	/**显示YOU+按钮**/
	public final static String YOUJIA_SHOW_FLAG_1 = "1";
	/**隐藏YOU+按钮**/
	public final static String YOUJIA_SHOW_FLAG_2 = "2";
	/**YOU+默认值为0**/
	public final static String YOUJIA_SHOW_FLAG_0 = "0";
	/**公司加盟模式**/
	public final static String COMP_MODEL_2 = "2";
	/**速销申请**/
	public final static String DIC_SO_SHOP_APPLY_1 = "1";
	/**速销申请成功**/
	public final static String DIC_SO_SHOP_APPLY_2 = "2";
	

	/**业绩目标类型：个人业绩 1*/
	public final static String DIC_PROFIT_TYPE_PERSONAL = "1";
	/**业绩目标类型：门店业绩 2*/
	public final static String DIC_PROFIT_TYPE_DEPT = "2";
	/**业绩目标类型：片区业绩 3*/
	public final static String DIC_PROFIT_TYPE_REG = "3";
	/**业绩目标类型：大区业绩 4*/
	public final static String DIC_PROFIT_TYPE_AREA = "4";
	/**业绩目标类型：公司业绩 5*/
	public final static String DIC_PROFIT_TYPE_COMP = "5";
	
	/**720相机图片状态：未删除 0*/
	public final static String DIC_PANORAMA_PHOTO_STATUS_0 = "0";
	/**720相机图片状态：已删除 1*/
	public final static String DIC_PANORAMA_PHOTO_STATUS_1 = "1";
	
	/** 鸿基广告房源 撤销0 点亮1 **/
	public final static String DIC_ADS_CASE_STATUS_1 = "1";
	public final static String DIC_ADS_CASE_STATUS_0 = "0";
	
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

	/**
	 * 陈文超 2016-06-13
	 * 真房源的图片数量
	 * 值：5
	 */
	public final static String DIC_TRUE_HOUSE_RULE_IMGCOUNT = "5";
	
	/***
	 * 合同指标参数状态 1:正常  0:删除
	 * */
	public final static String DIC_CONTRACT_INDEX_STATUS_1 = "1";
	public final static String DIC_CONTRACT_INDEX_STATUS_0 = "0";
	
	/***
	 * 合同模板状态 1:正常  0:删除
	 * */
	public final static String DIC_CONTRACT_TEMPLATE_STATUS_1 = "1";
	public final static String DIC_CONTRACT_TEMPLATE_STATUS_0 = "0";
	 /*个人中心发票状态*/
    /**
     * 个人中心发票状态：待审核0
     */
    public final static String DIC_INVOICE_STATUS_0 = "0";
    /**
     * 个人中心发票状态：审核失败1
     */
    public final static String DIC_INVOICE_STATUS_1 = "1";
    /**
     * 个人中心发票状态：业务审核通过2
     */
    public final static String DIC_INVOICE_STATUS_2 = "2";
    /**
     * 个人中心发票状态: 财务审核通过3
     */
    public final static String DIC_INVOICE_STATUS_3 = "3";
    /**
     * 个人中心发票状态: 已邮寄4
     */
    public final static String DIC_INVOICE_STATUS_4 = "4";
    /**
     * 个人中心发票状态: 已开具5
     */
    public final static String DIC_INVOICE_STATUS_5 = "5";
    /**
     * 个人中心发票状态: 仅保存6
     */
    public final static String DIC_INVOICE_STATUS_6 = "6";

	/**
	 * 添加分享合作城市公盘
	 * **/
	public final static String DIC_INFO_CITY_SHARE = "10";

	/**普通合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_1 = "1";
	/**隐号合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_2 = "2";
	/**优家普通合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_3 = "3";
	/** 优家隐号合作 **/
	public final static String DIC_INFO_CITY_SHARE_FLAG_4 = "4";

	/** 普通数据下架类型，1=不合作 >> 要合作 **/
	public final static String DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_1 = "1";
	/**普通数据下架类型，2=不合作 >> 隐号合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_2 = "2";
	/**普通数据下架类型，3=要合作>> 不合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_3 = "3";
	/**普通数据下架类型，4=隐号合作>> 不合作**/
	public final static String DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_4 = "4";

	/**
	 * 优优竞价正常1
	 **/
	public final static String HOUSE_BIDDING_YY_STATUS_1 = "1";
	public final static Byte HOUSE_BIDDING_YY_STATUS_1_BYTE = 1;
	/**
	 * 优优竞价下架0
	 **/
	public final static String HOUSE_BIDDING_YY_STATUS_0 = "0";
	/**
	 * 优优竞价下架2 不在上架
	 **/
	public final static String HOUSE_BIDDING_YY_STATUS_2 = "2";
	
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
	public final static String HOUSE_RELATIVE_PEOPLE_TYPE_6 = "6";
	/**
	 * 合同 值：1
	 */
	public final static Integer DIC_FUN_DEAL_FILE_TYPE_1 = 1;// 合同
	/**
	 * 补充协议 值：2
	 */
	public final static Integer DIC_FUN_DEAL_FILE_TYPE_2 = 2;// 补充协议

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

	public final static Integer YOUJIA_DOCKING_DEFAULT_UID = 12;
	public final static Integer YOUJIA_TRANSFER_DEFAULT_UID = 12;

	public static class Count{
		public static Map<String, String> PROFIT_COUNT_TYPE_MAP = new HashMap<String, String>();
		static{
			PROFIT_COUNT_TYPE_MAP.put("AREA", Constants_DIC.DIC_PROFIT_COUNT_TYPE_AREA);
			PROFIT_COUNT_TYPE_MAP.put("REG", Constants_DIC.DIC_PROFIT_COUNT_TYPE_REG);
			PROFIT_COUNT_TYPE_MAP.put("DEPT", Constants_DIC.DIC_PROFIT_COUNT_TYPE_DEPT);
			PROFIT_COUNT_TYPE_MAP.put("GROUP", Constants_DIC.DIC_PROFIT_COUNT_TYPE_GROUP);
			PROFIT_COUNT_TYPE_MAP.put("USER", Constants_DIC.DIC_PROFIT_COUNT_TYPE_USER);
		}
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
		public final static String HOUSE = "1";
		/**客源**/
		public final static String CUST = "2";
		/**城市公盘**/
		public final static String YOUJIA = "3";
		/**搜搜推送**/
		public final static String SOSO_PUSH = "4";
		/**薪资**/
		public final static Integer FUN_WAGE_PUSH = 11;
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
		public final static String WRITE_TRACK_BY_VIEW = "1";
		/**IP拨号**/
		public final static String IP_CALL = "2";
		/**查看电话**/
		public final static String VIEW_PHONE = "3";
		/**写跟进**/
		public final static String WRITE_TRACK = "4";
		/**修改信息**/
		public final static String UPDATE_HOUSE_CUST_INFO = "5";
		/**上传图片**/
		public final static String UPLOAD_PHOTO = "6";
		/**删除图片**/
		public final static String DELETE_PHOTO = "7";
		/**注销房源**/
		public final static String WRITEOFF_HOUSE_CUST = "8";
		/**创建合同的房源成交**/
		public final static String DEAL_HOUSE_CUST_BY_CONTRACT = "9";
		/**收藏的房源被注销**/
		public final static String FAVORITE_HOUSE_CUST_WRITEOFF = "10";
		/**收藏的房源被成交**/
		public final static String FAVORITE_HOUSE_CUST_DEAL = "11";
		/**提交钥匙**/
		public final static String SUBMIT_KEY = "12";
		/**优家房源被投诉**/
		public final static String YOU_HOUSE_CUST_COMPLAINED = "13";
		/**优家我参与的房源下架**/
		public final static String YOU_INVOLVEMENT_WRITEOFF = "14";
		/**优家新增的房客源**/
		public final static String YOU_HOUSE_CUST_NEW = "15";
		/**搜搜出售推送**/
		public final static String SOSO_PUSH_SALE = "16";
		/**搜搜出租推送**/
		public final static String SOSO_PUSH_LEASE = "17";
		/**搜搜转铺推送**/
		public final static String SOSO_PUSH_ZHUANPU = "18";
		/**搜搜合租推送**/
		public final static String SOSO_PUSH_HEZU = "19";
		/**搜搜求购推送**/
		public final static String SOSO_PUSH_BUY = "20";
		/**搜搜求租推送**/
		public final static String SOSO_PUSH_RENT = "21";
		/** 薪资账单发送 **/
		public final static Integer FUN_WAGE_BILL = 27;
	}

	/**
	 * 1:诚意金 2：合同
	 * **/
	public final static String LAKLA_POS_PAY_TYPE_1 = "1";
	public final static String LAKLA_POS_PAY_TYPE_2 = "2";
	
	/** 合同提醒  **/
	public final static String DIC_TASK_TYPE_CONTRACT_REMIND = "4";//
	public final static String DIC_TASK_TYPE_CONTRACT_REMIND_STR = "[ 合同提醒 ]";
	/** 小区专家 **/
	public final static String DIC_BIDDING_TYPE_HOUSE_EXPERT = "1";
	/**房源竞价推广*/
	public final static String DIC_INTEGRAL_TYPE_18 = "18";
	/**夺宝币来源，1=点亮真房源*/
	public final static String DIC_TREASURE_COIN_SOURCE_1 = "1";
	/**夺宝币来源，2=房源推广*/
	public final static String DIC_TREASURE_COIN_SOURCE_2 = "2";
	/**夺宝币来源，3=小区竞价*/
	public final static String DIC_TREASURE_COIN_SOURCE_3 = "3";
	/**夺宝币来源，4=新盘竞价*/
	public final static String DIC_TREASURE_COIN_SOURCE_4 = "4";
	/**夺宝币类型，1=收入*/
	public final static String DIC_TREASURE_COIN_TYPE_1 = "1";
	/**夺宝币类型，2=支出*/
	public final static String DIC_TREASURE_COIN_TYPE_2 = "2";

	/** 房源置顶 **/
	public final static String DIC_BIDDING_TYPE_HOUSE_TOP = "2";
	
	/**
	 * 腾讯推广余额不足
	 */
	public final static String ERROR_CODE_BALANCE_LACK = "-15";
	
	/** 点亮真房源状态错误码 值：-10=不是自己的房源 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_10 = "-10";
	/** 点亮真房源状态错误码 值：-11=图片少于5张 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_11 = "-11";
	/** 点亮真房源状态错误码 值：-12=真房源状态被投诉熄灭 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_12 = "-12";
	/** 点亮真房源状态错误码 值：-13=资金账户不存在 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_13 = "-13";
	/** 点亮真房源状态错误码 值：-14=未同意规则 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_14 = "-14";
	/** 点亮真房源状态错误码 值：-16=真房源被投诉成功 */
	public final static String DIC_LIGHT_TRUEHOUSE_ERROR_CODE_16 = "-16";
	/** 竞价小区专家状态错误码 值：-10=您尚未登记该楼盘的房源 */
	public final static String DIC_BUILD_INFO_ERROR_CODE_10 = "-10";

	public static class FunMsgType {
		public static Integer MSG_TYPE_1=1;
		public static Integer MSG_TYPE_2=2;
		public static Integer MSG_TYPE_3=3;
		public static Integer MSG_TYPE_4=4;
		public static Integer MSG_TYPE_5=5;
		public static Integer MSG_TYPE_6=6;
	}
}
