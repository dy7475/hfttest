package com.myfun.repository.jms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

public class JmsMsgAction {
	/** 增加工作量统计 创建合同在用 */
	public static final String ADD_WORK_COUNT = "addWorkCount";
	/** 跑分(erpWeb 竞价移走就没用了) */
	public static final String COUNT_SCORE = "countScore";

	/** 房客源审核任务 超期自动审核  */
	public static final String FUN_CASE_AUTO_ADUIT = "funCaseAutoAduit";
	/** 审核任务通知（这个应该也在houseWeb） */
	public static final String AUDIT_TOAST = "AUDIT_TOAST_CONSUMER";
	/** 审核任务推送移动通知(移到houseWeb) */
	public static final String SEND_AUDIT_RUNTIME_MSG_TO_MOBILE = "sendAuditRuntimeMsgToMobile";
	/** 用户登录 （现在用户登录还是老项目的） */
	public static final String USER_LOGIN = "userLogin";
	/** 创建用户(停用) */
	public static final String CREATE_USER_MESSAEG = "createUser";

    /** 增加工作量统计 addBusinessBeyondDeal*/
    public static final String ADD_BUSINESS_BEYONDDEAL = "addBusinessBeyondDeal";


	//===========================新版格式======================================
	/** youjia微信 推送  */
	public static final String YOUJIA_WX_PUSH = "YOUJIA_WEIXIN_PUSH_CONSUMER";
	/** 统一异步发送消息 */
	public static final String SEND_MESSAGE = "SEND_MESSAGE_CONSUMER";
	/** 创建合同流水 旧topic updateProfitDetail */
	/*为了本地的测试，占时修改改名称*/
	public static final String UPDATE_PROFIT_DETAIL = "UPDATE_PROFIT_CONSUMER";
	/** 修改员工信息 updateAreaRegDeptGroupInfo */
	public static final String UPDATE_AREA_REG_DEPT_GROUP_INFO = "UPDATE_AREA_REG_DEPT_GROUP_INFO_CONSUMER";
	/** 业绩达标跑分 countProfitScore*/
	public static final String COUNT_PROFIT_SCORE = "COUNT_PROFIT_SCORE_CONSUMER";
	/** 跟进任务，计算跟进质量分的 trackMsg*/
	public static final String TRACK_MESSAGE = "TRACK_MESSAGE_CONSUMER";
	/**处理员工权限  **/
	public static final String DEAL_USER_OPER = "DEAL_USER_OPER_CONSUMER";
	/**处理员工权限  **/
	public static final String ORG_MOVE_CONSUMER = "ORG_MOVE_CONSUMER";
	public static final String ORG_MOVE_COUNT_DEAL_CONSUMER = "ORG_MOVE_COUNT_DEAL_CONSUMER";
	/**处理调动组织之后组织人数  **/
	public static final String UPDATE_ORG_USER_NUM = "UPDATE_ORG_USER_NUM";
	/**下架发发房源  **/
	public static final String REMOVE_LISTING = "REMOVE_LISTING_ML";

// 修改类操作topci 包含 修改, 转有效, 状态变更，成交，速销房，注销，取消暂缓，预定，转盘
	public static final String  CASE_STATUS_CHANGE_CLASS_CONSUMER = "CASE_STATUS_CHANGE_CLASS_CONSUMER";
	// 美联委托业主都签署完毕，上传协议图片
	public static final String  AGREEMENT_PICTURE_MSG = "AGREEMENT_PICTURE_MSG";

	public static void main(String[] args) {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("isWarm", true);

		String s = JSON.toJSONString(pMap);

		Map<String,String> dataMap = JSON.parseObject(s, new TypeReference<Map<String, String>>() {});
		System.out.println(dataMap.get("isWarm"));

	}
}
