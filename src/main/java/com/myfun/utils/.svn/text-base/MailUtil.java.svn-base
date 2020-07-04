package com.myfun.utils;

import org.apache.commons.mail.SimpleEmail;

/**
 * 发送邮件帮助类
 * 
 * @ClassName: MailUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:07:29
 *
 */
public class MailUtil {
	/**
	 * 发送简单邮件
	 * 
	 * @param hostName
	 * @param userName
	 * @param password
	 * @param to
	 * @param title
	 * @param content
	 * @return
	 */
	public static boolean sendSimpleMail(String hostName, String userName, String password, String to, String title,
			String content) {
		SimpleEmail email1 = new SimpleEmail();// 如果发送普通的邮件，使用这个类就可以了
		email1.setHostName(hostName);
		try {
			email1.setFrom(userName);
			email1.setAuthentication(userName, password);
			email1.addTo(to);
			email1.setSubject(title);
			email1.setMsg(content);
			email1.send();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
