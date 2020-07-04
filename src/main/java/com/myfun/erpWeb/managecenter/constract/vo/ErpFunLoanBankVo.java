package com.myfun.erpWeb.managecenter.constract.vo;

import com.myfun.repository.erpdb.po.ErpFunLoanBank;

import java.util.List;

/**
 * @author czq
 * @since 2019/3/12
 */
public class ErpFunLoanBankVo {
    private List<ErpFunLoanBank> banks;

    public List<ErpFunLoanBank> getBanks() {
        return banks;
    }

    public void setBanks(List<ErpFunLoanBank> banks) {
        this.banks = banks;
    }
}