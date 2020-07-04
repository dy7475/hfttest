/**
 * @author Glan.duanyj
 * @date 2014-05-12
 * @project rest_demo
 */
package com.myfun.utils.rest;

import java.io.IOException;

import com.myfun.utils.EncryptHelper;
import com.myfun.utils.rest.client.AbsRestClient;
import com.myfun.utils.rest.client.JsonReqClient;
import com.myfun.utils.rest.client.XmlReqClient;

public class Rest {
	public static String ACCOUNT_SID;// = "9c3435b5f5a21070561da56e5ba9e7ce";
	public static String AUTH_TOKEN;// = "eeb3f4a9b7af46722aea75f458a1e11b";
	public static String APP_ID;// = "10595d0ba264498f8a35c6d8b58571d6";// 线上
	// public static final String APP_ID = "511924c677eb4744be55a73dd9e86dbe";//
	// 灰度
	public static volatile Boolean initFlag = false;

	public static void init(String accountSid, String authToken, String appId) {
		if (!initFlag) {
			ACCOUNT_SID = accountSid;
			AUTH_TOKEN = authToken;
			APP_ID = appId;
		}
	}

	static AbsRestClient InstantiationRestAPI(boolean enable) {
		if (enable) {
			return new JsonReqClient();
		} else {
			return new XmlReqClient();
		}
	}

	public static void testFindAccount(boolean json, String accountSid, String authToken) {
		try {
			String result = InstantiationRestAPI(json).findAccoutInfo(accountSid, authToken);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String testCreateClient(boolean json, String accountSid, String authToken, String appId, String clientName, String chargeType, String charge, String mobile) {
		String result = null;
		try {
			result = InstantiationRestAPI(json).createClient(accountSid, authToken, appId, clientName, chargeType, charge, mobile);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public static void testfindClients(boolean json, String accountSid, String authToken, String appId, String start, String limit) {
		try {
			String result = InstantiationRestAPI(json).findClients(accountSid, authToken, appId, start, limit);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testfindClientByNbr(boolean json, String accountSid, String authToken, String clientNumber, String appId) {
		try {
			String result = InstantiationRestAPI(json).findClientByNbr(accountSid, authToken, clientNumber, appId);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testCloseClient(boolean json, String accountSid, String authToken, String clientNumber, String appId) {
		try {
			String result = InstantiationRestAPI(json).closeClient(accountSid, authToken, clientNumber, appId);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testChargeClient(boolean json, String accountSid, String authToken, String clientNumber, String chargeType, String charge, String appId) {
		try {
			String result = InstantiationRestAPI(json).charegeClient(accountSid, authToken, clientNumber, chargeType, charge, appId);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testBillList(boolean json, String accountSid, String authToken, String appId, String date) {
		try {
			String result = InstantiationRestAPI(json).billList(accountSid, authToken, appId, date);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testClientBillList(boolean json, String accountSid, String authToken, String appId, String clientNumber, String date) {
		try {
			String result = InstantiationRestAPI(json).clientBillList(accountSid, authToken, appId, clientNumber, date);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String testCallback(boolean json, String accountSid, String authToken, String appId, String fromClient, String to, String fromSerNum, String toSerNum, String userData) {
		String result = null;
		try {
			result = InstantiationRestAPI(json).callback(accountSid, authToken, appId, fromClient, to, fromSerNum, toSerNum, userData);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public static void testVoiceCode(boolean json, String accountSid, String authToken, String appId, String to, String verifyCode) {
		try {
			String result = InstantiationRestAPI(json).voiceCode(accountSid, authToken, appId, to, verifyCode);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void testTemplateSMS(boolean json, String accountSid, String authToken, String appId, String templateId, String to, String param) {
		try {
			String result = InstantiationRestAPI(json).templateSMS(accountSid, authToken, appId, templateId, to, param);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String testfindClientByMobile(boolean json, String accountSid, String authToken, String mobile, String appId) {
		try {
			String result = InstantiationRestAPI(json).findClientByMobile(accountSid, authToken, mobile, appId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void testDispalyNumber(boolean json, String accountSid, String authToken, String appId, String clientNumber, String display) {
		try {
			String result = InstantiationRestAPI(json).dispalyNumber(accountSid, authToken, appId, clientNumber, display);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void voiceUrl(String callId) throws Exception {
		EncryptUtil encryptUtil = new EncryptUtil();
		System.out.println(encryptUtil.md5Digest(ACCOUNT_SID + callId + AUTH_TOKEN));
	}

	/*
	 * public void testCall(String to) { String fromClient = "64022029246112";
	 * String fromSerNum = ""; String toSerNum = "13408505238"; String userData
	 * = "123"; testCallback(true, ACCOUNT_SID, AUTH_TOKEN, APP_ID, fromClient,
	 * to, fromSerNum, toSerNum, userData); }
	 */

	/**
	 * 测试说明 参数顺序，请参照各具体方法参数名称 参数名称含义，请参考rest api 文档
	 * 
	 * @author Glan.duanyj
	 * @date 2014-06-30
	 * @param params[]
	 * @return void
	 * @throws IOException
	 * @method main
	 */
	public static void main(String[] args) throws Exception {
		String method = "3";
		boolean json = true;
		if (method.equals("1")) {
			// 创建账户
			String clientType = "0";
			String charge = "0";
			String friendlyName = "13408505237";
			String mobile = "13408505237";
			testCreateClient(json, ACCOUNT_SID, AUTH_TOKEN, APP_ID, mobile, "0", "0", mobile);
			// Response content is:
			// {"resp":{"respCode":"000000","client":{"balance":"0","clientNumber":"64022029246112","clientPwd":"9cf9e638","createDate":"2015-08-24
			// 15:57:00"}}}
		} else if (method.equals("2")) {
			// 拨打号码
			String fromClient = "64022029246112";
			String to = "13340962382";
			String fromSerNum = "02887055599";
			String toSerNum = "13408505238";
			String userData = EncryptHelper.encryptBase64("1" + "!!" + "0");
			testCallback(json, ACCOUNT_SID, AUTH_TOKEN, APP_ID, fromClient, to, fromSerNum, toSerNum, userData);
		} else if (method.equals("3")) {
			// 查找clientnumber
			System.out.println(testfindClientByMobile(json, ACCOUNT_SID, AUTH_TOKEN, "15114014553", APP_ID));
		} else if (method.equals("4")) {
			testCloseClient(json, ACCOUNT_SID, AUTH_TOKEN, "64022029621872", APP_ID);
		}
	}
}
