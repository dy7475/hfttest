package com.myfun.service.business.admindb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminPhotoTmpMapper;
import com.myfun.repository.admindb.po.AdminPhotoTmp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminPhotoTmpService;

@Service
public class AdminPhotoTmpServiceImpl extends AbstractService<AdminPhotoTmp, String> implements AdminPhotoTmpService {
	@Autowired
	private AdminPhotoTmpMapper adminPhotoTmpMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper = adminPhotoTmpMapper;
	}

	@Override
	public void deleteByEcardAddr(String ecardAddr) {
		adminPhotoTmpMapper.deleteByEcardAddr(ecardAddr);
	}

	@Override
	public void updatePhotoTmp(String[] urlsArr) {
		adminPhotoTmpMapper.updatePhotoTmp(urlsArr);
	}



}
