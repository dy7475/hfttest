<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>购买结果</title>
	<link href="${statics}ucenter/deptPay/css/index.css" rel="stylesheet" />
<meta name="content-type" content="text/html; charset=UTF-8">
<style>
body,html {margin:0px;padding:0px;overflow: hidden;}
.divCenter {
	padding-left: 75px;line-height: 70px;height: 70px;vertical-align: middle;
	background-image:url('${statics}/ucenter/common/img/success.png');background-repeat:no-repeat;
}
</style>
</head>
<body scroll="no" oncontextmenu="return false" onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false" onmouseup="return false">
	<div class="con-left l pay-result">
		<div class="success-box">
			<div><img src="${statics}ucenter/common/img_v2/pay-ok.png"/></div>
			<div class="success-text">成功开通新门店</div>
			<div class="dept_success_info"></div>
			<div class="copy_info">
				<button>复制</button>
			</div>
		</div>
		<%--<div class="copy_info"><button>复制</button></div>--%>

		<div class="success-bottom-box">
			<img src="${statics}ucenter/common/img_v2/logo_bottom.png">
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
	<object type='application/x-qt-plugin' classid='custObj' id='mybutton' style="height:0px;width:0px;display:block;" ></object>
</body>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>
<script src="${statics}ucenter/common/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${statics}ucenter/common/js/common.js" type="text/javascript"></script>
<script src="${statics}ucenter/deptPay/js/result.js" type="text/javascript"></script>

<script type="text/javascript">

    var deptName = '${deptName}';
    var deptAddr = '${deptAddr}';
    var deptTele = '${deptTele}';
    var deptContact = '${deptContact}';
    var deptNo = '${deptNo}';
    var pwdDesc = '${pwdDesc}';
</script>
</html>
