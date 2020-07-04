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
	needPrice : "0",// 所需价格，每次计算之后赋值
	usedAmount : "0",// 使用了多少账户余额，每次计算之后赋值
	needUserNewPrice : "0",// 需要用户新支付的金额
	ptId : "",// 生成订单后的订单ID
	token : "",// 生成订单后的token
	usableAmount : {},// 账号信息
	huabeiRepaymentRate : {},// 花呗分期配置，如果返回值为空则隐藏花呗
};

$(document).ready(function(){
	initUrlConfig("usercenter/payment/o2oRenewal/result?CLIENTKEY="+clientKey);
	
	payConfig.adminDeptId = adminDeptIdTmp;
	payConfig.archiveId = archiveIdTmp;
	payConfig.amount = amount;
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
        $("#huabeiPayNewUl li").css({'width':'120px','margin-right':'14px'});
        $(".huabeiPayNewUl").css({'float':'left','margin-top':'14px'});
        $(".pay-box2").css('margin-top','47px');
    }
	$("#payForName").text("O2O租用");
	$("#payForUseage").html("1、私有云解决方案让使用更放心<br>2、首推租用方案让成本投入更低<br>3、先使用满意再付费，1年内无条件退款");
	$("#payForName").css('background', 'url("'+statics+'ucenter/o2oRenewal/img/o2oRenewal.png") no-repeat 12px center');
	$("#vrRedWarnDiv div").html("");
	try {
		document.getElementById("custObj").setCloseBtnVisible(0);
	} catch (e) {}
	$("#vrInfoDiv,#quanGift").hide();
	ajaxTemp(payConfig.crmWebUrl + "crmOpenApi/contractOpenApi/deptSoftRule", "POST", "json", {
			deptId : payConfig.adminDeptId
		}, function(data){
			if (validateCrmResult(data, "", 1)) {
				payConfig.isInitOk--;
				payConfig.superComp = data.data.superComp;
				var endTimeNow = data.data.otoEnd;// 微店到期时间
				var html = "";
				var extJson = [1, 2, 3];
				for (var i = 0; i < extJson.length; i++) {
					var year = extJson[i];
					var selectIndex = 0;
					var liAttrs = (i == 0) ? 'class="select"' : '';
					var pirce = year * data.data.rentPrice;
					// 计算到期时间
					var date = new Date(endTimeNow.substring(0, 10));
					date.setFullYear(date.getFullYear()+1);
					var month = date.getMonth()+1;
					var day = date.getDate();
					month = month < 10 ? ('0' + month) : month;
					day = day < 10 ? ('0' + day) : day;
					endTimeNow = date.getFullYear()+'-'+month+'-'+day;
					
					liAttrs += ' price="'+pirce+'" year="'+year+'"';
//					html += '<li ' + liAttrs + '>';
//					html += '<div class="vip-price"><div>¥'+pirce+'<span>/'+year+'年</span></div>';
//					html += '<div>续期至'+endTimeNow+'</div>';
//					html += '</div>';
//					html += '<div class="thing-gou"></div></li>';
					html += '<li ' + liAttrs + '>';
					html += '<div class="vip-price"><div class="buy-price"><span class="price">'+pirce+'</span><span>元</span></div><div class="buy-count">续期至'+endTimeNow+'</div></div>';
					html += '<div class="thing-gou"></div></li>';// 勾勾
				}
				$("#priceTypeUl").empty().append(html);
				calculatePrice();
			}
		}
	);
});
/**
 * 重新计算并设置显示价格
 */
function calculatePrice() {
	var priceTypeSelect = $('#priceTypeUl .select');
	var price = parseInt(priceTypeSelect.attr('price'));
	var year = parseInt(priceTypeSelect.attr('year'));
	var priceArr = [price, price];
	payConfig.needPriceCutDkq = priceArr[0];// 减去抵扣券的金额（必须放这一行）
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
	$("#payInfoDiv .info").text("O2O租用"+year+"年");
	payConfig.ptId = "";
	payConfig.needPrice = priceArr[1];// 不减去抵扣时的金额
	payConfig.needUserNewPrice = priceArr[0];// 需要用户新支付的金额
	calculateHuabeiRepayment();// 花呗分期
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
		$('#sureCreateOrder').text('扫码支付');
		$('.use-web-pay').show();
		$('#huabeiPayNewUl').show();
	} else {
		$('#sureCreateOrder').text('扫码支付');
		$('#huabeiPayNewUl').hide();
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
	var priceTypeSelect = $('#priceTypeUl .select');
	var huabeiPayCheacked = $('#huabeiPayNewUl').find('li.checked');
	var hbFqNum = "";
	if(huabeiPayCheacked != undefined && huabeiPayCheacked.length > 0) {
		hbFqNum = huabeiPayCheacked.attr('times');
	}
	var price = calculatePrice();
	var year = priceTypeSelect.attr('year');
	var vrPrice = parseInt(priceTypeSelect.attr('vrPrice'));
	
	var choiseVr = $(".vr-choise").hasClass('select') ? 1 : 0;
	ajaxTemp("createPaymentTask", "POST", "json", {
			CLIENTKEY : clientKey,
			deptId : payConfig.adminDeptId,
			ptType : payConfig.ptType,
			srvMonth : year,
			addVr : choiseVr,
			balancePrice : payConfig.usedAmount,
			totalMoney : payConfig.needPriceCutDkq,
			source : "0",
			payModel : "0",
			hbFqNum : hbFqNum,// 花呗期数
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
				amountPayOrder();
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
	$(".con-left").hide();
	$(".con-left.pay-result").show();
	$(".ali-qr-iframe").attr("src", "");
	$('#aliPayQrCodeModel').hide();
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
		var huabeiPayCheacked = $('#huabeiPayNewUl').find('li.checked');
		var hbFqNum = "";
		if(huabeiPayCheacked != undefined && huabeiPayCheacked.length > 0) {
			hbFqNum = huabeiPayCheacked.attr('times');
		}
		openWindow(payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
				+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token
				+ "&hbFqNum=" + hbFqNum
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
 * 计算并展示花呗分期价格
 * @returns
 */
function calculateHuabeiRepayment(){
	// 隐藏花呗分期
	if (payConfig.huabeiRepaymentRate == undefined
			|| payConfig.huabeiRepaymentRate.seller == undefined
			|| payConfig.huabeiRepaymentRate.user == undefined) {
		return;
	}
	$("#huabeiPayNewUl").empty();
	var config = [3, 6, 12];
	for (var i = 0; i < config.length; i++) {
		var rate = undefined;
		var isSellerRate = (payConfig.ptType == 13 || payConfig.needPrice >= 1000
				|| (payConfig.needPrice >= 1000 && config[i] >= 6));
		// 现在都是用户承担手续费
		isSellerRate = false;
		if(isSellerRate) {// 否则都由我们承担
			rate = payConfig.huabeiRepaymentRate.seller['seller_' + config[i]];
		} else {// VIP购买而且小于1200分期手续费由用户承担
			rate = payConfig.huabeiRepaymentRate.user['user_' + config[i]];
		}
		if(rate == undefined) {
			break;
		}
		var onePrice = payConfig.needPrice / config[i];// 一期价格
		var ratePrice = payConfig.needPrice * (rate / 100);// 总手续费
		if(isSellerRate) {// VIP购买而且小于1200分期手续费由用户承担
			ratePrice = 0.0;
		}
		var oneRatePrice = ratePrice / config[i];// 一期手续费
		var oneNeedPrice = (onePrice + oneRatePrice).toFixed(2);// 一期加上手续费的价格
		var totlaPrice = (payConfig.needPrice + ratePrice).toFixed(2);// 几期总共的价格，必须在后面
		onePrice = onePrice.toFixed(2);
		ratePrice = ratePrice.toFixed(2);
		oneRatePrice = oneRatePrice.toFixed(2);
		var ratePayer = "手续费：商家承担";
		if(!isSellerRate) {// VIP购买而且小于1200分期手续费由用户承担
			ratePayer = '含手续费：'+oneRatePrice+'元/期';
		}
		var attrs = ' price="' + payConfig.needPrice + '" ratePrice="'+ratePrice+'" times="'+config[i]+'"';
		$("#huabeiPayNewUl").append(
			'<li '+attrs+'>'
				+'<div>'
					+'<span>￥'+oneNeedPrice+'元</span>×'+config[i]+'期'
				+'</div>'
				+'<div>'
					+ ratePayer
				+'</div>'
				+'<div class="prg-red"></div>'
			+'</li>'
		);
	}
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
/**
 * 选中使用余额抵扣
 */
$('#choiseShareMoney').on('click', function() {
	if ($(this).hasClass('pay-checkbox-checked')) {
		$(this).removeClass('pay-checkbox-checked');
	} else {
		$(this).addClass('pay-checkbox-checked');
	}
	calculatePrice();
});
/**
 * 花呗分期类型切换
 */
$('#huabeiPayNewUl').on('click', 'li', function() {
	if($(this).hasClass('checked')) {
		$(this).removeClass('checked');
		$("#huabeirateInfoDiv").hide();
		$("#huabeirateInfoDiv").parent(".qrcode").removeClass("huabei");
	} else {
		$(this).siblings().removeClass('checked');
		$(this).addClass('checked');
		var price = parseFloat($(this).attr('price'));
		var ratePrice = parseFloat($(this).attr('ratePrice'));
		$("#huabeiNeedPayPrice").text("￥" + (price+ratePrice));
		$("#huabeiRatePrice").text((ratePrice <= 0) ? "" : ("(含手续费：￥" + ratePrice + ")"));
		$("#huabeirateInfoDiv").parent(".qrcode").addClass("huabei");
		$("#huabeirateInfoDiv").show();
	}
});

