package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizPersonMapper;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPerson;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupBizPersonService;

@Service
public class ErpFunAttendanceGroupBizPersonServiceImpl extends AbstractService<ErpFunAttendanceGroupBizPerson, ErpFunAttendanceGroupBizPerson> implements ErpFunAttendanceGroupBizPersonService {

	@Autowired
	ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceGroupBizPersonMapper;
	}
	
}
