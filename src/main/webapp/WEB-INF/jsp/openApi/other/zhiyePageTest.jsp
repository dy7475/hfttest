<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第三方知页模拟页面</title>
</head>
<object type='application/x-qt-plugin' classid='custObj' id='custObj' style="height:0px;width:0px;display:block;" ></object>
<body>
	<input type="button" value="请求" onclick="validateVedio();">
</body>
	<script type="text/javascript">
		function validateVedio(){
			document.getElementById("custObj").validateVedio("1","2","3","4","5");
		}
	</script>
</html>