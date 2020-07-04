package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminWeiUserInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunDeptsService extends BaseMapper<AdminFunDepts, Integer> {

	List<AdminWeiUserInfo> getYouConnectorList(String compNo, String deptNo);
	
	boolean isShowYou(Integer compId);
	
	/**
	 * 通过版本获取小程序id
	 * @param archiveId	经纪人档案id
	 * @return appId 小程序id
	 */
	String getAppIdByVersion(Integer archiveId);
}
