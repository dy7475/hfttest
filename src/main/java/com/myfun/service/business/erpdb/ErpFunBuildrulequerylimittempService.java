package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittemp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBuildrulequerylimittempService extends BaseMapper<ErpFunBuildrulequerylimittemp,ErpFunBuildrulequerylimittemp>{
	public void insertList(String shardDbName,List<ErpFunBuildrulequerylimittemp> listTempList);
}
