package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpAccountService extends BaseMapper<ErpAccount, ErpAccount>{
	
	public List<ErpAccount> getAccountList(BaseMapParam param);

	public void insertAccount(AccountParam param);

	public void updateAccount(AccountParam param);
	
	public ErpAccount getAccountInfo(BaseMapParam param);
	
	public void deleteAccount(Integer cityId, Integer actId);
	
	public void reviewAccount(BaseMapParam param);

}
