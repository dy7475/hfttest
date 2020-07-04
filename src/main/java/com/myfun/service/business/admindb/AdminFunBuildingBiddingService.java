package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunBuildingBidding;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunBuildingBiddingService extends BaseMapper<AdminFunBuildingBidding, Integer> {
	/**
	 * 查询某个小区的小区专家
	 * @author 陈文超
	 * @date 2016年6月2日 下午3:41:58
	 */
	AdminFunBuildingBidding getBuildOwnerInfo(Integer cityId,Integer buildId) throws Exception;
}
