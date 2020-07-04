package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyClient400;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyClient400Mapper extends BaseMapper<AgencyClient400, Integer> {

	/**
	 * 更新400配置表
	 * @param client
	 */
	public void updateClient(AgencyClient400 client);
}