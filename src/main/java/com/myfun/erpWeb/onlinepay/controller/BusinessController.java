package com.myfun.erpWeb.onlinepay.controller;

import com.myfun.erpWeb.onlinepay.api.BusinessApi;
import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.RequestSourceConst;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminOnlinePaymentOrderService;
import com.myfun.service.business.admindb.AdminXwBankAccountService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.Assert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;

import com.myfun.utils.StringUtil;
import net.sourceforge.jtds.jdbc.DateTime;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @title 在线收款业务模块
 * @author lcb
 * @since 2019/8/24
 * @param 
 * @return
 */
@RestController
public class BusinessController extends BaseController implements BusinessApi {

    @Autowired
    AdminXwBankAccountService adminXwBankAccountService;
    @Autowired
    ErpSysParaService erpSysParaService;
    @Autowired
    AdminFunPaidMapper adminFunPaidMapper;
    @Autowired
    AdminOnlinePaymentOrderService adminOnlinePaymentOrderService;
    @Autowired
    AdminFunCompService adminFunCompService;

    @Override
    public ResponseJson createOrder(@Valid @RequestBody PaymentOrderParam param) throws Exception {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setUserId(operator.getUserId());
        param.setCompId(operator.getCompId());
        param.setDeptId(operator.getDeptId());
        param.setDeptName(operator.getDeptName());
        param.setUserName(operator.getUserName());
        param.setArchiveId(operator.getArchiveId());
        param.setCompName(operator.getCompName());

        Assert.isTrueThrow(null == param.getOrderAmount() || param.getOrderAmount().doubleValue() <= 0, "订单金额有误");
        PaymentOrderVO returnVO = adminXwBankAccountService.createOrder(param);
        return ErpResponseJson.ok(returnVO);
    }

    @Override
    public ResponseJson withDraw(@RequestBody WithDrawParam param) throws Exception {
        Operator operator = getOperator();

        Assert.isNullThrow(param.getAccountId(), "账户信息有误");

        param.setUserId(operator.getUserId());
        param.setUserName(operator.getUserName());
        param.setCityId(operator.getCityId());
        param.setArchiveId(operator.getArchiveId());
        param.setDeptId(operator.getDeptId());
        param.setDeptName(operator.getDeptName());
        param.setCompId(operator.getCompId());
        WithDrawVO withDrawVO = adminXwBankAccountService.withDraw(param);
        return ErpResponseJson.ok(withDrawVO);
    }

    @Override
    public ResponseJson dealRecordCount(@Valid @RequestBody DealRecordCountParam param) throws Exception {
        Operator operator = getOperator();
        DealRecordCountVO dealRecordListVO = new DealRecordCountVO();
        
        if(StringUtils.isNotBlank(param.getTimeStart())) {
            param.setTimeStart(param.getTimeStart() +" 00:00:00");
        }

        if(StringUtils.isNotBlank(param.getTimeEnd())) {
            param.setTimeEnd(param.getTimeEnd()+" 23:59:59");
        }
        
        if(StringUtils.isBlank(param.getTimeStart()) && StringUtils.isBlank(param.getTimeEnd())) {
            String timeStart = DateUtil.DateToString(new Date(), "yyyy-MM-dd 00:00:00");
            param.setTimeStart(timeStart);

            String timeEnd = DateUtil.DateToString(new Date(), "yyyy-MM-dd 23:59:59");
            param.setTimeEnd(timeEnd);
        }



        // 查询账户的类型,这里默认是公司的，后面要分个人的 自己修改
        Integer uaId = operator.getCompUaId();

        param.setUaId(uaId);
        // 这里如果有查询列表的 参照mobileWeb的com.myfun.mobileWeb.usercenter.controller.UserCenterController#getXwBankAccountAndPaidList
        List<AdminFunPaid> count = adminFunPaidMapper.getOnlinePayPaidCount(param);
        dealRecordListVO.setDealRecordCount(count.size());
        Double totalAmount = 0d;
        for (AdminFunPaid adminFunPaid : count) {
            totalAmount += adminFunPaid.getAmount();
        }
        dealRecordListVO.setDealRecordCount(count.size());
        dealRecordListVO.setDealRecordAmount(new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP));
        return ErpResponseJson.ok(dealRecordListVO);
    }

    @Override
    public ResponseJson dealRecordList(@RequestBody @Valid DealRecordListParam param) throws Exception {

        DealRecordListVO dealRecordListVO = new DealRecordListVO();
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        Integer timeType = param.getTimeType();
        if(StringUtils.isBlank(param.getTimeStart()) && StringUtils.isBlank(param.getTimeEnd())) {
            String timeStart = DateUtil.DateToString(new Date(), "yyyy-MM-dd 00:00:00");
            param.setTimeStart(timeStart);

            String timeEnd = DateUtil.DateToString(new Date(), "yyyy-MM-dd 23:59:59");
            param.setTimeEnd(timeEnd);
        }

        if(StringUtils.isNotBlank(param.getTimeStart())) {
            param.setTimeStart(param.getTimeStart()+" 00:00:00");
        }

        if(StringUtils.isNotBlank(param.getTimeEnd())) {
            param.setTimeEnd(param.getTimeEnd()+" 23:59:59");
        }

        Assert.isNullThrow(param.getAccountId(), "账户信息有误");

        // 首先查询时间范围内的成功支付的订单列表
        List<OnlinePaymentOrderVO> orderList = adminOnlinePaymentOrderService.selectOrderList(param);
        dealRecordListVO.setTableList(orderList);
        dealRecordListVO.setTotalIncomeAmount(BigDecimal.ZERO);
        try {
            BigDecimal receiveAmount = orderList.stream().map(OnlinePaymentOrderVO::getReceivedAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            dealRecordListVO.setTotalIncomeAmount(receiveAmount);
        }catch (Exception e){}



        List<String> dateList = new LinkedList<>();

        // 查询统计 日周月维度
        switch (timeType) {
            case 0:
                // 最近7天
                String[] dayTtimeArr = DateUtil.getRecentWeek();
                param.setTimeStart(dayTtimeArr[0]);
                param.setTimeEnd(dayTtimeArr[1]);

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, -7);

                for (Integer i=1; i<8;i++) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    dateList.add(DateUtil.DateToString(calendar.getTime(), "yyyy-MM-dd"));
                }

                break;
            case 1:
                // 最近四周
                String endTime = DateUtil.DateToString(new Date(), "yyyy-MM-dd 23:59:59");
                param.setTimeEnd(endTime);
                Calendar initCalendar = getInitCalendar(getThisWeekMonday());
                initCalendar.add(Calendar.WEEK_OF_MONTH, -3);
                String startTime = DateUtil.DateToString(initCalendar.getTime(), "yyyy-MM-dd");
                param.setTimeStart(startTime);

                for (Integer i = 0; i <= 5; i++) {
                    Calendar dateCalendar = getInitCalendar(getThisWeekMonday());
                    dateCalendar.add(Calendar.WEEK_OF_MONTH, -3);
                    dateCalendar.add(Calendar.WEEK_OF_MONTH, i);
                    String dateStartTime = DateUtil.DateToString(dateCalendar.getTime(), "yyyy-MM-dd");
                    Calendar cal = getInitCalendar(Calendar.getInstance());
                    dateCalendar.add(Calendar.DAY_OF_WEEK, 6);
                    String dateEndTime = DateUtil.DateToString(dateCalendar.getTime(), "yyyy-MM-dd");

                    if(dateCalendar.getTimeInMillis() >= cal.getTimeInMillis()) {
                        dateCalendar = cal;
                        dateEndTime = DateUtil.DateToString(dateCalendar.getTime(), "yyyy-MM-dd");
                        dateList.add(dateStartTime+"~"+dateEndTime);
                        break;
                    }
                    dateList.add(dateStartTime+"~"+dateEndTime);
                }

                break;
            case 2:
                // 最近半年
                String[] monthTimeArr = DateUtil.getRecentHalfYear();
                param.setTimeStart(monthTimeArr[0]);
                param.setTimeEnd(monthTimeArr[1]);
                // 最近半年

                Calendar dateCalendar = Calendar.getInstance();
                dateCalendar.add(Calendar.MONTH, -6);

                for (Integer i=1; i<7;i++) {
                    dateCalendar.add(Calendar.MONTH, 1);
                    dateList.add(DateUtil.DateToString(dateCalendar.getTime(), "yyyy-MM"));
                }
                break;
        }

        List<Map<String, BigDecimal>> countWeekAmountList = adminOnlinePaymentOrderService.countWeekAmount(param);
        Map<String, BigDecimal> shareCountResMap = countWeekAmountList.stream().collect(Collectors.toMap(val -> val.get("dateCount") + "", val -> val.get("receivedAmount")));

        List<Map<String, BigDecimal>> resList = new LinkedList<>();
        for (String dateCount : dateList) {
            Map<String, BigDecimal> itemMap = new HashMap<>();

            BigDecimal data = shareCountResMap.get(dateCount);
            if(null == data) {
                data = BigDecimal.ZERO;
            }
            itemMap.put(dateCount, data);
            resList.add(itemMap);
        }
        dealRecordListVO.setGraphicslist(resList);
        return ErpResponseJson.ok(dealRecordListVO);
    }

    private static Calendar getInitCalendar(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static Calendar getThisWeekMonday() {
        Calendar cal = Calendar.getInstance();
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal;
    }

    @Override
    public ResponseJson queryCollectAmountFlag(@RequestBody @Valid CollectAmountFlagParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();

        String[] erpVersionNoArr = String.valueOf(operator.getAttribute("LOGIN_VERSON")).split(" ");
        Integer erpVersionNo = StringUtil.paseInteger(erpVersionNoArr[erpVersionNoArr.length - 1], 0);
        boolean versionMore930 = adminFunCompService.judgeRequestFromNewVersionIn930(operator.isMobileApi(), request.getHeader("versionNo"),
                request.getHeader("appSource"), request.getHeader("deviceType"), erpVersionNo);
        // 安卓9.3.0下的提示升级
        if (!versionMore930 && RequestSourceConst.APP_SOURCE_ANDROID_API.equals(request.getHeader("appSource"))) {
            throw new BusinessException("请升级到最新版本！");
        }
        // 苹果9.3.0下的提示使用安卓或者ERP操作
        if (!versionMore930 && RequestSourceConst.APP_SOURCE_IOS_API.equals(request.getHeader("appSource"))) {
            throw new BusinessException("苹果版程序正在审核中，可在link电脑版上进行操作！");
        }

        param.setCityId(operator.getCityId());
        Integer cooperateId = param.getCooperateId();
        Assert.isNullThrow(cooperateId, "参数错误");

        CollectAmountFlagVO collectAmountFlagVO = adminOnlinePaymentOrderService.queryCollectAmountFlag(param);


        return ErpResponseJson.ok(collectAmountFlagVO);
    }

    @Override
    public ResponseJson queryNeedCollectAmount(@RequestBody NeedCollectAmountParam param) throws Exception {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        Assert.isNullThrow(param.getBusinessType(), "参数错误");
        Assert.isNullThrow(param.getBusinessId(), "参数错误");
        NeedCollectAmountVO needCollectAmountVO = adminOnlinePaymentOrderService.queryNeedCollectAmount(param);
        return ErpResponseJson.ok(needCollectAmountVO);
    }

    @Override
    public ResponseJson getQuickCollectSmallProgramInfo(@RequestBody SmallProgramInfoParam param) throws Exception {
        SmallProgramInfoParamVO smallProgramInfoParamVO = adminOnlinePaymentOrderService.getQuickCollectSmallProgramInfo(param);
        return ErpResponseJson.ok(smallProgramInfoParamVO);
    }
}
