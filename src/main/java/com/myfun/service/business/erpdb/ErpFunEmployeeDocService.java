package com.myfun.service.business.erpdb;

import java.util.Map;

import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunEmployeeDocService extends BaseMapper<ErpFunEmployeeDoc, ErpFunEmployeeDoc>{

	Integer editEmployeeDoc(Integer cityId,Integer compId, Integer deptId, Integer userId, ErpFunEmployeeDoc erpFunEmployeeDoc,
						 AdminFunArchive adminFunArchive, ErpFunUsers erpFunUsers, Map<String, Object> paramJsonMap, Integer compType, String createUserName) throws Exception;

	Integer changeUserPhoto(Integer cityId, Integer userId, Integer compId, String photoAddr);
	
	ErpFunEmployeeDoc getEmployeeInfo(Integer cityId, Integer compId, ErpFunUsers erpFunUsers);
	ErpFunEmployeeDoc getEmployeeInfoNewOrg(Integer cityId, Integer compId, ErpFunUsers erpFunUsers);

	void updateOrCreateEmployeeDoc(Integer cityId, ErpFunUsers user);

	void reConfigureUserKPIScheme(Integer cityId, ErpFunUsers funUser, String userPosition);
}
