package com.myfun.service.push;


import com.alibaba.fastjson.JSON;
import com.extension.framework.mq.context.MqUtil;
import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.admindb.AdminWeiPushRecordService;
import com.myfun.service.jms.bean.YouJiaWxPushMessage;
import com.myfun.utils.HttpUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @TODO youjia微信推送
 * @author lcb
 * @2016-9-1 下午3:38:55
 */

public class YoujiaWXPushUtil {
	private static YoujiaWXPushUtil youjiaWXPushUtil= null;
	static AdminWeiPushRecordService adminWeiPushRecordService = null;
	static AdminJmsMessageService adminJmsMessageService = null;
	static MqUtil mqUtil = null;
	// 写入推送记录
	public static YoujiaWXPushUtil getInstance() {
		adminWeiPushRecordService = SpringContextUtil.getBean(AdminWeiPushRecordService.class);
		adminJmsMessageService = SpringContextUtil.getBean(AdminJmsMessageService.class);
		mqUtil = SpringContextUtil.getBean(MqUtil.class);
		if(null == youjiaWXPushUtil) {
			youjiaWXPushUtil = new YoujiaWXPushUtil();
		}
		return youjiaWXPushUtil;
	}
	
	/**
	 * @TODO 添加发送对象到队列
	 * @author lcb
	 * 
	 */
	public void sendMessage(YouJiaWxPushMessage youJiaWxPushMessage) throws Exception {
		youJiaWxPushMessage.setCreateTime(new Date());
		youJiaWxPushMessage.setQueneName(JmsMsgAction.YOUJIA_WX_PUSH);
		mqUtil.sendMessage(youJiaWxPushMessage);

	}
	
	
	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-1 下午3:39:48
	 */
	public static void main(String[] args) throws Exception {

		Map<String, Object> bMap = new HashMap<>();
		bMap.put("action", "noticeLawyer"); // 模板ID
		bMap.put("paramOne", "您有一个合同需要审核,点击立即处理"); // title
		bMap.put("paramTwo", "1246"); // 审核结果
		bMap.put("paramThree", "出售合同"); // 审核人+门店名称
		bMap.put("paramFour", "好房通测试A店"); // 审核时间
		bMap.put("paramFive", "2016-10-20 17:29:22"); // 签约人员
		bMap.put("paramSix", "等待一审!"); // 修改信息
		bMap.put("remark", "请及时查看合同!"); // remark
		String hr ="http://youjia.haofang.net/Home/Contract/information.html?deal_id=8089";
		bMap.put("href", URLEncoder.encode(hr, StandardCharsets.UTF_8.toString())); // 链接
		bMap.put("openIds", "ool02uPU2hy04bosoUYByshIhIOg");
		String httpPostWithJSON = HttpUtil.post("http://youjia.haofang.net/Home/Api/sendTemplateMsg", bMap);
		System.out.println(httpPostWithJSON);
	}
}
