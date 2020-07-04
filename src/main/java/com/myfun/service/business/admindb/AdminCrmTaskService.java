package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminCrmTask;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmTaskService extends BaseMapper<AdminCrmTask, Integer> {

	/**
	 * 个人中心提醒顾问联系用户
	 * @author 朱科
	 * @since 2018年7月20日
	 * @return
	 */
	void remindConsultant(Integer adminCompId, Integer adminDeptId, String selUid, String warmContent);
}
