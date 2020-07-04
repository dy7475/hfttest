package com.myfun.service.business.admindb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminIpCallLogService extends BaseMapper<AdminIpCallLog, String> {

	public List<AdminIpCallLog> getCallRecordingList(AdminIpCallLog adminIpCallLog);

	public List<AdminIpCallLog> getRecordingByIds(String substring);

	public PageInfo<AdminIpCallLog> getMgrVoiceNoteLog(BaseMapParam param) throws Exception;
}
