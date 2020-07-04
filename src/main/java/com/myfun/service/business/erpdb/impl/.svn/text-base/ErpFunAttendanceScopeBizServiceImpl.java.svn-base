package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeBizMapper;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBiz;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeBizService;

@Service
public class ErpFunAttendanceScopeBizServiceImpl extends AbstractService<ErpFunAttendanceScopeBiz, ErpFunAttendanceScopeBiz> implements ErpFunAttendanceScopeBizService {

	@Autowired
	ErpFunAttendanceScopeBizMapper erpFunAttendanceScopeBizMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceScopeBizMapper;
	}
}
