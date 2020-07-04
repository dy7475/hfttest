package com.myfun.service.business.adminRpt.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindbRpt.dao.AdmindbRptTrackCountInfoMapper;
import com.myfun.repository.admindbRpt.po.AdmindbRptTrackCountInfo;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.adminRpt.AdminRptTrackCountInfoService;
import com.myfun.service.business.admindb.AdminJmsMessageService;

@Service
public class AdminRptTrackCountInfoServiceImpl extends AbstractService<AdmindbRptTrackCountInfo, Integer>implements AdminRptTrackCountInfoService {
	@Autowired
	private AdmindbRptTrackCountInfoMapper admindbRptTrackCountInfoMapper;
	@Autowired
	private AdminJmsMessageService adminJmsMessageService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = admindbRptTrackCountInfoMapper;
	}

	@Transactional
	@Override
	public void addWorkCount(AdmindbRptTrackCountInfo admindbRptTrackCountInfo, Integer jmsMsgId) throws Exception {
		admindbRptTrackCountInfoMapper.addWorkCount(admindbRptTrackCountInfo);
		adminJmsMessageService.deleteJmsMsg(jmsMsgId);
	}

}
