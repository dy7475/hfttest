package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class ErpFunContractIndexParam extends AbstractEncryParam implements DaoBaseParam{


    private String indexList;

    public String getIndexList() {
        return indexList;
    }

    public void setIndexList(String indexList) {
        this.indexList = indexList;
    }
}
