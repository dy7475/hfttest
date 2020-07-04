package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunAdsContentDto;
import com.myfun.repository.erpdb.param.CaseFavoriteParam;
import com.myfun.repository.erpdb.param.FunAdsParam;
import com.myfun.repository.erpdb.po.ErpFunAdsContent;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import com.myfun.repository.erpdb.po.ErpFunAdsContentExample;

public interface ErpFunAdsContentMapper extends BaseMapper<ErpFunAdsContent, ErpFunAdsContent> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAdsContentExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAdsContentExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAdsContent> selectByExample(ErpFunAdsContentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAdsContent record,
			@Param("example") ErpFunAdsContentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAdsContent record, @Param("example") ErpFunAdsContentExample example);

	@SwitchDB(type= SwitchDBType.CITY_ID)
	List<ErpFunAdsContentDto> getAdsList(@Param("pMap") Map<String, Object> pMap,@Param("shardCityId") Integer cityId);

	@SwitchDB(type= SwitchDBType.CITY_ID)
	int getPerCompAdsCaseCount(@Param("shardCityId") Integer cityId,@Param("map")Map<String, Object> map);

	@SwitchDB(type= SwitchDBType.CITY_ID)
	void updateAds(@Param("shardCityId") Integer cityId,@Param("map")Map<String, Object> map);
	
	@SwitchDB(type= SwitchDBType.CITY_ID)
	void updateAdsList(@Param("shardCityId") Integer cityId,@Param("map")Map<String, Object> map,@Param("adsContentIdList")List<String> adsContentIdList);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateAdsByprimaryKey(@Param("shardCityId") Integer cityId, @Param("map") Map<String, Object> map);

	@SwitchDB(type= SwitchDBType.CITY_ID)
	void updateAds1(@Param("shardCityId") Integer cityId,@Param("map")Map<String, Object> map,@Param("adsContentIdList")List<String> list);
	
	@SwitchDB(type= SwitchDBType.CITY_ID)
	List<ErpFunAdsContent> getAdsSaleLists(@Param("shardCityId") Integer cityId,@Param("adsContentIdList")List<String> list);
	
	@SwitchDB(type= SwitchDBType.CITY_ID)
	List<ErpFunAdsContent> getAdsLists(@Param("shardCityId") Integer cityId,@Param("param")FunAdsParam param);
	ErpFunAdsContent getErpFunAdsContentByCaseNo(@Param("shardCityId") Integer cityId,@Param("caseNo") String caseNo);
}