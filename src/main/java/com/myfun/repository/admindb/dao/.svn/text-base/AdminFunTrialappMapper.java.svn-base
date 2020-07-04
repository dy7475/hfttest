package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.param.AdminFunTrialappParam;
import com.myfun.repository.admindb.param.FunTrialappParam;
import com.myfun.repository.admindb.po.AdminFunTrialapp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunTrialappMapper extends BaseMapper<AdminFunTrialapp, Long> {

	/**
	 * 条件查询网络申请列表
	 * @param funTrialapp
	 * @return
	 */
	List<AdminFunTrialapp> selectByAdminFunTrialapp(FunTrialappParam funTrialapp);
	
	/**
	 * 查询招商列表
	 * @param adminFunTrialapp
	 * @return
	 */
	List<AdminFunTrialapp> getRecords(AdminFunTrialappParam adminFunTrialapp);

	AdminFunTrialapp selectIdByAdminFunTrialapp(AdminFunTrialapp adminFunTrialapp);
}