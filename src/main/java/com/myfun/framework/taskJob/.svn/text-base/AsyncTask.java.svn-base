package com.myfun.framework.taskJob;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.utils.HTMLHelper;
import com.myfun.utils.KafkaBizUtils;

/***
 * 
 * @author 尹振兴
 * @since 2018年6月5日
 */
@Component
public class AsyncTask {

	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;

	/**
	 * 推送消息
	 * @param cityId
	 * @param compId
	 */
	@Async
	public void appRefreshSys(Integer cityId, Integer compId) {
		List<ErpFunUsers> list = erpFunUsersMapper.selectAllUserArchiveId(cityId, compId);
		for (ErpFunUsers erpFunUsers : list) {
			JSONObject jsonobject = new JSONObject();
			jsonobject.put("templateId", 76);
			jsonobject.put("receiver", erpFunUsers.getArchiveId());
			KafkaBizUtils.pushMsgByTemplate(jsonobject);
		}
	}
	
	/**
	 * 推送公告消息
	 * @param cityId
	 * @param archiveId
	 * @param bulletId
	 * @param msgTitle
	 * @param msgContent
	 * @throws Exception
	 */
	@Async
	public void sendMsg(Integer cityId, Integer archiveId, Integer bulletId, String msgTitle, String msgContent) throws Exception{
		// 同步推送掌通
		String uuWebRoot= AppConfig.getUuHaofang();
		String webUrl = uuWebRoot + "/B/Home/Notice/notice?action=noticeDetail&needfullscreen=1&bulletId="+bulletId;
		if(StringUtils.isNotBlank(msgContent)) {
			msgContent = HTMLHelper.getTextFromHtml(msgContent);
		}
		if(msgContent.length() > 100) {
			msgContent = msgContent.substring(0, 100);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "68");
		jsonObject.put("receiver", archiveId);
		jsonObject.put("title", msgTitle);
		jsonObject.put("content", msgContent);
		jsonObject.put("url", webUrl);
		KafkaBizUtils.pushMsgByTemplate(jsonObject);
	}
	
}
