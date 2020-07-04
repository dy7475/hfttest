package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminAppLoginDto;
import com.myfun.repository.admindb.param.AdminAppLoginParam;
import com.myfun.repository.admindb.po.AdminAppLogin;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AdminAppLoginMapper extends BaseMapper<AdminAppLogin, Integer> {

	List<AdminAppLoginDto> getAdminAppLogin(AdminAppLoginParam adminAppLoginParam);

	AdminAppLogin getAppLastLoginTimeDiff(Integer archiveId);
	
	/**
	 * 通过archiveId查询
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	AdminAppLogin getAppLoginByArchiveId(@Param("archiveId")Integer archiveId);
}