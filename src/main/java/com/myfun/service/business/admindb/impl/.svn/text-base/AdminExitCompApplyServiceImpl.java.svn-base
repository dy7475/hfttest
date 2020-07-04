package com.myfun.service.business.admindb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminExitCompApplyMapper;
import com.myfun.repository.admindb.po.AdminExitCompApply;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminExitCompApplyService;
import com.myfun.service.business.admindb.AdminPhotoTmpService;

@Service
public class AdminExitCompApplyServiceImpl extends AbstractService<AdminExitCompApply, Integer> implements AdminExitCompApplyService {

	@Autowired
	private AdminExitCompApplyMapper adminExitCompApplyMapper;
	@Autowired
	private AdminPhotoTmpService adminPhotoTmpService;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminExitCompApplyMapper;
	}

	@Override
	public void removeBinding(AdminExitCompApply exitCompApply) {
		AdminExitCompApply auditInfo = adminExitCompApplyMapper.getAuditInfo(exitCompApply.getUserId(), exitCompApply.getCompId(), exitCompApply.getCityId());
		if(auditInfo != null) {
			exitCompApply.setId(auditInfo.getId());
			adminExitCompApplyMapper.updateByPrimaryKeySelective(exitCompApply);
		} else {
			adminExitCompApplyMapper.insertSelective(exitCompApply);
		}
		adminPhotoTmpService.deleteByEcardAddr(exitCompApply.getEcardAddr());
	}



}
