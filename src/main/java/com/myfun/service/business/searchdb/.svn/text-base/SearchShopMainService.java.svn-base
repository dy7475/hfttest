package com.myfun.service.business.searchdb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.searchdb.dto.SearchShopMainInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.po.SearchShopMain;
import com.myfun.repository.searchdb.po.SearchShopMainKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

public interface SearchShopMainService extends BaseMapper<SearchShopMain, SearchShopMainKey>{
	/**
	 * 查询商铺重复数据
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getShopMainRepeatList(String cityId, String caseIds);

	public SearchShopMainInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam dataInfoParam);

	public PageInfo<SearchShopMainInDataInfoDto> getSoSoShopMainList(SoSoSaleListParam param, Integer archiveId);
	
	/**
	 * 获取商铺已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public PageInfo<SearchShopMainInDataInfoDto> getSOSOViewedShopList(SoSoSaleListParam param);

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
