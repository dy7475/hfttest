package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunDeptFee;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import java.math.BigDecimal;

public class ErpFunDeptFeeParam extends ErpFunDeptFee implements DaoBaseParam{

    private Integer grId;

    //票据图片地址
    private String billPicUrl;

    public String getBillPicUrl() {
        return billPicUrl;
    }

    public void setBillPicUrl(String billPicUrl) {
        this.billPicUrl = billPicUrl;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }
}
