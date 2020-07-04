package com.myfun.erpWeb.openApi.other;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.AdminJmsMessageMapper;
import com.myfun.repository.admindb.dao.AdminServerErrorLogMapper;
import com.myfun.repository.admindb.po.AdminJmsMessage;
import com.myfun.repository.admindb.po.AdminJmsMessageExample;
import com.myfun.repository.admindb.po.AdminServerErrorLog;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.utils.Constants_DIC;

/**
 * 其他测试的一些控制器
 * @author 张宏利
 * @since 2017年4月17日
 */
@Controller
@RequestMapping(value = "/openApi/test")
public class DealJmsErrorMsgController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DealJmsErrorMsgController.class);
	
	@Autowired AdminServerErrorLogMapper adminServerErrorLogMapper;
	
	/**
	 * 处理jms异常量
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dealJmsErrorMsg")
	public String dealJmsErrorMsg(String tableEnd, Integer loopCount) {
		if(loopCount == null || loopCount <= 0) {
			loopCount = 5;
		}
		if(StringUtils.isBlank(tableEnd)) {
			return "name_error";
		}
		for (int i = 0; i < loopCount; i++) {
			List<AdminServerErrorLog> msgList = adminServerErrorLogMapper.getErrorLogList(tableEnd);
			if(msgList == null || msgList.isEmpty()) {
				break;
			}
			for (AdminServerErrorLog errorLog : msgList) {
				AdminJmsMessage adminJmsMessage = JSON.parseObject(errorLog.getExceptionText(), AdminJmsMessage.class);
				JmsPublisher.sendMessage(adminJmsMessage);
			}
			List<Integer> idList = msgList.stream().collect(Collectors.mapping(AdminServerErrorLog::getId, Collectors.toList()));
			adminServerErrorLogMapper.deleteErrorLog(tableEnd, idList);
		}
		return "ok";
	}
}

