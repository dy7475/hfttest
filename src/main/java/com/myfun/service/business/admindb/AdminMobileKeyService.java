package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminMobileKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Set;

public interface AdminMobileKeyService extends BaseMapper<AdminMobileKey, Integer> {
	

	/**
	 * 发送通知类短信
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @param phone 手机号
	 * @param signName 签名 1=好房优家
	 * @param message 消息内容
	 * @throws Exception
	 */
	void sendNoticeSms(String phone, String signName, String message);

	/**
	 * 验证短信验证码是否有效
	 * @author 张宏利
	 * @since 2017年5月11日
	 * @param smsCode
	 * @return
	 */
	boolean validateSmsCode(String smsCode, String mobile);


	/**
	 * 插入短信记录
	 * @author 张宏利
	 * @since 2017年6月12日
	 * @param userMobile
	 * @param ipAddr
	 * @param content
	 * @return
	 */
	String creatMobileKeyAndInsert(String userMobile, String ipAddr, String content);


	boolean checkMobileDialToday(String mobile);

	void sendSmsForYouJiaDealStatusChange(Set<String> mobiles, Byte youAduitStatus, String userName, String deptName, String dealNo, String fileName);

	void addWrongTime(Integer keyId, Integer wrongTime);

	/**
	 * @author 刘成
	 * @since 2018年1月10日
	 * @param keyId
	 * 验证成功后，修改状态
	 */
	public void changeStatus(Integer keyId);
}

