package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminWeiPushRecordMapper;
import com.myfun.repository.admindb.po.AdminWeiPushRecord;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminWeiPushRecordService;

@Service
public class AdminWeiPushRecordServiceImpl extends AbstractService<AdminWeiPushRecord, Integer> implements AdminWeiPushRecordService {

	@Autowired
	private AdminWeiPushRecordMapper adminWeiPushRecordMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminWeiPushRecordMapper;
	}


}
