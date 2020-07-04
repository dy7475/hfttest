package com.myfun.service.business.searchdb;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.searchdb.dto.SearchLeaseInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchLeaseInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.param.LeaseInParam;
import com.myfun.repository.searchdb.po.SearchLeaseIn;
import com.myfun.repository.searchdb.po.SearchLeaseInKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

public interface SearchLeaseInService extends BaseMapper<SearchLeaseIn, SearchLeaseInKey> {
	/**
	 * 获取出售重复列表
	 * 
	 * @param cityId
	 * @param caseIds
	 * @return
	 */
	public List<SearchRepeatDto> getRepeatLeaseIn(String cityId, String caseIds);

	public void updateLeaseInNotNullById(SearchLeaseIn searchLeaseIn);

	public List<SearchLeaseIn> getLeaseInList(LeaseInParam param);

	public SearchLeaseIn getSearchLeaseInById(String id, Date inTime);

	public SearchLeaseInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam dataInfoParam);
	
	public PageInfo<SearchLeaseInDto> getSoSoLeaseList(SoSoSaleListParam param, Integer archiveId);
	
	/**
	 * 获取搜搜已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public PageInfo<SearchLeaseInDto> getSOSOViewedLeaseList(SoSoSaleListParam param);
	
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
