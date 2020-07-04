package com.myfun.repository.searchdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.searchdb.dto.SearchSaleInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchSaleInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.param.SaleInParam;
import com.myfun.repository.searchdb.po.SearchSaleIn;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.generator.ColumnVo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.repository.searchdb.po.SearchSaleInKey;

public interface SearchSaleInMapper extends BaseMapper<SearchSaleIn, Integer> {
	/**
	 * 获取分页查询数据
	 * 
	 * @param saleIn
	 * @return
	 */
	@AccessReadonlyDb
	public List<SearchSaleIn> getSaleInList(SaleInParam saleIn);

	/**
	 * 获取状??
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int getStatueFlag(@Param("ids") String[] ids, @Param("tableName") String tableName);

	/**
	 * 根据ID查询状??
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int getVipFlag(@Param("ids") String[] ids, @Param("tableName") String tableName);

	/**
	 * 修改状??
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int updateStatusByids(@Param("ids") String[] ids, @Param("tableName") String tableName);

	/**
	 * 上架
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int isUpHouse(@Param("ids") String[] ids, @Param("tableName") String tableName);

	/**
	 * 上架前修改状??
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int updateStatusForUpByids(@Param("ids") String[] ids, @Param("tableName") String tableName);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @param tableName
	 * @return
	 */
	public SearchSaleIn getSaleInByid(@Param("id") String id, @Param("tableName") String tableName);

	/**
	 * 根据ID更新
	 * 
	 * @return
	 */
	public int updateByPrimaryKeySelectiveById(SearchSaleIn salein);

	/**
	 * 获取Id
	 * 
	 * @return
	 */
	public int getSEQSOSOId();

	/**
	 * 获取委托信息
	 * 
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 * @throws Exception
	 */
	public AgencyCommentDto getCaseInfo(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("cityId") String cityId, @Param("caseId") String caseId);

	/**
	 * 更新响应表的状?和时间
	 * 
	 * @param sosoTableName
	 * @param statusFlag
	 * @param sosoId
	 */
	public void updateStausFlagAndVipDownTmw(@Param("nowdate") Date nowdate, @Param("sosoTableName") String sosoTableName, @Param("statusFlag") String statusFlag, @Param("sosoId") String sosoId);

	/**
	 * 搜搜 出售 查询重复房源
	 *
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getRepeatSaleList(@Param("cityId") String cityId, @Param("caseIds") String[] caseIds);

	@AccessReadonlyDb
	public List<SearchSaleIn> getSaleInListBySolrForPage(DaoBaseParam param);

	/**
	 * soso库对应的表上?
	 * 
	 * @param sosoTableName
	 * @param sosoId
	 */
	public void downHouse(@Param("sosoTableName") String sosoTableName, @Param("sosoId") String sosoId);

	public List<ColumnVo> getColumnInfoByTbName(String tbName);

	public void deleteSeleInById(Integer id);

	public void updateNotNullById(SearchSaleIn searchSaleIn);

	public List<SearchSaleInDto> getSoSoSaleList(DaoBaseParam param);

	public SearchSaleInDataInfoDto getSaleInDataInfoById(DaoBaseParam param);
	
	/**
	 * 获取搜搜已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<SearchSaleInDto> getSOSOViewedSaleList(DaoBaseParam param);
	
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
	
	List<SearchSaleInDto> getSaleInRepeatById(DaoBaseParam param);

	Integer countByUrl(@Param("provinceId") Integer provinceId, @Param("cityId")Integer cityId, @Param("dataUrl")String dataUrl);
}