package com.myfun.erpWeb.managecenter.profit.param;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.po.ErpFunWageLog;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * create by 程二狗 on 2018/10/29 0029
 */
@ApiModel
public class WageLogListVO<T> implements EncryParamIfc {

    List<ErpFunWageLog> list;

    public List<ErpFunWageLog> getList() {
        return list;
    }

    public void setList(List<ErpFunWageLog> list) {
        this.list = list;
    }
}
