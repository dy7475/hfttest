package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunSectionService extends BaseMapper<ErpFunSection, ErpFunSection> {
	
	List<ErpFunSection> getSectionList(Integer cityId, Integer regId);

	Integer getSectionIdBySectionName(Integer cityId, String sectionName, Integer saleRegion, Integer buildId);
}
