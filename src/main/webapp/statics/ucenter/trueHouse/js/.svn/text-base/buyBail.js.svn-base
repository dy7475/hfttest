// 页面所需配置
var payConfig = {
	ptType : "",// 支付类型
	configType : "",// 支付类型
	couponNum3 : 0,// 代金券金额
	couponNum6 : 0,// 代金券金额
	couponNum12 : 0,// 代金券金额
	amount : 0,// 账户余额
	
	archiveId : "",// 档案ID
	adminDeptId : "",// admin门店ID
	payUrl : "",// 支付url，生成订单后返回
	superComp : "1",// 是否是总部城市，0=代理商城市，1=非代理商城市
	cityLevel : "0",// 重点城市的标记，1=重点城市
	isInitOk : 1,// 是否初始化完成，小于等于0代表完成，初始值为需要初始化的数量
	// 以下是点网页支付时需要
	needPrice : "100",// 所需价格，每次计算之后赋值
	usedAmount : "0",// 使用了多少账户余额，每次计算之后赋值
	needUserNewPrice : "100",// 需要用户新支付的金额
	ptId : "",// 生成订单后的订单ID
	token : "",// 生成订单后的token
	usableAmount : {},// 账号信息
};

$(document).ready(function(){
	initUrlConfig("usercenter/payment/trueHouse/result?CLIENTKEY="+clientKey);
	
	payConfig.adminDeptId = adminDeptIdTmp;
	payConfig.archiveId = archiveIdTmp;
	payConfig.amount = amount;
    payConfig.isPersonalVersion = isPersonalVersion;
    if (isPersonalVersion == 0) {
        $(".container").css({'width':'100%','height':'100%'});
        $(".con-left").css('width','636px');
        $(".con-right").css('width','229px');
        $(".bottomTipInfo").css({'height':'43px','width':'611px'});
        $(".qr-code-model .inner-qr-box").css('margin','91px 280px');
        $("#vrMaskDiv").css('height','20px');
        $(".pay-type-box .item").css({'height':'45px','margin-right':'14px'});
        $(".pay-type-box .item.checked .gou").css('height','40px');
        $(".pay-box2").css('margin-top','47px');
    }
	$("#payForName").text("真房源");
	$("#payForUseage").html("1、每缴纳100元保证金，认证会员可获" + lightUpCount + "个真房源标签，PLUS会员可获" + lightUpCountForVip + "个真房源标签<br>2、房源被投诉后24小时内下架该房源或申诉，逾期未处理或被平台认定为假房源，平台将扣除100保证金。<br>3、投诉中的房源须等待审核，等待期间无法移交、转抢盘或公盘<br><span style='color:#309fff;cursor: pointer;' onclick='trueHouseRules();'><详细规则></span>");
	$("#payForName").css('background', 'url("'+statics+'ucenter/trueHouse/img/trueHouse.png") no-repeat 35px 30px');
	$("#vrRedWarnDiv div").html("");
	try {
		document.getElementById("custObj").setCloseBtnVisible(0);
	} catch (e) {}
	$("#vrMaskDiv").show();
	$("#vrInfoDiv,#quanGift").hide();
	payConfig.isInitOk--;
	calculatePrice();
});
/**展示真房源规则*/
function trueHouseRules(){
	document.getElementById("custObj").showTrueHouseRules();
}
/**
 * 重新计算并设置显示价格
 */
function calculatePrice() {
	var price = 100;//$('#priceInput').val();
	var priceArr = [price, price];
	$(".total-price,#noAmountNeedPay,#resultNeedPay").text(priceArr[0]);// 所需支付总金额
	if(payConfig.amount > 0) {
		var usedAmount = (payConfig.amount > priceArr[0]) ? priceArr[0] : payConfig.amount;
		$("#amountPayTotal").text(usedAmount);
		if($('#choiseBalance').hasClass('pay-checkbox-checked')) {
			payConfig.usedAmount = usedAmount;
			priceArr[0] = parseFloat((payConfig.needPrice - usedAmount).toFixed(2));
			$(".total-price").text(priceArr[0]);
		}
	} else {
		$("#choiseBalance").hide();
	}
	$("#payInfoDiv .info").text("真房源保证金");
	payConfig.ptId = "";
	payConfig.needPrice = priceArr[1];// 不减去抵扣时的金额
	payConfig.needUserNewPrice = priceArr[0];// 需要用户新支付的金额
	return priceArr;
}
/**
 * 关闭扫码框
 */
$('.qr-box-close').on('click', function() {
	$('.qr-code-model').hide();
});
/**
 * 切换支付方式
 */
$('.pay-type-box .item').on('click', function() {
	$('.pay-type-box .item').removeClass('checked');
	$(this).addClass('checked');
    if (isPersonalVersion == 0){
        $(".pay-type-box .item.checked .gou").css('height','40px');
    }
	var val = $(".pay-type-box .item.checked").attr("val");
	$('.use-web-pay').hide();
	if(val == 1) {
		$('.use-web-pay').show();
	}
});
/**
 * 切换支付方式
 */
$('.wx-zfb-table span').on('click', function() {
	$('.wx-zfb-table span').removeClass('select-pay-method');
	$(this).addClass('select-pay-method');
	var index = $(this).index();
	if (index == 0) {
		$('#aliPayIframe').show();
		$('#weiXinQRCodeImg').hide();
	} else {
		$('#aliPayIframe').hide();
		$('#weiXinQRCodeImg').show();
	}
});
/**
 * 确认支付，创建订单和显示支付按钮
 */
$('#sureCreateOrder').on('click', function() {
	var paidFrom = $(".pay-type-box .item.checked").attr("val");
	createPaymentTask(paidFrom);
});
/**
 * 创建订单和显示支付按钮
 * paidFrom：1=支付宝，2=微信，3=网页支付
 */
function createPaymentTask(paidFrom) {
	if(payConfig.isInitOk > 0) {
		alertMsg("初始化尚未完成，请稍等片刻"); return;
	}
//	var priceInput = $('#priceInput').val();
//	if(priceInput <= 0 || priceInput % 100 != 0) {
//		alertMsg("只能输入金额需为100的倍数"); return;
//	}
	var priceTypeSelect = $('#priceTypeTable .select');
	var price = calculatePrice();
	
	ajaxTemp("createPaymentTask", "POST", "json", {
			CLIENTKEY : clientKey,
			deptId : payConfig.adminDeptId,
			ptType : payConfig.ptType,
			balancePrice : payConfig.usedAmount,
			totalMoney : payConfig.needUserNewPrice,
			source : "0",
			payModel : "1",
		}, function(data){
			if (data.code == 300 || data.code == 500) {
				var errorIndex = data.msg.indexOf("###");
				if(errorIndex > 0) {
					data.msg = data.msg.substring(0, errorIndex);
				}
				alertMsg("生成订单失败：" + data.msg);return;
			} else if (data.code != 200) {
				alertMsg("生成订单失败：系统错误");return;
			}
			payConfig.ptId = data.data.ptId;
			payConfig.token = data.data.token;
			if (payConfig.ptId == undefined) {
				alertMsg("生成订单失败：系统错误");
				return;
			}
			if(price[0] > 0) {
				if(paidFrom == 1) {
					aliQrIframeChangeCount = 0;
					$(".ali-qr-iframe").attr("src", payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
							+ "ptId=" + payConfig.ptId
							+ "&token=" + payConfig.token
							+ "&qrPayMode=4&qrcodeWidth=150"
							+ "&returnUrl=" + payConfig.returnUrl
					);
					$('#aliPayQrCodeModel').show();
				} else if(paidFrom == 2) {
					$(".weixin-qr-img").html('<img src='+payConfig.adminWebUrl+'pay/getWeiXinPayQrCode?'
							+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token + '>');
					$('#weixinPayQrCodeModel').show();
				} else {
					openWindow(payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
							+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token
					);
				}
			} else {
				amountPayOrder();// 余额支付订单
			}
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}
/**
 * 支付宝支付页面跳转后的操作
 */
var aliQrIframeChangeCount = 0;
function aliQrIframeOnChange(obj) {
	aliQrIframeChangeCount++;
	if(aliQrIframeChangeCount == 2) {
		showPaySuccess();
	}
}
function showPaySuccess() {
	ajaxTemp("../common/getUserAmount", "POST", "json", {
		CLIENTKEY : clientKey
		}, function(json){
			$(".con-left").hide();
			$(".con-left.pay-result").show();
			$(".ali-qr-iframe").attr("src", "");
			$('#aliPayQrCodeModel').hide();
			if (json.errCode != 200) {
				alertMsg("获取账户余额失败");return;
			}
			$('#haofangBeanNow').text(json.data.trueHouseDeposit);
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}

/** 
 * 网页支付
 */
$('.use-web-pay').on('click',function(){
	createPaymentTask(3);
});
/** 
 * 网页支付
 */
$('#aliWebPay').on('click',function(){
	if(payConfig.ptId != undefined && payConfig.ptId != "") {
		openWindow(payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
				+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token
		);
	} else {
		alertMsg("获取订单信息失败，请重新生成订单。");
	}
});
/**
 * 余额支付订单
 */
function amountPayOrder(){
	ajaxTemp("../common/autoOrderPayment", "POST", "json", {
		CLIENTKEY : clientKey, ptId : payConfig.ptId
		}, function(data){
			if (data.code == 300 || data.code == 500) {
				alertMsg("余额支付订单失败：" + data.msg);return;
			} else if (data.code != 200) {
				alertMsg("余额支付订单失败：系统错误");return;
			}
			showPaySuccess();
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}
/**
 * 点击支付
 */
$('#payModel .change-addr').on('click',function(){
	$('#payModel').show();
});
/**
 * 点击支付窗口关闭
 */
$('#payModel .model-delete').on('click',function(){
	$('#payModel').hide();
	$('#aliPayIframe').attr("src", "");
	$('#weiXinQRCodeImg').empty();
});
/**
 * 关闭整个支付窗口
 */
$('#closePayPage').on('click',function(){
	// 直接关闭整个窗口
	try {
		document.getElementById("custObj").closeWidget();
	} catch (e) {}
});
/**
 * 确认使用余额抵扣
 */
$('#amountPayDiv .sure-pay').on('click', function(){
	// 不用提示了
	amountPayOrder();
});
/**
 * 支付宝支付
 */
$('#aliPay').on('click',function(){
	$('#payModel .head .checked').removeClass("checked");
	$('#aliPay').addClass("checked");
	if(payConfig.needUserNewPrice <= 0) {
		$('#weiXinQRCodeDiv,#aliPayDiv,#aliWebPay,#iframeMask').hide();
		$('#amountPayDiv').show();
	} else {
		$('#weiXinQRCodeDiv,#amountPayDiv').hide();
		$('#aliPayDiv,#aliWebPay,#iframeMask').show();
	}
});
/**
 * 微信支付
 */
$('#weixinPay').on('click',function(){
	$('#payModel .head .checked').removeClass("checked");
	$('#weixinPay').addClass("checked");
	if(payConfig.needUserNewPrice <= 0) {
		$('#weiXinQRCodeDiv,#aliPayDiv,#aliWebPay,#iframeMask').hide();
		$('#amountPayDiv').show();
	} else {
		$('#aliPayDiv,#aliWebPay,#amountPayDiv').hide();
		$('#weiXinQRCodeDiv,#iframeMask').show();
	}
});
/**
 * 选中使用余额抵扣
 */
$('#choiseBalance').on('click', function() {
	if ($(this).hasClass('pay-checkbox-checked')) {
		$(this).removeClass('pay-checkbox-checked');
	} else {
		$(this).addClass('pay-checkbox-checked');
	}
	calculatePrice();
});
$('.plus_info_sj').on('click',function(){
	window.location.href=erpWebUrl+"usercenter/payment/vipPay/index?CLIENTKEY="+clientKey
});
