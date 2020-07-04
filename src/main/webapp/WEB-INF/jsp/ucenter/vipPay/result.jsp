<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>支付结果</title>
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
	<div class="divCenter">支付完成</div>
</body>
<object type='application/x-qt-plugin' width='0' height='0' classid='custObj' id='custObj'/>
<script type="text/javascript">
if('${superUser}' == '1') {
	//console.log("ok");
	parent.document.getElementById("custObj").setVipFlagTrue();
} else {
	//console.log("faild");
}
</script>
</html>
