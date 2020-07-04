package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunDatasourceConfig;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunDatasourceConfigService extends BaseMapper<AdminFunDatasourceConfig, Integer> {
	public void updateAllCompVersion(String compVersion);
}
