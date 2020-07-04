package com.myfun.erpWeb.deal.api;

import com.myfun.erpWeb.deal.param.*;
import com.myfun.erpWeb.deal.vo.*;
import com.myfun.erpWeb.managecenter.constract.param.ShareDealParam;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 在线签约接口
 */
@Api(tags = "在线签约控制器", value = "在线签约控制器")
@RequestMapping({"/onlineSign","/openApi/onlineSign"})
public interface OnlineSignApi {
    @ApiOperation(value = "返回是否开通的在线签约")
    @ApiImplicitParam(dataTypeClass = CompParam.class)
    @ApiResponses(value= {
        @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = CompVO.class)
    })
    @PostMapping("/getCompOpenOlineContract")
    ResponseJson getCompOpenOlineContract() throws Exception;

    @ApiOperation(value = "开通在线签约")
    @ApiImplicitParam(dataTypeClass = AccountInfoParam.class)
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = OpenOnlineContractVO.class)})
    @PostMapping("/openOnlineContract")
    ResponseJson openOnlineContract(@RequestBody AccountInfoParam accountInfoParam) throws Exception;
    
    @ApiOperation(value = "刷脸认证")
    @ApiImplicitParam(dataTypeClass = FaceVerifyParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "添加成功", response = FaceVerifyVO.class)
    })
    @PostMapping("/faceVerify")
    ResponseJson faceVerify(@RequestBody FaceVerifyParam faceVerifyParam) throws Exception;
    
    @ApiOperation(value = "刷脸认证结果")
    @ApiImplicitParam(dataTypeClass = FaceVerifyResultParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "添加成功", response = SsqSignVO.class)
    })
    @PostMapping("/faceVerifyResult")
    ResponseJson faceVerifyResult(@RequestBody FaceVerifyResultParam faceVerifyResultParam) throws Exception;
    
    @ApiOperation(value = "签名回调，改变签约状态")
    @ApiImplicitParam(dataTypeClass = NotifySignResultParam.class)
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "添加成功", response = SsqSignVO.class)
    })
    @RequestMapping("/notifySignResult")
    ResponseJson notifySignResult(NotifySignResultParam notifySignResultParam) throws Exception;

    @ApiOperation(value = "掌通合同模板接口")
    @ApiImplicitParam(dataTypeClass = ContractDetailsParam.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "上传成功", response=ContractDetailsVO.class)
    })
    @PostMapping("/getContractDetails")
    ResponseJson getContractDetails( ContractDetailsParam contractDetailsParam) throws Exception;

    @ApiOperation(value = "小程序合同详情接口")
    @ApiImplicitParam()
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = AppletContractDetailsVO.class)
    })
    @PostMapping("/getAppletContractDetails")
    ResponseJson getAppletContractDetails(AppletContractDetailsParam appletContractDetailsParam) throws Exception;

    @ApiOperation(value = "小程序合同流程接口")
    @ApiImplicitParam()
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = AppletWarrantStepAppletWarrantStepVO.class)
    })
    @PostMapping("/getAppletWarrantStepList")
    ResponseJson getAppletWarrantStepList(AppletWarrantStepParam appletWarrantStepParam) throws Exception;

    @ApiOperation(value = "发送邮件")
    @ApiImplicitParam()
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功")
    })
    @PostMapping("/sendEmail")
    ResponseJson sendEmail(SendEmailParam sendEmailParam) throws Exception;


    @ApiOperation(value = "验证电话是否能查看合同")
    @ApiImplicitParam()
    @ApiResponses(value= {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功")
    })
    @PostMapping("/verifyTelphoneNum")
    ResponseJson verifyTelphoneNum(VerifyTelphoneNumParam verifyTelphoneNumParam) throws Exception;

    @ApiOperation("分享合同后保存买方卖方openId和userId")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = ShareDealVo.class)})
    @PostMapping("/shareDeal")
    ResponseJson shareDeal(@RequestBody @Valid ShareDealParam param);

    @ApiOperation("计算签名位置并保存")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/savePdfPosition")
    ResponseJson savePdfPosition(@RequestBody @Valid PdfInfoParam param) throws Exception;
    
    @ApiOperation("验证短信")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/vcodeVerify")
    ResponseJson vcodeVerify(@RequestBody @Valid VcodeVerifyParam param) throws Exception;
    
    @PostMapping("/userPersonalRegTest")
    ResponseJson userPersonalRegTest(String account, String ownerName, String idCard) throws Exception;
}
