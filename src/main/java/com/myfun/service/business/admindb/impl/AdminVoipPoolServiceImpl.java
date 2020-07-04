package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.dao.AdminVoipPoolMapper;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.admindb.po.AdminVoipPool;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoipPoolService;

/**
 * 城市
 * 
 * @author Administrator
 *
 */
@Service
public class AdminVoipPoolServiceImpl extends AbstractService<AdminVoipPool, Integer>implements AdminVoipPoolService {
	@Autowired
	private AdminVoipPoolMapper adminVoipPoolMapper;
	@Autowired
	private AdminIpCallLogMapper adminIpCallLogMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminVoipPoolMapper;
	}

	/**
	 * @see AdminVoipPoolService#getValidChargeInfo()
	 */
	@Override
	public AdminVoipPool getValidChargeInfo() {
//		AdminVoipPool adminVoipPool = null;
//		String lockId = StringUtil.getUUIDBySub();
//		// 锁定有效的
//		Integer effectCount = adminVoipPoolMapper.lockVoipPoolByUse(lockId);
//		if (effectCount < 1) {
//			// 锁定超时的
//			effectCount = adminVoipPoolMapper.lockVoipPoolByTimeOut(lockId);
//		}
//
//		// 如果有锁定 获取锁定记录
//		if (effectCount > 0) {
//			adminVoipPool = adminVoipPoolMapper.getVoipPoolByLockId(lockId);
//		}
		AdminVoipPool adminVoipPool = adminVoipPoolMapper.getRandomVoipPool();
		return adminVoipPool;
	}

	/**
	 * @see AdminVoipPoolService#freeVoipPoolBySessionId(String)
	 */
	@Override
	public void freeVoipPoolBySessionId(String sessionId) {
		AdminIpCallLog adminIpCallLog = adminIpCallLogMapper.selectByPrimaryKey(sessionId);
		if (adminIpCallLog != null) {
			adminVoipPoolMapper.freeVoipPoolByLockId(adminIpCallLog.getPoolLockId());
		}
	}

	/**
	 * @see AdminVoipPoolService#freeVoipPoolByPoolId(Integer)
	 */
	@Override
	public void freeVoipPoolByPoolId(Integer poolId) {
		AdminVoipPool upVoipPool = new AdminVoipPool();
		upVoipPool.setPoolId(poolId);
		upVoipPool.setIsUse((byte) 0);
		adminVoipPoolMapper.updateByPrimaryKeySelective(upVoipPool);
	}
}
