package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminVoipPool;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminVoipPoolMapper extends BaseMapper<AdminVoipPool, Integer> {

	Integer lockVoipPoolByUse(String lockId);

	Integer lockVoipPoolByTimeOut(String lockId);

	AdminVoipPool getVoipPoolByLockId(String lockId);
	
	AdminVoipPool getRandomVoipPool();

	Integer freeVoipPoolByLockId(String lockId);
}