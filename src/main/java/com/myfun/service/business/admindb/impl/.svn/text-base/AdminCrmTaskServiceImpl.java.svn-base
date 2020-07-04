package com.myfun.service.business.admindb.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.myfun.utils.DateTimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminCrmTaskMapper;
import com.myfun.repository.admindb.po.AdminCrmTask;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCrmTaskService;
import com.myfun.utils.StringUtil;


@Service
public class AdminCrmTaskServiceImpl extends AbstractService<AdminCrmTask, Integer> implements AdminCrmTaskService {

	@Autowired
	private AdminCrmTaskMapper adminCrmTaskMapper;
	
	@Override
	public void setBaseMapper() {
		this.baseMapper = adminCrmTaskMapper;
	}

	@Override
	public void remindConsultant(Integer adminCompId, Integer adminDeptId, String selUid, String warmContent) {
		AdminCrmTask adminCrmTask = new AdminCrmTask();
		adminCrmTask.setTaskStatus((short)0);
		adminCrmTask.setTaskType((short)0);
		adminCrmTask.setCompId(adminCompId);
		// 容错
		if(null == adminCompId){
			adminCrmTask.setCompId(0);
		}
		adminCrmTask.setDeptId(adminDeptId);
		// 容错
		if(null == adminDeptId){
			adminCrmTask.setDeptId(0);
		}
		adminCrmTask.setTaskOwner(StringUtil.paseInteger(selUid));
		adminCrmTask.setTaskContent(warmContent);
		List<AdminCrmTask> adminCrmTaskList = adminCrmTaskMapper.getRemindConsultantList(adminCompId, adminDeptId, StringUtil.paseInteger(selUid), warmContent);
		if (null != adminCrmTaskList && !adminCrmTaskList.isEmpty()) {
			try {// 一天内只提醒一次
				AdminCrmTask queryTask = adminCrmTaskList.get(0);
				Date date = queryTask.getCreationTime();
                String strDate = DateTimeHelper.formatDateTimetoString(date,DateTimeHelper.FMT_yyyyMMdd);
                if (StringUtil.isBlank(strDate) || (LocalDate.now().toString()).equals(strDate)){
                    return;
                }

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		adminCrmTask.setCrmCompId(1);
		adminCrmTask.setCrmDeptId(1);
		adminCrmTask.setCreatorUid(Const.DIC_SYSTEM_USERID_999);
		adminCrmTask.setTaskSubject(warmContent);
		adminCrmTask.setTaskContent(warmContent);
		adminCrmTask.setCreationTime(new Date());
		adminCrmTask.setWarmTime(new Date());
		adminCrmTaskMapper.insertSelective(adminCrmTask);
	}

}
