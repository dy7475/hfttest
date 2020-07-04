package com.myfun.erpWeb.openApi.onlinePay;


import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminOnlinePaymentOrderService;
import com.myfun.service.business.admindb.AdminXwBankAccountService;
import com.myfun.utils.Assert;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/openApi/onlineCollect")
public class OnlineCollectController {

	@Autowired
	AdminXwBankAccountService adminXwBankAccountService;
	@Autowired
	AdminOnlinePaymentOrderService adminOnlinePaymentOrderService;

	/**
	 * @tag 新网银行发送短信
	 * @author lcb
	 * @data 2019/9/4
	 */
	@ApiOperation(value = "新网银行发送短信")
	@ApiImplicitParam(dataTypeClass = PretieCardParam.class)
	@ApiResponses(value= {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = PretieCardVO.class)
	})
	@PostMapping("/pretieCard")
	@ResponseBody
	public ErpResponseJson pretieCard(@RequestBody PretieCardParam param) throws Exception {
		Assert.isNullThrow(param.getAccountId(), "参数有误");
		Assert.isNullThrow(param.getPhone(), "参数有误");
		Assert.isNullThrow(param.getTxnNo(), "参数有误");
		Assert.isNullThrow(param.getType(), "参数有误");
		PretieCardVO returnVO = adminXwBankAccountService.pretieCard(param);
		return ErpResponseJson.ok(returnVO);
	}

	/**
	 * @tag 新网银行获取预订单号和订单信息
	 * @author lcb
	 * @data 2019/9/4
	 */
	@ApiOperation(value = "新网银行获取预订单号和订单信息")
	@ApiImplicitParam(dataTypeClass = OrderInfoParam.class)
	@ApiResponses(value= {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = PreCollectOrderInfoVO.class)
	})
	@PostMapping("/queryOrderInfo")
	@ResponseBody
	public ResponseJson queryOrderInfo(@RequestBody OrderInfoParam param) throws Exception {
		Assert.isNullThrow(param.getCityId(), "cityId 参数有误");
		Assert.isNullThrow(param.getOrderNo(), "orderNo 参数有误");
		PreCollectOrderInfoVO returnVO = adminXwBankAccountService.queryPreCollectOrderInfo(param);
		return ErpResponseJson.ok(returnVO);
	}

	/**
	 * @tag 银行卡类型查询
	 * @author lcb
	 * @data 2019/9/4
	 */
	@ApiOperation(value = "银行卡类型查询")
	@ApiImplicitParam(dataTypeClass = BankTypeInfoParam.class)
	@ApiResponses(value= {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = BankTypeInfoVO.class)
	})
	@PostMapping("/cardBinQuery")
	@ResponseBody
	public ErpResponseJson cardBinQuery(@RequestBody BankTypeInfoParam param) throws Exception {
		BankTypeInfoVO returnVO = adminXwBankAccountService.cardBinQuery(param);
		return ErpResponseJson.ok(returnVO);
	}

	/**
	 * @tag 银行卡类型查询
	 * @author lcb
	 * @data 2019/9/4
	 */
	@ApiOperation(value = "快捷支付")
	@ApiImplicitParam(dataTypeClass = CheckAccountStatusParam.class)
	@ApiResponses(value= {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = QuickPayVO.class)
	})
	@PostMapping("/quickCollect")
	public ErpResponseJson quickCollect(@RequestBody QuickPayParam param) throws Exception {
		QuickPayVO returnVO = adminOnlinePaymentOrderService.quickCollect(param);
		return ErpResponseJson.ok(returnVO);
	}

	/**
	 * @tag 支付成功后新增财务款项
	 * @author lcb
	 * @data 2019/9/4
	 */
	@ApiOperation(value = "快捷支付")
	@ApiImplicitParam(dataTypeClass = PaySuccessCallParam.class)
	@ApiResponses(value= {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功")
	})
	@PostMapping("/paySuccessCallDoBusiness")
	public ErpResponseJson paySuccessCallDoBusiness(@RequestBody PaySuccessCallParam param) throws Exception {

		adminOnlinePaymentOrderService.paySuccessCallDoBusiness(param);
		return ErpResponseJson.ok();
	}


}
