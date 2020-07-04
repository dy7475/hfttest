package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunContractTemplaeParam;
import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import com.myfun.repository.erpdb.po.ErpFunContractTemplae;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface ErpFunContractTemplateService extends BaseMapper<ErpFunContractTemplae, ErpFunContractTemplae>{

	void addOrEditContractTemplate(Integer cityId, Integer compId, ErpFunContractTemplae erpFunContractTemplae, List<ErpFunContractIndex> paramList);

	Integer saveContract(Integer cityId, Integer compId, ErpFunContractTemplaeParam erpFunContractTemplaeParam, Integer deptId, Integer userId, String userName) throws Exception;
}
