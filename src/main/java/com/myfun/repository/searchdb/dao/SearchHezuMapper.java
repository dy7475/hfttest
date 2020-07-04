package com.myfun.repository.searchdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.searchdb.dto.SearchHeZuDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.po.SearchHezu;
import com.myfun.repository.searchdb.po.SearchHezuKey;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface SearchHezuMapper extends BaseMapper<SearchHezu, SearchHezuKey> {
	/**
	 * 查询合租重复列表
	 * 
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getRepeatHezuList(@Param("cityId") String cityId, @Param("caseIds") String[] caseIds);

	@AccessReadonlyDb
	List<SearchHezu> getHezuListBySolrForPage(DaoBaseParam param);

	public SearchHeZuDataInfoDto getDataInfoById(DaoBaseParam param);

	public List<SearchHeZuDataInfoDto> getSoSoHezuList(DaoBaseParam param);
	
	/**
	 * 获取合租已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<SearchHeZuDataInfoDto> getSOSOViewedHeZuList(DaoBaseParam param);

	/**
	 * 增加投诉次数
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param sosoId
	 * @param complaintType
	 */
	public void addComplaintCount(@Param("sosoTableName") String sosoTableName,
			@Param("sosoId") Integer sosoId,@Param("complaintType") Integer complaintType,
			@Param("provinceId") Integer provinceId,@Param("cityId")  Integer cityId);
	
	List<SearchHeZuDataInfoDto> getHezuRepeatById(DaoBaseParam param);
}