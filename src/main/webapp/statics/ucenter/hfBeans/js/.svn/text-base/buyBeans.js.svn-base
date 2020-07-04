// 页面所需配置
var payConfig = {
	ptType : "",// 支付类型
	configType : "",// 支付类型
	couponNum3 : 0,// 代金券金额
	couponNum6 : 0,// 代金券金额
	couponNum12 : 0,// 代金券金额
	cashMoney : 0,// 账户余额
	shareMoney : 0,// 分享金额
	isMarketSendVip : 0,// 新营销版，且不是会员，则可以买1800好房币送会员
	
	archiveId : "",// 档案ID
	adminDeptId : "",// admin门店ID
	payUrl : "",// 支付url，生成订单后返回
	superComp : "1",// 是否是总部城市，0=代理商城市，1=非代理商城市
	cityLevel : "0",// 重点城市的标记，1=重点城市
	isInitOk : 1,// 是否初始化完成，小于等于0代表完成，初始值为需要初始化的数量
	// 以下是点网页支付时需要
	needPrice : "0",// 所需价格，每次计算之后赋值
	usedAmount : "0",// 使用了多少账户余额，每次计算之后赋值
	shareMoney : "0",// 使用了多少推广佣金，每次计算之后赋值
	needUserNewPrice : "0",// 需要用户新支付的金额
	ptId : "",// 生成订单后的订单ID
	token : "",// 生成订单后的token
	usableAmount : {},// 账号信息
};

$(document).ready(function(){
	initUrlConfig("usercenter/payment/hfBeans/result?CLIENTKEY="+clientKey);
	
	payConfig.ptType = ptType;
	payConfig.adminDeptId = adminDeptIdTmp;
	payConfig.archiveId = archiveIdTmp;
	payConfig.cashMoney = cashMoney;
	payConfig.shareMoney = shareMoney;
	payConfig.isMarketSendVip = isMarketSendVip;
    payConfig.isPersonalVersion = isPersonalVersion;
    if (isPersonalVersion == 0){
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
	$("#payForName").text("好房豆");
	$("#payForUseage").html("* 可以用来参与房源推广、小区专家、新盘顾问竞价等");
	$("#payForName").css('background', 'url("'+statics+'ucenter/hfBeans/img/hf-bean.png") no-repeat 40px 35px');
	$("#vrRedWarnDiv div").html("");
	try {
		document.getElementById("custObj").setCloseBtnVisible(0);
	} catch (e) {}
	$("#vrMaskDiv").show();
	$("#vrInfoDiv,#quanGift").hide();
	payConfig.isInitOk--;
	if(payConfig.cashMoney > 0) {
		$("#amountPay").show();
	}
	if(payConfig.shareMoney > 0) {
		$("#sharePay").show();
	}
	var html = "";
	var isSendVipFlag = (payConfig.isMarketSendVip == 1);
	for (var i = 0; i < buyConfigJson.length; i++) {
		var temp = buyConfigJson[i];
		var selectIndex = 0;
		var isSendVip = isSendVipFlag && (temp.price == 1200 || temp.price == 1800);
		var liAttrs = (i == 0) ? 'class="select"' : '';
		// 直接进入付费页面
		if(showBuySend == 1 && isSendVipFlag) {
			liAttrs = isSendVip ? 'class="select"' : '';
		}
		liAttrs += ' price="'+temp.price+'"';
		html += '<li ' + liAttrs + '><div class="vip-price">';
		html += '<div class="buy-price">'
			+'<span class="price">'+temp.price+'</span><span>元</span>';
		html += '</div>';
		html += '<div class="buy-count">'+temp.price+'好房豆</div>';
		html += '</div>';
		html += '<div class="thing-gou"></div>';
		if(isSendVip) {
			html += '<div class="send-info">送一年会员</div>';
			$("#payInfoBox .pay-text").text('预存'+temp.price+'元好房豆，全店享1年会员特权');
		} else if(temp.giftBean > 0) {
			html += '<div class="send-info">送'+temp.giftBean+'好房豆</div>';
		}
		html += '</li>';
	}
	$("#priceTypeUl").empty().append(html);
	calculatePrice();
	// 直接进入付费页面
	if(showBuySend == 1) {
		$("#priceTypeUl").hide();
		$("#payInfoBox").show();
	}
});
/**
 * 重新计算并设置显示价格
 */
function calculatePrice() {
	var priceTypeSelect = $('#priceTypeUl .select');
	var price = parseInt(priceTypeSelect.attr('price'));
	var giftBean = parseInt(priceTypeSelect.attr('giftBean'));
    if (!price) {
        price = 0;
    }
    if (!giftBean) {
        giftBean = 0;
    }
    var priceArr = [price, price];
	payConfig.needPriceCutDkq = priceArr[0];// 减去抵扣券的金额（必须放这一行）
	
	$("#noAmountNeedPay,#resultNeedPay").text(priceArr[0]);// 所需支付总金额
	if(bzyh == "1" && payConfig.ptType == 12){
		$(".total-price").text(price/2);
	}else{
		$(".total-price").text(price);
	}
	$(".total-price-test").text(priceArr[0]);
	var isSendVipFlag = (payConfig.isMarketSendVip == 1);
	if(isSendVipFlag && (price == 1200 || price == 1800)) {
		$("#payInfoDiv .info").text("预存"+price+"好房豆，全店享1年会员特权");
	} else {
		$("#payInfoDiv .info").text("好房豆");
	}
	payConfig.ptId = "";
	payConfig.needPrice = priceArr[1];// 不减去抵扣时的金额
	payConfig.needUserNewPrice = priceArr[0];// 需要用户新支付的金额
	
	// 推广现金和现金余额是否展示
	$("#payTypeDiv .sharepay").hide();
	$("#payTypeDiv .amountpay").hide();
	if(payConfig.shareMoney >= priceArr[1]) {
		$("#payTypeDiv .sharepay").show();
	}
	if(payConfig.cashMoney >= priceArr[1]) {
		$("#payTypeDiv .amountpay").show();
	}
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
	payConfig.usedShareMoney = 0;
	payConfig.usedAmount = 0;
	if(val == 1) {
		$('#sureCreateOrder').text('立即支付');
		payConfig.usedShareMoney = payConfig.needPrice;
	} else if(val == 2) {
		$('#sureCreateOrder').text('立即支付');
		payConfig.usedAmount = payConfig.needPrice;
	} else if(val == 3) {
		$('#sureCreateOrder').text('扫码支付');
		$('.use-web-pay').show();
	} else {
		$('#sureCreateOrder').text('扫码支付');
	}
});
/**
 * 价格类型切换
 */
$('#priceTypeUl').on('click', 'li', function() {
	$(this).siblings().removeClass('select');
	$(this).addClass('select');
	calculatePrice();
});
/**
 * 确认支付，创建订单和显示支付按钮
 */
$('#sureCreateOrder').on('click', function() {
	//showPayDiv(3);
	var paidFrom = $(".pay-type-box .item.checked").attr("val");
	createPaymentTask(paidFrom);
});
/**
 * 创建订单和显示支付按钮
 * paidFrom：1=推广佣金，2=现金余额，3=支付宝，4=微信，5=网页支付
 */
function createPaymentTask(paidFrom) {
	if(payConfig.isInitOk > 0) {
		alertMsg("初始化尚未完成，请稍等片刻"); return;
	}
	var priceTypeSelect = $('#priceTypeUl .select');
	var price = calculatePrice();
	var year = priceTypeSelect.attr('year');
	
	ajaxTemp("createPaymentTask", "POST", "json", {
			CLIENTKEY : clientKey,
			deptId : payConfig.adminDeptId,
			ptType : payConfig.ptType,
			balancePrice : payConfig.usedAmount,
			shareMoney : payConfig.usedShareMoney,
			totalMoney : payConfig.needPrice,
			source : "0",
			bzyh : bzyh,
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
			if(paidFrom == 1) {
				amountPayOrder();// 余额支付订单
			} else if(paidFrom == 2) {
				amountPayOrder();// 余额支付订单
			} else if(paidFrom == 3) {
				aliQrIframeChangeCount = 0;
				$(".ali-qr-iframe").attr("src", payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
						+ "ptId=" + payConfig.ptId
						+ "&token=" + payConfig.token
						+ "&qrPayMode=4&qrcodeWidth=150"
						+ "&returnUrl=" + payConfig.returnUrl
				);
				$('#aliPayQrCodeModel').show();
			} else if(paidFrom == 4) {
				$(".weixin-qr-img").html('<img src='+payConfig.adminWebUrl+'pay/getWeiXinPayQrCode?'
						+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token + '>');
				$('#weixinPayQrCodeModel').show();
			} else {
				console.log(payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
						+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token);
				
				openWindow(payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
						+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token
				);
			}
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}

/**
 * 支付宝支付页面跳转后的操作
 */

function showPaySuccess() {
	var isCompAccount = (payConfig.ptType == 11) ? 1 : 0;// 11=公司，12=个人
	ajaxTemp("../common/getUserAmount", "POST", "json", {
		CLIENTKEY : clientKey, isCompAccount : isCompAccount
		}, function(json){
			$(".con-left").hide();
			$(".con-left.pay-result").show();
			$(".ali-qr-iframe").attr("src", "");
			$('#aliPayQrCodeModel').hide();
			if (json.errCode != 200) {
				alertMsg("获取账户余额失败");return;
			}
			$('#haofangBeanNow').text(json.data.haofangAmount);
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}

/** 
 * 网页支付
 */
$('.use-web-pay').on('click',function(){
	createPaymentTask(5);
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

/**余额支付订单*/
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

/**点击支付*/
$('#payModel .change-addr').on('click',function(){
	$('#payModel').show();
});

/**点击支付窗口关闭*/
$('#payModel .model-delete').on('click',function(){
	$('#payModel').hide();
	$('#aliPayIframe').attr("src", "");
	$('#weiXinQRCodeImg').empty();
});

/**关闭整个支付窗口*/
$('#closePayPage').on('click',function(){
	// 直接关闭整个窗口
	try {
		document.getElementById("custObj").closeWidget();
	} catch (e) {}
});

/**确认使用余额抵扣*/
$('#amountPayDiv').on('click', ".sure-pay.visible", function(){
	amountPayOrder();
});

function showPayDiv(type) {
	//$('#payModel').show();
	payConfig.needUserNewPrice = payConfig.needPrice;// 需要用户新支付的金额
	payConfig.usedAmount = 0;// 余额为0
	payConfig.usedShareMoney = 0;// 分享金为0
	if(type == 1) {// 推广佣金
		$('#payModel .head .checked').removeClass("checked");
		$('#sharePay').addClass("checked");
		$("#resultPayInfoDiv .info").text("当前可用余额"+payConfig.shareMoney+"元").show();
		$('#weiXinQRCodeDiv,#aliPayDiv,#aliWebPay,#iframeMask').hide();
		$('#amountPayDiv').show();
		// 金额不够
		if(payConfig.shareMoney < payConfig.needPrice) {
			$('#amountPayDiv .pay-info').show();
			$('#amountPayDiv .sure-pay').removeClass("visible");
		} else {
			$('#amountPayDiv .pay-info').hide();
			$('#amountPayDiv .sure-pay').addClass("visible");
			payConfig.needUserNewPrice = 0;// 需要用户新支付的金额
			payConfig.usedShareMoney = payConfig.needPrice;// 分享金为全部金额
		}
	} else if(type == 2) {// 现金余额
		$('#payModel .head .checked').removeClass("checked");
		$('#amountPay').addClass("checked");
		$("#resultPayInfoDiv .info").text("当前可用余额"+payConfig.cashMoney+"元").show();
		$('#weiXinQRCodeDiv,#aliPayDiv,#aliWebPay,#iframeMask').hide();
		$('#amountPayDiv').show();
		// 金额不够
		if(payConfig.cashMoney < payConfig.needPrice) {
			$('#amountPayDiv .pay-info').show();
			$('#amountPayDiv .sure-pay').removeClass("visible");
		} else {
			$('#amountPayDiv .pay-info').hide();
			$('#amountPayDiv .sure-pay').addClass("visible");
			payConfig.needUserNewPrice = 0;// 需要用户新支付的金额
			payConfig.usedAmount = payConfig.needPrice;// 余额为全部金额
		}
	} else if(type == 3) {// 支付宝
		$('#payModel .head .checked').removeClass("checked");
		$('#aliPay').addClass("checked");
		$("#resultPayInfoDiv .info").hide();
		$('#amountPayDiv .pay-info').hide();
		$('#weiXinQRCodeDiv,#amountPayDiv').hide();
		$('#aliPayDiv,#aliWebPay,#iframeMask').show();
	} else if(type == 4) {// 微信支付
		$('#payModel .head .checked').removeClass("checked");
		$('#weixinPay').addClass("checked");
		$("#resultPayInfoDiv .info").hide();
		$('#amountPayDiv .pay-info').hide();
		$('#aliPayDiv,#aliWebPay,#amountPayDiv').hide();
		$('#weiXinQRCodeDiv,#iframeMask').show();
	}
}

/**分享金支付*/
$('#sharePay').on('click',function(){
	showPayDiv(1);
	createPaymentTask(1);
});

/**余额支付*/
$('#amountPay').on('click',function(){
	showPayDiv(2);
	createPaymentTask(2);
});

/**支付宝支付*/
$('#aliPay').on('click',function(){
	showPayDiv(3);
	createPaymentTask(3);
});

/**微信支付*/
$('#weixinPay').on('click',function(){
	showPayDiv(4);
	createPaymentTask(4);
});
$('.plus_info_sj').on('click',function(){
	/*console.log(payConfig.adminWebUrl + "payForProductApi/buyProductForPlus.htm?"
			+ "archiveId="+archiveIdTmp)
	openWindow(payConfig.adminWebUrl + "payForProductApi/buyProductForPlus.htm?"
			+ "archiveId="+archiveIdTmp);
	*/
	window.location.href=erpWebUrl+"usercenter/payment/vipPay/index?CLIENTKEY="+clientKey
	//window.location.href="http://192.168.5.161:8080/erpWeb/usercenter/payment/vipPay/index?CLIENTKEY="+clientKey
});

