package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.ErpFunBuildRuleParam;
import com.myfun.repository.erpdb.po.ErpFunBuildRule;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunBuildRuleService extends BaseMapper<ErpFunBuildRule,ErpFunBuildRule>{
	
	void deleteAllBuildData(Integer cityId,Map<String, Object> pMap);

	void insertOrUpdateBuildRule(GeneralParam generalParam, ErpFunBuildRuleParam erpFunBuildRuleParam);
	
	void deleteBuildRuleBat(Integer cityId, Integer compId, String[] entityIds);
	List<Map<String,Integer>> importBuildRules(String buildListJson, Integer cityId, Integer compId,String userName,String deptName,Integer deptId, Integer userId);

	void insertFloorUnitMgr(Integer cityId,Integer deptId, Integer compId,Integer userId,String deptName,String userName,BaseMapParam param) throws Exception;

	ErpFunBuildRule getMgrSingleFloorData(Integer cityId,Integer compId,Integer userId,String userName,Boolean isGener,Integer entityId);
	void updateFunBuildRule(String[] ids,ErpFunBuildRule erpFunBuildRule,Integer cityId,Integer compId,Integer userId,String userName);
}
