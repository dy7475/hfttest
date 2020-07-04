<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/common/error.jsp"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<title>购买PLUS会员</title>
<link href="${statics}ucenter/vipPay/css/index.css" rel="stylesheet" />
<script type="text/javascript">
var aliQrIframeChangeCount = 0;
function aliQrIframeOnChange(obj) {
	aliQrIframeChangeCount++;
	if(aliQrIframeChangeCount == 2) {
		showPaySuccess();
	}
}
</script>
</head>
<body scroll="no" oncontextmenu="return false"
	onselectstart="return false" onselect="document.selection.empty()"
	oncopy="document.selection.empty()" onbeforecopy="return false">
	<div id="app">
		<div class="container">
			<div class="con-left l pay-result">
				<div class="success-box">
					<div><img src="${statics}ucenter/common/img_v2/pay-ok.png"/></div>
					<div class="success-text">订单支付成功</div>
					<!-- <div class="now-balance">当前好房豆余额：<span id="haofangBeanNow"></span>个</div> -->
				</div>
				<div class="success-bottom-box">
					<img src="${statics}ucenter/common/img_v2/logo_bottom.png">
				</div>
			</div>
			<div class="con-left l">
				<div id="topTipInfo">您好，知业教学仅对O2O用户开放，升级为O2O服务后可使用知业教学全部功能</div>
				<div id="year9TipInfo"><div>开通年费会员并于7天内实名认证即获终身VIP</div></div>
				<ul id="priceTypeUl">
					<!-- <li class="select price-li" price="1800" month="6" vrprice="1400" vrrealprice="1880" quangift="1800">
						<div class="vip-price">
							<div class="buy-price">
								<span class="price">300</span><span>元</span>
							</div>
							<div class="buy-count">1个月</div>
						</div>
						<div class="thing-gou"></div>
					</li>
					<li class="price-li" price="1800" month="6" vrprice="1400" vrrealprice="1880" quangift="1800">
						<div class="vip-price">
							<div class="buy-price">
								<span class="price">900</span><span>元</span>
							</div>
							<div class="buy-count">3个月</div>
						</div>
						<div class="thing-gou"></div>
					</li>
					<li class="price-li" price="1800" month="6" vrprice="1400" vrrealprice="1880" quangift="1800">
						<div class="vip-price">
							<div class="buy-price">
								<span class="price">1800</span><span>元</span>
							</div>
							<div class="buy-count">6个月</div>
						</div>
						<div class="thing-gou"></div>
					</li> -->
					<%-- <li class="add-icon"></li>
					<li class="vr-choise">
						<div class="vr-img">
							<img src="${statics}ucenter/common/img/vrxj.jpg">
							<div class="vr-text">720°VR相机</div>
						</div>
						<div class="vr-price" id="vrPrice">0元</div>
						<div class="vr-gou"></div>
					</li> --%>
				</ul>
				<div id="vrMaskDiv"></div>
				<%-- <div class="vr" id="vrInfoDiv">
					<div id="zengVr" class="zeng"></div>
					<div id="choiseVr" class="checkbox"></div>
					<div class="thing">
						<div><img src="${statics}ucenter/common/img/vrxj.jpg"></div>
					</div>
					<div class="vr-txt">
						<div>
							<p>720°VR相机</p>
							<p>
								<span id="vrPrice"></span>
								<span id="vrRealPrice"></span>
							</p>
						</div>
					</div>
					<div class="r vr-des" id="vrRedWarnDiv">
						<div>充值满1200元即可600元换购<br> 价值1280元的720°VR相机</div>
					</div>
				</div> --%>
				<section class="pay">
					<div class="l pay-l">
						<div>支付方式：</div>
						<div class="pay-type-box">
							<div id="balanceInfoDiv">
								<div id="choiseShareMoney" class="pay-checkbox" style="width: 200px;">
									<div style="float: left;">
										<img class="pay_way_pic" src="${statics}ucenter/common/img/extend-cash.png" alt="">
									</div>
									<div style="float: left;margin-top: -4px;">
										<span class="info">余额抵扣<span id="sharePayTotal">12</span>元</span>
									</div>
									
								</div>
								<div id="choiseBalance" class="pay-checkbox" style="width: 216px;">
									<div style="float: left;">
										<img class="pay_way_pic" src="${statics}ucenter/common/img/cash-money.png" alt="">
									</div>
									<div style="float: left;margin-top: -4px;">	
										<span class="info">余额抵扣<span id="amountPayTotal">9</span>元</span>
									</div>
									
								</div>
							</div>
							<div id="payTypeDiv">
								<div class="item alipay checked" val="1"><div class="gou"></div></div>
								<div class="item weixinpay" val="2"><div class="gou"></div></div>
							</div>
						</div>
						<div class="huabeiPayNewUl">
							<ul id="huabeiPayNewUl">
								<!-- <li class="checked">
                                    <div>
                                        <span>￥99元</span>×3期
                                    </div>
                                    <div>
                                        含手续费：18.91元/期
                                    </div>
                                    <div class="prg-red"></div>
                                </li>
                                <li>
                                    <div>
                                        <span>￥99元</span>×6期
                                    </div>
                                    <div>
                                        含手续费：18.42元/期
                                    </div>
                                    <div class="prg-red"></div>
                                </li>
                                <li>
                                    <div>
                                        <span>￥99元</span>×12期
                                    </div>
                                    <div>
                                        含手续费：18.15元/期
                                    </div>
                                    <div class="prg-red"></div>
                                </li> -->
							</ul>
						</div>
					</div>
					<div class="r pay-r">
						<div class="pay-box2">
							<div class="pay-price-txt">
								<span id="cashCouponInfo"></span> <span id="balanceInfo"></span>
								<!-- 已使用代金券100元抵扣 --><!-- 已使用余额抵扣300元 -->
							</div>
							<div class="price-info">
								<span class="l-text">需支付：</span><span class="price-type">￥</span> <span class="total-price" id="huabeiNeedPayPrice">100</span>
								<span class="ll-text ll-text_data" id="huabeiRatePrice"></span>
								<div class="hfd_test" style="margin-top: 7px;">支付成功即送<span class="hfd_test hfd_test_data">1200</span>好房豆</div>
							</div>
							<div class="sure-pay-box">
								<div class="sure-pay visible" id="sureCreateOrder">扫码支付</div>
							</div>
							<div class="">
								<a class="use-web-pay">使用网页支付</a>
							</div>
						</div>
					</div>
				</section>
				<div class="bottomTipInfo">
					好房通产品均采用在线支付方式，为保障您的资金安全，如需转账请仔细核对公司收款账户信息。否则由此产生的任何经济损失与我公司无关。感谢您对好房通产品的信任和支持。
				</div>
			</div>
			<div class="con-right l">
				<div class="r-top">
					<div id="payForName" style="background-size: 20px;">
						<span class="product_title_1">PLUS会员</span>
						<span class="product_title_2">专享权益</span>
					</div>
				</div>
				<div>
						<ul class="product_jj">
					 		<li class="one_msg_data">
					 			<span>·</span>
					 			<span class="one_msg_data_1" >分享真房源返现金</span>
					 			<span class="one_msg_data_2" >2元/客户</span>
					 		</li>
					 		<li class="one_msg_data">
					 			<span>·</span>
					 			<span class="one_msg_data_1" >平台直客免费抢</span>
					 			<span class="one_msg_data_2" id="robNums">60次</span>
					 		</li>
					 		<li class="one_msg_data">
					 			<span>·</span>
					 			<span class="one_msg_data_1" >房源/小区置顶展位</span>
					 			<span class="one_msg_data_2" >半价入驻</span>
					 		</li>
					 		<li class="one_msg_data">
					 			<span>·</span>
					 			<span class="one_msg_data_1" >历史业主数据</span>
					 			<span class="one_msg_data_2" >30条/天</span>
					 		</li>
					 		<li class="one_msg_data">
					 			<span>·</span>
					 			<span class="one_msg_data_1" >好房豆兑换</span>
					 			<span class="one_msg_data_2" >5折优惠</span>
					 		</li>
					 	</ul>
				</div>
				<div class="r-bot">
					<div class="customer-service">客服帮助</div>
				</div>
			</div>
			<div class="delete" id="closePayPage"></div>
			<div id="alertModel" class="alert-model">
				<div class="alert-content">
					<div class="alert-title">
						<div class="model-delete"></div>
					</div>
					<div class="content">
						<img class="icon" src="${statics}ucenter/common/img/warningMsg.png">
						<div class="info" ></div>
					</div>
					<div class="alert-footer">
						<div class="ok">确定</div>
					</div>
				</div>
			</div>
			<div id="confirmModel" class="alert-model">
				<div class="alert-content">
					<div class="alert-title">
						<div class="model-delete"></div>
					</div>
					<div class="content">
						<img class="icon" src="${statics}ucenter/common/img/warningMsg.png">
						<div class="info" ></div>
					</div>
					<div class="alert-footer">
						<div class="ok">确定</div>
						<div class="cancel">取消</div>
					</div>
				</div>
			</div>
			<div class="qr-code-model" id="aliPayQrCodeModel">
				<div class="inner-qr-box">
					<div class="qr-box-close"></div>
					<div class="qr-box">
						<iframe class="qr-img ali-qr-iframe" scrolling="no" frameborder="0" src="" onload="aliQrIframeOnChange(this);"></iframe>
					</div>
					<div class="pay-info-box">
						<span>支付金额：</span><span class="total-price">0</span><span>元</span>
						<div class="info">支付宝扫码支付</div>
					</div>
				</div>
			</div>
			<div class="qr-code-model" id="weixinPayQrCodeModel">
				<div class="inner-qr-box">
					<div class="qr-box-close"></div>
					<div class="qr-box weixin">
						<div class="qr-img weixin-qr-img"></div>
						<div class="weixin-pay-img">
							<img src="${statics}ucenter/common/img_v2/weixin-pay-icon.png"></img>
						</div>
					</div>
					<div class="pay-info-box">
						<span>支付金额：</span><span class="total-price">0</span><span>元</span>
						<div class="info">微信扫码支付</div>
					</div>
				</div>
			</div>
			<div class="pay-model" id="payModel">
				<div class="pay-content">
					<div class="head">
						<span class="checked type" id="aliPay">支付宝支付</span>　|　
						<span class="type" id="weixinPay">微信支付</span>
					</div>
					<div class="body">
						<div id="payInfoDiv">
							<div class="info">好房通1年VIP服务+720°VR相机</div>
							<div class="need-pay">应付金额：<span class="price" id="noAmountNeedPay">1700</span>元</div>
						</div>
						<div id="resultPayInfoDiv">
							<div class="info">
								<div id="choiseShareMoney1" class="pay-checkbox">使用推广现金抵扣0元</div>
								<div id="choiseBalance1" class="pay-checkbox">使用余额抵扣0元</div>
							</div>
							<div class="need-pay">小计：<span class="price" id="resultNeedPay">¥0</span></div>
						</div>
						<div id="amountPayDiv">
							<div class="sure-pay">确认支付</div>
						</div>
						<div id="aliPayDiv">
							<ul id="huabeiPayUl">
								<!-- <li class="checked">
									<div>
										<span>￥99元</span>×3期
									</div>
									<div>
										(<span>18.00</span>元/期)
									</div>
									<div class="prg-red"></div>
								</li>
								<li>
									<div>
										<span>￥99元</span>×6期
									</div>
									<div>
										(<span>18.00</span>元/期)
									</div>
									<div class="prg-red"></div>
								</li>
								<li>
									<div>
										<span>￥99元</span>×12期
									</div>
									<div>
										(<span>18.00</span>元/期)
									</div>
									<div class="prg-red"></div>
								</li> -->
							</ul>
							<div class="qrcode">
								<div id="huabeirateInfoDiv">
									需支付：<span class="need-pay" id="huabeiNeedPayPrice1">￥0.0</span><br/>
									<span class="info" id="huabeiRatePrice1">
										(含手续费：￥0.0)
									</span>
								</div>
								<iframe class="payQrIframe" id="aliPayIframe" scrolling="no" frameborder="0"></iframe>
							</div>
						</div>
						<div class="wx-img" id="weiXinQRCodeDiv">
							<div id="weiXinQRCodeImg"></div>
							<div>微信扫码轻松支付</div>
						</div>
						<div id="iframeMask"></div>
					</div>
					<div class="footer">
						<div class="web-pay" id="aliWebPay">使用网页支付</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	var erpWebUrl = '${erpWebUrl}';
	var adminWebUrl = '${adminWebUrl}';
	var crmWebUrl = '${crmWebUrl}';
	var archiveIdTmp = '${archiveId}';
	var adminDeptIdTmp = '${adminDeptId}';
	var clientKey = '${clientKey}';
	var statics = '${statics}';
	var cashMoney = '${cashMoney}';
	var shareMoney = '${shareMoney}';
	var buyConfigJson = JSON.parse('${buyConfigJson}');
	var huabeiRepaymentRate = ${huabeiRepaymentRate};
    var isPersonalVersion = '${isPersonalVersion}';
</script>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>
<script src="${statics}ucenter/common/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}common/js/common.js" type="text/javascript"></script>
<script src="${statics}ucenter/vipPay/js/vipPay.js" type="text/javascript"></script>
</html>


