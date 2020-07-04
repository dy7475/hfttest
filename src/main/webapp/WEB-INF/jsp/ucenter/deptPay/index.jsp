<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="/common/error.jsp"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<title>购买软件</title>
<link href="${statics}ucenter/deptPay/css/index.css" rel="stylesheet" />
</head>
<body scroll="no" oncontextmenu="return false"
	onselectstart="return false" onselect="document.selection.empty()"
	oncopy="document.selection.empty()" onbeforecopy="return false">
	<div id="app">
		<div class="container">
			<div class="con-left l pay-result">
				<div class="success-box">
					<div><img src="${statics}ucenter/common/img_v2/pay-ok.png"/></div>
					<div class="success-text">成功开通新门店</div>
                    <div class="dept_success_info"></div>
					<div class="copy_info">
						<button>复制</button>
					</div>
				</div>
				<div class="success-bottom-box">
					<img src="${statics}ucenter/common/img_v2/logo_bottom.png">
				</div>
			</div>
			<div class="con-left l">
				<div id="topTipInfo">您好，知业教学仅对O2O用户开放，升级为O2O服务后可使用知业教学全部功能</div>
				<div id="year9TipInfo"><div>开通年费会员并于7天内实名认证即获终身VIP</div></div>
				<div id="payInfoBox">
					<div class="pay-text info">
						<div class="text"></div>
						<div class="contract"></div>
					</div>
					<div class="pay-text price">0元<br>

                    </div>
                    <div class="unitPrice">0元</div>
				</div>
				<div class="vr" id="vrMaskDiv"></div>
				<section class="pay">
					<div class="l pay-l">
						<div>支付方式：</div>
						<div class="pay-type-box">
							<div id="balanceInfoDiv">
								<div id="choiseShareMoney" class="pay-checkbox">
									<img src="${statics}ucenter/common/img_v2/extend-cash.png">
									<span class="info">余额抵扣<span id="sharePayTotal">0</span>元</span>
								</div>
								<div id="choiseBalance" class="pay-checkbox">
									<img src="${statics}ucenter/common/img_v2/cash-money.png">
									<span class="info">余额抵扣<span id="amountPayTotal">0</span>元</span>
								</div>
							</div>
							<div id="payTypeDiv">
								<div class="item alipay checked" val="1"><div class="gou"></div></div>
								<div class="item weixinpay" val="2"><div class="gou"></div></div>
							</div>
						</div>
						<div class="huabeiPayNewUl">
							<ul id="huabeiPayNewUl">
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
								<span class="l-text">需支付：</span><span class="price-type">￥</span> <span class="total-price">100</span>
							</div>
							<div class="sure-pay-box">
								<div class="sure-pay visible" id="sureCreateOrder">扫码支付</div>
                                <div class="web-pay use-web-pay">
                                    <a >使用网页支付</a>
                                </div>
							</div>
							<%--<div class="use-web-pay">
								<a >使用网页支付</a>
							</div>--%>
                            <div class="other-pay">
                                <span>他人代付</span>
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
	var cashMoney = '${cashMoney}';
	var shareMoney = '${shareMoney}';
	var contractIdTmp = '${contractId}';
	var deptFlagTmp = '${deptFlag}';
	var deptTypeTmp = '${deptType}';
	var bindOpenWeixin = '${bindOpenWeixin}';
	var weiContractNo = '${weiContractNo}';
	var contractHtml = '${contractHtml}';
	var weiContractHtml = '${weiContractHtml}';
	var totalPrice = '${totalPrice}';
	var weiTotalPrice = '${weiTotalPrice}';
	var contractNo = '${contractNo}';
	var contractHtml = '${contractHtml}';
	var totalAmount = '${totalAmount}';
	var softContractError = '${softContractError}';
	var huabeiRepaymentRate = ${huabeiRepaymentRate};
    var isPersonalVersion = '${isPersonalVersion}';
    var deptName = '${deptName}';
    var deptAddr = '${deptAddr}';
    var deptTele = '${deptTele}';
    var deptContact = '${deptContact}';
    var unitPrice = '${unitPrice}';
    var deptNo = '${deptNo}';
    var pwdDesc = '${pwdDesc}';
</script>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>

<script src="${statics}ucenter/common/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}common/js/common.js" type="text/javascript"></script>
<script src="${statics}ucenter/deptPay/js/deptPay.js" type="text/javascript"></script>
</html>


