package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.po.ErpFunProfitTarget;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class MgrProfiTargetVo implements Serializable {
    private final List<ErpFunProfitTarget> resultList = new ArrayList<>();

    public List<ErpFunProfitTarget> getResultList() {
        return resultList;
    }
}
