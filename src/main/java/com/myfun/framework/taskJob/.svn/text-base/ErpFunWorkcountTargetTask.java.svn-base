package com.myfun.framework.taskJob;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetParam;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.service.business.erpdb.ErpFunWorkcountTargetService;

@Component
public class ErpFunWorkcountTargetTask {

	@Autowired
	private ErpFunWorkcountTargetService erpFunWorkcountTargetService;
	
	@Async
	public void asyncAssemblyAndInsertDayData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		erpFunWorkcountTargetService.asyncAssemblyAndInsertDayData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
	}
	
	@Async
	public void asyncAssemblyAndInsertWeekData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		erpFunWorkcountTargetService.asyncAssemblyAndInsertWeekData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
	}
	
	@Async
	public void asyncAssemblyAndInsertMonthData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
			List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		erpFunWorkcountTargetService.asyncAssemblyAndInsertMonthData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
	}
}
