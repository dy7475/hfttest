package com.myfun.service.business.admindb.impl;

import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminWeiUserInfoMapper;
import com.myfun.repository.admindb.dao.AdminYouBorkerArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminWeiUserInfo;
import com.myfun.repository.admindb.po.AdminWeiUserInfoExample;
import com.myfun.repository.admindb.po.AdminYouBorkerArchive;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.admindb.AdminYouBorkerArchiveService;
import com.myfun.utils.Constants_DIC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AdminYouBorkerArchiveServiceImpl extends AbstractService<AdminYouBorkerArchive, Integer>implements AdminYouBorkerArchiveService {
	@Autowired
	AdminYouBorkerArchiveMapper adminYouBorkerArchiveMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminYouBorkerArchiveMapper;
	}
	
	
	@Override
	public void createYouBorkerArchive(Integer archiveId) {
		AdminYouBorkerArchive po = new AdminYouBorkerArchive();
		po.setArchiveId(archiveId);
		po.setComplainCount(0);
		po.setYouAmount(new BigDecimal(0));
		po.setComplainSuccessCount(0);
		po.setCreationTime(new Date());
		adminYouBorkerArchiveMapper.insertSelective(po);
	}
	
	@Override
	public void updateByArchiveId(Integer archiveId) {
		adminYouBorkerArchiveMapper.updateByArchiveId(archiveId);
	}
}
