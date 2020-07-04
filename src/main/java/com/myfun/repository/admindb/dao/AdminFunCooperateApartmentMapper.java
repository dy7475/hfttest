package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunCooperateApartment;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunCooperateApartmentMapper extends BaseMapper<AdminFunCooperateApartment, String> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminFunCooperateApartment record);
}