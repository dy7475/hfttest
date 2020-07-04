package com.myfun.service.business.erpdb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunOpersMapper;
import com.myfun.repository.erpdb.po.ErpFunOpers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunOpersService;

@Service
public class ErpFunOpersServiceImpl extends AbstractService<ErpFunOpers, ErpFunOpers> implements ErpFunOpersService{
	@Autowired private ErpFunOpersMapper erpFunOpersMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunOpersMapper;		
	}
	
}
