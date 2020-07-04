package com.myfun.service.business.searchdb;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.searchdb.dto.SearchSaleInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchSaleInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.param.SaleInParam;
import com.myfun.repository.searchdb.po.SearchLeaseIn;
import com.myfun.repository.searchdb.po.SearchSaleIn;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

public interface SearchSaleInService extends BaseMapper<SearchSaleIn, Integer> {
	/**
	 * 分页查询 出售
	 * 
	 * @param pageNumber
	 * @param saleIn
	 * @return
	 */
	public List<SearchSaleIn> getSaleInList(SaleInParam saleIn);

	/**
	 * 判断能否删除 出售
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public boolean isDelete(String[] ids, String tableName);

	/**
	 * 判断是否是VIP用户 出售
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public boolean isVipFlag(String[] ids, String tableName);

	/**
	 * 修改状态 10 删除房源出售
	 * 
	 * @param ids
	 * @param tableName
	 * @param record
	 * @return
	 */
	public int updateStatusFlag(String[] ids, String tableName, AdminCrmBrokerTrack record);

	/**
	 * 房源上架出售
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public boolean isUpHouse(String[] ids, String tableName);

	/**
	 * 把状态更新为0 出售
	 * 
	 * @param ids
	 * @param tableName
	 * @return
	 */
	public int updateStatusFlagForUp(String[] ids, String tableName);

	/**
	 * 通过ID获取实体对象 出售
	 * 
	 * @param id
	 * @param tableName
	 * @return
	 */
	public SearchSaleIn getSearchSaleInById(String id, Date inTime);

	/**
	 * 根据ＩＤ查询出租实体信息
	 * 
	 * @param id
	 * @return
	 */
	public SearchLeaseIn getSearchLeaseInById(String id, String tableName);

	/**
	 * 同步搜搜
	 * 
	 * @param caseType
	 * @param cityId
	 * @param caseId
	 * @param sosoId
	 * @throws Exception
	 */
	public void SyncVipSosoUgc(String caseType, Short cityId, Integer caseId, Integer sosoId);

	/**
	 * 获取委托信息
	 * 
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 * @throws Exception
	 */
	public AgencyCommentDto getCaseInfo(String tableName, String fieldName, String cityId, String caseId);

	public void deleteSeleInById(Integer id, Date inTime);

	public void updateSaleInNotNullById(SearchSaleIn searchSaleIn);
	
	/**
	 * 获取搜搜出售列表
	 * @author 张宏利
	 * @return
	 */
	public PageInfo<SearchSaleInDto> getSoSoSaleList(SoSoSaleListParam param, Integer archiveId);
	
	/**
	 * 获取搜搜出售已查看列表
	 * @author 张宏利
	 */
	public PageInfo<SearchSaleInDto> getSOSOViewedSaleList(SoSoSaleListParam param);

	public SearchSaleInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam param);
	
	/**
	 * 标记为假数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param sosoId 
	 * @param complaintType 投诉类型，1=中介房源 2=虚假房源
	 * @param archiveId
	 */
	public void complaintSosoData(String time, Integer sosoId,Integer repeatId, Integer complaintType, Integer archiveId, Integer provinceId, Integer cityId);

}
