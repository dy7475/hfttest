package com.myfun.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信工具类
 * 
 * @ClassName: MsgUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:08:41
 *
 */
public class MsgUtil {

	/**
	 * 
	 * @param url
	 *            应用地址，类似于http://ip:port/msg/
	 * @param account
	 *            账号
	 * @param pswd
	 *            密码
	 * @param mobile
	 *            手机号码，多个号码使用","分割
	 * @param msg
	 *            短信内容
	 * @param needstatus
	 *            是否需要状态报告，需要true，不需要false
	 * @return 返回值定义参见HTTP协议文档
	 * @throws Exception
	 */
	public static String send(String url, String account, String pswd, String mobile, String msg, boolean needstatus,
			String product, String extno) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("account", account);
		param.put("pswd", pswd);
		param.put("needstatus", needstatus);
		param.put("mobile", mobile);
		param.put("product", product);
		param.put("extno", extno);
		param.put("msg", msg);
		String result = HttpUtil.post(url, param);
		return result;
	}

}
