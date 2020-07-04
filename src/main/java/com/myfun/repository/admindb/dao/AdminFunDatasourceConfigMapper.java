package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;

import com.myfun.repository.admindb.po.AdminFunDatasourceConfig;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunDatasourceConfigMapper extends BaseMapper<AdminFunDatasourceConfig, Integer> {

	List<String> getDatasourceNameGroupBy();

	AdminFunDatasourceConfig selectOneByConnId(String connId);

	void updateAllCompVersion(String enterpriseVesion);

	Date getServerTime();
	
	/**
	 * 删除公司连接信息
	 * @param compId
	 */
	void deleteByCompId(Integer compId);
}