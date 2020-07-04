package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunScoreRecoredMapper;
import com.myfun.repository.admindb.po.AdminFunScoreRecored;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunScoreRecoredService;

/**
 * 用户跑分记录
 * @author 张宏利
 */
@Service
public class AdminFunScoreRecoredServiceImpl extends AbstractService<AdminFunScoreRecored, Integer> implements AdminFunScoreRecoredService {
	@Autowired
	private AdminFunScoreRecoredMapper adminFunScoreRecoredMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunScoreRecoredMapper;
	}
	
	
	
}
