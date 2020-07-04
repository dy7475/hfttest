package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.admindb.po.AdminFunSectionKey;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunSelectService extends BaseMapper<AdminFunSection, AdminFunSectionKey> {
	/**
	 * 获取片区信息下拉框
	 * @param cityId
	 * @param regId
	 * @return
	 */
	List<SelectDto> getSectionInfo(String cityId, String regId);

}
