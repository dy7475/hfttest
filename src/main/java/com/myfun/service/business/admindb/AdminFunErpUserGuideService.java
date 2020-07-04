package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunErpUserGuide;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunErpUserGuideService extends BaseMapper<AdminFunErpUserGuide, Integer> {
	
	/**
	 * 新建用户时创建所有的基本引导页
	 * @author 张宏利
	 * @since 2017年1月20日
	 * @param archiveId
	 * @throws Exception
	 */
	void insertAllUserGuide(Integer archiveId);

	/**
	 * 用户权限改变时增加以权限控制的引导页
	 * @author 张宏利
	 * @since 2017年1月20日
	 * @param archiveId
	 * @throws Exception
	 */
	void insertUserSeniorGuide(Integer userId, Integer archiveId);
	
	/**
	 * 修改引导状态
	 * @author 朱科
	 * @since 2018年7月13日
	 * @return
	 */
	void updateUserGuide(Integer status, Integer archiveId, String guideType);

	void insertUserSeniorGuideByRole(Integer cityId, Integer compId, String roleId);
}
