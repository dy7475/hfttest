package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunFinancPaymentService extends BaseMapper<ErpFunFinancPayment, ErpFunFinancPayment>{


	void createCompTempleteFinancPaymentList(Integer cityId, Integer compId);

    void updateFinancPaymentList(Integer cityId, Integer compId, List<ErpFunFinancPayment> paramList);

    Integer deletePaymentById(Integer cityId, Integer paymentId);
}
