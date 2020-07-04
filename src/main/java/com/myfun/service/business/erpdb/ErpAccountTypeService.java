package com.myfun.service.business.erpdb;



import java.util.List;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpAccountTypeDto;
import com.myfun.repository.erpdb.param.AccountTypeParam;
import com.myfun.repository.erpdb.po.ErpAccountType;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpAccountTypeService extends BaseMapper<ErpAccountType, ErpAccountType>{
	public List<ErpAccountTypeDto> getAccountTypeList(BaseMapParam param);

	public void insertAccountType(AccountTypeParam accountTypeParam);

	public void updateAccountType(AccountTypeParam accountTypeParam);

	public void deleteAccountType(BaseMapParam accountTypeParam);

}
