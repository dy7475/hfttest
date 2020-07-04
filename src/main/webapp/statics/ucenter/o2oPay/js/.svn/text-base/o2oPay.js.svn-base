// 页面所需配置
var payConfig = {
	ptType : "",// 支付类型
	couponNum3 : 0,// 代金券金额
	couponNum6 : 0,// 代金券金额
	couponNum12 : 0,// 代金券金额
	cashMoney : 0,// 账户余额
	shareMoney : 0,// 分享金额
	// 软件购买相关
	contractNo : "",// 合同编号
	contractHtml : "",// 合同详情网页
	weiContractHtml : "",// 微店合同详情网页
	softPrice : "",// 微店合同详情网页
	weiPrice : "",// 微店合同详情网页
	
	sellId : "",// 销售ID
	superUser : "",// VIP
	cityId : "",// 城市ID
	archiveId : "",// 档案ID
	adminDeptId : "",// admin门店ID
	payUrl : "",// 支付url，生成订单后返回
	giftVipFlag : "0",// 2018好房通精英版促销活动标记0=不参与，1=可以参与
	year9Event : "0",// 9周年活动是否开启，1=开启
	yearPayType : "0",// 年付支付类型 0 默认 1 差价（充值过的未过期年付用户） 2 打折（充值过的用户&&非年付未过期） 在活动期内--admin
	yearPayPriceSpread : "0",// 年付会员的补差价金额和打折方式
	superComp : "1",// 是否是总部城市，0=代理商城市，1=非代理商城市
	isInitOk : 1,// 是否初始化完成，小于等于0代表完成，初始值为需要初始化的数量
	// 是否可以使用代金券
	dkqFlag3 : "0",// 3个月是否可以使用
	dkqFlag6 : "0",// 6个月是否可以使用
	dkqFlag12 : "0",// 12个月是否可以使用
	// 以下是点网页支付时需要
	needPrice : "0",// 所需价格，每次计算之后赋值
	usedShareMoney : "0",// 使用了多少推广现金，每次计算之后赋值
	usedAmount : "0",// 使用了多少账户余额，每次计算之后赋值
	needUserNewPrice : "0",// 需要用户新支付的金额
	ptId : "",// 生成订单后的订单ID
	token : "",// 生成订单后的token
	huabeiRepaymentRate : {},// 花呗分期配置，如果返回值为空则隐藏花呗
};

$(document).ready(function(){
	initUrlConfig("usercenter/payment/hfBeans/result?CLIENTKEY="+clientKey);
	
	// 花呗配置
	payConfig.huabeiRepaymentRate = huabeiRepaymentRate;
	payConfig.cashMoney = cashMoney;
	payConfig.shareMoney = shareMoney;
	payConfig.adminDeptId = adminDeptIdTmp;
	payConfig.archiveId = archiveIdTmp;
	payConfig.ptType = "13";
    payConfig.isPersonalVersion = isPersonalVersion;
    if (isPersonalVersion == 0){
        $(".container").css({'width':'100%','height':'100%'});
        $(".con-left").css('width','636px');
        $(".con-right").css('width','229px');
        $(".bottomTipInfo").css({'height':'43px','width':'611px'});
        $(".qr-code-model .inner-qr-box").css('margin','91px 280px');
        $("#vrMaskDiv").css('height','20px');
        $(".pay-type-box .item").css({'height':'45px','margin-right':'14px'});
        $("#huabeiPayNewUl li").css({'width':'120px','margin-right':'14px'});
        $(".huabeiPayNewUl").css({'float':'left','margin-top':'14px'});
        $(".pay-type-box .item.checked .gou").css('height','40px');
        $(".pay-box2").css('margin-top','47px');
    }
	
	$("#payForName").text("O2O服务");
	$("#payForUseage").html("* 一键群发房源到各网站，1分钟完成任务，后续更新、管理更方便<br /><br /> * 无限制使用好房搜搜、好房发发的所有功能<br /><br /> *免费使用海量3D户型图，轻松搞定小区户型图匹配<br /><br /> *享受全面、真实、细致的大数据统计分析");
	$("#payForName").css('background', 'url("'+statics+'ucenter/o2oPay/img/o2o.png") no-repeat 12px 54%');
	$("#vrRedWarnDiv div").html("充值满2400元即可赠送价值<br/>1880元的720°VR相机");
	// 9年感恩钜惠显示
	if(payConfig.year9Event == "1") {
		$("#year9TipInfo").show();
	}
	try{
		document.getElementById("custObj").setCloseBtnVisible(0);
	}catch(e){}
	$("#vrInfoDiv,#quanGift").hide();
	//$('#huabeiPayUl').hide();// 不提供花呗支付方式
	// type=0经纪人1门店&caseId=archiveId||deptId
	ajaxTemp(payConfig.crmWebUrl + "crmOpenApi/contractOpenApi/entityIsSuperComp", "GET", "json", {
			type : "1", caseId : payConfig.adminDeptId
		}, function(data){
			if (validateCrmResult(data, "", 1)) {
				payConfig.isInitOk--;
				payConfig.superComp = data.data.superComp;
				if(payConfig.superComp == "1") {
					// 这里暂时不能选择VR；-VR选中-
					//$("#vrInfoDiv,#quanGift").show();
					//$("#choiseVr").addClass('checkbox1');
				}
				getUsableAmount();
			}
		}
	);
});
/**
 * 获取支付金额等配置
 */
function getUsableAmount() {
	var html = "";
	for (var i = 0; i < buyConfigJson.length; i++) {
		var temp = buyConfigJson[i];
		var selectIndex = 0;
		if (temp.dkqPrice != undefined) {
			if(temp.month == 3) {
				payConfig.couponNum3 = parseInt(temp.dkqPrice);
			} else if(temp.month == 6) {
				payConfig.couponNum6 = parseInt(temp.dkqPrice);
			} else if(temp.month == 12) {
				payConfig.couponNum12 = parseInt(temp.dkqPrice);
			}
		}
		var liAttrs = (i == selectIndex) ? 'class="select"' : '';
		var rateTypeStr = "";
		var yearPayTypeInt = false;//parseInt(payConfig.yearPayType);
		// 9年活动开启，而且是12个月
		var yearVipIsOpen = false;//payConfig.year9Event == "1" && temp.month == 12;
		if(yearVipIsOpen && yearPayTypeInt == 1) {// 当前还是年付会员
			rateTypeStr = "【补差】";
			temp.price = temp.price - payConfig.yearPayPriceSpread;// 补差金额
		} else if(yearVipIsOpen && yearPayTypeInt == 2) {// 曾经是年付会员
			rateTypeStr = "【7折】";
			temp.price = temp.price * payConfig.yearPayPriceSpread;// 7折
		} else if(yearVipIsOpen) {// 年付VIP
			rateTypeStr = "/终身VIP";
		}
		// 最后得到的赠送劵金额大于支付金额则赠送支付金额优惠券
		if(temp.quanGift > temp.price) {
			temp.quanGift = temp.price;
		}
		//payConfig.giftVipFlag = "1";//TODO 测试使用
		liAttrs += ' price="'+temp.price+'" month="'+temp.month+'" vrPrice="'+temp.vrPrice+'" vrRealPrice="'+temp.vrRealPrice+'" quanGift="'+temp.quanGift+'"';
		/*html += '<li ' + liAttrs + '>';
		// 9年感恩钜惠显示
		if(yearVipIsOpen) {
			html += '<div class="vip-price"><div>¥'+temp.price+'<span>'+rateTypeStr+'</span></div>';
		} else if(payConfig.year9Event == "1"){// 9年庆显示样式
			html += '<div class="vip-price"><div>¥'+temp.price+'<span>/'+temp.month+'个月</span></div>';
		} else {// 普通显示样式
			html += '<div class="vip-price"><div>¥'+temp.price+'</span></div>';
		}
		// 9年感恩钜惠显示
		if(yearVipIsOpen && yearPayTypeInt > 0) {// VIP且年付会员
			html += '<div>升级终身VIP</div>';
			html += '<div>'+temp.originalPrice+'/'+temp.month+'个月</div>';
		} else if(yearVipIsOpen) {// VIP的优惠价格
			html += '<div></div>';
			html += '<div>12个月</div>';
		} else if(temp.originalPrice != temp.price) {// 和原始价格不相等的优惠价格
			html += '<div>'+temp.text+'</div>';
			html += '<div>￥'+temp.originalPrice+'</div>';
		} else {// 普通样式，显示购买年限
			html += '<div>'+temp.text+'</div>';
		}
		html += '</div>';
		// 9年感恩钜惠显示
		if(yearVipIsOpen && payConfig.yearPayType == "1") {
			html += '<div class="vip-welfare"></div>';
		}
		// 非代理商城市
		var huiShow = false;
		if(payConfig.superComp == "1") {
			if(temp.originalPrice != temp.price){ // 和原始价格不相等，优惠标签
				huiShow = true;
			}
		}
		if(yearVipIsOpen) {// 年付VIP
			huiShow = true;
		}
		if(huiShow) {
			html += '<div class="hui"></div>';
		}*/
		html += '<li ' + liAttrs + '>';
		// 9年感恩钜惠显示
		if(yearVipIsOpen) {
			html += '<div class="vip-price"><div class="buy-price"><span class="price">'+temp.price+'</span><span>元</span></div><div class="buy-count">'+temp.text+'</div></div>';
		} else if(payConfig.ptType == 4){// 2018买一送一显示样式
			html += '<div class="vip-price"><div class="buy-price"><span class="price">'+temp.price+'</span><span>元</span></div><div class="buy-count">'+temp.text+'</div></div>';
			//html += '<div class="vip-price"><div>¥'+temp.price+'<span>/'+temp.month+'个月</span></div>';
		} else {// 普通显示样式
			html += '<div class="vip-price"><div class="buy-price"><span class="price">'+temp.price+'</span><span>元</span></div><div class="buy-count">'+temp.text+'</div></div>';
			//html += '<div class="vip-price"><div>¥'+temp.price+'</span></div>';
		}
		html += '<div class="thing-gou"></div></li>';// 勾勾
	}
	if(payConfig.year9Event == "1") {
		$("#priceTypeUl").addClass("year9");
	}
	$("#priceTypeUl").empty().append(html);
	calculatePrice();
}
/**
 * 重新计算并设置显示价格
 */
function calculatePrice() {
	var priceTypeSelect = $('#priceTypeUl .select');
	var price = parseInt(priceTypeSelect.attr('price'));
	var vrPrice = parseInt(priceTypeSelect.attr('vrPrice'));
	var vrRealPrice = parseInt(priceTypeSelect.attr('vrRealPrice'));
	var quanGift = parseInt(priceTypeSelect.attr('quanGift'));
	var month = parseInt(priceTypeSelect.attr('month'));
	var choiseVr = $(".vr-choise").hasClass('select');
	// 代理商城市不能选择VR
	if(payConfig.superComp == "0") {
		choiseVr = false;
		vrPrice = 0;
	}
	price = o2oCalculatePrice(price, choiseVr, vrPrice, vrRealPrice, month);
	payConfig.needPriceCutDkq = price[0];// 减去抵扣券的金额（必须放这一行）
	$(".total-price,#noAmountNeedPay,#resultNeedPay").text(price[0]);// 所需支付总金额
	if(payConfig.shareMoney > 0) {
		var usedAmount = (payConfig.shareMoney > price[0]) ? price[0] : payConfig.shareMoney;
		$("#sharePayTotal").text(usedAmount);
		if($('#choiseShareMoney').hasClass('pay-checkbox-checked')) {
			payConfig.usedShareMoney = usedAmount;
			price[0] = parseFloat((price[0] - usedAmount).toFixed(2));
			$(".total-price").text(price[0]);
		} else {
			payConfig.usedShareMoney = 0;
		}
	} else {
		$("#choiseShareMoney").hide();
	}
	if(payConfig.cashMoney > 0) {
		var usedAmount = (payConfig.cashMoney > price[0]) ? price[0] : payConfig.cashMoney;
		$("#amountPayTotal").text(usedAmount);
		if($('#choiseBalance').hasClass('pay-checkbox-checked')) {
			payConfig.usedAmount = usedAmount;
			price[0] = parseFloat((price[0] - usedAmount).toFixed(2));
			$(".total-price").text(price[0]);
		} else {
			payConfig.usedAmount = 0;
		}
		if(payConfig.shareMoney > 0 && payConfig.usedShareMoney <= 0) {
			var usedAmount = (payConfig.shareMoney > price[0]) ? price[0] : payConfig.shareMoney;
			$("#sharePayTotal").text(usedAmount);
		}
	} else {
		$("#choiseBalance").hide();
	}
	if (quanGift > 0) {
		$("#quanGift").text('及' + quanGift +'优惠券');
	} else {
		$("#quanGift").text('');
	}
	payConfig.ptId = "";
	payConfig.needPrice = price[1];// 不减去抵扣时的金额
	payConfig.needUserNewPrice = price[0];// 需要用户新支付的金额
	calculateHuabeiRepayment();// 花呗分期
	return price;
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
 * o2o价格计算
 */
function o2oCalculatePrice(price, choiseVr, vrPrice, vrRealPrice, month) {
	if(vrPrice > 0) {
		if(choiseVr) {
			price += vrPrice;// 价格在2400以下时，选择了VR，加上VR价格
		}
		$("#vrPrice").text(vrPrice+"元");
		$("#zengVr").hide();
		$(".vr-choise").show();
		$("#vrRedWarnDiv").show();
	} else {
		$("#vrPrice").text("0元");
		$("#zengVr").show();
		$(".vr-choise").hide();
		$("#vrRedWarnDiv").hide();
		// vr价格为0时选中VR；O2O暂时不提供VR选择；-VR选中-
		//if(payConfig.superComp == "1") {
			//$("#choiseVr").addClass('checkbox1');
		//}
	}
	var totalNeedPay = price;// 不减去抵扣时的金额
	if(vrPrice != vrRealPrice) {// 当前价格和原价不相等才显示原价
		$("#vrRealPrice").text("￥"+vrRealPrice);
	} else {
		$("#vrRealPrice").text("");
	}
	if(price <= 0) {
		price = 0;
	}
	var monthStr = "";
	if(month == "1") {
		monthStr = "一年";
	} else if(month == "2") {
		monthStr = "两年";
	} else if(month == "3") {
		monthStr = "三年";
	} else if(month == "4") {
		monthStr = "四年";
	} else {
		monthStr = month + "年";
	}
	var infoTemp = "好房通"+monthStr+"O2O服务";
	if(choiseVr) {
		infoTemp += "+720°VR相机";
	}
	$("#payInfoDiv .info").text(infoTemp);
	return [price, totalNeedPay];
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
	var month = priceTypeSelect.attr('month');
	var vrPrice = parseInt(priceTypeSelect.attr('vrPrice'));
	// 代理商城市不能选择VR
//	var choiseVr = ($("#choiseVr").hasClass('checkbox1')
//			|| (payConfig.superComp == "1" && vrPrice == 0)) ? 1 : 0;
	var choiseVr = $(".vr-choise").hasClass('select') ? 1 : 0;
	ajaxTemp("createPaymentTask", "POST", "json", {
			archiveId : payConfig.archiveId,
			deptId : payConfig.adminDeptId,
			ptType : payConfig.ptType,
			srvMonth : month,
			addVr : choiseVr,
			CLIENTKEY : clientKey,
			shareMoney : payConfig.usedShareMoney,
			balancePrice : payConfig.usedAmount,
			totalMoney : payConfig.needPriceCutDkq,
			source : "0",
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
		CLIENTKEY : clientKey, ptId : payConfig.ptId, archiveId : payConfig.archiveId
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
	document.getElementById("custObj").closeWidget();
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


