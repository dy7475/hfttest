package com.myfun.erpWeb.managecenter.financialStatements.vo;/**
 * @author 熊财
 * @since 16:52
 * Modified XIONG CAI 2020/1/3
 */

import com.myfun.repository.erpdb.po.ErpFunDeal;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/1/3 16:52
 * @Version 1.0
 **/
public class ErpFunDealFinanceVo extends ErpFunDeal {

    private String organizationPath;

    public String getOrganizationPath() {
        return organizationPath;
    }

    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
    }
}
