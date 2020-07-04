package com.myfun.service.business.erpdb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunAdsContentDto;
import com.myfun.repository.erpdb.param.FunAdsParam;
import com.myfun.repository.erpdb.po.ErpFunAdsContent;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunAdsContentService extends BaseMapper<ErpFunAdsContent, ErpFunAdsContent>{

	PageInfo<ErpFunAdsContentDto> getAdsContentList(BaseMapParam param);
	List<ErpFunAdsContentDto> getAdsCaseListForExport(BaseMapParam param);
	void creatFunAds(Integer cityId ,FunAdsParam param) throws Exception;
	void cancelFunAds(Integer cityId ,FunAdsParam param) throws Exception;
	void cancelListFunAds(Integer cityId ,FunAdsParam param) throws Exception;
	void cancelAllFunAds(Integer cityId ,FunAdsParam param) throws Exception;

	int cancleAdsContent(Integer cityId, Integer houseId, Integer dicCaseTypeSaleFun);
}
