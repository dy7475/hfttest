package com.myfun.repository.search2db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.search2db.po.Search2LeaseIn;
import com.myfun.repository.search2db.po.Search2LeaseInKey;
import com.myfun.repository.searchdb.dto.SearchLeaseInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchLeaseInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface Search2LeaseInMapper extends BaseMapper<Search2LeaseIn, Search2LeaseInKey> {

	/**
	 * 根据Id查询出租实体
	 * 
	 * @param id
	 * @param tableName
	 * @return
	 */
	public Search2LeaseIn getSearch2LeaseInById(@Param("id") String id, @Param("tableName") String tableName);

	/**
	 * 获取出售重复列表
	 * 
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getRepeatLeaseIn(@Param("cityId") String cityId, @Param("caseIds") String[] caseIds);

	@AccessReadonlyDb
	public List<Search2LeaseIn> getLeaseInListBySolrForPage(DaoBaseParam param);

	void updateNotNullById(Search2LeaseIn Search2LeaseIn);

	public SearchLeaseInDataInfoDto getDataInfoById(DaoBaseParam param);
	
	public List<SearchLeaseInDto> getSoSoLeaseList(DaoBaseParam param);
	
	/**
	 * 获取搜搜出售已查看房源列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<SearchLeaseInDto> getSOSOViewedLeaseList(DaoBaseParam param);

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
	
	List<SearchLeaseInDto> getLeaseRepeatById(DaoBaseParam param);

    Integer countByUrl(@Param("provinceId") Integer provinceId, @Param("cityId")Integer cityId, @Param("dataUrl")String dataUrl);
}