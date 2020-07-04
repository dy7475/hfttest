package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunProcessRecord;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunProcessRecordService extends BaseMapper<ErpFunProcessRecord, ErpFunProcessRecord> {
	void insert4UpdateStep(GeneralParam generalParam, Integer dealId, String afterStepName, ErpProcessRuntimeStep runtimeStep,
						   String updateClassic, String trackContent, ErpProcessRuntimeStep oldRuntimeStep);
}
