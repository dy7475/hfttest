package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminCrmTask;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmTaskMapper extends BaseMapper<AdminCrmTask, Integer> {
	
	/**
	 * 个人中心提醒顾问联系用户
	 * @author 朱科
	 * @since 2018年7月20日
	 * @return
	 */
	List<AdminCrmTask> getRemindConsultantList(@Param("compId")Integer adminCompId, @Param("deptId")Integer adminDeptId, @Param("taskOwner")Integer taskOwner, @Param("taskContent")String taskContent);
}