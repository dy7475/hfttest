package com.myfun.service.business.admindb.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunTempletMapper;
import com.myfun.repository.admindb.po.AdminFunTemplet;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunTempletService;

@Service
public class AdminFunTempletServiceImpl extends AbstractService<AdminFunTemplet, Integer> implements AdminFunTempletService {

	@Autowired
	private AdminFunTempletMapper adminFunTempletMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminFunTempletMapper;
	}

	@Override
	public void updateHouseTemplet(Integer id, String charactTemplet, String subjectTemplet) {
		// TODO
		AdminFunTemplet adminFunTemplet = new AdminFunTemplet();
		adminFunTemplet.setId(id);
		adminFunTemplet.setCharactTemplet(charactTemplet);
		adminFunTemplet.setSubjectTemplet(subjectTemplet);
		adminFunTempletMapper.updateByPrimaryKeyWithBLOBs(adminFunTemplet);
	}

	

}
