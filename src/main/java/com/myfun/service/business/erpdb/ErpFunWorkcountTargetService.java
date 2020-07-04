package com.myfun.service.business.erpdb;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetParam;
import com.myfun.repository.erpdb.param.ErpFunWorkCountTargetParam;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTarget;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunWorkcountTargetService extends BaseMapper<ErpFunWorkcountTarget, ErpFunWorkcountTarget>{

	Integer updateWorkCountTargetDetail(Integer cityId, Integer compId, ErpFunWorkCountTargetParam param);

	void appUpdateWorkCountTargetDetail(Integer cityId, Integer compId, AppFunWorkCountTargetParam param);
	
	
	void asyncAssemblyAndInsertDayData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date);
	
	void asyncAssemblyAndInsertWeekData(Integer cityId, Integer compId,Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date);
	
	void asyncAssemblyAndInsertMonthData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date);

    void updateWorkCountTargetForOrg(Integer cityId, Integer compId, AppFunWorkCountTargetParam param);
}
