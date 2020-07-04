package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunDealPaytypeService extends BaseMapper<ErpFunDealPaytype, ErpFunDealPaytype>{


	void createCompTempleteDealPayTypeList(Integer cityId, Integer compId);

    void updateFunDealPaytype(Integer cityId, Integer compId, List<ErpFunDealPaytype> paramList);
}
