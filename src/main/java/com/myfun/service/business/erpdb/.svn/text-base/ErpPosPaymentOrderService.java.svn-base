package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpPosPaymentOrder;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpPosPaymentOrderService extends BaseMapper<ErpPosPaymentOrder, ErpPosPaymentOrder>{


    void asynchronousNotify(String orderNo, Integer cityId, Integer payStatus, Integer financeType, Integer compId,
                            Integer deptId, String paymentTime, String financeIds, String posMachineId, String financeMoney);

    void delPosOrder(Integer cityId, Integer orderId, Integer financeId);
}
