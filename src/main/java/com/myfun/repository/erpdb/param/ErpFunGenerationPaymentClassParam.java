package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClass;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.repository.param.EncryParamIfc;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
public class ErpFunGenerationPaymentClassParam extends ErpFunGenerationPaymentClass implements EncryParamIfc {

	private String generationPaymentClassList;

	public String getGenerationPaymentClassList() {
		return generationPaymentClassList;
	}

	public void setGenerationPaymentClassList(String generationPaymentClassList) {
		this.generationPaymentClassList = generationPaymentClassList;
	}
}
