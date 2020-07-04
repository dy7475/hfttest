package com.myfun.utils.ssq;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.internet.MimeUtility;
import java.net.MalformedURLException;
import java.net.URL;

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
	
	/**
	 * 发送包含附件的邮件（附件为在线资源）
	 * @author XIONG CAI
	 * @since 2018年10月9日 上午11:05:29
	 * @param hostName 主机域名
	 * @param userName	发送人邮箱地址
	 * @param userNickName	发送人昵称
	 * @param password	密码
	 * @param to	收件人地址
	 * @param title	邮件主题
	 * @param content	邮件内容
	 * @param fileUrl	附件地址（在线）
	 * @throws EmailException
	 * @throws MalformedURLException
	 * Modified XXX XIONG CAI 2018年10月9日
	 */
	public static boolean sendEmailsWithOnlineAttachments(String hostName, String userName, String userNickName, String password, String to, String title, String content, String fileUrl, Integer port, String fileName){
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(hostName);
		try {
			// 加载在线附件
			EmailAttachment attachment = new EmailAttachment();
			attachment.setURL(new URL(fileUrl));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			//attachment.setDescription(fileUrl+".png");
			String newfileName = MimeUtility.encodeWord(fileName);
			attachment.setName(newfileName);

			// 创建邮件信息
			email.addTo(to, "");
			email.setFrom(userName, userNickName);
			email.setAuthentication(userName, password);
			email.setSubject(title);
			email.setMsg(content);
			if(port != null){
				email.setSmtpPort(port);
			}
			email.setCharset("UTF-8");
			email.attach(attachment);
			email.setSSLOnConnect(true);
			email.send();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
     }
	
	public static void main(String[] args) {
		/*if(!MailUtil.sendSimpleMail("smtp.qq.com", "1392030717@qq.com", "wvhbrdqpweafgefj", //idqlrepjtspyhgea
				"xiongcaigood@163.com", "注册验证码", "关机状态")){
		}*/
		//sendEmailsWithOnlineAttachments("smtp.qiye.aliyun.com", "hr@haofang.net", "成都好房通科技股份有限公司", "hftrlzy@123", "1056985913@qq.com", "面试邀请21", "成都好房通科技股份有限公司邀请你面试", "http://pic.myfun7.com/oss/online/tmp/2018/08/31/91073a0a250b47ac8d7ee13901cb4e70.png",465,"resume");
		sendEmailsWithOnlineAttachments("smtp.qiye.aliyun.com", "hr@haofang.net", "成都好房通科技股份有限公司", "hftrlzy@123", "1056985913@qq.com", "面试邀请21", "成都好房通科技股份有限公司邀请你面试", "http://img01-uat.m1200.com.cn/oss/online/tmp/2018/08/31/91073a0a250b47ac8d7ee13901cb4e70.png",465,"resume.png");
	}
}
