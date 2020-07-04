package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminVoipPool;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminVoipPoolService extends BaseMapper<AdminVoipPool, Integer> {
	/**
	 * 获取有效的计费号码 如果没有返回空<br/>
	 * 生成lockId<br/>
	 * 先锁定没有使用的资源<br/>
	 * 如果没有则锁定超时的资源<br/>
	 * 如果都没有则返回空<br/>
	 * 
	 * @return
	 */
	public AdminVoipPool getValidChargeInfo();

	/**
	 * 释放资源池
	 * 
	 * @param sessionId
	 */
	public void freeVoipPoolBySessionId(String sessionId);

	/**
	 * 释放资源池
	 * 
	 * @param poolId
	 */
	public void freeVoipPoolByPoolId(Integer poolId);
}
