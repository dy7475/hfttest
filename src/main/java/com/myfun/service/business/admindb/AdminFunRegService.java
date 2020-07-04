package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunReg;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunRegService  extends BaseMapper<AdminFunReg, Integer>{

	/**
	 * 根据城市和名称查询
	 * @param cityId
	 * @param regName
	 * @return
	 */
	public List<SelectDto> selectByCityIdAndRegName(Integer cityId, String regName);
}
