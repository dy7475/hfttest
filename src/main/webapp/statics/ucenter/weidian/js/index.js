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
	// 线上
	erpWebUrl : "http://erpweb.myfun7.com/erpWeb/",
	adminWebUrl : "http://admin.myfun7.com/adminWeb/",
	crmWebUrl : "http://crmweb.myfun7.com/crmWeb/",
	returnUrl : "http://erpweb.myfun7.com/erpWeb/usercenter/payment/weidian/result?CLIENTKEY="+clientKey,
	// jsg
//	erpWebUrl : "http://192.168.5.172:8080/erpWeb/",
//	adminWebUrl : "http://192.168.5.165:8080/adminWeb/",
//	crmWebUrl : "http://192.168.5.165:8089/crmWeb/",
//	returnUrl : "http://192.168.5.172:8080/erpWeb/usercenter/payment/weidian/result?CLIENTKEY="+clientKey,
	// 101
//	erpWebUrl : "http://192.168.11.101:8080/erpWeb/",
//	crmWebUrl : "http://192.168.11.101:8080/crmWeb/",
//	adminWebUrl : "http://192.168.11.101:8080/adminWeb/",
//	returnUrl : "http://192.168.11.101:8080/erpWeb/usercenter/payment/weidian/result?CLIENTKEY="+clientKey,
};

$(document).ready(function(){
	initUrlConfig("usercenter/payment/cashRecharge/result?CLIENTKEY="+clientKey);

	payConfig.adminDeptId = adminDeptIdTmp;
	payConfig.archiveId = archiveIdTmp;
	payConfig.amount = amount;
	payConfig.isPersonalVersion = isPersonalVersion;
	if (isPersonalVersion == 0){
		$(".container").css({'width':'100%','height':'100%'});
		$(".con-left").css('width','636px');
		$(".con-right").css('width','229px');
		$("#vrMaskDiv").css('height','20px');
	}
	$("#payForName").text("企业微店");
	$("#payForUseage").html("公司自己的自媒体：<br>1、无缝对接ERP数据，提供吸粉内容素材轻松经营<br>2、IM在线及时聊，沟通无障碍<br>3、优质房源，一键分享至微信，快速展示优质房源，让成交快人一步<br>4、利用社会化营销少花端口冤枉钱");
	$("#payForName").css('background', 'url("'+statics+'ucenter/weidian/img/weidian.png") no-repeat 12px 52%');
	$("#vrRedWarnDiv div").html("");
	try {
		document.getElementById("custObj").setCloseBtnVisible(0);
	} catch (e) {}
	$("#vrMaskDiv").show();
	$("#vrInfoDiv,#quanGift").hide();
	ajaxTemp(payConfig.crmWebUrl + "crmOpenApi/contractOpenApi/deptSoftRule", "POST", "json", {
			deptId : payConfig.adminDeptId
		}, function(data){
			if (validateCrmResult(data, "", 1)) {
				payConfig.isInitOk--;
				payConfig.superComp = data.data.superComp;
				var endTimeNow = data.data.wxEndTime;// 微店到期时间
				var html = "";
				var extJson = [1, 2, 3];
				for (var i = 0; i < extJson.length; i++) {
					var year = extJson[i];
					var selectIndex = 0;
					var liAttrs = (i == 0) ? 'class="select"' : '';
					var pirce = year * data.data.rentWxPrice;
					// 计算到期时间
					var date = new Date(endTimeNow.substring(0, 10));
					date.setFullYear(date.getFullYear()+1);
					var month = date.getMonth()+1;
					var day = date.getDate();
					month = month < 10 ? ('0' + month) : month;
					day = day < 10 ? ('0' + day) : day;
					endTimeNow = date.getFullYear()+'-'+month+'-'+day;

					liAttrs += ' price="'+pirce+'" year="'+year+'"';
					html += '<li ' + liAttrs + '>';
					html += '<div class="vip-price"><div>¥'+pirce+'<span>/'+year+'年</span></div>';
					html += '<div>续期至'+endTimeNow+'</div>';
					html += '</div>';
					html += '<div class="thing-gou"></div></li>';
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
	$("#totalPrice,#noAmountNeedPay,#resultNeedPay").text(priceArr[0]);// 所需支付总金额
	if(payConfig.amount > 0) {
		var usedAmount = (payConfig.amount > priceArr[0]) ? priceArr[0] : payConfig.amount;
		$("#choiseBalance").text("使用余额抵扣"+usedAmount+"元");
		if($('#choiseBalance').hasClass('checkbox1')) {
			payConfig.usedAmount = usedAmount;
			priceArr[0] = payConfig.needPrice - usedAmount;
			$("#resultNeedPay").text("¥"+priceArr[0]);
		}
	} else {
		$("#choiseBalance").hide();
	}
	if (quanGift > 0) {
		$("#quanGift").text('及' + quanGift +'优惠券');
	} else {
		$("#quanGift").text('');
	}
	$("#payInfoDiv .info").text("微店续费"+year+"年");
	payConfig.ptId = "";
	payConfig.needPrice = priceArr[1];// 不减去抵扣时的金额
	payConfig.needUserNewPrice = priceArr[0];// 需要用户新支付的金额
	return priceArr;
}
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
	calculateHuabeiRepayment();// 花呗分期
	createPaymentTask();
});
/**
 * 创建订单和显示支付按钮
 */
function createPaymentTask() {
	if(payConfig.isInitOk > 0) {
		alertMsg("初始化尚未完成，请稍等片刻"); return;
	}
	var priceTypeSelect = $('#priceTypeUl .select');
	var huabeiPayCheacked = $('#huabeiPayUl').find('li.checked');
	var hbFqNum = "";
	if(huabeiPayCheacked != undefined && huabeiPayCheacked.length > 0) {
		hbFqNum = huabeiPayCheacked.attr('times');
	}
	var price = calculatePrice();
	var year = priceTypeSelect.attr('year');
	var vrPrice = parseInt(priceTypeSelect.attr('vrPrice'));

	var choiseVr = $("#choiseVr").hasClass('checkbox1') ? 1 : 0;
	ajaxTemp("createPaymentTask", "POST", "json", {
			CLIENTKEY : clientKey,
			deptId : payConfig.adminDeptId,
			ptType : payConfig.ptType,
			srvMonth : year,
			wxPayType : "2",
			unitPrice : payConfig.usedAmount,
			wxPayYears : year,
			exercisePrice : payConfig.needPriceCutDkq,
			totalMoney : payConfig.needPriceCutDkq,
			source : "0",
			hbFqNum : hbFqNum,// 花呗期数
		}, function(data){
			if (data.code == 300 || data.code == 500) {
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
				$("#aliPayIframe").attr("src", payConfig.adminWebUrl + "pay/aliPagePayOrderPayment?"
					+ "ptId=" + payConfig.ptId
					+ "&token=" + payConfig.token
					+ "&qrPayMode=4&qrcodeWidth=110"
					+ "&returnUrl=" + payConfig.returnUrl
					+ "&hbFqNum=" + hbFqNum
				);
				$("#weiXinQRCodeImg").html('<img src='+payConfig.adminWebUrl+'pay/getWeiXinPayQrCode?'
					+ "ptId=" + payConfig.ptId + "&token=" + payConfig.token + '>');
			}
			$('#aliPay').click();
			$('#payModel').show();
		}, function(data){
			alertMsg("网络异常，请检查网络或稍后再试。");
		}
	);
}
/**
 * 网页支付
 */
$('#aliWebPay').on('click',function(){
	if(payConfig.ptId != undefined && payConfig.ptId != "") {
		var huabeiPayCheacked = $('#huabeiPayUl').find('li.checked');
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
			alertMsg("余额支付订单成功，请重新进入个人中心查看", function() {
				try {
					document.getElementById("custObj").closeWidget();// 关闭整个支付窗口
				} catch (e) {}
			});
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
	$("#huabeiPayUl").empty();
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
			ratePayer = '(<span>'+oneRatePrice+'</span>元/期)';
		}
		var attrs = ' price="' + payConfig.needPrice + '" ratePrice="'+ratePrice+'" times="'+config[i]+'"';
		$("#huabeiPayUl").append(
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
	if ($(this).hasClass('checkbox1')) {
		$(this).removeClass('checkbox1');
		if(payConfig.usedAmount > 0) {// 计算不使用余额的价格
			payConfig.usedAmount = 0;
			$("#resultNeedPay").text("¥"+payConfig.needPrice);
			createPaymentTask();// 重新生成订单
		}
	} else {
		$(this).addClass('checkbox1');
		if(payConfig.amount > 0) {// 如果有余额，减去余额，再重新生成订单
			var usedAmount = (payConfig.amount > payConfig.needPrice) ? payConfig.needPrice : payConfig.amount;
			payConfig.usedAmount = usedAmount;
			$("#resultNeedPay").text("¥"+(payConfig.needPrice - usedAmount));
			createPaymentTask();// 重新生成订单
		}
	}
});
/**
 * 花呗分期类型切换
 */
$('#huabeiPayUl').on('click', 'li', function() {
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
	createPaymentTask();// 重新生成订单
});