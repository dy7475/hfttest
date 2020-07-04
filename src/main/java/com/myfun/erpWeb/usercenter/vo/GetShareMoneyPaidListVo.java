package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class GetShareMoneyPaidListVo implements EncryParamIfc {

    private List<AdminFunPaid> list;

    public List<AdminFunPaid> getList() {
        return list;
    }

    public void setList(List<AdminFunPaid> list) {
        this.list = list;
    }
}
