package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminFunActivityRegisterDto;
import com.myfun.repository.admindb.param.AdminFunActivityRegisterParam;
import com.myfun.repository.admindb.po.AdminFunActivityRegister;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunActivityRegisterMapper extends BaseMapper<AdminFunActivityRegister, Integer> {
	
	/**
	 * 查询公众号报名列表
	 * @param param
	 * @return
	 */
	public List<AdminFunActivityRegisterDto> getPublicNumberRegisterList(AdminFunActivityRegisterParam param);
	
	/**
	 * 根据公司id和门店id获取报名经纪人档案编号
	 */
	public List<AdminFunActivityRegisterDto> getAchiveIDsByCompIDAndDeptID(AdminFunActivityRegister register);
}