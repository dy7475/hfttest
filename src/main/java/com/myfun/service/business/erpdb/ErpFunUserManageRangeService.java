package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunUserManageRangeService extends BaseMapper<ErpFunUserManageRange, ErpFunUserManageRange>{
	
	/**
	 * 给用户配置管理范围
	 * @author 张宏利
	 * @since 2017年11月1日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param roleId
	 * @param rangeIds
	 */
	void updateUserManageRange(Integer cityId, Integer compId, Integer userId, Integer rangeType, String rangeIds, String roleId, boolean isFangJidi);
	
	/**
	 * 管理范围为公司时调用此方法
	 * @param cityId
	 * @param roleId
	 * @param compId
	 */
	void createRangeForComp(Integer cityId, String roleId, Integer compId);

	void updateFangjiDiUserManageRange(Integer cityId, Integer compId, Integer userId, Integer rangeType,
			String rangeIds, String roleId, boolean isFangJidi);

	/**
	 * @title
	 * @author Lee
	 * @date 2019/12/6 19:34
	 ***/
	void updateUserManageRangeNewOrg(Integer cityId, Integer compId, Integer userId, String rangeIds, String roleId);
}
