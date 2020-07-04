package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.axn.param.CreateNumberPoolParam;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPool;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpAliyunNumberPoolService extends BaseMapper<ErpAliyunNumberPool, ErpAliyunNumberPool>{
	
	/**
	 * 创建号码池
	 * @param param
	 * @return
	 */
	ErpAliyunNumberPool createNumberPool(CreateNumberPoolParam param);
	
}
