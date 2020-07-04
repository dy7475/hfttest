package com.myfun.service.business.admindb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.param.EditOrCreateFnanceRecordParam;
import com.myfun.repository.admindb.po.AdminJrFinanceInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminJrFinanceInfoService extends BaseMapper<AdminJrFinanceInfo, Integer>{

	List<String> insertOrEditFinanceRecord(EditOrCreateFnanceRecordParam param, Map<String, Object> pMap);

}
