package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminWeixinContractMapper;
import com.myfun.repository.admindb.po.AdminWeixinContract;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminWeixinContractService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月26日 下午6:07:44 
 * 类说明 
*/
@Service
public class AdminWeixinContractServiceImpl extends AbstractService<AdminWeixinContract, Integer>implements AdminWeixinContractService {
	@Autowired
	private AdminWeixinContractMapper adminWeixinContractMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminWeixinContractMapper;
	}

	@Override
	public AdminWeixinContract getRecordByCompId(Integer compId) {
		return adminWeixinContractMapper.getRecordByCompId(compId);
	}

	@Override
	public AdminWeixinContract getRecordByWeiDeptId(Integer deptId) {
		return adminWeixinContractMapper.getRecordByWeiDeptId(deptId);
	}
	
		
}
