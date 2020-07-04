package com.myfun.service.business.admindb;

import java.util.ArrayList;

import com.myfun.repository.admindb.po.AdminDicDefinitions;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminDicDefinnitionsService extends BaseMapper<AdminDicDefinitions, Integer>{
	/**
	 * 根据编码查询Text
	 * @param dicValue
	 * @return
	 */
	public AdminDicDefinitions getMsg(String dicType, String dicValue);

	public AdminDicDefinitions getMsgS(String cityId, String dicType, String dicValue);

	public ArrayList<SelectDto> getMsgList(String cityId, String dicType);
}
