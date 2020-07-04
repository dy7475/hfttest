package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentClassParam;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunGenerationPayment;
import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClass;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
public interface ErpFunGenerationPaymentClassService extends BaseMapper<ErpFunGenerationPaymentClass, ErpFunGenerationPaymentClass>{

	void addEditGenerationPaymentClass(Integer cityId, Integer compId, ErpFunGenerationPaymentClassParam erpFunRewardPunishmentClassParam);

	Integer delGenerationPaymentClass(Integer cityId, Integer compId, ErpFunGenerationPaymentClassParam erpFunGenerationPaymentClassParam);
}
