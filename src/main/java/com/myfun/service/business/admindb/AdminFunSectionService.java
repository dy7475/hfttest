package com.myfun.service.business.admindb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dto.AdminFunSectionDto;
import com.myfun.repository.admindb.param.AdminFunSectionParam;
import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.admindb.po.AdminFunSectionKey;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunSectionService extends BaseMapper<AdminFunSection, AdminFunSectionKey>{
	
	/**
	 * 查询数据列表
	 * @param num
	 * @param adminFunSection
	 * @return
	 */
	PageInfo<AdminFunSectionDto> getSectionsData(AdminFunSectionParam adminFunSectionParam);
	
	/**
	 * 创建板块区域
	 * @param adminFunSection
	 */
	public void createRecords(AdminFunSection adminFunSection);
	
	/**
	 * 修改板块信息
	 * @param adminFunSection
	 */
	public void updateRecords(AdminFunSection adminFunSection);

	List<SelectDto> selectSectionByRegIdAndSectionName(Integer regId, String sectionName);
	
}
