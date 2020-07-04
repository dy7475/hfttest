package com.myfun.service.business.searchdb;

import com.myfun.repository.agencydb.dto.AgencyVipBuyDto;
import com.myfun.repository.agencydb.dto.AgencyVipRentDto;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.repository.searchdb.po.SearchSosoViewKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyDataParam;

import java.util.List;
import java.util.Map;

public interface SearchSosoViewService extends BaseMapper<SearchSosoView, SearchSosoViewKey> {
	
	/**
	 * 解密搜搜电话
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param sosoType
	 * @param caseId
	 * @throws Exception 
	 */
	int decodeSosoPhone(String sosoType, Integer caseId, int uaId, int archiveId) throws Exception;
	
	/**
	 * 解密非搜搜电话
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param sosoType
	 * @param caseId
	 */
	List<Map<String, String>> decodeNotSosoPhone(String caseType, Integer caseId, Integer uaId, int cityId, Integer archiveId, String userName, String userMobile, Integer adminDeptId) throws Exception;

	/**
	 * 获取搜搜求购详情
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	AgencyVipBuyDto getVipBuyData(SoSoBuyDataParam param);

	/**
	 * 搜搜求租
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	AgencyVipRentDto getVipRentData(SoSoBuyDataParam param);
	
	/**
	 * 修改统计用的查看次数
	 * @author 张宏利
	 * @since 2018年5月29日
	 * @param viewPO
	 */
	void updateViewCount(SearchSosoView viewPO);
}
