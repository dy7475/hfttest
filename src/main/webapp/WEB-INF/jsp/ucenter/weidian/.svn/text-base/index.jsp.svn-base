<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/common/error.jsp"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<title>购买企业微店</title>
<link href="${statics}ucenter/weidian/css/index.css" rel="stylesheet" />
</head>
<body scroll="no" oncontextmenu="return false"
	onselectstart="return false" onselect="document.selection.empty()"
	oncopy="document.selection.empty()" onbeforecopy="return false">
	<div id="app">
		<div class="container">
			<div class="con-left l">
				<div id="topTipInfo">您好，知业教学仅对O2O用户开放，升级为O2O服务后可使用知业教学全部功能</div>
				<div id="year9TipInfo"><div>开通年费会员并于7天内实名认证即获终身VIP</div></div>
				<ul id="priceTypeUl"></ul>
				<div class="vr" id="vrMaskDiv"></div>
				<div class="vr" id="vrInfoDiv">
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
				</div>
				<section class="pay">
					<div class="l pay-l"></div>
					<div class="r pay-r">
						<div class="pay-box2">
							<div class="pay-price-txt">
								<span id="cashCouponInfo"></span><br><span id="balanceInfo"></span>
								<!-- 已使用代金券100元抵扣 --><!-- 已使用余额抵扣300元 -->
							</div>
							<div class="pay-price">
								<span>￥</span> <span id="totalPrice"></span>
							</div>
							<div class="sure-pay" id="sureCreateOrder">支付</div>
							<div id="vipHuiDiv">
								<span id="vipHuiInfo">
									<span>支付成功即送3个月</span>
									<img src="${statics}ucenter/common/img/vip2018.png" style="margin-bottom: -5px;"></img>
								</span>
								<span id="quanGift"></span>
							</div>
							<!-- <p class="quanGift">支付成功即送0优惠券</p> -->
						</div>
					</div>
				</section>
			</div>
			<div class="con-right l">
				<div class="r-top">
					<div id="payForName"></div>
				</div>
				<div class="r-bot">
					<p id="payForUseage"></p>
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
								<div id="choiseBalance" class="checkbox">使用余额抵扣0元</div>
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
									需支付：<span class="need-pay" id="huabeiNeedPayPrice">￥0.0</span><br/>
									<span class="info" id="huabeiRatePrice">
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
	var amount = '${amount}';
    var isPersonalVersion = '${isPersonalVersion}';
</script>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>
<script src="${statics}ucenter/common/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}common/js/common.js" type="text/javascript"></script>
<script src="${statics}ucenter/weidian/js/index.js" type="text/javascript"></script>
</html>

