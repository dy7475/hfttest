package com.myfun.erpWeb.onlinepay.api;

import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @title 线上收款账户API
 * @author lcb
 * @since 2019/8/24
 * @param
 * @return
 */
@Api(tags = "在线收款-新网模块-业务相关")
@RequestMapping(value = "/onlineCollection/xwBankModule/business/")
public interface BusinessApi {

    @ApiOperation(value = "支付")
    @ApiImplicitParam(dataTypeClass = PaymentOrderParam.class)
    @ApiResponses(value= {
       @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = PaymentOrderVO.class)
    })
    @PostMapping("/createOrder")
    ResponseJson createOrder(PaymentOrderParam param) throws Exception;

    @ApiOperation(value = "提现")
    @ApiImplicitParam(dataTypeClass = WithDrawParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = WithDrawVO.class)
    })
    @PostMapping("/withDraw")
    ResponseJson withDraw(WithDrawParam param) throws Exception;

    @ApiOperation(value = "收单条数")
    @ApiImplicitParam(dataTypeClass = DealRecordCountParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = DealRecordCountVO.class)
    })
    @PostMapping("/dealRecordCount")
    ResponseJson dealRecordCount(DealRecordCountParam param) throws Exception;

    @ApiOperation(value = "收单列表")
    @ApiImplicitParam(dataTypeClass = DealRecordListParam.class)
    @ApiResponses(value= {
        @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = DealRecordListVO.class)
    })
    @PostMapping("/dealRecordList")
    ResponseJson dealRecordList(DealRecordListParam param) throws Exception;

    @ApiOperation(value = "检查合作是否收齐")
    @ApiImplicitParam(dataTypeClass = CollectAmountFlagParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = CollectAmountFlagVO.class)
    })
    @PostMapping("/queryCollectAmountFlag")
    ResponseJson queryCollectAmountFlag(CollectAmountFlagParam param, HttpServletRequest request) throws Exception;


    @ApiOperation(value = "查询可收最大金额")
    @ApiImplicitParam(dataTypeClass = NeedCollectAmountParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = NeedCollectAmountVO.class)
    })
    @PostMapping("/queryNeedCollectAmount")
    ResponseJson queryNeedCollectAmount(NeedCollectAmountParam param) throws Exception;

    @ApiOperation(value = "获取快捷支付分享小程序信息")
    @ApiImplicitParam(dataTypeClass = SmallProgramInfoParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = SmallProgramInfoParamVO.class)
    })
    @PostMapping("/getQuickCollectSmallProgramInfo")
    ResponseJson getQuickCollectSmallProgramInfo(SmallProgramInfoParam param) throws Exception;

}
