package com.myfun.repository.admindb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.myfun.repository.admindb.dto.AdminFunSectionDto;
import com.myfun.repository.admindb.param.AdminFunSectionParam;
import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.admindb.po.AdminFunSectionKey;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AdminFunSectionMapper extends BaseMapper<AdminFunSection, AdminFunSectionKey> {
	/**
	 * 获取片区信息下拉?
	 * @param cityId
	 * @param regId
	 * @return
	 */
	public ArrayList<SelectDto> getSectionInfo(@Param("cityId")String cityId, @Param("regId")String regId);
	
	/**
	 * 查询数据列表
	 * @param adminFunSection
	 * @return
	 */
	List<AdminFunSectionDto> getSectionsData(AdminFunSectionParam adminFunSectionParam);
	
	/**
	 * 获取ID
	 * @return
	 */
	public int getId();

	public List<SelectDto> selectSectionByRegIdAndSectionName(@Param("regId")Integer regId, @Param("sectionName")String sectionName);

	List<Map<String,Object>> getModelDataList(@Param("cityId") Integer cityId, @Param("regIds") String[] regIds);

    List<AdminFunSection> selectListBySectionIds(@Param("cityId")Integer cityId, @Param("sectionIds") List<Integer> sectionIds);
}