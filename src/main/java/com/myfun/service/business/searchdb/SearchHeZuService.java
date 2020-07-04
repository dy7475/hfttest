package com.myfun.service.business.searchdb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.searchdb.dto.SearchHeZuDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.po.SearchHezu;
import com.myfun.repository.searchdb.po.SearchHezuKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

public interface SearchHeZuService extends BaseMapper<SearchHezu, SearchHezuKey>{
	/**
	 * 查询合租重复列表
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getRepeatHezuList( String cityId, String caseIds);

	public SearchHeZuDataInfoDto getDataInfoById(SoSoSaleDataInfoParam dataInfoParam);
	
	public PageInfo<SearchHeZuDataInfoDto> getSoSoShopMainList(SoSoSaleListParam param, Integer archiveId);
	
	/**
	 * 获取已查看搜搜合租列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public PageInfo<SearchHeZuDataInfoDto> getSOSOViewedHeZuList(SoSoSaleListParam param);

	/**
	 * 标记为假房源
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param sosoId 
	 * @param complaintType 投诉类型，1=中介房源 2=虚假房源
	 * @param archiveId
	 */
	public void complaintSosoData(String time, Integer sosoId,Integer repeatId, Integer complaintType, Integer archiveId, Integer provinceId, Integer cityId);
}
