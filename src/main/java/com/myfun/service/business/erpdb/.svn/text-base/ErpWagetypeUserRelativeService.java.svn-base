package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.CreateOrUpdateUserSalaryPlanParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelative;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpWagetypeUserRelativeService extends BaseMapper<ErpWagetypeUserRelative, ErpWagetypeUserRelative>{

	List<Map<String, Object>> getSalaryPlanByUserId(Integer cityId,
			Integer compId, Integer userId);
	void insertOrUpdateUserSalaryPlan(Integer cityId,
			Integer compId, CreateOrUpdateUserSalaryPlanParam param, ErpFunUsers erpFunUsers);
	
	List<Map<String, Object>> getOneSalaryPlanUserList(Integer cityId,
			Integer compId, BaseMapParam param);
	
	void saveOneSalaryPlanRelativeUser(Integer cityId, Integer compId,
			Integer wageTypeId, String royaltyRange, String salaryPlanUserJson,
			String delUsers) throws Exception;
	
	void createSalaryTypeRelative(Integer salaryTypeId, ErpFunUsers erpFunUsers);

}
