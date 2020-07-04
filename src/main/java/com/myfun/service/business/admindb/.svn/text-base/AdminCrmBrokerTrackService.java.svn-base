package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.param.ErpFunUsersParam;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmBrokerTrackService extends BaseMapper<AdminCrmBrokerTrack, Integer>{

	List<AdminCrmBrokerTrack> selectByArchiveId(int parseInt);

	/**
	 * 写跟进，将公共参数提出来
	 * @param archive
	 * @param adminCrmUser
	 * @param content
	 * @param desc
	 */
	void addTrack(AdminFunArchive archive, AdminCrmUser adminCrmUser, String content, String desc);

	/**
	 * 创建员工时写的跟进
	 * @author 张宏利
	 * @since 2017年5月10日
	 * @param archiveId
	 * @param trackCotent
	 */
	void createRegisterTrack(Integer archiveId, String trackCotent);

	void createRegisterTrack(Integer archiveId, String trackContent, String desc);

	void createWriwriteOffUserTrack(Integer archiveId, String trackContent, DeleteUsersParam param);
}
