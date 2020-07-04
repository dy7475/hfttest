package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunGenerationPayment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
public interface ErpFunGenerationPaymentService extends BaseMapper<ErpFunGenerationPayment, ErpFunGenerationPayment>{

	Integer delGenerationPaymentInfo(Integer cityId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	Integer auditGenerationPaymentInfo(Integer cityId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	Integer addEditGenerationPayment(Integer cityId, Integer compId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	Integer addGenerationPayment(Integer cityId, Integer compId, Integer userId, String userName, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	Integer importGenerationPayment(Integer cityId, Integer compId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);
}
