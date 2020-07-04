package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunReceiptAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunReceiptAccountService extends BaseMapper<ErpFunReceiptAccount, ErpFunReceiptAccount> {

	public void updateReceiptAccountList(Integer cityId, Integer compId, List<ErpFunReceiptAccount> paramList);
}
