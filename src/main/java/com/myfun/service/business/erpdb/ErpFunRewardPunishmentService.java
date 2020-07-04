package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
public interface ErpFunRewardPunishmentService extends BaseMapper<ErpFunRewardPunishment, ErpFunRewardPunishment>{

	// 新增单条或者批量新增
	Integer addRewardPunishment(Integer cityId, Integer compId, Integer userId, String userName, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);

	Integer editRewardPunishment(Integer cityId, Integer compId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);

	Integer delRewardPunishmentInfo(Integer cityId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);

	Integer auditRewardPunishmentInfo(Integer cityId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);

	Integer importRewardPunishment(Integer cityId, Integer compId, Integer userId, ErpFunRewardPunishmentParam erpFunRewardPunishmentParam);
}
