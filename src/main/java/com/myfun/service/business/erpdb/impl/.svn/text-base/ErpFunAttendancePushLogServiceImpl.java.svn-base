package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.myfun.repository.erpdb.dao.ErpFunAttendancePushLogMapper;
import com.myfun.repository.erpdb.po.ErpFunAttendancePushLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendancePushLogService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.KafkaBizUtils;
@Service
public class ErpFunAttendancePushLogServiceImpl extends AbstractService<ErpFunAttendancePushLog , ErpFunAttendancePushLog> implements ErpFunAttendancePushLogService{
	@Autowired
	private ErpFunAttendancePushLogMapper erpFunAttendancePushLogMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendancePushLogMapper; 
	}

	@Override
	public void pushAttStaticsByManageRange(Integer cityId, Integer compId, String attDate, Integer userId,
		Integer archiveId, Integer totalErrorCount, Integer nomalCount) {
		String msgContent = "昨日您的团队员工全部正常出勤,再接再厉！";
		if (totalErrorCount>0) {
			msgContent = "昨日您的团队有"+totalErrorCount+"人打卡异常,快去看看把！";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "6");
		jsonObject.put("receiver", archiveId);
		jsonObject.put("content", msgContent);
		jsonObject.put("data", attDate);
		KafkaBizUtils.pushMsgByTemplate(jsonObject);
		ErpFunAttendancePushLog erpFunAttendancePushLog = new ErpFunAttendancePushLog();
		erpFunAttendancePushLog.setShardCityId(cityId);
		erpFunAttendancePushLog.setCityId(cityId);
		erpFunAttendancePushLog.setPushAttDate(DateTimeHelper.parseToDate(attDate));
		erpFunAttendancePushLog.setCompId(compId);
		erpFunAttendancePushLog.setUserId(userId);
		erpFunAttendancePushLogMapper.insertSelective(erpFunAttendancePushLog);
	}
}
