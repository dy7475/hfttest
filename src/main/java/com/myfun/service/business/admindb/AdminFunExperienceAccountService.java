package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunExperienceAccount;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface AdminFunExperienceAccountService extends BaseMapper<AdminFunExperienceAccount, Integer> {
	/**
	 * 修改最后登录时间
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
	void updateLastLoginTime(String macAddr);
}
