package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunLoanBank;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunLoanBankService extends BaseMapper<ErpFunLoanBank, ErpFunLoanBank>{


    void addEditLoanBank(Integer cityId, Integer compId, List<ErpFunLoanBank> paramList);
}
