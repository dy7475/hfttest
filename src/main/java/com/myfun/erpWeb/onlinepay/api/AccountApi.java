package com.myfun.erpWeb.onlinepay.api;

import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title 线上收款账户API
 * @author lcb
 * @since 2019/8/24
 * @param
 * @return
 */
@Api(tags = "在线收款-新网模块-账户相关")
@RequestMapping(value = "/onlineCollection/xwBankModule/account/")
public interface AccountApi {

    @ApiOperation(value = "检查开户状态，开户前检查")
    @ApiImplicitParam(dataTypeClass = CheckAccountStatusParam.class)
    @ApiResponses(value= {
       @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = CheckAccountStatusVO.class)
    })
    @PostMapping("/checkAccountStatus")
    ResponseJson checkAccountStatus(CheckAccountStatusParam param) throws Exception;

    @ApiOperation(value = "跳转新网申请开户页")
    @ApiImplicitParam(dataTypeClass = ApplyAccountParam.class)
    @ApiResponses(value= {
        @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = ApplyAccountVO.class)
    })
    @PostMapping("/applyAccount")
    ResponseJson applyAccount(ApplyAccountParam param) throws Exception;

    @ApiOperation(value = "发送账户验证专用短信, 这里只针对收款模块")
    @ApiImplicitParam(dataTypeClass = OnlineCollectValidateMsgParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功")
    })

    @PostMapping("/sendOnlineCollectValidateMsg")
    ResponseJson sendOnlineCollectValidateMsg(OnlineCollectValidateMsgParam param) throws Exception;

    @ApiOperation(value = "判断是否需要短信验证, 这里只针对收款模块")
    @ApiResponses(value= {
          @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = ValidateMsgCodeVO.class)
    })
    @PostMapping("/requireValidate")
    ResponseJson requireValidate() throws Exception;

    @ApiOperation(value = "新网账户密码管理，修改和重置")
    @ApiImplicitParam(dataTypeClass = XwAccountPasswordParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = XwAccountPasswordVO.class)
    })
    @PostMapping("/updateXwBankAccountPassword")
    ResponseJson updateXwBankAccountPassword(XwAccountPasswordParam param) throws Exception;

    @ApiOperation(value = "收款账户是否接受通知")
    @ApiImplicitParam(dataTypeClass = UpdateNotifyStatusParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功")
    })
    @PostMapping("/updateNotifyStatus")
    ResponseJson updateNotifyStatus(UpdateNotifyStatusParam param) throws Exception;

    @ApiOperation(value = "获取账户信息，银行卡信息")
    @ApiImplicitParam(dataTypeClass = AccountBankInfoParam.class)
    @ApiResponses(value= {
        @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = AccountBankInfoVO.class)
    })
    @PostMapping("/queryAccountBankInfo")
    ResponseJson queryAccountBankInfo(AccountBankInfoParam param) throws Exception;

    @ApiOperation(value = "解绑卡")
    @ApiImplicitParam(dataTypeClass = UpdateAccountBankInfoParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = UpdateAccountBankInfoVO.class)
    })
    @PostMapping("/updateAccountBankInfo")
    ResponseJson updateAccountBankInfo(UpdateAccountBankInfoParam param) throws Exception;

    @ApiOperation(value = "验证短信")
    @ApiImplicitParam(dataTypeClass = ValidateMessageParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = ValidateMessageVO.class)
    })
    @PostMapping("/validateMessage")
    ResponseJson validateMessage(ValidateMessageParam param) throws Exception;

}
