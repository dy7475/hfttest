package com.myfun.service.business.admindb;

import java.util.ArrayList;
import java.util.List;

import com.myfun.repository.admindb.po.AdminFunProvince;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunProvinceService extends BaseMapper<AdminFunProvince, Short>{
	public AdminFunProvince getAdminFunProvince(String provinceId);

	/**
	 * 查询省份列表
	 * @param provinceName
	 * @return
	 */
	public List<AdminFunProvince> selectByProvinceAll(String provinceName);
	
	
	/**
	 * 查询全部省份
	 * @return
	 */
	public List<AdminFunProvince> getProvinceAll(String proviceName);
}
