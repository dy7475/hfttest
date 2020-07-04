package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.repository.param.EncryParamIfc;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
public class ErpFunRewardPunishmentClassParam extends ErpFunRewardPunishmentClass implements EncryParamIfc {

	private String rewardPunishmentClassList;

	public String getRewardPunishmentClassList() {
		return rewardPunishmentClassList;
	}

	public void setRewardPunishmentClassList(String rewardPunishmentClassList) {
		this.rewardPunishmentClassList = rewardPunishmentClassList;
	}
}
