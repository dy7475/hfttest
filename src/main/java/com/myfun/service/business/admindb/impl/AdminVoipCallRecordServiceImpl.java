package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminVoipCallRecordMapper;
import com.myfun.repository.admindb.po.AdminVoipCallRecord;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoipCallRecordService;

@Service
public class AdminVoipCallRecordServiceImpl extends AbstractService<AdminVoipCallRecord, Integer>implements AdminVoipCallRecordService {
	@Autowired
	private AdminVoipCallRecordMapper adminVoipCallRecordMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminVoipCallRecordMapper;
	}

}
