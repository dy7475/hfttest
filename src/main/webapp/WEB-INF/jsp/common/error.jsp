<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String siteRoot = request.getContextPath();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>好房通</title>
	<style type="text/css">
		body {padding: 0;margin: 0;text-align: center;}
		.divCenter {width: 190px; margin-left: auto; margin-right: auto;}
		.divCenter .divIcon {
			background-image: url('<%=siteRoot%>/statics/common/img/Icon.png'); background-repeat: no-repeat;
			width: 190px; height: 155px;
		}
		.divCenter .divText {
			font-family: 'Microsoft YaHei';font-size: 14px;color: #000000;
			text-align: center;margin-top: 13px;margin-bottom: 11px;
		}
		.divCenter .btnOk {
			background-image: url('<%=siteRoot%>/statics/common/img/btn.png'); background-repeat: no-repeat;cursor:pointer;
			width: 92px; height: 28px;border:0px;outline:none;background-color:transparent;
			font-family:'Microsoft YaHei';font-size:12px; color:white;
		}
	</style>
	<script type="text/javascript">
		window.onload = function () {
	        var errorCode= ${isSessionTimeOut};
	        if(errorCode=="1"){
	        	if(alertMsg("你的账号已经在其他地方登录，请注意账号安全！")){
	            	document.getElementById('CCustObj').reLogin();
	        	}
	        }
	    }
        window.alertMsg = function(str,index){
        	try{
        		if(!!!index){
        			 return document.getElementById("CCustObj").openMessageBox(str,3,1);
        		}else{
        			return document.getElementById("CCustObj").openMessageBox(str,index,1);
        		}
        	}catch(e){
        		alert(str);
        	}
        }
    </script>
</head>
<body>
	<div class="divCenter" id="divCenter">
		<div class="divIcon"></div>
		<div class="divText">${errJson.errMsg}</div>
		
		<input type="button" class="btnOk" onclick="history.back()" value="返回" />
		<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
	</div>
</body>
</html>


