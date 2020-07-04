package com.myfun.erpWeb.managecenter.profit.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpFunRewardPunishmentDto;
import io.swagger.annotations.ApiModel;

/**
 * 奖罚列表返回数据VO
 * create by 程二狗 on 2018/11/13 0013
 */
@ApiModel(description = "奖罚列表")
public class RewardPunishmentDetailListVo extends PageInfo<ErpFunRewardPunishmentDto> {
}
