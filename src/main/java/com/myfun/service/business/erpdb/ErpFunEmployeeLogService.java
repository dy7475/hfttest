package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunEmployeeLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunEmployeeLogService extends BaseMapper<ErpFunEmployeeLog, ErpFunEmployeeLog> {
	
	public void insertLog(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeDept, Integer afterDept, String beforeRole, String afterRole, Integer beforeGr, Integer afterGr);

	public void insertLogAddCreateUser(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeDept, Integer afterDept, String beforeRole, String afterRole, Integer beforeGr, Integer afterGr,String createUserName);
	
	public void insertLogNew(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeOrgId, Integer afterOrgId, String beforeRole, String afterRole);
	
	public void insertLogNewNew(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeOrgId, Integer afterOrgId, String beforeRole, String afterRole, String userName);


	/**
	 * 写入修改职级的日志
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年7月31日 上午11:28:45
	 */
	public void insertLog4RoleLevel(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeRoleLevelId, Integer afterRoleLevelId);
}
