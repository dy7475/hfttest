package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;

public interface ErpEarbestDepositCommService {


    void writeCaseStatusAndTrackForEarbestAdd(Integer cityId, ErpFunEarbestMoney erpFunEarbestMoney);

    void writeCaseStatusAndTrackForDepositAdd(Integer cityId, ErpFunDeposit obj,boolean fromEarbest);


    void cancelHouseEarbest(Integer cityId, ErpFunEarbestMoney record);

    void cancelHouseDeposit(Integer cityId, ErpFunDeposit record);


    void judgeAndResetHouseEarbestStatus(Integer cityId, ErpFunEarbestMoney record);

    void judgeAndResetHouseDepositStatus(Integer cityId, ErpFunDeposit record);

    void makeEarbestBargainSuccess(Integer cityId, ErpFunEarbestMoney record);

    /**
     * 定金转成交
     * @param cityId
     * @param record
     */
    void makeDepositBargainSuccess(Integer cityId, ErpFunDeposit record);
}
