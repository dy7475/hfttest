package com.myfun.service.business.admindb;

import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.repository.admindb.po.AdminOnlinePaymentOrder;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AdminOnlinePaymentOrderService extends BaseMapper<AdminOnlinePaymentOrder, Integer> {

    List<OnlinePaymentOrderVO> selectOrderList(DealRecordListParam param);

    List<Map<String, BigDecimal>> countWeekAmount(DealRecordListParam param);

    CollectAmountFlagVO queryCollectAmountFlag(CollectAmountFlagParam param);

    NeedCollectAmountVO queryNeedCollectAmount(NeedCollectAmountParam param);

    QuickPayVO quickCollect(QuickPayParam param);

    void paySuccessCallDoBusiness(PaySuccessCallParam param);

    SmallProgramInfoParamVO getQuickCollectSmallProgramInfo(SmallProgramInfoParam param);
}
