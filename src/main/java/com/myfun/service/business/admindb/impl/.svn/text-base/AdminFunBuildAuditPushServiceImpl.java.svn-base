package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunBuildAuditPushMapper;
import com.myfun.repository.admindb.po.AdminFunBuildAuditPush;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBuildAuditPushService;

@Service
public class AdminFunBuildAuditPushServiceImpl extends AbstractService<AdminFunBuildAuditPush, Integer> implements AdminFunBuildAuditPushService {

	@Autowired
	private AdminFunBuildAuditPushMapper adminFunBuildAuditPushMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunBuildAuditPushMapper;
	}

	@Override
	public boolean pushWindowShow(Integer archiveId) {
		AdminFunBuildAuditPush funBuildAuditPush = adminFunBuildAuditPushMapper.getFunBuildAuditPushByArchiveId(archiveId);
		//老用户的
		if (funBuildAuditPush == null) {
			return false;
		}
		// 弹窗
		if ("1".equals(funBuildAuditPush.getWindowShow())) {
			return true;
		}
		return false;
	}
}
