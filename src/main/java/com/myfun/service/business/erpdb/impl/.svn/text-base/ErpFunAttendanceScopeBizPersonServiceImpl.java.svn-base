package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeBizPersonMapper;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizPerson;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeBizPersonService;

@Service
public class ErpFunAttendanceScopeBizPersonServiceImpl extends AbstractService<ErpFunAttendanceScopeBizPerson, ErpFunAttendanceScopeBizPerson> implements ErpFunAttendanceScopeBizPersonService {

	@Autowired
	ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceScopeBizPersonMapper;
	}
}
