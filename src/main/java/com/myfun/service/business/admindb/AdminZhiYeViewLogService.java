package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminZhiYeViewLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminZhiYeViewLogService extends BaseMapper<AdminZhiYeViewLog, Integer> {
	
	/**
	 * 新增查看记录
	 * @author 张宏利
	 * @since 2017年6月22日
	 * @param archiveId
	 * @param coursesType
	 * @param mediaId
	 * @param subjectId
	 * @return
	 */
	Integer createViewLog(Integer archiveId, String coursesType, String coursesId, String mediaId, String subjectId);
	
}
