<%@page import="org.myfun7.framerwork.exception.AbstractJthinkException"%>
<%@page import="org.myfun7.db.ExceptionHandler"%>
<%@page language="java" contentType="text/html; charset=utf-8"  isErrorPage="true" %>
<%@page import="org.fto.jthink.exception.*"%>
<%@page import="com.myfun7.util.Myfun7ErrorCode" %>
<%
	String siteRoot = request.getContextPath();
	String message = exception.getMessage();
	String classErrorName = "_errorTmp1";
	String errorCode="0";
	request.setAttribute("Exception", exception);
	if(exception instanceof JThinkException){
		JThinkException e1 = (JThinkException)exception;
		errorCode=String.valueOf(e1.getCode());
	}else if(exception instanceof JThinkRuntimeException){
		JThinkRuntimeException e2 = (JThinkRuntimeException)exception;
		if(e2.getMessage().indexOf("Violation of PRIMARY KEY constraint") != -1
			|| e2.getMessage().indexOf("违反了 PRIMARY KEY 约束") != -1){
			message = "网络忙，请点击 <a href='javascript:window.history.back();' style='color:blue'>返回</a> 前一页，重新保存！";
			classErrorName = "_errorTmp2";
		}else if(e2.getCode() != 0){
			message = "系统错误，请重新登录或联系在线客服！";
		}
	}else if(exception instanceof NullPointerException){
		message = "系统错误，请重新登录或联系在线客服！";
	}else if(exception instanceof ServletException){
		Object object=request.getAttribute("errorCode");
		if(object!=null){
			errorCode=String.valueOf(object);
		}
	}else if(exception instanceof AbstractJthinkException){
		AbstractJthinkException abstractJthinkException=(AbstractJthinkException)exception;
		errorCode=abstractJthinkException.errorCode;
	}
	if(errorCode!=null&&(errorCode.equals(Myfun7ErrorCode.LOGIN_INVALID_SESSION)
			||errorCode.equals(Myfun7ErrorCode.LOGIN_INVALID_RELOGIN_COMMOND))){
		message = "闲置时间过长，系统已中断连接，请重新登录！";
	}else if(errorCode!=null&&!errorCode.equals("0")){
		message = "系统错误，请重新登录或联系在线客服！";
	}
	request.setAttribute("IS_ERROR_PAGE", "YES");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>好房通</title>
    <style type="text/css">
        body {
            padding: 0;margin: 0;text-align: center;
        }
        .divCenter {
            width: 190px; margin-left: auto; margin-right: auto;
        }
        .divCenter .divIcon {
            background-image: url('<%=siteRoot%>/common/image/Icon.png'); background-repeat: no-repeat;
            width: 190px; height: 155px;
        }
        .divCenter .divText {
            font-family: 'Microsoft YaHei';font-size: 14px;color: #000000;
            text-align: center;margin-top: 13px;margin-bottom: 11px;
        }
        .divCenter .btnOk {
            background-image: url('<%=siteRoot%>/common/image/btn.png'); background-repeat: no-repeat;cursor:pointer;
            width: 92px; height: 28px;border:0px;outline:none;background-color:transparent;
            font-family:'Microsoft YaHei';font-size:12px; color:white;
        }
    </style>
    <script type="text/javascript">
        window.onresize = function () {
            document.getElementById('divCenter').style.marginTop = (window.innerHeight / 2) - 149 + "px";
        }
        window.onload = function () {
            window.onresize();
            var errorCode='<%=errorCode%>';
            if(errorCode=="-6"||errorCode=="-20"){
            	if(alertMsg("<%=message.trim()%>")){
                	document.getElementById('CustObj').reLogin();
            	}
            }
        }
        window.alertMsg = function(str,index){
        	try{
        		if(index == undefined){
        			 return document.getElementById("CustObj").openMessageBox(str,3,1);
        		}else{
        			return document.getElementById("CustObj").openMessageBox(str,index,1);
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
        <div class="divText" id="<%=classErrorName%>"><%=message.trim()%></div>
        <input type="button" class="btnOk" onclick="history.back()" value="返回" />
        <object type='application/x-qt-plugin' classid='custObj' id='CustObj' style="height:0px;width:0px;display:block;" ></object>
    </div>
</body>
</html>
