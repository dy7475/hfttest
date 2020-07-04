package com.myfun.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoipUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(VoipUtil.class);
	public static String VOIP_URL = null;

	public static String SPID = null;

	public static String APPID = null;

	public static String PASSWD = null;

	public static String DISPLAYNBR = null;

	private VoipUtil() {
	}

	/**
	 * 是否初始化
	 * 
	 * @return
	 */
	public static boolean isInit() {
		return !(VOIP_URL == null || SPID == null || APPID == null || PASSWD == null);
	}

	/**
	 * 初始化参数
	 * 
	 * @param voipUrl
	 *            ip电话地址
	 * @param sPid
	 *            应用Spid
	 * @param appId
	 *            应用Appid
	 * @param passwd
	 *            帐号登录密码
	 * @param chargeNbr
	 *            计费号码
	 * @param key
	 *            需填写选号注册时产生的Key
	 * @param displayNbr
	 *            来电显示号码-默认为计费号码
	 */
	public static void init(String voipUrl, String sPid, String appId, String passwd, String displayNbr) {
		if (isInit()) {
			return;
		}

		VOIP_URL = voipUrl;
		SPID = sPid;
		APPID = appId;
		PASSWD = EncryptHelper.encryptSHA1(passwd);
		DISPLAYNBR = displayNbr;

	}

	public static String execute(String methodName) {
		return "";
	}

	/**
	 * 拨打电话
	 * 
	 * @param callerNbr
	 * @param calleeNbr
	 * @return 返回第三方sessionId
	 */
	public static String callIp(String chargeNbr, String key, String callerNbr, String calleeNbr, String displayNbr, String record, String displayNbrMode, String answerOnMedia) {
		if (!isInit()) {
			throw new RuntimeException("请先初始化第三方参数");
		}
		Map<String, String> param = new HashMap<String, String>();
		param.put("postData", buildReq("Dial", chargeNbr, key, callerNbr, calleeNbr, displayNbr, record , displayNbrMode, answerOnMedia));
		String result = HttpUtil.post(VOIP_URL, param);
		LOGGER.info("URL->" + VOIP_URL + "<-IP拨号执行参数->" + param);
		LOGGER.info("返回结果->" + result);

		return getSessionId(result);
	}

	/**
	 * 获取第三方返回sessionId
	 * 
	 * @param result
	 * @return
	 */
	public static String getSessionId(String result) {
		try {
			Document document = DOM4JHelper.createDocument(result);
			Element headEl = DOM4JHelper.getSingleElement(document.getRootElement(), "Head");
			return DOM4JHelper.getSingleElement(headEl, "Sessionid").getText();
		} catch (Exception e) {
		}
		return null;
	}

	public static String buildReq(String methodName, String chargeNbr, String key, String callerNbr, String calleeNbr, String displayNbr, String record, String displayNbrMode, String answerOnMedia) {
		StringBuilder builder = new StringBuilder();
		builder.append("<Request>");
		builder.append(buildReqHead(methodName));
		builder.append(buildReqBody(chargeNbr, key, callerNbr, calleeNbr, displayNbr, record, displayNbrMode, answerOnMedia));
		builder.append("</Request>");
		return builder.toString();
	}

	/**
	 * 构建请求头
	 * 
	 * @param methodName
	 *            请求接口名
	 * @return
	 */
	public static String buildReqHead(String methodName) {
		StringBuilder builder = new StringBuilder();
		builder.append("<Head>");
		builder.append(" <MethodName>" + methodName + "</MethodName>");
		builder.append(" <Spid>" + SPID + "</Spid>");
		builder.append(" <Appid>" + APPID + "</Appid>");
		builder.append(" <Passwd>" + PASSWD + "</Passwd>");
		builder.append(" <Timestamp>" + DateUtil.DateToString(new Date(), "yyyyMMddhhmmss") + "</Timestamp>");
		builder.append("</Head>");
		return builder.toString();
	}

	/**
	 * 构建请求内容
	 * 
	 * @param callerNbr
	 *            主叫
	 * @param calleeNbr
	 *            被叫
	 * @param record
	 *            是否录音
	 * @return
	 */
	public static String buildReqBody(String chargeNbr, String key, String callerNbr, String calleeNbr, String displayNbr, String record, String displayNbrMode, String answerOnMedia) {
		StringBuilder builder = new StringBuilder();
		builder.append("<Body>");
		builder.append("  <ChargeNbr>" + chargeNbr + "</ChargeNbr>");
		builder.append("  <Key>" + key + "</Key>");
		builder.append(" <DisplayNbr>" + displayNbr + "</DisplayNbr>");
		builder.append("  <CallerNbr>" + callerNbr + "</CallerNbr>");
		builder.append("  <CalleeNbr>" + calleeNbr + "</CalleeNbr>");
		builder.append("  <AnswerOnMedia>" + answerOnMedia + "</AnswerOnMedia>");
		builder.append("  <Record>" + record + "</Record>");
		builder.append("  <DisplayNbrMode>" + ("1".equals(displayNbrMode) ? "1" : "0") + "</DisplayNbrMode>");
		builder.append("</Body>");
		return builder.toString();
	}

}
