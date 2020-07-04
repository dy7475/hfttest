package com.myfun.repository.search2db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.search2db.po.Search2ShopMain;
import com.myfun.repository.search2db.po.Search2ShopMainKey;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.dto.SearchShopMainInDataInfoDto;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface Search2ShopMainMapper extends BaseMapper<Search2ShopMain, Search2ShopMainKey> {
	/**
	 * 查询商铺重复数据
	 * 
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getShopMainRepeatList(@Param("cityId") String cityId, @Param("caseIds") String[] caseIds);

	@AccessReadonlyDb
	List<Search2ShopMain> getShopMainListBySolrForPage(DaoBaseParam param);

	public SearchShopMainInDataInfoDto getDataInfoById(DaoBaseParam param);
	
	public List<SearchShopMainInDataInfoDto> getSoSoShopMainList(DaoBaseParam param);
	
	/**
	 * 获取搜搜转铺已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<SearchShopMainInDataInfoDto> getSOSOViewedShopList(DaoBaseParam param);

	/**
	 * 增加投诉次数
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param sosoId
	 * @param complaintType
	 */
	public void addComplaintCount(@Param("sosoTableName") String sosoTableName,
			@Param("sosoId") Integer sosoId,@Param("complaintType") Integer complaintType,
			@Param("cityId")  Integer cityId);
	
	List<SearchShopMainInDataInfoDto> getShopRepeatById(DaoBaseParam param);
}