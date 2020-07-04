package com.myfun.service.business.admindb;

import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.repository.admindb.po.AdminXwBankAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminXwBankAccountService extends BaseMapper<AdminXwBankAccount, Integer> {

	AdminXwBankAccount checkXwBankAccountStatus(CheckAccountStatusParam param);

    PaymentOrderVO createOrder(PaymentOrderParam param);

    void updateNotifyStatus(UpdateNotifyStatusParam param);

    XwAccountPasswordVO updateXwBankAccountPassword(XwAccountPasswordParam param);

    AccountInfoVO checkAccountBankInfo(AccountBankInfoParam param) throws Exception;

    WithDrawVO withDraw(WithDrawParam param);

    UpdateAccountBankInfoVO updateAccountBankInfo(UpdateAccountBankInfoParam param);

    PreCollectOrderInfoVO queryPreCollectOrderInfo(OrderInfoParam param);

    PretieCardVO pretieCard(PretieCardParam param);

    BankTypeInfoVO cardBinQuery(BankTypeInfoParam param);

    ApplyAccountVO applyAccount(ApplyAccountParam param);

    ValidateMessageVO validateMessage(ValidateMessageParam param);
}
