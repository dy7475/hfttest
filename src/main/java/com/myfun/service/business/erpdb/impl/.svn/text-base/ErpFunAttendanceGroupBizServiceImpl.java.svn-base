package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizMapper;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBiz;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupBizService;

@Service
public class ErpFunAttendanceGroupBizServiceImpl extends AbstractService<ErpFunAttendanceGroupBiz, ErpFunAttendanceGroupBiz> implements ErpFunAttendanceGroupBizService {

	@Autowired
	ErpFunAttendanceGroupBizMapper 	erpFunAttendanceGroupBizMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceGroupBizMapper;
	}

}
