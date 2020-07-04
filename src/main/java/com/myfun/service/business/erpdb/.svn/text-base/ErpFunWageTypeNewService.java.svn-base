package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.param.CreateOrUpdateWageTypeNewParam;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunWageTypeNewService extends BaseMapper<ErpFunWageTypeNew, ErpFunWageTypeNew> {
	public void insertOrUpdateWageType( CreateOrUpdateWageTypeNewParam param) throws Exception;

	public Map<String, Object> getWageTypeDetail(Integer cityId,
			Integer compId, Integer wagetypeId);

	public List<ErpFunWageTypeNew> getSalaryPlanByComp(Integer cityId, Integer compId);

	public List<ErpFunWageTypeNew> getSalaryPlanByUserId(Integer cityId,
			Integer compId, Integer userId);
}
