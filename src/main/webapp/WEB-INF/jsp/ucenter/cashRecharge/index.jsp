<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/common/error.jsp"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<title>现金余额</title>
<link href="${statics}ucenter/cashRecharge/css/index.css" rel="stylesheet" />
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
					<div class="now-balance">当前现金余额：<span id="haofangBeanNow">0</span>元</div>
				</div>
				<div class="success-bottom-box">
					<img src="${statics}ucenter/common/img_v2/logo_bottom.png">
				</div>
			</div>
			<div class="con-left l">
				<div id="topTipInfo">
					<div class="title">您当前现金余额不足，不能点亮真房源！</div>
					<div class="sub">每点亮<span>${lightUpCount}</span>条真房源需缴纳<span>100</span>元保证金（可退）</div>
				</div>
				<table id="priceTypeTable">
					<tr>
						<td>充值金额：</td>
						<td><input type="number" id="priceInput"  placeholder="输入充值金额"/>元</td>
					</tr>
				</table>
				<div class="vr" id="vrMaskDiv"></div>
				<section class="pay">
					<div class="l pay-l">
						<div>支付方式：</div>
						<div class="pay-type-box">
							<div class="item alipay checked" val="1"><div class="gou"></div></div>
							<div class="item weixinpay" val="2"><div class="gou"></div></div>
						</div>
					</div>
					<div class="r pay-r">
						<div class="pay-box2">
							<div class="pay-price-txt">
								<span id="cashCouponInfo"></span> <span id="balanceInfo"></span>
								<!-- 已使用代金券100元抵扣 --><!-- 已使用余额抵扣300元 -->
							</div>
							<div class="price-info">
								<span class="l-text">需支付：</span><span class="price-type">￥</span> <span class="total-price">100</span>
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
							<img src="${statics}ucenter/common/img/weixinPay.png"></img>
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
							<div class="info"></div>
							<div class="need-pay">应付金额：<span class="price" id="noAmountNeedPay">0.0</span>元</div>
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
							<div class="qrcode">
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
	var ptType = '${ptType}';
	var isRechargeComp = '${isRechargeComp}';
	var isFromTrueHouse = '${isFromTrueHouse}';
    var isPersonalVersion = '${isPersonalVersion}';
</script>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>
<script src="${statics}ucenter/common/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}common/js/common.js" type="text/javascript"></script>
<script src="${statics}ucenter/cashRecharge/js/index.js" type="text/javascript"></script>
</html>

