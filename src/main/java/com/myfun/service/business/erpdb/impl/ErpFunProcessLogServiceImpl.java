package com.myfun.service.business.erpdb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunProcessLogMapper;
import com.myfun.repository.erpdb.po.ErpFunProcessLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunProcessLogService;

@Service
public class ErpFunProcessLogServiceImpl extends AbstractService<ErpFunProcessLog, ErpFunProcessLog> implements ErpFunProcessLogService {

	@Autowired
	private ErpFunProcessLogMapper erpFunProcessLogMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunProcessLogMapper;
	}
	
}
