package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface ErpFunContractIndexService extends BaseMapper<ErpFunContractIndex, ErpFunContractIndex>{

	String addOrEditTemplate(Integer cityId, Integer compId, List<ErpFunContractIndex> paramList);
}
