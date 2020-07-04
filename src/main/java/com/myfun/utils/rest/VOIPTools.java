package com.myfun.utils.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.myfun.utils.StringUtil;

public class VOIPTools {
	/***
	 * 查询余额
	 * 
	 * @param mobile
	 *            【0|18628227311;18628227311;100.0;2015/07/27；查询成功|账户号码；账户名称
	 *            ；余额；有效期】
	 */
	public static Double queryIpAmount(String mobile) {
		try {
			String ret = getGetResponse("http://182.92.0.28:8888/chs/api/getcustomer.jsp?name=" + mobile);
			System.out.println("余额：" + ret);
			String code = ret.substring(0, 1);
			if (code.equals("0")) {
				String info[] = ret.split("\\|")[1].split(";");
				String amount = info[2];
				return StringUtil.parseDouble(amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	public static void createSysIpAmount(String userMobile) {
		String ret1 = getGetResponse("http://182.92.0.28:8888/chs/api/setcustomer.jsp?account=" + userMobile);
		String ret2 = getGetResponse("http://182.92.0.28:8888/chs/api/setactivephonecard.jsp?pin=" + userMobile
				+ "&password=123456&operationType=0");
		String ret3 = getGetResponse("http://182.92.0.28:8888/chs/api/setbindede164.jsp?e164=" + userMobile);
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public static String getGetResponse(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			HttpGet httppost = new HttpGet(url);
			HttpResponse response = httpClient.execute(httppost);
			HttpEntity entity = response.getEntity();
			String result = "";
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8").trim();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	/***
	 * 充值
	 * 
	 * @param mobile
	 * @param pin
	 * @param password
	 * @return
	 */
	public static String rechargeSys(String mobile, String pin, String password) {
		try {
			String ret = getGetResponse("http://182.92.0.28:8888/chs/api/paybyphonecard.jsp?name=" + mobile
					+ "&type=2&pin=" + pin + "&password=" + password + "&active=1&memo=KMCZ");
			System.out.println("pin:" + pin + ",password:" + password);
			System.out.println("充值：" + ret);
			String code = ret.substring(0, 1);
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			return "1";
		}
	}

	/***
	 * 拨打电话
	 * 
	 * @param mobile1
	 * @param mobile2
	 */
	public static void call(String mobile1, String mobile2) {
		try {
			String ret = getGetResponse("http://182.92.0.28:8888/chs/api/callback.jsp?caller=" + mobile1 + "&callees="
					+ mobile2.replace("手机:", ""));
			System.out.println("拨打电话：" + mobile1 + "to" + mobile2 + "--" + ret);
		} catch (Exception e) {
			e.printStackTrace();
			new Exception("拨打失败");
		}
	}
}
