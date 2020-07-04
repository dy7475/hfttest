package com.myfun.service.business.erpdb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetLogListParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpSystemSettingLogsDto;
import com.myfun.repository.erpdb.po.ErpSystemSettingLogs;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.utils.SystemOperateUtil;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;

public interface ErpSystemSettingLogsService extends BaseMapper<ErpSystemSettingLogs, ErpSystemSettingLogs> {

	void insertLog(SystemOperateUtil.SSL_TYPE systemRunModel, String userId, String content, Object beforeObjct,
				   Object afterObject, BaseMapParam param);
	PageInfo<ErpSystemSettingLogsDto> getLogList(GetLogListParam param, Integer compId, Integer cityId);

	/**
	 * @Param systemRunModel 日志类型
	 * **/
	void insertSysLog(SSL_TYPE systemRunModel, Integer refrenceUserId, Integer refrenceDeptId, String content, Object before, Object after, 
			Integer cityId, Integer compId, Integer deptId, Integer userId);
	
	
	/**
	 * @Param systemRunModel 插入日志新，增加用户姓名+公司名字段
	 * **/
	void insertSysLogNew(SSL_TYPE systemRunModel, Integer refrenceUserId, Integer refrenceDeptId, String content, Object before, Object after, 
			Integer cityId, Integer compId, Integer deptId, Integer userId,String userName);
	
	void insertLogNew(SystemOperateUtil.SSL_TYPE systemRunModel, String userId, String content, Object beforeObjct,
			   Object afterObject, BaseMapParam param,String userName);
	
	

}
