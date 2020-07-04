package com.myfun.service.business.agencydb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.AgencyBuildingInfoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingInfo4AddParam;
import com.myfun.repository.agencydb.param.AgencyBuildingInfoParam;
import com.myfun.repository.agencydb.po.AgencyBuildingInfo;
import com.myfun.repository.agencydb.po.AgencyBuildingInfoKey;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingInfoService extends BaseMapper<AgencyBuildingInfo, AgencyBuildingInfoKey>{
	
	Integer insertBuildInfo(
			AgencyBuildingInfo agencyBuildingInfo,
			AgencyCooperationRule agencyCooperationRule,
			AgencyBuildingInfo4AddParam extParam,
			AdminCrmUser adminCrmUser);

	AgencyBuildingInfoDto getBuildingInfo(Integer buildId);
	
	/**
	 * 获取楼盘名称
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	AgencyBuildingInfo getBuildNameByCityIdAndBuildId(String cityId, String buildId);

	PageInfo<AgencyBuildingInfoDto> getDistBuildListOffIndex(BaseMapParam param);

	AgencyCooperationRule getCooperationRule(Integer buildId, Integer cityId);

	/**
	 * @TODO 公司相关楼盘
	 * @author lcb
	 * @2016-9-5 上午10:32:08
	 */
	List<AgencyBuildingInfo> getDistBuildByComp(BaseMapParam param);

	/**
	 * @TODO 分销楼盘详情
	 * @author lcb
	 * @2016-9-24 下午3:46:10
	 */
	AgencyBuildingInfoDto getBuildInfoDetailed(BaseMapParam param);

	/**
	 * @TODO 分销楼盘列表
	 * @author lcb
	 * @2016-9-27 下午1:59:10
	 */
	PageInfo<AgencyBuildingInfoDto> getBuildInfoList(BaseMapParam param);

	Integer updateDistBuildstatus(BaseMapParam param);

	Integer addEditBuildInfo(BaseMapParam param) throws Exception;
	
}
